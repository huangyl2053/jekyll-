package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KariSanteiTsuchiKobetsuJoho のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KariSanteiTsuchiKobetsuJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    private Label lblTokuKaishiTsuchi;
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD")
    private TextBoxDate txtTokuKaishiTsuchiHakkoYMD;
    @JsonProperty("lblKariHenkoTsuchi")
    private Label lblKariHenkoTsuchi;
    @JsonProperty("txtKariHenkoTsuchiHakkoYMD")
    private TextBoxDate txtKariHenkoTsuchiHakkoYMD;
    @JsonProperty("lblNotsu")
    private Label lblNotsu;
    @JsonProperty("txtNotsuHakkoYMD")
    private TextBoxDate txtNotsuHakkoYMD;
    @JsonProperty("txtNotsuShutsuryokuKi")
    private TextBox txtNotsuShutsuryokuKi;
    @JsonProperty("ddlNotsuShuturyokuki")
    private DropDownList ddlNotsuShuturyokuki;
    @JsonProperty("chkNotsuTaishosha")
    private CheckBoxList chkNotsuTaishosha;
    @JsonProperty("radNotsuSeikatsuHogo")
    private RadioButton radNotsuSeikatsuHogo;
    @JsonProperty("radNotsuYamawake")
    private RadioButton radNotsuYamawake;
    @JsonProperty("ccdBunshoBango")
    private BunshoBangoInputDiv ccdBunshoBango;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTokuKaishiTsuchi
     * @return lblTokuKaishiTsuchi
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    public Label getLblTokuKaishiTsuchi() {
        return lblTokuKaishiTsuchi;
    }

    /*
     * setlblTokuKaishiTsuchi
     * @param lblTokuKaishiTsuchi lblTokuKaishiTsuchi
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    public void setLblTokuKaishiTsuchi(Label lblTokuKaishiTsuchi) {
        this.lblTokuKaishiTsuchi = lblTokuKaishiTsuchi;
    }

    /*
     * gettxtTokuKaishiTsuchiHakkoYMD
     * @return txtTokuKaishiTsuchiHakkoYMD
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD")
    public TextBoxDate getTxtTokuKaishiTsuchiHakkoYMD() {
        return txtTokuKaishiTsuchiHakkoYMD;
    }

    /*
     * settxtTokuKaishiTsuchiHakkoYMD
     * @param txtTokuKaishiTsuchiHakkoYMD txtTokuKaishiTsuchiHakkoYMD
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD")
    public void setTxtTokuKaishiTsuchiHakkoYMD(TextBoxDate txtTokuKaishiTsuchiHakkoYMD) {
        this.txtTokuKaishiTsuchiHakkoYMD = txtTokuKaishiTsuchiHakkoYMD;
    }

    /*
     * getlblKariHenkoTsuchi
     * @return lblKariHenkoTsuchi
     */
    @JsonProperty("lblKariHenkoTsuchi")
    public Label getLblKariHenkoTsuchi() {
        return lblKariHenkoTsuchi;
    }

    /*
     * setlblKariHenkoTsuchi
     * @param lblKariHenkoTsuchi lblKariHenkoTsuchi
     */
    @JsonProperty("lblKariHenkoTsuchi")
    public void setLblKariHenkoTsuchi(Label lblKariHenkoTsuchi) {
        this.lblKariHenkoTsuchi = lblKariHenkoTsuchi;
    }

    /*
     * gettxtKariHenkoTsuchiHakkoYMD
     * @return txtKariHenkoTsuchiHakkoYMD
     */
    @JsonProperty("txtKariHenkoTsuchiHakkoYMD")
    public TextBoxDate getTxtKariHenkoTsuchiHakkoYMD() {
        return txtKariHenkoTsuchiHakkoYMD;
    }

    /*
     * settxtKariHenkoTsuchiHakkoYMD
     * @param txtKariHenkoTsuchiHakkoYMD txtKariHenkoTsuchiHakkoYMD
     */
    @JsonProperty("txtKariHenkoTsuchiHakkoYMD")
    public void setTxtKariHenkoTsuchiHakkoYMD(TextBoxDate txtKariHenkoTsuchiHakkoYMD) {
        this.txtKariHenkoTsuchiHakkoYMD = txtKariHenkoTsuchiHakkoYMD;
    }

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
     * gettxtNotsuShutsuryokuKi
     * @return txtNotsuShutsuryokuKi
     */
    @JsonProperty("txtNotsuShutsuryokuKi")
    public TextBox getTxtNotsuShutsuryokuKi() {
        return txtNotsuShutsuryokuKi;
    }

    /*
     * settxtNotsuShutsuryokuKi
     * @param txtNotsuShutsuryokuKi txtNotsuShutsuryokuKi
     */
    @JsonProperty("txtNotsuShutsuryokuKi")
    public void setTxtNotsuShutsuryokuKi(TextBox txtNotsuShutsuryokuKi) {
        this.txtNotsuShutsuryokuKi = txtNotsuShutsuryokuKi;
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

    /*
     * getccdBunshoBango
     * @return ccdBunshoBango
     */
    @JsonProperty("ccdBunshoBango")
    public IBunshoBangoInputDiv getCcdBunshoBango() {
        return ccdBunshoBango;
    }

    // </editor-fold>
}
