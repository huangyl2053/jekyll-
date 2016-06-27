package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * KyodoJukyushaIdoRenrakuhyoShokanPanel のクラスファイル
 *
 * @reamsid_L DBC-4390-010 xupeng
 */
public class KyodoJukyushaIdoRenrakuhyoShokanPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShokanIdoYMD")
    private TextBoxDate txtShokanIdoYMD;
    @JsonProperty("txtShokanRirekiNo")
    private TextBoxNum txtShokanRirekiNo;
    @JsonProperty("lin4")
    private HorizontalLine lin4;
    @JsonProperty("txtHokenKyufuIchijiSashitomeYMD")
    private TextBoxDateRange txtHokenKyufuIchijiSashitomeYMD;
    @JsonProperty("ddlHokenkyufuIchijiSashitomeKubun")
    private DropDownList ddlHokenkyufuIchijiSashitomeKubun;
    @JsonProperty("txtHokenkyufuIchijiSashitomeKingaku")
    private TextBoxNum txtHokenkyufuIchijiSashitomeKingaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShokanIdoYMD
     * @return txtShokanIdoYMD
     */
    @JsonProperty("txtShokanIdoYMD")
    public TextBoxDate getTxtShokanIdoYMD() {
        return txtShokanIdoYMD;
    }

    /*
     * settxtShokanIdoYMD
     * @param txtShokanIdoYMD txtShokanIdoYMD
     */
    @JsonProperty("txtShokanIdoYMD")
    public void setTxtShokanIdoYMD(TextBoxDate txtShokanIdoYMD) {
        this.txtShokanIdoYMD = txtShokanIdoYMD;
    }

    /*
     * gettxtShokanRirekiNo
     * @return txtShokanRirekiNo
     */
    @JsonProperty("txtShokanRirekiNo")
    public TextBoxNum getTxtShokanRirekiNo() {
        return txtShokanRirekiNo;
    }

    /*
     * settxtShokanRirekiNo
     * @param txtShokanRirekiNo txtShokanRirekiNo
     */
    @JsonProperty("txtShokanRirekiNo")
    public void setTxtShokanRirekiNo(TextBoxNum txtShokanRirekiNo) {
        this.txtShokanRirekiNo = txtShokanRirekiNo;
    }

    /*
     * getlin4
     * @return lin4
     */
    @JsonProperty("lin4")
    public HorizontalLine getLin4() {
        return lin4;
    }

    /*
     * setlin4
     * @param lin4 lin4
     */
    @JsonProperty("lin4")
    public void setLin4(HorizontalLine lin4) {
        this.lin4 = lin4;
    }

    /*
     * gettxtHokenKyufuIchijiSashitomeYMD
     * @return txtHokenKyufuIchijiSashitomeYMD
     */
    @JsonProperty("txtHokenKyufuIchijiSashitomeYMD")
    public TextBoxDateRange getTxtHokenKyufuIchijiSashitomeYMD() {
        return txtHokenKyufuIchijiSashitomeYMD;
    }

    /*
     * settxtHokenKyufuIchijiSashitomeYMD
     * @param txtHokenKyufuIchijiSashitomeYMD txtHokenKyufuIchijiSashitomeYMD
     */
    @JsonProperty("txtHokenKyufuIchijiSashitomeYMD")
    public void setTxtHokenKyufuIchijiSashitomeYMD(TextBoxDateRange txtHokenKyufuIchijiSashitomeYMD) {
        this.txtHokenKyufuIchijiSashitomeYMD = txtHokenKyufuIchijiSashitomeYMD;
    }

    /*
     * getddlHokenkyufuIchijiSashitomeKubun
     * @return ddlHokenkyufuIchijiSashitomeKubun
     */
    @JsonProperty("ddlHokenkyufuIchijiSashitomeKubun")
    public DropDownList getDdlHokenkyufuIchijiSashitomeKubun() {
        return ddlHokenkyufuIchijiSashitomeKubun;
    }

    /*
     * setddlHokenkyufuIchijiSashitomeKubun
     * @param ddlHokenkyufuIchijiSashitomeKubun ddlHokenkyufuIchijiSashitomeKubun
     */
    @JsonProperty("ddlHokenkyufuIchijiSashitomeKubun")
    public void setDdlHokenkyufuIchijiSashitomeKubun(DropDownList ddlHokenkyufuIchijiSashitomeKubun) {
        this.ddlHokenkyufuIchijiSashitomeKubun = ddlHokenkyufuIchijiSashitomeKubun;
    }

    /*
     * gettxtHokenkyufuIchijiSashitomeKingaku
     * @return txtHokenkyufuIchijiSashitomeKingaku
     */
    @JsonProperty("txtHokenkyufuIchijiSashitomeKingaku")
    public TextBoxNum getTxtHokenkyufuIchijiSashitomeKingaku() {
        return txtHokenkyufuIchijiSashitomeKingaku;
    }

    /*
     * settxtHokenkyufuIchijiSashitomeKingaku
     * @param txtHokenkyufuIchijiSashitomeKingaku txtHokenkyufuIchijiSashitomeKingaku
     */
    @JsonProperty("txtHokenkyufuIchijiSashitomeKingaku")
    public void setTxtHokenkyufuIchijiSashitomeKingaku(TextBoxNum txtHokenkyufuIchijiSashitomeKingaku) {
        this.txtHokenkyufuIchijiSashitomeKingaku = txtHokenkyufuIchijiSashitomeKingaku;
    }

    // </editor-fold>
}
