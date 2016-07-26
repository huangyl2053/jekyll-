/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendohokenryononyutsuchishokigoto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.AfterEditInformation;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HonSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.HyojiCodes;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.UniversalPhase;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NokigenShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.kanendohokenryononyutsuchishokigoto.KanendoHokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 * 保険料納入通知書（本算定過年度）【期毎タイプ】HokenryoNonyuTsuchishoKigotoEditor
 *
 * @reamsid_L DBB-9110-140 wangjie2
 */
public class KanendoHokenryoNonyuTsuchishoKigotoEditor implements IKanendoHokenryoNonyuTsuchishoKigotoEditor {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final NinshoshaSource ninshoshaSource;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final int 連番;
    private static final int INT_3 = 3;
    private static final int INT_4 = 4;
    private static final int INT_6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param 本算定納入通知書情報 本算定納入通知書情報
     * @param ninshoshaSource 認証者情報
     * @param 納入通知書期情報 納入通知書期情報
     * @param 連番 連番
     */
    protected KanendoHokenryoNonyuTsuchishoKigotoEditor(HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報,
            NinshoshaSource ninshoshaSource, NonyuTsuchiShoKiJoho 納入通知書期情報, int 連番) {
        this.本算定納入通知書情報 = 本算定納入通知書情報;
        this.ninshoshaSource = ninshoshaSource;
        this.納入通知書期情報 = 納入通知書期情報;
        this.連番 = 連番;
    }

