package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1150001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.IZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * SofusakiNyuryokuPanel のクラスファイル
 *
 * @reamsid_L DBB-1710-010 xuhao
 */
public class SofusakiNyuryokuPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtSofusakiYubinNo")
    private TextBoxYubinNo txtSofusakiYubinNo;
    @JsonProperty("txtSofusaki01")
    private TextBox txtSofusaki01;
    @JsonProperty("txtSofusaki02")
    private TextBox txtSofusaki02;
    @JsonProperty("txtSofusaki03")
    private TextBox txtSofusaki03;
    @JsonProperty("txtSofusakiOnchu")
    private TextBox txtSofusakiOnchu;
    @JsonProperty("lblOnchu")
    private Label lblOnchu;
    @JsonProperty("txtSofusakiSama")
    private TextBox txtSofusakiSama;
    @JsonProperty("lblSama")
    private Label lblSama;
    @JsonProperty("TextNo")
    private TextBox TextNo;
    @JsonProperty("ccdZenkokuJushoInput1")
    private ZenkokuJushoInputDiv ccdZenkokuJushoInput1;
    @JsonProperty("TextNO1")
    private TextBox TextNO1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtSofusakiYubinNo
     * @return txtSofusakiYubinNo
     */
    @JsonProperty("txtSofusakiYubinNo")
    public TextBoxYubinNo getTxtSofusakiYubinNo() {
        return txtSofusakiYubinNo;
    }

    /*
     * settxtSofusakiYubinNo
     * @param txtSofusakiYubinNo txtSofusakiYubinNo
     */
    @JsonProperty("txtSofusakiYubinNo")
    public void setTxtSofusakiYubinNo(TextBoxYubinNo txtSofusakiYubinNo) {
        this.txtSofusakiYubinNo = txtSofusakiYubinNo;
    }

    /*
     * gettxtSofusaki01
     * @return txtSofusaki01
     */
    @JsonProperty("txtSofusaki01")
    public TextBox getTxtSofusaki01() {
        return txtSofusaki01;
    }

    /*
     * settxtSofusaki01
     * @param txtSofusaki01 txtSofusaki01
     */
    @JsonProperty("txtSofusaki01")
    public void setTxtSofusaki01(TextBox txtSofusaki01) {
        this.txtSofusaki01 = txtSofusaki01;
    }

    /*
     * gettxtSofusaki02
     * @return txtSofusaki02
     */
    @JsonProperty("txtSofusaki02")
    public TextBox getTxtSofusaki02() {
        return txtSofusaki02;
    }

    /*
     * settxtSofusaki02
     * @param txtSofusaki02 txtSofusaki02
     */
    @JsonProperty("txtSofusaki02")
    public void setTxtSofusaki02(TextBox txtSofusaki02) {
        this.txtSofusaki02 = txtSofusaki02;
    }

    /*
     * gettxtSofusaki03
     * @return txtSofusaki03
     */
    @JsonProperty("txtSofusaki03")
    public TextBox getTxtSofusaki03() {
        return txtSofusaki03;
    }

    /*
     * settxtSofusaki03
     * @param txtSofusaki03 txtSofusaki03
     */
    @JsonProperty("txtSofusaki03")
    public void setTxtSofusaki03(TextBox txtSofusaki03) {
        this.txtSofusaki03 = txtSofusaki03;
    }

    /*
     * gettxtSofusakiOnchu
     * @return txtSofusakiOnchu
     */
    @JsonProperty("txtSofusakiOnchu")
    public TextBox getTxtSofusakiOnchu() {
        return txtSofusakiOnchu;
    }

    /*
     * settxtSofusakiOnchu
     * @param txtSofusakiOnchu txtSofusakiOnchu
     */
    @JsonProperty("txtSofusakiOnchu")
    public void setTxtSofusakiOnchu(TextBox txtSofusakiOnchu) {
        this.txtSofusakiOnchu = txtSofusakiOnchu;
    }

    /*
     * getlblOnchu
     * @return lblOnchu
     */
    @JsonProperty("lblOnchu")
    public Label getLblOnchu() {
        return lblOnchu;
    }

    /*
     * setlblOnchu
     * @param lblOnchu lblOnchu
     */
    @JsonProperty("lblOnchu")
    public void setLblOnchu(Label lblOnchu) {
        this.lblOnchu = lblOnchu;
    }

    /*
     * gettxtSofusakiSama
     * @return txtSofusakiSama
     */
    @JsonProperty("txtSofusakiSama")
    public TextBox getTxtSofusakiSama() {
        return txtSofusakiSama;
    }

    /*
     * settxtSofusakiSama
     * @param txtSofusakiSama txtSofusakiSama
     */
    @JsonProperty("txtSofusakiSama")
    public void setTxtSofusakiSama(TextBox txtSofusakiSama) {
        this.txtSofusakiSama = txtSofusakiSama;
    }

    /*
     * getlblSama
     * @return lblSama
     */
    @JsonProperty("lblSama")
    public Label getLblSama() {
        return lblSama;
    }

    /*
     * setlblSama
     * @param lblSama lblSama
     */
    @JsonProperty("lblSama")
    public void setLblSama(Label lblSama) {
        this.lblSama = lblSama;
    }

    /*
     * getTextNo
     * @return TextNo
     */
    @JsonProperty("TextNo")
    public TextBox getTextNo() {
        return TextNo;
    }

    /*
     * setTextNo
     * @param TextNo TextNo
     */
    @JsonProperty("TextNo")
    public void setTextNo(TextBox TextNo) {
        this.TextNo = TextNo;
    }

    /*
     * getccdZenkokuJushoInput1
     * @return ccdZenkokuJushoInput1
     */
    @JsonProperty("ccdZenkokuJushoInput1")
    public IZenkokuJushoInputDiv getCcdZenkokuJushoInput1() {
        return ccdZenkokuJushoInput1;
    }

    /*
     * getTextNO1
     * @return TextNO1
     */
    @JsonProperty("TextNO1")
    public TextBox getTextNO1() {
        return TextNO1;
    }

    /*
     * setTextNO1
     * @param TextNO1 TextNO1
     */
    @JsonProperty("TextNO1")
    public void setTextNO1(TextBox TextNO1) {
        this.TextNO1 = TextNO1;
    }

    // </editor-fold>
}
