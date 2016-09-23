/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD710100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.business.core.hikazeinenkintaishosha.HikazeiNenkinTaishosha;
import jp.co.ndensan.reams.db.dbd.definition.processprm.hikazeinenkintaishosha.HikazeiNenkinTaishoshaProcessParameter;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.hanyolisthikazeinenkintaishosha.HikazeiNenkinTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.entity.euc.hikazeinenkintaishosha.IHikazeiNenkinTaishoshaEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.euc.definition.UzUDE0831EucAccesslogFileType;
import jp.co.ndensan.reams.uz.uza.euc.io.EucEntityId;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.spool.FileSpoolManager;
import jp.co.ndensan.reams.uz.uza.spool.entities.UzUDE0835SpoolOutputType;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 汎用リスト出力(非課税年金対象者)のProcessクラスです。
 *
 * @reamsid_L DBD-5820-030 zhengsongling
 */
public class HanyoListHikazeiNenkinTaishoshaProcess extends BatchProcessBase<HikazeiNenkinTaishoshaEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate."
            + "hanyolisthikazeinenkintaishosha.IHanyoListHikazeiNenkinTaishoshaMapper.get汎用リスト");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701014");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private int 連番 = 1;
    private HikazeiNenkinTaishoshaProcessParameter processParameter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString 市町村名;
    private Map<RString, KoseiShichosonMaster> 市町村名MasterMap;
    private Association association;
    private boolean flag;
    private HikazeiNenkinTaishosha business;
    @BatchWriter
    private CsvWriter<IHikazeiNenkinTaishoshaEUCEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        flag = false;
        association = AssociationFinderFactory.createInstance().getAssociation();
        business = new HikazeiNenkinTaishosha(processParameter);
        get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, business.createMybatisParameter());
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HanyoList_HikazeNenkinTaishosha.csv"));
        eucCsvWriter = BatchWriters.csvWriter(IHikazeiNenkinTaishoshaEUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(processParameter.is項目名付加())
                .build();
    }
//TODO 1.6 出力順の補正 実装しない。QA:1750

    @Override
    protected void process(HikazeiNenkinTaishoshaEntity entity) {
        flag = true;
        if (processParameter.is連番付加()) {
            eucCsvWriter.writeLine(business.set連番ありEUCEntity(entity, 連番++, 市町村名MasterMap, association));
        } else {
            eucCsvWriter.writeLine(business.set連番なしEUCEntity(entity, 市町村名MasterMap, association));
        }
    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            if (processParameter.is連番付加()) {
                eucCsvWriter.writeLine(business.set連番ありEUCEntity());
            } else {
                eucCsvWriter.writeLine(business.set連番なしEUCEntity());
            }
            eucCsvWriter.close();
            manager.spool(eucFilePath);
        } else {
            eucCsvWriter.close();
            manager.spool(eucFilePath, business.getアクセスログ());
        }
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                EUC_ENTITY_ID.toRString(),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("汎用リスト　非課税年金対象者CSV"),
                new RString("HanyoList_HikazeNenkinTaishosha.csv"),
                get出力件数(new Decimal(eucCsvWriter.getCount())),
                business.set出力条件(市町村名));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private RString get出力件数(Decimal 出力件数) {
        RString 件数;
        if (flag) {
            RStringBuilder builder = new RStringBuilder();
            builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
            件数 = builder.toRString();
        } else {
            件数 = new RString("0");
        }
        return 件数;
    }

    private void get市町村名() {
        LasdecCode 保険者コード = processParameter.get宛名抽出条件().getShichoson_Code();
        if (new LasdecCode("000000").equals(保険者コード)) {
            市町村名 = new RString("全市町村");
        } else if (保険者コード != null
                && !保険者コード.isEmpty()) {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association 市町村 = finder.getAssociation(保険者コード);
            市町村名 = 市町村.get市町村名();
        } else {
            市町村名 = RString.EMPTY;
        }
        市町村名MasterMap = new HashMap<>();
        List<KoseiShichosonMaster> 市町村名Master = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        for (KoseiShichosonMaster koseiShichosonMaster : 市町村名Master) {
            市町村名MasterMap.put(koseiShichosonMaster.get市町村コード().value(), koseiShichosonMaster);
        }
    }
}
