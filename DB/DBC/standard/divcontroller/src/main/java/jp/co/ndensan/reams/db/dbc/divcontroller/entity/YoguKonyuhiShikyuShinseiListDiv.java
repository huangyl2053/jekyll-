package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgShikyuShinseiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YoguKonyuhiShikyuShinseiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeikyoYMD")
    private TextBoxDate txtTeikyoYMD;
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgShikyuShinseiList")
    private DataGrid<dgShikyuShinseiList_Row> dgShikyuShinseiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtTeikyoYMD")
    public TextBoxDate getTxtTeikyoYMD() {
        return txtTeikyoYMD;
    }

    @JsonProperty("txtTeikyoYMD")
    public void setTxtTeikyoYMD(TextBoxDate txtTeikyoYMD) {
        this.txtTeikyoYMD=txtTeikyoYMD;
    }

    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd=btnAdd;
    }

    @JsonProperty("dgShikyuShinseiList")
    public DataGrid<dgShikyuShinseiList_Row> getDgShikyuShinseiList() {
        return dgShikyuShinseiList;
    }

    @JsonProperty("dgShikyuShinseiList")
    public void setDgShikyuShinseiList(DataGrid<dgShikyuShinseiList_Row> dgShikyuShinseiList) {
        this.dgShikyuShinseiList=dgShikyuShinseiList;
    }

}
