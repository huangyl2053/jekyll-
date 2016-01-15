package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * JutakuKaishuhiShikyuKetteiTsuchishoPanel のクラスファイル
 *
 * @author 自動生成
 */
public class JutakuKaishuhiShikyuKetteiTsuchishoPanelDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("JutakuKaishuhiShikyuKetteiTsuchishoHakkoDate")
    private PrintContentsSettingDiv JutakuKaishuhiShikyuKetteiTsuchishoHakkoDate;
    @JsonProperty("JutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod")
    private PaymentDateDiv JutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod;
    @JsonProperty("JutakuKaishuhiShikyuKetteiTsuchishoOutputOrder")
    private ChohyoShutsuryokujunDiv JutakuKaishuhiShikyuKetteiTsuchishoOutputOrder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JutakuKaishuhiShikyuKetteiTsuchishoHakkoDate")
    public PrintContentsSettingDiv getJutakuKaishuhiShikyuKetteiTsuchishoHakkoDate() {
        return JutakuKaishuhiShikyuKetteiTsuchishoHakkoDate;
    }

    @JsonProperty("JutakuKaishuhiShikyuKetteiTsuchishoHakkoDate")
    public void setJutakuKaishuhiShikyuKetteiTsuchishoHakkoDate(PrintContentsSettingDiv JutakuKaishuhiShikyuKetteiTsuchishoHakkoDate) {
        this.JutakuKaishuhiShikyuKetteiTsuchishoHakkoDate = JutakuKaishuhiShikyuKetteiTsuchishoHakkoDate;
    }

    @JsonProperty("JutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod")
    public PaymentDateDiv getJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod() {
        return JutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod;
    }

    @JsonProperty("JutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod")
    public void setJutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod(PaymentDateDiv JutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod) {
        this.JutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod = JutakuKaishuhiShikyuKetteiTsuchishoPaymentMethod;
    }

    @JsonProperty("JutakuKaishuhiShikyuKetteiTsuchishoOutputOrder")
    public ChohyoShutsuryokujunDiv getJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder() {
        return JutakuKaishuhiShikyuKetteiTsuchishoOutputOrder;
    }

    @JsonProperty("JutakuKaishuhiShikyuKetteiTsuchishoOutputOrder")
    public void setJutakuKaishuhiShikyuKetteiTsuchishoOutputOrder(ChohyoShutsuryokujunDiv JutakuKaishuhiShikyuKetteiTsuchishoOutputOrder) {
        this.JutakuKaishuhiShikyuKetteiTsuchishoOutputOrder = JutakuKaishuhiShikyuKetteiTsuchishoOutputOrder;
    }

}
