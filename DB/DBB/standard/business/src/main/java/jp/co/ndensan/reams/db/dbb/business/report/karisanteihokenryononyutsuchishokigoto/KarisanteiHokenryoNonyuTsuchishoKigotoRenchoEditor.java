/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.karisanteihokenryononyutsuchishokigoto;

import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.EditedKariSanteiTsuchiShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.KariSanteiNonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NofuShoKyotsu;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoKiJoho;
import jp.co.ndensan.reams.db.dbb.business.report.tsuchisho.notsu.NonyuTsuchiShoSeigyoJoho;
import jp.co.ndensan.reams.db.dbb.definition.core.ShoriKubun;
import jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu.NokigenShutsuryokuHoho;
import jp.co.ndensan.reams.db.dbb.entity.report.karisanteihokenryononyutsuchishokigoto.KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringUtil;

/**
 *
 * 帳票設計_DBBRP00007_2_保険料納入通知書（仮算定）【期毎タイプ】連帳 KarisanteiHokenryoNonyuTsuchishoKigotoRenchoEditor
 */
public class KarisanteiHokenryoNonyuTsuchishoKigotoRenchoEditor implements IKarisanteiHokenryoNonyuTsuchishoKigotoRenchoEditor {

    private final KariSanteiNonyuTsuchiShoJoho 仮算定納入通知書情報;
    private final EditedKariSanteiTsuchiShoKyotsu 編集後仮算定通知書共通情報;
    private final KariSanteiNonyuTsuchiShoSeigyoJoho 仮算定納入通知書制御情報;
    private final NonyuTsuchiShoSeigyoJoho 納入通知書制御情報;
    private final NonyuTsuchiShoKiJoho 納入通知書期情報;
    private final NofuShoKyotsu 納付書共通;
    private final int 連番;
    //private final NinshoshaSource ninshoshaSource;
    private final SofubutsuAtesakiSource sofubutsuAtesakiSource;
    private final RString 領収書連番;
    private static final int OCR_3 = 3;
    private static final int OCR_4 = 4;
    private static final int 連番_6 = 6;

    /**
     * インスタンスを生成します。
     *
     * @param item KarisanteiHokenryoNonyuTsuchishoKigotoItem
     * @param 連番 int
     * @param sofubutsuAtesakiSource SofubutsuAtesakiSource
     * @param 領収書連番 int
     * @param 納入通知書期情報 NonyuTsuchiShoKiJoho
     */
    protected KarisanteiHokenryoNonyuTsuchishoKigotoRenchoEditor(
            KarisanteiHokenryoNonyuTsuchishoKigotoItem item,
            NonyuTsuchiShoKiJoho 納入通知書期情報,
            int 連番,
            //NinshoshaSource ninshoshaSource,
            SofubutsuAtesakiSource sofubutsuAtesakiSource,
            int 領収書連番) {
        this.仮算定納入通知書情報 = item.get仮算定納入通知書情報();
        this.編集後仮算定通知書共通情報 = null == 仮算定納入通知書情報.get編集後仮算定通知書共通情報()
                ? new EditedKariSanteiTsuchiShoKyotsu() : 仮算定納入通知書情報.get編集後仮算定通知書共通情報();
        this.仮算定納入通知書制御情報 = null == 仮算定納入通知書情報.get仮算定納入通知書制御情報()
                ? new KariSanteiNonyuTsuchiShoSeigyoJoho() : 仮算定納入通知書情報.get仮算定納入通知書制御情報();
        this.納入通知書制御情報 = null == 仮算定納入通知書制御情報.get納入通知書制御情報()
                ? new NonyuTsuchiShoSeigyoJoho() : 仮算定納入通知書制御情報.get納入通知書制御情報();
        this.納入通知書期情報 = 納入通知書期情報;
        this.納付書共通 = null == 仮算定納入通知書情報.get納付書共通() ? new NofuShoKyotsu() : 仮算定納入通知書情報.get納付書共通();
        this.連番 = 連番;
        //this.ninshoshaSource = ninshoshaSource;
        this.sofubutsuAtesakiSource = sofubutsuAtesakiSource;
        this.領収書連番 = new RString(String.valueOf(領収書連番));
    }

