/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.ninteichosadataoutput;

import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput.NinteiChosaDataOutputResult;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ninteichosadataoutput.NinteiChosaDataOutputProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputBatchRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ninteichosadataoutput.NinteiChosaDataOutputEucCsvEntity;
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
import jp.co.ndensan.reams.uz.uza.euc.io.EucCsvWriter;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;

/**
 *
 * 認定調査データ出力（モバイル）CSV出力処理クラスです。
 *
 * @reamsid_L DBE-1860-011 duanzhanli
 */
public class NinteiChosaDataOutputProcess extends BatchProcessBase<NinteiChosaDataOutputBatchRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.ninteichosadataoutput.INinteiChosaDataOutputMapper."
            + "get認定調査データ出力");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBE224001");
    private static final RString EUC_WRITER_DELIMITER = new RString(",");
    private static final RString EUC_WRITER_ENCLOSURE = new RString("\"");
    private NinteiChosaDataOutputProcessParamter processParamter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    @BatchWriter
    private EucCsvWriter<NinteiChosaDataOutputEucCsvEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("ChosaKekkaNyuryokuMobile.csv"));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toNinteiChosaDataOutputBatchMybitisParameter());
    }

    @Override
    protected void createWriter() {
        eucCsvWriter = new EucCsvWriter.InstanceBuilder(eucFilePath, EUC_ENTITY_ID).
                setDelimiter(EUC_WRITER_DELIMITER).
                setEnclosure(EUC_WRITER_ENCLOSURE).
                setEncode(Encode.SJIS).
                setNewLine(NewLine.CRLF).
                hasHeader(false).
                build();
    }

    @Override
    protected void process(NinteiChosaDataOutputBatchRelateEntity entity) {
        eucCsvWriter.writeLine(new NinteiChosaDataOutputResult().setEucCsvEntity(entity));
        new NinteiChosaDataOutputResult().getアクセスログ(entity.get申請書管理番号());
    }

    @Override
    protected void afterExecute() {
        eucCsvWriter.close();
        manager.spool(eucFilePath);
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("認定調査データ出力（モバイル）.csv"),
                new RString("ChosaKekkaNyuryokuMobile.csv"),
                new NinteiChosaDataOutputResult().get出力件数(new Decimal(eucCsvWriter.getCount())),
                new NinteiChosaDataOutputResult().get出力条件(processParamter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

}
