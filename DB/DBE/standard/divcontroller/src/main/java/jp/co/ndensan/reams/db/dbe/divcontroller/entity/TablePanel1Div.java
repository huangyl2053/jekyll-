package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
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
    @JsonProperty("TableCell1")
    private TableCell1AtTablePanel1 TableCell1;
    @JsonProperty("TableCell2")
    private TableCell2AtTablePanel1 TableCell2;
    @JsonProperty("TableCell3")
    private TableCell3AtTablePanel1 TableCell3;
    @JsonProperty("TableCell4")
    private TableCell4AtTablePanel1 TableCell4;
    @JsonProperty("TableCell5")
    private TableCell5AtTablePanel1 TableCell5;
    @JsonProperty("TableCell6")
    private TableCell6AtTablePanel1 TableCell6;
    @JsonProperty("TableCell7")
    private TableCell7AtTablePanel1 TableCell7;
    @JsonProperty("TableCell8")
    private TableCell8AtTablePanel1 TableCell8;
    @JsonProperty("TableCell9")
    private TableCell9AtTablePanel1 TableCell9;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblTokkiTitle01() {
        return this.TableCell1.getLblTokkiTitle01();
    }

    @JsonIgnore
    public Label getLblTokkiTitle02() {
        return this.TableCell2.getLblTokkiTitle02();
    }

    @JsonIgnore
    public Label getLblTokkiTitle03() {
        return this.TableCell3.getLblTokkiTitle03();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokkiJiko01() {
        return this.TableCell4.getTxtTokkiJiko01();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokkiJiko02() {
        return this.TableCell5.getTxtTokkiJiko02();
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtTokkiJiko03() {
        return this.TableCell6.getTxtTokkiJiko03();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TableCell1")
    private TableCell1AtTablePanel1 getTableCell1() {
        return TableCell1;
    }

    @JsonProperty("TableCell1")
    private void setTableCell1(TableCell1AtTablePanel1 TableCell1) {
        this.TableCell1=TableCell1;
    }

    @JsonProperty("TableCell2")
    private TableCell2AtTablePanel1 getTableCell2() {
        return TableCell2;
    }

    @JsonProperty("TableCell2")
    private void setTableCell2(TableCell2AtTablePanel1 TableCell2) {
        this.TableCell2=TableCell2;
    }

    @JsonProperty("TableCell3")
    private TableCell3AtTablePanel1 getTableCell3() {
        return TableCell3;
    }

    @JsonProperty("TableCell3")
    private void setTableCell3(TableCell3AtTablePanel1 TableCell3) {
        this.TableCell3=TableCell3;
    }

    @JsonProperty("TableCell4")
    private TableCell4AtTablePanel1 getTableCell4() {
        return TableCell4;
    }

    @JsonProperty("TableCell4")
    private void setTableCell4(TableCell4AtTablePanel1 TableCell4) {
        this.TableCell4=TableCell4;
    }

    @JsonProperty("TableCell5")
    private TableCell5AtTablePanel1 getTableCell5() {
        return TableCell5;
    }

    @JsonProperty("TableCell5")
    private void setTableCell5(TableCell5AtTablePanel1 TableCell5) {
        this.TableCell5=TableCell5;
    }

    @JsonProperty("TableCell6")
    private TableCell6AtTablePanel1 getTableCell6() {
        return TableCell6;
    }

    @JsonProperty("TableCell6")
    private void setTableCell6(TableCell6AtTablePanel1 TableCell6) {
        this.TableCell6=TableCell6;
    }

    @JsonProperty("TableCell7")
    private TableCell7AtTablePanel1 getTableCell7() {
        return TableCell7;
    }

    @JsonProperty("TableCell7")
    private void setTableCell7(TableCell7AtTablePanel1 TableCell7) {
        this.TableCell7=TableCell7;
    }

    @JsonProperty("TableCell8")
    private TableCell8AtTablePanel1 getTableCell8() {
        return TableCell8;
    }

    @JsonProperty("TableCell8")
    private void setTableCell8(TableCell8AtTablePanel1 TableCell8) {
        this.TableCell8=TableCell8;
    }

    @JsonProperty("TableCell9")
    private TableCell9AtTablePanel1 getTableCell9() {
        return TableCell9;
    }

    @JsonProperty("TableCell9")
    private void setTableCell9(TableCell9AtTablePanel1 TableCell9) {
        this.TableCell9=TableCell9;
    }

}
/**
 * TableCell1 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell1AtTablePanel1 extends TableCell {
    @JsonProperty("lblTokkiTitle01")
    private Label lblTokkiTitle01;

    @JsonProperty("lblTokkiTitle01")
    public Label getLblTokkiTitle01() {
        return lblTokkiTitle01;
    }

    @JsonProperty("lblTokkiTitle01")
    public void setLblTokkiTitle01(Label lblTokkiTitle01) {
        this.lblTokkiTitle01=lblTokkiTitle01;
    }

}
/**
 * TableCell2 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell2AtTablePanel1 extends TableCell {
    @JsonProperty("lblTokkiTitle02")
    private Label lblTokkiTitle02;

    @JsonProperty("lblTokkiTitle02")
    public Label getLblTokkiTitle02() {
        return lblTokkiTitle02;
    }

    @JsonProperty("lblTokkiTitle02")
    public void setLblTokkiTitle02(Label lblTokkiTitle02) {
        this.lblTokkiTitle02=lblTokkiTitle02;
    }

}
/**
 * TableCell3 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell3AtTablePanel1 extends TableCell {
    @JsonProperty("lblTokkiTitle03")
    private Label lblTokkiTitle03;

    @JsonProperty("lblTokkiTitle03")
    public Label getLblTokkiTitle03() {
        return lblTokkiTitle03;
    }

    @JsonProperty("lblTokkiTitle03")
    public void setLblTokkiTitle03(Label lblTokkiTitle03) {
        this.lblTokkiTitle03=lblTokkiTitle03;
    }

}
/**
 * TableCell4 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell4AtTablePanel1 extends TableCell {
    @JsonProperty("txtTokkiJiko01")
    private TextBoxMultiLine txtTokkiJiko01;

    @JsonProperty("txtTokkiJiko01")
    public TextBoxMultiLine getTxtTokkiJiko01() {
        return txtTokkiJiko01;
    }

    @JsonProperty("txtTokkiJiko01")
    public void setTxtTokkiJiko01(TextBoxMultiLine txtTokkiJiko01) {
        this.txtTokkiJiko01=txtTokkiJiko01;
    }

}
/**
 * TableCell5 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell5AtTablePanel1 extends TableCell {
    @JsonProperty("txtTokkiJiko02")
    private TextBoxMultiLine txtTokkiJiko02;

    @JsonProperty("txtTokkiJiko02")
    public TextBoxMultiLine getTxtTokkiJiko02() {
        return txtTokkiJiko02;
    }

    @JsonProperty("txtTokkiJiko02")
    public void setTxtTokkiJiko02(TextBoxMultiLine txtTokkiJiko02) {
        this.txtTokkiJiko02=txtTokkiJiko02;
    }

}
/**
 * TableCell6 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell6AtTablePanel1 extends TableCell {
    @JsonProperty("txtTokkiJiko03")
    private TextBoxMultiLine txtTokkiJiko03;

    @JsonProperty("txtTokkiJiko03")
    public TextBoxMultiLine getTxtTokkiJiko03() {
        return txtTokkiJiko03;
    }

    @JsonProperty("txtTokkiJiko03")
    public void setTxtTokkiJiko03(TextBoxMultiLine txtTokkiJiko03) {
        this.txtTokkiJiko03=txtTokkiJiko03;
    }

}
/**
 * TableCell7 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell7AtTablePanel1 extends TableCell {

}
/**
 * TableCell8 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell8AtTablePanel1 extends TableCell {

}
/**
 * TableCell9 のクラスファイル 
 * 
 * @author 自動生成
 */
class TableCell9AtTablePanel1 extends TableCell {

}
