package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1330001;
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
 * HanyoListJukyushaDaichoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class HanyoListJukyushaDaichoPanelDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
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
    @JsonProperty("ccdShutsuryokuKoumoku")
    private ChohyoShutsuryokuKomokuDiv ccdShutsuryokuKoumoku;
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;

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
     * getccdShutsuryokuKoumoku
     * @return ccdShutsuryokuKoumoku
     */
    @JsonProperty("ccdShutsuryokuKoumoku")
    public IChohyoShutsuryokuKomokuDiv getCcdShutsuryokuKoumoku() {
        return ccdShutsuryokuKoumoku;
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
    public RadioButton getRadChushutsuJokenSentaku() {
        return this.getChushutsuJokenPanel().getRadChushutsuJokenSentaku();
    }

    @JsonIgnore
    public void  setRadChushutsuJokenSentaku(RadioButton radChushutsuJokenSentaku) {
        this.getChushutsuJokenPanel().setRadChushutsuJokenSentaku(radChushutsuJokenSentaku);
    }

    @JsonIgnore
    public DropDownList getDdlSiteiNen() {
        return this.getChushutsuJokenPanel().getDdlSiteiNen();
    }

    @JsonIgnore
    public void  setDdlSiteiNen(DropDownList ddlSiteiNen) {
        this.getChushutsuJokenPanel().setDdlSiteiNen(ddlSiteiNen);
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
    public RadioButton getRadNenSiteiSentaku() {
        return this.getChushutsuJokenPanel().getChushutsuHaniPanel().getRadNenSiteiSentaku();
    }

    @JsonIgnore
    public void  setRadNenSiteiSentaku(RadioButton radNenSiteiSentaku) {
        this.getChushutsuJokenPanel().getChushutsuHaniPanel().setRadNenSiteiSentaku(radNenSiteiSentaku);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getChushutsuJokenPanel().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getChushutsuJokenPanel().setLin1(lin1);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaChushutsu() {
        return this.getChushutsuJokenPanel().getRadHihokenshaChushutsu();
    }

    @JsonIgnore
    public void  setRadHihokenshaChushutsu(RadioButton radHihokenshaChushutsu) {
        this.getChushutsuJokenPanel().setRadHihokenshaChushutsu(radHihokenshaChushutsu);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getChushutsuJokenPanel().getLin2();
    }

    @JsonIgnore
    public void  setLin2(HorizontalLine lin2) {
        this.getChushutsuJokenPanel().setLin2(lin2);
    }

    @JsonIgnore
    public CheckBoxList getChkSaisinJoho() {
        return this.getChushutsuJokenPanel().getChkSaisinJoho();
    }

    @JsonIgnore
    public void  setChkSaisinJoho(CheckBoxList chkSaisinJoho) {
        this.getChushutsuJokenPanel().setChkSaisinJoho(chkSaisinJoho);
    }

    @JsonIgnore
    public Label getLblSetumeiBun1() {
        return this.getChushutsuJokenPanel().getLblSetumeiBun1();
    }

    @JsonIgnore
    public void  setLblSetumeiBun1(Label lblSetumeiBun1) {
        this.getChushutsuJokenPanel().setLblSetumeiBun1(lblSetumeiBun1);
    }

    @JsonIgnore
    public Label getLblSetumeiBun2() {
        return this.getChushutsuJokenPanel().getLblSetumeiBun2();
    }

    @JsonIgnore
    public void  setLblSetumeiBun2(Label lblSetumeiBun2) {
        this.getChushutsuJokenPanel().setLblSetumeiBun2(lblSetumeiBun2);
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
