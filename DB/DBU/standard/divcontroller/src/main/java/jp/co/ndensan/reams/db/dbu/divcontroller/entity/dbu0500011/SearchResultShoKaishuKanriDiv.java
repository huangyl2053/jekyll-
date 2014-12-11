package jp.co.ndensan.reams.db.dbu.divcontroller.entity.dbu0500011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.ShoKaishuJokyoListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchResultShoKaishuKanri のクラスファイル
 *
 * @author 自動生成
 */
public class SearchResultShoKaishuKanriDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("SearchResultShoKaishuJokyoList")
    private ShoKaishuJokyoListDiv SearchResultShoKaishuJokyoList;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchResultShoKaishuJokyoList")
    public ShoKaishuJokyoListDiv getSearchResultShoKaishuJokyoList() {
        return SearchResultShoKaishuJokyoList;
    }

    @JsonProperty("SearchResultShoKaishuJokyoList")
    public void setSearchResultShoKaishuJokyoList(ShoKaishuJokyoListDiv SearchResultShoKaishuJokyoList) {
        this.SearchResultShoKaishuJokyoList = SearchResultShoKaishuJokyoList;
    }

    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

}
