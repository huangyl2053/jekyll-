package jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320001;
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
 * tblKikan2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblKikan2Div extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("cellFukaShokaiData16")
    private cellFukaShokaiData16AttblKikan2 cellFukaShokaiData16;
    @JsonProperty("cellFukaShokaiData17")
    private cellFukaShokaiData17AttblKikan2 cellFukaShokaiData17;
    @JsonProperty("cellFukaShokaiData18")
    private cellFukaShokaiData18AttblKikan2 cellFukaShokaiData18;
    @JsonProperty("cellFukaShokaiData19")
    private cellFukaShokaiData19AttblKikan2 cellFukaShokaiData19;
    @JsonProperty("cellFukaShokaiData20")
    private cellFukaShokaiData20AttblKikan2 cellFukaShokaiData20;
    @JsonProperty("cellFukaShokaiData21")
    private cellFukaShokaiData21AttblKikan2 cellFukaShokaiData21;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblKikan2() {
        return this.cellFukaShokaiData16.getLblKikan2();
    }

    @JsonIgnore
    public Label getLblTsukiSu2() {
        return this.cellFukaShokaiData17.getLblTsukiSu2();
    }

    @JsonIgnore
    public Label getLblHokenryoDankai2() {
        return this.cellFukaShokaiData18.getLblHokenryoDankai2();
    }

    @JsonIgnore
    public Label getLblHokenryoritsu2() {
        return this.cellFukaShokaiData19.getLblHokenryoritsu2();
    }

    @JsonIgnore
    public Label getLblHokenryoSansyutsu2() {
        return this.cellFukaShokaiData20.getLblHokenryoSansyutsu2();
    }

    @JsonIgnore
    public Label getLblHokenryo2() {
        return this.cellFukaShokaiData21.getLblHokenryo2();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("cellFukaShokaiData16")
    private cellFukaShokaiData16AttblKikan2 getCellFukaShokaiData16() {
        return cellFukaShokaiData16;
    }

    @JsonProperty("cellFukaShokaiData16")
    private void setCellFukaShokaiData16(cellFukaShokaiData16AttblKikan2 cellFukaShokaiData16) {
        this.cellFukaShokaiData16=cellFukaShokaiData16;
    }

    @JsonProperty("cellFukaShokaiData17")
    private cellFukaShokaiData17AttblKikan2 getCellFukaShokaiData17() {
        return cellFukaShokaiData17;
    }

    @JsonProperty("cellFukaShokaiData17")
    private void setCellFukaShokaiData17(cellFukaShokaiData17AttblKikan2 cellFukaShokaiData17) {
        this.cellFukaShokaiData17=cellFukaShokaiData17;
    }

    @JsonProperty("cellFukaShokaiData18")
    private cellFukaShokaiData18AttblKikan2 getCellFukaShokaiData18() {
        return cellFukaShokaiData18;
    }

    @JsonProperty("cellFukaShokaiData18")
    private void setCellFukaShokaiData18(cellFukaShokaiData18AttblKikan2 cellFukaShokaiData18) {
        this.cellFukaShokaiData18=cellFukaShokaiData18;
    }

    @JsonProperty("cellFukaShokaiData19")
    private cellFukaShokaiData19AttblKikan2 getCellFukaShokaiData19() {
        return cellFukaShokaiData19;
    }

    @JsonProperty("cellFukaShokaiData19")
    private void setCellFukaShokaiData19(cellFukaShokaiData19AttblKikan2 cellFukaShokaiData19) {
        this.cellFukaShokaiData19=cellFukaShokaiData19;
    }

    @JsonProperty("cellFukaShokaiData20")
    private cellFukaShokaiData20AttblKikan2 getCellFukaShokaiData20() {
        return cellFukaShokaiData20;
    }

    @JsonProperty("cellFukaShokaiData20")
    private void setCellFukaShokaiData20(cellFukaShokaiData20AttblKikan2 cellFukaShokaiData20) {
        this.cellFukaShokaiData20=cellFukaShokaiData20;
    }

    @JsonProperty("cellFukaShokaiData21")
    private cellFukaShokaiData21AttblKikan2 getCellFukaShokaiData21() {
        return cellFukaShokaiData21;
    }

    @JsonProperty("cellFukaShokaiData21")
    private void setCellFukaShokaiData21(cellFukaShokaiData21AttblKikan2 cellFukaShokaiData21) {
        this.cellFukaShokaiData21=cellFukaShokaiData21;
    }

}
/**
 * cellFukaShokaiData16 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokaiData16AttblKikan2 extends TableCell {
    @JsonProperty("lblKikan2")
    private Label lblKikan2;

    @JsonProperty("lblKikan2")
    public Label getLblKikan2() {
        return lblKikan2;
    }

    @JsonProperty("lblKikan2")
    public void setLblKikan2(Label lblKikan2) {
        this.lblKikan2=lblKikan2;
    }

}
/**
 * cellFukaShokaiData17 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokaiData17AttblKikan2 extends TableCell {
    @JsonProperty("lblTsukiSu2")
    private Label lblTsukiSu2;

    @JsonProperty("lblTsukiSu2")
    public Label getLblTsukiSu2() {
        return lblTsukiSu2;
    }

    @JsonProperty("lblTsukiSu2")
    public void setLblTsukiSu2(Label lblTsukiSu2) {
        this.lblTsukiSu2=lblTsukiSu2;
    }

}
/**
 * cellFukaShokaiData18 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokaiData18AttblKikan2 extends TableCell {
    @JsonProperty("lblHokenryoDankai2")
    private Label lblHokenryoDankai2;

    @JsonProperty("lblHokenryoDankai2")
    public Label getLblHokenryoDankai2() {
        return lblHokenryoDankai2;
    }

    @JsonProperty("lblHokenryoDankai2")
    public void setLblHokenryoDankai2(Label lblHokenryoDankai2) {
        this.lblHokenryoDankai2=lblHokenryoDankai2;
    }

}
/**
 * cellFukaShokaiData19 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokaiData19AttblKikan2 extends TableCell {
    @JsonProperty("lblHokenryoritsu2")
    private Label lblHokenryoritsu2;

    @JsonProperty("lblHokenryoritsu2")
    public Label getLblHokenryoritsu2() {
        return lblHokenryoritsu2;
    }

    @JsonProperty("lblHokenryoritsu2")
    public void setLblHokenryoritsu2(Label lblHokenryoritsu2) {
        this.lblHokenryoritsu2=lblHokenryoritsu2;
    }

}
/**
 * cellFukaShokaiData20 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokaiData20AttblKikan2 extends TableCell {
    @JsonProperty("lblHokenryoSansyutsu2")
    private Label lblHokenryoSansyutsu2;

    @JsonProperty("lblHokenryoSansyutsu2")
    public Label getLblHokenryoSansyutsu2() {
        return lblHokenryoSansyutsu2;
    }

    @JsonProperty("lblHokenryoSansyutsu2")
    public void setLblHokenryoSansyutsu2(Label lblHokenryoSansyutsu2) {
        this.lblHokenryoSansyutsu2=lblHokenryoSansyutsu2;
    }

}
/**
 * cellFukaShokaiData21 のクラスファイル 
 * 
 * @author 自動生成
 */
class cellFukaShokaiData21AttblKikan2 extends TableCell {
    @JsonProperty("lblHokenryo2")
    private Label lblHokenryo2;

    @JsonProperty("lblHokenryo2")
    public Label getLblHokenryo2() {
        return lblHokenryo2;
    }

    @JsonProperty("lblHokenryo2")
    public void setLblHokenryo2(Label lblHokenryo2) {
        this.lblHokenryo2=lblHokenryo2;
    }

}
