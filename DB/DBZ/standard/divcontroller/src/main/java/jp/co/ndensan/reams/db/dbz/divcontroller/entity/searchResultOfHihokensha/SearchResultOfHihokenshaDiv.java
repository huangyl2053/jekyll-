package jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.ButtonsForSearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.dgSearchResult_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchResultOfHihokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchResultOfHihokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSearchResult")
    private DataGrid<dgSearchResult_Row> dgSearchResult;
    @JsonProperty("ButtonsForSearchResultOfHihokensha")
    private ButtonsForSearchResultOfHihokenshaDiv ButtonsForSearchResultOfHihokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSearchResult")
    public DataGrid<dgSearchResult_Row> getDgSearchResult() {
        return dgSearchResult;
    }

    @JsonProperty("dgSearchResult")
    public void setDgSearchResult(DataGrid<dgSearchResult_Row> dgSearchResult) {
        this.dgSearchResult=dgSearchResult;
    }

    @JsonProperty("ButtonsForSearchResultOfHihokensha")
    public ButtonsForSearchResultOfHihokenshaDiv getButtonsForSearchResultOfHihokensha() {
        return ButtonsForSearchResultOfHihokensha;
    }

    @JsonProperty("ButtonsForSearchResultOfHihokensha")
    public void setButtonsForSearchResultOfHihokensha(ButtonsForSearchResultOfHihokenshaDiv ButtonsForSearchResultOfHihokensha) {
        this.ButtonsForSearchResultOfHihokensha=ButtonsForSearchResultOfHihokensha;
    }

}
