package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0220001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hanyolistatenaselect.HanyoListAtenaSelect.IHanyoListAtenaSelectDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterRestore;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterSave;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * HanyoListFukaDaichoParam のクラスファイル
 *
 * @reamsid_L DBB-1900-010 surun
 */
public class HanyoListFukaDaichoParamDiv extends PanelBatchParameter {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JokenFukugenHozonl")
    private JokenFukugenHozonlDiv JokenFukugenHozonl;
    @JsonProperty("NendoKijumbiSitei")
    private NendoKijumbiSiteiDiv NendoKijumbiSitei;
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
     * getNendoKijumbiSitei
     * @return NendoKijumbiSitei
     */
    @JsonProperty("NendoKijumbiSitei")
    public NendoKijumbiSiteiDiv getNendoKijumbiSitei() {
        return NendoKijumbiSitei;
    }

    /*
     * setNendoKijumbiSitei
     * @param NendoKijumbiSitei NendoKijumbiSitei
     */
    @JsonProperty("NendoKijumbiSitei")
    public void setNendoKijumbiSitei(NendoKijumbiSiteiDiv NendoKijumbiSitei) {
        this.NendoKijumbiSitei = NendoKijumbiSitei;
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
    public DropDownList getDdlChoteiNendo() {
        return this.getNendoKijumbiSitei().getDdlChoteiNendo();
    }

    @JsonIgnore
    public void setDdlChoteiNendo(DropDownList ddlChoteiNendo) {
        this.getNendoKijumbiSitei().setDdlChoteiNendo(ddlChoteiNendo);
    }

    @JsonIgnore
    public DropDownList getDdlFukaNendo() {
        return this.getNendoKijumbiSitei().getDdlFukaNendo();
    }

    @JsonIgnore
    public void setDdlFukaNendo(DropDownList ddlFukaNendo) {
        this.getNendoKijumbiSitei().setDdlFukaNendo(ddlFukaNendo);
    }

    @JsonIgnore
    public CheckBoxList getChkKijyunbiSiteiUmu() {
        return this.getNendoKijumbiSitei().getChkKijyunbiSiteiUmu();
    }

    @JsonIgnore
    public void setChkKijyunbiSiteiUmu(CheckBoxList chkKijyunbiSiteiUmu) {
        this.getNendoKijumbiSitei().setChkKijyunbiSiteiUmu(chkKijyunbiSiteiUmu);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunbi() {
        return this.getNendoKijumbiSitei().getTxtKijyunbi();
    }

    @JsonIgnore
    public void setTxtKijyunbi(TextBoxDate txtKijyunbi) {
        this.getNendoKijumbiSitei().setTxtKijyunbi(txtKijyunbi);
    }

    @JsonIgnore
    public RadioButton getRadKijumbiSentaku() {
        return this.getNendoKijumbiSitei().getRadKijumbiSentaku();
    }

    @JsonIgnore
    public void setRadKijumbiSentaku(RadioButton radKijumbiSentaku) {
        this.getNendoKijumbiSitei().setRadKijumbiSentaku(radKijumbiSentaku);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuKubun() {
        return this.getChushutsuJokenPanel().getDdlShikakuKubun();
    }

    @JsonIgnore
    public void setDdlShikakuKubun(DropDownList ddlShikakuKubun) {
        this.getChushutsuJokenPanel().setDdlShikakuKubun(ddlShikakuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlJukyushaHantei() {
        return this.getChushutsuJokenPanel().getDdlJukyushaHantei();
    }

    @JsonIgnore
    public void setDdlJukyushaHantei(DropDownList ddlJukyushaHantei) {
        this.getChushutsuJokenPanel().setDdlJukyushaHantei(ddlJukyushaHantei);
    }

    @JsonIgnore
    public DropDownList getDdlChosyuHoho() {
        return this.getChushutsuJokenPanel().getDdlChosyuHoho();
    }

    @JsonIgnore
    public void setDdlChosyuHoho(DropDownList ddlChosyuHoho) {
        this.getChushutsuJokenPanel().setDdlChosyuHoho(ddlChosyuHoho);
    }

    @JsonIgnore
    public CheckBoxList getChkHokenryoDankai() {
        return this.getChushutsuJokenPanel().getChkHokenryoDankai();
    }

    @JsonIgnore
    public void setChkHokenryoDankai(CheckBoxList chkHokenryoDankai) {
        this.getChushutsuJokenPanel().setChkHokenryoDankai(chkHokenryoDankai);
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
    public void setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    // </editor-fold>
}
