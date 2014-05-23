package jp.co.ndensan.reams.db.dbd.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.ShakaiFukushiFojinKeigenRiyoshaFutanDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShakaiFukushiFojinKeigenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShakaiFukushiFojinKeigenDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lblShinseiDate")
    private Label lblShinseiDate;
    @JsonProperty("txtShinseiDate")
    private TextBoxDate txtShinseiDate;
    @JsonProperty("ShakaiFukushiFojinKeigenRiyoshaFutan")
    private ShakaiFukushiFojinKeigenRiyoshaFutanDiv ShakaiFukushiFojinKeigenRiyoshaFutan;
    @JsonProperty("lblKyotakuServiceGentei")
    private Label lblKyotakuServiceGentei;
    @JsonProperty("txtKyotakuServiceGentei")
    private TextBox txtKyotakuServiceGentei;
    @JsonProperty("lblKyojuhiShokujiOnly")
    private Label lblKyojuhiShokujiOnly;
    @JsonProperty("txtlblKyojuhiShokujiOnly")
    private TextBox txtlblKyojuhiShokujiOnly;
    @JsonProperty("lblUnitPrivateRoomOnly")
    private Label lblUnitPrivateRoomOnly;
    @JsonProperty("txtUnitPrivateRoomOnly")
    private TextBox txtUnitPrivateRoomOnly;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("lblShinseiDate")
    public Label getLblShinseiDate() {
        return lblShinseiDate;
    }

    @JsonProperty("lblShinseiDate")
    public void setLblShinseiDate(Label lblShinseiDate) {
        this.lblShinseiDate=lblShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public TextBoxDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("ShakaiFukushiFojinKeigenRiyoshaFutan")
    public ShakaiFukushiFojinKeigenRiyoshaFutanDiv getShakaiFukushiFojinKeigenRiyoshaFutan() {
        return ShakaiFukushiFojinKeigenRiyoshaFutan;
    }

    @JsonProperty("ShakaiFukushiFojinKeigenRiyoshaFutan")
    public void setShakaiFukushiFojinKeigenRiyoshaFutan(ShakaiFukushiFojinKeigenRiyoshaFutanDiv ShakaiFukushiFojinKeigenRiyoshaFutan) {
        this.ShakaiFukushiFojinKeigenRiyoshaFutan=ShakaiFukushiFojinKeigenRiyoshaFutan;
    }

    @JsonProperty("lblKyotakuServiceGentei")
    public Label getLblKyotakuServiceGentei() {
        return lblKyotakuServiceGentei;
    }

    @JsonProperty("lblKyotakuServiceGentei")
    public void setLblKyotakuServiceGentei(Label lblKyotakuServiceGentei) {
        this.lblKyotakuServiceGentei=lblKyotakuServiceGentei;
    }

    @JsonProperty("txtKyotakuServiceGentei")
    public TextBox getTxtKyotakuServiceGentei() {
        return txtKyotakuServiceGentei;
    }

    @JsonProperty("txtKyotakuServiceGentei")
    public void setTxtKyotakuServiceGentei(TextBox txtKyotakuServiceGentei) {
        this.txtKyotakuServiceGentei=txtKyotakuServiceGentei;
    }

    @JsonProperty("lblKyojuhiShokujiOnly")
    public Label getLblKyojuhiShokujiOnly() {
        return lblKyojuhiShokujiOnly;
    }

    @JsonProperty("lblKyojuhiShokujiOnly")
    public void setLblKyojuhiShokujiOnly(Label lblKyojuhiShokujiOnly) {
        this.lblKyojuhiShokujiOnly=lblKyojuhiShokujiOnly;
    }

    @JsonProperty("txtlblKyojuhiShokujiOnly")
    public TextBox getTxtlblKyojuhiShokujiOnly() {
        return txtlblKyojuhiShokujiOnly;
    }

    @JsonProperty("txtlblKyojuhiShokujiOnly")
    public void setTxtlblKyojuhiShokujiOnly(TextBox txtlblKyojuhiShokujiOnly) {
        this.txtlblKyojuhiShokujiOnly=txtlblKyojuhiShokujiOnly;
    }

    @JsonProperty("lblUnitPrivateRoomOnly")
    public Label getLblUnitPrivateRoomOnly() {
        return lblUnitPrivateRoomOnly;
    }

    @JsonProperty("lblUnitPrivateRoomOnly")
    public void setLblUnitPrivateRoomOnly(Label lblUnitPrivateRoomOnly) {
        this.lblUnitPrivateRoomOnly=lblUnitPrivateRoomOnly;
    }

    @JsonProperty("txtUnitPrivateRoomOnly")
    public TextBox getTxtUnitPrivateRoomOnly() {
        return txtUnitPrivateRoomOnly;
    }

    @JsonProperty("txtUnitPrivateRoomOnly")
    public void setTxtUnitPrivateRoomOnly(TextBox txtUnitPrivateRoomOnly) {
        this.txtUnitPrivateRoomOnly=txtUnitPrivateRoomOnly;
    }

}
