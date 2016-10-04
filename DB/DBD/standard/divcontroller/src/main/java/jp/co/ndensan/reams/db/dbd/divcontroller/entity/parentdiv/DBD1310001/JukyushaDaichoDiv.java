package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1310001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.HanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * JukyushaDaicho のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaDaichoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
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
    @JsonProperty("ChushutsuPanel2")
    private ChushutsuPanel2Div ChushutsuPanel2;
    @JsonProperty("DvCsvHenshuHoho")
    private DvCsvHenshuHohoDiv DvCsvHenshuHoho;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;
    @JsonProperty("ccdShutsuryokuKoumoku")
    private ChohyoShutsuryokuKomokuDiv ccdShutsuryokuKoumoku;
    @JsonProperty("CommonChildDiv1")
    private HanyoListAtenaSelectDiv CommonChildDiv1;

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
     * getChushutsuPanel2
     * @return ChushutsuPanel2
     */
    @JsonProperty("ChushutsuPanel2")
    public ChushutsuPanel2Div getChushutsuPanel2() {
        return ChushutsuPanel2;
    }

    /*
     * setChushutsuPanel2
     * @param ChushutsuPanel2 ChushutsuPanel2
     */
    @JsonProperty("ChushutsuPanel2")
    public void setChushutsuPanel2(ChushutsuPanel2Div ChushutsuPanel2) {
        this.ChushutsuPanel2 = ChushutsuPanel2;
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
     * getccdShutsuryokujun
     * @return ccdShutsuryokujun
     */
    @JsonProperty("ccdShutsuryokujun")
    public IChohyoShutsuryokujunDiv getCcdShutsuryokujun() {
        return ccdShutsuryokujun;
    }

    /*
     * getccdShutsuryokuKoumoku
     * @return ccdShutsuryokuKoumoku
     */
    @JsonProperty("ccdShutsuryokuKoumoku")
    public IChohyoShutsuryokuKomokuDiv getCcdShutsuryokuKoumoku() {
        return ccdShutsuryokuKoumoku;
    }

    /*
     * getCommonChildDiv1
     * @return CommonChildDiv1
     */
    @JsonProperty("CommonChildDiv1")
    public IHanyoListAtenaSelectDiv getCommonChildDiv1() {
        return CommonChildDiv1;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonBatchParameterSave getBtnBatchParameterSave() {
        return this.getBatchParameterPanel().getBtnBatchParameterSave();
    }

    @JsonIgnore
    public void  setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.getBatchParameterPanel().setBtnBatchParameterSave(btnBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return this.getBatchParameterPanel().getBtnBatchParameterRestore();
    }

    @JsonIgnore
    public void  setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.getBatchParameterPanel().setBtnBatchParameterRestore(btnBatchParameterRestore);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuTaisho() {
        return this.getChushutsuJokenPanel().getRadChushutsuTaisho();
    }

    @JsonIgnore
    public void  setRadChushutsuTaisho(RadioButton radChushutsuTaisho) {
        this.getChushutsuJokenPanel().setRadChushutsuTaisho(radChushutsuTaisho);
    }

    @JsonIgnore
    public ChushutsuHaniPanelDiv getChushutsuHaniPanel() {
        return this.getChushutsuJokenPanel().getChushutsuHaniPanel();
    }

    @JsonIgnore
    public void  setChushutsuHaniPanel(ChushutsuHaniPanelDiv ChushutsuHaniPanel) {
        this.getChushutsuJokenPanel().setChushutsuHaniPanel(ChushutsuHaniPanel);
    }

    @JsonIgnore
    public CheckBoxList getChkSaisin() {
        return this.getChushutsuJokenPanel().getChushutsuHaniPanel().getChkSaisin();
    }

    @JsonIgnore
    public void  setChkSaisin(CheckBoxList chkSaisin) {
        this.getChushutsuJokenPanel().getChushutsuHaniPanel().setChkSaisin(chkSaisin);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunYmd() {
        return this.getChushutsuJokenPanel().getChushutsuHaniPanel().getTxtKijyunYmd();
    }

    @JsonIgnore
    public void  setTxtKijyunYmd(TextBoxDate txtKijyunYmd) {
        this.getChushutsuJokenPanel().getChushutsuHaniPanel().setTxtKijyunYmd(txtKijyunYmd);
    }

    @JsonIgnore
    public Label getLblNinteiYmdHani() {
        return this.getChushutsuJokenPanel().getChushutsuHaniPanel().getLblNinteiYmdHani();
    }

    @JsonIgnore
    public void  setLblNinteiYmdHani(Label lblNinteiYmdHani) {
        this.getChushutsuJokenPanel().getChushutsuHaniPanel().setLblNinteiYmdHani(lblNinteiYmdHani);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtNinteiYmdHani() {
        return this.getChushutsuJokenPanel().getChushutsuHaniPanel().getTxtNinteiYmdHani();
    }

    @JsonIgnore
    public void  setTxtNinteiYmdHani(TextBoxDateRange txtNinteiYmdHani) {
        this.getChushutsuJokenPanel().getChushutsuHaniPanel().setTxtNinteiYmdHani(txtNinteiYmdHani);
    }

    @JsonIgnore
    public NinteiKekkaPanelDiv getNinteiKekkaPanel() {
        return this.getChushutsuJokenPanel().getNinteiKekkaPanel();
    }

    @JsonIgnore
    public void  setNinteiKekkaPanel(NinteiKekkaPanelDiv NinteiKekkaPanel) {
        this.getChushutsuJokenPanel().setNinteiKekkaPanel(NinteiKekkaPanel);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiKekka() {
        return this.getChushutsuJokenPanel().getNinteiKekkaPanel().getChkNinteiKekka();
    }

    @JsonIgnore
    public void  setChkNinteiKekka(CheckBoxList chkNinteiKekka) {
        this.getChushutsuJokenPanel().getNinteiKekkaPanel().setChkNinteiKekka(chkNinteiKekka);
    }

    @JsonIgnore
    public Ninteikekka2PanelDiv getNinteikekka2Panel() {
        return this.getChushutsuJokenPanel().getNinteikekka2Panel();
    }

    @JsonIgnore
    public void  setNinteikekka2Panel(Ninteikekka2PanelDiv Ninteikekka2Panel) {
        this.getChushutsuJokenPanel().setNinteikekka2Panel(Ninteikekka2Panel);
    }

    @JsonIgnore
    public CheckBoxList getＣｈｋKyuSochisya() {
        return this.getChushutsuJokenPanel().getNinteikekka2Panel().getＣｈｋKyuSochisya();
    }

    @JsonIgnore
    public void  setＣｈｋKyuSochisya(CheckBoxList ｃｈｋKyuSochisya) {
        this.getChushutsuJokenPanel().getNinteikekka2Panel().setＣｈｋKyuSochisya(ｃｈｋKyuSochisya);
    }

    @JsonIgnore
    public CheckBoxList getChkHihokensya() {
        return this.getChushutsuJokenPanel().getNinteikekka2Panel().getChkHihokensya();
    }

    @JsonIgnore
    public void  setChkHihokensya(CheckBoxList chkHihokensya) {
        this.getChushutsuJokenPanel().getNinteikekka2Panel().setChkHihokensya(chkHihokensya);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiSabisu() {
        return this.getChushutsuJokenPanel().getNinteikekka2Panel().getChkNinteiSabisu();
    }

    @JsonIgnore
    public void  setChkNinteiSabisu(CheckBoxList chkNinteiSabisu) {
        this.getChushutsuJokenPanel().getNinteikekka2Panel().setChkNinteiSabisu(chkNinteiSabisu);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuSoshitsuKubun() {
        return this.getChushutsuJokenPanel().getDdlShikakuSoshitsuKubun();
    }

    @JsonIgnore
    public void  setDdlShikakuSoshitsuKubun(DropDownList ddlShikakuSoshitsuKubun) {
        this.getChushutsuJokenPanel().setDdlShikakuSoshitsuKubun(ddlShikakuSoshitsuKubun);
    }

    @JsonIgnore
    public IHanyoListAtenaSelectDiv getCcdAtenaJoken() {
        return this.getChushutsuPanel2().getCcdAtenaJoken();
    }

    @JsonIgnore
    public CheckBoxList getChkCsvHenshuHoho() {
        return this.getDvCsvHenshuHoho().getChkCsvHenshuHoho();
    }

    @JsonIgnore
    public void  setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    // </editor-fold>
}
