package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KarisanteiIdoFukaChohyoHakko のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KarisanteiIdoFukaChohyoHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KariSanteiTsuchiKobetsuJoho")
    private KariSanteiTsuchiKobetsuJohoDiv KariSanteiTsuchiKobetsuJoho;
    @JsonProperty("ccdChohyoIchiran")
    private OutputChohyoIchiranDiv ccdChohyoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKariSanteiTsuchiKobetsuJoho
     * @return KariSanteiTsuchiKobetsuJoho
     */
    @JsonProperty("KariSanteiTsuchiKobetsuJoho")
    public KariSanteiTsuchiKobetsuJohoDiv getKariSanteiTsuchiKobetsuJoho() {
        return KariSanteiTsuchiKobetsuJoho;
    }

    /*
     * setKariSanteiTsuchiKobetsuJoho
     * @param KariSanteiTsuchiKobetsuJoho KariSanteiTsuchiKobetsuJoho
     */
    @JsonProperty("KariSanteiTsuchiKobetsuJoho")
    public void setKariSanteiTsuchiKobetsuJoho(KariSanteiTsuchiKobetsuJohoDiv KariSanteiTsuchiKobetsuJoho) {
        this.KariSanteiTsuchiKobetsuJoho = KariSanteiTsuchiKobetsuJoho;
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
    public Label getLblTokuKaishiTsuchi() {
        return this.getKariSanteiTsuchiKobetsuJoho().getLblTokuKaishiTsuchi();
    }

    @JsonIgnore
    public void setLblTokuKaishiTsuchi(Label lblTokuKaishiTsuchi) {
        this.getKariSanteiTsuchiKobetsuJoho().setLblTokuKaishiTsuchi(lblTokuKaishiTsuchi);
    }

    @JsonIgnore
    public TextBoxDate getTxtTokuKaishiTsuchiHakkoYMD() {
        return this.getKariSanteiTsuchiKobetsuJoho().getTxtTokuKaishiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtTokuKaishiTsuchiHakkoYMD(TextBoxDate txtTokuKaishiTsuchiHakkoYMD) {
        this.getKariSanteiTsuchiKobetsuJoho().setTxtTokuKaishiTsuchiHakkoYMD(txtTokuKaishiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public Label getLblKariHenkoTsuchi() {
        return this.getKariSanteiTsuchiKobetsuJoho().getLblKariHenkoTsuchi();
    }

    @JsonIgnore
    public void setLblKariHenkoTsuchi(Label lblKariHenkoTsuchi) {
        this.getKariSanteiTsuchiKobetsuJoho().setLblKariHenkoTsuchi(lblKariHenkoTsuchi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKariHenkoTsuchiHakkoYMD() {
        return this.getKariSanteiTsuchiKobetsuJoho().getTxtKariHenkoTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKariHenkoTsuchiHakkoYMD(TextBoxDate txtKariHenkoTsuchiHakkoYMD) {
        this.getKariSanteiTsuchiKobetsuJoho().setTxtKariHenkoTsuchiHakkoYMD(txtKariHenkoTsuchiHakkoYMD);
    }

    @JsonIgnore
    public Label getLblNotsu() {
        return this.getKariSanteiTsuchiKobetsuJoho().getLblNotsu();
    }

    @JsonIgnore
    public void setLblNotsu(Label lblNotsu) {
        this.getKariSanteiTsuchiKobetsuJoho().setLblNotsu(lblNotsu);
    }

    @JsonIgnore
    public TextBoxDate getTxtNotsuHakkoYMD() {
        return this.getKariSanteiTsuchiKobetsuJoho().getTxtNotsuHakkoYMD();
    }

    @JsonIgnore
    public void setTxtNotsuHakkoYMD(TextBoxDate txtNotsuHakkoYMD) {
        this.getKariSanteiTsuchiKobetsuJoho().setTxtNotsuHakkoYMD(txtNotsuHakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtNotsuShutsuryokuKi() {
        return this.getKariSanteiTsuchiKobetsuJoho().getTxtNotsuShutsuryokuKi();
    }

    @JsonIgnore
    public void setTxtNotsuShutsuryokuKi(TextBox txtNotsuShutsuryokuKi) {
        this.getKariSanteiTsuchiKobetsuJoho().setTxtNotsuShutsuryokuKi(txtNotsuShutsuryokuKi);
    }

    @JsonIgnore
    public DropDownList getDdlNotsuShuturyokuki() {
        return this.getKariSanteiTsuchiKobetsuJoho().getDdlNotsuShuturyokuki();
    }

    @JsonIgnore
    public void setDdlNotsuShuturyokuki(DropDownList ddlNotsuShuturyokuki) {
        this.getKariSanteiTsuchiKobetsuJoho().setDdlNotsuShuturyokuki(ddlNotsuShuturyokuki);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishosha() {
        return this.getKariSanteiTsuchiKobetsuJoho().getChkNotsuTaishosha();
    }

    @JsonIgnore
    public void setChkNotsuTaishosha(CheckBoxList chkNotsuTaishosha) {
        this.getKariSanteiTsuchiKobetsuJoho().setChkNotsuTaishosha(chkNotsuTaishosha);
    }

    @JsonIgnore
    public RadioButton getRadNotsuSeikatsuHogo() {
        return this.getKariSanteiTsuchiKobetsuJoho().getRadNotsuSeikatsuHogo();
    }

    @JsonIgnore
    public void setRadNotsuSeikatsuHogo(RadioButton radNotsuSeikatsuHogo) {
        this.getKariSanteiTsuchiKobetsuJoho().setRadNotsuSeikatsuHogo(radNotsuSeikatsuHogo);
    }

    @JsonIgnore
    public RadioButton getRadNotsuYamawake() {
        return this.getKariSanteiTsuchiKobetsuJoho().getRadNotsuYamawake();
    }

    @JsonIgnore
    public void setRadNotsuYamawake(RadioButton radNotsuYamawake) {
        this.getKariSanteiTsuchiKobetsuJoho().setRadNotsuYamawake(radNotsuYamawake);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBango() {
        return this.getKariSanteiTsuchiKobetsuJoho().getCcdBunshoBango();
    }

    // </editor-fold>
}
