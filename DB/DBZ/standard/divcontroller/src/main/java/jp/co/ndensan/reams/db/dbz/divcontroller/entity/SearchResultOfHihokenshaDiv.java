package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.dgSearchResult_Row;
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
    @JsonProperty("btnToResearch")
    private Button btnToResearch;

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

    @JsonProperty("btnToResearch")
    public Button getBtnToResearch() {
        return btnToResearch;
    }

    @JsonProperty("btnToResearch")
    public void setBtnToResearch(Button btnToResearch) {
        this.btnToResearch=btnToResearch;
    }

}
