package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0110003;
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
 * HakkoJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class HakkoJokenDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteiChosaYoteiMiteishaIchiranJoken")
    private NinteiChosaYoteiMiteishaIchiranJokenDiv NinteiChosaYoteiMiteishaIchiranJoken;
    @JsonProperty("NinteiChosaIraisakiHenkoshaIchiranhyoJoken")
    private NinteiChosaIraisakiHenkoshaIchiranhyoJokenDiv NinteiChosaIraisakiHenkoshaIchiranhyoJoken;
    @JsonProperty("NinteiChosaKekkaShujiiIkenshoCheckListJoken")
    private NinteiChosaKekkaShujiiIkenshoCheckListJokenDiv NinteiChosaKekkaShujiiIkenshoCheckListJoken;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteiChosaYoteiMiteishaIchiranJoken
     * @return NinteiChosaYoteiMiteishaIchiranJoken
     */
    @JsonProperty("NinteiChosaYoteiMiteishaIchiranJoken")
    public NinteiChosaYoteiMiteishaIchiranJokenDiv getNinteiChosaYoteiMiteishaIchiranJoken() {
        return NinteiChosaYoteiMiteishaIchiranJoken;
    }

    /*
     * setNinteiChosaYoteiMiteishaIchiranJoken
     * @param NinteiChosaYoteiMiteishaIchiranJoken NinteiChosaYoteiMiteishaIchiranJoken
     */
    @JsonProperty("NinteiChosaYoteiMiteishaIchiranJoken")
    public void setNinteiChosaYoteiMiteishaIchiranJoken(NinteiChosaYoteiMiteishaIchiranJokenDiv NinteiChosaYoteiMiteishaIchiranJoken) {
        this.NinteiChosaYoteiMiteishaIchiranJoken = NinteiChosaYoteiMiteishaIchiranJoken;
    }

    /*
     * getNinteiChosaIraisakiHenkoshaIchiranhyoJoken
     * @return NinteiChosaIraisakiHenkoshaIchiranhyoJoken
     */
    @JsonProperty("NinteiChosaIraisakiHenkoshaIchiranhyoJoken")
    public NinteiChosaIraisakiHenkoshaIchiranhyoJokenDiv getNinteiChosaIraisakiHenkoshaIchiranhyoJoken() {
        return NinteiChosaIraisakiHenkoshaIchiranhyoJoken;
    }

    /*
     * setNinteiChosaIraisakiHenkoshaIchiranhyoJoken
     * @param NinteiChosaIraisakiHenkoshaIchiranhyoJoken NinteiChosaIraisakiHenkoshaIchiranhyoJoken
     */
    @JsonProperty("NinteiChosaIraisakiHenkoshaIchiranhyoJoken")
    public void setNinteiChosaIraisakiHenkoshaIchiranhyoJoken(NinteiChosaIraisakiHenkoshaIchiranhyoJokenDiv NinteiChosaIraisakiHenkoshaIchiranhyoJoken) {
        this.NinteiChosaIraisakiHenkoshaIchiranhyoJoken = NinteiChosaIraisakiHenkoshaIchiranhyoJoken;
    }

    /*
     * getNinteiChosaKekkaShujiiIkenshoCheckListJoken
     * @return NinteiChosaKekkaShujiiIkenshoCheckListJoken
     */
    @JsonProperty("NinteiChosaKekkaShujiiIkenshoCheckListJoken")
    public NinteiChosaKekkaShujiiIkenshoCheckListJokenDiv getNinteiChosaKekkaShujiiIkenshoCheckListJoken() {
        return NinteiChosaKekkaShujiiIkenshoCheckListJoken;
    }

    /*
     * setNinteiChosaKekkaShujiiIkenshoCheckListJoken
     * @param NinteiChosaKekkaShujiiIkenshoCheckListJoken NinteiChosaKekkaShujiiIkenshoCheckListJoken
     */
    @JsonProperty("NinteiChosaKekkaShujiiIkenshoCheckListJoken")
    public void setNinteiChosaKekkaShujiiIkenshoCheckListJoken(NinteiChosaKekkaShujiiIkenshoCheckListJokenDiv NinteiChosaKekkaShujiiIkenshoCheckListJoken) {
        this.NinteiChosaKekkaShujiiIkenshoCheckListJoken = NinteiChosaKekkaShujiiIkenshoCheckListJoken;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkNinteiChosaYoteiMiteishaIchiran() {
        return this.getNinteiChosaYoteiMiteishaIchiranJoken().getChkNinteiChosaYoteiMiteishaIchiran();
    }

    @JsonIgnore
    public void  setChkNinteiChosaYoteiMiteishaIchiran(CheckBoxList chkNinteiChosaYoteiMiteishaIchiran) {
        this.getNinteiChosaYoteiMiteishaIchiranJoken().setChkNinteiChosaYoteiMiteishaIchiran(chkNinteiChosaYoteiMiteishaIchiran);
    }

    @JsonIgnore
    public Label getLblJoken1() {
        return this.getNinteiChosaYoteiMiteishaIchiranJoken().getLblJoken1();
    }

    @JsonIgnore
    public void  setLblJoken1(Label lblJoken1) {
        this.getNinteiChosaYoteiMiteishaIchiranJoken().setLblJoken1(lblJoken1);
    }

    @JsonIgnore
    public RadioButton getRadJoken1() {
        return this.getNinteiChosaYoteiMiteishaIchiranJoken().getRadJoken1();
    }

    @JsonIgnore
    public void  setRadJoken1(RadioButton radJoken1) {
        this.getNinteiChosaYoteiMiteishaIchiranJoken().setRadJoken1(radJoken1);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtYoteiMiteishaShinseiYMD() {
        return this.getNinteiChosaYoteiMiteishaIchiranJoken().getTxtYoteiMiteishaShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtYoteiMiteishaShinseiYMD(TextBoxDateRange txtYoteiMiteishaShinseiYMD) {
        this.getNinteiChosaYoteiMiteishaIchiranJoken().setTxtYoteiMiteishaShinseiYMD(txtYoteiMiteishaShinseiYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaIraisakiHenkoshaIchiranhyoJoken() {
        return this.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getChkNinteiChosaIraisakiHenkoshaIchiranhyoJoken();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIraisakiHenkoshaIchiranhyoJoken(CheckBoxList chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken) {
        this.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().setChkNinteiChosaIraisakiHenkoshaIchiranhyoJoken(chkNinteiChosaIraisakiHenkoshaIchiranhyoJoken);
    }

    @JsonIgnore
    public Label getLblJoken2() {
        return this.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getLblJoken2();
    }

    @JsonIgnore
    public void  setLblJoken2(Label lblJoken2) {
        this.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().setLblJoken2(lblJoken2);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtIraisakiHenkoshaIchiranShinseiYMD() {
        return this.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().getTxtIraisakiHenkoshaIchiranShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtIraisakiHenkoshaIchiranShinseiYMD(TextBoxDateRange txtIraisakiHenkoshaIchiranShinseiYMD) {
        this.getNinteiChosaIraisakiHenkoshaIchiranhyoJoken().setTxtIraisakiHenkoshaIchiranShinseiYMD(txtIraisakiHenkoshaIchiranShinseiYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaKekkaShujiiIkenshoCheckListJoken() {
        return this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getChkNinteiChosaKekkaShujiiIkenshoCheckListJoken();
    }

    @JsonIgnore
    public void  setChkNinteiChosaKekkaShujiiIkenshoCheckListJoken(CheckBoxList chkNinteiChosaKekkaShujiiIkenshoCheckListJoken) {
        this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().setChkNinteiChosaKekkaShujiiIkenshoCheckListJoken(chkNinteiChosaKekkaShujiiIkenshoCheckListJoken);
    }

    @JsonIgnore
    public Label getLblJoken3() {
        return this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getLblJoken3();
    }

    @JsonIgnore
    public void  setLblJoken3(Label lblJoken3) {
        this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().setLblJoken3(lblJoken3);
    }

    @JsonIgnore
    public RadioButton getRadJoken3() {
        return this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getRadJoken3();
    }

    @JsonIgnore
    public void  setRadJoken3(RadioButton radJoken3) {
        this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().setRadJoken3(radJoken3);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtCheckListShinseiYMD() {
        return this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtCheckListShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtCheckListShinseiYMD(TextBoxDateRange txtCheckListShinseiYMD) {
        this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().setTxtCheckListShinseiYMD(txtCheckListShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaYMD() {
        return this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsaYMD();
    }

    @JsonIgnore
    public void  setTxtShinsaYMD(TextBoxDate txtShinsaYMD) {
        this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().setTxtShinsaYMD(txtShinsaYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtShinsakai() {
        return this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().getTxtShinsakai();
    }

    @JsonIgnore
    public void  setTxtShinsakai(TextBoxNum txtShinsakai) {
        this.getNinteiChosaKekkaShujiiIkenshoCheckListJoken().setTxtShinsakai(txtShinsakai);
    }

    // </editor-fold>
}
