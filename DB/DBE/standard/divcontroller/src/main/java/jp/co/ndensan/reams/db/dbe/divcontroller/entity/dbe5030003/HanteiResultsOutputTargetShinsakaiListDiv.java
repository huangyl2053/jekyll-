package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003.SearchButtonsForShinsakaiExtractionDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003.ShinsakaiExtractionConditionDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe5030003.dgShinsakaiList_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * HanteiResultsOutputTargetShinsakaiList のクラスファイル
 *
 * @author 自動生成
 */
public class HanteiResultsOutputTargetShinsakaiListDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("ShinsakaiExtractionCondition")
    private ShinsakaiExtractionConditionDiv ShinsakaiExtractionCondition;
    @JsonProperty("SearchButtonsForShinsakaiExtraction")
    private SearchButtonsForShinsakaiExtractionDiv SearchButtonsForShinsakaiExtraction;
    @JsonProperty("dgShinsakaiList")
    private DataGrid<dgShinsakaiList_Row> dgShinsakaiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShinsakaiExtractionCondition")
    public ShinsakaiExtractionConditionDiv getShinsakaiExtractionCondition() {
        return ShinsakaiExtractionCondition;
    }

    @JsonProperty("ShinsakaiExtractionCondition")
    public void setShinsakaiExtractionCondition(ShinsakaiExtractionConditionDiv ShinsakaiExtractionCondition) {
        this.ShinsakaiExtractionCondition = ShinsakaiExtractionCondition;
    }

    @JsonProperty("SearchButtonsForShinsakaiExtraction")
    public SearchButtonsForShinsakaiExtractionDiv getSearchButtonsForShinsakaiExtraction() {
        return SearchButtonsForShinsakaiExtraction;
    }

    @JsonProperty("SearchButtonsForShinsakaiExtraction")
    public void setSearchButtonsForShinsakaiExtraction(SearchButtonsForShinsakaiExtractionDiv SearchButtonsForShinsakaiExtraction) {
        this.SearchButtonsForShinsakaiExtraction = SearchButtonsForShinsakaiExtraction;
    }

    @JsonProperty("dgShinsakaiList")
    public DataGrid<dgShinsakaiList_Row> getDgShinsakaiList() {
        return dgShinsakaiList;
    }

    @JsonProperty("dgShinsakaiList")
    public void setDgShinsakaiList(DataGrid<dgShinsakaiList_Row> dgShinsakaiList) {
        this.dgShinsakaiList = dgShinsakaiList;
    }

}
