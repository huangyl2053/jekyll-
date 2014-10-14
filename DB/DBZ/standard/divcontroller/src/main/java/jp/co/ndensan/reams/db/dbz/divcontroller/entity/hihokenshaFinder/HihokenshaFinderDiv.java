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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.hihokenshaFinder.SearchCriteriaOfHihokenshaDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.AtenaFinderDiv;
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
    @JsonProperty("SearchCriteriaOfHihokensha")
    private SearchCriteriaOfHihokenshaDiv SearchCriteriaOfHihokensha;
    @JsonProperty("KaigoAtenaFinder")
    private AtenaFinderDiv KaigoAtenaFinder;
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
    @JsonProperty("SearchCriteriaOfHihokensha")
    public SearchCriteriaOfHihokenshaDiv getSearchCriteriaOfHihokensha() {
        return SearchCriteriaOfHihokensha;
    }

    @JsonProperty("SearchCriteriaOfHihokensha")
    public void setSearchCriteriaOfHihokensha(SearchCriteriaOfHihokenshaDiv SearchCriteriaOfHihokensha) {
        this.SearchCriteriaOfHihokensha=SearchCriteriaOfHihokensha;
    }

    @JsonProperty("KaigoAtenaFinder")
    public AtenaFinderDiv getKaigoAtenaFinder() {
        return KaigoAtenaFinder;
    }

    @JsonProperty("KaigoAtenaFinder")
    public void setKaigoAtenaFinder(AtenaFinderDiv KaigoAtenaFinder) {
        this.KaigoAtenaFinder=KaigoAtenaFinder;
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
