package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoguKonyuhiShikyuShinseiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class YoguKonyuhiShikyuShinseiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddShikyuShinsei")
    private Button btnAddShikyuShinsei;
    @JsonProperty("dgShikyuShinseiList")
    private DataGrid<dgShikyuShinseiList_Row> dgShikyuShinseiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddShikyuShinsei
     * @return btnAddShikyuShinsei
     */
    @JsonProperty("btnAddShikyuShinsei")
    public Button getBtnAddShikyuShinsei() {
        return btnAddShikyuShinsei;
    }

    /*
     * setbtnAddShikyuShinsei
     * @param btnAddShikyuShinsei btnAddShikyuShinsei
     */
    @JsonProperty("btnAddShikyuShinsei")
    public void setBtnAddShikyuShinsei(Button btnAddShikyuShinsei) {
        this.btnAddShikyuShinsei = btnAddShikyuShinsei;
    }

    /*
     * getdgShikyuShinseiList
     * @return dgShikyuShinseiList
     */
    @JsonProperty("dgShikyuShinseiList")
    public DataGrid<dgShikyuShinseiList_Row> getDgShikyuShinseiList() {
        return dgShikyuShinseiList;
    }

    /*
     * setdgShikyuShinseiList
     * @param dgShikyuShinseiList dgShikyuShinseiList
     */
    @JsonProperty("dgShikyuShinseiList")
    public void setDgShikyuShinseiList(DataGrid<dgShikyuShinseiList_Row> dgShikyuShinseiList) {
        this.dgShikyuShinseiList = dgShikyuShinseiList;
    }

    // </editor-fold>
}
