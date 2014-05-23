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
 * HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonkaigoRiyoshaFutangakuGengakuRiyoshaFutanDiv extends Panel {
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
    @JsonProperty("lblKyufuRitsu")
    private Label lblKyufuRitsu;
    @JsonProperty("txtKyufuRitsu")
    private TextBoxNum txtKyufuRitsu;
    @JsonProperty("lblFushoninRiyu")
    private Label lblFushoninRiyu;
    @JsonProperty("txtHishoninRiyu")
    private TextBoxMultiLine txtHishoninRiyu;
    @JsonProperty("lblKohiFutanshaNo")
    private Label lblKohiFutanshaNo;
    @JsonProperty("txtKohiFutanshaNo")
    private TextBoxCode txtKohiFutanshaNo;
    @JsonProperty("lblKohiJukyushaNo")
    private Label lblKohiJukyushaNo;
    @JsonProperty("txtKohiJukyushaNo")
    private TextBoxCode txtKohiJukyushaNo;

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

    @JsonProperty("lblKyufuRitsu")
    public Label getLblKyufuRitsu() {
        return lblKyufuRitsu;
    }

    @JsonProperty("lblKyufuRitsu")
    public void setLblKyufuRitsu(Label lblKyufuRitsu) {
        this.lblKyufuRitsu=lblKyufuRitsu;
    }

    @JsonProperty("txtKyufuRitsu")
    public TextBoxNum getTxtKyufuRitsu() {
        return txtKyufuRitsu;
    }

    @JsonProperty("txtKyufuRitsu")
    public void setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.txtKyufuRitsu=txtKyufuRitsu;
    }

    @JsonProperty("lblFushoninRiyu")
    public Label getLblFushoninRiyu() {
        return lblFushoninRiyu;
    }

    @JsonProperty("lblFushoninRiyu")
    public void setLblFushoninRiyu(Label lblFushoninRiyu) {
        this.lblFushoninRiyu=lblFushoninRiyu;
    }

    @JsonProperty("txtHishoninRiyu")
    public TextBoxMultiLine getTxtHishoninRiyu() {
        return txtHishoninRiyu;
    }

    @JsonProperty("txtHishoninRiyu")
    public void setTxtHishoninRiyu(TextBoxMultiLine txtHishoninRiyu) {
        this.txtHishoninRiyu=txtHishoninRiyu;
    }

    @JsonProperty("lblKohiFutanshaNo")
    public Label getLblKohiFutanshaNo() {
        return lblKohiFutanshaNo;
    }

    @JsonProperty("lblKohiFutanshaNo")
    public void setLblKohiFutanshaNo(Label lblKohiFutanshaNo) {
        this.lblKohiFutanshaNo=lblKohiFutanshaNo;
    }

    @JsonProperty("txtKohiFutanshaNo")
    public TextBoxCode getTxtKohiFutanshaNo() {
        return txtKohiFutanshaNo;
    }

    @JsonProperty("txtKohiFutanshaNo")
    public void setTxtKohiFutanshaNo(TextBoxCode txtKohiFutanshaNo) {
        this.txtKohiFutanshaNo=txtKohiFutanshaNo;
    }

    @JsonProperty("lblKohiJukyushaNo")
    public Label getLblKohiJukyushaNo() {
        return lblKohiJukyushaNo;
    }

    @JsonProperty("lblKohiJukyushaNo")
    public void setLblKohiJukyushaNo(Label lblKohiJukyushaNo) {
        this.lblKohiJukyushaNo=lblKohiJukyushaNo;
    }

    @JsonProperty("txtKohiJukyushaNo")
    public TextBoxCode getTxtKohiJukyushaNo() {
        return txtKohiJukyushaNo;
    }

    @JsonProperty("txtKohiJukyushaNo")
    public void setTxtKohiJukyushaNo(TextBoxCode txtKohiJukyushaNo) {
        this.txtKohiJukyushaNo=txtKohiJukyushaNo;
    }

}
