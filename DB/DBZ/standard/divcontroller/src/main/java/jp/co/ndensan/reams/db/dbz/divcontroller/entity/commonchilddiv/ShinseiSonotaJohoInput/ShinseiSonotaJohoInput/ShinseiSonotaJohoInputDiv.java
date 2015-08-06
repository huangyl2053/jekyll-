package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiSonotaJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiSonotaJohoInputDiv extends Panel implements IShinseiSonotaJohoInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-49">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlIdoJiyu")
    private DropDownList ddlIdoJiyu;
    @JsonProperty("ddlSakujoJiyu")
    private DropDownList ddlSakujoJiyu;
    @JsonProperty("txtRiyu")
    private TextBox txtRiyu;
    @JsonProperty("txtSoshitsuDay")
    private TextBoxFlexibleDate txtSoshitsuDay;
    @JsonProperty("txtTorikeshiDay")
    private TextBoxFlexibleDate txtTorikeshiDay;
    @JsonProperty("txtToshoNinteiKikanFrom")
    private TextBoxFlexibleDate txtToshoNinteiKikanFrom;
    @JsonProperty("txtToshoNinteiKikanTo")
    private TextBoxFlexibleDate txtToshoNinteiKikanTo;
    @JsonProperty("lblJukyuShikakuShomeisho")
    private Label lblJukyuShikakuShomeisho;
    @JsonProperty("txtJukyuShikakuHakkoDay1")
    private TextBoxFlexibleDate txtJukyuShikakuHakkoDay1;
    @JsonProperty("txtJukyuShikakuHakkoDay2")
    private TextBoxFlexibleDate txtJukyuShikakuHakkoDay2;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlIdoJiyu")
    public DropDownList getDdlIdoJiyu() {
        return ddlIdoJiyu;
    }

    @JsonProperty("ddlIdoJiyu")
    public void setDdlIdoJiyu(DropDownList ddlIdoJiyu) {
        this.ddlIdoJiyu=ddlIdoJiyu;
    }

    @JsonProperty("ddlSakujoJiyu")
    public DropDownList getDdlSakujoJiyu() {
        return ddlSakujoJiyu;
    }

    @JsonProperty("ddlSakujoJiyu")
    public void setDdlSakujoJiyu(DropDownList ddlSakujoJiyu) {
        this.ddlSakujoJiyu=ddlSakujoJiyu;
    }

    @JsonProperty("txtRiyu")
    public TextBox getTxtRiyu() {
        return txtRiyu;
    }

    @JsonProperty("txtRiyu")
    public void setTxtRiyu(TextBox txtRiyu) {
        this.txtRiyu=txtRiyu;
    }

    @JsonProperty("txtSoshitsuDay")
    public TextBoxFlexibleDate getTxtSoshitsuDay() {
        return txtSoshitsuDay;
    }

    @JsonProperty("txtSoshitsuDay")
    public void setTxtSoshitsuDay(TextBoxFlexibleDate txtSoshitsuDay) {
        this.txtSoshitsuDay=txtSoshitsuDay;
    }

    @JsonProperty("txtTorikeshiDay")
    public TextBoxFlexibleDate getTxtTorikeshiDay() {
        return txtTorikeshiDay;
    }

    @JsonProperty("txtTorikeshiDay")
    public void setTxtTorikeshiDay(TextBoxFlexibleDate txtTorikeshiDay) {
        this.txtTorikeshiDay=txtTorikeshiDay;
    }

    @JsonProperty("txtToshoNinteiKikanFrom")
    public TextBoxFlexibleDate getTxtToshoNinteiKikanFrom() {
        return txtToshoNinteiKikanFrom;
    }

    @JsonProperty("txtToshoNinteiKikanFrom")
    public void setTxtToshoNinteiKikanFrom(TextBoxFlexibleDate txtToshoNinteiKikanFrom) {
        this.txtToshoNinteiKikanFrom=txtToshoNinteiKikanFrom;
    }

    @JsonProperty("txtToshoNinteiKikanTo")
    public TextBoxFlexibleDate getTxtToshoNinteiKikanTo() {
        return txtToshoNinteiKikanTo;
    }

    @JsonProperty("txtToshoNinteiKikanTo")
    public void setTxtToshoNinteiKikanTo(TextBoxFlexibleDate txtToshoNinteiKikanTo) {
        this.txtToshoNinteiKikanTo=txtToshoNinteiKikanTo;
    }

    @JsonProperty("lblJukyuShikakuShomeisho")
    public Label getLblJukyuShikakuShomeisho() {
        return lblJukyuShikakuShomeisho;
    }

    @JsonProperty("lblJukyuShikakuShomeisho")
    public void setLblJukyuShikakuShomeisho(Label lblJukyuShikakuShomeisho) {
        this.lblJukyuShikakuShomeisho=lblJukyuShikakuShomeisho;
    }

    @JsonProperty("txtJukyuShikakuHakkoDay1")
    public TextBoxFlexibleDate getTxtJukyuShikakuHakkoDay1() {
        return txtJukyuShikakuHakkoDay1;
    }

    @JsonProperty("txtJukyuShikakuHakkoDay1")
    public void setTxtJukyuShikakuHakkoDay1(TextBoxFlexibleDate txtJukyuShikakuHakkoDay1) {
        this.txtJukyuShikakuHakkoDay1=txtJukyuShikakuHakkoDay1;
    }

    @JsonProperty("txtJukyuShikakuHakkoDay2")
    public TextBoxFlexibleDate getTxtJukyuShikakuHakkoDay2() {
        return txtJukyuShikakuHakkoDay2;
    }

    @JsonProperty("txtJukyuShikakuHakkoDay2")
    public void setTxtJukyuShikakuHakkoDay2(TextBoxFlexibleDate txtJukyuShikakuHakkoDay2) {
        this.txtJukyuShikakuHakkoDay2=txtJukyuShikakuHakkoDay2;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode=hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo=hdnShinseishoKanriNo;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
