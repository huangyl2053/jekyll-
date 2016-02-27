package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tbMeisai のクラスファイル 
 * 
 * @author 自動生成
 */
public class tbMeisaiDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabKeteiJoho")
    private tabKeteiJohoDiv tabKeteiJoho;
    @JsonProperty("tabShomeishoJoho")
    private tabShomeishoJohoDiv tabShomeishoJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabKeteiJoho
     * @return tabKeteiJoho
     */
    @JsonProperty("tabKeteiJoho")
    public tabKeteiJohoDiv getTabKeteiJoho() {
        return tabKeteiJoho;
    }

    /*
     * settabKeteiJoho
     * @param tabKeteiJoho tabKeteiJoho
     */
    @JsonProperty("tabKeteiJoho")
    public void setTabKeteiJoho(tabKeteiJohoDiv tabKeteiJoho) {
        this.tabKeteiJoho = tabKeteiJoho;
    }

    /*
     * gettabShomeishoJoho
     * @return tabShomeishoJoho
     */
    @JsonProperty("tabShomeishoJoho")
    public tabShomeishoJohoDiv getTabShomeishoJoho() {
        return tabShomeishoJoho;
    }

    /*
     * settabShomeishoJoho
     * @param tabShomeishoJoho tabShomeishoJoho
     */
    @JsonProperty("tabShomeishoJoho")
    public void setTabShomeishoJoho(tabShomeishoJohoDiv tabShomeishoJoho) {
        this.tabShomeishoJoho = tabShomeishoJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KyufugakuGengakuKisaiKaijyoDiv getKyufugakuGengakuKisaiKaijyo() {
        return this.getTabKeteiJoho().getKyufugakuGengakuKisaiKaijyo();
    }

    @JsonIgnore
    public void  setKyufugakuGengakuKisaiKaijyo(KyufugakuGengakuKisaiKaijyoDiv KyufugakuGengakuKisaiKaijyo) {
        this.getTabKeteiJoho().setKyufugakuGengakuKisaiKaijyo(KyufugakuGengakuKisaiKaijyo);
    }

    @JsonIgnore
    public RadioButton getRadKyufukakuGengakuKisaiKaijyo() {
        return this.getTabKeteiJoho().getKyufugakuGengakuKisaiKaijyo().getRadKyufukakuGengakuKisaiKaijyo();
    }

    @JsonIgnore
    public void  setRadKyufukakuGengakuKisaiKaijyo(RadioButton radKyufukakuGengakuKisaiKaijyo) {
        this.getTabKeteiJoho().getKyufugakuGengakuKisaiKaijyo().setRadKyufukakuGengakuKisaiKaijyo(radKyufukakuGengakuKisaiKaijyo);
    }

    @JsonIgnore
    public HyojunFutanGakuPanelDiv getHyojunFutanGakuPanel() {
        return this.getTabKeteiJoho().getHyojunFutanGakuPanel();
    }

    @JsonIgnore
    public void  setHyojunFutanGakuPanel(HyojunFutanGakuPanelDiv HyojunFutanGakuPanel) {
        this.getTabKeteiJoho().setHyojunFutanGakuPanel(HyojunFutanGakuPanel);
    }

    @JsonIgnore
    public RadioButton getRadHyojunFutanGaku() {
        return this.getTabKeteiJoho().getHyojunFutanGakuPanel().getRadHyojunFutanGaku();
    }

    @JsonIgnore
    public void  setRadHyojunFutanGaku(RadioButton radHyojunFutanGaku) {
        this.getTabKeteiJoho().getHyojunFutanGakuPanel().setRadHyojunFutanGaku(radHyojunFutanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyojunFutanKeigenAtoFutanGaku() {
        return this.getTabKeteiJoho().getHyojunFutanGakuPanel().getTxtHyojunFutanKeigenAtoFutanGaku();
    }

    @JsonIgnore
    public void  setTxtHyojunFutanKeigenAtoFutanGaku(TextBoxNum txtHyojunFutanKeigenAtoFutanGaku) {
        this.getTabKeteiJoho().getHyojunFutanGakuPanel().setTxtHyojunFutanKeigenAtoFutanGaku(txtHyojunFutanKeigenAtoFutanGaku);
    }

    @JsonIgnore
    public RadioButton getRadKyojuhiFutanGakuGengaku() {
        return this.getTabKeteiJoho().getHyojunFutanGakuPanel().getRadKyojuhiFutanGakuGengaku();
    }

    @JsonIgnore
    public void  setRadKyojuhiFutanGakuGengaku(RadioButton radKyojuhiFutanGakuGengaku) {
        this.getTabKeteiJoho().getHyojunFutanGakuPanel().setRadKyojuhiFutanGakuGengaku(radKyojuhiFutanGakuGengaku);
    }

    @JsonIgnore
    public DropDownList getDdlKyoshituShurui() {
        return this.getTabKeteiJoho().getHyojunFutanGakuPanel().getDdlKyoshituShurui();
    }

    @JsonIgnore
    public void  setDdlKyoshituShurui(DropDownList ddlKyoshituShurui) {
        this.getTabKeteiJoho().getHyojunFutanGakuPanel().setDdlKyoshituShurui(ddlKyoshituShurui);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenAtoFutanGaku() {
        return this.getTabKeteiJoho().getHyojunFutanGakuPanel().getTxtKeigenAtoFutanGaku();
    }

    @JsonIgnore
    public void  setTxtKeigenAtoFutanGaku(TextBoxNum txtKeigenAtoFutanGaku) {
        this.getTabKeteiJoho().getHyojunFutanGakuPanel().setTxtKeigenAtoFutanGaku(txtKeigenAtoFutanGaku);
    }

    @JsonIgnore
    public GogakuServiceJogengakuGengakuDiv getGogakuServiceJogengakuGengaku() {
        return this.getTabKeteiJoho().getGogakuServiceJogengakuGengaku();
    }

    @JsonIgnore
    public void  setGogakuServiceJogengakuGengaku(GogakuServiceJogengakuGengakuDiv GogakuServiceJogengakuGengaku) {
        this.getTabKeteiJoho().setGogakuServiceJogengakuGengaku(GogakuServiceJogengakuGengaku);
    }

    @JsonIgnore
    public RadioButton getRadShokuhiFutangakuGengaku() {
        return this.getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getRadShokuhiFutangakuGengaku();
    }

    @JsonIgnore
    public void  setRadShokuhiFutangakuGengaku(RadioButton radShokuhiFutangakuGengaku) {
        this.getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setRadShokuhiFutangakuGengaku(radShokuhiFutangakuGengaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiGenkenAtoFutangaku() {
        return this.getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getTxtShokuhiGenkenAtoFutangaku();
    }

    @JsonIgnore
    public void  setTxtShokuhiGenkenAtoFutangaku(TextBoxNum txtShokuhiGenkenAtoFutangaku) {
        this.getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setTxtShokuhiGenkenAtoFutangaku(txtShokuhiGenkenAtoFutangaku);
    }

    @JsonIgnore
    public RadioButton getRadGogakuServiceJokengaku() {
        return this.getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getRadGogakuServiceJokengaku();
    }

    @JsonIgnore
    public void  setRadGogakuServiceJokengaku(RadioButton radGogakuServiceJokengaku) {
        this.getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setRadGogakuServiceJokengaku(radGogakuServiceJokengaku);
    }

    @JsonIgnore
    public DropDownList getDdlSeidaiJogengaku() {
        return this.getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getDdlSeidaiJogengaku();
    }

    @JsonIgnore
    public void  setDdlSeidaiJogengaku(DropDownList ddlSeidaiJogengaku) {
        this.getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setDdlSeidaiJogengaku(ddlSeidaiJogengaku);
    }

    @JsonIgnore
    public HokenryoNofuGengakuDiv getHokenryoNofuGengaku() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku();
    }

    @JsonIgnore
    public void  setHokenryoNofuGengaku(HokenryoNofuGengakuDiv HokenryoNofuGengaku) {
        this.getTabKeteiJoho().setHokenryoNofuGengaku(HokenryoNofuGengaku);
    }

    @JsonIgnore
    public RadioButton getRadHokenryoNofuGengaku() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku().getRadHokenryoNofuGengaku();
    }

    @JsonIgnore
    public void  setRadHokenryoNofuGengaku(RadioButton radHokenryoNofuGengaku) {
        this.getTabKeteiJoho().getHokenryoNofuGengaku().setRadHokenryoNofuGengaku(radHokenryoNofuGengaku);
    }

    @JsonIgnore
    public HohenryoNofuPanelDiv getHohenryoNofuPanel() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel();
    }

    @JsonIgnore
    public void  setHohenryoNofuPanel(HohenryoNofuPanelDiv HohenryoNofuPanel) {
        this.getTabKeteiJoho().getHokenryoNofuGengaku().setHohenryoNofuPanel(HohenryoNofuPanel);
    }

    @JsonIgnore
    public Button getBtnTuikaSuru() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().getBtnTuikaSuru();
    }

    @JsonIgnore
    public void  setBtnTuikaSuru(Button btnTuikaSuru) {
        this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().setBtnTuikaSuru(btnTuikaSuru);
    }

    @JsonIgnore
    public DataGrid<dghokenryoNofu_Row> getDghokenryoNofu() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().getDghokenryoNofu();
    }

    @JsonIgnore
    public void  setDghokenryoNofu(DataGrid<dghokenryoNofu_Row> dghokenryoNofu) {
        this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().setDghokenryoNofu(dghokenryoNofu);
    }

    @JsonIgnore
    public HohenryoNofuNyuryokuDiv getHohenryoNofuNyuryoku() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku();
    }

    @JsonIgnore
    public void  setHohenryoNofuNyuryoku(HohenryoNofuNyuryokuDiv HohenryoNofuNyuryoku) {
        this.getTabKeteiJoho().getHokenryoNofuGengaku().setHohenryoNofuNyuryoku(HohenryoNofuNyuryoku);
    }

    @JsonIgnore
    public TextBoxDate getTxtHohenryoNofuFromDate() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getTxtHohenryoNofuFromDate();
    }

    @JsonIgnore
    public void  setTxtHohenryoNofuFromDate(TextBoxDate txtHohenryoNofuFromDate) {
        this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setTxtHohenryoNofuFromDate(txtHohenryoNofuFromDate);
    }

    @JsonIgnore
    public TextBoxDate getTxtHohenryoNofuToDate() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getTxtHohenryoNofuToDate();
    }

    @JsonIgnore
    public void  setTxtHohenryoNofuToDate(TextBoxDate txtHohenryoNofuToDate) {
        this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setTxtHohenryoNofuToDate(txtHohenryoNofuToDate);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyouSuruShutokuDankai() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getDdlTekiyouSuruShutokuDankai();
    }

    @JsonIgnore
    public void  setDdlTekiyouSuruShutokuDankai(DropDownList ddlTekiyouSuruShutokuDankai) {
        this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setDdlTekiyouSuruShutokuDankai(ddlTekiyouSuruShutokuDankai);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public ShomeishoNaiyoDiv getShomeishoNaiyo() {
        return this.getTabShomeishoJoho().getShomeishoNaiyo();
    }

    @JsonIgnore
    public void  setShomeishoNaiyo(ShomeishoNaiyoDiv ShomeishoNaiyo) {
        this.getTabShomeishoJoho().setShomeishoNaiyo(ShomeishoNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShiseiHaishibi() {
        return this.getTabShomeishoJoho().getShomeishoNaiyo().getTxtShiseiHaishibi();
    }

    @JsonIgnore
    public void  setTxtShiseiHaishibi(TextBoxDate txtShiseiHaishibi) {
        this.getTabShomeishoJoho().getShomeishoNaiyo().setTxtShiseiHaishibi(txtShiseiHaishibi);
    }

    @JsonIgnore
    public TextBoxNum getTxtHogoFuyoKonshoGengakuKingaku() {
        return this.getTabShomeishoJoho().getShomeishoNaiyo().getTxtHogoFuyoKonshoGengakuKingaku();
    }

    @JsonIgnore
    public void  setTxtHogoFuyoKonshoGengakuKingaku(TextBoxNum txtHogoFuyoKonshoGengakuKingaku) {
        this.getTabShomeishoJoho().getShomeishoNaiyo().setTxtHogoFuyoKonshoGengakuKingaku(txtHogoFuyoKonshoGengakuKingaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtShomeishoKoufuDate() {
        return this.getTabShomeishoJoho().getShomeishoNaiyo().getTxtShomeishoKoufuDate();
    }

    @JsonIgnore
    public void  setTxtShomeishoKoufuDate(TextBoxDate txtShomeishoKoufuDate) {
        this.getTabShomeishoJoho().getShomeishoNaiyo().setTxtShomeishoKoufuDate(txtShomeishoKoufuDate);
    }

    @JsonIgnore
    public KyokaisoGaitouSochiNaiyoDiv getKyokaisoGaitouSochiNaiyo() {
        return this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo();
    }

    @JsonIgnore
    public void  setKyokaisoGaitouSochiNaiyo(KyokaisoGaitouSochiNaiyoDiv KyokaisoGaitouSochiNaiyo) {
        this.getTabShomeishoJoho().setKyokaisoGaitouSochiNaiyo(KyokaisoGaitouSochiNaiyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufugakuJikoFutanGetsugaku() {
        return this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtKyufugakuJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKyufugakuJikoFutanGetsugaku(TextBoxNum txtKyufugakuJikoFutanGetsugaku) {
        this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtKyufugakuJikoFutanGetsugaku(txtKyufugakuJikoFutanGetsugaku);
    }

    @JsonIgnore
    public DropDownList getDdlKyojuhiGendogakuDankai() {
        return this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getDdlKyojuhiGendogakuDankai();
    }

    @JsonIgnore
    public void  setDdlKyojuhiGendogakuDankai(DropDownList ddlKyojuhiGendogakuDankai) {
        this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setDdlKyojuhiGendogakuDankai(ddlKyojuhiGendogakuDankai);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyojuhiJikoFutanGetsugaku() {
        return this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtKyojuhiJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKyojuhiJikoFutanGetsugaku(TextBoxNum txtKyojuhiJikoFutanGetsugaku) {
        this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtKyojuhiJikoFutanGetsugaku(txtKyojuhiJikoFutanGetsugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiJikoFutanGetsugaku() {
        return this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtShokuhiJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtShokuhiJikoFutanGetsugaku(TextBoxNum txtShokuhiJikoFutanGetsugaku) {
        this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtShokuhiJikoFutanGetsugaku(txtShokuhiJikoFutanGetsugaku);
    }

    @JsonIgnore
    public DropDownList getDdlShokuhiGakenFutanGendogakuDankai() {
        return this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getDdlShokuhiGakenFutanGendogakuDankai();
    }

    @JsonIgnore
    public void  setDdlShokuhiGakenFutanGendogakuDankai(DropDownList ddlShokuhiGakenFutanGendogakuDankai) {
        this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setDdlShokuhiGakenFutanGendogakuDankai(ddlShokuhiGakenFutanGendogakuDankai);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoHokenryoJikoFutanGetsugaku() {
        return this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtKaigoHokenryoJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKaigoHokenryoJikoFutanGetsugaku(TextBoxNum txtKaigoHokenryoJikoFutanGetsugaku) {
        this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtKaigoHokenryoJikoFutanGetsugaku(txtKaigoHokenryoJikoFutanGetsugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanSeidaiGokeigaku() {
        return this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtRiyoshaFutanSeidaiGokeigaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanSeidaiGokeigaku(TextBoxNum txtRiyoshaFutanSeidaiGokeigaku) {
        this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtRiyoshaFutanSeidaiGokeigaku(txtRiyoshaFutanSeidaiGokeigaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtJikoFutanGetsugakuGokeigaku() {
        return this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtJikoFutanGetsugakuGokeigaku();
    }

    @JsonIgnore
    public void  setTxtJikoFutanGetsugakuGokeigaku(TextBoxNum txtJikoFutanGetsugakuGokeigaku) {
        this.getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtJikoFutanGetsugakuGokeigaku(txtJikoFutanGetsugakuGokeigaku);
    }

    // </editor-fold>
}
