package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaNoShiteiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaNoShiteiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radHihokenshaNo")
    private RadioButton radHihokenshaNo;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("btnHihokenshaSearch")
    private ButtonDialog btnHihokenshaSearch;
    @JsonProperty("ddlNendo")
    private DropDownList ddlNendo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradHihokenshaNo
     * @return radHihokenshaNo
     */
    @JsonProperty("radHihokenshaNo")
    public RadioButton getRadHihokenshaNo() {
        return radHihokenshaNo;
    }

    /*
     * setradHihokenshaNo
     * @param radHihokenshaNo radHihokenshaNo
     */
    @JsonProperty("radHihokenshaNo")
    public void setRadHihokenshaNo(RadioButton radHihokenshaNo) {
        this.radHihokenshaNo = radHihokenshaNo;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * getbtnHihokenshaSearch
     * @return btnHihokenshaSearch
     */
    @JsonProperty("btnHihokenshaSearch")
    public ButtonDialog getBtnHihokenshaSearch() {
        return btnHihokenshaSearch;
    }

    /*
     * setbtnHihokenshaSearch
     * @param btnHihokenshaSearch btnHihokenshaSearch
     */
    @JsonProperty("btnHihokenshaSearch")
    public void setBtnHihokenshaSearch(ButtonDialog btnHihokenshaSearch) {
        this.btnHihokenshaSearch = btnHihokenshaSearch;
    }

    /*
     * getddlNendo
     * @return ddlNendo
     */
    @JsonProperty("ddlNendo")
    public DropDownList getDdlNendo() {
        return ddlNendo;
    }

    /*
     * setddlNendo
     * @param ddlNendo ddlNendo
     */
    @JsonProperty("ddlNendo")
    public void setDdlNendo(DropDownList ddlNendo) {
        this.ddlNendo = ddlNendo;
    }

    // </editor-fold>
}
