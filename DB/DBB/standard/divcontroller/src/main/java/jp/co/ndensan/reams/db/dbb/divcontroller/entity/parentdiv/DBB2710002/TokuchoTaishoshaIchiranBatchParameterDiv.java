package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.IOutputChohyoIchiranDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.OutputChohyoIchiranDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;

/**
 * TokuchoTaishoshaIchiranBatchParameter のクラスファイル <br/>
 *
 * 画面設計_DBBGM81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-010 yangchenbing
 */
public class TokuchoTaishoshaIchiranBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KonkaiShorinaiyoPanel")
    private KonkaiShorinaiyoPanelDiv KonkaiShorinaiyoPanel;
    @JsonProperty("ShutsuryokuTaishoPanel")
    private ShutsuryokuTaishoPanelDiv ShutsuryokuTaishoPanel;
    @JsonProperty("ccdOutputChohyoIchiran")
    private OutputChohyoIchiranDiv ccdOutputChohyoIchiran;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKonkaiShorinaiyoPanel
     * @return KonkaiShorinaiyoPanel
     */
    @JsonProperty("KonkaiShorinaiyoPanel")
    public KonkaiShorinaiyoPanelDiv getKonkaiShorinaiyoPanel() {
        return KonkaiShorinaiyoPanel;
    }

    /*
     * setKonkaiShorinaiyoPanel
     * @param KonkaiShorinaiyoPanel KonkaiShorinaiyoPanel
     */
    @JsonProperty("KonkaiShorinaiyoPanel")
    public void setKonkaiShorinaiyoPanel(KonkaiShorinaiyoPanelDiv KonkaiShorinaiyoPanel) {
        this.KonkaiShorinaiyoPanel = KonkaiShorinaiyoPanel;
    }

    /*
     * getShutsuryokuTaishoPanel
     * @return ShutsuryokuTaishoPanel
     */
    @JsonProperty("ShutsuryokuTaishoPanel")
    public ShutsuryokuTaishoPanelDiv getShutsuryokuTaishoPanel() {
        return ShutsuryokuTaishoPanel;
    }

    /*
     * setShutsuryokuTaishoPanel
     * @param ShutsuryokuTaishoPanel ShutsuryokuTaishoPanel
     */
    @JsonProperty("ShutsuryokuTaishoPanel")
    public void setShutsuryokuTaishoPanel(ShutsuryokuTaishoPanelDiv ShutsuryokuTaishoPanel) {
        this.ShutsuryokuTaishoPanel = ShutsuryokuTaishoPanel;
    }

    /*
     * getccdOutputChohyoIchiran
     * @return ccdOutputChohyoIchiran
     */
    @JsonProperty("ccdOutputChohyoIchiran")
    public IOutputChohyoIchiranDiv getCcdOutputChohyoIchiran() {
        return ccdOutputChohyoIchiran;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtTokuchoGimusha() {
        return this.getKonkaiShorinaiyoPanel().getTxtTokuchoGimusha();
    }

    @JsonIgnore
    public void setTxtTokuchoGimusha(TextBox txtTokuchoGimusha) {
        this.getKonkaiShorinaiyoPanel().setTxtTokuchoGimusha(txtTokuchoGimusha);
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuTaisho() {
        return this.getShutsuryokuTaishoPanel().getChkShutsuryokuTaisho();
    }

    @JsonIgnore
    public void setChkShutsuryokuTaisho(CheckBoxList chkShutsuryokuTaisho) {
        this.getShutsuryokuTaishoPanel().setChkShutsuryokuTaisho(chkShutsuryokuTaisho);
    }

    // </editor-fold>
}
