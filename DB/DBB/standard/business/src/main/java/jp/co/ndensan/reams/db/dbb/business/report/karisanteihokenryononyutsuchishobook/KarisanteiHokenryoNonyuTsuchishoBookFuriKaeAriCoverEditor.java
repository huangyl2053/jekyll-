/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishobook;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.NotsuReportEditorUtil;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsuAfterCorrection;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.OrdinaryIncomeInformation;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.PrecedingFiscalYearInformation;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.SanteiNoKiso;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishobook.KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbz.business.core.kaigosofubutsuatesakisource.KaigoSofubutsuAtesakiSource;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedAtesaki;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKojin;
import jp.co.ndensan.reams.db.dbz.business.report.util.EditedKoza;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 *
 * 保険料納入通知書（仮算定）【ブックタイプ】（口振依頼あり）通知書 KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor
 *
 * @reamsid_L DBB-9110-040 wangjie2
 */
public class KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor
        implements IKarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private final List<Kitsuki> 出力期リスト;
    private final NinshoshaSource ninshoshaSource;
    private final int 連番;
    private static final int INT3 = 3;
    private static final int INT4 = 4;
    private static final int INT5 = 5;
    private static final int INT6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param 仮算定納入通知書情報 仮算定納入通知書情報
     * @param 納入通知書期情報リスト 納入通知書期情報リスト
     * @param ninshoshaSource 認証者情報
     */
    protected KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverEditor(
            KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報,
            List<NonyuTsuchiShoKiJoho> 納入通知書期情報リスト,
            NinshoshaSource ninshoshaSource) {
        this.仮算定納入通知書情報 = 仮算定納入通知書情報;
        this.納入通知書期情報リスト = 納入通知書期情報リスト;
        this.編集後仮算定通知書共通情報 = null == 仮算定納入通知書情報.get編集後仮算定通知書共通情報()
                ? new EditedKariSanteiTsuchiShoKyotsu() : 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        this.出力期リスト = null == 仮算定納入通知書情報.get出力期リスト() ? new ArrayList<Kitsuki>() : 仮算定納入通知書情報.get出力期リスト();
        this.ninshoshaSource = ninshoshaSource;
        this.連番 = 仮算定納入通知書情報.get連番();
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource edit(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        source.layoutBreakItem = 1;
        editレイヤ１(source);
        editCompNinshosha(source);
        editCompSofubutsuAtesaki(source);
        return source;
    }

    private void editCompSofubutsuAtesaki(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        EditedAtesaki 編集後宛先 = 編集後仮算定通知書共通情報.get編集後宛先();
        KaigoSofubutsuAtesakiSource kaigoSofubutsuAtesakiSource = null;
        if (編集後宛先 != null) {
            kaigoSofubutsuAtesakiSource = 編集後宛先.getSofubutsuAtesakiSource();
        }
        if (kaigoSofubutsuAtesakiSource != null) {
            SofubutsuAtesakiSource sofubutsuAtesakiSource = kaigoSofubutsuAtesakiSource.get送付物宛先ソース();
            if (sofubutsuAtesakiSource != null) {
                source.customerBarCode = sofubutsuAtesakiSource.customerBarCode;
                source.dainoKubunMei = sofubutsuAtesakiSource.dainoKubunMei;
                source.gyoseiku1 = sofubutsuAtesakiSource.gyoseiku;
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
                source.yubinNo1 = sofubutsuAtesakiSource.yubinNo;
                //世帯主名 様方
            }
        }
    }

    private void editCompNinshosha(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        if (ninshoshaSource != null) {
            source.denshiKoin = ninshoshaSource.denshiKoin;
            source.hakkoYMD = ninshoshaSource.hakkoYMD;
            source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
            source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
            source.koinShoryaku = ninshoshaSource.koinShoryaku;
            source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
        }
    }

    private void editレイヤ１(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        edit編集後個人And編集後口座(source);
        NonyuTsuchiShoKiJoho 納入通知書期情報リストの一番目
                = 納入通知書期情報リスト.isEmpty() ? new NonyuTsuchiShoKiJoho() : 納入通知書期情報リスト.get(0);
        NonyuTsuchiShoKiJoho 納入通知書期情報リストの二番目
                = 納入通知書期情報リスト.size() >= 2 ? 納入通知書期情報リスト.get(1) : new NonyuTsuchiShoKiJoho();
        NonyuTsuchiShoKiJoho 納入通知書期情報リストの三番目
                = 納入通知書期情報リスト.size() >= INT3 ? 納入通知書期情報リスト.get(2) : new NonyuTsuchiShoKiJoho();
        NonyuTsuchiShoKiJoho 納入通知書期情報リストの四番目
                = 納入通知書期情報リスト.size() >= INT4 ? 納入通知書期情報リスト.get(INT3) : new NonyuTsuchiShoKiJoho();
        NonyuTsuchiShoKiJoho 納入通知書期情報リストの五番目
                = 納入通知書期情報リスト.size() >= INT5 ? 納入通知書期情報リスト.get(INT4) : new NonyuTsuchiShoKiJoho();
        NonyuTsuchiShoKiJoho 納入通知書期情報リストの六番目
                = 納入通知書期情報リスト.size() >= INT6 ? 納入通知書期情報リスト.get(INT5) : new NonyuTsuchiShoKiJoho();
        EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後
                = null == 編集後仮算定通知書共通情報.get更正後()
                ? new EditedKariSanteiTsuchiShoKyotsuAfterCorrection() : 編集後仮算定通知書共通情報.get更正後();
        source.hyojicode1 = 編集後仮算定通知書共通情報.get表示コード1();
        source.hyojicode2 = 編集後仮算定通知書共通情報.get表示コード２();
        source.hyojicode3 = 編集後仮算定通知書共通情報.get表示コード３();
        source.hyojicodeName1 = 編集後仮算定通知書共通情報.get表示コード１名();
        source.hyojicodeName2 = 編集後仮算定通知書共通情報.get表示コード２名();
        source.hyojicodeName3 = 編集後仮算定通知書共通情報.get表示コード３名();
        source.keisanMeisaishoKi1 = 納入通知書期情報リストの一番目.get期表記();
        source.keisanMeisaishoTsuki1 = 納入通知書期情報リストの一番目.get月表記();
        source.keisanMeisaishoNokigenKaishi1 = 納入通知書期情報リストの一番目.get納期開始日表記();
        source.keisanMeisaishoNokigenShuryo1 = 納入通知書期情報リストの一番目.get納期終了日表記();
        source.keisanMeisaishoKi2 = 納入通知書期情報リストの二番目.get期表記();
        source.keisanMeisaishoTsuki2 = 納入通知書期情報リストの二番目.get月表記();
        source.keisanMeisaishoNokigenKaishi2 = 納入通知書期情報リストの二番目.get納期開始日表記();
        source.keisanMeisaishoNokigenShuryo2 = 納入通知書期情報リストの二番目.get納期終了日表記();
        source.keisanMeisaishoKi3 = 納入通知書期情報リストの三番目.get期表記();
        source.keisanMeisaishoTsuki3 = 納入通知書期情報リストの三番目.get月表記();
        source.keisanMeisaishoNokigenKaishi3 = 納入通知書期情報リストの三番目.get納期開始日表記();
        source.keisanMeisaishoNokigenShuryo3 = 納入通知書期情報リストの三番目.get納期終了日表記();
        source.keisanMeisaishoKi4 = 納入通知書期情報リストの四番目.get期表記();
        source.keisanMeisaishoTsuki4 = 納入通知書期情報リストの四番目.get月表記();
        source.keisanMeisaishoNokigenKaishi4 = 納入通知書期情報リストの四番目.get納期開始日表記();
        source.keisanMeisaishoNokigenShuryo4 = 納入通知書期情報リストの四番目.get納期終了日表記();
        source.keisanMeisaishoKi5 = 納入通知書期情報リストの五番目.get期表記();
        source.keisanMeisaishoTsuki5 = 納入通知書期情報リストの五番目.get月表記();
        source.keisanMeisaishoNokigenKaishi5 = 納入通知書期情報リストの五番目.get納期開始日表記();
        source.keisanMeisaishoNokigenShuryo5 = 納入通知書期情報リストの五番目.get納期終了日表記();
        source.keisanMeisaishoKi6 = 納入通知書期情報リストの六番目.get期表記();
        source.keisanMeisaishoTsuki6 = 納入通知書期情報リストの六番目.get月表記();
        source.keisanMeisaishoNokigenKaishi6 = 納入通知書期情報リストの六番目.get納期開始日表記();
        source.keisanMeisaishoNokigenShuryo6 = 納入通知書期情報リストの六番目.get納期終了日表記();
        if (編集後仮算定通知書共通情報.get通知書番号() != null) {
            source.keisanMeisaishoTsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
            source.nokibetsuMeisaishoTsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
        }
        source.keisanMeisaishoKaishiKi = get最小の月();
        source.kaisanMeisaishoShuryoKi = get最大の月();
        source.keisanMeisaishoKisu = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴期数()));
        source.keisanMeisaishoGenmenGaku = NotsuReportEditorUtil.get共通ポリシー金額1(更正後.get更正後介護保険料減免額());
        source.kaisanMeisaishoTokuchoGokeiGaku = NotsuReportEditorUtil.get共通ポリシー金額1(更正後.get更正後特徴期別金額合計());
        source.keisanMeisaishoKiTitle1 = new RString("第").concat(String.valueOf(納入通知書期情報リストの一番目.get期())).concat("期");
        source.keisanMeisaishoKiNofuGaku1 = 納入通知書期情報リストの一番目.get調定額表記();
        source.keisanMeisaishoKiTitle2 = 納入通知書期情報リスト.size() > 1 ? new RString("次期以降") : RString.EMPTY;
        source.keisanMeisaishoKiNofuGaku2
                = 納入通知書期情報リスト.size() > 1 ? 納入通知書期情報リストの二番目.get調定額表記() : RString.EMPTY;
        source.keisanMeisaishoKarisanteiGokeiGaku = NotsuReportEditorUtil.get共通ポリシー金額1(更正後.get更正後介護保険料仮徴収額合計());
        if (編集後仮算定通知書共通情報.get調定年度_年度なし() != null) {
            source.nokibetsuMeisaishoNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
        }
        editNokibetsuMeisaishoHohokenshaName(source);
        editレイヤ１_1(source);
        editレイヤ１_2(source, 更正後, 納入通知書期情報リストの一番目, 納入通知書期情報リストの二番目,
                納入通知書期情報リストの三番目, 納入通知書期情報リストの四番目, 納入通知書期情報リストの五番目, 納入通知書期情報リストの六番目);

    }

    private void editレイヤ１_1(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        if (編集後仮算定通知書共通情報.get調定年度_年度なし() != null) {
            source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
            source.keisanMeisaishoNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
        }
        if (編集後仮算定通知書共通情報.get通知書番号() != null) {
            source.tsuchoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
        }
        SanteiNoKiso 算定の基礎 = null == 仮算定納入通知書情報.get算定の基礎() ? new SanteiNoKiso() : 仮算定納入通知書情報.get算定の基礎();
        PrecedingFiscalYearInformation 前年度情報
                = null == 編集後仮算定通知書共通情報.get前年度情報() ? new PrecedingFiscalYearInformation() : 編集後仮算定通知書共通情報.get前年度情報();
        source.keisanMeisaishoNendo1 = 前年度情報.get前年度賦課年度();
        if (前年度情報.get前年度保険料段階() != null) {
            source.keisanMeisaishoShotokuDankai = RStringUtil.convert半角to全角(前年度情報.get前年度保険料段階());
        }
        source.keisanMeisaishoNendo2 = is算定の基礎は空白(算定の基礎, 1) ? RString.EMPTY : 前年度情報.get前年度賦課年度();
        source.keisanMeisaishoHokenryoRitsu
                = null == 前年度情報.get前年度保険料率() || is算定の基礎は空白(算定の基礎, 1)
                ? RString.EMPTY : new RString(前年度情報.get前年度保険料率().toString());
        source.keisanMeisaishoNendo3 = is算定の基礎は空白(算定の基礎, 2) ? RString.EMPTY : 前年度情報.get前年度賦課年度();
        source.kaisanMeisaishoNenGaku
                = null == 前年度情報.get前年度確定介護保険料_年額() || is算定の基礎は空白(算定の基礎, 2)
                ? RString.EMPTY : new RString(前年度情報.get前年度確定介護保険料_年額().toString());
        source.keisanMeisaishoNendo4 = is算定の基礎は空白(算定の基礎, INT3) ? RString.EMPTY : 前年度情報.get前年度賦課年度();
        source.keisanMeisaishoCalHokenryoGaku
                = null == 前年度情報.get前年度最終期普徴期別介護保険料() || is算定の基礎は空白(算定の基礎, INT3)
                ? RString.EMPTY : new RString(前年度情報.get前年度最終期普徴期別介護保険料().toString());
    }

    private void editNokibetsuMeisaishoHohokenshaName(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        NofuShoKyotsu 納付書共通 = null == 仮算定納入通知書情報.get納付書共通() ? new NofuShoKyotsu() : 仮算定納入通知書情報.get納付書共通();
        if (納付書共通.get被保険者氏名() != null) {
            source.nokibetsuMeisaishoHohokenshaName = 納付書共通.get被保険者氏名().getColumnValue();
        }
    }

    private void edit編集後個人And編集後口座(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        EditedKojin 編集後個人 = 編集後仮算定通知書共通情報.get編集後個人();
        EditedKoza 編集後口座 = 編集後仮算定通知書共通情報.get編集後口座();
        if (編集後個人 != null) {
            source.setaiCode = 編集後個人.get世帯コード().getColumnValue();
            source.kaisanMeisaishoHihokenshaName = 編集後個人.get名称().getName().getColumnValue();
            source.keisanMeisaishoSetaiCode = 編集後個人.get世帯コード().getColumnValue();
            source.kaisanMeisaishoSetaiNushiName = 編集後個人.get世帯主名().getColumnValue();
            source.nokibetsuMeisaishoSetaiCode = 編集後個人.get世帯コード().getColumnValue();
            source.kozaIraishoLeftJusho = 編集後個人.get編集後住所();
            source.kozaIraishoRightJusho = 編集後個人.get編集後住所();
            source.kozaIraishoLeftHihokenshaName = 編集後個人.get名称().getName().getColumnValue();
            source.kozaIraishoRightHihokenshaName = 編集後個人.get名称().getName().getColumnValue();
        }
        if (編集後口座 != null) {
            source.bankCode = 編集後口座.get金融機関コードCombinedWith支店コード();
            source.kozaShurui = 編集後口座.get口座種別略称();
            source.kozaNo = 編集後口座.get口座番号Or通帳記号番号();
            source.bankName = 編集後口座.get金融機関名CombinedWith支店名();
            source.kozaMeiginin = 編集後口座.get口座名義人優先();
        }
    }

    private void editレイヤ１_2(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource source,
            EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後,
            NonyuTsuchiShoKiJoho 納入通知書期情報リストの一番目,
            NonyuTsuchiShoKiJoho 納入通知書期情報リストの二番目,
            NonyuTsuchiShoKiJoho 納入通知書期情報リストの三番目,
            NonyuTsuchiShoKiJoho 納入通知書期情報リストの四番目,
            NonyuTsuchiShoKiJoho 納入通知書期情報リストの五番目,
            NonyuTsuchiShoKiJoho 納入通知書期情報リストの六番目) {
        edit各種納期別明細書特徴金額(source, 更正後);
        if (納入通知書期情報リストの一番目.get期表記() != null) {
            source.nokibetsuMeisaishoKi1 = new RString("第").concat(納入通知書期情報リストの一番目.get期表記()).concat("期");
        }
        source.nokibetsuMeisaishoFuchoNofuGaku1 = 納入通知書期情報リストの一番目.get調定額表記();
        source.nokibetsuMeisaishoFuchoNofuZumiGaku1 = 納入通知書期情報リストの一番目.get収入額表記();
        source.nokibetsuMeisaishoFuchoSaGaku1 = 納入通知書期情報リストの一番目.get差額表記();
        source.nokibetsuMeisaishoNokigen1 = 納入通知書期情報リストの一番目.get納期限表記();
        if (納入通知書期情報リストの二番目.get期表記() != null) {
            source.nokibetsuMeisaishoKi2 = new RString("第").concat(納入通知書期情報リストの二番目.get期表記()).concat("期");
        }
        source.nokibetsuMeisaishoFuchoNofuGaku2 = 納入通知書期情報リストの二番目.get調定額表記();
        source.nokibetsuMeisaishoFuchoNofuZumiGaku2 = 納入通知書期情報リストの二番目.get収入額表記();
        source.nokibetsuMeisaishoFuchoSaGaku2 = 納入通知書期情報リストの二番目.get差額表記();
        source.nokibetsuMeisaishoNokigen2 = 納入通知書期情報リストの二番目.get納期限表記();
        if (納入通知書期情報リストの三番目.get期表記() != null) {
            source.nokibetsuMeisaishoKi3 = new RString("第").concat(納入通知書期情報リストの三番目.get期表記()).concat("期");
        }
        source.nokibetsuMeisaishoFuchoNofuGaku3 = 納入通知書期情報リストの三番目.get調定額表記();
        source.nokibetsuMeisaishoFuchoNofuZumiGaku3 = 納入通知書期情報リストの三番目.get収入額表記();
        source.nokibetsuMeisaishoFuchoSaGaku3 = 納入通知書期情報リストの三番目.get差額表記();
        source.nokibetsuMeisaishoNokigen3 = 納入通知書期情報リストの三番目.get納期限表記();
        if (納入通知書期情報リストの四番目.get期表記() != null) {
            source.nokibetsuMeisaishoKi4 = new RString("第").concat(納入通知書期情報リストの四番目.get期表記()).concat("期");
        }
        source.nokibetsuMeisaishoFuchoNofuGaku4 = 納入通知書期情報リストの四番目.get調定額表記();
        source.nokibetsuMeisaishoFuchoNofuZumiGaku4 = 納入通知書期情報リストの四番目.get収入額表記();
        source.nokibetsuMeisaishoFuchoSaGaku4 = 納入通知書期情報リストの四番目.get差額表記();
        source.nokibetsuMeisaishoNokigen4 = 納入通知書期情報リストの四番目.get納期限表記();
        if (納入通知書期情報リストの五番目.get期表記() != null) {
            source.nokibetsuMeisaishoKi5 = new RString("第").concat(納入通知書期情報リストの五番目.get期表記()).concat("期");
        }
        source.nokibetsuMeisaishoFuchoNofuGaku5 = 納入通知書期情報リストの五番目.get調定額表記();
        source.nokibetsuMeisaishoFuchoNofuZumiGaku5 = 納入通知書期情報リストの五番目.get収入額表記();
        source.nokibetsuMeisaishoFuchoSaGaku5 = 納入通知書期情報リストの五番目.get差額表記();
        source.nokibetsuMeisaishoNokigen5 = 納入通知書期情報リストの五番目.get納期限表記();
        if (納入通知書期情報リストの六番目.get期表記() != null) {
            source.nokibetsuMeisaishoKi6 = new RString("第").concat(納入通知書期情報リストの六番目.get期表記()).concat("期");
        }
        source.nokibetsuMeisaishoFuchoNofuGaku6 = 納入通知書期情報リストの六番目.get調定額表記();
        source.nokibetsuMeisaishoFuchoNofuZumiGaku6 = 納入通知書期情報リストの六番目.get収入額表記();
        source.nokibetsuMeisaishoFuchoSaGaku6 = 納入通知書期情報リストの六番目.get差額表記();
        source.nokibetsuMeisaishoNokigen6 = 納入通知書期情報リストの六番目.get納期限表記();
        edit納期別明細書普徴額７(source);
        if (編集後仮算定通知書共通情報.get識別コード() != null) {
            source.kozaIraishoLeftShikibetsuCode = 編集後仮算定通知書共通情報.get識別コード().getColumnValue();
            source.kozaIraishoRightShikibetsuCode = 編集後仮算定通知書共通情報.get識別コード().getColumnValue();
        }
        source.pagerenban1
                = ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分()) ? new RString(String.valueOf(連番)).concat("-1") : new RString("1-1");
        source.pagerenban2
                = ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分()) ? new RString(String.valueOf(連番)).concat("-2") : new RString("1-2");
        source.pagerenban3
                = ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分()) ? new RString(String.valueOf(連番)).concat("-3") : new RString("1-3");
        source.pagerenban4
                = ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分()) ? new RString(String.valueOf(連番)).concat("-4") : new RString("1-4");
        source.renban = ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())
                ? new RString(String.valueOf(連番)).padLeft("0", INT6) : RString.EMPTY;
        source.hokenshaName = 編集後仮算定通知書共通情報.get保険者名();
    }

    private void edit納期別明細書普徴額７(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource source) {
        Decimal 納期別明細書普徴納付額７ = null;
        if (!isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuGaku1)
                && !isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuGaku2)
                && !isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuGaku3)
                && !isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuGaku4)
                && !isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuGaku5)
                && !isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuGaku6)) {
            納期別明細書普徴納付額７ = rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuGaku1)
                    .add(rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuGaku2))
                    .add(rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuGaku3))
                    .add(rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuGaku4))
                    .add(rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuGaku5))
                    .add(rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuGaku6));
        }
        Decimal 納期別明細書普徴納付済額７ = null;
        if (!isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuZumiGaku1)
                && !isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuZumiGaku2)
                && !isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuZumiGaku3)
                && !isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuZumiGaku4)
                && !isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuZumiGaku5)
                && !isNullOrEmpty(source.nokibetsuMeisaishoFuchoNofuZumiGaku6)) {
            納期別明細書普徴納付済額７ = rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuZumiGaku1)
                    .add(rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuZumiGaku2))
                    .add(rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuZumiGaku3))
                    .add(rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuZumiGaku4))
                    .add(rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuZumiGaku5))
                    .add(rStringToDecimal(source.nokibetsuMeisaishoFuchoNofuZumiGaku6));
        }
        Decimal 納期別明細書普徴差額７ = null;
        if (納期別明細書普徴納付額７ != null && 納期別明細書普徴納付済額７ != null) {
            納期別明細書普徴差額７ = 納期別明細書普徴納付額７.subtract(納期別明細書普徴納付済額７);
        }
        source.nokibetsuMeisaishoFuchoNofuGaku7 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書普徴納付額７);
        source.nokibetsuMeisaishoFuchoNofuZumiGaku7 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書普徴納付済額７);
        source.nokibetsuMeisaishoFuchoSaGaku7 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書普徴差額７);
    }

    private boolean isNullOrEmpty(RString value) {
        return null == value || value.isEmpty();
    }

    private Decimal rStringToDecimal(RString value) {
        return new Decimal(value.toString());
    }

    private void edit各種納期別明細書特徴金額(KarisanteiHokenryoNonyuTsuchishoBookFuriKaeAriCoverSource source,
            EditedKariSanteiTsuchiShoKyotsuAfterCorrection 更正後) {
        List<OrdinaryIncomeInformation> 特徴収入情報リスト
                = null == 編集後仮算定通知書共通情報.get特徴収入情報リスト()
                ? new ArrayList<OrdinaryIncomeInformation>() : 編集後仮算定通知書共通情報.get特徴収入情報リスト();
        Decimal 納期別明細書特徴納付額１ = 更正後.get更正後特徴期別金額01();
        Decimal 納期別明細書特徴納付額２ = 更正後.get更正後特徴期別金額02();
        Decimal 納期別明細書特徴納付額３ = 更正後.get更正後特徴期別金額03();
        Decimal 納期別明細書特徴納付額４ = null;
        if (納期別明細書特徴納付額１ != null && 納期別明細書特徴納付額２ != null && 納期別明細書特徴納付額３ != null) {
            納期別明細書特徴納付額４ = 納期別明細書特徴納付額１.add(納期別明細書特徴納付額２).add(納期別明細書特徴納付額３);
        }
        Decimal 納期別明細書特徴納付済額１ = get収入額(特徴収入情報リスト, 1);
        Decimal 納期別明細書特徴納付済額２ = get収入額(特徴収入情報リスト, 2);
        Decimal 納期別明細書特徴納付済額３ = get収入額(特徴収入情報リスト, INT3);
        Decimal 納期別明細書特徴納付済額４ = null;
        if (納期別明細書特徴納付済額１ != null && 納期別明細書特徴納付済額２ != null && 納期別明細書特徴納付済額３ != null) {
            納期別明細書特徴納付済額４ = 納期別明細書特徴納付済額１.add(納期別明細書特徴納付済額２).add(納期別明細書特徴納付済額３);
        }
        Decimal 納期別明細書特徴差額１ = null;
        if (納期別明細書特徴納付額１ != null && 納期別明細書特徴納付済額１ != null) {
            納期別明細書特徴差額１ = 納期別明細書特徴納付額１.subtract(納期別明細書特徴納付済額１);
        }
        Decimal 納期別明細書特徴差額２ = null;
        if (納期別明細書特徴納付額２ != null && 納期別明細書特徴納付済額２ != null) {
            納期別明細書特徴差額２ = 納期別明細書特徴納付額２.subtract(納期別明細書特徴納付済額２);
        }
        Decimal 納期別明細書特徴差額３ = null;
        if (納期別明細書特徴納付額３ != null && 納期別明細書特徴納付済額３ != null) {
            納期別明細書特徴差額３ = 納期別明細書特徴納付額３.subtract(納期別明細書特徴納付済額３);
        }
        Decimal 納期別明細書特徴差額４ = null;
        if (納期別明細書特徴差額１ != null && 納期別明細書特徴差額２ != null && 納期別明細書特徴差額３ != null) {
            納期別明細書特徴差額４ = 納期別明細書特徴差額１.add(納期別明細書特徴差額２).add(納期別明細書特徴差額３);
        }
        source.nokibetsuMeisaishoTokuchoNofuGaku1 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴納付額１);
        source.nokibetsuMeisaishoTokuchoNofuZumiGaku1 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴納付済額１);
        source.nokibetsuMeisaishoTokuchoSaGaku1 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴差額１);
        source.nokibetsuMeisaishoTokuchoNofuGaku2 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴納付額２);
        source.nokibetsuMeisaishoTokuchoNofuZumiGaku2 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴納付済額２);
        source.nokibetsuMeisaishoTokuchoSaGaku2 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴差額２);
        source.nokibetsuMeisaishoTokuchoNofuGaku3 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴納付額３);
        source.nokibetsuMeisaishoTokuchoNofuZumiGaku3 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴納付済額３);
        source.nokibetsuMeisaishoTokuchoSaGaku3 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴差額３);
        source.nokibetsuMeisaishoTokuchoNofuGaku4 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴納付額４);
        source.nokibetsuMeisaishoTokuchoNofuZumiGaku4 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴納付済額４);
        source.nokibetsuMeisaishoTokuchoSaGaku4 = NotsuReportEditorUtil.get共通ポリシー金額1(納期別明細書特徴差額４);
    }

    private Decimal get収入額(List<OrdinaryIncomeInformation> 特徴収入情報リスト, int 期) {
        for (OrdinaryIncomeInformation 特徴収入情報 : 特徴収入情報リスト) {
            if (期 == 特徴収入情報.get期月().get期AsInt()) {
                return 特徴収入情報.get収入額();
            }
        }
        return null;
    }

    private boolean is算定の基礎は空白(SanteiNoKiso 算定の基礎, int 算定の基礎項番) {
        boolean is算定の基礎は空白 = true;
        switch (算定の基礎項番) {
            case 1:
                is算定の基礎は空白 = null == 算定の基礎.get基礎1();
                break;
            case 2:
                is算定の基礎は空白 = null == 算定の基礎.get基礎2();
                break;
            case INT3:
                is算定の基礎は空白 = null == 算定の基礎.get基礎3();
                break;
            default:
                break;
        }
        return is算定の基礎は空白;
    }

    private RString get最大の月() {
        if (出力期リスト.isEmpty()) {
            return RString.EMPTY;
        }
        int 最大月 = 出力期リスト.get(0).get月AsInt();
        RString 最大の月 = 出力期リスト.get(0).get月().get名称();
        for (Kitsuki 出力期 : 出力期リスト) {
            if (最大月 < 出力期.get月AsInt()) {
                最大の月 = 出力期.get月().get名称();
            }
        }
        return 最大の月;
    }

    private RString get最小の月() {
        if (出力期リスト.isEmpty()) {
            return RString.EMPTY;
        }
        int 最小月 = 出力期リスト.get(0).get月AsInt();
        RString 最小の月 = 出力期リスト.get(0).get月().get名称();
        for (Kitsuki 出力期 : 出力期リスト) {
            if (最小月 > 出力期.get月AsInt()) {
                最小の月 = 出力期.get月().get名称();
            }
        }
        return 最小の月;
    }

}
