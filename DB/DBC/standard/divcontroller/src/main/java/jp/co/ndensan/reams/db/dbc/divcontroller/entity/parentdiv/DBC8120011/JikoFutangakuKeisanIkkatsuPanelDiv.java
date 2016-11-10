package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * JikoFutangakuKeisanIkkatsuPanel のクラスファイルです。
 *
 * @reamsid_L DBC-4790-010 chenyadong
 */
public class JikoFutangakuKeisanIkkatsuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JikoFutangakuKeisanIkkatsuBatchParameter")
    private JikoFutangakuKeisanIkkatsuBatchParameterDiv JikoFutangakuKeisanIkkatsuBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJikoFutangakuKeisanIkkatsuBatchParameter
     * @return JikoFutangakuKeisanIkkatsuBatchParameter
     */
    @JsonProperty("JikoFutangakuKeisanIkkatsuBatchParameter")
    public JikoFutangakuKeisanIkkatsuBatchParameterDiv getJikoFutangakuKeisanIkkatsuBatchParameter() {
        return JikoFutangakuKeisanIkkatsuBatchParameter;
    }

    /*
     * setJikoFutangakuKeisanIkkatsuBatchParameter
     * @param JikoFutangakuKeisanIkkatsuBatchParameter JikoFutangakuKeisanIkkatsuBatchParameter
     */
    @JsonProperty("JikoFutangakuKeisanIkkatsuBatchParameter")
    public void setJikoFutangakuKeisanIkkatsuBatchParameter(JikoFutangakuKeisanIkkatsuBatchParameterDiv JikoFutangakuKeisanIkkatsuBatchParameter) {
        this.JikoFutangakuKeisanIkkatsuBatchParameter = JikoFutangakuKeisanIkkatsuBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public JikoFutangakuKeisanChushutsuJokenPanelDiv getJikoFutangakuKeisanChushutsuJokenPanel() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel();
    }

    @JsonIgnore
    public void setJikoFutangakuKeisanChushutsuJokenPanel(JikoFutangakuKeisanChushutsuJokenPanelDiv JikoFutangakuKeisanChushutsuJokenPanel) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().setJikoFutangakuKeisanChushutsuJokenPanel(JikoFutangakuKeisanChushutsuJokenPanel);
    }

    @JsonIgnore
    public TaishoshaKeisanPanelDiv getTaishoshaKeisanPanel() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel();
    }

    @JsonIgnore
    public void setTaishoshaKeisanPanel(TaishoshaKeisanPanelDiv TaishoshaKeisanPanel) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().setTaishoshaKeisanPanel(TaishoshaKeisanPanel);
    }

    @JsonIgnore
    public RadioButton getRadTaishoshaKeisan() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().getRadTaishoshaKeisan();
    }

    @JsonIgnore
    public void setRadTaishoshaKeisan(RadioButton radTaishoshaKeisan) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().setRadTaishoshaKeisan(radTaishoshaKeisan);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiUketoriYM() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().getTxtZenkaiUketoriYM();
    }

    @JsonIgnore
    public void setTxtZenkaiUketoriYM(TextBoxDate txtZenkaiUketoriYM) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().setTxtZenkaiUketoriYM(txtZenkaiUketoriYM);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiShoriYMD() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().getTxtZenkaiShoriYMD();
    }

    @JsonIgnore
    public void setTxtZenkaiShoriYMD(TextBox txtZenkaiShoriYMD) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().setTxtZenkaiShoriYMD(txtZenkaiShoriYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriYM() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().getTxtUketoriYM();
    }

    @JsonIgnore
    public void setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().setTxtUketoriYM(txtUketoriYM);
    }

    @JsonIgnore
    public HihokenshaNoShiteiPanelDiv getHihokenshaNoShiteiPanel() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel();
    }

    @JsonIgnore
    public void setHihokenshaNoShiteiPanel(HihokenshaNoShiteiPanelDiv HihokenshaNoShiteiPanel) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().setHihokenshaNoShiteiPanel(HihokenshaNoShiteiPanel);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaNo() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().getRadHihokenshaNo();
    }

    @JsonIgnore
    public void setRadHihokenshaNo(RadioButton radHihokenshaNo) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().setRadHihokenshaNo(radHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public Button getBtnSearchHihokensha() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().getBtnSearchHihokensha();
    }

    @JsonIgnore
    public void setBtnSearchHihokensha(Button btnSearchHihokensha) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().setBtnSearchHihokensha(btnSearchHihokensha);
    }

    @JsonIgnore
    public DropDownList getDdlNendo() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().getDdlNendo();
    }

    @JsonIgnore
    public void setDdlNendo(DropDownList ddlNendo) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().setDdlNendo(ddlNendo);
    }

    @JsonIgnore
    public Label getLbl1() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getLbl1();
    }

    @JsonIgnore
    public void setLbl1(Label lbl1) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().setLbl1(lbl1);
    }

    @JsonIgnore
    public Label getLbl2() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().getLbl2();
    }

    @JsonIgnore
    public void setLbl2(Label lbl2) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanChushutsuJokenPanel().setLbl2(lbl2);
    }

    @JsonIgnore
    public JikoFutangakuKeisanKekkaIchiranhyoPanelPublishDiv getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish();
    }

    @JsonIgnore
    public void setJikoFutangakuKeisanKekkaIchiranhyoPanelPublish(JikoFutangakuKeisanKekkaIchiranhyoPanelPublishDiv JikoFutangakuKeisanKekkaIchiranhyoPanelPublish) {
        this.getJikoFutangakuKeisanIkkatsuBatchParameter().setJikoFutangakuKeisanKekkaIchiranhyoPanelPublish(JikoFutangakuKeisanKekkaIchiranhyoPanelPublish);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getJikoFutangakuKeisanIkkatsuBatchParameter().getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
