package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.dbe4070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.dbe4070001.SearchCriteriaForShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.dbe4070001.ShinsakaiListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiSearch のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiSearchDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchCriteriaForShinsakai")
    private SearchCriteriaForShinsakaiDiv SearchCriteriaForShinsakai;
    @JsonProperty("ShinsakaiList")
    private ShinsakaiListDiv ShinsakaiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchCriteriaForShinsakai")
    public SearchCriteriaForShinsakaiDiv getSearchCriteriaForShinsakai() {
        return SearchCriteriaForShinsakai;
    }

    @JsonProperty("SearchCriteriaForShinsakai")
    public void setSearchCriteriaForShinsakai(SearchCriteriaForShinsakaiDiv SearchCriteriaForShinsakai) {
        this.SearchCriteriaForShinsakai=SearchCriteriaForShinsakai;
    }

    @JsonProperty("ShinsakaiList")
    public ShinsakaiListDiv getShinsakaiList() {
        return ShinsakaiList;
    }

    @JsonProperty("ShinsakaiList")
    public void setShinsakaiList(ShinsakaiListDiv ShinsakaiList) {
        this.ShinsakaiList=ShinsakaiList;
    }

}
