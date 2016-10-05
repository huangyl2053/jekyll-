package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000062;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * SetaiJoho のクラスファイル
 *
 * @reamsid_L DBC-4620-010 wangkanglei
 */
public class SetaiJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSetaiCode")
    private TextBoxCode txtSetaiCode;
    @JsonProperty("txtShoriNendo")
    private TextBoxFlexibleDate txtShoriNendo;
    @JsonProperty("txtSetaiinHaakuKijunYMD")
    private TextBoxFlexibleDate txtSetaiinHaakuKijunYMD;
    @JsonProperty("txtShinseiYMD")
    private TextBoxFlexibleDate txtShinseiYMD;
    @JsonProperty("txtShinseishoSakuseiYMD")
    private TextBoxFlexibleDate txtShinseishoSakuseiYMD;
    @JsonProperty("SetaiJoho2")
    private SetaiJoho2Div SetaiJoho2;
    @JsonProperty("FuyoKojo")
    private FuyoKojoDiv FuyoKojo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSetaiCode
     * @return txtSetaiCode
     */
    @JsonProperty("txtSetaiCode")
    public TextBoxCode getTxtSetaiCode() {
        return txtSetaiCode;
    }

    /*
     * settxtSetaiCode
     * @param txtSetaiCode txtSetaiCode
     */
    @JsonProperty("txtSetaiCode")
    public void setTxtSetaiCode(TextBoxCode txtSetaiCode) {
        this.txtSetaiCode = txtSetaiCode;
    }

    /*
     * gettxtShoriNendo
     * @return txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public TextBoxFlexibleDate getTxtShoriNendo() {
        return txtShoriNendo;
    }

    /*
     * settxtShoriNendo
     * @param txtShoriNendo txtShoriNendo
     */
    @JsonProperty("txtShoriNendo")
    public void setTxtShoriNendo(TextBoxFlexibleDate txtShoriNendo) {
        this.txtShoriNendo = txtShoriNendo;
    }

    /*
     * gettxtSetaiinHaakuKijunYMD
     * @return txtSetaiinHaakuKijunYMD
     */
    @JsonProperty("txtSetaiinHaakuKijunYMD")
    public TextBoxFlexibleDate getTxtSetaiinHaakuKijunYMD() {
        return txtSetaiinHaakuKijunYMD;
    }

    /*
     * settxtSetaiinHaakuKijunYMD
     * @param txtSetaiinHaakuKijunYMD txtSetaiinHaakuKijunYMD
     */
    @JsonProperty("txtSetaiinHaakuKijunYMD")
    public void setTxtSetaiinHaakuKijunYMD(TextBoxFlexibleDate txtSetaiinHaakuKijunYMD) {
        this.txtSetaiinHaakuKijunYMD = txtSetaiinHaakuKijunYMD;
    }

    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * gettxtShinseishoSakuseiYMD
     * @return txtShinseishoSakuseiYMD
     */
    @JsonProperty("txtShinseishoSakuseiYMD")
    public TextBoxFlexibleDate getTxtShinseishoSakuseiYMD() {
        return txtShinseishoSakuseiYMD;
    }

    /*
     * settxtShinseishoSakuseiYMD
     * @param txtShinseishoSakuseiYMD txtShinseishoSakuseiYMD
     */
    @JsonProperty("txtShinseishoSakuseiYMD")
    public void setTxtShinseishoSakuseiYMD(TextBoxFlexibleDate txtShinseishoSakuseiYMD) {
        this.txtShinseishoSakuseiYMD = txtShinseishoSakuseiYMD;
    }

    /*
     * getSetaiJoho2
     * @return SetaiJoho2
     */
    @JsonProperty("SetaiJoho2")
    public SetaiJoho2Div getSetaiJoho2() {
        return SetaiJoho2;
    }

    /*
     * setSetaiJoho2
     * @param SetaiJoho2 SetaiJoho2
     */
    @JsonProperty("SetaiJoho2")
    public void setSetaiJoho2(SetaiJoho2Div SetaiJoho2) {
        this.SetaiJoho2 = SetaiJoho2;
    }

    /*
     * getFuyoKojo
     * @return FuyoKojo
     */
    @JsonProperty("FuyoKojo")
    public FuyoKojoDiv getFuyoKojo() {
        return FuyoKojo;
    }

    /*
     * setFuyoKojo
     * @param FuyoKojo FuyoKojo
     */
    @JsonProperty("FuyoKojo")
    public void setFuyoKojo(FuyoKojoDiv FuyoKojo) {
        this.FuyoKojo = FuyoKojo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtSetaiKazei() {
        return this.getSetaiJoho2().getTxtSetaiKazei();
    }

    @JsonIgnore
    public void setTxtSetaiKazei(TextBox txtSetaiKazei) {
        this.getSetaiJoho2().setTxtSetaiKazei(txtSetaiKazei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStartYM() {
        return this.getSetaiJoho2().getTxtTekiyoStartYM();
    }

    @JsonIgnore
    public void setTxtTekiyoStartYM(TextBoxFlexibleDate txtTekiyoStartYM) {
        this.getSetaiJoho2().setTxtTekiyoStartYM(txtTekiyoStartYM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoEndYM() {
        return this.getSetaiJoho2().getTxtTekiyoEndYM();
    }

    @JsonIgnore
    public void setTxtTekiyoEndYM(TextBoxFlexibleDate txtTekiyoEndYM) {
        this.getSetaiJoho2().setTxtTekiyoEndYM(txtTekiyoEndYM);
    }

    @JsonIgnore
    public DropDownList getDdlSanteiKijunGaku() {
        return this.getSetaiJoho2().getDdlSanteiKijunGaku();
    }

    @JsonIgnore
    public void setDdlSanteiKijunGaku(DropDownList ddlSanteiKijunGaku) {
        this.getSetaiJoho2().setDdlSanteiKijunGaku(ddlSanteiKijunGaku);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiYMD() {
        return this.getSetaiJoho2().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void setTxtKetteiYMD(TextBoxFlexibleDate txtKetteiYMD) {
        this.getSetaiJoho2().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiTsuchishoHakkoYMD() {
        return this.getSetaiJoho2().getTxtKetteiTsuchishoHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchishoHakkoYMD(TextBoxFlexibleDate txtKetteiTsuchishoHakkoYMD) {
        this.getSetaiJoho2().setTxtKetteiTsuchishoHakkoYMD(txtKetteiTsuchishoHakkoYMD);
    }

    @JsonIgnore
    public ButtonPanelDiv getButtonPanel() {
        return this.getFuyoKojo().getButtonPanel();
    }

    @JsonIgnore
    public void setButtonPanel(ButtonPanelDiv ButtonPanel) {
        this.getFuyoKojo().setButtonPanel(ButtonPanel);
    }

    @JsonIgnore
    public Button getBtnSetaiSaiSanshutsu() {
        return this.getFuyoKojo().getButtonPanel().getBtnSetaiSaiSanshutsu();
    }

    @JsonIgnore
    public void setBtnSetaiSaiSanshutsu(Button btnSetaiSaiSanshutsu) {
        this.getFuyoKojo().getButtonPanel().setBtnSetaiSaiSanshutsu(btnSetaiSaiSanshutsu);
    }

    @JsonIgnore
    public Button getBtnKojoSaiSanshutsu() {
        return this.getFuyoKojo().getButtonPanel().getBtnKojoSaiSanshutsu();
    }

    @JsonIgnore
    public void setBtnKojoSaiSanshutsu(Button btnKojoSaiSanshutsu) {
        this.getFuyoKojo().getButtonPanel().setBtnKojoSaiSanshutsu(btnKojoSaiSanshutsu);
    }

    @JsonIgnore
    public Label getLblKojoTaisho() {
        return this.getFuyoKojo().getLblKojoTaisho();
    }

    @JsonIgnore
    public void setLblKojoTaisho(Label lblKojoTaisho) {
        this.getFuyoKojo().setLblKojoTaisho(lblKojoTaisho);
    }

    @JsonIgnore
    public ZennenKojoTaishoDiv getZennenKojoTaisho() {
        return this.getFuyoKojo().getZennenKojoTaisho();
    }

    @JsonIgnore
    public void setZennenKojoTaisho(ZennenKojoTaishoDiv ZennenKojoTaisho) {
        this.getFuyoKojo().setZennenKojoTaisho(ZennenKojoTaisho);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder16() {
        return this.getFuyoKojo().getZennenKojoTaisho().getTxtUnder16();
    }

    @JsonIgnore
    public void setTxtUnder16(TextBoxNum txtUnder16) {
        this.getFuyoKojo().getZennenKojoTaisho().setTxtUnder16(txtUnder16);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver16() {
        return this.getFuyoKojo().getZennenKojoTaisho().getTxtOver16();
    }

    @JsonIgnore
    public void setTxtOver16(TextBoxNum txtOver16) {
        this.getFuyoKojo().getZennenKojoTaisho().setTxtOver16(txtOver16);
    }

    // </editor-fold>
}
