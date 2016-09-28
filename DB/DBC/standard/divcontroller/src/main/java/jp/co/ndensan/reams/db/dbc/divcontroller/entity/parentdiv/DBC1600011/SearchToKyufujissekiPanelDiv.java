package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1600011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchToKyufujissekiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchToKyufujissekiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdJigyoshaSentaku")
    private ShisetsuJohoCommonChildDivDiv ccdJigyoshaSentaku;
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("btnSearchHihokensha")
    private Button btnSearchHihokensha;
    @JsonProperty("txtHihoName")
    private TextBox txtHihoName;
    @JsonProperty("txtTeikyoYMRange")
    private TextBoxDateRange txtTeikyoYMRange;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("Button1")
    private Button Button1;
    @JsonProperty("HokenshaList")
    private HokenshaListDiv HokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdJigyoshaSentaku
     * @return ccdJigyoshaSentaku
     */
    @JsonProperty("ccdJigyoshaSentaku")
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaSentaku() {
        return ccdJigyoshaSentaku;
    }

    /*
     * gettxtHihoNo
     * @return txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public TextBoxCode getTxtHihoNo() {
        return txtHihoNo;
    }

    /*
     * settxtHihoNo
     * @param txtHihoNo txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.txtHihoNo = txtHihoNo;
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
     * gettxtHihoName
     * @return txtHihoName
     */
    @JsonProperty("txtHihoName")
    public TextBox getTxtHihoName() {
        return txtHihoName;
    }

    /*
     * settxtHihoName
     * @param txtHihoName txtHihoName
     */
    @JsonProperty("txtHihoName")
    public void setTxtHihoName(TextBox txtHihoName) {
        this.txtHihoName = txtHihoName;
    }

    /*
     * gettxtTeikyoYMRange
     * @return txtTeikyoYMRange
     */
    @JsonProperty("txtTeikyoYMRange")
    public TextBoxDateRange getTxtTeikyoYMRange() {
        return txtTeikyoYMRange;
    }

    /*
     * settxtTeikyoYMRange
     * @param txtTeikyoYMRange txtTeikyoYMRange
     */
    @JsonProperty("txtTeikyoYMRange")
    public void setTxtTeikyoYMRange(TextBoxDateRange txtTeikyoYMRange) {
        this.txtTeikyoYMRange = txtTeikyoYMRange;
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
     * getButton1
     * @return Button1
     */
    @JsonProperty("Button1")
    public Button getButton1() {
        return Button1;
    }

    /*
     * setButton1
     * @param Button1 Button1
     */
    @JsonProperty("Button1")
    public void setButton1(Button Button1) {
        this.Button1 = Button1;
    }

    /*
     * getHokenshaList
     * @return HokenshaList
     */
    @JsonProperty("HokenshaList")
    public IHokenshaListDiv getHokenshaList() {
        return HokenshaList;
    }

    // </editor-fold>
}
