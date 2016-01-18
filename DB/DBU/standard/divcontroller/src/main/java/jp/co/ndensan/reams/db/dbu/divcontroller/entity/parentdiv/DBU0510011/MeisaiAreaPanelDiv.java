package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * MeisaiAreaPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MeisaiAreaPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtShiseibi")
    private TextBoxDate txtShiseibi;
    @JsonProperty("radSochiGaitouKubun")
    private RadioButton radSochiGaitouKubun;
    @JsonProperty("txtKeteibi")
    private TextBoxDate txtKeteibi;
    @JsonProperty("txtKaishibi")
    private TextBoxDate txtKaishibi;
    @JsonProperty("txtShuryobi")
    private TextBoxDate txtShuryobi;
    @JsonProperty("tbMeisai")
    private tbMeisaiDiv tbMeisai;
    @JsonProperty("RirekiNo")
    private RString RirekiNo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtShiseibi
     * @return txtShiseibi
     */
    @JsonProperty("txtShiseibi")
    public TextBoxDate getTxtShiseibi() {
        return txtShiseibi;
    }

    /*
     * settxtShiseibi
     * @param txtShiseibi txtShiseibi
     */
    @JsonProperty("txtShiseibi")
    public void setTxtShiseibi(TextBoxDate txtShiseibi) {
        this.txtShiseibi = txtShiseibi;
    }

    /*
     * getradSochiGaitouKubun
     * @return radSochiGaitouKubun
     */
    @JsonProperty("radSochiGaitouKubun")
    public RadioButton getRadSochiGaitouKubun() {
        return radSochiGaitouKubun;
    }

    /*
     * setradSochiGaitouKubun
     * @param radSochiGaitouKubun radSochiGaitouKubun
     */
    @JsonProperty("radSochiGaitouKubun")
    public void setRadSochiGaitouKubun(RadioButton radSochiGaitouKubun) {
        this.radSochiGaitouKubun = radSochiGaitouKubun;
    }

    /*
     * gettxtKeteibi
     * @return txtKeteibi
     */
    @JsonProperty("txtKeteibi")
    public TextBoxDate getTxtKeteibi() {
        return txtKeteibi;
    }

    /*
     * settxtKeteibi
     * @param txtKeteibi txtKeteibi
     */
    @JsonProperty("txtKeteibi")
    public void setTxtKeteibi(TextBoxDate txtKeteibi) {
        this.txtKeteibi = txtKeteibi;
    }

    /*
     * gettxtKaishibi
     * @return txtKaishibi
     */
    @JsonProperty("txtKaishibi")
    public TextBoxDate getTxtKaishibi() {
        return txtKaishibi;
    }

    /*
     * settxtKaishibi
     * @param txtKaishibi txtKaishibi
     */
    @JsonProperty("txtKaishibi")
    public void setTxtKaishibi(TextBoxDate txtKaishibi) {
        this.txtKaishibi = txtKaishibi;
    }

    /*
     * gettxtShuryobi
     * @return txtShuryobi
     */
    @JsonProperty("txtShuryobi")
    public TextBoxDate getTxtShuryobi() {
        return txtShuryobi;
    }

    /*
     * settxtShuryobi
     * @param txtShuryobi txtShuryobi
     */
    @JsonProperty("txtShuryobi")
    public void setTxtShuryobi(TextBoxDate txtShuryobi) {
        this.txtShuryobi = txtShuryobi;
    }

    /*
     * gettbMeisai
     * @return tbMeisai
     */
    @JsonProperty("tbMeisai")
    public tbMeisaiDiv getTbMeisai() {
        return tbMeisai;
    }

    /*
     * settbMeisai
     * @param tbMeisai tbMeisai
     */
    @JsonProperty("tbMeisai")
    public void setTbMeisai(tbMeisaiDiv tbMeisai) {
        this.tbMeisai = tbMeisai;
    }

    /*
     * getRirekiNo
     * @return RirekiNo
     */
    @JsonProperty("RirekiNo")
    public RString getRirekiNo() {
        return RirekiNo;
    }

    /*
     * setRirekiNo
     * @param RirekiNo RirekiNo
     */
    @JsonProperty("RirekiNo")
    public void setRirekiNo(RString RirekiNo) {
        this.RirekiNo = RirekiNo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tabKeteiJohoDiv getTabKeteiJoho() {
        return this.getTbMeisai().getTabKeteiJoho();
    }

    @JsonIgnore
    public void  setTabKeteiJoho(tabKeteiJohoDiv tabKeteiJoho) {
        this.getTbMeisai().setTabKeteiJoho(tabKeteiJoho);
    }

    @JsonIgnore
    public KyufugakuGengakuKisaiKaijyoDiv getKyufugakuGengakuKisaiKaijyo() {
        return this.getTbMeisai().getTabKeteiJoho().getKyufugakuGengakuKisaiKaijyo();
    }

    @JsonIgnore
    public void  setKyufugakuGengakuKisaiKaijyo(KyufugakuGengakuKisaiKaijyoDiv KyufugakuGengakuKisaiKaijyo) {
        this.getTbMeisai().getTabKeteiJoho().setKyufugakuGengakuKisaiKaijyo(KyufugakuGengakuKisaiKaijyo);
    }

    @JsonIgnore
    public RadioButton getRadKyufukakuGengakuKisaiKaijyo() {
        return this.getTbMeisai().getTabKeteiJoho().getKyufugakuGengakuKisaiKaijyo().getRadKyufukakuGengakuKisaiKaijyo();
    }

    @JsonIgnore
    public void  setRadKyufukakuGengakuKisaiKaijyo(RadioButton radKyufukakuGengakuKisaiKaijyo) {
        this.getTbMeisai().getTabKeteiJoho().getKyufugakuGengakuKisaiKaijyo().setRadKyufukakuGengakuKisaiKaijyo(radKyufukakuGengakuKisaiKaijyo);
    }

    @JsonIgnore
    public HyojunFutanGakuPanelDiv getHyojunFutanGakuPanel() {
        return this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel();
    }

    @JsonIgnore
    public void  setHyojunFutanGakuPanel(HyojunFutanGakuPanelDiv HyojunFutanGakuPanel) {
        this.getTbMeisai().getTabKeteiJoho().setHyojunFutanGakuPanel(HyojunFutanGakuPanel);
    }

    @JsonIgnore
    public RadioButton getRadHyojunFutanGaku() {
        return this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().getRadHyojunFutanGaku();
    }

    @JsonIgnore
    public void  setRadHyojunFutanGaku(RadioButton radHyojunFutanGaku) {
        this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().setRadHyojunFutanGaku(radHyojunFutanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyojunFutanKeigenAtoFutanGaku() {
        return this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().getTxtHyojunFutanKeigenAtoFutanGaku();
    }

    @JsonIgnore
    public void  setTxtHyojunFutanKeigenAtoFutanGaku(TextBoxNum txtHyojunFutanKeigenAtoFutanGaku) {
        this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().setTxtHyojunFutanKeigenAtoFutanGaku(txtHyojunFutanKeigenAtoFutanGaku);
    }

    @JsonIgnore
    public RadioButton getRadKyojuhiFutanGakuGengaku() {
        return this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().getRadKyojuhiFutanGakuGengaku();
    }

    @JsonIgnore
    public void  setRadKyojuhiFutanGakuGengaku(RadioButton radKyojuhiFutanGakuGengaku) {
        this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().setRadKyojuhiFutanGakuGengaku(radKyojuhiFutanGakuGengaku);
    }

    @JsonIgnore
    public DropDownList getDdlKyoshituShurui() {
        return this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().getDdlKyoshituShurui();
    }

    @JsonIgnore
    public void  setDdlKyoshituShurui(DropDownList ddlKyoshituShurui) {
        this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().setDdlKyoshituShurui(ddlKyoshituShurui);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenAtoFutanGaku() {
        return this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().getTxtKeigenAtoFutanGaku();
    }

    @JsonIgnore
    public void  setTxtKeigenAtoFutanGaku(TextBoxNum txtKeigenAtoFutanGaku) {
        this.getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().setTxtKeigenAtoFutanGaku(txtKeigenAtoFutanGaku);
    }

    @JsonIgnore
    public GogakuServiceJogengakuGengakuDiv getGogakuServiceJogengakuGengaku() {
        return this.getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku();
    }

    @JsonIgnore
    public void  setGogakuServiceJogengakuGengaku(GogakuServiceJogengakuGengakuDiv GogakuServiceJogengakuGengaku) {
        this.getTbMeisai().getTabKeteiJoho().setGogakuServiceJogengakuGengaku(GogakuServiceJogengakuGengaku);
    }

    @JsonIgnore
    public RadioButton getRadShokuhiFutangakuGengaku() {
        return this.getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getRadShokuhiFutangakuGengaku();
    }

    @JsonIgnore
    public void  setRadShokuhiFutangakuGengaku(RadioButton radShokuhiFutangakuGengaku) {
        this.getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setRadShokuhiFutangakuGengaku(radShokuhiFutangakuGengaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiGenkenAtoFutangaku() {
        return this.getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getTxtShokuhiGenkenAtoFutangaku();
    }

    @JsonIgnore
    public void  setTxtShokuhiGenkenAtoFutangaku(TextBoxNum txtShokuhiGenkenAtoFutangaku) {
        this.getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setTxtShokuhiGenkenAtoFutangaku(txtShokuhiGenkenAtoFutangaku);
    }

    @JsonIgnore
    public RadioButton getRadGogakuServiceJokengaku() {
        return this.getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getRadGogakuServiceJokengaku();
    }

    @JsonIgnore
    public void  setRadGogakuServiceJokengaku(RadioButton radGogakuServiceJokengaku) {
        this.getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setRadGogakuServiceJokengaku(radGogakuServiceJokengaku);
    }

    @JsonIgnore
    public DropDownList getDdlSeidaiJogengaku() {
        return this.getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getDdlSeidaiJogengaku();
    }

    @JsonIgnore
    public void  setDdlSeidaiJogengaku(DropDownList ddlSeidaiJogengaku) {
        this.getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setDdlSeidaiJogengaku(ddlSeidaiJogengaku);
    }

    @JsonIgnore
    public HokenryoNofuGengakuDiv getHokenryoNofuGengaku() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku();
    }

    @JsonIgnore
    public void  setHokenryoNofuGengaku(HokenryoNofuGengakuDiv HokenryoNofuGengaku) {
        this.getTbMeisai().getTabKeteiJoho().setHokenryoNofuGengaku(HokenryoNofuGengaku);
    }

    @JsonIgnore
    public RadioButton getRadHokenryoNofuGengaku() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getRadHokenryoNofuGengaku();
    }

    @JsonIgnore
    public void  setRadHokenryoNofuGengaku(RadioButton radHokenryoNofuGengaku) {
        this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().setRadHokenryoNofuGengaku(radHokenryoNofuGengaku);
    }

    @JsonIgnore
    public HohenryoNofuPanelDiv getHohenryoNofuPanel() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel();
    }

    @JsonIgnore
    public void  setHohenryoNofuPanel(HohenryoNofuPanelDiv HohenryoNofuPanel) {
        this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().setHohenryoNofuPanel(HohenryoNofuPanel);
    }

    @JsonIgnore
    public Button getBtnTuikaSuru() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().getBtnTuikaSuru();
    }

    @JsonIgnore
    public void  setBtnTuikaSuru(Button btnTuikaSuru) {
        this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().setBtnTuikaSuru(btnTuikaSuru);
    }

    @JsonIgnore
    public DataGrid<dghokenryoNofu_Row> getDghokenryoNofu() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().getDghokenryoNofu();
    }

    @JsonIgnore
    public void  setDghokenryoNofu(DataGrid<dghokenryoNofu_Row> dghokenryoNofu) {
        this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().setDghokenryoNofu(dghokenryoNofu);
    }

    @JsonIgnore
    public HohenryoNofuNyuryokuDiv getHohenryoNofuNyuryoku() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku();
    }

    @JsonIgnore
    public void  setHohenryoNofuNyuryoku(HohenryoNofuNyuryokuDiv HohenryoNofuNyuryoku) {
        this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().setHohenryoNofuNyuryoku(HohenryoNofuNyuryoku);
    }

    @JsonIgnore
    public TextBoxDate getTxtHohenryoNofuFromDate() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getTxtHohenryoNofuFromDate();
    }

    @JsonIgnore
    public void  setTxtHohenryoNofuFromDate(TextBoxDate txtHohenryoNofuFromDate) {
        this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setTxtHohenryoNofuFromDate(txtHohenryoNofuFromDate);
    }

    @JsonIgnore
    public TextBoxDate getTxtHohenryoNofuToDate() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getTxtHohenryoNofuToDate();
    }

    @JsonIgnore
    public void  setTxtHohenryoNofuToDate(TextBoxDate txtHohenryoNofuToDate) {
        this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setTxtHohenryoNofuToDate(txtHohenryoNofuToDate);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyouSuruShutokuDankai() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getDdlTekiyouSuruShutokuDankai();
    }

    @JsonIgnore
    public void  setDdlTekiyouSuruShutokuDankai(DropDownList ddlTekiyouSuruShutokuDankai) {
        this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setDdlTekiyouSuruShutokuDankai(ddlTekiyouSuruShutokuDankai);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public tabShomeishoJohoDiv getTabShomeishoJoho() {
        return this.getTbMeisai().getTabShomeishoJoho();
    }

    @JsonIgnore
    public void  setTabShomeishoJoho(tabShomeishoJohoDiv tabShomeishoJoho) {
        this.getTbMeisai().setTabShomeishoJoho(tabShomeishoJoho);
    }

    @JsonIgnore
    public ShomeishoNaiyoDiv getShomeishoNaiyo() {
        return this.getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo();
    }

    @JsonIgnore
    public void  setShomeishoNaiyo(ShomeishoNaiyoDiv ShomeishoNaiyo) {
        this.getTbMeisai().getTabShomeishoJoho().setShomeishoNaiyo(ShomeishoNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShiseiHaishibi() {
        return this.getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().getTxtShiseiHaishibi();
    }

    @JsonIgnore
    public void  setTxtShiseiHaishibi(TextBoxDate txtShiseiHaishibi) {
        this.getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().setTxtShiseiHaishibi(txtShiseiHaishibi);
    }

    @JsonIgnore
    public TextBoxNum getTxtHogoFuyoKonshoGengakuKingaku() {
        return this.getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().getTxtHogoFuyoKonshoGengakuKingaku();
    }

    @JsonIgnore
    public void  setTxtHogoFuyoKonshoGengakuKingaku(TextBoxNum txtHogoFuyoKonshoGengakuKingaku) {
        this.getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().setTxtHogoFuyoKonshoGengakuKingaku(txtHogoFuyoKonshoGengakuKingaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtShomeishoKoufuDate() {
        return this.getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().getTxtShomeishoKoufuDate();
    }

    @JsonIgnore
    public void  setTxtShomeishoKoufuDate(TextBoxDate txtShomeishoKoufuDate) {
        this.getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().setTxtShomeishoKoufuDate(txtShomeishoKoufuDate);
    }

    @JsonIgnore
    public KyokaisoGaitouSochiNaiyoDiv getKyokaisoGaitouSochiNaiyo() {
        return this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo();
    }

    @JsonIgnore
    public void  setKyokaisoGaitouSochiNaiyo(KyokaisoGaitouSochiNaiyoDiv KyokaisoGaitouSochiNaiyo) {
        this.getTbMeisai().getTabShomeishoJoho().setKyokaisoGaitouSochiNaiyo(KyokaisoGaitouSochiNaiyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufugakuJikoFutanGetsugaku() {
        return this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtKyufugakuJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKyufugakuJikoFutanGetsugaku(TextBoxNum txtKyufugakuJikoFutanGetsugaku) {
        this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtKyufugakuJikoFutanGetsugaku(txtKyufugakuJikoFutanGetsugaku);
    }

    @JsonIgnore
    public DropDownList getDdlKyojuhiGendogakuDankai() {
        return this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getDdlKyojuhiGendogakuDankai();
    }

    @JsonIgnore
    public void  setDdlKyojuhiGendogakuDankai(DropDownList ddlKyojuhiGendogakuDankai) {
        this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setDdlKyojuhiGendogakuDankai(ddlKyojuhiGendogakuDankai);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyojuhiJikoFutanGetsugaku() {
        return this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtKyojuhiJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKyojuhiJikoFutanGetsugaku(TextBoxNum txtKyojuhiJikoFutanGetsugaku) {
        this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtKyojuhiJikoFutanGetsugaku(txtKyojuhiJikoFutanGetsugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiJikoFutanGetsugaku() {
        return this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtShokuhiJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtShokuhiJikoFutanGetsugaku(TextBoxNum txtShokuhiJikoFutanGetsugaku) {
        this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtShokuhiJikoFutanGetsugaku(txtShokuhiJikoFutanGetsugaku);
    }

    @JsonIgnore
    public DropDownList getDdlShokuhiGakenFutanGendogakuDankai() {
        return this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getDdlShokuhiGakenFutanGendogakuDankai();
    }

    @JsonIgnore
    public void  setDdlShokuhiGakenFutanGendogakuDankai(DropDownList ddlShokuhiGakenFutanGendogakuDankai) {
        this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setDdlShokuhiGakenFutanGendogakuDankai(ddlShokuhiGakenFutanGendogakuDankai);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoHokenryoJikoFutanGetsugaku() {
        return this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtKaigoHokenryoJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKaigoHokenryoJikoFutanGetsugaku(TextBoxNum txtKaigoHokenryoJikoFutanGetsugaku) {
        this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtKaigoHokenryoJikoFutanGetsugaku(txtKaigoHokenryoJikoFutanGetsugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanSeidaiGokeigaku() {
        return this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtRiyoshaFutanSeidaiGokeigaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanSeidaiGokeigaku(TextBoxNum txtRiyoshaFutanSeidaiGokeigaku) {
        this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtRiyoshaFutanSeidaiGokeigaku(txtRiyoshaFutanSeidaiGokeigaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtJikoFutanGetsugakuGokeigaku() {
        return this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtJikoFutanGetsugakuGokeigaku();
    }

    @JsonIgnore
    public void  setTxtJikoFutanGetsugakuGokeigaku(TextBoxNum txtJikoFutanGetsugakuGokeigaku) {
        this.getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtJikoFutanGetsugakuGokeigaku(txtJikoFutanGetsugakuGokeigaku);
    }

    // </editor-fold>
}
