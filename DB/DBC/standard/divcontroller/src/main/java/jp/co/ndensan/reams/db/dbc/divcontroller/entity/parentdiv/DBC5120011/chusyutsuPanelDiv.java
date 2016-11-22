package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC5120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * chusyutsuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class chusyutsuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radtaishoYm")
    private RadioButton radtaishoYm;
    @JsonProperty("txthani")
    private TextBoxDateRange txthani;
    @JsonProperty("lblshurui")
    private Label lblshurui;
    @JsonProperty("ddlshurui")
    private DropDownList ddlshurui;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradtaishoYm
     * @return radtaishoYm
     */
    @JsonProperty("radtaishoYm")
    public RadioButton getRadtaishoYm() {
        return radtaishoYm;
    }

    /*
     * setradtaishoYm
     * @param radtaishoYm radtaishoYm
     */
    @JsonProperty("radtaishoYm")
    public void setRadtaishoYm(RadioButton radtaishoYm) {
        this.radtaishoYm = radtaishoYm;
    }

    /*
     * gettxthani
     * @return txthani
     */
    @JsonProperty("txthani")
    public TextBoxDateRange getTxthani() {
        return txthani;
    }

    /*
     * settxthani
     * @param txthani txthani
     */
    @JsonProperty("txthani")
    public void setTxthani(TextBoxDateRange txthani) {
        this.txthani = txthani;
    }

    /*
     * getlblshurui
     * @return lblshurui
     */
    @JsonProperty("lblshurui")
    public Label getLblshurui() {
        return lblshurui;
    }

    /*
     * setlblshurui
     * @param lblshurui lblshurui
     */
    @JsonProperty("lblshurui")
    public void setLblshurui(Label lblshurui) {
        this.lblshurui = lblshurui;
    }

    /*
     * getddlshurui
     * @return ddlshurui
     */
    @JsonProperty("ddlshurui")
    public DropDownList getDdlshurui() {
        return ddlshurui;
    }

    /*
     * setddlshurui
     * @param ddlshurui ddlshurui
     */
    @JsonProperty("ddlshurui")
    public void setDdlshurui(DropDownList ddlshurui) {
        this.ddlshurui = ddlshurui;
    }

    // </editor-fold>
}
