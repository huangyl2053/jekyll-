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
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuchoTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoTaishoshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokuchoTaishoshaIchiranBatchParameter")
    private TokuchoTaishoshaIchiranBatchParameterDiv TokuchoTaishoshaIchiranBatchParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokuchoTaishoshaIchiranBatchParameter
     * @return TokuchoTaishoshaIchiranBatchParameter
     */
    @JsonProperty("TokuchoTaishoshaIchiranBatchParameter")
    public TokuchoTaishoshaIchiranBatchParameterDiv getTokuchoTaishoshaIchiranBatchParameter() {
        return TokuchoTaishoshaIchiranBatchParameter;
    }

    /*
     * setTokuchoTaishoshaIchiranBatchParameter
     * @param TokuchoTaishoshaIchiranBatchParameter TokuchoTaishoshaIchiranBatchParameter
     */
    @JsonProperty("TokuchoTaishoshaIchiranBatchParameter")
    public void setTokuchoTaishoshaIchiranBatchParameter(TokuchoTaishoshaIchiranBatchParameterDiv TokuchoTaishoshaIchiranBatchParameter) {
        this.TokuchoTaishoshaIchiranBatchParameter = TokuchoTaishoshaIchiranBatchParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KonkaiShorinaiyoPanelDiv getKonkaiShorinaiyoPanel() {
        return this.getTokuchoTaishoshaIchiranBatchParameter().getKonkaiShorinaiyoPanel();
    }

    @JsonIgnore
    public void  setKonkaiShorinaiyoPanel(KonkaiShorinaiyoPanelDiv KonkaiShorinaiyoPanel) {
        this.getTokuchoTaishoshaIchiranBatchParameter().setKonkaiShorinaiyoPanel(KonkaiShorinaiyoPanel);
    }

    @JsonIgnore
    public TextBox getTxtTokuchoGimusha() {
        return this.getTokuchoTaishoshaIchiranBatchParameter().getKonkaiShorinaiyoPanel().getTxtTokuchoGimusha();
    }

    @JsonIgnore
    public void  setTxtTokuchoGimusha(TextBox txtTokuchoGimusha) {
        this.getTokuchoTaishoshaIchiranBatchParameter().getKonkaiShorinaiyoPanel().setTxtTokuchoGimusha(txtTokuchoGimusha);
    }

    @JsonIgnore
    public ShutsuryokuTaishoPanelDiv getShutsuryokuTaishoPanel() {
        return this.getTokuchoTaishoshaIchiranBatchParameter().getShutsuryokuTaishoPanel();
    }

    @JsonIgnore
    public void  setShutsuryokuTaishoPanel(ShutsuryokuTaishoPanelDiv ShutsuryokuTaishoPanel) {
        this.getTokuchoTaishoshaIchiranBatchParameter().setShutsuryokuTaishoPanel(ShutsuryokuTaishoPanel);
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuTaisho() {
        return this.getTokuchoTaishoshaIchiranBatchParameter().getShutsuryokuTaishoPanel().getChkShutsuryokuTaisho();
    }

    @JsonIgnore
    public void  setChkShutsuryokuTaisho(CheckBoxList chkShutsuryokuTaisho) {
        this.getTokuchoTaishoshaIchiranBatchParameter().getShutsuryokuTaishoPanel().setChkShutsuryokuTaisho(chkShutsuryokuTaisho);
    }

    @JsonIgnore
    public IOutputChohyoIchiranDiv getCcdOutputChohyoIchiran() {
        return this.getTokuchoTaishoshaIchiranBatchParameter().getCcdOutputChohyoIchiran();
    }

    // </editor-fold>
}
