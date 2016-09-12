package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * KarisanteiIdoFukaBatchParameter のクラスファイル
 *
 * @reamsid_L DBB-0890-010 wangkanglei
 */
public class KarisanteiIdoFukaBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShoriJokyo")
    private ShoriJokyoDiv ShoriJokyo;
    @JsonProperty("KarisanteiIdoFukaKanriInfo")
    private KarisanteiIdoFukaKanriInfoDiv KarisanteiIdoFukaKanriInfo;
    @JsonProperty("KarisanteiIdoFukaChohyoHakko")
    private KarisanteiIdoFukaChohyoHakkoDiv KarisanteiIdoFukaChohyoHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShoriJokyo
     * @return ShoriJokyo
     */
    @JsonProperty("ShoriJokyo")
    public ShoriJokyoDiv getShoriJokyo() {
        return ShoriJokyo;
    }

    /*
     * setShoriJokyo
     * @param ShoriJokyo ShoriJokyo
     */
    @JsonProperty("ShoriJokyo")
    public void setShoriJokyo(ShoriJokyoDiv ShoriJokyo) {
        this.ShoriJokyo = ShoriJokyo;
    }

    /*
     * getKarisanteiIdoFukaKanriInfo
     * @return KarisanteiIdoFukaKanriInfo
     */
    @JsonProperty("KarisanteiIdoFukaKanriInfo")
    public KarisanteiIdoFukaKanriInfoDiv getKarisanteiIdoFukaKanriInfo() {
        return KarisanteiIdoFukaKanriInfo;
    }

    /*
     * setKarisanteiIdoFukaKanriInfo
     * @param KarisanteiIdoFukaKanriInfo KarisanteiIdoFukaKanriInfo
     */
    @JsonProperty("KarisanteiIdoFukaKanriInfo")
    public void setKarisanteiIdoFukaKanriInfo(KarisanteiIdoFukaKanriInfoDiv KarisanteiIdoFukaKanriInfo) {
        this.KarisanteiIdoFukaKanriInfo = KarisanteiIdoFukaKanriInfo;
    }

    /*
     * getKarisanteiIdoFukaChohyoHakko
     * @return KarisanteiIdoFukaChohyoHakko
     */
    @JsonProperty("KarisanteiIdoFukaChohyoHakko")
    public KarisanteiIdoFukaChohyoHakkoDiv getKarisanteiIdoFukaChohyoHakko() {
        return KarisanteiIdoFukaChohyoHakko;
    }

    /*
     * setKarisanteiIdoFukaChohyoHakko
     * @param KarisanteiIdoFukaChohyoHakko KarisanteiIdoFukaChohyoHakko
     */
    @JsonProperty("KarisanteiIdoFukaChohyoHakko")
    public void setKarisanteiIdoFukaChohyoHakko(KarisanteiIdoFukaChohyoHakkoDiv KarisanteiIdoFukaChohyoHakko) {
        this.KarisanteiIdoFukaChohyoHakko = KarisanteiIdoFukaChohyoHakko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgHokenryoDankai_Row> getDgHokenryoDankai() {
        return this.getShoriJokyo().getKanriJohoKakunin().getDgHokenryoDankai();
    }

    @JsonIgnore
    public void setDgHokenryoDankai(DataGrid<dgHokenryoDankai_Row> dgHokenryoDankai) {
        this.getShoriJokyo().getKanriJohoKakunin().setDgHokenryoDankai(dgHokenryoDankai);
    }

    @JsonIgnore
    public DataGrid<dgKomokuNaiyo_Row> getDgKomokuNaiyo() {
        return this.getShoriJokyo().getKanriJohoKakunin().getDgKomokuNaiyo();
    }

    @JsonIgnore
    public void setDgKomokuNaiyo(DataGrid<dgKomokuNaiyo_Row> dgKomokuNaiyo) {
        this.getShoriJokyo().getKanriJohoKakunin().setDgKomokuNaiyo(dgKomokuNaiyo);
    }

    @JsonIgnore
    public TextBox getTxtTaishoTokuchoKaishiTsuki() {
        return this.getShoriJokyo().getTokuchoHosoku().getTxtTaishoTokuchoKaishiTsuki();
    }

    @JsonIgnore
    public void setTxtTaishoTokuchoKaishiTsuki(TextBox txtTaishoTokuchoKaishiTsuki) {
        this.getShoriJokyo().getTokuchoHosoku().setTxtTaishoTokuchoKaishiTsuki(txtTaishoTokuchoKaishiTsuki);
    }

    @JsonIgnore
    public RadioButton getRadTokuchoHosokuIraiKingakuKeisan() {
        return this.getShoriJokyo().getTokuchoHosoku().getRadTokuchoHosokuIraiKingakuKeisan();
    }

    @JsonIgnore
    public void setRadTokuchoHosokuIraiKingakuKeisan(RadioButton radTokuchoHosokuIraiKingakuKeisan) {
        this.getShoriJokyo().getTokuchoHosoku().setRadTokuchoHosokuIraiKingakuKeisan(radTokuchoHosokuIraiKingakuKeisan);
    }

    @JsonIgnore
    public Label getLblTokuKaishiTsuchi() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getLblTokuKaishiTsuchi();
    }

    @JsonIgnore
    public void setLblTokuKaishiTsuchi(Label lblTokuKaishiTsuchi) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setLblTokuKaishiTsuchi(lblTokuKaishiTsuchi);
    }

    @JsonIgnore
    public TextBoxDate getTxtTokuKaishiTsuchiHakkoYMD() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtTokuKaishiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtTokuKaishiTsuchiHakkoYMD(TextBoxDate txtTokuKaishiTsuchiHakkoYMD) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setTxtTokuKaishiTsuchiHakkoYMD(txtTokuKaishiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public Label getLblKariHenkoTsuchi() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getLblKariHenkoTsuchi();
    }

    @JsonIgnore
    public void setLblKariHenkoTsuchi(Label lblKariHenkoTsuchi) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setLblKariHenkoTsuchi(lblKariHenkoTsuchi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKariHenkoTsuchiHakkoYMD() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtKariHenkoTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKariHenkoTsuchiHakkoYMD(TextBoxDate txtKariHenkoTsuchiHakkoYMD) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setTxtKariHenkoTsuchiHakkoYMD(txtKariHenkoTsuchiHakkoYMD);
    }

    @JsonIgnore
    public Label getLblNotsu() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getLblNotsu();
    }

    @JsonIgnore
    public void setLblNotsu(Label lblNotsu) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setLblNotsu(lblNotsu);
    }

    @JsonIgnore
    public TextBoxDate getTxtNotsuHakkoYMD() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtNotsuHakkoYMD();
    }

    @JsonIgnore
    public void setTxtNotsuHakkoYMD(TextBoxDate txtNotsuHakkoYMD) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setTxtNotsuHakkoYMD(txtNotsuHakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtNotsuShutsuryokuKi() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getTxtNotsuShutsuryokuKi();
    }

    @JsonIgnore
    public void setTxtNotsuShutsuryokuKi(TextBox txtNotsuShutsuryokuKi) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setTxtNotsuShutsuryokuKi(txtNotsuShutsuryokuKi);
    }

    @JsonIgnore
    public DropDownList getDdlNotsuShuturyokuki() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getDdlNotsuShuturyokuki();
    }

    @JsonIgnore
    public void setDdlNotsuShuturyokuki(DropDownList ddlNotsuShuturyokuki) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setDdlNotsuShuturyokuki(ddlNotsuShuturyokuki);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishosha() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getChkNotsuTaishosha();
    }

    @JsonIgnore
    public void setChkNotsuTaishosha(CheckBoxList chkNotsuTaishosha) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setChkNotsuTaishosha(chkNotsuTaishosha);
    }

    @JsonIgnore
    public RadioButton getRadNotsuSeikatsuHogo() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getRadNotsuSeikatsuHogo();
    }

    @JsonIgnore
    public void setRadNotsuSeikatsuHogo(RadioButton radNotsuSeikatsuHogo) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setRadNotsuSeikatsuHogo(radNotsuSeikatsuHogo);
    }

    @JsonIgnore
    public RadioButton getRadNotsuYamawake() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getRadNotsuYamawake();
    }

    @JsonIgnore
    public void setRadNotsuYamawake(RadioButton radNotsuYamawake) {
        this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().setRadNotsuYamawake(radNotsuYamawake);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBango() {
        return this.getKarisanteiIdoFukaChohyoHakko().getKariSanteiTsuchiKobetsuJoho().getCcdBunshoBango();
    }

    // </editor-fold>
}
