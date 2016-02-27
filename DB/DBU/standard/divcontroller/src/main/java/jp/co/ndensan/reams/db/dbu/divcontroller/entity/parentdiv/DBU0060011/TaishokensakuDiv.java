package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0060011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * Taishokensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishokensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokokuY")
    private TextBoxFlexibleDate txtHokokuY;
    @JsonProperty("txtshukeiY")
    private TextBoxFlexibleDate txtshukeiY;
    @JsonProperty("ddlShichoson")
    private DropDownList ddlShichoson;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("btnClear")
    private Button btnClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHokokuY
     * @return txtHokokuY
     */
    @JsonProperty("txtHokokuY")
    public TextBoxFlexibleDate getTxtHokokuY() {
        return txtHokokuY;
    }

    /*
     * settxtHokokuY
     * @param txtHokokuY txtHokokuY
     */
    @JsonProperty("txtHokokuY")
    public void setTxtHokokuY(TextBoxFlexibleDate txtHokokuY) {
        this.txtHokokuY = txtHokokuY;
    }

    /*
     * gettxtshukeiY
     * @return txtshukeiY
     */
    @JsonProperty("txtshukeiY")
    public TextBoxFlexibleDate getTxtshukeiY() {
        return txtshukeiY;
    }

    /*
     * settxtshukeiY
     * @param txtshukeiY txtshukeiY
     */
    @JsonProperty("txtshukeiY")
    public void setTxtshukeiY(TextBoxFlexibleDate txtshukeiY) {
        this.txtshukeiY = txtshukeiY;
    }

    /*
     * getddlShichoson
     * @return ddlShichoson
     */
    @JsonProperty("ddlShichoson")
    public DropDownList getDdlShichoson() {
        return ddlShichoson;
    }

    /*
     * setddlShichoson
     * @param ddlShichoson ddlShichoson
     */
    @JsonProperty("ddlShichoson")
    public void setDdlShichoson(DropDownList ddlShichoson) {
        this.ddlShichoson = ddlShichoson;
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
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    // </editor-fold>
}
