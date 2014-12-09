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
 * tblJigyosha のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblJigyoshaDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("celJigyoshaTitle")
    private celJigyoshaTitleAttblJigyosha celJigyoshaTitle;
    @JsonProperty("celTodokedeDateTitle")
    private celTodokedeDateTitleAttblJigyosha celTodokedeDateTitle;
    @JsonProperty("celTekiyoStYMD")
    private celTekiyoStYMDAttblJigyosha celTekiyoStYMD;
    @JsonProperty("celJigyosha1")
    private celJigyosha1AttblJigyosha celJigyosha1;
    @JsonProperty("celTodokedeDate1")
    private celTodokedeDate1AttblJigyosha celTodokedeDate1;
    @JsonProperty("celTekiyoStYMD1")
    private celTekiyoStYMD1AttblJigyosha celTekiyoStYMD1;
    @JsonProperty("celJigyosha2")
    private celJigyosha2AttblJigyosha celJigyosha2;
    @JsonProperty("celTodokedeDate2")
    private celTodokedeDate2AttblJigyosha celTodokedeDate2;
    @JsonProperty("celTekiyoStYMD2")
    private celTekiyoStYMD2AttblJigyosha celTekiyoStYMD2;
    @JsonProperty("celJigyosha3")
    private celJigyosha3AttblJigyosha celJigyosha3;
    @JsonProperty("celTodokedeDate3")
    private celTodokedeDate3AttblJigyosha celTodokedeDate3;
    @JsonProperty("celTekiyoStYMD3")
    private celTekiyoStYMD3AttblJigyosha celTekiyoStYMD3;

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
    public Label getLblTekiyoStYMD() {
        return this.celTekiyoStYMD.getLblTekiyoStYMD();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha1() {
        return this.celJigyosha1.getTxtJigyosha1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeYMD1() {
        return this.celTodokedeDate1.getTxtTodokedeYMD1();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStYMD1() {
        return this.celTekiyoStYMD1.getTxtTekiyoStYMD1();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha2() {
        return this.celJigyosha2.getTxtJigyosha2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeYMD2() {
        return this.celTodokedeDate2.getTxtTodokedeYMD2();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStYMD2() {
        return this.celTekiyoStYMD2.getTxtTekiyoStYMD2();
    }

    @JsonIgnore
    public TextBox getTxtJigyosha3() {
        return this.celJigyosha3.getTxtJigyosha3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTodokedeYMD3() {
        return this.celTodokedeDate3.getTxtTodokedeYMD3();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoStYMD3() {
        return this.celTekiyoStYMD3.getTxtTekiyoStYMD3();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("celJigyoshaTitle")
    private celJigyoshaTitleAttblJigyosha getCelJigyoshaTitle() {
        return celJigyoshaTitle;
    }

    @JsonProperty("celJigyoshaTitle")
    private void setCelJigyoshaTitle(celJigyoshaTitleAttblJigyosha celJigyoshaTitle) {
        this.celJigyoshaTitle=celJigyoshaTitle;
    }

    @JsonProperty("celTodokedeDateTitle")
    private celTodokedeDateTitleAttblJigyosha getCelTodokedeDateTitle() {
        return celTodokedeDateTitle;
    }

    @JsonProperty("celTodokedeDateTitle")
    private void setCelTodokedeDateTitle(celTodokedeDateTitleAttblJigyosha celTodokedeDateTitle) {
        this.celTodokedeDateTitle=celTodokedeDateTitle;
    }

    @JsonProperty("celTekiyoStYMD")
    private celTekiyoStYMDAttblJigyosha getCelTekiyoStYMD() {
        return celTekiyoStYMD;
    }

    @JsonProperty("celTekiyoStYMD")
    private void setCelTekiyoStYMD(celTekiyoStYMDAttblJigyosha celTekiyoStYMD) {
        this.celTekiyoStYMD=celTekiyoStYMD;
    }

    @JsonProperty("celJigyosha1")
    private celJigyosha1AttblJigyosha getCelJigyosha1() {
        return celJigyosha1;
    }

    @JsonProperty("celJigyosha1")
    private void setCelJigyosha1(celJigyosha1AttblJigyosha celJigyosha1) {
        this.celJigyosha1=celJigyosha1;
    }

    @JsonProperty("celTodokedeDate1")
    private celTodokedeDate1AttblJigyosha getCelTodokedeDate1() {
        return celTodokedeDate1;
    }

    @JsonProperty("celTodokedeDate1")
    private void setCelTodokedeDate1(celTodokedeDate1AttblJigyosha celTodokedeDate1) {
        this.celTodokedeDate1=celTodokedeDate1;
    }

    @JsonProperty("celTekiyoStYMD1")
    private celTekiyoStYMD1AttblJigyosha getCelTekiyoStYMD1() {
        return celTekiyoStYMD1;
    }

    @JsonProperty("celTekiyoStYMD1")
    private void setCelTekiyoStYMD1(celTekiyoStYMD1AttblJigyosha celTekiyoStYMD1) {
        this.celTekiyoStYMD1=celTekiyoStYMD1;
    }

    @JsonProperty("celJigyosha2")
    private celJigyosha2AttblJigyosha getCelJigyosha2() {
        return celJigyosha2;
    }

    @JsonProperty("celJigyosha2")
    private void setCelJigyosha2(celJigyosha2AttblJigyosha celJigyosha2) {
        this.celJigyosha2=celJigyosha2;
    }

    @JsonProperty("celTodokedeDate2")
    private celTodokedeDate2AttblJigyosha getCelTodokedeDate2() {
        return celTodokedeDate2;
    }

    @JsonProperty("celTodokedeDate2")
    private void setCelTodokedeDate2(celTodokedeDate2AttblJigyosha celTodokedeDate2) {
        this.celTodokedeDate2=celTodokedeDate2;
    }

    @JsonProperty("celTekiyoStYMD2")
    private celTekiyoStYMD2AttblJigyosha getCelTekiyoStYMD2() {
        return celTekiyoStYMD2;
    }

    @JsonProperty("celTekiyoStYMD2")
    private void setCelTekiyoStYMD2(celTekiyoStYMD2AttblJigyosha celTekiyoStYMD2) {
        this.celTekiyoStYMD2=celTekiyoStYMD2;
    }

    @JsonProperty("celJigyosha3")
    private celJigyosha3AttblJigyosha getCelJigyosha3() {
        return celJigyosha3;
    }

    @JsonProperty("celJigyosha3")
    private void setCelJigyosha3(celJigyosha3AttblJigyosha celJigyosha3) {
        this.celJigyosha3=celJigyosha3;
    }

    @JsonProperty("celTodokedeDate3")
    private celTodokedeDate3AttblJigyosha getCelTodokedeDate3() {
        return celTodokedeDate3;
    }

    @JsonProperty("celTodokedeDate3")
    private void setCelTodokedeDate3(celTodokedeDate3AttblJigyosha celTodokedeDate3) {
        this.celTodokedeDate3=celTodokedeDate3;
    }

    @JsonProperty("celTekiyoStYMD3")
    private celTekiyoStYMD3AttblJigyosha getCelTekiyoStYMD3() {
        return celTekiyoStYMD3;
    }

    @JsonProperty("celTekiyoStYMD3")
    private void setCelTekiyoStYMD3(celTekiyoStYMD3AttblJigyosha celTekiyoStYMD3) {
        this.celTekiyoStYMD3=celTekiyoStYMD3;
    }

}
/**
 * celJigyoshaTitle のクラスファイル 
 * 
 * @author 自動生成
 */
class celJigyoshaTitleAttblJigyosha extends TableCell {
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
class celTodokedeDateTitleAttblJigyosha extends TableCell {
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
 * celTekiyoStYMD のクラスファイル 
 * 
 * @author 自動生成
 */
class celTekiyoStYMDAttblJigyosha extends TableCell {
    @JsonProperty("lblTekiyoStYMD")
    private Label lblTekiyoStYMD;

    @JsonProperty("lblTekiyoStYMD")
    public Label getLblTekiyoStYMD() {
        return lblTekiyoStYMD;
    }

    @JsonProperty("lblTekiyoStYMD")
    public void setLblTekiyoStYMD(Label lblTekiyoStYMD) {
        this.lblTekiyoStYMD=lblTekiyoStYMD;
    }

}
/**
 * celJigyosha1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJigyosha1AttblJigyosha extends TableCell {
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
class celTodokedeDate1AttblJigyosha extends TableCell {
    @JsonProperty("txtTodokedeYMD1")
    private TextBoxFlexibleDate txtTodokedeYMD1;

    @JsonProperty("txtTodokedeYMD1")
    public TextBoxFlexibleDate getTxtTodokedeYMD1() {
        return txtTodokedeYMD1;
    }

    @JsonProperty("txtTodokedeYMD1")
    public void setTxtTodokedeYMD1(TextBoxFlexibleDate txtTodokedeYMD1) {
        this.txtTodokedeYMD1=txtTodokedeYMD1;
    }

}
/**
 * celTekiyoStYMD1 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTekiyoStYMD1AttblJigyosha extends TableCell {
    @JsonProperty("txtTekiyoStYMD1")
    private TextBoxFlexibleDate txtTekiyoStYMD1;

    @JsonProperty("txtTekiyoStYMD1")
    public TextBoxFlexibleDate getTxtTekiyoStYMD1() {
        return txtTekiyoStYMD1;
    }

    @JsonProperty("txtTekiyoStYMD1")
    public void setTxtTekiyoStYMD1(TextBoxFlexibleDate txtTekiyoStYMD1) {
        this.txtTekiyoStYMD1=txtTekiyoStYMD1;
    }

}
/**
 * celJigyosha2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJigyosha2AttblJigyosha extends TableCell {
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
class celTodokedeDate2AttblJigyosha extends TableCell {
    @JsonProperty("txtTodokedeYMD2")
    private TextBoxFlexibleDate txtTodokedeYMD2;

    @JsonProperty("txtTodokedeYMD2")
    public TextBoxFlexibleDate getTxtTodokedeYMD2() {
        return txtTodokedeYMD2;
    }

    @JsonProperty("txtTodokedeYMD2")
    public void setTxtTodokedeYMD2(TextBoxFlexibleDate txtTodokedeYMD2) {
        this.txtTodokedeYMD2=txtTodokedeYMD2;
    }

}
/**
 * celTekiyoStYMD2 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTekiyoStYMD2AttblJigyosha extends TableCell {
    @JsonProperty("txtTekiyoStYMD2")
    private TextBoxFlexibleDate txtTekiyoStYMD2;

    @JsonProperty("txtTekiyoStYMD2")
    public TextBoxFlexibleDate getTxtTekiyoStYMD2() {
        return txtTekiyoStYMD2;
    }

    @JsonProperty("txtTekiyoStYMD2")
    public void setTxtTekiyoStYMD2(TextBoxFlexibleDate txtTekiyoStYMD2) {
        this.txtTekiyoStYMD2=txtTekiyoStYMD2;
    }

}
/**
 * celJigyosha3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celJigyosha3AttblJigyosha extends TableCell {
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
class celTodokedeDate3AttblJigyosha extends TableCell {
    @JsonProperty("txtTodokedeYMD3")
    private TextBoxFlexibleDate txtTodokedeYMD3;

    @JsonProperty("txtTodokedeYMD3")
    public TextBoxFlexibleDate getTxtTodokedeYMD3() {
        return txtTodokedeYMD3;
    }

    @JsonProperty("txtTodokedeYMD3")
    public void setTxtTodokedeYMD3(TextBoxFlexibleDate txtTodokedeYMD3) {
        this.txtTodokedeYMD3=txtTodokedeYMD3;
    }

}
/**
 * celTekiyoStYMD3 のクラスファイル 
 * 
 * @author 自動生成
 */
class celTekiyoStYMD3AttblJigyosha extends TableCell {
    @JsonProperty("txtTekiyoStYMD3")
    private TextBoxFlexibleDate txtTekiyoStYMD3;

    @JsonProperty("txtTekiyoStYMD3")
    public TextBoxFlexibleDate getTxtTekiyoStYMD3() {
        return txtTekiyoStYMD3;
    }

    @JsonProperty("txtTekiyoStYMD3")
    public void setTxtTekiyoStYMD3(TextBoxFlexibleDate txtTekiyoStYMD3) {
        this.txtTekiyoStYMD3=txtTekiyoStYMD3;
    }

}
