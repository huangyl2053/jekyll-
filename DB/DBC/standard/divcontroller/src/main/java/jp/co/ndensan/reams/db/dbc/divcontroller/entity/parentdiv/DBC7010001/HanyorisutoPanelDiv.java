package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7010001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HanyorisutoPanel のクラスファイル
 *
 * @reamsid_L DBC-3091-010 zhangrui
 */
public class HanyorisutoPanelDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("BatchParameterPanel")
    private BatchParameterPanelDiv BatchParameterPanel;
    @JsonProperty("ChushutsuJokenPanel")
    private ChushutsuJokenPanelDiv ChushutsuJokenPanel;
    @JsonProperty("DvCsvHenshuHoho")
    private DvCsvHenshuHohoDiv DvCsvHenshuHoho;
    @JsonProperty("ccdChohyoShutsuryokukoumoku")
    private ChohyoShutsuryokuKomokuDiv ccdChohyoShutsuryokukoumoku;
    @JsonProperty("ccdChohyoShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdChohyoShutsuryokujun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getBatchParameterPanel
     * @return BatchParameterPanel
     */
    @JsonProperty("BatchParameterPanel")
    public BatchParameterPanelDiv getBatchParameterPanel() {
        return BatchParameterPanel;
    }

    /*
     * setBatchParameterPanel
     * @param BatchParameterPanel BatchParameterPanel
     */
    @JsonProperty("BatchParameterPanel")
    public void setBatchParameterPanel(BatchParameterPanelDiv BatchParameterPanel) {
        this.BatchParameterPanel = BatchParameterPanel;
    }

    /*
     * getChushutsuJokenPanel
     * @return ChushutsuJokenPanel
     */
    @JsonProperty("ChushutsuJokenPanel")
    public ChushutsuJokenPanelDiv getChushutsuJokenPanel() {
        return ChushutsuJokenPanel;
    }

    /*
     * setChushutsuJokenPanel
     * @param ChushutsuJokenPanel ChushutsuJokenPanel
     */
    @JsonProperty("ChushutsuJokenPanel")
    public void setChushutsuJokenPanel(ChushutsuJokenPanelDiv ChushutsuJokenPanel) {
        this.ChushutsuJokenPanel = ChushutsuJokenPanel;
    }

    /*
     * getDvCsvHenshuHoho
     * @return DvCsvHenshuHoho
     */
    @JsonProperty("DvCsvHenshuHoho")
    public DvCsvHenshuHohoDiv getDvCsvHenshuHoho() {
        return DvCsvHenshuHoho;
    }

    /*
     * setDvCsvHenshuHoho
     * @param DvCsvHenshuHoho DvCsvHenshuHoho
     */
    @JsonProperty("DvCsvHenshuHoho")
    public void setDvCsvHenshuHoho(DvCsvHenshuHohoDiv DvCsvHenshuHoho) {
        this.DvCsvHenshuHoho = DvCsvHenshuHoho;
    }

    /*
     * getccdChohyoShutsuryokukoumoku
     * @return ccdChohyoShutsuryokukoumoku
     */
    @JsonProperty("ccdChohyoShutsuryokukoumoku")
    public IChohyoShutsuryokuKomokuDiv getCcdChohyoShutsuryokukoumoku() {
        return ccdChohyoShutsuryokukoumoku;
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
    public ButtonBatchParameterSave getBtnBatchParameterSave() {
        return this.getBatchParameterPanel().getBtnBatchParameterSave();
    }

    @JsonIgnore
    public void setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.getBatchParameterPanel().setBtnBatchParameterSave(btnBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return this.getBatchParameterPanel().getBtnBatchParameterRestore();
    }

    @JsonIgnore
    public void setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.getBatchParameterPanel().setBtnBatchParameterRestore(btnBatchParameterRestore);
    }

    @JsonIgnore
    public SakuseiKubunPanelDiv getSakuseiKubunPanel() {
        return this.getChushutsuJokenPanel().getSakuseiKubunPanel();
    }

    @JsonIgnore
    public void setSakuseiKubunPanel(SakuseiKubunPanelDiv SakuseiKubunPanel) {
        this.getChushutsuJokenPanel().setSakuseiKubunPanel(SakuseiKubunPanel);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokensya() {
        return this.getChushutsuJokenPanel().getSakuseiKubunPanel().getCcdHokensya();
    }

    @JsonIgnore
    public ChushutsuJokenKotakuDiv getChushutsuJokenKotaku() {
        return this.getChushutsuJokenPanel().getChushutsuJokenKotaku();
    }

    @JsonIgnore
    public void setChushutsuJokenKotaku(ChushutsuJokenKotakuDiv ChushutsuJokenKotaku) {
        this.getChushutsuJokenPanel().setChushutsuJokenKotaku(ChushutsuJokenKotaku);
    }

    @JsonIgnore
    public RadioButton getRadSakuseiKubun() {
        return this.getChushutsuJokenPanel().getChushutsuJokenKotaku().getRadSakuseiKubun();
    }

    @JsonIgnore
    public void setRadSakuseiKubun(RadioButton radSakuseiKubun) {
        this.getChushutsuJokenPanel().getChushutsuJokenKotaku().setRadSakuseiKubun(radSakuseiKubun);
    }

    @JsonIgnore
    public RadioButton getRadChusyutuKubun() {
        return this.getChushutsuJokenPanel().getChushutsuJokenKotaku().getRadChusyutuKubun();
    }

    @JsonIgnore
    public void setRadChusyutuKubun(RadioButton radChusyutuKubun) {
        this.getChushutsuJokenPanel().getChushutsuJokenKotaku().setRadChusyutuKubun(radChusyutuKubun);
    }

    @JsonIgnore
    public KijunYMDPanelDiv getKijunYMDPanel() {
        return this.getChushutsuJokenPanel().getChushutsuJokenKotaku().getKijunYMDPanel();
    }

    @JsonIgnore
    public void setKijunYMDPanel(KijunYMDPanelDiv KijunYMDPanel) {
        this.getChushutsuJokenPanel().getChushutsuJokenKotaku().setKijunYMDPanel(KijunYMDPanel);
    }

    @JsonIgnore
    public Space getChusyutuKubunSpace() {
        return this.getChushutsuJokenPanel().getChushutsuJokenKotaku().getKijunYMDPanel().getChusyutuKubunSpace();
    }

    @JsonIgnore
    public void setChusyutuKubunSpace(Space ChusyutuKubunSpace) {
        this.getChushutsuJokenPanel().getChushutsuJokenKotaku().getKijunYMDPanel().setChusyutuKubunSpace(ChusyutuKubunSpace);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijunYMD() {
        return this.getChushutsuJokenPanel().getChushutsuJokenKotaku().getKijunYMDPanel().getTxtKijunYMD();
    }

    @JsonIgnore
    public void setTxtKijunYMD(TextBoxDate txtKijunYMD) {
        this.getChushutsuJokenPanel().getChushutsuJokenKotaku().getKijunYMDPanel().setTxtKijunYMD(txtKijunYMD);
    }

    @JsonIgnore
    public TextBox getTxtSienJigyosyano() {
        return this.getChushutsuJokenPanel().getChushutsuJokenKotaku().getTxtSienJigyosyano();
    }

    @JsonIgnore
    public void setTxtSienJigyosyano(TextBox txtSienJigyosyano) {
        this.getChushutsuJokenPanel().getChushutsuJokenKotaku().setTxtSienJigyosyano(txtSienJigyosyano);
    }

    @JsonIgnore
    public ButtonDialog getBtnSienJigyosyano() {
        return this.getChushutsuJokenPanel().getChushutsuJokenKotaku().getBtnSienJigyosyano();
    }

    @JsonIgnore
    public void setBtnSienJigyosyano(ButtonDialog btnSienJigyosyano) {
        this.getChushutsuJokenPanel().getChushutsuJokenKotaku().setBtnSienJigyosyano(btnSienJigyosyano);
    }

    @JsonIgnore
    public TextBox getTxtSienJigyosya() {
        return this.getChushutsuJokenPanel().getChushutsuJokenKotaku().getTxtSienJigyosya();
    }

    @JsonIgnore
    public void setTxtSienJigyosya(TextBox txtSienJigyosya) {
        this.getChushutsuJokenPanel().getChushutsuJokenKotaku().setTxtSienJigyosya(txtSienJigyosya);
    }

    @JsonIgnore
    public CheckBoxList getChkCsvHenshuHoho() {
        return this.getDvCsvHenshuHoho().getChkCsvHenshuHoho();
    }

    @JsonIgnore
    public void setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    // </editor-fold>
}
