package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0550001;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * KanendoFukaChohyoHakko のクラスファイル
 *
 * @reamsid_L DBB-0920-010 quxiaodong
 */
public class KanendoFukaChohyoHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HonSanteiKanendoIdoTsuchiKobetsuJoho")
    private HonSanteiKanendoIdoTsuchiKobetsuJohoDiv HonSanteiKanendoIdoTsuchiKobetsuJoho;
    @JsonProperty("ccdChohyoIchiran")
    private OutputChohyoIchiranDiv ccdChohyoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHonSanteiKanendoIdoTsuchiKobetsuJoho
     * @return HonSanteiKanendoIdoTsuchiKobetsuJoho
     */
    @JsonProperty("HonSanteiKanendoIdoTsuchiKobetsuJoho")
    public HonSanteiKanendoIdoTsuchiKobetsuJohoDiv getHonSanteiKanendoIdoTsuchiKobetsuJoho() {
        return HonSanteiKanendoIdoTsuchiKobetsuJoho;
    }

    /*
     * setHonSanteiKanendoIdoTsuchiKobetsuJoho
     * @param HonSanteiKanendoIdoTsuchiKobetsuJoho HonSanteiKanendoIdoTsuchiKobetsuJoho
     */
    @JsonProperty("HonSanteiKanendoIdoTsuchiKobetsuJoho")
    public void setHonSanteiKanendoIdoTsuchiKobetsuJoho(HonSanteiKanendoIdoTsuchiKobetsuJohoDiv HonSanteiKanendoIdoTsuchiKobetsuJoho) {
        this.HonSanteiKanendoIdoTsuchiKobetsuJoho = HonSanteiKanendoIdoTsuchiKobetsuJoho;
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
    public CheckBoxList getChkKetteiTsuchi() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi();
    }

    @JsonIgnore
    public void setChkKetteiTsuchi(CheckBoxList chkKetteiTsuchi) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkKetteiTsuchi(chkKetteiTsuchi);
    }

    @JsonIgnore
    public Label getLblKetteiTsuchi() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getLblKetteiTsuchi();
    }

    @JsonIgnore
    public void setLblKetteiTsuchi(Label lblKetteiTsuchi) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setLblKetteiTsuchi(lblKetteiTsuchi);
    }

    @JsonIgnore
    public CheckBoxList getChkKetteiTsuchiTaishoNendo() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchiTaishoNendo();
    }

    @JsonIgnore
    public void setChkKetteiTsuchiTaishoNendo(CheckBoxList chkKetteiTsuchiTaishoNendo) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkKetteiTsuchiTaishoNendo(chkKetteiTsuchiTaishoNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiTsuchiHakkoYMD() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchiHakkoYMD(TextBoxDate txtKetteiTsuchiHakkoYMD) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtKetteiTsuchiHakkoYMD(txtKetteiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchi() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi();
    }

    @JsonIgnore
    public void setChkHenkoTsuchi(CheckBoxList chkHenkoTsuchi) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkHenkoTsuchi(chkHenkoTsuchi);
    }

    @JsonIgnore
    public Label getLblHenkoTsuchi() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getLblHenkoTsuchi();
    }

    @JsonIgnore
    public void setLblHenkoTsuchi(Label lblHenkoTsuchi) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setLblHenkoTsuchi(lblHenkoTsuchi);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchiTaishoFukaNendo() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishoFukaNendo();
    }

    @JsonIgnore
    public void setChkHenkoTsuchiTaishoFukaNendo(CheckBoxList chkHenkoTsuchiTaishoFukaNendo) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkHenkoTsuchiTaishoFukaNendo(chkHenkoTsuchiTaishoFukaNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtHenkoTsuchiHakkoYMD() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtHenkoTsuchiHakkoYMD(TextBoxDate txtHenkoTsuchiHakkoYMD) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtHenkoTsuchiHakkoYMD(txtHenkoTsuchiHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchiTaishosha() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha();
    }

    @JsonIgnore
    public void setChkHenkoTsuchiTaishosha(CheckBoxList chkHenkoTsuchiTaishosha) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkHenkoTsuchiTaishosha(chkHenkoTsuchiTaishosha);
    }

    @JsonIgnore
    public Label getLblNotsu() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getLblNotsu();
    }

    @JsonIgnore
    public void setLblNotsu(Label lblNotsu) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setLblNotsu(lblNotsu);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishoFukaNedno() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishoFukaNedno();
    }

    @JsonIgnore
    public void setChkNotsuTaishoFukaNedno(CheckBoxList chkNotsuTaishoFukaNedno) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkNotsuTaishoFukaNedno(chkNotsuTaishoFukaNedno);
    }

    @JsonIgnore
    public TextBoxDate getTxtNotsuHakkoYMD() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtNotsuHakkoYMD();
    }

    @JsonIgnore
    public void setTxtNotsuHakkoYMD(TextBoxDate txtNotsuHakkoYMD) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtNotsuHakkoYMD(txtNotsuHakkoYMD);
    }

    @JsonIgnore
    public DropDownList getDdlNotsuShutsuryokuKi() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getDdlNotsuShutsuryokuKi();
    }

    @JsonIgnore
    public void setDdlNotsuShutsuryokuKi(DropDownList ddlNotsuShutsuryokuKi) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setDdlNotsuShutsuryokuKi(ddlNotsuShutsuryokuKi);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishosha() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha();
    }

    @JsonIgnore
    public void setChkNotsuTaishosha(CheckBoxList chkNotsuTaishosha) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkNotsuTaishosha(chkNotsuTaishosha);
    }

    @JsonIgnore
    public RadioButton getRadNotsuKozaShutsuryokuYoshiki() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuKozaShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setRadNotsuKozaShutsuryokuYoshiki(RadioButton radNotsuKozaShutsuryokuYoshiki) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setRadNotsuKozaShutsuryokuYoshiki(radNotsuKozaShutsuryokuYoshiki);
    }

    @JsonIgnore
    public Label getTxtNotsuMsgAboutShutsuryokuYoshiki() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtNotsuMsgAboutShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setTxtNotsuMsgAboutShutsuryokuYoshiki(Label txtNotsuMsgAboutShutsuryokuYoshiki) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtNotsuMsgAboutShutsuryokuYoshiki(txtNotsuMsgAboutShutsuryokuYoshiki);
    }

    @JsonIgnore
    public RadioButton getRadNotsuSeikatsuHogo() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuSeikatsuHogo();
    }

    @JsonIgnore
    public void setRadNotsuSeikatsuHogo(RadioButton radNotsuSeikatsuHogo) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setRadNotsuSeikatsuHogo(radNotsuSeikatsuHogo);
    }

    @JsonIgnore
    public RadioButton getRadNotsuYamawake() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuYamawake();
    }

    @JsonIgnore
    public void setRadNotsuYamawake(RadioButton radNotsuYamawake) {
        this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().setRadNotsuYamawake(radNotsuYamawake);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoHenkoTsuchi() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getCcdBunshoBangoHenkoTsuchi();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoKetteiTsuchi() {
        return this.getHonSanteiKanendoIdoTsuchiKobetsuJoho().getCcdBunshoBangoKetteiTsuchi();
    }

    // </editor-fold>
}
