package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0440011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList.IKogakuKyufuTaishoListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList.IKogakuShinseiListDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList.KogakuShinseiListDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * 画面設計_DBCMN42001_高額サービス費支給申請登録
 *
 * @reamsid_L DBC-2020-040 quxiaodong
 */
public class KogakuSabisuhiShikyuShinseiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKogakuKyufuTaishoListDiv getCcdKogakuKyufuTaishoList() {
        return this.getKogakuKyufuTaishoListPanel().getCcdKogakuKyufuTaishoList();
    }

    // </editor-fold>
}
