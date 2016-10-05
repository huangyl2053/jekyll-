package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD6010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SystemKanriNinteiShien のクラスファイル 
 * 
 * @author 自動生成
 */
public class SystemKanriNinteiShienDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlIfShurui")
    private DropDownList ddlIfShurui;
    @JsonProperty("ddlShujiiChosainJohoTorikomi")
    private DropDownList ddlShujiiChosainJohoTorikomi;
    @JsonProperty("txtNinteiIfKaiteiYMD")
    private TextBoxDate txtNinteiIfKaiteiYMD;
    @JsonProperty("radShinseiKanren")
    private RadioButton radShinseiKanren;
    @JsonProperty("radIkkatsuKoshin")
    private RadioButton radIkkatsuKoshin;
    @JsonProperty("linSystemKanri")
    private HorizontalLine linSystemKanri;
    @JsonProperty("lblYoshikiOld")
    private Label lblYoshikiOld;
    @JsonProperty("lblYoshikiNew")
    private Label lblYoshikiNew;
    @JsonProperty("txtNinteiKekkaFileOld")
    private TextBox txtNinteiKekkaFileOld;
    @JsonProperty("txtNinteiKekkaFileNew")
    private TextBox txtNinteiKekkaFileNew;
    @JsonProperty("txtShiteiJigyoOutFileOld")
    private TextBox txtShiteiJigyoOutFileOld;
    @JsonProperty("txtShiteiJigyoOutFileNew")
    private TextBox txtShiteiJigyoOutFileNew;
    @JsonProperty("txtChosainOutFileOld")
    private TextBox txtChosainOutFileOld;
    @JsonProperty("txtChosainOutFileNew")
    private TextBox txtChosainOutFileNew;
    @JsonProperty("txtIryoKikanOutFileOld")
    private TextBox txtIryoKikanOutFileOld;
    @JsonProperty("txtIryoKikanOutFileNew")
    private TextBox txtIryoKikanOutFileNew;
    @JsonProperty("txtShujiiOutFileOld")
    private TextBox txtShujiiOutFileOld;
    @JsonProperty("txtShujiiOutFileNew")
    private TextBox txtShujiiOutFileNew;
    @JsonProperty("txtShinseiJohoOutFileOld")
    private TextBox txtShinseiJohoOutFileOld;
    @JsonProperty("txtShinseiJohoOutFileNew")
    private TextBox txtShinseiJohoOutFileNew;
    @JsonProperty("txtShiboJohoFile")
    private TextBox txtShiboJohoFile;
    @JsonProperty("txtTennyuShiboFile")
    private TextBox txtTennyuShiboFile;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlIfShurui
     * @return ddlIfShurui
     */
    @JsonProperty("ddlIfShurui")
    public DropDownList getDdlIfShurui() {
        return ddlIfShurui;
    }

    /*
     * setddlIfShurui
     * @param ddlIfShurui ddlIfShurui
     */
    @JsonProperty("ddlIfShurui")
    public void setDdlIfShurui(DropDownList ddlIfShurui) {
        this.ddlIfShurui = ddlIfShurui;
    }

    /*
     * getddlShujiiChosainJohoTorikomi
     * @return ddlShujiiChosainJohoTorikomi
     */
    @JsonProperty("ddlShujiiChosainJohoTorikomi")
    public DropDownList getDdlShujiiChosainJohoTorikomi() {
        return ddlShujiiChosainJohoTorikomi;
    }

    /*
     * setddlShujiiChosainJohoTorikomi
     * @param ddlShujiiChosainJohoTorikomi ddlShujiiChosainJohoTorikomi
     */
    @JsonProperty("ddlShujiiChosainJohoTorikomi")
    public void setDdlShujiiChosainJohoTorikomi(DropDownList ddlShujiiChosainJohoTorikomi) {
        this.ddlShujiiChosainJohoTorikomi = ddlShujiiChosainJohoTorikomi;
    }

    /*
     * gettxtNinteiIfKaiteiYMD
     * @return txtNinteiIfKaiteiYMD
     */
    @JsonProperty("txtNinteiIfKaiteiYMD")
    public TextBoxDate getTxtNinteiIfKaiteiYMD() {
        return txtNinteiIfKaiteiYMD;
    }

    /*
     * settxtNinteiIfKaiteiYMD
     * @param txtNinteiIfKaiteiYMD txtNinteiIfKaiteiYMD
     */
    @JsonProperty("txtNinteiIfKaiteiYMD")
    public void setTxtNinteiIfKaiteiYMD(TextBoxDate txtNinteiIfKaiteiYMD) {
        this.txtNinteiIfKaiteiYMD = txtNinteiIfKaiteiYMD;
    }

    /*
     * getradShinseiKanren
     * @return radShinseiKanren
     */
    @JsonProperty("radShinseiKanren")
    public RadioButton getRadShinseiKanren() {
        return radShinseiKanren;
    }

    /*
     * setradShinseiKanren
     * @param radShinseiKanren radShinseiKanren
     */
    @JsonProperty("radShinseiKanren")
    public void setRadShinseiKanren(RadioButton radShinseiKanren) {
        this.radShinseiKanren = radShinseiKanren;
    }

    /*
     * getradIkkatsuKoshin
     * @return radIkkatsuKoshin
     */
    @JsonProperty("radIkkatsuKoshin")
    public RadioButton getRadIkkatsuKoshin() {
        return radIkkatsuKoshin;
    }

    /*
     * setradIkkatsuKoshin
     * @param radIkkatsuKoshin radIkkatsuKoshin
     */
    @JsonProperty("radIkkatsuKoshin")
    public void setRadIkkatsuKoshin(RadioButton radIkkatsuKoshin) {
        this.radIkkatsuKoshin = radIkkatsuKoshin;
    }

    /*
     * getlinSystemKanri
     * @return linSystemKanri
     */
    @JsonProperty("linSystemKanri")
    public HorizontalLine getLinSystemKanri() {
        return linSystemKanri;
    }

    /*
     * setlinSystemKanri
     * @param linSystemKanri linSystemKanri
     */
    @JsonProperty("linSystemKanri")
    public void setLinSystemKanri(HorizontalLine linSystemKanri) {
        this.linSystemKanri = linSystemKanri;
    }

    /*
     * getlblYoshikiOld
     * @return lblYoshikiOld
     */
    @JsonProperty("lblYoshikiOld")
    public Label getLblYoshikiOld() {
        return lblYoshikiOld;
    }

    /*
     * setlblYoshikiOld
     * @param lblYoshikiOld lblYoshikiOld
     */
    @JsonProperty("lblYoshikiOld")
    public void setLblYoshikiOld(Label lblYoshikiOld) {
        this.lblYoshikiOld = lblYoshikiOld;
    }

    /*
     * getlblYoshikiNew
     * @return lblYoshikiNew
     */
    @JsonProperty("lblYoshikiNew")
    public Label getLblYoshikiNew() {
        return lblYoshikiNew;
    }

    /*
     * setlblYoshikiNew
     * @param lblYoshikiNew lblYoshikiNew
     */
    @JsonProperty("lblYoshikiNew")
    public void setLblYoshikiNew(Label lblYoshikiNew) {
        this.lblYoshikiNew = lblYoshikiNew;
    }

    /*
     * gettxtNinteiKekkaFileOld
     * @return txtNinteiKekkaFileOld
     */
    @JsonProperty("txtNinteiKekkaFileOld")
    public TextBox getTxtNinteiKekkaFileOld() {
        return txtNinteiKekkaFileOld;
    }

    /*
     * settxtNinteiKekkaFileOld
     * @param txtNinteiKekkaFileOld txtNinteiKekkaFileOld
     */
    @JsonProperty("txtNinteiKekkaFileOld")
    public void setTxtNinteiKekkaFileOld(TextBox txtNinteiKekkaFileOld) {
        this.txtNinteiKekkaFileOld = txtNinteiKekkaFileOld;
    }

    /*
     * gettxtNinteiKekkaFileNew
     * @return txtNinteiKekkaFileNew
     */
    @JsonProperty("txtNinteiKekkaFileNew")
    public TextBox getTxtNinteiKekkaFileNew() {
        return txtNinteiKekkaFileNew;
    }

    /*
     * settxtNinteiKekkaFileNew
     * @param txtNinteiKekkaFileNew txtNinteiKekkaFileNew
     */
    @JsonProperty("txtNinteiKekkaFileNew")
    public void setTxtNinteiKekkaFileNew(TextBox txtNinteiKekkaFileNew) {
        this.txtNinteiKekkaFileNew = txtNinteiKekkaFileNew;
    }

    /*
     * gettxtShiteiJigyoOutFileOld
     * @return txtShiteiJigyoOutFileOld
     */
    @JsonProperty("txtShiteiJigyoOutFileOld")
    public TextBox getTxtShiteiJigyoOutFileOld() {
        return txtShiteiJigyoOutFileOld;
    }

    /*
     * settxtShiteiJigyoOutFileOld
     * @param txtShiteiJigyoOutFileOld txtShiteiJigyoOutFileOld
     */
    @JsonProperty("txtShiteiJigyoOutFileOld")
    public void setTxtShiteiJigyoOutFileOld(TextBox txtShiteiJigyoOutFileOld) {
        this.txtShiteiJigyoOutFileOld = txtShiteiJigyoOutFileOld;
    }

    /*
     * gettxtShiteiJigyoOutFileNew
     * @return txtShiteiJigyoOutFileNew
     */
    @JsonProperty("txtShiteiJigyoOutFileNew")
    public TextBox getTxtShiteiJigyoOutFileNew() {
        return txtShiteiJigyoOutFileNew;
    }

    /*
     * settxtShiteiJigyoOutFileNew
     * @param txtShiteiJigyoOutFileNew txtShiteiJigyoOutFileNew
     */
    @JsonProperty("txtShiteiJigyoOutFileNew")
    public void setTxtShiteiJigyoOutFileNew(TextBox txtShiteiJigyoOutFileNew) {
        this.txtShiteiJigyoOutFileNew = txtShiteiJigyoOutFileNew;
    }

    /*
     * gettxtChosainOutFileOld
     * @return txtChosainOutFileOld
     */
    @JsonProperty("txtChosainOutFileOld")
    public TextBox getTxtChosainOutFileOld() {
        return txtChosainOutFileOld;
    }

    /*
     * settxtChosainOutFileOld
     * @param txtChosainOutFileOld txtChosainOutFileOld
     */
    @JsonProperty("txtChosainOutFileOld")
    public void setTxtChosainOutFileOld(TextBox txtChosainOutFileOld) {
        this.txtChosainOutFileOld = txtChosainOutFileOld;
    }

    /*
     * gettxtChosainOutFileNew
     * @return txtChosainOutFileNew
     */
    @JsonProperty("txtChosainOutFileNew")
    public TextBox getTxtChosainOutFileNew() {
        return txtChosainOutFileNew;
    }

    /*
     * settxtChosainOutFileNew
     * @param txtChosainOutFileNew txtChosainOutFileNew
     */
    @JsonProperty("txtChosainOutFileNew")
    public void setTxtChosainOutFileNew(TextBox txtChosainOutFileNew) {
        this.txtChosainOutFileNew = txtChosainOutFileNew;
    }

    /*
     * gettxtIryoKikanOutFileOld
     * @return txtIryoKikanOutFileOld
     */
    @JsonProperty("txtIryoKikanOutFileOld")
    public TextBox getTxtIryoKikanOutFileOld() {
        return txtIryoKikanOutFileOld;
    }

    /*
     * settxtIryoKikanOutFileOld
     * @param txtIryoKikanOutFileOld txtIryoKikanOutFileOld
     */
    @JsonProperty("txtIryoKikanOutFileOld")
    public void setTxtIryoKikanOutFileOld(TextBox txtIryoKikanOutFileOld) {
        this.txtIryoKikanOutFileOld = txtIryoKikanOutFileOld;
    }

    /*
     * gettxtIryoKikanOutFileNew
     * @return txtIryoKikanOutFileNew
     */
    @JsonProperty("txtIryoKikanOutFileNew")
    public TextBox getTxtIryoKikanOutFileNew() {
        return txtIryoKikanOutFileNew;
    }

    /*
     * settxtIryoKikanOutFileNew
     * @param txtIryoKikanOutFileNew txtIryoKikanOutFileNew
     */
    @JsonProperty("txtIryoKikanOutFileNew")
    public void setTxtIryoKikanOutFileNew(TextBox txtIryoKikanOutFileNew) {
        this.txtIryoKikanOutFileNew = txtIryoKikanOutFileNew;
    }

    /*
     * gettxtShujiiOutFileOld
     * @return txtShujiiOutFileOld
     */
    @JsonProperty("txtShujiiOutFileOld")
    public TextBox getTxtShujiiOutFileOld() {
        return txtShujiiOutFileOld;
    }

    /*
     * settxtShujiiOutFileOld
     * @param txtShujiiOutFileOld txtShujiiOutFileOld
     */
    @JsonProperty("txtShujiiOutFileOld")
    public void setTxtShujiiOutFileOld(TextBox txtShujiiOutFileOld) {
        this.txtShujiiOutFileOld = txtShujiiOutFileOld;
    }

    /*
     * gettxtShujiiOutFileNew
     * @return txtShujiiOutFileNew
     */
    @JsonProperty("txtShujiiOutFileNew")
    public TextBox getTxtShujiiOutFileNew() {
        return txtShujiiOutFileNew;
    }

    /*
     * settxtShujiiOutFileNew
     * @param txtShujiiOutFileNew txtShujiiOutFileNew
     */
    @JsonProperty("txtShujiiOutFileNew")
    public void setTxtShujiiOutFileNew(TextBox txtShujiiOutFileNew) {
        this.txtShujiiOutFileNew = txtShujiiOutFileNew;
    }

    /*
     * gettxtShinseiJohoOutFileOld
     * @return txtShinseiJohoOutFileOld
     */
    @JsonProperty("txtShinseiJohoOutFileOld")
    public TextBox getTxtShinseiJohoOutFileOld() {
        return txtShinseiJohoOutFileOld;
    }

    /*
     * settxtShinseiJohoOutFileOld
     * @param txtShinseiJohoOutFileOld txtShinseiJohoOutFileOld
     */
    @JsonProperty("txtShinseiJohoOutFileOld")
    public void setTxtShinseiJohoOutFileOld(TextBox txtShinseiJohoOutFileOld) {
        this.txtShinseiJohoOutFileOld = txtShinseiJohoOutFileOld;
    }

    /*
     * gettxtShinseiJohoOutFileNew
     * @return txtShinseiJohoOutFileNew
     */
    @JsonProperty("txtShinseiJohoOutFileNew")
    public TextBox getTxtShinseiJohoOutFileNew() {
        return txtShinseiJohoOutFileNew;
    }

    /*
     * settxtShinseiJohoOutFileNew
     * @param txtShinseiJohoOutFileNew txtShinseiJohoOutFileNew
     */
    @JsonProperty("txtShinseiJohoOutFileNew")
    public void setTxtShinseiJohoOutFileNew(TextBox txtShinseiJohoOutFileNew) {
        this.txtShinseiJohoOutFileNew = txtShinseiJohoOutFileNew;
    }

    /*
     * gettxtShiboJohoFile
     * @return txtShiboJohoFile
     */
    @JsonProperty("txtShiboJohoFile")
    public TextBox getTxtShiboJohoFile() {
        return txtShiboJohoFile;
    }

    /*
     * settxtShiboJohoFile
     * @param txtShiboJohoFile txtShiboJohoFile
     */
    @JsonProperty("txtShiboJohoFile")
    public void setTxtShiboJohoFile(TextBox txtShiboJohoFile) {
        this.txtShiboJohoFile = txtShiboJohoFile;
    }

    /*
     * gettxtTennyuShiboFile
     * @return txtTennyuShiboFile
     */
    @JsonProperty("txtTennyuShiboFile")
    public TextBox getTxtTennyuShiboFile() {
        return txtTennyuShiboFile;
    }

    /*
     * settxtTennyuShiboFile
     * @param txtTennyuShiboFile txtTennyuShiboFile
     */
    @JsonProperty("txtTennyuShiboFile")
    public void setTxtTennyuShiboFile(TextBox txtTennyuShiboFile) {
        this.txtTennyuShiboFile = txtTennyuShiboFile;
    }

    // </editor-fold>
}
