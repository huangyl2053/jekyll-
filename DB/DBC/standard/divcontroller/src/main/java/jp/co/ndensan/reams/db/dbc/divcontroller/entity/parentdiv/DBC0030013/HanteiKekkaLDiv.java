package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * HanteiKekkaL のクラスファイル
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class HanteiKekkaLDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJudgementResultL")
    private DataGrid<dgJudgementResultL_Row> dgJudgementResultL;
    @JsonProperty("HanteiKekkaDetailL")
    private HanteiKekkaDetailLDiv HanteiKekkaDetailL;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgJudgementResultL
     * @return dgJudgementResultL
     */
    @JsonProperty("dgJudgementResultL")
    public DataGrid<dgJudgementResultL_Row> getDgJudgementResultL() {
        return dgJudgementResultL;
    }

    /*
     * setdgJudgementResultL
     * @param dgJudgementResultL dgJudgementResultL
     */
    @JsonProperty("dgJudgementResultL")
    public void setDgJudgementResultL(DataGrid<dgJudgementResultL_Row> dgJudgementResultL) {
        this.dgJudgementResultL = dgJudgementResultL;
    }

    /*
     * getHanteiKekkaDetailL
     * @return HanteiKekkaDetailL
     */
    @JsonProperty("HanteiKekkaDetailL")
    public HanteiKekkaDetailLDiv getHanteiKekkaDetailL() {
        return HanteiKekkaDetailL;
    }

    /*
     * setHanteiKekkaDetailL
     * @param HanteiKekkaDetailL HanteiKekkaDetailL
     */
    @JsonProperty("HanteiKekkaDetailL")
    public void setHanteiKekkaDetailL(HanteiKekkaDetailLDiv HanteiKekkaDetailL) {
        this.HanteiKekkaDetailL = HanteiKekkaDetailL;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihoNoL() {
        return this.getHanteiKekkaDetailL().getTxtHihoNoL();
    }

    @JsonIgnore
    public void setTxtHihoNoL(TextBoxCode txtHihoNoL) {
        this.getHanteiKekkaDetailL().setTxtHihoNoL(txtHihoNoL);
    }

    @JsonIgnore
    public TextBox getTxtHihoNameR() {
        return this.getHanteiKekkaDetailL().getTxtHihoNameR();
    }

    @JsonIgnore
    public void setTxtHihoNameR(TextBox txtHihoNameR) {
        this.getHanteiKekkaDetailL().setTxtHihoNameR(txtHihoNameR);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeDateL() {
        return this.getHanteiKekkaDetailL().getTxtUketsukeDateL();
    }

    @JsonIgnore
    public void setTxtUketsukeDateL(TextBoxDate txtUketsukeDateL) {
        this.getHanteiKekkaDetailL().setTxtUketsukeDateL(txtUketsukeDateL);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiDateL() {
        return this.getHanteiKekkaDetailL().getTxtKetteiDateL();
    }

    @JsonIgnore
    public void setTxtKetteiDateL(TextBoxDate txtKetteiDateL) {
        this.getHanteiKekkaDetailL().setTxtKetteiDateL(txtKetteiDateL);
    }

    @JsonIgnore
    public RadioButton getRadShinsaMethodL() {
        return this.getHanteiKekkaDetailL().getRadShinsaMethodL();
    }

    @JsonIgnore
    public void setRadShinsaMethodL(RadioButton radShinsaMethodL) {
        this.getHanteiKekkaDetailL().setRadShinsaMethodL(radShinsaMethodL);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiAmountL() {
        return this.getHanteiKekkaDetailL().getTxtShiharaiAmountL();
    }

    @JsonIgnore
    public void setTxtShiharaiAmountL(TextBoxNum txtShiharaiAmountL) {
        this.getHanteiKekkaDetailL().setTxtShiharaiAmountL(txtShiharaiAmountL);
    }

    @JsonIgnore
    public RadioButton getRadShikyuKubunL() {
        return this.getHanteiKekkaDetailL().getRadShikyuKubunL();
    }

    @JsonIgnore
    public void setRadShikyuKubunL(RadioButton radShikyuKubunL) {
        this.getHanteiKekkaDetailL().setRadShikyuKubunL(radShikyuKubunL);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuAmountL() {
        return this.getHanteiKekkaDetailL().getTxtShikyuAmountL();
    }

    @JsonIgnore
    public void setTxtShikyuAmountL(TextBoxNum txtShikyuAmountL) {
        this.getHanteiKekkaDetailL().setTxtShikyuAmountL(txtShikyuAmountL);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushikyuRiyuL() {
        return this.getHanteiKekkaDetailL().getTxtFushikyuRiyuL();
    }

    @JsonIgnore
    public void setTxtFushikyuRiyuL(TextBoxMultiLine txtFushikyuRiyuL) {
        this.getHanteiKekkaDetailL().setTxtFushikyuRiyuL(txtFushikyuRiyuL);
    }

    @JsonIgnore
    public RadioButton getRadKogakuAutoShokanL() {
        return this.getHanteiKekkaDetailL().getRadKogakuAutoShokanL();
    }

    @JsonIgnore
    public void setRadKogakuAutoShokanL(RadioButton radKogakuAutoShokanL) {
        this.getHanteiKekkaDetailL().setRadKogakuAutoShokanL(radKogakuAutoShokanL);
    }

    @JsonIgnore
    public TextBox getTxtBikoL() {
        return this.getHanteiKekkaDetailL().getTxtBikoL();
    }

    @JsonIgnore
    public void setTxtBikoL(TextBox txtBikoL) {
        this.getHanteiKekkaDetailL().setTxtBikoL(txtBikoL);
    }

    // </editor-fold>
}
