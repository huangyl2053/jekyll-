package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN130001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Koshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class KoshinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlKoshinTaishoNendo")
    private DropDownList ddlKoshinTaishoNendo;
    @JsonProperty("txtKoshinShikyuShinseishoSeiriNo")
    private TextBox txtKoshinShikyuShinseishoSeiriNo;
    @JsonProperty("chkIsRirekiHyoji")
    private CheckBoxList chkIsRirekiHyoji;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("dgShomeishoRireki")
    private DataGrid<dgShomeishoRireki_Row> dgShomeishoRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlKoshinTaishoNendo
     * @return ddlKoshinTaishoNendo
     */
    @JsonProperty("ddlKoshinTaishoNendo")
    public DropDownList getDdlKoshinTaishoNendo() {
        return ddlKoshinTaishoNendo;
    }

    /*
     * setddlKoshinTaishoNendo
     * @param ddlKoshinTaishoNendo ddlKoshinTaishoNendo
     */
    @JsonProperty("ddlKoshinTaishoNendo")
    public void setDdlKoshinTaishoNendo(DropDownList ddlKoshinTaishoNendo) {
        this.ddlKoshinTaishoNendo = ddlKoshinTaishoNendo;
    }

    /*
     * gettxtKoshinShikyuShinseishoSeiriNo
     * @return txtKoshinShikyuShinseishoSeiriNo
     */
    @JsonProperty("txtKoshinShikyuShinseishoSeiriNo")
    public TextBox getTxtKoshinShikyuShinseishoSeiriNo() {
        return txtKoshinShikyuShinseishoSeiriNo;
    }

    /*
     * settxtKoshinShikyuShinseishoSeiriNo
     * @param txtKoshinShikyuShinseishoSeiriNo txtKoshinShikyuShinseishoSeiriNo
     */
    @JsonProperty("txtKoshinShikyuShinseishoSeiriNo")
    public void setTxtKoshinShikyuShinseishoSeiriNo(TextBox txtKoshinShikyuShinseishoSeiriNo) {
        this.txtKoshinShikyuShinseishoSeiriNo = txtKoshinShikyuShinseishoSeiriNo;
    }

    /*
     * getchkIsRirekiHyoji
     * @return chkIsRirekiHyoji
     */
    @JsonProperty("chkIsRirekiHyoji")
    public CheckBoxList getChkIsRirekiHyoji() {
        return chkIsRirekiHyoji;
    }

    /*
     * setchkIsRirekiHyoji
     * @param chkIsRirekiHyoji chkIsRirekiHyoji
     */
    @JsonProperty("chkIsRirekiHyoji")
    public void setChkIsRirekiHyoji(CheckBoxList chkIsRirekiHyoji) {
        this.chkIsRirekiHyoji = chkIsRirekiHyoji;
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
     * getdgShomeishoRireki
     * @return dgShomeishoRireki
     */
    @JsonProperty("dgShomeishoRireki")
    public DataGrid<dgShomeishoRireki_Row> getDgShomeishoRireki() {
        return dgShomeishoRireki;
    }

    /*
     * setdgShomeishoRireki
     * @param dgShomeishoRireki dgShomeishoRireki
     */
    @JsonProperty("dgShomeishoRireki")
    public void setDgShomeishoRireki(DataGrid<dgShomeishoRireki_Row> dgShomeishoRireki) {
        this.dgShomeishoRireki = dgShomeishoRireki;
    }

    // </editor-fold>
}
