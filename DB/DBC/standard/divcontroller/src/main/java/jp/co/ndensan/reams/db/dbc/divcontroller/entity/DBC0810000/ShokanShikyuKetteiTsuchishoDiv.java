package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.PaymentDateDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.PaymentDateDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * ShokanShikyuKetteiTsuchisho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiTsuchishoDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuKetteiTsuchishoPrintContentsSetting")
    private PrintContentsSettingDiv ShokanShikyuKetteiTsuchishoPrintContentsSetting;
    @JsonProperty("ShokanShikyuKetteiTsuchishoPaymentDate")
    private PaymentDateDiv ShokanShikyuKetteiTsuchishoPaymentDate;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuKetteiTsuchishoPrintContentsSetting")
    public PrintContentsSettingDiv getShokanShikyuKetteiTsuchishoPrintContentsSetting() {
        return ShokanShikyuKetteiTsuchishoPrintContentsSetting;
    }

    @JsonProperty("ShokanShikyuKetteiTsuchishoPrintContentsSetting")
    public void setShokanShikyuKetteiTsuchishoPrintContentsSetting(PrintContentsSettingDiv ShokanShikyuKetteiTsuchishoPrintContentsSetting) {
        this.ShokanShikyuKetteiTsuchishoPrintContentsSetting=ShokanShikyuKetteiTsuchishoPrintContentsSetting;
    }

    @JsonProperty("ShokanShikyuKetteiTsuchishoPaymentDate")
    public PaymentDateDiv getShokanShikyuKetteiTsuchishoPaymentDate() {
        return ShokanShikyuKetteiTsuchishoPaymentDate;
    }

    @JsonProperty("ShokanShikyuKetteiTsuchishoPaymentDate")
    public void setShokanShikyuKetteiTsuchishoPaymentDate(PaymentDateDiv ShokanShikyuKetteiTsuchishoPaymentDate) {
        this.ShokanShikyuKetteiTsuchishoPaymentDate=ShokanShikyuKetteiTsuchishoPaymentDate;
    }

}
