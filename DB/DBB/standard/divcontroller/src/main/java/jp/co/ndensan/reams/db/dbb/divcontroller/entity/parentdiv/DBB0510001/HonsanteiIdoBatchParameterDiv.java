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
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * HonsanteiIdoBatchParameter のクラスファイル
 *
 * @reamsid_L DBB-0880-010 wangkanglei
 */
public class HonsanteiIdoBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShotiJokyo")
    private ShotiJokyoDiv ShotiJokyo;
    @JsonProperty("HonsanteiIdoChushutsuJoken")
    private HonsanteiIdoChushutsuJokenDiv HonsanteiIdoChushutsuJoken;
    @JsonProperty("HonsanteiIdoChohyoHakko")
    private HonsanteiIdoChohyoHakkoDiv HonsanteiIdoChohyoHakko;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShotiJokyo
     * @return ShotiJokyo
     */
    @JsonProperty("ShotiJokyo")
    public ShotiJokyoDiv getShotiJokyo() {
        return ShotiJokyo;
    }

    /*
     * setShotiJokyo
     * @param ShotiJokyo ShotiJokyo
     */
    @JsonProperty("ShotiJokyo")
    public void setShotiJokyo(ShotiJokyoDiv ShotiJokyo) {
        this.ShotiJokyo = ShotiJokyo;
    }

    /*
     * getHonsanteiIdoChushutsuJoken
     * @return HonsanteiIdoChushutsuJoken
     */
    @JsonProperty("HonsanteiIdoChushutsuJoken")
    public HonsanteiIdoChushutsuJokenDiv getHonsanteiIdoChushutsuJoken() {
        return HonsanteiIdoChushutsuJoken;
    }

    /*
     * setHonsanteiIdoChushutsuJoken
     * @param HonsanteiIdoChushutsuJoken HonsanteiIdoChushutsuJoken
     */
    @JsonProperty("HonsanteiIdoChushutsuJoken")
    public void setHonsanteiIdoChushutsuJoken(HonsanteiIdoChushutsuJokenDiv HonsanteiIdoChushutsuJoken) {
        this.HonsanteiIdoChushutsuJoken = HonsanteiIdoChushutsuJoken;
    }

    /*
     * getHonsanteiIdoChohyoHakko
     * @return HonsanteiIdoChohyoHakko
     */
    @JsonProperty("HonsanteiIdoChohyoHakko")
    public HonsanteiIdoChohyoHakkoDiv getHonsanteiIdoChohyoHakko() {
        return HonsanteiIdoChohyoHakko;
    }

    /*
     * setHonsanteiIdoChohyoHakko
     * @param HonsanteiIdoChohyoHakko HonsanteiIdoChohyoHakko
     */
    @JsonProperty("HonsanteiIdoChohyoHakko")
    public void setHonsanteiIdoChohyoHakko(HonsanteiIdoChohyoHakkoDiv HonsanteiIdoChohyoHakko) {
        this.HonsanteiIdoChohyoHakko = HonsanteiIdoChohyoHakko;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HonsanteiIdoShoriNaiyoDiv getHonsanteiIdoShoriNaiyo() {
        return this.getShotiJokyo().getHonsanteiIdoShoriNaiyo();
    }

    @JsonIgnore
    public void setHonsanteiIdoShoriNaiyo(HonsanteiIdoShoriNaiyoDiv HonsanteiIdoShoriNaiyo) {
        this.getShotiJokyo().setHonsanteiIdoShoriNaiyo(HonsanteiIdoShoriNaiyo);
    }

    @JsonIgnore
    public TextBoxYear getTxtChoteiNendo() {
        return this.getShotiJokyo().getHonsanteiIdoShoriNaiyo().getTxtChoteiNendo();
    }

    @JsonIgnore
    public void setTxtChoteiNendo(TextBoxYear txtChoteiNendo) {
        this.getShotiJokyo().getHonsanteiIdoShoriNaiyo().setTxtChoteiNendo(txtChoteiNendo);
    }

    @JsonIgnore
    public TextBoxYear getTxtFukaNendo() {
        return this.getShotiJokyo().getHonsanteiIdoShoriNaiyo().getTxtFukaNendo();
    }

    @JsonIgnore
    public void setTxtFukaNendo(TextBoxYear txtFukaNendo) {
        this.getShotiJokyo().getHonsanteiIdoShoriNaiyo().setTxtFukaNendo(txtFukaNendo);
    }

    @JsonIgnore
    public DropDownList getDdlShoritsuki() {
        return this.getShotiJokyo().getHonsanteiIdoShoriNaiyo().getDdlShoritsuki();
    }

    @JsonIgnore
    public void setDdlShoritsuki(DropDownList ddlShoritsuki) {
        this.getShotiJokyo().getHonsanteiIdoShoriNaiyo().setDdlShoritsuki(ddlShoritsuki);
    }

    @JsonIgnore
    public RadioButton getRadShoriTaisho() {
        return this.getShotiJokyo().getHonsanteiIdoShoriNaiyo().getRadShoriTaisho();
    }

    @JsonIgnore
    public void setRadShoriTaisho(RadioButton radShoriTaisho) {
        this.getShotiJokyo().getHonsanteiIdoShoriNaiyo().setRadShoriTaisho(radShoriTaisho);
    }

    @JsonIgnore
    public DropDownList getDdlTokuchoTeishiSelect() {
        return this.getShotiJokyo().getHonsanteiIdoShoriNaiyo().getDdlTokuchoTeishiSelect();
    }

    @JsonIgnore
    public void setDdlTokuchoTeishiSelect(DropDownList ddlTokuchoTeishiSelect) {
        this.getShotiJokyo().getHonsanteiIdoShoriNaiyo().setDdlTokuchoTeishiSelect(ddlTokuchoTeishiSelect);
    }

    @JsonIgnore
    public DataGrid<dgHonsanteiIdoShoriKakunin_Row> getDgHonsanteiIdoShoriKakunin() {
        return this.getShotiJokyo().getDgHonsanteiIdoShoriKakunin();
    }

    @JsonIgnore
    public void setDgHonsanteiIdoShoriKakunin(DataGrid<dgHonsanteiIdoShoriKakunin_Row> dgHonsanteiIdoShoriKakunin) {
        this.getShotiJokyo().setDgHonsanteiIdoShoriKakunin(dgHonsanteiIdoShoriKakunin);
    }

    @JsonIgnore
    public TokuchoHosokuDiv getTokuchoHosoku() {
        return this.getShotiJokyo().getTokuchoHosoku();
    }

    @JsonIgnore
    public void setTokuchoHosoku(TokuchoHosokuDiv TokuchoHosoku) {
        this.getShotiJokyo().setTokuchoHosoku(TokuchoHosoku);
    }

    @JsonIgnore
    public TextBox getXtTaishoTokuchoKaishiTsuki() {
        return this.getShotiJokyo().getTokuchoHosoku().getXtTaishoTokuchoKaishiTsuki();
    }

    @JsonIgnore
    public void setXtTaishoTokuchoKaishiTsuki(TextBox xtTaishoTokuchoKaishiTsuki) {
        this.getShotiJokyo().getTokuchoHosoku().setXtTaishoTokuchoKaishiTsuki(xtTaishoTokuchoKaishiTsuki);
    }

    @JsonIgnore
    public RadioButton getRadTokuchoHosokuIraiKingakuKeisan() {
        return this.getShotiJokyo().getTokuchoHosoku().getRadTokuchoHosokuIraiKingakuKeisan();
    }

    @JsonIgnore
    public void setRadTokuchoHosokuIraiKingakuKeisan(RadioButton radTokuchoHosokuIraiKingakuKeisan) {
        this.getShotiJokyo().getTokuchoHosoku().setRadTokuchoHosokuIraiKingakuKeisan(radTokuchoHosokuIraiKingakuKeisan);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuJoken() {
        return this.getHonsanteiIdoChushutsuJoken().getRadChushutsuJoken();
    }

    @JsonIgnore
    public void setRadChushutsuJoken(RadioButton radChushutsuJoken) {
        this.getHonsanteiIdoChushutsuJoken().setRadChushutsuJoken(radChushutsuJoken);
    }

    @JsonIgnore
    public DataGrid<dgChushutsuKikan_Row> getDgChushutsuKikan() {
        return this.getHonsanteiIdoChushutsuJoken().getDgChushutsuKikan();
    }

    @JsonIgnore
    public void setDgChushutsuKikan(DataGrid<dgChushutsuKikan_Row> dgChushutsuKikan) {
        this.getHonsanteiIdoChushutsuJoken().setDgChushutsuKikan(dgChushutsuKikan);
    }

    @JsonIgnore
    public HonSanteiIdoTsuchiKobetsuJohoDiv getHonSanteiIdoTsuchiKobetsuJoho() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho();
    }

    @JsonIgnore
    public void setHonSanteiIdoTsuchiKobetsuJoho(HonSanteiIdoTsuchiKobetsuJohoDiv HonSanteiIdoTsuchiKobetsuJoho) {
        this.getHonsanteiIdoChohyoHakko().setHonSanteiIdoTsuchiKobetsuJoho(HonSanteiIdoTsuchiKobetsuJoho);
    }

    @JsonIgnore
    public Label getLblTokuchoKaishiTsuchi() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getLblTokuchoKaishiTsuchi();
    }

    @JsonIgnore
    public void setLblTokuchoKaishiTsuchi(Label lblTokuchoKaishiTsuchi) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setLblTokuchoKaishiTsuchi(lblTokuchoKaishiTsuchi);
    }

    @JsonIgnore
    public RadioButton getRadTokuchoKaishiTsuchiTaishosha() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getRadTokuchoKaishiTsuchiTaishosha();
    }

    @JsonIgnore
    public void setRadTokuchoKaishiTsuchiTaishosha(RadioButton radTokuchoKaishiTsuchiTaishosha) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setRadTokuchoKaishiTsuchiTaishosha(radTokuchoKaishiTsuchiTaishosha);
    }

    @JsonIgnore
    public TextBoxDate getTxtTokuchoKaishiTsuchishoHakkoYMD() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtTokuchoKaishiTsuchishoHakkoYMD();
    }

    @JsonIgnore
    public void setTxtTokuchoKaishiTsuchishoHakkoYMD(TextBoxDate txtTokuchoKaishiTsuchishoHakkoYMD) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtTokuchoKaishiTsuchishoHakkoYMD(txtTokuchoKaishiTsuchishoHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkKetteiTsuchi() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getChkKetteiTsuchi();
    }

    @JsonIgnore
    public void setChkKetteiTsuchi(CheckBoxList chkKetteiTsuchi) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setChkKetteiTsuchi(chkKetteiTsuchi);
    }

    @JsonIgnore
    public Label getLblKetteiTsuchi() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getLblKetteiTsuchi();
    }

    @JsonIgnore
    public void setLblKetteiTsuchi(Label lblKetteiTsuchi) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setLblKetteiTsuchi(lblKetteiTsuchi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiTsuchiHakkoYMD() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtKetteiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtKetteiTsuchiHakkoYMD(TextBoxDate txtKetteiTsuchiHakkoYMD) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtKetteiTsuchiHakkoYMD(txtKetteiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchi() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getChkHenkoTsuchi();
    }

    @JsonIgnore
    public void setChkHenkoTsuchi(CheckBoxList chkHenkoTsuchi) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setChkHenkoTsuchi(chkHenkoTsuchi);
    }

    @JsonIgnore
    public Label getLblHenkoTsuchi() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getLblHenkoTsuchi();
    }

    @JsonIgnore
    public void setLblHenkoTsuchi(Label lblHenkoTsuchi) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setLblHenkoTsuchi(lblHenkoTsuchi);
    }

    @JsonIgnore
    public CheckBoxList getChkHenkoTsuchiTaishosha() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getChkHenkoTsuchiTaishosha();
    }

    @JsonIgnore
    public void setChkHenkoTsuchiTaishosha(CheckBoxList chkHenkoTsuchiTaishosha) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setChkHenkoTsuchiTaishosha(chkHenkoTsuchiTaishosha);
    }

    @JsonIgnore
    public TextBox getTxtHenkoTsuchiKozaIdoNomiShutsuryoku() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiKozaIdoNomiShutsuryoku();
    }

    @JsonIgnore
    public void setTxtHenkoTsuchiKozaIdoNomiShutsuryoku(TextBox txtHenkoTsuchiKozaIdoNomiShutsuryoku) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtHenkoTsuchiKozaIdoNomiShutsuryoku(txtHenkoTsuchiKozaIdoNomiShutsuryoku);
    }

    @JsonIgnore
    public TextBoxDate getTxtHenkoTsuchiHakkoYMD() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtHenkoTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtHenkoTsuchiHakkoYMD(TextBoxDate txtHenkoTsuchiHakkoYMD) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtHenkoTsuchiHakkoYMD(txtHenkoTsuchiHakkoYMD);
    }

    @JsonIgnore
    public Label getLblNotsu() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getLblNotsu();
    }

    @JsonIgnore
    public void setLblNotsu(Label lblNotsu) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setLblNotsu(lblNotsu);
    }

    @JsonIgnore
    public CheckBoxList getChkNotsuTaishoSha() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getChkNotsuTaishoSha();
    }

    @JsonIgnore
    public void setChkNotsuTaishoSha(CheckBoxList chkNotsuTaishoSha) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setChkNotsuTaishoSha(chkNotsuTaishoSha);
    }

    @JsonIgnore
    public TextBox getTxtNotsuKozaIdoNomiShutsuryoku() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuKozaIdoNomiShutsuryoku();
    }

    @JsonIgnore
    public void setTxtNotsuKozaIdoNomiShutsuryoku(TextBox txtNotsuKozaIdoNomiShutsuryoku) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuKozaIdoNomiShutsuryoku(txtNotsuKozaIdoNomiShutsuryoku);
    }

    @JsonIgnore
    public RadioButton getRadNotsuKozaShutsuryokuYoshiki() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getRadNotsuKozaShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setRadNotsuKozaShutsuryokuYoshiki(RadioButton radNotsuKozaShutsuryokuYoshiki) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setRadNotsuKozaShutsuryokuYoshiki(radNotsuKozaShutsuryokuYoshiki);
    }

    @JsonIgnore
    public Label getTxtNotsuMsgAboutShutsuryokuYoshiki() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuMsgAboutShutsuryokuYoshiki();
    }

    @JsonIgnore
    public void setTxtNotsuMsgAboutShutsuryokuYoshiki(Label txtNotsuMsgAboutShutsuryokuYoshiki) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuMsgAboutShutsuryokuYoshiki(txtNotsuMsgAboutShutsuryokuYoshiki);
    }

    @JsonIgnore
    public TextBoxDate getTxtNotsuHakkoYMD() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuHakkoYMD();
    }

    @JsonIgnore
    public void setTxtNotsuHakkoYMD(TextBoxDate txtNotsuHakkoYMD) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuHakkoYMD(txtNotsuHakkoYMD);
    }

    @JsonIgnore
    public TextBox getTxtNotsuShutsuryokuKi() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getTxtNotsuShutsuryokuKi();
    }

    @JsonIgnore
    public void setTxtNotsuShutsuryokuKi(TextBox txtNotsuShutsuryokuKi) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setTxtNotsuShutsuryokuKi(txtNotsuShutsuryokuKi);
    }

    @JsonIgnore
    public DropDownList getDdlNotsuShuturyokuki() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getDdlNotsuShuturyokuki();
    }

    @JsonIgnore
    public void setDdlNotsuShuturyokuki(DropDownList ddlNotsuShuturyokuki) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setDdlNotsuShuturyokuki(ddlNotsuShuturyokuki);
    }

    @JsonIgnore
    public RadioButton getRadNotsuSeikatsuHogo() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getRadNotsuSeikatsuHogo();
    }

    @JsonIgnore
    public void setRadNotsuSeikatsuHogo(RadioButton radNotsuSeikatsuHogo) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setRadNotsuSeikatsuHogo(radNotsuSeikatsuHogo);
    }

    @JsonIgnore
    public RadioButton getRadNotsuYamawake() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getRadNotsuYamawake();
    }

    @JsonIgnore
    public void setRadNotsuYamawake(RadioButton radNotsuYamawake) {
        this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().setRadNotsuYamawake(radNotsuYamawake);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBushiNoKetteiTsuchi() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getCcdBushiNoKetteiTsuchi();
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoBangoHenkoTsuchi() {
        return this.getHonsanteiIdoChohyoHakko().getHonSanteiIdoTsuchiKobetsuJoho().getCcdBunshoBangoHenkoTsuchi();
    }

    @JsonIgnore
    public IOutputChohyoIchiranDiv getCcdChohyoIchiran() {
        return this.getHonsanteiIdoChohyoHakko().getCcdChohyoIchiran();
    }

    // </editor-fold>
}
