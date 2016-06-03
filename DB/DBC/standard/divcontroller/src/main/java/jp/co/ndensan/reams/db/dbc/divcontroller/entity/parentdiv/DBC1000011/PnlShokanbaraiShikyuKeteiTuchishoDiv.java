package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlShokanbaraiShikyuKeteiTuchisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlShokanbaraiShikyuKeteiTuchishoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHakkobi")
    private TextBoxDate txtHakkobi;
    @JsonProperty("txtBunshoNo")
    private TextBox txtBunshoNo;
    @JsonProperty("lblHakkoShijiMsg")
    private Label lblHakkoShijiMsg;
    @JsonProperty("PnlTestOutput")
    private PnlTestOutputDiv PnlTestOutput;
    @JsonProperty("PnlOutputTarget")
    private PnlOutputTargetDiv PnlOutputTarget;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHakkobi
     * @return txtHakkobi
     */
    @JsonProperty("txtHakkobi")
    public TextBoxDate getTxtHakkobi() {
        return txtHakkobi;
    }

    /*
     * settxtHakkobi
     * @param txtHakkobi txtHakkobi
     */
    @JsonProperty("txtHakkobi")
    public void setTxtHakkobi(TextBoxDate txtHakkobi) {
        this.txtHakkobi = txtHakkobi;
    }

    /*
     * gettxtBunshoNo
     * @return txtBunshoNo
     */
    @JsonProperty("txtBunshoNo")
    public TextBox getTxtBunshoNo() {
        return txtBunshoNo;
    }

    /*
     * settxtBunshoNo
     * @param txtBunshoNo txtBunshoNo
     */
    @JsonProperty("txtBunshoNo")
    public void setTxtBunshoNo(TextBox txtBunshoNo) {
        this.txtBunshoNo = txtBunshoNo;
    }

    /*
     * getlblHakkoShijiMsg
     * @return lblHakkoShijiMsg
     */
    @JsonProperty("lblHakkoShijiMsg")
    public Label getLblHakkoShijiMsg() {
        return lblHakkoShijiMsg;
    }

    /*
     * setlblHakkoShijiMsg
     * @param lblHakkoShijiMsg lblHakkoShijiMsg
     */
    @JsonProperty("lblHakkoShijiMsg")
    public void setLblHakkoShijiMsg(Label lblHakkoShijiMsg) {
        this.lblHakkoShijiMsg = lblHakkoShijiMsg;
    }

    /*
     * getPnlTestOutput
     * @return PnlTestOutput
     */
    @JsonProperty("PnlTestOutput")
    public PnlTestOutputDiv getPnlTestOutput() {
        return PnlTestOutput;
    }

    /*
     * setPnlTestOutput
     * @param PnlTestOutput PnlTestOutput
     */
    @JsonProperty("PnlTestOutput")
    public void setPnlTestOutput(PnlTestOutputDiv PnlTestOutput) {
        this.PnlTestOutput = PnlTestOutput;
    }

    /*
     * getPnlOutputTarget
     * @return PnlOutputTarget
     */
    @JsonProperty("PnlOutputTarget")
    public PnlOutputTargetDiv getPnlOutputTarget() {
        return PnlOutputTarget;
    }

    /*
     * setPnlOutputTarget
     * @param PnlOutputTarget PnlOutputTarget
     */
    @JsonProperty("PnlOutputTarget")
    public void setPnlOutputTarget(PnlOutputTargetDiv PnlOutputTarget) {
        this.PnlOutputTarget = PnlOutputTarget;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkTestShutsuryoku() {
        return this.getPnlTestOutput().getChkTestShutsuryoku();
    }

    @JsonIgnore
    public void  setChkTestShutsuryoku(CheckBoxList chkTestShutsuryoku) {
        this.getPnlTestOutput().setChkTestShutsuryoku(chkTestShutsuryoku);
    }

    @JsonIgnore
    public RadioButton getRadKeteibiIkatsuKoushinnKubun() {
        return this.getPnlTestOutput().getRadKeteibiIkatsuKoushinnKubun();
    }

    @JsonIgnore
    public void  setRadKeteibiIkatsuKoushinnKubun(RadioButton radKeteibiIkatsuKoushinnKubun) {
        this.getPnlTestOutput().setRadKeteibiIkatsuKoushinnKubun(radKeteibiIkatsuKoushinnKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtKeteibiTuchisho() {
        return this.getPnlTestOutput().getTxtKeteibiTuchisho();
    }

    @JsonIgnore
    public void  setTxtKeteibiTuchisho(TextBoxDate txtKeteibiTuchisho) {
        this.getPnlTestOutput().setTxtKeteibiTuchisho(txtKeteibiTuchisho);
    }

    @JsonIgnore
    public CheckBoxList getChkOutputTargetKubun() {
        return this.getPnlOutputTarget().getChkOutputTargetKubun();
    }

    @JsonIgnore
    public void  setChkOutputTargetKubun(CheckBoxList chkOutputTargetKubun) {
        this.getPnlOutputTarget().setChkOutputTargetKubun(chkOutputTargetKubun);
    }

    // </editor-fold>
}
