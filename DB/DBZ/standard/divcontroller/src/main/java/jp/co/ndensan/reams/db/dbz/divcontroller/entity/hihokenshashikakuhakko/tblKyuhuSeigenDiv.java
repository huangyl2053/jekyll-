package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshashikakuhakko;
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
 * tblKyuhuSeigen のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKyuhuSeigenDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celKyufuSeigenNaiyoTitle")
    private celKyufuSeigenNaiyoTitleAttblKyuhuSeigen celKyufuSeigenNaiyoTitle;
    @JsonProperty("celKyufuSeigenKikanTitle")
    private celKyufuSeigenKikanTitleAttblKyuhuSeigen celKyufuSeigenKikanTitle;
    @JsonProperty("celKyufuSeigenNaiyo1")
    private celKyufuSeigenNaiyo1AttblKyuhuSeigen celKyufuSeigenNaiyo1;
    @JsonProperty("celKyufuSeigenKikan1")
    private celKyufuSeigenKikan1AttblKyuhuSeigen celKyufuSeigenKikan1;
    @JsonProperty("celKyufuSeigenNaiyo2")
    private celKyufuSeigenNaiyo2AttblKyuhuSeigen celKyufuSeigenNaiyo2;
    @JsonProperty("celKyufuSeigenKikan2")
    private celKyufuSeigenKikan2AttblKyuhuSeigen celKyufuSeigenKikan2;
    @JsonProperty("celKyufuSeigenNaiyo3")
    private celKyufuSeigenNaiyo3AttblKyuhuSeigen celKyufuSeigenNaiyo3;
    @JsonProperty("celKyufuSeigenKikan3")
    private celKyufuSeigenKikan3AttblKyuhuSeigen celKyufuSeigenKikan3;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblKyufuSeigenNaiyo() {
        return this.celKyufuSeigenNaiyoTitle.getLblKyufuSeigenNaiyo();
    }

    @JsonIgnore
    public Label getLblKyufuSeigenKikan() {
        return this.celKyufuSeigenKikanTitle.getLblKyufuSeigenKikan();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo1() {
        return this.celKyufuSeigenNaiyo1.getTxtKyufuSeigenNaiyo1();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan1() {
        return this.celKyufuSeigenKikan1.getTxtKyufuSeigenKikan1();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo2() {
        return this.celKyufuSeigenNaiyo2.getTxtKyufuSeigenNaiyo2();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan2() {
        return this.celKyufuSeigenKikan2.getTxtKyufuSeigenKikan2();
    }

    @JsonIgnore
    public TextBox getTxtKyufuSeigenNaiyo3() {
        return this.celKyufuSeigenNaiyo3.getTxtKyufuSeigenNaiyo3();
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKyufuSeigenKikan3() {
        return this.celKyufuSeigenKikan3.getTxtKyufuSeigenKikan3();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celKyufuSeigenNaiyoTitle")
    private celKyufuSeigenNaiyoTitleAttblKyuhuSeigen getCelKyufuSeigenNaiyoTitle() {
        return celKyufuSeigenNaiyoTitle;
    }

    @JsonProperty("celKyufuSeigenNaiyoTitle")
    private void setCelKyufuSeigenNaiyoTitle(celKyufuSeigenNaiyoTitleAttblKyuhuSeigen celKyufuSeigenNaiyoTitle) {
        this.celKyufuSeigenNaiyoTitle=celKyufuSeigenNaiyoTitle;
    }

    @JsonProperty("celKyufuSeigenKikanTitle")
    private celKyufuSeigenKikanTitleAttblKyuhuSeigen getCelKyufuSeigenKikanTitle() {
        return celKyufuSeigenKikanTitle;
    }

    @JsonProperty("celKyufuSeigenKikanTitle")
    private void setCelKyufuSeigenKikanTitle(celKyufuSeigenKikanTitleAttblKyuhuSeigen celKyufuSeigenKikanTitle) {
        this.celKyufuSeigenKikanTitle=celKyufuSeigenKikanTitle;
    }

    @JsonProperty("celKyufuSeigenNaiyo1")
    private celKyufuSeigenNaiyo1AttblKyuhuSeigen getCelKyufuSeigenNaiyo1() {
        return celKyufuSeigenNaiyo1;
    }

    @JsonProperty("celKyufuSeigenNaiyo1")
    private void setCelKyufuSeigenNaiyo1(celKyufuSeigenNaiyo1AttblKyuhuSeigen celKyufuSeigenNaiyo1) {
        this.celKyufuSeigenNaiyo1=celKyufuSeigenNaiyo1;
    }

    @JsonProperty("celKyufuSeigenKikan1")
    private celKyufuSeigenKikan1AttblKyuhuSeigen getCelKyufuSeigenKikan1() {
        return celKyufuSeigenKikan1;
    }

    @JsonProperty("celKyufuSeigenKikan1")
    private void setCelKyufuSeigenKikan1(celKyufuSeigenKikan1AttblKyuhuSeigen celKyufuSeigenKikan1) {
        this.celKyufuSeigenKikan1=celKyufuSeigenKikan1;
    }

    @JsonProperty("celKyufuSeigenNaiyo2")
    private celKyufuSeigenNaiyo2AttblKyuhuSeigen getCelKyufuSeigenNaiyo2() {
        return celKyufuSeigenNaiyo2;
    }

    @JsonProperty("celKyufuSeigenNaiyo2")
    private void setCelKyufuSeigenNaiyo2(celKyufuSeigenNaiyo2AttblKyuhuSeigen celKyufuSeigenNaiyo2) {
        this.celKyufuSeigenNaiyo2=celKyufuSeigenNaiyo2;
    }

    @JsonProperty("celKyufuSeigenKikan2")
    private celKyufuSeigenKikan2AttblKyuhuSeigen getCelKyufuSeigenKikan2() {
        return celKyufuSeigenKikan2;
    }

    @JsonProperty("celKyufuSeigenKikan2")
    private void setCelKyufuSeigenKikan2(celKyufuSeigenKikan2AttblKyuhuSeigen celKyufuSeigenKikan2) {
        this.celKyufuSeigenKikan2=celKyufuSeigenKikan2;
    }

    @JsonProperty("celKyufuSeigenNaiyo3")
    private celKyufuSeigenNaiyo3AttblKyuhuSeigen getCelKyufuSeigenNaiyo3() {
        return celKyufuSeigenNaiyo3;
    }

    @JsonProperty("celKyufuSeigenNaiyo3")
    private void setCelKyufuSeigenNaiyo3(celKyufuSeigenNaiyo3AttblKyuhuSeigen celKyufuSeigenNaiyo3) {
        this.celKyufuSeigenNaiyo3=celKyufuSeigenNaiyo3;
    }

    @JsonProperty("celKyufuSeigenKikan3")
    private celKyufuSeigenKikan3AttblKyuhuSeigen getCelKyufuSeigenKikan3() {
        return celKyufuSeigenKikan3;
    }

    @JsonProperty("celKyufuSeigenKikan3")
    private void setCelKyufuSeigenKikan3(celKyufuSeigenKikan3AttblKyuhuSeigen celKyufuSeigenKikan3) {
        this.celKyufuSeigenKikan3=celKyufuSeigenKikan3;
    }

}
/**
 * celKyufuSeigenNaiyoTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufuSeigenNaiyoTitleAttblKyuhuSeigen extends TableCell {
    @JsonProperty("lblKyufuSeigenNaiyo")
    private Label lblKyufuSeigenNaiyo;

    @JsonProperty("lblKyufuSeigenNaiyo")
    public Label getLblKyufuSeigenNaiyo() {
        return lblKyufuSeigenNaiyo;
    }

    @JsonProperty("lblKyufuSeigenNaiyo")
    public void setLblKyufuSeigenNaiyo(Label lblKyufuSeigenNaiyo) {
        this.lblKyufuSeigenNaiyo=lblKyufuSeigenNaiyo;
    }

}
/**
 * celKyufuSeigenKikanTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufuSeigenKikanTitleAttblKyuhuSeigen extends TableCell {
    @JsonProperty("lblKyufuSeigenKikan")
    private Label lblKyufuSeigenKikan;

    @JsonProperty("lblKyufuSeigenKikan")
    public Label getLblKyufuSeigenKikan() {
        return lblKyufuSeigenKikan;
    }

    @JsonProperty("lblKyufuSeigenKikan")
    public void setLblKyufuSeigenKikan(Label lblKyufuSeigenKikan) {
        this.lblKyufuSeigenKikan=lblKyufuSeigenKikan;
    }

}
/**
 * celKyufuSeigenNaiyo1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufuSeigenNaiyo1AttblKyuhuSeigen extends TableCell {
    @JsonProperty("txtKyufuSeigenNaiyo1")
    private TextBox txtKyufuSeigenNaiyo1;

    @JsonProperty("txtKyufuSeigenNaiyo1")
    public TextBox getTxtKyufuSeigenNaiyo1() {
        return txtKyufuSeigenNaiyo1;
    }

    @JsonProperty("txtKyufuSeigenNaiyo1")
    public void setTxtKyufuSeigenNaiyo1(TextBox txtKyufuSeigenNaiyo1) {
        this.txtKyufuSeigenNaiyo1=txtKyufuSeigenNaiyo1;
    }

}
/**
 * celKyufuSeigenKikan1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufuSeigenKikan1AttblKyuhuSeigen extends TableCell {
    @JsonProperty("txtKyufuSeigenKikan1")
    private TextBoxDateRange txtKyufuSeigenKikan1;

    @JsonProperty("txtKyufuSeigenKikan1")
    public TextBoxDateRange getTxtKyufuSeigenKikan1() {
        return txtKyufuSeigenKikan1;
    }

    @JsonProperty("txtKyufuSeigenKikan1")
    public void setTxtKyufuSeigenKikan1(TextBoxDateRange txtKyufuSeigenKikan1) {
        this.txtKyufuSeigenKikan1=txtKyufuSeigenKikan1;
    }

}
/**
 * celKyufuSeigenNaiyo2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufuSeigenNaiyo2AttblKyuhuSeigen extends TableCell {
    @JsonProperty("txtKyufuSeigenNaiyo2")
    private TextBox txtKyufuSeigenNaiyo2;

    @JsonProperty("txtKyufuSeigenNaiyo2")
    public TextBox getTxtKyufuSeigenNaiyo2() {
        return txtKyufuSeigenNaiyo2;
    }

    @JsonProperty("txtKyufuSeigenNaiyo2")
    public void setTxtKyufuSeigenNaiyo2(TextBox txtKyufuSeigenNaiyo2) {
        this.txtKyufuSeigenNaiyo2=txtKyufuSeigenNaiyo2;
    }

}
/**
 * celKyufuSeigenKikan2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufuSeigenKikan2AttblKyuhuSeigen extends TableCell {
    @JsonProperty("txtKyufuSeigenKikan2")
    private TextBoxDateRange txtKyufuSeigenKikan2;

    @JsonProperty("txtKyufuSeigenKikan2")
    public TextBoxDateRange getTxtKyufuSeigenKikan2() {
        return txtKyufuSeigenKikan2;
    }

    @JsonProperty("txtKyufuSeigenKikan2")
    public void setTxtKyufuSeigenKikan2(TextBoxDateRange txtKyufuSeigenKikan2) {
        this.txtKyufuSeigenKikan2=txtKyufuSeigenKikan2;
    }

}
/**
 * celKyufuSeigenNaiyo3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufuSeigenNaiyo3AttblKyuhuSeigen extends TableCell {
    @JsonProperty("txtKyufuSeigenNaiyo3")
    private TextBox txtKyufuSeigenNaiyo3;

    @JsonProperty("txtKyufuSeigenNaiyo3")
    public TextBox getTxtKyufuSeigenNaiyo3() {
        return txtKyufuSeigenNaiyo3;
    }

    @JsonProperty("txtKyufuSeigenNaiyo3")
    public void setTxtKyufuSeigenNaiyo3(TextBox txtKyufuSeigenNaiyo3) {
        this.txtKyufuSeigenNaiyo3=txtKyufuSeigenNaiyo3;
    }

}
/**
 * celKyufuSeigenKikan3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celKyufuSeigenKikan3AttblKyuhuSeigen extends TableCell {
    @JsonProperty("txtKyufuSeigenKikan3")
    private TextBoxDateRange txtKyufuSeigenKikan3;

    @JsonProperty("txtKyufuSeigenKikan3")
    public TextBoxDateRange getTxtKyufuSeigenKikan3() {
        return txtKyufuSeigenKikan3;
    }

    @JsonProperty("txtKyufuSeigenKikan3")
    public void setTxtKyufuSeigenKikan3(TextBoxDateRange txtKyufuSeigenKikan3) {
        this.txtKyufuSeigenKikan3=txtKyufuSeigenKikan3;
    }

}
