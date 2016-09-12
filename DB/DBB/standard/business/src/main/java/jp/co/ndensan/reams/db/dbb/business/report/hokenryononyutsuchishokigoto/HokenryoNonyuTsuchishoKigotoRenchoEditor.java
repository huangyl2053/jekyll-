/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.hokenryononyutsuchishokigoto;

import java.util.ArrayList;
import java.util.HashMap;
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
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoRenchoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険料納入通知書（本算定）【期毎タイプ】HokenryoNonyuTsuchishoKigotoRenchoEditor
 *
 * @reamsid_L DBB-9110-080 huangh
 */
public class HokenryoNonyuTsuchishoKigotoRenchoEditor implements IHokenryoNonyuTsuchishoKigotoRenchoEditor {

    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final NofuShoKyotsu 納付書共通;
    private final NinshoshaSource ninshoshaSource;
    private static final int INDEX_0 = 0;
    private static final int INDEX_1 = 1;
    private static final int INDEX_2 = 2;
    private static final int INDEX_3 = 3;
    private static final int INDEX_4 = 4;
    private static final int INDEX_5 = 5;
    private static final int INDEX_6 = 6;
    private static final int INDEX_7 = 7;
    private static final int INDEX_8 = 8;
    private static final int INDEX_9 = 9;
    private static final int INDEX_10 = 10;

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HonSanteiNonyuTsuchiShoJoho}
     * @param 納入通知書期情報 納入通知書期情報
     * @param ninshoshaSource 認証者情報
     */
    protected HokenryoNonyuTsuchishoKigotoRenchoEditor(HonSanteiNonyuTsuchiShoJoho item,
            NonyuTsuchiShoKiJoho 納入通知書期情報,
            NinshoshaSource ninshoshaSource) {
        this.本算定納入通知書情報 = null == item ? new HonSanteiNonyuTsuchiShoJoho() : item;
        this.編集後本算定通知書共通情報 = null == 本算定納入通知書情報.get編集後本算定通知書共通情報()
                ? new EditedHonSanteiTsuchiShoKyotsu() : 本算定納入通知書情報.get編集後本算定通知書共通情報();
        this.本算定納入通知書制御情報 = null == 本算定納入通知書情報.get本算定納入通知書制御情報()
                ? new HonSanteiNonyuTsuchiShoSeigyoJoho() : 本算定納入通知書情報.get本算定納入通知書制御情報();
        this.納入通知書期情報 = 納入通知書期情報;
        this.納付書共通 = null == 本算定納入通知書情報.get納付書共通() ? new NofuShoKyotsu() : 本算定納入通知書情報.get納付書共通();
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public HokenryoNonyuTsuchishoKigotoRenchoSource edit(HokenryoNonyuTsuchishoKigotoRenchoSource source) {
        editレイヤ１(source);
        editCompNinshosha(source);
        editCompNofushoItem(source);
        editCompRyoshushoItem(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editCompSofubutsuAtesaki(HokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (本算定納入通知書情報.get編集後本算定通知書共通情報() != null
                && 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先() != null
                && 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource() != null) {
            SofubutsuAtesakiSource sofubutsuAtesakiSource
                    = 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource().get送付物宛先ソース();
            if (null == sofubutsuAtesakiSource) {
                return;
            }
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
        }
    }

    private void editCompRyoshushoItem(HokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKanendo = RString.EMPTY;
        source.ryoshushoNendo = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
        source.ryoshushoKanendobun = RString.EMPTY;
        source.ryoshushoKi = 納入通知書期情報.get期表記();
        source.ryoshushoTsuki = 納入通知書期情報.get月表記();
        source.ryoshushoYubinNo = 納付書共通.get郵便番号();
        source.ryoshushoGyoseikuName = 納付書共通.get行政区名();
        source.ryoshushoJusho = 納付書共通.get住所();
        source.ryoshushoKatagaki = 納付書共通.get方書();
        source.ryoshushoSofusakiName = 納付書共通.get納付者氏名();
        RString 被代納人氏名 = 納付書共通.get被代納人氏名();
        source.ryoshushoHonninName = 被代納人氏名;
        source.ryoshushoKakko2 = RString.EMPTY;
        if (!被代納人氏名.isNullOrEmpty()) {
            source.ryoshushoKakko1 = new RString("(");
            source.ryoshushoKakko3 = 納付書共通.get被代納人敬称() == null ? new RString(")") : 納付書共通.get被代納人敬称().concat(")");
        }
        if (納付書共通.get通知書番号() != null) {
            source.ryoshushoTsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
        }
        if (納付書共通.get世帯コード() != null) {
            source.ryoshushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
        }

        HyojiCodes 表示コード = null == 納付書共通.get表示コード() ? new HyojiCodes() : 納付書共通.get表示コード();
        source.ryoshushohyojicodeName1 = 表示コード.get表示コード名１();
        source.ryoshushohyojicode1 = 表示コード.get表示コード１();
        source.ryoshushohyojicodeName2 = 表示コード.get表示コード名２();
        source.ryoshushohyojicode2 = 表示コード.get表示コード２();
        source.ryoshushohyojicodeName3 = 表示コード.get表示コード名３();
        source.ryoshushoHyojicode3 = 表示コード.get表示コード３();
        source.ryoshushoNokigen = 納入通知書期情報.get納期限表記();
        source.ryoshushoNofugaku = 納入通知書期情報.get領収証書納付額欄();
        source.ryoshushoNofuin = 納入通知書期情報.get領収日付印欄();
        source.ryoshushoRyoshuHizukein = 納入通知書期情報.get領収証書領収印欄();
        source.ryoshushoZuiji = 納入通知書期情報.get随時表記();
        source.ryoshushoRenban = new RString(本算定納入通知書情報.get連番()).padLeft("0", INDEX_6);
        source.ryoshushoShichosonMei1 = 納付書共通.get納付書市町村名();
        source.ryoshushoShichosonMei2 = RString.EMPTY;
    }

    private void editCompNofushoItem(HokenryoNonyuTsuchishoKigotoRenchoSource source) {
        Map<Integer, RString> ocr = 納入通知書期情報.getOcr();
        if (ocr == null || ocr.isEmpty()) {
            ocr = new HashMap<>();
        }
        source.nofushoKanendo = RString.EMPTY;
        source.nofushoNendo = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
        source.nofushoKanendobun = RString.EMPTY;
        source.nofushoKi = 納入通知書期情報.get期表記();
        source.nofushoTsuki = 納入通知書期情報.get月表記();
        source.nofushoOcr1 = ocr.get(INDEX_1);
        source.nofushoOcr2 = ocr.get(INDEX_2);
        source.nofushoOcr3 = ocr.get(INDEX_3);
        source.nofushoOcr4 = ocr.get(INDEX_4);
        source.nofushoNofugaku = 納入通知書期情報.get納付書納付額欄();
        source.nofushoSofusakiName = 納付書共通.get納付者氏名();
        RString 被代納人氏名 = 納付書共通.get被代納人氏名();
        source.nofushoHonninName1 = 被代納人氏名;
        source.nofushoKakko2 = RString.EMPTY;
        if (!被代納人氏名.isNullOrEmpty()) {
            source.nofushoKakko1 = new RString("(");
            source.nofushoKakko3 = 納付書共通.get被代納人敬称() == null ? new RString(")") : 納付書共通.get被代納人敬称().concat(")");
        }
        if (納付書共通.get通知書番号() != null) {
            source.nofushoTsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
        }
        if (納付書共通.get世帯コード() != null) {
            source.nofushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
        }
        HyojiCodes 表示コード = null == 納付書共通.get表示コード() ? new HyojiCodes() : 納付書共通.get表示コード();
        source.nofushohyojicodeName1 = 表示コード.get表示コード名１();
        source.nofushohyojicode1 = 表示コード.get表示コード１();
        source.nofushohyojicodeName2 = 表示コード.get表示コード名２();
        source.nofushohyojicode2 = 表示コード.get表示コード２();
        source.nofushohyojicodeName3 = 表示コード.get表示コード名３();
        source.nofushohyojicode3 = 表示コード.get表示コード３();
        source.nofushoNokigen = 納入通知書期情報.get納期限表記();
        source.nofushoNofuin = 納入通知書期情報.get領収日付欄();
        source.nofushoRyoshuHizukein = 納入通知書期情報.get納付書領収印欄();
        source.nofushoZuiji = 納入通知書期情報.get随時表記();
        source.nofushoShichosonMei = 納付書共通.get納付書市町村名();
    }

    private void editCompNinshosha(HokenryoNonyuTsuchishoKigotoRenchoSource source) {
        if (ninshoshaSource != null) {
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
    }

    private void editレイヤ１(HokenryoNonyuTsuchishoKigotoRenchoSource source) {

        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = null == 編集後本算定通知書共通情報.get更正後()
                ? new EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection() : 編集後本算定通知書共通情報.get更正後();
        this.edit期月(source);

        source.hyojicodeName1 = RString.EMPTY;
        source.hyojicodeName2 = RString.EMPTY;
        source.hyojicodeName3 = RString.EMPTY;
        HyojiCodes 表示コード = null == 編集後本算定通知書共通情報.get表示コード() ? new HyojiCodes() : 編集後本算定通知書共通情報.get表示コード();
        source.hyojiKomoku1 = 表示コード.get表示コード名１();
        source.hyojiKomoku2 = 表示コード.get表示コード名２();
        source.hyojiKomoku3 = 表示コード.get表示コード名３();
        source.hyojicode1 = 表示コード.get表示コード１();
        source.hyojicode2 = 表示コード.get表示コード２();
        source.hyojicode3 = 表示コード.get表示コード３();
        if (編集後本算定通知書共通情報.get通知書番号() != null) {
            source.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().getColumnValue();
        }
        if (編集後本算定通知書共通情報.get編集後個人() != null) {
            if (編集後本算定通知書共通情報.get編集後個人().get世帯コード() != null) {
                source.setaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue();
            }
            if (編集後本算定通知書共通情報.get編集後個人().get名称() != null
                    && 編集後本算定通知書共通情報.get編集後個人().get名称().getName() != null) {
                source.hihokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().getColumnValue();
            }
            if (編集後本算定通知書共通情報.get編集後個人().get世帯主名() != null) {
                source.setaiNushiName = 編集後本算定通知書共通情報.get編集後個人().get世帯主名().getColumnValue();
            }
        }

        source.nendo = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        source.nendo1 = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        if (更正後.get確定保険料_年額() != null) {
            source.hokenryoGaku = new RString(更正後.get確定保険料_年額().toString());
        }
        source.kisoKikanKaishi = 更正後.get期間_自();
        source.kisoKikanShuryo = 更正後.get期間_至();
        source.kisoTsukisu = 更正後.get月数_ケ月();
        source.kisoShotokuDankai = RStringUtil.convert半角to全角(更正後.get保険料段階());
        if (更正後.get保険料率() != null) {
            source.kisoHokenryoRitsu = new RString(更正後.get保険料率().toString());
        }
        if (更正後.get減免前保険料_年額() != null) {
            source.kisoCalHokenryoGaku = new RString(更正後.get減免前保険料_年額().toString());
        }
        if (更正後.get減免額() != null) {
            source.kisoGenmenGaku = new RString(更正後.get減免額().toString());
        }
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

        List<UniversalPhase> 普徴期別金額リスト = 更正後.get普徴期別金額リスト();
        int 期 = 納入通知書期情報.get期();
        source.santeiKisoTokiHokenryoGaku = new RString(get普徴期別金額By期(普徴期別金額リスト, 期).toString());
        source.santeiKisoJikiTitle = new RString("次期以降");
        source.santeiKisoJikoHokenryoGaku = new RString(get普徴期別金額By期(普徴期別金額リスト, 期 + 1).toString());
        if (編集後本算定通知書共通情報.get編集後口座() != null) {
            source.bankName = 編集後本算定通知書共通情報.get編集後口座().get金融機関名CombinedWith支店名();
            source.kozaMeigi = 編集後本算定通知書共通情報.get編集後口座().get口座名義人優先();
            source.bankCode = 編集後本算定通知書共通情報.get編集後口座().get金融機関コードCombinedWith支店コード();
            source.kozaShurui = 編集後本算定通知書共通情報.get編集後口座().get口座種別略称();
            source.kozaNo = 編集後本算定通知書共通情報.get編集後口座().get口座番号Or通帳記号番号();
        }
    }

    private void edit期月(HokenryoNonyuTsuchishoKigotoRenchoSource source) {
        boolean is納期限出力方法が0 = is納期限出力方法が0();
        List<AfterEditInformation> 普徴納期情報リスト = null == 編集後本算定通知書共通情報.get普徴納期情報リスト()
                ? new ArrayList<AfterEditInformation>() : 編集後本算定通知書共通情報.get普徴納期情報リスト();
        AfterEditInformation 普徴納期情報リストの一番目 = get普徴納期情報By番目(普徴納期情報リスト, INDEX_0);
        AfterEditInformation 普徴納期情報リストの二番目 = get普徴納期情報By番目(普徴納期情報リスト, INDEX_1);
        AfterEditInformation 普徴納期情報リストの三番目 = get普徴納期情報By番目(普徴納期情報リスト, INDEX_2);
        AfterEditInformation 普徴納期情報リストの四番目 = get普徴納期情報By番目(普徴納期情報リスト, INDEX_3);
        AfterEditInformation 普徴納期情報リストの五番目 = get普徴納期情報By番目(普徴納期情報リスト, INDEX_4);
        AfterEditInformation 普徴納期情報リストの六番目 = get普徴納期情報By番目(普徴納期情報リスト, INDEX_5);
        AfterEditInformation 普徴納期情報リストの七番目 = get普徴納期情報By番目(普徴納期情報リスト, INDEX_6);
        AfterEditInformation 普徴納期情報リストの八番目 = get普徴納期情報By番目(普徴納期情報リスト, INDEX_7);
        AfterEditInformation 普徴納期情報リストの九番目 = get普徴納期情報By番目(普徴納期情報リスト, INDEX_8);
        AfterEditInformation 普徴納期情報リストの十番目 = get普徴納期情報By番目(普徴納期情報リスト, INDEX_9);
        AfterEditInformation 普徴納期情報リスト1期 = get普徴納期情報By期(普徴納期情報リスト, INDEX_1);
        AfterEditInformation 普徴納期情報リスト2期 = get普徴納期情報By期(普徴納期情報リスト, INDEX_2);
        AfterEditInformation 普徴納期情報リスト3期 = get普徴納期情報By期(普徴納期情報リスト, INDEX_3);
        AfterEditInformation 普徴納期情報リスト4期 = get普徴納期情報By期(普徴納期情報リスト, INDEX_4);
        AfterEditInformation 普徴納期情報リスト5期 = get普徴納期情報By期(普徴納期情報リスト, INDEX_5);
        AfterEditInformation 普徴納期情報リスト6期 = get普徴納期情報By期(普徴納期情報リスト, INDEX_6);
        AfterEditInformation 普徴納期情報リスト7期 = get普徴納期情報By期(普徴納期情報リスト, INDEX_7);
        AfterEditInformation 普徴納期情報リスト8期 = get普徴納期情報By期(普徴納期情報リスト, INDEX_8);
        AfterEditInformation 普徴納期情報リスト9期 = get普徴納期情報By期(普徴納期情報リスト, INDEX_9);
        AfterEditInformation 普徴納期情報リスト10期 = get普徴納期情報By期(普徴納期情報リスト, INDEX_10);

        source.titleNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());
        source.nokiKaishi1 = get納期開始日(普徴納期情報リスト1期);
        source.nokiShuryo1 = get納期終了日(普徴納期情報リスト1期);
        source.nokiKaishi2 = get納期開始日(普徴納期情報リスト2期);
        source.nokiShuryo2 = get納期終了日(普徴納期情報リスト2期);
        source.nokiKaishi3 = get納期開始日(普徴納期情報リスト3期);
        source.nokiShuryo3 = get納期終了日(普徴納期情報リスト3期);
        source.nokiKaishi4 = get納期開始日(普徴納期情報リスト4期);
        source.nokiShuryo4 = get納期終了日(普徴納期情報リスト4期);
        source.nokiKaishi5 = get納期開始日(普徴納期情報リスト5期);
        source.nokiShuryo5 = get納期終了日(普徴納期情報リスト5期);
        source.nokiKaishi6 = get納期開始日(普徴納期情報リスト6期);
        source.nokiShuryo6 = get納期終了日(普徴納期情報リスト6期);
        source.nokiKaishi7 = get納期開始日(普徴納期情報リスト7期);
        source.nokiShuryo7 = get納期終了日(普徴納期情報リスト7期);
        source.nokiKaishi8 = get納期開始日(普徴納期情報リスト8期);
        source.nokiShuryo8 = get納期終了日(普徴納期情報リスト8期);
        source.nokiKaishi9 = get納期開始日(普徴納期情報リスト9期);
        source.nokiShuryo9 = get納期終了日(普徴納期情報リスト9期);
        source.nokiKaishi10 = get納期開始日(普徴納期情報リスト10期);
        source.nokiShuryo10 = get納期開始日(普徴納期情報リスト10期);

        if (is納期限出力方法が0) {
            source.ki1 = 納入通知書期情報.get期表記();
            source.tsuki1 = 納入通知書期情報.get月表記();
            source.ki2 = RString.EMPTY;
            source.tsuki2 = RString.EMPTY;
            source.ki3 = RString.EMPTY;
            source.tsuki3 = RString.EMPTY;
            source.ki4 = RString.EMPTY;
            source.tsuki4 = RString.EMPTY;
            source.ki5 = RString.EMPTY;
            source.tsuki5 = RString.EMPTY;
            source.ki6 = RString.EMPTY;
            source.tsuki6 = RString.EMPTY;
            source.ki7 = RString.EMPTY;
            source.tsuki7 = RString.EMPTY;
            source.ki8 = RString.EMPTY;
            source.tsuki8 = RString.EMPTY;
            source.ki9 = RString.EMPTY;
            source.tsuki9 = RString.EMPTY;
            source.ki10 = RString.EMPTY;
            source.tsuki10 = RString.EMPTY;
        } else {
            source.ki1 = edit2ケタ空白埋め(普徴納期情報リストの一番目.get期());
            source.tsuki1 = edit2ケタ空白埋め(普徴納期情報リストの一番目.get月());
            source.ki2 = edit2ケタ空白埋め(普徴納期情報リストの二番目.get期());
            source.tsuki2 = edit2ケタ空白埋め(普徴納期情報リストの二番目.get月());
            source.ki3 = edit2ケタ空白埋め(普徴納期情報リストの三番目.get期());
            source.tsuki3 = edit2ケタ空白埋め(普徴納期情報リストの三番目.get月());
            source.ki4 = edit2ケタ空白埋め(普徴納期情報リストの四番目.get期());
            source.tsuki4 = edit2ケタ空白埋め(普徴納期情報リストの四番目.get月());
            source.ki5 = edit2ケタ空白埋め(普徴納期情報リストの五番目.get期());
            source.tsuki5 = edit2ケタ空白埋め(普徴納期情報リストの五番目.get月());
            source.ki6 = edit2ケタ空白埋め(普徴納期情報リストの六番目.get期());
            source.tsuki6 = edit2ケタ空白埋め(普徴納期情報リストの六番目.get月());
            source.ki7 = edit2ケタ空白埋め(普徴納期情報リストの七番目.get期());
            source.tsuki7 = edit2ケタ空白埋め(普徴納期情報リストの七番目.get月());
            source.ki8 = edit2ケタ空白埋め(普徴納期情報リストの八番目.get期());
            source.tsuki8 = edit2ケタ空白埋め(普徴納期情報リストの八番目.get月());
            source.ki9 = edit2ケタ空白埋め(普徴納期情報リストの九番目.get期());
            source.tsuki9 = edit2ケタ空白埋め(普徴納期情報リストの九番目.get月());
            source.ki10 = edit2ケタ空白埋め(普徴納期情報リストの十番目.get期());
            source.tsuki10 = edit2ケタ空白埋め(普徴納期情報リストの十番目.get月());
        }
        source.santeiKisoTokiTitle = edit2ケタ空白埋め(普徴納期情報リストの一番目.get期());
    }

    private RString edit2ケタ空白埋め(RString editor) {

        if (editor == null) {
            return RString.EMPTY;
        }

        return editor.padLeft(RString.HALF_SPACE, 2);
    }

    private Decimal get普徴期別金額By期(List<UniversalPhase> 普徴期別金額リスト, int 期) {
        for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
            if (普徴期別金額.get期() == 期) {
                return 普徴期別金額.get金額();
            }
        }
        return Decimal.ZERO;
    }

    private AfterEditInformation get普徴納期情報By期(List<AfterEditInformation> 普徴納期情報リスト, int 期) {
        for (AfterEditInformation 普徴納期情報 : 普徴納期情報リスト) {
            if (Integer.parseInt(普徴納期情報.get期().toString()) == 期) {
                return 普徴納期情報;
            }
        }
        return null;
    }

    private AfterEditInformation get普徴納期情報By番目(List<AfterEditInformation> 普徴納期情報リスト, int 番目) {
        return !普徴納期情報リスト.isEmpty() && 普徴納期情報リスト.size() >= 番目 + 1 ? 普徴納期情報リスト.get(番目) : new AfterEditInformation();
    }

    private boolean is納期限出力方法が0() {
        return NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(本算定納入通知書制御情報.get納入通知書制御情報().get納期限出力方法());
    }

    private RString get納期開始日(AfterEditInformation data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return data.get納期開始日();
    }

    private RString get納期終了日(AfterEditInformation data) {
        if (data == null) {
            return RString.EMPTY;
        }
        return data.get納期終了日();
    }
}
