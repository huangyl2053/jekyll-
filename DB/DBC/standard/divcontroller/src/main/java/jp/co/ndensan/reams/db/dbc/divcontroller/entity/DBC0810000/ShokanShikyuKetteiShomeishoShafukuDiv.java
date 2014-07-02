package jp.co.ndensan.reams.db.dbc.divcontroller.entity.DBC0810000;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.ServiceTeikyoShomeishoShafukuList.ServiceTeikyoShomeishoShafukuListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * ShokanShikyuKetteiShomeishoShafuku のクラスファイル
 *
 * @author 自動生成
 */
public class ShokanShikyuKetteiShomeishoShafukuDiv extends TabPanel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShokanShikyuKetteiShomeishoShafukuListInfo")
    private ServiceTeikyoShomeishoShafukuListDiv ShokanShikyuKetteiShomeishoShafukuListInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShokanShikyuKetteiShomeishoShafukuListInfo")
    public ServiceTeikyoShomeishoShafukuListDiv getShokanShikyuKetteiShomeishoShafukuListInfo() {
        return ShokanShikyuKetteiShomeishoShafukuListInfo;
    }

    @JsonProperty("ShokanShikyuKetteiShomeishoShafukuListInfo")
    public void setShokanShikyuKetteiShomeishoShafukuListInfo(ServiceTeikyoShomeishoShafukuListDiv ShokanShikyuKetteiShomeishoShafukuListInfo) {
        this.ShokanShikyuKetteiShomeishoShafukuListInfo = ShokanShikyuKetteiShomeishoShafukuListInfo;
    }

}