    @Override
    public KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource edit(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        editTitleNendo(source);
        editKi1(source);
        editTsuki1(source);
        editNokiKaishi1(source);
        editNokiShuryo1(source);
        editKi2(source);
        editTsuki2(source);
        editNokiKaishi2(source);
        editNokiShuryo2(source);
        editKi3(source);
        editTsuki3(source);
        editNokiKaishi3(source);
        editNokiShuryo3(source);
        editKi4(source);
        editTsuki4(source);
        editNokiKaishi4(source);
        editNokiShuryo4(source);
        editKi5(source);
        editTsuki5(source);
        editNokiKaishi5(source);
        editNokiShuryo5(source);
        editKi6(source);
        editTsuki6(source);
        editNokiKaishi6(source);
        editNokiShuryo6(source);
        editBankCode(source);
        editKozaMeigi(source);
        editKozaShurui(source);
        editKozaNo(source);
        editBankName(source);
        editHyojicodeName1(source);
        editHyojicodeName2(source);
        editHyojicodeName3(source);
        editHyojiKomoku11(source);
        editHyojiKomoku21(source);
        editHyojiKomoku31(source);
        editHyojicode1(source);
        editHyojicode2(source);
        editHyojicode3(source);
        editTsuchishoNo(source);
        editSetaiCode(source);
        editHihokenshaName(source);
        editSetaiNushiName(source);
        editNendo1(source);
        editHokenryoGaku(source);
        editNendo2(source);
        editShotokuDankai(source);
        editNendo3(source);
        editKomokuTitle1(source);
        editSanteiKisoKingaku1(source);
        editYen1(source);
        editNendo4(source);
        editKomokuTitle2(source);
        editSanteiKisoKingaku2(source);
        editYen2(source);
        editNendo5(source);
        editKomokuTitle3(source);
        editSanteiKisoKingaku3(source);
        editYen3(source);
        editSanteiKisoKi(source);
        editSanteiKisoGenmenGaku(source);
        editSanteiKisoKariGokeiGaku(source);
        editSanteiKisoKiTitle1(source);
        editSanteiKisoZanteikiHokenryoGaku1(source);
        editSanteiKisoKiTitle2(source);
        editSanteiKisoZanteikiHokenryoGaku2(source);
        editRenban(source);
        editHokenshaName(source);
        //editCompNinshosha(source);
        editCompSofubutsuAtesaki(source);
        editDBBCompNofusho(source);
        editDBBCompRyoshusho(source);
        return source;
    }

    private void editDBBCompRyoshusho(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        editRyoshushoGyoseikuName(source);
        editRyoshushoHonninName(source);
        editRyoshushoJusho(source);
        editRyoshushoKakko1(source);
        editRyoshushoKakko2(source);
        editRyoshushoKakko3(source);
        editRyoshushoKanendo(source);
        editRyoshushoKanendobun(source);
        editRyoshushoKatagaki(source);
        editRyoshushoKi(source);
        editRyoshushoNendo(source);
        editRyoshushoNofugaku(source);
        editRyoshushoNofuin(source);
        editRyoshushoNokigen(source);
        editRyoshushoRenban(source);
        editRyoshushoRyoshuHizukein(source);
        editRyoshushoSetaiCode(source);
        editRyoshushoShichosonMei1(source);
        editRyoshushoShichosonMei2(source);
        editRyoshushoSofusakiName(source);
        editRyoshushoTsuchishoNo(source);
        editRyoshushoTsuki(source);
        editRyoshushoYubinNo(source);
        editRyoshushoZuiji(source);
        editRyoshushohyojicode1(source);
        editRyoshushohyojicode2(source);
        editRyoshushohyojicode3(source);
        editRyoshushohyojicodeName1(source);
        editRyoshushohyojicodeName2(source);
        editRyoshushohyojicodeName3(source);
    }

