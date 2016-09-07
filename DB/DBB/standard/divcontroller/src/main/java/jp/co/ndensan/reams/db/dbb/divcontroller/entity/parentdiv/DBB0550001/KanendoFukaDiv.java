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
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * KanendoFuka のクラスファイル
 *
 * @reamsid_L DBB-0920-010 quxiaodong
 */
public class KanendoFukaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KanendoFukaBatchParameter")
    private KanendoFukaBatchParameterDiv KanendoFukaBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKanendoFukaBatchParameter
     * @return KanendoFukaBatchParameter
     */
    @JsonProperty("KanendoFukaBatchParameter")
    public KanendoFukaBatchParameterDiv getKanendoFukaBatchParameter() {
        return KanendoFukaBatchParameter;
    }

    /*
     * setKanendoFukaBatchParameter
     * @param KanendoFukaBatchParameter KanendoFukaBatchParameter
     */
    @JsonProperty("KanendoFukaBatchParameter")
    public void setKanendoFukaBatchParameter(KanendoFukaBatchParameterDiv KanendoFukaBatchParameter) {
        this.KanendoFukaBatchParameter = KanendoFukaBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KanendoShoriNaiyoDiv getKanendoShoriNaiyo() {
        return this.getKanendoFukaBatchParameter().getKanendoShoriNaiyo();
    }

    @JsonIgnore
    public void setKanendoShoriNaiyo(KanendoShoriNaiyoDiv KanendoShoriNaiyo) {
        this.getKanendoFukaBatchParameter().setKanendoShoriNaiyo(KanendoShoriNaiyo);
    }

    @JsonIgnore
    public TextBoxYear getTxtChoteiNendo() {
        return this.getKanendoFukaBatchParameter().getKanendoShoriNaiyo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void setTxtChoteiNendo(TextBoxYear txtChoteiNendo) {
        this.getKanendoFukaBatchParameter().getKanendoShoriNaiyo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public DropDownList getDdlShoritsuki() {
        return this.getKanendoFukaBatchParameter().getKanendoShoriNaiyo().getDdlShoritsuki();
    }

    @JsonIgnore
    public void setDdlShoritsuki(DropDownList ddlShoritsuki) {
        this.getKanendoFukaBatchParameter().getKanendoShoriNaiyo().setDdlShoritsuki(ddlShoritsuki);
    }

    @JsonIgnore
    public ShoriKakuninDiv getShoriKakunin() {
        return this.getKanendoFukaBatchParameter().getShoriKakunin();
    }

    @JsonIgnore
    public void setShoriKakunin(ShoriKakuninDiv ShoriKakunin) {
        this.getKanendoFukaBatchParameter().setShoriKakunin(ShoriKakunin);
    }

    @JsonIgnore
    public DataGrid<dgShoriKakunin_Row> getDgShoriKakunin() {
        return this.getKanendoFukaBatchParameter().getShoriKakunin().getDgShoriKakunin();
    }

    @JsonIgnore
    public void setDgShoriKakunin(DataGrid<dgShoriKakunin_Row> dgShoriKakunin) {
        this.getKanendoFukaBatchParameter().getShoriKakunin().setDgShoriKakunin(dgShoriKakunin);
    }

    @JsonIgnore
    public Label getLblShoriKakunin() {
        return this.getKanendoFukaBatchParameter().getShoriKakunin().getLblShoriKakunin();
    }

    @JsonIgnore
    public void setLblShoriKakunin(Label lblShoriKakunin) {
        this.getKanendoFukaBatchParameter().getShoriKakunin().setLblShoriKakunin(lblShoriKakunin);
    }

    @JsonIgnore
    public KanendoFukaChushutsuJokenDiv getKanendoFukaChushutsuJoken() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChushutsuJoken();
    }

    @JsonIgnore
    public void setKanendoFukaChushutsuJoken(KanendoFukaChushutsuJokenDiv KanendoFukaChushutsuJoken) {
        this.getKanendoFukaBatchParameter().setKanendoFukaChushutsuJoken(KanendoFukaChushutsuJoken);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJoken() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChushutsuJoken().getRadChushutsuJoken();
    }

    @JsonIgnore
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChushutsuJoken().setRadChushutsuJoken(radChushutsuJoken);
    }

    @JsonIgnore
    public DataGrid<dgChushutsuKikan_Row> getDgChushutsuKikan() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChushutsuJoken().getDgChushutsuKikan();
    }

    @JsonIgnore
    public void setDgChushutsuKikan(DataGrid<dgChushutsuKikan_Row> dgChushutsuKikan) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChushutsuJoken().setDgChushutsuKikan(dgChushutsuKikan);
    }

    @JsonIgnore
    public KanendoFukaChohyoHakkoDiv getKanendoFukaChohyoHakko() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko();
    }

    @JsonIgnore
    public void setKanendoFukaChohyoHakko(KanendoFukaChohyoHakkoDiv KanendoFukaChohyoHakko) {
        this.getKanendoFukaBatchParameter().setKanendoFukaChohyoHakko(KanendoFukaChohyoHakko);
    }

    @JsonIgnore
    public HonSanteiKanendoIdoTsuchiKobetsuJohoDiv getHonSanteiKanendoIdoTsuchiKobetsuJoho() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho();
    }

    @JsonIgnore
    public void setHonSanteiKanendoIdoTsuchiKobetsuJoho(HonSanteiKanendoIdoTsuchiKobetsuJohoDiv HonSanteiKanendoIdoTsuchiKobetsuJoho) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().setHonSanteiKanendoIdoTsuchiKobetsuJoho(HonSanteiKanendoIdoTsuchiKobetsuJoho);
    }

    @JsonIgnore
    public CheckBoxList getChkKetteiTsuchi() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchi();
    }

    @JsonIgnore
    public void setChkKetteiTsuchi(CheckBoxList chkKetteiTsuchi) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkKetteiTsuchi(chkKetteiTsuchi);
    }

    @JsonIgnore
    public Label getLblKetteiTsuchi() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getLblKetteiTsuchi();
    }

    @JsonIgnore
    public void setLblKetteiTsuchi(Label lblKetteiTsuchi) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setLblKetteiTsuchi(lblKetteiTsuchi);
    }

    @JsonIgnore
    public CheckBoxList getChkKetteiTsuchiTaishoNendo() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkKetteiTsuchiTaishoNendo();
    }

    @JsonIgnore
    public void setChkKetteiTsuchiTaishoNendo(CheckBoxList chkKetteiTsuchiTaishoNendo) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkKetteiTsuchiTaishoNendo(chkKetteiTsuchiTaishoNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiTsuchiHakkoYMD() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchiHakkoYMD(TextBoxDate txtKetteiTsuchiHakkoYMD) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtKetteiTsuchiHakkoYMD(txtKetteiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchi() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchi();
    }

    @JsonIgnore
    public void setChkHenkoTsuchi(CheckBoxList chkHenkoTsuchi) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkHenkoTsuchi(chkHenkoTsuchi);
    }

    @JsonIgnore
    public Label getLblHenkoTsuchi() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getLblHenkoTsuchi();
    }

    @JsonIgnore
    public void setLblHenkoTsuchi(Label lblHenkoTsuchi) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setLblHenkoTsuchi(lblHenkoTsuchi);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchiTaishoFukaNendo() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishoFukaNendo();
    }

    @JsonIgnore
    public void setChkHenkoTsuchiTaishoFukaNendo(CheckBoxList chkHenkoTsuchiTaishoFukaNendo) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkHenkoTsuchiTaishoFukaNendo(chkHenkoTsuchiTaishoFukaNendo);
    }

    @JsonIgnore
    public TextBoxDate getTxtHenkoTsuchiHakkoYMD() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtHenkoTsuchiHakkoYMD(TextBoxDate txtHenkoTsuchiHakkoYMD) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtHenkoTsuchiHakkoYMD(txtHenkoTsuchiHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchiTaishosha() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha();
    }

    @JsonIgnore
    public void setChkHenkoTsuchiTaishosha(CheckBoxList chkHenkoTsuchiTaishosha) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkHenkoTsuchiTaishosha(chkHenkoTsuchiTaishosha);
    }

    @JsonIgnore
    public Label getLblNotsu() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getLblNotsu();
    }

    @JsonIgnore
    public void setLblNotsu(Label lblNotsu) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setLblNotsu(lblNotsu);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishoFukaNedno() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishoFukaNedno();
    }

    @JsonIgnore
    public void setChkNotsuTaishoFukaNedno(CheckBoxList chkNotsuTaishoFukaNedno) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkNotsuTaishoFukaNedno(chkNotsuTaishoFukaNedno);
    }

    @JsonIgnore
    public TextBoxDate getTxtNotsuHakkoYMD() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtNotsuHakkoYMD();
    }

    @JsonIgnore
    public void setTxtNotsuHakkoYMD(TextBoxDate txtNotsuHakkoYMD) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtNotsuHakkoYMD(txtNotsuHakkoYMD);
    }

    @JsonIgnore
    public DropDownList getDdlNotsuShutsuryokuKi() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getDdlNotsuShutsuryokuKi();
    }

    @JsonIgnore
    public void setDdlNotsuShutsuryokuKi(DropDownList ddlNotsuShutsuryokuKi) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setDdlNotsuShutsuryokuKi(ddlNotsuShutsuryokuKi);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishosha() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getChkNotsuTaishosha();
    }

    @JsonIgnore
    public void setChkNotsuTaishosha(CheckBoxList chkNotsuTaishosha) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setChkNotsuTaishosha(chkNotsuTaishosha);
    }

    @JsonIgnore
    public RadioButton getRadNotsuKozaShutsuryokuYoshiki() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuKozaShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setRadNotsuKozaShutsuryokuYoshiki(RadioButton radNotsuKozaShutsuryokuYoshiki) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setRadNotsuKozaShutsuryokuYoshiki(radNotsuKozaShutsuryokuYoshiki);
    }

    @JsonIgnore
    public Label getTxtNotsuMsgAboutShutsuryokuYoshiki() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getTxtNotsuMsgAboutShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setTxtNotsuMsgAboutShutsuryokuYoshiki(Label txtNotsuMsgAboutShutsuryokuYoshiki) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setTxtNotsuMsgAboutShutsuryokuYoshiki(txtNotsuMsgAboutShutsuryokuYoshiki);
    }

    @JsonIgnore
    public RadioButton getRadNotsuSeikatsuHogo() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuSeikatsuHogo();
    }

    @JsonIgnore
    public void setRadNotsuSeikatsuHogo(RadioButton radNotsuSeikatsuHogo) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setRadNotsuSeikatsuHogo(radNotsuSeikatsuHogo);
    }

    @JsonIgnore
    public RadioButton getRadNotsuYamawake() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getRadNotsuYamawake();
    }

    @JsonIgnore
    public void setRadNotsuYamawake(RadioButton radNotsuYamawake) {
        this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().setRadNotsuYamawake(radNotsuYamawake);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoHenkoTsuchi() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getCcdBunshoBangoHenkoTsuchi();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoKetteiTsuchi() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getHonSanteiKanendoIdoTsuchiKobetsuJoho().getCcdBunshoBangoKetteiTsuchi();
    }

    @JsonIgnore
    public IOutputChohyoIchiranDiv getCcdChohyoIchiran() {
        return this.getKanendoFukaBatchParameter().getKanendoFukaChohyoHakko().getCcdChohyoIchiran();
    }

    // </editor-fold>
}
