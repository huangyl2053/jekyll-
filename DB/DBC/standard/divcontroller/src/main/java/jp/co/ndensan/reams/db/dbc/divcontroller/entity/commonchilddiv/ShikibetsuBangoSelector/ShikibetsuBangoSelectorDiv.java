package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShikibetsuBangoSelector;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.shikibetsubangoselector.ShikibetsuBangoSelectorDivHandler;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxShikibetsuCode;

/**
 * ShikibetsuBangoSelector のクラスファイル
 */
public class ShikibetsuBangoSelectorDiv extends Panel implements IShikibetsuBangoSelectorDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShikibetsuCode")
    private TextBoxShikibetsuCode txtShikibetsuCode;
    @JsonProperty("txtShiyoCode")
    private TextBoxCode txtShiyoCode;
    @JsonProperty("txtKinjunYM")
    private TextBoxDate txtKinjunYM;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("dgDetail")
    private DataGrid<dgDetail_Row> dgDetail;
    @JsonProperty("btnCancel")
    private Button btnCancel;
    @JsonProperty("hiddenYoshikiNo")
    private RString hiddenYoshikiNo;
    @JsonProperty("hiddenServiceTeikyoYM")
    private RString hiddenServiceTeikyoYM;
    @JsonProperty("hiddenShikibetsuCode")
    private RString hiddenShikibetsuCode;
    @JsonProperty("hiddenSelectCode")
    private RString hiddenSelectCode;
    @JsonProperty("hiddenSelectKoumoku")
    private RString hiddenSelectKoumoku;
    @JsonProperty("searchCode")
    private RString searchCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShikibetsuCode
     * @return txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public TextBoxShikibetsuCode getTxtShikibetsuCode() {
        return txtShikibetsuCode;
    }

    /*
     * settxtShikibetsuCode
     * @param txtShikibetsuCode txtShikibetsuCode
     */
    @JsonProperty("txtShikibetsuCode")
    public void setTxtShikibetsuCode(TextBoxShikibetsuCode txtShikibetsuCode) {
        this.txtShikibetsuCode = txtShikibetsuCode;
    }

    /*
     * gettxtShiyoCode
     * @return txtShiyoCode
     */
    @JsonProperty("txtShiyoCode")
    public TextBoxCode getTxtShiyoCode() {
        return txtShiyoCode;
    }

    /*
     * settxtShiyoCode
     * @param txtShiyoCode txtShiyoCode
     */
    @JsonProperty("txtShiyoCode")
    public void setTxtShiyoCode(TextBoxCode txtShiyoCode) {
        this.txtShiyoCode = txtShiyoCode;
    }

    /*
     * gettxtKinjunYM
     * @return txtKinjunYM
     */
    @JsonProperty("txtKinjunYM")
    public TextBoxDate getTxtKinjunYM() {
        return txtKinjunYM;
    }

    /*
     * settxtKinjunYM
     * @param txtKinjunYM txtKinjunYM
     */
    @JsonProperty("txtKinjunYM")
    public void setTxtKinjunYM(TextBoxDate txtKinjunYM) {
        this.txtKinjunYM = txtKinjunYM;
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
     * getdgDetail
     * @return dgDetail
     */
    @JsonProperty("dgDetail")
    public DataGrid<dgDetail_Row> getDgDetail() {
        return dgDetail;
    }

    /*
     * setdgDetail
     * @param dgDetail dgDetail
     */
    @JsonProperty("dgDetail")
    public void setDgDetail(DataGrid<dgDetail_Row> dgDetail) {
        this.dgDetail = dgDetail;
    }

    /*
     * getbtnCancel
     * @return btnCancel
     */
    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    /*
     * setbtnCancel
     * @param btnCancel btnCancel
     */
    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

    /*
     * gethiddenYoshikiNo
     * @return hiddenYoshikiNo
     */
    @JsonProperty("hiddenYoshikiNo")
    public RString getHiddenYoshikiNo() {
        return hiddenYoshikiNo;
    }

    /*
     * sethiddenYoshikiNo
     * @param hiddenYoshikiNo hiddenYoshikiNo
     */
    @JsonProperty("hiddenYoshikiNo")
    public void setHiddenYoshikiNo(RString hiddenYoshikiNo) {
        this.hiddenYoshikiNo = hiddenYoshikiNo;
    }

    /*
     * gethiddenServiceTeikyoYM
     * @return hiddenServiceTeikyoYM
     */
    @JsonProperty("hiddenServiceTeikyoYM")
    public RString getHiddenServiceTeikyoYM() {
        return hiddenServiceTeikyoYM;
    }

    /*
     * sethiddenServiceTeikyoYM
     * @param hiddenServiceTeikyoYM hiddenServiceTeikyoYM
     */
    @JsonProperty("hiddenServiceTeikyoYM")
    public void setHiddenServiceTeikyoYM(RString hiddenServiceTeikyoYM) {
        this.hiddenServiceTeikyoYM = hiddenServiceTeikyoYM;
    }

    /*
     * gethiddenShikibetsuCode
     * @return hiddenShikibetsuCode
     */
    @JsonProperty("hiddenShikibetsuCode")
    public RString getHiddenShikibetsuCode() {
        return hiddenShikibetsuCode;
    }

    /*
     * sethiddenShikibetsuCode
     * @param hiddenShikibetsuCode hiddenShikibetsuCode
     */
    @JsonProperty("hiddenShikibetsuCode")
    public void setHiddenShikibetsuCode(RString hiddenShikibetsuCode) {
        this.hiddenShikibetsuCode = hiddenShikibetsuCode;
    }

    /*
     * gethiddenSelectCode
     * @return hiddenSelectCode
     */
    @JsonProperty("hiddenSelectCode")
    public RString getHiddenSelectCode() {
        return hiddenSelectCode;
    }

    /*
     * sethiddenSelectCode
     * @param hiddenSelectCode hiddenSelectCode
     */
    @JsonProperty("hiddenSelectCode")
    public void setHiddenSelectCode(RString hiddenSelectCode) {
        this.hiddenSelectCode = hiddenSelectCode;
    }

    /*
     * gethiddenSelectKoumoku
     * @return hiddenSelectKoumoku
     */
    @JsonProperty("hiddenSelectKoumoku")
    public RString getHiddenSelectKoumoku() {
        return hiddenSelectKoumoku;
    }

    /*
     * sethiddenSelectKoumoku
     * @param hiddenSelectKoumoku hiddenSelectKoumoku
     */
    @JsonProperty("hiddenSelectKoumoku")
    public void setHiddenSelectKoumoku(RString hiddenSelectKoumoku) {
        this.hiddenSelectKoumoku = hiddenSelectKoumoku;
    }

    /*
     * getsearchCode
     * @return searchCode
     */
    @JsonProperty("searchCode")
    public RString getSearchCode() {
        return searchCode;
    }

    /*
     * setsearchCode
     * @param searchCode searchCode
     */
    @JsonProperty("searchCode")
    public void setSearchCode(RString searchCode) {
        this.searchCode = searchCode;
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public void initialize(RString 様式番号, RString サービス提供年月, RString 特定診療識別コード) {
        ShikibetsuBangoSelectorDivHandler.of(this).initialize(様式番号, サービス提供年月, 特定診療識別コード);
    }

}
