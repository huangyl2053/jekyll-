/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteisumidataif;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteisumidataif.IchijiHanteiSumiDataIFEditor;
import jp.co.ndensan.reams.db.dbe.definition.core.util.accesslog.ExpandedInformations;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataEucEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataIDataShutsuryokuRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 書込みに用いるentityの値により、書き込むCSVファイルを制御します。 また、CSVファイルのスプールを行います。アクセスログの記録も内部で行います。
 */
final class CsvWritersByFileName {

    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private static final RString SJIS = new RString("1");
    private static final RString UTF_8_WITH_BOM = new RString("2");

    private final FileSpoolManager fsManager;
    private final Map<RString, CsvWriter<IchijihanteiSumidataEucEntity>> csvWriters;
    private final Map<RString, DbAccessLogger> accessLoggers;
    private final Encode encode;
    private final IchijiHanteiSumiDataIFEditor editor;

    /**
     * @param fsManager CSVファイルのスプールに用いる{@link FileSpoolManager}
     * @param operationDate 処理日付
     */
    CsvWritersByFileName(FileSpoolManager fsManager, RDate operationDate) {
        this.fsManager = fsManager;
        this.csvWriters = new HashMap<>();
        this.accessLoggers = new HashMap<>();
        this.encode = getEncode(operationDate);
        this.editor = new IchijiHanteiSumiDataIFEditor(operationDate);
    }

    private static Encode getEncode(RDate operationDate) {
        RString code = DbBusinessConfig.get(ConfigNameDBE.一次判定IF文字コード, operationDate);
        if (SJIS.equals(code)) {
            return Encode.SJIS;
        } else if (UTF_8_WITH_BOM.equals(code)) {
            return Encode.UTF_8withBOM;
        }
        return Encode.SJIS;
    }

    private CsvWriter<IchijihanteiSumidataEucEntity> csvWriter(RString fileName) {
        if (!this.csvWriters.containsKey(fileName)) {
            this.csvWriters.put(
                    fileName,
                    newCsvWrtier(this.fsManager.getEucOutputDirectry(), fileName, this.encode)
            );
        }
        return this.csvWriters.get(fileName);
    }

    private static CsvWriter<IchijihanteiSumidataEucEntity> newCsvWrtier(
            RString directoryPath,
            RString fileName,
            Encode encode
    ) {
        return new CsvWriter.InstanceBuilder(Path.combinePath(directoryPath, fileName))
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setEncode(encode)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    /**
     * 対応するCSVファイルに対して、一行を出力します。
     *
     * @param entity {@link IchijihanteiSumidataIDataShutsuryokuRelateEntity}
     */
    void writeLine(IchijihanteiSumidataIDataShutsuryokuRelateEntity entity) {
        IchijiHanteiSumiDataIFEditor.IResult result = editor.edit(entity);
        if (!result.exists()) {
            return;
        }
        RString fileName = result.getFileName();
        this.csvWriter(fileName).writeLine(result.createCsvEntity());
        this.accessLogger(fileName).store(new ShoKisaiHokenshaNo(entity.get保険者番号()), entity.get被保険者番号(),
                ExpandedInformations.fromShinseishoKanriNo(new ShinseishoKanriNo(entity.get申請書管理番号()))
        );
    }

    private DbAccessLogger accessLogger(RString fileName) {
        if (!this.accessLoggers.containsKey(fileName)) {
            this.accessLoggers.put(fileName, new DbAccessLogger());
        }
        return this.accessLoggers.get(fileName);
    }

    /**
     * CSVファイルをスプールします。
     */
    void spool() {
        for (RString fileName : this.csvWriters.keySet()) {
            this.fsManager.spool(fileName, this.accessLoggers.get(fileName).flushByEUC(UzUDE0835SpoolOutputType.EucOther));
        }
    }

    Iterable<OutputingInfo> outputingInfos() {
        List<OutputingInfo> list = new ArrayList<>();
        for (Map.Entry<RString, CsvWriter<IchijihanteiSumidataEucEntity>> csvWriter : this.csvWriters.entrySet()) {
            list.add(new OutputingInfo(csvWriter.getKey(), csvWriter.getValue().getCount()));
        }
        return list;
    }

    @lombok.Getter
    static final class OutputingInfo {

        private final RString fileName;
        private final Decimal count;

        private OutputingInfo(RString fileName, long count) {
            this.fileName = fileName;
            this.count = new Decimal(count);
        }
    }
}
