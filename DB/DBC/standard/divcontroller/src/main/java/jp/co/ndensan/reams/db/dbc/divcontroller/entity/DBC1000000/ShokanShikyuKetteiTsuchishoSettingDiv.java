package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC1000000;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * ShokanShikyuKetteiTsuchishoSetting のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShokanShikyuKetteiTsuchishoSettingDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanShikyuKetteiTsuchishoPrintSetting")
    private PrintContentsSettingDiv ShokanShikyuKetteiTsuchishoPrintSetting;
    @JsonProperty("ShokanShikyuKetteiTsuchishoSettingOuputOrder")
    private ChohyoShutsuryokujunDiv ShokanShikyuKetteiTsuchishoSettingOuputOrder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuKetteiTsuchishoPrintSetting")
    public PrintContentsSettingDiv getShokanShikyuKetteiTsuchishoPrintSetting() {
        return ShokanShikyuKetteiTsuchishoPrintSetting;
    }

    @JsonProperty("ShokanShikyuKetteiTsuchishoPrintSetting")
    public void setShokanShikyuKetteiTsuchishoPrintSetting(PrintContentsSettingDiv ShokanShikyuKetteiTsuchishoPrintSetting) {
        this.ShokanShikyuKetteiTsuchishoPrintSetting=ShokanShikyuKetteiTsuchishoPrintSetting;
    }

    @JsonProperty("ShokanShikyuKetteiTsuchishoSettingOuputOrder")
    public ChohyoShutsuryokujunDiv getShokanShikyuKetteiTsuchishoSettingOuputOrder() {
        return ShokanShikyuKetteiTsuchishoSettingOuputOrder;
    }

    @JsonProperty("ShokanShikyuKetteiTsuchishoSettingOuputOrder")
    public void setShokanShikyuKetteiTsuchishoSettingOuputOrder(ChohyoShutsuryokujunDiv ShokanShikyuKetteiTsuchishoSettingOuputOrder) {
        this.ShokanShikyuKetteiTsuchishoSettingOuputOrder=ShokanShikyuKetteiTsuchishoSettingOuputOrder;
    }

}
