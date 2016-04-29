/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007_16;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuSanshutsuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007_16.NonyuTsuchishoBookFuriKaeAriRenchoCoverSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書_連帳 NonyuTsuchishoBookFuriKaeAriRenchoCoverEditor
 *
 * @reamsid_L DBB-9110-160 liangbc
 */
public class NonyuTsuchishoBookFuriKaeAriRenchoCoverEditor implements INonyuTsuchishoBookFuriKaeAriRenchoCoverEditor {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final int 連番;
    private final NinshoshaSource ninshoshaSource;
    private final SofubutsuAtesakiSource sofubutsuAtesakiSource;
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
     * @param sofubutsuAtesakiSource sofubutsuAtesakiSource
     */
    protected NonyuTsuchishoBookFuriKaeAriRenchoCoverEditor(
            NonyuTsuchishoBookItem item,
            int 連番,
            NinshoshaSource ninshoshaSource,
            SofubutsuAtesakiSource sofubutsuAtesakiSource) {
        this.本算定納入通知書情報 = null == item.get本算定納入通知書情報()
                ? new HonSanteiNonyuTsuchiShoJoho() : item.get本算定納入通知書情報();
        this.編集後本算定通知書共通情報 = null == 本算定納入通知書情報.get編集後本算定通知書共通情報()
                ? new EditedHonSanteiTsuchiShoKyotsu() : 本算定納入通知書情報.get編集後本算定通知書共通情報();
        this.本算定納入通知書制御情報 = null == 本算定納入通知書情報.get本算定納入通知書制御情報()
                ? new HonSanteiNonyuTsuchiShoSeigyoJoho() : 本算定納入通知書情報.get本算定納入通知書制御情報();
        this.納入通知書期情報リスト = null == 本算定納入通知書情報.get納入通知書期情報リスト()
                ? new ArrayList<NonyuTsuchiShoKiJoho>() : 本算定納入通知書情報.get納入通知書期情報リスト();
        this.連番 = 連番;
        this.ninshoshaSource = ninshoshaSource;
        this.sofubutsuAtesakiSource = sofubutsuAtesakiSource;
    }

