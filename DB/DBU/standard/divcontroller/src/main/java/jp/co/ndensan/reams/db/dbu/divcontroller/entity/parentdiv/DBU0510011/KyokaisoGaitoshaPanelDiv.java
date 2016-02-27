package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.IKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.KanryoMessage.KanryoMessageDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyokaisoGaitoshaPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyokaisoGaitoshaPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyokaisouGaitouItiran")
    private KyokaisouGaitouItiranDiv KyokaisouGaitouItiran;
    @JsonProperty("MeisaiAreaPanel")
    private MeisaiAreaPanelDiv MeisaiAreaPanel;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKanryoMessage")
    private KanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("ccdKaigoAtena")
    private KaigoAtenaInfoDiv ccdKaigoAtena;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyokaisouGaitouItiran
     * @return KyokaisouGaitouItiran
     */
    @JsonProperty("KyokaisouGaitouItiran")
    public KyokaisouGaitouItiranDiv getKyokaisouGaitouItiran() {
        return KyokaisouGaitouItiran;
    }

    /*
     * setKyokaisouGaitouItiran
     * @param KyokaisouGaitouItiran KyokaisouGaitouItiran
     */
    @JsonProperty("KyokaisouGaitouItiran")
    public void setKyokaisouGaitouItiran(KyokaisouGaitouItiranDiv KyokaisouGaitouItiran) {
        this.KyokaisouGaitouItiran = KyokaisouGaitouItiran;
    }

    /*
     * getMeisaiAreaPanel
     * @return MeisaiAreaPanel
     */
    @JsonProperty("MeisaiAreaPanel")
    public MeisaiAreaPanelDiv getMeisaiAreaPanel() {
        return MeisaiAreaPanel;
    }

    /*
     * setMeisaiAreaPanel
     * @param MeisaiAreaPanel MeisaiAreaPanel
     */
    @JsonProperty("MeisaiAreaPanel")
    public void setMeisaiAreaPanel(MeisaiAreaPanelDiv MeisaiAreaPanel) {
        this.MeisaiAreaPanel = MeisaiAreaPanel;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * getccdKaigoAtena
     * @return ccdKaigoAtena
     */
    @JsonProperty("ccdKaigoAtena")
    public IKaigoAtenaInfoDiv getCcdKaigoAtena() {
        return ccdKaigoAtena;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnTuika() {
        return this.getKyokaisouGaitouItiran().getBtnTuika();
    }

    @JsonIgnore
    public void  setBtnTuika(Button btnTuika) {
        this.getKyokaisouGaitouItiran().setBtnTuika(btnTuika);
    }

    @JsonIgnore
    public DataGrid<dgKyokaisouGaitouItran_Row> getDgKyokaisouGaitouItran() {
        return this.getKyokaisouGaitouItiran().getDgKyokaisouGaitouItran();
    }

    @JsonIgnore
    public void  setDgKyokaisouGaitouItran(DataGrid<dgKyokaisouGaitouItran_Row> dgKyokaisouGaitouItran) {
        this.getKyokaisouGaitouItiran().setDgKyokaisouGaitouItran(dgKyokaisouGaitouItran);
    }

    @JsonIgnore
    public TextBoxDate getTxtShiseibi() {
        return this.getMeisaiAreaPanel().getTxtShiseibi();
    }

    @JsonIgnore
    public void  setTxtShiseibi(TextBoxDate txtShiseibi) {
        this.getMeisaiAreaPanel().setTxtShiseibi(txtShiseibi);
    }

    @JsonIgnore
    public RadioButton getRadSochiGaitouKubun() {
        return this.getMeisaiAreaPanel().getRadSochiGaitouKubun();
    }

    @JsonIgnore
    public void  setRadSochiGaitouKubun(RadioButton radSochiGaitouKubun) {
        this.getMeisaiAreaPanel().setRadSochiGaitouKubun(radSochiGaitouKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtKeteibi() {
        return this.getMeisaiAreaPanel().getTxtKeteibi();
    }

    @JsonIgnore
    public void  setTxtKeteibi(TextBoxDate txtKeteibi) {
        this.getMeisaiAreaPanel().setTxtKeteibi(txtKeteibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaishibi() {
        return this.getMeisaiAreaPanel().getTxtKaishibi();
    }

    @JsonIgnore
    public void  setTxtKaishibi(TextBoxDate txtKaishibi) {
        this.getMeisaiAreaPanel().setTxtKaishibi(txtKaishibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtShuryobi() {
        return this.getMeisaiAreaPanel().getTxtShuryobi();
    }

    @JsonIgnore
    public void  setTxtShuryobi(TextBoxDate txtShuryobi) {
        this.getMeisaiAreaPanel().setTxtShuryobi(txtShuryobi);
    }

    @JsonIgnore
    public tbMeisaiDiv getTbMeisai() {
        return this.getMeisaiAreaPanel().getTbMeisai();
    }

    @JsonIgnore
    public void  setTbMeisai(tbMeisaiDiv tbMeisai) {
        this.getMeisaiAreaPanel().setTbMeisai(tbMeisai);
    }

    @JsonIgnore
    public tabKeteiJohoDiv getTabKeteiJoho() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho();
    }

    @JsonIgnore
    public void  setTabKeteiJoho(tabKeteiJohoDiv tabKeteiJoho) {
        this.getMeisaiAreaPanel().getTbMeisai().setTabKeteiJoho(tabKeteiJoho);
    }

    @JsonIgnore
    public KyufugakuGengakuKisaiKaijyoDiv getKyufugakuGengakuKisaiKaijyo() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getKyufugakuGengakuKisaiKaijyo();
    }

    @JsonIgnore
    public void  setKyufugakuGengakuKisaiKaijyo(KyufugakuGengakuKisaiKaijyoDiv KyufugakuGengakuKisaiKaijyo) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().setKyufugakuGengakuKisaiKaijyo(KyufugakuGengakuKisaiKaijyo);
    }

    @JsonIgnore
    public RadioButton getRadKyufukakuGengakuKisaiKaijyo() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getKyufugakuGengakuKisaiKaijyo().getRadKyufukakuGengakuKisaiKaijyo();
    }

    @JsonIgnore
    public void  setRadKyufukakuGengakuKisaiKaijyo(RadioButton radKyufukakuGengakuKisaiKaijyo) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getKyufugakuGengakuKisaiKaijyo().setRadKyufukakuGengakuKisaiKaijyo(radKyufukakuGengakuKisaiKaijyo);
    }

    @JsonIgnore
    public HyojunFutanGakuPanelDiv getHyojunFutanGakuPanel() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel();
    }

    @JsonIgnore
    public void  setHyojunFutanGakuPanel(HyojunFutanGakuPanelDiv HyojunFutanGakuPanel) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().setHyojunFutanGakuPanel(HyojunFutanGakuPanel);
    }

    @JsonIgnore
    public RadioButton getRadHyojunFutanGaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().getRadHyojunFutanGaku();
    }

    @JsonIgnore
    public void  setRadHyojunFutanGaku(RadioButton radHyojunFutanGaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().setRadHyojunFutanGaku(radHyojunFutanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyojunFutanKeigenAtoFutanGaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().getTxtHyojunFutanKeigenAtoFutanGaku();
    }

    @JsonIgnore
    public void  setTxtHyojunFutanKeigenAtoFutanGaku(TextBoxNum txtHyojunFutanKeigenAtoFutanGaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().setTxtHyojunFutanKeigenAtoFutanGaku(txtHyojunFutanKeigenAtoFutanGaku);
    }

    @JsonIgnore
    public RadioButton getRadKyojuhiFutanGakuGengaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().getRadKyojuhiFutanGakuGengaku();
    }

    @JsonIgnore
    public void  setRadKyojuhiFutanGakuGengaku(RadioButton radKyojuhiFutanGakuGengaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().setRadKyojuhiFutanGakuGengaku(radKyojuhiFutanGakuGengaku);
    }

    @JsonIgnore
    public DropDownList getDdlKyoshituShurui() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().getDdlKyoshituShurui();
    }

    @JsonIgnore
    public void  setDdlKyoshituShurui(DropDownList ddlKyoshituShurui) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().setDdlKyoshituShurui(ddlKyoshituShurui);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenAtoFutanGaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().getTxtKeigenAtoFutanGaku();
    }

    @JsonIgnore
    public void  setTxtKeigenAtoFutanGaku(TextBoxNum txtKeigenAtoFutanGaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHyojunFutanGakuPanel().setTxtKeigenAtoFutanGaku(txtKeigenAtoFutanGaku);
    }

    @JsonIgnore
    public GogakuServiceJogengakuGengakuDiv getGogakuServiceJogengakuGengaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku();
    }

    @JsonIgnore
    public void  setGogakuServiceJogengakuGengaku(GogakuServiceJogengakuGengakuDiv GogakuServiceJogengakuGengaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().setGogakuServiceJogengakuGengaku(GogakuServiceJogengakuGengaku);
    }

    @JsonIgnore
    public RadioButton getRadShokuhiFutangakuGengaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getRadShokuhiFutangakuGengaku();
    }

    @JsonIgnore
    public void  setRadShokuhiFutangakuGengaku(RadioButton radShokuhiFutangakuGengaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setRadShokuhiFutangakuGengaku(radShokuhiFutangakuGengaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiGenkenAtoFutangaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getTxtShokuhiGenkenAtoFutangaku();
    }

    @JsonIgnore
    public void  setTxtShokuhiGenkenAtoFutangaku(TextBoxNum txtShokuhiGenkenAtoFutangaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setTxtShokuhiGenkenAtoFutangaku(txtShokuhiGenkenAtoFutangaku);
    }

    @JsonIgnore
    public RadioButton getRadGogakuServiceJokengaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getRadGogakuServiceJokengaku();
    }

    @JsonIgnore
    public void  setRadGogakuServiceJokengaku(RadioButton radGogakuServiceJokengaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setRadGogakuServiceJokengaku(radGogakuServiceJokengaku);
    }

    @JsonIgnore
    public DropDownList getDdlSeidaiJogengaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().getDdlSeidaiJogengaku();
    }

    @JsonIgnore
    public void  setDdlSeidaiJogengaku(DropDownList ddlSeidaiJogengaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getGogakuServiceJogengakuGengaku().setDdlSeidaiJogengaku(ddlSeidaiJogengaku);
    }

    @JsonIgnore
    public HokenryoNofuGengakuDiv getHokenryoNofuGengaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku();
    }

    @JsonIgnore
    public void  setHokenryoNofuGengaku(HokenryoNofuGengakuDiv HokenryoNofuGengaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().setHokenryoNofuGengaku(HokenryoNofuGengaku);
    }

    @JsonIgnore
    public RadioButton getRadHokenryoNofuGengaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getRadHokenryoNofuGengaku();
    }

    @JsonIgnore
    public void  setRadHokenryoNofuGengaku(RadioButton radHokenryoNofuGengaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().setRadHokenryoNofuGengaku(radHokenryoNofuGengaku);
    }

    @JsonIgnore
    public HohenryoNofuPanelDiv getHohenryoNofuPanel() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel();
    }

    @JsonIgnore
    public void  setHohenryoNofuPanel(HohenryoNofuPanelDiv HohenryoNofuPanel) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().setHohenryoNofuPanel(HohenryoNofuPanel);
    }

    @JsonIgnore
    public Button getBtnTuikaSuru() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().getBtnTuikaSuru();
    }

    @JsonIgnore
    public void  setBtnTuikaSuru(Button btnTuikaSuru) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().setBtnTuikaSuru(btnTuikaSuru);
    }

    @JsonIgnore
    public DataGrid<dghokenryoNofu_Row> getDghokenryoNofu() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().getDghokenryoNofu();
    }

    @JsonIgnore
    public void  setDghokenryoNofu(DataGrid<dghokenryoNofu_Row> dghokenryoNofu) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuPanel().setDghokenryoNofu(dghokenryoNofu);
    }

    @JsonIgnore
    public HohenryoNofuNyuryokuDiv getHohenryoNofuNyuryoku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku();
    }

    @JsonIgnore
    public void  setHohenryoNofuNyuryoku(HohenryoNofuNyuryokuDiv HohenryoNofuNyuryoku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().setHohenryoNofuNyuryoku(HohenryoNofuNyuryoku);
    }

    @JsonIgnore
    public TextBoxDate getTxtHohenryoNofuFromDate() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getTxtHohenryoNofuFromDate();
    }

    @JsonIgnore
    public void  setTxtHohenryoNofuFromDate(TextBoxDate txtHohenryoNofuFromDate) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setTxtHohenryoNofuFromDate(txtHohenryoNofuFromDate);
    }

    @JsonIgnore
    public TextBoxDate getTxtHohenryoNofuToDate() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getTxtHohenryoNofuToDate();
    }

    @JsonIgnore
    public void  setTxtHohenryoNofuToDate(TextBoxDate txtHohenryoNofuToDate) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setTxtHohenryoNofuToDate(txtHohenryoNofuToDate);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyouSuruShutokuDankai() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getDdlTekiyouSuruShutokuDankai();
    }

    @JsonIgnore
    public void  setDdlTekiyouSuruShutokuDankai(DropDownList ddlTekiyouSuruShutokuDankai) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setDdlTekiyouSuruShutokuDankai(ddlTekiyouSuruShutokuDankai);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabKeteiJoho().getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public tabShomeishoJohoDiv getTabShomeishoJoho() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho();
    }

    @JsonIgnore
    public void  setTabShomeishoJoho(tabShomeishoJohoDiv tabShomeishoJoho) {
        this.getMeisaiAreaPanel().getTbMeisai().setTabShomeishoJoho(tabShomeishoJoho);
    }

    @JsonIgnore
    public ShomeishoNaiyoDiv getShomeishoNaiyo() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo();
    }

    @JsonIgnore
    public void  setShomeishoNaiyo(ShomeishoNaiyoDiv ShomeishoNaiyo) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().setShomeishoNaiyo(ShomeishoNaiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShiseiHaishibi() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().getTxtShiseiHaishibi();
    }

    @JsonIgnore
    public void  setTxtShiseiHaishibi(TextBoxDate txtShiseiHaishibi) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().setTxtShiseiHaishibi(txtShiseiHaishibi);
    }

    @JsonIgnore
    public TextBoxNum getTxtHogoFuyoKonshoGengakuKingaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().getTxtHogoFuyoKonshoGengakuKingaku();
    }

    @JsonIgnore
    public void  setTxtHogoFuyoKonshoGengakuKingaku(TextBoxNum txtHogoFuyoKonshoGengakuKingaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().setTxtHogoFuyoKonshoGengakuKingaku(txtHogoFuyoKonshoGengakuKingaku);
    }

    @JsonIgnore
    public TextBoxDate getTxtShomeishoKoufuDate() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().getTxtShomeishoKoufuDate();
    }

    @JsonIgnore
    public void  setTxtShomeishoKoufuDate(TextBoxDate txtShomeishoKoufuDate) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getShomeishoNaiyo().setTxtShomeishoKoufuDate(txtShomeishoKoufuDate);
    }

    @JsonIgnore
    public KyokaisoGaitouSochiNaiyoDiv getKyokaisoGaitouSochiNaiyo() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo();
    }

    @JsonIgnore
    public void  setKyokaisoGaitouSochiNaiyo(KyokaisoGaitouSochiNaiyoDiv KyokaisoGaitouSochiNaiyo) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().setKyokaisoGaitouSochiNaiyo(KyokaisoGaitouSochiNaiyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufugakuJikoFutanGetsugaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtKyufugakuJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKyufugakuJikoFutanGetsugaku(TextBoxNum txtKyufugakuJikoFutanGetsugaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtKyufugakuJikoFutanGetsugaku(txtKyufugakuJikoFutanGetsugaku);
    }

    @JsonIgnore
    public DropDownList getDdlKyojuhiGendogakuDankai() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getDdlKyojuhiGendogakuDankai();
    }

    @JsonIgnore
    public void  setDdlKyojuhiGendogakuDankai(DropDownList ddlKyojuhiGendogakuDankai) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setDdlKyojuhiGendogakuDankai(ddlKyojuhiGendogakuDankai);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyojuhiJikoFutanGetsugaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtKyojuhiJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKyojuhiJikoFutanGetsugaku(TextBoxNum txtKyojuhiJikoFutanGetsugaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtKyojuhiJikoFutanGetsugaku(txtKyojuhiJikoFutanGetsugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiJikoFutanGetsugaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtShokuhiJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtShokuhiJikoFutanGetsugaku(TextBoxNum txtShokuhiJikoFutanGetsugaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtShokuhiJikoFutanGetsugaku(txtShokuhiJikoFutanGetsugaku);
    }

    @JsonIgnore
    public DropDownList getDdlShokuhiGakenFutanGendogakuDankai() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getDdlShokuhiGakenFutanGendogakuDankai();
    }

    @JsonIgnore
    public void  setDdlShokuhiGakenFutanGendogakuDankai(DropDownList ddlShokuhiGakenFutanGendogakuDankai) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setDdlShokuhiGakenFutanGendogakuDankai(ddlShokuhiGakenFutanGendogakuDankai);
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoHokenryoJikoFutanGetsugaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtKaigoHokenryoJikoFutanGetsugaku();
    }

    @JsonIgnore
    public void  setTxtKaigoHokenryoJikoFutanGetsugaku(TextBoxNum txtKaigoHokenryoJikoFutanGetsugaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtKaigoHokenryoJikoFutanGetsugaku(txtKaigoHokenryoJikoFutanGetsugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtRiyoshaFutanSeidaiGokeigaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtRiyoshaFutanSeidaiGokeigaku();
    }

    @JsonIgnore
    public void  setTxtRiyoshaFutanSeidaiGokeigaku(TextBoxNum txtRiyoshaFutanSeidaiGokeigaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtRiyoshaFutanSeidaiGokeigaku(txtRiyoshaFutanSeidaiGokeigaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtJikoFutanGetsugakuGokeigaku() {
        return this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().getTxtJikoFutanGetsugakuGokeigaku();
    }

    @JsonIgnore
    public void  setTxtJikoFutanGetsugakuGokeigaku(TextBoxNum txtJikoFutanGetsugakuGokeigaku) {
        this.getMeisaiAreaPanel().getTbMeisai().getTabShomeishoJoho().getKyokaisoGaitouSochiNaiyo().setTxtJikoFutanGetsugakuGokeigaku(txtJikoFutanGetsugakuGokeigaku);
    }

    // </editor-fold>
}
