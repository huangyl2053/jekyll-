package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.IKogakuKyufuTaishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.KogakuKyufuTaishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList.IKogakuShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList.KogakuShinseiListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuSabisuhiShikyuShinseiPanel のクラスファイル 
 * 
 * @reamsid_L DBC-2020-040 quxiaodong
 */
public class KogakuSabisuhiShikyuShinseiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("CommonPanel")
    private CommonPanelDiv CommonPanel;
    @JsonProperty("ShinseiTorokuPanel")
    private ShinseiTorokuPanelDiv ShinseiTorokuPanel;
    @JsonProperty("KogakuKyufuTaishoListPanel")
    private KogakuKyufuTaishoListPanelDiv KogakuKyufuTaishoListPanel;
    @JsonProperty("ccdKogakuShinseiList")
    private KogakuShinseiListDiv ccdKogakuShinseiList;
    @JsonProperty("ccdKaigoKanryoMessage")
    private KaigoKanryoMessageDiv ccdKaigoKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getCommonPanel
     * @return CommonPanel
     */
    @JsonProperty("CommonPanel")
    public CommonPanelDiv getCommonPanel() {
        return CommonPanel;
    }

    /*
     * setCommonPanel
     * @param CommonPanel CommonPanel
     */
    @JsonProperty("CommonPanel")
    public void setCommonPanel(CommonPanelDiv CommonPanel) {
        this.CommonPanel = CommonPanel;
    }

    /*
     * getShinseiTorokuPanel
     * @return ShinseiTorokuPanel
     */
    @JsonProperty("ShinseiTorokuPanel")
    public ShinseiTorokuPanelDiv getShinseiTorokuPanel() {
        return ShinseiTorokuPanel;
    }

    /*
     * setShinseiTorokuPanel
     * @param ShinseiTorokuPanel ShinseiTorokuPanel
     */
    @JsonProperty("ShinseiTorokuPanel")
    public void setShinseiTorokuPanel(ShinseiTorokuPanelDiv ShinseiTorokuPanel) {
        this.ShinseiTorokuPanel = ShinseiTorokuPanel;
    }

    /*
     * getKogakuKyufuTaishoListPanel
     * @return KogakuKyufuTaishoListPanel
     */
    @JsonProperty("KogakuKyufuTaishoListPanel")
    public KogakuKyufuTaishoListPanelDiv getKogakuKyufuTaishoListPanel() {
        return KogakuKyufuTaishoListPanel;
    }

    /*
     * setKogakuKyufuTaishoListPanel
     * @param KogakuKyufuTaishoListPanel KogakuKyufuTaishoListPanel
     */
    @JsonProperty("KogakuKyufuTaishoListPanel")
    public void setKogakuKyufuTaishoListPanel(KogakuKyufuTaishoListPanelDiv KogakuKyufuTaishoListPanel) {
        this.KogakuKyufuTaishoListPanel = KogakuKyufuTaishoListPanel;
    }

    /*
     * getccdKogakuShinseiList
     * @return ccdKogakuShinseiList
     */
    @JsonProperty("ccdKogakuShinseiList")
    public IKogakuShinseiListDiv getCcdKogakuShinseiList() {
        return ccdKogakuShinseiList;
    }

    /*
     * getccdKaigoKanryoMessage
     * @return ccdKaigoKanryoMessage
     */
    @JsonProperty("ccdKaigoKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return ccdKaigoKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSetaiShotokuIchiran() {
        return this.getShinseiTorokuPanel().getSetaiJoho().getCcdSetaiShotokuIchiran();
    }

    @JsonIgnore
    public IKogakuKyufuTaishoListDiv getCcdKogakuKyufuTaishoList() {
        return this.getKogakuKyufuTaishoListPanel().getCcdKogakuKyufuTaishoList();
    }

    // </editor-fold>
}
