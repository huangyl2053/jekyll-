package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * HihokenshaKensakuJoken のクラスファイル
 *
 * @reamsid_L DBC-3000-010 gongliang
 */
public class HihokenshaKensakuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihoNo")
    private TextBoxCode txtHihoNo;
    @JsonProperty("btnSearchHihokensha")
    private ButtonDialog btnSearchHihokensha;
    @JsonProperty("txtHihoName")
    private TextBox txtHihoName;
    @JsonProperty("txtTeikyoYMRange")
    private TextBoxDateRange txtTeikyoYMRange;
    @JsonProperty("txtShinseiYMRange")
    private TextBoxDateRange txtShinseiYMRange;
    @JsonProperty("txtKetteiYMRange")
    private TextBoxDateRange txtKetteiYMRange;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * gettxtShinseiYMRange
     * @return txtShinseiYMRange
     */
    @JsonProperty("txtShinseiYMRange")
    public TextBoxDateRange getTxtShinseiYMRange() {
        return txtShinseiYMRange;
    }

    /*
     * settxtShinseiYMRange
     * @param txtShinseiYMRange txtShinseiYMRange
     */
    @JsonProperty("txtShinseiYMRange")
    public void setTxtShinseiYMRange(TextBoxDateRange txtShinseiYMRange) {
        this.txtShinseiYMRange = txtShinseiYMRange;
    }

    /*
     * gettxtKetteiYMRange
     * @return txtKetteiYMRange
     */
    @JsonProperty("txtKetteiYMRange")
    public TextBoxDateRange getTxtKetteiYMRange() {
        return txtKetteiYMRange;
    }

    /*
     * settxtKetteiYMRange
     * @param txtKetteiYMRange txtKetteiYMRange
     */
    @JsonProperty("txtKetteiYMRange")
    public void setTxtKetteiYMRange(TextBoxDateRange txtKetteiYMRange) {
        this.txtKetteiYMRange = txtKetteiYMRange;
    }

    // </editor-fold>
}
