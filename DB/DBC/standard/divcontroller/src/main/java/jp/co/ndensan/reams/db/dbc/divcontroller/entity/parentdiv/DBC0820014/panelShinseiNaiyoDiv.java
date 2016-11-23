package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820014;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * panelShinseiNaiyo のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelShinseiNaiyoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseibi")
    private TextBoxDate txtShinseibi;
    @JsonProperty("ddlShomeisho")
    private DropDownList ddlShomeisho;
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgdServiceTeikyoShomeisyo")
    private DataGrid<dgdServiceTeikyoShomeisyo_Row> dgdServiceTeikyoShomeisyo;
    @JsonProperty("ccdShisetsuJoho")
    private ShisetsuJohoCommonChildDivDiv ccdShisetsuJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseibi
     * @return txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public TextBoxDate getTxtShinseibi() {
        return txtShinseibi;
    }

    /*
     * settxtShinseibi
     * @param txtShinseibi txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxDate txtShinseibi) {
        this.txtShinseibi = txtShinseibi;
    }

    /*
     * getddlShomeisho
     * @return ddlShomeisho
     */
    @JsonProperty("ddlShomeisho")
    public DropDownList getDdlShomeisho() {
        return ddlShomeisho;
    }

    /*
     * setddlShomeisho
     * @param ddlShomeisho ddlShomeisho
     */
    @JsonProperty("ddlShomeisho")
    public void setDdlShomeisho(DropDownList ddlShomeisho) {
        this.ddlShomeisho = ddlShomeisho;
    }

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
     * getdgdServiceTeikyoShomeisyo
     * @return dgdServiceTeikyoShomeisyo
     */
    @JsonProperty("dgdServiceTeikyoShomeisyo")
    public DataGrid<dgdServiceTeikyoShomeisyo_Row> getDgdServiceTeikyoShomeisyo() {
        return dgdServiceTeikyoShomeisyo;
    }

    /*
     * setdgdServiceTeikyoShomeisyo
     * @param dgdServiceTeikyoShomeisyo dgdServiceTeikyoShomeisyo
     */
    @JsonProperty("dgdServiceTeikyoShomeisyo")
    public void setDgdServiceTeikyoShomeisyo(DataGrid<dgdServiceTeikyoShomeisyo_Row> dgdServiceTeikyoShomeisyo) {
        this.dgdServiceTeikyoShomeisyo = dgdServiceTeikyoShomeisyo;
    }

    /*
     * getccdShisetsuJoho
     * @return ccdShisetsuJoho
     */
    @JsonProperty("ccdShisetsuJoho")
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return ccdShisetsuJoho;
    }

    // </editor-fold>
}
