/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.CharacteristicsPhase;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.SpecialIncomeInformation;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuSanshutsuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 保険料納入通知書（本算定）【ブックタイプ】（口振依頼あり）通知書 HokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor
 *
 * @reamsid_L DBB-9110-010 huangh
 */
public class HokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor implements IHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final NinshoshaSource ninshoshaSource;
    private static final int INT6 = 6;
    private static final int LIST_SIZE_1 = 1;
    private static final int LIST_SIZE_2 = 2;
    private static final int LIST_SIZE_3 = 3;
    private static final int LIST_SIZE_4 = 4;
    private static final int LIST_SIZE_5 = 5;
    private static final int LIST_SIZE_6 = 6;
    private static final int LIST_SIZE_7 = 7;
    private static final int LIST_SIZE_8 = 8;
    private static final int LIST_SIZE_9 = 9;
    private static final int LIST_SIZE_10 = 10;

    private static final RString EN = new RString("円");
    private static final RString TSUGIKI_IKOU = new RString("次期以降");

    /**
     * コンストラクタです。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource ninshoshaSource
     */
    protected HokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor(
            HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            NinshoshaSource ninshoshaSource) {
        this.本算定納入通知書情報 = 本算定納入通知書情報;
        this.編集後本算定通知書共通情報 = null == 本算定納入通知書情報.get編集後本算定通知書共通情報()
                ? new EditedHonSanteiTsuchiShoKyotsu() : 本算定納入通知書情報.get編集後本算定通知書共通情報();
        this.本算定納入通知書制御情報 = null == 本算定納入通知書情報.get本算定納入通知書制御情報()
                ? new HonSanteiNonyuTsuchiShoSeigyoJoho() : 本算定納入通知書情報.get本算定納入通知書制御情報();
        this.納入通知書期情報リスト = null == 本算定納入通知書情報.get納入通知書期情報リスト()
                ? new ArrayList<NonyuTsuchiShoKiJoho>() : 本算定納入通知書情報.get納入通知書期情報リスト();
        this.ninshoshaSource = ninshoshaSource;
    }

    /**
     * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書構造体編集
     *
     * @param source 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書構造体
     * @return NonyuTsuchishoBookFuriKaeAriCoverSource
     */
    @Override
    public HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource edit(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        source.layoutBreakItem = 1;
        editレイヤ１(source);
        editCompNinshosha(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editレイヤ１(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = 本算定納入通知書制御情報.get納入通知書制御情報();
        if (null == 納入通知書制御情報) {
            納入通知書制御情報 = new NonyuTsuchiShoSeigyoJoho();
        }
        NofugakuSanshutsuHoho 納付額算出方法 = 納入通知書制御情報.get納付額算出方法();
        boolean isバッチ = ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分());
        source.cover_keisanMeisaishoNendo = 半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.cover_titleNendo = 半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        HyojiCodes 表示コード = 編集後本算定通知書共通情報.get表示コード();
        if (表示コード != null) {
            source.cover_hyojicodeName1 = 表示コード.get表示コード名１();
            source.cover_hyojicodeName2 = 表示コード.get表示コード名２();
            source.cover_hyojicodeName3 = 表示コード.get表示コード名３();
            source.cover_hyojicode1 = 表示コード.get表示コード１();
            source.cover_hyojicode2 = 表示コード.get表示コード２();
            source.cover_hyojicode3 = 表示コード.get表示コード３();
        }
        if (編集後本算定通知書共通情報.get通知書番号() != null) {
            source.cover_tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
            source.cover_keisanMeisaishoTsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        }
        EditedKojin 編集後個人 = 編集後本算定通知書共通情報.get編集後個人();
        EditedKoza 編集後口座 = 編集後本算定通知書共通情報.get編集後口座();
        edit編集後個人And編集後口座(source, 編集後個人, 編集後口座);
        this.edit期月情報(source);

        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = 編集後本算定通知書共通情報.get更正後();
        if (更正後 != null) {
            source.cover_keisanMeisaishoTsukiSu = 半角to全角(更正後.get月数_ケ月());
            source.cover_keisanMeisaishoKaishiKi = 更正後.get期間_自();
            source.cover_kaisanMeisaishoShuryoKi = 更正後.get期間_至();
            source.cover_keisanMeisaishoShotokuDankai = 半角to全角(更正後.get保険料段階());
            source.cover_kaisanHokenryoRitsu = decimalFormatter_toコンマ区切りRString(更正後.get保険料率(), 0);
            source.cover_keisanMeisaishoCalHokenryoGaku = decimalFormatter_toコンマ区切りRString(更正後.get減免前保険料_年額(), 0);
            source.cover_keisanMeisaishoGenmenGaku = decimalFormatter_toコンマ区切りRString(更正後.get減免額(), 0);
            source.cover_keisanMeisaishoTokuchoGokeiGaku = decimalFormatter_toコンマ区切りRString(更正後.get特別徴収額合計(), 0);
            source.cover_kaisanMeisaishoFuchoGokeiGaku = decimalFormatter_toコンマ区切りRString(更正後.get普通徴収額合計(), 0);
            source.cover_keisanMeisaishoHokenryoGokeiGaku = decimalFormatter_toコンマ区切りRString(更正後.get確定保険料_年額(), 0);
        }
        if (NofugakuSanshutsuHoho.収入額をもとに算出.equals(納付額算出方法)) {
            source.cover_kaisanMeisaishoNofuZumiGaku
                    = decimalFormatter_toコンマ区切りRString(編集後本算定通知書共通情報.get普徴納付済額_未到来期含む(), 0);
            source.cover_keisanMeisaishoKongoNofuGaku
                    = decimalFormatter_toコンマ区切りRString(編集後本算定通知書共通情報.get普徴今後納付すべき額_調定元に(), 0);
        } else if (NofugakuSanshutsuHoho.調定額をもとに算出.equals(納付額算出方法)) {
            source.cover_kaisanMeisaishoNofuZumiGaku
                    = decimalFormatter_toコンマ区切りRString(編集後本算定通知書共通情報.get普徴既に納付すべき額(), 0);
            source.cover_keisanMeisaishoKongoNofuGaku
                    = decimalFormatter_toコンマ区切りRString(編集後本算定通知書共通情報.get普徴今後納付すべき額_収入元に(), 0);
        }
        source.cover_yen1 = EN;
        source.cover_yen2 = EN;
        if (納入通知書期情報リスト.get(0) != null) {
            source.cover_keisanMeisaishoKiTitle1
                    = new RString("第").concat(new RString(納入通知書期情報リスト.get(0).get期())).concat(new RString("期"));
            source.cover_keisanMeisaishoKibetsuNofuGaku1 = 納入通知書期情報リスト.get(0).get調定額表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_2
                && 納入通知書期情報リスト.get(LIST_SIZE_1).get期() > 0) {
            source.cover_keisanMeisaishoKiTitle3 = TSUGIKI_IKOU;
            source.cover_keisanMeisaishoKibetsuNofuGaku3 = 納入通知書期情報リスト.get(LIST_SIZE_1).get調定額表記();
        }
        source.cover_yen3 = EN;
        source.cover_yen4 = EN;
        source.cover_keisanmeisaishoNendo2 = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        source.cover_pagerenban1 = isバッチ ? new RString(本算定納入通知書情報.get連番()).concat(new RString("-1")) : new RString("1-1");
        source.cover_pagerenban2 = isバッチ ? new RString(本算定納入通知書情報.get連番()).concat(new RString("-2")) : new RString("1-2");
        source.cover_nokibetsuMeisaishoNendo = 半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.cover_nokibetsuMeisaishoTsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();

        this.edit特徴額(source);

        this.edit納期別明細書の表記(source);

        if (編集後本算定通知書共通情報.get識別コード() != null) {
            source.cover_kozaIraishoLeftShikibetsuCode = 編集後本算定通知書共通情報.get識別コード().value();
            source.cover_kozaIraishoRightShikibetsuCode = 編集後本算定通知書共通情報.get識別コード().value();
        }
        source.cover_renban = isバッチ ? new RString(本算定納入通知書情報.get連番()).padLeft("0", INT6) : RString.EMPTY;
        source.cover_hokenshaName = 編集後本算定通知書共通情報.get保険者名();
        source.cover_pagerenban3 = isバッチ ? new RString(本算定納入通知書情報.get連番()).concat(new RString("-3")) : new RString("1-3");
        source.cover_pagerenban4 = isバッチ ? new RString(本算定納入通知書情報.get連番()).concat(new RString("-4")) : new RString("1-4");
    }

    private RString decimalFormatter_toコンマ区切りRString(Decimal 額, int count) {
        if (null == 額) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(額, count);
    }

    private RString 半角to全角(RString 半角) {
        if (null == 半角) {
            return RString.EMPTY;
        }
        return RStringUtil.convert半角to全角(半角);
    }

    private Decimal rstringToDecimal(RString 変更元) {
        if (null == 変更元) {
            return Decimal.ZERO;
        }
        return new Decimal(変更元.toString());
    }

    private void edit編集後個人And編集後口座(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource source,
            EditedKojin 編集後個人, EditedKoza 編集後口座) {
        if (編集後個人 != null) {
            if (編集後個人.get世帯コード() != null) {
                source.cover_setaiCode = 編集後個人.get世帯コード().value();
                source.cover_keisanMeisaishoSetaiCode = 編集後個人.get世帯コード().value();
                source.cover_nokibetsuMeisaishoSetaiCode = 編集後個人.get世帯コード().value();
            }
            if (編集後個人.get名称() != null
                    && 編集後個人.get名称().getName() != null) {
                source.cover_kaisanMeisaishoHihokenshaName = 編集後個人.get名称().getName().value();
                source.cover_kozaIraishoLeftHihokenshaName = 編集後個人.get名称().getName().value();
                source.cover_kozaIraishoRightHihokenshaName = 編集後個人.get名称().getName().value();
                source.cover_nokibetsuMeisaishoHohokenshaName = 編集後個人.get名称().getName().value();
            }
            if (編集後個人.get世帯主名() != null) {
                source.cover_kaisanMeisaishoSetaiNushiName = 編集後個人.get世帯主名().value();
            }

            source.cover_kozaIraishoLeftJusho = 編集後個人.get編集後住所();
            source.cover_kozaIraishoRightJusho = 編集後個人.get編集後住所();
        }
        if (編集後口座 != null) {
            source.cover_bankCode = 編集後口座.get金融機関コードCombinedWith支店コード();
            source.cover_kozaShurui = 編集後口座.get口座種別略称();
            source.cover_kozaNo = 編集後口座.get口座番号Or通帳記号番号();
            source.cover_bankName = 編集後口座.get金融機関名CombinedWith支店名();
            source.cover_kozaMeiginin = 編集後口座.get口座名義人優先();
        }
    }

    private void editCompNinshosha(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        source.cover_denshiKoin = ninshoshaSource.denshiKoin;
        source.cover_hakkoYMD = ninshoshaSource.hakkoYMD;
        source.cover_ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.cover_ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.cover_koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.cover_ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.cover_ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.cover_ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        source.cover_koinShoryaku = ninshoshaSource.koinShoryaku;
    }

    private void editCompSofubutsuAtesaki(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        EditedAtesaki 編集後宛先 = 編集後本算定通知書共通情報.get編集後宛先();
        KaigoSofubutsuAtesakiSource kaigoSofubutsuAtesakiSource = null;
        if (編集後宛先 != null) {
            kaigoSofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
        }
        if (kaigoSofubutsuAtesakiSource != null) {
            SofubutsuAtesakiSource sofubutsuAtesakiSource = kaigoSofubutsuAtesakiSource.get送付物宛先ソース();
            if (sofubutsuAtesakiSource != null) {
                source.cover_customerBarCode = sofubutsuAtesakiSource.customerBarCode;
                source.cover_dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
                source.cover_gyoseiku = sofubutsuAtesakiSource.gyoseiku;
                source.cover_jusho1 = sofubutsuAtesakiSource.jusho1;
                source.cover_jusho2 = sofubutsuAtesakiSource.jusho2;
                source.cover_jusho3 = sofubutsuAtesakiSource.jusho3;
                source.cover_jushoText = sofubutsuAtesakiSource.jushoText;
                source.cover_kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
                source.cover_kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
                source.cover_kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
                source.cover_kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
                source.cover_katagaki1 = sofubutsuAtesakiSource.katagaki1;
                source.cover_katagaki2 = sofubutsuAtesakiSource.katagaki2;
                source.cover_katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
                source.cover_katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
                source.cover_katagakiText = sofubutsuAtesakiSource.katagakiText;
                source.cover_meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
                source.cover_meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
                source.cover_samaBun1 = sofubutsuAtesakiSource.samaBun1;
                source.cover_samaBun2 = sofubutsuAtesakiSource.samaBun2;
                source.cover_samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
                source.cover_samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
                source.cover_samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
                source.cover_samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
                source.cover_samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
                source.cover_shimei1 = sofubutsuAtesakiSource.shimei1;
                source.cover_shimei2 = sofubutsuAtesakiSource.shimei2;
                source.cover_shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
                source.cover_shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
                source.cover_shimeiText = sofubutsuAtesakiSource.shimeiText;
                source.cover_yubinNo = sofubutsuAtesakiSource.yubinNo;
                // TODO 世帯主名 setainusimei 共通部品から設定する
                // TODO 様方 samaKata 共通部品から設定する
            }
        }
    }

    private void edit期月情報(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        if (納入通知書期情報リスト == null) {
            return;
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_1) {
            source.cover_keisanMeisaishoKi1 = 納入通知書期情報リスト.get(0).get期表記();
            source.cover_keisanMeisaishoTsuki1 = 納入通知書期情報リスト.get(0).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi1 = 納入通知書期情報リスト.get(0).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo1 = 納入通知書期情報リスト.get(0).get納期終了日表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_2) {
            source.cover_keisanMeisaishoKi2 = 納入通知書期情報リスト.get(LIST_SIZE_1).get期表記();
            source.cover_keisanMeisaishoTsuki2 = 納入通知書期情報リスト.get(LIST_SIZE_1).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi2 = 納入通知書期情報リスト.get(LIST_SIZE_1).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo2 = 納入通知書期情報リスト.get(LIST_SIZE_1).get納期終了日表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_3) {
            source.cover_keisanMeisaishoKi3 = 納入通知書期情報リスト.get(LIST_SIZE_2).get期表記();
            source.cover_keisanMeisaishoTsuki3 = 納入通知書期情報リスト.get(LIST_SIZE_2).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi3 = 納入通知書期情報リスト.get(LIST_SIZE_2).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo3 = 納入通知書期情報リスト.get(LIST_SIZE_2).get納期終了日表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_4) {
            source.cover_keisanMeisaishoKi4 = 納入通知書期情報リスト.get(LIST_SIZE_3).get期表記();
            source.cover_keisanMeisaishoTsuki4 = 納入通知書期情報リスト.get(LIST_SIZE_3).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi4 = 納入通知書期情報リスト.get(LIST_SIZE_3).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo4 = 納入通知書期情報リスト.get(LIST_SIZE_3).get納期終了日表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_5) {
            source.cover_keisanMeisaishoKi5 = 納入通知書期情報リスト.get(LIST_SIZE_4).get期表記();
            source.cover_keisanMeisaishoTsuki5 = 納入通知書期情報リスト.get(LIST_SIZE_4).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi5 = 納入通知書期情報リスト.get(LIST_SIZE_4).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo5 = 納入通知書期情報リスト.get(LIST_SIZE_4).get納期終了日表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_6) {
            source.cover_keisanMeisaishoKi6 = 納入通知書期情報リスト.get(LIST_SIZE_5).get期表記();
            source.cover_keisanMeisaishoTsuki6 = 納入通知書期情報リスト.get(LIST_SIZE_5).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi6 = 納入通知書期情報リスト.get(LIST_SIZE_5).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo6 = 納入通知書期情報リスト.get(LIST_SIZE_5).get納期終了日表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_7) {
            source.cover_keisanMeisaishoKi7 = 納入通知書期情報リスト.get(LIST_SIZE_6).get期表記();
            source.cover_keisanMeisaishoTsuki7 = 納入通知書期情報リスト.get(LIST_SIZE_6).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi7 = 納入通知書期情報リスト.get(LIST_SIZE_6).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo7 = 納入通知書期情報リスト.get(LIST_SIZE_6).get納期終了日表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_8) {
            source.cover_keisanMeisaishoKi8 = 納入通知書期情報リスト.get(LIST_SIZE_7).get期表記();
            source.cover_keisanMeisaishoTsuki8 = 納入通知書期情報リスト.get(LIST_SIZE_7).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi8 = 納入通知書期情報リスト.get(LIST_SIZE_7).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo8 = 納入通知書期情報リスト.get(LIST_SIZE_7).get納期終了日表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_9) {
            source.cover_keisanMeisaishoKi9 = 納入通知書期情報リスト.get(LIST_SIZE_8).get期表記();
            source.cover_keisanMeisaishoTsuki9 = 納入通知書期情報リスト.get(LIST_SIZE_8).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi9 = 納入通知書期情報リスト.get(LIST_SIZE_8).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo9 = 納入通知書期情報リスト.get(LIST_SIZE_8).get納期終了日表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_10) {
            source.cover_keisanMeisaishoKi10 = 納入通知書期情報リスト.get(LIST_SIZE_9).get期表記();
            source.cover_keisanMeisaishoTsuki10 = 納入通知書期情報リスト.get(LIST_SIZE_9).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi10 = 納入通知書期情報リスト.get(LIST_SIZE_9).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo10 = 納入通知書期情報リスト.get(LIST_SIZE_9).get納期終了日表記();
        }
    }

    private void edit特徴額(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource source) {

        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = 編集後本算定通知書共通情報.get更正後();
        Decimal 納期別明細書特徴納付額１ = Decimal.ZERO;
        Decimal 納期別明細書特徴納付額２ = Decimal.ZERO;
        Decimal 納期別明細書特徴納付額３ = Decimal.ZERO;
        Decimal 納期別明細書特徴納付済額１ = Decimal.ZERO;
        Decimal 納期別明細書特徴納付済額２ = Decimal.ZERO;
        Decimal 納期別明細書特徴納付済額３ = Decimal.ZERO;

        if (更正後 != null) {
            for (CharacteristicsPhase 特徴期別金額情報 : 更正後.get特徴期別金額リスト()) {
                if (new RString("4").equals(特徴期別金額情報.get期())) {
                    納期別明細書特徴納付額１ = 特徴期別金額情報.get金額();
                    source.cover_nokibetsuMeisaishoTokuchoNofuGaku1 = decimalFormatter_toコンマ区切りRString(納期別明細書特徴納付額１, 0);
                }
                if (new RString("5").equals(特徴期別金額情報.get期())) {
                    納期別明細書特徴納付額２ = 特徴期別金額情報.get金額();
                    source.cover_nokibetsuMeisaishoTokuchoNofuGaku1 = decimalFormatter_toコンマ区切りRString(納期別明細書特徴納付額２, 0);
                }
                if (new RString("6").equals(特徴期別金額情報.get期())) {
                    納期別明細書特徴納付額３ = 特徴期別金額情報.get金額();
                    source.cover_nokibetsuMeisaishoTokuchoNofuGaku1 = decimalFormatter_toコンマ区切りRString(納期別明細書特徴納付額３, 0);
                }
            }
        }
        for (SpecialIncomeInformation 特徴収入情報 : 編集後本算定通知書共通情報.get特徴収入情報リスト()) {
            if (特徴収入情報.get期月() == null) {
                continue;
            }
            if (new RString("4").equals(特徴収入情報.get期月().get期())) {
                納期別明細書特徴納付済額１ = 特徴収入情報.get収入額();
                source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku1 = decimalFormatter_toコンマ区切りRString(納期別明細書特徴納付済額１, 0);
            }
            if (new RString("5").equals(特徴収入情報.get期月().get期())) {
                納期別明細書特徴納付済額２ = 特徴収入情報.get収入額();
                source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku2 = decimalFormatter_toコンマ区切りRString(納期別明細書特徴納付済額２, 0);
            }
            if (new RString("6").equals(特徴収入情報.get期月().get期())) {
                納期別明細書特徴納付済額３ = 特徴収入情報.get収入額();
                source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku3 = decimalFormatter_toコンマ区切りRString(納期別明細書特徴納付済額３, 0);
            }
        }

        Decimal 納期別明細書特徴差額１ = 納期別明細書特徴納付額１.subtract(納期別明細書特徴納付済額１);
        Decimal 納期別明細書特徴差額２ = 納期別明細書特徴納付額２.subtract(納期別明細書特徴納付済額２);
        Decimal 納期別明細書特徴差額３ = 納期別明細書特徴納付額３.subtract(納期別明細書特徴納付済額３);

        source.cover_nokibetsuMeisaishoTokuchoSaGaku1 = decimalFormatter_toコンマ区切りRString(納期別明細書特徴差額１, 0);
        source.cover_nokibetsuMeisaishoTokuchoSaGaku2 = decimalFormatter_toコンマ区切りRString(納期別明細書特徴差額２, 0);
        source.cover_nokibetsuMeisaishoTokuchoSaGaku3 = decimalFormatter_toコンマ区切りRString(納期別明細書特徴差額３, 0);

        source.cover_nokibetsuMeisaishoTokuchoNofuGaku4
                = decimalFormatter_toコンマ区切りRString(納期別明細書特徴納付額１.add(納期別明細書特徴納付額２).add(納期別明細書特徴納付額３), 0);
        source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku4
                = decimalFormatter_toコンマ区切りRString(納期別明細書特徴納付済額１.add(納期別明細書特徴納付済額２).add(納期別明細書特徴納付済額３), 0);
        source.cover_nokibetsuMeisaishoTokuchoSaGaku4
                = decimalFormatter_toコンマ区切りRString(納期別明細書特徴差額１.add(納期別明細書特徴差額２).add(納期別明細書特徴差額２), 0);
    }

    private void edit納期別明細書の表記(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriCoverSource source) {

        if (納入通知書期情報リスト.size() >= LIST_SIZE_1) {
            source.cover_nokibetsuMeisaishoKi1 = new RString("第").concat(納入通知書期情報リスト.get(0).get期表記()).concat(new RString("期"));
            source.cover_nokibetsuMeisaishoFuchoNofuGaku1 = 納入通知書期情報リスト.get(0).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku1 = 納入通知書期情報リスト.get(0).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku1 = 納入通知書期情報リスト.get(0).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen1 = 納入通知書期情報リスト.get(0).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_2) {
            source.cover_nokibetsuMeisaishoKi2 = new RString("第").concat(納入通知書期情報リスト.get(1).get期表記()).concat(new RString("期"));
            source.cover_nokibetsuMeisaishoFuchoNofuGaku2 = 納入通知書期情報リスト.get(1).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku2 = 納入通知書期情報リスト.get(1).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku2 = 納入通知書期情報リスト.get(1).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen2 = 納入通知書期情報リスト.get(1).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_3) {
            source.cover_nokibetsuMeisaishoKi3 = new RString("第").concat(納入通知書期情報リスト.get(2).get期表記()).concat(new RString("期"));
            source.cover_nokibetsuMeisaishoFuchoNofuGaku3 = 納入通知書期情報リスト.get(2).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku3 = 納入通知書期情報リスト.get(2).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku3 = 納入通知書期情報リスト.get(2).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen3 = 納入通知書期情報リスト.get(2).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_4) {
            source.cover_nokibetsuMeisaishoKi4 = new RString("第").
                    concat(納入通知書期情報リスト.get(LIST_SIZE_3).get期表記()).concat(new RString("期"));
            source.cover_nokibetsuMeisaishoFuchoNofuGaku4 = 納入通知書期情報リスト.get(LIST_SIZE_3).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku4 = 納入通知書期情報リスト.get(LIST_SIZE_3).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku4 = 納入通知書期情報リスト.get(LIST_SIZE_3).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen4 = 納入通知書期情報リスト.get(LIST_SIZE_3).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_5) {
            source.cover_nokibetsuMeisaishoKi5 = new RString("第").
                    concat(納入通知書期情報リスト.get(LIST_SIZE_4).get期表記()).concat(new RString("期"));
            source.cover_nokibetsuMeisaishoFuchoNofuGaku5 = 納入通知書期情報リスト.get(LIST_SIZE_4).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku5 = 納入通知書期情報リスト.get(LIST_SIZE_4).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku5 = 納入通知書期情報リスト.get(LIST_SIZE_4).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen5 = 納入通知書期情報リスト.get(LIST_SIZE_4).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_6) {
            source.cover_nokibetsuMeisaishoKi6 = new RString("第").
                    concat(納入通知書期情報リスト.get(LIST_SIZE_5).get期表記()).concat(new RString("期"));
            source.cover_nokibetsuMeisaishoFuchoNofuGaku6 = 納入通知書期情報リスト.get(LIST_SIZE_5).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku6 = 納入通知書期情報リスト.get(LIST_SIZE_5).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku6 = 納入通知書期情報リスト.get(LIST_SIZE_5).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen6 = 納入通知書期情報リスト.get(LIST_SIZE_5).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_7) {
            source.cover_nokibetsuMeisaishoKi7 = new RString("第").
                    concat(納入通知書期情報リスト.get(LIST_SIZE_6).get期表記()).concat(new RString("期"));
            source.cover_nokibetsuMeisaishoFuchoNofuGaku7 = 納入通知書期情報リスト.get(LIST_SIZE_6).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku7 = 納入通知書期情報リスト.get(LIST_SIZE_6).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku7 = 納入通知書期情報リスト.get(LIST_SIZE_6).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen7 = 納入通知書期情報リスト.get(LIST_SIZE_6).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_8) {
            if (納入通知書期情報リスト.get(LIST_SIZE_7).get期表記() != null) {
                source.cover_nokibetsuMeisaishoKi8 = new RString("第").
                        concat(納入通知書期情報リスト.get(LIST_SIZE_7).get期表記()).concat(new RString("期"));
            }
            source.cover_nokibetsuMeisaishoFuchoNofuGaku8 = 納入通知書期情報リスト.get(LIST_SIZE_7).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku8 = 納入通知書期情報リスト.get(LIST_SIZE_7).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku8 = 納入通知書期情報リスト.get(LIST_SIZE_7).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen8 = 納入通知書期情報リスト.get(LIST_SIZE_7).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_9) {
            source.cover_nokibetsuMeisaishoKi9 = new RString("第").
                    concat(納入通知書期情報リスト.get(LIST_SIZE_8).get期表記()).concat(new RString("期"));
            source.cover_nokibetsuMeisaishoFuchoNofuGaku9 = 納入通知書期情報リスト.get(LIST_SIZE_8).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku9 = 納入通知書期情報リスト.get(LIST_SIZE_8).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku9 = 納入通知書期情報リスト.get(LIST_SIZE_8).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen9 = 納入通知書期情報リスト.get(LIST_SIZE_8).get納期限表記();
        }
        if (納入通知書期情報リスト.size() >= LIST_SIZE_10) {
            source.cover_nokibetsuMeisaishoKi10 = new RString("第").
                    concat(納入通知書期情報リスト.get(LIST_SIZE_9).get期表記()).concat(new RString("期"));
            source.cover_nokibetsuMeisaishoFuchoNofuGaku10 = 納入通知書期情報リスト.get(LIST_SIZE_9).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku10 = 納入通知書期情報リスト.get(LIST_SIZE_9).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku10 = 納入通知書期情報リスト.get(LIST_SIZE_9).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen10 = 納入通知書期情報リスト.get(LIST_SIZE_9).get納期限表記();
        }

        source.cover_nokibetsuMeisaishoFuchoNofuGaku11
                = decimalFormatter_toコンマ区切りRString(
                        rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuGaku1)
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuGaku2))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuGaku3))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuGaku4))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuGaku5))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuGaku6))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuGaku7))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuGaku8))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuGaku9))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuGaku10)), 0);
        source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku11
                = decimalFormatter_toコンマ区切りRString(
                        rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku1)
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku2))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku3))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku4))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku5))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku6))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku7))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku8))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku9))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku10)), 0);
        source.cover_nokibetsuMeisaishoFuchoSaGaku11
                = decimalFormatter_toコンマ区切りRString(
                        rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoSaGaku1)
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoSaGaku2))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoSaGaku3))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoSaGaku4))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoSaGaku5))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoSaGaku6))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoSaGaku7))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoSaGaku8))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoSaGaku9))
                        .add(rstringToDecimal(source.cover_nokibetsuMeisaishoFuchoSaGaku10)), 0);
    }
}
