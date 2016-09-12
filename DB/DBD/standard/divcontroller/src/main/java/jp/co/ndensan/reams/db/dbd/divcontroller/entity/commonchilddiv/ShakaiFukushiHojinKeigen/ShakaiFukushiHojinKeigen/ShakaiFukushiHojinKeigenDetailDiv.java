package jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.ShakaiFukushiHojinKeigen.ShakaiFukushiHojinKeigen;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShakaiFukushiHojinKeigenDetail のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShakaiFukushiHojinKeigenDetailDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("txtKyotakuServiceOnly")
    private TextBox txtKyotakuServiceOnly;
    @JsonProperty("txtKyojuhiShokujiOnly")
    private TextBox txtKyojuhiShokujiOnly;
    @JsonProperty("txtUnitPrivateRoomOnly")
    private TextBox txtUnitPrivateRoomOnly;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShinseiDate
     * @return txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return txtShinseiDate;
    }

    /*
     * settxtShinseiDate
     * @param txtShinseiDate txtShinseiDate
     */
    @JsonProperty("txtShinseiDate")
    public void setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.txtShinseiDate = txtShinseiDate;
    }

    /*
     * getShakaiFukushiHojinKeigenRiyoshaFutan
     * @return ShakaiFukushiHojinKeigenRiyoshaFutan
     */
    @JsonProperty("ShakaiFukushiHojinKeigenRiyoshaFutan")
    public ShakaiFukushiHojinKeigenRiyoshaFutanDiv getShakaiFukushiHojinKeigenRiyoshaFutan() {
        return ShakaiFukushiHojinKeigenRiyoshaFutan;
    }

    /*
     * setShakaiFukushiHojinKeigenRiyoshaFutan
     * @param ShakaiFukushiHojinKeigenRiyoshaFutan ShakaiFukushiHojinKeigenRiyoshaFutan
     */
    @JsonProperty("ShakaiFukushiHojinKeigenRiyoshaFutan")
    public void setShakaiFukushiHojinKeigenRiyoshaFutan(ShakaiFukushiHojinKeigenRiyoshaFutanDiv ShakaiFukushiHojinKeigenRiyoshaFutan) {
        this.ShakaiFukushiHojinKeigenRiyoshaFutan = ShakaiFukushiHojinKeigenRiyoshaFutan;
    }

    /*
     * gettxtKyotakuServiceOnly
     * @return txtKyotakuServiceOnly
     */
    @JsonProperty("txtKyotakuServiceOnly")
    public TextBox getTxtKyotakuServiceOnly() {
        return txtKyotakuServiceOnly;
    }

    /*
     * settxtKyotakuServiceOnly
     * @param txtKyotakuServiceOnly txtKyotakuServiceOnly
     */
    @JsonProperty("txtKyotakuServiceOnly")
    public void setTxtKyotakuServiceOnly(TextBox txtKyotakuServiceOnly) {
        this.txtKyotakuServiceOnly = txtKyotakuServiceOnly;
    }

    /*
     * gettxtKyojuhiShokujiOnly
     * @return txtKyojuhiShokujiOnly
     */
    @JsonProperty("txtKyojuhiShokujiOnly")
    public TextBox getTxtKyojuhiShokujiOnly() {
        return txtKyojuhiShokujiOnly;
    }

    /*
     * settxtKyojuhiShokujiOnly
     * @param txtKyojuhiShokujiOnly txtKyojuhiShokujiOnly
     */
    @JsonProperty("txtKyojuhiShokujiOnly")
    public void setTxtKyojuhiShokujiOnly(TextBox txtKyojuhiShokujiOnly) {
        this.txtKyojuhiShokujiOnly = txtKyojuhiShokujiOnly;
    }

    /*
     * gettxtUnitPrivateRoomOnly
     * @return txtUnitPrivateRoomOnly
     */
    @JsonProperty("txtUnitPrivateRoomOnly")
    public TextBox getTxtUnitPrivateRoomOnly() {
        return txtUnitPrivateRoomOnly;
    }

    /*
     * settxtUnitPrivateRoomOnly
     * @param txtUnitPrivateRoomOnly txtUnitPrivateRoomOnly
     */
    @JsonProperty("txtUnitPrivateRoomOnly")
    public void setTxtUnitPrivateRoomOnly(TextBox txtUnitPrivateRoomOnly) {
        this.txtUnitPrivateRoomOnly = txtUnitPrivateRoomOnly;
    }

    // </editor-fold>
}
