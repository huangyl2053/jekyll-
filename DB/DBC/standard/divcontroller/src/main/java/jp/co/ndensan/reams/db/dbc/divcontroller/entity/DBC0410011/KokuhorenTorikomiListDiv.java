package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410011;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410011.dgKokuhorenTorikomiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KokuhorenTorikomiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class KokuhorenTorikomiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriYM")
    private TextBoxDate txtShoriYM;
    @JsonProperty("btnDisplay")
    private Button btnDisplay;
    @JsonProperty("btnScheduleSetting")
    private Button btnScheduleSetting;
    @JsonProperty("dgKokuhorenTorikomiList")
    private DataGrid<dgKokuhorenTorikomiList_Row> dgKokuhorenTorikomiList;
    @JsonProperty("lblUketoriTorikomi")
    private Label lblUketoriTorikomi;
    @JsonProperty("lblKokuhorenTorikomiList")
    private Label lblKokuhorenTorikomiList;

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

    @JsonProperty("btnDisplay")
    public Button getBtnDisplay() {
        return btnDisplay;
    }

    @JsonProperty("btnDisplay")
    public void setBtnDisplay(Button btnDisplay) {
        this.btnDisplay=btnDisplay;
    }

    @JsonProperty("btnScheduleSetting")
    public Button getBtnScheduleSetting() {
        return btnScheduleSetting;
    }

    @JsonProperty("btnScheduleSetting")
    public void setBtnScheduleSetting(Button btnScheduleSetting) {
        this.btnScheduleSetting=btnScheduleSetting;
    }

    @JsonProperty("dgKokuhorenTorikomiList")
    public DataGrid<dgKokuhorenTorikomiList_Row> getDgKokuhorenTorikomiList() {
        return dgKokuhorenTorikomiList;
    }

    @JsonProperty("dgKokuhorenTorikomiList")
    public void setDgKokuhorenTorikomiList(DataGrid<dgKokuhorenTorikomiList_Row> dgKokuhorenTorikomiList) {
        this.dgKokuhorenTorikomiList=dgKokuhorenTorikomiList;
    }

    @JsonProperty("lblUketoriTorikomi")
    public Label getLblUketoriTorikomi() {
        return lblUketoriTorikomi;
    }

    @JsonProperty("lblUketoriTorikomi")
    public void setLblUketoriTorikomi(Label lblUketoriTorikomi) {
        this.lblUketoriTorikomi=lblUketoriTorikomi;
    }

    @JsonProperty("lblKokuhorenTorikomiList")
    public Label getLblKokuhorenTorikomiList() {
        return lblKokuhorenTorikomiList;
    }

    @JsonProperty("lblKokuhorenTorikomiList")
    public void setLblKokuhorenTorikomiList(Label lblKokuhorenTorikomiList) {
        this.lblKokuhorenTorikomiList=lblKokuhorenTorikomiList;
    }

}
