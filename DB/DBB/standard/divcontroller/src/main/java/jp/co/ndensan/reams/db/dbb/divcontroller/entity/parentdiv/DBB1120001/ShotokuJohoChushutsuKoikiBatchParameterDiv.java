package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * ShotokuJohoChushutsuKoikiBatchParameter のクラスファイル
 *
 * @reamsid_L DBB-1690-010 sunhui
 */
public class ShotokuJohoChushutsuKoikiBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShotokuJohoChushutsuKoikiPanel")
    private ShotokuJohoChushutsuKoikiPanelDiv ShotokuJohoChushutsuKoikiPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShotokuJohoChushutsuKoikiPanel
     * @return ShotokuJohoChushutsuKoikiPanel
     */
    @JsonProperty("ShotokuJohoChushutsuKoikiPanel")
    public ShotokuJohoChushutsuKoikiPanelDiv getShotokuJohoChushutsuKoikiPanel() {
        return ShotokuJohoChushutsuKoikiPanel;
    }

    /*
     * setShotokuJohoChushutsuKoikiPanel
     * @param ShotokuJohoChushutsuKoikiPanel ShotokuJohoChushutsuKoikiPanel
     */
    @JsonProperty("ShotokuJohoChushutsuKoikiPanel")
    public void setShotokuJohoChushutsuKoikiPanel(ShotokuJohoChushutsuKoikiPanelDiv ShotokuJohoChushutsuKoikiPanel) {
        this.ShotokuJohoChushutsuKoikiPanel = ShotokuJohoChushutsuKoikiPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShoriNendoKoiki() {
        return this.getShotokuJohoChushutsuKoikiPanel().getTxtShoriNendoKoiki();
    }

    @JsonIgnore
    public void setTxtShoriNendoKoiki(TextBoxDate txtShoriNendoKoiki) {
        this.getShotokuJohoChushutsuKoikiPanel().setTxtShoriNendoKoiki(txtShoriNendoKoiki);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getShotokuJohoChushutsuKoikiPanel().getLin1();
    }

    @JsonIgnore
    public void setLin1(HorizontalLine lin1) {
        this.getShotokuJohoChushutsuKoikiPanel().setLin1(lin1);
    }

    @JsonIgnore
    public DataGrid<dgShichosonIchiran_Row> getDgShichosonIchiran() {
        return this.getShotokuJohoChushutsuKoikiPanel().getDgShichosonIchiran();
    }

    @JsonIgnore
    public void setDgShichosonIchiran(DataGrid<dgShichosonIchiran_Row> dgShichosonIchiran) {
        this.getShotokuJohoChushutsuKoikiPanel().setDgShichosonIchiran(dgShichosonIchiran);
    }

    @JsonIgnore
    public ShotokuJohoIchiranKoikiDiv getShotokuJohoIchiranKoiki() {
        return this.getShotokuJohoChushutsuKoikiPanel().getShotokuJohoIchiranKoiki();
    }

    @JsonIgnore
    public void setShotokuJohoIchiranKoiki(ShotokuJohoIchiranKoikiDiv ShotokuJohoIchiranKoiki) {
        this.getShotokuJohoChushutsuKoikiPanel().setShotokuJohoIchiranKoiki(ShotokuJohoIchiranKoiki);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujunKoiki() {
        return this.getShotokuJohoChushutsuKoikiPanel().getShotokuJohoIchiranKoiki().getCcdChohyoShutsuryokujunKoiki();
    }

    // </editor-fold>
}
