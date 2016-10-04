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
 * HanteiKekkaDetailR のクラスファイル
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class HanteiKekkaDetailRDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihoNoR")
    private TextBoxCode txtHihoNoR;
    @JsonProperty("txtHihoNameL")
    private TextBox txtHihoNameL;
    @JsonProperty("txtUketsukeDateR")
    private TextBoxDate txtUketsukeDateR;
    @JsonProperty("txtKetteiDateR")
    private TextBoxDate txtKetteiDateR;
    @JsonProperty("radShinsaMethodR")
    private RadioButton radShinsaMethodR;
    @JsonProperty("txtShiharaiAmountR")
    private TextBoxNum txtShiharaiAmountR;
    @JsonProperty("radShikyuKubunR")
    private RadioButton radShikyuKubunR;
    @JsonProperty("txtShikyuAmountR")
    private TextBoxNum txtShikyuAmountR;
    @JsonProperty("txtFushikyuRiyuR")
    private TextBoxMultiLine txtFushikyuRiyuR;
    @JsonProperty("radKogakuAutoShokanR")
    private RadioButton radKogakuAutoShokanR;
    @JsonProperty("txtBikoR")
    private TextBox txtBikoR;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihoNoR
     * @return txtHihoNoR
     */
    @JsonProperty("txtHihoNoR")
    public TextBoxCode getTxtHihoNoR() {
        return txtHihoNoR;
    }

    /*
     * settxtHihoNoR
     * @param txtHihoNoR txtHihoNoR
     */
    @JsonProperty("txtHihoNoR")
    public void setTxtHihoNoR(TextBoxCode txtHihoNoR) {
        this.txtHihoNoR = txtHihoNoR;
    }

    /*
     * gettxtHihoNameL
     * @return txtHihoNameL
     */
    @JsonProperty("txtHihoNameL")
    public TextBox getTxtHihoNameL() {
        return txtHihoNameL;
    }

    /*
     * settxtHihoNameL
     * @param txtHihoNameL txtHihoNameL
     */
    @JsonProperty("txtHihoNameL")
    public void setTxtHihoNameL(TextBox txtHihoNameL) {
        this.txtHihoNameL = txtHihoNameL;
    }

    /*
     * gettxtUketsukeDateR
     * @return txtUketsukeDateR
     */
    @JsonProperty("txtUketsukeDateR")
    public TextBoxDate getTxtUketsukeDateR() {
        return txtUketsukeDateR;
    }

    /*
     * settxtUketsukeDateR
     * @param txtUketsukeDateR txtUketsukeDateR
     */
    @JsonProperty("txtUketsukeDateR")
    public void setTxtUketsukeDateR(TextBoxDate txtUketsukeDateR) {
        this.txtUketsukeDateR = txtUketsukeDateR;
    }

    /*
     * gettxtKetteiDateR
     * @return txtKetteiDateR
     */
    @JsonProperty("txtKetteiDateR")
    public TextBoxDate getTxtKetteiDateR() {
        return txtKetteiDateR;
    }

    /*
     * settxtKetteiDateR
     * @param txtKetteiDateR txtKetteiDateR
     */
    @JsonProperty("txtKetteiDateR")
    public void setTxtKetteiDateR(TextBoxDate txtKetteiDateR) {
        this.txtKetteiDateR = txtKetteiDateR;
    }

    /*
     * getradShinsaMethodR
     * @return radShinsaMethodR
     */
    @JsonProperty("radShinsaMethodR")
    public RadioButton getRadShinsaMethodR() {
        return radShinsaMethodR;
    }

    /*
     * setradShinsaMethodR
     * @param radShinsaMethodR radShinsaMethodR
     */
    @JsonProperty("radShinsaMethodR")
    public void setRadShinsaMethodR(RadioButton radShinsaMethodR) {
        this.radShinsaMethodR = radShinsaMethodR;
    }

    /*
     * gettxtShiharaiAmountR
     * @return txtShiharaiAmountR
     */
    @JsonProperty("txtShiharaiAmountR")
    public TextBoxNum getTxtShiharaiAmountR() {
        return txtShiharaiAmountR;
    }

    /*
     * settxtShiharaiAmountR
     * @param txtShiharaiAmountR txtShiharaiAmountR
     */
    @JsonProperty("txtShiharaiAmountR")
    public void setTxtShiharaiAmountR(TextBoxNum txtShiharaiAmountR) {
        this.txtShiharaiAmountR = txtShiharaiAmountR;
    }

    /*
     * getradShikyuKubunR
     * @return radShikyuKubunR
     */
    @JsonProperty("radShikyuKubunR")
    public RadioButton getRadShikyuKubunR() {
        return radShikyuKubunR;
    }

    /*
     * setradShikyuKubunR
     * @param radShikyuKubunR radShikyuKubunR
     */
    @JsonProperty("radShikyuKubunR")
    public void setRadShikyuKubunR(RadioButton radShikyuKubunR) {
        this.radShikyuKubunR = radShikyuKubunR;
    }

    /*
     * gettxtShikyuAmountR
     * @return txtShikyuAmountR
     */
    @JsonProperty("txtShikyuAmountR")
    public TextBoxNum getTxtShikyuAmountR() {
        return txtShikyuAmountR;
    }

    /*
     * settxtShikyuAmountR
     * @param txtShikyuAmountR txtShikyuAmountR
     */
    @JsonProperty("txtShikyuAmountR")
    public void setTxtShikyuAmountR(TextBoxNum txtShikyuAmountR) {
        this.txtShikyuAmountR = txtShikyuAmountR;
    }

    /*
     * gettxtFushikyuRiyuR
     * @return txtFushikyuRiyuR
     */
    @JsonProperty("txtFushikyuRiyuR")
    public TextBoxMultiLine getTxtFushikyuRiyuR() {
        return txtFushikyuRiyuR;
    }

    /*
     * settxtFushikyuRiyuR
     * @param txtFushikyuRiyuR txtFushikyuRiyuR
     */
    @JsonProperty("txtFushikyuRiyuR")
    public void setTxtFushikyuRiyuR(TextBoxMultiLine txtFushikyuRiyuR) {
        this.txtFushikyuRiyuR = txtFushikyuRiyuR;
    }

    /*
     * getradKogakuAutoShokanR
     * @return radKogakuAutoShokanR
     */
    @JsonProperty("radKogakuAutoShokanR")
    public RadioButton getRadKogakuAutoShokanR() {
        return radKogakuAutoShokanR;
    }

    /*
     * setradKogakuAutoShokanR
     * @param radKogakuAutoShokanR radKogakuAutoShokanR
     */
    @JsonProperty("radKogakuAutoShokanR")
    public void setRadKogakuAutoShokanR(RadioButton radKogakuAutoShokanR) {
        this.radKogakuAutoShokanR = radKogakuAutoShokanR;
    }

    /*
     * gettxtBikoR
     * @return txtBikoR
     */
    @JsonProperty("txtBikoR")
    public TextBox getTxtBikoR() {
        return txtBikoR;
    }

    /*
     * settxtBikoR
     * @param txtBikoR txtBikoR
     */
    @JsonProperty("txtBikoR")
    public void setTxtBikoR(TextBox txtBikoR) {
        this.txtBikoR = txtBikoR;
    }

    // </editor-fold>
}
