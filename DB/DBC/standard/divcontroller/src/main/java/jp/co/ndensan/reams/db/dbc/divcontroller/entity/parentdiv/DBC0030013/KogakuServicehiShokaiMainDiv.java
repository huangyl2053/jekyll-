package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0030013;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KogakuServicehiShokaiMain のクラスファイル
 *
 * @reamsid_L DBC-3000-040 gongliang
 */
public class KogakuServicehiShokaiMainDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SetaiInfo")
    private SetaiInfoDiv SetaiInfo;
    @JsonProperty("SetaiInfoPanel")
    private SetaiInfoPanelDiv SetaiInfoPanel;
    @JsonProperty("ShowResultTwo")
    private ShowResultTwoDiv ShowResultTwo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSetaiInfo
     * @return SetaiInfo
     */
    @JsonProperty("SetaiInfo")
    public SetaiInfoDiv getSetaiInfo() {
        return SetaiInfo;
    }

    /*
     * setSetaiInfo
     * @param SetaiInfo SetaiInfo
     */
    @JsonProperty("SetaiInfo")
    public void setSetaiInfo(SetaiInfoDiv SetaiInfo) {
        this.SetaiInfo = SetaiInfo;
    }

    /*
     * getSetaiInfoPanel
     * @return SetaiInfoPanel
     */
    @JsonProperty("SetaiInfoPanel")
    public SetaiInfoPanelDiv getSetaiInfoPanel() {
        return SetaiInfoPanel;
    }

    /*
     * setSetaiInfoPanel
     * @param SetaiInfoPanel SetaiInfoPanel
     */
    @JsonProperty("SetaiInfoPanel")
    public void setSetaiInfoPanel(SetaiInfoPanelDiv SetaiInfoPanel) {
        this.SetaiInfoPanel = SetaiInfoPanel;
    }

    /*
     * getShowResultTwo
     * @return ShowResultTwo
     */
    @JsonProperty("ShowResultTwo")
    public ShowResultTwoDiv getShowResultTwo() {
        return ShowResultTwo;
    }

    /*
     * setShowResultTwo
     * @param ShowResultTwo ShowResultTwo
     */
    @JsonProperty("ShowResultTwo")
    public void setShowResultTwo(ShowResultTwoDiv ShowResultTwo) {
        this.ShowResultTwo = ShowResultTwo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSetaiShotokuIchiran() {
        return this.getSetaiInfoPanel().getCcdSetaiShotokuIchiran();
    }

    @JsonIgnore
    public HanteiKekkaLDiv getHanteiKekkaL() {
        return this.getShowResultTwo().getSetaiinL().getHanteiKekkaL();
    }

    @JsonIgnore
    public void setHanteiKekkaL(HanteiKekkaLDiv HanteiKekkaL) {
        this.getShowResultTwo().getSetaiinL().setHanteiKekkaL(HanteiKekkaL);
    }

    @JsonIgnore
    public HanteiKekkaRDiv getHanteiKekkaR() {
        return this.getShowResultTwo().getSetaiinR().getHanteiKekkaR();
    }

    @JsonIgnore
    public void setHanteiKekkaR(HanteiKekkaRDiv HanteiKekkaR) {
        this.getShowResultTwo().getSetaiinR().setHanteiKekkaR(HanteiKekkaR);
    }

    // </editor-fold>
}