    @Override
    public KanendoHokenryoNonyuTsuchishoKigotoSource edit(KanendoHokenryoNonyuTsuchishoKigotoSource source) {
        editレイヤ１(source);
        editCompNinshosha(source);
        editCompNofushoItemAndCompRyoshushoItem(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editCompSofubutsuAtesaki(KanendoHokenryoNonyuTsuchishoKigotoSource source) {
        if (本算定納入通知書情報.get編集後本算定通知書共通情報() != null
                && 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先() != null
                && 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource() != null) {
            SofubutsuAtesakiSource 送付物宛先ソース
                    = 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource().get送付物宛先ソース();
            if (null == 送付物宛先ソース) {
                return;
            }
            source.yubinNo = 送付物宛先ソース.yubinNo;
            source.gyoseiku = 送付物宛先ソース.gyoseiku;
            source.jusho3 = 送付物宛先ソース.jusho3;
            source.jushoText = 送付物宛先ソース.jushoText;
            source.jusho2 = 送付物宛先ソース.jusho2;
            source.jusho1 = 送付物宛先ソース.jusho1;
            source.katagaki2 = 送付物宛先ソース.katagaki2;
            source.katagakiText = 送付物宛先ソース.katagakiText;
            source.katagakiSmall2 = 送付物宛先ソース.katagakiSmall2;
            source.katagaki1 = 送付物宛先ソース.katagaki1;
            source.katagakiSmall1 = 送付物宛先ソース.katagakiSmall1;
            source.shimei2 = 送付物宛先ソース.shimei2;
            source.shimeiSmall2 = 送付物宛先ソース.shimeiSmall2;
            source.shimeiText = 送付物宛先ソース.shimeiText;
            source.meishoFuyo2 = 送付物宛先ソース.meishoFuyo2;
            source.dainoKubunMei = 送付物宛先ソース.dainoKubunMei;
            source.shimei1 = 送付物宛先ソース.shimei1;
            source.shimeiSmall1 = 送付物宛先ソース.shimeiSmall1;
            source.meishoFuyo1 = 送付物宛先ソース.meishoFuyo1;
            source.kakkoLeft2 = 送付物宛先ソース.kakkoLeft2;
            source.samabunShimei2 = 送付物宛先ソース.samabunShimei2;
            source.samabunShimeiSmall2 = 送付物宛先ソース.samabunShimeiSmall2;
            source.samabunShimeiText = 送付物宛先ソース.samabunShimeiText;
            source.samaBun2 = 送付物宛先ソース.samaBun2;
            source.kakkoRight2 = 送付物宛先ソース.kakkoRight2;
            source.kakkoLeft1 = 送付物宛先ソース.kakkoLeft1;
            source.samabunShimei1 = 送付物宛先ソース.samabunShimei1;
            source.samabunShimeiSmall1 = 送付物宛先ソース.samabunShimeiSmall1;
            source.samaBun1 = 送付物宛先ソース.samaBun1;
            source.kakkoRight1 = 送付物宛先ソース.kakkoRight1;
            source.customerBarCode = 送付物宛先ソース.customerBarCode;
        }
    }

    private void editCompNofushoItemAndCompRyoshushoItem(KanendoHokenryoNonyuTsuchishoKigotoSource source) {
        NofuShoKyotsu 納付書共通 = 本算定納入通知書情報.get納付書共通();
        if (納付書共通 != null) {
            source.nofushoKanendo = 半角to全角(納付書共通.get調定年度表記());
            source.nofushoNendo = 半角to全角(納付書共通.get調定年度表記());
            source.ryoshushoKanendo = 半角to全角(納付書共通.get調定年度表記());
            source.ryoshushoNendo = 半角to全角(納付書共通.get調定年度表記());
            source.nofushoKanendobun = 半角to全角(納付書共通.get賦課年度表記()).concat("分");
            source.ryoshushoKanendobun = 半角to全角(納付書共通.get賦課年度表記()).concat("分");
            source.nofushoSofusakiName = 納付書共通.get納付者氏名();
            if (納付書共通.get被代納人氏名() != null && !納付書共通.get被代納人氏名().isEmpty()) {
                source.nofushoKakko1 = new RString("(");
                source.nofushoKakko3 = 納付書共通.get被代納人敬称().concat(")");
                source.ryoshushoKakko1 = new RString("(");
                source.ryoshushoKakko3 = 納付書共通.get被代納人敬称().concat(")");
            }
            source.nofushoHonninName1 = 納付書共通.get被代納人氏名();
            source.nofushoKakko2 = RString.EMPTY;
            source.ryoshushoHonninName = 納付書共通.get被代納人氏名();
            source.ryoshushoKakko2 = RString.EMPTY;
            if (納付書共通.get通知書番号() != null) {
                source.nofushoTsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
                source.ryoshushoTsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
            }
            if (納付書共通.get世帯コード() != null) {
                source.nofushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
                source.ryoshushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
            }
            HyojiCodes 表示コード = 納付書共通.get表示コード();
            if (表示コード != null) {
                source.nofushohyojicodeName1 = 表示コード.get表示コード名１();
                source.nofushohyojicodeName2 = 表示コード.get表示コード名２();
                source.nofushohyojicodeName3 = 表示コード.get表示コード名３();
                source.nofushohyojicode1 = 表示コード.get表示コード１();
                source.nofushohyojicode2 = 表示コード.get表示コード２();
                source.nofushohyojicode3 = 表示コード.get表示コード３();
                source.ryoshushohyojicodeName1 = 表示コード.get表示コード名１();
                source.ryoshushohyojicodeName2 = 表示コード.get表示コード名２();
                source.ryoshushohyojicodeName3 = 表示コード.get表示コード名３();
                source.ryoshushohyojicode1 = 表示コード.get表示コード１();
                source.ryoshushohyojicode2 = 表示コード.get表示コード２();
                source.ryoshushoHyojicode3 = 表示コード.get表示コード３();
            }
            source.nofushoShichosonMei = 納付書共通.get納付書市町村名();
            source.ryoshushoYubinNo = 納付書共通.get郵便番号();
            source.ryoshushoGyoseikuName = 納付書共通.get行政区名();
            source.ryoshushoJusho = 納付書共通.get住所();
            source.ryoshushoKatagaki = 納付書共通.get方書();
            source.ryoshushoSofusakiName = 納付書共通.get納付者氏名();
            source.ryoshushoShichosonMei1 = 納付書共通.get納付書市町村名();
        }
        source.nofushoKi = 納入通知書期情報.get期表記();
        source.nofushoTsuki = 納入通知書期情報.get月表記();
        source.ryoshushoKi = 納入通知書期情報.get期表記();
        source.ryoshushoTsuki = 納入通知書期情報.get月表記();
        Map<Integer, RString> ocr = 納入通知書期情報.getOcr();
        if (ocr != null) {
            source.nofushoOcr1 = ocr.get(1);
            source.nofushoOcr2 = ocr.get(2);
            source.nofushoOcr3 = ocr.get(INT_3);
            source.nofushoOcr4 = ocr.get(INT_4);
        }
        source.nofushoNofugaku = 納入通知書期情報.get納付書納付額欄();
        source.nofushoNokigen = 納入通知書期情報.get納期限表記();
        source.nofushoNofuin = 納入通知書期情報.get領収日付欄();
        source.nofushoRyoshuHizukein = 納入通知書期情報.get納付書領収印欄();
        source.nofushoZuiji = 納入通知書期情報.get随時表記();
        source.ryoshushoNokigen = 納入通知書期情報.get納期限表記();
        source.ryoshushoNofugaku = 納入通知書期情報.get領収証書納付額欄();
        source.ryoshushoNofuin = 納入通知書期情報.get領収日付印欄();
        source.ryoshushoRyoshuHizukein = 納入通知書期情報.get領収証書領収印欄();
        source.ryoshushoZuiji = 納入通知書期情報.get調定額表記();
        source.ryoshushoRenban = new RString(連番).padLeft("0", INT_6);
        source.ryoshushoShichosonMei2 = RString.EMPTY;
    }

    private void editCompNinshosha(KanendoHokenryoNonyuTsuchishoKigotoSource source) {
        source.denshiKoin = ninshoshaSource.denshiKoin;
        source.hakkoYMD = ninshoshaSource.hakkoYMD;
        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
        source.ninshoshaYakushokuMei1 = ninshoshaSource.ninshoshaYakushokuMei1;
        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        source.ninshoshaYakushokuMei2 = ninshoshaSource.ninshoshaYakushokuMei2;
        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
        source.koinShoryaku = ninshoshaSource.koinShoryaku;
    }

    private void editレイヤ１(KanendoHokenryoNonyuTsuchishoKigotoSource source) {
        EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報 = 本算定納入通知書情報.get編集後本算定通知書共通情報();
        List<AfterEditInformation> 普徴納期情報リスト = new ArrayList<>();
        if (編集後本算定通知書共通情報 != null) {
            普徴納期情報リスト = 編集後本算定通知書共通情報.get普徴納期情報リスト();
            source.titleNendo = 半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
            if (編集後本算定通知書共通情報.get賦課年度_年度あり() != null) {
                source.titleKanendobun = 編集後本算定通知書共通情報.get賦課年度_年度あり().concat("分");
            }
            HyojiCodes 表示コード = 編集後本算定通知書共通情報.get表示コード();
            if (表示コード != null) {
                source.hyojiKomoku1 = 表示コード.get表示コード名１();
                source.hyojiKomoku2 = 表示コード.get表示コード名２();
                source.hyojiKomoku3 = 表示コード.get表示コード名３();
                source.hyojicode1 = 表示コード.get表示コード１();
                source.hyojicode2 = 表示コード.get表示コード２();
                source.hyojicode3 = 表示コード.get表示コード３();
            }
            if (編集後本算定通知書共通情報.get通知書番号() != null) {
                source.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().getColumnValue();
            }
            EditedKojin 編集後個人 = 編集後本算定通知書共通情報.get編集後個人();
            if (編集後個人 != null) {
                source.setaiCode = 編集後個人.get世帯コード().getColumnValue();
                source.hihokenshaName = 編集後個人.get名称().getName().getColumnValue();
                source.setaiNushiName = 編集後個人.get世帯主名().getColumnValue();
            }
            source.nendo = 編集後本算定通知書共通情報.get賦課年度_年度なし();
            source.nendo1 = 編集後本算定通知書共通情報.get賦課年度_年度なし();
            EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = 編集後本算定通知書共通情報.get更正後();
            edit更正後(source, 更正後);
            if (編集後本算定通知書共通情報.get特徴既に納付すべき額() != null) {
                source.tokuchoNofuSubekiGaku = new RString(編集後本算定通知書共通情報.get特徴既に納付すべき額().toString());
            }
            if (編集後本算定通知書共通情報.get普徴既に納付すべき額() != null) {
                source.fuchoNofuSubekiGaku = new RString(編集後本算定通知書共通情報.get普徴既に納付すべき額().toString());
            }
            if (編集後本算定通知書共通情報.get納付済額_未到来期含む() != null) {
                source.nofuZumiGaku = new RString(編集後本算定通知書共通情報.get納付済額_未到来期含む().toString());
            }
            if (編集後本算定通知書共通情報.get今後納付すべき額() != null) {
                source.kongoNofuSubekiGaku = new RString(編集後本算定通知書共通情報.get今後納付すべき額().toString());
            }
            EditedKoza 編集後口座 = 編集後本算定通知書共通情報.get編集後口座();
            if (編集後口座 != null) {
                source.bankCode = 編集後口座.get金融機関コードCombinedWith支店コード();
                source.bankName = 編集後口座.get金融機関名CombinedWith支店名();
                source.kozaShurui = 編集後口座.get口座種別略称();
                source.kozaNo = 編集後口座.get口座番号Or通帳記号番号();
                source.kozaMeigi = 編集後口座.get口座名義人優先();
            }
            source.hokenshaName = 編集後本算定通知書共通情報.get保険者名();
        }
        source.hyojicodeName1 = RString.EMPTY;
        source.hyojicodeName2 = RString.EMPTY;
        source.hyojicodeName3 = RString.EMPTY;
        edit納期(source, 普徴納期情報リスト);
        List<Kitsuki> 出力期リスト = 本算定納入通知書情報.get出力期リスト();
        if (出力期リスト != null && !出力期リスト.isEmpty()) {
            int 期 = 出力期リスト.get(0).get期AsInt();
            source.santeiKisoTokiTitle = new RString(期).padLeft(RString.HALF_SPACE, 2);
            if (編集後本算定通知書共通情報 != null && 編集後本算定通知書共通情報.get更正後() != null) {
                source.santeiKisoTokiHokenryoGaku = get普徴期別金額(編集後本算定通知書共通情報.get更正後().get普徴期別金額リスト(), 期);
            }
        }
        source.santeiKisoJikiTitle = RString.EMPTY;
        source.santeiKisoJikoHokenryoGaku = RString.EMPTY;
        source.renban = new RString(連番).padLeft("0", INT_6);
    }

    private RString 半角to全角(RString 半角) {
        if (null == 半角) {
            return RString.EMPTY;
        }
        return RStringUtil.convert半角to全角(半角);
    }

    private void edit納期(KanendoHokenryoNonyuTsuchishoKigotoSource source, List<AfterEditInformation> 普徴納期情報リスト) {
        HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報 = 本算定納入通知書情報.get本算定納入通知書制御情報();
        if (null == 本算定納入通知書制御情報) {
            本算定納入通知書制御情報 = new HonSanteiNonyuTsuchiShoSeigyoJoho();
        }
        if (本算定納入通知書制御情報.get納入通知書制御情報() != null) {
            AfterEditInformation 一番目普徴納期情報;
            if (普徴納期情報リスト != null && !普徴納期情報リスト.isEmpty()) {
                一番目普徴納期情報 = 普徴納期情報リスト.get(0);
            } else {
                一番目普徴納期情報 = new AfterEditInformation();
            }
            if (NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する
                    .equals(本算定納入通知書制御情報.get納入通知書制御情報().get納期限出力方法())) {
                source.ki1 = 納入通知書期情報.get期表記();
                source.tsuki1 = 納入通知書期情報.get月表記();
            } else if (NokigenShutsuryokuHoho.全ての期分を印字する
                    .equals(本算定納入通知書制御情報.get納入通知書制御情報().get納期限出力方法())) {
                source.ki1 = null == 納入通知書期情報.get期表記() ? RString.EMPTY : 納入通知書期情報.get期表記().padLeft(RString.HALF_SPACE, 2);
                source.tsuki1 = null == 納入通知書期情報.get月表記() ? RString.EMPTY : 納入通知書期情報.get月表記().padLeft(RString.HALF_SPACE, 2);
            }
            source.nokiKaishi1 = 一番目普徴納期情報.get納期開始日();
            source.nokiShuryo1 = 一番目普徴納期情報.get納期終了日();
        }
        source.ki2 = RString.EMPTY;
        source.tsuki2 = RString.EMPTY;
        source.nokiKaishi2 = RString.EMPTY;
        source.nokiShuryo2 = RString.EMPTY;
        source.ki3 = RString.EMPTY;
        source.tsuki3 = RString.EMPTY;
        source.nokiKaishi3 = RString.EMPTY;
        source.nokiShuryo3 = RString.EMPTY;
        source.ki4 = RString.EMPTY;
        source.tsuki4 = RString.EMPTY;
        source.nokiKaishi4 = RString.EMPTY;
        source.nokiShuryo4 = RString.EMPTY;
        source.ki5 = RString.EMPTY;
        source.tsuki5 = RString.EMPTY;
        source.nokiKaishi5 = RString.EMPTY;
        source.nokiShuryo5 = RString.EMPTY;
        source.ki6 = RString.EMPTY;
        source.tsuki6 = RString.EMPTY;
        source.nokiKaishi6 = RString.EMPTY;
        source.nokiShuryo6 = RString.EMPTY;
        source.ki7 = RString.EMPTY;
        source.tsuki7 = RString.EMPTY;
        source.nokiKaishi7 = RString.EMPTY;
        source.nokiShuryo7 = RString.EMPTY;
        source.ki8 = RString.EMPTY;
        source.tsuki8 = RString.EMPTY;
        source.nokiKaishi8 = RString.EMPTY;
        source.nokiShuryo8 = RString.EMPTY;
        source.ki9 = RString.EMPTY;
        source.tsuki9 = RString.EMPTY;
        source.nokiKaishi9 = RString.EMPTY;
        source.nokiShuryo9 = RString.EMPTY;
        source.ki10 = RString.EMPTY;
        source.tsuki10 = RString.EMPTY;
        source.nokiKaishi10 = RString.EMPTY;
        source.nokiShuryo10 = RString.EMPTY;
    }

    private RString get普徴期別金額(List<UniversalPhase> 普徴期別金額リスト, int 期) {
        if (普徴期別金額リスト != null) {
            for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
                if (普徴期別金額.get期() == 期) {
                    return null == 普徴期別金額.get金額() ? RString.EMPTY : new RString(普徴期別金額.get金額().toString());
                }
            }
        }
        return RString.EMPTY;
    }

    private void edit更正後(KanendoHokenryoNonyuTsuchishoKigotoSource source, EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後) {
        if (null == 更正後) {
            return;
        }
        source.kisoTsukisu = 更正後.get月数_ケ月();
        if (更正後.get確定保険料_年額() != null) {
            source.hokenryoGaku = new RString(更正後.get確定保険料_年額().toString());
        }
        source.kisoKikanKaishi = 更正後.get期間_自();
        source.kisoKikanShuryo = 更正後.get期間_至();
        source.kisoShotokuDankai = 半角to全角(更正後.get保険料段階());
        if (更正後.get保険料率() != null) {
            source.kisoHokenryoRitsu = new RString(更正後.get保険料率().toString());
        }
        if (更正後.get減免前保険料_年額() != null) {
            source.kisoCalHokenryoGaku = new RString(更正後.get減免前保険料_年額().toString());
        }
        if (更正後.get減免額() != null) {
            source.kisoGenmenGaku = new RString(更正後.get減免額().toString());
        }
    }

}
