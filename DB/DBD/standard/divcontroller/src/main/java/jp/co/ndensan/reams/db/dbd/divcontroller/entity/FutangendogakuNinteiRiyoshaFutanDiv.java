package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.FutangendogakuNinteiGendogakuDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.FutangendogakuNinteiKyusochishaKubunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * FutangendogakuNinteiRiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class FutangendogakuNinteiRiyoshaFutanDiv extends Panel {
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
    @JsonProperty("FutangendogakuNinteiKyusochishaKubun")
    private FutangendogakuNinteiKyusochishaKubunDiv FutangendogakuNinteiKyusochishaKubun;
    @JsonProperty("lblFutanDankai")
    private Label lblFutanDankai;
    @JsonProperty("txtFutanDankai")
    private TextBox txtFutanDankai;
    @JsonProperty("lblKyoshitsuType")
    private Label lblKyoshitsuType;
    @JsonProperty("txtKyoshitsuType")
    private TextBox txtKyoshitsuType;
    @JsonProperty("lblKyokaiso")
    private Label lblKyokaiso;
    @JsonProperty("txtKyokaiso")
    private TextBox txtKyokaiso;
    @JsonProperty("lblGekihenKanwa")
    private Label lblGekihenKanwa;
    @JsonProperty("txtGekihenKanwa")
    private TextBox txtGekihenKanwa;
    @JsonProperty("FutangendogakuNinteiGendogaku")
    private FutangendogakuNinteiGendogakuDiv FutangendogakuNinteiGendogaku;
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

    @JsonProperty("FutangendogakuNinteiKyusochishaKubun")
    public FutangendogakuNinteiKyusochishaKubunDiv getFutangendogakuNinteiKyusochishaKubun() {
        return FutangendogakuNinteiKyusochishaKubun;
    }

    @JsonProperty("FutangendogakuNinteiKyusochishaKubun")
    public void setFutangendogakuNinteiKyusochishaKubun(FutangendogakuNinteiKyusochishaKubunDiv FutangendogakuNinteiKyusochishaKubun) {
        this.FutangendogakuNinteiKyusochishaKubun=FutangendogakuNinteiKyusochishaKubun;
    }

    @JsonProperty("lblFutanDankai")
    public Label getLblFutanDankai() {
        return lblFutanDankai;
    }

    @JsonProperty("lblFutanDankai")
    public void setLblFutanDankai(Label lblFutanDankai) {
        this.lblFutanDankai=lblFutanDankai;
    }

    @JsonProperty("txtFutanDankai")
    public TextBox getTxtFutanDankai() {
        return txtFutanDankai;
    }

    @JsonProperty("txtFutanDankai")
    public void setTxtFutanDankai(TextBox txtFutanDankai) {
        this.txtFutanDankai=txtFutanDankai;
    }

    @JsonProperty("lblKyoshitsuType")
    public Label getLblKyoshitsuType() {
        return lblKyoshitsuType;
    }

    @JsonProperty("lblKyoshitsuType")
    public void setLblKyoshitsuType(Label lblKyoshitsuType) {
        this.lblKyoshitsuType=lblKyoshitsuType;
    }

    @JsonProperty("txtKyoshitsuType")
    public TextBox getTxtKyoshitsuType() {
        return txtKyoshitsuType;
    }

    @JsonProperty("txtKyoshitsuType")
    public void setTxtKyoshitsuType(TextBox txtKyoshitsuType) {
        this.txtKyoshitsuType=txtKyoshitsuType;
    }

    @JsonProperty("lblKyokaiso")
    public Label getLblKyokaiso() {
        return lblKyokaiso;
    }

    @JsonProperty("lblKyokaiso")
    public void setLblKyokaiso(Label lblKyokaiso) {
        this.lblKyokaiso=lblKyokaiso;
    }

    @JsonProperty("txtKyokaiso")
    public TextBox getTxtKyokaiso() {
        return txtKyokaiso;
    }

    @JsonProperty("txtKyokaiso")
    public void setTxtKyokaiso(TextBox txtKyokaiso) {
        this.txtKyokaiso=txtKyokaiso;
    }

    @JsonProperty("lblGekihenKanwa")
    public Label getLblGekihenKanwa() {
        return lblGekihenKanwa;
    }

    @JsonProperty("lblGekihenKanwa")
    public void setLblGekihenKanwa(Label lblGekihenKanwa) {
        this.lblGekihenKanwa=lblGekihenKanwa;
    }

    @JsonProperty("txtGekihenKanwa")
    public TextBox getTxtGekihenKanwa() {
        return txtGekihenKanwa;
    }

    @JsonProperty("txtGekihenKanwa")
    public void setTxtGekihenKanwa(TextBox txtGekihenKanwa) {
        this.txtGekihenKanwa=txtGekihenKanwa;
    }

    @JsonProperty("FutangendogakuNinteiGendogaku")
    public FutangendogakuNinteiGendogakuDiv getFutangendogakuNinteiGendogaku() {
        return FutangendogakuNinteiGendogaku;
    }

    @JsonProperty("FutangendogakuNinteiGendogaku")
    public void setFutangendogakuNinteiGendogaku(FutangendogakuNinteiGendogakuDiv FutangendogakuNinteiGendogaku) {
        this.FutangendogakuNinteiGendogaku=FutangendogakuNinteiGendogaku;
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
