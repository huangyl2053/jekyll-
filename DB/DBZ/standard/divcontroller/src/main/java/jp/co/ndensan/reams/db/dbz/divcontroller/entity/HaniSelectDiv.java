package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HaniSelect のクラスファイル 
 * 
 * @author 自動生成
 */
public class HaniSelectDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHaniSt")
    private ButtonDialog btnHaniSt;
    @JsonProperty("txtCodeHaniSt")
    private TextBox txtCodeHaniSt;
    @JsonProperty("txtHaniStMeisho")
    private TextBox txtHaniStMeisho;
    @JsonProperty("btnHaniEd")
    private ButtonDialog btnHaniEd;
    @JsonProperty("txtCodeHaniEd")
    private TextBox txtCodeHaniEd;
    @JsonProperty("txtHaniEdMeisho")
    private TextBox txtHaniEdMeisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnHaniSt")
    public ButtonDialog getBtnHaniSt() {
        return btnHaniSt;
    }

    @JsonProperty("btnHaniSt")
    public void setBtnHaniSt(ButtonDialog btnHaniSt) {
        this.btnHaniSt=btnHaniSt;
    }

    @JsonProperty("txtCodeHaniSt")
    public TextBox getTxtCodeHaniSt() {
        return txtCodeHaniSt;
    }

    @JsonProperty("txtCodeHaniSt")
    public void setTxtCodeHaniSt(TextBox txtCodeHaniSt) {
        this.txtCodeHaniSt=txtCodeHaniSt;
    }

    @JsonProperty("txtHaniStMeisho")
    public TextBox getTxtHaniStMeisho() {
        return txtHaniStMeisho;
    }

    @JsonProperty("txtHaniStMeisho")
    public void setTxtHaniStMeisho(TextBox txtHaniStMeisho) {
        this.txtHaniStMeisho=txtHaniStMeisho;
    }

    @JsonProperty("btnHaniEd")
    public ButtonDialog getBtnHaniEd() {
        return btnHaniEd;
    }

    @JsonProperty("btnHaniEd")
    public void setBtnHaniEd(ButtonDialog btnHaniEd) {
        this.btnHaniEd=btnHaniEd;
    }

    @JsonProperty("txtCodeHaniEd")
    public TextBox getTxtCodeHaniEd() {
        return txtCodeHaniEd;
    }

    @JsonProperty("txtCodeHaniEd")
    public void setTxtCodeHaniEd(TextBox txtCodeHaniEd) {
        this.txtCodeHaniEd=txtCodeHaniEd;
    }

    @JsonProperty("txtHaniEdMeisho")
    public TextBox getTxtHaniEdMeisho() {
        return txtHaniEdMeisho;
    }

    @JsonProperty("txtHaniEdMeisho")
    public void setTxtHaniEdMeisho(TextBox txtHaniEdMeisho) {
        this.txtHaniEdMeisho=txtHaniEdMeisho;
    }

}
