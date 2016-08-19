/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd8100201;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.HikazeiNennkinTaishouSyaJohoListCsvOutEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd8100201.HikazeiNennkinTaishouSyaJohoListCsvResultEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
 * 非課税年金対象者情報一覧CSV作成_process処理クラスです.
 *
 * @reamsid_L DBD-4910-030 x_lilh
 */
public class HikazeiNennkinTaishouSyaJohoCsvCreateProcess extends BatchProcessBase<HikazeiNennkinTaishouSyaJohoListCsvResultEntity> {

    private static final RString MAPPERPATH = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "hikazeinennkintaishousyajohotorikomi.IHikazeiNennkinTaishouSyaJohoCsvMapper.get非課税年金対象者情報一覧CSV用のデータ情報");

    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId(new RString("DBD900001"));
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private FileSpoolManager manager;
    private RString spoolFilePath;
    int 連番 = 0;

    @BatchWriter
    private CsvWriter<HikazeiNennkinTaishouSyaJohoListCsvOutEntity> csvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MAPPERPATH);
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        spoolFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HikazeiNenkinTaishoshaJohoIchiran.csv"));
        csvWriter = new CsvWriter.InstanceBuilder(spoolFilePath)
                .alwaysWriteHeader(HikazeiNennkinTaishouSyaJohoListCsvOutEntity.class)
                .setEncode(Encode.UTF_8withBOM)
                .setDelimiter(EUC_WRITER_DELIMITER)
                .setEnclosure(EUC_WRITER_ENCLOSURE)
                .setNewLine(NewLine.CRLF)
                .hasHeader(true)
                .build();
    }

    @Override
    protected void process(HikazeiNennkinTaishouSyaJohoListCsvResultEntity t) {
        HikazeiNennkinTaishouSyaJohoListCsvOutEntity eucCsvEntity = new HikazeiNennkinTaishouSyaJohoListCsvOutEntity();
        setEucCsvEntity(eucCsvEntity, t);
        csvWriter.writeLine(eucCsvEntity);
        連番++;
    }

    @Override
    protected void afterExecute() {
        csvWriter.close();
    }

    private void setEucCsvEntity(HikazeiNennkinTaishouSyaJohoListCsvOutEntity eucCsvEntity,
            HikazeiNennkinTaishouSyaJohoListCsvResultEntity t) {
        eucCsvEntity.set市町村コード(t.getDT市町村コード());
        eucCsvEntity.set年金保険者コード(t.getDT年金保険者コード());
        eucCsvEntity.set通知内容コード(t.getDT通知内容コード());
        eucCsvEntity.set予備１(t.getDT予備1());
        eucCsvEntity.set制度コード(t.getDT制度コード());
        eucCsvEntity.set作成年月日(t.getDT作成年月日());
        eucCsvEntity.set基礎年金番号(t.getDT基礎年金番号());
        eucCsvEntity.set年金コード(t.getDT年金コード());
        eucCsvEntity.set予備２(t.getDT予備2());
        eucCsvEntity.set生年月日(t.getDT生年月日());
        eucCsvEntity.set性別(t.getDT性別());
        eucCsvEntity.setカナ氏名(t.getDTカナ氏名());
        eucCsvEntity.set漢字氏名(t.getDT漢字氏名());
        eucCsvEntity.set郵便番号(t.getDT郵便番号());
        eucCsvEntity.setカナ住所(t.getDTカナ住所());
        eucCsvEntity.set漢字住所(t.getDT漢字住所());
        eucCsvEntity.set対象年(t.getDT対象年());
        eucCsvEntity.set訂正表示(t.getDT訂正表示());
        eucCsvEntity.set各種区分(t.getDT各種区分());
        eucCsvEntity.set処理結果(t.getDT処理結果());
        eucCsvEntity.set予備３(t.getDT予備3());
        eucCsvEntity.set予備４(t.getDT予備4());
        eucCsvEntity.set金額１(new RString(t.getDT金額1().toString()));
        eucCsvEntity.set金額予備１(new RString(t.getDT金額予備1().toString()));
        eucCsvEntity.set金額予備２(new RString(t.getDT金額予備2().toString()));
        eucCsvEntity.set予備５(t.getDT予備5());
        eucCsvEntity.set共済年金証書記号番号(t.getDT共済年金証書記号番号());
    }
}
