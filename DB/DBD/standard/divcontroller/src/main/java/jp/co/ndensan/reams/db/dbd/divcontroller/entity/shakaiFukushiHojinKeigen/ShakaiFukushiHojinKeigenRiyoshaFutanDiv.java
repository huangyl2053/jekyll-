package jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen;
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
    private TextBoxCode txtKeigenJiyu;
    @JsonProperty("lblGengakuRitsuBunshi")
    private TextBoxNum lblGengakuRitsuBunshi;
    @JsonProperty("lblGengakuRitsuVinculum")
    private Label lblGengakuRitsuVinculum;
    @JsonProperty("txtGengakuRitsuBunbo")
    private TextBoxNum txtGengakuRitsuBunbo;
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
    public TextBoxCode getTxtKeigenJiyu() {
        return txtKeigenJiyu;
    }

    @JsonProperty("txtKeigenJiyu")
    public void setTxtKeigenJiyu(TextBoxCode txtKeigenJiyu) {
        this.txtKeigenJiyu=txtKeigenJiyu;
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
