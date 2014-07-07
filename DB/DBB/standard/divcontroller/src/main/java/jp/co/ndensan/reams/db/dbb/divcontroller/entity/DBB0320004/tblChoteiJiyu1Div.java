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
 * tblChoteiJiyu1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChoteiJiyu1Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChoteiJiyu11")
    private celChoteiJiyu11AttblChoteiJiyu1 celChoteiJiyu11;
    @JsonProperty("celChoteiJiyu12")
    private celChoteiJiyu12AttblChoteiJiyu1 celChoteiJiyu12;
    @JsonProperty("celChoteiJiyu13")
    private celChoteiJiyu13AttblChoteiJiyu1 celChoteiJiyu13;
    @JsonProperty("celChoteiJiyu14")
    private celChoteiJiyu14AttblChoteiJiyu1 celChoteiJiyu14;
    @JsonProperty("celChoteiJiyu15")
    private celChoteiJiyu15AttblChoteiJiyu1 celChoteiJiyu15;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblChoteiJiyu1() {
        return this.celChoteiJiyu11.getLblChoteiJiyu1();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu11() {
        return this.celChoteiJiyu12.getTxtChoteiJiyu11();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu12() {
        return this.celChoteiJiyu13.getTxtChoteiJiyu12();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu13() {
        return this.celChoteiJiyu14.getTxtChoteiJiyu13();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu14() {
        return this.celChoteiJiyu15.getTxtChoteiJiyu14();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celChoteiJiyu11")
    private celChoteiJiyu11AttblChoteiJiyu1 getCelChoteiJiyu11() {
        return celChoteiJiyu11;
    }

    @JsonProperty("celChoteiJiyu11")
    private void setCelChoteiJiyu11(celChoteiJiyu11AttblChoteiJiyu1 celChoteiJiyu11) {
        this.celChoteiJiyu11=celChoteiJiyu11;
    }

    @JsonProperty("celChoteiJiyu12")
    private celChoteiJiyu12AttblChoteiJiyu1 getCelChoteiJiyu12() {
        return celChoteiJiyu12;
    }

    @JsonProperty("celChoteiJiyu12")
    private void setCelChoteiJiyu12(celChoteiJiyu12AttblChoteiJiyu1 celChoteiJiyu12) {
        this.celChoteiJiyu12=celChoteiJiyu12;
    }

    @JsonProperty("celChoteiJiyu13")
    private celChoteiJiyu13AttblChoteiJiyu1 getCelChoteiJiyu13() {
        return celChoteiJiyu13;
    }

    @JsonProperty("celChoteiJiyu13")
    private void setCelChoteiJiyu13(celChoteiJiyu13AttblChoteiJiyu1 celChoteiJiyu13) {
        this.celChoteiJiyu13=celChoteiJiyu13;
    }

    @JsonProperty("celChoteiJiyu14")
    private celChoteiJiyu14AttblChoteiJiyu1 getCelChoteiJiyu14() {
        return celChoteiJiyu14;
    }

    @JsonProperty("celChoteiJiyu14")
    private void setCelChoteiJiyu14(celChoteiJiyu14AttblChoteiJiyu1 celChoteiJiyu14) {
        this.celChoteiJiyu14=celChoteiJiyu14;
    }

    @JsonProperty("celChoteiJiyu15")
    private celChoteiJiyu15AttblChoteiJiyu1 getCelChoteiJiyu15() {
        return celChoteiJiyu15;
    }

    @JsonProperty("celChoteiJiyu15")
    private void setCelChoteiJiyu15(celChoteiJiyu15AttblChoteiJiyu1 celChoteiJiyu15) {
        this.celChoteiJiyu15=celChoteiJiyu15;
    }

}
/**
 * celChoteiJiyu11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu11AttblChoteiJiyu1 extends TableCell {
    @JsonProperty("lblChoteiJiyu1")
    private Label lblChoteiJiyu1;

    @JsonProperty("lblChoteiJiyu1")
    public Label getLblChoteiJiyu1() {
        return lblChoteiJiyu1;
    }

    @JsonProperty("lblChoteiJiyu1")
    public void setLblChoteiJiyu1(Label lblChoteiJiyu1) {
        this.lblChoteiJiyu1=lblChoteiJiyu1;
    }

}
/**
 * celChoteiJiyu12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu12AttblChoteiJiyu1 extends TableCell {
    @JsonProperty("txtChoteiJiyu11")
    private TextBox txtChoteiJiyu11;

    @JsonProperty("txtChoteiJiyu11")
    public TextBox getTxtChoteiJiyu11() {
        return txtChoteiJiyu11;
    }

    @JsonProperty("txtChoteiJiyu11")
    public void setTxtChoteiJiyu11(TextBox txtChoteiJiyu11) {
        this.txtChoteiJiyu11=txtChoteiJiyu11;
    }

}
/**
 * celChoteiJiyu13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu13AttblChoteiJiyu1 extends TableCell {
    @JsonProperty("txtChoteiJiyu12")
    private TextBox txtChoteiJiyu12;

    @JsonProperty("txtChoteiJiyu12")
    public TextBox getTxtChoteiJiyu12() {
        return txtChoteiJiyu12;
    }

    @JsonProperty("txtChoteiJiyu12")
    public void setTxtChoteiJiyu12(TextBox txtChoteiJiyu12) {
        this.txtChoteiJiyu12=txtChoteiJiyu12;
    }

}
/**
 * celChoteiJiyu14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu14AttblChoteiJiyu1 extends TableCell {
    @JsonProperty("txtChoteiJiyu13")
    private TextBox txtChoteiJiyu13;

    @JsonProperty("txtChoteiJiyu13")
    public TextBox getTxtChoteiJiyu13() {
        return txtChoteiJiyu13;
    }

    @JsonProperty("txtChoteiJiyu13")
    public void setTxtChoteiJiyu13(TextBox txtChoteiJiyu13) {
        this.txtChoteiJiyu13=txtChoteiJiyu13;
    }

}
/**
 * celChoteiJiyu15 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu15AttblChoteiJiyu1 extends TableCell {
    @JsonProperty("txtChoteiJiyu14")
    private TextBox txtChoteiJiyu14;

    @JsonProperty("txtChoteiJiyu14")
    public TextBox getTxtChoteiJiyu14() {
        return txtChoteiJiyu14;
    }

    @JsonProperty("txtChoteiJiyu14")
    public void setTxtChoteiJiyu14(TextBox txtChoteiJiyu14) {
        this.txtChoteiJiyu14=txtChoteiJiyu14;
    }

}
