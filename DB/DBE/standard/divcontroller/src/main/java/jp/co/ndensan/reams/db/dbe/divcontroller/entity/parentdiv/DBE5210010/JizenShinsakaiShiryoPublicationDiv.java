package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5210010;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JizenShinsakaiShiryoPublication のクラスファイル 
 * 
 * @author 自動生成
 */
public class JizenShinsakaiShiryoPublicationDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PublicationTargetShinsakai")
    private PublicationTargetShinsakaiDiv PublicationTargetShinsakai;
    @JsonProperty("PublishingCondition")
    private PublishingConditionDiv PublishingCondition;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPublicationTargetShinsakai
     * @return PublicationTargetShinsakai
     */
    @JsonProperty("PublicationTargetShinsakai")
    public PublicationTargetShinsakaiDiv getPublicationTargetShinsakai() {
        return PublicationTargetShinsakai;
    }

    /*
     * setPublicationTargetShinsakai
     * @param PublicationTargetShinsakai PublicationTargetShinsakai
     */
    @JsonProperty("PublicationTargetShinsakai")
    public void setPublicationTargetShinsakai(PublicationTargetShinsakaiDiv PublicationTargetShinsakai) {
        this.PublicationTargetShinsakai = PublicationTargetShinsakai;
    }

    /*
     * getPublishingCondition
     * @return PublishingCondition
     */
    @JsonProperty("PublishingCondition")
    public PublishingConditionDiv getPublishingCondition() {
        return PublishingCondition;
    }

    /*
     * setPublishingCondition
     * @param PublishingCondition PublishingCondition
     */
    @JsonProperty("PublishingCondition")
    public void setPublishingCondition(PublishingConditionDiv PublishingCondition) {
        this.PublishingCondition = PublishingCondition;
    }

    // </editor-fold>
}
