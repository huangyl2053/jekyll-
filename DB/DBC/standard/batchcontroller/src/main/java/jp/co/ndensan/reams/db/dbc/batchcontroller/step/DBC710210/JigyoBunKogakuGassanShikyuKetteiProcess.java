/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710210;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKettei;
import jp.co.ndensan.reams.db.dbc.definition.processprm.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKetteiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.jigyobunkogakugassanshikyukettei.JigyoBunKogakuGassanShikyuKetteiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.jigyobunkogakugassanshikyukettei.IJigyoBunKogakuGassanShikyuKetteiEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.koza.IKoza;
import jp.co.ndensan.reams.ua.uax.business.core.koza.Koza;
import jp.co.ndensan.reams.ua.uax.entity.db.relate.TokuteiKozaRelateEntity;
import jp.co.ndensan.reams.ua.uax.service.core.maskedkoza.MaskedKozaCreator;
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
 * 汎用リスト_事業分高額合算支給決定情報のProcessクラスです。
 *
 * @reamsid_L DBC-5060-030 duanzhanli
 */
public class JigyoBunKogakuGassanShikyuKetteiProcess extends BatchProcessBase<JigyoBunKogakuGassanShikyuKetteiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "jigyobunkogakugassanshikyukettei.IJigyoBunKogakuGassanShikyuKetteiMapper.get事業高額合算情報");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701021");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private int 連番 = 1;
    private static final int NUM5 = 5;
    private JigyoBunKogakuGassanShikyuKetteiProcessParameter processParameter;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString 市町村名;
    private Map<RString, KoseiShichosonMaster> 市町村名MasterMap;
    private JigyoBunKogakuGassanShikyuKettei business;
    private Association association;
    private boolean flag;
    @BatchWriter
    private CsvWriter<IJigyoBunKogakuGassanShikyuKetteiEUCEntity> eucCsvWriter;

    @Override
    protected void initialize() {
        flag = false;
        association = AssociationFinderFactory.createInstance().getAssociation();
        business = new JigyoBunKogakuGassanShikyuKettei(processParameter);
        get市町村名();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, business.createMybatisParameter(get出力順()));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HanyoList_JigyoBunKogakuGassanShikyuKettei.csv"));
        eucCsvWriter = BatchWriters.csvWriter(IJigyoBunKogakuGassanShikyuKetteiEUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(processParameter.is項目名付加())
                .build();
    }

    @Override
    protected void process(JigyoBunKogakuGassanShikyuKetteiRelateEntity entity) {
        flag = true;
        TokuteiKozaRelateEntity 口座Entity = entity.get口座Entity();
        IKoza iKoza = null;
        if (口座Entity != null && 口座Entity.getUaT0310KozaEntity().getKozaId() != 0L) {
            MaskedKozaCreator maskedKozaCreator = MaskedKozaCreator.createInstance(SubGyomuCode.DBC介護給付);
            iKoza = maskedKozaCreator.createマスク編集済口座(new Koza(口座Entity));
        }
        if (processParameter.is連番付加()) {
            eucCsvWriter.writeLine(business.set連番ありEUCEntity(entity, iKoza, 市町村名MasterMap, association, 連番++));
        } else {
            eucCsvWriter.writeLine(business.set連番なしEUCEntity(entity, iKoza, 市町村名MasterMap, association));
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
                new RString("汎用リスト　事業分高額合算支給決定情報CSV"),
                new RString("HanyoList_JigyoBunKogakuGassanShikyuKettei.csv"),
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
        RString 保険者コード = processParameter.get保険者コード();
        if (new RString("000000").equals(保険者コード)) {
            市町村名 = new RString("全市町村");
        } else if (!RString.isNullOrEmpty(保険者コード)) {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            Association 市町村 = finder.getAssociation(new LasdecCode(保険者コード));
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

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701021.getReportId(), processParameter.get出力順ID());
        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = ReportUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(
                    JigyoBunKogakuGassanShikyuKettei.ShutsuryokujunEnum.class, outputOrder), NUM5);
        }
        return 出力順;
    }
}
