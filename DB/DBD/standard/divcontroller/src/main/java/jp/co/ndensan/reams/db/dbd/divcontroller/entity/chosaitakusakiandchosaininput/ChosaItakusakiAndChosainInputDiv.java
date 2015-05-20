package jp.co.ndensan.reams.db.dbd.divcontroller.entity.chosaitakusakiandchosaininput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChosaItakusakiAndChosainInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakusakiAndChosainInputDiv extends Panel implements IChosaItakusakiAndChosainInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosaItakusakiCode")
    private TextBoxCode txtChosaItakusakiCode;
    @JsonProperty("btnChosaItakusakiGuide")
    private ButtonDialog btnChosaItakusakiGuide;
    @JsonProperty("txtChosaItakusakiName")
    private TextBox txtChosaItakusakiName;
    @JsonProperty("btnChosainRenrakuJiko")
    private ButtonDialog btnChosainRenrakuJiko;
    @JsonProperty("btnZenkaiFukusha")
    private Button btnZenkaiFukusha;
    @JsonProperty("txtChosainCode")
    private TextBoxCode txtChosainCode;
    @JsonProperty("btnChosainGuide")
    private ButtonDialog btnChosainGuide;
    @JsonProperty("txtChosainName")
    private TextBox txtChosainName;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChosaItakusakiCode")
    public TextBoxCode getTxtChosaItakusakiCode() {
        return txtChosaItakusakiCode;
    }

    @JsonProperty("txtChosaItakusakiCode")
    public void setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.txtChosaItakusakiCode=txtChosaItakusakiCode;
    }

    @JsonProperty("btnChosaItakusakiGuide")
    public ButtonDialog getBtnChosaItakusakiGuide() {
        return btnChosaItakusakiGuide;
    }

    @JsonProperty("btnChosaItakusakiGuide")
    public void setBtnChosaItakusakiGuide(ButtonDialog btnChosaItakusakiGuide) {
        this.btnChosaItakusakiGuide=btnChosaItakusakiGuide;
    }

    @JsonProperty("txtChosaItakusakiName")
    public TextBox getTxtChosaItakusakiName() {
        return txtChosaItakusakiName;
    }

    @JsonProperty("txtChosaItakusakiName")
    public void setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.txtChosaItakusakiName=txtChosaItakusakiName;
    }

    @JsonProperty("btnChosainRenrakuJiko")
    public ButtonDialog getBtnChosainRenrakuJiko() {
        return btnChosainRenrakuJiko;
    }

    @JsonProperty("btnChosainRenrakuJiko")
    public void setBtnChosainRenrakuJiko(ButtonDialog btnChosainRenrakuJiko) {
        this.btnChosainRenrakuJiko=btnChosainRenrakuJiko;
    }

    @JsonProperty("btnZenkaiFukusha")
    public Button getBtnZenkaiFukusha() {
        return btnZenkaiFukusha;
    }

    @JsonProperty("btnZenkaiFukusha")
    public void setBtnZenkaiFukusha(Button btnZenkaiFukusha) {
        this.btnZenkaiFukusha=btnZenkaiFukusha;
    }

    @JsonProperty("txtChosainCode")
    public TextBoxCode getTxtChosainCode() {
        return txtChosainCode;
    }

    @JsonProperty("txtChosainCode")
    public void setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.txtChosainCode=txtChosainCode;
    }

    @JsonProperty("btnChosainGuide")
    public ButtonDialog getBtnChosainGuide() {
        return btnChosainGuide;
    }

    @JsonProperty("btnChosainGuide")
    public void setBtnChosainGuide(ButtonDialog btnChosainGuide) {
        this.btnChosainGuide=btnChosainGuide;
    }

    @JsonProperty("txtChosainName")
    public TextBox getTxtChosainName() {
        return txtChosainName;
    }

    @JsonProperty("txtChosainName")
    public void setTxtChosainName(TextBox txtChosainName) {
        this.txtChosainName=txtChosainName;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode=hdnDatabaseSubGyomuCode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
