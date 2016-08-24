package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7150001;
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
 * HanyoListParamKougakuGassanJikoFudan のクラスファイル
 *
 * @reamsid_L DBC-3102-010 dingminghao
 */
public class HanyoListParamKougakuGassanJikoFudanDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JokenFukugenHozonl")
    private JokenFukugenHozonlDiv JokenFukugenHozonl;
    @JsonProperty("ChushutsuJokenPanel")
    private ChushutsuJokenPanelDiv ChushutsuJokenPanel;
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
     * getJokenFukugenHozonl
     * @return JokenFukugenHozonl
     */
    @JsonProperty("JokenFukugenHozonl")
    public JokenFukugenHozonlDiv getJokenFukugenHozonl() {
        return JokenFukugenHozonl;
    }

    /*
     * setJokenFukugenHozonl
     * @param JokenFukugenHozonl JokenFukugenHozonl
     */
    @JsonProperty("JokenFukugenHozonl")
    public void setJokenFukugenHozonl(JokenFukugenHozonlDiv JokenFukugenHozonl) {
        this.JokenFukugenHozonl = JokenFukugenHozonl;
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
        return this.getJokenFukugenHozonl().getBtnBatchParameterSave();
    }

    @JsonIgnore
    public void setBtnBatchParameterSave(ButtonBatchParameterSave btnBatchParameterSave) {
        this.getJokenFukugenHozonl().setBtnBatchParameterSave(btnBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnBatchParameterRestore() {
        return this.getJokenFukugenHozonl().getBtnBatchParameterRestore();
    }

    @JsonIgnore
    public void setBtnBatchParameterRestore(ButtonBatchParameterRestore btnBatchParameterRestore) {
        this.getJokenFukugenHozonl().setBtnBatchParameterRestore(btnBatchParameterRestore);
    }

    @JsonIgnore
    public ChushutsuJoken1Div getChushutsuJoken1() {
        return this.getChushutsuJokenPanel().getChushutsuJoken1();
    }

    @JsonIgnore
    public void setChushutsuJoken1(ChushutsuJoken1Div ChushutsuJoken1) {
        this.getChushutsuJokenPanel().setChushutsuJoken1(ChushutsuJoken1);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuKubun() {
        return this.getChushutsuJokenPanel().getChushutsuJoken1().getRadChushutsuKubun();
    }

    @JsonIgnore
    public void setRadChushutsuKubun(RadioButton radChushutsuKubun) {
        this.getChushutsuJokenPanel().getChushutsuJoken1().setRadChushutsuKubun(radChushutsuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlDetaSakuseiKubun() {
        return this.getChushutsuJokenPanel().getChushutsuJoken1().getDdlDetaSakuseiKubun();
    }

    @JsonIgnore
    public void setDdlDetaSakuseiKubun(DropDownList ddlDetaSakuseiKubun) {
        this.getChushutsuJokenPanel().getChushutsuJoken1().setDdlDetaSakuseiKubun(ddlDetaSakuseiKubun);
    }

    @JsonIgnore
    public RadioButton getRadDataShurui() {
        return this.getChushutsuJokenPanel().getChushutsuJoken1().getRadDataShurui();
    }

    @JsonIgnore
    public void setRadDataShurui(RadioButton radDataShurui) {
        this.getChushutsuJokenPanel().getChushutsuJoken1().setRadDataShurui(radDataShurui);
    }

    @JsonIgnore
    public RadioButton getRadHoseuJokyo() {
        return this.getChushutsuJokenPanel().getChushutsuJoken1().getRadHoseuJokyo();
    }

    @JsonIgnore
    public void setRadHoseuJokyo(RadioButton radHoseuJokyo) {
        this.getChushutsuJokenPanel().getChushutsuJoken1().setRadHoseuJokyo(radHoseuJokyo);
    }

    @JsonIgnore
    public ChushutsuJoken2Div getChushutsuJoken2() {
        return this.getChushutsuJokenPanel().getChushutsuJoken2();
    }

    @JsonIgnore
    public void setChushutsuJoken2(ChushutsuJoken2Div ChushutsuJoken2) {
        this.getChushutsuJokenPanel().setChushutsuJoken2(ChushutsuJoken2);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtJikoFutangakuKakunin() {
        return this.getChushutsuJokenPanel().getChushutsuJoken2().getTxtJikoFutangakuKakunin();
    }

    @JsonIgnore
    public void setTxtJikoFutangakuKakunin(TextBoxDateRange txtJikoFutangakuKakunin) {
        this.getChushutsuJokenPanel().getChushutsuJoken2().setTxtJikoFutangakuKakunin(txtJikoFutangakuKakunin);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtHoseizumiJikoFutangaku() {
        return this.getChushutsuJokenPanel().getChushutsuJoken2().getTxtHoseizumiJikoFutangaku();
    }

    @JsonIgnore
    public void setTxtHoseizumiJikoFutangaku(TextBoxDateRange txtHoseizumiJikoFutangaku) {
        this.getChushutsuJokenPanel().getChushutsuJoken2().setTxtHoseizumiJikoFutangaku(txtHoseizumiJikoFutangaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtJikoFutanngakuShoumeisho() {
        return this.getChushutsuJokenPanel().getChushutsuJoken2().getTxtJikoFutanngakuShoumeisho();
    }

    @JsonIgnore
    public void setTxtJikoFutanngakuShoumeisho(TextBoxDateRange txtJikoFutanngakuShoumeisho) {
        this.getChushutsuJokenPanel().getChushutsuJoken2().setTxtJikoFutanngakuShoumeisho(txtJikoFutanngakuShoumeisho);
    }

    @JsonIgnore
    public DropDownList getDdlTaishoNendo() {
        return this.getChushutsuJokenPanel().getDdlTaishoNendo();
    }

    @JsonIgnore
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.getChushutsuJokenPanel().setDdlTaishoNendo(ddlTaishoNendo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtSinseibi() {
        return this.getChushutsuJokenPanel().getTxtSinseibi();
    }

    @JsonIgnore
    public void setTxtSinseibi(TextBoxDateRange txtSinseibi) {
        this.getChushutsuJokenPanel().setTxtSinseibi(txtSinseibi);
    }

    @JsonIgnore
    public TextBox getTxtSikyuSinseishoSeiriBangoKaishi() {
        return this.getChushutsuJokenPanel().getTxtSikyuSinseishoSeiriBangoKaishi();
    }

    @JsonIgnore
    public void setTxtSikyuSinseishoSeiriBangoKaishi(TextBox txtSikyuSinseishoSeiriBangoKaishi) {
        this.getChushutsuJokenPanel().setTxtSikyuSinseishoSeiriBangoKaishi(txtSikyuSinseishoSeiriBangoKaishi);
    }

    @JsonIgnore
    public TextBox getTxtSikyuSinseishoSeiriBangoShuryo() {
        return this.getChushutsuJokenPanel().getTxtSikyuSinseishoSeiriBangoShuryo();
    }

    @JsonIgnore
    public void setTxtSikyuSinseishoSeiriBangoShuryo(TextBox txtSikyuSinseishoSeiriBangoShuryo) {
        this.getChushutsuJokenPanel().setTxtSikyuSinseishoSeiriBangoShuryo(txtSikyuSinseishoSeiriBangoShuryo);
    }

    @JsonIgnore
    public CheckBoxList getChkSofuTaishogaiFukumu() {
        return this.getChushutsuJokenPanel().getChkSofuTaishogaiFukumu();
    }

    @JsonIgnore
    public void setChkSofuTaishogaiFukumu(CheckBoxList chkSofuTaishogaiFukumu) {
        this.getChushutsuJokenPanel().setChkSofuTaishogaiFukumu(chkSofuTaishogaiFukumu);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getChushutsuJokenPanel().getCcdHokenshaList();
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
