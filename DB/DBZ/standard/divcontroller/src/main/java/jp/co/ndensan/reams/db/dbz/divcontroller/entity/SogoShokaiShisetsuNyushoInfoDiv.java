package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.ISogoShokaiShisetsuNyushoInfoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SogoShokaiShisetsuNyushoInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class SogoShokaiShisetsuNyushoInfoDiv extends Panel implements ISogoShokaiShisetsuNyushoInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShisetsuBunrui")
    private TextBox txtShisetsuBunrui;
    @JsonProperty("txtShisetsuNyushoYMD")
    private TextBoxDate txtShisetsuNyushoYMD;
    @JsonProperty("txtShisetsuTaishoYMD")
    private TextBoxDate txtShisetsuTaishoYMD;
    @JsonProperty("txtShisetsuName")
    private TextBox txtShisetsuName;
    @JsonProperty("txtShisetsuJigyoshaNo")
    private TextBoxCode txtShisetsuJigyoshaNo;
    @JsonProperty("txtShisetsuJigyoshaName")
    private TextBox txtShisetsuJigyoshaName;
    @JsonProperty("txtShisetsuJigyoshaJusho")
    private TextBox txtShisetsuJigyoshaJusho;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShisetsuBunrui")
    public TextBox getTxtShisetsuBunrui() {
        return txtShisetsuBunrui;
    }

    @JsonProperty("txtShisetsuBunrui")
    public void setTxtShisetsuBunrui(TextBox txtShisetsuBunrui) {
        this.txtShisetsuBunrui=txtShisetsuBunrui;
    }

    @JsonProperty("txtShisetsuNyushoYMD")
    public TextBoxDate getTxtShisetsuNyushoYMD() {
        return txtShisetsuNyushoYMD;
    }

    @JsonProperty("txtShisetsuNyushoYMD")
    public void setTxtShisetsuNyushoYMD(TextBoxDate txtShisetsuNyushoYMD) {
        this.txtShisetsuNyushoYMD=txtShisetsuNyushoYMD;
    }

    @JsonProperty("txtShisetsuTaishoYMD")
    public TextBoxDate getTxtShisetsuTaishoYMD() {
        return txtShisetsuTaishoYMD;
    }

    @JsonProperty("txtShisetsuTaishoYMD")
    public void setTxtShisetsuTaishoYMD(TextBoxDate txtShisetsuTaishoYMD) {
        this.txtShisetsuTaishoYMD=txtShisetsuTaishoYMD;
    }

    @JsonProperty("txtShisetsuName")
    public TextBox getTxtShisetsuName() {
        return txtShisetsuName;
    }

    @JsonProperty("txtShisetsuName")
    public void setTxtShisetsuName(TextBox txtShisetsuName) {
        this.txtShisetsuName=txtShisetsuName;
    }

    @JsonProperty("txtShisetsuJigyoshaNo")
    public TextBoxCode getTxtShisetsuJigyoshaNo() {
        return txtShisetsuJigyoshaNo;
    }

    @JsonProperty("txtShisetsuJigyoshaNo")
    public void setTxtShisetsuJigyoshaNo(TextBoxCode txtShisetsuJigyoshaNo) {
        this.txtShisetsuJigyoshaNo=txtShisetsuJigyoshaNo;
    }

    @JsonProperty("txtShisetsuJigyoshaName")
    public TextBox getTxtShisetsuJigyoshaName() {
        return txtShisetsuJigyoshaName;
    }

    @JsonProperty("txtShisetsuJigyoshaName")
    public void setTxtShisetsuJigyoshaName(TextBox txtShisetsuJigyoshaName) {
        this.txtShisetsuJigyoshaName=txtShisetsuJigyoshaName;
    }

    @JsonProperty("txtShisetsuJigyoshaJusho")
    public TextBox getTxtShisetsuJigyoshaJusho() {
        return txtShisetsuJigyoshaJusho;
    }

    @JsonProperty("txtShisetsuJigyoshaJusho")
    public void setTxtShisetsuJigyoshaJusho(TextBox txtShisetsuJigyoshaJusho) {
        this.txtShisetsuJigyoshaJusho=txtShisetsuJigyoshaJusho;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    //--------------- この行より下にコードを追加してください -------------------

}
