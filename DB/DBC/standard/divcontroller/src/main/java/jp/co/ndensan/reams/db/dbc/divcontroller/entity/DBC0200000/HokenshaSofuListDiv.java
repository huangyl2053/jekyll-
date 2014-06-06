package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0200000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HokenshaSofuList のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenshaSofuListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriYM")
    private TextBoxDate txtShoriYM;
    @JsonProperty("lblHokenshaSofuList")
    private Label lblHokenshaSofuList;
    @JsonProperty("btnDisplay")
    private Button btnDisplay;
    @JsonProperty("dgHokenshaSofuList")
    private DataGrid<dgHokenshaSofuList_Row> dgHokenshaSofuList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShoriYM")
    public TextBoxDate getTxtShoriYM() {
        return txtShoriYM;
    }

    @JsonProperty("txtShoriYM")
    public void setTxtShoriYM(TextBoxDate txtShoriYM) {
        this.txtShoriYM=txtShoriYM;
    }

    @JsonProperty("lblHokenshaSofuList")
    public Label getLblHokenshaSofuList() {
        return lblHokenshaSofuList;
    }

    @JsonProperty("lblHokenshaSofuList")
    public void setLblHokenshaSofuList(Label lblHokenshaSofuList) {
        this.lblHokenshaSofuList=lblHokenshaSofuList;
    }

    @JsonProperty("btnDisplay")
    public Button getBtnDisplay() {
        return btnDisplay;
    }

    @JsonProperty("btnDisplay")
    public void setBtnDisplay(Button btnDisplay) {
        this.btnDisplay=btnDisplay;
    }

    @JsonProperty("dgHokenshaSofuList")
    public DataGrid<dgHokenshaSofuList_Row> getDgHokenshaSofuList() {
        return dgHokenshaSofuList;
    }

    @JsonProperty("dgHokenshaSofuList")
    public void setDgHokenshaSofuList(DataGrid<dgHokenshaSofuList_Row> dgHokenshaSofuList) {
        this.dgHokenshaSofuList=dgHokenshaSofuList;
    }

}
