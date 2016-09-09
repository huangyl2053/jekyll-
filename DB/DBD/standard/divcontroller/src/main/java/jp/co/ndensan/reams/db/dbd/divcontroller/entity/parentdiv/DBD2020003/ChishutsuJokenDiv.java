package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD2020003;
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
 * ChishutsuJoken のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChishutsuJokenDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblHanteiKijun")
    private Label lblHanteiKijun;
    @JsonProperty("txtKijunbi")
    private TextBoxFlexibleDate txtKijunbi;
    @JsonProperty("linKijunbi")
    private HorizontalLine linKijunbi;
    @JsonProperty("JIkoKisanbiJoken")
    private JIkoKisanbiJokenDiv JIkoKisanbiJoken;
    @JsonProperty("ShosaiJoken")
    private ShosaiJokenDiv ShosaiJoken;
    @JsonProperty("chkHokenKannoshaShutsuryoku")
    private CheckBoxList chkHokenKannoshaShutsuryoku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblHanteiKijun
     * @return lblHanteiKijun
     */
    @JsonProperty("lblHanteiKijun")
    public Label getLblHanteiKijun() {
        return lblHanteiKijun;
    }

    /*
     * setlblHanteiKijun
     * @param lblHanteiKijun lblHanteiKijun
     */
    @JsonProperty("lblHanteiKijun")
    public void setLblHanteiKijun(Label lblHanteiKijun) {
        this.lblHanteiKijun = lblHanteiKijun;
    }

    /*
     * gettxtKijunbi
     * @return txtKijunbi
     */
    @JsonProperty("txtKijunbi")
    public TextBoxFlexibleDate getTxtKijunbi() {
        return txtKijunbi;
    }

    /*
     * settxtKijunbi
     * @param txtKijunbi txtKijunbi
     */
    @JsonProperty("txtKijunbi")
    public void setTxtKijunbi(TextBoxFlexibleDate txtKijunbi) {
        this.txtKijunbi = txtKijunbi;
    }

    /*
     * getlinKijunbi
     * @return linKijunbi
     */
    @JsonProperty("linKijunbi")
    public HorizontalLine getLinKijunbi() {
        return linKijunbi;
    }

    /*
     * setlinKijunbi
     * @param linKijunbi linKijunbi
     */
    @JsonProperty("linKijunbi")
    public void setLinKijunbi(HorizontalLine linKijunbi) {
        this.linKijunbi = linKijunbi;
    }

    /*
     * getJIkoKisanbiJoken
     * @return JIkoKisanbiJoken
     */
    @JsonProperty("JIkoKisanbiJoken")
    public JIkoKisanbiJokenDiv getJIkoKisanbiJoken() {
        return JIkoKisanbiJoken;
    }

    /*
     * setJIkoKisanbiJoken
     * @param JIkoKisanbiJoken JIkoKisanbiJoken
     */
    @JsonProperty("JIkoKisanbiJoken")
    public void setJIkoKisanbiJoken(JIkoKisanbiJokenDiv JIkoKisanbiJoken) {
        this.JIkoKisanbiJoken = JIkoKisanbiJoken;
    }

    /*
     * getShosaiJoken
     * @return ShosaiJoken
     */
    @JsonProperty("ShosaiJoken")
    public ShosaiJokenDiv getShosaiJoken() {
        return ShosaiJoken;
    }

    /*
     * setShosaiJoken
     * @param ShosaiJoken ShosaiJoken
     */
    @JsonProperty("ShosaiJoken")
    public void setShosaiJoken(ShosaiJokenDiv ShosaiJoken) {
        this.ShosaiJoken = ShosaiJoken;
    }

    /*
     * getchkHokenKannoshaShutsuryoku
     * @return chkHokenKannoshaShutsuryoku
     */
    @JsonProperty("chkHokenKannoshaShutsuryoku")
    public CheckBoxList getChkHokenKannoshaShutsuryoku() {
        return chkHokenKannoshaShutsuryoku;
    }

    /*
     * setchkHokenKannoshaShutsuryoku
     * @param chkHokenKannoshaShutsuryoku chkHokenKannoshaShutsuryoku
     */
    @JsonProperty("chkHokenKannoshaShutsuryoku")
    public void setChkHokenKannoshaShutsuryoku(CheckBoxList chkHokenKannoshaShutsuryoku) {
        this.chkHokenKannoshaShutsuryoku = chkHokenKannoshaShutsuryoku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadJikoKisanbiTorokushaNomi() {
        return this.getJIkoKisanbiJoken().getRadJikoKisanbiTorokushaNomi();
    }

    @JsonIgnore
    public void  setRadJikoKisanbiTorokushaNomi(RadioButton radJikoKisanbiTorokushaNomi) {
        this.getJIkoKisanbiJoken().setRadJikoKisanbiTorokushaNomi(radJikoKisanbiTorokushaNomi);
    }

    @JsonIgnore
    public RadioButton getRadJikoKisanbiTorokushaIgai() {
        return this.getJIkoKisanbiJoken().getRadJikoKisanbiTorokushaIgai();
    }

    @JsonIgnore
    public void  setRadJikoKisanbiTorokushaIgai(RadioButton radJikoKisanbiTorokushaIgai) {
        this.getJIkoKisanbiJoken().setRadJikoKisanbiTorokushaIgai(radJikoKisanbiTorokushaIgai);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaZenin() {
        return this.getShosaiJoken().getRadHihokenshaZenin();
    }

    @JsonIgnore
    public void  setRadHihokenshaZenin(RadioButton radHihokenshaZenin) {
        this.getShosaiJoken().setRadHihokenshaZenin(radHihokenshaZenin);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaIgai() {
        return this.getShosaiJoken().getRadHihokenshaIgai();
    }

    @JsonIgnore
    public void  setRadHihokenshaIgai(RadioButton radHihokenshaIgai) {
        this.getShosaiJoken().setRadHihokenshaIgai(radHihokenshaIgai);
    }

    @JsonIgnore
    public JukyushaJokenDiv getJukyushaJoken() {
        return this.getShosaiJoken().getJukyushaJoken();
    }

    @JsonIgnore
    public void  setJukyushaJoken(JukyushaJokenDiv JukyushaJoken) {
        this.getShosaiJoken().setJukyushaJoken(JukyushaJoken);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyushaZenin() {
        return this.getShosaiJoken().getJukyushaJoken().getChkJukyushaZenin();
    }

    @JsonIgnore
    public void  setChkJukyushaZenin(CheckBoxList chkJukyushaZenin) {
        this.getShosaiJoken().getJukyushaJoken().setChkJukyushaZenin(chkJukyushaZenin);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyuNinteiShinseityusha() {
        return this.getShosaiJoken().getJukyushaJoken().getChkJukyuNinteiShinseityusha();
    }

    @JsonIgnore
    public void  setChkJukyuNinteiShinseityusha(CheckBoxList chkJukyuNinteiShinseityusha) {
        this.getShosaiJoken().getJukyushaJoken().setChkJukyuNinteiShinseityusha(chkJukyuNinteiShinseityusha);
    }

    @JsonIgnore
    public CheckBoxList getChkJukyuNinteibiChushutsu() {
        return this.getShosaiJoken().getJukyushaJoken().getChkJukyuNinteibiChushutsu();
    }

    @JsonIgnore
    public void  setChkJukyuNinteibiChushutsu(CheckBoxList chkJukyuNinteibiChushutsu) {
        this.getShosaiJoken().getJukyushaJoken().setChkJukyuNinteibiChushutsu(chkJukyuNinteibiChushutsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJukyuNinteibiKaishi() {
        return this.getShosaiJoken().getJukyushaJoken().getTxtJukyuNinteibiKaishi();
    }

    @JsonIgnore
    public void  setTxtJukyuNinteibiKaishi(TextBoxFlexibleDate txtJukyuNinteibiKaishi) {
        this.getShosaiJoken().getJukyushaJoken().setTxtJukyuNinteibiKaishi(txtJukyuNinteibiKaishi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJukyuNinteibiShuryo() {
        return this.getShosaiJoken().getJukyushaJoken().getTxtJukyuNinteibiShuryo();
    }

    @JsonIgnore
    public void  setTxtJukyuNinteibiShuryo(TextBoxFlexibleDate txtJukyuNinteibiShuryo) {
        this.getShosaiJoken().getJukyushaJoken().setTxtJukyuNinteibiShuryo(txtJukyuNinteibiShuryo);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiYukoShuryobiChushutsu() {
        return this.getShosaiJoken().getJukyushaJoken().getChkNinteiYukoShuryobiChushutsu();
    }

    @JsonIgnore
    public void  setChkNinteiYukoShuryobiChushutsu(CheckBoxList chkNinteiYukoShuryobiChushutsu) {
        this.getShosaiJoken().getJukyushaJoken().setChkNinteiYukoShuryobiChushutsu(chkNinteiYukoShuryobiChushutsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoShuryobiKaishi() {
        return this.getShosaiJoken().getJukyushaJoken().getTxtNinteiYukoShuryobiKaishi();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoShuryobiKaishi(TextBoxFlexibleDate txtNinteiYukoShuryobiKaishi) {
        this.getShosaiJoken().getJukyushaJoken().setTxtNinteiYukoShuryobiKaishi(txtNinteiYukoShuryobiKaishi);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYukoShuryobiShuryo() {
        return this.getShosaiJoken().getJukyushaJoken().getTxtNinteiYukoShuryobiShuryo();
    }

    @JsonIgnore
    public void  setTxtNinteiYukoShuryobiShuryo(TextBoxFlexibleDate txtNinteiYukoShuryobiShuryo) {
        this.getShosaiJoken().getJukyushaJoken().setTxtNinteiYukoShuryobiShuryo(txtNinteiYukoShuryobiShuryo);
    }

    // </editor-fold>
}
