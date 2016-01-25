package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0810011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelShokan のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShokanDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServerYmRange")
    private TextBoxDateRange txtServerYmRange;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("dgShokanBaraisyokai")
    private DataGrid<dgShokanBaraisyokai_Row> dgShokanBaraisyokai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServerYmRange
     * @return txtServerYmRange
     */
    @JsonProperty("txtServerYmRange")
    public TextBoxDateRange getTxtServerYmRange() {
        return txtServerYmRange;
    }

    /*
     * settxtServerYmRange
     * @param txtServerYmRange txtServerYmRange
     */
    @JsonProperty("txtServerYmRange")
    public void setTxtServerYmRange(TextBoxDateRange txtServerYmRange) {
        this.txtServerYmRange = txtServerYmRange;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * getdgShokanBaraisyokai
     * @return dgShokanBaraisyokai
     */
    @JsonProperty("dgShokanBaraisyokai")
    public DataGrid<dgShokanBaraisyokai_Row> getDgShokanBaraisyokai() {
        return dgShokanBaraisyokai;
    }

    /*
     * setdgShokanBaraisyokai
     * @param dgShokanBaraisyokai dgShokanBaraisyokai
     */
    @JsonProperty("dgShokanBaraisyokai")
    public void setDgShokanBaraisyokai(DataGrid<dgShokanBaraisyokai_Row> dgShokanBaraisyokai) {
        this.dgShokanBaraisyokai = dgShokanBaraisyokai;
    }

    // </editor-fold>
}
