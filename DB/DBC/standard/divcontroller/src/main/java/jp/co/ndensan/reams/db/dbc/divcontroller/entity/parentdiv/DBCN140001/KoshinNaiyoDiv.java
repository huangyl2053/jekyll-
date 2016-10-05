package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBCN140001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;

/**
 * KoshinNaiyo のクラスファイル
 *
 * @reamsid_L DBC-4830-010 quxiaodong
 */
public class KoshinNaiyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiDate")
    private TextBoxFlexibleDate txtKetteiDate;
    @JsonProperty("txtKyufunoShurui")
    private TextBoxMultiLine txtKyufunoShurui;
    @JsonProperty("txtFushikyuRiyu")
    private TextBoxMultiLine txtFushikyuRiyu;
    @JsonProperty("MadoguchibaraiJoho")
    private MadoguchibaraiJohoDiv MadoguchibaraiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtKetteiDate
     * @return txtKetteiDate
     */
    @JsonProperty("txtKetteiDate")
    public TextBoxFlexibleDate getTxtKetteiDate() {
        return txtKetteiDate;
    }

    /*
     * settxtKetteiDate
     * @param txtKetteiDate txtKetteiDate
     */
    @JsonProperty("txtKetteiDate")
    public void setTxtKetteiDate(TextBoxFlexibleDate txtKetteiDate) {
        this.txtKetteiDate = txtKetteiDate;
    }

    /*
     * gettxtKyufunoShurui
     * @return txtKyufunoShurui
     */
    @JsonProperty("txtKyufunoShurui")
    public TextBoxMultiLine getTxtKyufunoShurui() {
        return txtKyufunoShurui;
    }

    /*
     * settxtKyufunoShurui
     * @param txtKyufunoShurui txtKyufunoShurui
     */
    @JsonProperty("txtKyufunoShurui")
    public void setTxtKyufunoShurui(TextBoxMultiLine txtKyufunoShurui) {
        this.txtKyufunoShurui = txtKyufunoShurui;
    }

    /*
     * gettxtFushikyuRiyu
     * @return txtFushikyuRiyu
     */
    @JsonProperty("txtFushikyuRiyu")
    public TextBoxMultiLine getTxtFushikyuRiyu() {
        return txtFushikyuRiyu;
    }

    /*
     * settxtFushikyuRiyu
     * @param txtFushikyuRiyu txtFushikyuRiyu
     */
    @JsonProperty("txtFushikyuRiyu")
    public void setTxtFushikyuRiyu(TextBoxMultiLine txtFushikyuRiyu) {
        this.txtFushikyuRiyu = txtFushikyuRiyu;
    }

    /*
     * getMadoguchibaraiJoho
     * @return MadoguchibaraiJoho
     */
    @JsonProperty("MadoguchibaraiJoho")
    public MadoguchibaraiJohoDiv getMadoguchibaraiJoho() {
        return MadoguchibaraiJoho;
    }

    /*
     * setMadoguchibaraiJoho
     * @param MadoguchibaraiJoho MadoguchibaraiJoho
     */
    @JsonProperty("MadoguchibaraiJoho")
    public void setMadoguchibaraiJoho(MadoguchibaraiJohoDiv MadoguchibaraiJoho) {
        this.MadoguchibaraiJoho = MadoguchibaraiJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxMultiLine getTxtShiharaiBasho() {
        return this.getMadoguchibaraiJoho().getTxtShiharaiBasho();
    }

    @JsonIgnore
    public void setTxtShiharaiBasho(TextBoxMultiLine txtShiharaiBasho) {
        this.getMadoguchibaraiJoho().setTxtShiharaiBasho(txtShiharaiBasho);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKaishiDate() {
        return this.getMadoguchibaraiJoho().getTxtKaishiDate();
    }

    @JsonIgnore
    public void setTxtKaishiDate(TextBoxFlexibleDate txtKaishiDate) {
        this.getMadoguchibaraiJoho().setTxtKaishiDate(txtKaishiDate);
    }

    @JsonIgnore
    public TextBox getTxtKaishiYobi() {
        return this.getMadoguchibaraiJoho().getTxtKaishiYobi();
    }

    @JsonIgnore
    public void setTxtKaishiYobi(TextBox txtKaishiYobi) {
        this.getMadoguchibaraiJoho().setTxtKaishiYobi(txtKaishiYobi);
    }

    @JsonIgnore
    public TextBoxTime getTxtKaishiTime() {
        return this.getMadoguchibaraiJoho().getTxtKaishiTime();
    }

    @JsonIgnore
    public void setTxtKaishiTime(TextBoxTime txtKaishiTime) {
        this.getMadoguchibaraiJoho().setTxtKaishiTime(txtKaishiTime);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShuryoDate() {
        return this.getMadoguchibaraiJoho().getTxtShuryoDate();
    }

    @JsonIgnore
    public void setTxtShuryoDate(TextBoxFlexibleDate txtShuryoDate) {
        this.getMadoguchibaraiJoho().setTxtShuryoDate(txtShuryoDate);
    }

    @JsonIgnore
    public TextBox getTxtShuryoYobi() {
        return this.getMadoguchibaraiJoho().getTxtShuryoYobi();
    }

    @JsonIgnore
    public void setTxtShuryoYobi(TextBox txtShuryoYobi) {
        this.getMadoguchibaraiJoho().setTxtShuryoYobi(txtShuryoYobi);
    }

    @JsonIgnore
    public TextBoxTime getTxtShuryoTime() {
        return this.getMadoguchibaraiJoho().getTxtShuryoTime();
    }

    @JsonIgnore
    public void setTxtShuryoTime(TextBoxTime txtShuryoTime) {
        this.getMadoguchibaraiJoho().setTxtShuryoTime(txtShuryoTime);
    }

    @JsonIgnore
    public Label getLblChuiGaki1() {
        return this.getMadoguchibaraiJoho().getLblChuiGaki1();
    }

    @JsonIgnore
    public void setLblChuiGaki1(Label lblChuiGaki1) {
        this.getMadoguchibaraiJoho().setLblChuiGaki1(lblChuiGaki1);
    }

    @JsonIgnore
    public Label getLblChuiGaki2() {
        return this.getMadoguchibaraiJoho().getLblChuiGaki2();
    }

    @JsonIgnore
    public void setLblChuiGaki2(Label lblChuiGaki2) {
        this.getMadoguchibaraiJoho().setLblChuiGaki2(lblChuiGaki2);
    }

    // </editor-fold>
}
