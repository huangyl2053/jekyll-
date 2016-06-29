package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.UploadPanel;

/**
 * ShotokuJohoChushutsuTanitsuTashaBatchParameter のクラスファイル
 *
 * @reamsid_L DBB-1690-030 sunhui
 */
public class ShotokuJohoChushutsuTanitsuTashaBatchParameterDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShotokuJohoChushutsuTanitsuTashaPanel")
    private ShotokuJohoChushutsuTanitsuTashaPanelDiv ShotokuJohoChushutsuTanitsuTashaPanel;
    @JsonProperty("hiddenResult")
    private RString hiddenResult;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShotokuJohoChushutsuTanitsuTashaPanel
     * @return ShotokuJohoChushutsuTanitsuTashaPanel
     */
    @JsonProperty("ShotokuJohoChushutsuTanitsuTashaPanel")
    public ShotokuJohoChushutsuTanitsuTashaPanelDiv getShotokuJohoChushutsuTanitsuTashaPanel() {
        return ShotokuJohoChushutsuTanitsuTashaPanel;
    }

    /*
     * setShotokuJohoChushutsuTanitsuTashaPanel
     * @param ShotokuJohoChushutsuTanitsuTashaPanel ShotokuJohoChushutsuTanitsuTashaPanel
     */
    @JsonProperty("ShotokuJohoChushutsuTanitsuTashaPanel")
    public void setShotokuJohoChushutsuTanitsuTashaPanel(ShotokuJohoChushutsuTanitsuTashaPanelDiv ShotokuJohoChushutsuTanitsuTashaPanel) {
        this.ShotokuJohoChushutsuTanitsuTashaPanel = ShotokuJohoChushutsuTanitsuTashaPanel;
    }

    /*
     * gethiddenResult
     * @return hiddenResult
     */
    @JsonProperty("hiddenResult")
    public RString getHiddenResult() {
        return hiddenResult;
    }

    /*
     * sethiddenResult
     * @param hiddenResult hiddenResult
     */
    @JsonProperty("hiddenResult")
    public void setHiddenResult(RString hiddenResult) {
        this.hiddenResult = hiddenResult;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShoriNendoTanitsuTasha() {
        return this.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtShoriNendoTanitsuTasha();
    }

    @JsonIgnore
    public void setTxtShoriNendoTanitsuTasha(TextBoxDate txtShoriNendoTanitsuTasha) {
        this.getShotokuJohoChushutsuTanitsuTashaPanel().setTxtShoriNendoTanitsuTasha(txtShoriNendoTanitsuTasha);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getShotokuJohoChushutsuTanitsuTashaPanel().getLin2();
    }

    @JsonIgnore
    public void setLin2(HorizontalLine lin2) {
        this.getShotokuJohoChushutsuTanitsuTashaPanel().setLin2(lin2);
    }

    @JsonIgnore
    public TextBox getTxtTorikomiJotai() {
        return this.getShotokuJohoChushutsuTanitsuTashaPanel().getTxtTorikomiJotai();
    }

    @JsonIgnore
    public void setTxtTorikomiJotai(TextBox txtTorikomiJotai) {
        this.getShotokuJohoChushutsuTanitsuTashaPanel().setTxtTorikomiJotai(txtTorikomiJotai);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getShotokuJohoChushutsuTanitsuTashaPanel().getLin3();
    }

    @JsonIgnore
    public void setLin3(HorizontalLine lin3) {
        this.getShotokuJohoChushutsuTanitsuTashaPanel().setLin3(lin3);
    }

    @JsonIgnore
    public ToriKomiTaishoDiv getToriKomiTaisho() {
        return this.getShotokuJohoChushutsuTanitsuTashaPanel().getToriKomiTaisho();
    }

    @JsonIgnore
    public void setToriKomiTaisho(ToriKomiTaishoDiv ToriKomiTaisho) {
        this.getShotokuJohoChushutsuTanitsuTashaPanel().setToriKomiTaisho(ToriKomiTaisho);
    }

    @JsonIgnore
    public UploadPanel getUplUpload() {
        return this.getShotokuJohoChushutsuTanitsuTashaPanel().getToriKomiTaisho().getUplUpload();
    }

    @JsonIgnore
    public void setUplUpload(UploadPanel uplUpload) {
        this.getShotokuJohoChushutsuTanitsuTashaPanel().getToriKomiTaisho().setUplUpload(uplUpload);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getShotokuJohoChushutsuTanitsuTashaPanel().getToriKomiTaisho().getBtnUpload();
    }

    @JsonIgnore
    public void setBtnUpload(Button btnUpload) {
        this.getShotokuJohoChushutsuTanitsuTashaPanel().getToriKomiTaisho().setBtnUpload(btnUpload);
    }

    @JsonIgnore
    public ShotokuJohoIchiranTanitsuTashaDiv getShotokuJohoIchiranTanitsuTasha() {
        return this.getShotokuJohoChushutsuTanitsuTashaPanel().getShotokuJohoIchiranTanitsuTasha();
    }

    @JsonIgnore
    public void setShotokuJohoIchiranTanitsuTasha(ShotokuJohoIchiranTanitsuTashaDiv ShotokuJohoIchiranTanitsuTasha) {
        this.getShotokuJohoChushutsuTanitsuTashaPanel().setShotokuJohoIchiranTanitsuTasha(ShotokuJohoIchiranTanitsuTasha);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujunTanitsuTasha() {
        return this.getShotokuJohoChushutsuTanitsuTashaPanel().getShotokuJohoIchiranTanitsuTasha().getCcdChohyoShutsuryokujunTanitsuTasha();
    }

    // </editor-fold>
}
