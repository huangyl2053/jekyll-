package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShokujiList.ServiceTeikyoShomeishoShokujiListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuKetteiShomeishoShokuji のクラスファイル
 *
 * @author 自動生成
 */
public class ShokanShikyuKetteiShomeishoShokujiDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShokanShikyuKetteiShomeishoShokujiListInfo")
    private ServiceTeikyoShomeishoShokujiListDiv ShokanShikyuKetteiShomeishoShokujiListInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuKetteiShomeishoShokujiListInfo")
    public ServiceTeikyoShomeishoShokujiListDiv getShokanShikyuKetteiShomeishoShokujiListInfo() {
        return ShokanShikyuKetteiShomeishoShokujiListInfo;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoShokujiListInfo")
    public void setShokanShikyuKetteiShomeishoShokujiListInfo(ServiceTeikyoShomeishoShokujiListDiv ShokanShikyuKetteiShomeishoShokujiListInfo) {
        this.ShokanShikyuKetteiShomeishoShokujiListInfo = ShokanShikyuKetteiShomeishoShokujiListInfo;
    }

}
