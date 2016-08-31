package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7200001;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterRestore;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonBatchParameterSave;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.Space;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;

/**
 * HanyoListBatchParam のクラスファイル
 *
 * @author 自動生成
 */
public class HanyoListBatchParamDiv extends PanelBatchParameter {

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
    @JsonProperty("ccdShutsuryokujun")
    private ChohyoShutsuryokujunDiv ccdShutsuryokujun;
    @JsonProperty("ccdShutsuryokuKoumoku")
    private ChohyoShutsuryokuKomokuDiv ccdShutsuryokuKoumoku;
    @JsonProperty("hdnDonyuKeitai")
    private RString hdnDonyuKeitai;

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
     * gethdnDonyuKeitai
     * @return hdnDonyuKeitai
     */
    @JsonProperty("hdnDonyuKeitai")
    public RString getHdnDonyuKeitai() {
        return hdnDonyuKeitai;
    }

    /*
     * sethdnDonyuKeitai
     * @param hdnDonyuKeitai hdnDonyuKeitai
     */
    @JsonProperty("hdnDonyuKeitai")
    public void setHdnDonyuKeitai(RString hdnDonyuKeitai) {
        this.hdnDonyuKeitai = hdnDonyuKeitai;
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
    public DropDownList getDdlTaishoNendo() {
        return this.getChushutsuJokenPanel().getDdlTaishoNendo();
    }

    @JsonIgnore
    public void setDdlTaishoNendo(DropDownList ddlTaishoNendo) {
        this.getChushutsuJokenPanel().setDdlTaishoNendo(ddlTaishoNendo);
    }

    @JsonIgnore
    public CheckBoxList getChkSakujyoDataChushutsu() {
        return this.getChushutsuJokenPanel().getChkSakujyoDataChushutsu();
    }

    @JsonIgnore
    public void setChkSakujyoDataChushutsu(CheckBoxList chkSakujyoDataChushutsu) {
        this.getChushutsuJokenPanel().setChkSakujyoDataChushutsu(chkSakujyoDataChushutsu);
    }

    @JsonIgnore
    public DetaShubetsuDiv getDetaShubetsu() {
        return this.getChushutsuJokenPanel().getDetaShubetsu();
    }

    @JsonIgnore
    public void setDetaShubetsu(DetaShubetsuDiv DetaShubetsu) {
        this.getChushutsuJokenPanel().setDetaShubetsu(DetaShubetsu);
    }

    @JsonIgnore
    public RadioButton getRadDetaShubetsu() {
        return this.getChushutsuJokenPanel().getDetaShubetsu().getRadDetaShubetsu();
    }

    @JsonIgnore
    public void setRadDetaShubetsu(RadioButton radDetaShubetsu) {
        this.getChushutsuJokenPanel().getDetaShubetsu().setRadDetaShubetsu(radDetaShubetsu);
    }

    @JsonIgnore
    public ChushutsuKubunDiv getChushutsuKubun() {
        return this.getChushutsuJokenPanel().getChushutsuKubun();
    }

    @JsonIgnore
    public void setChushutsuKubun(ChushutsuKubunDiv ChushutsuKubun) {
        this.getChushutsuJokenPanel().setChushutsuKubun(ChushutsuKubun);
    }

    @JsonIgnore
    public Space getYohaku1() {
        return this.getChushutsuJokenPanel().getChushutsuKubun().getYohaku1();
    }

    @JsonIgnore
    public void setYohaku1(Space Yohaku1) {
        this.getChushutsuJokenPanel().getChushutsuKubun().setYohaku1(Yohaku1);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuKubun() {
        return this.getChushutsuJokenPanel().getChushutsuKubun().getRadChushutsuKubun();
    }

    @JsonIgnore
    public void setRadChushutsuKubun(RadioButton radChushutsuKubun) {
        this.getChushutsuJokenPanel().getChushutsuKubun().setRadChushutsuKubun(radChushutsuKubun);
    }

    @JsonIgnore
    public KijyunbiDiv getKijyunbi() {
        return this.getChushutsuJokenPanel().getChushutsuKubun().getKijyunbi();
    }

    @JsonIgnore
    public void setKijyunbi(KijyunbiDiv Kijyunbi) {
        this.getChushutsuJokenPanel().getChushutsuKubun().setKijyunbi(Kijyunbi);
    }

    @JsonIgnore
    public Space getYohaku2() {
        return this.getChushutsuJokenPanel().getChushutsuKubun().getKijyunbi().getYohaku2();
    }

    @JsonIgnore
    public void setYohaku2(Space Yohaku2) {
        this.getChushutsuJokenPanel().getChushutsuKubun().getKijyunbi().setYohaku2(Yohaku2);
    }

    @JsonIgnore
    public TextBoxDate getTxtKijyunnNengetsu() {
        return this.getChushutsuJokenPanel().getChushutsuKubun().getKijyunbi().getTxtKijyunnNengetsu();
    }

    @JsonIgnore
    public void setTxtKijyunnNengetsu(TextBoxDate txtKijyunnNengetsu) {
        this.getChushutsuJokenPanel().getChushutsuKubun().getKijyunbi().setTxtKijyunnNengetsu(txtKijyunnNengetsu);
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
    public TextBoxDateRange getTxtKetteibi() {
        return this.getChushutsuJokenPanel().getTxtKetteibi();
    }

    @JsonIgnore
    public void setTxtKetteibi(TextBoxDateRange txtKetteibi) {
        this.getChushutsuJokenPanel().setTxtKetteibi(txtKetteibi);
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
