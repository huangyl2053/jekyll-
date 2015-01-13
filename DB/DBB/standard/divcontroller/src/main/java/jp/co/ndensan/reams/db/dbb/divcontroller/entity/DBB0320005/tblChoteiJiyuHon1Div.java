package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320005;
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
 * tblChoteiJiyuHon1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChoteiJiyuHon1Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChoteiJiyu31")
    private celChoteiJiyu31AttblChoteiJiyuHon1 celChoteiJiyu31;
    @JsonProperty("celChoteiJiyu32")
    private celChoteiJiyu32AttblChoteiJiyuHon1 celChoteiJiyu32;
    @JsonProperty("celChoteiJiyu33")
    private celChoteiJiyu33AttblChoteiJiyuHon1 celChoteiJiyu33;
    @JsonProperty("celChoteiJiyu34")
    private celChoteiJiyu34AttblChoteiJiyuHon1 celChoteiJiyu34;
    @JsonProperty("celChoteiJiyu35")
    private celChoteiJiyu35AttblChoteiJiyuHon1 celChoteiJiyu35;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblChoteiJiyuHon1() {
        return this.celChoteiJiyu31.getLblChoteiJiyuHon1();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon11() {
        return this.celChoteiJiyu32.getTxtChoteiJiyuHon11();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon12() {
        return this.celChoteiJiyu33.getTxtChoteiJiyuHon12();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon13() {
        return this.celChoteiJiyu34.getTxtChoteiJiyuHon13();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuHon14() {
        return this.celChoteiJiyu35.getTxtChoteiJiyuHon14();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celChoteiJiyu31")
    private celChoteiJiyu31AttblChoteiJiyuHon1 getCelChoteiJiyu31() {
        return celChoteiJiyu31;
    }

    @JsonProperty("celChoteiJiyu31")
    private void setCelChoteiJiyu31(celChoteiJiyu31AttblChoteiJiyuHon1 celChoteiJiyu31) {
        this.celChoteiJiyu31=celChoteiJiyu31;
    }

    @JsonProperty("celChoteiJiyu32")
    private celChoteiJiyu32AttblChoteiJiyuHon1 getCelChoteiJiyu32() {
        return celChoteiJiyu32;
    }

    @JsonProperty("celChoteiJiyu32")
    private void setCelChoteiJiyu32(celChoteiJiyu32AttblChoteiJiyuHon1 celChoteiJiyu32) {
        this.celChoteiJiyu32=celChoteiJiyu32;
    }

    @JsonProperty("celChoteiJiyu33")
    private celChoteiJiyu33AttblChoteiJiyuHon1 getCelChoteiJiyu33() {
        return celChoteiJiyu33;
    }

    @JsonProperty("celChoteiJiyu33")
    private void setCelChoteiJiyu33(celChoteiJiyu33AttblChoteiJiyuHon1 celChoteiJiyu33) {
        this.celChoteiJiyu33=celChoteiJiyu33;
    }

    @JsonProperty("celChoteiJiyu34")
    private celChoteiJiyu34AttblChoteiJiyuHon1 getCelChoteiJiyu34() {
        return celChoteiJiyu34;
    }

    @JsonProperty("celChoteiJiyu34")
    private void setCelChoteiJiyu34(celChoteiJiyu34AttblChoteiJiyuHon1 celChoteiJiyu34) {
        this.celChoteiJiyu34=celChoteiJiyu34;
    }

    @JsonProperty("celChoteiJiyu35")
    private celChoteiJiyu35AttblChoteiJiyuHon1 getCelChoteiJiyu35() {
        return celChoteiJiyu35;
    }

    @JsonProperty("celChoteiJiyu35")
    private void setCelChoteiJiyu35(celChoteiJiyu35AttblChoteiJiyuHon1 celChoteiJiyu35) {
        this.celChoteiJiyu35=celChoteiJiyu35;
    }

}
/**
 * celChoteiJiyu31 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu31AttblChoteiJiyuHon1 extends TableCell {
    @JsonProperty("lblChoteiJiyuHon1")
    private Label lblChoteiJiyuHon1;

    @JsonProperty("lblChoteiJiyuHon1")
    public Label getLblChoteiJiyuHon1() {
        return lblChoteiJiyuHon1;
    }

    @JsonProperty("lblChoteiJiyuHon1")
    public void setLblChoteiJiyuHon1(Label lblChoteiJiyuHon1) {
        this.lblChoteiJiyuHon1=lblChoteiJiyuHon1;
    }

}
/**
 * celChoteiJiyu32 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu32AttblChoteiJiyuHon1 extends TableCell {
    @JsonProperty("txtChoteiJiyuHon11")
    private TextBox txtChoteiJiyuHon11;

    @JsonProperty("txtChoteiJiyuHon11")
    public TextBox getTxtChoteiJiyuHon11() {
        return txtChoteiJiyuHon11;
    }

    @JsonProperty("txtChoteiJiyuHon11")
    public void setTxtChoteiJiyuHon11(TextBox txtChoteiJiyuHon11) {
        this.txtChoteiJiyuHon11=txtChoteiJiyuHon11;
    }

}
/**
 * celChoteiJiyu33 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu33AttblChoteiJiyuHon1 extends TableCell {
    @JsonProperty("txtChoteiJiyuHon12")
    private TextBox txtChoteiJiyuHon12;

    @JsonProperty("txtChoteiJiyuHon12")
    public TextBox getTxtChoteiJiyuHon12() {
        return txtChoteiJiyuHon12;
    }

    @JsonProperty("txtChoteiJiyuHon12")
    public void setTxtChoteiJiyuHon12(TextBox txtChoteiJiyuHon12) {
        this.txtChoteiJiyuHon12=txtChoteiJiyuHon12;
    }

}
/**
 * celChoteiJiyu34 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu34AttblChoteiJiyuHon1 extends TableCell {
    @JsonProperty("txtChoteiJiyuHon13")
    private TextBox txtChoteiJiyuHon13;

    @JsonProperty("txtChoteiJiyuHon13")
    public TextBox getTxtChoteiJiyuHon13() {
        return txtChoteiJiyuHon13;
    }

    @JsonProperty("txtChoteiJiyuHon13")
    public void setTxtChoteiJiyuHon13(TextBox txtChoteiJiyuHon13) {
        this.txtChoteiJiyuHon13=txtChoteiJiyuHon13;
    }

}
/**
 * celChoteiJiyu35 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu35AttblChoteiJiyuHon1 extends TableCell {
    @JsonProperty("txtChoteiJiyuHon14")
    private TextBox txtChoteiJiyuHon14;

    @JsonProperty("txtChoteiJiyuHon14")
    public TextBox getTxtChoteiJiyuHon14() {
        return txtChoteiJiyuHon14;
    }

    @JsonProperty("txtChoteiJiyuHon14")
    public void setTxtChoteiJiyuHon14(TextBox txtChoteiJiyuHon14) {
        this.txtChoteiJiyuHon14=txtChoteiJiyuHon14;
    }

}
