package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * JikoFutangakuKeisanIkkatsuBatchParameter のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoFutangakuKeisanIkkatsuBatchParameterDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JikoFutangakuKeisanChushutsuJokenPanel")
    private JikoFutangakuKeisanChushutsuJokenPanelDiv JikoFutangakuKeisanChushutsuJokenPanel;
    @JsonProperty("JikoFutangakuKeisanKekkaIchiranhyoPanelPublish")
    private JikoFutangakuKeisanKekkaIchiranhyoPanelPublishDiv JikoFutangakuKeisanKekkaIchiranhyoPanelPublish;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJikoFutangakuKeisanChushutsuJokenPanel
     * @return JikoFutangakuKeisanChushutsuJokenPanel
     */
    @JsonProperty("JikoFutangakuKeisanChushutsuJokenPanel")
    public JikoFutangakuKeisanChushutsuJokenPanelDiv getJikoFutangakuKeisanChushutsuJokenPanel() {
        return JikoFutangakuKeisanChushutsuJokenPanel;
    }

    /*
     * setJikoFutangakuKeisanChushutsuJokenPanel
     * @param JikoFutangakuKeisanChushutsuJokenPanel JikoFutangakuKeisanChushutsuJokenPanel
     */
    @JsonProperty("JikoFutangakuKeisanChushutsuJokenPanel")
    public void setJikoFutangakuKeisanChushutsuJokenPanel(JikoFutangakuKeisanChushutsuJokenPanelDiv JikoFutangakuKeisanChushutsuJokenPanel) {
        this.JikoFutangakuKeisanChushutsuJokenPanel = JikoFutangakuKeisanChushutsuJokenPanel;
    }

    /*
     * getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish
     * @return JikoFutangakuKeisanKekkaIchiranhyoPanelPublish
     */
    @JsonProperty("JikoFutangakuKeisanKekkaIchiranhyoPanelPublish")
    public JikoFutangakuKeisanKekkaIchiranhyoPanelPublishDiv getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish() {
        return JikoFutangakuKeisanKekkaIchiranhyoPanelPublish;
    }

    /*
     * setJikoFutangakuKeisanKekkaIchiranhyoPanelPublish
     * @param JikoFutangakuKeisanKekkaIchiranhyoPanelPublish JikoFutangakuKeisanKekkaIchiranhyoPanelPublish
     */
    @JsonProperty("JikoFutangakuKeisanKekkaIchiranhyoPanelPublish")
    public void setJikoFutangakuKeisanKekkaIchiranhyoPanelPublish(JikoFutangakuKeisanKekkaIchiranhyoPanelPublishDiv JikoFutangakuKeisanKekkaIchiranhyoPanelPublish) {
        this.JikoFutangakuKeisanKekkaIchiranhyoPanelPublish = JikoFutangakuKeisanKekkaIchiranhyoPanelPublish;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TaishoshaKeisanPanelDiv getTaishoshaKeisanPanel() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel();
    }

    @JsonIgnore
    public void  setTaishoshaKeisanPanel(TaishoshaKeisanPanelDiv TaishoshaKeisanPanel) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().setTaishoshaKeisanPanel(TaishoshaKeisanPanel);
    }

    @JsonIgnore
    public RadioButton getRadTaishoshaKeisan() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().getRadTaishoshaKeisan();
    }

    @JsonIgnore
    public void  setRadTaishoshaKeisan(RadioButton radTaishoshaKeisan) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().setRadTaishoshaKeisan(radTaishoshaKeisan);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiUketoriYM() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().getTxtZenkaiUketoriYM();
    }

    @JsonIgnore
    public void  setTxtZenkaiUketoriYM(TextBoxDate txtZenkaiUketoriYM) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().setTxtZenkaiUketoriYM(txtZenkaiUketoriYM);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiShoriYMD() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().getTxtZenkaiShoriYMD();
    }

    @JsonIgnore
    public void  setTxtZenkaiShoriYMD(TextBox txtZenkaiShoriYMD) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().setTxtZenkaiShoriYMD(txtZenkaiShoriYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriYM() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().getTxtUketoriYM();
    }

    @JsonIgnore
    public void  setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().getTaishoshaKeisanPanel().setTxtUketoriYM(txtUketoriYM);
    }

    @JsonIgnore
    public HihokenshaNoShiteiPanelDiv getHihokenshaNoShiteiPanel() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel();
    }

    @JsonIgnore
    public void  setHihokenshaNoShiteiPanel(HihokenshaNoShiteiPanelDiv HihokenshaNoShiteiPanel) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().setHihokenshaNoShiteiPanel(HihokenshaNoShiteiPanel);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaNo() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().getRadHihokenshaNo();
    }

    @JsonIgnore
    public void  setRadHihokenshaNo(RadioButton radHihokenshaNo) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().setRadHihokenshaNo(radHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaSearch() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().getBtnHihokenshaSearch();
    }

    @JsonIgnore
    public void  setBtnHihokenshaSearch(ButtonDialog btnHihokenshaSearch) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().setBtnHihokenshaSearch(btnHihokenshaSearch);
    }

    @JsonIgnore
    public DropDownList getDdlNendo() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().getDdlNendo();
    }

    @JsonIgnore
    public void  setDdlNendo(DropDownList ddlNendo) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().getHihokenshaNoShiteiPanel().setDdlNendo(ddlNendo);
    }

    @JsonIgnore
    public Label getLbl1() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getLbl1();
    }

    @JsonIgnore
    public void  setLbl1(Label lbl1) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().setLbl1(lbl1);
    }

    @JsonIgnore
    public Label getLbl2() {
        return this.getJikoFutangakuKeisanChushutsuJokenPanel().getLbl2();
    }

    @JsonIgnore
    public void  setLbl2(Label lbl2) {
        this.getJikoFutangakuKeisanChushutsuJokenPanel().setLbl2(lbl2);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getJikoFutangakuKeisanKekkaIchiranhyoPanelPublish().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
