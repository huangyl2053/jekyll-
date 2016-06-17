package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;

/**
 * KogakuServicehiTaishoshaKensakuMain のクラスファイル
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class KogakuServicehiTaishoshaKensakuMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KogakuServicehiSearch")
    private KogakuServicehiSearchDiv KogakuServicehiSearch;
    @JsonProperty("KogakuServicehiResult")
    private KogakuServicehiResultDiv KogakuServicehiResult;
    @JsonProperty("hdnShichosonCode")
    private RString hdnShichosonCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKogakuServicehiSearch
     * @return KogakuServicehiSearch
     */
    @JsonProperty("KogakuServicehiSearch")
    public KogakuServicehiSearchDiv getKogakuServicehiSearch() {
        return KogakuServicehiSearch;
    }

    /*
     * setKogakuServicehiSearch
     * @param KogakuServicehiSearch KogakuServicehiSearch
     */
    @JsonProperty("KogakuServicehiSearch")
    public void setKogakuServicehiSearch(KogakuServicehiSearchDiv KogakuServicehiSearch) {
        this.KogakuServicehiSearch = KogakuServicehiSearch;
    }

    /*
     * getKogakuServicehiResult
     * @return KogakuServicehiResult
     */
    @JsonProperty("KogakuServicehiResult")
    public KogakuServicehiResultDiv getKogakuServicehiResult() {
        return KogakuServicehiResult;
    }

    /*
     * setKogakuServicehiResult
     * @param KogakuServicehiResult KogakuServicehiResult
     */
    @JsonProperty("KogakuServicehiResult")
    public void setKogakuServicehiResult(KogakuServicehiResultDiv KogakuServicehiResult) {
        this.KogakuServicehiResult = KogakuServicehiResult;
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
        return this.getKogakuServicehiSearch().getHihokenshaShitei().getRadHihokenshaShitei();
    }

    @JsonIgnore
    public void setRadHihokenshaShitei(RadioButton radHihokenshaShitei) {
        this.getKogakuServicehiSearch().getHihokenshaShitei().setRadHihokenshaShitei(radHihokenshaShitei);
    }

    @JsonIgnore
    public HihokenshaKensakuJokenDiv getHihokenshaKensakuJoken() {
        return this.getKogakuServicehiSearch().getHihokenshaShitei().getHihokenshaKensakuJoken();
    }

    @JsonIgnore
    public void setHihokenshaKensakuJoken(HihokenshaKensakuJokenDiv HihokenshaKensakuJoken) {
        this.getKogakuServicehiSearch().getHihokenshaShitei().setHihokenshaKensakuJoken(HihokenshaKensakuJoken);
    }

    @JsonIgnore
    public RadioButton getRadNengetsuShitei() {
        return this.getKogakuServicehiSearch().getNengetsuShitei().getRadNengetsuShitei();
    }

    @JsonIgnore
    public void setRadNengetsuShitei(RadioButton radNengetsuShitei) {
        this.getKogakuServicehiSearch().getNengetsuShitei().setRadNengetsuShitei(radNengetsuShitei);
    }

    @JsonIgnore
    public NengetsuKensakuJokenDiv getNengetsuKensakuJoken() {
        return this.getKogakuServicehiSearch().getNengetsuShitei().getNengetsuKensakuJoken();
    }

    @JsonIgnore
    public void setNengetsuKensakuJoken(NengetsuKensakuJokenDiv NengetsuKensakuJoken) {
        this.getKogakuServicehiSearch().getNengetsuShitei().setNengetsuKensakuJoken(NengetsuKensakuJoken);
    }

    // </editor-fold>
}
