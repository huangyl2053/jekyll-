package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigochohyoseigyokyotsu.KaigoChohyoSeigyoKyotsu.IKaigoChohyoSeigyoKyotsuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * NotsuInfo のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class NotsuInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabNotsuInfo")
    private tabNotsuInfoDiv tabNotsuInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabNotsuInfo
     * @return tabNotsuInfo
     */
    @JsonProperty("tabNotsuInfo")
    public tabNotsuInfoDiv getTabNotsuInfo() {
        return tabNotsuInfo;
    }

    /*
     * settabNotsuInfo
     * @param tabNotsuInfo tabNotsuInfo
     */
    @JsonProperty("tabNotsuInfo")
    public void setTabNotsuInfo(tabNotsuInfoDiv tabNotsuInfo) {
        this.tabNotsuInfo = tabNotsuInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplAtesakiDiv getTplAtesaki() {
        return this.getTabNotsuInfo().getTplAtesaki();
    }

    @JsonIgnore
    public void setTplAtesaki(tplAtesakiDiv tplAtesaki) {
        this.getTabNotsuInfo().setTplAtesaki(tplAtesaki);
    }

    @JsonIgnore
    public NonyuTsuchishoInfoDiv getNonyuTsuchishoInfo() {
        return this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo();
    }

    @JsonIgnore
    public void setNonyuTsuchishoInfo(NonyuTsuchishoInfoDiv NonyuTsuchishoInfo) {
        this.getTabNotsuInfo().getTplAtesaki().setNonyuTsuchishoInfo(NonyuTsuchishoInfo);
    }

    @JsonIgnore
    public TextBox getTxtHakkoBusu() {
        return this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo().getTxtHakkoBusu();
    }

    @JsonIgnore
    public void setTxtHakkoBusu(TextBox txtHakkoBusu) {
        this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo().setTxtHakkoBusu(txtHakkoBusu);
    }

    @JsonIgnore
    public RadioButton getRadSokuhoTorikomiKubun() {
        return this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo().getRadSokuhoTorikomiKubun();
    }

    @JsonIgnore
    public void setRadSokuhoTorikomiKubun(RadioButton radSokuhoTorikomiKubun) {
        this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo().setRadSokuhoTorikomiKubun(radSokuhoTorikomiKubun);
    }

    @JsonIgnore
    public TanpyoHakkoShokiDiv getTanpyoHakkoShoki() {
        return this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo().getTanpyoHakkoShoki();
    }

    @JsonIgnore
    public void setTanpyoHakkoShoki(TanpyoHakkoShokiDiv TanpyoHakkoShoki) {
        this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo().setTanpyoHakkoShoki(TanpyoHakkoShoki);
    }

    @JsonIgnore
    public RadioButton getRadSokujiHakkoHoshiki() {
        return this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo().getTanpyoHakkoShoki().getRadSokujiHakkoHoshiki();
    }

    @JsonIgnore
    public void setRadSokujiHakkoHoshiki(RadioButton radSokujiHakkoHoshiki) {
        this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo().getTanpyoHakkoShoki().setRadSokujiHakkoHoshiki(radSokujiHakkoHoshiki);
    }

    @JsonIgnore
    public RadioButton getRadSokujiHakkoKeishiki() {
        return this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo().getTanpyoHakkoShoki().getRadSokujiHakkoKeishiki();
    }

    @JsonIgnore
    public void setRadSokujiHakkoKeishiki(RadioButton radSokujiHakkoKeishiki) {
        this.getTabNotsuInfo().getTplAtesaki().getNonyuTsuchishoInfo().getTanpyoHakkoShoki().setRadSokujiHakkoKeishiki(radSokujiHakkoKeishiki);
    }

    @JsonIgnore
    public IKaigoChohyoSeigyoKyotsuDiv getCcdKaigoChohyoSeigyoKyotsu() {
        return this.getTabNotsuInfo().getTplAtesaki().getCcdKaigoChohyoSeigyoKyotsu();
    }

    @JsonIgnore
    public tplKozaMongoRyoshuHizukeiDiv getTplKozaMongoRyoshuHizukei() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei();
    }

    @JsonIgnore
    public void setTplKozaMongoRyoshuHizukei(tplKozaMongoRyoshuHizukeiDiv tplKozaMongoRyoshuHizukei) {
        this.getTabNotsuInfo().setTplKozaMongoRyoshuHizukei(tplKozaMongoRyoshuHizukei);
    }

    @JsonIgnore
    public KozaMongonDiv getKozaMongon() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getKozaMongon();
    }

    @JsonIgnore
    public void setKozaMongon(KozaMongonDiv KozaMongon) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().setKozaMongon(KozaMongon);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonRyoshushoNofugaku() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getKozaMongon().getDdlKozaMongonRyoshushoNofugaku();
    }

    @JsonIgnore
    public void setDdlKozaMongonRyoshushoNofugaku(DropDownList ddlKozaMongonRyoshushoNofugaku) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getKozaMongon().setDdlKozaMongonRyoshushoNofugaku(ddlKozaMongonRyoshushoNofugaku);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonNofushoNofugaku() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getKozaMongon().getDdlKozaMongonNofushoNofugaku();
    }

    @JsonIgnore
    public void setDdlKozaMongonNofushoNofugaku(DropDownList ddlKozaMongonNofushoNofugaku) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getKozaMongon().setDdlKozaMongonNofushoNofugaku(ddlKozaMongonNofushoNofugaku);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonRyoshushoRyoshuin() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getKozaMongon().getDdlKozaMongonRyoshushoRyoshuin();
    }

    @JsonIgnore
    public void setDdlKozaMongonRyoshushoRyoshuin(DropDownList ddlKozaMongonRyoshushoRyoshuin) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getKozaMongon().setDdlKozaMongonRyoshushoRyoshuin(ddlKozaMongonRyoshushoRyoshuin);
    }

    @JsonIgnore
    public DropDownList getDdlKozaMongonNofushoRyoshuin() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getKozaMongon().getDdlKozaMongonNofushoRyoshuin();
    }

    @JsonIgnore
    public void setDdlKozaMongonNofushoRyoshuin(DropDownList ddlKozaMongonNofushoRyoshuin) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getKozaMongon().setDdlKozaMongonNofushoRyoshuin(ddlKozaMongonNofushoRyoshuin);
    }

    @JsonIgnore
    public ShutsuryokuHohoDiv getShutsuryokuHoho() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho();
    }

    @JsonIgnore
    public void setShutsuryokuHoho(ShutsuryokuHohoDiv ShutsuryokuHoho) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().setShutsuryokuHoho(ShutsuryokuHoho);
    }

    @JsonIgnore
    public DropDownList getDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn();
    }

    @JsonIgnore
    public void setDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn(DropDownList ddlShutsuryokuHohoRyoshushoRyoshuHidukeIn) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setDdlShutsuryokuHohoRyoshushoRyoshuHidukeIn(ddlShutsuryokuHohoRyoshushoRyoshuHidukeIn);
    }

    @JsonIgnore
    public DropDownList getDdlShutsuryokuHohoNofushoRyoshuHiduke() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getDdlShutsuryokuHohoNofushoRyoshuHiduke();
    }

    @JsonIgnore
    public void setDdlShutsuryokuHohoNofushoRyoshuHiduke(DropDownList ddlShutsuryokuHohoNofushoRyoshuHiduke) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setDdlShutsuryokuHohoNofushoRyoshuHiduke(ddlShutsuryokuHohoNofushoRyoshuHiduke);
    }

    @JsonIgnore
    public DropDownList getDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi();
    }

    @JsonIgnore
    public void setDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi(DropDownList ddlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setDdlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi(ddlShutsuryokuHohoRyoshushoRyoshuHidukeInNoKi);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setLin1(lin1);
    }

    @JsonIgnore
    public DropDownList getDdlNofushoShichosonNameUmu() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getDdlNofushoShichosonNameUmu();
    }

    @JsonIgnore
    public void setDdlNofushoShichosonNameUmu(DropDownList ddlNofushoShichosonNameUmu) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setDdlNofushoShichosonNameUmu(ddlNofushoShichosonNameUmu);
    }

    @JsonIgnore
    public TextBox getTxtNofushoShichosonName() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().getTxtNofushoShichosonName();
    }

    @JsonIgnore
    public void setTxtNofushoShichosonName(TextBox txtNofushoShichosonName) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getShutsuryokuHoho().setTxtNofushoShichosonName(txtNofushoShichosonName);
    }

    @JsonIgnore
    public NokigenOCRDiv getNokigenOCR() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getNokigenOCR();
    }

    @JsonIgnore
    public void setNokigenOCR(NokigenOCRDiv NokigenOCR) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().setNokigenOCR(NokigenOCR);
    }

    @JsonIgnore
    public DropDownList getDdlNokigenShutsuryokuHoho() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getNokigenOCR().getDdlNokigenShutsuryokuHoho();
    }

    @JsonIgnore
    public void setDdlNokigenShutsuryokuHoho(DropDownList ddlNokigenShutsuryokuHoho) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getNokigenOCR().setDdlNokigenShutsuryokuHoho(ddlNokigenShutsuryokuHoho);
    }

    @JsonIgnore
    public DropDownList getDdlOCRShutsuryokuHoho() {
        return this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getNokigenOCR().getDdlOCRShutsuryokuHoho();
    }

    @JsonIgnore
    public void setDdlOCRShutsuryokuHoho(DropDownList ddlOCRShutsuryokuHoho) {
        this.getTabNotsuInfo().getTplKozaMongoRyoshuHizukei().getNokigenOCR().setDdlOCRShutsuryokuHoho(ddlOCRShutsuryokuHoho);
    }

    @JsonIgnore
    public tplSagakureishoToshoHohoDiv getTplSagakureishoToshoHoho() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho();
    }

    @JsonIgnore
    public void setTplSagakureishoToshoHoho(tplSagakureishoToshoHohoDiv tplSagakureishoToshoHoho) {
        this.getTabNotsuInfo().setTplSagakureishoToshoHoho(tplSagakureishoToshoHoho);
    }

    @JsonIgnore
    public KarisanteiDiv getKarisantei() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei();
    }

    @JsonIgnore
    public void setKarisantei(KarisanteiDiv Karisantei) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().setKarisantei(Karisantei);
    }

    @JsonIgnore
    public SaGakuKDiv getSaGakuK() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK();
    }

    @JsonIgnore
    public void setSaGakuK(SaGakuKDiv SaGakuK) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().setSaGakuK(SaGakuK);
    }

    @JsonIgnore
    public RadioButton getRadSagakuReishoHakkoUmuK() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getRadSagakuReishoHakkoUmuK();
    }

    @JsonIgnore
    public void setRadSagakuReishoHakkoUmuK(RadioButton radSagakuReishoHakkoUmuK) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setRadSagakuReishoHakkoUmuK(radSagakuReishoHakkoUmuK);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setLin2(lin2);
    }

    @JsonIgnore
    public RadioButton getRadBarCodeHyojiK() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getRadBarCodeHyojiK();
    }

    @JsonIgnore
    public void setRadBarCodeHyojiK(RadioButton radBarCodeHyojiK) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setRadBarCodeHyojiK(radBarCodeHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadKozaNofushoHyojiK() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getRadKozaNofushoHyojiK();
    }

    @JsonIgnore
    public void setRadKozaNofushoHyojiK(RadioButton radKozaNofushoHyojiK) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setRadKozaNofushoHyojiK(radKozaNofushoHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadNofishoHakkoYMDHyojiK() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getRadNofishoHakkoYMDHyojiK();
    }

    @JsonIgnore
    public void setRadNofishoHakkoYMDHyojiK(RadioButton radNofishoHakkoYMDHyojiK) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setRadNofishoHakkoYMDHyojiK(radNofishoHakkoYMDHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadNofishoToriatsukaiKigenHyojiK() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().getRadNofishoToriatsukaiKigenHyojiK();
    }

    @JsonIgnore
    public void setRadNofishoToriatsukaiKigenHyojiK(RadioButton radNofishoToriatsukaiKigenHyojiK) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSaGakuK().setRadNofishoToriatsukaiKigenHyojiK(radNofishoToriatsukaiKigenHyojiK);
    }

    @JsonIgnore
    public ToshoShutsuryokuKDiv getToshoShutsuryokuK() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK();
    }

    @JsonIgnore
    public void setToshoShutsuryokuK(ToshoShutsuryokuKDiv ToshoShutsuryokuK) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().setToshoShutsuryokuK(ToshoShutsuryokuK);
    }

    @JsonIgnore
    public RadioButton getRadToshoShutsuryokuK() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().getRadToshoShutsuryokuK();
    }

    @JsonIgnore
    public void setRadToshoShutsuryokuK(RadioButton radToshoShutsuryokuK) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().setRadToshoShutsuryokuK(radToshoShutsuryokuK);
    }

    @JsonIgnore
    public DropDownList getDdlChukiKaishiKiK() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().getDdlChukiKaishiKiK();
    }

    @JsonIgnore
    public void setDdlChukiKaishiKiK(DropDownList ddlChukiKaishiKiK) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().setDdlChukiKaishiKiK(ddlChukiKaishiKiK);
    }

    @JsonIgnore
    public DropDownList getDdlKokiKaishiKiK() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().getDdlKokiKaishiKiK();
    }

    @JsonIgnore
    public void setDdlKokiKaishiKiK(DropDownList ddlKokiKaishiKiK) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getToshoShutsuryokuK().setDdlKokiKaishiKiK(ddlKokiKaishiKiK);
    }

    @JsonIgnore
    public SanteiKisoShutsuryokuHohoDiv getSanteiKisoShutsuryokuHoho() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho();
    }

    @JsonIgnore
    public void setSanteiKisoShutsuryokuHoho(SanteiKisoShutsuryokuHohoDiv SanteiKisoShutsuryokuHoho) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().setSanteiKisoShutsuryokuHoho(SanteiKisoShutsuryokuHoho);
    }

    @JsonIgnore
    public DropDownList getDdlKiso1() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().getDdlKiso1();
    }

    @JsonIgnore
    public void setDdlKiso1(DropDownList ddlKiso1) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().setDdlKiso1(ddlKiso1);
    }

    @JsonIgnore
    public DropDownList getDdlKiso2() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().getDdlKiso2();
    }

    @JsonIgnore
    public void setDdlKiso2(DropDownList ddlKiso2) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().setDdlKiso2(ddlKiso2);
    }

    @JsonIgnore
    public DropDownList getDdlKiso3() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().getDdlKiso3();
    }

    @JsonIgnore
    public void setDdlKiso3(DropDownList ddlKiso3) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getKarisantei().getSanteiKisoShutsuryokuHoho().setDdlKiso3(ddlKiso3);
    }

    @JsonIgnore
    public HonsanteiDiv getHonsantei() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei();
    }

    @JsonIgnore
    public void setHonsantei(HonsanteiDiv Honsantei) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().setHonsantei(Honsantei);
    }

    @JsonIgnore
    public SaGakuHDiv getSaGakuH() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH();
    }

    @JsonIgnore
    public void setSaGakuH(SaGakuHDiv SaGakuH) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().setSaGakuH(SaGakuH);
    }

    @JsonIgnore
    public RadioButton getRadSagakuReishoHakkoUmuH() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getRadSagakuReishoHakkoUmuH();
    }

    @JsonIgnore
    public void setRadSagakuReishoHakkoUmuH(RadioButton radSagakuReishoHakkoUmuH) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setRadSagakuReishoHakkoUmuH(radSagakuReishoHakkoUmuH);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setLin3(lin3);
    }

    @JsonIgnore
    public RadioButton getRadBarCodeHyojiH() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getRadBarCodeHyojiH();
    }

    @JsonIgnore
    public void setRadBarCodeHyojiH(RadioButton radBarCodeHyojiH) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setRadBarCodeHyojiH(radBarCodeHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadKozaNofushoHyojiH() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getRadKozaNofushoHyojiH();
    }

    @JsonIgnore
    public void setRadKozaNofushoHyojiH(RadioButton radKozaNofushoHyojiH) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setRadKozaNofushoHyojiH(radKozaNofushoHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadNofishoHakkoYMDHyojiH() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getRadNofishoHakkoYMDHyojiH();
    }

    @JsonIgnore
    public void setRadNofishoHakkoYMDHyojiH(RadioButton radNofishoHakkoYMDHyojiH) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setRadNofishoHakkoYMDHyojiH(radNofishoHakkoYMDHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadNofishoToriatsukaiKigenHyojiH() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().getRadNofishoToriatsukaiKigenHyojiH();
    }

    @JsonIgnore
    public void setRadNofishoToriatsukaiKigenHyojiH(RadioButton radNofishoToriatsukaiKigenHyojiH) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getSaGakuH().setRadNofishoToriatsukaiKigenHyojiH(radNofishoToriatsukaiKigenHyojiH);
    }

    @JsonIgnore
    public ToshoShutsuryokuHDiv getToshoShutsuryokuH() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH();
    }

    @JsonIgnore
    public void setToshoShutsuryokuH(ToshoShutsuryokuHDiv ToshoShutsuryokuH) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().setToshoShutsuryokuH(ToshoShutsuryokuH);
    }

    @JsonIgnore
    public RadioButton getRadToshoShutsuryokuH() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().getRadToshoShutsuryokuH();
    }

    @JsonIgnore
    public void setRadToshoShutsuryokuH(RadioButton radToshoShutsuryokuH) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().setRadToshoShutsuryokuH(radToshoShutsuryokuH);
    }

    @JsonIgnore
    public DropDownList getDdlChukiKaishiKiH() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().getDdlChukiKaishiKiH();
    }

    @JsonIgnore
    public void setDdlChukiKaishiKiH(DropDownList ddlChukiKaishiKiH) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().setDdlChukiKaishiKiH(ddlChukiKaishiKiH);
    }

    @JsonIgnore
    public DropDownList getDdlKokiKaishiKiH() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().getDdlKokiKaishiKiH();
    }

    @JsonIgnore
    public void setDdlKokiKaishiKiH(DropDownList ddlKokiKaishiKiH) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getToshoShutsuryokuH().setDdlKokiKaishiKiH(ddlKokiKaishiKiH);
    }

    @JsonIgnore
    public KanendoMongonDiv getKanendoMongon() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getKanendoMongon();
    }

    @JsonIgnore
    public void setKanendoMongon(KanendoMongonDiv KanendoMongon) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().setKanendoMongon(KanendoMongon);
    }

    @JsonIgnore
    public RadioButton getRadKanendoMongon1() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getKanendoMongon().getRadKanendoMongon1();
    }

    @JsonIgnore
    public void setRadKanendoMongon1(RadioButton radKanendoMongon1) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getKanendoMongon().setRadKanendoMongon1(radKanendoMongon1);
    }

    @JsonIgnore
    public RadioButton getRadKanendoMongon2() {
        return this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getKanendoMongon().getRadKanendoMongon2();
    }

    @JsonIgnore
    public void setRadKanendoMongon2(RadioButton radKanendoMongon2) {
        this.getTabNotsuInfo().getTplSagakureishoToshoHoho().getHonsantei().getKanendoMongon().setRadKanendoMongon2(radKanendoMongon2);
    }

    // </editor-fold>
}
