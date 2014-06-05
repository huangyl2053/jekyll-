package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1000000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.PaymentDateDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.PaymentDateDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * ShokanShikyuKetteishaListSetting のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteishaListSettingDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuKetteishaListPrintSetting")
    private PrintContentsSettingDiv ShokanShikyuKetteishaListPrintSetting;
    @JsonProperty("ShokanShikyuKetteishaListPayDate")
    private PaymentDateDiv ShokanShikyuKetteishaListPayDate;
    @JsonProperty("ShokanShikyuKetteishaListSettingOutputOrder")
    private ChohyoShutsuryokujunDiv ShokanShikyuKetteishaListSettingOutputOrder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuKetteishaListPrintSetting")
    public PrintContentsSettingDiv getShokanShikyuKetteishaListPrintSetting() {
        return ShokanShikyuKetteishaListPrintSetting;
    }

    @JsonProperty("ShokanShikyuKetteishaListPrintSetting")
    public void setShokanShikyuKetteishaListPrintSetting(PrintContentsSettingDiv ShokanShikyuKetteishaListPrintSetting) {
        this.ShokanShikyuKetteishaListPrintSetting=ShokanShikyuKetteishaListPrintSetting;
    }

    @JsonProperty("ShokanShikyuKetteishaListPayDate")
    public PaymentDateDiv getShokanShikyuKetteishaListPayDate() {
        return ShokanShikyuKetteishaListPayDate;
    }

    @JsonProperty("ShokanShikyuKetteishaListPayDate")
    public void setShokanShikyuKetteishaListPayDate(PaymentDateDiv ShokanShikyuKetteishaListPayDate) {
        this.ShokanShikyuKetteishaListPayDate=ShokanShikyuKetteishaListPayDate;
    }

    @JsonProperty("ShokanShikyuKetteishaListSettingOutputOrder")
    public ChohyoShutsuryokujunDiv getShokanShikyuKetteishaListSettingOutputOrder() {
        return ShokanShikyuKetteishaListSettingOutputOrder;
    }

    @JsonProperty("ShokanShikyuKetteishaListSettingOutputOrder")
    public void setShokanShikyuKetteishaListSettingOutputOrder(ChohyoShutsuryokujunDiv ShokanShikyuKetteishaListSettingOutputOrder) {
        this.ShokanShikyuKetteishaListSettingOutputOrder=ShokanShikyuKetteishaListSettingOutputOrder;
    }

}
