package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblChoteiJiyu3 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChoteiJiyu3Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChoteiJiyu31")
    private celChoteiJiyu31AttblChoteiJiyu3 celChoteiJiyu31;
    @JsonProperty("celChoteiJiyu32")
    private celChoteiJiyu32AttblChoteiJiyu3 celChoteiJiyu32;
    @JsonProperty("celChoteiJiyu33")
    private celChoteiJiyu33AttblChoteiJiyu3 celChoteiJiyu33;
    @JsonProperty("celChoteiJiyu34")
    private celChoteiJiyu34AttblChoteiJiyu3 celChoteiJiyu34;
    @JsonProperty("celChoteiJiyu35")
    private celChoteiJiyu35AttblChoteiJiyu3 celChoteiJiyu35;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblChoteiJiyu3() {
        return this.celChoteiJiyu31.getLblChoteiJiyu3();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu31() {
        return this.celChoteiJiyu32.getTxtChoteiJiyu31();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu32() {
        return this.celChoteiJiyu33.getTxtChoteiJiyu32();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu33() {
        return this.celChoteiJiyu34.getTxtChoteiJiyu33();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu34() {
        return this.celChoteiJiyu35.getTxtChoteiJiyu34();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celChoteiJiyu31")
    private celChoteiJiyu31AttblChoteiJiyu3 getCelChoteiJiyu31() {
        return celChoteiJiyu31;
    }

    @JsonProperty("celChoteiJiyu31")
    private void setCelChoteiJiyu31(celChoteiJiyu31AttblChoteiJiyu3 celChoteiJiyu31) {
        this.celChoteiJiyu31=celChoteiJiyu31;
    }

    @JsonProperty("celChoteiJiyu32")
    private celChoteiJiyu32AttblChoteiJiyu3 getCelChoteiJiyu32() {
        return celChoteiJiyu32;
    }

    @JsonProperty("celChoteiJiyu32")
    private void setCelChoteiJiyu32(celChoteiJiyu32AttblChoteiJiyu3 celChoteiJiyu32) {
        this.celChoteiJiyu32=celChoteiJiyu32;
    }

    @JsonProperty("celChoteiJiyu33")
    private celChoteiJiyu33AttblChoteiJiyu3 getCelChoteiJiyu33() {
        return celChoteiJiyu33;
    }

    @JsonProperty("celChoteiJiyu33")
    private void setCelChoteiJiyu33(celChoteiJiyu33AttblChoteiJiyu3 celChoteiJiyu33) {
        this.celChoteiJiyu33=celChoteiJiyu33;
    }

    @JsonProperty("celChoteiJiyu34")
    private celChoteiJiyu34AttblChoteiJiyu3 getCelChoteiJiyu34() {
        return celChoteiJiyu34;
    }

    @JsonProperty("celChoteiJiyu34")
    private void setCelChoteiJiyu34(celChoteiJiyu34AttblChoteiJiyu3 celChoteiJiyu34) {
        this.celChoteiJiyu34=celChoteiJiyu34;
    }

    @JsonProperty("celChoteiJiyu35")
    private celChoteiJiyu35AttblChoteiJiyu3 getCelChoteiJiyu35() {
        return celChoteiJiyu35;
    }

    @JsonProperty("celChoteiJiyu35")
    private void setCelChoteiJiyu35(celChoteiJiyu35AttblChoteiJiyu3 celChoteiJiyu35) {
        this.celChoteiJiyu35=celChoteiJiyu35;
    }

}
/**
 * celChoteiJiyu31 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu31AttblChoteiJiyu3 extends TableCell {
    @JsonProperty("lblChoteiJiyu3")
    private Label lblChoteiJiyu3;

    @JsonProperty("lblChoteiJiyu3")
    public Label getLblChoteiJiyu3() {
        return lblChoteiJiyu3;
    }

    @JsonProperty("lblChoteiJiyu3")
    public void setLblChoteiJiyu3(Label lblChoteiJiyu3) {
        this.lblChoteiJiyu3=lblChoteiJiyu3;
    }

}
/**
 * celChoteiJiyu32 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu32AttblChoteiJiyu3 extends TableCell {
    @JsonProperty("txtChoteiJiyu31")
    private TextBox txtChoteiJiyu31;

    @JsonProperty("txtChoteiJiyu31")
    public TextBox getTxtChoteiJiyu31() {
        return txtChoteiJiyu31;
    }

    @JsonProperty("txtChoteiJiyu31")
    public void setTxtChoteiJiyu31(TextBox txtChoteiJiyu31) {
        this.txtChoteiJiyu31=txtChoteiJiyu31;
    }

}
/**
 * celChoteiJiyu33 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu33AttblChoteiJiyu3 extends TableCell {
    @JsonProperty("txtChoteiJiyu32")
    private TextBox txtChoteiJiyu32;

    @JsonProperty("txtChoteiJiyu32")
    public TextBox getTxtChoteiJiyu32() {
        return txtChoteiJiyu32;
    }

    @JsonProperty("txtChoteiJiyu32")
    public void setTxtChoteiJiyu32(TextBox txtChoteiJiyu32) {
        this.txtChoteiJiyu32=txtChoteiJiyu32;
    }

}
/**
 * celChoteiJiyu34 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu34AttblChoteiJiyu3 extends TableCell {
    @JsonProperty("txtChoteiJiyu33")
    private TextBox txtChoteiJiyu33;

    @JsonProperty("txtChoteiJiyu33")
    public TextBox getTxtChoteiJiyu33() {
        return txtChoteiJiyu33;
    }

    @JsonProperty("txtChoteiJiyu33")
    public void setTxtChoteiJiyu33(TextBox txtChoteiJiyu33) {
        this.txtChoteiJiyu33=txtChoteiJiyu33;
    }

}
/**
 * celChoteiJiyu35 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu35AttblChoteiJiyu3 extends TableCell {
    @JsonProperty("txtChoteiJiyu34")
    private TextBox txtChoteiJiyu34;

    @JsonProperty("txtChoteiJiyu34")
    public TextBox getTxtChoteiJiyu34() {
        return txtChoteiJiyu34;
    }

    @JsonProperty("txtChoteiJiyu34")
    public void setTxtChoteiJiyu34(TextBox txtChoteiJiyu34) {
        this.txtChoteiJiyu34=txtChoteiJiyu34;
    }

}
