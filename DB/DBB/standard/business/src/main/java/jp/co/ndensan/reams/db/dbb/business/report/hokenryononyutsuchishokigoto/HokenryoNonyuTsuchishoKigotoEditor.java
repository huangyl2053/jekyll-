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
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NofugakuSanshutsuHoho;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NokigenShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.hokenryononyutsuchishokigoto.HokenryoNonyuTsuchishoKigotoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 保険料納入通知書（本算定）【期毎タイプ】HokenryoNonyuTsuchishoKigotoEditor
 *
 * @reamsid_L DBB-9110-080 liangbc
 */
public class HokenryoNonyuTsuchishoKigotoEditor implements IHokenryoNonyuTsuchishoKigotoEditor {

    private final EditedHonSanteiTsuchiShoKyotsu 編集後本算定通知書共通情報;
    private final HonSanteiNonyuTsuchiShoJoho 本算定納入通知書情報;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final NofuShoKyotsu 納付書共通;
    private final HonSanteiNonyuTsuchiShoSeigyoJoho 本算定納入通知書制御情報;
    private final NinshoshaSource ninshoshaSource;
    private static final int INDEX定数_0 = 0;
    private static final int INDEX定数_1 = 1;
    private static final int INDEX定数_2 = 2;
    private static final int INDEX定数_3 = 3;
    private static final int INDEX定数_4 = 4;
    private static final int INDEX定数_5 = 5;
    private static final int INDEX定数_6 = 6;
    private static final int INDEX定数_7 = 7;
    private static final int INDEX定数_8 = 8;
    private static final int INDEX定数_9 = 9;
    private static final int INDEX定数_10 = 10;
    private static final RString 第 = new RString("第");
    private static final RString 期 = new RString("期");

    /**
     * インスタンスを生成します。
     *
     * @param item {@link HonSanteiNonyuTsuchiShoJoho}
     * @param 納入通知書期情報 納入通知書期情報
     * @param ninshoshaSource 認証者情報
     */
    protected HokenryoNonyuTsuchishoKigotoEditor(HonSanteiNonyuTsuchiShoJoho item,
            NonyuTsuchiShoKiJoho 納入通知書期情報,
            NinshoshaSource ninshoshaSource) {
        this.本算定納入通知書情報 = null == item ? new HonSanteiNonyuTsuchiShoJoho() : item;
        this.本算定納入通知書制御情報 = null == 本算定納入通知書情報.get本算定納入通知書制御情報()
                ? new HonSanteiNonyuTsuchiShoSeigyoJoho() : 本算定納入通知書情報.get本算定納入通知書制御情報();
        this.編集後本算定通知書共通情報 = null == 本算定納入通知書情報.get編集後本算定通知書共通情報()
                ? new EditedHonSanteiTsuchiShoKyotsu() : 本算定納入通知書情報.get編集後本算定通知書共通情報();
        this.納付書共通 = null == 本算定納入通知書情報.get納付書共通() ? new NofuShoKyotsu() : 本算定納入通知書情報.get納付書共通();
        this.納入通知書期情報 = 納入通知書期情報;
        this.ninshoshaSource = ninshoshaSource;
    }

