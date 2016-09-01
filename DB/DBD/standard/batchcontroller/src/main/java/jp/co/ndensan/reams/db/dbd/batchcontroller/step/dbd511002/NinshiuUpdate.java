/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd511002;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5320001.TsutishoHakkoCommonProcess;
import static jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5320001.TsutishoHakkoCommonProcess.get地方公共団体;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501001.YokaigoNinteiShinseishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd511002.NinshiuUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.NinshiuUpdateEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.RenZhengzheEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.TongzhiShuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.TongzhiShufaxingEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501002.YokaigoNinteikbnHenkoShinseishoReportSource;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.business.core.editedatesaki.EditedAtesakiBuilder;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.DainoRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.HojinDaihyoshaRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SetainushiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.IReportOutputJokenhyoPrinter;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.ux.uxx.business.core.tsuchishoteikeibun.TsuchishoTeikeibunInfo;
import jp.co.ndensan.reams.ux.uxx.service.core.tsuchishoteikeibun.TsuchishoTeikeibunManager;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchPermanentTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 更新未申請者把握リスト作成CSVファイル出力です。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
public class NinshiuUpdate extends BatchProcessBase<NinshiuUpdateEntity> {

    private NinshiuUpdateProcessParameter parameter;
    private List<RenZhengzheEntity> oenNinshiEntitys;
    private List<ShinseiShoEntity> shinseiShoEntity;
    private static final ReportId 帳票ID01 = new ReportId("DBD501001_YokaigoNinteiShinseisho");
    private static final ReportId 帳票ID11 = new ReportId("DBD511001_KoshinShinseiOshiraseTshuchisho");
    private static final ReportId 帳票ID112 = new ReportId("DBD511002_KoshinShinseiTsuchishoHakkoIchiranhyo");
    private static Association association;
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    private static final RString カラ = new RString("～");
    private static final RString カあ = new RString("-");
    private static final RString まる = new RString("○");
    private static final int ZERO = 1;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final RString 新規申請 = new RString("新規申請");
    private static final RString 更新申請 = new RString("更新申請");
    private static final RString 区分変更申請 = new RString("区分変更申請");
    private static final RString 職権 = new RString("職権");
    private static final RString 新規申請_事前 = new RString("新規申請_事前");
    private static final RString 更新申請_事前 = new RString("更新申請_事前");
    private static final RString 資格喪失_死亡 = new RString("資格喪失_死亡");
    private static final RString 転入申請 = new RString("転入申請");
    private static final String 明治 = new String("明治");
    private static final String 昭和 = new String("昭和");
    private static final String 大正 = new String("大正");

    private BatchReportWriter<YokaigoNinteikbnHenkoShinseishoReportSource> batchReportWrite01;
    private ReportSourceWriter<YokaigoNinteikbnHenkoShinseishoReportSource> reportSourceWriter01;
    //TODO
//    private BatchReportWriter<YokaigoNinteikbnHenkoShinseishoReportSource> batchReportWrite11;
//    private ReportSourceWriter<YokaigoNinteikbnHenkoShinseishoReportSource> reportSourceWriter11;
//    private BatchReportWriter<YokaigoNinteikbnHenkoShinseishoReportSource> batchReportWrite112;
//    private ReportSourceWriter<YokaigoNinteikbnHenkoShinseishoReportSource> reportSourceWriter112;

    private static final RString MYBATIS_SELECT_ID
            = new RString("jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.futanngenndogakuninntei."
                    + "IFutanGenndoGakuNinnteiTsuuchishoMapper.get負担限度額認定の通知書発行情報");

