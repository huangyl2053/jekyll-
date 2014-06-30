package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.PublishingConditionForJimukyoku1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.PublishingConditionForShinsakaiIin1Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * PublishingCondition1 のクラスファイル 
 * 
 * @author 自動生成
 */
public class PublishingCondition1Div extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnToMask")
    private Button btnToMask;
    @JsonProperty("btnToChangeCondition2")
    private Button btnToChangeCondition2;
    @JsonProperty("PublishingConditionForJimukyoku1")
    private PublishingConditionForJimukyoku1Div PublishingConditionForJimukyoku1;
    @JsonProperty("PublishingConditionForShinsakaiIin1")
    private PublishingConditionForShinsakaiIin1Div PublishingConditionForShinsakaiIin1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnToMask")
    public Button getBtnToMask() {
        return btnToMask;
    }

    @JsonProperty("btnToMask")
    public void setBtnToMask(Button btnToMask) {
        this.btnToMask=btnToMask;
    }

    @JsonProperty("btnToChangeCondition2")
    public Button getBtnToChangeCondition2() {
        return btnToChangeCondition2;
    }

    @JsonProperty("btnToChangeCondition2")
    public void setBtnToChangeCondition2(Button btnToChangeCondition2) {
        this.btnToChangeCondition2=btnToChangeCondition2;
    }

    @JsonProperty("PublishingConditionForJimukyoku1")
    public PublishingConditionForJimukyoku1Div getPublishingConditionForJimukyoku1() {
        return PublishingConditionForJimukyoku1;
    }

    @JsonProperty("PublishingConditionForJimukyoku1")
    public void setPublishingConditionForJimukyoku1(PublishingConditionForJimukyoku1Div PublishingConditionForJimukyoku1) {
        this.PublishingConditionForJimukyoku1=PublishingConditionForJimukyoku1;
    }

    @JsonProperty("PublishingConditionForShinsakaiIin1")
    public PublishingConditionForShinsakaiIin1Div getPublishingConditionForShinsakaiIin1() {
        return PublishingConditionForShinsakaiIin1;
    }

    @JsonProperty("PublishingConditionForShinsakaiIin1")
    public void setPublishingConditionForShinsakaiIin1(PublishingConditionForShinsakaiIin1Div PublishingConditionForShinsakaiIin1) {
        this.PublishingConditionForShinsakaiIin1=PublishingConditionForShinsakaiIin1;
    }

}
