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
 * ShakaiFukushiFojinKeigenRiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShakaiFukushiFojinKeigenRiyoshaFutanDiv extends Panel {
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
    @JsonProperty("lblKeigenJiyu")
    private Label lblKeigenJiyu;
    @JsonProperty("txtKeigenJiyu")
    private TextBoxCode txtKeigenJiyu;
    @JsonProperty("lblGengakuRitsu")
    private Label lblGengakuRitsu;
    @JsonProperty("lblGengakuRitsuBunshi")
    private TextBoxNum lblGengakuRitsuBunshi;
    @JsonProperty("lblGengakuRitsuVinculum")
    private Label lblGengakuRitsuVinculum;
    @JsonProperty("txtGengakuRitsuBunbo")
    private TextBoxNum txtGengakuRitsuBunbo;
    @JsonProperty("lblHishoninRiyu")
    private Label lblHishoninRiyu;
    @JsonProperty("txtFushoninRiyu")
    private TextBoxMultiLine txtFushoninRiyu;
    @JsonProperty("lblKakuninNo")
    private Label lblKakuninNo;
    @JsonProperty("txtKakuninNo")
    private TextBoxCode txtKakuninNo;

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

    @JsonProperty("lblKeigenJiyu")
    public Label getLblKeigenJiyu() {
        return lblKeigenJiyu;
    }

    @JsonProperty("lblKeigenJiyu")
    public void setLblKeigenJiyu(Label lblKeigenJiyu) {
        this.lblKeigenJiyu=lblKeigenJiyu;
    }

    @JsonProperty("txtKeigenJiyu")
    public TextBoxCode getTxtKeigenJiyu() {
        return txtKeigenJiyu;
    }

    @JsonProperty("txtKeigenJiyu")
    public void setTxtKeigenJiyu(TextBoxCode txtKeigenJiyu) {
        this.txtKeigenJiyu=txtKeigenJiyu;
    }

    @JsonProperty("lblGengakuRitsu")
    public Label getLblGengakuRitsu() {
        return lblGengakuRitsu;
    }

    @JsonProperty("lblGengakuRitsu")
    public void setLblGengakuRitsu(Label lblGengakuRitsu) {
        this.lblGengakuRitsu=lblGengakuRitsu;
    }

    @JsonProperty("lblGengakuRitsuBunshi")
    public TextBoxNum getLblGengakuRitsuBunshi() {
        return lblGengakuRitsuBunshi;
    }

    @JsonProperty("lblGengakuRitsuBunshi")
    public void setLblGengakuRitsuBunshi(TextBoxNum lblGengakuRitsuBunshi) {
        this.lblGengakuRitsuBunshi=lblGengakuRitsuBunshi;
    }

    @JsonProperty("lblGengakuRitsuVinculum")
    public Label getLblGengakuRitsuVinculum() {
        return lblGengakuRitsuVinculum;
    }

    @JsonProperty("lblGengakuRitsuVinculum")
    public void setLblGengakuRitsuVinculum(Label lblGengakuRitsuVinculum) {
        this.lblGengakuRitsuVinculum=lblGengakuRitsuVinculum;
    }

    @JsonProperty("txtGengakuRitsuBunbo")
    public TextBoxNum getTxtGengakuRitsuBunbo() {
        return txtGengakuRitsuBunbo;
    }

    @JsonProperty("txtGengakuRitsuBunbo")
    public void setTxtGengakuRitsuBunbo(TextBoxNum txtGengakuRitsuBunbo) {
        this.txtGengakuRitsuBunbo=txtGengakuRitsuBunbo;
    }

    @JsonProperty("lblHishoninRiyu")
    public Label getLblHishoninRiyu() {
        return lblHishoninRiyu;
    }

    @JsonProperty("lblHishoninRiyu")
    public void setLblHishoninRiyu(Label lblHishoninRiyu) {
        this.lblHishoninRiyu=lblHishoninRiyu;
    }

    @JsonProperty("txtFushoninRiyu")
    public TextBoxMultiLine getTxtFushoninRiyu() {
        return txtFushoninRiyu;
    }

    @JsonProperty("txtFushoninRiyu")
    public void setTxtFushoninRiyu(TextBoxMultiLine txtFushoninRiyu) {
        this.txtFushoninRiyu=txtFushoninRiyu;
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

}
