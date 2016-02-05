package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * PnlTotal のクラスファイル 
 * 
 * @author 自動生成
 */
public class PnlTotalDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KaigoCommonPanel")
    private KaigoCommonPanelDiv KaigoCommonPanel;
    @JsonProperty("YoguKonyuhiShikyuShinseiList")
    private YoguKonyuhiShikyuShinseiListDiv YoguKonyuhiShikyuShinseiList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKaigoCommonPanel
     * @return KaigoCommonPanel
     */
    @JsonProperty("KaigoCommonPanel")
    public KaigoCommonPanelDiv getKaigoCommonPanel() {
        return KaigoCommonPanel;
    }

    /*
     * setKaigoCommonPanel
     * @param KaigoCommonPanel KaigoCommonPanel
     */
    @JsonProperty("KaigoCommonPanel")
    public void setKaigoCommonPanel(KaigoCommonPanelDiv KaigoCommonPanel) {
        this.KaigoCommonPanel = KaigoCommonPanel;
    }

    /*
     * getYoguKonyuhiShikyuShinseiList
     * @return YoguKonyuhiShikyuShinseiList
     */
    @JsonProperty("YoguKonyuhiShikyuShinseiList")
    public YoguKonyuhiShikyuShinseiListDiv getYoguKonyuhiShikyuShinseiList() {
        return YoguKonyuhiShikyuShinseiList;
    }

    /*
     * setYoguKonyuhiShikyuShinseiList
     * @param YoguKonyuhiShikyuShinseiList YoguKonyuhiShikyuShinseiList
     */
    @JsonProperty("YoguKonyuhiShikyuShinseiList")
    public void setYoguKonyuhiShikyuShinseiList(YoguKonyuhiShikyuShinseiListDiv YoguKonyuhiShikyuShinseiList) {
        this.YoguKonyuhiShikyuShinseiList = YoguKonyuhiShikyuShinseiList;
    }

    // </editor-fold>
}
