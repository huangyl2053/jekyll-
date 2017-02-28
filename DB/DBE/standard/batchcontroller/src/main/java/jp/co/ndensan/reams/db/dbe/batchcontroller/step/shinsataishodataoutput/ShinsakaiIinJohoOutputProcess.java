/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiIinJohoEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiIinJohoRelateEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.euc.api.EucOtherInfo;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 介護認定審査会委員情報のCSV出力処理クラスです。
 */
public class ShinsakaiIinJohoOutputProcess extends BatchProcessBase<ShinsakaiIinJohoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput.IShinsaTaishoDataOutPutMapper."
            + "get介護認定審査会委員情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE518002");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private ShinsaTaishoDataOutPutProcessParammeter processParamter;
    private RString eucFilePath;
    @BatchWriter
    private CsvWriter<ShinsakaiIinJohoEucCsvEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        eucFilePath = Path.combinePath(processParamter.getTempPath(), EucOtherInfo.getDisplayName(SubGyomuCode.DBE認定支援, EUC_ENTITY_ID.toRString()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShinsaTaishoDataOutMybatisParameter());
    }

    @Override
    protected void createWriter() {
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.UTF_8withBOM).
                setNewLine(NewLine.CRLF).
                hasHeader(true).
                build();
    }

    @Override
    protected void process(ShinsakaiIinJohoRelateEntity entity) {
        eucCsvWriter.writeLine(createCsvEntity(entity));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
    }

    private ShinsakaiIinJohoEucCsvEntity createCsvEntity(ShinsakaiIinJohoRelateEntity entity) {
        ShinsakaiIinJohoEucCsvEntity csvEntity = new ShinsakaiIinJohoEucCsvEntity();

        csvEntity.set介護認定審査会開催番号(entity.get介護認定審査会開催番号());
        csvEntity.set介護認定審査会委員コード(entity.get介護認定審査会委員コード());
        csvEntity.set介護認定審査会委員氏名(entity.get介護認定審査会委員氏名());
        csvEntity.set介護認定審査会委員長区分コード(entity.get介護認定審査会議長区分コード());
        csvEntity.set委員出席(entity.is委員出席());
        csvEntity.set介護認定審査員資格(entity.get介護認定審査員資格());
        csvEntity.set委員出席時間(entity.get委員出席時間());
        csvEntity.set委員退席時間(entity.get委員退席時間());
        csvEntity.set委員遅刻有無(entity.is委員遅刻有無());
        csvEntity.set委員早退有無(entity.is委員早退有無());

        return csvEntity;
    }
}
