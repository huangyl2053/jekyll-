/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ichijihanteisumidataif;

import jp.co.ndensan.reams.db.dbe.business.core.ichijihanteisumidataif.IchijiHanteiSumiDataIFEditor;
import jp.co.ndensan.reams.db.dbe.definition.core.util.accesslog.ExpandedInformations;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteisumidataif.IchijihanteiSumidataEucEntity;
import jp.co.ndensan.reams.db.dbz.service.core.DbAccessLogger;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 単一のNCI231.CSVを編集、スプールします。
 */
final class NCI231Writer {

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBE309003"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private final RString fileName;
    private final FileSpoolManager fsManager;
    private final CsvWriter<IchijihanteiSumidataEucEntity> csvWriter;
    private final DbAccessLogger accessLogger;

    NCI231Writer(RString fileName, Encode encode) {
        this.fileName = fileName;
        this.fsManager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        this.csvWriter = newCsvWrtier(this.fsManager.getEucOutputDirectry(), fileName, encode);
        this.accessLogger = new DbAccessLogger();
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
     * @param in {@link IchijiHanteiSumiDataIFEditor.IResult}
     */
    void writeLine(IchijiHanteiSumiDataIFEditor.IResult in) {
        this.csvWriter.writeLine(in.toCsvEntity());
        this.accessLogger.store(in.getShoKisaiHokenshaNo(), in.getHihokenshaNo(),
                ExpandedInformations.fromShinseishoKanriNo(in.getShinseishoKanriNo())
        );
    }

    /**
     * CSVファイルをスプールします。
     */
    void spool() {
        this.fsManager.spool(fileName, this.accessLogger.flushByEUC(UzUDE0835SpoolOutputType.EucOther));
    }

    /**
     * @return 作成中のCSVファイルの情報
     */
    OutputingCsv newOutputingCsv() {
        return new OutputingCsv(EUC_ENTITY_ID, this.fileName, this.csvWriter.getCount());
    }
}
