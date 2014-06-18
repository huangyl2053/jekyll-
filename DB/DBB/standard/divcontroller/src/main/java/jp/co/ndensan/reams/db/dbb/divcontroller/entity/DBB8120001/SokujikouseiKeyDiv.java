package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB8120001;
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
 * SokujikouseiKey のクラスファイル 
 * 
 * @author 自動生成
 */
public class SokujikouseiKeyDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblFukaNendo")
    private Label lblFukaNendo;
    @JsonProperty("txtFukaNendo")
    private TextBox txtFukaNendo;
    @JsonProperty("lblChoteiYMD")
    private Label lblChoteiYMD;
    @JsonProperty("txtChoteiYMD")
    private TextBoxDate txtChoteiYMD;
    @JsonProperty("lblKoseiTsuki")
    private Label lblKoseiTsuki;
    @JsonProperty("ddlKoseiTsuki")
    private DropDownList ddlKoseiTsuki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblFukaNendo")
    public Label getLblFukaNendo() {
        return lblFukaNendo;
    }

    @JsonProperty("lblFukaNendo")
    public void setLblFukaNendo(Label lblFukaNendo) {
        this.lblFukaNendo=lblFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public TextBox getTxtFukaNendo() {
        return txtFukaNendo;
    }

    @JsonProperty("txtFukaNendo")
    public void setTxtFukaNendo(TextBox txtFukaNendo) {
        this.txtFukaNendo=txtFukaNendo;
    }

    @JsonProperty("lblChoteiYMD")
    public Label getLblChoteiYMD() {
        return lblChoteiYMD;
    }

    @JsonProperty("lblChoteiYMD")
    public void setLblChoteiYMD(Label lblChoteiYMD) {
        this.lblChoteiYMD=lblChoteiYMD;
    }

    @JsonProperty("txtChoteiYMD")
    public TextBoxDate getTxtChoteiYMD() {
        return txtChoteiYMD;
    }

    @JsonProperty("txtChoteiYMD")
    public void setTxtChoteiYMD(TextBoxDate txtChoteiYMD) {
        this.txtChoteiYMD=txtChoteiYMD;
    }

    @JsonProperty("lblKoseiTsuki")
    public Label getLblKoseiTsuki() {
        return lblKoseiTsuki;
    }

    @JsonProperty("lblKoseiTsuki")
    public void setLblKoseiTsuki(Label lblKoseiTsuki) {
        this.lblKoseiTsuki=lblKoseiTsuki;
    }

    @JsonProperty("ddlKoseiTsuki")
    public DropDownList getDdlKoseiTsuki() {
        return ddlKoseiTsuki;
    }

    @JsonProperty("ddlKoseiTsuki")
    public void setDdlKoseiTsuki(DropDownList ddlKoseiTsuki) {
        this.ddlKoseiTsuki=ddlKoseiTsuki;
    }

}
