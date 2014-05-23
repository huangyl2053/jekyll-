package jp.co.ndensan.reams.db.dbe.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.SearchButtonsForShinsakaiExtractionDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.ShinsakaiExtractionConditionDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbShinsakaiList_Row;
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
    @JsonProperty("dbShinsakaiList")
    private DataGrid<dbShinsakaiList_Row> dbShinsakaiList;

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
        this.ShinsakaiExtractionCondition=ShinsakaiExtractionCondition;
    }

    @JsonProperty("SearchButtonsForShinsakaiExtraction")
    public SearchButtonsForShinsakaiExtractionDiv getSearchButtonsForShinsakaiExtraction() {
        return SearchButtonsForShinsakaiExtraction;
    }

    @JsonProperty("SearchButtonsForShinsakaiExtraction")
    public void setSearchButtonsForShinsakaiExtraction(SearchButtonsForShinsakaiExtractionDiv SearchButtonsForShinsakaiExtraction) {
        this.SearchButtonsForShinsakaiExtraction=SearchButtonsForShinsakaiExtraction;
    }

    @JsonProperty("dbShinsakaiList")
    public DataGrid<dbShinsakaiList_Row> getDbShinsakaiList() {
        return dbShinsakaiList;
    }

    @JsonProperty("dbShinsakaiList")
    public void setDbShinsakaiList(DataGrid<dbShinsakaiList_Row> dbShinsakaiList) {
        this.dbShinsakaiList=dbShinsakaiList;
    }

}
