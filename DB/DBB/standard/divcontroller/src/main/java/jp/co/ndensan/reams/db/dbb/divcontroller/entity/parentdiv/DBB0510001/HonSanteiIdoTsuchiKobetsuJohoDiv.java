package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001;
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
 * HonSanteiIdoTsuchiKobetsuJoho のクラスファイル
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public class HonSanteiIdoTsuchiKobetsuJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTokuchoKaishiTsuchi")
    private Label lblTokuchoKaishiTsuchi;
    @JsonProperty("radTokuchoKaishiTsuchiTaishosha")
    private RadioButton radTokuchoKaishiTsuchiTaishosha;
    @JsonProperty("txtTokuchoKaishiTsuchishoHakkoYMD")
    private TextBoxDate txtTokuchoKaishiTsuchishoHakkoYMD;
    @JsonProperty("chkKetteiTsuchi")
    private CheckBoxList chkKetteiTsuchi;
    @JsonProperty("lblKetteiTsuchi")
    private Label lblKetteiTsuchi;
    @JsonProperty("txtKetteiTsuchiHakkoYMD")
    private TextBoxDate txtKetteiTsuchiHakkoYMD;
    @JsonProperty("chkHenkoTsuchi")
    private CheckBoxList chkHenkoTsuchi;
    @JsonProperty("lblHenkoTsuchi")
    private Label lblHenkoTsuchi;
    @JsonProperty("chkHenkoTsuchiTaishosha")
    private CheckBoxList chkHenkoTsuchiTaishosha;
    @JsonProperty("txtHenkoTsuchiKozaIdoNomiShutsuryoku")
    private TextBox txtHenkoTsuchiKozaIdoNomiShutsuryoku;
    @JsonProperty("txtHenkoTsuchiHakkoYMD")
    private TextBoxDate txtHenkoTsuchiHakkoYMD;
    @JsonProperty("lblNotsu")
    private Label lblNotsu;
    @JsonProperty("chkNotsuTaishoSha")
    private CheckBoxList chkNotsuTaishoSha;
    @JsonProperty("txtNotsuKozaIdoNomiShutsuryoku")
    private TextBox txtNotsuKozaIdoNomiShutsuryoku;
    @JsonProperty("radNotsuKozaShutsuryokuYoshiki")
    private RadioButton radNotsuKozaShutsuryokuYoshiki;
    @JsonProperty("txtNotsuMsgAboutShutsuryokuYoshiki")
    private Label txtNotsuMsgAboutShutsuryokuYoshiki;
    @JsonProperty("txtNotsuHakkoYMD")
    private TextBoxDate txtNotsuHakkoYMD;
    @JsonProperty("txtNotsuShutsuryokuKi")
    private TextBox txtNotsuShutsuryokuKi;
    @JsonProperty("ddlNotsuShuturyokuki")
    private DropDownList ddlNotsuShuturyokuki;
    @JsonProperty("radNotsuSeikatsuHogo")
    private RadioButton radNotsuSeikatsuHogo;
    @JsonProperty("radNotsuYamawake")
    private RadioButton radNotsuYamawake;
    @JsonProperty("ccdBushiNoKetteiTsuchi")
    private BunshoBangoInputDiv ccdBushiNoKetteiTsuchi;
    @JsonProperty("ccdBunshoBangoHenkoTsuchi")
    private BunshoBangoInputDiv ccdBunshoBangoHenkoTsuchi;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblTokuchoKaishiTsuchi
     * @return lblTokuchoKaishiTsuchi
     */
    @JsonProperty("lblTokuchoKaishiTsuchi")
    public Label getLblTokuchoKaishiTsuchi() {
        return lblTokuchoKaishiTsuchi;
    }

    /*
     * setlblTokuchoKaishiTsuchi
     * @param lblTokuchoKaishiTsuchi lblTokuchoKaishiTsuchi
     */
    @JsonProperty("lblTokuchoKaishiTsuchi")
    public void setLblTokuchoKaishiTsuchi(Label lblTokuchoKaishiTsuchi) {
        this.lblTokuchoKaishiTsuchi = lblTokuchoKaishiTsuchi;
    }

    /*
     * getradTokuchoKaishiTsuchiTaishosha
     * @return radTokuchoKaishiTsuchiTaishosha
     */
    @JsonProperty("radTokuchoKaishiTsuchiTaishosha")
    public RadioButton getRadTokuchoKaishiTsuchiTaishosha() {
        return radTokuchoKaishiTsuchiTaishosha;
    }

    /*
     * setradTokuchoKaishiTsuchiTaishosha
     * @param radTokuchoKaishiTsuchiTaishosha radTokuchoKaishiTsuchiTaishosha
     */
    @JsonProperty("radTokuchoKaishiTsuchiTaishosha")
    public void setRadTokuchoKaishiTsuchiTaishosha(RadioButton radTokuchoKaishiTsuchiTaishosha) {
        this.radTokuchoKaishiTsuchiTaishosha = radTokuchoKaishiTsuchiTaishosha;
    }

    /*
     * gettxtTokuchoKaishiTsuchishoHakkoYMD
     * @return txtTokuchoKaishiTsuchishoHakkoYMD
     */
    @JsonProperty("txtTokuchoKaishiTsuchishoHakkoYMD")
    public TextBoxDate getTxtTokuchoKaishiTsuchishoHakkoYMD() {
        return txtTokuchoKaishiTsuchishoHakkoYMD;
    }

    /*
     * settxtTokuchoKaishiTsuchishoHakkoYMD
     * @param txtTokuchoKaishiTsuchishoHakkoYMD txtTokuchoKaishiTsuchishoHakkoYMD
     */
    @JsonProperty("txtTokuchoKaishiTsuchishoHakkoYMD")
    public void setTxtTokuchoKaishiTsuchishoHakkoYMD(TextBoxDate txtTokuchoKaishiTsuchishoHakkoYMD) {
        this.txtTokuchoKaishiTsuchishoHakkoYMD = txtTokuchoKaishiTsuchishoHakkoYMD;
    }

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
     * gettxtHenkoTsuchiKozaIdoNomiShutsuryoku
     * @return txtHenkoTsuchiKozaIdoNomiShutsuryoku
     */
    @JsonProperty("txtHenkoTsuchiKozaIdoNomiShutsuryoku")
    public TextBox getTxtHenkoTsuchiKozaIdoNomiShutsuryoku() {
        return txtHenkoTsuchiKozaIdoNomiShutsuryoku;
    }

    /*
     * settxtHenkoTsuchiKozaIdoNomiShutsuryoku
     * @param txtHenkoTsuchiKozaIdoNomiShutsuryoku txtHenkoTsuchiKozaIdoNomiShutsuryoku
     */
    @JsonProperty("txtHenkoTsuchiKozaIdoNomiShutsuryoku")
    public void setTxtHenkoTsuchiKozaIdoNomiShutsuryoku(TextBox txtHenkoTsuchiKozaIdoNomiShutsuryoku) {
        this.txtHenkoTsuchiKozaIdoNomiShutsuryoku = txtHenkoTsuchiKozaIdoNomiShutsuryoku;
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
     * getchkNotsuTaishoSha
     * @return chkNotsuTaishoSha
     */
    @JsonProperty("chkNotsuTaishoSha")
    public CheckBoxList getChkNotsuTaishoSha() {
        return chkNotsuTaishoSha;
    }

    /*
     * setchkNotsuTaishoSha
     * @param chkNotsuTaishoSha chkNotsuTaishoSha
     */
    @JsonProperty("chkNotsuTaishoSha")
    public void setChkNotsuTaishoSha(CheckBoxList chkNotsuTaishoSha) {
        this.chkNotsuTaishoSha = chkNotsuTaishoSha;
    }

    /*
     * gettxtNotsuKozaIdoNomiShutsuryoku
     * @return txtNotsuKozaIdoNomiShutsuryoku
     */
    @JsonProperty("txtNotsuKozaIdoNomiShutsuryoku")
    public TextBox getTxtNotsuKozaIdoNomiShutsuryoku() {
        return txtNotsuKozaIdoNomiShutsuryoku;
    }

    /*
     * settxtNotsuKozaIdoNomiShutsuryoku
     * @param txtNotsuKozaIdoNomiShutsuryoku txtNotsuKozaIdoNomiShutsuryoku
     */
    @JsonProperty("txtNotsuKozaIdoNomiShutsuryoku")
    public void setTxtNotsuKozaIdoNomiShutsuryoku(TextBox txtNotsuKozaIdoNomiShutsuryoku) {
        this.txtNotsuKozaIdoNomiShutsuryoku = txtNotsuKozaIdoNomiShutsuryoku;
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
     * getccdBushiNoKetteiTsuchi
     * @return ccdBushiNoKetteiTsuchi
     */
    @JsonProperty("ccdBushiNoKetteiTsuchi")
    public IBunshoBangoInputDiv getCcdBushiNoKetteiTsuchi() {
        return ccdBushiNoKetteiTsuchi;
    }

    /*
     * getccdBunshoBangoHenkoTsuchi
     * @return ccdBunshoBangoHenkoTsuchi
     */
    @JsonProperty("ccdBunshoBangoHenkoTsuchi")
    public IBunshoBangoInputDiv getCcdBunshoBangoHenkoTsuchi() {
        return ccdBunshoBangoHenkoTsuchi;
    }

    // </editor-fold>
}
