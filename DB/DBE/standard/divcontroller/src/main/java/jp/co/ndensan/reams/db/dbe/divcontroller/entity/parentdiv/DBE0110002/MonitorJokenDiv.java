package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MonitorJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class MonitorJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkMonitror")
    private CheckBoxList chkMonitror;
    @JsonProperty("lblMonitorSakuseiJoken")
    private Label lblMonitorSakuseiJoken;
    @JsonProperty("radMonitorJoken")
    private RadioButton radMonitorJoken;
    @JsonProperty("txtMonitorShoriYMD")
    private TextBoxDateRange txtMonitorShoriYMD;
    @JsonProperty("txtMonitorShinseiYMD")
    private TextBoxDateRange txtMonitorShinseiYMD;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkMonitror
     * @return chkMonitror
     */
    @JsonProperty("chkMonitror")
    public CheckBoxList getChkMonitror() {
        return chkMonitror;
    }

    /*
     * setchkMonitror
     * @param chkMonitror chkMonitror
     */
    @JsonProperty("chkMonitror")
    public void setChkMonitror(CheckBoxList chkMonitror) {
        this.chkMonitror = chkMonitror;
    }

    /*
     * getlblMonitorSakuseiJoken
     * @return lblMonitorSakuseiJoken
     */
    @JsonProperty("lblMonitorSakuseiJoken")
    public Label getLblMonitorSakuseiJoken() {
        return lblMonitorSakuseiJoken;
    }

    /*
     * setlblMonitorSakuseiJoken
     * @param lblMonitorSakuseiJoken lblMonitorSakuseiJoken
     */
    @JsonProperty("lblMonitorSakuseiJoken")
    public void setLblMonitorSakuseiJoken(Label lblMonitorSakuseiJoken) {
        this.lblMonitorSakuseiJoken = lblMonitorSakuseiJoken;
    }

    /*
     * getradMonitorJoken
     * @return radMonitorJoken
     */
    @JsonProperty("radMonitorJoken")
    public RadioButton getRadMonitorJoken() {
        return radMonitorJoken;
    }

    /*
     * setradMonitorJoken
     * @param radMonitorJoken radMonitorJoken
     */
    @JsonProperty("radMonitorJoken")
    public void setRadMonitorJoken(RadioButton radMonitorJoken) {
        this.radMonitorJoken = radMonitorJoken;
    }

    /*
     * gettxtMonitorShoriYMD
     * @return txtMonitorShoriYMD
     */
    @JsonProperty("txtMonitorShoriYMD")
    public TextBoxDateRange getTxtMonitorShoriYMD() {
        return txtMonitorShoriYMD;
    }

    /*
     * settxtMonitorShoriYMD
     * @param txtMonitorShoriYMD txtMonitorShoriYMD
     */
    @JsonProperty("txtMonitorShoriYMD")
    public void setTxtMonitorShoriYMD(TextBoxDateRange txtMonitorShoriYMD) {
        this.txtMonitorShoriYMD = txtMonitorShoriYMD;
    }

    /*
     * gettxtMonitorShinseiYMD
     * @return txtMonitorShinseiYMD
     */
    @JsonProperty("txtMonitorShinseiYMD")
    public TextBoxDateRange getTxtMonitorShinseiYMD() {
        return txtMonitorShinseiYMD;
    }

    /*
     * settxtMonitorShinseiYMD
     * @param txtMonitorShinseiYMD txtMonitorShinseiYMD
     */
    @JsonProperty("txtMonitorShinseiYMD")
    public void setTxtMonitorShinseiYMD(TextBoxDateRange txtMonitorShinseiYMD) {
        this.txtMonitorShinseiYMD = txtMonitorShinseiYMD;
    }

    // </editor-fold>
}
