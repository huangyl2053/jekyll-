package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0300001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * GaitoshaList のクラスファイル 
 * 
 * @author 自動生成
 */
public class GaitoshaListDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtFukanendo")
    private TextBoxDate txtFukanendo;
    @JsonProperty("dgFukaGaitoshaList")
    private DataGrid<dgFukaGaitoshaList_Row> dgFukaGaitoshaList;
    @JsonProperty("btnReSearch")
    private Button btnReSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtFukanendo
     * @return txtFukanendo
     */
    @JsonProperty("txtFukanendo")
    public TextBoxDate getTxtFukanendo() {
        return txtFukanendo;
    }

    /*
     * settxtFukanendo
     * @param txtFukanendo txtFukanendo
     */
    @JsonProperty("txtFukanendo")
    public void setTxtFukanendo(TextBoxDate txtFukanendo) {
        this.txtFukanendo = txtFukanendo;
    }

    /*
     * getdgFukaGaitoshaList
     * @return dgFukaGaitoshaList
     */
    @JsonProperty("dgFukaGaitoshaList")
    public DataGrid<dgFukaGaitoshaList_Row> getDgFukaGaitoshaList() {
        return dgFukaGaitoshaList;
    }

    /*
     * setdgFukaGaitoshaList
     * @param dgFukaGaitoshaList dgFukaGaitoshaList
     */
    @JsonProperty("dgFukaGaitoshaList")
    public void setDgFukaGaitoshaList(DataGrid<dgFukaGaitoshaList_Row> dgFukaGaitoshaList) {
        this.dgFukaGaitoshaList = dgFukaGaitoshaList;
    }

    /*
     * getbtnReSearch
     * @return btnReSearch
     */
    @JsonProperty("btnReSearch")
    public Button getBtnReSearch() {
        return btnReSearch;
    }

    /*
     * setbtnReSearch
     * @param btnReSearch btnReSearch
     */
    @JsonProperty("btnReSearch")
    public void setBtnReSearch(Button btnReSearch) {
        this.btnReSearch = btnReSearch;
    }

    // </editor-fold>
}
