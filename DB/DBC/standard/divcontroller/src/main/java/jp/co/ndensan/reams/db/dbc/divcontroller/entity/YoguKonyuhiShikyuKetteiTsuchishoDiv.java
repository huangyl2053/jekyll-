package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.OutputOrderAndNewpageDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.PaymentDateDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * YoguKonyuhiShikyuKetteiTsuchisho のクラスファイル
 *
 * @author 自動生成
 */
public class YoguKonyuhiShikyuKetteiTsuchishoDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("YoguKonyuhiShikyuKetteiTsuchishoHakkoDate")
    private PrintContentsSettingDiv YoguKonyuhiShikyuKetteiTsuchishoHakkoDate;
    @JsonProperty("PaymentDate")
    private PaymentDateDiv PaymentDate;
    @JsonProperty("OutputOrderForTsuchisho")
    private OutputOrderAndNewpageDiv OutputOrderForTsuchisho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("YoguKonyuhiShikyuKetteiTsuchishoHakkoDate")
    public PrintContentsSettingDiv getYoguKonyuhiShikyuKetteiTsuchishoHakkoDate() {
        return YoguKonyuhiShikyuKetteiTsuchishoHakkoDate;
    }

    @JsonProperty("YoguKonyuhiShikyuKetteiTsuchishoHakkoDate")
    public void setYoguKonyuhiShikyuKetteiTsuchishoHakkoDate(PrintContentsSettingDiv YoguKonyuhiShikyuKetteiTsuchishoHakkoDate) {
        this.YoguKonyuhiShikyuKetteiTsuchishoHakkoDate = YoguKonyuhiShikyuKetteiTsuchishoHakkoDate;
    }

    @JsonProperty("PaymentDate")
    public PaymentDateDiv getPaymentDate() {
        return PaymentDate;
    }

    @JsonProperty("PaymentDate")
    public void setPaymentDate(PaymentDateDiv PaymentDate) {
        this.PaymentDate = PaymentDate;
    }

    @JsonProperty("OutputOrderForTsuchisho")
    public OutputOrderAndNewpageDiv getOutputOrderForTsuchisho() {
        return OutputOrderForTsuchisho;
    }

    @JsonProperty("OutputOrderForTsuchisho")
    public void setOutputOrderForTsuchisho(OutputOrderAndNewpageDiv OutputOrderForTsuchisho) {
        this.OutputOrderForTsuchisho = OutputOrderForTsuchisho;
    }

}
