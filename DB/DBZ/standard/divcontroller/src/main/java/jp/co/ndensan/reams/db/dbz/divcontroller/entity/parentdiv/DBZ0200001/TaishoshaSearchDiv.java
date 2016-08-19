package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.DBZ0200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaishoshaSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoshaSearchDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchCondition")
    private SearchConditionDiv SearchCondition;
    @JsonProperty("GaitoshaList")
    private GaitoshaListDiv GaitoshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSearchCondition
     * @return SearchCondition
     */
    @JsonProperty("SearchCondition")
    public SearchConditionDiv getSearchCondition() {
        return SearchCondition;
    }

    /*
     * setSearchCondition
     * @param SearchCondition SearchCondition
     */
    @JsonProperty("SearchCondition")
    public void setSearchCondition(SearchConditionDiv SearchCondition) {
        this.SearchCondition = SearchCondition;
    }

    /*
     * getGaitoshaList
     * @return GaitoshaList
     */
    @JsonProperty("GaitoshaList")
    public GaitoshaListDiv getGaitoshaList() {
        return GaitoshaList;
    }

    /*
     * setGaitoshaList
     * @param GaitoshaList GaitoshaList
     */
    @JsonProperty("GaitoshaList")
    public void setGaitoshaList(GaitoshaListDiv GaitoshaList) {
        this.GaitoshaList = GaitoshaList;
    }

    // </editor-fold>
}