    /**
     * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書_連帳構造体編集
     *
     * @param source 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼あり）通知書_連帳構造体
     * @return NonyuTsuchishoBookFuriKaeAriRenchoCoverSource
     */
    @Override
    public NonyuTsuchishoBookFuriKaeAriRenchoCoverSource edit(NonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        editレイヤ１(source);
        editCompNinshosha(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editレイヤ１(NonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        // レイヤ１
        NofugakuSanshutsuHoho 納付額算出方法 = 本算定納入通知書制御情報.get納入通知書制御情報().get納付額算出方法();
        boolean isバッチ = ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分());
        source.keisanMeisaishoNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.keisanMeisaishoNendoBun = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get賦課年度_年度あり()).concat(分);
        source.titleNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.titleNendoBun = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get賦課年度_年度あり()).concat(分);
        source.hyojicodeName1 = 編集後本算定通知書共通情報.get表示コード().get表示コード名１();
        source.hyojicodeName2 = 編集後本算定通知書共通情報.get表示コード().get表示コード名２();
        source.hyojicodeName3 = 編集後本算定通知書共通情報.get表示コード().get表示コード名３();
        source.hyojicode1 = 編集後本算定通知書共通情報.get表示コード().get表示コード１();
        source.hyojicode2 = 編集後本算定通知書共通情報.get表示コード().get表示コード２();
        source.hyojicode3 = 編集後本算定通知書共通情報.get表示コード().get表示コード３();
        source.keisanMeisaishoKi1 = 納入通知書期情報リスト.get(0).get期表記();
        source.keisanMeisaishoNokigenKaishi1 = 納入通知書期情報リスト.get(0).get納期開始日表記();
        source.kaisanMeisaishoHihokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().value();
        source.kaisanMeisaishoSetaiNushiName = 編集後本算定通知書共通情報.get編集後個人().get世帯主名().value();
        source.keisanMeisaishoTsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        source.keisanMeisaishoSetaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
        source.keisanMeisaishoTsuki1 = 納入通知書期情報リスト.get(0).get月表記();
        source.keisanMeisaishoNokigenShuryo1 = 納入通知書期情報リスト.get(0).get納期終了日表記();
        source.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        source.setaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
        source.keisanMeisaishoKaishiKi = 編集後本算定通知書共通情報.get更正後().get期間_自();
        source.keisanMeisaishoTsukiSu = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get更正後().get月数_ケ月());
        source.kaisanMeisaishoShuryoKi = 編集後本算定通知書共通情報.get更正後().get期間_至();
        source.bankCode = 編集後本算定通知書共通情報.get編集後口座().get金融機関コードCombinedWith支店コード();
        source.kozaShurui = 編集後本算定通知書共通情報.get編集後口座().get口座種別略称();
        source.kozaNo = 編集後本算定通知書共通情報.get編集後口座().get口座番号Or通帳記号番号();
        source.keisanMeisaishoShotokuDankai = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get更正後().get保険料段階());
        source.kaisanMeisaiHokenryoRitsu = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get保険料率(), 0);
        source.keisanMeisaishoCalHokenryoGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get減免前保険料_年額(), 0);
        source.keisanMeisaishoGenmenGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get減免額(), 0);
        source.bankName = 編集後本算定通知書共通情報.get編集後口座().get金融機関名CombinedWith支店名();
        source.keisanMeisaishoTokuchoGokeiGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get特別徴収額合計(), 0);
        source.kaisanMeisaishoFuchoGokeiGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get普通徴収額合計(), 0);
        // TODO 納通連番 ＝ 通知書番号単位に、1から順番で採番する 連番は6桁0埋めです
        source.noutsuRenban = isバッチ ? new RString(String.valueOf(連番)).padLeft("0", INT6) : RString.EMPTY;
        source.kozaMeiginin = 編集後本算定通知書共通情報.get編集後口座().get口座名義人優先();
        if (NofugakuSanshutsuHoho.収入額をもとに算出.equals(納付額算出方法)) {
            source.kaisanMeisaishoNofuZumiGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get普徴納付済額_未到来期含む(), 0);
        } else if (NofugakuSanshutsuHoho.調定額をもとに算出.equals(納付額算出方法)) {
            source.kaisanMeisaishoNofuZumiGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get普徴既に納付すべき額(), 0);
        }
        if (NofugakuSanshutsuHoho.収入額をもとに算出.equals(納付額算出方法)) {
            source.keisanMeisaishoKongoNofuGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get普徴今後納付すべき額_調定元に(), 0);
        } else if (NofugakuSanshutsuHoho.調定額をもとに算出.equals(納付額算出方法)) {
            source.keisanMeisaishoKongoNofuGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get普徴今後納付すべき額_収入元に(), 0);
        }
        source.yen1 = 円;
        source.yen2 = 円;
        source.keisanMeisaishoKiTitle1 = new RString("第").concat(new RString(納入通知書期情報リスト.get(0).get期())).concat(new RString("期"));
        source.keisanMeisaishoKibetsuNofuGaku1 = 納入通知書期情報リスト.get(0).get調定額表記();
        source.yen3 = 円;
        source.yen4 = 円;
        source.keisanmeisaishoNendo2 = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        source.keisanMeisaishoHokenryoGokeiGaku = DecimalFormatter.toコンマ区切りRString(編集後本算定通知書共通情報.get更正後().get確定保険料_年額(), 0);
        source.pagerenban1 = isバッチ ? new RString(String.valueOf(連番)).concat(new RString("-1")) : new RString("1-1");
        source.pagerenban2 = isバッチ ? new RString(String.valueOf(連番)).concat(new RString("-2")) : new RString("1-2");
        source.nokibetsuMeisaishoNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.kmNendoBun = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get賦課年度_年度あり()).concat(分);
        source.kozaIraishoLeftJusho = 編集後本算定通知書共通情報.get編集後個人().get編集後住所();
        source.kozaIraishoRightJusho = 編集後本算定通知書共通情報.get編集後個人().get編集後住所();
        source.nokibetsuMeisaishoTokuchoNofuGaku1 = 金額_0;
        source.nokibetsuMeisaishoTokuchoNofuZumiGaku1 = 金額_0;
        source.nokibetsuMeisaishoTsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        source.nokibetsuMeisaishoSetaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().value();
        source.nokibetsuMeisaishoTokuchoSaGaku1 = 金額_0;
        source.nokibetsuMeisaishoTokuchoNofuGaku2 = 金額_0;
        source.nokibetsuMeisaishoTokuchoNofuZumiGaku2 = 金額_0;
        source.nokibetsuMeisaishoTokuchoSaGaku2 = 金額_0;
        source.kozaIraishoLeftHihokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().value();
        source.kozaIraishoRightHihokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().value();
        source.nokibetsuMeisaishoHohokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().value();
        source.nokibetsuMeisaishoTokuchoNofuGaku3 = 金額_0;
        source.nokibetsuMeisaishoTokuchoNofuZumiGaku3 = 金額_0;
        source.nokibetsuMeisaishoTokuchoSaGaku3 = 金額_0;
        source.nokibetsuMeisaishoTokuchoNofuGaku4 = 金額_0;
        source.nokibetsuMeisaishoTokuchoNofuZumiGaku4 = 金額_0;
        source.nokibetsuMeisaishoTokuchoSaGaku4 = 金額_0;
        source.kozaIraishoLeftShikibetsuCode = 編集後本算定通知書共通情報.get識別コード().value();
        source.kozaIraishoRightShikibetsuCode = 編集後本算定通知書共通情報.get識別コード().value();
        // TODO 分割前の納入通知書期情報リスト、全部期月の情報を出力
        source.nokibetsuMeisaishoKi1 = new RString("第").concat(納入通知書期情報リスト.get(0).get期表記()).concat(new RString("期"));
        source.nokibetsuMeisaishoFuchoNofuGaku1 = 納入通知書期情報リスト.get(0).get調定額表記();
        source.nokibetsuMeisaishoFuchoNofuZumiGaku1 = 納入通知書期情報リスト.get(0).get収入額表記();
        source.nokibetsuMeisaishoFuchoSaGaku1 = 納入通知書期情報リスト.get(0).get差額表記();
        source.nokibetsuMeisaishoNokigen1 = 納入通知書期情報リスト.get(0).get納期限表記();
        source.nokibetsuMeisaishoFuchoNofuGaku11 = source.nokibetsuMeisaishoFuchoNofuGaku1;
        source.nokibetsuMeisaishoFuchoNofuZumiGaku11 = source.nokibetsuMeisaishoFuchoNofuZumiGaku1;
        source.nokibetsuMeisaishoFuchoSaGaku11 = source.nokibetsuMeisaishoFuchoSaGaku1;
        source.pagerenban3 = isバッチ ? new RString(String.valueOf(連番)).concat(new RString("-3")) : new RString("1-3");
        source.pagerenban4 = isバッチ ? new RString(String.valueOf(連番)).concat(new RString("-4")) : new RString("1-4");
    }

    private void editCompNinshosha(NonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        // CompNinshosha 雛形部品自動的に設定する
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.hakkoYMD = ninshoshaSource.hakkoYMD;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
    }

    private void editCompSofubutsuAtesaki(NonyuTsuchishoBookFuriKaeAriRenchoCoverSource source) {
        // CompSofubutsuAtesaki 共通部品から設定する
        source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
        source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
        source.gyoseiku = sofubutsuAtesakiSource.gyoseiku;
        source.jusho1 = sofubutsuAtesakiSource.jusho1;
        source.jusho2 = sofubutsuAtesakiSource.jusho2;
        source.jusho3 = sofubutsuAtesakiSource.jusho3;
        source.jushoText = sofubutsuAtesakiSource.jushoText;
        source.kakkoLeft1 = sofubutsuAtesakiSource.kakkoLeft1;
        source.kakkoLeft2 = sofubutsuAtesakiSource.kakkoLeft2;
        source.kakkoRight1 = sofubutsuAtesakiSource.kakkoRight1;
        source.kakkoRight2 = sofubutsuAtesakiSource.kakkoRight2;
        source.katagaki1 = sofubutsuAtesakiSource.katagaki1;
        source.katagaki2 = sofubutsuAtesakiSource.katagaki2;
        source.katagakiSmall1 = sofubutsuAtesakiSource.katagakiSmall1;
        source.katagakiSmall2 = sofubutsuAtesakiSource.katagakiSmall2;
        source.katagakiText = sofubutsuAtesakiSource.katagakiText;
        source.meishoFuyo1 = sofubutsuAtesakiSource.meishoFuyo1;
        source.meishoFuyo2 = sofubutsuAtesakiSource.meishoFuyo2;
        source.samaBun1 = sofubutsuAtesakiSource.samaBun1;
        source.samaBun2 = sofubutsuAtesakiSource.samaBun2;
        source.samabunShimei1 = sofubutsuAtesakiSource.samabunShimei1;
        source.samabunShimei2 = sofubutsuAtesakiSource.samabunShimei2;
        source.samabunShimeiSmall1 = sofubutsuAtesakiSource.samabunShimeiSmall1;
        source.samabunShimeiSmall2 = sofubutsuAtesakiSource.samabunShimeiSmall2;
        source.samabunShimeiText = sofubutsuAtesakiSource.samabunShimeiText;
        source.shimei1 = sofubutsuAtesakiSource.shimei1;
        source.shimei2 = sofubutsuAtesakiSource.shimei2;
        source.shimeiSmall1 = sofubutsuAtesakiSource.shimeiSmall1;
        source.shimeiSmall2 = sofubutsuAtesakiSource.shimeiSmall2;
        source.shimeiText = sofubutsuAtesakiSource.shimeiText;
        source.yubinNo = sofubutsuAtesakiSource.yubinNo;
        // TODO 世帯主名 setainusimei 共通部品から設定する
        // TODO 様方 samaKata 共通部品から設定する
    }
}
