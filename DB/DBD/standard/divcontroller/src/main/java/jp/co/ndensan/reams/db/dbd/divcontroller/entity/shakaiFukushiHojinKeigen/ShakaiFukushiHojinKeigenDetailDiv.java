package jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.shakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigenRiyoshaFutanDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShakaiFukushiHojinKeigenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShakaiFukushiHojinKeigenDetailDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShinseiDate")
    private TextBoxFlexibleDate txtShinseiDate;
    @JsonProperty("ShakaiFukushiHojinKeigenRiyoshaFutan")
    private ShakaiFukushiHojinKeigenRiyoshaFutanDiv ShakaiFukushiHojinKeigenRiyoshaFutan;
    @JsonProperty("txtKyotakuServiceGentei")
    private TextBox txtKyotakuServiceGentei;
    @JsonProperty("txtlblKyojuhiShokujiOnly")
    private TextBox txtlblKyojuhiShokujiOnly;
    @JsonProperty("txtUnitPrivateRoomOnly")
    private TextBox txtUnitPrivateRoomOnly;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate=txtShinseiDate;
    }

    @JsonProperty("ShakaiFukushiHojinKeigenRiyoshaFutan")
    public ShakaiFukushiHojinKeigenRiyoshaFutanDiv getShakaiFukushiHojinKeigenRiyoshaFutan() {
        return ShakaiFukushiHojinKeigenRiyoshaFutan;
    }

    @JsonProperty("ShakaiFukushiHojinKeigenRiyoshaFutan")
    public void setShakaiFukushiHojinKeigenRiyoshaFutan(ShakaiFukushiHojinKeigenRiyoshaFutanDiv ShakaiFukushiHojinKeigenRiyoshaFutan) {
        this.ShakaiFukushiHojinKeigenRiyoshaFutan=ShakaiFukushiHojinKeigenRiyoshaFutan;
    }

    @JsonProperty("txtKyotakuServiceGentei")
    public TextBox getTxtKyotakuServiceGentei() {
        return txtKyotakuServiceGentei;
    }

    @JsonProperty("txtKyotakuServiceGentei")
    public void setTxtKyotakuServiceGentei(TextBox txtKyotakuServiceGentei) {
        this.txtKyotakuServiceGentei=txtKyotakuServiceGentei;
    }

    @JsonProperty("txtlblKyojuhiShokujiOnly")
    public TextBox getTxtlblKyojuhiShokujiOnly() {
        return txtlblKyojuhiShokujiOnly;
    }

    @JsonProperty("txtlblKyojuhiShokujiOnly")
    public void setTxtlblKyojuhiShokujiOnly(TextBox txtlblKyojuhiShokujiOnly) {
        this.txtlblKyojuhiShokujiOnly=txtlblKyojuhiShokujiOnly;
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
