package jp.co.ndensan.reams.db.dbc.divcontroller.entity;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshafinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchHihokensha のクラスファイル
 *
 * @author 自動生成
 */
public class SearchHihokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("SearchConditionOfHihokensha")
    private HihokenshaFinderDiv SearchConditionOfHihokensha;
    @JsonProperty("btnKari")
    private Button btnKari;
    @JsonProperty("SearchResultOfHihokensha")
    private SearchResultOfHihokenshaDiv SearchResultOfHihokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchConditionOfHihokensha")
    public HihokenshaFinderDiv getSearchConditionOfHihokensha() {
        return SearchConditionOfHihokensha;
    }

    @JsonProperty("SearchConditionOfHihokensha")
    public void setSearchConditionOfHihokensha(HihokenshaFinderDiv SearchConditionOfHihokensha) {
        this.SearchConditionOfHihokensha = SearchConditionOfHihokensha;
    }

    @JsonProperty("btnKari")
    public Button getBtnKari() {
        return btnKari;
    }

    @JsonProperty("btnKari")
    public void setBtnKari(Button btnKari) {
        this.btnKari = btnKari;
    }

    @JsonProperty("SearchResultOfHihokensha")
    public SearchResultOfHihokenshaDiv getSearchResultOfHihokensha() {
        return SearchResultOfHihokensha;
    }

    @JsonProperty("SearchResultOfHihokensha")
    public void setSearchResultOfHihokensha(SearchResultOfHihokenshaDiv SearchResultOfHihokensha) {
        this.SearchResultOfHihokensha = SearchResultOfHihokensha;
    }

}
