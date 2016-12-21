package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HakkoJokenSinnsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class HakkoJokenSinnseiDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("MonitorJoken")
    private MonitorJokenDiv MonitorJoken;
    @JsonProperty("ShinseishaIchiranJoken")
    private ShinseishaIchiranJokenDiv ShinseishaIchiranJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getMonitorJoken
     * @return MonitorJoken
     */
    @JsonProperty("MonitorJoken")
    public MonitorJokenDiv getMonitorJoken() {
        return MonitorJoken;
    }

    /*
     * setMonitorJoken
     * @param MonitorJoken MonitorJoken
     */
    @JsonProperty("MonitorJoken")
    public void setMonitorJoken(MonitorJokenDiv MonitorJoken) {
        this.MonitorJoken = MonitorJoken;
    }

    /*
     * getShinseishaIchiranJoken
     * @return ShinseishaIchiranJoken
     */
    @JsonProperty("ShinseishaIchiranJoken")
    public ShinseishaIchiranJokenDiv getShinseishaIchiranJoken() {
        return ShinseishaIchiranJoken;
    }

    /*
     * setShinseishaIchiranJoken
     * @param ShinseishaIchiranJoken ShinseishaIchiranJoken
     */
    @JsonProperty("ShinseishaIchiranJoken")
    public void setShinseishaIchiranJoken(ShinseishaIchiranJokenDiv ShinseishaIchiranJoken) {
        this.ShinseishaIchiranJoken = ShinseishaIchiranJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkMonitror() {
        return this.getMonitorJoken().getChkMonitror();
    }

    @JsonIgnore
    public void  setChkMonitror(CheckBoxList chkMonitror) {
        this.getMonitorJoken().setChkMonitror(chkMonitror);
    }

    @JsonIgnore
    public Label getLblMonitorSakuseiJoken() {
        return this.getMonitorJoken().getLblMonitorSakuseiJoken();
    }

    @JsonIgnore
    public void  setLblMonitorSakuseiJoken(Label lblMonitorSakuseiJoken) {
        this.getMonitorJoken().setLblMonitorSakuseiJoken(lblMonitorSakuseiJoken);
    }

    @JsonIgnore
    public RadioButton getRadMonitorJoken() {
        return this.getMonitorJoken().getRadMonitorJoken();
    }

    @JsonIgnore
    public void  setRadMonitorJoken(RadioButton radMonitorJoken) {
        this.getMonitorJoken().setRadMonitorJoken(radMonitorJoken);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtMonitorShoriYMD() {
        return this.getMonitorJoken().getTxtMonitorShoriYMD();
    }

    @JsonIgnore
    public void  setTxtMonitorShoriYMD(TextBoxDateRange txtMonitorShoriYMD) {
        this.getMonitorJoken().setTxtMonitorShoriYMD(txtMonitorShoriYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtMonitorShinseiYMD() {
        return this.getMonitorJoken().getTxtMonitorShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtMonitorShinseiYMD(TextBoxDateRange txtMonitorShinseiYMD) {
        this.getMonitorJoken().setTxtMonitorShinseiYMD(txtMonitorShinseiYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkShinseishaIchiran() {
        return this.getShinseishaIchiranJoken().getChkShinseishaIchiran();
    }

    @JsonIgnore
    public void  setChkShinseishaIchiran(CheckBoxList chkShinseishaIchiran) {
        this.getShinseishaIchiranJoken().setChkShinseishaIchiran(chkShinseishaIchiran);
    }

    @JsonIgnore
    public Label getLblShinseishaSakuseiJoken() {
        return this.getShinseishaIchiranJoken().getLblShinseishaSakuseiJoken();
    }

    @JsonIgnore
    public void  setLblShinseishaSakuseiJoken(Label lblShinseishaSakuseiJoken) {
        this.getShinseishaIchiranJoken().setLblShinseishaSakuseiJoken(lblShinseishaSakuseiJoken);
    }

    @JsonIgnore
    public RadioButton getRadShinseishaJoken() {
        return this.getShinseishaIchiranJoken().getRadShinseishaJoken();
    }

    @JsonIgnore
    public void  setRadShinseishaJoken(RadioButton radShinseishaJoken) {
        this.getShinseishaIchiranJoken().setRadShinseishaJoken(radShinseishaJoken);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseishaShoriYMD() {
        return this.getShinseishaIchiranJoken().getTxtShinseishaShoriYMD();
    }

    @JsonIgnore
    public void  setTxtShinseishaShoriYMD(TextBoxDateRange txtShinseishaShoriYMD) {
        this.getShinseishaIchiranJoken().setTxtShinseishaShoriYMD(txtShinseishaShoriYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShinseishaShinseiYMD() {
        return this.getShinseishaIchiranJoken().getTxtShinseishaShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseishaShinseiYMD(TextBoxDateRange txtShinseishaShinseiYMD) {
        this.getShinseishaIchiranJoken().setTxtShinseishaShinseiYMD(txtShinseishaShinseiYMD);
    }

    // </editor-fold>
}
