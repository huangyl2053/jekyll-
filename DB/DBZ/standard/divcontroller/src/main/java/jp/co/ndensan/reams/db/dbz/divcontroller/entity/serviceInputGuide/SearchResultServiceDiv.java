package jp.co.ndensan.reams.db.dbz.divcontroller.entity.serviceInputGuide;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.serviceInputGuide.dgSearchResultService_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchResultService のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchResultServiceDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSearchResultService")
    private DataGrid<dgSearchResultService_Row> dgSearchResultService;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSearchResultService")
    public DataGrid<dgSearchResultService_Row> getDgSearchResultService() {
        return dgSearchResultService;
    }

    @JsonProperty("dgSearchResultService")
    public void setDgSearchResultService(DataGrid<dgSearchResultService_Row> dgSearchResultService) {
        this.dgSearchResultService=dgSearchResultService;
    }

}