    @Override
    protected void initialize() {
        association = AssociationFinderFactory.createInstance().getAssociation();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, parameter.toNinshiuUpdateMyBatisParameter(parameter.get申請書管理番号リスト(),
                parameter.get出力対象区分(),
                parameter.get抽出対象期間_開始(),
                parameter.get抽出対象期間_終了(),
                parameter.get通知書発行日(),
                parameter.get出力順()));
    }
    @BatchWriter
    private BatchPermanentTableWriter<DbT4101NinteiShinseiJohoEntity> dbT4101EntityWriter;

    @Override
    protected void createWriter() {
        batchReportWrite01 = BatchReportFactory.createBatchReportWriter(帳票ID01.value()).create();
        reportSourceWriter01 = new ReportSourceWriter<>(batchReportWrite01);
        dbT4101EntityWriter = new BatchPermanentTableWriter(DbT4101NinteiShinseiJohoEntity.class);
    }

    @Override
    protected void process(NinshiuUpdateEntity t) {
        if (parameter.get出力対象区分().equals(ZERO)) {

        } else if (parameter.get出力対象区分().equals(ONE)) {
            for (ShinseiShoEntity shoEntity : shinseiShoEntity) {
                YokaigoNinteiShinseishoReport find = YokaigoNinteiShinseishoReport.createReport(shoEntity);
                //   find.writeBy(reportSourceWriter01);
            }
        } else if (parameter.get出力対象区分().equals(TWO)) {
        }
    }

    protected void afterProcess(DbT4101NinteiShinseiJohoEntity entity) {
        if (parameter.get出力対象区分().equals(ZERO)
                && parameter.get出力対象区分().equals(TWO)) {
            dbT4101EntityWriter.update(update要介護認定申請情報テーブ(entity));
        }
    }

    private DbT4101NinteiShinseiJohoEntity update要介護認定申請情報テーブ(DbT4101NinteiShinseiJohoEntity entity) {
        entity.setKoshinTsuchiHakkoYMD(parameter.get通知書発行日());
        return entity;
    }

    @Override
    protected void afterExecute() {
        RStringBuilder builder = new RStringBuilder();
        List<RString> 帳票 = new ArrayList<>();
        if (parameter.get出力対象区分().equals(ZERO)) {
            builder.append(帳票ID11);
            builder.append(帳票ID112);
        } else if (parameter.get出力対象区分().equals(ONE)) {
            builder.append(帳票ID01);
            builder.append(帳票ID112);
        } else if (parameter.get出力対象区分().equals(TWO)) {
            builder.append(帳票ID01);
            builder.append(帳票ID11);
            builder.append(帳票ID112);
        }
        帳票.add(builder.toRString());
        List<RString> 帳票名称 = new ArrayList<>();
        if (parameter.get出力対象区分().equals(ZERO)) {
            builder.append(ReportIdDBD.DBD511001.getReportName());
            builder.append(ReportIdDBD.DBD511002.getReportName());
        } else if (parameter.get出力対象区分().equals(ONE)) {
            builder.append(ReportIdDBD.DBD501001.getReportName());
            builder.append(ReportIdDBD.DBD511002.getReportName());
        } else if (parameter.get出力対象区分().equals(TWO)) {
            builder.append(ReportIdDBD.DBD501001.getReportName());
            builder.append(ReportIdDBD.DBD511002.getReportName());
            builder.append(ReportIdDBD.DBD511001.getReportName());
        }
        帳票名称.add(builder.toRString());
        List<RString> 出力ページ = new ArrayList<>();
        if (parameter.get出力対象区分().equals(ZERO)) {
//TODO
        } else if (parameter.get出力対象区分().equals(ONE)) {
            builder.append(new RString(String.valueOf(batchReportWrite01.getPageCount())));
        } else if (parameter.get出力対象区分().equals(TWO)) {
//TODO
        }
        出力ページ.add(builder.toRString());
        バッチ出力条件リスト(帳票, 出力ページ, 帳票名称);
    }

    private void バッチ出力条件リスト(List<RString> 出力ページ, List<RString> 帳票, List<RString> 帳票名称) {
        for (RString 帳票ID : 帳票) {
            for (RString 出力ページ数 : 出力ページ) {
                for (RString 帳票名 : 帳票名称) {
                    バッチ出力条件リストの出力(出力ページ数, 帳票名, 帳票ID);
                }
            }
        }

    }

    private void バッチ出力条件リストの出力(RString 出力ページ数, RString 帳票名, RString 帳票ID) {
        RString 導入団体コード = association.getLasdecCode_().getColumnValue();
        RString 市町村名 = association.get市町村名();
        RString ジョブ番号 = new RString(String.valueOf(JobContextHolder.getJobId()));
        RString csv出力有無 = new RString("なし");
        RString csvファイル名 = カあ;
        RStringBuilder builder = new RStringBuilder();
        List<RString> 出力条件 = new ArrayList<>();
        builder.append(parameter.get申請書管理番号リスト());
        出力条件.add(builder.toRString());
        builder.append(parameter.get抽出対象期間_開始());
        出力条件.add(builder.toRString());
        builder.append(parameter.get出力対象区分());
        出力条件.add(builder.toRString());
        builder.append(parameter.get出力順());
        出力条件.add(builder.toRString());
        builder.append(parameter.get抽出対象期間_終了());
        出力条件.add(builder.toRString());
        builder.append(parameter.get通知書発行日());
        出力条件.add(builder.toRString());

        ReportOutputJokenhyoItem reportOutputJokenhyoItem = new ReportOutputJokenhyoItem(
                帳票ID,
                導入団体コード,
                市町村名,
                ジョブ番号,
                帳票名,
                出力ページ数,
                csv出力有無,
                csvファイル名,
                出力条件);
        IReportOutputJokenhyoPrinter printer = OutputJokenhyoFactory.createInstance(reportOutputJokenhyoItem);
        printer.print();
    }

    /**
     * 2.1
     */
    private RenZhengzheEntity oenNinshi(RenZhengzheEntity entity, NinshiuUpdateEntity ninshi) {
        ChohyoSeigyoKyotsu 帳票共通情報 = TsutishoHakkoCommonProcess.get帳票共通情報(帳票ID11);
        ChohyoSeigyoHanyo 帳票制御情報 = TsutishoHakkoCommonProcess.get帳票制御情報(帳票ID11);
//        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票ID11,
//                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
//                KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        SofubutsuAtesakiSource 送付物宛先情報 = TsutishoHakkoCommonProcess.get送付物宛先情報(帳票共通情報);
        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(帳票ID11);
        帳票制御汎用 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御汎用(帳票ID11);
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        TsuchishoTeikeibunInfo 通知文1 = manager.get最新適用日(SubGyomuCode.DBD介護受給, 帳票ID11, KamokuCode.EMPTY, 1, 1);
        entity.set被保険者氏名フリガナ(ninshi.getHihokenshaKana().getColumnValue());
        entity.set被保険者番号1(ninshi.getHihokenshaNo().substring(ZERO, ONE));
        entity.set被保険者番号2(ninshi.getHihokenshaNo().substring(ONE, TWO));
        entity.set被保険者番号3(ninshi.getHihokenshaNo().substring(TWO, THREE));
        entity.set被保険者番号4(ninshi.getHihokenshaNo().substring(THREE, FOUR));
        entity.set被保険者番号5(ninshi.getHihokenshaNo().substring(FOUR, FIVE));
        entity.set被保険者番号6(ninshi.getHihokenshaNo().substring(FIVE, SIX));
        entity.set被保険者番号7(ninshi.getHihokenshaNo().substring(SIX, SEVEN));
        entity.set被保険者番号8(ninshi.getHihokenshaNo().substring(SEVEN, EIGHT));
        entity.set被保険者番号9(ninshi.getHihokenshaNo().substring(EIGHT, NINE));
        entity.set被保険者番号10(ninshi.getHihokenshaNo().substring(NINE, TEN));
        entity.set被保険者氏名(ninshi.getHihokenshaName().getColumnValue());
        entity.set要介護認定開始日(ninshi.getNinteiYukoKikanKaishiYMD().wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        entity.set要介護認定終了日(ninshi.getNinteiYukoKikanShuryoYMD().wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ninshi.getYokaigoJotaiKubunCode();
        if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("99A"))) {

        } else if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("02A"))) {

        } else if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("06A"))) {

        } else if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("09B"))
                && ninshi.getYokaigoJotaiKubunCode().equals(new Code("09A"))) {

        }
        TsuchishoTeikeibunInfo 通知文2 = manager.get最新適用日(SubGyomuCode.DBD介護受給, 帳票ID11, KamokuCode.EMPTY, 1, 2);
        return entity;
    }

    /**
     * 2.2
     */
    private void twoNinshi(TongzhiShuEntity entity, TongzhiShufaxingEntity twonin, NinshiuUpdateEntity ninshi) {
        List<RString> 抽出対象期間 = new ArrayList<>();
        RStringBuilder builder = new RStringBuilder();
        builder.append(parameter.get抽出対象期間_開始().wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        builder.append(カラ);
        builder.append(parameter.get抽出対象期間_終了().wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        抽出対象期間.add(builder.toRString());
        //twonin.set抽出対象期間();
        twonin.set市町村コード(ninshi.getShichosonCode().getColumnValue());
        twonin.set市町村名称(ninshi.getShichosonMeisho());
        if (parameter.get出力順().get(ZERO).isNullOrEmpty()) {
            twonin.set並び順1(parameter.get出力順().get(ZERO));
        } else if (parameter.get出力順().get(ONE).isNullOrEmpty()) {
            twonin.set並び順2(parameter.get出力順().get(ONE));
        } else if (parameter.get出力順().get(TWO).isNullOrEmpty()) {
            twonin.set並び順3(parameter.get出力順().get(TWO));
        } else if (parameter.get出力順().get(THREE).isNullOrEmpty()) {
            twonin.set並び順2(parameter.get出力順().get(THREE));
        } else if (parameter.get出力順().get(FOUR).isNullOrEmpty()) {
            twonin.set並び順2(parameter.get出力順().get(FOUR));
        }
        entity.set被保険者番号(ninshi.getHihokenshaNo());
        entity.set被保険者氏名(ninshi.getHihokenshaName().getColumnValue());
        if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("99A"))) {

        } else if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("02A"))) {

        } else if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("06A"))) {

        } else if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("09B"))
                && ninshi.getYokaigoJotaiKubunCode().equals(new Code("09A"))) {
        }
        entity.set受給申請日(ninshi.getNinteiShinseiYMD().wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        entity.set認定日(ninshi.getNinteiYMD().wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        entity.set認定開始日(ninshi.getNinteiYukoKikanKaishiYMD().wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        entity.set認定終了日(ninshi.getNinteiYukoKikanShuryoYMD().wareki().separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        entity.set受給申請事由(ninshi.getNinteiShinseiRiyu());
        entity.set申請区分_申請時(get申請区分_申請時(ninshi.getNinteiShinseiShinseijiKubunCode()));
        entity.set申請区分_法令(get申請区分_法令(ninshi.getNinteiShinseiHoreiKubunCode()));
        entity.set居宅支援事業者コード(ninshi.getJigyoshaNo().getColumnValue());
        entity.set居宅支援事業者名称(ninshi.getJigyoshaMeisho());
        entity.set入所施設事業者コード(ninshi.getNyushoShisetsuCode().getColumnValue());
        entity.set入所施設事業者名称(ninshi.getJigyoshaName().getColumnValue());
    }

    /**
     * 2.3
     */
    private ShinseiShoEntity TherrNinshi(ShinseiShoEntity entity, NinshiuUpdateEntity ninshi) {
        entity.set市町村名称(ninshi.getShichosonMeisho());
        entity.set被保険者番号第1桁(ninshi.getHihokenshaNo().substring(ZERO, ONE));
        entity.set被保険者番号第2桁(ninshi.getHihokenshaNo().substring(ONE, TWO));
        entity.set被保険者番号第3桁(ninshi.getHihokenshaNo().substring(TWO, THREE));
        entity.set被保険者番号第4桁(ninshi.getHihokenshaNo().substring(THREE, FOUR));
        entity.set被保険者番号第5桁(ninshi.getHihokenshaNo().substring(FOUR, FIVE));
        entity.set被保険者番号第6桁(ninshi.getHihokenshaNo().substring(FIVE, SIX));
        entity.set被保険者番号第7桁(ninshi.getHihokenshaNo().substring(SIX, SEVEN));
        entity.set被保険者番号第8桁(ninshi.getHihokenshaNo().substring(SEVEN, EIGHT));
        entity.set被保険者番号第9桁(ninshi.getHihokenshaNo().substring(EIGHT, NINE));
        entity.set被保険者番号第10桁(ninshi.getHihokenshaNo().substring(NINE, TEN));
        String nianhao = ninshi.getSeinengappiYMD().toString();
        if (nianhao.startsWith(明治)) {
            entity.set出生元号明治(まる);
            entity.set出生元号大正(RString.EMPTY);
            entity.set出生元号明治(RString.EMPTY);
        } else if (nianhao.startsWith(大正)) {
            entity.set出生元号明治(RString.EMPTY);
            entity.set出生元号大正(まる);
            entity.set出生元号明治(RString.EMPTY);
        } else {
            entity.set出生元号明治(RString.EMPTY);
            entity.set出生元号大正(RString.EMPTY);
            entity.set出生元号明治(まる);
        }
        entity.set被保険者名称カナ(ninshi.getHihokenshaKana().getColumnValue());
        entity.set出生年YYYY(RString.EMPTY);
        entity.set生まれYY(ninshi.getSeinengappiYMD().wareki().getYear());
        entity.set出生月MM(ninshi.getSeinengappiYMD().wareki().getMonth());
        entity.set出生日DD(ninshi.getSeinengappiYMD().wareki().getDay());
        entity.set出生日DD(ninshi.getHihokenshaName().getColumnValue());
        if (ninshi.getSeibetsu().equals(new Code("男"))) {
            entity.set性別男(まる);
            entity.set性別女(RString.EMPTY);
        } else {
            entity.set性別男(RString.EMPTY);
            entity.set性別女(まる);
        }
        entity.set電話番号(ninshi.getTelNo().getColumnValue());
        entity.set郵便番号(ninshi.getYubinNo().getColumnValue());
        entity.set住所(ninshi.getJusho().getColumnValue());
        TsuchishoTeikeibunManager manager = new TsuchishoTeikeibunManager();
        Code eCode = ninshi.getYokaigoJotaiKubunCode();
        TsuchishoTeikeibunInfo 通知文1 = manager.get最新適用日(SubGyomuCode.DBD介護受給, 帳票ID01, KamokuCode.EMPTY, 1, 1);
        if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("99A"))) {
            entity = oneZifang(entity, eCode);
        } else if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("02A"))) {
            entity = twoZifang(entity, eCode);
        } else if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("06A"))) {
            entity = therrZifang(entity, eCode);
        } else if (ninshi.getYokaigoJotaiKubunCode().equals(new Code("09B"))
                && ninshi.getYokaigoJotaiKubunCode().equals(new Code("09A"))) {
            entity = fourZifang(entity, eCode);
        }

        entity.set有効開始年YYYY(ninshi.getNinteiYukoKikanKaishiYMD().wareki().getYear());
        entity.set有効開始月MM(ninshi.getNinteiYukoKikanKaishiYMD().wareki().getMonth());
        entity.set有効開始日DD(ninshi.getNinteiYukoKikanKaishiYMD().wareki().getDay());
        entity.set有効終了年YYYY(ninshi.getNinteiYukoKikanShuryoYMD().wareki().getYear());
        entity.set有効終了月MM(ninshi.getNinteiYukoKikanShuryoYMD().wareki().getMonth());
        entity.set有効終了日DD(ninshi.getNinteiYukoKikanShuryoYMD().wareki().getDay());
        return entity;
    }

    /**
     * 送付物宛先情報の取得。
     *
     * @param 帳票共通情報 ChohyoSeigyoKyotsu
     * @return 送付物宛先情報 送付物宛先情報
     */
    public static SofubutsuAtesakiSource get送付物宛先情報(ChohyoSeigyoKyotsu 帳票共通情報) {
        IAtesakiGyomuHanteiKey key = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(key);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());

        EditedAtesaki 編集後宛先 = EditedAtesakiBuilder.create編集後宛先(宛先, get地方公共団体(), 帳票共通情報);
        SofubutsuAtesakiSource sofubutsuAtesakiSource;
        try {
            sofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource().get送付物宛先ソース();
        } catch (Exception e) {
            sofubutsuAtesakiSource = new SofubutsuAtesakiSource();
        }

        return sofubutsuAtesakiSource;
    }

    private RString get申請区分_法令(Code code) {
        if (NinteiShinseiHoreiCode.職権.getコード().equals(code)) {
            return 職権;
        } else if (NinteiShinseiHoreiCode.区分変更申請.getコード().equals(code)) {
            return 区分変更申請;
        } else if (NinteiShinseiHoreiCode.新規申請.getコード().equals(code)) {
            return 新規申請;
        } else if (NinteiShinseiHoreiCode.更新申請.getコード().equals(code)) {
            return 更新申請;
        } else {
            return RString.EMPTY;
        }
    }

    private RString get申請区分_申請時(Code code) {
        if (NinteiShinseiShinseijiKubunCode.職権.getコード().equals(code)) {
            return 職権;
        } else if (NinteiShinseiShinseijiKubunCode.区分変更申請.getコード().equals(code)) {
            return 区分変更申請;
        } else if (NinteiShinseiShinseijiKubunCode.新規申請.getコード().equals(code)) {
            return 新規申請;
        } else if (NinteiShinseiShinseijiKubunCode.新規申請_事前.getコード().equals(code)) {
            return 新規申請_事前;
        } else if (NinteiShinseiShinseijiKubunCode.更新申請.getコード().equals(code)) {
            return 更新申請;
        } else if (NinteiShinseiShinseijiKubunCode.更新申請_事前.getコード().equals(code)) {
            return 更新申請_事前;
        } else if (NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード().equals(code)) {
            return 資格喪失_死亡;
        } else if (NinteiShinseiShinseijiKubunCode.転入申請.getコード().equals(code)) {
            return 転入申請;
        } else {
            return RString.EMPTY;
        }
    }

    private ShinseiShoEntity oneZifang(ShinseiShoEntity entity, Code eCode) {
        if (eCode.equals(YokaigoJotaiKubun99.要介護1.getコード())) {
            entity.set要介護状態区分1(まる);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun99.要介護2.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(まる);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun99.要介護3.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(まる);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun99.要介護4.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(まる);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun99.要介護5.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(まる);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        }
        return entity;
    }

    private ShinseiShoEntity twoZifang(ShinseiShoEntity entity, Code eCode) {
        if (eCode.equals(YokaigoJotaiKubun02.要介護1.getコード())) {
            entity.set要介護状態区分1(まる);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun02.要介護2.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(まる);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun02.要介護3.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(まる);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun02.要介護4.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(まる);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun02.要介護5.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(まる);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        }
        return entity;
    }

    private ShinseiShoEntity therrZifang(ShinseiShoEntity entity, Code eCode) {
        if (eCode.equals(YokaigoJotaiKubun06.要介護1.getコード())) {
            entity.set要介護状態区分1(まる);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun06.要介護2.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(まる);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun06.要介護3.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(まる);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun06.要介護4.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(まる);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun06.要介護5.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(まる);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun06.要支援1.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(まる);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun06.要支援2.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(まる);
        }
        return entity;
    }

    private ShinseiShoEntity fourZifang(ShinseiShoEntity entity, Code eCode) {
        if (eCode.equals(YokaigoJotaiKubun09.要介護1.getコード())) {
            entity.set要介護状態区分1(まる);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun09.要介護2.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(まる);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun09.要介護3.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(まる);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun09.要介護4.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(まる);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun09.要介護5.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(まる);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun09.要支援1.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(まる);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.equals(YokaigoJotaiKubun09.要支援2.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(まる);
        }
        return entity;
    }
}
