package jp.co.ndensan.reams.db.dbz.divcontroller.entity.dbzu020001;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaSearch のクラスファイル
 *
 * @author 自動生成
 */
public class HihokenshaSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("taishoshaSearch")
    private HihokenshaFinderDiv taishoshaSearch;
    @JsonProperty("taishoshaList")
    private SearchResultOfHihokenshaDiv taishoshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("taishoshaSearch")
    public HihokenshaFinderDiv getTaishoshaSearch() {
        return taishoshaSearch;
    }

    @JsonProperty("taishoshaSearch")
    public void setTaishoshaSearch(HihokenshaFinderDiv taishoshaSearch) {
        this.taishoshaSearch = taishoshaSearch;
    }

    @JsonProperty("taishoshaList")
    public SearchResultOfHihokenshaDiv getTaishoshaList() {
        return taishoshaList;
    }

    @JsonProperty("taishoshaList")
    public void setTaishoshaList(SearchResultOfHihokenshaDiv taishoshaList) {
        this.taishoshaList = taishoshaList;
    }

}
