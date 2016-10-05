package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShowResultTwo のクラスファイル
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class ShowResultTwoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeikyoYMShowTwo")
    private TextBoxDate txtTeikyoYMShowTwo;
    @JsonProperty("txtSetaiShuyakuNo")
    private TextBoxCode txtSetaiShuyakuNo;
    @JsonProperty("SetaiinL")
    private SetaiinLDiv SetaiinL;
    @JsonProperty("SetaiinR")
    private SetaiinRDiv SetaiinR;
    @JsonProperty("btnBackIchiran")
    private Button btnBackIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTeikyoYMShowTwo
     * @return txtTeikyoYMShowTwo
     */
    @JsonProperty("txtTeikyoYMShowTwo")
    public TextBoxDate getTxtTeikyoYMShowTwo() {
        return txtTeikyoYMShowTwo;
    }

    /*
     * settxtTeikyoYMShowTwo
     * @param txtTeikyoYMShowTwo txtTeikyoYMShowTwo
     */
    @JsonProperty("txtTeikyoYMShowTwo")
    public void setTxtTeikyoYMShowTwo(TextBoxDate txtTeikyoYMShowTwo) {
        this.txtTeikyoYMShowTwo = txtTeikyoYMShowTwo;
    }

    /*
     * gettxtSetaiShuyakuNo
     * @return txtSetaiShuyakuNo
     */
    @JsonProperty("txtSetaiShuyakuNo")
    public TextBoxCode getTxtSetaiShuyakuNo() {
        return txtSetaiShuyakuNo;
    }

    /*
     * settxtSetaiShuyakuNo
     * @param txtSetaiShuyakuNo txtSetaiShuyakuNo
     */
    @JsonProperty("txtSetaiShuyakuNo")
    public void setTxtSetaiShuyakuNo(TextBoxCode txtSetaiShuyakuNo) {
        this.txtSetaiShuyakuNo = txtSetaiShuyakuNo;
    }

    /*
     * getSetaiinL
     * @return SetaiinL
     */
    @JsonProperty("SetaiinL")
    public SetaiinLDiv getSetaiinL() {
        return SetaiinL;
    }

    /*
     * setSetaiinL
     * @param SetaiinL SetaiinL
     */
    @JsonProperty("SetaiinL")
    public void setSetaiinL(SetaiinLDiv SetaiinL) {
        this.SetaiinL = SetaiinL;
    }

    /*
     * getSetaiinR
     * @return SetaiinR
     */
    @JsonProperty("SetaiinR")
    public SetaiinRDiv getSetaiinR() {
        return SetaiinR;
    }

    /*
     * setSetaiinR
     * @param SetaiinR SetaiinR
     */
    @JsonProperty("SetaiinR")
    public void setSetaiinR(SetaiinRDiv SetaiinR) {
        this.SetaiinR = SetaiinR;
    }

    /*
     * getbtnBackIchiran
     * @return btnBackIchiran
     */
    @JsonProperty("btnBackIchiran")
    public Button getBtnBackIchiran() {
        return btnBackIchiran;
    }

    /*
     * setbtnBackIchiran
     * @param btnBackIchiran btnBackIchiran
     */
    @JsonProperty("btnBackIchiran")
    public void setBtnBackIchiran(Button btnBackIchiran) {
        this.btnBackIchiran = btnBackIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HanteiKekkaLDiv getHanteiKekkaL() {
        return this.getSetaiinL().getHanteiKekkaL();
    }

    @JsonIgnore
    public void setHanteiKekkaL(HanteiKekkaLDiv HanteiKekkaL) {
        this.getSetaiinL().setHanteiKekkaL(HanteiKekkaL);
    }

    @JsonIgnore
    public HanteiKekkaRDiv getHanteiKekkaR() {
        return this.getSetaiinR().getHanteiKekkaR();
    }

    @JsonIgnore
    public void setHanteiKekkaR(HanteiKekkaRDiv HanteiKekkaR) {
        this.getSetaiinR().setHanteiKekkaR(HanteiKekkaR);
    }

    // </editor-fold>
}
