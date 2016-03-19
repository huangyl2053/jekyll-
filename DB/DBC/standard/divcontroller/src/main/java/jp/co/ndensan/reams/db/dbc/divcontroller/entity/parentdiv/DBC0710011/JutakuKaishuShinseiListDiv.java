package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JutakuKaishuShinseiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuShinseiListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddShinsei")
    private Button btnAddShinsei;
    @JsonProperty("dgJutakuKaishuShinseiList")
    private DataGrid<dgJutakuKaishuShinseiList_Row> dgJutakuKaishuShinseiList;

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
     * getdgJutakuKaishuShinseiList
     * @return dgJutakuKaishuShinseiList
     */
    @JsonProperty("dgJutakuKaishuShinseiList")
    public DataGrid<dgJutakuKaishuShinseiList_Row> getDgJutakuKaishuShinseiList() {
        return dgJutakuKaishuShinseiList;
    }

    /*
     * setdgJutakuKaishuShinseiList
     * @param dgJutakuKaishuShinseiList dgJutakuKaishuShinseiList
     */
    @JsonProperty("dgJutakuKaishuShinseiList")
    public void setDgJutakuKaishuShinseiList(DataGrid<dgJutakuKaishuShinseiList_Row> dgJutakuKaishuShinseiList) {
        this.dgJutakuKaishuShinseiList = dgJutakuKaishuShinseiList;
    }

    // </editor-fold>
}
