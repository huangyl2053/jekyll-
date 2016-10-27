/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710040;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaResult;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistkokuhorenjukyusha.HanyoListKokuhorenJukyushaRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistkokuhorenjukyusha.IHanyoListKokuhorenJukyushaEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.association.IAssociationFinder;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
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
 * 汎用リスト 国保連受給者情報Process
 *
 * @reamsid_L DBC-3104-020 yaodongsheng
 */
public class HanyoListKokuhorenJukyushaProcess extends BatchProcessBase<HanyoListKokuhorenJukyushaRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistkokuhorenjukyusha.IHanyoListKokuhorenJukyushaMapper.get国保連受給者情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701004");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final int NUM5 = 5;
    private static final RString 全市町村NAME = new RString("全市町村");
    private static final RString 全市町村CODE = new RString("000000");
    private static final RString FILENAMEKANJI = new RString("汎用リスト　国保連受給者情報CSV");
    private static final RString FILENAME = new RString("HanyoList_KokuhorenJukyusha.csv");
    private int 連番 = 1;
    private HanyoListKokuhorenJukyushaProcessParameter processParameter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString 市町村名;
    private Map<RString, KoseiShichosonMaster> 市町村名MasterMap;
    private HanyoListKokuhorenJukyushaResult business;
    private boolean flag;
    private Association association;
    @BatchWriter
    private CsvWriter<IHanyoListKokuhorenJukyushaEUCEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        flag = false;
        business = new HanyoListKokuhorenJukyushaResult(processParameter);
        association = AssociationFinderFactory.createInstance().getAssociation();
        get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, business.createMybatisParameter(get出力順()));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HanyoList_KokuhorenJukyusha.csv"));
        eucCsvWriter = BatchWriters.csvWriter(IHanyoListKokuhorenJukyushaEUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(processParameter.is項目名付加())
                .build();
    }

    @Override
    protected void process(HanyoListKokuhorenJukyushaRelateEntity entity) {
        flag = true;
        if (processParameter.is連番付加()) {
            eucCsvWriter.writeLine(business.set連番ありEUCEntity(entity, 市町村名MasterMap, association, 連番++));
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
        }
        eucCsvWriter.close();
        if (!flag) {
            manager.spool(eucFilePath);
        } else {
            manager.spool(eucFilePath, business.getアクセスログ());
        }
        outputJokenhyoFactory();
    }

    private void outputJokenhyoFactory() {
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                FILENAMEKANJI,
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                FILENAME,
                EUC_ENTITY_ID.toRString(),
                get出力件数(new Decimal(eucCsvWriter.getCount())),
                business.set出力条件());
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private RString get出力件数(Decimal 出力件数) {
        if (!flag) {
            return new RString("0");
        }
        RStringBuilder builder = new RStringBuilder();
        builder.append(DecimalFormatter.toコンマ区切りRString(出力件数, 0));
        return builder.toRString();
    }

    private void get市町村名() {
        RString 保険者コード = processParameter.get保険者コード();
        if (全市町村CODE.equals(保険者コード)) {
            市町村名 = 全市町村NAME;
        } else if (!RString.isNullOrEmpty(保険者コード)) {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            市町村名 = finder.getAssociation(new LasdecCode(保険者コード)).get市町村名();
        } else {
            市町村名 = RString.EMPTY;
        }
        市町村名MasterMap = new HashMap<>();
        List<KoseiShichosonMaster> 市町村名Master = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        for (KoseiShichosonMaster koseiShichosonMaster : 市町村名Master) {
            市町村名MasterMap.put(koseiShichosonMaster.get市町村コード().value(), koseiShichosonMaster);
        }
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701004.getReportId(), processParameter.get出力順ID());
        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(
                    HanyoListKokuhorenJukyushaResult.ShutsuryokujunEnum.class, outputOrder), NUM5);
        }
        return 出力順;
    }

}
