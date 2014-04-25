package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchCriteriaOfHokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.SearchCriteriaOfKojinDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HihokenshaFinder のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaFinderDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchCriteriaOfHokensha")
    private SearchCriteriaOfHokenshaDiv SearchCriteriaOfHokensha;
    @JsonProperty("SearchCriteriaOfKojin")
    private SearchCriteriaOfKojinDiv SearchCriteriaOfKojin;
    @JsonProperty("SearchCriteriaOfHihokensha")
    private SearchCriteriaOfHihokenshaDiv SearchCriteriaOfHihokensha;
    @JsonProperty("btnToSearch")
    private Button btnToSearch;
    @JsonProperty("btnToClear")
    private Button btnToClear;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchCriteriaOfHokensha")
    public SearchCriteriaOfHokenshaDiv getSearchCriteriaOfHokensha() {
        return SearchCriteriaOfHokensha;
    }

    @JsonProperty("SearchCriteriaOfHokensha")
    public void setSearchCriteriaOfHokensha(SearchCriteriaOfHokenshaDiv SearchCriteriaOfHokensha) {
        this.SearchCriteriaOfHokensha=SearchCriteriaOfHokensha;
    }

    @JsonProperty("SearchCriteriaOfKojin")
    public SearchCriteriaOfKojinDiv getSearchCriteriaOfKojin() {
        return SearchCriteriaOfKojin;
    }

    @JsonProperty("SearchCriteriaOfKojin")
    public void setSearchCriteriaOfKojin(SearchCriteriaOfKojinDiv SearchCriteriaOfKojin) {
        this.SearchCriteriaOfKojin=SearchCriteriaOfKojin;
    }

    @JsonProperty("SearchCriteriaOfHihokensha")
    public SearchCriteriaOfHihokenshaDiv getSearchCriteriaOfHihokensha() {
        return SearchCriteriaOfHihokensha;
    }

    @JsonProperty("SearchCriteriaOfHihokensha")
    public void setSearchCriteriaOfHihokensha(SearchCriteriaOfHihokenshaDiv SearchCriteriaOfHihokensha) {
        this.SearchCriteriaOfHihokensha=SearchCriteriaOfHihokensha;
    }

    @JsonProperty("btnToSearch")
    public Button getBtnToSearch() {
        return btnToSearch;
    }

    @JsonProperty("btnToSearch")
    public void setBtnToSearch(Button btnToSearch) {
        this.btnToSearch=btnToSearch;
    }

    @JsonProperty("btnToClear")
    public Button getBtnToClear() {
        return btnToClear;
    }

    @JsonProperty("btnToClear")
    public void setBtnToClear(Button btnToClear) {
        this.btnToClear=btnToClear;
    }

}
