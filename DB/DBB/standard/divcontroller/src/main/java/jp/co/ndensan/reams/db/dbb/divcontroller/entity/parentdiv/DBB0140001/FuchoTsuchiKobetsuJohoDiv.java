package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * FuchoTsuchiKobetsuJoho のクラスファイル
 *
 * @reamsid_L DBB-0710-010 gongliang
 */
public class FuchoTsuchiKobetsuJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblNotsu")
    private Label lblNotsu;
    @JsonProperty("txtHakkoYMD")
    private TextBoxDate txtHakkoYMD;
    @JsonProperty("txtNotsuShutsuryokukiType2")
    private TextBox txtNotsuShutsuryokukiType2;
    @JsonProperty("ddlNotsuShuturyokuki2")
    private DropDownList ddlNotsuShuturyokuki2;
    @JsonProperty("chkNotsuTaishosha2")
    private CheckBoxList chkNotsuTaishosha2;
    @JsonProperty("radNotsuSeikatsuHogo2")
    private RadioButton radNotsuSeikatsuHogo2;
    @JsonProperty("radNotsuYamawake2")
    private RadioButton radNotsuYamawake2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblNotsu
     * @return lblNotsu
     */
    @JsonProperty("lblNotsu")
    public Label getLblNotsu() {
        return lblNotsu;
    }

    /*
     * setlblNotsu
     * @param lblNotsu lblNotsu
     */
    @JsonProperty("lblNotsu")
    public void setLblNotsu(Label lblNotsu) {
        this.lblNotsu = lblNotsu;
    }

    /*
     * gettxtHakkoYMD
     * @return txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public TextBoxDate getTxtHakkoYMD() {
        return txtHakkoYMD;
    }

    /*
     * settxtHakkoYMD
     * @param txtHakkoYMD txtHakkoYMD
     */
    @JsonProperty("txtHakkoYMD")
    public void setTxtHakkoYMD(TextBoxDate txtHakkoYMD) {
        this.txtHakkoYMD = txtHakkoYMD;
    }

    /*
     * gettxtNotsuShutsuryokukiType2
     * @return txtNotsuShutsuryokukiType2
     */
    @JsonProperty("txtNotsuShutsuryokukiType2")
    public TextBox getTxtNotsuShutsuryokukiType2() {
        return txtNotsuShutsuryokukiType2;
    }

    /*
     * settxtNotsuShutsuryokukiType2
     * @param txtNotsuShutsuryokukiType2 txtNotsuShutsuryokukiType2
     */
    @JsonProperty("txtNotsuShutsuryokukiType2")
    public void setTxtNotsuShutsuryokukiType2(TextBox txtNotsuShutsuryokukiType2) {
        this.txtNotsuShutsuryokukiType2 = txtNotsuShutsuryokukiType2;
    }

    /*
     * getddlNotsuShuturyokuki2
     * @return ddlNotsuShuturyokuki2
     */
    @JsonProperty("ddlNotsuShuturyokuki2")
    public DropDownList getDdlNotsuShuturyokuki2() {
        return ddlNotsuShuturyokuki2;
    }

    /*
     * setddlNotsuShuturyokuki2
     * @param ddlNotsuShuturyokuki2 ddlNotsuShuturyokuki2
     */
    @JsonProperty("ddlNotsuShuturyokuki2")
    public void setDdlNotsuShuturyokuki2(DropDownList ddlNotsuShuturyokuki2) {
        this.ddlNotsuShuturyokuki2 = ddlNotsuShuturyokuki2;
    }

    /*
     * getchkNotsuTaishosha2
     * @return chkNotsuTaishosha2
     */
    @JsonProperty("chkNotsuTaishosha2")
    public CheckBoxList getChkNotsuTaishosha2() {
        return chkNotsuTaishosha2;
    }

    /*
     * setchkNotsuTaishosha2
     * @param chkNotsuTaishosha2 chkNotsuTaishosha2
     */
    @JsonProperty("chkNotsuTaishosha2")
    public void setChkNotsuTaishosha2(CheckBoxList chkNotsuTaishosha2) {
        this.chkNotsuTaishosha2 = chkNotsuTaishosha2;
    }

    /*
     * getradNotsuSeikatsuHogo2
     * @return radNotsuSeikatsuHogo2
     */
    @JsonProperty("radNotsuSeikatsuHogo2")
    public RadioButton getRadNotsuSeikatsuHogo2() {
        return radNotsuSeikatsuHogo2;
    }

    /*
     * setradNotsuSeikatsuHogo2
     * @param radNotsuSeikatsuHogo2 radNotsuSeikatsuHogo2
     */
    @JsonProperty("radNotsuSeikatsuHogo2")
    public void setRadNotsuSeikatsuHogo2(RadioButton radNotsuSeikatsuHogo2) {
        this.radNotsuSeikatsuHogo2 = radNotsuSeikatsuHogo2;
    }

    /*
     * getradNotsuYamawake2
     * @return radNotsuYamawake2
     */
    @JsonProperty("radNotsuYamawake2")
    public RadioButton getRadNotsuYamawake2() {
        return radNotsuYamawake2;
    }

    /*
     * setradNotsuYamawake2
     * @param radNotsuYamawake2 radNotsuYamawake2
     */
    @JsonProperty("radNotsuYamawake2")
    public void setRadNotsuYamawake2(RadioButton radNotsuYamawake2) {
        this.radNotsuYamawake2 = radNotsuYamawake2;
    }

    // </editor-fold>
}
