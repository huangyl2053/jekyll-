package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0800011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HokenshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class HokenshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTodofuken")
    private DropDownList ddlTodofuken;
    @JsonProperty("btnAddHokensha")
    private Button btnAddHokensha;
    @JsonProperty("dgHokenshas")
    private DataGrid<dgHokenshas_Row> dgHokenshas;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlTodofuken
     * @return ddlTodofuken
     */
    @JsonProperty("ddlTodofuken")
    public DropDownList getDdlTodofuken() {
        return ddlTodofuken;
    }

    /*
     * setddlTodofuken
     * @param ddlTodofuken ddlTodofuken
     */
    @JsonProperty("ddlTodofuken")
    public void setDdlTodofuken(DropDownList ddlTodofuken) {
        this.ddlTodofuken = ddlTodofuken;
    }

    /*
     * getbtnAddHokensha
     * @return btnAddHokensha
     */
    @JsonProperty("btnAddHokensha")
    public Button getBtnAddHokensha() {
        return btnAddHokensha;
    }

    /*
     * setbtnAddHokensha
     * @param btnAddHokensha btnAddHokensha
     */
    @JsonProperty("btnAddHokensha")
    public void setBtnAddHokensha(Button btnAddHokensha) {
        this.btnAddHokensha = btnAddHokensha;
    }

    /*
     * getdgHokenshas
     * @return dgHokenshas
     */
    @JsonProperty("dgHokenshas")
    public DataGrid<dgHokenshas_Row> getDgHokenshas() {
        return dgHokenshas;
    }

    /*
     * setdgHokenshas
     * @param dgHokenshas dgHokenshas
     */
    @JsonProperty("dgHokenshas")
    public void setDgHokenshas(DataGrid<dgHokenshas_Row> dgHokenshas) {
        this.dgHokenshas = dgHokenshas;
    }

    // </editor-fold>
}
