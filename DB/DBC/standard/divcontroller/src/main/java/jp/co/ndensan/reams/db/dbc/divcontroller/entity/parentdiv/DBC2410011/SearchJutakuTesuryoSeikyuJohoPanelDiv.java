package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2410011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchJutakuTesuryoSeikyuJohoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchJutakuTesuryoSeikyuJohoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSearchSakuseiYM")
    private TextBoxDate txtSearchSakuseiYM;
    @JsonProperty("chkSerchKetteiZumi")
    private CheckBoxList chkSerchKetteiZumi;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("ccdJigyosha")
    private ShisetsuJohoCommonChildDivDiv ccdJigyosha;
    @JsonProperty("executionStatus")
    private RString executionStatus;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSearchSakuseiYM
     * @return txtSearchSakuseiYM
     */
    @JsonProperty("txtSearchSakuseiYM")
    public TextBoxDate getTxtSearchSakuseiYM() {
        return txtSearchSakuseiYM;
    }

    /*
     * settxtSearchSakuseiYM
     * @param txtSearchSakuseiYM txtSearchSakuseiYM
     */
    @JsonProperty("txtSearchSakuseiYM")
    public void setTxtSearchSakuseiYM(TextBoxDate txtSearchSakuseiYM) {
        this.txtSearchSakuseiYM = txtSearchSakuseiYM;
    }

    /*
     * getchkSerchKetteiZumi
     * @return chkSerchKetteiZumi
     */
    @JsonProperty("chkSerchKetteiZumi")
    public CheckBoxList getChkSerchKetteiZumi() {
        return chkSerchKetteiZumi;
    }

    /*
     * setchkSerchKetteiZumi
     * @param chkSerchKetteiZumi chkSerchKetteiZumi
     */
    @JsonProperty("chkSerchKetteiZumi")
    public void setChkSerchKetteiZumi(CheckBoxList chkSerchKetteiZumi) {
        this.chkSerchKetteiZumi = chkSerchKetteiZumi;
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
     * getccdJigyosha
     * @return ccdJigyosha
     */
    @JsonProperty("ccdJigyosha")
    public IShisetsuJohoCommonChildDiv getCcdJigyosha() {
        return ccdJigyosha;
    }

    /*
     * getexecutionStatus
     * @return executionStatus
     */
    @JsonProperty("executionStatus")
    public RString getExecutionStatus() {
        return executionStatus;
    }

    /*
     * setexecutionStatus
     * @param executionStatus executionStatus
     */
    @JsonProperty("executionStatus")
    public void setExecutionStatus(RString executionStatus) {
        this.executionStatus = executionStatus;
    }

    // </editor-fold>
}
