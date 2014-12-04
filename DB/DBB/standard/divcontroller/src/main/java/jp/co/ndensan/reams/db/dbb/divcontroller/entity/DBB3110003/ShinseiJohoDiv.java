package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB3110003;
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
 * ShinseiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiJohoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiNendo")
    private TextBox txtChoteiNendo;
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("btnYuyoShurui")
    private Button btnYuyoShurui;
    @JsonProperty("txtYuyoShurui")
    private TextBox txtYuyoShurui;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChoteiNendo")
    public TextBox getTxtChoteiNendo() {
        return txtChoteiNendo;
    }

    @JsonProperty("txtChoteiNendo")
    public void setTxtChoteiNendo(TextBox txtChoteiNendo) {
        this.txtChoteiNendo=txtChoteiNendo;
    }

    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo=txtFukaNendo;
    }

    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD=txtShinseiYMD;
    }

    @JsonProperty("btnYuyoShurui")
    public Button getBtnYuyoShurui() {
        return btnYuyoShurui;
    }

    @JsonProperty("btnYuyoShurui")
    public void setBtnYuyoShurui(Button btnYuyoShurui) {
        this.btnYuyoShurui=btnYuyoShurui;
    }

    @JsonProperty("txtYuyoShurui")
    public TextBox getTxtYuyoShurui() {
        return txtYuyoShurui;
    }

    @JsonProperty("txtYuyoShurui")
    public void setTxtYuyoShurui(TextBox txtYuyoShurui) {
        this.txtYuyoShurui=txtYuyoShurui;
    }

    @JsonProperty("txtShinseiRiyu")
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.txtShinseiRiyu=txtShinseiRiyu;
    }

}