    private void editRyoshushoKanendo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKanendo = RString.EMPTY;
    }

    private void editRyoshushoNendo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoNendo = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
    }

    private void editRyoshushoKanendobun(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKanendobun = RString.EMPTY;
    }

    private void editRyoshushoKi(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKi = 納入通知書期情報.get期表記();
    }

    private void editRyoshushoTsuki(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoTsuki = 納入通知書期情報.get月表記();
    }

    private void editRyoshushoYubinNo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoYubinNo = 納付書共通.get郵便番号();
    }

    private void editRyoshushoGyoseikuName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoGyoseikuName = 納付書共通.get行政区名();
    }

    private void editRyoshushoJusho(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoJusho = 納付書共通.get住所();
    }

    private void editRyoshushoKatagaki(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKatagaki = 納付書共通.get方書();
    }

    private void editRyoshushoSofusakiName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoSofusakiName = 納付書共通.get納付者氏名();
    }

    private void editRyoshushoKakko1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKakko1 = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : new RString("(");
    }

    private void editRyoshushoHonninName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoHonninName = 納付書共通.get被代納人氏名();
    }

    private void editRyoshushoKakko2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKakko2 = RString.EMPTY;
    }

    private void editRyoshushoKakko3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoKakko3
                = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
    }

    private void editRyoshushoTsuchishoNo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoTsuchishoNo = 納付書共通.get通知書番号().getColumnValue();
    }

    private void editRyoshushoSetaiCode(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoSetaiCode = 納付書共通.get世帯コード().getColumnValue();
    }

    private void editRyoshushohyojicodeName1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード名１
        source.ryoshushohyojicodeName1 = null;
    }

    private void editRyoshushohyojicode1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード１
        source.ryoshushohyojicode1 = null;
    }

    private void editRyoshushohyojicodeName2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード名2
        source.ryoshushohyojicodeName2 = null;
    }

    private void editRyoshushohyojicode2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード2
        source.ryoshushohyojicode2 = null;
    }

    private void editRyoshushohyojicodeName3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード名3
        source.ryoshushohyojicodeName3 = null;
    }

    private void editRyoshushohyojicode3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード3
        source.ryoshushohyojicode1 = null;
    }

    private void editRyoshushoNokigen(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoNokigen = 納入通知書期情報.get納期限表記();
    }

    private void editRyoshushoNofugaku(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoNofugaku = 納入通知書期情報.get領収証書納付額欄();
    }

    private void editRyoshushoNofuin(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoNofuin = 納入通知書期情報.get領収日付印欄();
    }

    private void editRyoshushoRyoshuHizukein(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoRyoshuHizukein = 納入通知書期情報.get領収証書領収印欄();
    }

    private void editRyoshushoZuiji(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoZuiji = 納入通知書期情報.get随時表記();
    }

    private void editRyoshushoRenban(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoRenban = 領収書連番;
    }

    private void editRyoshushoShichosonMei1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoShichosonMei1 = 納付書共通.get納付書市町村名();
    }

    private void editRyoshushoShichosonMei2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ryoshushoShichosonMei2 = RString.EMPTY;
    }

    private void editCompSofubutsuAtesaki(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
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
    }

    private void editDBBCompNofusho(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        editNofushoHonninName1(source);
        editNofushoKakko11(source);
        editNofushoKakko21(source);
        editNofushoKakko31(source);
        editNofushoKanendo1(source);
        editNofushoKanendobun1(source);
        editNofushoKi1(source);
        editNofushoNendo1(source);
        editNofushoNofugaku1(source);
        editNofushoNofuin1(source);
        editNofushoNokigen1(source);
        editNofushoOcr11(source);
        editNofushoOcr21(source);
        editNofushoOcr31(source);
        editNofushoOcr41(source);
        editNofushoRyoshuHizukein1(source);
        editNofushoSetaiCode1(source);
        editNofushoShichosonMei11(source);
        editNofushoSofusakiName1(source);
        editNofushoTsuchishoNo1(source);
        editNofushoTsuki1(source);
        editNofushoZuiji1(source);
        editNofushohyojicode11(source);
        editNofushohyojicode21(source);
        editNofushohyojicode31(source);
        editNofushohyojicodeName11(source);
        editNofushohyojicodeName21(source);
        editNofushohyojicodeName31(source);
    }

    private void editNofushoNendo1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoNendo1 = RStringUtil.convert半角to全角(納付書共通.get調定年度表記());
    }

    private void editNofushoKanendo1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKanendo1 = RString.EMPTY;
    }

    private void editNofushoKanendobun1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKanendobun1 = RString.EMPTY;
    }

    private void editNofushoTsuki1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoTsuki1 = 納入通知書期情報.get月表記();
    }

    private void editNofushoKi1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKi1 = 納入通知書期情報.get期表記();
    }

    private void editNofushoOcr11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoOcr11 = 納入通知書期情報.getOCR().get(1);
    }

    private void editNofushoOcr21(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoOcr21 = 納入通知書期情報.getOCR().get(2);
    }

    private void editNofushoOcr31(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoOcr31 = 納入通知書期情報.getOCR().get(OCR_3);
    }

    private void editNofushoOcr41(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoOcr41 = 納入通知書期情報.getOCR().get(OCR_4);
    }

    private void editNofushoNofugaku1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoNofugaku1 = 納入通知書期情報.get納付書納付額欄();
    }

    private void editNofushoSofusakiName1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoSofusakiName1 = 納付書共通.get納付者氏名();
    }

    private void editNofushoHonninName1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoHonninName1 = 納付書共通.get被代納人氏名();
    }

    private void editNofushoKakko11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKakko11 = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : new RString(("("));
    }

    private void editNofushoKakko21(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKakko21 = RString.EMPTY;
    }

    private void editNofushoKakko31(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoKakko31 = RString.isNullOrEmpty(納付書共通.get被代納人氏名()) ? RString.EMPTY : 納付書共通.get被代納人敬称().concat(")");
    }

    private void editNofushoTsuchishoNo1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoTsuchishoNo1 = 納付書共通.get通知書番号().getColumnValue();
    }

    private void editNofushoSetaiCode1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoSetaiCode1 = 納付書共通.get世帯コード().getColumnValue();
    }

    private void editNofushohyojicodeName11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード名１
        source.nofushohyojicodeName11 = null;
    }

    private void editNofushohyojicode11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード１
        source.nofushohyojicode11 = null;
    }

    private void editNofushohyojicodeName21(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード名2
        source.nofushohyojicodeName21 = null;
    }

    private void editNofushohyojicode21(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード2
        source.nofushohyojicode21 = null;
    }

    private void editNofushohyojicodeName31(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード名3
        source.nofushohyojicodeName31 = null;
    }

    private void editNofushohyojicode31(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        //TODO 納付書共通.表示コード.表示コード3
        source.nofushohyojicode31 = null;
    }

    private void editNofushoNokigen1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoNokigen1 = 納入通知書期情報.get納期限表記();
    }

    private void editNofushoNofuin1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoNofuin1 = 納入通知書期情報.get領収日付欄();
    }

    private void editNofushoRyoshuHizukein1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoRyoshuHizukein1 = 納入通知書期情報.get納付書領収印欄();
    }

    private void editNofushoZuiji1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoZuiji1 = 納入通知書期情報.get随時表記();
    }

    private void editNofushoShichosonMei11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nofushoShichosonMei11 = 納付書共通.get納付書市町村名();
    }

