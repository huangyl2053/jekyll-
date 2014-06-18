package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320003;
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
 * tblChoteiJiyu2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblChoteiJiyu2Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celChoteiJiyu21")
    private celChoteiJiyu21AttblChoteiJiyu2 celChoteiJiyu21;
    @JsonProperty("celChoteiJiyu22")
    private celChoteiJiyu22AttblChoteiJiyu2 celChoteiJiyu22;
    @JsonProperty("celChoteiJiyu23")
    private celChoteiJiyu23AttblChoteiJiyu2 celChoteiJiyu23;
    @JsonProperty("celChoteiJiyu24")
    private celChoteiJiyu24AttblChoteiJiyu2 celChoteiJiyu24;
    @JsonProperty("celChoteiJiyu25")
    private celChoteiJiyu25AttblChoteiJiyu2 celChoteiJiyu25;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblChoteiJiyu2() {
        return this.celChoteiJiyu21.getLblChoteiJiyu2();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu21() {
        return this.celChoteiJiyu22.getTxtChoteiJiyu21();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu22() {
        return this.celChoteiJiyu23.getTxtChoteiJiyu22();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu23() {
        return this.celChoteiJiyu24.getTxtChoteiJiyu23();
    }

    @JsonIgnore
    public TextBox getTxtChoteiJiyu24() {
        return this.celChoteiJiyu25.getTxtChoteiJiyu24();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celChoteiJiyu21")
    private celChoteiJiyu21AttblChoteiJiyu2 getCelChoteiJiyu21() {
        return celChoteiJiyu21;
    }

    @JsonProperty("celChoteiJiyu21")
    private void setCelChoteiJiyu21(celChoteiJiyu21AttblChoteiJiyu2 celChoteiJiyu21) {
        this.celChoteiJiyu21=celChoteiJiyu21;
    }

    @JsonProperty("celChoteiJiyu22")
    private celChoteiJiyu22AttblChoteiJiyu2 getCelChoteiJiyu22() {
        return celChoteiJiyu22;
    }

    @JsonProperty("celChoteiJiyu22")
    private void setCelChoteiJiyu22(celChoteiJiyu22AttblChoteiJiyu2 celChoteiJiyu22) {
        this.celChoteiJiyu22=celChoteiJiyu22;
    }

    @JsonProperty("celChoteiJiyu23")
    private celChoteiJiyu23AttblChoteiJiyu2 getCelChoteiJiyu23() {
        return celChoteiJiyu23;
    }

    @JsonProperty("celChoteiJiyu23")
    private void setCelChoteiJiyu23(celChoteiJiyu23AttblChoteiJiyu2 celChoteiJiyu23) {
        this.celChoteiJiyu23=celChoteiJiyu23;
    }

    @JsonProperty("celChoteiJiyu24")
    private celChoteiJiyu24AttblChoteiJiyu2 getCelChoteiJiyu24() {
        return celChoteiJiyu24;
    }

    @JsonProperty("celChoteiJiyu24")
    private void setCelChoteiJiyu24(celChoteiJiyu24AttblChoteiJiyu2 celChoteiJiyu24) {
        this.celChoteiJiyu24=celChoteiJiyu24;
    }

    @JsonProperty("celChoteiJiyu25")
    private celChoteiJiyu25AttblChoteiJiyu2 getCelChoteiJiyu25() {
        return celChoteiJiyu25;
    }

    @JsonProperty("celChoteiJiyu25")
    private void setCelChoteiJiyu25(celChoteiJiyu25AttblChoteiJiyu2 celChoteiJiyu25) {
        this.celChoteiJiyu25=celChoteiJiyu25;
    }

}
/**
 * celChoteiJiyu21 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu21AttblChoteiJiyu2 extends TableCell {
    @JsonProperty("lblChoteiJiyu2")
    private Label lblChoteiJiyu2;

    @JsonProperty("lblChoteiJiyu2")
    public Label getLblChoteiJiyu2() {
        return lblChoteiJiyu2;
    }

    @JsonProperty("lblChoteiJiyu2")
    public void setLblChoteiJiyu2(Label lblChoteiJiyu2) {
        this.lblChoteiJiyu2=lblChoteiJiyu2;
    }

}
/**
 * celChoteiJiyu22 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu22AttblChoteiJiyu2 extends TableCell {
    @JsonProperty("txtChoteiJiyu21")
    private TextBox txtChoteiJiyu21;

    @JsonProperty("txtChoteiJiyu21")
    public TextBox getTxtChoteiJiyu21() {
        return txtChoteiJiyu21;
    }

    @JsonProperty("txtChoteiJiyu21")
    public void setTxtChoteiJiyu21(TextBox txtChoteiJiyu21) {
        this.txtChoteiJiyu21=txtChoteiJiyu21;
    }

}
/**
 * celChoteiJiyu23 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu23AttblChoteiJiyu2 extends TableCell {
    @JsonProperty("txtChoteiJiyu22")
    private TextBox txtChoteiJiyu22;

    @JsonProperty("txtChoteiJiyu22")
    public TextBox getTxtChoteiJiyu22() {
        return txtChoteiJiyu22;
    }

    @JsonProperty("txtChoteiJiyu22")
    public void setTxtChoteiJiyu22(TextBox txtChoteiJiyu22) {
        this.txtChoteiJiyu22=txtChoteiJiyu22;
    }

}
/**
 * celChoteiJiyu24 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu24AttblChoteiJiyu2 extends TableCell {
    @JsonProperty("txtChoteiJiyu23")
    private TextBox txtChoteiJiyu23;

    @JsonProperty("txtChoteiJiyu23")
    public TextBox getTxtChoteiJiyu23() {
        return txtChoteiJiyu23;
    }

    @JsonProperty("txtChoteiJiyu23")
    public void setTxtChoteiJiyu23(TextBox txtChoteiJiyu23) {
        this.txtChoteiJiyu23=txtChoteiJiyu23;
    }

}
/**
 * celChoteiJiyu25 のクラスファイル 
 * 
 * @author 自動生成
 */
class celChoteiJiyu25AttblChoteiJiyu2 extends TableCell {
    @JsonProperty("txtChoteiJiyu24")
    private TextBox txtChoteiJiyu24;

    @JsonProperty("txtChoteiJiyu24")
    public TextBox getTxtChoteiJiyu24() {
        return txtChoteiJiyu24;
    }

    @JsonProperty("txtChoteiJiyu24")
    public void setTxtChoteiJiyu24(TextBox txtChoteiJiyu24) {
        this.txtChoteiJiyu24=txtChoteiJiyu24;
    }

}
