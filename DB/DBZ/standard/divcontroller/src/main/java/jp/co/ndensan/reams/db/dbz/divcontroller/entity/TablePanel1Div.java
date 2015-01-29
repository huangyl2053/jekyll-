package jp.co.ndensan.reams.db.dbz.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.Chiku1InputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.IChiku1InputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;

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

    @JsonProperty("TableCell13")
    private TableCell13AtTablePanel1 TableCell13;
    @JsonProperty("TableCell14")
    private TableCell14AtTablePanel1 TableCell14;
    @JsonProperty("TableCell15")
    private TableCell15AtTablePanel1 TableCell15;
    @JsonProperty("TableCell16")
    private TableCell16AtTablePanel1 TableCell16;
    @JsonProperty("TableCell17")
    private TableCell17AtTablePanel1 TableCell17;
    @JsonProperty("TableCell18")
    private TableCell18AtTablePanel1 TableCell18;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Label getLblChiku1InputSt() {
        return this.TableCell13.getLblChiku1InputSt();
    }

    @JsonIgnore
    public Label getLblChiku1InputEd() {
        return this.TableCell15.getLblChiku1InputEd();
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1InputSt() {
        return this.TableCell16.getCcdChiku1InputSt();
    }

    @JsonIgnore
    public Label getLblKaraChiku1() {
        return this.TableCell17.getLblKaraChiku1();
    }

    @JsonIgnore
    public IChiku1InputDiv getCcdChiku1InputEd() {
        return this.TableCell18.getCcdChiku1InputEd();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TableCell13")
    private TableCell13AtTablePanel1 getTableCell13() {
        return TableCell13;
    }

    @JsonProperty("TableCell13")
    private void setTableCell13(TableCell13AtTablePanel1 TableCell13) {
        this.TableCell13 = TableCell13;
    }

    @JsonProperty("TableCell14")
    private TableCell14AtTablePanel1 getTableCell14() {
        return TableCell14;
    }

    @JsonProperty("TableCell14")
    private void setTableCell14(TableCell14AtTablePanel1 TableCell14) {
        this.TableCell14 = TableCell14;
    }

    @JsonProperty("TableCell15")
    private TableCell15AtTablePanel1 getTableCell15() {
        return TableCell15;
    }

    @JsonProperty("TableCell15")
    private void setTableCell15(TableCell15AtTablePanel1 TableCell15) {
        this.TableCell15 = TableCell15;
    }

    @JsonProperty("TableCell16")
    private TableCell16AtTablePanel1 getTableCell16() {
        return TableCell16;
    }

    @JsonProperty("TableCell16")
    private void setTableCell16(TableCell16AtTablePanel1 TableCell16) {
        this.TableCell16 = TableCell16;
    }

    @JsonProperty("TableCell17")
    private TableCell17AtTablePanel1 getTableCell17() {
        return TableCell17;
    }

    @JsonProperty("TableCell17")
    private void setTableCell17(TableCell17AtTablePanel1 TableCell17) {
        this.TableCell17 = TableCell17;
    }

    @JsonProperty("TableCell18")
    private TableCell18AtTablePanel1 getTableCell18() {
        return TableCell18;
    }

    @JsonProperty("TableCell18")
    private void setTableCell18(TableCell18AtTablePanel1 TableCell18) {
        this.TableCell18 = TableCell18;
    }

}

/**
 * TableCell13 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell13AtTablePanel1 extends TableCell {

    @JsonProperty("lblChiku1InputSt")
    private Label lblChiku1InputSt;

    @JsonProperty("lblChiku1InputSt")
    public Label getLblChiku1InputSt() {
        return lblChiku1InputSt;
    }

    @JsonProperty("lblChiku1InputSt")
    public void setLblChiku1InputSt(Label lblChiku1InputSt) {
        this.lblChiku1InputSt = lblChiku1InputSt;
    }

}

/**
 * TableCell14 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell14AtTablePanel1 extends TableCell {

}

/**
 * TableCell15 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell15AtTablePanel1 extends TableCell {

    @JsonProperty("lblChiku1InputEd")
    private Label lblChiku1InputEd;

    @JsonProperty("lblChiku1InputEd")
    public Label getLblChiku1InputEd() {
        return lblChiku1InputEd;
    }

    @JsonProperty("lblChiku1InputEd")
    public void setLblChiku1InputEd(Label lblChiku1InputEd) {
        this.lblChiku1InputEd = lblChiku1InputEd;
    }

}

/**
 * TableCell16 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell16AtTablePanel1 extends TableCell {

    @JsonProperty("ccdChiku1InputSt")
    private Chiku1InputDiv ccdChiku1InputSt;

    @JsonProperty("ccdChiku1InputSt")
    public IChiku1InputDiv getCcdChiku1InputSt() {
        return ccdChiku1InputSt;
    }

}

/**
 * TableCell17 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell17AtTablePanel1 extends TableCell {

    @JsonProperty("lblKaraChiku1")
    private Label lblKaraChiku1;

    @JsonProperty("lblKaraChiku1")
    public Label getLblKaraChiku1() {
        return lblKaraChiku1;
    }

    @JsonProperty("lblKaraChiku1")
    public void setLblKaraChiku1(Label lblKaraChiku1) {
        this.lblKaraChiku1 = lblKaraChiku1;
    }

}

/**
 * TableCell18 のクラスファイル
 *
 * @author 自動生成
 */
class TableCell18AtTablePanel1 extends TableCell {

    @JsonProperty("ccdChiku1InputEd")
    private Chiku1InputDiv ccdChiku1InputEd;

    @JsonProperty("ccdChiku1InputEd")
    public IChiku1InputDiv getCcdChiku1InputEd() {
        return ccdChiku1InputEd;
    }

}
