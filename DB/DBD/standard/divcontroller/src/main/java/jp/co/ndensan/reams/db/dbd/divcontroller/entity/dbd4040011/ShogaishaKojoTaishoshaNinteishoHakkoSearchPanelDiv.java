package jp.co.ndensan.reams.db.dbd.divcontroller.entity.dbd4040011;
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
 * ShogaishaKojoTaishoshaNinteishoHakkoSearchPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoTaishoshaNinteishoHakkoSearchPanelDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShogaishaKojoTaishoshaSearch")
    private HihokenshaFinderDiv ShogaishaKojoTaishoshaSearch;
    @JsonProperty("ShogaishaKojoTaishoshaList")
    private SearchResultOfHihokenshaDiv ShogaishaKojoTaishoshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShogaishaKojoTaishoshaSearch")
    public HihokenshaFinderDiv getShogaishaKojoTaishoshaSearch() {
        return ShogaishaKojoTaishoshaSearch;
    }

    @JsonProperty("ShogaishaKojoTaishoshaSearch")
    public void setShogaishaKojoTaishoshaSearch(HihokenshaFinderDiv ShogaishaKojoTaishoshaSearch) {
        this.ShogaishaKojoTaishoshaSearch=ShogaishaKojoTaishoshaSearch;
    }

    @JsonProperty("ShogaishaKojoTaishoshaList")
    public SearchResultOfHihokenshaDiv getShogaishaKojoTaishoshaList() {
        return ShogaishaKojoTaishoshaList;
    }

    @JsonProperty("ShogaishaKojoTaishoshaList")
    public void setShogaishaKojoTaishoshaList(SearchResultOfHihokenshaDiv ShogaishaKojoTaishoshaList) {
        this.ShogaishaKojoTaishoshaList=ShogaishaKojoTaishoshaList;
    }

}
