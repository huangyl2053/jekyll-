package jp.co.ndensan.reams.db.dbz.divcontroller.entity.DBZ0010000;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SogoShokaiSearch のクラスファイル
 *
 * @author 自動生成
 */
public class SogoShokaiSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("SogoShokaiSearchInfo")
    private HihokenshaFinderDiv SogoShokaiSearchInfo;
    @JsonProperty("SogoShokaiGaitoshaListInfo")
    private SearchResultOfHihokenshaDiv SogoShokaiGaitoshaListInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SogoShokaiSearchInfo")
    public HihokenshaFinderDiv getSogoShokaiSearchInfo() {
        return SogoShokaiSearchInfo;
    }

    @JsonProperty("SogoShokaiSearchInfo")
    public void setSogoShokaiSearchInfo(HihokenshaFinderDiv SogoShokaiSearchInfo) {
        this.SogoShokaiSearchInfo = SogoShokaiSearchInfo;
    }

    @JsonProperty("SogoShokaiGaitoshaListInfo")
    public SearchResultOfHihokenshaDiv getSogoShokaiGaitoshaListInfo() {
        return SogoShokaiGaitoshaListInfo;
    }

    @JsonProperty("SogoShokaiGaitoshaListInfo")
    public void setSogoShokaiGaitoshaListInfo(SearchResultOfHihokenshaDiv SogoShokaiGaitoshaListInfo) {
        this.SogoShokaiGaitoshaListInfo = SogoShokaiGaitoshaListInfo;
    }

}
