package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB9020004;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tplSagakureishoToshoHoho のクラスファイル
 *
 * @reamsid_L DBB-1770-060 yebangqiang
 */
public class tplSagakureishoToshoHohoDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Karisantei")
    private KarisanteiDiv Karisantei;
    @JsonProperty("Honsantei")
    private HonsanteiDiv Honsantei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKarisantei
     * @return Karisantei
     */
    @JsonProperty("Karisantei")
    public KarisanteiDiv getKarisantei() {
        return Karisantei;
    }

    /*
     * setKarisantei
     * @param Karisantei Karisantei
     */
    @JsonProperty("Karisantei")
    public void setKarisantei(KarisanteiDiv Karisantei) {
        this.Karisantei = Karisantei;
    }

    /*
     * getHonsantei
     * @return Honsantei
     */
    @JsonProperty("Honsantei")
    public HonsanteiDiv getHonsantei() {
        return Honsantei;
    }

    /*
     * setHonsantei
     * @param Honsantei Honsantei
     */
    @JsonProperty("Honsantei")
    public void setHonsantei(HonsanteiDiv Honsantei) {
        this.Honsantei = Honsantei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public SaGakuKDiv getSaGakuK() {
        return this.getKarisantei().getSaGakuK();
    }

    @JsonIgnore
    public void setSaGakuK(SaGakuKDiv SaGakuK) {
        this.getKarisantei().setSaGakuK(SaGakuK);
    }

    @JsonIgnore
    public RadioButton getRadSagakuReishoHakkoUmuK() {
        return this.getKarisantei().getSaGakuK().getRadSagakuReishoHakkoUmuK();
    }

    @JsonIgnore
    public void setRadSagakuReishoHakkoUmuK(RadioButton radSagakuReishoHakkoUmuK) {
        this.getKarisantei().getSaGakuK().setRadSagakuReishoHakkoUmuK(radSagakuReishoHakkoUmuK);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getKarisantei().getSaGakuK().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getKarisantei().getSaGakuK().setLin2(lin2);
    }

    @JsonIgnore
    public RadioButton getRadBarCodeHyojiK() {
        return this.getKarisantei().getSaGakuK().getRadBarCodeHyojiK();
    }

    @JsonIgnore
    public void setRadBarCodeHyojiK(RadioButton radBarCodeHyojiK) {
        this.getKarisantei().getSaGakuK().setRadBarCodeHyojiK(radBarCodeHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadKozaNofushoHyojiK() {
        return this.getKarisantei().getSaGakuK().getRadKozaNofushoHyojiK();
    }

    @JsonIgnore
    public void setRadKozaNofushoHyojiK(RadioButton radKozaNofushoHyojiK) {
        this.getKarisantei().getSaGakuK().setRadKozaNofushoHyojiK(radKozaNofushoHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadNofishoHakkoYMDHyojiK() {
        return this.getKarisantei().getSaGakuK().getRadNofishoHakkoYMDHyojiK();
    }

    @JsonIgnore
    public void setRadNofishoHakkoYMDHyojiK(RadioButton radNofishoHakkoYMDHyojiK) {
        this.getKarisantei().getSaGakuK().setRadNofishoHakkoYMDHyojiK(radNofishoHakkoYMDHyojiK);
    }

    @JsonIgnore
    public RadioButton getRadNofishoToriatsukaiKigenHyojiK() {
        return this.getKarisantei().getSaGakuK().getRadNofishoToriatsukaiKigenHyojiK();
    }

    @JsonIgnore
    public void setRadNofishoToriatsukaiKigenHyojiK(RadioButton radNofishoToriatsukaiKigenHyojiK) {
        this.getKarisantei().getSaGakuK().setRadNofishoToriatsukaiKigenHyojiK(radNofishoToriatsukaiKigenHyojiK);
    }

    @JsonIgnore
    public ToshoShutsuryokuKDiv getToshoShutsuryokuK() {
        return this.getKarisantei().getToshoShutsuryokuK();
    }

    @JsonIgnore
    public void setToshoShutsuryokuK(ToshoShutsuryokuKDiv ToshoShutsuryokuK) {
        this.getKarisantei().setToshoShutsuryokuK(ToshoShutsuryokuK);
    }

    @JsonIgnore
    public RadioButton getRadToshoShutsuryokuK() {
        return this.getKarisantei().getToshoShutsuryokuK().getRadToshoShutsuryokuK();
    }

    @JsonIgnore
    public void setRadToshoShutsuryokuK(RadioButton radToshoShutsuryokuK) {
        this.getKarisantei().getToshoShutsuryokuK().setRadToshoShutsuryokuK(radToshoShutsuryokuK);
    }

    @JsonIgnore
    public DropDownList getDdlChukiKaishiKiK() {
        return this.getKarisantei().getToshoShutsuryokuK().getDdlChukiKaishiKiK();
    }

    @JsonIgnore
    public void setDdlChukiKaishiKiK(DropDownList ddlChukiKaishiKiK) {
        this.getKarisantei().getToshoShutsuryokuK().setDdlChukiKaishiKiK(ddlChukiKaishiKiK);
    }

    @JsonIgnore
    public DropDownList getDdlKokiKaishiKiK() {
        return this.getKarisantei().getToshoShutsuryokuK().getDdlKokiKaishiKiK();
    }

    @JsonIgnore
    public void setDdlKokiKaishiKiK(DropDownList ddlKokiKaishiKiK) {
        this.getKarisantei().getToshoShutsuryokuK().setDdlKokiKaishiKiK(ddlKokiKaishiKiK);
    }

    @JsonIgnore
    public SanteiKisoShutsuryokuHohoDiv getSanteiKisoShutsuryokuHoho() {
        return this.getKarisantei().getSanteiKisoShutsuryokuHoho();
    }

    @JsonIgnore
    public void setSanteiKisoShutsuryokuHoho(SanteiKisoShutsuryokuHohoDiv SanteiKisoShutsuryokuHoho) {
        this.getKarisantei().setSanteiKisoShutsuryokuHoho(SanteiKisoShutsuryokuHoho);
    }

    @JsonIgnore
    public DropDownList getDdlKiso1() {
        return this.getKarisantei().getSanteiKisoShutsuryokuHoho().getDdlKiso1();
    }

    @JsonIgnore
    public void setDdlKiso1(DropDownList ddlKiso1) {
        this.getKarisantei().getSanteiKisoShutsuryokuHoho().setDdlKiso1(ddlKiso1);
    }

    @JsonIgnore
    public DropDownList getDdlKiso2() {
        return this.getKarisantei().getSanteiKisoShutsuryokuHoho().getDdlKiso2();
    }

    @JsonIgnore
    public void setDdlKiso2(DropDownList ddlKiso2) {
        this.getKarisantei().getSanteiKisoShutsuryokuHoho().setDdlKiso2(ddlKiso2);
    }

    @JsonIgnore
    public DropDownList getDdlKiso3() {
        return this.getKarisantei().getSanteiKisoShutsuryokuHoho().getDdlKiso3();
    }

    @JsonIgnore
    public void setDdlKiso3(DropDownList ddlKiso3) {
        this.getKarisantei().getSanteiKisoShutsuryokuHoho().setDdlKiso3(ddlKiso3);
    }

    @JsonIgnore
    public SaGakuHDiv getSaGakuH() {
        return this.getHonsantei().getSaGakuH();
    }

    @JsonIgnore
    public void setSaGakuH(SaGakuHDiv SaGakuH) {
        this.getHonsantei().setSaGakuH(SaGakuH);
    }

    @JsonIgnore
    public RadioButton getRadSagakuReishoHakkoUmuH() {
        return this.getHonsantei().getSaGakuH().getRadSagakuReishoHakkoUmuH();
    }

    @JsonIgnore
    public void setRadSagakuReishoHakkoUmuH(RadioButton radSagakuReishoHakkoUmuH) {
        this.getHonsantei().getSaGakuH().setRadSagakuReishoHakkoUmuH(radSagakuReishoHakkoUmuH);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getHonsantei().getSaGakuH().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getHonsantei().getSaGakuH().setLin3(lin3);
    }

    @JsonIgnore
    public RadioButton getRadBarCodeHyojiH() {
        return this.getHonsantei().getSaGakuH().getRadBarCodeHyojiH();
    }

    @JsonIgnore
    public void setRadBarCodeHyojiH(RadioButton radBarCodeHyojiH) {
        this.getHonsantei().getSaGakuH().setRadBarCodeHyojiH(radBarCodeHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadKozaNofushoHyojiH() {
        return this.getHonsantei().getSaGakuH().getRadKozaNofushoHyojiH();
    }

    @JsonIgnore
    public void setRadKozaNofushoHyojiH(RadioButton radKozaNofushoHyojiH) {
        this.getHonsantei().getSaGakuH().setRadKozaNofushoHyojiH(radKozaNofushoHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadNofishoHakkoYMDHyojiH() {
        return this.getHonsantei().getSaGakuH().getRadNofishoHakkoYMDHyojiH();
    }

    @JsonIgnore
    public void setRadNofishoHakkoYMDHyojiH(RadioButton radNofishoHakkoYMDHyojiH) {
        this.getHonsantei().getSaGakuH().setRadNofishoHakkoYMDHyojiH(radNofishoHakkoYMDHyojiH);
    }

    @JsonIgnore
    public RadioButton getRadNofishoToriatsukaiKigenHyojiH() {
        return this.getHonsantei().getSaGakuH().getRadNofishoToriatsukaiKigenHyojiH();
    }

    @JsonIgnore
    public void setRadNofishoToriatsukaiKigenHyojiH(RadioButton radNofishoToriatsukaiKigenHyojiH) {
        this.getHonsantei().getSaGakuH().setRadNofishoToriatsukaiKigenHyojiH(radNofishoToriatsukaiKigenHyojiH);
    }

    @JsonIgnore
    public ToshoShutsuryokuHDiv getToshoShutsuryokuH() {
        return this.getHonsantei().getToshoShutsuryokuH();
    }

    @JsonIgnore
    public void setToshoShutsuryokuH(ToshoShutsuryokuHDiv ToshoShutsuryokuH) {
        this.getHonsantei().setToshoShutsuryokuH(ToshoShutsuryokuH);
    }

    @JsonIgnore
    public RadioButton getRadToshoShutsuryokuH() {
        return this.getHonsantei().getToshoShutsuryokuH().getRadToshoShutsuryokuH();
    }

    @JsonIgnore
    public void setRadToshoShutsuryokuH(RadioButton radToshoShutsuryokuH) {
        this.getHonsantei().getToshoShutsuryokuH().setRadToshoShutsuryokuH(radToshoShutsuryokuH);
    }

    @JsonIgnore
    public DropDownList getDdlChukiKaishiKiH() {
        return this.getHonsantei().getToshoShutsuryokuH().getDdlChukiKaishiKiH();
    }

    @JsonIgnore
    public void setDdlChukiKaishiKiH(DropDownList ddlChukiKaishiKiH) {
        this.getHonsantei().getToshoShutsuryokuH().setDdlChukiKaishiKiH(ddlChukiKaishiKiH);
    }

    @JsonIgnore
    public DropDownList getDdlKokiKaishiKiH() {
        return this.getHonsantei().getToshoShutsuryokuH().getDdlKokiKaishiKiH();
    }

    @JsonIgnore
    public void setDdlKokiKaishiKiH(DropDownList ddlKokiKaishiKiH) {
        this.getHonsantei().getToshoShutsuryokuH().setDdlKokiKaishiKiH(ddlKokiKaishiKiH);
    }

    @JsonIgnore
    public KanendoMongonDiv getKanendoMongon() {
        return this.getHonsantei().getKanendoMongon();
    }

    @JsonIgnore
    public void setKanendoMongon(KanendoMongonDiv KanendoMongon) {
        this.getHonsantei().setKanendoMongon(KanendoMongon);
    }

    @JsonIgnore
    public RadioButton getRadKanendoMongon1() {
        return this.getHonsantei().getKanendoMongon().getRadKanendoMongon1();
    }

    @JsonIgnore
    public void setRadKanendoMongon1(RadioButton radKanendoMongon1) {
        this.getHonsantei().getKanendoMongon().setRadKanendoMongon1(radKanendoMongon1);
    }

    @JsonIgnore
    public RadioButton getRadKanendoMongon2() {
        return this.getHonsantei().getKanendoMongon().getRadKanendoMongon2();
    }

    @JsonIgnore
    public void setRadKanendoMongon2(RadioButton radKanendoMongon2) {
        this.getHonsantei().getKanendoMongon().setRadKanendoMongon2(radKanendoMongon2);
    }

    // </editor-fold>
}
