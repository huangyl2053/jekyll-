package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0260011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
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
 * KyodoIdoRenrakuhyoTaishoshaKensakuMain のクラスファイル
 *
 * @reamsid_L DBC-1951-010 wangkanglei
 */
public class KyodoIdoRenrakuhyoTaishoshaKensakuMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoSearch")
    private KyodoIdoRenrakuhyoHenkoSearchDiv KyodoIdoRenrakuhyoHenkoSearch;
    @JsonProperty("KyodoIdoRenrakuhyoHenkoResult")
    private KyodoIdoRenrakuhyoHenkoResultDiv KyodoIdoRenrakuhyoHenkoResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyodoIdoRenrakuhyoHenkoSearch
     * @return KyodoIdoRenrakuhyoHenkoSearch
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoSearch")
    public KyodoIdoRenrakuhyoHenkoSearchDiv getKyodoIdoRenrakuhyoHenkoSearch() {
        return KyodoIdoRenrakuhyoHenkoSearch;
    }

    /*
     * setKyodoIdoRenrakuhyoHenkoSearch
     * @param KyodoIdoRenrakuhyoHenkoSearch KyodoIdoRenrakuhyoHenkoSearch
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoSearch")
    public void setKyodoIdoRenrakuhyoHenkoSearch(KyodoIdoRenrakuhyoHenkoSearchDiv KyodoIdoRenrakuhyoHenkoSearch) {
        this.KyodoIdoRenrakuhyoHenkoSearch = KyodoIdoRenrakuhyoHenkoSearch;
    }

    /*
     * getKyodoIdoRenrakuhyoHenkoResult
     * @return KyodoIdoRenrakuhyoHenkoResult
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoResult")
    public KyodoIdoRenrakuhyoHenkoResultDiv getKyodoIdoRenrakuhyoHenkoResult() {
        return KyodoIdoRenrakuhyoHenkoResult;
    }

    /*
     * setKyodoIdoRenrakuhyoHenkoResult
     * @param KyodoIdoRenrakuhyoHenkoResult KyodoIdoRenrakuhyoHenkoResult
     */
    @JsonProperty("KyodoIdoRenrakuhyoHenkoResult")
    public void setKyodoIdoRenrakuhyoHenkoResult(KyodoIdoRenrakuhyoHenkoResultDiv KyodoIdoRenrakuhyoHenkoResult) {
        this.KyodoIdoRenrakuhyoHenkoResult = KyodoIdoRenrakuhyoHenkoResult;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtSearchIdoYMD() {
        return this.getKyodoIdoRenrakuhyoHenkoSearch().getTxtSearchIdoYMD();
    }

    @JsonIgnore
    public void setTxtSearchIdoYMD(TextBoxDateRange txtSearchIdoYMD) {
        this.getKyodoIdoRenrakuhyoHenkoSearch().setTxtSearchIdoYMD(txtSearchIdoYMD);
    }

    @JsonIgnore
    public TextBox getTxtSearchHihokenshaNo() {
        return this.getKyodoIdoRenrakuhyoHenkoSearch().getTxtSearchHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtSearchHihokenshaNo(TextBox txtSearchHihokenshaNo) {
        this.getKyodoIdoRenrakuhyoHenkoSearch().setTxtSearchHihokenshaNo(txtSearchHihokenshaNo);
    }

    @JsonIgnore
    public Button getBtnSearchHihokensha() {
        return this.getKyodoIdoRenrakuhyoHenkoSearch().getBtnSearchHihokensha();
    }

    @JsonIgnore
    public void setBtnSearchHihokensha(Button btnSearchHihokensha) {
        this.getKyodoIdoRenrakuhyoHenkoSearch().setBtnSearchHihokensha(btnSearchHihokensha);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtHihokenshaMei() {
        return this.getKyodoIdoRenrakuhyoHenkoSearch().getTxtHihokenshaMei();
    }

    @JsonIgnore
    public void setTxtHihokenshaMei(TextBoxAtenaMeisho txtHihokenshaMei) {
        this.getKyodoIdoRenrakuhyoHenkoSearch().setTxtHihokenshaMei(txtHihokenshaMei);
    }

    @JsonIgnore
    public CheckBoxList getChkSearchDeleteData() {
        return this.getKyodoIdoRenrakuhyoHenkoSearch().getChkSearchDeleteData();
    }

    @JsonIgnore
    public void setChkSearchDeleteData(CheckBoxList chkSearchDeleteData) {
        this.getKyodoIdoRenrakuhyoHenkoSearch().setChkSearchDeleteData(chkSearchDeleteData);
    }

    @JsonIgnore
    public Label getLblSearchCondition() {
        return this.getKyodoIdoRenrakuhyoHenkoSearch().getLblSearchCondition();
    }

    @JsonIgnore
    public void setLblSearchCondition(Label lblSearchCondition) {
        this.getKyodoIdoRenrakuhyoHenkoSearch().setLblSearchCondition(lblSearchCondition);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getKyodoIdoRenrakuhyoHenkoSearch().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getKyodoIdoRenrakuhyoHenkoSearch().setLin1(lin1);
    }

    @JsonIgnore
    public Button getBtnSearchClear() {
        return this.getKyodoIdoRenrakuhyoHenkoSearch().getBtnSearchClear();
    }

    @JsonIgnore
    public void setBtnSearchClear(Button btnSearchClear) {
        this.getKyodoIdoRenrakuhyoHenkoSearch().setBtnSearchClear(btnSearchClear);
    }

    // </editor-fold>
}
