package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinseiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinseiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddShinsei")
    private Button btnAddShinsei;
    @JsonProperty("dgShinseiList")
    private DataGrid<dgShinseiList_Row> dgShinseiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddShinsei
     * @return btnAddShinsei
     */
    @JsonProperty("btnAddShinsei")
    public Button getBtnAddShinsei() {
        return btnAddShinsei;
    }

    /*
     * setbtnAddShinsei
     * @param btnAddShinsei btnAddShinsei
     */
    @JsonProperty("btnAddShinsei")
    public void setBtnAddShinsei(Button btnAddShinsei) {
        this.btnAddShinsei = btnAddShinsei;
    }

    /*
     * getdgShinseiList
     * @return dgShinseiList
     */
    @JsonProperty("dgShinseiList")
    public DataGrid<dgShinseiList_Row> getDgShinseiList() {
        return dgShinseiList;
    }

    /*
     * setdgShinseiList
     * @param dgShinseiList dgShinseiList
     */
    @JsonProperty("dgShinseiList")
    public void setDgShinseiList(DataGrid<dgShinseiList_Row> dgShinseiList) {
        this.dgShinseiList = dgShinseiList;
    }

    // </editor-fold>
}
