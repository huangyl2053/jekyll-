package jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.ButtonsForHihokenshaFinderDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoSaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoSaikinShorishaRirekiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaDetailDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHokenshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfKojinDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HihokenshaFinder のクラスファイル 
 * 
 * @author 自動生成
 */
public class HihokenshaFinderDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SearchCriteriaOfHokensha")
    private SearchCriteriaOfHokenshaDiv SearchCriteriaOfHokensha;
    @JsonProperty("SearchCriteriaOfHihokensha")
    private SearchCriteriaOfHihokenshaDiv SearchCriteriaOfHihokensha;
    @JsonProperty("SearchCriteriaOfKojin")
    private SearchCriteriaOfKojinDiv SearchCriteriaOfKojin;
    @JsonProperty("SearchCriteriaDetail")
    private SearchCriteriaDetailDiv SearchCriteriaDetail;
    @JsonProperty("ButtonsForHihokenshaFinder")
    private ButtonsForHihokenshaFinderDiv ButtonsForHihokenshaFinder;
    @JsonProperty("saikinShorisha")
    private KaigoSaikinShorishaRirekiDiv saikinShorisha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("SearchCriteriaOfHokensha")
    public SearchCriteriaOfHokenshaDiv getSearchCriteriaOfHokensha() {
        return SearchCriteriaOfHokensha;
    }

    @JsonProperty("SearchCriteriaOfHokensha")
    public void setSearchCriteriaOfHokensha(SearchCriteriaOfHokenshaDiv SearchCriteriaOfHokensha) {
        this.SearchCriteriaOfHokensha=SearchCriteriaOfHokensha;
    }

    @JsonProperty("SearchCriteriaOfHihokensha")
    public SearchCriteriaOfHihokenshaDiv getSearchCriteriaOfHihokensha() {
        return SearchCriteriaOfHihokensha;
    }

    @JsonProperty("SearchCriteriaOfHihokensha")
    public void setSearchCriteriaOfHihokensha(SearchCriteriaOfHihokenshaDiv SearchCriteriaOfHihokensha) {
        this.SearchCriteriaOfHihokensha=SearchCriteriaOfHihokensha;
    }

    @JsonProperty("SearchCriteriaOfKojin")
    public SearchCriteriaOfKojinDiv getSearchCriteriaOfKojin() {
        return SearchCriteriaOfKojin;
    }

    @JsonProperty("SearchCriteriaOfKojin")
    public void setSearchCriteriaOfKojin(SearchCriteriaOfKojinDiv SearchCriteriaOfKojin) {
        this.SearchCriteriaOfKojin=SearchCriteriaOfKojin;
    }

    @JsonProperty("SearchCriteriaDetail")
    public SearchCriteriaDetailDiv getSearchCriteriaDetail() {
        return SearchCriteriaDetail;
    }

    @JsonProperty("SearchCriteriaDetail")
    public void setSearchCriteriaDetail(SearchCriteriaDetailDiv SearchCriteriaDetail) {
        this.SearchCriteriaDetail=SearchCriteriaDetail;
    }

    @JsonProperty("ButtonsForHihokenshaFinder")
    public ButtonsForHihokenshaFinderDiv getButtonsForHihokenshaFinder() {
        return ButtonsForHihokenshaFinder;
    }

    @JsonProperty("ButtonsForHihokenshaFinder")
    public void setButtonsForHihokenshaFinder(ButtonsForHihokenshaFinderDiv ButtonsForHihokenshaFinder) {
        this.ButtonsForHihokenshaFinder=ButtonsForHihokenshaFinder;
    }

    @JsonProperty("saikinShorisha")
    public KaigoSaikinShorishaRirekiDiv getSaikinShorisha() {
        return saikinShorisha;
    }

    @JsonProperty("saikinShorisha")
    public void setSaikinShorisha(KaigoSaikinShorishaRirekiDiv saikinShorisha) {
        this.saikinShorisha=saikinShorisha;
    }

}
