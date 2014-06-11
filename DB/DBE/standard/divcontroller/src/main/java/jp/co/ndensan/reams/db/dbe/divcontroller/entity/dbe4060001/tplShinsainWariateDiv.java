package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.ShinsainWariateBtnDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.dgShinsainIchiran_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4060001.dgShinsainKoseiIchiran_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tplShinsainWariate のクラスファイル 
 * 
 * @author 自動生成
 */
public class tplShinsainWariateDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinsainKoseiIchiran")
    private Label lblShinsainKoseiIchiran;
    @JsonProperty("dgShinsainKoseiIchiran")
    private DataGrid<dgShinsainKoseiIchiran_Row> dgShinsainKoseiIchiran;
    @JsonProperty("ShinsainWariateBtn")
    private ShinsainWariateBtnDiv ShinsainWariateBtn;
    @JsonProperty("lblShinsainIchiran")
    private Label lblShinsainIchiran;
    @JsonProperty("dgShinsainIchiran")
    private DataGrid<dgShinsainIchiran_Row> dgShinsainIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShinsainKoseiIchiran")
    public Label getLblShinsainKoseiIchiran() {
        return lblShinsainKoseiIchiran;
    }

    @JsonProperty("lblShinsainKoseiIchiran")
    public void setLblShinsainKoseiIchiran(Label lblShinsainKoseiIchiran) {
        this.lblShinsainKoseiIchiran=lblShinsainKoseiIchiran;
    }

    @JsonProperty("dgShinsainKoseiIchiran")
    public DataGrid<dgShinsainKoseiIchiran_Row> getDgShinsainKoseiIchiran() {
        return dgShinsainKoseiIchiran;
    }

    @JsonProperty("dgShinsainKoseiIchiran")
    public void setDgShinsainKoseiIchiran(DataGrid<dgShinsainKoseiIchiran_Row> dgShinsainKoseiIchiran) {
        this.dgShinsainKoseiIchiran=dgShinsainKoseiIchiran;
    }

    @JsonProperty("ShinsainWariateBtn")
    public ShinsainWariateBtnDiv getShinsainWariateBtn() {
        return ShinsainWariateBtn;
    }

    @JsonProperty("ShinsainWariateBtn")
    public void setShinsainWariateBtn(ShinsainWariateBtnDiv ShinsainWariateBtn) {
        this.ShinsainWariateBtn=ShinsainWariateBtn;
    }

    @JsonProperty("lblShinsainIchiran")
    public Label getLblShinsainIchiran() {
        return lblShinsainIchiran;
    }

    @JsonProperty("lblShinsainIchiran")
    public void setLblShinsainIchiran(Label lblShinsainIchiran) {
        this.lblShinsainIchiran=lblShinsainIchiran;
    }

    @JsonProperty("dgShinsainIchiran")
    public DataGrid<dgShinsainIchiran_Row> getDgShinsainIchiran() {
        return dgShinsainIchiran;
    }

    @JsonProperty("dgShinsainIchiran")
    public void setDgShinsainIchiran(DataGrid<dgShinsainIchiran_Row> dgShinsainIchiran) {
        this.dgShinsainIchiran=dgShinsainIchiran;
    }

}
