package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.printcontentssetting.PrintContentsSettingDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelPublish;

/**
 * JutakuKaishuhiShikyuKetteishaListPanel のクラスファイル
 *
 * @author 自動生成
 */
public class JutakuKaishuhiShikyuKetteishaListPanelDiv extends PanelPublish {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("JutakuKaishuhiShikyuKetteishaListHakkoDate")
    private PrintContentsSettingDiv JutakuKaishuhiShikyuKetteishaListHakkoDate;
    @JsonProperty("JutakuKaishuhiShikyuKetteishaListOutputOrder")
    private ChohyoShutsuryokujunDiv JutakuKaishuhiShikyuKetteishaListOutputOrder;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("JutakuKaishuhiShikyuKetteishaListHakkoDate")
    public PrintContentsSettingDiv getJutakuKaishuhiShikyuKetteishaListHakkoDate() {
        return JutakuKaishuhiShikyuKetteishaListHakkoDate;
    }

    @JsonProperty("JutakuKaishuhiShikyuKetteishaListHakkoDate")
    public void setJutakuKaishuhiShikyuKetteishaListHakkoDate(PrintContentsSettingDiv JutakuKaishuhiShikyuKetteishaListHakkoDate) {
        this.JutakuKaishuhiShikyuKetteishaListHakkoDate = JutakuKaishuhiShikyuKetteishaListHakkoDate;
    }

    @JsonProperty("JutakuKaishuhiShikyuKetteishaListOutputOrder")
    public ChohyoShutsuryokujunDiv getJutakuKaishuhiShikyuKetteishaListOutputOrder() {
        return JutakuKaishuhiShikyuKetteishaListOutputOrder;
    }

    @JsonProperty("JutakuKaishuhiShikyuKetteishaListOutputOrder")
    public void setJutakuKaishuhiShikyuKetteishaListOutputOrder(ChohyoShutsuryokujunDiv JutakuKaishuhiShikyuKetteishaListOutputOrder) {
        this.JutakuKaishuhiShikyuKetteishaListOutputOrder = JutakuKaishuhiShikyuKetteishaListOutputOrder;
    }

}
