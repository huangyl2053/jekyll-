package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe1010001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshafinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaSearchForShinsei のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaSearchForShinseiDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("SearchCriteriaForShinsei")
    private HihokenshaFinderDiv SearchCriteriaForShinsei;
    @JsonProperty("SearchResultForShinsei")
    private SearchResultOfHihokenshaDiv SearchResultForShinsei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchCriteriaForShinsei")
    public HihokenshaFinderDiv getSearchCriteriaForShinsei() {
        return SearchCriteriaForShinsei;
    }

    @JsonProperty("SearchCriteriaForShinsei")
    public void setSearchCriteriaForShinsei(HihokenshaFinderDiv SearchCriteriaForShinsei) {
        this.SearchCriteriaForShinsei = SearchCriteriaForShinsei;
    }

    @JsonProperty("SearchResultForShinsei")
    public SearchResultOfHihokenshaDiv getSearchResultForShinsei() {
        return SearchResultForShinsei;
    }

    @JsonProperty("SearchResultForShinsei")
    public void setSearchResultForShinsei(SearchResultOfHihokenshaDiv SearchResultForShinsei) {
        this.SearchResultForShinsei = SearchResultForShinsei;
    }

}
