package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0020031;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YoshikiIchinoniIchinosanHosei のクラスファイル
 *
 * @reamsid_L DBU-1100-030 wangkanglei
 */
public class YoshikiIchinoniIchinosanHoseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("PanelHead")
    private PanelHeadDiv PanelHead;
    @JsonProperty("PanelDaisan")
    private PanelDaisanDiv PanelDaisan;
    @JsonProperty("PanelDaiyon")
    private PanelDaiyonDiv PanelDaiyon;
    @JsonProperty("PanelDaigo")
    private PanelDaigoDiv PanelDaigo;
    @JsonProperty("KanryoMessage")
    private KanryoMessageDiv KanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getPanelHead
     * @return PanelHead
     */
    @JsonProperty("PanelHead")
    public PanelHeadDiv getPanelHead() {
        return PanelHead;
    }

    /*
     * setPanelHead
     * @param PanelHead PanelHead
     */
    @JsonProperty("PanelHead")
    public void setPanelHead(PanelHeadDiv PanelHead) {
        this.PanelHead = PanelHead;
    }

    /*
     * getPanelDaisan
     * @return PanelDaisan
     */
    @JsonProperty("PanelDaisan")
    public PanelDaisanDiv getPanelDaisan() {
        return PanelDaisan;
    }

    /*
     * setPanelDaisan
     * @param PanelDaisan PanelDaisan
     */
    @JsonProperty("PanelDaisan")
    public void setPanelDaisan(PanelDaisanDiv PanelDaisan) {
        this.PanelDaisan = PanelDaisan;
    }

    /*
     * getPanelDaiyon
     * @return PanelDaiyon
     */
    @JsonProperty("PanelDaiyon")
    public PanelDaiyonDiv getPanelDaiyon() {
        return PanelDaiyon;
    }

    /*
     * setPanelDaiyon
     * @param PanelDaiyon PanelDaiyon
     */
    @JsonProperty("PanelDaiyon")
    public void setPanelDaiyon(PanelDaiyonDiv PanelDaiyon) {
        this.PanelDaiyon = PanelDaiyon;
    }

    /*
     * getPanelDaigo
     * @return PanelDaigo
     */
    @JsonProperty("PanelDaigo")
    public PanelDaigoDiv getPanelDaigo() {
        return PanelDaigo;
    }

    /*
     * setPanelDaigo
     * @param PanelDaigo PanelDaigo
     */
    @JsonProperty("PanelDaigo")
    public void setPanelDaigo(PanelDaigoDiv PanelDaigo) {
        this.PanelDaigo = PanelDaigo;
    }

    /*
     * getKanryoMessage
     * @return KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public KanryoMessageDiv getKanryoMessage() {
        return KanryoMessage;
    }

    /*
     * setKanryoMessage
     * @param KanryoMessage KanryoMessage
     */
    @JsonProperty("KanryoMessage")
    public void setKanryoMessage(KanryoMessageDiv KanryoMessage) {
        this.KanryoMessage = KanryoMessage;
    }

    // </editor-fold>
}
