package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC7040001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.ChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokujun.ChohyoShutsuryokujun.IChohyoShutsuryokujunDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.ChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.chohyoshutsuryokukomoku.ChohyoShutsuryokuKomoku.IChohyoShutsuryokuKomokuDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.PanelBatchParameter;

/**
 * HanyoListParamKokurenJyukyujyaJyoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HanyoListParamKokurenJyukyujyaJyohoDiv extends PanelBatchParameter {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("JokenFukugenHozonlKihon")
    private JokenFukugenHozonlKihonDiv JokenFukugenHozonlKihon;
    @JsonProperty("JokenFukugenHozonlShokan")
    private JokenFukugenHozonlShokanDiv JokenFukugenHozonlShokan;
    @JsonProperty("JokenFukugenHozonlKogaku")
    private JokenFukugenHozonlKogakuDiv JokenFukugenHozonlKogaku;
    @JsonProperty("JokenFukugenHozonlKokuho")
    private JokenFukugenHozonlKokuhoDiv JokenFukugenHozonlKokuho;
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
     * getJokenFukugenHozonlKihon
     * @return JokenFukugenHozonlKihon
     */
    @JsonProperty("JokenFukugenHozonlKihon")
    public JokenFukugenHozonlKihonDiv getJokenFukugenHozonlKihon() {
        return JokenFukugenHozonlKihon;
    }

    /*
     * setJokenFukugenHozonlKihon
     * @param JokenFukugenHozonlKihon JokenFukugenHozonlKihon
     */
    @JsonProperty("JokenFukugenHozonlKihon")
    public void setJokenFukugenHozonlKihon(JokenFukugenHozonlKihonDiv JokenFukugenHozonlKihon) {
        this.JokenFukugenHozonlKihon = JokenFukugenHozonlKihon;
    }

    /*
     * getJokenFukugenHozonlShokan
     * @return JokenFukugenHozonlShokan
     */
    @JsonProperty("JokenFukugenHozonlShokan")
    public JokenFukugenHozonlShokanDiv getJokenFukugenHozonlShokan() {
        return JokenFukugenHozonlShokan;
    }

    /*
     * setJokenFukugenHozonlShokan
     * @param JokenFukugenHozonlShokan JokenFukugenHozonlShokan
     */
    @JsonProperty("JokenFukugenHozonlShokan")
    public void setJokenFukugenHozonlShokan(JokenFukugenHozonlShokanDiv JokenFukugenHozonlShokan) {
        this.JokenFukugenHozonlShokan = JokenFukugenHozonlShokan;
    }

    /*
     * getJokenFukugenHozonlKogaku
     * @return JokenFukugenHozonlKogaku
     */
    @JsonProperty("JokenFukugenHozonlKogaku")
    public JokenFukugenHozonlKogakuDiv getJokenFukugenHozonlKogaku() {
        return JokenFukugenHozonlKogaku;
    }

    /*
     * setJokenFukugenHozonlKogaku
     * @param JokenFukugenHozonlKogaku JokenFukugenHozonlKogaku
     */
    @JsonProperty("JokenFukugenHozonlKogaku")
    public void setJokenFukugenHozonlKogaku(JokenFukugenHozonlKogakuDiv JokenFukugenHozonlKogaku) {
        this.JokenFukugenHozonlKogaku = JokenFukugenHozonlKogaku;
    }

    /*
     * getJokenFukugenHozonlKokuho
     * @return JokenFukugenHozonlKokuho
     */
    @JsonProperty("JokenFukugenHozonlKokuho")
    public JokenFukugenHozonlKokuhoDiv getJokenFukugenHozonlKokuho() {
        return JokenFukugenHozonlKokuho;
    }

    /*
     * setJokenFukugenHozonlKokuho
     * @param JokenFukugenHozonlKokuho JokenFukugenHozonlKokuho
     */
    @JsonProperty("JokenFukugenHozonlKokuho")
    public void setJokenFukugenHozonlKokuho(JokenFukugenHozonlKokuhoDiv JokenFukugenHozonlKokuho) {
        this.JokenFukugenHozonlKokuho = JokenFukugenHozonlKokuho;
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
    public ButtonBatchParameterSave getBtnKihonBatchParameterSave() {
        return this.getJokenFukugenHozonlKihon().getBtnKihonBatchParameterSave();
    }

    @JsonIgnore
    public void  setBtnKihonBatchParameterSave(ButtonBatchParameterSave btnKihonBatchParameterSave) {
        this.getJokenFukugenHozonlKihon().setBtnKihonBatchParameterSave(btnKihonBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnKihonBatchParameterRestore() {
        return this.getJokenFukugenHozonlKihon().getBtnKihonBatchParameterRestore();
    }

    @JsonIgnore
    public void  setBtnKihonBatchParameterRestore(ButtonBatchParameterRestore btnKihonBatchParameterRestore) {
        this.getJokenFukugenHozonlKihon().setBtnKihonBatchParameterRestore(btnKihonBatchParameterRestore);
    }

    @JsonIgnore
    public ButtonBatchParameterSave getBtnShokanBatchParameterSave() {
        return this.getJokenFukugenHozonlShokan().getBtnShokanBatchParameterSave();
    }

    @JsonIgnore
    public void  setBtnShokanBatchParameterSave(ButtonBatchParameterSave btnShokanBatchParameterSave) {
        this.getJokenFukugenHozonlShokan().setBtnShokanBatchParameterSave(btnShokanBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnShokanBatchParameterRestore() {
        return this.getJokenFukugenHozonlShokan().getBtnShokanBatchParameterRestore();
    }

    @JsonIgnore
    public void  setBtnShokanBatchParameterRestore(ButtonBatchParameterRestore btnShokanBatchParameterRestore) {
        this.getJokenFukugenHozonlShokan().setBtnShokanBatchParameterRestore(btnShokanBatchParameterRestore);
    }

    @JsonIgnore
    public ButtonBatchParameterSave getBtnKogakuBatchParameterSave() {
        return this.getJokenFukugenHozonlKogaku().getBtnKogakuBatchParameterSave();
    }

    @JsonIgnore
    public void  setBtnKogakuBatchParameterSave(ButtonBatchParameterSave btnKogakuBatchParameterSave) {
        this.getJokenFukugenHozonlKogaku().setBtnKogakuBatchParameterSave(btnKogakuBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnKogakuBatchParameterRestore() {
        return this.getJokenFukugenHozonlKogaku().getBtnKogakuBatchParameterRestore();
    }

    @JsonIgnore
    public void  setBtnKogakuBatchParameterRestore(ButtonBatchParameterRestore btnKogakuBatchParameterRestore) {
        this.getJokenFukugenHozonlKogaku().setBtnKogakuBatchParameterRestore(btnKogakuBatchParameterRestore);
    }

    @JsonIgnore
    public ButtonBatchParameterSave getBtnKokuhoBatchParameterSave() {
        return this.getJokenFukugenHozonlKokuho().getBtnKokuhoBatchParameterSave();
    }

    @JsonIgnore
    public void  setBtnKokuhoBatchParameterSave(ButtonBatchParameterSave btnKokuhoBatchParameterSave) {
        this.getJokenFukugenHozonlKokuho().setBtnKokuhoBatchParameterSave(btnKokuhoBatchParameterSave);
    }

    @JsonIgnore
    public ButtonBatchParameterRestore getBtnKokuhoBatchParameterRestore() {
        return this.getJokenFukugenHozonlKokuho().getBtnKokuhoBatchParameterRestore();
    }

    @JsonIgnore
    public void  setBtnKokuhoBatchParameterRestore(ButtonBatchParameterRestore btnKokuhoBatchParameterRestore) {
        this.getJokenFukugenHozonlKokuho().setBtnKokuhoBatchParameterRestore(btnKokuhoBatchParameterRestore);
    }

    @JsonIgnore
    public HorizontalLine getLinChusyutsuHani() {
        return this.getChushutsuJokenPanel().getLinChusyutsuHani();
    }

    @JsonIgnore
    public void  setLinChusyutsuHani(HorizontalLine linChusyutsuHani) {
        this.getChushutsuJokenPanel().setLinChusyutsuHani(linChusyutsuHani);
    }

    @JsonIgnore
    public RadioButton getRadChushutsuHaniSentaku() {
        return this.getChushutsuJokenPanel().getRadChushutsuHaniSentaku();
    }

    @JsonIgnore
    public void  setRadChushutsuHaniSentaku(RadioButton radChushutsuHaniSentaku) {
        this.getChushutsuJokenPanel().setRadChushutsuHaniSentaku(radChushutsuHaniSentaku);
    }

    @JsonIgnore
    public ChushutsubiDiv getChushutsubi() {
        return this.getChushutsuJokenPanel().getChushutsubi();
    }

    @JsonIgnore
    public void  setChushutsubi(ChushutsubiDiv Chushutsubi) {
        this.getChushutsuJokenPanel().setChushutsubi(Chushutsubi);
    }

    @JsonIgnore
    public Space getYohaku() {
        return this.getChushutsuJokenPanel().getChushutsubi().getYohaku();
    }

    @JsonIgnore
    public void  setYohaku(Space Yohaku) {
        this.getChushutsuJokenPanel().getChushutsubi().setYohaku(Yohaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShoriTaishoNengetsu() {
        return this.getChushutsuJokenPanel().getChushutsubi().getTxtShoriTaishoNengetsu();
    }

    @JsonIgnore
    public void  setTxtShoriTaishoNengetsu(TextBoxDateRange txtShoriTaishoNengetsu) {
        this.getChushutsuJokenPanel().getChushutsubi().setTxtShoriTaishoNengetsu(txtShoriTaishoNengetsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtIdoNengetsu() {
        return this.getChushutsuJokenPanel().getChushutsubi().getTxtIdoNengetsu();
    }

    @JsonIgnore
    public void  setTxtIdoNengetsu(TextBoxDateRange txtIdoNengetsu) {
        this.getChushutsuJokenPanel().getChushutsubi().setTxtIdoNengetsu(txtIdoNengetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkIdotukiSaisinJohoChushutsu() {
        return this.getChushutsuJokenPanel().getChushutsubi().getChkIdotukiSaisinJohoChushutsu();
    }

    @JsonIgnore
    public void  setChkIdotukiSaisinJohoChushutsu(CheckBoxList chkIdotukiSaisinJohoChushutsu) {
        this.getChushutsuJokenPanel().getChushutsubi().setChkIdotukiSaisinJohoChushutsu(chkIdotukiSaisinJohoChushutsu);
    }

    @JsonIgnore
    public HorizontalLine getLinKubunSentaku() {
        return this.getChushutsuJokenPanel().getLinKubunSentaku();
    }

    @JsonIgnore
    public void  setLinKubunSentaku(HorizontalLine linKubunSentaku) {
        this.getChushutsuJokenPanel().setLinKubunSentaku(linKubunSentaku);
    }

    @JsonIgnore
    public IdoKubunDiv getIdoKubun() {
        return this.getChushutsuJokenPanel().getIdoKubun();
    }

    @JsonIgnore
    public void  setIdoKubun(IdoKubunDiv IdoKubun) {
        this.getChushutsuJokenPanel().setIdoKubun(IdoKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkIdokubunKodo1() {
        return this.getChushutsuJokenPanel().getIdoKubun().getChkIdokubunKodo1();
    }

    @JsonIgnore
    public void  setChkIdokubunKodo1(CheckBoxList chkIdokubunKodo1) {
        this.getChushutsuJokenPanel().getIdoKubun().setChkIdokubunKodo1(chkIdokubunKodo1);
    }

    @JsonIgnore
    public KogakuJohoChushutsuJokenDiv getKogakuJohoChushutsuJoken() {
        return this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken();
    }

    @JsonIgnore
    public void  setKogakuJohoChushutsuJoken(KogakuJohoChushutsuJokenDiv KogakuJohoChushutsuJoken) {
        this.getChushutsuJokenPanel().setKogakuJohoChushutsuJoken(KogakuJohoChushutsuJoken);
    }

    @JsonIgnore
    public CheckBoxList getChkIdokubunKodo2() {
        return this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken().getChkIdokubunKodo2();
    }

    @JsonIgnore
    public void  setChkIdokubunKodo2(CheckBoxList chkIdokubunKodo2) {
        this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken().setChkIdokubunKodo2(chkIdokubunKodo2);
    }

    @JsonIgnore
    public CheckBoxList getChkSetaiShotokuKubun() {
        return this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken().getChkSetaiShotokuKubun();
    }

    @JsonIgnore
    public void  setChkSetaiShotokuKubun(CheckBoxList chkSetaiShotokuKubun) {
        this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken().setChkSetaiShotokuKubun(chkSetaiShotokuKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkShotokuKubun() {
        return this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken().getChkShotokuKubun();
    }

    @JsonIgnore
    public void  setChkShotokuKubun(CheckBoxList chkShotokuKubun) {
        this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken().setChkShotokuKubun(chkShotokuKubun);
    }

    @JsonIgnore
    public RadioButton getRadRoreiNenkinJukyuKubun() {
        return this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken().getRadRoreiNenkinJukyuKubun();
    }

    @JsonIgnore
    public void  setRadRoreiNenkinJukyuKubun(RadioButton radRoreiNenkinJukyuKubun) {
        this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken().setRadRoreiNenkinJukyuKubun(radRoreiNenkinJukyuKubun);
    }

    @JsonIgnore
    public RadioButton getRadRiyoshaFutanDai2Dankai() {
        return this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken().getRadRiyoshaFutanDai2Dankai();
    }

    @JsonIgnore
    public void  setRadRiyoshaFutanDai2Dankai(RadioButton radRiyoshaFutanDai2Dankai) {
        this.getChushutsuJokenPanel().getKogakuJohoChushutsuJoken().setRadRiyoshaFutanDai2Dankai(radRiyoshaFutanDai2Dankai);
    }

    @JsonIgnore
    public KokuhorenJukyushaJohoChushutsuJokenDiv getKokuhorenJukyushaJohoChushutsuJoken() {
        return this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken();
    }

    @JsonIgnore
    public void  setKokuhorenJukyushaJohoChushutsuJoken(KokuhorenJukyushaJohoChushutsuJokenDiv KokuhorenJukyushaJohoChushutsuJoken) {
        this.getChushutsuJokenPanel().setKokuhorenJukyushaJohoChushutsuJoken(KokuhorenJukyushaJohoChushutsuJoken);
    }

    @JsonIgnore
    public CheckBoxList getChkIdokubunKodo3() {
        return this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().getChkIdokubunKodo3();
    }

    @JsonIgnore
    public void  setChkIdokubunKodo3(CheckBoxList chkIdokubunKodo3) {
        this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().setChkIdokubunKodo3(chkIdokubunKodo3);
    }

    @JsonIgnore
    public CheckBoxList getChkMinashiYoKaigoKubun() {
        return this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().getChkMinashiYoKaigoKubun();
    }

    @JsonIgnore
    public void  setChkMinashiYoKaigoKubun(CheckBoxList chkMinashiYoKaigoKubun) {
        this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().setChkMinashiYoKaigoKubun(chkMinashiYoKaigoKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkRiyoshaFutanKubunKodo() {
        return this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().getChkRiyoshaFutanKubunKodo();
    }

    @JsonIgnore
    public void  setChkRiyoshaFutanKubunKodo(CheckBoxList chkRiyoshaFutanKubunKodo) {
        this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().setChkRiyoshaFutanKubunKodo(chkRiyoshaFutanKubunKodo);
    }

    @JsonIgnore
    public CheckBoxList getChkTokuteiNyushoshaSabisuKubun() {
        return this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().getChkTokuteiNyushoshaSabisuKubun();
    }

    @JsonIgnore
    public void  setChkTokuteiNyushoshaSabisuKubun(CheckBoxList chkTokuteiNyushoshaSabisuKubun) {
        this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().setChkTokuteiNyushoshaSabisuKubun(chkTokuteiNyushoshaSabisuKubun);
    }

    @JsonIgnore
    public RadioButton getRadKohiFutangakuGengaku() {
        return this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().getRadKohiFutangakuGengaku();
    }

    @JsonIgnore
    public void  setRadKohiFutangakuGengaku(RadioButton radKohiFutangakuGengaku) {
        this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().setRadKohiFutangakuGengaku(radKohiFutangakuGengaku);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdkyotakuSienJigyoshaBango() {
        return this.getChushutsuJokenPanel().getKokuhorenJukyushaJohoChushutsuJoken().getCcdkyotakuSienJigyoshaBango();
    }

    @JsonIgnore
    public HorizontalLine getLinSakujoJoho() {
        return this.getChushutsuJokenPanel().getLinSakujoJoho();
    }

    @JsonIgnore
    public void  setLinSakujoJoho(HorizontalLine linSakujoJoho) {
        this.getChushutsuJokenPanel().setLinSakujoJoho(linSakujoJoho);
    }

    @JsonIgnore
    public CheckBoxList getChkSakujyoDataChushutsu() {
        return this.getChushutsuJokenPanel().getChkSakujyoDataChushutsu();
    }

    @JsonIgnore
    public void  setChkSakujyoDataChushutsu(CheckBoxList chkSakujyoDataChushutsu) {
        this.getChushutsuJokenPanel().setChkSakujyoDataChushutsu(chkSakujyoDataChushutsu);
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
    public void  setChkCsvHenshuHoho(CheckBoxList chkCsvHenshuHoho) {
        this.getDvCsvHenshuHoho().setChkCsvHenshuHoho(chkCsvHenshuHoho);
    }

    // </editor-fold>
}
