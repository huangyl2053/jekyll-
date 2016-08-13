package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0430011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * ShinseishoHakkoParameters のクラスファイル
 *
 * @reamsid DBC-0430-011 zhengshenlei
 */
public class ShinseishoHakkoParametersDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShinsaYM")
    private RadioButton radShinsaYM;
    @JsonProperty("txtShinsaYM")
    private TextBoxFlexibleDate txtShinsaYM;
    @JsonProperty("txtShokaiShinseiHakuKijunDate")
    private TextBoxFlexibleDate txtShokaiShinseiHakuKijunDate;
    @JsonProperty("radHihokenshaNo")
    private RadioButton radHihokenshaNo;
    @JsonProperty("txtHihokenshaNo")
    private TextBox txtHihokenshaNo;
    @JsonProperty("btnHihokenshaSearch")
    private ButtonDialog btnHihokenshaSearch;
    @JsonProperty("ddlServiceYM")
    private DropDownList ddlServiceYM;
    @JsonProperty("radHakushiInsatsu")
    private RadioButton radHakushiInsatsu;
    @JsonProperty("ShutsuryokuTaisho")
    private ShutsuryokuTaishoDiv ShutsuryokuTaisho;
    @JsonProperty("JidoShokanTaishoJohoSettei")
    private JidoShokanTaishoJohoSetteiDiv JidoShokanTaishoJohoSettei;
    @JsonProperty("ccdShuturyokujun")
    private ChohyoShutsuryokujunDiv ccdShuturyokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradShinsaYM
     * @return radShinsaYM
     */
    @JsonProperty("radShinsaYM")
    public RadioButton getRadShinsaYM() {
        return radShinsaYM;
    }

    /*
     * setradShinsaYM
     * @param radShinsaYM radShinsaYM
     */
    @JsonProperty("radShinsaYM")
    public void setRadShinsaYM(RadioButton radShinsaYM) {
        this.radShinsaYM = radShinsaYM;
    }

    /*
     * gettxtShinsaYM
     * @return txtShinsaYM
     */
    @JsonProperty("txtShinsaYM")
    public TextBoxFlexibleDate getTxtShinsaYM() {
        return txtShinsaYM;
    }

    /*
     * settxtShinsaYM
     * @param txtShinsaYM txtShinsaYM
     */
    @JsonProperty("txtShinsaYM")
    public void setTxtShinsaYM(TextBoxFlexibleDate txtShinsaYM) {
        this.txtShinsaYM = txtShinsaYM;
    }

    /*
     * gettxtShokaiShinseiHakuKijunDate
     * @return txtShokaiShinseiHakuKijunDate
     */
    @JsonProperty("txtShokaiShinseiHakuKijunDate")
    public TextBoxFlexibleDate getTxtShokaiShinseiHakuKijunDate() {
        return txtShokaiShinseiHakuKijunDate;
    }

    /*
     * settxtShokaiShinseiHakuKijunDate
     * @param txtShokaiShinseiHakuKijunDate txtShokaiShinseiHakuKijunDate
     */
    @JsonProperty("txtShokaiShinseiHakuKijunDate")
    public void setTxtShokaiShinseiHakuKijunDate(TextBoxFlexibleDate txtShokaiShinseiHakuKijunDate) {
        this.txtShokaiShinseiHakuKijunDate = txtShokaiShinseiHakuKijunDate;
    }

    /*
     * getradHihokenshaNo
     * @return radHihokenshaNo
     */
    @JsonProperty("radHihokenshaNo")
    public RadioButton getRadHihokenshaNo() {
        return radHihokenshaNo;
    }

    /*
     * setradHihokenshaNo
     * @param radHihokenshaNo radHihokenshaNo
     */
    @JsonProperty("radHihokenshaNo")
    public void setRadHihokenshaNo(RadioButton radHihokenshaNo) {
        this.radHihokenshaNo = radHihokenshaNo;
    }

    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBox getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * getbtnHihokenshaSearch
     * @return btnHihokenshaSearch
     */
    @JsonProperty("btnHihokenshaSearch")
    public ButtonDialog getBtnHihokenshaSearch() {
        return btnHihokenshaSearch;
    }

    /*
     * setbtnHihokenshaSearch
     * @param btnHihokenshaSearch btnHihokenshaSearch
     */
    @JsonProperty("btnHihokenshaSearch")
    public void setBtnHihokenshaSearch(ButtonDialog btnHihokenshaSearch) {
        this.btnHihokenshaSearch = btnHihokenshaSearch;
    }

    /*
     * getddlServiceYM
     * @return ddlServiceYM
     */
    @JsonProperty("ddlServiceYM")
    public DropDownList getDdlServiceYM() {
        return ddlServiceYM;
    }

    /*
     * setddlServiceYM
     * @param ddlServiceYM ddlServiceYM
     */
    @JsonProperty("ddlServiceYM")
    public void setDdlServiceYM(DropDownList ddlServiceYM) {
        this.ddlServiceYM = ddlServiceYM;
    }

    /*
     * getradHakushiInsatsu
     * @return radHakushiInsatsu
     */
    @JsonProperty("radHakushiInsatsu")
    public RadioButton getRadHakushiInsatsu() {
        return radHakushiInsatsu;
    }

    /*
     * setradHakushiInsatsu
     * @param radHakushiInsatsu radHakushiInsatsu
     */
    @JsonProperty("radHakushiInsatsu")
    public void setRadHakushiInsatsu(RadioButton radHakushiInsatsu) {
        this.radHakushiInsatsu = radHakushiInsatsu;
    }

    /*
     * getShutsuryokuTaisho
     * @return ShutsuryokuTaisho
     */
    @JsonProperty("ShutsuryokuTaisho")
    public ShutsuryokuTaishoDiv getShutsuryokuTaisho() {
        return ShutsuryokuTaisho;
    }

    /*
     * setShutsuryokuTaisho
     * @param ShutsuryokuTaisho ShutsuryokuTaisho
     */
    @JsonProperty("ShutsuryokuTaisho")
    public void setShutsuryokuTaisho(ShutsuryokuTaishoDiv ShutsuryokuTaisho) {
        this.ShutsuryokuTaisho = ShutsuryokuTaisho;
    }

    /*
     * getJidoShokanTaishoJohoSettei
     * @return JidoShokanTaishoJohoSettei
     */
    @JsonProperty("JidoShokanTaishoJohoSettei")
    public JidoShokanTaishoJohoSetteiDiv getJidoShokanTaishoJohoSettei() {
        return JidoShokanTaishoJohoSettei;
    }

    /*
     * setJidoShokanTaishoJohoSettei
     * @param JidoShokanTaishoJohoSettei JidoShokanTaishoJohoSettei
     */
    @JsonProperty("JidoShokanTaishoJohoSettei")
    public void setJidoShokanTaishoJohoSettei(JidoShokanTaishoJohoSetteiDiv JidoShokanTaishoJohoSettei) {
        this.JidoShokanTaishoJohoSettei = JidoShokanTaishoJohoSettei;
    }

    /*
     * getccdShuturyokujun
     * @return ccdShuturyokujun
     */
    @JsonProperty("ccdShuturyokujun")
    public IChohyoShutsuryokujunDiv getCcdShuturyokujun() {
        return ccdShuturyokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtSakuseiDate() {
        return this.getShutsuryokuTaisho().getTxtSakuseiDate();
    }

    @JsonIgnore
    public void setTxtSakuseiDate(TextBoxFlexibleDate txtSakuseiDate) {
        this.getShutsuryokuTaisho().setTxtSakuseiDate(txtSakuseiDate);
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuTaisho() {
        return this.getShutsuryokuTaisho().getChkShutsuryokuTaisho();
    }

    @JsonIgnore
    public void setChkShutsuryokuTaisho(CheckBoxList chkShutsuryokuTaisho) {
        this.getShutsuryokuTaisho().setChkShutsuryokuTaisho(chkShutsuryokuTaisho);
    }

    @JsonIgnore
    public RadioButton getRadKinyoKikanmeiHyoji() {
        return this.getShutsuryokuTaisho().getRadKinyoKikanmeiHyoji();
    }

    @JsonIgnore
    public void setRadKinyoKikanmeiHyoji(RadioButton radKinyoKikanmeiHyoji) {
        this.getShutsuryokuTaisho().setRadKinyoKikanmeiHyoji(radKinyoKikanmeiHyoji);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseishoTeishutsuKigen() {
        return this.getShutsuryokuTaisho().getTxtShinseishoTeishutsuKigen();
    }

    @JsonIgnore
    public void setTxtShinseishoTeishutsuKigen(TextBoxFlexibleDate txtShinseishoTeishutsuKigen) {
        this.getShutsuryokuTaisho().setTxtShinseishoTeishutsuKigen(txtShinseishoTeishutsuKigen);
    }

    @JsonIgnore
    public CheckBoxList getChkHakkoIchiranhyoHakko() {
        return this.getShutsuryokuTaisho().getChkHakkoIchiranhyoHakko();
    }

    @JsonIgnore
    public void setChkHakkoIchiranhyoHakko(CheckBoxList chkHakkoIchiranhyoHakko) {
        this.getShutsuryokuTaisho().setChkHakkoIchiranhyoHakko(chkHakkoIchiranhyoHakko);
    }

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoNo() {
        return this.getShutsuryokuTaisho().getCcdBunshoNo();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return this.getJidoShokanTaishoJohoSettei().getTxtShinseiDate();
    }

    @JsonIgnore
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.getJidoShokanTaishoJohoSettei().setTxtShinseiDate(txtShinseiDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtUketsukeDate() {
        return this.getJidoShokanTaishoJohoSettei().getTxtUketsukeDate();
    }

    @JsonIgnore
    public void setTxtUketsukeDate(TextBoxFlexibleDate txtUketsukeDate) {
        this.getJidoShokanTaishoJohoSettei().setTxtUketsukeDate(txtUketsukeDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKetteiDate() {
        return this.getJidoShokanTaishoJohoSettei().getTxtKetteiDate();
    }

    @JsonIgnore
    public void setTxtKetteiDate(TextBoxFlexibleDate txtKetteiDate) {
        this.getJidoShokanTaishoJohoSettei().setTxtKetteiDate(txtKetteiDate);
    }

    // </editor-fold>
}
