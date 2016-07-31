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
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * HonsanteiIdo のクラスファイル
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public class HonsanteiIdoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HonsanteiIdoBatchParameter")
    private HonsanteiIdoBatchParameterDiv HonsanteiIdoBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHonsanteiIdoBatchParameter
     * @return HonsanteiIdoBatchParameter
     */
    @JsonProperty("HonsanteiIdoBatchParameter")
    public HonsanteiIdoBatchParameterDiv getHonsanteiIdoBatchParameter() {
        return HonsanteiIdoBatchParameter;
    }

    /*
     * setHonsanteiIdoBatchParameter
     * @param HonsanteiIdoBatchParameter HonsanteiIdoBatchParameter
     */
    @JsonProperty("HonsanteiIdoBatchParameter")
    public void setHonsanteiIdoBatchParameter(HonsanteiIdoBatchParameterDiv HonsanteiIdoBatchParameter) {
        this.HonsanteiIdoBatchParameter = HonsanteiIdoBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShotiJokyoDiv getShotiJokyo() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo();
    }

    @JsonIgnore
    public void setShotiJokyo(ShotiJokyoDiv ShotiJokyo) {
        this.getHonsanteiIdoBatchParameter().setShotiJokyo(ShotiJokyo);
    }

    @JsonIgnore
    public HonsanteiIdoShoriNaiyoDiv getHonsanteiIdoShoriNaiyo() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo();
    }

    @JsonIgnore
    public void setHonsanteiIdoShoriNaiyo(HonsanteiIdoShoriNaiyoDiv HonsanteiIdoShoriNaiyo) {
        this.getHonsanteiIdoBatchParameter().getShotiJokyo().setHonsanteiIdoShoriNaiyo(HonsanteiIdoShoriNaiyo);
    }

    @JsonIgnore
    public TextBoxYear getTxtChoteiNendo() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void setTxtChoteiNendo(TextBoxYear txtChoteiNendo) {
        this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public TextBoxYear getTxtFukaNendo() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo().getTxtFukaNendo();
    }

    @JsonIgnore
    public void setTxtFukaNendo(TextBoxYear txtFukaNendo) {
        this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo().setTxtFukaNendo(txtFukaNendo);
    }

    @JsonIgnore
    public DropDownList getDdlShoritsuki() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo().getDdlShoritsuki();
    }

    @JsonIgnore
    public void setDdlShoritsuki(DropDownList ddlShoritsuki) {
        this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo().setDdlShoritsuki(ddlShoritsuki);
    }

    @JsonIgnore
    public RadioButton getRadShoriTaisho() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo().getRadShoriTaisho();
    }

    @JsonIgnore
    public void setRadShoriTaisho(RadioButton radShoriTaisho) {
        this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo().setRadShoriTaisho(radShoriTaisho);
    }

    @JsonIgnore
    public DropDownList getDdlTokuchoTeishiSelect() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo().getDdlTokuchoTeishiSelect();
    }

    @JsonIgnore
    public void setDdlTokuchoTeishiSelect(DropDownList ddlTokuchoTeishiSelect) {
        this.getHonsanteiIdoBatchParameter().getShotiJokyo().getHonsanteiIdoShoriNaiyo().setDdlTokuchoTeishiSelect(ddlTokuchoTeishiSelect);
    }

    @JsonIgnore
    public DataGrid<dgHonsanteiIdoShoriKakunin_Row> getDgHonsanteiIdoShoriKakunin() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo().getDgHonsanteiIdoShoriKakunin();
    }

    @JsonIgnore
    public void setDgHonsanteiIdoShoriKakunin(DataGrid<dgHonsanteiIdoShoriKakunin_Row> dgHonsanteiIdoShoriKakunin) {
        this.getHonsanteiIdoBatchParameter().getShotiJokyo().setDgHonsanteiIdoShoriKakunin(dgHonsanteiIdoShoriKakunin);
    }

    @JsonIgnore
    public TokuchoHosokuDiv getTokuchoHosoku() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo().getTokuchoHosoku();
    }

    @JsonIgnore
    public void setTokuchoHosoku(TokuchoHosokuDiv TokuchoHosoku) {
        this.getHonsanteiIdoBatchParameter().getShotiJokyo().setTokuchoHosoku(TokuchoHosoku);
    }

    @JsonIgnore
    public TextBox getXtTaishoTokuchoKaishiTsuki() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo().getTokuchoHosoku().getXtTaishoTokuchoKaishiTsuki();
    }

    @JsonIgnore
    public void setXtTaishoTokuchoKaishiTsuki(TextBox xtTaishoTokuchoKaishiTsuki) {
        this.getHonsanteiIdoBatchParameter().getShotiJokyo().getTokuchoHosoku().setXtTaishoTokuchoKaishiTsuki(xtTaishoTokuchoKaishiTsuki);
    }

    @JsonIgnore
    public RadioButton getRadTokuchoHosokuIraiKingakuKeisan() {
        return this.getHonsanteiIdoBatchParameter().getShotiJokyo().getTokuchoHosoku().getRadTokuchoHosokuIraiKingakuKeisan();
    }

    @JsonIgnore
    public void setRadTokuchoHosokuIraiKingakuKeisan(RadioButton radTokuchoHosokuIraiKingakuKeisan) {
        this.getHonsanteiIdoBatchParameter().getShotiJokyo().getTokuchoHosoku().setRadTokuchoHosokuIraiKingakuKeisan(radTokuchoHosokuIraiKingakuKeisan);
    }

    @JsonIgnore
    public HonsanteiIdoChushutsuJokenDiv getHonsanteiIdoChushutsuJoken() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChushutsuJoken();
    }

    @JsonIgnore
    public void setHonsanteiIdoChushutsuJoken(HonsanteiIdoChushutsuJokenDiv HonsanteiIdoChushutsuJoken) {
        this.getHonsanteiIdoBatchParameter().setHonsanteiIdoChushutsuJoken(HonsanteiIdoChushutsuJoken);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJoken() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChushutsuJoken().getRadChushutsuJoken();
    }

    @JsonIgnore
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChushutsuJoken().setRadChushutsuJoken(radChushutsuJoken);
    }

    @JsonIgnore
    public DataGrid<dgChushutsuKikan_Row> getDgChushutsuKikan() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChushutsuJoken().getDgChushutsuKikan();
    }

    @JsonIgnore
    public void setDgChushutsuKikan(DataGrid<dgChushutsuKikan_Row> dgChushutsuKikan) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChushutsuJoken().setDgChushutsuKikan(dgChushutsuKikan);
    }

    @JsonIgnore
    public HonsanteiIdoChohyoHakkoDiv getHonsanteiIdoChohyoHakko() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko();
    }

    @JsonIgnore
    public void setHonsanteiIdoChohyoHakko(HonsanteiIdoChohyoHakkoDiv HonsanteiIdoChohyoHakko) {
        this.getHonsanteiIdoBatchParameter().setHonsanteiIdoChohyoHakko(HonsanteiIdoChohyoHakko);
    }

    @JsonIgnore
    public HonSanteiIdoTsuchiKobetsuJohoDiv getHonSanteiIdoTsuchiKobetsuJoho() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho();
    }

    @JsonIgnore
    public void setHonSanteiIdoTsuchiKobetsuJoho(HonSanteiIdoTsuchiKobetsuJohoDiv HonSanteiIdoTsuchiKobetsuJoho) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().setHonSanteiIdoTsuchiKobetsuJoho(HonSanteiIdoTsuchiKobetsuJoho);
    }

    @JsonIgnore
    public Label getLblTokuchoKaishiTsuchi() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getLblTokuchoKaishiTsuchi();
    }

    @JsonIgnore
    public void setLblTokuchoKaishiTsuchi(Label lblTokuchoKaishiTsuchi) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setLblTokuchoKaishiTsuchi(lblTokuchoKaishiTsuchi);
    }

    @JsonIgnore
    public RadioButton getRadTokuchoKaishiTsuchiTaishosha() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getRadTokuchoKaishiTsuchiTaishosha();
    }

    @JsonIgnore
    public void setRadTokuchoKaishiTsuchiTaishosha(RadioButton radTokuchoKaishiTsuchiTaishosha) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setRadTokuchoKaishiTsuchiTaishosha(radTokuchoKaishiTsuchiTaishosha);
    }

    @JsonIgnore
    public TextBoxDate getTxtTokuchoKaishiTsuchishoHakkoYMD() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtTokuchoKaishiTsuchishoHakkoYMD();
    }

    @JsonIgnore
    public void setTxtTokuchoKaishiTsuchishoHakkoYMD(TextBoxDate txtTokuchoKaishiTsuchishoHakkoYMD) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtTokuchoKaishiTsuchishoHakkoYMD(txtTokuchoKaishiTsuchishoHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkKetteiTsuchi() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getChkKetteiTsuchi();
    }

    @JsonIgnore
    public void setChkKetteiTsuchi(CheckBoxList chkKetteiTsuchi) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setChkKetteiTsuchi(chkKetteiTsuchi);
    }

    @JsonIgnore
    public Label getLblKetteiTsuchi() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getLblKetteiTsuchi();
    }

    @JsonIgnore
    public void setLblKetteiTsuchi(Label lblKetteiTsuchi) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setLblKetteiTsuchi(lblKetteiTsuchi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiTsuchiHakkoYMD() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchiHakkoYMD(TextBoxDate txtKetteiTsuchiHakkoYMD) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtKetteiTsuchiHakkoYMD(txtKetteiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchi() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getChkHenkoTsuchi();
    }

    @JsonIgnore
    public void setChkHenkoTsuchi(CheckBoxList chkHenkoTsuchi) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setChkHenkoTsuchi(chkHenkoTsuchi);
    }

    @JsonIgnore
    public Label getLblHenkoTsuchi() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getLblHenkoTsuchi();
    }

    @JsonIgnore
    public void setLblHenkoTsuchi(Label lblHenkoTsuchi) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setLblHenkoTsuchi(lblHenkoTsuchi);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchiTaishosha() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha();
    }

    @JsonIgnore
    public void setChkHenkoTsuchiTaishosha(CheckBoxList chkHenkoTsuchiTaishosha) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setChkHenkoTsuchiTaishosha(chkHenkoTsuchiTaishosha);
    }

    @JsonIgnore
    public TextBox getTxtHenkoTsuchiKozaIdoNomiShutsuryoku() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiKozaIdoNomiShutsuryoku();
    }

    @JsonIgnore
    public void setTxtHenkoTsuchiKozaIdoNomiShutsuryoku(TextBox txtHenkoTsuchiKozaIdoNomiShutsuryoku) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtHenkoTsuchiKozaIdoNomiShutsuryoku(txtHenkoTsuchiKozaIdoNomiShutsuryoku);
    }

    @JsonIgnore
    public TextBoxDate getTxtHenkoTsuchiHakkoYMD() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtHenkoTsuchiHakkoYMD(TextBoxDate txtHenkoTsuchiHakkoYMD) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtHenkoTsuchiHakkoYMD(txtHenkoTsuchiHakkoYMD);
    }

    @JsonIgnore
    public Label getLblNotsu() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getLblNotsu();
    }

    @JsonIgnore
    public void setLblNotsu(Label lblNotsu) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setLblNotsu(lblNotsu);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishoSha() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getChkNotsuTaishoSha();
    }

    @JsonIgnore
    public void setChkNotsuTaishoSha(CheckBoxList chkNotsuTaishoSha) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setChkNotsuTaishoSha(chkNotsuTaishoSha);
    }

    @JsonIgnore
    public TextBox getTxtNotsuKozaIdoNomiShutsuryoku() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuKozaIdoNomiShutsuryoku();
    }

    @JsonIgnore
    public void setTxtNotsuKozaIdoNomiShutsuryoku(TextBox txtNotsuKozaIdoNomiShutsuryoku) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuKozaIdoNomiShutsuryoku(txtNotsuKozaIdoNomiShutsuryoku);
    }

    @JsonIgnore
    public RadioButton getRadNotsuKozaShutsuryokuYoshiki() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getRadNotsuKozaShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setRadNotsuKozaShutsuryokuYoshiki(RadioButton radNotsuKozaShutsuryokuYoshiki) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setRadNotsuKozaShutsuryokuYoshiki(radNotsuKozaShutsuryokuYoshiki);
    }

    @JsonIgnore
    public Label getTxtNotsuMsgAboutShutsuryokuYoshiki() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuMsgAboutShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setTxtNotsuMsgAboutShutsuryokuYoshiki(Label txtNotsuMsgAboutShutsuryokuYoshiki) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuMsgAboutShutsuryokuYoshiki(txtNotsuMsgAboutShutsuryokuYoshiki);
    }

    @JsonIgnore
    public TextBoxDate getTxtNotsuHakkoYMD() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuHakkoYMD();
    }

    @JsonIgnore
    public void setTxtNotsuHakkoYMD(TextBoxDate txtNotsuHakkoYMD) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuHakkoYMD(txtNotsuHakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtNotsuShutsuryokuKi() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuShutsuryokuKi();
    }

    @JsonIgnore
    public void setTxtNotsuShutsuryokuKi(TextBox txtNotsuShutsuryokuKi) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuShutsuryokuKi(txtNotsuShutsuryokuKi);
    }

    @JsonIgnore
    public DropDownList getDdlNotsuShuturyokuki() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getDdlNotsuShuturyokuki();
    }

    @JsonIgnore
    public void setDdlNotsuShuturyokuki(DropDownList ddlNotsuShuturyokuki) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setDdlNotsuShuturyokuki(ddlNotsuShuturyokuki);
    }

    @JsonIgnore
    public RadioButton getRadNotsuSeikatsuHogo() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getRadNotsuSeikatsuHogo();
    }

    @JsonIgnore
    public void setRadNotsuSeikatsuHogo(RadioButton radNotsuSeikatsuHogo) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setRadNotsuSeikatsuHogo(radNotsuSeikatsuHogo);
    }

    @JsonIgnore
    public RadioButton getRadNotsuYamawake() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getRadNotsuYamawake();
    }

    @JsonIgnore
    public void setRadNotsuYamawake(RadioButton radNotsuYamawake) {
        this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setRadNotsuYamawake(radNotsuYamawake);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBushiNoKetteiTsuchi() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getCcdBushiNoKetteiTsuchi();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoHenkoTsuchi() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getCcdBunshoBangoHenkoTsuchi();
    }

    @JsonIgnore
    public IOutputChohyoIchiranDiv getCcdChohyoIchiran() {
        return this.getHonsanteiIdoBatchParameter().getHonsanteiIdoChohyoHakko().getCcdChohyoIchiran();
    }

    // </editor-fold>
}
