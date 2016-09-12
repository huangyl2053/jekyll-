package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0510001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.IOutputChohyoIchiranDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.OutputChohyoIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * HonsanteiIdoChohyoHakko のクラスファイル
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public class HonsanteiIdoChohyoHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HonSanteiIdoTsuchiKobetsuJoho")
    private HonSanteiIdoTsuchiKobetsuJohoDiv HonSanteiIdoTsuchiKobetsuJoho;
    @JsonProperty("ccdChohyoIchiran")
    private OutputChohyoIchiranDiv ccdChohyoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHonSanteiIdoTsuchiKobetsuJoho
     * @return HonSanteiIdoTsuchiKobetsuJoho
     */
    @JsonProperty("HonSanteiIdoTsuchiKobetsuJoho")
    public HonSanteiIdoTsuchiKobetsuJohoDiv getHonSanteiIdoTsuchiKobetsuJoho() {
        return HonSanteiIdoTsuchiKobetsuJoho;
    }

    /*
     * setHonSanteiIdoTsuchiKobetsuJoho
     * @param HonSanteiIdoTsuchiKobetsuJoho HonSanteiIdoTsuchiKobetsuJoho
     */
    @JsonProperty("HonSanteiIdoTsuchiKobetsuJoho")
    public void setHonSanteiIdoTsuchiKobetsuJoho(HonSanteiIdoTsuchiKobetsuJohoDiv HonSanteiIdoTsuchiKobetsuJoho) {
        this.HonSanteiIdoTsuchiKobetsuJoho = HonSanteiIdoTsuchiKobetsuJoho;
    }

    /*
     * getccdChohyoIchiran
     * @return ccdChohyoIchiran
     */
    @JsonProperty("ccdChohyoIchiran")
    public IOutputChohyoIchiranDiv getCcdChohyoIchiran() {
        return ccdChohyoIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTokuchoKaishiTsuchi() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getLblTokuchoKaishiTsuchi();
    }

    @JsonIgnore
    public void setLblTokuchoKaishiTsuchi(Label lblTokuchoKaishiTsuchi) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setLblTokuchoKaishiTsuchi(lblTokuchoKaishiTsuchi);
    }

    @JsonIgnore
    public RadioButton getRadTokuchoKaishiTsuchiTaishosha() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getRadTokuchoKaishiTsuchiTaishosha();
    }

    @JsonIgnore
    public void setRadTokuchoKaishiTsuchiTaishosha(RadioButton radTokuchoKaishiTsuchiTaishosha) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setRadTokuchoKaishiTsuchiTaishosha(radTokuchoKaishiTsuchiTaishosha);
    }

    @JsonIgnore
    public TextBoxDate getTxtTokuchoKaishiTsuchishoHakkoYMD() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getTxtTokuchoKaishiTsuchishoHakkoYMD();
    }

    @JsonIgnore
    public void setTxtTokuchoKaishiTsuchishoHakkoYMD(TextBoxDate txtTokuchoKaishiTsuchishoHakkoYMD) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setTxtTokuchoKaishiTsuchishoHakkoYMD(txtTokuchoKaishiTsuchishoHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkKetteiTsuchi() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getChkKetteiTsuchi();
    }

    @JsonIgnore
    public void setChkKetteiTsuchi(CheckBoxList chkKetteiTsuchi) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setChkKetteiTsuchi(chkKetteiTsuchi);
    }

    @JsonIgnore
    public Label getLblKetteiTsuchi() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getLblKetteiTsuchi();
    }

    @JsonIgnore
    public void setLblKetteiTsuchi(Label lblKetteiTsuchi) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setLblKetteiTsuchi(lblKetteiTsuchi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiTsuchiHakkoYMD() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchiHakkoYMD(TextBoxDate txtKetteiTsuchiHakkoYMD) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setTxtKetteiTsuchiHakkoYMD(txtKetteiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchi() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getChkHenkoTsuchi();
    }

    @JsonIgnore
    public void setChkHenkoTsuchi(CheckBoxList chkHenkoTsuchi) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setChkHenkoTsuchi(chkHenkoTsuchi);
    }

    @JsonIgnore
    public Label getLblHenkoTsuchi() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getLblHenkoTsuchi();
    }

    @JsonIgnore
    public void setLblHenkoTsuchi(Label lblHenkoTsuchi) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setLblHenkoTsuchi(lblHenkoTsuchi);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchiTaishosha() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha();
    }

    @JsonIgnore
    public void setChkHenkoTsuchiTaishosha(CheckBoxList chkHenkoTsuchiTaishosha) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setChkHenkoTsuchiTaishosha(chkHenkoTsuchiTaishosha);
    }

    @JsonIgnore
    public TextBox getTxtHenkoTsuchiKozaIdoNomiShutsuryoku() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiKozaIdoNomiShutsuryoku();
    }

    @JsonIgnore
    public void setTxtHenkoTsuchiKozaIdoNomiShutsuryoku(TextBox txtHenkoTsuchiKozaIdoNomiShutsuryoku) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setTxtHenkoTsuchiKozaIdoNomiShutsuryoku(txtHenkoTsuchiKozaIdoNomiShutsuryoku);
    }

    @JsonIgnore
    public TextBoxDate getTxtHenkoTsuchiHakkoYMD() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtHenkoTsuchiHakkoYMD(TextBoxDate txtHenkoTsuchiHakkoYMD) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setTxtHenkoTsuchiHakkoYMD(txtHenkoTsuchiHakkoYMD);
    }

    @JsonIgnore
    public Label getLblNotsu() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getLblNotsu();
    }

    @JsonIgnore
    public void setLblNotsu(Label lblNotsu) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setLblNotsu(lblNotsu);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishoSha() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getChkNotsuTaishoSha();
    }

    @JsonIgnore
    public void setChkNotsuTaishoSha(CheckBoxList chkNotsuTaishoSha) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setChkNotsuTaishoSha(chkNotsuTaishoSha);
    }

    @JsonIgnore
    public TextBox getTxtNotsuKozaIdoNomiShutsuryoku() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuKozaIdoNomiShutsuryoku();
    }

    @JsonIgnore
    public void setTxtNotsuKozaIdoNomiShutsuryoku(TextBox txtNotsuKozaIdoNomiShutsuryoku) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuKozaIdoNomiShutsuryoku(txtNotsuKozaIdoNomiShutsuryoku);
    }

    @JsonIgnore
    public RadioButton getRadNotsuKozaShutsuryokuYoshiki() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getRadNotsuKozaShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setRadNotsuKozaShutsuryokuYoshiki(RadioButton radNotsuKozaShutsuryokuYoshiki) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setRadNotsuKozaShutsuryokuYoshiki(radNotsuKozaShutsuryokuYoshiki);
    }

    @JsonIgnore
    public Label getTxtNotsuMsgAboutShutsuryokuYoshiki() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuMsgAboutShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setTxtNotsuMsgAboutShutsuryokuYoshiki(Label txtNotsuMsgAboutShutsuryokuYoshiki) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuMsgAboutShutsuryokuYoshiki(txtNotsuMsgAboutShutsuryokuYoshiki);
    }

    @JsonIgnore
    public TextBoxDate getTxtNotsuHakkoYMD() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuHakkoYMD();
    }

    @JsonIgnore
    public void setTxtNotsuHakkoYMD(TextBoxDate txtNotsuHakkoYMD) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuHakkoYMD(txtNotsuHakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtNotsuShutsuryokuKi() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuShutsuryokuKi();
    }

    @JsonIgnore
    public void setTxtNotsuShutsuryokuKi(TextBox txtNotsuShutsuryokuKi) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuShutsuryokuKi(txtNotsuShutsuryokuKi);
    }

    @JsonIgnore
    public DropDownList getDdlNotsuShuturyokuki() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getDdlNotsuShuturyokuki();
    }

    @JsonIgnore
    public void setDdlNotsuShuturyokuki(DropDownList ddlNotsuShuturyokuki) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setDdlNotsuShuturyokuki(ddlNotsuShuturyokuki);
    }

    @JsonIgnore
    public RadioButton getRadNotsuSeikatsuHogo() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getRadNotsuSeikatsuHogo();
    }

    @JsonIgnore
    public void setRadNotsuSeikatsuHogo(RadioButton radNotsuSeikatsuHogo) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setRadNotsuSeikatsuHogo(radNotsuSeikatsuHogo);
    }

    @JsonIgnore
    public RadioButton getRadNotsuYamawake() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getRadNotsuYamawake();
    }

    @JsonIgnore
    public void setRadNotsuYamawake(RadioButton radNotsuYamawake) {
        this.getHonSanteiIdoTsuchiKobetsuJoho().setRadNotsuYamawake(radNotsuYamawake);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBushiNoKetteiTsuchi() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getCcdBushiNoKetteiTsuchi();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoHenkoTsuchi() {
        return this.getHonSanteiIdoTsuchiKobetsuJoho().getCcdBunshoBangoHenkoTsuchi();
    }

    // </editor-fold>
}
