package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgChosainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dgIraisakiIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TableCell;
import jp.co.ndensan.reams.uz.uza.ui.binding.TablePanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TPIraisaki のクラスファイル 
 * 
 * @author 自動生成
 */
public class TPIraisakiDiv extends TablePanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TCeIraisaki")
    private TCeIraisakiAtTPIraisaki TCeIraisaki;
    @JsonProperty("TCChosain")
    private TCChosainAtTPIraisaki TCChosain;

    /*
     * [ Helperの作成 ]
     * TablePanelコントロールに特化したヘルパーメソッドを作成
     */
    @JsonIgnore
    public Button getBtTouroku() {
        return this.TCeIraisaki.getBtTouroku();
    }

    @JsonIgnore
    public DataGrid<dgIraisakiIchiran_Row> getDgIraisakiIchiran() {
        return this.TCeIraisaki.getDgIraisakiIchiran();
    }

    @JsonIgnore
    public Label getLbBrank() {
        return this.TCChosain.getLbBrank();
    }

    @JsonIgnore
    public DataGrid<dgChosainIchiran_Row> getDgChosainIchiran() {
        return this.TCChosain.getDgChosainIchiran();
    }

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("TCeIraisaki")
    private TCeIraisakiAtTPIraisaki getTCeIraisaki() {
        return TCeIraisaki;
    }

    @JsonProperty("TCeIraisaki")
    private void setTCeIraisaki(TCeIraisakiAtTPIraisaki TCeIraisaki) {
        this.TCeIraisaki=TCeIraisaki;
    }

    @JsonProperty("TCChosain")
    private TCChosainAtTPIraisaki getTCChosain() {
        return TCChosain;
    }

    @JsonProperty("TCChosain")
    private void setTCChosain(TCChosainAtTPIraisaki TCChosain) {
        this.TCChosain=TCChosain;
    }

}
/**
 * TCeIraisaki のクラスファイル 
 * 
 * @author 自動生成
 */
class TCeIraisakiAtTPIraisaki extends TableCell {
    @JsonProperty("btTouroku")
    private Button btTouroku;
    @JsonProperty("dgIraisakiIchiran")
    private DataGrid<dgIraisakiIchiran_Row> dgIraisakiIchiran;

    @JsonProperty("btTouroku")
    public Button getBtTouroku() {
        return btTouroku;
    }

    @JsonProperty("btTouroku")
    public void setBtTouroku(Button btTouroku) {
        this.btTouroku=btTouroku;
    }

    @JsonProperty("dgIraisakiIchiran")
    public DataGrid<dgIraisakiIchiran_Row> getDgIraisakiIchiran() {
        return dgIraisakiIchiran;
    }

    @JsonProperty("dgIraisakiIchiran")
    public void setDgIraisakiIchiran(DataGrid<dgIraisakiIchiran_Row> dgIraisakiIchiran) {
        this.dgIraisakiIchiran=dgIraisakiIchiran;
    }

}
/**
 * TCChosain のクラスファイル 
 * 
 * @author 自動生成
 */
class TCChosainAtTPIraisaki extends TableCell {
    @JsonProperty("lbBrank")
    private Label lbBrank;
    @JsonProperty("dgChosainIchiran")
    private DataGrid<dgChosainIchiran_Row> dgChosainIchiran;

    @JsonProperty("lbBrank")
    public Label getLbBrank() {
        return lbBrank;
    }

    @JsonProperty("lbBrank")
    public void setLbBrank(Label lbBrank) {
        this.lbBrank=lbBrank;
    }

    @JsonProperty("dgChosainIchiran")
    public DataGrid<dgChosainIchiran_Row> getDgChosainIchiran() {
        return dgChosainIchiran;
    }

    @JsonProperty("dgChosainIchiran")
    public void setDgChosainIchiran(DataGrid<dgChosainIchiran_Row> dgChosainIchiran) {
        this.dgChosainIchiran=dgChosainIchiran;
    }

}
