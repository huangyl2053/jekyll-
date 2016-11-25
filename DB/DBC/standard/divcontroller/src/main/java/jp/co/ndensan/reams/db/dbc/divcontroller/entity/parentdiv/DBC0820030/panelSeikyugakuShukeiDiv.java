package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820030;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelSeikyugakuShukei のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelSeikyugakuShukeiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgdSeikyugakushukei")
    private DataGrid<dgdSeikyugakushukei_Row> dgdSeikyugakushukei;
    @JsonProperty("panelSeikyuShokai")
    private panelSeikyuShokaiDiv panelSeikyuShokai;
    @JsonProperty("rowId")
    private TextBoxNum rowId;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgdSeikyugakushukei
     * @return dgdSeikyugakushukei
     */
    @JsonProperty("dgdSeikyugakushukei")
    public DataGrid<dgdSeikyugakushukei_Row> getDgdSeikyugakushukei() {
        return dgdSeikyugakushukei;
    }

    /*
     * setdgdSeikyugakushukei
     * @param dgdSeikyugakushukei dgdSeikyugakushukei
     */
    @JsonProperty("dgdSeikyugakushukei")
    public void setDgdSeikyugakushukei(DataGrid<dgdSeikyugakushukei_Row> dgdSeikyugakushukei) {
        this.dgdSeikyugakushukei = dgdSeikyugakushukei;
    }

    /*
     * getpanelSeikyuShokai
     * @return panelSeikyuShokai
     */
    @JsonProperty("panelSeikyuShokai")
    public panelSeikyuShokaiDiv getPanelSeikyuShokai() {
        return panelSeikyuShokai;
    }

    /*
     * setpanelSeikyuShokai
     * @param panelSeikyuShokai panelSeikyuShokai
     */
    @JsonProperty("panelSeikyuShokai")
    public void setPanelSeikyuShokai(panelSeikyuShokaiDiv panelSeikyuShokai) {
        this.panelSeikyuShokai = panelSeikyuShokai;
    }

    /*
     * getrowId
     * @return rowId
     */
    @JsonProperty("rowId")
    public TextBoxNum getRowId() {
        return rowId;
    }

    /*
     * setrowId
     * @param rowId rowId
     */
    @JsonProperty("rowId")
    public void setRowId(TextBoxNum rowId) {
        this.rowId = rowId;
    }

    // </editor-fold>
}
