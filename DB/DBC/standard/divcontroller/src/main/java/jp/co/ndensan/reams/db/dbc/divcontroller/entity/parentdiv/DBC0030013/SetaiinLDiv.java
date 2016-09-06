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
 * SetaiinL のクラスファイル
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class SetaiinLDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HanteiKekkaL")
    private HanteiKekkaLDiv HanteiKekkaL;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHanteiKekkaL
     * @return HanteiKekkaL
     */
    @JsonProperty("HanteiKekkaL")
    public HanteiKekkaLDiv getHanteiKekkaL() {
        return HanteiKekkaL;
    }

    /*
     * setHanteiKekkaL
     * @param HanteiKekkaL HanteiKekkaL
     */
    @JsonProperty("HanteiKekkaL")
    public void setHanteiKekkaL(HanteiKekkaLDiv HanteiKekkaL) {
        this.HanteiKekkaL = HanteiKekkaL;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihoNoL() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getTxtHihoNoL();
    }

    @JsonIgnore
    public void setTxtHihoNoL(TextBoxCode txtHihoNoL) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setTxtHihoNoL(txtHihoNoL);
    }

    @JsonIgnore
    public TextBox getTxtHihoNameR() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getTxtHihoNameR();
    }

    @JsonIgnore
    public void setTxtHihoNameR(TextBox txtHihoNameR) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setTxtHihoNameR(txtHihoNameR);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeDateL() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getTxtUketsukeDateL();
    }

    @JsonIgnore
    public void setTxtUketsukeDateL(TextBoxDate txtUketsukeDateL) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setTxtUketsukeDateL(txtUketsukeDateL);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiDateL() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getTxtKetteiDateL();
    }

    @JsonIgnore
    public void setTxtKetteiDateL(TextBoxDate txtKetteiDateL) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setTxtKetteiDateL(txtKetteiDateL);
    }

    @JsonIgnore
    public RadioButton getRadShinsaMethodL() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getRadShinsaMethodL();
    }

    @JsonIgnore
    public void setRadShinsaMethodL(RadioButton radShinsaMethodL) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setRadShinsaMethodL(radShinsaMethodL);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiAmountL() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getTxtShiharaiAmountL();
    }

    @JsonIgnore
    public void setTxtShiharaiAmountL(TextBoxNum txtShiharaiAmountL) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setTxtShiharaiAmountL(txtShiharaiAmountL);
    }

    @JsonIgnore
    public RadioButton getRadShikyuKubunL() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getRadShikyuKubunL();
    }

    @JsonIgnore
    public void setRadShikyuKubunL(RadioButton radShikyuKubunL) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setRadShikyuKubunL(radShikyuKubunL);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuAmountL() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getTxtShikyuAmountL();
    }

    @JsonIgnore
    public void setTxtShikyuAmountL(TextBoxNum txtShikyuAmountL) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setTxtShikyuAmountL(txtShikyuAmountL);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushikyuRiyuL() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getTxtFushikyuRiyuL();
    }

    @JsonIgnore
    public void setTxtFushikyuRiyuL(TextBoxMultiLine txtFushikyuRiyuL) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setTxtFushikyuRiyuL(txtFushikyuRiyuL);
    }

    @JsonIgnore
    public RadioButton getRadKogakuAutoShokanL() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getRadKogakuAutoShokanL();
    }

    @JsonIgnore
    public void setRadKogakuAutoShokanL(RadioButton radKogakuAutoShokanL) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setRadKogakuAutoShokanL(radKogakuAutoShokanL);
    }

    @JsonIgnore
    public TextBox getTxtBikoL() {
        return this.getHanteiKekkaL().getHanteiKekkaDetailL().getTxtBikoL();
    }

    @JsonIgnore
    public void setTxtBikoL(TextBox txtBikoL) {
        this.getHanteiKekkaL().getHanteiKekkaDetailL().setTxtBikoL(txtBikoL);
    }

    // </editor-fold>
}
