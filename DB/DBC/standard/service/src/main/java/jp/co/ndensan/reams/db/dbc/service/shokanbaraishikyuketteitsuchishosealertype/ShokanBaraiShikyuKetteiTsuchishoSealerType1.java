/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.shokanbaraishikyuketteitsuchishosealertype;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteissuchishosealer.ShokanKetteiTsuchiShoSealer2Item;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerItem;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerProperty;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.report.source.shokanketteitsuchishoshiharaiyotei.ShokanKetteiTsuchiShoSealerReportSource;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.business.report.parts.ninshosha.INinshoshaSourceBuilder;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.bunshono.BunshoNoFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import jp.co.ndensan.reams.ur.urz.service.report.parts.ninshosha.INinshoshaSourceBuilderCreator;
import jp.co.ndensan.reams.ur.urz.service.report.sourcebuilder.ReportSourceBuilders;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
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
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.IReportProperty;
import jp.co.ndensan.reams.uz.uza.report.IReportSource;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportAssembler;
import jp.co.ndensan.reams.uz.uza.report.ReportAssemblerBuilder;
import jp.co.ndensan.reams.uz.uza.report.ReportManager;
import jp.co.ndensan.reams.uz.uza.report.source.breaks.BreakAggregator;

/**
 * 償還払い支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）のビジネスです。
 */
public class ShokanBaraiShikyuKetteiTsuchishoSealerType1 {

    private static final RString YEN = new RString("円");
    private static final RString 種別タイトル_口座種別 = new RString("口座種別");
    private static final RString 種別タイトル_店番 = new RString("店番");
    private static final RString 番号タイトル_口座番号 = new RString("口座番号");
    private static final RString 増減の理由タイトル_不支給の理由 = new RString("不支給の理由");
    private static final RString 増減の理由タイトル_増減の理由 = new RString("増減の理由");
    private static final RString 金融機関コード_郵便局 = new RString("9900");
    private static final RString 抽出モード_受け日 = new RString("1");
    private static final RString 抽出モード_決定日 = new RString("2");
    private static final RString KARA = new RString("～");
    private static final RString 抽出条件_受付日 = new RString("【抽出条件】 受付日：");
    private static final RString 抽出条件_決定日 = new RString("【抽出条件】 決定日：");
    private static final RString 抽出条件_決定者受付年月 = new RString("【抽出条件】 決定者受付年月：");
    private static final RString 記号_星 = new RString("**************");
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;

    /**
     * 帳票データを作成します。
     *
     * @param businessList 償還払支給（不支給）決定通知書情報Entityリスト
     * @param batchPram バッチパラメータ
     * @return 伝送データEntity
     */
    public TensoData shokanBaraiShikyuKetteiTsuchishoSealerType1(List<ShokanKetteiTsuchiShoShiharai> businessList,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram) {
        return 伝送データ作成(businessList, batchPram);
    }

