package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.dgJutakuKaishuShinseiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JutakuKaishuShinseiList のクラスファイル 
 * 
 * @author 自動生成
 */
public class JutakuKaishuShinseiListDiv extends Panel {
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
    @JsonProperty("btnDummy")
    private Button btnDummy;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddShinsei")
    public Button getBtnAddShinsei() {
        return btnAddShinsei;
    }

    @JsonProperty("btnAddShinsei")
    public void setBtnAddShinsei(Button btnAddShinsei) {
        this.btnAddShinsei=btnAddShinsei;
    }

    @JsonProperty("dgJutakuKaishuShinseiList")
    public DataGrid<dgJutakuKaishuShinseiList_Row> getDgJutakuKaishuShinseiList() {
        return dgJutakuKaishuShinseiList;
    }

    @JsonProperty("dgJutakuKaishuShinseiList")
    public void setDgJutakuKaishuShinseiList(DataGrid<dgJutakuKaishuShinseiList_Row> dgJutakuKaishuShinseiList) {
        this.dgJutakuKaishuShinseiList=dgJutakuKaishuShinseiList;
    }

    @JsonProperty("btnDummy")
    public Button getBtnDummy() {
        return btnDummy;
    }

    @JsonProperty("btnDummy")
    public void setBtnDummy(Button btnDummy) {
        this.btnDummy=btnDummy;
    }

}
