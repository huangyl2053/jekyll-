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
 * ShakaiFukushiHojinKeigenRiyoshaFutan のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShakaiFukushiHojinKeigenRiyoshaFutanDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtKetteiDate")
    private TextBoxFlexibleDate txtKetteiDate;
    @JsonProperty("txtKetteiKubun")
    private TextBox txtKetteiKubun;
    @JsonProperty("txtTekiyoDate")
    private TextBoxFlexibleDate txtTekiyoDate;
    @JsonProperty("txtYukokigenDate")
    private TextBoxFlexibleDate txtYukokigenDate;
    @JsonProperty("txtKeigenJiyu")
    private TextBox txtKeigenJiyu;
    @JsonProperty("txtKeigenRitsuBunshi")
    private TextBoxNum txtKeigenRitsuBunshi;
    @JsonProperty("lblIKeigenRitsuVinculum")
    private Label lblIKeigenRitsuVinculum;
    @JsonProperty("txtKeigenRitsuBunbo")
    private TextBoxNum txtKeigenRitsuBunbo;
    @JsonProperty("txtFushoninRiyu")
    private TextBoxMultiLine txtFushoninRiyu;
    @JsonProperty("txtKakuninNo")
    private TextBoxCode txtKakuninNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtKetteiDate")
    public TextBoxFlexibleDate getTxtKetteiDate() {
        return txtKetteiDate;
    }

    @JsonProperty("txtKetteiDate")
    public void setTxtKetteiDate(TextBoxFlexibleDate txtKetteiDate) {
        this.txtKetteiDate=txtKetteiDate;
    }

    @JsonProperty("txtKetteiKubun")
    public TextBox getTxtKetteiKubun() {
        return txtKetteiKubun;
    }

    @JsonProperty("txtKetteiKubun")
    public void setTxtKetteiKubun(TextBox txtKetteiKubun) {
        this.txtKetteiKubun=txtKetteiKubun;
    }

    @JsonProperty("txtTekiyoDate")
    public TextBoxFlexibleDate getTxtTekiyoDate() {
        return txtTekiyoDate;
    }

    @JsonProperty("txtTekiyoDate")
    public void setTxtTekiyoDate(TextBoxFlexibleDate txtTekiyoDate) {
        this.txtTekiyoDate=txtTekiyoDate;
    }

    @JsonProperty("txtYukokigenDate")
    public TextBoxFlexibleDate getTxtYukokigenDate() {
        return txtYukokigenDate;
    }

    @JsonProperty("txtYukokigenDate")
    public void setTxtYukokigenDate(TextBoxFlexibleDate txtYukokigenDate) {
        this.txtYukokigenDate=txtYukokigenDate;
    }

    @JsonProperty("txtKeigenJiyu")
    public TextBox getTxtKeigenJiyu() {
        return txtKeigenJiyu;
    }

    @JsonProperty("txtKeigenJiyu")
    public void setTxtKeigenJiyu(TextBox txtKeigenJiyu) {
        this.txtKeigenJiyu=txtKeigenJiyu;
    }

    @JsonProperty("txtKeigenRitsuBunshi")
    public TextBoxNum getTxtKeigenRitsuBunshi() {
        return txtKeigenRitsuBunshi;
    }

    @JsonProperty("txtKeigenRitsuBunshi")
    public void setTxtKeigenRitsuBunshi(TextBoxNum txtKeigenRitsuBunshi) {
        this.txtKeigenRitsuBunshi=txtKeigenRitsuBunshi;
    }

    @JsonProperty("lblIKeigenRitsuVinculum")
    public Label getLblIKeigenRitsuVinculum() {
        return lblIKeigenRitsuVinculum;
    }

    @JsonProperty("lblIKeigenRitsuVinculum")
    public void setLblIKeigenRitsuVinculum(Label lblIKeigenRitsuVinculum) {
        this.lblIKeigenRitsuVinculum=lblIKeigenRitsuVinculum;
    }

    @JsonProperty("txtKeigenRitsuBunbo")
    public TextBoxNum getTxtKeigenRitsuBunbo() {
        return txtKeigenRitsuBunbo;
    }

    @JsonProperty("txtKeigenRitsuBunbo")
    public void setTxtKeigenRitsuBunbo(TextBoxNum txtKeigenRitsuBunbo) {
        this.txtKeigenRitsuBunbo=txtKeigenRitsuBunbo;
    }

    @JsonProperty("txtFushoninRiyu")
    public TextBoxMultiLine getTxtFushoninRiyu() {
        return txtFushoninRiyu;
    }

    @JsonProperty("txtFushoninRiyu")
    public void setTxtFushoninRiyu(TextBoxMultiLine txtFushoninRiyu) {
        this.txtFushoninRiyu=txtFushoninRiyu;
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
