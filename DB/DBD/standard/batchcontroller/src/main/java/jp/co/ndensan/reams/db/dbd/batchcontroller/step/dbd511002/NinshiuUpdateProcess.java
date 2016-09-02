/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd511002;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd5320001.TsutishoHakkoCommonProcess;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501001.YokaigoNinteiShinseishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd501002.ShinseiShoEntity;
import jp.co.ndensan.reams.db.dbd.business.report.dbd511001.KoshinShinseiOshiraseTshuchishoReport;
import jp.co.ndensan.reams.db.dbd.business.report.dbd511002.KoshinShinseiTsuchishoHakkoIchiranhyoReport;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd511002.NinshiuUpdateProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.reportid.ReportIdDBD;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.NinshiuUpdateEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.RenZhengzheEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.TongzhiShuEntity;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd511002.TongzhiShufaxingEntity;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd501001.YokaigoNinteiShinseishoReportSource;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511001.KoshinShinseiOshiraseTshuchishoReportSource;
import jp.co.ndensan.reams.db.dbd.entity.report.dbd511002.KoshinShinseiTsuchishoHakkoIchiranhyoReportSource;
import jp.co.ndensan.reams.db.dbd.service.report.gemgengnintskettsucskobthakko.GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun02;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun06;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun99;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4101NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7065ChohyoSeigyoKyotsuEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
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
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 更新未申請者把握リスト作成CSVファイル出力です。
 *
 * @reamsid_L DBD-2030-020 x_miaocl
 */
public class NinshiuUpdateProcess extends BatchProcessBase<NinshiuUpdateEntity> {

