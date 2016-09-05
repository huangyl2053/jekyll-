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
 * HanteiKekkaR のクラスファイル
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class HanteiKekkaRDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgJudgementResultR")
    private DataGrid<dgJudgementResultR_Row> dgJudgementResultR;
    @JsonProperty("HanteiKekkaDetailR")
    private HanteiKekkaDetailRDiv HanteiKekkaDetailR;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getdgJudgementResultR
     * @return dgJudgementResultR
     */
    @JsonProperty("dgJudgementResultR")
    public DataGrid<dgJudgementResultR_Row> getDgJudgementResultR() {
        return dgJudgementResultR;
    }

    /*
     * setdgJudgementResultR
     * @param dgJudgementResultR dgJudgementResultR
     */
    @JsonProperty("dgJudgementResultR")
    public void setDgJudgementResultR(DataGrid<dgJudgementResultR_Row> dgJudgementResultR) {
        this.dgJudgementResultR = dgJudgementResultR;
    }

    /*
     * getHanteiKekkaDetailR
     * @return HanteiKekkaDetailR
     */
    @JsonProperty("HanteiKekkaDetailR")
    public HanteiKekkaDetailRDiv getHanteiKekkaDetailR() {
        return HanteiKekkaDetailR;
    }

    /*
     * setHanteiKekkaDetailR
     * @param HanteiKekkaDetailR HanteiKekkaDetailR
     */
    @JsonProperty("HanteiKekkaDetailR")
    public void setHanteiKekkaDetailR(HanteiKekkaDetailRDiv HanteiKekkaDetailR) {
        this.HanteiKekkaDetailR = HanteiKekkaDetailR;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtHihoNoR() {
        return this.getHanteiKekkaDetailR().getTxtHihoNoR();
    }

    @JsonIgnore
    public void setTxtHihoNoR(TextBoxCode txtHihoNoR) {
        this.getHanteiKekkaDetailR().setTxtHihoNoR(txtHihoNoR);
    }

    @JsonIgnore
    public TextBox getTxtHihoNameL() {
        return this.getHanteiKekkaDetailR().getTxtHihoNameL();
    }

    @JsonIgnore
    public void setTxtHihoNameL(TextBox txtHihoNameL) {
        this.getHanteiKekkaDetailR().setTxtHihoNameL(txtHihoNameL);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketsukeDateR() {
        return this.getHanteiKekkaDetailR().getTxtUketsukeDateR();
    }

    @JsonIgnore
    public void setTxtUketsukeDateR(TextBoxDate txtUketsukeDateR) {
        this.getHanteiKekkaDetailR().setTxtUketsukeDateR(txtUketsukeDateR);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiDateR() {
        return this.getHanteiKekkaDetailR().getTxtKetteiDateR();
    }

    @JsonIgnore
    public void setTxtKetteiDateR(TextBoxDate txtKetteiDateR) {
        this.getHanteiKekkaDetailR().setTxtKetteiDateR(txtKetteiDateR);
    }

    @JsonIgnore
    public RadioButton getRadShinsaMethodR() {
        return this.getHanteiKekkaDetailR().getRadShinsaMethodR();
    }

    @JsonIgnore
    public void setRadShinsaMethodR(RadioButton radShinsaMethodR) {
        this.getHanteiKekkaDetailR().setRadShinsaMethodR(radShinsaMethodR);
    }

    @JsonIgnore
    public TextBoxNum getTxtShiharaiAmountR() {
        return this.getHanteiKekkaDetailR().getTxtShiharaiAmountR();
    }

    @JsonIgnore
    public void setTxtShiharaiAmountR(TextBoxNum txtShiharaiAmountR) {
        this.getHanteiKekkaDetailR().setTxtShiharaiAmountR(txtShiharaiAmountR);
    }

    @JsonIgnore
    public RadioButton getRadShikyuKubunR() {
        return this.getHanteiKekkaDetailR().getRadShikyuKubunR();
    }

    @JsonIgnore
    public void setRadShikyuKubunR(RadioButton radShikyuKubunR) {
        this.getHanteiKekkaDetailR().setRadShikyuKubunR(radShikyuKubunR);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuAmountR() {
        return this.getHanteiKekkaDetailR().getTxtShikyuAmountR();
    }

    @JsonIgnore
    public void setTxtShikyuAmountR(TextBoxNum txtShikyuAmountR) {
        this.getHanteiKekkaDetailR().setTxtShikyuAmountR(txtShikyuAmountR);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtFushikyuRiyuR() {
        return this.getHanteiKekkaDetailR().getTxtFushikyuRiyuR();
    }

    @JsonIgnore
    public void setTxtFushikyuRiyuR(TextBoxMultiLine txtFushikyuRiyuR) {
        this.getHanteiKekkaDetailR().setTxtFushikyuRiyuR(txtFushikyuRiyuR);
    }

    @JsonIgnore
    public RadioButton getRadKogakuAutoShokanR() {
        return this.getHanteiKekkaDetailR().getRadKogakuAutoShokanR();
    }

    @JsonIgnore
    public void setRadKogakuAutoShokanR(RadioButton radKogakuAutoShokanR) {
        this.getHanteiKekkaDetailR().setRadKogakuAutoShokanR(radKogakuAutoShokanR);
    }

    @JsonIgnore
    public TextBox getTxtBikoR() {
        return this.getHanteiKekkaDetailR().getTxtBikoR();
    }

    @JsonIgnore
    public void setTxtBikoR(TextBox txtBikoR) {
        this.getHanteiKekkaDetailR().setTxtBikoR(txtBikoR);
    }

    // </editor-fold>
}
