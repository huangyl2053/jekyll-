package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020011;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHokokuYM")
    private TextBoxFlexibleDate txtHokokuYM;
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
     * gettxtHokokuYM
     * @return txtHokokuYM
     */
    @JsonProperty("txtHokokuYM")
    public TextBoxFlexibleDate getTxtHokokuYM() {
        return txtHokokuYM;
    }

    /*
     * settxtHokokuYM
     * @param txtHokokuYM txtHokokuYM
     */
    @JsonProperty("txtHokokuYM")
    public void setTxtHokokuYM(TextBoxFlexibleDate txtHokokuYM) {
        this.txtHokokuYM = txtHokokuYM;
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
