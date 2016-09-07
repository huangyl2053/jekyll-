package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260011;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaMeisho;

/**
 * KyodoIdoRenrakuhyoHenkoSearch のクラスファイル
 *
 * @reamsid_L DBC-1951-010 wangkanglei
 */
public class KyodoIdoRenrakuhyoHenkoSearchDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSearchIdoYMD")
    private TextBoxDateRange txtSearchIdoYMD;
    @JsonProperty("txtSearchHihokenshaNo")
    private TextBox txtSearchHihokenshaNo;
    @JsonProperty("btnSearchHihokensha")
    private Button btnSearchHihokensha;
    @JsonProperty("txtHihokenshaMei")
    private TextBoxAtenaMeisho txtHihokenshaMei;
    @JsonProperty("chkSearchDeleteData")
    private CheckBoxList chkSearchDeleteData;
    @JsonProperty("lblSearchCondition")
    private Label lblSearchCondition;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("btnSearchClear")
    private Button btnSearchClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSearchIdoYMD
     * @return txtSearchIdoYMD
     */
    @JsonProperty("txtSearchIdoYMD")
    public TextBoxDateRange getTxtSearchIdoYMD() {
        return txtSearchIdoYMD;
    }

    /*
     * settxtSearchIdoYMD
     * @param txtSearchIdoYMD txtSearchIdoYMD
     */
    @JsonProperty("txtSearchIdoYMD")
    public void setTxtSearchIdoYMD(TextBoxDateRange txtSearchIdoYMD) {
        this.txtSearchIdoYMD = txtSearchIdoYMD;
    }

    /*
     * gettxtSearchHihokenshaNo
     * @return txtSearchHihokenshaNo
     */
    @JsonProperty("txtSearchHihokenshaNo")
    public TextBox getTxtSearchHihokenshaNo() {
        return txtSearchHihokenshaNo;
    }

    /*
     * settxtSearchHihokenshaNo
     * @param txtSearchHihokenshaNo txtSearchHihokenshaNo
     */
    @JsonProperty("txtSearchHihokenshaNo")
    public void setTxtSearchHihokenshaNo(TextBox txtSearchHihokenshaNo) {
        this.txtSearchHihokenshaNo = txtSearchHihokenshaNo;
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
     * gettxtHihokenshaMei
     * @return txtHihokenshaMei
     */
    @JsonProperty("txtHihokenshaMei")
    public TextBoxAtenaMeisho getTxtHihokenshaMei() {
        return txtHihokenshaMei;
    }

    /*
     * settxtHihokenshaMei
     * @param txtHihokenshaMei txtHihokenshaMei
     */
    @JsonProperty("txtHihokenshaMei")
    public void setTxtHihokenshaMei(TextBoxAtenaMeisho txtHihokenshaMei) {
        this.txtHihokenshaMei = txtHihokenshaMei;
    }

    /*
     * getchkSearchDeleteData
     * @return chkSearchDeleteData
     */
    @JsonProperty("chkSearchDeleteData")
    public CheckBoxList getChkSearchDeleteData() {
        return chkSearchDeleteData;
    }

    /*
     * setchkSearchDeleteData
     * @param chkSearchDeleteData chkSearchDeleteData
     */
    @JsonProperty("chkSearchDeleteData")
    public void setChkSearchDeleteData(CheckBoxList chkSearchDeleteData) {
        this.chkSearchDeleteData = chkSearchDeleteData;
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
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getbtnSearchClear
     * @return btnSearchClear
     */
    @JsonProperty("btnSearchClear")
    public Button getBtnSearchClear() {
        return btnSearchClear;
    }

    /*
     * setbtnSearchClear
     * @param btnSearchClear btnSearchClear
     */
    @JsonProperty("btnSearchClear")
    public void setBtnSearchClear(Button btnSearchClear) {
        this.btnSearchClear = btnSearchClear;
    }

    // </editor-fold>
}
