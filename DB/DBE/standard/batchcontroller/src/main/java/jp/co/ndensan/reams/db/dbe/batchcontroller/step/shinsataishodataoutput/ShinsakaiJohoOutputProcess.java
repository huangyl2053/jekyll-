/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shinsataishodataoutput;

import jp.co.ndensan.reams.db.dbe.business.core.shinsataishodataoutput.ShinsaTaishoDataOutPutResult;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shinsataishodataoutput.ShinsaTaishoDataOutPutProcessParammeter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiJohoEucCsvEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.ShinsakaiJohoRelateEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 * 介護認定審査会情報のCSV出力処理クラスです。
 */
public class ShinsakaiJohoOutputProcess extends BatchProcessBase<ShinsakaiJohoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinsataishodataoutput.IShinsaTaishoDataOutPutMapper."
            + "get介護認定審査会情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE518001");
    private static final RString FILE_NAME = new RString("審査会情報.csv");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private ShinsaTaishoDataOutPutProcessParammeter processParamter;
    private RString eucFilePath;
    private FileSpoolManager manager;
    @BatchWriter
    private CsvWriter<ShinsakaiJohoEucCsvEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShinsaTaishoDataOutMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), FILE_NAME);
        eucCsvWriter = new CsvWriter.InstanceBuilder(eucFilePath).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.SJIS).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process(ShinsakaiJohoRelateEntity entity) {
        eucCsvWriter.writeLine(createCsvEntity(entity));
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        outputJokenhyoFactory();
    }

    private ShinsakaiJohoEucCsvEntity createCsvEntity(ShinsakaiJohoRelateEntity entity) {
        ShinsakaiJohoEucCsvEntity csvEntity = new ShinsakaiJohoEucCsvEntity();

        csvEntity.set介護認定審査会開催番号(entity.get介護認定審査会開催番号());
        csvEntity.set介護認定審査会開催年月日(entity.get介護認定審査会開催年月日());
        csvEntity.set介護認定審査会開始時刻(entity.get介護認定審査会開始時刻());
        csvEntity.set介護認定審査会終了時刻(entity.get介護認定審査会終了時刻());
        csvEntity.set合議体番号(entity.get合議体番号());

        return csvEntity;
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                FILE_NAME,
                EUC_ENTITY_ID.toRString(),
                new ShinsaTaishoDataOutPutResult().get出力件数(new Decimal(eucCsvWriter.getCount())),
                new ShinsaTaishoDataOutPutResult().get出力条件(processParamter));
        OutputJokenhyoFactory.createInstance(item).print();
    }
}
