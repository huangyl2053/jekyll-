package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HakkoJokenSinnsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class HakkoJokenSinnseiDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblSakuseiChohyo")
    private Label lblSakuseiChohyo;
    @JsonProperty("chkSakuseiChohyo")
    private CheckBoxList chkSakuseiChohyo;
    @JsonProperty("lblSakuseiJoken")
    private Label lblSakuseiJoken;
    @JsonProperty("radHakoJyoken")
    private RadioButton radHakoJyoken;
    @JsonProperty("txtShoriYMD")
    private TextBoxDateRange txtShoriYMD;
    @JsonProperty("txtShinseibi")
    private TextBoxDateRange txtShinseibi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblSakuseiChohyo
     * @return lblSakuseiChohyo
     */
    @JsonProperty("lblSakuseiChohyo")
    public Label getLblSakuseiChohyo() {
        return lblSakuseiChohyo;
    }

    /*
     * setlblSakuseiChohyo
     * @param lblSakuseiChohyo lblSakuseiChohyo
     */
    @JsonProperty("lblSakuseiChohyo")
    public void setLblSakuseiChohyo(Label lblSakuseiChohyo) {
        this.lblSakuseiChohyo = lblSakuseiChohyo;
    }

    /*
     * getchkSakuseiChohyo
     * @return chkSakuseiChohyo
     */
    @JsonProperty("chkSakuseiChohyo")
    public CheckBoxList getChkSakuseiChohyo() {
        return chkSakuseiChohyo;
    }

    /*
     * setchkSakuseiChohyo
     * @param chkSakuseiChohyo chkSakuseiChohyo
     */
    @JsonProperty("chkSakuseiChohyo")
    public void setChkSakuseiChohyo(CheckBoxList chkSakuseiChohyo) {
        this.chkSakuseiChohyo = chkSakuseiChohyo;
    }

    /*
     * getlblSakuseiJoken
     * @return lblSakuseiJoken
     */
    @JsonProperty("lblSakuseiJoken")
    public Label getLblSakuseiJoken() {
        return lblSakuseiJoken;
    }

    /*
     * setlblSakuseiJoken
     * @param lblSakuseiJoken lblSakuseiJoken
     */
    @JsonProperty("lblSakuseiJoken")
    public void setLblSakuseiJoken(Label lblSakuseiJoken) {
        this.lblSakuseiJoken = lblSakuseiJoken;
    }

    /*
     * getradHakoJyoken
     * @return radHakoJyoken
     */
    @JsonProperty("radHakoJyoken")
    public RadioButton getRadHakoJyoken() {
        return radHakoJyoken;
    }

    /*
     * setradHakoJyoken
     * @param radHakoJyoken radHakoJyoken
     */
    @JsonProperty("radHakoJyoken")
    public void setRadHakoJyoken(RadioButton radHakoJyoken) {
        this.radHakoJyoken = radHakoJyoken;
    }

    /*
     * gettxtShoriYMD
     * @return txtShoriYMD
     */
    @JsonProperty("txtShoriYMD")
    public TextBoxDateRange getTxtShoriYMD() {
        return txtShoriYMD;
    }

    /*
     * settxtShoriYMD
     * @param txtShoriYMD txtShoriYMD
     */
    @JsonProperty("txtShoriYMD")
    public void setTxtShoriYMD(TextBoxDateRange txtShoriYMD) {
        this.txtShoriYMD = txtShoriYMD;
    }

    /*
     * gettxtShinseibi
     * @return txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public TextBoxDateRange getTxtShinseibi() {
        return txtShinseibi;
    }

    /*
     * settxtShinseibi
     * @param txtShinseibi txtShinseibi
     */
    @JsonProperty("txtShinseibi")
    public void setTxtShinseibi(TextBoxDateRange txtShinseibi) {
        this.txtShinseibi = txtShinseibi;
    }

    // </editor-fold>
}