    @Override
    public HokenryoNonyuTsuchishoKigotoSource edit(HokenryoNonyuTsuchishoKigotoSource source) {
        editレイヤ１(source);
        editCompNinshosha(source);
        editCompNofushoItem(source);
        editCompRyoshushoItem(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editCompSofubutsuAtesaki(HokenryoNonyuTsuchishoKigotoSource source) {
        if (本算定納入通知書情報.get編集後本算定通知書共通情報() != null
                && 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先() != null
                && 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource() != null) {
            SofubutsuAtesakiSource 送付物宛先Source
                    = 本算定納入通知書情報.get編集後本算定通知書共通情報().get編集後宛先().getSofubutsuAtesakiSource().get送付物宛先ソース();
            if (null == 送付物宛先Source) {
                return;
            }
            source.customerBarCode = 送付物宛先Source.customerBarCode;
            source.dainoKubunMei = 送付物宛先Source.dainoKubunMei;
            source.gyoseiku = 送付物宛先Source.gyoseiku;
            source.jusho1 = 送付物宛先Source.jusho1;
            source.jusho2 = 送付物宛先Source.jusho2;
            source.jusho3 = 送付物宛先Source.jusho3;
            source.jushoText = 送付物宛先Source.jushoText;
            source.kakkoLeft1 = 送付物宛先Source.kakkoLeft1;
            source.kakkoLeft2 = 送付物宛先Source.kakkoLeft2;
            source.kakkoRight1 = 送付物宛先Source.kakkoRight1;
            source.kakkoRight2 = 送付物宛先Source.kakkoRight2;
            source.katagaki1 = 送付物宛先Source.katagaki1;
            source.katagaki2 = 送付物宛先Source.katagaki2;
            source.katagakiSmall1 = 送付物宛先Source.katagakiSmall1;
            source.katagakiSmall2 = 送付物宛先Source.katagakiSmall2;
            source.katagakiText = 送付物宛先Source.katagakiText;
            source.meishoFuyo1 = 送付物宛先Source.meishoFuyo1;
            source.meishoFuyo2 = 送付物宛先Source.meishoFuyo2;
            source.samaBun1 = 送付物宛先Source.samaBun1;
            source.samaBun2 = 送付物宛先Source.samaBun2;
            source.samabunShimei1 = 送付物宛先Source.samabunShimei1;
            source.samabunShimei2 = 送付物宛先Source.samabunShimei2;
            source.samabunShimeiSmall1 = 送付物宛先Source.samabunShimeiSmall1;
            source.samabunShimeiSmall2 = 送付物宛先Source.samabunShimeiSmall2;
            source.samabunShimeiText = 送付物宛先Source.samabunShimeiText;
            source.shimei1 = 送付物宛先Source.shimei1;
            source.shimei2 = 送付物宛先Source.shimei2;
            source.shimeiSmall1 = 送付物宛先Source.shimeiSmall1;
            source.shimeiSmall2 = 送付物宛先Source.shimeiSmall2;
            source.shimeiText = 送付物宛先Source.shimeiText;
            source.yubinNo = 送付物宛先Source.yubinNo;
        }
    }

    private void editCompRyoshushoItem(HokenryoNonyuTsuchishoKigotoSource source) {
        source.ryoshushoKanendo = RString.EMPTY;
        source.ryoshushoNendo = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
        source.ryoshushoKanendobun = RString.EMPTY;
        source.ryoshushoKi = new RString(納入通知書期情報.get期());
        source.ryoshushoTsuki = 納入通知書期情報.get月表記();
        source.ryoshushoGyoseikuName = 納付書共通.get行政区名();
        source.ryoshushoYubinNo = 納付書共通.get郵便番号();
        source.ryoshushoJusho = 納付書共通.get住所();
        source.ryoshushoKatagaki = 納付書共通.get方書();
        source.ryoshushoSofusakiName = 納付書共通.get納付者氏名();
        RString 被代納人氏名 = 納付書共通.get被代納人氏名();
        source.ryoshushoKakko2 = RString.EMPTY;
        source.ryoshushoHonninName = 被代納人氏名;
        if (!被代納人氏名.isNullOrEmpty()) {
            source.ryoshushoKakko1 = new RString("(");
            source.ryoshushoKakko3 = 納付書共通.get被代納人敬称() == null ? new RString(")") : 納付書共通.get被代納人敬称().concat(")");
        }
        if (納付書共通.get世帯コード() != null) {
            source.ryoshushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
        }
        if (納付書共通.get通知書番号() != null) {
            source.ryoshushoTsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
        }

        HyojiCodes 表示コード = null == 納付書共通.get表示コード() ? new HyojiCodes() : 納付書共通.get表示コード();
        source.ryoshushohyojicode1 = 表示コード.get表示コード１();
        source.ryoshushohyojicodeName1 = 表示コード.get表示コード名１();
        source.ryoshushohyojicode2 = 表示コード.get表示コード２();
        source.ryoshushohyojicodeName2 = 表示コード.get表示コード名２();
        source.ryoshushoHyojicode3 = 表示コード.get表示コード３();
        source.ryoshushohyojicodeName3 = 表示コード.get表示コード名３();
        source.ryoshushoNokigen = 納入通知書期情報.get納期限表記();
        source.ryoshushoNofugaku = 納入通知書期情報.get領収証書納付額欄();
        source.ryoshushoRyoshuHizukein = 納入通知書期情報.get領収証書領収印欄();
        source.ryoshushoNofuin = 納入通知書期情報.get領収日付印欄();
        source.ryoshushoZuiji = 納入通知書期情報.get随時表記();
        source.ryoshushoRenban = new RString(本算定納入通知書情報.get連番()).padLeft("0", INDEX定数_6);
        source.ryoshushoShichosonMei2 = RString.EMPTY;
        source.ryoshushoShichosonMei1 = 納付書共通.get納付書市町村名();
    }

    private void editCompNofushoItem(HokenryoNonyuTsuchishoKigotoSource source) {
        Map<Integer, RString> ocr = 納入通知書期情報.getOcr();
        if (ocr == null || ocr.isEmpty()) {
            ocr = new HashMap<>();
        }
        source.nofushoKanendo = RString.EMPTY;
        source.nofushoNendo = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
        source.nofushoKanendobun = RString.EMPTY;
        source.nofushoKi = new RString(納入通知書期情報.get期());
        source.nofushoTsuki = 納入通知書期情報.get月表記();
        source.nofushoOcr1 = ocr.get(INDEX定数_1);
        source.nofushoOcr2 = ocr.get(INDEX定数_2);
        source.nofushoOcr3 = ocr.get(INDEX定数_3);
        source.nofushoOcr4 = ocr.get(INDEX定数_4);
        source.nofushoNofugaku = 納入通知書期情報.get納付書納付額欄();
        source.nofushoSofusakiName = 納付書共通.get納付者氏名();
        RString 被代納人氏名 = 納付書共通.get被代納人氏名();
        source.nofushoKakko2 = RString.EMPTY;
        source.nofushoHonninName1 = 被代納人氏名;
        if (!RString.isNullOrEmpty(被代納人氏名)) {
            source.nofushoKakko1 = new RString("(");
            source.nofushoKakko3 = null == 納付書共通.get被代納人敬称() ? new RString(")") : 納付書共通.get被代納人敬称().concat(")");
        }
        source.nofushoTsuchishoNo = null == 納付書共通.get通知書番号() ? null : 納付書共通.get通知書番号().getColumnValue();
        if (納付書共通.get世帯コード() != null) {
            source.nofushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
        }
        HyojiCodes 表示コード = null == 納付書共通.get表示コード() ? new HyojiCodes() : 納付書共通.get表示コード();
        source.nofushohyojicode1 = 表示コード.get表示コード１();
        source.nofushohyojicodeName1 = 表示コード.get表示コード名１();
        source.nofushohyojicode2 = 表示コード.get表示コード２();
        source.nofushohyojicodeName2 = 表示コード.get表示コード名２();
        source.nofushohyojicode3 = 表示コード.get表示コード３();
        source.nofushohyojicodeName3 = 表示コード.get表示コード名３();
        source.nofushoNokigen = 納入通知書期情報.get納期限表記();
        source.nofushoNofuin = 納入通知書期情報.get領収日付欄();
        source.nofushoRyoshuHizukein = 納入通知書期情報.get納付書領収印欄();
        source.nofushoShichosonMei = 納付書共通.get納付書市町村名();
        source.nofushoZuiji = 納入通知書期情報.get随時表記();
    }

    private void editCompNinshosha(HokenryoNonyuTsuchishoKigotoSource source) {
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

    private void editレイヤ１(HokenryoNonyuTsuchishoKigotoSource source) {
        EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection 更正後 = null == 編集後本算定通知書共通情報.get更正後()
                ? new EditedHonSanteiTsuchiShoKyotsuBeforeOrAfterCorrection() : 編集後本算定通知書共通情報.get更正後();
        this.edit期月(source);

        HyojiCodes 表示コード = null == 編集後本算定通知書共通情報.get表示コード() ? new HyojiCodes() : 編集後本算定通知書共通情報.get表示コード();
        source.hyojicode1 = 表示コード.get表示コード１();
        source.hyojicode2 = 表示コード.get表示コード２();
        source.hyojicode3 = 表示コード.get表示コード３();
        source.hyojiKomoku1 = 表示コード.get表示コード名１();
        source.hyojiKomoku2 = 表示コード.get表示コード名２();
        source.hyojiKomoku3 = 表示コード.get表示コード名３();
        source.hyojicodeName1 = RString.EMPTY;
        source.hyojicodeName2 = RString.EMPTY;
        source.hyojicodeName3 = RString.EMPTY;
        if (編集後本算定通知書共通情報.get通知書番号() != null) {
            source.tsuchishoNo = 編集後本算定通知書共通情報.get通知書番号().getColumnValue();
        }
        if (編集後本算定通知書共通情報.get編集後個人() != null) {
            if (編集後本算定通知書共通情報.get編集後個人().get世帯主名() != null) {
                source.setaiNushiName = 編集後本算定通知書共通情報.get編集後個人().get世帯主名().getColumnValue();
            }
            if (編集後本算定通知書共通情報.get編集後個人().get名称() != null
                    && 編集後本算定通知書共通情報.get編集後個人().get名称().getName() != null) {
                source.hihokenshaName = 編集後本算定通知書共通情報.get編集後個人().get名称().getName().getColumnValue();
            }
            if (編集後本算定通知書共通情報.get編集後個人().get世帯コード() != null) {
                source.setaiCode = 編集後本算定通知書共通情報.get編集後個人().get世帯コード().getColumnValue();
            }
        }

        source.nendo = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        source.nendo1 = 編集後本算定通知書共通情報.get賦課年度_年度なし();
        source.hokenryoGaku = getコンマ区切りRString(更正後.get確定保険料_年額());
        source.kisoKikanKaishi = 更正後.get期間_自();
        source.kisoKikanShuryo = 更正後.get期間_至();
        source.kisoTsukisu = 更正後.get月数_ケ月();
        source.kisoShotokuDankai = RStringUtil.convert半角to全角(更正後.get保険料段階());
        source.kisoHokenryoRitsu = getコンマ区切りRString(更正後.get保険料率());
        source.kisoCalHokenryoGaku = getコンマ区切りRString(更正後.get減免前保険料_年額());
        source.kisoGenmenGaku = getコンマ区切りRString(更正後.get減免額());
        source.tokuchoNofuSubekiGaku = getコンマ区切りRString(編集後本算定通知書共通情報.get特別徴収額合計());
        source.fuchoNofuSubekiGaku = getコンマ区切りRString(編集後本算定通知書共通情報.get普通徴収額合計());
        NofugakuSanshutsuHoho 納付額算出方法 = 本算定納入通知書制御情報.get納入通知書制御情報().get納付額算出方法();
        if (NofugakuSanshutsuHoho.収入額をもとに算出.equals(納付額算出方法)) {
            source.nofuZumiGaku = getコンマ区切りRString(編集後本算定通知書共通情報.get納付済額_未到来期含む());
            source.kongoNofuSubekiGaku = getコンマ区切りRString(編集後本算定通知書共通情報.get今後納付すべき額());
        } else if (NofugakuSanshutsuHoho.調定額をもとに算出.equals(納付額算出方法)) {
            source.nofuZumiGaku = getコンマ区切りRString(編集後本算定通知書共通情報.get普徴既に納付すべき額());
            source.kongoNofuSubekiGaku = getコンマ区切りRString(編集後本算定通知書共通情報.get普徴今後納付すべき額_調定元に());
        }
        List<UniversalPhase> 普徴期別金額リスト = 更正後.get普徴期別金額リスト();
        int 期 = 納入通知書期情報.get期();
        source.santeiKisoTokiHokenryoGaku = null == get普徴期別金額By期(普徴期別金額リスト, 期) ? new RString("0")
                : DecimalFormatter.toコンマ区切りRString(get普徴期別金額By期(普徴期別金額リスト, 期), 0);
        source.santeiKisoJikiTitle = new RString("次期以降");
        source.santeiKisoJikoHokenryoGaku = null == get普徴期別金額By期(普徴期別金額リスト, 期 + 1) ? new RString("0")
                : DecimalFormatter.toコンマ区切りRString(get普徴期別金額By期(普徴期別金額リスト, 期 + 1), 0);
        if (編集後本算定通知書共通情報.get編集後口座() != null) {
            source.bankName = 編集後本算定通知書共通情報.get編集後口座().get金融機関名CombinedWith支店名();
            source.kozaMeigi = 編集後本算定通知書共通情報.get編集後口座().get口座名義人優先();
            source.bankCode = 編集後本算定通知書共通情報.get編集後口座().get金融機関コードCombinedWith支店コード();
            source.kozaShurui = 編集後本算定通知書共通情報.get編集後口座().get口座種別略称();
            source.kozaNo = 編集後本算定通知書共通情報.get編集後口座().get口座番号Or通帳記号番号();
        }

        source.renban = new RString(本算定納入通知書情報.get連番()).padLeft("0", INDEX定数_6);
        source.hokenshaName = 編集後本算定通知書共通情報.get保険者名();
    }

    private RString getコンマ区切りRString(Decimal コンマ区切り対象) {
        return null == コンマ区切り対象 ? null : DecimalFormatter.toコンマ区切りRString(コンマ区切り対象, 0);
    }

    private void edit期月(HokenryoNonyuTsuchishoKigotoSource source) {
        boolean is納期限出力方法が0 = is納期限出力方法が0();
        List<AfterEditInformation> 普徴納期情報List = null == 編集後本算定通知書共通情報.get普徴納期情報リスト()
                ? new ArrayList<AfterEditInformation>() : 編集後本算定通知書共通情報.get普徴納期情報リスト();
        AfterEditInformation 普徴納期情報リストの一番目 = get普徴納期情報By番目(普徴納期情報List, INDEX定数_0);
        AfterEditInformation 普徴納期情報リストの二番目 = get普徴納期情報By番目(普徴納期情報List, INDEX定数_1);
        AfterEditInformation 普徴納期情報リストの三番目 = get普徴納期情報By番目(普徴納期情報List, INDEX定数_2);
        AfterEditInformation 普徴納期情報リストの四番目 = get普徴納期情報By番目(普徴納期情報List, INDEX定数_3);
        AfterEditInformation 普徴納期情報リストの五番目 = get普徴納期情報By番目(普徴納期情報List, INDEX定数_4);
        AfterEditInformation 普徴納期情報リストの六番目 = get普徴納期情報By番目(普徴納期情報List, INDEX定数_5);
        AfterEditInformation 普徴納期情報リストの七番目 = get普徴納期情報By番目(普徴納期情報List, INDEX定数_6);
        AfterEditInformation 普徴納期情報リストの八番目 = get普徴納期情報By番目(普徴納期情報List, INDEX定数_7);
        AfterEditInformation 普徴納期情報リストの九番目 = get普徴納期情報By番目(普徴納期情報List, INDEX定数_8);
        AfterEditInformation 普徴納期情報リストの十番目 = get普徴納期情報By番目(普徴納期情報List, INDEX定数_9);
        AfterEditInformation 普徴納期情報リスト1期 = get普徴納期情報By期(普徴納期情報List, INDEX定数_1);
        AfterEditInformation 普徴納期情報リスト2期 = get普徴納期情報By期(普徴納期情報List, INDEX定数_2);
        AfterEditInformation 普徴納期情報リスト3期 = get普徴納期情報By期(普徴納期情報List, INDEX定数_3);
        AfterEditInformation 普徴納期情報リスト4期 = get普徴納期情報By期(普徴納期情報List, INDEX定数_4);
        AfterEditInformation 普徴納期情報リスト5期 = get普徴納期情報By期(普徴納期情報List, INDEX定数_5);
        AfterEditInformation 普徴納期情報リスト6期 = get普徴納期情報By期(普徴納期情報List, INDEX定数_6);
        AfterEditInformation 普徴納期情報リスト7期 = get普徴納期情報By期(普徴納期情報List, INDEX定数_7);
        AfterEditInformation 普徴納期情報リスト8期 = get普徴納期情報By期(普徴納期情報List, INDEX定数_8);
        AfterEditInformation 普徴納期情報リスト9期 = get普徴納期情報By期(普徴納期情報List, INDEX定数_9);
        AfterEditInformation 普徴納期情報リスト10期 = get普徴納期情報By期(普徴納期情報List, INDEX定数_10);

        source.titleNendo = RStringUtil.convert半角to全角(編集後本算定通知書共通情報.get調定年度_年度なし());

        if (is納期限出力方法が0) {
            source.ki1 = new RString(納入通知書期情報.get期());
            source.ki2 = RString.EMPTY;
            source.ki3 = RString.EMPTY;
            source.ki4 = RString.EMPTY;
            source.ki5 = RString.EMPTY;
            source.ki6 = RString.EMPTY;
            source.ki7 = RString.EMPTY;
            source.ki8 = RString.EMPTY;
            source.ki9 = RString.EMPTY;
            source.ki10 = RString.EMPTY;
            source.tsuki1 = 納入通知書期情報.get月表記();
            source.tsuki2 = RString.EMPTY;
            source.tsuki3 = RString.EMPTY;
            source.tsuki4 = RString.EMPTY;
            source.tsuki5 = RString.EMPTY;
            source.tsuki6 = RString.EMPTY;
            source.tsuki7 = RString.EMPTY;
            source.tsuki8 = RString.EMPTY;
            source.tsuki9 = RString.EMPTY;
            source.tsuki10 = RString.EMPTY;
            AfterEditInformation 普徴納期情報 = get普徴納期情報By期(普徴納期情報List, 納入通知書期情報.get期());
            source.nokiKaishi1 = get納期開始日(普徴納期情報);
            source.nokiShuryo1 = get納期終了日(普徴納期情報);
            source.nokiKaishi2 = RString.EMPTY;
            source.nokiShuryo2 = RString.EMPTY;
            source.nokiKaishi3 = RString.EMPTY;
            source.nokiShuryo3 = RString.EMPTY;
            source.nokiKaishi4 = RString.EMPTY;
            source.nokiShuryo4 = RString.EMPTY;
            source.nokiKaishi5 = RString.EMPTY;
            source.nokiShuryo5 = RString.EMPTY;
            source.nokiKaishi6 = RString.EMPTY;
            source.nokiShuryo6 = RString.EMPTY;
            source.nokiKaishi7 = RString.EMPTY;
            source.nokiShuryo7 = RString.EMPTY;
            source.nokiKaishi8 = RString.EMPTY;
            source.nokiShuryo8 = RString.EMPTY;
            source.nokiKaishi9 = RString.EMPTY;
            source.nokiShuryo9 = RString.EMPTY;
            source.nokiKaishi10 = RString.EMPTY;
            source.nokiShuryo10 = RString.EMPTY;
        } else {
            source.tsuki1 = edit2ケタ空白埋め(普徴納期情報リストの一番目.get月());
            source.ki1 = edit2ケタ空白埋め(普徴納期情報リストの一番目.get期());
            source.tsuki2 = edit2ケタ空白埋め(普徴納期情報リストの二番目.get月());
            source.ki2 = edit2ケタ空白埋め(普徴納期情報リストの二番目.get期());
            source.tsuki3 = edit2ケタ空白埋め(普徴納期情報リストの三番目.get月());
            source.ki3 = edit2ケタ空白埋め(普徴納期情報リストの三番目.get期());
            source.tsuki4 = edit2ケタ空白埋め(普徴納期情報リストの四番目.get月());
            source.ki4 = edit2ケタ空白埋め(普徴納期情報リストの四番目.get期());
            source.tsuki5 = edit2ケタ空白埋め(普徴納期情報リストの五番目.get月());
            source.ki5 = edit2ケタ空白埋め(普徴納期情報リストの五番目.get期());
            source.tsuki6 = edit2ケタ空白埋め(普徴納期情報リストの六番目.get月());
            source.ki6 = edit2ケタ空白埋め(普徴納期情報リストの六番目.get期());
            source.tsuki7 = edit2ケタ空白埋め(普徴納期情報リストの七番目.get月());
            source.ki7 = edit2ケタ空白埋め(普徴納期情報リストの七番目.get期());
            source.tsuki8 = edit2ケタ空白埋め(普徴納期情報リストの八番目.get月());
            source.ki8 = edit2ケタ空白埋め(普徴納期情報リストの八番目.get期());
            source.tsuki9 = edit2ケタ空白埋め(普徴納期情報リストの九番目.get月());
            source.ki9 = edit2ケタ空白埋め(普徴納期情報リストの九番目.get期());
            source.tsuki10 = edit2ケタ空白埋め(普徴納期情報リストの十番目.get月());
            source.ki10 = edit2ケタ空白埋め(普徴納期情報リストの十番目.get期());
            source.nokiKaishi1 = get納期開始日(普徴納期情報リスト1期);
            source.nokiKaishi2 = get納期開始日(普徴納期情報リスト2期);
            source.nokiKaishi3 = get納期開始日(普徴納期情報リスト3期);
            source.nokiKaishi4 = get納期開始日(普徴納期情報リスト4期);
            source.nokiKaishi5 = get納期開始日(普徴納期情報リスト5期);
            source.nokiKaishi6 = get納期開始日(普徴納期情報リスト6期);
            source.nokiKaishi7 = get納期開始日(普徴納期情報リスト7期);
            source.nokiKaishi8 = get納期開始日(普徴納期情報リスト8期);
            source.nokiKaishi9 = get納期開始日(普徴納期情報リスト9期);
            source.nokiKaishi10 = get納期開始日(普徴納期情報リスト10期);
            source.nokiShuryo1 = get納期終了日(普徴納期情報リスト1期);
            source.nokiShuryo2 = get納期終了日(普徴納期情報リスト2期);
            source.nokiShuryo3 = get納期終了日(普徴納期情報リスト3期);
            source.nokiShuryo4 = get納期終了日(普徴納期情報リスト4期);
            source.nokiShuryo5 = get納期終了日(普徴納期情報リスト5期);
            source.nokiShuryo6 = get納期終了日(普徴納期情報リスト6期);
            source.nokiShuryo7 = get納期終了日(普徴納期情報リスト7期);
            source.nokiShuryo8 = get納期終了日(普徴納期情報リスト8期);
            source.nokiShuryo9 = get納期終了日(普徴納期情報リスト9期);
            source.nokiShuryo10 = get納期終了日(普徴納期情報リスト10期);
        }
        source.santeiKisoTokiTitle = 第.concat(edit2ケタ空白埋め(普徴納期情報リストの一番目.get期())).concat(期);
    }

    private Decimal get普徴期別金額By期(List<UniversalPhase> 普徴期別金額リスト, int 期) {
        for (UniversalPhase 普徴期別金額 : 普徴期別金額リスト) {
            if (期 == 普徴期別金額.get期()) {
                return nullToDemical(普徴期別金額.get金額());
            }
        }
        return Decimal.ZERO;
    }

    private RString edit2ケタ空白埋め(RString editor) {
        if (null == editor) {
            return RString.EMPTY;
        }
        return editor.padLeft(RString.HALF_SPACE, 2);
    }

    private AfterEditInformation get普徴納期情報By番目(List<AfterEditInformation> 普徴納期情報リスト, int 番目) {
        return !普徴納期情報リスト.isEmpty() && 普徴納期情報リスト.size() >= 番目 + 1 ? 普徴納期情報リスト.get(番目) : new AfterEditInformation();
    }

    private AfterEditInformation get普徴納期情報By期(List<AfterEditInformation> 普徴納期情報リスト, int 期) {
        for (AfterEditInformation 普徴納期情報 : 普徴納期情報リスト) {
            if (期 == Integer.parseInt(普徴納期情報.get期().toString())) {
                return 普徴納期情報;
            }
        }
        return null;
    }

    private boolean is納期限出力方法が0() {
        return NokigenShutsuryokuHoho.対象の期.equals(本算定納入通知書制御情報.get納入通知書制御情報().get納期限出力方法());
    }

    private RString get納期開始日(AfterEditInformation data) {
        return null == data ? RString.EMPTY : data.get納期開始日();
    }

    private RString get納期終了日(AfterEditInformation data) {
        return null == data ? RString.EMPTY : data.get納期終了日();
    }

    private Decimal nullToDemical(Decimal 項目) {
        if (項目 == null) {
            return Decimal.ZERO;
        }
        return 項目;
    }

}
