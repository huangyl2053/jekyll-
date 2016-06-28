package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * HonNotsu のクラスファイル
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonNotsuDiv extends PanelPublish {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtNotsuHakkoYMD")
    private TextBoxDate txtNotsuHakkoYMD;
    @JsonProperty("lblNotsuDaikou")
    private Label lblNotsuDaikou;
    @JsonProperty("ddlNotsuShuturyokuki")
    private DropDownList ddlNotsuShuturyokuki;
    @JsonProperty("chkNotsuTaishosha")
    private CheckBoxList chkNotsuTaishosha;
    @JsonProperty("radNotsuSeikatsuHogo")
    private RadioButton radNotsuSeikatsuHogo;
    @JsonProperty("radNotsuYamawake")
    private RadioButton radNotsuYamawake;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtNotsuHakkoYMD
     * @return txtNotsuHakkoYMD
     */
    @JsonProperty("txtNotsuHakkoYMD")
    public TextBoxDate getTxtNotsuHakkoYMD() {
        return txtNotsuHakkoYMD;
    }

    /*
     * settxtNotsuHakkoYMD
     * @param txtNotsuHakkoYMD txtNotsuHakkoYMD
     */
    @JsonProperty("txtNotsuHakkoYMD")
    public void setTxtNotsuHakkoYMD(TextBoxDate txtNotsuHakkoYMD) {
        this.txtNotsuHakkoYMD = txtNotsuHakkoYMD;
    }

    /*
     * getlblNotsuDaikou
     * @return lblNotsuDaikou
     */
    @JsonProperty("lblNotsuDaikou")
    public Label getLblNotsuDaikou() {
        return lblNotsuDaikou;
    }

    /*
     * setlblNotsuDaikou
     * @param lblNotsuDaikou lblNotsuDaikou
     */
    @JsonProperty("lblNotsuDaikou")
    public void setLblNotsuDaikou(Label lblNotsuDaikou) {
        this.lblNotsuDaikou = lblNotsuDaikou;
    }

    /*
     * getddlNotsuShuturyokuki
     * @return ddlNotsuShuturyokuki
     */
    @JsonProperty("ddlNotsuShuturyokuki")
    public DropDownList getDdlNotsuShuturyokuki() {
        return ddlNotsuShuturyokuki;
    }

    /*
     * setddlNotsuShuturyokuki
     * @param ddlNotsuShuturyokuki ddlNotsuShuturyokuki
     */
    @JsonProperty("ddlNotsuShuturyokuki")
    public void setDdlNotsuShuturyokuki(DropDownList ddlNotsuShuturyokuki) {
        this.ddlNotsuShuturyokuki = ddlNotsuShuturyokuki;
    }

    /*
     * getchkNotsuTaishosha
     * @return chkNotsuTaishosha
     */
    @JsonProperty("chkNotsuTaishosha")
    public CheckBoxList getChkNotsuTaishosha() {
        return chkNotsuTaishosha;
    }

    /*
     * setchkNotsuTaishosha
     * @param chkNotsuTaishosha chkNotsuTaishosha
     */
    @JsonProperty("chkNotsuTaishosha")
    public void setChkNotsuTaishosha(CheckBoxList chkNotsuTaishosha) {
        this.chkNotsuTaishosha = chkNotsuTaishosha;
    }

    /*
     * getradNotsuSeikatsuHogo
     * @return radNotsuSeikatsuHogo
     */
    @JsonProperty("radNotsuSeikatsuHogo")
    public RadioButton getRadNotsuSeikatsuHogo() {
        return radNotsuSeikatsuHogo;
    }

    /*
     * setradNotsuSeikatsuHogo
     * @param radNotsuSeikatsuHogo radNotsuSeikatsuHogo
     */
    @JsonProperty("radNotsuSeikatsuHogo")
    public void setRadNotsuSeikatsuHogo(RadioButton radNotsuSeikatsuHogo) {
        this.radNotsuSeikatsuHogo = radNotsuSeikatsuHogo;
    }

    /*
     * getradNotsuYamawake
     * @return radNotsuYamawake
     */
    @JsonProperty("radNotsuYamawake")
    public RadioButton getRadNotsuYamawake() {
        return radNotsuYamawake;
    }

    /*
     * setradNotsuYamawake
     * @param radNotsuYamawake radNotsuYamawake
     */
    @JsonProperty("radNotsuYamawake")
    public void setRadNotsuYamawake(RadioButton radNotsuYamawake) {
        this.radNotsuYamawake = radNotsuYamawake;
    }

    // </editor-fold>
}
