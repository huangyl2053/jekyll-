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
 * Shinki のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinkiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShinkiTaishoNendo")
    private DropDownList ddlShinkiTaishoNendo;
    @JsonProperty("txtShinkiTuikaShokisaiHokenshaNo")
    private TextBox txtShinkiTuikaShokisaiHokenshaNo;
    @JsonProperty("txtShinkiShikyuShinseishoSeiriNo")
    private TextBox txtShinkiShikyuShinseishoSeiriNo;
    @JsonProperty("btnShinkiTsuika")
    private Button btnShinkiTsuika;
    @JsonProperty("lblChui")
    private Label lblChui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShinkiTaishoNendo
     * @return ddlShinkiTaishoNendo
     */
    @JsonProperty("ddlShinkiTaishoNendo")
    public DropDownList getDdlShinkiTaishoNendo() {
        return ddlShinkiTaishoNendo;
    }

    /*
     * setddlShinkiTaishoNendo
     * @param ddlShinkiTaishoNendo ddlShinkiTaishoNendo
     */
    @JsonProperty("ddlShinkiTaishoNendo")
    public void setDdlShinkiTaishoNendo(DropDownList ddlShinkiTaishoNendo) {
        this.ddlShinkiTaishoNendo = ddlShinkiTaishoNendo;
    }

    /*
     * gettxtShinkiTuikaShokisaiHokenshaNo
     * @return txtShinkiTuikaShokisaiHokenshaNo
     */
    @JsonProperty("txtShinkiTuikaShokisaiHokenshaNo")
    public TextBox getTxtShinkiTuikaShokisaiHokenshaNo() {
        return txtShinkiTuikaShokisaiHokenshaNo;
    }

    /*
     * settxtShinkiTuikaShokisaiHokenshaNo
     * @param txtShinkiTuikaShokisaiHokenshaNo txtShinkiTuikaShokisaiHokenshaNo
     */
    @JsonProperty("txtShinkiTuikaShokisaiHokenshaNo")
    public void setTxtShinkiTuikaShokisaiHokenshaNo(TextBox txtShinkiTuikaShokisaiHokenshaNo) {
        this.txtShinkiTuikaShokisaiHokenshaNo = txtShinkiTuikaShokisaiHokenshaNo;
    }

    /*
     * gettxtShinkiShikyuShinseishoSeiriNo
     * @return txtShinkiShikyuShinseishoSeiriNo
     */
    @JsonProperty("txtShinkiShikyuShinseishoSeiriNo")
    public TextBox getTxtShinkiShikyuShinseishoSeiriNo() {
        return txtShinkiShikyuShinseishoSeiriNo;
    }

    /*
     * settxtShinkiShikyuShinseishoSeiriNo
     * @param txtShinkiShikyuShinseishoSeiriNo txtShinkiShikyuShinseishoSeiriNo
     */
    @JsonProperty("txtShinkiShikyuShinseishoSeiriNo")
    public void setTxtShinkiShikyuShinseishoSeiriNo(TextBox txtShinkiShikyuShinseishoSeiriNo) {
        this.txtShinkiShikyuShinseishoSeiriNo = txtShinkiShikyuShinseishoSeiriNo;
    }

    /*
     * getbtnShinkiTsuika
     * @return btnShinkiTsuika
     */
    @JsonProperty("btnShinkiTsuika")
    public Button getBtnShinkiTsuika() {
        return btnShinkiTsuika;
    }

    /*
     * setbtnShinkiTsuika
     * @param btnShinkiTsuika btnShinkiTsuika
     */
    @JsonProperty("btnShinkiTsuika")
    public void setBtnShinkiTsuika(Button btnShinkiTsuika) {
        this.btnShinkiTsuika = btnShinkiTsuika;
    }

    /*
     * getlblChui
     * @return lblChui
     */
    @JsonProperty("lblChui")
    public Label getLblChui() {
        return lblChui;
    }

    /*
     * setlblChui
     * @param lblChui lblChui
     */
    @JsonProperty("lblChui")
    public void setLblChui(Label lblChui) {
        this.lblChui = lblChui;
    }

    // </editor-fold>
}
