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
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonManejimentoReibanNashiEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonMeisaiReibanNashiEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonReibanNashiEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.HanyoListSogoJigyoHiKiHonShukeiReibanNashiEUCEntity;
import jp.co.ndensan.reams.db.dbc.entity.euc.hanyolistsogojigyohi.IHanyoListSogoJigyoHiEUCEntity;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbx.service.core.koseishichoson.KoseiShichosonJohoFinder;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoKyotsuManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.batchcontroller.step.writer.BatchWriters;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.EucFileOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
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
 * 汎用リスト出力(総合事業費情報)_基本集計情報のProcessクラスです。
 *
 * @reamsid_L DBC-3107-020 wanghuafeng
 */
public class HanyoListSogoJigyoHiRenbanNashiProcess extends BatchProcessBase<HanyoListSogoJigyoHiRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate."
            + "hanyolistsogojigyo.IHanyoListSogoJigyoReibanMapper.get総合事業費");
    private static final RString コンマ = new RString(",");
    private static final RString ダブル引用符 = new RString("\"");
    private static final RString 基本情報 = new RString("基本情報のみ");
    private static final RString 基本明細情報 = new RString("基本情報＋明細情報");
    private static final RString 基本集計情報 = new RString("基本情報＋集計情報");
    private static final RString 基本ケアマネジメント情報 = new RString("基本情報＋ケアマネジメント費情報");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private static final RString サービス年月 = new RString("サービス年月");
    private static final RString 整理番号 = new RString("整理番号");
    private static final RString サービス種類 = new RString("サービス種類");
    private static final RString サービス項目 = new RString("サービス項目");
    private static final RString サービスコード = new RString("サービスコード");
    private static final RString 給付実績事業者 = new RString("給付実績事業者");
    private static final RString HIHOKENSHANO = new RString(",\"hihokenshaNo\"");
    private static final RString SERVICEYM = new RString(",\"serviceYM\"");
    private static final RString SEIRINO = new RString(",\"seiriNo\"");
    private static final RString SERVICESHURUICODE = new RString(",\"serviceShuruiCode\"");
    private static final RString SERVICEKOMOKU = new RString(",\"serviceKomoku\"");
    private static final RString KETTEISERVICECODE = new RString(",\"ketteiServiceCode\"");
    private static final RString KYUFUJISSEKIJIGYOSHA = new RString(",\"kyufuJissekiJigyosha\"");
    private static final RString CHOHYOID_1 = new RString("DBC701018_HanyoListSogoJigyoHi");
    private static final RString CHOHYOID_2 = new RString("DBC701022_HanyoListSogoJigyoHiMeisai");
    private static final RString CHOHYOID_3 = new RString("DBC701023_HanyoListSogoJigyoHiShukei");
    private static final RString CHOHYOID_4 = new RString("DBC701024_HanyoListSogoJigyoHiCare");
    private EucEntityId euc_entity_id;
    private FileSpoolManager manager;
    private RString eucFilePath;
    private Map<RString, KoseiShichosonMaster> 市町村名MasterMap;
    private HanyoListSogoJigyoHiProcessParameter processParameter;
    private HanyoListSogoJigyoHi hanyolistsogojigyohi;
    private Association association;
    private boolean flag;
    private ChohyoSeigyoKyotsu 帳票制御共通;
    private ChohyoSeigyoKyotsu 帳票制御共通_明細;
    private ChohyoSeigyoKyotsu 帳票制御共通_集計;
    private ChohyoSeigyoKyotsu 帳票制御共通_ケアマネジメント;

    @Override
    protected void initialize() {
        flag = false;
        hanyolistsogojigyohi = new HanyoListSogoJigyoHi(processParameter);
        association = AssociationFinderFactory.createInstance().getAssociation();
        get市町村名();
        ChohyoSeigyoKyotsuManager chohyoSeigyoKyotsuManager = new ChohyoSeigyoKyotsuManager();
        帳票制御共通 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701018.getReportId());
        帳票制御共通_明細 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701022.getReportId());
        帳票制御共通_集計 = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701023.getReportId());
        帳票制御共通_ケアマネジメント = chohyoSeigyoKyotsuManager.get帳票制御共通(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701024.getReportId());
    }

    @BatchWriter
    private CsvWriter<IHanyoListSogoJigyoHiEUCEntity> eucCsvWriter;

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, hanyolistsogojigyohi.createMybatisParameter(get出力順()));
    }

    @Override
    protected void createWriter() {
        manager = new FileSpoolManager(UzUDE0835SpoolOutputType.EucOther, setEUC_ENTITY_ID(processParameter.get帳票ID()),
                UzUDE0831EucAccesslogFileType.Csv);
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
            eucCsvWriter.writeLine(hanyolistsogojigyohi.set連番基本なしEUCEntity(entity, 市町村名MasterMap, 帳票制御共通, association));
        } else if (基本明細情報.equals(processParameter.get抽出方法())) {
            eucCsvWriter.writeLine(hanyolistsogojigyohi.set連番基本明細なしEUCEntity(entity, 市町村名MasterMap, 帳票制御共通_明細, association));
        } else if (基本集計情報.equals(processParameter.get抽出方法())) {
            eucCsvWriter.writeLine(hanyolistsogojigyohi.set連番基本集計なしEUCEntity(entity, 市町村名MasterMap, 帳票制御共通_集計, association));
        } else if (基本ケアマネジメント情報.equals(processParameter.get抽出方法())) {
            eucCsvWriter.writeLine(hanyolistsogojigyohi.set連番基本マネジなしEUCEntity(entity, 市町村名MasterMap, 帳票制御共通_ケアマネジメント, association));
        }
    }

    @Override
    protected void afterExecute() {
        if (!flag) {
            if (基本情報.equals(processParameter.get抽出方法())) {
                eucCsvWriter.writeLine(new HanyoListSogoJigyoHiKiHonReibanNashiEUCEntity());
            } else if (基本明細情報.equals(processParameter.get抽出方法())) {
                eucCsvWriter.writeLine(new HanyoListSogoJigyoHiKiHonMeisaiReibanNashiEUCEntity());
            } else if (基本集計情報.equals(processParameter.get抽出方法())) {
                eucCsvWriter.writeLine(new HanyoListSogoJigyoHiKiHonShukeiReibanNashiEUCEntity());
            } else if (基本ケアマネジメント情報.equals(processParameter.get抽出方法())) {
                eucCsvWriter.writeLine(new HanyoListSogoJigyoHiKiHonManejimentoReibanNashiEUCEntity());
            }
            eucCsvWriter.close();
            manager.spool(eucFilePath);
        } else {
            eucCsvWriter.close();
            manager.spool(eucFilePath, hanyolistsogojigyohi.getアクセスログ());
        }
        outputJokenhyoFactory();
    }

    private void get市町村名() {
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
                euc_entity_id.toRString(),
                get出力件数(new Decimal(eucCsvWriter.getCount())),
                hanyolistsogojigyohi.set出力条件());
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
        ShutsuryokujunRelateEntity shutsuryokujunrelateentity = new ShutsuryokujunRelateEntity();
        if (基本情報.equals(processParameter.get抽出方法())) {
            shutsuryokujunrelateentity = ReportUtil.get出力順情報(HanyoListSogoJigyoHi.ShutsuryokujunEnum.class,
                    SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701018.getReportId(),
                    processParameter.get出力順ID());
        } else if (基本明細情報.equals(processParameter.get抽出方法())) {
            shutsuryokujunrelateentity = ReportUtil.get出力順情報(HanyoListSogoJigyoHi.ShutsuryokujunEnum.class,
                    SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701022.getReportId(),
                    processParameter.get出力順ID());
        } else if (基本集計情報.equals(processParameter.get抽出方法())) {
            shutsuryokujunrelateentity = ReportUtil.get出力順情報(HanyoListSogoJigyoHi.ShutsuryokujunEnum.class,
                    SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701023.getReportId(),
                    processParameter.get出力順ID());
        } else if (基本ケアマネジメント情報.equals(processParameter.get抽出方法())) {
            shutsuryokujunrelateentity = ReportUtil.get出力順情報(HanyoListSogoJigyoHi.ShutsuryokujunEnum.class,
                    SubGyomuCode.DBC介護給付, ReportIdDBC.DBC701024.getReportId(),
                    processParameter.get出力順ID());
        }

        RString 出力順 = RString.EMPTY;
        if (shutsuryokujunrelateentity != null) {
            出力順 = shutsuryokujunrelateentity.get出力順OrderBy();
            List<RString> 出力順項目 = shutsuryokujunrelateentity.get出力順項目();
            if (基本情報.equals(processParameter.get抽出方法())) {
                return set出力順(出力順項目, 出力順);
            } else if (基本明細情報.equals(processParameter.get抽出方法())) {
                return set出力順基本明細(出力順項目, set出力順(出力順項目, 出力順));
            } else if (基本集計情報.equals(processParameter.get抽出方法())) {
                return set出力順基本集計(出力順項目, set出力順(出力順項目, 出力順));
            } else if (基本ケアマネジメント情報.equals(processParameter.get抽出方法())) {
                return set出力順基本ケアマ(出力順項目, set出力順(出力順項目, 出力順));
            }
        }
        return 出力順;
    }

    private RString set出力順(List<RString> 出力順項目, RString 出力順) {
        if (出力順項目.contains(被保険者番号)) {
            return set被保険者番号ARi(出力順項目, 出力順);
        } else {
            return set被保険者番号NaShi(出力順項目, 出力順);
        }
    }

    private RString set被保険者番号ARi(List<RString> 出力順項目, RString 出力順) {
        if (出力順項目.contains(サービス年月)) {
            return setサービス年月ARI(出力順項目, 出力順);
        } else {
            return setサービス年月NASHI(出力順項目, 出力順);
        }
    }

    private RString set被保険者番号NaShi(List<RString> 出力順項目, RString 出力順) {
        if (出力順項目.contains(サービス年月)) {
            return setサービス年月ARI(出力順項目, 出力順).concat(HIHOKENSHANO);
        } else {
            return setサービス年月NASHI(出力順項目, 出力順).concat(HIHOKENSHANO);
        }
    }

    private RString set出力順基本明細(List<RString> 出力順項目, RString 出力順) {
        if (出力順項目.contains(サービス種類)) {
            if (出力順項目.contains(サービス項目)) {
                return 出力順;
            } else {
                return 出力順.concat(SERVICEKOMOKU);
            }
        } else if (出力順項目.contains(サービス項目)) {
            return 出力順.concat(SERVICESHURUICODE);
        } else {
            return 出力順.concat(SERVICEKOMOKU).concat(SERVICESHURUICODE);
        }
    }

    private RString set出力順基本集計(List<RString> 出力順項目, RString 出力順) {
        if (出力順項目.contains(サービス種類)) {
            return 出力順;
        } else {
            return 出力順.concat(SERVICESHURUICODE);
        }
    }

    private RString set出力順基本ケアマ(List<RString> 出力順項目, RString 出力順) {
        if (出力順項目.contains(サービスコード)) {
            return 出力順;
        } else {
            return 出力順.concat(KETTEISERVICECODE);
        }
    }

    private RString setサービス年月ARI(List<RString> 出力順項目, RString 出力順) {
        if (出力順項目.contains(整理番号)) {
            if (出力順項目.contains(給付実績事業者)) {
                return 出力順;
            } else {
                return 出力順.concat(KYUFUJISSEKIJIGYOSHA);
            }
        } else if (出力順項目.contains(給付実績事業者)) {
            return 出力順.concat(SEIRINO);
        } else {
            return 出力順.concat(SEIRINO).concat(KYUFUJISSEKIJIGYOSHA);
        }
    }

    private RString setサービス年月NASHI(List<RString> 出力順項目, RString 出力順) {
        if (出力順項目.contains(整理番号)) {
            if (出力順項目.contains(給付実績事業者)) {
                return 出力順.concat(SERVICEYM);
            } else {
                return 出力順.concat(SERVICEYM).concat(KYUFUJISSEKIJIGYOSHA);
            }
        } else if (出力順項目.contains(給付実績事業者)) {
            return 出力順.concat(SERVICEYM).concat(SEIRINO);
        } else {
            return 出力順.concat(SERVICEYM).concat(SEIRINO).concat(KYUFUJISSEKIJIGYOSHA);
        }
    }

    private EucEntityId setEUC_ENTITY_ID(RString 帳票ID) {
        if (CHOHYOID_1.equals(帳票ID)) {
            euc_entity_id = new EucEntityId("DBC701018");
        } else if (CHOHYOID_2.equals(帳票ID)) {
            euc_entity_id = new EucEntityId("DBC701022");
        } else if (CHOHYOID_3.equals(帳票ID)) {
            euc_entity_id = new EucEntityId("DBC701023");
        } else if (CHOHYOID_4.equals(帳票ID)) {
            euc_entity_id = new EucEntityId("DBC701024");
        }
        return euc_entity_id;
    }
}
