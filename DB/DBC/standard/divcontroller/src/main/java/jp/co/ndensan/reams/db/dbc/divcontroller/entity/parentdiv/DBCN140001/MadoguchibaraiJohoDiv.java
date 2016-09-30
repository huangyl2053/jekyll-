package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * MadoguchibaraiJoho のクラスファイル
 *
 * @reamsid_L DBC-4830-010 quxiaodong
 */
public class MadoguchibaraiJohoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShiharaiBasho")
    private TextBoxMultiLine txtShiharaiBasho;
    @JsonProperty("txtKaishiDate")
    private TextBoxFlexibleDate txtKaishiDate;
    @JsonProperty("txtKaishiYobi")
    private TextBox txtKaishiYobi;
    @JsonProperty("txtKaishiTime")
    private TextBoxTime txtKaishiTime;
    @JsonProperty("txtShuryoDate")
    private TextBoxFlexibleDate txtShuryoDate;
    @JsonProperty("txtShuryoYobi")
    private TextBox txtShuryoYobi;
    @JsonProperty("txtShuryoTime")
    private TextBoxTime txtShuryoTime;
    @JsonProperty("lblChuiGaki1")
    private Label lblChuiGaki1;
    @JsonProperty("lblChuiGaki2")
    private Label lblChuiGaki2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShiharaiBasho
     * @return txtShiharaiBasho
     */
    @JsonProperty("txtShiharaiBasho")
    public TextBoxMultiLine getTxtShiharaiBasho() {
        return txtShiharaiBasho;
    }

    /*
     * settxtShiharaiBasho
     * @param txtShiharaiBasho txtShiharaiBasho
     */
    @JsonProperty("txtShiharaiBasho")
    public void setTxtShiharaiBasho(TextBoxMultiLine txtShiharaiBasho) {
        this.txtShiharaiBasho = txtShiharaiBasho;
    }

    /*
     * gettxtKaishiDate
     * @return txtKaishiDate
     */
    @JsonProperty("txtKaishiDate")
    public TextBoxFlexibleDate getTxtKaishiDate() {
        return txtKaishiDate;
    }

    /*
     * settxtKaishiDate
     * @param txtKaishiDate txtKaishiDate
     */
    @JsonProperty("txtKaishiDate")
    public void setTxtKaishiDate(TextBoxFlexibleDate txtKaishiDate) {
        this.txtKaishiDate = txtKaishiDate;
    }

    /*
     * gettxtKaishiYobi
     * @return txtKaishiYobi
     */
    @JsonProperty("txtKaishiYobi")
    public TextBox getTxtKaishiYobi() {
        return txtKaishiYobi;
    }

    /*
     * settxtKaishiYobi
     * @param txtKaishiYobi txtKaishiYobi
     */
    @JsonProperty("txtKaishiYobi")
    public void setTxtKaishiYobi(TextBox txtKaishiYobi) {
        this.txtKaishiYobi = txtKaishiYobi;
    }

    /*
     * gettxtKaishiTime
     * @return txtKaishiTime
     */
    @JsonProperty("txtKaishiTime")
    public TextBoxTime getTxtKaishiTime() {
        return txtKaishiTime;
    }

    /*
     * settxtKaishiTime
     * @param txtKaishiTime txtKaishiTime
     */
    @JsonProperty("txtKaishiTime")
    public void setTxtKaishiTime(TextBoxTime txtKaishiTime) {
        this.txtKaishiTime = txtKaishiTime;
    }

    /*
     * gettxtShuryoDate
     * @return txtShuryoDate
     */
    @JsonProperty("txtShuryoDate")
    public TextBoxFlexibleDate getTxtShuryoDate() {
        return txtShuryoDate;
    }

    /*
     * settxtShuryoDate
     * @param txtShuryoDate txtShuryoDate
     */
    @JsonProperty("txtShuryoDate")
    public void setTxtShuryoDate(TextBoxFlexibleDate txtShuryoDate) {
        this.txtShuryoDate = txtShuryoDate;
    }

    /*
     * gettxtShuryoYobi
     * @return txtShuryoYobi
     */
    @JsonProperty("txtShuryoYobi")
    public TextBox getTxtShuryoYobi() {
        return txtShuryoYobi;
    }

    /*
     * settxtShuryoYobi
     * @param txtShuryoYobi txtShuryoYobi
     */
    @JsonProperty("txtShuryoYobi")
    public void setTxtShuryoYobi(TextBox txtShuryoYobi) {
        this.txtShuryoYobi = txtShuryoYobi;
    }

    /*
     * gettxtShuryoTime
     * @return txtShuryoTime
     */
    @JsonProperty("txtShuryoTime")
    public TextBoxTime getTxtShuryoTime() {
        return txtShuryoTime;
    }

    /*
     * settxtShuryoTime
     * @param txtShuryoTime txtShuryoTime
     */
    @JsonProperty("txtShuryoTime")
    public void setTxtShuryoTime(TextBoxTime txtShuryoTime) {
        this.txtShuryoTime = txtShuryoTime;
    }

    /*
     * getlblChuiGaki1
     * @return lblChuiGaki1
     */
    @JsonProperty("lblChuiGaki1")
    public Label getLblChuiGaki1() {
        return lblChuiGaki1;
    }

    /*
     * setlblChuiGaki1
     * @param lblChuiGaki1 lblChuiGaki1
     */
    @JsonProperty("lblChuiGaki1")
    public void setLblChuiGaki1(Label lblChuiGaki1) {
        this.lblChuiGaki1 = lblChuiGaki1;
    }

    /*
     * getlblChuiGaki2
     * @return lblChuiGaki2
     */
    @JsonProperty("lblChuiGaki2")
    public Label getLblChuiGaki2() {
        return lblChuiGaki2;
    }

    /*
     * setlblChuiGaki2
     * @param lblChuiGaki2 lblChuiGaki2
     */
    @JsonProperty("lblChuiGaki2")
    public void setLblChuiGaki2(Label lblChuiGaki2) {
        this.lblChuiGaki2 = lblChuiGaki2;
    }

    // </editor-fold>
}
