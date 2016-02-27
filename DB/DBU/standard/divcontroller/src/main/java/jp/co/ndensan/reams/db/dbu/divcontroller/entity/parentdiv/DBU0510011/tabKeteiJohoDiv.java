package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0510011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabKeteiJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKeteiJohoDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KyufugakuGengakuKisaiKaijyo")
    private KyufugakuGengakuKisaiKaijyoDiv KyufugakuGengakuKisaiKaijyo;
    @JsonProperty("HyojunFutanGakuPanel")
    private HyojunFutanGakuPanelDiv HyojunFutanGakuPanel;
    @JsonProperty("GogakuServiceJogengakuGengaku")
    private GogakuServiceJogengakuGengakuDiv GogakuServiceJogengakuGengaku;
    @JsonProperty("HokenryoNofuGengaku")
    private HokenryoNofuGengakuDiv HokenryoNofuGengaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKyufugakuGengakuKisaiKaijyo
     * @return KyufugakuGengakuKisaiKaijyo
     */
    @JsonProperty("KyufugakuGengakuKisaiKaijyo")
    public KyufugakuGengakuKisaiKaijyoDiv getKyufugakuGengakuKisaiKaijyo() {
        return KyufugakuGengakuKisaiKaijyo;
    }

    /*
     * setKyufugakuGengakuKisaiKaijyo
     * @param KyufugakuGengakuKisaiKaijyo KyufugakuGengakuKisaiKaijyo
     */
    @JsonProperty("KyufugakuGengakuKisaiKaijyo")
    public void setKyufugakuGengakuKisaiKaijyo(KyufugakuGengakuKisaiKaijyoDiv KyufugakuGengakuKisaiKaijyo) {
        this.KyufugakuGengakuKisaiKaijyo = KyufugakuGengakuKisaiKaijyo;
    }

    /*
     * getHyojunFutanGakuPanel
     * @return HyojunFutanGakuPanel
     */
    @JsonProperty("HyojunFutanGakuPanel")
    public HyojunFutanGakuPanelDiv getHyojunFutanGakuPanel() {
        return HyojunFutanGakuPanel;
    }

    /*
     * setHyojunFutanGakuPanel
     * @param HyojunFutanGakuPanel HyojunFutanGakuPanel
     */
    @JsonProperty("HyojunFutanGakuPanel")
    public void setHyojunFutanGakuPanel(HyojunFutanGakuPanelDiv HyojunFutanGakuPanel) {
        this.HyojunFutanGakuPanel = HyojunFutanGakuPanel;
    }

    /*
     * getGogakuServiceJogengakuGengaku
     * @return GogakuServiceJogengakuGengaku
     */
    @JsonProperty("GogakuServiceJogengakuGengaku")
    public GogakuServiceJogengakuGengakuDiv getGogakuServiceJogengakuGengaku() {
        return GogakuServiceJogengakuGengaku;
    }

    /*
     * setGogakuServiceJogengakuGengaku
     * @param GogakuServiceJogengakuGengaku GogakuServiceJogengakuGengaku
     */
    @JsonProperty("GogakuServiceJogengakuGengaku")
    public void setGogakuServiceJogengakuGengaku(GogakuServiceJogengakuGengakuDiv GogakuServiceJogengakuGengaku) {
        this.GogakuServiceJogengakuGengaku = GogakuServiceJogengakuGengaku;
    }

    /*
     * getHokenryoNofuGengaku
     * @return HokenryoNofuGengaku
     */
    @JsonProperty("HokenryoNofuGengaku")
    public HokenryoNofuGengakuDiv getHokenryoNofuGengaku() {
        return HokenryoNofuGengaku;
    }

    /*
     * setHokenryoNofuGengaku
     * @param HokenryoNofuGengaku HokenryoNofuGengaku
     */
    @JsonProperty("HokenryoNofuGengaku")
    public void setHokenryoNofuGengaku(HokenryoNofuGengakuDiv HokenryoNofuGengaku) {
        this.HokenryoNofuGengaku = HokenryoNofuGengaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadKyufukakuGengakuKisaiKaijyo() {
        return this.getKyufugakuGengakuKisaiKaijyo().getRadKyufukakuGengakuKisaiKaijyo();
    }

    @JsonIgnore
    public void  setRadKyufukakuGengakuKisaiKaijyo(RadioButton radKyufukakuGengakuKisaiKaijyo) {
        this.getKyufugakuGengakuKisaiKaijyo().setRadKyufukakuGengakuKisaiKaijyo(radKyufukakuGengakuKisaiKaijyo);
    }

    @JsonIgnore
    public RadioButton getRadHyojunFutanGaku() {
        return this.getHyojunFutanGakuPanel().getRadHyojunFutanGaku();
    }

    @JsonIgnore
    public void  setRadHyojunFutanGaku(RadioButton radHyojunFutanGaku) {
        this.getHyojunFutanGakuPanel().setRadHyojunFutanGaku(radHyojunFutanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHyojunFutanKeigenAtoFutanGaku() {
        return this.getHyojunFutanGakuPanel().getTxtHyojunFutanKeigenAtoFutanGaku();
    }

    @JsonIgnore
    public void  setTxtHyojunFutanKeigenAtoFutanGaku(TextBoxNum txtHyojunFutanKeigenAtoFutanGaku) {
        this.getHyojunFutanGakuPanel().setTxtHyojunFutanKeigenAtoFutanGaku(txtHyojunFutanKeigenAtoFutanGaku);
    }

    @JsonIgnore
    public RadioButton getRadKyojuhiFutanGakuGengaku() {
        return this.getHyojunFutanGakuPanel().getRadKyojuhiFutanGakuGengaku();
    }

    @JsonIgnore
    public void  setRadKyojuhiFutanGakuGengaku(RadioButton radKyojuhiFutanGakuGengaku) {
        this.getHyojunFutanGakuPanel().setRadKyojuhiFutanGakuGengaku(radKyojuhiFutanGakuGengaku);
    }

    @JsonIgnore
    public DropDownList getDdlKyoshituShurui() {
        return this.getHyojunFutanGakuPanel().getDdlKyoshituShurui();
    }

    @JsonIgnore
    public void  setDdlKyoshituShurui(DropDownList ddlKyoshituShurui) {
        this.getHyojunFutanGakuPanel().setDdlKyoshituShurui(ddlKyoshituShurui);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenAtoFutanGaku() {
        return this.getHyojunFutanGakuPanel().getTxtKeigenAtoFutanGaku();
    }

    @JsonIgnore
    public void  setTxtKeigenAtoFutanGaku(TextBoxNum txtKeigenAtoFutanGaku) {
        this.getHyojunFutanGakuPanel().setTxtKeigenAtoFutanGaku(txtKeigenAtoFutanGaku);
    }

    @JsonIgnore
    public RadioButton getRadShokuhiFutangakuGengaku() {
        return this.getGogakuServiceJogengakuGengaku().getRadShokuhiFutangakuGengaku();
    }

    @JsonIgnore
    public void  setRadShokuhiFutangakuGengaku(RadioButton radShokuhiFutangakuGengaku) {
        this.getGogakuServiceJogengakuGengaku().setRadShokuhiFutangakuGengaku(radShokuhiFutangakuGengaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShokuhiGenkenAtoFutangaku() {
        return this.getGogakuServiceJogengakuGengaku().getTxtShokuhiGenkenAtoFutangaku();
    }

    @JsonIgnore
    public void  setTxtShokuhiGenkenAtoFutangaku(TextBoxNum txtShokuhiGenkenAtoFutangaku) {
        this.getGogakuServiceJogengakuGengaku().setTxtShokuhiGenkenAtoFutangaku(txtShokuhiGenkenAtoFutangaku);
    }

    @JsonIgnore
    public RadioButton getRadGogakuServiceJokengaku() {
        return this.getGogakuServiceJogengakuGengaku().getRadGogakuServiceJokengaku();
    }

    @JsonIgnore
    public void  setRadGogakuServiceJokengaku(RadioButton radGogakuServiceJokengaku) {
        this.getGogakuServiceJogengakuGengaku().setRadGogakuServiceJokengaku(radGogakuServiceJokengaku);
    }

    @JsonIgnore
    public DropDownList getDdlSeidaiJogengaku() {
        return this.getGogakuServiceJogengakuGengaku().getDdlSeidaiJogengaku();
    }

    @JsonIgnore
    public void  setDdlSeidaiJogengaku(DropDownList ddlSeidaiJogengaku) {
        this.getGogakuServiceJogengakuGengaku().setDdlSeidaiJogengaku(ddlSeidaiJogengaku);
    }

    @JsonIgnore
    public RadioButton getRadHokenryoNofuGengaku() {
        return this.getHokenryoNofuGengaku().getRadHokenryoNofuGengaku();
    }

    @JsonIgnore
    public void  setRadHokenryoNofuGengaku(RadioButton radHokenryoNofuGengaku) {
        this.getHokenryoNofuGengaku().setRadHokenryoNofuGengaku(radHokenryoNofuGengaku);
    }

    @JsonIgnore
    public HohenryoNofuPanelDiv getHohenryoNofuPanel() {
        return this.getHokenryoNofuGengaku().getHohenryoNofuPanel();
    }

    @JsonIgnore
    public void  setHohenryoNofuPanel(HohenryoNofuPanelDiv HohenryoNofuPanel) {
        this.getHokenryoNofuGengaku().setHohenryoNofuPanel(HohenryoNofuPanel);
    }

    @JsonIgnore
    public Button getBtnTuikaSuru() {
        return this.getHokenryoNofuGengaku().getHohenryoNofuPanel().getBtnTuikaSuru();
    }

    @JsonIgnore
    public void  setBtnTuikaSuru(Button btnTuikaSuru) {
        this.getHokenryoNofuGengaku().getHohenryoNofuPanel().setBtnTuikaSuru(btnTuikaSuru);
    }

    @JsonIgnore
    public DataGrid<dghokenryoNofu_Row> getDghokenryoNofu() {
        return this.getHokenryoNofuGengaku().getHohenryoNofuPanel().getDghokenryoNofu();
    }

    @JsonIgnore
    public void  setDghokenryoNofu(DataGrid<dghokenryoNofu_Row> dghokenryoNofu) {
        this.getHokenryoNofuGengaku().getHohenryoNofuPanel().setDghokenryoNofu(dghokenryoNofu);
    }

    @JsonIgnore
    public HohenryoNofuNyuryokuDiv getHohenryoNofuNyuryoku() {
        return this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku();
    }

    @JsonIgnore
    public void  setHohenryoNofuNyuryoku(HohenryoNofuNyuryokuDiv HohenryoNofuNyuryoku) {
        this.getHokenryoNofuGengaku().setHohenryoNofuNyuryoku(HohenryoNofuNyuryoku);
    }

    @JsonIgnore
    public TextBoxDate getTxtHohenryoNofuFromDate() {
        return this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getTxtHohenryoNofuFromDate();
    }

    @JsonIgnore
    public void  setTxtHohenryoNofuFromDate(TextBoxDate txtHohenryoNofuFromDate) {
        this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setTxtHohenryoNofuFromDate(txtHohenryoNofuFromDate);
    }

    @JsonIgnore
    public TextBoxDate getTxtHohenryoNofuToDate() {
        return this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getTxtHohenryoNofuToDate();
    }

    @JsonIgnore
    public void  setTxtHohenryoNofuToDate(TextBoxDate txtHohenryoNofuToDate) {
        this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setTxtHohenryoNofuToDate(txtHohenryoNofuToDate);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyouSuruShutokuDankai() {
        return this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getDdlTekiyouSuruShutokuDankai();
    }

    @JsonIgnore
    public void  setDdlTekiyouSuruShutokuDankai(DropDownList ddlTekiyouSuruShutokuDankai) {
        this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setDdlTekiyouSuruShutokuDankai(ddlTekiyouSuruShutokuDankai);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setBtnCancel(btnCancel);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getHokenryoNofuGengaku().getHohenryoNofuNyuryoku().setBtnKakutei(btnKakutei);
    }

    // </editor-fold>
}
