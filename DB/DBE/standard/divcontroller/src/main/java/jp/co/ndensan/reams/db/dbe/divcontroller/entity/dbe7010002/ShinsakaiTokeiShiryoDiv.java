package jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe7010002;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe7010002.ExtractedTermDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe7010002.PublishButtonDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.dbe7010002.ShinsakaiTokeiPublishedTargetDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiTokeiShiryo のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiTokeiShiryoDiv extends Panel {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShinsakaiTokeiPublishedTarget")
    private ShinsakaiTokeiPublishedTargetDiv ShinsakaiTokeiPublishedTarget;
    @JsonProperty("ExtractedTerm")
    private ExtractedTermDiv ExtractedTerm;
    @JsonProperty("PublishButton")
    private PublishButtonDiv PublishButton;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ShinsakaiTokeiPublishedTarget")
    public ShinsakaiTokeiPublishedTargetDiv getShinsakaiTokeiPublishedTarget() {
        return ShinsakaiTokeiPublishedTarget;
    }

    @JsonProperty("ShinsakaiTokeiPublishedTarget")
    public void setShinsakaiTokeiPublishedTarget(ShinsakaiTokeiPublishedTargetDiv ShinsakaiTokeiPublishedTarget) {
        this.ShinsakaiTokeiPublishedTarget=ShinsakaiTokeiPublishedTarget;
    }

    @JsonProperty("ExtractedTerm")
    public ExtractedTermDiv getExtractedTerm() {
        return ExtractedTerm;
    }

    @JsonProperty("ExtractedTerm")
    public void setExtractedTerm(ExtractedTermDiv ExtractedTerm) {
        this.ExtractedTerm=ExtractedTerm;
    }

    @JsonProperty("PublishButton")
    public PublishButtonDiv getPublishButton() {
        return PublishButton;
    }

    @JsonProperty("PublishButton")
    public void setPublishButton(PublishButtonDiv PublishButton) {
        this.PublishButton=PublishButton;
    }

}
