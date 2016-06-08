package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1300001;
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
 * JukyushaDaichoPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaDaichoPanelDiv extends PanelBatchParameter {
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
    public DropDownList getDdlChushutsuData() {
        return this.getChushutsuJokenPanel().getDdlChushutsuData();
    }

    @JsonIgnore
    public void  setDdlChushutsuData(DropDownList ddlChushutsuData) {
        this.getChushutsuJokenPanel().setDdlChushutsuData(ddlChushutsuData);
    }

    @JsonIgnore
    public CheckBoxList getChkTorikeshiSakujo() {
        return this.getChushutsuJokenPanel().getChkTorikeshiSakujo();
    }

    @JsonIgnore
    public void  setChkTorikeshiSakujo(CheckBoxList chkTorikeshiSakujo) {
        this.getChushutsuJokenPanel().setChkTorikeshiSakujo(chkTorikeshiSakujo);
    }

    @JsonIgnore
    public DropDownList getDdlSoushitsuKubun() {
        return this.getChushutsuJokenPanel().getDdlSoushitsuKubun();
    }

    @JsonIgnore
    public void  setDdlSoushitsuKubun(DropDownList ddlSoushitsuKubun) {
        this.getChushutsuJokenPanel().setDdlSoushitsuKubun(ddlSoushitsuKubun);
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
    public ChushutsuPanelDiv getChushutsuPanel() {
        return this.getChushutsuJokenPanel().getChushutsuPanel();
    }

    @JsonIgnore
    public void  setChushutsuPanel(ChushutsuPanelDiv ChushutsuPanel) {
        this.getChushutsuJokenPanel().setChushutsuPanel(ChushutsuPanel);
    }

    @JsonIgnore
    public DropDownList getDdlChushutsuYmd() {
        return this.getChushutsuJokenPanel().getChushutsuPanel().getDdlChushutsuYmd();
    }

    @JsonIgnore
    public void  setDdlChushutsuYmd(DropDownList ddlChushutsuYmd) {
        this.getChushutsuJokenPanel().getChushutsuPanel().setDdlChushutsuYmd(ddlChushutsuYmd);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtChushutsuYMD() {
        return this.getChushutsuJokenPanel().getChushutsuPanel().getTxtChushutsuYMD();
    }

    @JsonIgnore
    public void  setTxtChushutsuYMD(TextBoxDateRange txtChushutsuYMD) {
        this.getChushutsuJokenPanel().getChushutsuPanel().setTxtChushutsuYMD(txtChushutsuYMD);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtIryokikan() {
        return this.getChushutsuJokenPanel().getChushutsuPanel().getTxtIryokikan();
    }

    @JsonIgnore
    public void  setTxtIryokikan(TextBoxNumRange txtIryokikan) {
        this.getChushutsuJokenPanel().getChushutsuPanel().setTxtIryokikan(txtIryokikan);
    }

    @JsonIgnore
    public TextBoxNumRange getTxtChosaItakusaki() {
        return this.getChushutsuJokenPanel().getChushutsuPanel().getTxtChosaItakusaki();
    }

    @JsonIgnore
    public void  setTxtChosaItakusaki(TextBoxNumRange txtChosaItakusaki) {
        this.getChushutsuJokenPanel().getChushutsuPanel().setTxtChosaItakusaki(txtChosaItakusaki);
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
