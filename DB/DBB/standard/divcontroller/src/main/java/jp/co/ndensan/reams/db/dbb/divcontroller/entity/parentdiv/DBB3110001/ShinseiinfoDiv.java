package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB3110001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * Shinseiinfo のクラスファイル
 *
 * @reamsid_L DBB-1660-010 gongliang
 */
public class ShinseiinfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChoteiYY")
    private TextBoxDate txtChoteiYY;
    @JsonProperty("txtFukaYY")
    private TextBoxDate txtFukaYY;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("txtShinseiGemmengaku")
    private TextBoxNum txtShinseiGemmengaku;
    @JsonProperty("btnGemmenShurui")
    private ButtonDialog btnGemmenShurui;
    @JsonProperty("txtGemmenShurui")
    private TextBox txtGemmenShurui;
    @JsonProperty("txtShinseiRiyu")
    private TextBoxMultiLine txtShinseiRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChoteiYY
     * @return txtChoteiYY
     */
    @JsonProperty("txtChoteiYY")
    public TextBoxDate getTxtChoteiYY() {
        return txtChoteiYY;
    }

    /*
     * settxtChoteiYY
     * @param txtChoteiYY txtChoteiYY
     */
    @JsonProperty("txtChoteiYY")
    public void setTxtChoteiYY(TextBoxDate txtChoteiYY) {
        this.txtChoteiYY = txtChoteiYY;
    }

    /*
     * gettxtFukaYY
     * @return txtFukaYY
     */
    @JsonProperty("txtFukaYY")
    public TextBoxDate getTxtFukaYY() {
        return txtFukaYY;
    }

    /*
     * settxtFukaYY
     * @param txtFukaYY txtFukaYY
     */
    @JsonProperty("txtFukaYY")
    public void setTxtFukaYY(TextBoxDate txtFukaYY) {
        this.txtFukaYY = txtFukaYY;
    }

    /*
     * gettxtShinseiYMD
     * @return txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    /*
     * settxtShinseiYMD
     * @param txtShinseiYMD txtShinseiYMD
     */
    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD = txtShinseiYMD;
    }

    /*
     * gettxtShinseiGemmengaku
     * @return txtShinseiGemmengaku
     */
    @JsonProperty("txtShinseiGemmengaku")
    public TextBoxNum getTxtShinseiGemmengaku() {
        return txtShinseiGemmengaku;
    }

    /*
     * settxtShinseiGemmengaku
     * @param txtShinseiGemmengaku txtShinseiGemmengaku
     */
    @JsonProperty("txtShinseiGemmengaku")
    public void setTxtShinseiGemmengaku(TextBoxNum txtShinseiGemmengaku) {
        this.txtShinseiGemmengaku = txtShinseiGemmengaku;
    }

    /*
     * getbtnGemmenShurui
     * @return btnGemmenShurui
     */
    @JsonProperty("btnGemmenShurui")
    public ButtonDialog getBtnGemmenShurui() {
        return btnGemmenShurui;
    }

    /*
     * setbtnGemmenShurui
     * @param btnGemmenShurui btnGemmenShurui
     */
    @JsonProperty("btnGemmenShurui")
    public void setBtnGemmenShurui(ButtonDialog btnGemmenShurui) {
        this.btnGemmenShurui = btnGemmenShurui;
    }

    /*
     * gettxtGemmenShurui
     * @return txtGemmenShurui
     */
    @JsonProperty("txtGemmenShurui")
    public TextBox getTxtGemmenShurui() {
        return txtGemmenShurui;
    }

    /*
     * settxtGemmenShurui
     * @param txtGemmenShurui txtGemmenShurui
     */
    @JsonProperty("txtGemmenShurui")
    public void setTxtGemmenShurui(TextBox txtGemmenShurui) {
        this.txtGemmenShurui = txtGemmenShurui;
    }

    /*
     * gettxtShinseiRiyu
     * @return txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return txtShinseiRiyu;
    }

    /*
     * settxtShinseiRiyu
     * @param txtShinseiRiyu txtShinseiRiyu
     */
    @JsonProperty("txtShinseiRiyu")
    public void setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.txtShinseiRiyu = txtShinseiRiyu;
    }

    // </editor-fold>
}
