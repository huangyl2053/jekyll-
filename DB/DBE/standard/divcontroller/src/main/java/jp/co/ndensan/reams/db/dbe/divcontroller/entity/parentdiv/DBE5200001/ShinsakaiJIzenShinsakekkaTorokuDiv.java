package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE5200001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShinsakaiJIzenShinsakekkaToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShinsakaiJIzenShinsakekkaTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JizenShinsakaiShiryoPublication")
    private JizenShinsakaiShiryoPublicationDiv JizenShinsakaiShiryoPublication;
    @JsonProperty("PublicationResult")
    private PublicationResultDiv PublicationResult;
    @JsonProperty("serviceType")
    private RString serviceType;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getJizenShinsakaiShiryoPublication
     * @return JizenShinsakaiShiryoPublication
     */
    @JsonProperty("JizenShinsakaiShiryoPublication")
    public JizenShinsakaiShiryoPublicationDiv getJizenShinsakaiShiryoPublication() {
        return JizenShinsakaiShiryoPublication;
    }

    /*
     * setJizenShinsakaiShiryoPublication
     * @param JizenShinsakaiShiryoPublication JizenShinsakaiShiryoPublication
     */
    @JsonProperty("JizenShinsakaiShiryoPublication")
    public void setJizenShinsakaiShiryoPublication(JizenShinsakaiShiryoPublicationDiv JizenShinsakaiShiryoPublication) {
        this.JizenShinsakaiShiryoPublication = JizenShinsakaiShiryoPublication;
    }

    /*
     * getPublicationResult
     * @return PublicationResult
     */
    @JsonProperty("PublicationResult")
    public PublicationResultDiv getPublicationResult() {
        return PublicationResult;
    }

    /*
     * setPublicationResult
     * @param PublicationResult PublicationResult
     */
    @JsonProperty("PublicationResult")
    public void setPublicationResult(PublicationResultDiv PublicationResult) {
        this.PublicationResult = PublicationResult;
    }

    /*
     * getserviceType
     * @return serviceType
     */
    @JsonProperty("serviceType")
    public RString getServiceType() {
        return serviceType;
    }

    /*
     * setserviceType
     * @param serviceType serviceType
     */
    @JsonProperty("serviceType")
    public void setServiceType(RString serviceType) {
        this.serviceType = serviceType;
    }

    // </editor-fold>
}
