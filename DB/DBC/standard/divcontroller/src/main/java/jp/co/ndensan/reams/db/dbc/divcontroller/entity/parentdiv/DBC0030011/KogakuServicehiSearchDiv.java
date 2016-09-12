package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * KogakuServicehiSearch のクラスファイル
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiSearchDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaShitei")
    private HihokenshaShiteiDiv HihokenshaShitei;
    @JsonProperty("NengetsuShitei")
    private NengetsuShiteiDiv NengetsuShitei;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("hdnShichosonCode")
    private RString hdnShichosonCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHihokenshaShitei
     * @return HihokenshaShitei
     */
    @JsonProperty("HihokenshaShitei")
    public HihokenshaShiteiDiv getHihokenshaShitei() {
        return HihokenshaShitei;
    }

    /*
     * setHihokenshaShitei
     * @param HihokenshaShitei HihokenshaShitei
     */
    @JsonProperty("HihokenshaShitei")
    public void setHihokenshaShitei(HihokenshaShiteiDiv HihokenshaShitei) {
        this.HihokenshaShitei = HihokenshaShitei;
    }

    /*
     * getNengetsuShitei
     * @return NengetsuShitei
     */
    @JsonProperty("NengetsuShitei")
    public NengetsuShiteiDiv getNengetsuShitei() {
        return NengetsuShitei;
    }

    /*
     * setNengetsuShitei
     * @param NengetsuShitei NengetsuShitei
     */
    @JsonProperty("NengetsuShitei")
    public void setNengetsuShitei(NengetsuShiteiDiv NengetsuShitei) {
        this.NengetsuShitei = NengetsuShitei;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * gethdnShichosonCode
     * @return hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public RString getHdnShichosonCode() {
        return hdnShichosonCode;
    }

    /*
     * sethdnShichosonCode
     * @param hdnShichosonCode hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public void setHdnShichosonCode(RString hdnShichosonCode) {
        this.hdnShichosonCode = hdnShichosonCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadHihokenshaShitei() {
        return this.getHihokenshaShitei().getRadHihokenshaShitei();
    }

    @JsonIgnore
    public void setRadHihokenshaShitei(RadioButton radHihokenshaShitei) {
        this.getHihokenshaShitei().setRadHihokenshaShitei(radHihokenshaShitei);
    }

    @JsonIgnore
    public HihokenshaKensakuJokenDiv getHihokenshaKensakuJoken() {
        return this.getHihokenshaShitei().getHihokenshaKensakuJoken();
    }

    @JsonIgnore
    public void setHihokenshaKensakuJoken(HihokenshaKensakuJokenDiv HihokenshaKensakuJoken) {
        this.getHihokenshaShitei().setHihokenshaKensakuJoken(HihokenshaKensakuJoken);
    }

    @JsonIgnore
    public RadioButton getRadNengetsuShitei() {
        return this.getNengetsuShitei().getRadNengetsuShitei();
    }

    @JsonIgnore
    public void setRadNengetsuShitei(RadioButton radNengetsuShitei) {
        this.getNengetsuShitei().setRadNengetsuShitei(radNengetsuShitei);
    }

    @JsonIgnore
    public NengetsuKensakuJokenDiv getNengetsuKensakuJoken() {
        return this.getNengetsuShitei().getNengetsuKensakuJoken();
    }

    @JsonIgnore
    public void setNengetsuKensakuJoken(NengetsuKensakuJokenDiv NengetsuKensakuJoken) {
        this.getNengetsuShitei().setNengetsuKensakuJoken(NengetsuKensakuJoken);
    }

    // </editor-fold>
}
