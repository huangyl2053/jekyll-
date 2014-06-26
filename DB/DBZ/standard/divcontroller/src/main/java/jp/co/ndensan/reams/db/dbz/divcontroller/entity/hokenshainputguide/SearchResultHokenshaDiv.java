package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hokenshainputguide;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hokenshainputguide.dgSearchResultHokensha_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * SearchResultHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class SearchResultHokenshaDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("dgSearchResultHokensha")
    private DataGrid<dgSearchResultHokensha_Row> dgSearchResultHokensha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgSearchResultHokensha")
    public DataGrid<dgSearchResultHokensha_Row> getDgSearchResultHokensha() {
        return dgSearchResultHokensha;
    }

    @JsonProperty("dgSearchResultHokensha")
    public void setDgSearchResultHokensha(DataGrid<dgSearchResultHokensha_Row> dgSearchResultHokensha) {
        this.dgSearchResultHokensha=dgSearchResultHokensha;
    }

}
