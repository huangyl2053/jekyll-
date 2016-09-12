package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 *
 * 画面設計_DBBGM84001_2_特徴制度間Ｉ／Ｆ（単一他社）
 *
 * @reamsid_L DBB-1830-010 yangchenbing
 */
public class TanitsuShoriInfoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblZenShoriYMD")
    private Label lblZenShoriYMD;
    @JsonProperty("lblZenShoriTime")
    private Label lblZenShoriTime;
    @JsonProperty("txtShoriJotai")
    private TextBox txtShoriJotai;
    @JsonProperty("txtZenKaiShoriYMD")
    private TextBoxDate txtZenKaiShoriYMD;
    @JsonProperty("txtZenKaiShoriTime")
    private TextBoxTime txtZenKaiShoriTime;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblZenShoriYMD
     * @return lblZenShoriYMD
     */
    @JsonProperty("lblZenShoriYMD")
    public Label getLblZenShoriYMD() {
        return lblZenShoriYMD;
    }

    /*
     * setlblZenShoriYMD
     * @param lblZenShoriYMD lblZenShoriYMD
     */
    @JsonProperty("lblZenShoriYMD")
    public void setLblZenShoriYMD(Label lblZenShoriYMD) {
        this.lblZenShoriYMD = lblZenShoriYMD;
    }

    /*
     * getlblZenShoriTime
     * @return lblZenShoriTime
     */
    @JsonProperty("lblZenShoriTime")
    public Label getLblZenShoriTime() {
        return lblZenShoriTime;
    }

    /*
     * setlblZenShoriTime
     * @param lblZenShoriTime lblZenShoriTime
     */
    @JsonProperty("lblZenShoriTime")
    public void setLblZenShoriTime(Label lblZenShoriTime) {
        this.lblZenShoriTime = lblZenShoriTime;
    }

    /*
     * gettxtShoriJotai
     * @return txtShoriJotai
     */
    @JsonProperty("txtShoriJotai")
    public TextBox getTxtShoriJotai() {
        return txtShoriJotai;
    }

    /*
     * settxtShoriJotai
     * @param txtShoriJotai txtShoriJotai
     */
    @JsonProperty("txtShoriJotai")
    public void setTxtShoriJotai(TextBox txtShoriJotai) {
        this.txtShoriJotai = txtShoriJotai;
    }

    /*
     * gettxtZenKaiShoriYMD
     * @return txtZenKaiShoriYMD
     */
    @JsonProperty("txtZenKaiShoriYMD")
    public TextBoxDate getTxtZenKaiShoriYMD() {
        return txtZenKaiShoriYMD;
    }

    /*
     * settxtZenKaiShoriYMD
     * @param txtZenKaiShoriYMD txtZenKaiShoriYMD
     */
    @JsonProperty("txtZenKaiShoriYMD")
    public void setTxtZenKaiShoriYMD(TextBoxDate txtZenKaiShoriYMD) {
        this.txtZenKaiShoriYMD = txtZenKaiShoriYMD;
    }

    /*
     * gettxtZenKaiShoriTime
     * @return txtZenKaiShoriTime
     */
    @JsonProperty("txtZenKaiShoriTime")
    public TextBoxTime getTxtZenKaiShoriTime() {
        return txtZenKaiShoriTime;
    }

    /*
     * settxtZenKaiShoriTime
     * @param txtZenKaiShoriTime txtZenKaiShoriTime
     */
    @JsonProperty("txtZenKaiShoriTime")
    public void setTxtZenKaiShoriTime(TextBoxTime txtZenKaiShoriTime) {
        this.txtZenKaiShoriTime = txtZenKaiShoriTime;
    }

    // </editor-fold>
}
