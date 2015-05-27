package jp.co.ndensan.reams.db.dbd.divcontroller.entity.shujiiIryokikanandshujiiinput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ShujiiIryokikanAndShujiiInput のクラスファイル
 *
 * @author 自動生成
 */
public class ShujiiIryokikanAndShujiiInputDiv extends Panel implements IShujiiIryokikanAndShujiiInputDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIryoKikanCode")
    private TextBoxCode txtIryoKikanCode;
    @JsonProperty("btnIryokikanGuide")
    private ButtonDialog btnIryokikanGuide;
    @JsonProperty("txtIryoKikanName")
    private TextBox txtIryoKikanName;
    @JsonProperty("btnShujiiRenrakuJiko")
    private ButtonDialog btnShujiiRenrakuJiko;
    @JsonProperty("btnZenkaiIrokikanJoho")
    private Button btnZenkaiIrokikanJoho;
    @JsonProperty("txtShujiiCode")
    private TextBoxCode txtShujiiCode;
    @JsonProperty("btnShujiiGuide")
    private ButtonDialog btnShujiiGuide;
    @JsonProperty("txtShujiiName")
    private TextBox txtShujiiName;
    @JsonProperty("chkShiteii")
    private CheckBoxList chkShiteii;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;
    @JsonProperty("hdnShujiiRenrakuJiko")
    private RString hdnShujiiRenrakuJiko;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnShichosonCode")
    private RString hdnShichosonCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtIryoKikanCode")
    public TextBoxCode getTxtIryoKikanCode() {
        return txtIryoKikanCode;
    }

    @JsonProperty("txtIryoKikanCode")
    public void setTxtIryoKikanCode(TextBoxCode txtIryoKikanCode) {
        this.txtIryoKikanCode = txtIryoKikanCode;
    }

    @JsonProperty("btnIryokikanGuide")
    public ButtonDialog getBtnIryokikanGuide() {
        return btnIryokikanGuide;
    }

    @JsonProperty("btnIryokikanGuide")
    public void setBtnIryokikanGuide(ButtonDialog btnIryokikanGuide) {
        this.btnIryokikanGuide = btnIryokikanGuide;
    }

    @JsonProperty("txtIryoKikanName")
    public TextBox getTxtIryoKikanName() {
        return txtIryoKikanName;
    }

    @JsonProperty("txtIryoKikanName")
    public void setTxtIryoKikanName(TextBox txtIryoKikanName) {
        this.txtIryoKikanName = txtIryoKikanName;
    }

    @JsonProperty("btnShujiiRenrakuJiko")
    public ButtonDialog getBtnShujiiRenrakuJiko() {
        return btnShujiiRenrakuJiko;
    }

    @JsonProperty("btnShujiiRenrakuJiko")
    public void setBtnShujiiRenrakuJiko(ButtonDialog btnShujiiRenrakuJiko) {
        this.btnShujiiRenrakuJiko = btnShujiiRenrakuJiko;
    }

    @JsonProperty("btnZenkaiIrokikanJoho")
    public Button getBtnZenkaiIrokikanJoho() {
        return btnZenkaiIrokikanJoho;
    }

    @JsonProperty("btnZenkaiIrokikanJoho")
    public void setBtnZenkaiIrokikanJoho(Button btnZenkaiIrokikanJoho) {
        this.btnZenkaiIrokikanJoho = btnZenkaiIrokikanJoho;
    }

    @JsonProperty("txtShujiiCode")
    public TextBoxCode getTxtShujiiCode() {
        return txtShujiiCode;
    }

    @JsonProperty("txtShujiiCode")
    public void setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.txtShujiiCode = txtShujiiCode;
    }

    @JsonProperty("btnShujiiGuide")
    public ButtonDialog getBtnShujiiGuide() {
        return btnShujiiGuide;
    }

    @JsonProperty("btnShujiiGuide")
    public void setBtnShujiiGuide(ButtonDialog btnShujiiGuide) {
        this.btnShujiiGuide = btnShujiiGuide;
    }

    @JsonProperty("txtShujiiName")
    public TextBox getTxtShujiiName() {
        return txtShujiiName;
    }

    @JsonProperty("txtShujiiName")
    public void setTxtShujiiName(TextBox txtShujiiName) {
        this.txtShujiiName = txtShujiiName;
    }

    @JsonProperty("chkShiteii")
    public CheckBoxList getChkShiteii() {
        return chkShiteii;
    }

    @JsonProperty("chkShiteii")
    public void setChkShiteii(CheckBoxList chkShiteii) {
        this.chkShiteii = chkShiteii;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode = hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnShujiiRenrakuJiko")
    public RString getHdnShujiiRenrakuJiko() {
        return hdnShujiiRenrakuJiko;
    }

    @JsonProperty("hdnShujiiRenrakuJiko")
    public void setHdnShujiiRenrakuJiko(RString hdnShujiiRenrakuJiko) {
        this.hdnShujiiRenrakuJiko = hdnShujiiRenrakuJiko;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo = hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnShichosonCode")
    public RString getHdnShichosonCode() {
        return hdnShichosonCode;
    }

    @JsonProperty("hdnShichosonCode")
    public void setHdnShichosonCode(RString hdnShichosonCode) {
        this.hdnShichosonCode = hdnShichosonCode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void clear() {
        createHandler().clear();
    }

    @JsonIgnore
    private ShujiiIryokikanAndShujiiInputHandler createHandler() {
        return new ShujiiIryokikanAndShujiiInputHandler(this);
    }
}
