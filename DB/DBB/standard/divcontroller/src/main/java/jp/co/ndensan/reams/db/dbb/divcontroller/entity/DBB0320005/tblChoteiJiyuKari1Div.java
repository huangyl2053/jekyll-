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
 * tblChoteiJiyuKari1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChoteiJiyuKari1Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChoteiJiyu11")
    private celChoteiJiyu11AttblChoteiJiyuKari1 celChoteiJiyu11;
    @JsonProperty("celChoteiJiyu12")
    private celChoteiJiyu12AttblChoteiJiyuKari1 celChoteiJiyu12;
    @JsonProperty("celChoteiJiyu13")
    private celChoteiJiyu13AttblChoteiJiyuKari1 celChoteiJiyu13;
    @JsonProperty("celChoteiJiyu14")
    private celChoteiJiyu14AttblChoteiJiyuKari1 celChoteiJiyu14;
    @JsonProperty("celChoteiJiyu15")
    private celChoteiJiyu15AttblChoteiJiyuKari1 celChoteiJiyu15;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblChoteiJiyuKari1() {
        return this.celChoteiJiyu11.getLblChoteiJiyuKari1();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari11() {
        return this.celChoteiJiyu12.getTxtChoteiJiyuKari11();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari12() {
        return this.celChoteiJiyu13.getTxtChoteiJiyuKari12();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari13() {
        return this.celChoteiJiyu14.getTxtChoteiJiyuKari13();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyuKari14() {
        return this.celChoteiJiyu15.getTxtChoteiJiyuKari14();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celChoteiJiyu11")
    private celChoteiJiyu11AttblChoteiJiyuKari1 getCelChoteiJiyu11() {
        return celChoteiJiyu11;
    }

    @JsonProperty("celChoteiJiyu11")
    private void setCelChoteiJiyu11(celChoteiJiyu11AttblChoteiJiyuKari1 celChoteiJiyu11) {
        this.celChoteiJiyu11=celChoteiJiyu11;
    }

    @JsonProperty("celChoteiJiyu12")
    private celChoteiJiyu12AttblChoteiJiyuKari1 getCelChoteiJiyu12() {
        return celChoteiJiyu12;
    }

    @JsonProperty("celChoteiJiyu12")
    private void setCelChoteiJiyu12(celChoteiJiyu12AttblChoteiJiyuKari1 celChoteiJiyu12) {
        this.celChoteiJiyu12=celChoteiJiyu12;
    }

    @JsonProperty("celChoteiJiyu13")
    private celChoteiJiyu13AttblChoteiJiyuKari1 getCelChoteiJiyu13() {
        return celChoteiJiyu13;
    }

    @JsonProperty("celChoteiJiyu13")
    private void setCelChoteiJiyu13(celChoteiJiyu13AttblChoteiJiyuKari1 celChoteiJiyu13) {
        this.celChoteiJiyu13=celChoteiJiyu13;
    }

    @JsonProperty("celChoteiJiyu14")
    private celChoteiJiyu14AttblChoteiJiyuKari1 getCelChoteiJiyu14() {
        return celChoteiJiyu14;
    }

    @JsonProperty("celChoteiJiyu14")
    private void setCelChoteiJiyu14(celChoteiJiyu14AttblChoteiJiyuKari1 celChoteiJiyu14) {
        this.celChoteiJiyu14=celChoteiJiyu14;
    }

    @JsonProperty("celChoteiJiyu15")
    private celChoteiJiyu15AttblChoteiJiyuKari1 getCelChoteiJiyu15() {
        return celChoteiJiyu15;
    }

    @JsonProperty("celChoteiJiyu15")
    private void setCelChoteiJiyu15(celChoteiJiyu15AttblChoteiJiyuKari1 celChoteiJiyu15) {
        this.celChoteiJiyu15=celChoteiJiyu15;
    }

}
/**
 * celChoteiJiyu11 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu11AttblChoteiJiyuKari1 extends TableCell {
    @JsonProperty("lblChoteiJiyuKari1")
    private Label lblChoteiJiyuKari1;

    @JsonProperty("lblChoteiJiyuKari1")
    public Label getLblChoteiJiyuKari1() {
        return lblChoteiJiyuKari1;
    }

    @JsonProperty("lblChoteiJiyuKari1")
    public void setLblChoteiJiyuKari1(Label lblChoteiJiyuKari1) {
        this.lblChoteiJiyuKari1=lblChoteiJiyuKari1;
    }

}
/**
 * celChoteiJiyu12 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu12AttblChoteiJiyuKari1 extends TableCell {
    @JsonProperty("txtChoteiJiyuKari11")
    private TextBox txtChoteiJiyuKari11;

    @JsonProperty("txtChoteiJiyuKari11")
    public TextBox getTxtChoteiJiyuKari11() {
        return txtChoteiJiyuKari11;
    }

    @JsonProperty("txtChoteiJiyuKari11")
    public void setTxtChoteiJiyuKari11(TextBox txtChoteiJiyuKari11) {
        this.txtChoteiJiyuKari11=txtChoteiJiyuKari11;
    }

}
/**
 * celChoteiJiyu13 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu13AttblChoteiJiyuKari1 extends TableCell {
    @JsonProperty("txtChoteiJiyuKari12")
    private TextBox txtChoteiJiyuKari12;

    @JsonProperty("txtChoteiJiyuKari12")
    public TextBox getTxtChoteiJiyuKari12() {
        return txtChoteiJiyuKari12;
    }

    @JsonProperty("txtChoteiJiyuKari12")
    public void setTxtChoteiJiyuKari12(TextBox txtChoteiJiyuKari12) {
        this.txtChoteiJiyuKari12=txtChoteiJiyuKari12;
    }

}
/**
 * celChoteiJiyu14 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu14AttblChoteiJiyuKari1 extends TableCell {
    @JsonProperty("txtChoteiJiyuKari13")
    private TextBox txtChoteiJiyuKari13;

    @JsonProperty("txtChoteiJiyuKari13")
    public TextBox getTxtChoteiJiyuKari13() {
        return txtChoteiJiyuKari13;
    }

    @JsonProperty("txtChoteiJiyuKari13")
    public void setTxtChoteiJiyuKari13(TextBox txtChoteiJiyuKari13) {
        this.txtChoteiJiyuKari13=txtChoteiJiyuKari13;
    }

}
/**
 * celChoteiJiyu15 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu15AttblChoteiJiyuKari1 extends TableCell {
    @JsonProperty("txtChoteiJiyuKari14")
    private TextBox txtChoteiJiyuKari14;

    @JsonProperty("txtChoteiJiyuKari14")
    public TextBox getTxtChoteiJiyuKari14() {
        return txtChoteiJiyuKari14;
    }

    @JsonProperty("txtChoteiJiyuKari14")
    public void setTxtChoteiJiyuKari14(TextBox txtChoteiJiyuKari14) {
        this.txtChoteiJiyuKari14=txtChoteiJiyuKari14;
    }

}
