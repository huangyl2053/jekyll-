package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8120011;
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
 * JikoFutangakuKeisanChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoFutangakuKeisanChushutsuJokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TaishoshaKeisanPanel")
    private TaishoshaKeisanPanelDiv TaishoshaKeisanPanel;
    @JsonProperty("HihokenshaNoShiteiPanel")
    private HihokenshaNoShiteiPanelDiv HihokenshaNoShiteiPanel;
    @JsonProperty("lbl1")
    private Label lbl1;
    @JsonProperty("lbl2")
    private Label lbl2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTaishoshaKeisanPanel
     * @return TaishoshaKeisanPanel
     */
    @JsonProperty("TaishoshaKeisanPanel")
    public TaishoshaKeisanPanelDiv getTaishoshaKeisanPanel() {
        return TaishoshaKeisanPanel;
    }

    /*
     * setTaishoshaKeisanPanel
     * @param TaishoshaKeisanPanel TaishoshaKeisanPanel
     */
    @JsonProperty("TaishoshaKeisanPanel")
    public void setTaishoshaKeisanPanel(TaishoshaKeisanPanelDiv TaishoshaKeisanPanel) {
        this.TaishoshaKeisanPanel = TaishoshaKeisanPanel;
    }

    /*
     * getHihokenshaNoShiteiPanel
     * @return HihokenshaNoShiteiPanel
     */
    @JsonProperty("HihokenshaNoShiteiPanel")
    public HihokenshaNoShiteiPanelDiv getHihokenshaNoShiteiPanel() {
        return HihokenshaNoShiteiPanel;
    }

    /*
     * setHihokenshaNoShiteiPanel
     * @param HihokenshaNoShiteiPanel HihokenshaNoShiteiPanel
     */
    @JsonProperty("HihokenshaNoShiteiPanel")
    public void setHihokenshaNoShiteiPanel(HihokenshaNoShiteiPanelDiv HihokenshaNoShiteiPanel) {
        this.HihokenshaNoShiteiPanel = HihokenshaNoShiteiPanel;
    }

    /*
     * getlbl1
     * @return lbl1
     */
    @JsonProperty("lbl1")
    public Label getLbl1() {
        return lbl1;
    }

    /*
     * setlbl1
     * @param lbl1 lbl1
     */
    @JsonProperty("lbl1")
    public void setLbl1(Label lbl1) {
        this.lbl1 = lbl1;
    }

    /*
     * getlbl2
     * @return lbl2
     */
    @JsonProperty("lbl2")
    public Label getLbl2() {
        return lbl2;
    }

    /*
     * setlbl2
     * @param lbl2 lbl2
     */
    @JsonProperty("lbl2")
    public void setLbl2(Label lbl2) {
        this.lbl2 = lbl2;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTaishoshaKeisan() {
        return this.getTaishoshaKeisanPanel().getRadTaishoshaKeisan();
    }

    @JsonIgnore
    public void  setRadTaishoshaKeisan(RadioButton radTaishoshaKeisan) {
        this.getTaishoshaKeisanPanel().setRadTaishoshaKeisan(radTaishoshaKeisan);
    }

    @JsonIgnore
    public TextBoxDate getTxtZenkaiUketoriYM() {
        return this.getTaishoshaKeisanPanel().getTxtZenkaiUketoriYM();
    }

    @JsonIgnore
    public void  setTxtZenkaiUketoriYM(TextBoxDate txtZenkaiUketoriYM) {
        this.getTaishoshaKeisanPanel().setTxtZenkaiUketoriYM(txtZenkaiUketoriYM);
    }

    @JsonIgnore
    public TextBox getTxtZenkaiShoriYMD() {
        return this.getTaishoshaKeisanPanel().getTxtZenkaiShoriYMD();
    }

    @JsonIgnore
    public void  setTxtZenkaiShoriYMD(TextBox txtZenkaiShoriYMD) {
        this.getTaishoshaKeisanPanel().setTxtZenkaiShoriYMD(txtZenkaiShoriYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriYM() {
        return this.getTaishoshaKeisanPanel().getTxtUketoriYM();
    }

    @JsonIgnore
    public void  setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.getTaishoshaKeisanPanel().setTxtUketoriYM(txtUketoriYM);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaNo() {
        return this.getHihokenshaNoShiteiPanel().getRadHihokenshaNo();
    }

    @JsonIgnore
    public void  setRadHihokenshaNo(RadioButton radHihokenshaNo) {
        this.getHihokenshaNoShiteiPanel().setRadHihokenshaNo(radHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getHihokenshaNoShiteiPanel().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getHihokenshaNoShiteiPanel().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaSearch() {
        return this.getHihokenshaNoShiteiPanel().getBtnHihokenshaSearch();
    }

    @JsonIgnore
    public void  setBtnHihokenshaSearch(ButtonDialog btnHihokenshaSearch) {
        this.getHihokenshaNoShiteiPanel().setBtnHihokenshaSearch(btnHihokenshaSearch);
    }

    @JsonIgnore
    public DropDownList getDdlNendo() {
        return this.getHihokenshaNoShiteiPanel().getDdlNendo();
    }

    @JsonIgnore
    public void  setDdlNendo(DropDownList ddlNendo) {
        this.getHihokenshaNoShiteiPanel().setDdlNendo(ddlNendo);
    }

    // </editor-fold>
}
