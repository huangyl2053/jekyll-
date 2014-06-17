package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd3010001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaShokaiTargetSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaShokaiTargetSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("searchCriteria")
    private HihokenshaFinderDiv searchCriteria;
    @JsonProperty("searchResult")
    private SearchResultOfHihokenshaDiv searchResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("searchCriteria")
    public HihokenshaFinderDiv getSearchCriteria() {
        return searchCriteria;
    }

    @JsonProperty("searchCriteria")
    public void setSearchCriteria(HihokenshaFinderDiv searchCriteria) {
        this.searchCriteria=searchCriteria;
    }

    @JsonProperty("searchResult")
    public SearchResultOfHihokenshaDiv getSearchResult() {
        return searchResult;
    }

    @JsonProperty("searchResult")
    public void setSearchResult(SearchResultOfHihokenshaDiv searchResult) {
        this.searchResult=searchResult;
    }

}
