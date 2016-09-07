package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * ShotokuJohoIchiranHyoSakusei のクラスファイル
 *
 * @reamsid_L DBB-1650-010 lijunjun
 */
public class ShotokuJohoIchiranHyoSakuseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShotokuJohoIchiranHyoSakuseiBatchParameter")
    private ShotokuJohoIchiranHyoSakuseiBatchParameterDiv ShotokuJohoIchiranHyoSakuseiBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShotokuJohoIchiranHyoSakuseiBatchParameter
     * @return ShotokuJohoIchiranHyoSakuseiBatchParameter
     */
    @JsonProperty("ShotokuJohoIchiranHyoSakuseiBatchParameter")
    public ShotokuJohoIchiranHyoSakuseiBatchParameterDiv getShotokuJohoIchiranHyoSakuseiBatchParameter() {
        return ShotokuJohoIchiranHyoSakuseiBatchParameter;
    }

    /*
     * setShotokuJohoIchiranHyoSakuseiBatchParameter
     * @param ShotokuJohoIchiranHyoSakuseiBatchParameter ShotokuJohoIchiranHyoSakuseiBatchParameter
     */
    @JsonProperty("ShotokuJohoIchiranHyoSakuseiBatchParameter")
    public void setShotokuJohoIchiranHyoSakuseiBatchParameter(ShotokuJohoIchiranHyoSakuseiBatchParameterDiv ShotokuJohoIchiranHyoSakuseiBatchParameter) {
        this.ShotokuJohoIchiranHyoSakuseiBatchParameter = ShotokuJohoIchiranHyoSakuseiBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlShoriNendo() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getDdlShoriNendo();
    }

    @JsonIgnore
    public void setDdlShoriNendo(DropDownList ddlShoriNendo) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().setDdlShoriNendo(ddlShoriNendo);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().setLin1(lin1);
    }

    @JsonIgnore
    public Label getLblChusgutsuTaisho() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getLblChusgutsuTaisho();
    }

    @JsonIgnore
    public void setLblChusgutsuTaisho(Label lblChusgutsuTaisho) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().setLblChusgutsuTaisho(lblChusgutsuTaisho);
    }

    @JsonIgnore
    public CheckBoxList getChkChushutsuTaisho() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getChkChushutsuTaisho();
    }

    @JsonIgnore
    public void setChkChushutsuTaisho(CheckBoxList chkChushutsuTaisho) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().setChkChushutsuTaisho(chkChushutsuTaisho);
    }

    @JsonIgnore
    public RadioButton getRadRirekiSelect() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getRadRirekiSelect();
    }

    @JsonIgnore
    public void setRadRirekiSelect(RadioButton radRirekiSelect) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().setRadRirekiSelect(radRirekiSelect);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().setLin2(lin2);
    }

    @JsonIgnore
    public KoikiChushutsuJokenTanitsuTashaPanelDiv getKoikiChushutsuJokenTanitsuTashaPanel() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel();
    }

    @JsonIgnore
    public void setKoikiChushutsuJokenTanitsuTashaPanel(KoikiChushutsuJokenTanitsuTashaPanelDiv KoikiChushutsuJokenTanitsuTashaPanel) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().setKoikiChushutsuJokenTanitsuTashaPanel(KoikiChushutsuJokenTanitsuTashaPanel);
    }

    @JsonIgnore
    public Label getLblKakuteiStYMD() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().getLblKakuteiStYMD();
    }

    @JsonIgnore
    public void setLblKakuteiStYMD(Label lblKakuteiStYMD) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().setLblKakuteiStYMD(lblKakuteiStYMD);
    }

    @JsonIgnore
    public Label getLblKakuteiStTime() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().getLblKakuteiStTime();
    }

    @JsonIgnore
    public void setLblKakuteiStTime(Label lblKakuteiStTime) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().setLblKakuteiStTime(lblKakuteiStTime);
    }

    @JsonIgnore
    public Label getLblKakuteiEdYMD() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().getLblKakuteiEdYMD();
    }

    @JsonIgnore
    public void setLblKakuteiEdYMD(Label lblKakuteiEdYMD) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().setLblKakuteiEdYMD(lblKakuteiEdYMD);
    }

    @JsonIgnore
    public Label getLblKakuteiEdTime() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().getLblKakuteiEdTime();
    }

    @JsonIgnore
    public void setLblKakuteiEdTime(Label lblKakuteiEdTime) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().setLblKakuteiEdTime(lblKakuteiEdTime);
    }

    @JsonIgnore
    public Label getLblChushutsuKikan() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().getLblChushutsuKikan();
    }

    @JsonIgnore
    public void setLblChushutsuKikan(Label lblChushutsuKikan) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().setLblChushutsuKikan(lblChushutsuKikan);
    }

    @JsonIgnore
    public TextBoxDate getTxtKakuteiStYMD() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().getTxtKakuteiStYMD();
    }

    @JsonIgnore
    public void setTxtKakuteiStYMD(TextBoxDate txtKakuteiStYMD) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().setTxtKakuteiStYMD(txtKakuteiStYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtKakuteiStTime() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().getTxtKakuteiStTime();
    }

    @JsonIgnore
    public void setTxtKakuteiStTime(TextBoxTime txtKakuteiStTime) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().setTxtKakuteiStTime(txtKakuteiStTime);
    }

    @JsonIgnore
    public Label getLblKara() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().getLblKara();
    }

    @JsonIgnore
    public void setLblKara(Label lblKara) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().setLblKara(lblKara);
    }

    @JsonIgnore
    public TextBoxDate getTxtKakuteiEdYMD() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().getTxtKakuteiEdYMD();
    }

    @JsonIgnore
    public void setTxtKakuteiEdYMD(TextBoxDate txtKakuteiEdYMD) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().setTxtKakuteiEdYMD(txtKakuteiEdYMD);
    }

    @JsonIgnore
    public TextBoxTime getTxtKakuteiEdTime() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().getTxtKakuteiEdTime();
    }

    @JsonIgnore
    public void setTxtKakuteiEdTime(TextBoxTime txtKakuteiEdTime) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenTanitsuTashaPanel().setTxtKakuteiEdTime(txtKakuteiEdTime);
    }

    @JsonIgnore
    public KoikiChushutsuJokenKoikiPanelDiv getKoikiChushutsuJokenKoikiPanel() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenKoikiPanel();
    }

    @JsonIgnore
    public void setKoikiChushutsuJokenKoikiPanel(KoikiChushutsuJokenKoikiPanelDiv KoikiChushutsuJokenKoikiPanel) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().setKoikiChushutsuJokenKoikiPanel(KoikiChushutsuJokenKoikiPanel);
    }

    @JsonIgnore
    public DataGrid<dgShichosonIchiran_Row> getDgShichosonIchiran() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenKoikiPanel().getDgShichosonIchiran();
    }

    @JsonIgnore
    public void setDgShichosonIchiran(DataGrid<dgShichosonIchiran_Row> dgShichosonIchiran) {
        this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getKoikiChushutsuJokenKoikiPanel().setDgShichosonIchiran(dgShichosonIchiran);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return this.getShotokuJohoIchiranHyoSakuseiBatchParameter().getCcdChohyoShutsuryokujun();
    }

    // </editor-fold>
}
