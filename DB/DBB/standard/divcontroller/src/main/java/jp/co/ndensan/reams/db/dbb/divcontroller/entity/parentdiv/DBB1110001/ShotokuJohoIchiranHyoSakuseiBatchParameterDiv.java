package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * ShotokuJohoIchiranHyoSakuseiBatchParameter のクラスファイル
 *
 * @reamsid_L DBB-1650-040 lijunjun
 */
public class ShotokuJohoIchiranHyoSakuseiBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlShoriNendo")
    private DropDownList ddlShoriNendo;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("lblChusgutsuTaisho")
    private Label lblChusgutsuTaisho;
    @JsonProperty("chkChushutsuTaisho")
    private CheckBoxList chkChushutsuTaisho;
    @JsonProperty("radRirekiSelect")
    private RadioButton radRirekiSelect;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("KoikiChushutsuJokenTanitsuTashaPanel")
    private KoikiChushutsuJokenTanitsuTashaPanelDiv KoikiChushutsuJokenTanitsuTashaPanel;
    @JsonProperty("KoikiChushutsuJokenKoikiPanel")
    private KoikiChushutsuJokenKoikiPanelDiv KoikiChushutsuJokenKoikiPanel;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlShoriNendo
     * @return ddlShoriNendo
     */
    @JsonProperty("ddlShoriNendo")
    public DropDownList getDdlShoriNendo() {
        return ddlShoriNendo;
    }

    /*
     * setddlShoriNendo
     * @param ddlShoriNendo ddlShoriNendo
     */
    @JsonProperty("ddlShoriNendo")
    public void setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.ddlShoriNendo = ddlShoriNendo;
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
     * getlblChusgutsuTaisho
     * @return lblChusgutsuTaisho
     */
    @JsonProperty("lblChusgutsuTaisho")
    public Label getLblChusgutsuTaisho() {
        return lblChusgutsuTaisho;
    }

    /*
     * setlblChusgutsuTaisho
     * @param lblChusgutsuTaisho lblChusgutsuTaisho
     */
    @JsonProperty("lblChusgutsuTaisho")
    public void setLblChusgutsuTaisho(Label lblChusgutsuTaisho) {
        this.lblChusgutsuTaisho = lblChusgutsuTaisho;
    }

    /*
     * getchkChushutsuTaisho
     * @return chkChushutsuTaisho
     */
    @JsonProperty("chkChushutsuTaisho")
    public CheckBoxList getChkChushutsuTaisho() {
        return chkChushutsuTaisho;
    }

    /*
     * setchkChushutsuTaisho
     * @param chkChushutsuTaisho chkChushutsuTaisho
     */
    @JsonProperty("chkChushutsuTaisho")
    public void setChkChushutsuTaisho(CheckBoxList chkChushutsuTaisho) {
        this.chkChushutsuTaisho = chkChushutsuTaisho;
    }

    /*
     * getradRirekiSelect
     * @return radRirekiSelect
     */
    @JsonProperty("radRirekiSelect")
    public RadioButton getRadRirekiSelect() {
        return radRirekiSelect;
    }

    /*
     * setradRirekiSelect
     * @param radRirekiSelect radRirekiSelect
     */
    @JsonProperty("radRirekiSelect")
    public void setRadRirekiSelect(RadioButton radRirekiSelect) {
        this.radRirekiSelect = radRirekiSelect;
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
     * getKoikiChushutsuJokenTanitsuTashaPanel
     * @return KoikiChushutsuJokenTanitsuTashaPanel
     */
    @JsonProperty("KoikiChushutsuJokenTanitsuTashaPanel")
    public KoikiChushutsuJokenTanitsuTashaPanelDiv getKoikiChushutsuJokenTanitsuTashaPanel() {
        return KoikiChushutsuJokenTanitsuTashaPanel;
    }

    /*
     * setKoikiChushutsuJokenTanitsuTashaPanel
     * @param KoikiChushutsuJokenTanitsuTashaPanel KoikiChushutsuJokenTanitsuTashaPanel
     */
    @JsonProperty("KoikiChushutsuJokenTanitsuTashaPanel")
    public void setKoikiChushutsuJokenTanitsuTashaPanel(KoikiChushutsuJokenTanitsuTashaPanelDiv KoikiChushutsuJokenTanitsuTashaPanel) {
        this.KoikiChushutsuJokenTanitsuTashaPanel = KoikiChushutsuJokenTanitsuTashaPanel;
    }

    /*
     * getKoikiChushutsuJokenKoikiPanel
     * @return KoikiChushutsuJokenKoikiPanel
     */
    @JsonProperty("KoikiChushutsuJokenKoikiPanel")
    public KoikiChushutsuJokenKoikiPanelDiv getKoikiChushutsuJokenKoikiPanel() {
        return KoikiChushutsuJokenKoikiPanel;
    }

    /*
     * setKoikiChushutsuJokenKoikiPanel
     * @param KoikiChushutsuJokenKoikiPanel KoikiChushutsuJokenKoikiPanel
     */
    @JsonProperty("KoikiChushutsuJokenKoikiPanel")
    public void setKoikiChushutsuJokenKoikiPanel(KoikiChushutsuJokenKoikiPanelDiv KoikiChushutsuJokenKoikiPanel) {
        this.KoikiChushutsuJokenKoikiPanel = KoikiChushutsuJokenKoikiPanel;
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
    public Label getLblKakuteiStYMD() {
        return this.getKoikiChushutsuJokenTanitsuTashaPanel().getLblKakuteiStYMD();
    }

    @JsonIgnore
    public void setLblKakuteiStYMD(Label lblKakuteiStYMD) {
        this.getKoikiChushutsuJokenTanitsuTashaPanel().setLblKakuteiStYMD(lblKakuteiStYMD);
    }

    @JsonIgnore
    public Label getLblKakuteiStTime() {
        return this.getKoikiChushutsuJokenTanitsuTashaPanel().getLblKakuteiStTime();
    }

    @JsonIgnore
    public void setLblKakuteiStTime(Label lblKakuteiStTime) {
        this.getKoikiChushutsuJokenTanitsuTashaPanel().setLblKakuteiStTime(lblKakuteiStTime);
    }

    @JsonIgnore
    public Label getLblKakuteiEdYMD() {
        return this.getKoikiChushutsuJokenTanitsuTashaPanel().getLblKakuteiEdYMD();
    }

    @JsonIgnore
    public void setLblKakuteiEdYMD(Label lblKakuteiEdYMD) {
        this.getKoikiChushutsuJokenTanitsuTashaPanel().setLblKakuteiEdYMD(lblKakuteiEdYMD);
    }

    @JsonIgnore
    public Label getLblKakuteiEdTime() {
        return this.getKoikiChushutsuJokenTanitsuTashaPanel().getLblKakuteiEdTime();
    }

    @JsonIgnore
    public void setLblKakuteiEdTime(Label lblKakuteiEdTime) {
        this.getKoikiChushutsuJokenTanitsuTashaPanel().setLblKakuteiEdTime(lblKakuteiEdTime);
    }

    @JsonIgnore
    public Label getLblChushutsuKikan() {
        return this.getKoikiChushutsuJokenTanitsuTashaPanel().getLblChushutsuKikan();
    }

    @JsonIgnore
    public void setLblChushutsuKikan(Label lblChushutsuKikan) {
        this.getKoikiChushutsuJokenTanitsuTashaPanel().setLblChushutsuKikan(lblChushutsuKikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtKakuteiStYMD() {
        return this.getKoikiChushutsuJokenTanitsuTashaPanel().getTxtKakuteiStYMD();
    }

    @JsonIgnore
    public void setTxtKakuteiStYMD(TextBoxDate txtKakuteiStYMD) {
        this.getKoikiChushutsuJokenTanitsuTashaPanel().setTxtKakuteiStYMD(txtKakuteiStYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtKakuteiStTime() {
        return this.getKoikiChushutsuJokenTanitsuTashaPanel().getTxtKakuteiStTime();
    }

    @JsonIgnore
    public void setTxtKakuteiStTime(TextBoxTime txtKakuteiStTime) {
        this.getKoikiChushutsuJokenTanitsuTashaPanel().setTxtKakuteiStTime(txtKakuteiStTime);
    }

    @JsonIgnore
    public Label getLblKara() {
        return this.getKoikiChushutsuJokenTanitsuTashaPanel().getLblKara();
    }

    @JsonIgnore
    public void setLblKara(Label lblKara) {
        this.getKoikiChushutsuJokenTanitsuTashaPanel().setLblKara(lblKara);
    }

    @JsonIgnore
    public TextBoxDate getTxtKakuteiEdYMD() {
        return this.getKoikiChushutsuJokenTanitsuTashaPanel().getTxtKakuteiEdYMD();
    }

    @JsonIgnore
    public void setTxtKakuteiEdYMD(TextBoxDate txtKakuteiEdYMD) {
        this.getKoikiChushutsuJokenTanitsuTashaPanel().setTxtKakuteiEdYMD(txtKakuteiEdYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtKakuteiEdTime() {
        return this.getKoikiChushutsuJokenTanitsuTashaPanel().getTxtKakuteiEdTime();
    }

    @JsonIgnore
    public void setTxtKakuteiEdTime(TextBoxTime txtKakuteiEdTime) {
        this.getKoikiChushutsuJokenTanitsuTashaPanel().setTxtKakuteiEdTime(txtKakuteiEdTime);
    }

    @JsonIgnore
    public DataGrid<dgShichosonIchiran_Row> getDgShichosonIchiran() {
        return this.getKoikiChushutsuJokenKoikiPanel().getDgShichosonIchiran();
    }

    @JsonIgnore
    public void setDgShichosonIchiran(DataGrid<dgShichosonIchiran_Row> dgShichosonIchiran) {
        this.getKoikiChushutsuJokenKoikiPanel().setDgShichosonIchiran(dgShichosonIchiran);
    }

    // </editor-fold>
}