    private NinshiuUpdateProcessParameter parameter;
    private List<RenZhengzheEntity> oenNinshiEntitys;
    private static final ReportId 帳票ID01 = new ReportId("DBD501001_YokaigoNinteiShinseisho");
    private static final ReportId 帳票ID11 = new ReportId("DBD511001_KoshinShinseiOshiraseTshuchisho");
    private static final ReportId 帳票ID112 = new ReportId("DBD511002_KoshinShinseiTsuchishoHakkoIchiranhyo");
    private static Association association;
    private DbT7065ChohyoSeigyoKyotsuEntity 帳票制御共通;
    private List<DbT7067ChohyoSeigyoHanyoEntity> 帳票制御汎用;
    private ChohyoSeigyoHanyo 帳票制御情報;
    private NinshoshaSource ninshoshaSource;
    private SofubutsuAtesakiSource 送付物宛先情報;
    private static IAtesaki 宛先;
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
    private static final int INDEX_0 = 0;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_8 = 8;
    private BatchReportWriter<YokaigoNinteiShinseishoReportSource> batchReportWrite01;
    private ReportSourceWriter<YokaigoNinteiShinseishoReportSource> reportSourceWriter01;
    private BatchReportWriter<KoshinShinseiOshiraseTshuchishoReportSource> batchReportWrite11;
    private ReportSourceWriter<KoshinShinseiOshiraseTshuchishoReportSource> reportSourceWriter11;
    private BatchReportWriter<KoshinShinseiTsuchishoHakkoIchiranhyoReportSource> batchReportWrite112;
    private ReportSourceWriter<KoshinShinseiTsuchishoHakkoIchiranhyoReportSource> reportSourceWriter112;

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
        batchReportWrite11 = BatchReportFactory.createBatchReportWriter(帳票ID11.value()).create();
        reportSourceWriter11 = new ReportSourceWriter<>(batchReportWrite11);
        batchReportWrite112 = BatchReportFactory.createBatchReportWriter(帳票ID112.value()).create();
        reportSourceWriter112 = new ReportSourceWriter<>(batchReportWrite112);
        dbT4101EntityWriter = new BatchPermanentTableWriter(DbT4101NinteiShinseiJohoEntity.class);
    }

    @Override
    protected void process(NinshiuUpdateEntity ninshi) {
        RenZhengzheEntity entity = new RenZhengzheEntity();
        TongzhiShufaxingEntity twonin = new TongzhiShufaxingEntity();
        ShinseiShoEntity entity2 = new ShinseiShoEntity();
        KoshinShinseNinshi(entity, ninshi);

        if (parameter.get出力対象区分().equals(ZERO)) {
            KoshinShinseiOshiraseTshuchishoReport find11 = new KoshinShinseiOshiraseTshuchishoReport(ninshoshaSource, 宛先,
                    new ChohyoSeigyoKyotsu(帳票制御共通), association, 帳票制御汎用, KoshinShinseNinshi(entity, ninshi));
            find11.writeBy(reportSourceWriter11);
            KoshinShinseiTsuchishoHakkoIchiranhyoReport find112 = new KoshinShinseiTsuchishoHakkoIchiranhyoReport(OshiraseNinshi(twonin, ninshi));
            find112.writeBy(reportSourceWriter112);
        } else if (parameter.get出力対象区分().equals(ONE)) {
            YokaigoNinteiShinseishoReport find01 = YokaigoNinteiShinseishoReport.createReport(KoshinShinseNinshi(entity2, ninshi));
            find01.writeBy(reportSourceWriter01);
            KoshinShinseiTsuchishoHakkoIchiranhyoReport find112 = new KoshinShinseiTsuchishoHakkoIchiranhyoReport(OshiraseNinshi(twonin, ninshi));
            find112.writeBy(reportSourceWriter112);
        } else if (parameter.get出力対象区分().equals(TWO)) {
            YokaigoNinteiShinseishoReport find01 = YokaigoNinteiShinseishoReport.createReport(KoshinShinseNinshi(entity2, ninshi));
            find01.writeBy(reportSourceWriter01);
            KoshinShinseiTsuchishoHakkoIchiranhyoReport find112 = new KoshinShinseiTsuchishoHakkoIchiranhyoReport(OshiraseNinshi(twonin, ninshi));
            find112.writeBy(reportSourceWriter112);
            KoshinShinseiOshiraseTshuchishoReport find11 = new KoshinShinseiOshiraseTshuchishoReport(ninshoshaSource, 宛先,
                    new ChohyoSeigyoKyotsu(帳票制御共通), association, 帳票制御汎用, KoshinShinseNinshi(entity, ninshi));
            find11.writeBy(reportSourceWriter11);
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
            builder.append(new RString(String.valueOf(batchReportWrite11.getPageCount())));
            builder.append(new RString(String.valueOf(batchReportWrite112.getPageCount())));
        } else if (parameter.get出力対象区分().equals(ONE)) {
            builder.append(new RString(String.valueOf(batchReportWrite01.getPageCount())));
        } else if (parameter.get出力対象区分().equals(TWO)) {
            builder.append(new RString(String.valueOf(batchReportWrite11.getPageCount())));
            builder.append(new RString(String.valueOf(batchReportWrite112.getPageCount())));
            builder.append(new RString(String.valueOf(batchReportWrite01.getPageCount())));
        }
        出力ページ.add(builder.toRString());
        バッチ出力条件リスト(帳票, 出力ページ, 帳票名称);
    }

    private void バッチ出力条件リスト(List<RString> 出力ページ, List<RString> 帳票, List<RString> 帳票名称) {
        for (RString 帳票ID : 帳票) {
            Baqi出力(出力ページ, 帳票名称, 帳票ID);
        }
    }

    private void Baqi出力(List<RString> 出力ページ, List<RString> 帳票名称, RString 帳票ID) {
        for (RString 出力ページ数 : 出力ページ) {
            for (RString 帳票名 : 帳票名称) {
                バッチ出力条件リストの出力(出力ページ数, 帳票名, 帳票ID);
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
    private RenZhengzheEntity KoshinShinseNinshi(RenZhengzheEntity entity, NinshiuUpdateEntity ninshi) {
        ChohyoSeigyoKyotsu 帳票共通情報 = TsutishoHakkoCommonProcess.get帳票共通情報(帳票ID11);
        帳票制御情報 = TsutishoHakkoCommonProcess.get帳票制御情報(帳票ID11);
        ninshoshaSource = ReportUtil.get認証者情報(SubGyomuCode.DBD介護受給, 帳票ID11,
                FlexibleDate.getNowDate(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(),
                KenmeiFuyoKubunType.付与なし, reportSourceWriter11);

        帳票制御共通 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御共通(帳票ID11);
        帳票制御汎用 = GenmenGengakuNinteishoKetteiTsuchishoKobetsuHakko.createInstance().load帳票制御汎用(帳票ID11);
        Map<Integer, RString> map = ReportUtil.get通知文(SubGyomuCode.DBD介護受給, 帳票ID11,
                KamokuCode.EMPTY, 1);
        entity.set通知文1(map.get(1));
        entity.set通知文2(map.get(2));
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
        entity.set要介護認定開始日(ninshi.getNinteiYukoKikanKaishiYMD().wareki().separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        entity.set要介護認定終了日(ninshi.getNinteiYukoKikanShuryoYMD().wareki().separator(Separator.JAPANESE).
                fillType(FillType.BLANK).toDateString());
        if (ninshi.getYokaigoJotaiKubunCode().getColumnValue().equals(new RString("99A"))) {
            entity.set要介護状態区分(YokaigoJotaiKubun99.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get略称());
        } else if (ninshi.getYokaigoJotaiKubunCode().getColumnValue().equals(new RString("02A"))) {
            entity.set要介護状態区分(YokaigoJotaiKubun02.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get略称());
        } else if (ninshi.getYokaigoJotaiKubunCode().getColumnValue().equals(new RString("06A"))) {
            entity.set要介護状態区分(YokaigoJotaiKubun06.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get略称());
        } else if (ninshi.getYokaigoJotaiKubunCode().getColumnValue().equals(new RString("09B"))
                && ninshi.getYokaigoJotaiKubunCode().getColumnValue().equals(new RString("09A"))) {
            entity.set要介護状態区分(YokaigoJotaiKubun09.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get略称());
        }

        return entity;
    }

    /**
     * 2.2
     */
    private TongzhiShufaxingEntity OshiraseNinshi(TongzhiShufaxingEntity twonin, NinshiuUpdateEntity ninshi) {
        RStringBuilder builder = new RStringBuilder();
        builder.append(parameter.get抽出対象期間_開始().wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        builder.append(カラ);
        builder.append(parameter.get抽出対象期間_終了().wareki().separator(Separator.JAPANESE).fillType(FillType.ZERO).toDateString());
        twonin.set抽出対象期間(builder.toRString());
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
        RTime time = RDate.getNowTime();
        RString hour = new RString(time.toString()).substring(INDEX_0, INDEX_2);
        RString min = new RString(time.toString()).substring(INDEX_3, INDEX_5);
        RString sec = new RString(time.toString()).substring(INDEX_6, INDEX_8);
        RString timeFormat = hour.concat("時").concat(min).concat("分").concat(sec).concat("秒");
        twonin.set印刷時間(new RString(RDate.getNowDate().wareki().eraType(EraType.KANJI).
                firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).
                fillType(FillType.ZERO).toDateString().toString() + timeFormat));
        set通知書発行一覧(twonin, ninshi);
        return twonin;
    }

    private void set通知書発行一覧(TongzhiShufaxingEntity twonin, NinshiuUpdateEntity ninshi) {
        TongzhiShuEntity entity = new TongzhiShuEntity();
        entity.set被保険者番号(ninshi.getHihokenshaNo());
        entity.set被保険者氏名(ninshi.getHihokenshaName().getColumnValue());
        if (ninshi.getYokaigoJotaiKubunCode().getColumnValue().equals(new RString("99A"))) {
            entity.set要介護度(YokaigoJotaiKubun99.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get略称());
        } else if (ninshi.getYokaigoJotaiKubunCode().getColumnValue().equals(new RString("02A"))) {
            entity.set要介護度(YokaigoJotaiKubun02.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get略称());
        } else if (ninshi.getYokaigoJotaiKubunCode().getColumnValue().equals(new RString("06A"))) {
            entity.set要介護度(YokaigoJotaiKubun06.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get略称());
        } else if (ninshi.getYokaigoJotaiKubunCode().getColumnValue().equals(new RString("09B"))
                && ninshi.getYokaigoJotaiKubunCode().getColumnValue().equals(new RString("09A"))) {
            entity.set要介護度(YokaigoJotaiKubun09.toValue(ninshi.getYokaigoJotaiKubunCode().getColumnValue()).get略称());
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

        twonin.setTongzhiShu(entity);
    }

    /**
     * 2.3
     */
    private ShinseiShoEntity KoshinShinseNinshi(ShinseiShoEntity entity, NinshiuUpdateEntity ninshi) {
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
     * @return AtesakiPSMSearchKeyBuilder AtesakiPSMSearchKeyBuilder
     */
    public static AtesakiPSMSearchKeyBuilder get送付物宛先情報() {
        IAtesakiGyomuHanteiKey key = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBD介護受給);
        AtesakiPSMSearchKeyBuilder builder = new AtesakiPSMSearchKeyBuilder(key);
        builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        builder.set識別コード(ShikibetsuCode.EMPTY);
        builder.set基準日(FlexibleDate.getNowDate());
        builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        builder.set世帯主利用区分(SetainushiRiyoKubun.利用しない);
        builder.set代納人利用区分(DainoRiyoKubun.利用する);
        builder.set法人代表者利用区分(HojinDaihyoshaRiyoKubun.利用しない);
        宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(builder.build());

        return builder;

    }

    private RString get申請区分_法令(Code code) {
        if (code.getColumnValue().equals(NinteiShinseiHoreiCode.職権.getコード())) {
            return 職権;
        } else if (code.getColumnValue().equals(NinteiShinseiHoreiCode.区分変更申請.getコード())) {
            return 区分変更申請;
        } else if (code.getColumnValue().equals(NinteiShinseiHoreiCode.新規申請.getコード())) {
            return 新規申請;
        } else if (code.getColumnValue().equals(NinteiShinseiHoreiCode.更新申請.getコード())) {
            return 更新申請;
        } else {
            return RString.EMPTY;
        }
    }

    private RString get申請区分_申請時(Code code) {
        if (code.getColumnValue().equals(NinteiShinseiShinseijiKubunCode.職権.getコード())) {
            return 職権;
        } else if (code.getColumnValue().equals(NinteiShinseiShinseijiKubunCode.区分変更申請.getコード())) {
            return 区分変更申請;
        } else if (code.getColumnValue().equals(NinteiShinseiShinseijiKubunCode.新規申請.getコード())) {
            return 新規申請;
        } else if (code.getColumnValue().equals(NinteiShinseiShinseijiKubunCode.新規申請_事前.getコード())) {
            return 新規申請_事前;
        } else if (code.getColumnValue().equals(NinteiShinseiShinseijiKubunCode.更新申請.getコード())) {
            return 更新申請;
        } else if (code.getColumnValue().equals(NinteiShinseiShinseijiKubunCode.更新申請_事前.getコード())) {
            return 更新申請_事前;
        } else if (code.getColumnValue().equals(NinteiShinseiShinseijiKubunCode.資格喪失_死亡.getコード())) {
            return 資格喪失_死亡;
        } else if (code.getColumnValue().equals(NinteiShinseiShinseijiKubunCode.転入申請.getコード())) {
            return 転入申請;
        } else {
            return RString.EMPTY;
        }
    }

    private ShinseiShoEntity oneZifang(ShinseiShoEntity entity, Code eCode) {
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護1.getコード())) {
            entity.set要介護状態区分1(まる);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護2.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(まる);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護3.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(まる);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護4.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(まる);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun99.要介護5.getコード())) {
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
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護1.getコード())) {
            entity.set要介護状態区分1(まる);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護2.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(まる);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護3.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(まる);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護4.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(まる);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun02.要介護5.getコード())) {
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
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護1.getコード())) {
            entity.set要介護状態区分1(まる);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護2.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(まる);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護3.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(まる);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護4.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(まる);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要介護5.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(まる);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要支援1.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(まる);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun06.要支援2.getコード())) {
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
        if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護1.getコード())) {
            entity.set要介護状態区分1(まる);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護2.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(まる);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護3.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(まる);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護4.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(まる);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要介護5.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(まる);
            entity.set要支援状態区分1(RString.EMPTY);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要支援1.getコード())) {
            entity.set要介護状態区分1(RString.EMPTY);
            entity.set要介護状態区分2(RString.EMPTY);
            entity.set要介護状態区分3(RString.EMPTY);
            entity.set要介護状態区分4(RString.EMPTY);
            entity.set要介護状態区分5(RString.EMPTY);
            entity.set要支援状態区分1(まる);
            entity.set要支援状態区分2(RString.EMPTY);
        } else if (eCode.getColumnValue().equals(YokaigoJotaiKubun09.要支援2.getコード())) {
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
