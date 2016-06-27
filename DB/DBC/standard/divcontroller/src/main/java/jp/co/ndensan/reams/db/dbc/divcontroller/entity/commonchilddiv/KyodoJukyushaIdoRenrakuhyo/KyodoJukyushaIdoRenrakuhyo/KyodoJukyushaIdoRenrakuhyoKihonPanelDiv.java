package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyodoJukyushaIdoRenrakuhyo.KyodoJukyushaIdoRenrakuhyo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxKana;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * KyodoJukyushaIdoRenrakuhyoKihonPanel のクラスファイル
 *
 * @reamsid_L DBC-4390-010 xupeng
 */
public class KyodoJukyushaIdoRenrakuhyoKihonPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKihonIdoYMD")
    private TextBoxDate txtKihonIdoYMD;
    @JsonProperty("txtRirekiNo")
    private TextBoxNum txtRirekiNo;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("txtHiHokenshaName")
    private TextBox txtHiHokenshaName;
    @JsonProperty("txtTelNo")
    private TextBox txtTelNo;
    @JsonProperty("txtChohyoOutputJunjyoCode")
    private TextBox txtChohyoOutputJunjyoCode;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtAddress")
    private TextBox txtAddress;
    @JsonProperty("txtAddressKana")
    private TextBoxKana txtAddressKana;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKihonIdoYMD
     * @return txtKihonIdoYMD
     */
    @JsonProperty("txtKihonIdoYMD")
    public TextBoxDate getTxtKihonIdoYMD() {
        return txtKihonIdoYMD;
    }

    /*
     * settxtKihonIdoYMD
     * @param txtKihonIdoYMD txtKihonIdoYMD
     */
    @JsonProperty("txtKihonIdoYMD")
    public void setTxtKihonIdoYMD(TextBoxDate txtKihonIdoYMD) {
        this.txtKihonIdoYMD = txtKihonIdoYMD;
    }

    /*
     * gettxtRirekiNo
     * @return txtRirekiNo
     */
    @JsonProperty("txtRirekiNo")
    public TextBoxNum getTxtRirekiNo() {
        return txtRirekiNo;
    }

    /*
     * settxtRirekiNo
     * @param txtRirekiNo txtRirekiNo
     */
    @JsonProperty("txtRirekiNo")
    public void setTxtRirekiNo(TextBoxNum txtRirekiNo) {
        this.txtRirekiNo = txtRirekiNo;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * gettxtHiHokenshaName
     * @return txtHiHokenshaName
     */
    @JsonProperty("txtHiHokenshaName")
    public TextBox getTxtHiHokenshaName() {
        return txtHiHokenshaName;
    }

    /*
     * settxtHiHokenshaName
     * @param txtHiHokenshaName txtHiHokenshaName
     */
    @JsonProperty("txtHiHokenshaName")
    public void setTxtHiHokenshaName(TextBox txtHiHokenshaName) {
        this.txtHiHokenshaName = txtHiHokenshaName;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBox getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBox txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * gettxtChohyoOutputJunjyoCode
     * @return txtChohyoOutputJunjyoCode
     */
    @JsonProperty("txtChohyoOutputJunjyoCode")
    public TextBox getTxtChohyoOutputJunjyoCode() {
        return txtChohyoOutputJunjyoCode;
    }

    /*
     * settxtChohyoOutputJunjyoCode
     * @param txtChohyoOutputJunjyoCode txtChohyoOutputJunjyoCode
     */
    @JsonProperty("txtChohyoOutputJunjyoCode")
    public void setTxtChohyoOutputJunjyoCode(TextBox txtChohyoOutputJunjyoCode) {
        this.txtChohyoOutputJunjyoCode = txtChohyoOutputJunjyoCode;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * gettxtAddress
     * @return txtAddress
     */
    @JsonProperty("txtAddress")
    public TextBox getTxtAddress() {
        return txtAddress;
    }

    /*
     * settxtAddress
     * @param txtAddress txtAddress
     */
    @JsonProperty("txtAddress")
    public void setTxtAddress(TextBox txtAddress) {
        this.txtAddress = txtAddress;
    }

    /*
     * gettxtAddressKana
     * @return txtAddressKana
     */
    @JsonProperty("txtAddressKana")
    public TextBoxKana getTxtAddressKana() {
        return txtAddressKana;
    }

    /*
     * settxtAddressKana
     * @param txtAddressKana txtAddressKana
     */
    @JsonProperty("txtAddressKana")
    public void setTxtAddressKana(TextBoxKana txtAddressKana) {
        this.txtAddressKana = txtAddressKana;
    }

    // </editor-fold>
}
