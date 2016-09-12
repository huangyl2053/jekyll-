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
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * KanendoFukaBatchParameter のクラスファイル
 *
 * @reamsid_L DBB-0920-010 quxiaodong
 */
public class KanendoFukaBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanendoShoriNaiyo")
    private KanendoShoriNaiyoDiv KanendoShoriNaiyo;
    @JsonProperty("ShoriKakunin")
    private ShoriKakuninDiv ShoriKakunin;
    @JsonProperty("KanendoFukaChushutsuJoken")
    private KanendoFukaChushutsuJokenDiv KanendoFukaChushutsuJoken;
    @JsonProperty("KanendoFukaChohyoHakko")
    private KanendoFukaChohyoHakkoDiv KanendoFukaChohyoHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKanendoShoriNaiyo
     * @return KanendoShoriNaiyo
     */
    @JsonProperty("KanendoShoriNaiyo")
    public KanendoShoriNaiyoDiv getKanendoShoriNaiyo() {
        return KanendoShoriNaiyo;
    }

    /*
     * setKanendoShoriNaiyo
     * @param KanendoShoriNaiyo KanendoShoriNaiyo
     */
    @JsonProperty("KanendoShoriNaiyo")
    public void setKanendoShoriNaiyo(KanendoShoriNaiyoDiv KanendoShoriNaiyo) {
        this.KanendoShoriNaiyo = KanendoShoriNaiyo;
    }

    /*
     * getShoriKakunin
     * @return ShoriKakunin
     */
    @JsonProperty("ShoriKakunin")
    public ShoriKakuninDiv getShoriKakunin() {
        return ShoriKakunin;
    }

    /*
     * setShoriKakunin
     * @param ShoriKakunin ShoriKakunin
     */
    @JsonProperty("ShoriKakunin")
    public void setShoriKakunin(ShoriKakuninDiv ShoriKakunin) {
        this.ShoriKakunin = ShoriKakunin;
    }

    /*
     * getKanendoFukaChushutsuJoken
     * @return KanendoFukaChushutsuJoken
     */
    @JsonProperty("KanendoFukaChushutsuJoken")
    public KanendoFukaChushutsuJokenDiv getKanendoFukaChushutsuJoken() {
        return KanendoFukaChushutsuJoken;
    }

    /*
     * setKanendoFukaChushutsuJoken
     * @param KanendoFukaChushutsuJoken KanendoFukaChushutsuJoken
     */
    @JsonProperty("KanendoFukaChushutsuJoken")
    public void setKanendoFukaChushutsuJoken(KanendoFukaChushutsuJokenDiv KanendoFukaChushutsuJoken) {
        this.KanendoFukaChushutsuJoken = KanendoFukaChushutsuJoken;
    }

    /*
     * getKanendoFukaChohyoHakko
     * @return KanendoFukaChohyoHakko
     */
    @JsonProperty("KanendoFukaChohyoHakko")
    public KanendoFukaChohyoHakkoDiv getKanendoFukaChohyoHakko() {
        return KanendoFukaChohyoHakko;
    }

    /*
     * setKanendoFukaChohyoHakko
     * @param KanendoFukaChohyoHakko KanendoFukaChohyoHakko
     */
    @JsonProperty("KanendoFukaChohyoHakko")
    public void setKanendoFukaChohyoHakko(KanendoFukaChohyoHakkoDiv KanendoFukaChohyoHakko) {
        this.KanendoFukaChohyoHakko = KanendoFukaChohyoHakko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxYear getTxtChoteiNendo() {
        return this.getKanendoShoriNaiyo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void setTxtChoteiNendo(TextBoxYear txtChoteiNendo) {
        this.getKanendoShoriNaiyo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public DropDownList getDdlShoritsuki() {
        return this.getKanendoShoriNaiyo().getDdlShoritsuki();
    }

    @JsonIgnore
    public void setDdlShoritsuki(DropDownList ddlShoritsuki) {
        this.getKanendoShoriNaiyo().setDdlShoritsuki(ddlShoritsuki);
    }

    @JsonIgnore
    public DataGrid<dgShoriKakunin_Row> getDgShoriKakunin() {
        return this.getShoriKakunin().getDgShoriKakunin();
    }

    @JsonIgnore
    public void setDgShoriKakunin(DataGrid<dgShoriKakunin_Row> dgShoriKakunin) {
        this.getShoriKakunin().setDgShoriKakunin(dgShoriKakunin);
    }

    @JsonIgnore
    public Label getLblShoriKakunin() {
        return this.getShoriKakunin().getLblShoriKakunin();
    }

    @JsonIgnore
    public void setLblShoriKakunin(Label lblShoriKakunin) {
        this.getShoriKakunin().setLblShoriKakunin(lblShoriKakunin);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJoken() {
        return this.getKanendoFukaChushutsuJoken().getRadChushutsuJoken();
    }

    @JsonIgnore
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.getKanendoFukaChushutsuJoken().setRadChushutsuJoken(radChushutsuJoken);
    }

    @JsonIgnore
    public DataGrid<dgChushutsuKikan_Row> getDgChushutsuKikan() {
        return this.getKanendoFukaChushutsuJoken().getDgChushutsuKikan();
    }

    @JsonIgnore
    public void setDgChushutsuKikan(DataGrid<dgChushutsuKikan_Row> dgChushutsuKikan) {
        this.getKanendoFukaChushutsuJoken().setDgChushutsuKikan(dgChushutsuKikan);
    }

    @JsonIgnore
    public HonSanteiKanendoIdoTsuchiKobetsuJohoDiv getHonSanteiKanendoIdoTsuchiKobetsuJoho() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho();
    }

    @JsonIgnore
    public void setHonSanteiKanendoIdoTsuchiKobetsuJoho(HonSanteiKanendoIdoTsuchiKobetsuJohoDiv HonSanteiKanendoIdoTsuchiKobetsuJoho) {
        this.getKanendoFukaChohyoHakko().setHonSanteiKanendoIdoTsuchiKobetsuJoho(HonSanteiKanendoIdoTsuchiKobetsuJoho);
    }

    @JsonIgnore
    public CheckBoxList getChkKetteiTsuchi() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi();
    }

    @JsonIgnore
    public void setChkKetteiTsuchi(CheckBoxList chkKetteiTsuchi) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkKetteiTsuchi(chkKetteiTsuchi);
    }

    @JsonIgnore
    public Label getLblKetteiTsuchi() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getLblKetteiTsuchi();
    }

    @JsonIgnore
    public void setLblKetteiTsuchi(Label lblKetteiTsuchi) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setLblKetteiTsuchi(lblKetteiTsuchi);
    }

    @JsonIgnore
    public CheckBoxList getChkKetteiTsuchiTaishoNendo() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchiTaishoNendo();
    }

    @JsonIgnore
    public void setChkKetteiTsuchiTaishoNendo(CheckBoxList chkKetteiTsuchiTaishoNendo) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkKetteiTsuchiTaishoNendo(chkKetteiTsuchiTaishoNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiTsuchiHakkoYMD() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchiHakkoYMD(TextBoxDate txtKetteiTsuchiHakkoYMD) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtKetteiTsuchiHakkoYMD(txtKetteiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchi() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi();
    }

    @JsonIgnore
    public void setChkHenkoTsuchi(CheckBoxList chkHenkoTsuchi) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkHenkoTsuchi(chkHenkoTsuchi);
    }

    @JsonIgnore
    public Label getLblHenkoTsuchi() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getLblHenkoTsuchi();
    }

    @JsonIgnore
    public void setLblHenkoTsuchi(Label lblHenkoTsuchi) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setLblHenkoTsuchi(lblHenkoTsuchi);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchiTaishoFukaNendo() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishoFukaNendo();
    }

    @JsonIgnore
    public void setChkHenkoTsuchiTaishoFukaNendo(CheckBoxList chkHenkoTsuchiTaishoFukaNendo) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkHenkoTsuchiTaishoFukaNendo(chkHenkoTsuchiTaishoFukaNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtHenkoTsuchiHakkoYMD() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtHenkoTsuchiHakkoYMD(TextBoxDate txtHenkoTsuchiHakkoYMD) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtHenkoTsuchiHakkoYMD(txtHenkoTsuchiHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchiTaishosha() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha();
    }

    @JsonIgnore
    public void setChkHenkoTsuchiTaishosha(CheckBoxList chkHenkoTsuchiTaishosha) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkHenkoTsuchiTaishosha(chkHenkoTsuchiTaishosha);
    }

    @JsonIgnore
    public Label getLblNotsu() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getLblNotsu();
    }

    @JsonIgnore
    public void setLblNotsu(Label lblNotsu) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setLblNotsu(lblNotsu);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishoFukaNedno() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishoFukaNedno();
    }

    @JsonIgnore
    public void setChkNotsuTaishoFukaNedno(CheckBoxList chkNotsuTaishoFukaNedno) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkNotsuTaishoFukaNedno(chkNotsuTaishoFukaNedno);
    }

    @JsonIgnore
    public TextBoxDate getTxtNotsuHakkoYMD() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtNotsuHakkoYMD();
    }

    @JsonIgnore
    public void setTxtNotsuHakkoYMD(TextBoxDate txtNotsuHakkoYMD) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtNotsuHakkoYMD(txtNotsuHakkoYMD);
    }

    @JsonIgnore
    public DropDownList getDdlNotsuShutsuryokuKi() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getDdlNotsuShutsuryokuKi();
    }

    @JsonIgnore
    public void setDdlNotsuShutsuryokuKi(DropDownList ddlNotsuShutsuryokuKi) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setDdlNotsuShutsuryokuKi(ddlNotsuShutsuryokuKi);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishosha() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha();
    }

    @JsonIgnore
    public void setChkNotsuTaishosha(CheckBoxList chkNotsuTaishosha) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkNotsuTaishosha(chkNotsuTaishosha);
    }

    @JsonIgnore
    public RadioButton getRadNotsuKozaShutsuryokuYoshiki() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuKozaShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setRadNotsuKozaShutsuryokuYoshiki(RadioButton radNotsuKozaShutsuryokuYoshiki) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setRadNotsuKozaShutsuryokuYoshiki(radNotsuKozaShutsuryokuYoshiki);
    }

    @JsonIgnore
    public Label getTxtNotsuMsgAboutShutsuryokuYoshiki() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtNotsuMsgAboutShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setTxtNotsuMsgAboutShutsuryokuYoshiki(Label txtNotsuMsgAboutShutsuryokuYoshiki) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtNotsuMsgAboutShutsuryokuYoshiki(txtNotsuMsgAboutShutsuryokuYoshiki);
    }

    @JsonIgnore
    public RadioButton getRadNotsuSeikatsuHogo() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuSeikatsuHogo();
    }

    @JsonIgnore
    public void setRadNotsuSeikatsuHogo(RadioButton radNotsuSeikatsuHogo) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setRadNotsuSeikatsuHogo(radNotsuSeikatsuHogo);
    }

    @JsonIgnore
    public RadioButton getRadNotsuYamawake() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuYamawake();
    }

    @JsonIgnore
    public void setRadNotsuYamawake(RadioButton radNotsuYamawake) {
        this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setRadNotsuYamawake(radNotsuYamawake);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoHenkoTsuchi() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getCcdBunshoBangoHenkoTsuchi();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoKetteiTsuchi() {
        return this.getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getCcdBunshoBangoKetteiTsuchi();
    }

    @JsonIgnore
    public IOutputChohyoIchiranDiv getCcdChohyoIchiran() {
        return this.getKanendoFukaChohyoHakko().getCcdChohyoIchiran();
    }

    // </editor-fold>
}
