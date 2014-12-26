package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0410000;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * KyufuJissekiTorikomiKekkaList のクラスファイル
 *
 * @author 自動生成
 */
public class KyufuJissekiTorikomiKekkaListDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("KyufuJissekiTorikomiKekkaListPrintSetting")
    private PrintContentsSettingDiv KyufuJissekiTorikomiKekkaListPrintSetting;
    @JsonProperty("KyufuJissekiTorikomiKekkaListOutputOrder")
    private ChohyoShutsuryokujunDiv KyufuJissekiTorikomiKekkaListOutputOrder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("KyufuJissekiTorikomiKekkaListPrintSetting")
    public PrintContentsSettingDiv getKyufuJissekiTorikomiKekkaListPrintSetting() {
        return KyufuJissekiTorikomiKekkaListPrintSetting;
    }

    @JsonProperty("KyufuJissekiTorikomiKekkaListPrintSetting")
    public void setKyufuJissekiTorikomiKekkaListPrintSetting(PrintContentsSettingDiv KyufuJissekiTorikomiKekkaListPrintSetting) {
        this.KyufuJissekiTorikomiKekkaListPrintSetting = KyufuJissekiTorikomiKekkaListPrintSetting;
    }

    @JsonProperty("KyufuJissekiTorikomiKekkaListOutputOrder")
    public ChohyoShutsuryokujunDiv getKyufuJissekiTorikomiKekkaListOutputOrder() {
        return KyufuJissekiTorikomiKekkaListOutputOrder;
    }

    @JsonProperty("KyufuJissekiTorikomiKekkaListOutputOrder")
    public void setKyufuJissekiTorikomiKekkaListOutputOrder(ChohyoShutsuryokujunDiv KyufuJissekiTorikomiKekkaListOutputOrder) {
        this.KyufuJissekiTorikomiKekkaListOutputOrder = KyufuJissekiTorikomiKekkaListOutputOrder;
    }

}
