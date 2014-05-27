package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * TokubetsuChiikiKasanGemmenRiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokubetsuChiikiKasanGemmenRiyoshaFutanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblKetteiDate")
    private Label lblKetteiDate;
    @JsonProperty("txtKetteiDate")
    private TextBoxDate txtKetteiDate;
    @JsonProperty("lblKetteiKubun")
    private Label lblKetteiKubun;
    @JsonProperty("txtKetteiKubun")
    private TextBox txtKetteiKubun;
    @JsonProperty("lblTekiyoDate")
    private Label lblTekiyoDate;
    @JsonProperty("txtTekiyoDate")
    private TextBoxDate txtTekiyoDate;
    @JsonProperty("lblYukokigenDate")
    private Label lblYukokigenDate;
    @JsonProperty("txtYukokigenDate")
    private TextBoxDate txtYukokigenDate;
    @JsonProperty("lblGengakuRitsu")
    private Label lblGengakuRitsu;
    @JsonProperty("txtKyufuRitsu")
    private TextBoxNum txtKyufuRitsu;
    @JsonProperty("lblKakuninNo")
    private Label lblKakuninNo;
    @JsonProperty("txtKakuninNo")
    private TextBoxCode txtKakuninNo;
    @JsonProperty("lblFushoninRiyu")
    private Label lblFushoninRiyu;
    @JsonProperty("txtFushoninRiyu")
    private TextBoxMultiLine txtFushoninRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblKetteiDate")
    public Label getLblKetteiDate() {
        return lblKetteiDate;
    }

    @JsonProperty("lblKetteiDate")
    public void setLblKetteiDate(Label lblKetteiDate) {
        this.lblKetteiDate=lblKetteiDate;
    }

    @JsonProperty("txtKetteiDate")
    public TextBoxDate getTxtKetteiDate() {
        return txtKetteiDate;
    }

    @JsonProperty("txtKetteiDate")
    public void setTxtKetteiDate(TextBoxDate txtKetteiDate) {
        this.txtKetteiDate=txtKetteiDate;
    }

    @JsonProperty("lblKetteiKubun")
    public Label getLblKetteiKubun() {
        return lblKetteiKubun;
    }

    @JsonProperty("lblKetteiKubun")
    public void setLblKetteiKubun(Label lblKetteiKubun) {
        this.lblKetteiKubun=lblKetteiKubun;
    }

    @JsonProperty("txtKetteiKubun")
    public TextBox getTxtKetteiKubun() {
        return txtKetteiKubun;
    }

    @JsonProperty("txtKetteiKubun")
    public void setTxtKetteiKubun(TextBox txtKetteiKubun) {
        this.txtKetteiKubun=txtKetteiKubun;
    }

    @JsonProperty("lblTekiyoDate")
    public Label getLblTekiyoDate() {
        return lblTekiyoDate;
    }

    @JsonProperty("lblTekiyoDate")
    public void setLblTekiyoDate(Label lblTekiyoDate) {
        this.lblTekiyoDate=lblTekiyoDate;
    }

    @JsonProperty("txtTekiyoDate")
    public TextBoxDate getTxtTekiyoDate() {
        return txtTekiyoDate;
    }

    @JsonProperty("txtTekiyoDate")
    public void setTxtTekiyoDate(TextBoxDate txtTekiyoDate) {
        this.txtTekiyoDate=txtTekiyoDate;
    }

    @JsonProperty("lblYukokigenDate")
    public Label getLblYukokigenDate() {
        return lblYukokigenDate;
    }

    @JsonProperty("lblYukokigenDate")
    public void setLblYukokigenDate(Label lblYukokigenDate) {
        this.lblYukokigenDate=lblYukokigenDate;
    }

    @JsonProperty("txtYukokigenDate")
    public TextBoxDate getTxtYukokigenDate() {
        return txtYukokigenDate;
    }

    @JsonProperty("txtYukokigenDate")
    public void setTxtYukokigenDate(TextBoxDate txtYukokigenDate) {
        this.txtYukokigenDate=txtYukokigenDate;
    }

    @JsonProperty("lblGengakuRitsu")
    public Label getLblGengakuRitsu() {
        return lblGengakuRitsu;
    }

    @JsonProperty("lblGengakuRitsu")
    public void setLblGengakuRitsu(Label lblGengakuRitsu) {
        this.lblGengakuRitsu=lblGengakuRitsu;
    }

    @JsonProperty("txtKyufuRitsu")
    public TextBoxNum getTxtKyufuRitsu() {
        return txtKyufuRitsu;
    }

    @JsonProperty("txtKyufuRitsu")
    public void setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.txtKyufuRitsu=txtKyufuRitsu;
    }

    @JsonProperty("lblKakuninNo")
    public Label getLblKakuninNo() {
        return lblKakuninNo;
    }

    @JsonProperty("lblKakuninNo")
    public void setLblKakuninNo(Label lblKakuninNo) {
        this.lblKakuninNo=lblKakuninNo;
    }

    @JsonProperty("txtKakuninNo")
    public TextBoxCode getTxtKakuninNo() {
        return txtKakuninNo;
    }

    @JsonProperty("txtKakuninNo")
    public void setTxtKakuninNo(TextBoxCode txtKakuninNo) {
        this.txtKakuninNo=txtKakuninNo;
    }

    @JsonProperty("lblFushoninRiyu")
    public Label getLblFushoninRiyu() {
        return lblFushoninRiyu;
    }

    @JsonProperty("lblFushoninRiyu")
    public void setLblFushoninRiyu(Label lblFushoninRiyu) {
        this.lblFushoninRiyu=lblFushoninRiyu;
    }

    @JsonProperty("txtFushoninRiyu")
    public TextBoxMultiLine getTxtFushoninRiyu() {
        return txtFushoninRiyu;
    }

    @JsonProperty("txtFushoninRiyu")
    public void setTxtFushoninRiyu(TextBoxMultiLine txtFushoninRiyu) {
        this.txtFushoninRiyu=txtFushoninRiyu;
    }

}
