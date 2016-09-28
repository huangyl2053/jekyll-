package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC4200011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikyuGendogakuKyotakuServiceDetailPanel のクラスファイル
 *
 * @reamsid_L DBC-3410-010 jianglaisheng
 */
public class ShikyuGendogakuKyotakuServiceDetailPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShikyuGendogakuKyotakuServiceTop")
    private ShikyuGendogakuKyotakuServiceTopDiv ShikyuGendogakuKyotakuServiceTop;
    @JsonProperty("KubunShikyuGendogaku")
    private KubunShikyuGendogakuDiv KubunShikyuGendogaku;
    @JsonProperty("ShuruiShikyuGendogaku")
    private ShuruiShikyuGendogakuDiv ShuruiShikyuGendogaku;
    @JsonProperty("btnSettle")
    private Button btnSettle;
    @JsonProperty("btnCancel")
    private Button btnCancel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShikyuGendogakuKyotakuServiceTop")
    public ShikyuGendogakuKyotakuServiceTopDiv getShikyuGendogakuKyotakuServiceTop() {
        return ShikyuGendogakuKyotakuServiceTop;
    }

    @JsonProperty("ShikyuGendogakuKyotakuServiceTop")
    public void setShikyuGendogakuKyotakuServiceTop(ShikyuGendogakuKyotakuServiceTopDiv ShikyuGendogakuKyotakuServiceTop) {
        this.ShikyuGendogakuKyotakuServiceTop = ShikyuGendogakuKyotakuServiceTop;
    }

    @JsonProperty("KubunShikyuGendogaku")
    public KubunShikyuGendogakuDiv getKubunShikyuGendogaku() {
        return KubunShikyuGendogaku;
    }

    @JsonProperty("KubunShikyuGendogaku")
    public void setKubunShikyuGendogaku(KubunShikyuGendogakuDiv KubunShikyuGendogaku) {
        this.KubunShikyuGendogaku = KubunShikyuGendogaku;
    }

    @JsonProperty("ShuruiShikyuGendogaku")
    public ShuruiShikyuGendogakuDiv getShuruiShikyuGendogaku() {
        return ShuruiShikyuGendogaku;
    }

    @JsonProperty("ShuruiShikyuGendogaku")
    public void setShuruiShikyuGendogaku(ShuruiShikyuGendogakuDiv ShuruiShikyuGendogaku) {
        this.ShuruiShikyuGendogaku = ShuruiShikyuGendogaku;
    }

    @JsonProperty("btnSettle")
    public Button getBtnSettle() {
        return btnSettle;
    }

    @JsonProperty("btnSettle")
    public void setBtnSettle(Button btnSettle) {
        this.btnSettle = btnSettle;
    }

    @JsonProperty("btnCancel")
    public Button getBtnCancel() {
        return btnCancel;
    }

    @JsonProperty("btnCancel")
    public void setBtnCancel(Button btnCancel) {
        this.btnCancel = btnCancel;
    }

}
