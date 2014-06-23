package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SearchConditionToMishinsaShikyuShinseiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.SearchResultToMishinsaShikyuShinseiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchMishinsaShikyuShinseiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchMishinsaShikyuShinseiPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchConditionToMishinsaShikyuShinsei")
    private SearchConditionToMishinsaShikyuShinseiDiv SearchConditionToMishinsaShikyuShinsei;
    @JsonProperty("SearchResultToMishinsaShikyuShinsei")
    private SearchResultToMishinsaShikyuShinseiDiv SearchResultToMishinsaShikyuShinsei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchConditionToMishinsaShikyuShinsei")
    public SearchConditionToMishinsaShikyuShinseiDiv getSearchConditionToMishinsaShikyuShinsei() {
        return SearchConditionToMishinsaShikyuShinsei;
    }

    @JsonProperty("SearchConditionToMishinsaShikyuShinsei")
    public void setSearchConditionToMishinsaShikyuShinsei(SearchConditionToMishinsaShikyuShinseiDiv SearchConditionToMishinsaShikyuShinsei) {
        this.SearchConditionToMishinsaShikyuShinsei=SearchConditionToMishinsaShikyuShinsei;
    }

    @JsonProperty("SearchResultToMishinsaShikyuShinsei")
    public SearchResultToMishinsaShikyuShinseiDiv getSearchResultToMishinsaShikyuShinsei() {
        return SearchResultToMishinsaShikyuShinsei;
    }

    @JsonProperty("SearchResultToMishinsaShikyuShinsei")
    public void setSearchResultToMishinsaShikyuShinsei(SearchResultToMishinsaShikyuShinseiDiv SearchResultToMishinsaShikyuShinsei) {
        this.SearchResultToMishinsaShikyuShinsei=SearchResultToMishinsaShikyuShinsei;
    }

}