    private TensoData 伝送データ作成(List<ShokanKetteiTsuchiShoShiharai> businessList,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram) {

        NinshoshaSource builderSource = 認証者取得(batchPram.getHakkoYMD()).buildSource();
        // TODO 文書番号　を　電算さんは見直し中
        RString 文書番号 = BunshoNoFinderFactory.createInstance().
                get文書番号管理(ReportIdDBC.DBC100004.getReportId(), batchPram.getHakkoYMD()).edit文書番号();
        // TODO ③送付先　を　電算さんは見直し中
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder 宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(batchPram.getHakkoYMD());
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        List<IAtesaki> 宛先s = ShikibetsuTaishoService.getAtesakiFinder().get宛先s(宛先builder.build());
        // TODO ②通知書定型文　を　電算さんは見直し中
        List<ShokanKetteiTsuchiShoSealerItem> ｼｰﾗﾀｲﾌﾟ帳票ソースデータ = new ArrayList<>();
        List<ShokanKetteiTsuchiShoSealer2Item> ｼｰﾗﾀｲﾌﾟ2帳票ソースデータ = new ArrayList<>();
        List<RString> 重複キーリスト = new ArrayList<>();
        for (ShokanKetteiTsuchiShoShiharai shiharai : businessList) {
            RString key = getJufukuKey(shiharai);
            if (重複キーリスト.contains(key)) {
                continue;
            }
            重複キーリスト.add(key);
            int pageCount = 0;
            HihokenshaNo 被保険者番号 = HihokenshaNo.EMPTY;
            if (!被保険者番号.equals(shiharai.get被保険者番号())) {
                pageCount++;
            }
            ｼｰﾗﾀｲﾌﾟ帳票ソースデータ.add(toItemｼｰﾗﾀｲﾌﾟ(shiharai, batchPram, builderSource, 文書番号, 宛先s, pageCount));
            ｼｰﾗﾀｲﾌﾟ2帳票ソースデータ.add(toItemｼｰﾗﾀｲﾌﾟ2(shiharai, batchPram, builderSource, 文書番号, 宛先s, pageCount));
        }
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        List<RString> 帳票名 = new ArrayList<>();
        帳票名.add(ReportIdDBC.DBC100004.getReportName());
        List<RString> 抽出条件 = new ArrayList<>();
        RStringBuilder 抽出条件Builder = new RStringBuilder();
        if (抽出モード_受け日.equals(batchPram.getChusyutuMode())) {
            抽出条件Builder.append(抽出条件_受付日);
            if (batchPram.getDataFrom() != null) {
                抽出条件Builder.append(batchPram.getDataFrom().wareki().
                        eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString());
            }
            抽出条件Builder.append(KARA);
            if (batchPram.getDataFrom() != null) {
                抽出条件Builder.append(batchPram.getDataTo().wareki().
                        eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString());
            }
        } else if (抽出モード_決定日.equals(batchPram.getChusyutuMode())) {
            抽出条件Builder.append(抽出条件_決定日);
            if (batchPram.getDataFrom() != null) {
                抽出条件Builder.append(batchPram.getDataFrom().wareki().
                        eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString());
            }
            抽出条件Builder.append(KARA);
            if (batchPram.getDataFrom() != null) {
                抽出条件Builder.append(batchPram.getDataTo().wareki().
                        eraType(EraType.KANJI).
                        firstYear(FirstYear.GAN_NEN).
                        separator(Separator.JAPANESE).
                        fillType(FillType.BLANK).toDateString());
            }
        } else {
            抽出条件Builder.append(抽出条件_決定者受付年月);
            抽出条件Builder.append(batchPram.getKetteishaUketukeYM().wareki().
                    eraType(EraType.KANJI_RYAKU).
                    firstYear(FirstYear.GAN_NEN).
                    separator(Separator.JAPANESE).
                    fillType(FillType.BLANK).toDateString());
        }
        抽出条件.add(抽出条件Builder.toRString());
        List<Decimal> ページ数 = new ArrayList<>();
        ページ数.add(Decimal.ONE);
        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().
                get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100004.getReportId(),
                        Long.parseLong(batchPram.getSyutujunId().toString()));
        List<RString> 出力順項目 = new ArrayList<>();
        List<RString> 改ページ項目 = new ArrayList<>();
        for (ISetSortItem sortItem : outputOrder.get設定項目リスト()) {
            出力順項目.add(sortItem.get項目ID());
            if (sortItem.is改頁項目()) {
                改ページ項目.add(sortItem.get項目ID());
            }
        }
        DaikoPrintItem daikoPrintItem = new DaikoPrintItem(SubGyomuCode.DBC介護給付,
                導入団体クラス.getLasdecCode_(), 導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC100004.getReportName(),
                ReportIdDBC.DBC100004.getReportId().value(),
                帳票名, ページ数, 抽出条件,
                出力順項目, 改ページ項目, null);
        IDaikoPrint daikoPrint = DaikoPrintFactory.createInstance(daikoPrintItem);
        return new TensoData(ｼｰﾗﾀｲﾌﾟ帳票ソースデータ, ｼｰﾗﾀｲﾌﾟ2帳票ソースデータ, daikoPrint);
    }

    private RString getJufukuKey(ShokanKetteiTsuchiShoShiharai shiharai) {
        RStringBuilder key = new RStringBuilder();
        key.append(shiharai.get提供年月().wareki().toDateString());
        key.append(shiharai.get整理番号());
        key.append(shiharai.get被保険者番号().value());
        key.append(shiharai.get種類());
        return key.toRString();
    }

    // TODO 認証者取得 ①雛形部品_認証者を　電算さんは見直し中
    private INinshoshaSourceBuilder 認証者取得(FlexibleDate 発行日) {
        try (ReportManager reportManager = new ReportManager()) {
            ShokanKetteiTsuchiShoSealerProperty property = new ShokanKetteiTsuchiShoSealerProperty();
            try (ReportAssembler<ShokanKetteiTsuchiShoSealerReportSource> assembler = createAssembler(property, reportManager)) {
                INinshoshaSourceBuilderCreator builderCreator = ReportSourceBuilders.ninshoshaSourceBuilder();
                return builderCreator.create(GyomuCode.DB介護保険, RString.EMPTY,
                        new RDate(発行日.wareki().toDateString().toString()), assembler.getImageFolderPath());
            }
        }
    }

    private ShokanKetteiTsuchiShoSealerItem toItemｼｰﾗﾀｲﾌﾟ(ShokanKetteiTsuchiShoShiharai business,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, NinshoshaSource ninshoshaSource,
            RString 文書番号, List<IAtesaki> 宛先s, int pageCount) {

        // TODO 以下全てTODO項目：QA696、設定項目と帳票項目は不一致
        return new ShokanKetteiTsuchiShoSealerItem(
                RString.EMPTY,
                // TODO 帳票制御汎用のシーラタイプタイトル１ ただし、帳票制御汎用のシーラタイプタイトル２が設定の場合Empty
                RString.EMPTY,
                文書番号,
                new RString(String.valueOf(pageCount)),
                RString.EMPTY,
                // TODO パタン番号が5であり、項目番号が1であるタイトル（ｼｰﾗﾀｲﾌﾟでEmpty）
                RString.EMPTY,
                // TODO 帳票制御汎用のシーラタイプタイトル２
                RString.EMPTY,
                business.get被保険者氏名(),
                business.get被保険者番号().value(),
                business.get被保険者氏名(),
                // TODO 通知書定型文 パタン番号が5であり、項目番号が2である通知文
                RString.EMPTY,
                business.get決定年月日() == null ? RString.EMPTY : business.get決定年月日().seireki().toDateString(),
                new RString(business.get支給額().toString()),
                batchPram.getHurikomiYMD().seireki().toDateString(),
                // TODO 給付種類1無
                RString.EMPTY,
                // TODO 対象年月1無
                business.get提供年月() == null ? RString.EMPTY : business.get提供年月().wareki().firstYear(
                        FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.ZERO).toDateString(),
                // TODO 支給額1無
                new RString(business.get支給額().toString()),
                YEN,
                // TODO 通知書定型文 パタン番号が5であり、項目番号が3である連絡先・不服申立他
                RString.EMPTY,
                // TODO 給付種類2無
                RString.EMPTY,
                // TODO 対象年月2無
                RString.EMPTY,
                // TODO 支給額2無
                RString.EMPTY,
                YEN,
                // TODO 給付種類3無
                RString.EMPTY,
                // TODO 対象年月3無
                RString.EMPTY,
                // TODO 支給額3無
                RString.EMPTY,
                YEN,
                // TODO 給付種類4無
                RString.EMPTY,
                // TODO 対象年月4無
                RString.EMPTY,
                // TODO 支給額4無
                RString.EMPTY,
                YEN,
                business.get金融機関名称(),
                business.get支店名称(),
                // TODO 種別タイトル無
                RString.EMPTY,
                business.get預金種別名称(),
                番号タイトル_口座番号,
                business.get口座番号(),
                business.get口座名義人漢字(),
                ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.ninshoshaShimeiKakeru,
                ninshoshaSource.koinShoryaku,
                business.get郵便番号(),
                // TODO 以下全て項目：送付物宛先を電算さんは見直し中
                // TODO 送付物宛先.行政区2
                RString.EMPTY,
                // TODO 送付物宛先.住所4
                RString.EMPTY,
                // TODO 送付物宛先.住所
                RString.EMPTY,
                // TODO 送付物宛先.住所5
                RString.EMPTY,
                // TODO 送付物宛先.住所6
                RString.EMPTY,
                // TODO 送付物宛先.方書
                RString.EMPTY,
                // TODO 送付物宛先.方書3
                RString.EMPTY,
                // TODO 送付物宛先.方書小2
                RString.EMPTY,
                // TODO 送付物宛先.方書4
                RString.EMPTY,
                RString.EMPTY,
                // TODO 送付物宛先.方書小1
                RString.EMPTY,
                // TODO 送付物宛先.氏名5
                RString.EMPTY,
                // TODO 送付物宛先.氏名小2
                RString.EMPTY,
                // TODO 送付物宛先.氏名
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY);
    }

    private static <T extends IReportSource, R extends Report<T>> ReportAssembler<T>
            createAssembler(IReportProperty<T> property, ReportManager manager) {

        ReportAssemblerBuilder builder = manager.reportAssembler(property.reportId().value(), property.subGyomuCode());
        for (BreakAggregator<? super T, ?> breaks : property.breakers()) {
            builder.addBreak(breaks);
        }
        builder.isHojinNo(property.containsHojinNo());
        builder.isKojinNo(property.containsKojinNo());
        return builder.<T>create();
    }

    private ShokanKetteiTsuchiShoSealer2Item toItemｼｰﾗﾀｲﾌﾟ2(ShokanKetteiTsuchiShoShiharai business,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, NinshoshaSource ninshoshaSource,
            RString 文書番号, List<IAtesaki> 宛先s, int pageCount) {

        // TODO QA696 設定項目と帳票項目は不一致
        RString 増減の理由タイトル;
        RString 種別タイトル = RString.EMPTY;
        if (ShikyuFushikyuKubun.不支給.getコード().equals(business.get支給不支給決定区分())) {
            増減の理由タイトル = 増減の理由タイトル_不支給の理由;
            if (ShiharaiHohoKubun.窓口払.getコード().equals(business.get支払方法区分コード())) {
                種別タイトル = 種別タイトル_口座種別;
            } else if (ShiharaiHohoKubun.口座払.getコード().equals(business.get支払方法区分コード())) {
                if (金融機関コード_郵便局.equals(business.get金融機関コード().value())) {
                    種別タイトル = 種別タイトル_店番;
                } else {
                    種別タイトル = 種別タイトル_口座種別;
                }
            }
        } else {
            増減の理由タイトル = 増減の理由タイトル_増減の理由;
            種別タイトル = 種別タイトル_口座種別;
        }

        RString タイトル2_2_1 = RString.EMPTY;
        RString タイトル2_2_2 = RString.EMPTY;
        RString タイトル2_3_1 = RString.EMPTY;
        RString タイトル2_3_2 = RString.EMPTY;
        if (ShikyuFushikyuKubun.支給.getコード().equals(business.get支給不支給決定区分())) {
            // TODO QA696 帳票制御汎用関連資料無
            タイトル2_2_1 = RString.EMPTY;
            タイトル2_3_1 = RString.EMPTY;
        } else {
            タイトル2_2_2 = RString.EMPTY;
            // TODO QA696 帳票制御汎用関連資料無
            タイトル2_3_2 = RString.EMPTY;
        }

        RString 被保険者番号 = business.get被保険者番号().value();
        RStringBuilder 支払窓口開始時間Builder = new RStringBuilder();
        if (!RString.isNullOrEmpty(business.get支払窓口開始時間())) {
            RTime 支払窓口開始時間 = new RTime(business.get支払窓口開始時間());
            支払窓口開始時間Builder.append(String.format("%02d", 支払窓口開始時間.getHour()));
            支払窓口開始時間Builder.append(new RString("時"));
            支払窓口開始時間Builder.append(String.format("%02d", 支払窓口開始時間.getMinute()));
            支払窓口開始時間Builder.append(new RString("分"));
            支払窓口開始時間Builder.append(String.format("%02d", 支払窓口開始時間.getSecond()));
            支払窓口開始時間Builder.append(new RString("秒"));
        }

        RStringBuilder 支払窓口終了期間Builder = new RStringBuilder();
        if (!RString.isNullOrEmpty(business.get支払窓口終了期間())) {
            RTime 支払窓口終了期間 = new RTime(business.get支払窓口終了期間());
            支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getHour()));
            支払窓口終了期間Builder.append(new RString("時"));
            支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getMinute()));
            支払窓口終了期間Builder.append(new RString("分"));
            支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getSecond()));
            支払窓口終了期間Builder.append(new RString("秒"));
        }
        RString karaFugo = RString.EMPTY;
        if (!RString.isNullOrEmpty(business.get支払窓口開始時間()) && !RString.isNullOrEmpty(business.get支払窓口終了期間())) {
            karaFugo = KARA;
        }

        RString 取消支払場所 = RString.EMPTY;
        RString 取消支払期間 = RString.EMPTY;
        if (ShiharaiHohoKubun.窓口払.getコード().equals(business.get支払方法区分コード())) {
            取消支払場所 = RString.EMPTY;
            取消支払期間 = 記号_星;
        } else if (ShiharaiHohoKubun.口座払.getコード().equals(business.get支払方法区分コード())) {
            取消支払場所 = 記号_星;
            取消支払期間 = RString.EMPTY;
        }
        // TODO 以下全てTODO項目：QA696、設定項目と帳票項目は不一致
        return new ShokanKetteiTsuchiShoSealer2Item(
                文書番号,
                business.get被保険者氏名(),
                被保険者番号.substring(ZERO, ONE),
                被保険者番号.substring(ONE, TWO),
                被保険者番号.substring(TWO, THREE),
                被保険者番号.substring(THREE, FOUR),
                被保険者番号.substring(FOUR, FIVE),
                被保険者番号.substring(FIVE, SIX),
                被保険者番号.substring(SIX, SEVEN),
                被保険者番号.substring(SEVEN, EIGHT),
                被保険者番号.substring(EIGHT, NINE),
                business.get受付年月日() == null ? RString.EMPTY : business.get受付年月日().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString(),
                business.get決定年月日() == null ? RString.EMPTY : business.get決定年月日().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString(),
                new RString(business.get本人支払額().toString()),
                business.get提供年月() == null ? RString.EMPTY : business.get提供年月().wareki().firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString(),
                business.get種類(),
                // TODO QA696 給付の種類１,2,3無
                RString.EMPTY,
                RString.EMPTY,
                ShikyuFushikyuKubun.toValue(business.get支給不支給決定区分()).get名称(),
                new RString(business.get支給額().toString()),
                // TODO QA696 増減理由１,2,3無
                business.get増減理由等(),
                RString.EMPTY,
                RString.EMPTY,
                batchPram.getShiharaiBasho(),
                business.get支払期間開始年月日() == null ? RString.EMPTY : business.get支払期間開始年月日().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString(),
                business.get支払期間終了年月日() == null ? RString.EMPTY : business.get支払期間終了年月日().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString(),
                支払窓口開始時間Builder.toRString(),
                支払窓口終了期間Builder.toRString(),
                karaFugo,
                RString.EMPTY,
                種別タイトル,
                番号タイトル_口座番号,
                ninshoshaSource.hakkoYMD,
                ninshoshaSource.denshiKoin,
                ninshoshaSource.ninshoshaYakushokuMei,
                ninshoshaSource.ninshoshaYakushokuMei1,
                ninshoshaSource.koinMojiretsu,
                ninshoshaSource.ninshoshaYakushokuMei2,
                ninshoshaSource.ninshoshaShimeiKakenai,
                ninshoshaSource.ninshoshaShimeiKakeru,
                ninshoshaSource.koinShoryaku,
                business.get郵便番号(),
                // TODO 以下全て項目：送付物宛先を電算さんは見直し中
                // TODO 送付物宛先.行政区2
                RString.EMPTY,
                // TODO 送付物宛先.住所4
                RString.EMPTY,
                // TODO 送付物宛先.住所
                RString.EMPTY,
                // TODO 送付物宛先.住所5
                RString.EMPTY,
                // TODO 送付物宛先.住所6
                RString.EMPTY,
                // TODO 送付物宛先.方書
                RString.EMPTY,
                // TODO 送付物宛先.方書3
                RString.EMPTY,
                // TODO 送付物宛先.方書小2
                RString.EMPTY,
                // TODO 送付物宛先.方書4
                RString.EMPTY,
                RString.EMPTY,
                // TODO 送付物宛先.方書小1
                RString.EMPTY,
                // TODO 送付物宛先.氏名5
                RString.EMPTY,
                // TODO 送付物宛先.氏名小2
                RString.EMPTY,
                // TODO 送付物宛先.氏名
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                // TODO QA696 帳票制御汎用関連資料無 タイトル2_1
                RString.EMPTY,
                タイトル2_2_1,
                タイトル2_2_2,
                タイトル2_3_1,
                タイトル2_3_2,
                // TODO QA696 帳票制御汎用関連資料無 タイトル2_4
                RString.EMPTY,
                business.get証記載保険者番号(),
                business.get提供年月() == null ? RString.EMPTY : business.get提供年月().wareki().firstYear(
                        FirstYear.GAN_NEN).separator(
                        Separator.NONE).fillType(FillType.NONE).toDateString(),
                RString.EMPTY,
                取消支払期間,
                増減の理由タイトル,
                business.get増減理由等(),
                // TODO QA696 帳票制御汎用関連資料無 タイトル1
                RString.EMPTY,
                // TODO QA696 帳票制御汎用関連資料無 タイトル2
                RString.EMPTY,
                new RString(String.valueOf(pageCount)),
                YEN,
                business.get被保険者氏名(),
                // TODO 通知文,情報文  通知書定型文の取得を　電算さんは見直し中
                RString.EMPTY,
                RString.EMPTY,
                RString.EMPTY,
                YEN,
                YEN,
                YEN,
                // TODO タイトル  通知書定型文の取得を　電算さんは見直し中
                RString.EMPTY,
                取消支払場所,
                business.get被保険者番号().value(),
                // TODO 送付物宛先
                RString.EMPTY);
    }
}
