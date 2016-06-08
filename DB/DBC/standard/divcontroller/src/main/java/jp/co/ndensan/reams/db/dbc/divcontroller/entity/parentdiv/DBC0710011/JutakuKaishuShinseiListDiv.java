package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0710011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * JutakuKaishuShinseiList のクラスファイル
 *
 * @reamsid_L DBC-0992-100 yebangqiang
 */
public class JutakuKaishuShinseiListDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddShinsei")
    private Button btnAddShinsei;
    @JsonProperty("txtServiceYM")
    private TextBoxDate txtServiceYM;
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
     * gettxtServiceYM
     * @return txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public TextBoxDate getTxtServiceYM() {
        return txtServiceYM;
    }

    /*
     * settxtServiceYM
     * @param txtServiceYM txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public void setTxtServiceYM(TextBoxDate txtServiceYM) {
        this.txtServiceYM = txtServiceYM;
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