//    private void editCompNinshosha(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
//        source.denshiKoin = ninshoshaSource.denshiKoin;
//        source.hakkoYMD = ninshoshaSource.hakkoYMD;
//        source.koinMojiretsu = ninshoshaSource.koinMojiretsu;
//        source.ninshoshaShimeiKakeru = ninshoshaSource.ninshoshaShimeiKakeru;
//        source.ninshoshaShimeiKakenai = ninshoshaSource.ninshoshaShimeiKakenai;
//        source.ninshoshaYakushokuMei = ninshoshaSource.ninshoshaYakushokuMei;
//        source.koinShoryaku = ninshoshaSource.koinShoryaku;
//    }
    private void editTitleNendo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.titleNendo = RStringUtil.convert半角to全角(編集後仮算定通知書共通情報.get調定年度_年度なし());
    }

    private void editKi1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ki1 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? 納入通知書期情報.get期表記() : null;
        //仮算定納入通知書情報.編集後仮算定通知書共通情報.普徴納期情報リストの一番目の期月.get期AsInt()
    }

    private void editTsuki1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.tsuki1 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? 納入通知書期情報.get月表記() : null;
        //仮算定納入通知書情報.編集後仮算定通知書共通情報.普徴納期情報リストの一番目の期月.get月AsInt()
    }

    private void editNokiKaishi1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi1 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? 納入通知書期情報.get納期開始日表記() : null;
        //仮算定納入通知書情報.編集後仮算定通知書共通情報.普徴納期情報リスト中にX期の納期開始日（X＝期１）
    }

    private void editNokiShuryo1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo1 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? 納入通知書期情報.get納期終了日表記() : null;
        //仮算定納入通知書情報.編集後仮算定通知書共通情報.普徴納期情報リスト中にX期の納期終了日（X＝期１）
    }

    private void editKi2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ki2 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : null;
        //TODO
    }

    private void editTsuki2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.tsuki2 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : null;
        //TODO
    }

    private void editNokiKaishi2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi2 = null;
        //TODO
    }

    private void editNokiShuryo2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo2 = null;
        //TODO
    }

    private void editKi3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ki3 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : null;
        //TODO
    }

    private void editTsuki3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.tsuki3 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : null;
        //TODO
    }

    private void editNokiKaishi3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi3 = null;
        //TODO
    }

    private void editNokiShuryo3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo3 = null;
        //TODO
    }

    private void editKi4(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ki4 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : null;
        //TODO
    }

    private void editTsuki4(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.tsuki4 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : null;
        //TODO
    }

    private void editNokiKaishi4(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi4 = null;
        //TODO
    }

    private void editNokiShuryo4(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo4 = null;
        //TODO
    }

    private void editKi5(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ki5 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : null;
        //TODO
    }

    private void editTsuki5(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.tsuki5 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : null;
        //TODO
    }

    private void editNokiKaishi5(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi5 = null;
        //TODO
    }

    private void editNokiShuryo5(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo5 = null;
        //TODO
    }

    private void editKi6(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.ki6 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : null;
        //TODO
    }

    private void editTsuki6(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.tsuki6 = NokigenShutsuryokuHoho.納付書の対象となっている期を全て印字する.equals(納入通知書制御情報.get納期限出力方法())
                ? RString.EMPTY : null;
        //TODO
    }

    private void editNokiKaishi6(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiKaishi6 = null;
        //TODO
    }

    private void editNokiShuryo6(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nokiShuryo6 = null;
        //TODO
    }

    private void editBankCode(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.bankCode = null;
        //TODO
    }

    private void editKozaMeigi(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.kozaMeigi = null;
        //TODO
    }

    private void editKozaShurui(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.kozaShurui = null;
        //TODO
    }

    private void editKozaNo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.kozaNo = null;
        //TODO
    }

    private void editBankName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.bankName = null;
        //TODO
    }

    private void editHyojicodeName1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.HyojicodeName1 = RString.EMPTY;
    }

    private void editHyojicodeName2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.HyojicodeName2 = RString.EMPTY;
    }

    private void editHyojicodeName3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.HyojicodeName3 = RString.EMPTY;
    }

    private void editHyojiKomoku11(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojiKomoku11 = null;
        //TODO
    }

    private void editHyojiKomoku21(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojiKomoku21 = null;
        //TODO
    }

    private void editHyojiKomoku31(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hyojiKomoku31 = null;
        //TODO
    }

    private void editHyojicode1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.Hyojicode1 = null;
        //TODO
    }

    private void editHyojicode2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.Hyojicode2 = null;
        //TODO
    }

    private void editHyojicode3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.Hyojicode3 = null;
        //TODO
    }

    private void editTsuchishoNo(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.tsuchishoNo = 編集後仮算定通知書共通情報.get通知書番号().getColumnValue();
    }

    private void editSetaiCode(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.setaiCode = null;
        //TODO
    }

    private void editHihokenshaName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hihokenshaName = null;
        //TODO
    }

    private void editSetaiNushiName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.setaiNushiName = null;
        //TODO
    }

    private void editNendo1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nendo1 = 編集後仮算定通知書共通情報.get賦課年度().toDateString();
    }

    private void editHokenryoGaku(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hokenryoGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後介護保険料仮徴収額合計().toString());
    }

    private void editNendo2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nendo2 = 編集後仮算定通知書共通情報.get前年度情報().get前年度賦課年度();
    }

    private void editShotokuDankai(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.shotokuDankai = 編集後仮算定通知書共通情報.get前年度情報().get前年度保険料段階();
    }

    private void editNendo3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nendo3 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get年度();
    }

    private void editKomokuTitle1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.komokuTitle1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get名称();
    }

    private void editSanteiKisoKingaku1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKingaku1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get金額();
    }

    private void editYen1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.yen1 = 仮算定納入通知書情報.get算定の基礎().get基礎1().get単位();
    }

    private void editNendo4(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nendo4 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get年度();
    }

    private void editKomokuTitle2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.komokuTitle2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get名称();
    }

    private void editSanteiKisoKingaku2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKingaku2 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get金額();
    }

    private void editYen2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.yen1 = 仮算定納入通知書情報.get算定の基礎().get基礎2().get単位();
    }

    private void editNendo5(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.nendo5 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get年度();
    }

    private void editKomokuTitle3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.komokuTitle3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get名称();
    }

    private void editSanteiKisoKingaku3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKingaku3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get金額();
    }

    private void editYen3(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.yen3 = 仮算定納入通知書情報.get算定の基礎().get基礎3().get単位();
    }

    private void editSanteiKisoKi(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKi = new RString(String.valueOf(編集後仮算定通知書共通情報.get普徴期数()));
    }

    private void editSanteiKisoGenmenGaku(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoGenmenGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額合計().toString());
    }

    private void editSanteiKisoKariGokeiGaku(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKariGokeiGaku = new RString(編集後仮算定通知書共通情報.get更正後().get更正後特徴期別金額合計().toString());
    }

    private void editSanteiKisoKiTitle1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKiTitle1 = null;
        //TODO
    }

    private void editSanteiKisoZanteikiHokenryoGaku1(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoZanteikiHokenryoGaku1 = null;
        //仮算定納入通知書情報.編集後仮算定通知書共通情報.更正後普徴期別金額リスト中にX期の金額（Xは出力期リストの一番目の期）
    }

    private void editSanteiKisoKiTitle2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoKiTitle2 = 仮算定納入通知書情報.get出力期リスト().size() >= 2 ? new RString("次期以降") : RString.EMPTY;
    }

    private void editSanteiKisoZanteikiHokenryoGaku2(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.santeiKisoZanteikiHokenryoGaku2 = 仮算定納入通知書情報.get出力期リスト().size() >= 2 ? null : RString.EMPTY;
        //仮算定納入通知書情報.編集後仮算定通知書共通情報.更正後普徴期別金額リスト中にX期の金額（Xは出力期リストの二番目の期）
    }

    private void editRenban(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        RString 連番 = new RString(String.valueOf(this.連番));
        if (ShoriKubun.バッチ.equals(仮算定納入通知書情報.get処理区分())) {
            連番.padLeft(連番, 連番_6);
        }
        source.renban = 連番;
    }

    private void editHokenshaName(KarisanteiHokenryoNonyuTsuchishoKigotoRenchoSource source) {
        source.hokenshaName = new RString(編集後仮算定通知書共通情報.get保険者名().getText());
    }

}
