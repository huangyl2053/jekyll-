package jp.co.ndensan.reams.db.dbe.divcontroller.entity.commonchilddiv.ShobyoIken.ShobyoIken;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.CodeInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.CodeInput.ICodeInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShindanName のクラスファイル
 *
 */
public class ShindanNameDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_12-59-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShindanName1")
    private TextBox txtShindanName1;
    @JsonProperty("txtShindanYMD1")
    private TextBoxDate txtShindanYMD1;
    @JsonProperty("txtShindanName2")
    private TextBox txtShindanName2;
    @JsonProperty("txtShindanYMD2")
    private TextBoxDate txtShindanYMD2;
    @JsonProperty("txtShindanName")
    private TextBox txtShindanName;
    @JsonProperty("txtShindanYMD3")
    private TextBoxDate txtShindanYMD3;
    @JsonProperty("geninShikkanPanel")
    private geninShikkanPanelDiv geninShikkanPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShindanName1
     * @return txtShindanName1
     */
    @JsonProperty("txtShindanName1")
    public TextBox getTxtShindanName1() {
        return txtShindanName1;
    }

    /*
     * settxtShindanName1
     * @param txtShindanName1 txtShindanName1
     */
    @JsonProperty("txtShindanName1")
    public void setTxtShindanName1(TextBox txtShindanName1) {
        this.txtShindanName1 = txtShindanName1;
    }

    /*
     * gettxtShindanYMD1
     * @return txtShindanYMD1
     */
    @JsonProperty("txtShindanYMD1")
    public TextBoxDate getTxtShindanYMD1() {
        return txtShindanYMD1;
    }

    /*
     * settxtShindanYMD1
     * @param txtShindanYMD1 txtShindanYMD1
     */
    @JsonProperty("txtShindanYMD1")
    public void setTxtShindanYMD1(TextBoxDate txtShindanYMD1) {
        this.txtShindanYMD1 = txtShindanYMD1;
    }

    /*
     * gettxtShindanName2
     * @return txtShindanName2
     */
    @JsonProperty("txtShindanName2")
    public TextBox getTxtShindanName2() {
        return txtShindanName2;
    }

    /*
     * settxtShindanName2
     * @param txtShindanName2 txtShindanName2
     */
    @JsonProperty("txtShindanName2")
    public void setTxtShindanName2(TextBox txtShindanName2) {
        this.txtShindanName2 = txtShindanName2;
    }

    /*
     * gettxtShindanYMD2
     * @return txtShindanYMD2
     */
    @JsonProperty("txtShindanYMD2")
    public TextBoxDate getTxtShindanYMD2() {
        return txtShindanYMD2;
    }

    /*
     * settxtShindanYMD2
     * @param txtShindanYMD2 txtShindanYMD2
     */
    @JsonProperty("txtShindanYMD2")
    public void setTxtShindanYMD2(TextBoxDate txtShindanYMD2) {
        this.txtShindanYMD2 = txtShindanYMD2;
    }

    /*
     * gettxtShindanName
     * @return txtShindanName
     */
    @JsonProperty("txtShindanName")
    public TextBox getTxtShindanName() {
        return txtShindanName;
    }

    /*
     * settxtShindanName
     * @param txtShindanName txtShindanName
     */
    @JsonProperty("txtShindanName")
    public void setTxtShindanName(TextBox txtShindanName) {
        this.txtShindanName = txtShindanName;
    }

    /*
     * gettxtShindanYMD3
     * @return txtShindanYMD3
     */
    @JsonProperty("txtShindanYMD3")
    public TextBoxDate getTxtShindanYMD3() {
        return txtShindanYMD3;
    }

    /*
     * settxtShindanYMD3
     * @param txtShindanYMD3 txtShindanYMD3
     */
    @JsonProperty("txtShindanYMD3")
    public void setTxtShindanYMD3(TextBoxDate txtShindanYMD3) {
        this.txtShindanYMD3 = txtShindanYMD3;
    }

    /*
     * getgeninShikkanPanel
     * @return geninShikkanPanel
     */
    @JsonProperty("geninShikkanPanel")
    public geninShikkanPanelDiv getGeninShikkanPanel() {
        return geninShikkanPanel;
    }

    /*
     * setgeninShikkanPanel
     * @param geninShikkanPanel geninShikkanPanel
     */
    @JsonProperty("geninShikkanPanel")
    public void setGeninShikkanPanel(geninShikkanPanelDiv geninShikkanPanel) {
        this.geninShikkanPanel = geninShikkanPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAdd() {
        return this.getGeninShikkanPanel().getBtnAdd();
    }

    @JsonIgnore
    public void  setBtnAdd(Button btnAdd) {
        this.getGeninShikkanPanel().setBtnAdd(btnAdd);
    }

    @JsonIgnore
    public DataGrid<dgGenyin_Row> getDgGenyin() {
        return this.getGeninShikkanPanel().getDgGenyin();
    }

    @JsonIgnore
    public void  setDgGenyin(DataGrid<dgGenyin_Row> dgGenyin) {
        this.getGeninShikkanPanel().setDgGenyin(dgGenyin);
    }

    @JsonIgnore
    public geninShikkanShosaiDiv getGeninShikkanShosai() {
        return this.getGeninShikkanPanel().getGeninShikkanShosai();
    }

    @JsonIgnore
    public void  setGeninShikkanShosai(geninShikkanShosaiDiv geninShikkanShosai) {
        this.getGeninShikkanPanel().setGeninShikkanShosai(geninShikkanShosai);
    }

    @JsonIgnore
    public ICodeInputDiv getCcdCodeInputGeninShikkan() {
        return this.getGeninShikkanPanel().getGeninShikkanShosai().getCcdCodeInputGeninShikkan();
    }

    @JsonIgnore
    public RadioButton getRadIsShutaruGeninShikkan() {
        return this.getGeninShikkanPanel().getGeninShikkanShosai().getRadIsShutaruGeninShikkan();
    }

    @JsonIgnore
    public void  setRadIsShutaruGeninShikkan(RadioButton radIsShutaruGeninShikkan) {
        this.getGeninShikkanPanel().getGeninShikkanShosai().setRadIsShutaruGeninShikkan(radIsShutaruGeninShikkan);
    }

    @JsonIgnore
    public Button getBtnNo() {
        return this.getGeninShikkanPanel().getGeninShikkanShosai().getBtnNo();
    }

    @JsonIgnore
    public void  setBtnNo(Button btnNo) {
        this.getGeninShikkanPanel().getGeninShikkanShosai().setBtnNo(btnNo);
    }

    @JsonIgnore
    public Button getBtnOK() {
        return this.getGeninShikkanPanel().getGeninShikkanShosai().getBtnOK();
    }

    @JsonIgnore
    public void  setBtnOK(Button btnOK) {
        this.getGeninShikkanPanel().getGeninShikkanShosai().setBtnOK(btnOK);
    }

    // </editor-fold>
}
