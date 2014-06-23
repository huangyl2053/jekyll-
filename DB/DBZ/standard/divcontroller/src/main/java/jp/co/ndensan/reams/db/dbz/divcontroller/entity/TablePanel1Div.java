package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
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
 * TablePanel1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class TablePanel1Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celJigyoshaTitle")
    private celJigyoshaTitleAtTablePanel1 celJigyoshaTitle;
    @JsonProperty("celTodokedeDateTitle")
    private celTodokedeDateTitleAtTablePanel1 celTodokedeDateTitle;
    @JsonProperty("celJigyosha1")
    private celJigyosha1AtTablePanel1 celJigyosha1;
    @JsonProperty("celTodokedeDate1")
    private celTodokedeDate1AtTablePanel1 celTodokedeDate1;
    @JsonProperty("celJigyosha2")
    private celJigyosha2AtTablePanel1 celJigyosha2;
    @JsonProperty("celTodokedeDate2")
    private celTodokedeDate2AtTablePanel1 celTodokedeDate2;
    @JsonProperty("celJigyosha3")
    private celJigyosha3AtTablePanel1 celJigyosha3;
    @JsonProperty("celTodokedeDate3")
    private celTodokedeDate3AtTablePanel1 celTodokedeDate3;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblJigyosha() {
        return this.celJigyoshaTitle.getLblJigyosha();
    }

    @JsonIgnore
    public Label getLblTodokedeDate() {
        return this.celTodokedeDateTitle.getLblTodokedeDate();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha1() {
        return this.celJigyosha1.getTxtJigyosha1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate1() {
        return this.celTodokedeDate1.getTxtTodokedeDate1();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha2() {
        return this.celJigyosha2.getTxtJigyosha2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate2() {
        return this.celTodokedeDate2.getTxtTodokedeDate2();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha3() {
        return this.celJigyosha3.getTxtJigyosha3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeDate3() {
        return this.celTodokedeDate3.getTxtTodokedeDate3();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celJigyoshaTitle")
    private celJigyoshaTitleAtTablePanel1 getCelJigyoshaTitle() {
        return celJigyoshaTitle;
    }

    @JsonProperty("celJigyoshaTitle")
    private void setCelJigyoshaTitle(celJigyoshaTitleAtTablePanel1 celJigyoshaTitle) {
        this.celJigyoshaTitle=celJigyoshaTitle;
    }

    @JsonProperty("celTodokedeDateTitle")
    private celTodokedeDateTitleAtTablePanel1 getCelTodokedeDateTitle() {
        return celTodokedeDateTitle;
    }

    @JsonProperty("celTodokedeDateTitle")
    private void setCelTodokedeDateTitle(celTodokedeDateTitleAtTablePanel1 celTodokedeDateTitle) {
        this.celTodokedeDateTitle=celTodokedeDateTitle;
    }

    @JsonProperty("celJigyosha1")
    private celJigyosha1AtTablePanel1 getCelJigyosha1() {
        return celJigyosha1;
    }

    @JsonProperty("celJigyosha1")
    private void setCelJigyosha1(celJigyosha1AtTablePanel1 celJigyosha1) {
        this.celJigyosha1=celJigyosha1;
    }

    @JsonProperty("celTodokedeDate1")
    private celTodokedeDate1AtTablePanel1 getCelTodokedeDate1() {
        return celTodokedeDate1;
    }

    @JsonProperty("celTodokedeDate1")
    private void setCelTodokedeDate1(celTodokedeDate1AtTablePanel1 celTodokedeDate1) {
        this.celTodokedeDate1=celTodokedeDate1;
    }

    @JsonProperty("celJigyosha2")
    private celJigyosha2AtTablePanel1 getCelJigyosha2() {
        return celJigyosha2;
    }

    @JsonProperty("celJigyosha2")
    private void setCelJigyosha2(celJigyosha2AtTablePanel1 celJigyosha2) {
        this.celJigyosha2=celJigyosha2;
    }

    @JsonProperty("celTodokedeDate2")
    private celTodokedeDate2AtTablePanel1 getCelTodokedeDate2() {
        return celTodokedeDate2;
    }

    @JsonProperty("celTodokedeDate2")
    private void setCelTodokedeDate2(celTodokedeDate2AtTablePanel1 celTodokedeDate2) {
        this.celTodokedeDate2=celTodokedeDate2;
    }

    @JsonProperty("celJigyosha3")
    private celJigyosha3AtTablePanel1 getCelJigyosha3() {
        return celJigyosha3;
    }

    @JsonProperty("celJigyosha3")
    private void setCelJigyosha3(celJigyosha3AtTablePanel1 celJigyosha3) {
        this.celJigyosha3=celJigyosha3;
    }

    @JsonProperty("celTodokedeDate3")
    private celTodokedeDate3AtTablePanel1 getCelTodokedeDate3() {
        return celTodokedeDate3;
    }

    @JsonProperty("celTodokedeDate3")
    private void setCelTodokedeDate3(celTodokedeDate3AtTablePanel1 celTodokedeDate3) {
        this.celTodokedeDate3=celTodokedeDate3;
    }

}
/**
 * celJigyoshaTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celJigyoshaTitleAtTablePanel1 extends TableCell {
    @JsonProperty("lblJigyosha")
    private Label lblJigyosha;

    @JsonProperty("lblJigyosha")
    public Label getLblJigyosha() {
        return lblJigyosha;
    }

    @JsonProperty("lblJigyosha")
    public void setLblJigyosha(Label lblJigyosha) {
        this.lblJigyosha=lblJigyosha;
    }

}
/**
 * celTodokedeDateTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celTodokedeDateTitleAtTablePanel1 extends TableCell {
    @JsonProperty("lblTodokedeDate")
    private Label lblTodokedeDate;

    @JsonProperty("lblTodokedeDate")
    public Label getLblTodokedeDate() {
        return lblTodokedeDate;
    }

    @JsonProperty("lblTodokedeDate")
    public void setLblTodokedeDate(Label lblTodokedeDate) {
        this.lblTodokedeDate=lblTodokedeDate;
    }

}
/**
 * celJigyosha1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJigyosha1AtTablePanel1 extends TableCell {
    @JsonProperty("txtJigyosha1")
    private TextBox txtJigyosha1;

    @JsonProperty("txtJigyosha1")
    public TextBox getTxtJigyosha1() {
        return txtJigyosha1;
    }

    @JsonProperty("txtJigyosha1")
    public void setTxtJigyosha1(TextBox txtJigyosha1) {
        this.txtJigyosha1=txtJigyosha1;
    }

}
/**
 * celTodokedeDate1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTodokedeDate1AtTablePanel1 extends TableCell {
    @JsonProperty("txtTodokedeDate1")
    private TextBoxFlexibleDate txtTodokedeDate1;

    @JsonProperty("txtTodokedeDate1")
    public TextBoxFlexibleDate getTxtTodokedeDate1() {
        return txtTodokedeDate1;
    }

    @JsonProperty("txtTodokedeDate1")
    public void setTxtTodokedeDate1(TextBoxFlexibleDate txtTodokedeDate1) {
        this.txtTodokedeDate1=txtTodokedeDate1;
    }

}
/**
 * celJigyosha2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJigyosha2AtTablePanel1 extends TableCell {
    @JsonProperty("txtJigyosha2")
    private TextBox txtJigyosha2;

    @JsonProperty("txtJigyosha2")
    public TextBox getTxtJigyosha2() {
        return txtJigyosha2;
    }

    @JsonProperty("txtJigyosha2")
    public void setTxtJigyosha2(TextBox txtJigyosha2) {
        this.txtJigyosha2=txtJigyosha2;
    }

}
/**
 * celTodokedeDate2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTodokedeDate2AtTablePanel1 extends TableCell {
    @JsonProperty("txtTodokedeDate2")
    private TextBoxFlexibleDate txtTodokedeDate2;

    @JsonProperty("txtTodokedeDate2")
    public TextBoxFlexibleDate getTxtTodokedeDate2() {
        return txtTodokedeDate2;
    }

    @JsonProperty("txtTodokedeDate2")
    public void setTxtTodokedeDate2(TextBoxFlexibleDate txtTodokedeDate2) {
        this.txtTodokedeDate2=txtTodokedeDate2;
    }

}
/**
 * celJigyosha3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJigyosha3AtTablePanel1 extends TableCell {
    @JsonProperty("txtJigyosha3")
    private TextBox txtJigyosha3;

    @JsonProperty("txtJigyosha3")
    public TextBox getTxtJigyosha3() {
        return txtJigyosha3;
    }

    @JsonProperty("txtJigyosha3")
    public void setTxtJigyosha3(TextBox txtJigyosha3) {
        this.txtJigyosha3=txtJigyosha3;
    }

}
/**
 * celTodokedeDate3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTodokedeDate3AtTablePanel1 extends TableCell {
    @JsonProperty("txtTodokedeDate3")
    private TextBoxFlexibleDate txtTodokedeDate3;

    @JsonProperty("txtTodokedeDate3")
    public TextBoxFlexibleDate getTxtTodokedeDate3() {
        return txtTodokedeDate3;
    }

    @JsonProperty("txtTodokedeDate3")
    public void setTxtTodokedeDate3(TextBoxFlexibleDate txtTodokedeDate3) {
        this.txtTodokedeDate3=txtTodokedeDate3;
    }

}
