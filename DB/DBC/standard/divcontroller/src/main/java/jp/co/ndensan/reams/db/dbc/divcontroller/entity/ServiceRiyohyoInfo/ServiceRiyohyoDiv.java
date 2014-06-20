package jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceRiyohyoInfo.dgServiceRiyohyoList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ServiceRiyohyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ServiceRiyohyoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblServiceRiyohyoList")
    private Label lblServiceRiyohyoList;
    @JsonProperty("btnRiyohyoMeisaiAdd")
    private Button btnRiyohyoMeisaiAdd;
    @JsonProperty("dgServiceRiyohyoList")
    private DataGrid<dgServiceRiyohyoList_Row> dgServiceRiyohyoList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblServiceRiyohyoList")
    public Label getLblServiceRiyohyoList() {
        return lblServiceRiyohyoList;
    }

    @JsonProperty("lblServiceRiyohyoList")
    public void setLblServiceRiyohyoList(Label lblServiceRiyohyoList) {
        this.lblServiceRiyohyoList=lblServiceRiyohyoList;
    }

    @JsonProperty("btnRiyohyoMeisaiAdd")
    public Button getBtnRiyohyoMeisaiAdd() {
        return btnRiyohyoMeisaiAdd;
    }

    @JsonProperty("btnRiyohyoMeisaiAdd")
    public void setBtnRiyohyoMeisaiAdd(Button btnRiyohyoMeisaiAdd) {
        this.btnRiyohyoMeisaiAdd=btnRiyohyoMeisaiAdd;
    }

    @JsonProperty("dgServiceRiyohyoList")
    public DataGrid<dgServiceRiyohyoList_Row> getDgServiceRiyohyoList() {
        return dgServiceRiyohyoList;
    }

    @JsonProperty("dgServiceRiyohyoList")
    public void setDgServiceRiyohyoList(DataGrid<dgServiceRiyohyoList_Row> dgServiceRiyohyoList) {
        this.dgServiceRiyohyoList=dgServiceRiyohyoList;
    }

}
