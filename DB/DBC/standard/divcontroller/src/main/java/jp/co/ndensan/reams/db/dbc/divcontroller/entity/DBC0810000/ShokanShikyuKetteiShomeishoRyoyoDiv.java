package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoRyoyoList.ServiceTeikyoShomeishoRyoyoListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuKetteiShomeishoRyoyo のクラスファイル
 *
 * @author 自動生成
 */
public class ShokanShikyuKetteiShomeishoRyoyoDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShokanShikyuKetteiShomeishoRyoyoListInfo")
    private ServiceTeikyoShomeishoRyoyoListDiv ShokanShikyuKetteiShomeishoRyoyoListInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuKetteiShomeishoRyoyoListInfo")
    public ServiceTeikyoShomeishoRyoyoListDiv getShokanShikyuKetteiShomeishoRyoyoListInfo() {
        return ShokanShikyuKetteiShomeishoRyoyoListInfo;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoRyoyoListInfo")
    public void setShokanShikyuKetteiShomeishoRyoyoListInfo(ServiceTeikyoShomeishoRyoyoListDiv ShokanShikyuKetteiShomeishoRyoyoListInfo) {
        this.ShokanShikyuKetteiShomeishoRyoyoListInfo = ShokanShikyuKetteiShomeishoRyoyoListInfo;
    }

}
