package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4070001.PublishingConditionForJimukyoku2Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE4070001.PublishingConditionForShinsakaiIin2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PublishingCondition2 のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublishingCondition2Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PublishingConditionForJimukyoku2")
    private PublishingConditionForJimukyoku2Div PublishingConditionForJimukyoku2;
    @JsonProperty("PublishingConditionForShinsakaiIin2")
    private PublishingConditionForShinsakaiIin2Div PublishingConditionForShinsakaiIin2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("PublishingConditionForJimukyoku2")
    public PublishingConditionForJimukyoku2Div getPublishingConditionForJimukyoku2() {
        return PublishingConditionForJimukyoku2;
    }

    @JsonProperty("PublishingConditionForJimukyoku2")
    public void setPublishingConditionForJimukyoku2(PublishingConditionForJimukyoku2Div PublishingConditionForJimukyoku2) {
        this.PublishingConditionForJimukyoku2=PublishingConditionForJimukyoku2;
    }

    @JsonProperty("PublishingConditionForShinsakaiIin2")
    public PublishingConditionForShinsakaiIin2Div getPublishingConditionForShinsakaiIin2() {
        return PublishingConditionForShinsakaiIin2;
    }

    @JsonProperty("PublishingConditionForShinsakaiIin2")
    public void setPublishingConditionForShinsakaiIin2(PublishingConditionForShinsakaiIin2Div PublishingConditionForShinsakaiIin2) {
        this.PublishingConditionForShinsakaiIin2=PublishingConditionForShinsakaiIin2;
    }

}
