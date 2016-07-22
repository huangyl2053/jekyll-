/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanbaraishikyuketteitsuchishosealertype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealer;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.daikoprint.DaikoPrintItem;
import jp.co.ndensan.reams.ur.urz.definition.report.ReportId;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.DaikoPrintFactory;
import jp.co.ndensan.reams.ur.urz.service.report.daikoprint.IDaikoPrint;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 償還払い支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ）のビジネスです。
 *
 * @reamsid_L DBC-1000-030 zuotao
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
    private static final int TEN = 10;
    private static final int 文字数_38 = 38;
    private static final int 文字数_76 = 76;
    private static final int パターン番号_5 = 5;
    private static final RString 帳票制御汎用キー_シーラタイプタイトル１ = new RString("シーラタイプタイトル１");
    private static final RString 帳票制御汎用キー_シーラタイプタイトル２ = new RString("シーラタイプタイトル２");
    private static final RString 帳票制御汎用キー_取り消し線 = new RString("取り消し線");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり１ = new RString("帳票タイトル_抹消線あり１");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり２ = new RString("帳票タイトル_抹消線あり２");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり３ = new RString("帳票タイトル_抹消線あり３");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり４ = new RString("帳票タイトル_抹消線あり４");
    private static final RString 帳票制御汎用キー_持ち物内容文言１ = new RString("持ち物内容文言１");
    private static final RString 帳票制御汎用キー_持ち物内容文言２ = new RString("持ち物内容文言２");
    private static final RString 帳票制御汎用キー_持ち物内容文言３ = new RString("持ち物内容文言３");
    private static final RString 帳票制御汎用キー_帳票タイトル = new RString("帳票タイトル");
    private static final RString 取り消し線を編集しない = new RString("0");
    private static final RString 取り消し線を編集する = new RString("1");

    /**
     * 帳票データを作成します。
     *
     * @param businessList 償還払支給（不支給）決定通知書情報Entityリスト
     * @param batchPram バッチパラメータ
     * @param reportSourceWriter ReportSourceWriter
     * @return 伝送データEntity
     */
    public TensoData createChoHyoData(List<ShokanKetteiTsuchiShoShiharai> businessList,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, ReportSourceWriter reportSourceWriter) {

        Collections.sort(businessList, new Comparator<ShokanKetteiTsuchiShoShiharai>() {
            @Override
            public int compare(ShokanKetteiTsuchiShoShiharai o1, ShokanKetteiTsuchiShoShiharai o2) {
                return getJufukuKey(o1).compareTo(getJufukuKey(o2));
            }
        });
        return 伝送データ作成(businessList, batchPram, reportSourceWriter);
    }

    private TensoData 伝送データ作成(List<ShokanKetteiTsuchiShoShiharai> businessList,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, ReportSourceWriter reportSourceWriter) {

        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(
                SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100004.getReportId(), batchPram.getHakkoYMD(),
                NinshoshaDenshikoinshubetsuCode.保険者印, reportSourceWriter);
        RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100004.getReportId(), batchPram.getHakkoYMD());

        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder 宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(batchPram.getHakkoYMD());
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(宛先builder.build());
        SofubutsuAtesakiSource atesakiSource
                = new SofubutsuAtesakiSourceBuilder(new SofubutsuAtesakiEditorBuilder(宛先).build()).buildSource();
        RString タイトル = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100002_2.getReportId(), KamokuCode.EMPTY, パターン番号_5, ONE, FlexibleDate.getNowDate());
        RString 通知文 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100002_2.getReportId(), KamokuCode.EMPTY, パターン番号_5, TWO, FlexibleDate.getNowDate());
        RString 情報文 = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100002_2.getReportId(), KamokuCode.EMPTY, パターン番号_5, THREE, FlexibleDate.getNowDate());
        List<ShokanKetteiTsuchiShoSealer> 帳票ソースデータ = new ArrayList<>();
        RString hiHokenshaNo = RString.EMPTY;
        RString key = RString.EMPTY;
        ShokanKetteiTsuchiShoSealer sealer = null;
        int count = ZERO;
        int pageCount = ZERO;
        for (ShokanKetteiTsuchiShoShiharai shiharai : businessList) {
            if (!hiHokenshaNo.equals(shiharai.get被保険者番号().value())) {
                sealer = new ShokanKetteiTsuchiShoSealer();
                帳票ソースデータ.add(sealer);
                pageCount++;
            } else {
                if (key.equals(getJufukuKey(shiharai))) {
                    continue;
                }
                if (count == FOUR) {
                    sealer = new ShokanKetteiTsuchiShoSealer();
                    帳票ソースデータ.add(sealer);
                    count = ZERO;
                    pageCount++;
                }
            }
            sealer = create帳票ソースデータ(sealer, count, ninshoshaSource, shiharai, batchPram, 文書番号, 通知文,
                    情報文, タイトル, atesakiSource, pageCount);
            count++;
            key = getJufukuKey(shiharai);
            hiHokenshaNo = shiharai.get被保険者番号().value();
        }
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
            if (batchPram.getDataTo() != null) {
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
            if (batchPram.getDataTo() != null) {
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
        // TODO 出力順関連
//        IOutputOrder outputOrder = ChohyoShutsuryokujunFinderFactory.createInstance().
//                get出力順(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100004.getReportId(),
//                        Long.parseLong(batchPram.getSyutujunId().toString()));
        List<RString> 出力順項目 = new ArrayList<>();
        List<RString> 改ページ項目 = new ArrayList<>();
//        if (outputOrder != null && outputOrder.get設定項目リスト() != null) {
//            for (ISetSortItem sortItem : outputOrder.get設定項目リスト()) {
//                出力順項目.add(sortItem.get項目ID());
//                if (sortItem.is改頁項目()) {
//                    改ページ項目.add(sortItem.get項目ID());
//                }
//            }
//        }
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        DaikoPrintItem daikoPrintItem = new DaikoPrintItem(SubGyomuCode.DBC介護給付,
                導入団体クラス.getLasdecCode_(), 導入団体クラス.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                ReportIdDBC.DBC100004.getReportName(),
                ReportId.代行プリント送付票チェックなし.value(),
                帳票名, ページ数, 抽出条件,
                出力順項目, 改ページ項目, Collections.<RString>emptyList());
        IDaikoPrint daikoPrint = DaikoPrintFactory.createInstance(daikoPrintItem);
        return new TensoData(帳票ソースデータ, daikoPrint);
    }

    private RString getJufukuKey(ShokanKetteiTsuchiShoShiharai shiharai) {
        RStringBuilder key = new RStringBuilder();
        key.append(shiharai.get被保険者番号().value());
        key.append(shiharai.get提供年月().wareki().toDateString());
        key.append(shiharai.getサービス種類コード());
        key.append(shiharai.get整理番号().padLeft(new RString(ZERO), TEN));
        return key.toRString();
    }

    private ShokanKetteiTsuchiShoSealer create帳票ソースデータ(ShokanKetteiTsuchiShoSealer ketteiTsuchiShoSealer, int count,
            NinshoshaSource ninshoshaSource, ShokanKetteiTsuchiShoShiharai business, ShokanKetteiTsuchiShoSealerBatchParameter batchPram,
            RString 文書番号, RString 通知文, RString 情報文, RString タイトル, SofubutsuAtesakiSource atesaki, int pageCount) {

        ketteiTsuchiShoSealer = setJuhuku(ketteiTsuchiShoSealer, count, business);
        ketteiTsuchiShoSealer.setPage(new RString(String.valueOf(pageCount)));
        if (ZERO < count) {
            Decimal 支給額 = new Decimal(ketteiTsuchiShoSealer.getShikyuGaku().toString()).add(business.get支給額() == null
                    ? Decimal.ZERO : business.get支給額());
            ketteiTsuchiShoSealer.setShikyuGaku(new RString(支給額.toString()));
            return ketteiTsuchiShoSealer;
        }
        ketteiTsuchiShoSealer.setShikyuGaku(nullToZero(business.get支給額()));
        RString 種別タイトル = get種別タイトル(business);
        RString 増減の理由タイトル;
        if (ShikyuFushikyuKubun.不支給.getコード().equals(business.get支給不支給決定区分())) {
            増減の理由タイトル = 増減の理由タイトル_不支給の理由;
        } else {
            増減の理由タイトル = 増減の理由タイトル_増減の理由;
        }
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        RString タイトル1 = RString.EMPTY;
        RString タイトル2 = RString.EMPTY;
        if (RString.isNullOrEmpty(タイトル)) {
            タイトル2 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_シーラタイプタイトル２);
        }
        if (RString.isNullOrEmpty(タイトル2)) {
            タイトル1 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_シーラタイプタイトル１);
        }
        RString タイトル2_1 = RString.EMPTY;
        RString タイトル2_2_1 = RString.EMPTY;
        RString タイトル2_2_2 = RString.EMPTY;
        RString タイトル2_3_1 = RString.EMPTY;
        RString タイトル2_3_2 = RString.EMPTY;
        RString タイトル2_4 = RString.EMPTY;
        RString 取り消し線 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_取り消し線);
        if (取り消し線を編集しない.equals(取り消し線)) {
            タイトル = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル);
        } else if (取り消し線を編集する.equals(取り消し線)) {
            タイトル2_1 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり１);
            タイトル2_4 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり４);
            if (ShikyuFushikyuKubun.支給.getコード().equals(business.get支給不支給決定区分())) {
                タイトル2_2_1 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり２);
                タイトル2_3_2 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり３);
            } else {
                タイトル2_2_2 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり２);
                タイトル2_3_1 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり３);
            }
        }
        ketteiTsuchiShoSealer.setTitle1(タイトル1);
        ketteiTsuchiShoSealer.setTitle2(タイトル2);
        ketteiTsuchiShoSealer.setTitle(タイトル);
        ketteiTsuchiShoSealer.setTitle2_1(タイトル2_1);
        ketteiTsuchiShoSealer.setTitle2_2_1(タイトル2_2_1);
        ketteiTsuchiShoSealer.setTitle2_2_2(タイトル2_2_2);
        ketteiTsuchiShoSealer.setTitle2_3_1(タイトル2_3_1);
        ketteiTsuchiShoSealer.setTitle2_3_2(タイトル2_3_2);
        ketteiTsuchiShoSealer.setTitle2_4(タイトル2_4);
        ketteiTsuchiShoSealer.setBunshoNo(文書番号);
        ketteiTsuchiShoSealer.setHihokenshaName(business.get被保険者氏名());
        RString 被保険者番号 = business.get被保険者番号().value();
        ketteiTsuchiShoSealer.setHihokenshaNo(被保険者番号);
        ketteiTsuchiShoSealer.setUketsukeYMD(business.get受付年月日() == null ? RString.EMPTY : business.get受付年月日().wareki().eraType(
                EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ketteiTsuchiShoSealer.setKetteiYMD(business.get決定年月日() == null ? RString.EMPTY : business.get決定年月日().wareki().eraType(
                EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ketteiTsuchiShoSealer.setKekka(ShikyuFushikyuKubun.toValue(business.get支給不支給決定区分()).get名称());
        ketteiTsuchiShoSealer = set増減の理由(ketteiTsuchiShoSealer, business.get増減理由等());
        ketteiTsuchiShoSealer.setShiharaiBasho(batchPram.getShiharaiBasho());
        ketteiTsuchiShoSealer.setShiharaiStartYMD(business.get支払期間開始年月日() == null
                ? RString.EMPTY : business.get支払期間開始年月日().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ketteiTsuchiShoSealer.setShiharaiEndYMD(business.get支払期間終了年月日() == null
                ? RString.EMPTY : business.get支払期間終了年月日().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
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
        ketteiTsuchiShoSealer.setShiharaiStartHMS(支払窓口開始時間Builder.toRString());
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
        ketteiTsuchiShoSealer.setShiharaiEndHMS(支払窓口終了期間Builder.toRString());
        if (!RString.isNullOrEmpty(business.get支払窓口開始時間()) && !RString.isNullOrEmpty(business.get支払窓口終了期間())) {
            ketteiTsuchiShoSealer.setKaraFugo(KARA);
        }
        ketteiTsuchiShoSealer.setBankName(business.get金融機関名称());
        ketteiTsuchiShoSealer.setBranchBankName(business.get支店名称());
        ketteiTsuchiShoSealer.setKouzaShu(business.get預金種別名称());
        ketteiTsuchiShoSealer.setKouzaNo(business.get口座番号());
        ketteiTsuchiShoSealer.setKouzaMeigi(business.get口座名義人漢字());
        ketteiTsuchiShoSealer.setShiharaiYoteiYMD(batchPram.getHurikomiYMD() == null
                ? RString.EMPTY : batchPram.getHurikomiYMD().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        ketteiTsuchiShoSealer.set整理番号(business.get整理番号());
        ketteiTsuchiShoSealer.set決定通知書番号(business.get決定通知No());
        ketteiTsuchiShoSealer.setTsuban(RString.EMPTY);
        ketteiTsuchiShoSealer.setHihokenshaName2(business.get被保険者氏名());
        ketteiTsuchiShoSealer.setTsuchibun1(通知文);
        ketteiTsuchiShoSealer.setInfo(情報文);
        ketteiTsuchiShoSealer.setYen1(YEN);
        ketteiTsuchiShoSealer.setYen2(YEN);
        ketteiTsuchiShoSealer.setYen3(YEN);
        ketteiTsuchiShoSealer.setYen4(YEN);
        ketteiTsuchiShoSealer.setRiyuTitle(増減の理由タイトル);
        ketteiTsuchiShoSealer.setShumokuTitle(種別タイトル);
        ketteiTsuchiShoSealer.setBangoTitle(番号タイトル_口座番号);
        ketteiTsuchiShoSealer.setMochimono1(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_持ち物内容文言１));
        ketteiTsuchiShoSealer.setMochimono2(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_持ち物内容文言２));
        ketteiTsuchiShoSealer.setMochimono3(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_持ち物内容文言３));
        RString temp_被保険者番号 = 被保険者番号.padRight(RString.HALF_SPACE, TEN);
        ketteiTsuchiShoSealer.setHihokenshaNo1(temp_被保険者番号.substring(ZERO, ONE));
        ketteiTsuchiShoSealer.setHihokenshaNo2(temp_被保険者番号.substring(ONE, TWO));
        ketteiTsuchiShoSealer.setHihokenshaNo3(temp_被保険者番号.substring(TWO, THREE));
        ketteiTsuchiShoSealer.setHihokenshaNo4(temp_被保険者番号.substring(THREE, FOUR));
        ketteiTsuchiShoSealer.setHihokenshaNo5(temp_被保険者番号.substring(FOUR, FIVE));
        ketteiTsuchiShoSealer.setHihokenshaNo6(temp_被保険者番号.substring(FIVE, SIX));
        ketteiTsuchiShoSealer.setHihokenshaNo7(temp_被保険者番号.substring(SIX, SEVEN));
        ketteiTsuchiShoSealer.setHihokenshaNo8(temp_被保険者番号.substring(SEVEN, EIGHT));
        ketteiTsuchiShoSealer.setHihokenshaNo9(temp_被保険者番号.substring(EIGHT, NINE));
        ketteiTsuchiShoSealer.setHihokenshaNo10(temp_被保険者番号.substring(NINE));
        return setKetteiTsuchiShoSealer(ketteiTsuchiShoSealer, ninshoshaSource, business, atesaki);
    }

    private RString get種別タイトル(ShokanKetteiTsuchiShoShiharai business) {
        if (!ShikyuFushikyuKubun.不支給.getコード().equals(business.get支給不支給決定区分())) {
            return 種別タイトル_口座種別;
        }
        RString 種別タイトル = RString.EMPTY;
        if (ShiharaiHohoKubun.窓口払.getコード().equals(business.get支払方法区分コード())) {
            種別タイトル = 種別タイトル_口座種別;
        } else if (ShiharaiHohoKubun.口座払.getコード().equals(business.get支払方法区分コード())) {
            if (金融機関コード_郵便局.equals(business.get金融機関コード().value())) {
                種別タイトル = 種別タイトル_店番;
            } else {
                種別タイトル = 種別タイトル_口座種別;
            }
        }
        return 種別タイトル;
    }

    private RString get帳票制御汎用(ChohyoSeigyoHanyoManager 帳票制御汎用Manager, RString 項目名) {
        RString 設定値 = RString.EMPTY;
        ChohyoSeigyoHanyo chohyoSeigyoHanyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100004.getReportId(),
                FlexibleYear.MIN, 項目名);
        if (chohyoSeigyoHanyo != null) {
            設定値 = chohyoSeigyoHanyo.get設定値();
        }
        return 設定値;
    }

    private ShokanKetteiTsuchiShoSealer setKetteiTsuchiShoSealer(ShokanKetteiTsuchiShoSealer ketteiTsuchiShoSealer,
            NinshoshaSource ninshoshaSource, ShokanKetteiTsuchiShoShiharai business, SofubutsuAtesakiSource atesaki) {

        ketteiTsuchiShoSealer.setHakkoYMD(ninshoshaSource.hakkoYMD);
        ketteiTsuchiShoSealer.setDenshiKoin(ninshoshaSource.denshiKoin);
        ketteiTsuchiShoSealer.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
        ketteiTsuchiShoSealer.setNinshoshaYakushokuMei1(ninshoshaSource.ninshoshaYakushokuMei1);
        ketteiTsuchiShoSealer.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
        ketteiTsuchiShoSealer.setNinshoshaYakushokuMei2(ninshoshaSource.ninshoshaYakushokuMei2);
        ketteiTsuchiShoSealer.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
        ketteiTsuchiShoSealer.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
        ketteiTsuchiShoSealer.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        ketteiTsuchiShoSealer.setYubinNo(atesaki.yubinNo);
        ketteiTsuchiShoSealer.setGyoseiku1(atesaki.gyoseiku);
        ketteiTsuchiShoSealer.setGyoseiku2(atesaki.gyoseiku);
        ketteiTsuchiShoSealer.setJusho4(atesaki.jusho1);
        ketteiTsuchiShoSealer.setJushoText(atesaki.jushoText);
        ketteiTsuchiShoSealer.setJusho5(atesaki.jusho2);
        ketteiTsuchiShoSealer.setJusho6(atesaki.jusho3);
        ketteiTsuchiShoSealer.setKatagakiText(atesaki.katagakiText);
        ketteiTsuchiShoSealer.setKatagaki3(atesaki.katagaki1);
        ketteiTsuchiShoSealer.setKatagaki4(atesaki.katagaki2);
        ketteiTsuchiShoSealer.setKatagakiSmall2(atesaki.katagakiSmall2);
        ketteiTsuchiShoSealer.setKatagakiSmall1(atesaki.katagakiSmall1);
        ketteiTsuchiShoSealer.setShimeiSmall2(atesaki.shimeiSmall2);
        ketteiTsuchiShoSealer.setShimeiText(atesaki.shimeiText);
        ketteiTsuchiShoSealer.setMeishoFuyo2(atesaki.meishoFuyo2);
        ketteiTsuchiShoSealer.setShimeiSmall1(atesaki.shimeiSmall1);
        ketteiTsuchiShoSealer.setDainoKubunMei(atesaki.dainoKubunMei);
        ketteiTsuchiShoSealer.setShimei5(atesaki.shimei1);
        ketteiTsuchiShoSealer.setShimei6(atesaki.shimei2);
        ketteiTsuchiShoSealer.setMeishoFuyo1(atesaki.meishoFuyo1);
        ketteiTsuchiShoSealer.setSamabunShimeiText(atesaki.samabunShimeiText);
        ketteiTsuchiShoSealer.setSamaBun2(atesaki.samaBun2);
        ketteiTsuchiShoSealer.setKakkoLeft2(atesaki.kakkoLeft2);
        ketteiTsuchiShoSealer.setSamabunShimei2(atesaki.samabunShimei2);
        ketteiTsuchiShoSealer.setSamabunShimeiSmall2(atesaki.samabunShimeiSmall2);
        ketteiTsuchiShoSealer.setKakkoRight2(atesaki.kakkoRight2);
        ketteiTsuchiShoSealer.setKakkoLeft1(atesaki.kakkoLeft1);
        ketteiTsuchiShoSealer.setSamabunShimei1(atesaki.samabunShimei1);
        ketteiTsuchiShoSealer.setSamaBun1(atesaki.samaBun1);
        ketteiTsuchiShoSealer.setKakkoRight1(atesaki.kakkoRight1);
        ketteiTsuchiShoSealer.setSamabunShimeiSmall1(atesaki.samabunShimeiSmall1);
        ketteiTsuchiShoSealer.setCustomerBarCode(atesaki.customerBarCode);
        ketteiTsuchiShoSealer.setShoHokenshaNo(business.get証記載保険者番号().value());
        // TODO QA1101 サービス年月の設定不明
        ketteiTsuchiShoSealer.setServiceYM(business.get提供年月() == null ? RString.EMPTY : business.get提供年月().seireki().
                separator(Separator.NONE).fillType(FillType.NONE).toDateString());
        ketteiTsuchiShoSealer.setTsuban2(RString.EMPTY);
        if (ShiharaiHohoKubun.窓口払.getコード().equals(business.get支払方法区分コード())) {
            ketteiTsuchiShoSealer.setTorikeshi1(RString.EMPTY);
            ketteiTsuchiShoSealer.setTorikeshi2(RString.EMPTY);
            ketteiTsuchiShoSealer.setTorikeshiMochimono1(RString.EMPTY);
            ketteiTsuchiShoSealer.setTorikeshiMochimono2(RString.EMPTY);
            ketteiTsuchiShoSealer.setTorikeshiShiharaibasho(RString.EMPTY);
            ketteiTsuchiShoSealer.setTorikeshiShiharaikikan(RString.EMPTY);
        } else if (ShiharaiHohoKubun.口座払.getコード().equals(business.get支払方法区分コード())) {
            ketteiTsuchiShoSealer.setTorikeshi1(記号_星);
            ketteiTsuchiShoSealer.setTorikeshi2(記号_星);
            ketteiTsuchiShoSealer.setTorikeshiMochimono1(記号_星);
            ketteiTsuchiShoSealer.setTorikeshiMochimono2(記号_星);
            ketteiTsuchiShoSealer.setTorikeshiShiharaibasho(記号_星);
            ketteiTsuchiShoSealer.setTorikeshiShiharaikikan(記号_星);
        }
        return ketteiTsuchiShoSealer;
    }

    private RString nullToZero(Decimal dec) {
        if (dec == null) {
            dec = Decimal.ZERO;
        }
        return new RString(dec.toString());
    }

    private ShokanKetteiTsuchiShoSealer setJuhuku(ShokanKetteiTsuchiShoSealer ketteiTsuchiShoSealer, int count,
            ShokanKetteiTsuchiShoShiharai business) {
        if (count == ZERO) {
            ketteiTsuchiShoSealer.setKyufuShurui1(business.get種類());
            ketteiTsuchiShoSealer.setTaishoYM1(business.get提供年月() == null ? RString.EMPTY : business.get提供年月().wareki().eraType(
                    EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            ketteiTsuchiShoSealer.setShikyuGaku1(nullToZero(business.get支給額()));
        } else if (count == ONE) {
            ketteiTsuchiShoSealer.setKyufuShurui2(business.get種類());
            ketteiTsuchiShoSealer.setTaishoYM2(business.get提供年月() == null ? RString.EMPTY : business.get提供年月().wareki().eraType(
                    EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            ketteiTsuchiShoSealer.setShikyuGaku2(nullToZero(business.get支給額()));
        } else if (count == TWO) {
            ketteiTsuchiShoSealer.setKyufuShurui3(business.get種類());
            ketteiTsuchiShoSealer.setTaishoYM3(business.get提供年月() == null ? RString.EMPTY : business.get提供年月().wareki().eraType(
                    EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            ketteiTsuchiShoSealer.setShikyuGaku3(nullToZero(business.get支給額()));
        } else if (count == THREE) {
            ketteiTsuchiShoSealer.setKyufuShurui4(business.get種類());
            ketteiTsuchiShoSealer.setTaishoYM4(business.get提供年月() == null ? RString.EMPTY : business.get提供年月().wareki().eraType(
                    EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
            ketteiTsuchiShoSealer.setShikyuGaku4(nullToZero(business.get支給額()));
        }
        return ketteiTsuchiShoSealer;
    }

    private ShokanKetteiTsuchiShoSealer set増減の理由(ShokanKetteiTsuchiShoSealer ketteiTsuchiShoSealer, RString 増減の理由) {
        if (RString.isNullOrEmpty(増減の理由) || 増減の理由.length() <= 文字数_38) {
            ketteiTsuchiShoSealer.setRiyu1(増減の理由);
        } else if (増減の理由.length() <= 文字数_76) {
            ketteiTsuchiShoSealer.setRiyu1(増減の理由.substring(ZERO, 文字数_38));
            ketteiTsuchiShoSealer.setRiyu2(増減の理由.substring(文字数_38));
        } else {
            ketteiTsuchiShoSealer.setRiyu1(増減の理由.substring(ZERO, 文字数_38));
            ketteiTsuchiShoSealer.setRiyu2(増減の理由.substring(文字数_38, 文字数_76));
            ketteiTsuchiShoSealer.setRiyu3(RString.EMPTY);
        }
        return ketteiTsuchiShoSealer;
    }
}
