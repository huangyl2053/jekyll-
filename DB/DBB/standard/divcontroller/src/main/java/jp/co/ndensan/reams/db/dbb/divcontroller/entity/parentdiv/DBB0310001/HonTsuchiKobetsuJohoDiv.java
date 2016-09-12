package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * HonTsuchiKobetsuJoho のクラスファイル
 *
 * @reamsid_L DBB-0780-010 xicongwang
 */
public class HonTsuchiKobetsuJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblTokuKaishiTsuchi")
    private Label lblTokuKaishiTsuchi;
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD2")
    private TextBoxDate txtTokuKaishiTsuchiHakkoYMD2;
    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    private RadioButton radTokuKaishiTsuchiTaisho2;
    @JsonProperty("lblKetteTsuchi")
    private Label lblKetteTsuchi;
    @JsonProperty("txtKetteTsuchiHakkoYMD2")
    private TextBoxDate txtKetteTsuchiHakkoYMD2;
    @JsonProperty("btnKetteiTsuchiYousikiSettei2")
    private Button btnKetteiTsuchiYousikiSettei2;
    @JsonProperty("txtKetteiTsuchiYousikiSettei")
    private TextBox txtKetteiTsuchiYousikiSettei;
    @JsonProperty("lblNotsu")
    private Label lblNotsu;
    @JsonProperty("txtNotsuHakkoYMD2")
    private TextBoxDate txtNotsuHakkoYMD2;
    @JsonProperty("ddlNotsuShuturyokuki2")
    private DropDownList ddlNotsuShuturyokuki2;
    @JsonProperty("txtShutsuryokuHoho")
    private TextBox txtShutsuryokuHoho;
    @JsonProperty("chkNotsuTaishosha2")
    private CheckBoxList chkNotsuTaishosha2;
    @JsonProperty("radNotsuSeikatsuHogo2")
    private RadioButton radNotsuSeikatsuHogo2;
    @JsonProperty("radNotsuYamawake2")
    private RadioButton radNotsuYamawake2;
    @JsonProperty("demoTest")
    private Button demoTest;
    @JsonProperty("ccdBunshoBangoKetteiTsuchi")
    private BunshoBangoInputDiv ccdBunshoBangoKetteiTsuchi;

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
     * gettxtTokuKaishiTsuchiHakkoYMD2
     * @return txtTokuKaishiTsuchiHakkoYMD2
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD2")
    public TextBoxDate getTxtTokuKaishiTsuchiHakkoYMD2() {
        return txtTokuKaishiTsuchiHakkoYMD2;
    }

    /*
     * settxtTokuKaishiTsuchiHakkoYMD2
     * @param txtTokuKaishiTsuchiHakkoYMD2 txtTokuKaishiTsuchiHakkoYMD2
     */
    @JsonProperty("txtTokuKaishiTsuchiHakkoYMD2")
    public void setTxtTokuKaishiTsuchiHakkoYMD2(TextBoxDate txtTokuKaishiTsuchiHakkoYMD2) {
        this.txtTokuKaishiTsuchiHakkoYMD2 = txtTokuKaishiTsuchiHakkoYMD2;
    }

    /*
     * getradTokuKaishiTsuchiTaisho2
     * @return radTokuKaishiTsuchiTaisho2
     */
    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    public RadioButton getRadTokuKaishiTsuchiTaisho2() {
        return radTokuKaishiTsuchiTaisho2;
    }

    /*
     * setradTokuKaishiTsuchiTaisho2
     * @param radTokuKaishiTsuchiTaisho2 radTokuKaishiTsuchiTaisho2
     */
    @JsonProperty("radTokuKaishiTsuchiTaisho2")
    public void setRadTokuKaishiTsuchiTaisho2(RadioButton radTokuKaishiTsuchiTaisho2) {
        this.radTokuKaishiTsuchiTaisho2 = radTokuKaishiTsuchiTaisho2;
    }

    /*
     * getlblKetteTsuchi
     * @return lblKetteTsuchi
     */
    @JsonProperty("lblKetteTsuchi")
    public Label getLblKetteTsuchi() {
        return lblKetteTsuchi;
    }

    /*
     * setlblKetteTsuchi
     * @param lblKetteTsuchi lblKetteTsuchi
     */
    @JsonProperty("lblKetteTsuchi")
    public void setLblKetteTsuchi(Label lblKetteTsuchi) {
        this.lblKetteTsuchi = lblKetteTsuchi;
    }

    /*
     * gettxtKetteTsuchiHakkoYMD2
     * @return txtKetteTsuchiHakkoYMD2
     */
    @JsonProperty("txtKetteTsuchiHakkoYMD2")
    public TextBoxDate getTxtKetteTsuchiHakkoYMD2() {
        return txtKetteTsuchiHakkoYMD2;
    }

    /*
     * settxtKetteTsuchiHakkoYMD2
     * @param txtKetteTsuchiHakkoYMD2 txtKetteTsuchiHakkoYMD2
     */
    @JsonProperty("txtKetteTsuchiHakkoYMD2")
    public void setTxtKetteTsuchiHakkoYMD2(TextBoxDate txtKetteTsuchiHakkoYMD2) {
        this.txtKetteTsuchiHakkoYMD2 = txtKetteTsuchiHakkoYMD2;
    }

    /*
     * getbtnKetteiTsuchiYousikiSettei2
     * @return btnKetteiTsuchiYousikiSettei2
     */
    @JsonProperty("btnKetteiTsuchiYousikiSettei2")
    public Button getBtnKetteiTsuchiYousikiSettei2() {
        return btnKetteiTsuchiYousikiSettei2;
    }

    /*
     * setbtnKetteiTsuchiYousikiSettei2
     * @param btnKetteiTsuchiYousikiSettei2 btnKetteiTsuchiYousikiSettei2
     */
    @JsonProperty("btnKetteiTsuchiYousikiSettei2")
    public void setBtnKetteiTsuchiYousikiSettei2(Button btnKetteiTsuchiYousikiSettei2) {
        this.btnKetteiTsuchiYousikiSettei2 = btnKetteiTsuchiYousikiSettei2;
    }

    /*
     * gettxtKetteiTsuchiYousikiSettei
     * @return txtKetteiTsuchiYousikiSettei
     */
    @JsonProperty("txtKetteiTsuchiYousikiSettei")
    public TextBox getTxtKetteiTsuchiYousikiSettei() {
        return txtKetteiTsuchiYousikiSettei;
    }

    /*
     * settxtKetteiTsuchiYousikiSettei
     * @param txtKetteiTsuchiYousikiSettei txtKetteiTsuchiYousikiSettei
     */
    @JsonProperty("txtKetteiTsuchiYousikiSettei")
    public void setTxtKetteiTsuchiYousikiSettei(TextBox txtKetteiTsuchiYousikiSettei) {
        this.txtKetteiTsuchiYousikiSettei = txtKetteiTsuchiYousikiSettei;
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
     * gettxtNotsuHakkoYMD2
     * @return txtNotsuHakkoYMD2
     */
    @JsonProperty("txtNotsuHakkoYMD2")
    public TextBoxDate getTxtNotsuHakkoYMD2() {
        return txtNotsuHakkoYMD2;
    }

    /*
     * settxtNotsuHakkoYMD2
     * @param txtNotsuHakkoYMD2 txtNotsuHakkoYMD2
     */
    @JsonProperty("txtNotsuHakkoYMD2")
    public void setTxtNotsuHakkoYMD2(TextBoxDate txtNotsuHakkoYMD2) {
        this.txtNotsuHakkoYMD2 = txtNotsuHakkoYMD2;
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
     * gettxtShutsuryokuHoho
     * @return txtShutsuryokuHoho
     */
    @JsonProperty("txtShutsuryokuHoho")
    public TextBox getTxtShutsuryokuHoho() {
        return txtShutsuryokuHoho;
    }

    /*
     * settxtShutsuryokuHoho
     * @param txtShutsuryokuHoho txtShutsuryokuHoho
     */
    @JsonProperty("txtShutsuryokuHoho")
    public void setTxtShutsuryokuHoho(TextBox txtShutsuryokuHoho) {
        this.txtShutsuryokuHoho = txtShutsuryokuHoho;
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

    /*
     * getdemoTest
     * @return demoTest
     */
    @JsonProperty("demoTest")
    public Button getDemoTest() {
        return demoTest;
    }

    /*
     * setdemoTest
     * @param demoTest demoTest
     */
    @JsonProperty("demoTest")
    public void setDemoTest(Button demoTest) {
        this.demoTest = demoTest;
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
