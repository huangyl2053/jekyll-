/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710180;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.business.core.hanyolistsogojigyohi.HanyoListSogoJigyoHi;
import jp.co.ndensan.reams.db.dbc.definition.processprm.hanyolistsogojigyohi.HanyoListSogoJigyoHiProcessParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.hanyolistsogojigyohi.HanyoListSogoJigyoHiRelateEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonManejimentoReibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonMeisaiReibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonReibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonShukeiReibanAriEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.IHanyoListSogoJigyoHiEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
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
 * 汎用リスト出力(総合事業費情報)_連番ありのProcessクラスです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
public class HanyoListSogoJigyoHiRenbanAriProcess extends BatchProcessBase<HanyoListSogoJigyoHiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistsogojigyo.IHanyoListSogoJigyoReibanMapper.get総合事業費");
    private static final EucEntityId EUC_ENTITY_ID = new EucEntityId("DBC701018");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 基本情報 = new RString("基本情報のみ");
    private static final RString 基本明細情報 = new RString("基本情報＋明細情報");
    private static final RString 基本集計情報 = new RString("基本情報＋集計情報");
    private static final RString 基本ケアマネジメント情報 = new RString("基本情報＋ケアマネジメント費情報");
    private static final RString 被保険者番号 = new RString("0104");
    private static final RString サービス年月 = new RString("0301");
    private static final RString 整理番号 = new RString("0305");
    private static final RString HIHOKENSHANO = new RString(",\"hihokenshaNo\"");
    private static final RString SERVICEYM = new RString(",\"serviceYM\"");
    private static final RString SEIRINO = new RString(",\"seiriNo\"");
    private int 連番 = 1;
    private static final int NUM5 = 5;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private RString 市町村名;
    private RString サービス種類コード名称;
    private RString 事業所名;
    private Map<RString, KoseiShichosonMaster> 市町村名MasterMap;
    private HanyoListSogoJigyoHiProcessParameter processParameter;
    private HanyoListSogoJigyoHi hanyolistsogojigyohi;
    private Association association;
    private boolean flag;

    @Override
    protected void initialize() {
        flag = false;
        hanyolistsogojigyohi = new HanyoListSogoJigyoHi(processParameter);
        association = AssociationFinderFactory.createInstance().getAssociation();
        get市町村名();
    }

    @BatchWriter
    private CsvWriter<IHanyoListSogoJigyoHiEUCEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, hanyolistsogojigyohi.createMybatisParameter(get出力順()));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, EUC_ENTITY_ID, UzUDE0831EucAccesslogFileType.Csv);
        eucFilePath = Path.combinePath(manager.getEucOutputDirectry(), new RString("HanyoList_SogoJigyoHi.csv"));
        eucCsvWriter = BatchWriters.csvWriter(IHanyoListSogoJigyoHiEUCEntity.class)
                .filePath(eucFilePath)
                .setDelimiter(コンマ)
                .setEnclosure(ダブル引用符)
                .setEncode(Encode.UTF_8withBOM)
                .setNewLine(NewLine.CRLF)
                .hasHeader(processParameter.is項目名付加())
                .build();
    }

    @Override
    protected void process(HanyoListSogoJigyoHiRelateEntity entity) {
        flag = true;
        if (基本情報.equals(processParameter.get抽出方法())) {
            eucCsvWriter.writeLine(hanyolistsogojigyohi.set連番基本ありEUCEntity(entity, 市町村名MasterMap, association, 連番++));
        } else if (基本明細情報.equals(processParameter.get抽出方法())) {
            eucCsvWriter.writeLine(hanyolistsogojigyohi.set連番基本明細ありEUCEntity(entity, 市町村名MasterMap, association, 連番++));
            サービス種類コード名称 = entity.get明細サービス種類名称();
        } else if (基本集計情報.equals(processParameter.get抽出方法())) {
            eucCsvWriter.writeLine(hanyolistsogojigyohi.set連番基本集計ありEUCEntity(entity, 市町村名MasterMap, association, 連番++));
            サービス種類コード名称 = entity.get集計サービス種類名称();
        } else if (基本ケアマネジメント情報.equals(processParameter.get抽出方法())) {
            eucCsvWriter.writeLine(hanyolistsogojigyohi.set連番基本マネジありEUCEntity(entity, 市町村名MasterMap, association, 連番++));
            サービス種類コード名称 = entity.getケアマネジメント費サービス種類名称();
        }
        事業所名 = entity.get事業者名称();
    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            if (基本情報.equals(processParameter.get抽出方法())) {
                eucCsvWriter.writeLine(new HanyoListSogoJigyoHiKiHonReibanAriEUCEntity());
            } else if (基本明細情報.equals(processParameter.get抽出方法())) {
                eucCsvWriter.writeLine(new HanyoListSogoJigyoHiKiHonMeisaiReibanAriEUCEntity());
            } else if (基本集計情報.equals(processParameter.get抽出方法())) {
                eucCsvWriter.writeLine(new HanyoListSogoJigyoHiKiHonShukeiReibanAriEUCEntity());
            } else if (基本ケアマネジメント情報.equals(processParameter.get抽出方法())) {
                eucCsvWriter.writeLine(new HanyoListSogoJigyoHiKiHonManejimentoReibanAriEUCEntity());
            }
        }
        eucCsvWriter.close();
        manager.spool(eucFilePath, hanyolistsogojigyohi.getアクセスログ());
        outputJokenhyoFactory();
    }

    private void get市町村名() {
        RString 保険者コード = processParameter.get保険者コード();
        if (new RString("000000").equals(保険者コード)) {
            市町村名 = new RString("全市町村");
        } else if (!RString.isNullOrEmpty(保険者コード)) {
            IAssociationFinder finder = AssociationFinderFactory.createInstance();
            association = finder.getAssociation(new LasdecCode(保険者コード));
            市町村名 = association.get市町村名();
        } else {
            市町村名 = RString.EMPTY;
        }
        市町村名MasterMap = new HashMap<>();
        List<KoseiShichosonMaster> 市町村名Master = KoseiShichosonJohoFinder.createInstance().get現市町村情報();
        for (KoseiShichosonMaster koseiShichosonMaster : 市町村名Master) {
            市町村名MasterMap.put(koseiShichosonMaster.get市町村コード().value(), koseiShichosonMaster);
        }
    }

    private void outputJokenhyoFactory() {
        association = AssociationFinderFactory.createInstance().getAssociation();
        EucFileOutputJokenhyoItem item = new EucFileOutputJokenhyoItem(
                new RString("汎用リスト　総合事業費情報CSV"),
                association.getLasdecCode_().value(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                new RString("HanyoList_SogoJigyoHi.csv"),
                EUC_ENTITY_ID.toRString(),
                get出力件数(new Decimal(eucCsvWriter.getCount())),
                hanyolistsogojigyohi.set出力条件(市町村名, サービス種類コード名称, 事業所名));
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

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = finder.get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701018.getReportId(), processParameter.get出力順ID());
        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(
                    HanyoListSogoJigyoHi.ShutsuryokujunEnum.class, outputOrder), NUM5);
            for (ISetSortItem item : outputOrder.get設定項目リスト()) {
                return set出力順(item, 出力順);
            }
        }
        return 出力順;
    }

    private RString set出力順(ISetSortItem item, RString 出力順) {
        if (被保険者番号.equals(item.get項目ID())) {
            return set被保険者番号ARi(item, 出力順);
        } else {
            return set被保険者番号NaShi(item, 出力順);
        }
    }

    private RString set被保険者番号ARi(ISetSortItem item, RString 出力順) {
        if (サービス年月.equals(item.get項目ID())) {
            if (整理番号.equals(item.get項目ID())) {
                return 出力順;
            } else {
                return 出力順.concat(SEIRINO);
            }
        } else {
            if (整理番号.equals(item.get項目ID())) {
                return 出力順.concat(SERVICEYM);
            } else {
                return 出力順.concat(SERVICEYM).concat(SEIRINO);
            }
        }
    }

    private RString set被保険者番号NaShi(ISetSortItem item, RString 出力順) {
        if (サービス年月.equals(item.get項目ID())) {
            if (整理番号.equals(item.get項目ID())) {
                return 出力順.concat(HIHOKENSHANO);
            } else {
                return 出力順.concat(HIHOKENSHANO).concat(SEIRINO);
            }
        } else {
            if (整理番号.equals(item.get項目ID())) {
                return 出力順.concat(HIHOKENSHANO).concat(SERVICEYM);
            } else {
                return 出力順.concat(HIHOKENSHANO).concat(SERVICEYM).concat(SEIRINO);
            }
        }
    }
}
