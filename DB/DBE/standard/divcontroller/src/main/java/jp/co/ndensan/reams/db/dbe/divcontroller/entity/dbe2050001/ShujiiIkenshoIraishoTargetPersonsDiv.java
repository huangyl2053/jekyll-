package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.SearchButtonsForShujiiIkenshoIraishoTargetPersonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe2050001.dgShujiiIkenshoIraishoTargetPersons_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShujiiIkenshoIraishoTargetPersons のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIkenshoIraishoTargetPersonsDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SerachCriteriaForShujiiIkenshoIraishoTargetPersons")
    private SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv SerachCriteriaForShujiiIkenshoIraishoTargetPersons;
    @JsonProperty("SearchButtonsForShujiiIkenshoIraishoTargetPersons")
    private SearchButtonsForShujiiIkenshoIraishoTargetPersonsDiv SearchButtonsForShujiiIkenshoIraishoTargetPersons;
    @JsonProperty("dgShujiiIkenshoIraishoTargetPersons")
    private DataGrid<dgShujiiIkenshoIraishoTargetPersons_Row> dgShujiiIkenshoIraishoTargetPersons;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SerachCriteriaForShujiiIkenshoIraishoTargetPersons")
    public SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv getSerachCriteriaForShujiiIkenshoIraishoTargetPersons() {
        return SerachCriteriaForShujiiIkenshoIraishoTargetPersons;
    }

    @JsonProperty("SerachCriteriaForShujiiIkenshoIraishoTargetPersons")
    public void setSerachCriteriaForShujiiIkenshoIraishoTargetPersons(SerachCriteriaForShujiiIkenshoIraishoTargetPersonsDiv SerachCriteriaForShujiiIkenshoIraishoTargetPersons) {
        this.SerachCriteriaForShujiiIkenshoIraishoTargetPersons=SerachCriteriaForShujiiIkenshoIraishoTargetPersons;
    }

    @JsonProperty("SearchButtonsForShujiiIkenshoIraishoTargetPersons")
    public SearchButtonsForShujiiIkenshoIraishoTargetPersonsDiv getSearchButtonsForShujiiIkenshoIraishoTargetPersons() {
        return SearchButtonsForShujiiIkenshoIraishoTargetPersons;
    }

    @JsonProperty("SearchButtonsForShujiiIkenshoIraishoTargetPersons")
    public void setSearchButtonsForShujiiIkenshoIraishoTargetPersons(SearchButtonsForShujiiIkenshoIraishoTargetPersonsDiv SearchButtonsForShujiiIkenshoIraishoTargetPersons) {
        this.SearchButtonsForShujiiIkenshoIraishoTargetPersons=SearchButtonsForShujiiIkenshoIraishoTargetPersons;
    }

    @JsonProperty("dgShujiiIkenshoIraishoTargetPersons")
    public DataGrid<dgShujiiIkenshoIraishoTargetPersons_Row> getDgShujiiIkenshoIraishoTargetPersons() {
        return dgShujiiIkenshoIraishoTargetPersons;
    }

    @JsonProperty("dgShujiiIkenshoIraishoTargetPersons")
    public void setDgShujiiIkenshoIraishoTargetPersons(DataGrid<dgShujiiIkenshoIraishoTargetPersons_Row> dgShujiiIkenshoIraishoTargetPersons) {
        this.dgShujiiIkenshoIraishoTargetPersons=dgShujiiIkenshoIraishoTargetPersons;
    }

}
