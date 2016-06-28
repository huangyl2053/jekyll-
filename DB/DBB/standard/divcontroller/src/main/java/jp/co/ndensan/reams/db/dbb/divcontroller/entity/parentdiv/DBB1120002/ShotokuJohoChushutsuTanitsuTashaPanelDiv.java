package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB1120002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.UploadPanel;

/**
 * ShotokuJohoChushutsuTanitsuTashaPanel のクラスファイル
 *
 * @reamsid_L DBB-1690-030 sunhui
 */
public class ShotokuJohoChushutsuTanitsuTashaPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShoriNendoTanitsuTasha")
    private TextBoxDate txtShoriNendoTanitsuTasha;
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("txtTorikomiJotai")
    private TextBox txtTorikomiJotai;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("ToriKomiTaisho")
    private ToriKomiTaishoDiv ToriKomiTaisho;
    @JsonProperty("ShotokuJohoIchiranTanitsuTasha")
    private ShotokuJohoIchiranTanitsuTashaDiv ShotokuJohoIchiranTanitsuTasha;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShoriNendoTanitsuTasha
     * @return txtShoriNendoTanitsuTasha
     */
    @JsonProperty("txtShoriNendoTanitsuTasha")
    public TextBoxDate getTxtShoriNendoTanitsuTasha() {
        return txtShoriNendoTanitsuTasha;
    }

    /*
     * settxtShoriNendoTanitsuTasha
     * @param txtShoriNendoTanitsuTasha txtShoriNendoTanitsuTasha
     */
    @JsonProperty("txtShoriNendoTanitsuTasha")
    public void setTxtShoriNendoTanitsuTasha(TextBoxDate txtShoriNendoTanitsuTasha) {
        this.txtShoriNendoTanitsuTasha = txtShoriNendoTanitsuTasha;
    }

    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * gettxtTorikomiJotai
     * @return txtTorikomiJotai
     */
    @JsonProperty("txtTorikomiJotai")
    public TextBox getTxtTorikomiJotai() {
        return txtTorikomiJotai;
    }

    /*
     * settxtTorikomiJotai
     * @param txtTorikomiJotai txtTorikomiJotai
     */
    @JsonProperty("txtTorikomiJotai")
    public void setTxtTorikomiJotai(TextBox txtTorikomiJotai) {
        this.txtTorikomiJotai = txtTorikomiJotai;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * getToriKomiTaisho
     * @return ToriKomiTaisho
     */
    @JsonProperty("ToriKomiTaisho")
    public ToriKomiTaishoDiv getToriKomiTaisho() {
        return ToriKomiTaisho;
    }

    /*
     * setToriKomiTaisho
     * @param ToriKomiTaisho ToriKomiTaisho
     */
    @JsonProperty("ToriKomiTaisho")
    public void setToriKomiTaisho(ToriKomiTaishoDiv ToriKomiTaisho) {
        this.ToriKomiTaisho = ToriKomiTaisho;
    }

    /*
     * getShotokuJohoIchiranTanitsuTasha
     * @return ShotokuJohoIchiranTanitsuTasha
     */
    @JsonProperty("ShotokuJohoIchiranTanitsuTasha")
    public ShotokuJohoIchiranTanitsuTashaDiv getShotokuJohoIchiranTanitsuTasha() {
        return ShotokuJohoIchiranTanitsuTasha;
    }

    /*
     * setShotokuJohoIchiranTanitsuTasha
     * @param ShotokuJohoIchiranTanitsuTasha ShotokuJohoIchiranTanitsuTasha
     */
    @JsonProperty("ShotokuJohoIchiranTanitsuTasha")
    public void setShotokuJohoIchiranTanitsuTasha(ShotokuJohoIchiranTanitsuTashaDiv ShotokuJohoIchiranTanitsuTasha) {
        this.ShotokuJohoIchiranTanitsuTasha = ShotokuJohoIchiranTanitsuTasha;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public UploadPanel getUplUpload() {
        return this.getToriKomiTaisho().getUplUpload();
    }

    @JsonIgnore
    public void setUplUpload(UploadPanel uplUpload) {
        this.getToriKomiTaisho().setUplUpload(uplUpload);
    }

    @JsonIgnore
    public Button getBtnUpload() {
        return this.getToriKomiTaisho().getBtnUpload();
    }

    @JsonIgnore
    public void setBtnUpload(Button btnUpload) {
        this.getToriKomiTaisho().setBtnUpload(btnUpload);
    }

    @JsonIgnore
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujunTanitsuTasha() {
        return this.getShotokuJohoIchiranTanitsuTasha().getCcdChohyoShutsuryokujunTanitsuTasha();
    }

    // </editor-fold>
}
