package jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dba.divcontroller.entity.DBA6010012.TablePanel3Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * kaiItaku1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class kaiItaku1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TablePanel3")
    private TablePanel3Div TablePanel3;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TablePanel3")
    public TablePanel3Div getTablePanel3() {
        return TablePanel3;
    }

    @JsonProperty("TablePanel3")
    public void setTablePanel3(TablePanel3Div TablePanel3) {
        this.TablePanel3=TablePanel3;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLabel6() {
        return this.getTablePanel3().getLabel6();
    }

    @JsonIgnore
    public Label getLabel7() {
        return this.getTablePanel3().getLabel7();
    }

    @JsonIgnore
    public Label getLabel8() {
        return this.getTablePanel3().getLabel8();
    }

    @JsonIgnore
    public Label getLabel9() {
        return this.getTablePanel3().getLabel9();
    }

    @JsonIgnore
    public Label getLabel10() {
        return this.getTablePanel3().getLabel10();
    }

    @JsonIgnore
    public TextBox getTextBox1() {
        return this.getTablePanel3().getTextBox1();
    }

    @JsonIgnore
    public TextBox getTextBox3() {
        return this.getTablePanel3().getTextBox3();
    }

    @JsonIgnore
    public TextBox getTextBox4() {
        return this.getTablePanel3().getTextBox4();
    }

    @JsonIgnore
    public TextBox getTextBox5() {
        return this.getTablePanel3().getTextBox5();
    }

    @JsonIgnore
    public TextBox getTextBox19() {
        return this.getTablePanel3().getTextBox19();
    }

    @JsonIgnore
    public TextBox getTextBox6() {
        return this.getTablePanel3().getTextBox6();
    }

    @JsonIgnore
    public TextBox getTextBox7() {
        return this.getTablePanel3().getTextBox7();
    }

    @JsonIgnore
    public TextBox getTextBox8() {
        return this.getTablePanel3().getTextBox8();
    }

    @JsonIgnore
    public TextBox getTextBox9() {
        return this.getTablePanel3().getTextBox9();
    }

    @JsonIgnore
    public TextBox getTextBox20() {
        return this.getTablePanel3().getTextBox20();
    }

    @JsonIgnore
    public TextBox getTextBox10() {
        return this.getTablePanel3().getTextBox10();
    }

    @JsonIgnore
    public TextBox getTextBox11() {
        return this.getTablePanel3().getTextBox11();
    }

    @JsonIgnore
    public TextBox getTextBox12() {
        return this.getTablePanel3().getTextBox12();
    }

    @JsonIgnore
    public TextBox getTextBox13() {
        return this.getTablePanel3().getTextBox13();
    }

    @JsonIgnore
    public TextBox getTextBox14() {
        return this.getTablePanel3().getTextBox14();
    }

    @JsonIgnore
    public TextBox getTextBox15() {
        return this.getTablePanel3().getTextBox15();
    }

    @JsonIgnore
    public TextBox getTextBox17() {
        return this.getTablePanel3().getTextBox17();
    }

    @JsonIgnore
    public TextBox getTextBox18() {
        return this.getTablePanel3().getTextBox18();
    }

}
