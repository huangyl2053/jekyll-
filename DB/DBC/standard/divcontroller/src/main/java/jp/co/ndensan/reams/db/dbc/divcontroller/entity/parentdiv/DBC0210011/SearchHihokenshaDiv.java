package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0210011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder.HihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hihokenshafinder.HihokenshaFinder.IHihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.searchResultOfHihokensha.SearchResultOfHihokenshaDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * SearchHihokensha のクラスファイル
 *
 * @author 自動生成
 */
public class SearchHihokenshaDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-07_19-12-57">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchResultOfHihokensha")
    private SearchResultOfHihokenshaDiv SearchResultOfHihokensha;
    @JsonProperty("SearchConditionOfHihokensha")
    private HihokenshaFinderDiv SearchConditionOfHihokensha;

    /*
     * getSearchConditionOfHihokensha
     * @return SearchConditionOfHihokensha
     */
    @JsonProperty("SearchConditionOfHihokensha")
    public IHihokenshaFinderDiv getSearchConditionOfHihokensha() {
        return SearchConditionOfHihokensha;
    }

    // </editor-fold>
}
