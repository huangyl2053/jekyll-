package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0410011;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchHihokenshashoHakko のクラスファイル
 *
 * @author 自動生成
 */
//TODO n3317 塚田萌　ビルドを通すための対応。再生成してください。
public class SearchHihokenshashoHakkoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ccdSearchHihokenshashoHakkoTaishosha")
    private HihokenshaFinderDiv ccdSearchHihokenshashoHakkoTaishosha;
    @JsonProperty("ccdHihokenshashoHakkoTaishoGaitosha")
    private SearchResultOfHihokenshaDiv ccdHihokenshashoHakkoTaishoGaitosha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ccdSearchHihokenshashoHakkoTaishosha")
    public HihokenshaFinderDiv getCcdSearchHihokenshashoHakkoTaishosha() {
        return ccdSearchHihokenshashoHakkoTaishosha;
    }

    @JsonProperty("ccdSearchHihokenshashoHakkoTaishosha")
    public void setCcdSearchHihokenshashoHakkoTaishosha(HihokenshaFinderDiv ccdSearchHihokenshashoHakkoTaishosha) {
        this.ccdSearchHihokenshashoHakkoTaishosha = ccdSearchHihokenshashoHakkoTaishosha;
    }

    @JsonProperty("ccdHihokenshashoHakkoTaishoGaitosha")
    public SearchResultOfHihokenshaDiv getCcdHihokenshashoHakkoTaishoGaitosha() {
        return ccdHihokenshashoHakkoTaishoGaitosha;
    }

    @JsonProperty("ccdHihokenshashoHakkoTaishoGaitosha")
    public void setCcdHihokenshashoHakkoTaishoGaitosha(SearchResultOfHihokenshaDiv ccdHihokenshashoHakkoTaishoGaitosha) {
        this.ccdHihokenshashoHakkoTaishoGaitosha = ccdHihokenshashoHakkoTaishoGaitosha;
    }

}
