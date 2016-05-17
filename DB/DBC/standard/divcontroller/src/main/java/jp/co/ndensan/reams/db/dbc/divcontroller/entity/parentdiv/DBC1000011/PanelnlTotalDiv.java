package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1000011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate.IPaymentDateDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.PaymentDate.PaymentDateDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * PanelnlTotal のクラスファイル
 *
 * @reamsid_L DBC-1000-010 zhangzhiming
 */
public class PanelnlTotalDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShokanbaraiShikyuKetteiTsuchishoJoken")
    private ShokanbaraiShikyuKetteiTsuchishoJokenDiv ShokanbaraiShikyuKetteiTsuchishoJoken;
    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod")
    private PaymentDateDiv KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod;
    @JsonProperty("PnlShokanbaraiShikyuKeteiTuchisho")
    private PnlShokanbaraiShikyuKeteiTuchishoDiv PnlShokanbaraiShikyuKeteiTuchisho;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShokanbaraiShikyuKetteiTsuchishoJoken
     * @return ShokanbaraiShikyuKetteiTsuchishoJoken
     */
    @JsonProperty("ShokanbaraiShikyuKetteiTsuchishoJoken")
    public ShokanbaraiShikyuKetteiTsuchishoJokenDiv getShokanbaraiShikyuKetteiTsuchishoJoken() {
        return ShokanbaraiShikyuKetteiTsuchishoJoken;
    }

    /*
     * setShokanbaraiShikyuKetteiTsuchishoJoken
     * @param ShokanbaraiShikyuKetteiTsuchishoJoken ShokanbaraiShikyuKetteiTsuchishoJoken
     */
    @JsonProperty("ShokanbaraiShikyuKetteiTsuchishoJoken")
    public void setShokanbaraiShikyuKetteiTsuchishoJoken(ShokanbaraiShikyuKetteiTsuchishoJokenDiv ShokanbaraiShikyuKetteiTsuchishoJoken) {
        this.ShokanbaraiShikyuKetteiTsuchishoJoken = ShokanbaraiShikyuKetteiTsuchishoJoken;
    }

    /*
     * getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod
     * @return KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod
     */
    @JsonProperty("KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod")
    public IPaymentDateDiv getKogakuShikyuKetteiTsuchiSakuseishoPaymentMethod() {
        return KogakuShikyuKetteiTsuchiSakuseishoPaymentMethod;
    }

    /*
     * getPnlShokanbaraiShikyuKeteiTuchisho
     * @return PnlShokanbaraiShikyuKeteiTuchisho
     */
    @JsonProperty("PnlShokanbaraiShikyuKeteiTuchisho")
    public PnlShokanbaraiShikyuKeteiTuchishoDiv getPnlShokanbaraiShikyuKeteiTuchisho() {
        return PnlShokanbaraiShikyuKeteiTuchisho;
    }

    /*
     * setPnlShokanbaraiShikyuKeteiTuchisho
     * @param PnlShokanbaraiShikyuKeteiTuchisho PnlShokanbaraiShikyuKeteiTuchisho
     */
    @JsonProperty("PnlShokanbaraiShikyuKeteiTuchisho")
    public void setPnlShokanbaraiShikyuKeteiTuchisho(PnlShokanbaraiShikyuKeteiTuchishoDiv PnlShokanbaraiShikyuKeteiTuchisho) {
        this.PnlShokanbaraiShikyuKeteiTuchisho = PnlShokanbaraiShikyuKeteiTuchisho;
    }

    /*
     * getccdChohyoShutsuryokujun
     * @return ccdChohyoShutsuryokujun
     */
    @JsonProperty("ccdChohyoShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdChohyoShutsuryokujun() {
        return ccdChohyoShutsuryokujun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadInnsho() {
        return this.getShokanbaraiShikyuKetteiTsuchishoJoken().getPnlInnsho().getRadInnsho();
    }

    @JsonIgnore
    public void setRadInnsho(RadioButton radInnsho) {
        this.getShokanbaraiShikyuKetteiTsuchishoJoken().getPnlInnsho().setRadInnsho(radInnsho);
    }

    @JsonIgnore
    public TextBoxDate getTxtHakkobi() {
        return this.getPnlShokanbaraiShikyuKeteiTuchisho().getTxtHakkobi();
    }

    @JsonIgnore
    public void setTxtHakkobi(TextBoxDate txtHakkobi) {
        this.getPnlShokanbaraiShikyuKeteiTuchisho().setTxtHakkobi(txtHakkobi);
    }

    @JsonIgnore
    public TextBox getTxtBunshoNo() {
        return this.getPnlShokanbaraiShikyuKeteiTuchisho().getTxtBunshoNo();
    }

    @JsonIgnore
    public void setTxtBunshoNo(TextBox txtBunshoNo) {
        this.getPnlShokanbaraiShikyuKeteiTuchisho().setTxtBunshoNo(txtBunshoNo);
    }

    @JsonIgnore
    public Label getLblHakkoShijiMsg() {
        return this.getPnlShokanbaraiShikyuKeteiTuchisho().getLblHakkoShijiMsg();
    }

    @JsonIgnore
    public void setLblHakkoShijiMsg(Label lblHakkoShijiMsg) {
        this.getPnlShokanbaraiShikyuKeteiTuchisho().setLblHakkoShijiMsg(lblHakkoShijiMsg);
    }

    @JsonIgnore
    public PnlTestOutputDiv getPnlTestOutput() {
        return this.getPnlShokanbaraiShikyuKeteiTuchisho().getPnlTestOutput();
    }

    @JsonIgnore
    public void setPnlTestOutput(PnlTestOutputDiv PnlTestOutput) {
        this.getPnlShokanbaraiShikyuKeteiTuchisho().setPnlTestOutput(PnlTestOutput);
    }

    @JsonIgnore
    public CheckBoxList getChkTestShutsuryoku() {
        return this.getPnlShokanbaraiShikyuKeteiTuchisho().getPnlTestOutput().getChkTestShutsuryoku();
    }

    @JsonIgnore
    public void setChkTestShutsuryoku(CheckBoxList chkTestShutsuryoku) {
        this.getPnlShokanbaraiShikyuKeteiTuchisho().getPnlTestOutput().setChkTestShutsuryoku(chkTestShutsuryoku);
    }

    @JsonIgnore
    public RadioButton getRadKeteibiIkatsuKoushinnKubun() {
        return this.getPnlShokanbaraiShikyuKeteiTuchisho().getPnlTestOutput().getRadKeteibiIkatsuKoushinnKubun();
    }

    @JsonIgnore
    public void setRadKeteibiIkatsuKoushinnKubun(RadioButton radKeteibiIkatsuKoushinnKubun) {
        this.getPnlShokanbaraiShikyuKeteiTuchisho().getPnlTestOutput().setRadKeteibiIkatsuKoushinnKubun(radKeteibiIkatsuKoushinnKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtKeteibiTuchisho() {
        return this.getPnlShokanbaraiShikyuKeteiTuchisho().getPnlTestOutput().getTxtKeteibiTuchisho();
    }

    @JsonIgnore
    public void setTxtKeteibiTuchisho(TextBoxDate txtKeteibiTuchisho) {
        this.getPnlShokanbaraiShikyuKeteiTuchisho().getPnlTestOutput().setTxtKeteibiTuchisho(txtKeteibiTuchisho);
    }

    @JsonIgnore
    public PnlOutputTargetDiv getPnlOutputTarget() {
        return this.getPnlShokanbaraiShikyuKeteiTuchisho().getPnlOutputTarget();
    }

    @JsonIgnore
    public void setPnlOutputTarget(PnlOutputTargetDiv PnlOutputTarget) {
        this.getPnlShokanbaraiShikyuKeteiTuchisho().setPnlOutputTarget(PnlOutputTarget);
    }

    @JsonIgnore
    public CheckBoxList getChkOutputTargetKubun() {
        return this.getPnlShokanbaraiShikyuKeteiTuchisho().getPnlOutputTarget().getChkOutputTargetKubun();
    }

    @JsonIgnore
    public void setChkOutputTargetKubun(CheckBoxList chkOutputTargetKubun) {
        this.getPnlShokanbaraiShikyuKeteiTuchisho().getPnlOutputTarget().setChkOutputTargetKubun(chkOutputTargetKubun);
    }

    // </editor-fold>
}
