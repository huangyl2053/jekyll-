package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0110011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * JigyoshaJoho のクラスファイル
 *
 * @reamsid_L DBC-1920-010 tianshuai
 */
public class JigyoshaJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("txtJigyoshaNo")
    private TextBox txtJigyoshaNo;
    @JsonProperty("btnJigyoshaKensaku")
    private ButtonDialog btnJigyoshaKensaku;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("radServiceShurui")
    private RadioButton radServiceShurui;
    @JsonProperty("txtJigyoshaYubinNo")
    private TextBox txtJigyoshaYubinNo;
    @JsonProperty("txtJigyoshaJusho")
    private TextBoxMultiLine txtJigyoshaJusho;
    @JsonProperty("txtJigyoshaTelNo")
    private TextBox txtJigyoshaTelNo;
    @JsonProperty("txtJigyoshaKanrishaName")
    private TextBox txtJigyoshaKanrishaName;
    @JsonProperty("txtItakusakiJigyoshaNo")
    private TextBox txtItakusakiJigyoshaNo;
    @JsonProperty("btnItakuSakiJigyoshaKensaku")
    private ButtonDialog btnItakuSakiJigyoshaKensaku;
    @JsonProperty("txtItakusakiJigyoshaName")
    private TextBox txtItakusakiJigyoshaName;
    @JsonProperty("lblJigyoshaDescription")
    private Label lblJigyoshaDescription;
    @JsonProperty("txtJigyoshaHenkoYMD")
    private TextBoxDate txtJigyoshaHenkoYMD;
    @JsonProperty("txtJigyoshaHenkoJiyu")
    private TextBoxMultiLine txtJigyoshaHenkoJiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

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
     * getbtnJigyoshaKensaku
     * @return btnJigyoshaKensaku
     */
    @JsonProperty("btnJigyoshaKensaku")
    public ButtonDialog getBtnJigyoshaKensaku() {
        return btnJigyoshaKensaku;
    }

    /*
     * setbtnJigyoshaKensaku
     * @param btnJigyoshaKensaku btnJigyoshaKensaku
     */
    @JsonProperty("btnJigyoshaKensaku")
    public void setBtnJigyoshaKensaku(ButtonDialog btnJigyoshaKensaku) {
        this.btnJigyoshaKensaku = btnJigyoshaKensaku;
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
     * getradServiceShurui
     * @return radServiceShurui
     */
    @JsonProperty("radServiceShurui")
    public RadioButton getRadServiceShurui() {
        return radServiceShurui;
    }

    /*
     * setradServiceShurui
     * @param radServiceShurui radServiceShurui
     */
    @JsonProperty("radServiceShurui")
    public void setRadServiceShurui(RadioButton radServiceShurui) {
        this.radServiceShurui = radServiceShurui;
    }

    /*
     * gettxtJigyoshaYubinNo
     * @return txtJigyoshaYubinNo
     */
    @JsonProperty("txtJigyoshaYubinNo")
    public TextBox getTxtJigyoshaYubinNo() {
        return txtJigyoshaYubinNo;
    }

    /*
     * settxtJigyoshaYubinNo
     * @param txtJigyoshaYubinNo txtJigyoshaYubinNo
     */
    @JsonProperty("txtJigyoshaYubinNo")
    public void setTxtJigyoshaYubinNo(TextBox txtJigyoshaYubinNo) {
        this.txtJigyoshaYubinNo = txtJigyoshaYubinNo;
    }

    /*
     * gettxtJigyoshaJusho
     * @return txtJigyoshaJusho
     */
    @JsonProperty("txtJigyoshaJusho")
    public TextBoxMultiLine getTxtJigyoshaJusho() {
        return txtJigyoshaJusho;
    }

    /*
     * settxtJigyoshaJusho
     * @param txtJigyoshaJusho txtJigyoshaJusho
     */
    @JsonProperty("txtJigyoshaJusho")
    public void setTxtJigyoshaJusho(TextBoxMultiLine txtJigyoshaJusho) {
        this.txtJigyoshaJusho = txtJigyoshaJusho;
    }

    /*
     * gettxtJigyoshaTelNo
     * @return txtJigyoshaTelNo
     */
    @JsonProperty("txtJigyoshaTelNo")
    public TextBox getTxtJigyoshaTelNo() {
        return txtJigyoshaTelNo;
    }

    /*
     * settxtJigyoshaTelNo
     * @param txtJigyoshaTelNo txtJigyoshaTelNo
     */
    @JsonProperty("txtJigyoshaTelNo")
    public void setTxtJigyoshaTelNo(TextBox txtJigyoshaTelNo) {
        this.txtJigyoshaTelNo = txtJigyoshaTelNo;
    }

    /*
     * gettxtJigyoshaKanrishaName
     * @return txtJigyoshaKanrishaName
     */
    @JsonProperty("txtJigyoshaKanrishaName")
    public TextBox getTxtJigyoshaKanrishaName() {
        return txtJigyoshaKanrishaName;
    }

    /*
     * settxtJigyoshaKanrishaName
     * @param txtJigyoshaKanrishaName txtJigyoshaKanrishaName
     */
    @JsonProperty("txtJigyoshaKanrishaName")
    public void setTxtJigyoshaKanrishaName(TextBox txtJigyoshaKanrishaName) {
        this.txtJigyoshaKanrishaName = txtJigyoshaKanrishaName;
    }

    /*
     * gettxtItakusakiJigyoshaNo
     * @return txtItakusakiJigyoshaNo
     */
    @JsonProperty("txtItakusakiJigyoshaNo")
    public TextBox getTxtItakusakiJigyoshaNo() {
        return txtItakusakiJigyoshaNo;
    }

    /*
     * settxtItakusakiJigyoshaNo
     * @param txtItakusakiJigyoshaNo txtItakusakiJigyoshaNo
     */
    @JsonProperty("txtItakusakiJigyoshaNo")
    public void setTxtItakusakiJigyoshaNo(TextBox txtItakusakiJigyoshaNo) {
        this.txtItakusakiJigyoshaNo = txtItakusakiJigyoshaNo;
    }

    /*
     * getbtnItakuSakiJigyoshaKensaku
     * @return btnItakuSakiJigyoshaKensaku
     */
    @JsonProperty("btnItakuSakiJigyoshaKensaku")
    public ButtonDialog getBtnItakuSakiJigyoshaKensaku() {
        return btnItakuSakiJigyoshaKensaku;
    }

    /*
     * setbtnItakuSakiJigyoshaKensaku
     * @param btnItakuSakiJigyoshaKensaku btnItakuSakiJigyoshaKensaku
     */
    @JsonProperty("btnItakuSakiJigyoshaKensaku")
    public void setBtnItakuSakiJigyoshaKensaku(ButtonDialog btnItakuSakiJigyoshaKensaku) {
        this.btnItakuSakiJigyoshaKensaku = btnItakuSakiJigyoshaKensaku;
    }

    /*
     * gettxtItakusakiJigyoshaName
     * @return txtItakusakiJigyoshaName
     */
    @JsonProperty("txtItakusakiJigyoshaName")
    public TextBox getTxtItakusakiJigyoshaName() {
        return txtItakusakiJigyoshaName;
    }

    /*
     * settxtItakusakiJigyoshaName
     * @param txtItakusakiJigyoshaName txtItakusakiJigyoshaName
     */
    @JsonProperty("txtItakusakiJigyoshaName")
    public void setTxtItakusakiJigyoshaName(TextBox txtItakusakiJigyoshaName) {
        this.txtItakusakiJigyoshaName = txtItakusakiJigyoshaName;
    }

    /*
     * getlblJigyoshaDescription
     * @return lblJigyoshaDescription
     */
    @JsonProperty("lblJigyoshaDescription")
    public Label getLblJigyoshaDescription() {
        return lblJigyoshaDescription;
    }

    /*
     * setlblJigyoshaDescription
     * @param lblJigyoshaDescription lblJigyoshaDescription
     */
    @JsonProperty("lblJigyoshaDescription")
    public void setLblJigyoshaDescription(Label lblJigyoshaDescription) {
        this.lblJigyoshaDescription = lblJigyoshaDescription;
    }

    /*
     * gettxtJigyoshaHenkoYMD
     * @return txtJigyoshaHenkoYMD
     */
    @JsonProperty("txtJigyoshaHenkoYMD")
    public TextBoxDate getTxtJigyoshaHenkoYMD() {
        return txtJigyoshaHenkoYMD;
    }

    /*
     * settxtJigyoshaHenkoYMD
     * @param txtJigyoshaHenkoYMD txtJigyoshaHenkoYMD
     */
    @JsonProperty("txtJigyoshaHenkoYMD")
    public void setTxtJigyoshaHenkoYMD(TextBoxDate txtJigyoshaHenkoYMD) {
        this.txtJigyoshaHenkoYMD = txtJigyoshaHenkoYMD;
    }

    /*
     * gettxtJigyoshaHenkoJiyu
     * @return txtJigyoshaHenkoJiyu
     */
    @JsonProperty("txtJigyoshaHenkoJiyu")
    public TextBoxMultiLine getTxtJigyoshaHenkoJiyu() {
        return txtJigyoshaHenkoJiyu;
    }

    /*
     * settxtJigyoshaHenkoJiyu
     * @param txtJigyoshaHenkoJiyu txtJigyoshaHenkoJiyu
     */
    @JsonProperty("txtJigyoshaHenkoJiyu")
    public void setTxtJigyoshaHenkoJiyu(TextBoxMultiLine txtJigyoshaHenkoJiyu) {
        this.txtJigyoshaHenkoJiyu = txtJigyoshaHenkoJiyu;
    }

    // </editor-fold>
}
