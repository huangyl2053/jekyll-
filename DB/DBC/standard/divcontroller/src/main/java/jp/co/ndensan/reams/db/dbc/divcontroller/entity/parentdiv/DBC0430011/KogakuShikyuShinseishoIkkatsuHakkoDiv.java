package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * KogakuShikyuShinseishoIkkatsuHakko のクラスファイル
 *
 * @reamsid_L DBC-4770-011 zhengshenlei
 */
public class KogakuShikyuShinseishoIkkatsuHakkoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinseishoHakkoParameters")
    private ShinseishoHakkoParametersDiv ShinseishoHakkoParameters;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinseishoHakkoParameters
     * @return ShinseishoHakkoParameters
     */
    @JsonProperty("ShinseishoHakkoParameters")
    public ShinseishoHakkoParametersDiv getShinseishoHakkoParameters() {
        return ShinseishoHakkoParameters;
    }

    /*
     * setShinseishoHakkoParameters
     * @param ShinseishoHakkoParameters ShinseishoHakkoParameters
     */
    @JsonProperty("ShinseishoHakkoParameters")
    public void setShinseishoHakkoParameters(ShinseishoHakkoParametersDiv ShinseishoHakkoParameters) {
        this.ShinseishoHakkoParameters = ShinseishoHakkoParameters;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadShinsaYM() {
        return this.getShinseishoHakkoParameters().getRadShinsaYM();
    }

    @JsonIgnore
    public void setRadShinsaYM(RadioButton radShinsaYM) {
        this.getShinseishoHakkoParameters().setRadShinsaYM(radShinsaYM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinsaYM() {
        return this.getShinseishoHakkoParameters().getTxtShinsaYM();
    }

    @JsonIgnore
    public void setTxtShinsaYM(TextBoxFlexibleDate txtShinsaYM) {
        this.getShinseishoHakkoParameters().setTxtShinsaYM(txtShinsaYM);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShokaiShinseiHakuKijunDate() {
        return this.getShinseishoHakkoParameters().getTxtShokaiShinseiHakuKijunDate();
    }

    @JsonIgnore
    public void setTxtShokaiShinseiHakuKijunDate(TextBoxFlexibleDate txtShokaiShinseiHakuKijunDate) {
        this.getShinseishoHakkoParameters().setTxtShokaiShinseiHakuKijunDate(txtShokaiShinseiHakuKijunDate);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaNo() {
        return this.getShinseishoHakkoParameters().getRadHihokenshaNo();
    }

    @JsonIgnore
    public void setRadHihokenshaNo(RadioButton radHihokenshaNo) {
        this.getShinseishoHakkoParameters().setRadHihokenshaNo(radHihokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getShinseishoHakkoParameters().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getShinseishoHakkoParameters().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaSearch() {
        return this.getShinseishoHakkoParameters().getBtnHihokenshaSearch();
    }

    @JsonIgnore
    public void setBtnHihokenshaSearch(ButtonDialog btnHihokenshaSearch) {
        this.getShinseishoHakkoParameters().setBtnHihokenshaSearch(btnHihokenshaSearch);
    }

    @JsonIgnore
    public DropDownList getDdlServiceYM() {
        return this.getShinseishoHakkoParameters().getDdlServiceYM();
    }

    @JsonIgnore
    public void setDdlServiceYM(DropDownList ddlServiceYM) {
        this.getShinseishoHakkoParameters().setDdlServiceYM(ddlServiceYM);
    }

    @JsonIgnore
    public RadioButton getRadHakushiInsatsu() {
        return this.getShinseishoHakkoParameters().getRadHakushiInsatsu();
    }

    @JsonIgnore
    public void setRadHakushiInsatsu(RadioButton radHakushiInsatsu) {
        this.getShinseishoHakkoParameters().setRadHakushiInsatsu(radHakushiInsatsu);
    }

    @JsonIgnore
    public ShutsuryokuTaishoDiv getShutsuryokuTaisho() {
        return this.getShinseishoHakkoParameters().getShutsuryokuTaisho();
    }

    @JsonIgnore
    public void setShutsuryokuTaisho(ShutsuryokuTaishoDiv ShutsuryokuTaisho) {
        this.getShinseishoHakkoParameters().setShutsuryokuTaisho(ShutsuryokuTaisho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiDate() {
        return this.getShinseishoHakkoParameters().getShutsuryokuTaisho().getTxtSakuseiDate();
    }

    @JsonIgnore
    public void setTxtSakuseiDate(TextBoxFlexibleDate txtSakuseiDate) {
        this.getShinseishoHakkoParameters().getShutsuryokuTaisho().setTxtSakuseiDate(txtSakuseiDate);
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuTaisho() {
        return this.getShinseishoHakkoParameters().getShutsuryokuTaisho().getChkShutsuryokuTaisho();
    }

    @JsonIgnore
    public void setChkShutsuryokuTaisho(CheckBoxList chkShutsuryokuTaisho) {
        this.getShinseishoHakkoParameters().getShutsuryokuTaisho().setChkShutsuryokuTaisho(chkShutsuryokuTaisho);
    }

    @JsonIgnore
    public RadioButton getRadKinyoKikanmeiHyoji() {
        return this.getShinseishoHakkoParameters().getShutsuryokuTaisho().getRadKinyoKikanmeiHyoji();
    }

    @JsonIgnore
    public void setRadKinyoKikanmeiHyoji(RadioButton radKinyoKikanmeiHyoji) {
        this.getShinseishoHakkoParameters().getShutsuryokuTaisho().setRadKinyoKikanmeiHyoji(radKinyoKikanmeiHyoji);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseishoTeishutsuKigen() {
        return this.getShinseishoHakkoParameters().getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen();
    }

    @JsonIgnore
    public void setTxtShinseishoTeishutsuKigen(TextBoxFlexibleDate txtShinseishoTeishutsuKigen) {
        this.getShinseishoHakkoParameters().getShutsuryokuTaisho().setTxtShinseishoTeishutsuKigen(txtShinseishoTeishutsuKigen);
    }

    @JsonIgnore
    public CheckBoxList getChkHakkoIchiranhyoHakko() {
        return this.getShinseishoHakkoParameters().getShutsuryokuTaisho().getChkHakkoIchiranhyoHakko();
    }

    @JsonIgnore
    public void setChkHakkoIchiranhyoHakko(CheckBoxList chkHakkoIchiranhyoHakko) {
        this.getShinseishoHakkoParameters().getShutsuryokuTaisho().setChkHakkoIchiranhyoHakko(chkHakkoIchiranhyoHakko);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoNo() {
        return this.getShinseishoHakkoParameters().getShutsuryokuTaisho().getCcdBunshoNo();
    }

    @JsonIgnore
    public JidoShokanTaishoJohoSetteiDiv getJidoShokanTaishoJohoSettei() {
        return this.getShinseishoHakkoParameters().getJidoShokanTaishoJohoSettei();
    }

    @JsonIgnore
    public void setJidoShokanTaishoJohoSettei(JidoShokanTaishoJohoSetteiDiv JidoShokanTaishoJohoSettei) {
        this.getShinseishoHakkoParameters().setJidoShokanTaishoJohoSettei(JidoShokanTaishoJohoSettei);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return this.getShinseishoHakkoParameters().getJidoShokanTaishoJohoSettei().getTxtShinseiDate();
    }

    @JsonIgnore
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.getShinseishoHakkoParameters().getJidoShokanTaishoJohoSettei().setTxtShinseiDate(txtShinseiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtUketsukeDate() {
        return this.getShinseishoHakkoParameters().getJidoShokanTaishoJohoSettei().getTxtUketsukeDate();
    }

    @JsonIgnore
    public void setTxtUketsukeDate(TextBoxFlexibleDate txtUketsukeDate) {
        this.getShinseishoHakkoParameters().getJidoShokanTaishoJohoSettei().setTxtUketsukeDate(txtUketsukeDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiDate() {
        return this.getShinseishoHakkoParameters().getJidoShokanTaishoJohoSettei().getTxtKetteiDate();
    }

    @JsonIgnore
    public void setTxtKetteiDate(TextBoxFlexibleDate txtKetteiDate) {
        this.getShinseishoHakkoParameters().getJidoShokanTaishoJohoSettei().setTxtKetteiDate(txtKetteiDate);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdShuturyokujun() {
        return this.getShinseishoHakkoParameters().getCcdShuturyokujun();
    }

    // </editor-fold>
}
