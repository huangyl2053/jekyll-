package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1500011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("txtJigyoshaNo")
    private TextBox txtJigyoshaNo;
    @JsonProperty("btnSearchJigyosha")
    private ButtonDialog btnSearchJigyosha;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("txtHihoNo")
    private TextBox txtHihoNo;
    @JsonProperty("btnSearchHihokensha")
    private ButtonDialog btnSearchHihokensha;
    @JsonProperty("txtHihoName")
    private TextBox txtHihoName;
    @JsonProperty("txtTeikyoYMRange")
    private TextBoxDateRange txtTeikyoYMRange;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("MoshitateshoSakuseiZumi")
    private CheckBoxList MoshitateshoSakuseiZumi;
    @JsonProperty("Hokenshalist")
    private HokenshaListDiv Hokenshalist;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtJigyoshaNo
     * @return txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public TextBox getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    /*
     * settxtJigyoshaNo
     * @param txtJigyoshaNo txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBox txtJigyoshaNo) {
        this.txtJigyoshaNo = txtJigyoshaNo;
    }

    /*
     * getbtnSearchJigyosha
     * @return btnSearchJigyosha
     */
    @JsonProperty("btnSearchJigyosha")
    public ButtonDialog getBtnSearchJigyosha() {
        return btnSearchJigyosha;
    }

    /*
     * setbtnSearchJigyosha
     * @param btnSearchJigyosha btnSearchJigyosha
     */
    @JsonProperty("btnSearchJigyosha")
    public void setBtnSearchJigyosha(ButtonDialog btnSearchJigyosha) {
        this.btnSearchJigyosha = btnSearchJigyosha;
    }

    /*
     * gettxtJigyoshaName
     * @return txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    /*
     * settxtJigyoshaName
     * @param txtJigyoshaName txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName = txtJigyoshaName;
    }

    /*
     * gettxtHihoNo
     * @return txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public TextBox getTxtHihoNo() {
        return txtHihoNo;
    }

    /*
     * settxtHihoNo
     * @param txtHihoNo txtHihoNo
     */
    @JsonProperty("txtHihoNo")
    public void setTxtHihoNo(TextBox txtHihoNo) {
        this.txtHihoNo = txtHihoNo;
    }

    /*
     * getbtnSearchHihokensha
     * @return btnSearchHihokensha
     */
    @JsonProperty("btnSearchHihokensha")
    public ButtonDialog getBtnSearchHihokensha() {
        return btnSearchHihokensha;
    }

    /*
     * setbtnSearchHihokensha
     * @param btnSearchHihokensha btnSearchHihokensha
     */
    @JsonProperty("btnSearchHihokensha")
    public void setBtnSearchHihokensha(ButtonDialog btnSearchHihokensha) {
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
     * getMoshitateshoSakuseiZumi
     * @return MoshitateshoSakuseiZumi
     */
    @JsonProperty("MoshitateshoSakuseiZumi")
    public CheckBoxList getMoshitateshoSakuseiZumi() {
        return MoshitateshoSakuseiZumi;
    }

    /*
     * setMoshitateshoSakuseiZumi
     * @param MoshitateshoSakuseiZumi MoshitateshoSakuseiZumi
     */
    @JsonProperty("MoshitateshoSakuseiZumi")
    public void setMoshitateshoSakuseiZumi(CheckBoxList MoshitateshoSakuseiZumi) {
        this.MoshitateshoSakuseiZumi = MoshitateshoSakuseiZumi;
    }

    /*
     * getHokenshalist
     * @return Hokenshalist
     */
    @JsonProperty("Hokenshalist")
    public IHokenshaListDiv getHokenshalist() {
        return Hokenshalist;
    }

    // </editor-fold>
}
