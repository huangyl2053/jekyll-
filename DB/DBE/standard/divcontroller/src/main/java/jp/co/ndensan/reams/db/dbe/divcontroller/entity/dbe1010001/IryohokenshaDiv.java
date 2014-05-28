package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;
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
 * Iryohokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryohokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblIryohokenType")
    private Label lblIryohokenType;
    @JsonProperty("ddlIryohokenType")
    private DropDownList ddlIryohokenType;
    @JsonProperty("lblIryohokenshaNo")
    private Label lblIryohokenshaNo;
    @JsonProperty("txtIryohokenshaNo")
    private TextBoxCode txtIryohokenshaNo;
    @JsonProperty("lblIryohokenshaName")
    private Label lblIryohokenshaName;
    @JsonProperty("txtIryohokenshaName")
    private TextBox txtIryohokenshaName;
    @JsonProperty("lblIryohokenKigo")
    private Label lblIryohokenKigo;
    @JsonProperty("txtIryohokenKigo")
    private TextBoxCode txtIryohokenKigo;
    @JsonProperty("lblIryohokenBango")
    private Label lblIryohokenBango;
    @JsonProperty("txtIryohokenBango")
    private TextBoxCode txtIryohokenBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblIryohokenType")
    public Label getLblIryohokenType() {
        return lblIryohokenType;
    }

    @JsonProperty("lblIryohokenType")
    public void setLblIryohokenType(Label lblIryohokenType) {
        this.lblIryohokenType=lblIryohokenType;
    }

    @JsonProperty("ddlIryohokenType")
    public DropDownList getDdlIryohokenType() {
        return ddlIryohokenType;
    }

    @JsonProperty("ddlIryohokenType")
    public void setDdlIryohokenType(DropDownList ddlIryohokenType) {
        this.ddlIryohokenType=ddlIryohokenType;
    }

    @JsonProperty("lblIryohokenshaNo")
    public Label getLblIryohokenshaNo() {
        return lblIryohokenshaNo;
    }

    @JsonProperty("lblIryohokenshaNo")
    public void setLblIryohokenshaNo(Label lblIryohokenshaNo) {
        this.lblIryohokenshaNo=lblIryohokenshaNo;
    }

    @JsonProperty("txtIryohokenshaNo")
    public TextBoxCode getTxtIryohokenshaNo() {
        return txtIryohokenshaNo;
    }

    @JsonProperty("txtIryohokenshaNo")
    public void setTxtIryohokenshaNo(TextBoxCode txtIryohokenshaNo) {
        this.txtIryohokenshaNo=txtIryohokenshaNo;
    }

    @JsonProperty("lblIryohokenshaName")
    public Label getLblIryohokenshaName() {
        return lblIryohokenshaName;
    }

    @JsonProperty("lblIryohokenshaName")
    public void setLblIryohokenshaName(Label lblIryohokenshaName) {
        this.lblIryohokenshaName=lblIryohokenshaName;
    }

    @JsonProperty("txtIryohokenshaName")
    public TextBox getTxtIryohokenshaName() {
        return txtIryohokenshaName;
    }

    @JsonProperty("txtIryohokenshaName")
    public void setTxtIryohokenshaName(TextBox txtIryohokenshaName) {
        this.txtIryohokenshaName=txtIryohokenshaName;
    }

    @JsonProperty("lblIryohokenKigo")
    public Label getLblIryohokenKigo() {
        return lblIryohokenKigo;
    }

    @JsonProperty("lblIryohokenKigo")
    public void setLblIryohokenKigo(Label lblIryohokenKigo) {
        this.lblIryohokenKigo=lblIryohokenKigo;
    }

    @JsonProperty("txtIryohokenKigo")
    public TextBoxCode getTxtIryohokenKigo() {
        return txtIryohokenKigo;
    }

    @JsonProperty("txtIryohokenKigo")
    public void setTxtIryohokenKigo(TextBoxCode txtIryohokenKigo) {
        this.txtIryohokenKigo=txtIryohokenKigo;
    }

    @JsonProperty("lblIryohokenBango")
    public Label getLblIryohokenBango() {
        return lblIryohokenBango;
    }

    @JsonProperty("lblIryohokenBango")
    public void setLblIryohokenBango(Label lblIryohokenBango) {
        this.lblIryohokenBango=lblIryohokenBango;
    }

    @JsonProperty("txtIryohokenBango")
    public TextBoxCode getTxtIryohokenBango() {
        return txtIryohokenBango;
    }

    @JsonProperty("txtIryohokenBango")
    public void setTxtIryohokenBango(TextBoxCode txtIryohokenBango) {
        this.txtIryohokenBango=txtIryohokenBango;
    }

}
