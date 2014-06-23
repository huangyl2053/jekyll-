package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.LatestPublicationDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.PublicationTargetShinsakaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.PublishingCondition1Div;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe4070001.PublishingCondition2Div;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiShiryoPublication のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiShiryoPublicationDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PublicationTargetShinsakai")
    private PublicationTargetShinsakaiDiv PublicationTargetShinsakai;
    @JsonProperty("LatestPublication")
    private LatestPublicationDiv LatestPublication;
    @JsonProperty("PublishingCondition1")
    private PublishingCondition1Div PublishingCondition1;
    @JsonProperty("PublishingCondition2")
    private PublishingCondition2Div PublishingCondition2;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("PublicationTargetShinsakai")
    public PublicationTargetShinsakaiDiv getPublicationTargetShinsakai() {
        return PublicationTargetShinsakai;
    }

    @JsonProperty("PublicationTargetShinsakai")
    public void setPublicationTargetShinsakai(PublicationTargetShinsakaiDiv PublicationTargetShinsakai) {
        this.PublicationTargetShinsakai=PublicationTargetShinsakai;
    }

    @JsonProperty("LatestPublication")
    public LatestPublicationDiv getLatestPublication() {
        return LatestPublication;
    }

    @JsonProperty("LatestPublication")
    public void setLatestPublication(LatestPublicationDiv LatestPublication) {
        this.LatestPublication=LatestPublication;
    }

    @JsonProperty("PublishingCondition1")
    public PublishingCondition1Div getPublishingCondition1() {
        return PublishingCondition1;
    }

    @JsonProperty("PublishingCondition1")
    public void setPublishingCondition1(PublishingCondition1Div PublishingCondition1) {
        this.PublishingCondition1=PublishingCondition1;
    }

    @JsonProperty("PublishingCondition2")
    public PublishingCondition2Div getPublishingCondition2() {
        return PublishingCondition2;
    }

    @JsonProperty("PublishingCondition2")
    public void setPublishingCondition2(PublishingCondition2Div PublishingCondition2) {
        this.PublishingCondition2=PublishingCondition2;
    }

}
