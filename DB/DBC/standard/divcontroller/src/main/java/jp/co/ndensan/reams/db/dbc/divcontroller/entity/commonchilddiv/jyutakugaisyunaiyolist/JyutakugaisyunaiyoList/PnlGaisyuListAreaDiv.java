package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.jyutakugaisyunaiyolist.JyutakugaisyunaiyoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlGaisyuListArea のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlGaisyuListAreaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnDetailAdd")
    private Button btnDetailAdd;
    @JsonProperty("dgGaisyuList")
    private DataGrid<dgGaisyuList_Row> dgGaisyuList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnDetailAdd
     * @return btnDetailAdd
     */
    @JsonProperty("btnDetailAdd")
    public Button getBtnDetailAdd() {
        return btnDetailAdd;
    }

    /*
     * setbtnDetailAdd
     * @param btnDetailAdd btnDetailAdd
     */
    @JsonProperty("btnDetailAdd")
    public void setBtnDetailAdd(Button btnDetailAdd) {
        this.btnDetailAdd = btnDetailAdd;
    }

    /*
     * getdgGaisyuList
     * @return dgGaisyuList
     */
    @JsonProperty("dgGaisyuList")
    public DataGrid<dgGaisyuList_Row> getDgGaisyuList() {
        return dgGaisyuList;
    }

    /*
     * setdgGaisyuList
     * @param dgGaisyuList dgGaisyuList
     */
    @JsonProperty("dgGaisyuList")
    public void setDgGaisyuList(DataGrid<dgGaisyuList_Row> dgGaisyuList) {
        this.dgGaisyuList = dgGaisyuList;
    }

    // </editor-fold>
}
