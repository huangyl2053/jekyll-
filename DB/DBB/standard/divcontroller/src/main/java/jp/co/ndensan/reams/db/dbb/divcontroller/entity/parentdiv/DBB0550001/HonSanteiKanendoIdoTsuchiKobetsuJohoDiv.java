package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * HonSanteiKanendoIdoTsuchiKobetsuJoho のクラスファイル
 *
 * @reamsid_L DBB-0920-010 quxiaodong
 */
public class HonSanteiKanendoIdoTsuchiKobetsuJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkKetteiTsuchi")
    private CheckBoxList chkKetteiTsuchi;
    @JsonProperty("lblKetteiTsuchi")
    private Label lblKetteiTsuchi;
    @JsonProperty("chkKetteiTsuchiTaishoNendo")
    private CheckBoxList chkKetteiTsuchiTaishoNendo;
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    private TextBoxDate txtKetteiTsuchiHakkoYMD;
    @JsonProperty("chkHenkoTsuchi")
    private CheckBoxList chkHenkoTsuchi;
    @JsonProperty("lblHenkoTsuchi")
    private Label lblHenkoTsuchi;
    @JsonProperty("chkHenkoTsuchiTaishoFukaNendo")
    private CheckBoxList chkHenkoTsuchiTaishoFukaNendo;
    @JsonProperty("txtHenkoTsuchiHakkoYMD")
    private TextBoxDate txtHenkoTsuchiHakkoYMD;
    @JsonProperty("chkHenkoTsuchiTaishosha")
    private CheckBoxList chkHenkoTsuchiTaishosha;
    @JsonProperty("lblNotsu")
    private Label lblNotsu;
    @JsonProperty("chkNotsuTaishoFukaNedno")
    private CheckBoxList chkNotsuTaishoFukaNedno;
    @JsonProperty("txtNotsuHakkoYMD")
    private TextBoxDate txtNotsuHakkoYMD;
    @JsonProperty("ddlNotsuShutsuryokuKi")
    private DropDownList ddlNotsuShutsuryokuKi;
    @JsonProperty("chkNotsuTaishosha")
    private CheckBoxList chkNotsuTaishosha;
    @JsonProperty("radNotsuKozaShutsuryokuYoshiki")
    private RadioButton radNotsuKozaShutsuryokuYoshiki;
    @JsonProperty("txtNotsuMsgAboutShutsuryokuYoshiki")
    private Label txtNotsuMsgAboutShutsuryokuYoshiki;
    @JsonProperty("radNotsuSeikatsuHogo")
    private RadioButton radNotsuSeikatsuHogo;
    @JsonProperty("radNotsuYamawake")
    private RadioButton radNotsuYamawake;
    @JsonProperty("ccdBunshoBangoHenkoTsuchi")
    private BunshoBangoInputDiv ccdBunshoBangoHenkoTsuchi;
    @JsonProperty("ccdBunshoBangoKetteiTsuchi")
    private BunshoBangoInputDiv ccdBunshoBangoKetteiTsuchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkKetteiTsuchi
     * @return chkKetteiTsuchi
     */
    @JsonProperty("chkKetteiTsuchi")
    public CheckBoxList getChkKetteiTsuchi() {
        return chkKetteiTsuchi;
    }

    /*
     * setchkKetteiTsuchi
     * @param chkKetteiTsuchi chkKetteiTsuchi
     */
    @JsonProperty("chkKetteiTsuchi")
    public void setChkKetteiTsuchi(CheckBoxList chkKetteiTsuchi) {
        this.chkKetteiTsuchi = chkKetteiTsuchi;
    }

    /*
     * getlblKetteiTsuchi
     * @return lblKetteiTsuchi
     */
    @JsonProperty("lblKetteiTsuchi")
    public Label getLblKetteiTsuchi() {
        return lblKetteiTsuchi;
    }

    /*
     * setlblKetteiTsuchi
     * @param lblKetteiTsuchi lblKetteiTsuchi
     */
    @JsonProperty("lblKetteiTsuchi")
    public void setLblKetteiTsuchi(Label lblKetteiTsuchi) {
        this.lblKetteiTsuchi = lblKetteiTsuchi;
    }

    /*
     * getchkKetteiTsuchiTaishoNendo
     * @return chkKetteiTsuchiTaishoNendo
     */
    @JsonProperty("chkKetteiTsuchiTaishoNendo")
    public CheckBoxList getChkKetteiTsuchiTaishoNendo() {
        return chkKetteiTsuchiTaishoNendo;
    }

    /*
     * setchkKetteiTsuchiTaishoNendo
     * @param chkKetteiTsuchiTaishoNendo chkKetteiTsuchiTaishoNendo
     */
    @JsonProperty("chkKetteiTsuchiTaishoNendo")
    public void setChkKetteiTsuchiTaishoNendo(CheckBoxList chkKetteiTsuchiTaishoNendo) {
        this.chkKetteiTsuchiTaishoNendo = chkKetteiTsuchiTaishoNendo;
    }

    /*
     * gettxtKetteiTsuchiHakkoYMD
     * @return txtKetteiTsuchiHakkoYMD
     */
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    public TextBoxDate getTxtKetteiTsuchiHakkoYMD() {
        return txtKetteiTsuchiHakkoYMD;
    }

    /*
     * settxtKetteiTsuchiHakkoYMD
     * @param txtKetteiTsuchiHakkoYMD txtKetteiTsuchiHakkoYMD
     */
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    public void setTxtKetteiTsuchiHakkoYMD(TextBoxDate txtKetteiTsuchiHakkoYMD) {
        this.txtKetteiTsuchiHakkoYMD = txtKetteiTsuchiHakkoYMD;
    }

    /*
     * getchkHenkoTsuchi
     * @return chkHenkoTsuchi
     */
    @JsonProperty("chkHenkoTsuchi")
    public CheckBoxList getChkHenkoTsuchi() {
        return chkHenkoTsuchi;
    }

    /*
     * setchkHenkoTsuchi
     * @param chkHenkoTsuchi chkHenkoTsuchi
     */
    @JsonProperty("chkHenkoTsuchi")
    public void setChkHenkoTsuchi(CheckBoxList chkHenkoTsuchi) {
        this.chkHenkoTsuchi = chkHenkoTsuchi;
    }

    /*
     * getlblHenkoTsuchi
     * @return lblHenkoTsuchi
     */
    @JsonProperty("lblHenkoTsuchi")
    public Label getLblHenkoTsuchi() {
        return lblHenkoTsuchi;
    }

    /*
     * setlblHenkoTsuchi
     * @param lblHenkoTsuchi lblHenkoTsuchi
     */
    @JsonProperty("lblHenkoTsuchi")
    public void setLblHenkoTsuchi(Label lblHenkoTsuchi) {
        this.lblHenkoTsuchi = lblHenkoTsuchi;
    }

    /*
     * getchkHenkoTsuchiTaishoFukaNendo
     * @return chkHenkoTsuchiTaishoFukaNendo
     */
    @JsonProperty("chkHenkoTsuchiTaishoFukaNendo")
    public CheckBoxList getChkHenkoTsuchiTaishoFukaNendo() {
        return chkHenkoTsuchiTaishoFukaNendo;
    }

    /*
     * setchkHenkoTsuchiTaishoFukaNendo
     * @param chkHenkoTsuchiTaishoFukaNendo chkHenkoTsuchiTaishoFukaNendo
     */
    @JsonProperty("chkHenkoTsuchiTaishoFukaNendo")
    public void setChkHenkoTsuchiTaishoFukaNendo(CheckBoxList chkHenkoTsuchiTaishoFukaNendo) {
        this.chkHenkoTsuchiTaishoFukaNendo = chkHenkoTsuchiTaishoFukaNendo;
    }

    /*
     * gettxtHenkoTsuchiHakkoYMD
     * @return txtHenkoTsuchiHakkoYMD
     */
    @JsonProperty("txtHenkoTsuchiHakkoYMD")
    public TextBoxDate getTxtHenkoTsuchiHakkoYMD() {
        return txtHenkoTsuchiHakkoYMD;
    }

    /*
     * settxtHenkoTsuchiHakkoYMD
     * @param txtHenkoTsuchiHakkoYMD txtHenkoTsuchiHakkoYMD
     */
    @JsonProperty("txtHenkoTsuchiHakkoYMD")
    public void setTxtHenkoTsuchiHakkoYMD(TextBoxDate txtHenkoTsuchiHakkoYMD) {
        this.txtHenkoTsuchiHakkoYMD = txtHenkoTsuchiHakkoYMD;
    }

    /*
     * getchkHenkoTsuchiTaishosha
     * @return chkHenkoTsuchiTaishosha
     */
    @JsonProperty("chkHenkoTsuchiTaishosha")
    public CheckBoxList getChkHenkoTsuchiTaishosha() {
        return chkHenkoTsuchiTaishosha;
    }

    /*
     * setchkHenkoTsuchiTaishosha
     * @param chkHenkoTsuchiTaishosha chkHenkoTsuchiTaishosha
     */
    @JsonProperty("chkHenkoTsuchiTaishosha")
    public void setChkHenkoTsuchiTaishosha(CheckBoxList chkHenkoTsuchiTaishosha) {
        this.chkHenkoTsuchiTaishosha = chkHenkoTsuchiTaishosha;
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
     * getchkNotsuTaishoFukaNedno
     * @return chkNotsuTaishoFukaNedno
     */
    @JsonProperty("chkNotsuTaishoFukaNedno")
    public CheckBoxList getChkNotsuTaishoFukaNedno() {
        return chkNotsuTaishoFukaNedno;
    }

    /*
     * setchkNotsuTaishoFukaNedno
     * @param chkNotsuTaishoFukaNedno chkNotsuTaishoFukaNedno
     */
    @JsonProperty("chkNotsuTaishoFukaNedno")
    public void setChkNotsuTaishoFukaNedno(CheckBoxList chkNotsuTaishoFukaNedno) {
        this.chkNotsuTaishoFukaNedno = chkNotsuTaishoFukaNedno;
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
     * getddlNotsuShutsuryokuKi
     * @return ddlNotsuShutsuryokuKi
     */
    @JsonProperty("ddlNotsuShutsuryokuKi")
    public DropDownList getDdlNotsuShutsuryokuKi() {
        return ddlNotsuShutsuryokuKi;
    }

    /*
     * setddlNotsuShutsuryokuKi
     * @param ddlNotsuShutsuryokuKi ddlNotsuShutsuryokuKi
     */
    @JsonProperty("ddlNotsuShutsuryokuKi")
    public void setDdlNotsuShutsuryokuKi(DropDownList ddlNotsuShutsuryokuKi) {
        this.ddlNotsuShutsuryokuKi = ddlNotsuShutsuryokuKi;
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
     * getradNotsuKozaShutsuryokuYoshiki
     * @return radNotsuKozaShutsuryokuYoshiki
     */
    @JsonProperty("radNotsuKozaShutsuryokuYoshiki")
    public RadioButton getRadNotsuKozaShutsuryokuYoshiki() {
        return radNotsuKozaShutsuryokuYoshiki;
    }

    /*
     * setradNotsuKozaShutsuryokuYoshiki
     * @param radNotsuKozaShutsuryokuYoshiki radNotsuKozaShutsuryokuYoshiki
     */
    @JsonProperty("radNotsuKozaShutsuryokuYoshiki")
    public void setRadNotsuKozaShutsuryokuYoshiki(RadioButton radNotsuKozaShutsuryokuYoshiki) {
        this.radNotsuKozaShutsuryokuYoshiki = radNotsuKozaShutsuryokuYoshiki;
    }

    /*
     * gettxtNotsuMsgAboutShutsuryokuYoshiki
     * @return txtNotsuMsgAboutShutsuryokuYoshiki
     */
    @JsonProperty("txtNotsuMsgAboutShutsuryokuYoshiki")
    public Label getTxtNotsuMsgAboutShutsuryokuYoshiki() {
        return txtNotsuMsgAboutShutsuryokuYoshiki;
    }

    /*
     * settxtNotsuMsgAboutShutsuryokuYoshiki
     * @param txtNotsuMsgAboutShutsuryokuYoshiki txtNotsuMsgAboutShutsuryokuYoshiki
     */
    @JsonProperty("txtNotsuMsgAboutShutsuryokuYoshiki")
    public void setTxtNotsuMsgAboutShutsuryokuYoshiki(Label txtNotsuMsgAboutShutsuryokuYoshiki) {
        this.txtNotsuMsgAboutShutsuryokuYoshiki = txtNotsuMsgAboutShutsuryokuYoshiki;
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
     * getccdBunshoBangoHenkoTsuchi
     * @return ccdBunshoBangoHenkoTsuchi
     */
    @JsonProperty("ccdBunshoBangoHenkoTsuchi")
    public IBunshoBangoInputDiv getCcdBunshoBangoHenkoTsuchi() {
        return ccdBunshoBangoHenkoTsuchi;
    }

    /*
     * getccdBunshoBangoKetteiTsuchi
     * @return ccdBunshoBangoKetteiTsuchi
     */
    @JsonProperty("ccdBunshoBangoKetteiTsuchi")
    public IBunshoBangoInputDiv getCcdBunshoBangoKetteiTsuchi() {
        return ccdBunshoBangoKetteiTsuchi;
    }

    // </editor-fold>
}
