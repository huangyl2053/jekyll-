package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1170001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYear;

/**
 * ChushutsuJoken のクラスファイル
 *
 * @reamsid_L DBB-1700-010 zhangrui
 */
public class ChushutsuJokenDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblChushutsuStYMD")
    private Label lblChushutsuStYMD;
    @JsonProperty("lblChushutsuStTime")
    private Label lblChushutsuStTime;
    @JsonProperty("lblChushutsuEdYMD")
    private Label lblChushutsuEdYMD;
    @JsonProperty("lblChushutsuEdTime")
    private Label lblChushutsuEdTime;
    @JsonProperty("txtChushutsuKijunNendo")
    private TextBoxYear txtChushutsuKijunNendo;
    @JsonProperty("txtChushutsuStYMD")
    private TextBoxDate txtChushutsuStYMD;
    @JsonProperty("txtChushutsuStTime")
    private TextBoxTime txtChushutsuStTime;
    @JsonProperty("lblKara")
    private Label lblKara;
    @JsonProperty("txtChushutsuEdYMD")
    private TextBoxDate txtChushutsuEdYMD;
    @JsonProperty("txtChushutsuEdTime")
    private TextBoxTime txtChushutsuEdTime;
    @JsonProperty("btnChushutsu")
    private Button btnChushutsu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlblChushutsuStYMD
     * @return lblChushutsuStYMD
     */
    @JsonProperty("lblChushutsuStYMD")
    public Label getLblChushutsuStYMD() {
        return lblChushutsuStYMD;
    }

    /*
     * setlblChushutsuStYMD
     * @param lblChushutsuStYMD lblChushutsuStYMD
     */
    @JsonProperty("lblChushutsuStYMD")
    public void setLblChushutsuStYMD(Label lblChushutsuStYMD) {
        this.lblChushutsuStYMD = lblChushutsuStYMD;
    }

    /*
     * getlblChushutsuStTime
     * @return lblChushutsuStTime
     */
    @JsonProperty("lblChushutsuStTime")
    public Label getLblChushutsuStTime() {
        return lblChushutsuStTime;
    }

    /*
     * setlblChushutsuStTime
     * @param lblChushutsuStTime lblChushutsuStTime
     */
    @JsonProperty("lblChushutsuStTime")
    public void setLblChushutsuStTime(Label lblChushutsuStTime) {
        this.lblChushutsuStTime = lblChushutsuStTime;
    }

    /*
     * getlblChushutsuEdYMD
     * @return lblChushutsuEdYMD
     */
    @JsonProperty("lblChushutsuEdYMD")
    public Label getLblChushutsuEdYMD() {
        return lblChushutsuEdYMD;
    }

    /*
     * setlblChushutsuEdYMD
     * @param lblChushutsuEdYMD lblChushutsuEdYMD
     */
    @JsonProperty("lblChushutsuEdYMD")
    public void setLblChushutsuEdYMD(Label lblChushutsuEdYMD) {
        this.lblChushutsuEdYMD = lblChushutsuEdYMD;
    }

    /*
     * getlblChushutsuEdTime
     * @return lblChushutsuEdTime
     */
    @JsonProperty("lblChushutsuEdTime")
    public Label getLblChushutsuEdTime() {
        return lblChushutsuEdTime;
    }

    /*
     * setlblChushutsuEdTime
     * @param lblChushutsuEdTime lblChushutsuEdTime
     */
    @JsonProperty("lblChushutsuEdTime")
    public void setLblChushutsuEdTime(Label lblChushutsuEdTime) {
        this.lblChushutsuEdTime = lblChushutsuEdTime;
    }

    /*
     * gettxtChushutsuKijunNendo
     * @return txtChushutsuKijunNendo
     */
    @JsonProperty("txtChushutsuKijunNendo")
    public TextBoxYear getTxtChushutsuKijunNendo() {
        return txtChushutsuKijunNendo;
    }

    /*
     * settxtChushutsuKijunNendo
     * @param txtChushutsuKijunNendo txtChushutsuKijunNendo
     */
    @JsonProperty("txtChushutsuKijunNendo")
    public void setTxtChushutsuKijunNendo(TextBoxYear txtChushutsuKijunNendo) {
        this.txtChushutsuKijunNendo = txtChushutsuKijunNendo;
    }

    /*
     * gettxtChushutsuStYMD
     * @return txtChushutsuStYMD
     */
    @JsonProperty("txtChushutsuStYMD")
    public TextBoxDate getTxtChushutsuStYMD() {
        return txtChushutsuStYMD;
    }

    /*
     * settxtChushutsuStYMD
     * @param txtChushutsuStYMD txtChushutsuStYMD
     */
    @JsonProperty("txtChushutsuStYMD")
    public void setTxtChushutsuStYMD(TextBoxDate txtChushutsuStYMD) {
        this.txtChushutsuStYMD = txtChushutsuStYMD;
    }

    /*
     * gettxtChushutsuStTime
     * @return txtChushutsuStTime
     */
    @JsonProperty("txtChushutsuStTime")
    public TextBoxTime getTxtChushutsuStTime() {
        return txtChushutsuStTime;
    }

    /*
     * settxtChushutsuStTime
     * @param txtChushutsuStTime txtChushutsuStTime
     */
    @JsonProperty("txtChushutsuStTime")
    public void setTxtChushutsuStTime(TextBoxTime txtChushutsuStTime) {
        this.txtChushutsuStTime = txtChushutsuStTime;
    }

    /*
     * getlblKara
     * @return lblKara
     */
    @JsonProperty("lblKara")
    public Label getLblKara() {
        return lblKara;
    }

    /*
     * setlblKara
     * @param lblKara lblKara
     */
    @JsonProperty("lblKara")
    public void setLblKara(Label lblKara) {
        this.lblKara = lblKara;
    }

    /*
     * gettxtChushutsuEdYMD
     * @return txtChushutsuEdYMD
     */
    @JsonProperty("txtChushutsuEdYMD")
    public TextBoxDate getTxtChushutsuEdYMD() {
        return txtChushutsuEdYMD;
    }

    /*
     * settxtChushutsuEdYMD
     * @param txtChushutsuEdYMD txtChushutsuEdYMD
     */
    @JsonProperty("txtChushutsuEdYMD")
    public void setTxtChushutsuEdYMD(TextBoxDate txtChushutsuEdYMD) {
        this.txtChushutsuEdYMD = txtChushutsuEdYMD;
    }

    /*
     * gettxtChushutsuEdTime
     * @return txtChushutsuEdTime
     */
    @JsonProperty("txtChushutsuEdTime")
    public TextBoxTime getTxtChushutsuEdTime() {
        return txtChushutsuEdTime;
    }

    /*
     * settxtChushutsuEdTime
     * @param txtChushutsuEdTime txtChushutsuEdTime
     */
    @JsonProperty("txtChushutsuEdTime")
    public void setTxtChushutsuEdTime(TextBoxTime txtChushutsuEdTime) {
        this.txtChushutsuEdTime = txtChushutsuEdTime;
    }

    /*
     * getbtnChushutsu
     * @return btnChushutsu
     */
    @JsonProperty("btnChushutsu")
    public Button getBtnChushutsu() {
        return btnChushutsu;
    }

    /*
     * setbtnChushutsu
     * @param btnChushutsu btnChushutsu
     */
    @JsonProperty("btnChushutsu")
    public void setBtnChushutsu(Button btnChushutsu) {
        this.btnChushutsu = btnChushutsu;
    }

    // </editor-fold>
}
