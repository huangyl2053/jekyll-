package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0820013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.ShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KouzaInfoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KouzaInfoPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-16_12-38-19">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelOne")
    private panelOneDiv panelOne;
    @JsonProperty("panelTwo")
    private panelTwoDiv panelTwo;
    @JsonProperty("PnlCommon")
    private PnlCommonDiv PnlCommon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelOne
     * @return panelOne
     */
    @JsonProperty("panelOne")
    public panelOneDiv getPanelOne() {
        return panelOne;
    }

    /*
     * setpanelOne
     * @param panelOne panelOne
     */
    @JsonProperty("panelOne")
    public void setPanelOne(panelOneDiv panelOne) {
        this.panelOne = panelOne;
    }

    /*
     * getpanelTwo
     * @return panelTwo
     */
    @JsonProperty("panelTwo")
    public panelTwoDiv getPanelTwo() {
        return panelTwo;
    }

    /*
     * setpanelTwo
     * @param panelTwo panelTwo
     */
    @JsonProperty("panelTwo")
    public void setPanelTwo(panelTwoDiv panelTwo) {
        this.panelTwo = panelTwo;
    }

    /*
     * getPnlCommon
     * @return PnlCommon
     */
    @JsonProperty("PnlCommon")
    public PnlCommonDiv getPnlCommon() {
        return PnlCommon;
    }

    /*
     * setPnlCommon
     * @param PnlCommon PnlCommon
     */
    @JsonProperty("PnlCommon")
    public void setPnlCommon(PnlCommonDiv PnlCommon) {
        this.PnlCommon = PnlCommon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShinseiNaiyo() {
        return this.getPnlCommon().getCcdShinseiNaiyo();
    }

    // </editor-fold>
}
