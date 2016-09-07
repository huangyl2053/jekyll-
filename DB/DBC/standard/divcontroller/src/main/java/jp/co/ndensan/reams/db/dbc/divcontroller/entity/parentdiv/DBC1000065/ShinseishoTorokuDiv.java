package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000065;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * ShinseishoToroku のクラスファイル
 *
 * @reamsid_L DBC-4640-010 qinzhen
 */
public class ShinseishoTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken")
    private ChushutsuJokenDiv ChushutsuJoken;
    @JsonProperty("ChushutsuJoken2")
    private ChushutsuJoken2Div ChushutsuJoken2;
    @JsonProperty("HaakuKijunbiAndTeishutsuKigen")
    private HaakuKijunbiAndTeishutsuKigenDiv HaakuKijunbiAndTeishutsuKigen;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("lblShutsuryokuTaisho")
    private Label lblShutsuryokuTaisho;
    @JsonProperty("txtSakuseiYMD")
    private TextBoxFlexibleDate txtSakuseiYMD;
    @JsonProperty("chkShinseisho")
    private CheckBoxList chkShinseisho;
    @JsonProperty("chkTsuchisho")
    private CheckBoxList chkTsuchisho;
    @JsonProperty("chkIchiranhyoCsv")
    private CheckBoxList chkIchiranhyoCsv;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("ccdBunshoBangoInput")
    private BunshoBangoInputDiv ccdBunshoBangoInput;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJoken
     * @return ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public ChushutsuJokenDiv getChushutsuJoken() {
        return ChushutsuJoken;
    }

    /*
     * setChushutsuJoken
     * @param ChushutsuJoken ChushutsuJoken
     */
    @JsonProperty("ChushutsuJoken")
    public void setChushutsuJoken(ChushutsuJokenDiv ChushutsuJoken) {
        this.ChushutsuJoken = ChushutsuJoken;
    }

    /*
     * getChushutsuJoken2
     * @return ChushutsuJoken2
     */
    @JsonProperty("ChushutsuJoken2")
    public ChushutsuJoken2Div getChushutsuJoken2() {
        return ChushutsuJoken2;
    }

    /*
     * setChushutsuJoken2
     * @param ChushutsuJoken2 ChushutsuJoken2
     */
    @JsonProperty("ChushutsuJoken2")
    public void setChushutsuJoken2(ChushutsuJoken2Div ChushutsuJoken2) {
        this.ChushutsuJoken2 = ChushutsuJoken2;
    }

    /*
     * getHaakuKijunbiAndTeishutsuKigen
     * @return HaakuKijunbiAndTeishutsuKigen
     */
    @JsonProperty("HaakuKijunbiAndTeishutsuKigen")
    public HaakuKijunbiAndTeishutsuKigenDiv getHaakuKijunbiAndTeishutsuKigen() {
        return HaakuKijunbiAndTeishutsuKigen;
    }

    /*
     * setHaakuKijunbiAndTeishutsuKigen
     * @param HaakuKijunbiAndTeishutsuKigen HaakuKijunbiAndTeishutsuKigen
     */
    @JsonProperty("HaakuKijunbiAndTeishutsuKigen")
    public void setHaakuKijunbiAndTeishutsuKigen(HaakuKijunbiAndTeishutsuKigenDiv HaakuKijunbiAndTeishutsuKigen) {
        this.HaakuKijunbiAndTeishutsuKigen = HaakuKijunbiAndTeishutsuKigen;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getlblShutsuryokuTaisho
     * @return lblShutsuryokuTaisho
     */
    @JsonProperty("lblShutsuryokuTaisho")
    public Label getLblShutsuryokuTaisho() {
        return lblShutsuryokuTaisho;
    }

    /*
     * setlblShutsuryokuTaisho
     * @param lblShutsuryokuTaisho lblShutsuryokuTaisho
     */
    @JsonProperty("lblShutsuryokuTaisho")
    public void setLblShutsuryokuTaisho(Label lblShutsuryokuTaisho) {
        this.lblShutsuryokuTaisho = lblShutsuryokuTaisho;
    }

    /*
     * gettxtSakuseiYMD
     * @return txtSakuseiYMD
     */
    @JsonProperty("txtSakuseiYMD")
    public TextBoxFlexibleDate getTxtSakuseiYMD() {
        return txtSakuseiYMD;
    }

    /*
     * settxtSakuseiYMD
     * @param txtSakuseiYMD txtSakuseiYMD
     */
    @JsonProperty("txtSakuseiYMD")
    public void setTxtSakuseiYMD(TextBoxFlexibleDate txtSakuseiYMD) {
        this.txtSakuseiYMD = txtSakuseiYMD;
    }

    /*
     * getchkShinseisho
     * @return chkShinseisho
     */
    @JsonProperty("chkShinseisho")
    public CheckBoxList getChkShinseisho() {
        return chkShinseisho;
    }

    /*
     * setchkShinseisho
     * @param chkShinseisho chkShinseisho
     */
    @JsonProperty("chkShinseisho")
    public void setChkShinseisho(CheckBoxList chkShinseisho) {
        this.chkShinseisho = chkShinseisho;
    }

    /*
     * getchkTsuchisho
     * @return chkTsuchisho
     */
    @JsonProperty("chkTsuchisho")
    public CheckBoxList getChkTsuchisho() {
        return chkTsuchisho;
    }

    /*
     * setchkTsuchisho
     * @param chkTsuchisho chkTsuchisho
     */
    @JsonProperty("chkTsuchisho")
    public void setChkTsuchisho(CheckBoxList chkTsuchisho) {
        this.chkTsuchisho = chkTsuchisho;
    }

    /*
     * getchkIchiranhyoCsv
     * @return chkIchiranhyoCsv
     */
    @JsonProperty("chkIchiranhyoCsv")
    public CheckBoxList getChkIchiranhyoCsv() {
        return chkIchiranhyoCsv;
    }

    /*
     * setchkIchiranhyoCsv
     * @param chkIchiranhyoCsv chkIchiranhyoCsv
     */
    @JsonProperty("chkIchiranhyoCsv")
    public void setChkIchiranhyoCsv(CheckBoxList chkIchiranhyoCsv) {
        this.chkIchiranhyoCsv = chkIchiranhyoCsv;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * getccdBunshoBangoInput
     * @return ccdBunshoBangoInput
     */
    @JsonProperty("ccdBunshoBangoInput")
    public IBunshoBangoInputDiv getCcdBunshoBangoInput() {
        return ccdBunshoBangoInput;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblChushutsuJoken() {
        return this.getChushutsuJoken().getLblChushutsuJoken();
    }

    @JsonIgnore
    public void setLblChushutsuJoken(Label lblChushutsuJoken) {
        this.getChushutsuJoken().setLblChushutsuJoken(lblChushutsuJoken);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJoken() {
        return this.getChushutsuJoken().getRadChushutsuJoken();
    }

    @JsonIgnore
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.getChushutsuJoken().setRadChushutsuJoken(radChushutsuJoken);
    }

    @JsonIgnore
    public Space getBlank1() {
        return this.getChushutsuJoken2().getBlank1();
    }

    @JsonIgnore
    public void setBlank1(Space blank1) {
        this.getChushutsuJoken2().setBlank1(blank1);
    }

    @JsonIgnore
    public Space getBlank2() {
        return this.getChushutsuJoken2().getBlank2();
    }

    @JsonIgnore
    public void setBlank2(Space blank2) {
        this.getChushutsuJoken2().setBlank2(blank2);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShoriNendo() {
        return this.getChushutsuJoken2().getTxtShoriNendo();
    }

    @JsonIgnore
    public void setTxtShoriNendo(TextBoxFlexibleDate txtShoriNendo) {
        this.getChushutsuJoken2().setTxtShoriNendo(txtShoriNendo);
    }

    @JsonIgnore
    public Button getBtnSearchHihokensha() {
        return this.getChushutsuJoken2().getBtnSearchHihokensha();
    }

    @JsonIgnore
    public void setBtnSearchHihokensha(Button btnSearchHihokensha) {
        this.getChushutsuJoken2().setBtnSearchHihokensha(btnSearchHihokensha);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihokenshaNo() {
        return this.getChushutsuJoken2().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.getChushutsuJoken2().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public Space getBlank3() {
        return this.getHaakuKijunbiAndTeishutsuKigen().getBlank3();
    }

    @JsonIgnore
    public void setBlank3(Space blank3) {
        this.getHaakuKijunbiAndTeishutsuKigen().setBlank3(blank3);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSetaiinHaakuKijunYMD() {
        return this.getHaakuKijunbiAndTeishutsuKigen().getTxtSetaiinHaakuKijunYMD();
    }

    @JsonIgnore
    public void setTxtSetaiinHaakuKijunYMD(TextBoxFlexibleDate txtSetaiinHaakuKijunYMD) {
        this.getHaakuKijunbiAndTeishutsuKigen().setTxtSetaiinHaakuKijunYMD(txtSetaiinHaakuKijunYMD);
    }

    @JsonIgnore
    public TextBox getTxtTeishutsuKigen() {
        return this.getHaakuKijunbiAndTeishutsuKigen().getTxtTeishutsuKigen();
    }

    @JsonIgnore
    public void setTxtTeishutsuKigen(TextBox txtTeishutsuKigen) {
        this.getHaakuKijunbiAndTeishutsuKigen().setTxtTeishutsuKigen(txtTeishutsuKigen);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuTaisho() {
        return this.getHaakuKijunbiAndTeishutsuKigen().getRadChushutsuTaisho();
    }

    @JsonIgnore
    public void setRadChushutsuTaisho(RadioButton radChushutsuTaisho) {
        this.getHaakuKijunbiAndTeishutsuKigen().setRadChushutsuTaisho(radChushutsuTaisho);
    }

    // </editor-fold>
}
