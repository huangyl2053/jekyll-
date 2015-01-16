package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshafinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchHihokenshaPanel のクラスファイル
 *
 * @author 自動生成
 */
public class SearchHihokenshaPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("HihokenshaFinder")
    private HihokenshaFinderDiv HihokenshaFinder;
    @JsonProperty("HihokenshaSearchResult")
    private SearchResultOfHihokenshaDiv HihokenshaSearchResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("HihokenshaFinder")
    public HihokenshaFinderDiv getHihokenshaFinder() {
        return HihokenshaFinder;
    }

    @JsonProperty("HihokenshaFinder")
    public void setHihokenshaFinder(HihokenshaFinderDiv HihokenshaFinder) {
        this.HihokenshaFinder = HihokenshaFinder;
    }

    @JsonProperty("HihokenshaSearchResult")
    public SearchResultOfHihokenshaDiv getHihokenshaSearchResult() {
        return HihokenshaSearchResult;
    }

    @JsonProperty("HihokenshaSearchResult")
    public void setHihokenshaSearchResult(SearchResultOfHihokenshaDiv HihokenshaSearchResult) {
        this.HihokenshaSearchResult = HihokenshaSearchResult;
    }

}
