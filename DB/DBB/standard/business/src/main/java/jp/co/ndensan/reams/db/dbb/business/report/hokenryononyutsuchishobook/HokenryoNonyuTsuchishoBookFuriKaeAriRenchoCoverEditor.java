/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishobook;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuSanshutsuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishobook.HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 保険料納入通知書（本算定）【ブックタイプ】（口振依頼あり）通知書_連帳 HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor
 *
 * @reamsid_L DBB-9110-010 huangh
 */
public class HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor implements IHokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final int 連番;
    private final NinshoshaSource ninshoshaSource;
    private static final int INT6 = 6;
    private static final RString 分 = new RString("分");
    private static final RString 円 = new RString("円");
    private static final RString 金額_0 = new RString("0");

    /**
     * コンストラクタです。
     *
     * @param item {@link NonyuTsuchishoBookItem}
     * @param 連番 連番
     * @param ninshoshaSource ninshoshaSource
     */
    protected HokenryoNonyuTsuchishoBookFuriKaeAriRenchoCoverEditor(
            HonSanteiNonyuTsuchiShoJoho item,
            int 連番,
            NinshoshaSource ninshoshaSource) {
        this.本算定納入通知書情報 = null == item
                ? new HonSanteiNonyuTsuchiShoJoho() : item;
        this.編集後本算定通知書共通情報 = null == 本算定納入通知書情報.get編集後本算定通知書共通情報()
                ? new EditedHonSanteiTsuchiShoKyotsu() : 本算定納入通知書情報.get編集後本算定通知書共通情報();
        this.本算定納入通知書制御情報 = null == 本算定納入通知書情報.get本算定納入通知書制御情報()
                ? new HonSanteiNonyuTsuchiShoSeigyoJoho() : 本算定納入通知書情報.get本算定納入通知書制御情報();
        this.納入通知書期情報リスト = null == 本算定納入通知書情報.get納入通知書期情報リスト()
                ? new ArrayList<NonyuTsuchiShoKiJoho>() : 本算定納入通知書情報.get納入通知書期情報リスト();
        this.連番 = 連番;
        this.ninshoshaSource = ninshoshaSource;
    }

    /**
     * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書_連帳構造体編集
     *
     * @param source 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書_連帳構造体
     * @return HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource
     */
    @Override
    public HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource edit(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        editレイヤ１(source);
        editCompNinshosha(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editレイヤ１(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        // レイヤ１
        NofugakuSanshutsuHoho 納付額算出方法 = 本算定納入通知書制御情報.get納入通知書制御情報().get納付額算出方法();
        boolean isバッチ = ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分());
        source.cover_keisanMeisaishoNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.cover_keisanMeisaishoNendoBun = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get賦課年度_年度あり()).concat(分);
        source.cover_titleNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.cover_titleNendoBun = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get賦課年度_年度あり()).concat(分);
        source.cover_hyojicodeName1 = 編集後本算定通知書共通情報.get表示コード().get表示コード名１();
        source.cover_hyojicodeName2 = 編集後本算定通知書共通情報.get表示コード().get表示コード名２();
        source.cover_hyojicodeName3 = 編集後本算定通知書共通情報.get表示コード().get表示コード名３();
        source.cover_hyojicode1 = 編集後本算定通知書共通情報.get表示コード().get表示コード１();
        source.cover_hyojicode2 = 編集後本算定通知書共通情報.get表示コード().get表示コード２();
        source.cover_hyojicode3 = 編集後本算定通知書共通情報.get表示コード().get表示コード３();
        source.cover_keisanMeisaishoKi1 = 納入通知書期情報リスト.get(0).get期表記();
        source.cover_keisanMeisaishoNokigenKaishi1 = 納入通知書期情報リスト.get(0).get納期開始日表記();
        source.cover_kaisanMeisaishoHihokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().value();
        source.cover_kaisanMeisaishoSetaiNushiName = 編集後本算定通知書共通情報.get編集後個人().get世帯主名().value();
        source.cover_keisanMeisaishoTsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        source.cover_keisanMeisaishoSetaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
        source.cover_keisanMeisaishoTsuki1 = 納入通知書期情報リスト.get(0).get月表記();
        source.cover_keisanMeisaishoNokigenShuryo1 = 納入通知書期情報リスト.get(0).get納期終了日表記();
        source.cover_tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        source.cover_setaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
        source.cover_keisanMeisaishoKaishiKi = 編集後本算定通知書共通情報.get更正後().get期間_自();
        source.cover_keisanMeisaishoTsukiSu = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get更正後().get月数_ケ月());
        source.cover_kaisanMeisaishoShuryoKi = 編集後本算定通知書共通情報.get更正後().get期間_至();
        source.cover_bankCode = 編集後本算定通知書共通情報.get編集後口座().get金融機関コードCombinedWith支店コード();
        source.cover_kozaShurui = 編集後本算定通知書共通情報.get編集後口座().get口座種別略称();
        source.cover_kozaNo = 編集後本算定通知書共通情報.get編集後口座().get口座番号Or通帳記号番号();
        source.cover_keisanMeisaishoShotokuDankai = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get更正後().get保険料段階());
        source.cover_kaisanMeisaiHokenryoRitsu = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get保険料率(), 0);
        source.cover_keisanMeisaishoCalHokenryoGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get減免前保険料_年額(), 0);
        source.cover_keisanMeisaishoGenmenGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get減免額(), 0);
        source.cover_bankName = 編集後本算定通知書共通情報.get編集後口座().get金融機関名CombinedWith支店名();
        source.cover_keisanMeisaishoTokuchoGokeiGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get特別徴収額合計(), 0);
        source.cover_kaisanMeisaishoFuchoGokeiGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get普通徴収額合計(), 0);
        source.cover_noutsuRenban = isバッチ ? new RString(String.valueOf(連番)).padLeft("0", INT6) : RString.EMPTY;
        source.cover_kozaMeiginin = 編集後本算定通知書共通情報.get編集後口座().get口座名義人優先();
        if (NofugakuSanshutsuHoho.収入額をもとに算出.equals(納付額算出方法)) {
            source.cover_kaisanMeisaishoNofuZumiGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get普徴納付済額_未到来期含む(), 0);
        } else if (NofugakuSanshutsuHoho.調定額をもとに算出.equals(納付額算出方法)) {
            source.cover_kaisanMeisaishoNofuZumiGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get普徴既に納付すべき額(), 0);
        }
        if (NofugakuSanshutsuHoho.収入額をもとに算出.equals(納付額算出方法)) {
            source.cover_keisanMeisaishoKongoNofuGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get普徴今後納付すべき額_調定元に(), 0);
        } else if (NofugakuSanshutsuHoho.調定額をもとに算出.equals(納付額算出方法)) {
            source.cover_keisanMeisaishoKongoNofuGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get普徴今後納付すべき額_収入元に(), 0);
        }
        source.cover_yen1 = 円;
        source.cover_yen2 = 円;
        source.cover_keisanMeisaishoKiTitle1 = new RString("第").concat(new RString(納入通知書期情報リスト.get(0).get期())).concat(new RString("期"));
        source.cover_keisanMeisaishoKibetsuNofuGaku1 = 納入通知書期情報リスト.get(0).get調定額表記();
        source.cover_yen3 = 円;
        source.cover_yen4 = 円;
        source.cover_keisanmeisaishoNendo2 = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        source.cover_keisanMeisaishoHokenryoGokeiGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get確定保険料_年額(), 0);
        source.cover_pagerenban1 = isバッチ ? new RString(String.valueOf(連番)).concat(new RString("-1")) : new RString("1-1");
        source.cover_pagerenban2 = isバッチ ? new RString(String.valueOf(連番)).concat(new RString("-2")) : new RString("1-2");
        source.cover_nokibetsuMeisaishoNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.cover_kmNendoBun = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get賦課年度_年度あり()).concat(分);
        source.cover_kozaIraishoLeftJusho = 編集後本算定通知書共通情報.get編集後個人().get編集後住所();
        source.cover_kozaIraishoRightJusho = 編集後本算定通知書共通情報.get編集後個人().get編集後住所();
        source.cover_nokibetsuMeisaishoTokuchoNofuGaku1 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku1 = 金額_0;
        source.cover_nokibetsuMeisaishoTsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        source.cover_nokibetsuMeisaishoSetaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
        source.cover_nokibetsuMeisaishoTokuchoSaGaku1 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuGaku2 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku2 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoSaGaku2 = 金額_0;
        source.cover_kozaIraishoLeftHihokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().value();
        source.cover_kozaIraishoRightHihokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().value();
        source.cover_nokibetsuMeisaishoHohokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().value();
        source.cover_nokibetsuMeisaishoTokuchoNofuGaku3 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku3 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoSaGaku3 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuGaku4 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku4 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoSaGaku4 = 金額_0;
        source.cover_kozaIraishoLeftShikibetsuCode = 編集後本算定通知書共通情報.get識別コード().value();
        source.cover_kozaIraishoRightShikibetsuCode = 編集後本算定通知書共通情報.get識別コード().value();
        // TODO 分割前の納入通知書期情報リスト、全部期月の情報を出力
        source.cover_nokibetsuMeisaishoKi1 = new RString("第").concat(納入通知書期情報リスト.get(0).get期表記()).concat(new RString("期"));
        source.cover_nokibetsuMeisaishoFuchoNofuGaku1 = 納入通知書期情報リスト.get(0).get調定額表記();
        source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku1 = 納入通知書期情報リスト.get(0).get収入額表記();
        source.cover_nokibetsuMeisaishoFuchoSaGaku1 = 納入通知書期情報リスト.get(0).get差額表記();
        source.cover_nokibetsuMeisaishoNokigen1 = 納入通知書期情報リスト.get(0).get納期限表記();
        source.cover_nokibetsuMeisaishoFuchoNofuGaku11 = source.cover_nokibetsuMeisaishoFuchoNofuGaku1;
        source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku11 = source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku1;
        source.cover_nokibetsuMeisaishoFuchoSaGaku11 = source.cover_nokibetsuMeisaishoFuchoSaGaku1;
        source.cover_pagerenban3 = isバッチ ? new RString(String.valueOf(連番)).concat(new RString("-3")) : new RString("1-3");
        source.cover_pagerenban4 = isバッチ ? new RString(String.valueOf(連番)).concat(new RString("-4")) : new RString("1-4");
    }

    private void editCompNinshosha(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        // CompNinshosha 雛形部品自動的に設定する
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

    private void editCompSofubutsuAtesaki(HokenryoNonyuNonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        // CompSofubutsuAtesaki 共通部品から設定する
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
}
