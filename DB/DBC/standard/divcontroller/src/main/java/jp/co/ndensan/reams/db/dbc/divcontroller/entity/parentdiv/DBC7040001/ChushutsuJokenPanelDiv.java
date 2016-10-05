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
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ChushutsuJokenPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChushutsuJokenPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linChusyutsuHani")
    private HorizontalLine linChusyutsuHani;
    @JsonProperty("radChushutsuHaniSentaku")
    private RadioButton radChushutsuHaniSentaku;
    @JsonProperty("Chushutsubi")
    private ChushutsubiDiv Chushutsubi;
    @JsonProperty("linKubunSentaku")
    private HorizontalLine linKubunSentaku;
    @JsonProperty("IdoKubun")
    private IdoKubunDiv IdoKubun;
    @JsonProperty("KogakuJohoChushutsuJoken")
    private KogakuJohoChushutsuJokenDiv KogakuJohoChushutsuJoken;
    @JsonProperty("KokuhorenJukyushaJohoChushutsuJoken")
    private KokuhorenJukyushaJohoChushutsuJokenDiv KokuhorenJukyushaJohoChushutsuJoken;
    @JsonProperty("linSakujoJoho")
    private HorizontalLine linSakujoJoho;
    @JsonProperty("chkSakujyoDataChushutsu")
    private CheckBoxList chkSakujyoDataChushutsu;
    @JsonProperty("ccdHokenshaList")
    private HokenshaListDiv ccdHokenshaList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinChusyutsuHani
     * @return linChusyutsuHani
     */
    @JsonProperty("linChusyutsuHani")
    public HorizontalLine getLinChusyutsuHani() {
        return linChusyutsuHani;
    }

    /*
     * setlinChusyutsuHani
     * @param linChusyutsuHani linChusyutsuHani
     */
    @JsonProperty("linChusyutsuHani")
    public void setLinChusyutsuHani(HorizontalLine linChusyutsuHani) {
        this.linChusyutsuHani = linChusyutsuHani;
    }

    /*
     * getradChushutsuHaniSentaku
     * @return radChushutsuHaniSentaku
     */
    @JsonProperty("radChushutsuHaniSentaku")
    public RadioButton getRadChushutsuHaniSentaku() {
        return radChushutsuHaniSentaku;
    }

    /*
     * setradChushutsuHaniSentaku
     * @param radChushutsuHaniSentaku radChushutsuHaniSentaku
     */
    @JsonProperty("radChushutsuHaniSentaku")
    public void setRadChushutsuHaniSentaku(RadioButton radChushutsuHaniSentaku) {
        this.radChushutsuHaniSentaku = radChushutsuHaniSentaku;
    }

    /*
     * getChushutsubi
     * @return Chushutsubi
     */
    @JsonProperty("Chushutsubi")
    public ChushutsubiDiv getChushutsubi() {
        return Chushutsubi;
    }

    /*
     * setChushutsubi
     * @param Chushutsubi Chushutsubi
     */
    @JsonProperty("Chushutsubi")
    public void setChushutsubi(ChushutsubiDiv Chushutsubi) {
        this.Chushutsubi = Chushutsubi;
    }

    /*
     * getlinKubunSentaku
     * @return linKubunSentaku
     */
    @JsonProperty("linKubunSentaku")
    public HorizontalLine getLinKubunSentaku() {
        return linKubunSentaku;
    }

    /*
     * setlinKubunSentaku
     * @param linKubunSentaku linKubunSentaku
     */
    @JsonProperty("linKubunSentaku")
    public void setLinKubunSentaku(HorizontalLine linKubunSentaku) {
        this.linKubunSentaku = linKubunSentaku;
    }

    /*
     * getIdoKubun
     * @return IdoKubun
     */
    @JsonProperty("IdoKubun")
    public IdoKubunDiv getIdoKubun() {
        return IdoKubun;
    }

    /*
     * setIdoKubun
     * @param IdoKubun IdoKubun
     */
    @JsonProperty("IdoKubun")
    public void setIdoKubun(IdoKubunDiv IdoKubun) {
        this.IdoKubun = IdoKubun;
    }

    /*
     * getKogakuJohoChushutsuJoken
     * @return KogakuJohoChushutsuJoken
     */
    @JsonProperty("KogakuJohoChushutsuJoken")
    public KogakuJohoChushutsuJokenDiv getKogakuJohoChushutsuJoken() {
        return KogakuJohoChushutsuJoken;
    }

    /*
     * setKogakuJohoChushutsuJoken
     * @param KogakuJohoChushutsuJoken KogakuJohoChushutsuJoken
     */
    @JsonProperty("KogakuJohoChushutsuJoken")
    public void setKogakuJohoChushutsuJoken(KogakuJohoChushutsuJokenDiv KogakuJohoChushutsuJoken) {
        this.KogakuJohoChushutsuJoken = KogakuJohoChushutsuJoken;
    }

    /*
     * getKokuhorenJukyushaJohoChushutsuJoken
     * @return KokuhorenJukyushaJohoChushutsuJoken
     */
    @JsonProperty("KokuhorenJukyushaJohoChushutsuJoken")
    public KokuhorenJukyushaJohoChushutsuJokenDiv getKokuhorenJukyushaJohoChushutsuJoken() {
        return KokuhorenJukyushaJohoChushutsuJoken;
    }

    /*
     * setKokuhorenJukyushaJohoChushutsuJoken
     * @param KokuhorenJukyushaJohoChushutsuJoken KokuhorenJukyushaJohoChushutsuJoken
     */
    @JsonProperty("KokuhorenJukyushaJohoChushutsuJoken")
    public void setKokuhorenJukyushaJohoChushutsuJoken(KokuhorenJukyushaJohoChushutsuJokenDiv KokuhorenJukyushaJohoChushutsuJoken) {
        this.KokuhorenJukyushaJohoChushutsuJoken = KokuhorenJukyushaJohoChushutsuJoken;
    }

    /*
     * getlinSakujoJoho
     * @return linSakujoJoho
     */
    @JsonProperty("linSakujoJoho")
    public HorizontalLine getLinSakujoJoho() {
        return linSakujoJoho;
    }

    /*
     * setlinSakujoJoho
     * @param linSakujoJoho linSakujoJoho
     */
    @JsonProperty("linSakujoJoho")
    public void setLinSakujoJoho(HorizontalLine linSakujoJoho) {
        this.linSakujoJoho = linSakujoJoho;
    }

    /*
     * getchkSakujyoDataChushutsu
     * @return chkSakujyoDataChushutsu
     */
    @JsonProperty("chkSakujyoDataChushutsu")
    public CheckBoxList getChkSakujyoDataChushutsu() {
        return chkSakujyoDataChushutsu;
    }

    /*
     * setchkSakujyoDataChushutsu
     * @param chkSakujyoDataChushutsu chkSakujyoDataChushutsu
     */
    @JsonProperty("chkSakujyoDataChushutsu")
    public void setChkSakujyoDataChushutsu(CheckBoxList chkSakujyoDataChushutsu) {
        this.chkSakujyoDataChushutsu = chkSakujyoDataChushutsu;
    }

    /*
     * getccdHokenshaList
     * @return ccdHokenshaList
     */
    @JsonProperty("ccdHokenshaList")
    public IHokenshaListDiv getCcdHokenshaList() {
        return ccdHokenshaList;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Space getYohaku() {
        return this.getChushutsubi().getYohaku();
    }

    @JsonIgnore
    public void  setYohaku(Space Yohaku) {
        this.getChushutsubi().setYohaku(Yohaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtShoriTaishoNengetsu() {
        return this.getChushutsubi().getTxtShoriTaishoNengetsu();
    }

    @JsonIgnore
    public void  setTxtShoriTaishoNengetsu(TextBoxDateRange txtShoriTaishoNengetsu) {
        this.getChushutsubi().setTxtShoriTaishoNengetsu(txtShoriTaishoNengetsu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtIdoNengetsu() {
        return this.getChushutsubi().getTxtIdoNengetsu();
    }

    @JsonIgnore
    public void  setTxtIdoNengetsu(TextBoxDateRange txtIdoNengetsu) {
        this.getChushutsubi().setTxtIdoNengetsu(txtIdoNengetsu);
    }

    @JsonIgnore
    public CheckBoxList getChkIdotukiSaisinJohoChushutsu() {
        return this.getChushutsubi().getChkIdotukiSaisinJohoChushutsu();
    }

    @JsonIgnore
    public void  setChkIdotukiSaisinJohoChushutsu(CheckBoxList chkIdotukiSaisinJohoChushutsu) {
        this.getChushutsubi().setChkIdotukiSaisinJohoChushutsu(chkIdotukiSaisinJohoChushutsu);
    }

    @JsonIgnore
    public CheckBoxList getChkIdokubunKodo1() {
        return this.getIdoKubun().getChkIdokubunKodo1();
    }

    @JsonIgnore
    public void  setChkIdokubunKodo1(CheckBoxList chkIdokubunKodo1) {
        this.getIdoKubun().setChkIdokubunKodo1(chkIdokubunKodo1);
    }

    @JsonIgnore
    public CheckBoxList getChkIdokubunKodo2() {
        return this.getKogakuJohoChushutsuJoken().getChkIdokubunKodo2();
    }

    @JsonIgnore
    public void  setChkIdokubunKodo2(CheckBoxList chkIdokubunKodo2) {
        this.getKogakuJohoChushutsuJoken().setChkIdokubunKodo2(chkIdokubunKodo2);
    }

    @JsonIgnore
    public CheckBoxList getChkSetaiShotokuKubun() {
        return this.getKogakuJohoChushutsuJoken().getChkSetaiShotokuKubun();
    }

    @JsonIgnore
    public void  setChkSetaiShotokuKubun(CheckBoxList chkSetaiShotokuKubun) {
        this.getKogakuJohoChushutsuJoken().setChkSetaiShotokuKubun(chkSetaiShotokuKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkShotokuKubun() {
        return this.getKogakuJohoChushutsuJoken().getChkShotokuKubun();
    }

    @JsonIgnore
    public void  setChkShotokuKubun(CheckBoxList chkShotokuKubun) {
        this.getKogakuJohoChushutsuJoken().setChkShotokuKubun(chkShotokuKubun);
    }

    @JsonIgnore
    public RadioButton getRadRoreiNenkinJukyuKubun() {
        return this.getKogakuJohoChushutsuJoken().getRadRoreiNenkinJukyuKubun();
    }

    @JsonIgnore
    public void  setRadRoreiNenkinJukyuKubun(RadioButton radRoreiNenkinJukyuKubun) {
        this.getKogakuJohoChushutsuJoken().setRadRoreiNenkinJukyuKubun(radRoreiNenkinJukyuKubun);
    }

    @JsonIgnore
    public RadioButton getRadRiyoshaFutanDai2Dankai() {
        return this.getKogakuJohoChushutsuJoken().getRadRiyoshaFutanDai2Dankai();
    }

    @JsonIgnore
    public void  setRadRiyoshaFutanDai2Dankai(RadioButton radRiyoshaFutanDai2Dankai) {
        this.getKogakuJohoChushutsuJoken().setRadRiyoshaFutanDai2Dankai(radRiyoshaFutanDai2Dankai);
    }

    @JsonIgnore
    public CheckBoxList getChkIdokubunKodo3() {
        return this.getKokuhorenJukyushaJohoChushutsuJoken().getChkIdokubunKodo3();
    }

    @JsonIgnore
    public void  setChkIdokubunKodo3(CheckBoxList chkIdokubunKodo3) {
        this.getKokuhorenJukyushaJohoChushutsuJoken().setChkIdokubunKodo3(chkIdokubunKodo3);
    }

    @JsonIgnore
    public CheckBoxList getChkMinashiYoKaigoKubun() {
        return this.getKokuhorenJukyushaJohoChushutsuJoken().getChkMinashiYoKaigoKubun();
    }

    @JsonIgnore
    public void  setChkMinashiYoKaigoKubun(CheckBoxList chkMinashiYoKaigoKubun) {
        this.getKokuhorenJukyushaJohoChushutsuJoken().setChkMinashiYoKaigoKubun(chkMinashiYoKaigoKubun);
    }

    @JsonIgnore
    public CheckBoxList getChkRiyoshaFutanKubunKodo() {
        return this.getKokuhorenJukyushaJohoChushutsuJoken().getChkRiyoshaFutanKubunKodo();
    }

    @JsonIgnore
    public void  setChkRiyoshaFutanKubunKodo(CheckBoxList chkRiyoshaFutanKubunKodo) {
        this.getKokuhorenJukyushaJohoChushutsuJoken().setChkRiyoshaFutanKubunKodo(chkRiyoshaFutanKubunKodo);
    }

    @JsonIgnore
    public CheckBoxList getChkTokuteiNyushoshaSabisuKubun() {
        return this.getKokuhorenJukyushaJohoChushutsuJoken().getChkTokuteiNyushoshaSabisuKubun();
    }

    @JsonIgnore
    public void  setChkTokuteiNyushoshaSabisuKubun(CheckBoxList chkTokuteiNyushoshaSabisuKubun) {
        this.getKokuhorenJukyushaJohoChushutsuJoken().setChkTokuteiNyushoshaSabisuKubun(chkTokuteiNyushoshaSabisuKubun);
    }

    @JsonIgnore
    public RadioButton getRadKohiFutangakuGengaku() {
        return this.getKokuhorenJukyushaJohoChushutsuJoken().getRadKohiFutangakuGengaku();
    }

    @JsonIgnore
    public void  setRadKohiFutangakuGengaku(RadioButton radKohiFutangakuGengaku) {
        this.getKokuhorenJukyushaJohoChushutsuJoken().setRadKohiFutangakuGengaku(radKohiFutangakuGengaku);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdkyotakuSienJigyoshaBango() {
        return this.getKokuhorenJukyushaJohoChushutsuJoken().getCcdkyotakuSienJigyoshaBango();
    }

    // </editor-fold>
}
