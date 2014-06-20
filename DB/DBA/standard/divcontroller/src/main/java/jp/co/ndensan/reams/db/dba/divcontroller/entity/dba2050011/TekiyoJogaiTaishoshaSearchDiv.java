package jp.co.ndensan.reams.db.dba.divcontroller.entity.dba2050011;
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
 * TekiyoJogaiTaishoshaSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class TekiyoJogaiTaishoshaSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HihokenshaFinder")
    private HihokenshaFinderDiv HihokenshaFinder;
    @JsonProperty("SearchResult")
    private SearchResultOfHihokenshaDiv SearchResult;

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
        this.HihokenshaFinder=HihokenshaFinder;
    }

    @JsonProperty("SearchResult")
    public SearchResultOfHihokenshaDiv getSearchResult() {
        return SearchResult;
    }

    @JsonProperty("SearchResult")
    public void setSearchResult(SearchResultOfHihokenshaDiv SearchResult) {
        this.SearchResult=SearchResult;
    }

}
