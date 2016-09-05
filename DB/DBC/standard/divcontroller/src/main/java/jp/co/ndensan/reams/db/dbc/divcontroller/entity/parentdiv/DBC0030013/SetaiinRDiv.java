package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * SetaiinR のクラスファイル
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class SetaiinRDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HanteiKekkaR")
    private HanteiKekkaRDiv HanteiKekkaR;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHanteiKekkaR
     * @return HanteiKekkaR
     */
    @JsonProperty("HanteiKekkaR")
    public HanteiKekkaRDiv getHanteiKekkaR() {
        return HanteiKekkaR;
    }

    /*
     * setHanteiKekkaR
     * @param HanteiKekkaR HanteiKekkaR
     */
    @JsonProperty("HanteiKekkaR")
    public void setHanteiKekkaR(HanteiKekkaRDiv HanteiKekkaR) {
        this.HanteiKekkaR = HanteiKekkaR;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihoNoR() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getTxtHihoNoR();
    }

    @JsonIgnore
    public void setTxtHihoNoR(TextBoxCode txtHihoNoR) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setTxtHihoNoR(txtHihoNoR);
    }

    @JsonIgnore
    public TextBox getTxtHihoNameL() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getTxtHihoNameL();
    }

    @JsonIgnore
    public void setTxtHihoNameL(TextBox txtHihoNameL) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setTxtHihoNameL(txtHihoNameL);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeDateR() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getTxtUketsukeDateR();
    }

    @JsonIgnore
    public void setTxtUketsukeDateR(TextBoxDate txtUketsukeDateR) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setTxtUketsukeDateR(txtUketsukeDateR);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiDateR() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getTxtKetteiDateR();
    }

    @JsonIgnore
    public void setTxtKetteiDateR(TextBoxDate txtKetteiDateR) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setTxtKetteiDateR(txtKetteiDateR);
    }

    @JsonIgnore
    public RadioButton getRadShinsaMethodR() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getRadShinsaMethodR();
    }

    @JsonIgnore
    public void setRadShinsaMethodR(RadioButton radShinsaMethodR) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setRadShinsaMethodR(radShinsaMethodR);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiAmountR() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getTxtShiharaiAmountR();
    }

    @JsonIgnore
    public void setTxtShiharaiAmountR(TextBoxNum txtShiharaiAmountR) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setTxtShiharaiAmountR(txtShiharaiAmountR);
    }

    @JsonIgnore
    public RadioButton getRadShikyuKubunR() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getRadShikyuKubunR();
    }

    @JsonIgnore
    public void setRadShikyuKubunR(RadioButton radShikyuKubunR) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setRadShikyuKubunR(radShikyuKubunR);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuAmountR() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getTxtShikyuAmountR();
    }

    @JsonIgnore
    public void setTxtShikyuAmountR(TextBoxNum txtShikyuAmountR) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setTxtShikyuAmountR(txtShikyuAmountR);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushikyuRiyuR() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getTxtFushikyuRiyuR();
    }

    @JsonIgnore
    public void setTxtFushikyuRiyuR(TextBoxMultiLine txtFushikyuRiyuR) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setTxtFushikyuRiyuR(txtFushikyuRiyuR);
    }

    @JsonIgnore
    public RadioButton getRadKogakuAutoShokanR() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getRadKogakuAutoShokanR();
    }

    @JsonIgnore
    public void setRadKogakuAutoShokanR(RadioButton radKogakuAutoShokanR) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setRadKogakuAutoShokanR(radKogakuAutoShokanR);
    }

    @JsonIgnore
    public TextBox getTxtBikoR() {
        return this.getHanteiKekkaR().getHanteiKekkaDetailR().getTxtBikoR();
    }

    @JsonIgnore
    public void setTxtBikoR(TextBox txtBikoR) {
        this.getHanteiKekkaR().getHanteiKekkaDetailR().setTxtBikoR(txtBikoR);
    }

    // </editor-fold>
}
