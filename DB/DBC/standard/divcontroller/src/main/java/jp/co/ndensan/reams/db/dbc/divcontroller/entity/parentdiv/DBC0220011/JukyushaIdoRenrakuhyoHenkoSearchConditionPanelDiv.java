package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0220011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * JukyushaIdoRenrakuhyoHenkoSearchConditionPanel のクラスファイル
 *
 * @reamsid_L DBC-2101-010 quxiaodong
 */
public class JukyushaIdoRenrakuhyoHenkoSearchConditionPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtIdoDateRange")
    private TextBoxDateRange txtIdoDateRange;
    @JsonProperty("txtSearchHihoNo")
    private TextBoxCode txtSearchHihoNo;
    @JsonProperty("btnSearchHihokensha")
    private Button btnSearchHihokensha;
    @JsonProperty("chkIsSearchDeletedData")
    private CheckBoxList chkIsSearchDeletedData;
    @JsonProperty("lblSearchCondition")
    private Label lblSearchCondition;
    @JsonProperty("searchHorizontalLine")
    private HorizontalLine searchHorizontalLine;
    @JsonProperty("btnClearSearchCondition")
    private Button btnClearSearchCondition;
    @JsonProperty("btnSearch")
    private Button btnSearch;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtIdoDateRange
     * @return txtIdoDateRange
     */
    @JsonProperty("txtIdoDateRange")
    public TextBoxDateRange getTxtIdoDateRange() {
        return txtIdoDateRange;
    }

    /*
     * settxtIdoDateRange
     * @param txtIdoDateRange txtIdoDateRange
     */
    @JsonProperty("txtIdoDateRange")
    public void setTxtIdoDateRange(TextBoxDateRange txtIdoDateRange) {
        this.txtIdoDateRange = txtIdoDateRange;
    }

    /*
     * gettxtSearchHihoNo
     * @return txtSearchHihoNo
     */
    @JsonProperty("txtSearchHihoNo")
    public TextBoxCode getTxtSearchHihoNo() {
        return txtSearchHihoNo;
    }

    /*
     * settxtSearchHihoNo
     * @param txtSearchHihoNo txtSearchHihoNo
     */
    @JsonProperty("txtSearchHihoNo")
    public void setTxtSearchHihoNo(TextBoxCode txtSearchHihoNo) {
        this.txtSearchHihoNo = txtSearchHihoNo;
    }

    /*
     * getbtnSearchHihokensha
     * @return btnSearchHihokensha
     */
    @JsonProperty("btnSearchHihokensha")
    public Button getBtnSearchHihokensha() {
        return btnSearchHihokensha;
    }

    /*
     * setbtnSearchHihokensha
     * @param btnSearchHihokensha btnSearchHihokensha
     */
    @JsonProperty("btnSearchHihokensha")
    public void setBtnSearchHihokensha(Button btnSearchHihokensha) {
        this.btnSearchHihokensha = btnSearchHihokensha;
    }

    /*
     * getchkIsSearchDeletedData
     * @return chkIsSearchDeletedData
     */
    @JsonProperty("chkIsSearchDeletedData")
    public CheckBoxList getChkIsSearchDeletedData() {
        return chkIsSearchDeletedData;
    }

    /*
     * setchkIsSearchDeletedData
     * @param chkIsSearchDeletedData chkIsSearchDeletedData
     */
    @JsonProperty("chkIsSearchDeletedData")
    public void setChkIsSearchDeletedData(CheckBoxList chkIsSearchDeletedData) {
        this.chkIsSearchDeletedData = chkIsSearchDeletedData;
    }

    /*
     * getlblSearchCondition
     * @return lblSearchCondition
     */
    @JsonProperty("lblSearchCondition")
    public Label getLblSearchCondition() {
        return lblSearchCondition;
    }

    /*
     * setlblSearchCondition
     * @param lblSearchCondition lblSearchCondition
     */
    @JsonProperty("lblSearchCondition")
    public void setLblSearchCondition(Label lblSearchCondition) {
        this.lblSearchCondition = lblSearchCondition;
    }

    /*
     * getsearchHorizontalLine
     * @return searchHorizontalLine
     */
    @JsonProperty("searchHorizontalLine")
    public HorizontalLine getSearchHorizontalLine() {
        return searchHorizontalLine;
    }

    /*
     * setsearchHorizontalLine
     * @param searchHorizontalLine searchHorizontalLine
     */
    @JsonProperty("searchHorizontalLine")
    public void setSearchHorizontalLine(HorizontalLine searchHorizontalLine) {
        this.searchHorizontalLine = searchHorizontalLine;
    }

    /*
     * getbtnClearSearchCondition
     * @return btnClearSearchCondition
     */
    @JsonProperty("btnClearSearchCondition")
    public Button getBtnClearSearchCondition() {
        return btnClearSearchCondition;
    }

    /*
     * setbtnClearSearchCondition
     * @param btnClearSearchCondition btnClearSearchCondition
     */
    @JsonProperty("btnClearSearchCondition")
    public void setBtnClearSearchCondition(Button btnClearSearchCondition) {
        this.btnClearSearchCondition = btnClearSearchCondition;
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

    // </editor-fold>
}
