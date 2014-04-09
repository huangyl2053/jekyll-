package jp.co.ndensan.reams.db.dbb.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、以下の状況下で不正な動作の原因になったり、
 * コードが再生成されるときに損失したりします。
 * Wed Apr 09 09:37:23 JST 2014 
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SashidashininKakuninPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SashidashininKakuninPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblYubinNoCheck")
    private Label lblYubinNoCheck;
    @JsonProperty("TextBoxYubinNo1")
    private TextBoxYubinNo TextBoxYubinNo1;
    @JsonProperty("lblShozaiCheck")
    private Label lblShozaiCheck;
    @JsonProperty("txtShozaiCheck")
    private TextBox txtShozaiCheck;
    @JsonProperty("lblTantoCheck")
    private Label lblTantoCheck;
    @JsonProperty("txtTantoCheck")
    private TextBox txtTantoCheck;
    @JsonProperty("lblTellNoCheck")
    private Label lblTellNoCheck;
    @JsonProperty("txtTellNoCheck")
    private TextBox txtTellNoCheck;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblYubinNoCheck")
    public Label getLblYubinNoCheck() {
        return lblYubinNoCheck;
    }

    @JsonProperty("lblYubinNoCheck")
    public void setLblYubinNoCheck(Label lblYubinNoCheck) {
        this.lblYubinNoCheck=lblYubinNoCheck;
    }

    @JsonProperty("TextBoxYubinNo1")
    public TextBoxYubinNo getTextBoxYubinNo1() {
        return TextBoxYubinNo1;
    }

    @JsonProperty("TextBoxYubinNo1")
    public void setTextBoxYubinNo1(TextBoxYubinNo TextBoxYubinNo1) {
        this.TextBoxYubinNo1=TextBoxYubinNo1;
    }

    @JsonProperty("lblShozaiCheck")
    public Label getLblShozaiCheck() {
        return lblShozaiCheck;
    }

    @JsonProperty("lblShozaiCheck")
    public void setLblShozaiCheck(Label lblShozaiCheck) {
        this.lblShozaiCheck=lblShozaiCheck;
    }

    @JsonProperty("txtShozaiCheck")
    public TextBox getTxtShozaiCheck() {
        return txtShozaiCheck;
    }

    @JsonProperty("txtShozaiCheck")
    public void setTxtShozaiCheck(TextBox txtShozaiCheck) {
        this.txtShozaiCheck=txtShozaiCheck;
    }

    @JsonProperty("lblTantoCheck")
    public Label getLblTantoCheck() {
        return lblTantoCheck;
    }

    @JsonProperty("lblTantoCheck")
    public void setLblTantoCheck(Label lblTantoCheck) {
        this.lblTantoCheck=lblTantoCheck;
    }

    @JsonProperty("txtTantoCheck")
    public TextBox getTxtTantoCheck() {
        return txtTantoCheck;
    }

    @JsonProperty("txtTantoCheck")
    public void setTxtTantoCheck(TextBox txtTantoCheck) {
        this.txtTantoCheck=txtTantoCheck;
    }

    @JsonProperty("lblTellNoCheck")
    public Label getLblTellNoCheck() {
        return lblTellNoCheck;
    }

    @JsonProperty("lblTellNoCheck")
    public void setLblTellNoCheck(Label lblTellNoCheck) {
        this.lblTellNoCheck=lblTellNoCheck;
    }

    @JsonProperty("txtTellNoCheck")
    public TextBox getTxtTellNoCheck() {
        return txtTellNoCheck;
    }

    @JsonProperty("txtTellNoCheck")
    public void setTxtTellNoCheck(TextBox txtTellNoCheck) {
        this.txtTellNoCheck=txtTellNoCheck;
    }

}
