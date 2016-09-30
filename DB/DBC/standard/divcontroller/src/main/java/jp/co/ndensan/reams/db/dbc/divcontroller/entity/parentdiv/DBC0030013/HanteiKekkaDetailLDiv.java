package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * HanteiKekkaDetailL のクラスファイル
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class HanteiKekkaDetailLDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihoNoL")
    private TextBoxCode txtHihoNoL;
    @JsonProperty("txtHihoNameR")
    private TextBox txtHihoNameR;
    @JsonProperty("txtUketsukeDateL")
    private TextBoxDate txtUketsukeDateL;
    @JsonProperty("txtKetteiDateL")
    private TextBoxDate txtKetteiDateL;
    @JsonProperty("radShinsaMethodL")
    private RadioButton radShinsaMethodL;
    @JsonProperty("txtShiharaiAmountL")
    private TextBoxNum txtShiharaiAmountL;
    @JsonProperty("radShikyuKubunL")
    private RadioButton radShikyuKubunL;
    @JsonProperty("txtShikyuAmountL")
    private TextBoxNum txtShikyuAmountL;
    @JsonProperty("txtFushikyuRiyuL")
    private TextBoxMultiLine txtFushikyuRiyuL;
    @JsonProperty("radKogakuAutoShokanL")
    private RadioButton radKogakuAutoShokanL;
    @JsonProperty("txtBikoL")
    private TextBox txtBikoL;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihoNoL
     * @return txtHihoNoL
     */
    @JsonProperty("txtHihoNoL")
    public TextBoxCode getTxtHihoNoL() {
        return txtHihoNoL;
    }

    /*
     * settxtHihoNoL
     * @param txtHihoNoL txtHihoNoL
     */
    @JsonProperty("txtHihoNoL")
    public void setTxtHihoNoL(TextBoxCode txtHihoNoL) {
        this.txtHihoNoL = txtHihoNoL;
    }

    /*
     * gettxtHihoNameR
     * @return txtHihoNameR
     */
    @JsonProperty("txtHihoNameR")
    public TextBox getTxtHihoNameR() {
        return txtHihoNameR;
    }

    /*
     * settxtHihoNameR
     * @param txtHihoNameR txtHihoNameR
     */
    @JsonProperty("txtHihoNameR")
    public void setTxtHihoNameR(TextBox txtHihoNameR) {
        this.txtHihoNameR = txtHihoNameR;
    }

    /*
     * gettxtUketsukeDateL
     * @return txtUketsukeDateL
     */
    @JsonProperty("txtUketsukeDateL")
    public TextBoxDate getTxtUketsukeDateL() {
        return txtUketsukeDateL;
    }

    /*
     * settxtUketsukeDateL
     * @param txtUketsukeDateL txtUketsukeDateL
     */
    @JsonProperty("txtUketsukeDateL")
    public void setTxtUketsukeDateL(TextBoxDate txtUketsukeDateL) {
        this.txtUketsukeDateL = txtUketsukeDateL;
    }

    /*
     * gettxtKetteiDateL
     * @return txtKetteiDateL
     */
    @JsonProperty("txtKetteiDateL")
    public TextBoxDate getTxtKetteiDateL() {
        return txtKetteiDateL;
    }

    /*
     * settxtKetteiDateL
     * @param txtKetteiDateL txtKetteiDateL
     */
    @JsonProperty("txtKetteiDateL")
    public void setTxtKetteiDateL(TextBoxDate txtKetteiDateL) {
        this.txtKetteiDateL = txtKetteiDateL;
    }

    /*
     * getradShinsaMethodL
     * @return radShinsaMethodL
     */
    @JsonProperty("radShinsaMethodL")
    public RadioButton getRadShinsaMethodL() {
        return radShinsaMethodL;
    }

    /*
     * setradShinsaMethodL
     * @param radShinsaMethodL radShinsaMethodL
     */
    @JsonProperty("radShinsaMethodL")
    public void setRadShinsaMethodL(RadioButton radShinsaMethodL) {
        this.radShinsaMethodL = radShinsaMethodL;
    }

    /*
     * gettxtShiharaiAmountL
     * @return txtShiharaiAmountL
     */
    @JsonProperty("txtShiharaiAmountL")
    public TextBoxNum getTxtShiharaiAmountL() {
        return txtShiharaiAmountL;
    }

    /*
     * settxtShiharaiAmountL
     * @param txtShiharaiAmountL txtShiharaiAmountL
     */
    @JsonProperty("txtShiharaiAmountL")
    public void setTxtShiharaiAmountL(TextBoxNum txtShiharaiAmountL) {
        this.txtShiharaiAmountL = txtShiharaiAmountL;
    }

    /*
     * getradShikyuKubunL
     * @return radShikyuKubunL
     */
    @JsonProperty("radShikyuKubunL")
    public RadioButton getRadShikyuKubunL() {
        return radShikyuKubunL;
    }

    /*
     * setradShikyuKubunL
     * @param radShikyuKubunL radShikyuKubunL
     */
    @JsonProperty("radShikyuKubunL")
    public void setRadShikyuKubunL(RadioButton radShikyuKubunL) {
        this.radShikyuKubunL = radShikyuKubunL;
    }

    /*
     * gettxtShikyuAmountL
     * @return txtShikyuAmountL
     */
    @JsonProperty("txtShikyuAmountL")
    public TextBoxNum getTxtShikyuAmountL() {
        return txtShikyuAmountL;
    }

    /*
     * settxtShikyuAmountL
     * @param txtShikyuAmountL txtShikyuAmountL
     */
    @JsonProperty("txtShikyuAmountL")
    public void setTxtShikyuAmountL(TextBoxNum txtShikyuAmountL) {
        this.txtShikyuAmountL = txtShikyuAmountL;
    }

    /*
     * gettxtFushikyuRiyuL
     * @return txtFushikyuRiyuL
     */
    @JsonProperty("txtFushikyuRiyuL")
    public TextBoxMultiLine getTxtFushikyuRiyuL() {
        return txtFushikyuRiyuL;
    }

    /*
     * settxtFushikyuRiyuL
     * @param txtFushikyuRiyuL txtFushikyuRiyuL
     */
    @JsonProperty("txtFushikyuRiyuL")
    public void setTxtFushikyuRiyuL(TextBoxMultiLine txtFushikyuRiyuL) {
        this.txtFushikyuRiyuL = txtFushikyuRiyuL;
    }

    /*
     * getradKogakuAutoShokanL
     * @return radKogakuAutoShokanL
     */
    @JsonProperty("radKogakuAutoShokanL")
    public RadioButton getRadKogakuAutoShokanL() {
        return radKogakuAutoShokanL;
    }

    /*
     * setradKogakuAutoShokanL
     * @param radKogakuAutoShokanL radKogakuAutoShokanL
     */
    @JsonProperty("radKogakuAutoShokanL")
    public void setRadKogakuAutoShokanL(RadioButton radKogakuAutoShokanL) {
        this.radKogakuAutoShokanL = radKogakuAutoShokanL;
    }

    /*
     * gettxtBikoL
     * @return txtBikoL
     */
    @JsonProperty("txtBikoL")
    public TextBox getTxtBikoL() {
        return txtBikoL;
    }

    /*
     * settxtBikoL
     * @param txtBikoL txtBikoL
     */
    @JsonProperty("txtBikoL")
    public void setTxtBikoL(TextBox txtBikoL) {
        this.txtBikoL = txtBikoL;
    }

    // </editor-fold>
}
