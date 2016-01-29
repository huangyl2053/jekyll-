package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShikibetsuBangoSelector;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.handler.shikibetsubangoselector.ShikibetsuBangoSelectorDivHandler;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxShikibetsuCode;

/**
 * ShikibetsuBangoSelector のクラスファイル
 *
 * @author 自動生成
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public void onLoad(RString 様式番号, FlexibleYearMonth サービス提供年月, RString 特定診療識別コード) {
        ShikibetsuBangoSelectorDivHandler.of(this).initialize(様式番号, サービス提供年月, 特定診療識別コード);
    }

    @JsonIgnore
    public void getShikibetsuBangoJoho() {
        ShikibetsuBangoSelectorDivHandler.of(this).getShikibetsuBangoJoho();
    }
}
