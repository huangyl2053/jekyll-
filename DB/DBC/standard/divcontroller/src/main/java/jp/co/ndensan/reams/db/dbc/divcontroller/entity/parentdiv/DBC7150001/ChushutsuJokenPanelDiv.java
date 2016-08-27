package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * ChushutsuJokenPanel のクラスファイル
 *
 * @reamsid_L DBC-3102-010 dingminghao
 */
public class ChushutsuJokenPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChushutsuJoken1")
    private ChushutsuJoken1Div ChushutsuJoken1;
    @JsonProperty("ChushutsuJoken2")
    private ChushutsuJoken2Div ChushutsuJoken2;
    @JsonProperty("ddlTaishoNendo")
    private DropDownList ddlTaishoNendo;
    @JsonProperty("txtSinseibi")
    private TextBoxDateRange txtSinseibi;
    @JsonProperty("txtSikyuSinseishoSeiriBangoKaishi")
    private TextBox txtSikyuSinseishoSeiriBangoKaishi;
    @JsonProperty("txtSikyuSinseishoSeiriBangoShuryo")
    private TextBox txtSikyuSinseishoSeiriBangoShuryo;
    @JsonProperty("chkSofuTaishogaiFukumu")
    private CheckBoxList chkSofuTaishogaiFukumu;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChushutsuJoken1
     * @return ChushutsuJoken1
     */
    @JsonProperty("ChushutsuJoken1")
    public ChushutsuJoken1Div getChushutsuJoken1() {
        return ChushutsuJoken1;
    }

    /*
     * setChushutsuJoken1
     * @param ChushutsuJoken1 ChushutsuJoken1
     */
    @JsonProperty("ChushutsuJoken1")
    public void setChushutsuJoken1(ChushutsuJoken1Div ChushutsuJoken1) {
        this.ChushutsuJoken1 = ChushutsuJoken1;
    }

    /*
     * getChushutsuJoken2
     * @return ChushutsuJoken2
     */
    @JsonProperty("ChushutsuJoken2")
    public ChushutsuJoken2Div getChushutsuJoken2() {
        return ChushutsuJoken2;
    }

    /*
     * setChushutsuJoken2
     * @param ChushutsuJoken2 ChushutsuJoken2
     */
    @JsonProperty("ChushutsuJoken2")
    public void setChushutsuJoken2(ChushutsuJoken2Div ChushutsuJoken2) {
        this.ChushutsuJoken2 = ChushutsuJoken2;
    }

    /*
     * getddlTaishoNendo
     * @return ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public DropDownList getDdlTaishoNendo() {
        return ddlTaishoNendo;
    }

    /*
     * setddlTaishoNendo
     * @param ddlTaishoNendo ddlTaishoNendo
     */
    @JsonProperty("ddlTaishoNendo")
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.ddlTaishoNendo = ddlTaishoNendo;
    }

    /*
     * gettxtSinseibi
     * @return txtSinseibi
     */
    @JsonProperty("txtSinseibi")
    public TextBoxDateRange getTxtSinseibi() {
        return txtSinseibi;
    }

    /*
     * settxtSinseibi
     * @param txtSinseibi txtSinseibi
     */
    @JsonProperty("txtSinseibi")
    public void setTxtSinseibi(TextBoxDateRange txtSinseibi) {
        this.txtSinseibi = txtSinseibi;
    }

    /*
     * gettxtSikyuSinseishoSeiriBangoKaishi
     * @return txtSikyuSinseishoSeiriBangoKaishi
     */
    @JsonProperty("txtSikyuSinseishoSeiriBangoKaishi")
    public TextBox getTxtSikyuSinseishoSeiriBangoKaishi() {
        return txtSikyuSinseishoSeiriBangoKaishi;
    }

    /*
     * settxtSikyuSinseishoSeiriBangoKaishi
     * @param txtSikyuSinseishoSeiriBangoKaishi txtSikyuSinseishoSeiriBangoKaishi
     */
    @JsonProperty("txtSikyuSinseishoSeiriBangoKaishi")
    public void setTxtSikyuSinseishoSeiriBangoKaishi(TextBox txtSikyuSinseishoSeiriBangoKaishi) {
        this.txtSikyuSinseishoSeiriBangoKaishi = txtSikyuSinseishoSeiriBangoKaishi;
    }

    /*
     * gettxtSikyuSinseishoSeiriBangoShuryo
     * @return txtSikyuSinseishoSeiriBangoShuryo
     */
    @JsonProperty("txtSikyuSinseishoSeiriBangoShuryo")
    public TextBox getTxtSikyuSinseishoSeiriBangoShuryo() {
        return txtSikyuSinseishoSeiriBangoShuryo;
    }

    /*
     * settxtSikyuSinseishoSeiriBangoShuryo
     * @param txtSikyuSinseishoSeiriBangoShuryo txtSikyuSinseishoSeiriBangoShuryo
     */
    @JsonProperty("txtSikyuSinseishoSeiriBangoShuryo")
    public void setTxtSikyuSinseishoSeiriBangoShuryo(TextBox txtSikyuSinseishoSeiriBangoShuryo) {
        this.txtSikyuSinseishoSeiriBangoShuryo = txtSikyuSinseishoSeiriBangoShuryo;
    }

    /*
     * getchkSofuTaishogaiFukumu
     * @return chkSofuTaishogaiFukumu
     */
    @JsonProperty("chkSofuTaishogaiFukumu")
    public CheckBoxList getChkSofuTaishogaiFukumu() {
        return chkSofuTaishogaiFukumu;
    }

    /*
     * setchkSofuTaishogaiFukumu
     * @param chkSofuTaishogaiFukumu chkSofuTaishogaiFukumu
     */
    @JsonProperty("chkSofuTaishogaiFukumu")
    public void setChkSofuTaishogaiFukumu(CheckBoxList chkSofuTaishogaiFukumu) {
        this.chkSofuTaishogaiFukumu = chkSofuTaishogaiFukumu;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadChushutsuKubun() {
        return this.getChushutsuJoken1().getRadChushutsuKubun();
    }

    @JsonIgnore
    public void setRadChushutsuKubun(RadioButton radChushutsuKubun) {
        this.getChushutsuJoken1().setRadChushutsuKubun(radChushutsuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlDetaSakuseiKubun() {
        return this.getChushutsuJoken1().getDdlDetaSakuseiKubun();
    }

    @JsonIgnore
    public void setDdlDetaSakuseiKubun(DropDownList ddlDetaSakuseiKubun) {
        this.getChushutsuJoken1().setDdlDetaSakuseiKubun(ddlDetaSakuseiKubun);
    }

    @JsonIgnore
    public RadioButton getRadDataShurui() {
        return this.getChushutsuJoken1().getRadDataShurui();
    }

    @JsonIgnore
    public void setRadDataShurui(RadioButton radDataShurui) {
        this.getChushutsuJoken1().setRadDataShurui(radDataShurui);
    }

    @JsonIgnore
    public RadioButton getRadHoseuJokyo() {
        return this.getChushutsuJoken1().getRadHoseuJokyo();
    }

    @JsonIgnore
    public void setRadHoseuJokyo(RadioButton radHoseuJokyo) {
        this.getChushutsuJoken1().setRadHoseuJokyo(radHoseuJokyo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtJikoFutangakuKakunin() {
        return this.getChushutsuJoken2().getTxtJikoFutangakuKakunin();
    }

    @JsonIgnore
    public void setTxtJikoFutangakuKakunin(TextBoxDateRange txtJikoFutangakuKakunin) {
        this.getChushutsuJoken2().setTxtJikoFutangakuKakunin(txtJikoFutangakuKakunin);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtHoseizumiJikoFutangaku() {
        return this.getChushutsuJoken2().getTxtHoseizumiJikoFutangaku();
    }

    @JsonIgnore
    public void setTxtHoseizumiJikoFutangaku(TextBoxDateRange txtHoseizumiJikoFutangaku) {
        this.getChushutsuJoken2().setTxtHoseizumiJikoFutangaku(txtHoseizumiJikoFutangaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtJikoFutanngakuShoumeisho() {
        return this.getChushutsuJoken2().getTxtJikoFutanngakuShoumeisho();
    }

    @JsonIgnore
    public void setTxtJikoFutanngakuShoumeisho(TextBoxDateRange txtJikoFutanngakuShoumeisho) {
        this.getChushutsuJoken2().setTxtJikoFutanngakuShoumeisho(txtJikoFutanngakuShoumeisho);
    }

    // </editor-fold>
}
