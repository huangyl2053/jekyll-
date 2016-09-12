/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendononyutsuchishobookfurikae;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuSanshutsuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendononyutsuchishobookfurikae.KanendoNonyuTsuchishoBookFuriKaeNashiSource;
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
 * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼なし）通知書 HokenryoNonyuTsuchishoBookFuriKaeNashiEditor
 *
 * @reamsid_L DBB-9110-160 wangjie2
 */
public class KanendoNonyuTsuchishoBookFuriKaeNashiEditor implements IKanendoNonyuTsuchishoBookFuriKaeNashiEditor {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final NinshoshaSource ninshoshaSource;
    private static final int INT1 = 1;
    private static final int INT2 = 2;
    private static final int INT3 = 3;
    private static final int INT6 = 6;
    private final RString 分 = new RString("分");
    private final RString 円 = new RString("円");
    private final RString 金額_0 = new RString("0");
    private final RString 星2 = new RString("**");
    private final RString 星6 = new RString("******");
    private final RString 星9 = new RString("*********");
    private final RString 星10 = new RString("**********");
    private final RString 星11 = new RString("***********");
    private final RString 星12 = new RString("************");
    private final RString 星19 = new RString("*******************");
    private final RString 星20 = new RString("********************");

    /**
     * コンストラクタです。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource ninshoshaSource
     */
    protected KanendoNonyuTsuchishoBookFuriKaeNashiEditor(
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
     * 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼なし）通知書構造体編集
     *
     * @param source 保険料納入通知書（本算定過年度）【ブックタイプ】（口振依頼なし）通知書構造体
     * @return HokenryoNonyuTsuchishoBookFuriKaeNashiCoverSource
     */
    @Override
    public KanendoNonyuTsuchishoBookFuriKaeNashiSource edit(KanendoNonyuTsuchishoBookFuriKaeNashiSource source) {
        source.layoutBreakItem = 1;
        editレイヤ１(source);
        editCompNofushoBookItem(source);
        editCompNinshosha(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editレイヤ１(KanendoNonyuTsuchishoBookFuriKaeNashiSource source) {
        NonyuTsuchiShoSeigyoJoho 納入通知書制御情報 = 本算定納入通知書制御情報.get納入通知書制御情報();
        if (null == 納入通知書制御情報) {
            納入通知書制御情報 = new NonyuTsuchiShoSeigyoJoho();
        }
        NofugakuSanshutsuHoho 納付額算出方法 = 納入通知書制御情報.get納付額算出方法();
        boolean isバッチ = ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分());
        source.cover_keisanMeisaishoNendo = 半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.cover_keisanMeisaishoNendoBun = 半角to全角(編集後本算定通知書共通情報.get賦課年度_年度あり()).concat(分);
        source.cover_titleNendo = 半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.cover_titleNendoBun = 半角to全角(編集後本算定通知書共通情報.get賦課年度_年度あり()).concat(分);
        HyojiCodes 表示コード = 編集後本算定通知書共通情報.get表示コード();
        if (表示コード != null) {
            source.cover_hyojicodeName1 = 表示コード.get表示コード名１();
            source.cover_hyojicodeName2 = 表示コード.get表示コード名２();
            source.cover_hyojicodeName3 = 表示コード.get表示コード名３();
            source.cover_hyojicode1 = 表示コード.get表示コード１();
            source.cover_hyojicode2 = 表示コード.get表示コード２();
            source.cover_hyojicode3 = 表示コード.get表示コード３();
        }
        EditedKojin 編集後個人 = 編集後本算定通知書共通情報.get編集後個人();
        EditedKoza 編集後口座 = 編集後本算定通知書共通情報.get編集後口座();
        edit編集後個人And編集後口座(source, 編集後個人, 編集後口座);
        if (編集後本算定通知書共通情報.get通知書番号() != null) {
            source.cover_tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
            source.cover_keisanMeisaishoTsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
            source.cover_nokibetsuMeisaishoTsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().value();
        }
        if (!納入通知書期情報リスト.isEmpty()
                && 納入通知書期情報リスト.get(0) != null) {
            source.cover_keisanMeisaishoKi1 = 納入通知書期情報リスト.get(0).get期表記();
            source.cover_keisanMeisaishoTsuki1 = 納入通知書期情報リスト.get(0).get月表記();
            source.cover_keisanMeisaishoNokigenKaishi1 = 納入通知書期情報リスト.get(0).get納期開始日表記();
            source.cover_keisanMeisaishoNokigenShuryo1 = 納入通知書期情報リスト.get(0).get納期終了日表記();
        }

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
        source.cover_yen1 = 円;
        source.cover_yen2 = 円;
        source.cover_keisanMeisaishoKiTitle1
                = new RString("第").concat(new RString(納入通知書期情報リスト.get(0).get期())).concat(new RString("期"));
        source.cover_keisanMeisaishoKibetsuNofuGaku1 = 納入通知書期情報リスト.get(0).get調定額表記();
        source.cover_yen3 = 円;
        source.cover_yen4 = 円;
        source.cover_keisanmeisaishoNendo2 = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        source.cover_pagerenban1 = isバッチ ? new RString(本算定納入通知書情報.get連番()).concat(new RString("-1")) : new RString("1-1");
        source.cover_pagerenban2 = isバッチ ? new RString(本算定納入通知書情報.get連番()).concat(new RString("-2")) : new RString("1-2");
        source.cover_nokibetsuMeisaishoNendo = 半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.cover_nokibetsuMeisaishoNendoNendoBun = 半角to全角(編集後本算定通知書共通情報.get賦課年度_年度あり()).concat(分);
        source.cover_nokibetsuMeisaishoTokuchoNofuGaku1 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku1 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoSaGaku1 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuGaku2 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku2 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoSaGaku2 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuGaku3 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku3 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoSaGaku3 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuGaku4 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoNofuZumiGaku4 = 金額_0;
        source.cover_nokibetsuMeisaishoTokuchoSaGaku4 = 金額_0;

        if (!納入通知書期情報リスト.isEmpty()
                && 納入通知書期情報リスト.get(0) != null) {
            if (納入通知書期情報リスト.get(0).get期表記() != null) {
                source.cover_nokibetsuMeisaishoKi1
                        = new RString("第").concat(納入通知書期情報リスト.get(0).get期表記()).concat(new RString("期"));
            }

            source.cover_nokibetsuMeisaishoFuchoNofuGaku1 = 納入通知書期情報リスト.get(0).get調定額表記();
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku1 = 納入通知書期情報リスト.get(0).get収入額表記();
            source.cover_nokibetsuMeisaishoFuchoSaGaku1 = 納入通知書期情報リスト.get(0).get差額表記();
            source.cover_nokibetsuMeisaishoNokigen1 = 納入通知書期情報リスト.get(0).get納期限表記();
            source.cover_nokibetsuMeisaishoFuchoNofuGaku11 = source.cover_nokibetsuMeisaishoFuchoNofuGaku1;
            source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku11 = source.cover_nokibetsuMeisaishoFuchoNofuZumiGaku1;
            source.cover_nokibetsuMeisaishoFuchoSaGaku11 = source.cover_nokibetsuMeisaishoFuchoSaGaku1;
        }

        source.cover_renban = isバッチ ? new RString(本算定納入通知書情報.get連番()).padLeft("0", INT6) : RString.EMPTY;
        source.cover_hokenshaName = 編集後本算定通知書共通情報.get保険者名();
        source.cover_pagerenban3 = isバッチ ? new RString(本算定納入通知書情報.get連番()).concat(new RString("-3")) : new RString("1-3");
    }

    private void edit編集後個人And編集後口座(
            KanendoNonyuTsuchishoBookFuriKaeNashiSource source, EditedKojin 編集後個人, EditedKoza 編集後口座) {
        if (編集後個人 != null) {
            if (編集後個人.get世帯コード() != null) {
                source.cover_setaiCode = 編集後個人.get世帯コード().value();
                source.cover_keisanMeisaishoSetaiCode = 編集後個人.get世帯コード().value();
                source.cover_nokibetsuMeisaishoSetaiCode = 編集後個人.get世帯コード().value();
            }
            if (編集後個人.get名称() != null
                    && 編集後個人.get名称().getName() != null) {
                source.cover_kaisanMeisaishoHihokenshaName = 編集後個人.get名称().getName().value();
                source.cover_nokibetsuMeisaishoHohokenshaName = 編集後個人.get名称().getName().value();
            }
            if (編集後個人.get世帯主名() != null) {
                source.cover_kaisanMeisaishoSetaiNushiName = 編集後個人.get世帯主名().value();
            }
        }
        if (編集後口座 != null) {
            source.cover_bankCode = 編集後口座.get金融機関コードCombinedWith支店コード();
            source.cover_kozaShurui = 編集後口座.get口座種別略称();
            source.cover_kozaNo = 編集後口座.get口座番号Or通帳記号番号();
            source.cover_bankName = 編集後口座.get金融機関名CombinedWith支店名();
            source.cover_kozaMeiginin = 編集後口座.get口座名義人優先();
        }
    }

    private RString decimalFormatter_toコンマ区切りRString(Decimal 額, int count) {
        if (null == 額) {
            return RString.EMPTY;
        }
        return DecimalFormatter.toコンマ区切りRString(額, count);
    }

    private void editCompNofushoBookItem(KanendoNonyuTsuchishoBookFuriKaeNashiSource source) {
        NofuShoKyotsu 納付書共通 = 本算定納入通知書情報.get納付書共通();
        if (null == 納付書共通) {
            納付書共通 = new NofuShoKyotsu();
        }
        boolean isバッチ = ShoriKubun.バッチ.equals(本算定納入通知書情報.get処理区分());
        NonyuTsuchiShoKiJoho 納入通知書期情報 = null;
        if (!納入通知書期情報リスト.isEmpty()) {
            納入通知書期情報 = 納入通知書期情報リスト.get(0);
        }
        if (納入通知書期情報 != null && 1 == 納入通知書期情報.getブック開始位置()) {
            source.cover_nofuzumishoTitleNendoBun1 = 納付書共通.get賦課年度表記();
            source.cover_nofuzumishoTitleKi1 = 納入通知書期情報.get期表記();
            source.cover_nofuzumishoTitleTsuki1 = 納入通知書期情報.get月表記();
            source.cover_nofozumishoTitleNendo1 = 納付書共通.get調定年度表記();
            source.cover_ryoshushoTitleNendo1 = 納付書共通.get調定年度表記();
            source.cover_ryoshushoTitleKi1 = 納入通知書期情報.get期表記();
            source.cover_ryoshushoTitleTsuki1 = 納入通知書期情報.get月表記();
            source.cover_nofushoTitleNendo1 = 納付書共通.get調定年度表記();
            source.cover_nofushoTitleKi1 = 納入通知書期情報.get期表記();
            source.cover_nofushoTitleTsuki1 = 納入通知書期情報.get月表記();
            Map<Integer, RString> ocr = 納入通知書期情報.getOcr();
            if (ocr != null) {
                source.cover_nofuzumishoOCR11 = ocr.get(INT1);
                source.cover_nofuzumishoOCR21 = ocr.get(INT2);
                source.cover_nofuzumishoOCR31 = ocr.get(INT3);
            }
            source.cover_nofuzumishoNokigen1 = 納入通知書期情報.get納期限表記();
            source.cover_ryoshushoHokenryoGaku1 = 納入通知書期情報.get領収証書納付額欄();
            source.cover_nofushoHokenryoGaku1 = 納入通知書期情報.get納付書納付額欄();
            source.cover_nofuzumishoNofuGaku1 = 納入通知書期情報.get納付書納付額欄();
            source.cover_ryoshushoNokigen1 = 納入通知書期情報.get納期限表記();
            source.cover_nofushoNokigen1 = 納入通知書期情報.get納期限表記();
            source.cover_ryoshushoNofuIn1 = 納入通知書期情報.get領収日付印欄();
            source.cover_nofushoNofuIn1 = 納入通知書期情報.get領収日付欄();
            source.cover_nofuzumishoNofuIn1 = 納入通知書期情報.get領収日付欄();
            source.cover_ryoshushoKozaCom1 = 納入通知書期情報.get領収証書領収印欄();
            source.cover_nofushoKozaCom1 = 納入通知書期情報.get納付書領収印欄();
            source.cover_nofuzumishoKozaCom1 = 納入通知書期情報.get納付書領収印欄();
            source.cover_ryoshushoZuiji1 = 納入通知書期情報.get随時表記();
            source.cover_nofushoZuiji1 = 納入通知書期情報.get随時表記();
            source.cover_nofuzumishoZuiji1 = 納入通知書期情報.get随時表記();
        } else {
            source.cover_nofuzumishoTitleNendoBun1 = 星9;
            source.cover_nofuzumishoTitleKi1 = 星2;
            source.cover_nofuzumishoTitleTsuki1 = 星2;
            source.cover_nofozumishoTitleNendo1 = 星6;
            source.cover_ryoshushoTitleNendo1 = 星6;
            source.cover_ryoshushoTitleKi1 = 星2;
            source.cover_ryoshushoTitleTsuki1 = 星2;
            source.cover_nofushoTitleNendo1 = 星6;
            source.cover_nofushoTitleKi1 = 星2;
            source.cover_nofushoTitleTsuki1 = 星2;
            source.cover_nofuzumishoOCR11 = 星19;
            source.cover_nofuzumishoOCR21 = 星20;
            source.cover_nofuzumishoOCR31 = 星12;
            source.cover_nofuzumishoNokigen1 = 星11;
            source.cover_ryoshushoHokenryoGaku1 = 星10;
            source.cover_nofushoHokenryoGaku1 = 星10;
            source.cover_nofuzumishoNofuGaku1 = 星10;
            source.cover_ryoshushoNokigen1 = 星11;
            source.cover_nofushoNokigen1 = 星11;
            source.cover_ryoshushoNofuIn1 = 星2;
            source.cover_nofushoNofuIn1 = 星2;
            source.cover_nofuzumishoNofuIn1 = 星2;
        }
        source.cover_ryoshushoJusho1 = 納付書共通.get住所();
        if (納付書共通.get通知書番号() != null) {
            source.cover_nofuzumishoTsuchishoNo1 = 納付書共通.get通知書番号().value();
            source.cover_ryoshushoTsuchishoNo1 = 納付書共通.get通知書番号().value();
            source.cover_nofushoTsuchishoNo1 = 納付書共通.get通知書番号().value();
        }
        source.cover_ryoshushoKatagaki1 = 納付書共通.get方書();
        if (納付書共通.get世帯コード() != null) {
            source.cover_nofuzumishoSetaiCode1 = 納付書共通.get世帯コード().value();
        }
        source.cover_ryoshushoHihokenshaName1 = 納付書共通.get納付者氏名();
        source.cover_nofushoHihokenshaName1 = 納付書共通.get納付者氏名();
        source.cover_nofuzumishoJusho1 = 納付書共通.get住所();
        source.cover_nofuzumishoKatagaki1 = 納付書共通.get方書();
        source.cover_nofuzumishoHihokenshaName1 = 納付書共通.get納付者氏名();
        source.cover_nofuzumishoshichosonName1 = 納付書共通.get納付書市町村名();
        source.cover_pagerenban4 = isバッチ ? new RString(本算定納入通知書情報.get連番()).concat(new RString("-4")) : new RString("1-4");
    }

    private RString 半角to全角(RString 半角) {
        if (null == 半角) {
            return RString.EMPTY;
        }
        return RStringUtil.convert半角to全角(半角);
    }

    private void editCompNinshosha(KanendoNonyuTsuchishoBookFuriKaeNashiSource source) {
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

    private void editCompSofubutsuAtesaki(KanendoNonyuTsuchishoBookFuriKaeNashiSource source) {
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
