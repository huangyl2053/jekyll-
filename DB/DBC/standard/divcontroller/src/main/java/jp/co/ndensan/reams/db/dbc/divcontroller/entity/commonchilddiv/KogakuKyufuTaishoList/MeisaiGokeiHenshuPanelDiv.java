package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * 画面設計_DBCKD00006_高額給付対象一覧共有子Div
 *
 * @reamsid_L DBC-2020-030 quxiaodong
 */
public class MeisaiGokeiHenshuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("rdbMisaiGkeiKbun")
    private RadioButton rdbMisaiGkeiKbun;
    @JsonProperty("txtJgyoshaCode")
    private TextBox txtJgyoshaCode;
    @JsonProperty("btnJgyosha")
    private ButtonDialog btnJgyosha;
    @JsonProperty("txtJgyoshaName")
    private TextBox txtJgyoshaName;
    @JsonProperty("txtServiceSyurui")
    private TextBoxCode txtServiceSyurui;
    @JsonProperty("btnServiceSyurui")
    private ButtonDialog btnServiceSyurui;
    @JsonProperty("txtServiceSyuruiName")
    private TextBox txtServiceSyuruiName;
    @JsonProperty("txtHyoGkei")
    private TextBoxNum txtHyoGkei;
    @JsonProperty("txtRiyoshafutanGokei")
    private TextBoxNum txtRiyoshafutanGokei;
    @JsonProperty("GokeiPanel")
    private GokeiPanelDiv GokeiPanel;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("KogakuKyufuKonkyoPanel")
    private KogakuKyufuKonkyoPanelDiv KogakuKyufuKonkyoPanel;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;
    @JsonProperty("btnkakutei")
    private Button btnkakutei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getrdbMisaiGkeiKbun
     * @return rdbMisaiGkeiKbun
     */
    @JsonProperty("rdbMisaiGkeiKbun")
    public RadioButton getRdbMisaiGkeiKbun() {
        return rdbMisaiGkeiKbun;
    }

    /*
     * setrdbMisaiGkeiKbun
     * @param rdbMisaiGkeiKbun rdbMisaiGkeiKbun
     */
    @JsonProperty("rdbMisaiGkeiKbun")
    public void setRdbMisaiGkeiKbun(RadioButton rdbMisaiGkeiKbun) {
        this.rdbMisaiGkeiKbun = rdbMisaiGkeiKbun;
    }

    /*
     * gettxtJgyoshaCode
     * @return txtJgyoshaCode
     */
    @JsonProperty("txtJgyoshaCode")
    public TextBox getTxtJgyoshaCode() {
        return txtJgyoshaCode;
    }

    /*
     * settxtJgyoshaCode
     * @param txtJgyoshaCode txtJgyoshaCode
     */
    @JsonProperty("txtJgyoshaCode")
    public void setTxtJgyoshaCode(TextBox txtJgyoshaCode) {
        this.txtJgyoshaCode = txtJgyoshaCode;
    }

    /*
     * getbtnJgyosha
     * @return btnJgyosha
     */
    @JsonProperty("btnJgyosha")
    public ButtonDialog getBtnJgyosha() {
        return btnJgyosha;
    }

    /*
     * setbtnJgyosha
     * @param btnJgyosha btnJgyosha
     */
    @JsonProperty("btnJgyosha")
    public void setBtnJgyosha(ButtonDialog btnJgyosha) {
        this.btnJgyosha = btnJgyosha;
    }

    /*
     * gettxtJgyoshaName
     * @return txtJgyoshaName
     */
    @JsonProperty("txtJgyoshaName")
    public TextBox getTxtJgyoshaName() {
        return txtJgyoshaName;
    }

    /*
     * settxtJgyoshaName
     * @param txtJgyoshaName txtJgyoshaName
     */
    @JsonProperty("txtJgyoshaName")
    public void setTxtJgyoshaName(TextBox txtJgyoshaName) {
        this.txtJgyoshaName = txtJgyoshaName;
    }

    /*
     * gettxtServiceSyurui
     * @return txtServiceSyurui
     */
    @JsonProperty("txtServiceSyurui")
    public TextBoxCode getTxtServiceSyurui() {
        return txtServiceSyurui;
    }

    /*
     * settxtServiceSyurui
     * @param txtServiceSyurui txtServiceSyurui
     */
    @JsonProperty("txtServiceSyurui")
    public void setTxtServiceSyurui(TextBoxCode txtServiceSyurui) {
        this.txtServiceSyurui = txtServiceSyurui;
    }

    /*
     * getbtnServiceSyurui
     * @return btnServiceSyurui
     */
    @JsonProperty("btnServiceSyurui")
    public ButtonDialog getBtnServiceSyurui() {
        return btnServiceSyurui;
    }

    /*
     * setbtnServiceSyurui
     * @param btnServiceSyurui btnServiceSyurui
     */
    @JsonProperty("btnServiceSyurui")
    public void setBtnServiceSyurui(ButtonDialog btnServiceSyurui) {
        this.btnServiceSyurui = btnServiceSyurui;
    }

    /*
     * gettxtServiceSyuruiName
     * @return txtServiceSyuruiName
     */
    @JsonProperty("txtServiceSyuruiName")
    public TextBox getTxtServiceSyuruiName() {
        return txtServiceSyuruiName;
    }

    /*
     * settxtServiceSyuruiName
     * @param txtServiceSyuruiName txtServiceSyuruiName
     */
    @JsonProperty("txtServiceSyuruiName")
    public void setTxtServiceSyuruiName(TextBox txtServiceSyuruiName) {
        this.txtServiceSyuruiName = txtServiceSyuruiName;
    }

    /*
     * gettxtHyoGkei
     * @return txtHyoGkei
     */
    @JsonProperty("txtHyoGkei")
    public TextBoxNum getTxtHyoGkei() {
        return txtHyoGkei;
    }

    /*
     * settxtHyoGkei
     * @param txtHyoGkei txtHyoGkei
     */
    @JsonProperty("txtHyoGkei")
    public void setTxtHyoGkei(TextBoxNum txtHyoGkei) {
        this.txtHyoGkei = txtHyoGkei;
    }

    /*
     * gettxtRiyoshafutanGokei
     * @return txtRiyoshafutanGokei
     */
    @JsonProperty("txtRiyoshafutanGokei")
    public TextBoxNum getTxtRiyoshafutanGokei() {
        return txtRiyoshafutanGokei;
    }

    /*
     * settxtRiyoshafutanGokei
     * @param txtRiyoshafutanGokei txtRiyoshafutanGokei
     */
    @JsonProperty("txtRiyoshafutanGokei")
    public void setTxtRiyoshafutanGokei(TextBoxNum txtRiyoshafutanGokei) {
        this.txtRiyoshafutanGokei = txtRiyoshafutanGokei;
    }

    /*
     * getGokeiPanel
     * @return GokeiPanel
     */
    @JsonProperty("GokeiPanel")
    public GokeiPanelDiv getGokeiPanel() {
        return GokeiPanel;
    }

    /*
     * setGokeiPanel
     * @param GokeiPanel GokeiPanel
     */
    @JsonProperty("GokeiPanel")
    public void setGokeiPanel(GokeiPanelDiv GokeiPanel) {
        this.GokeiPanel = GokeiPanel;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * getKogakuKyufuKonkyoPanel
     * @return KogakuKyufuKonkyoPanel
     */
    @JsonProperty("KogakuKyufuKonkyoPanel")
    public KogakuKyufuKonkyoPanelDiv getKogakuKyufuKonkyoPanel() {
        return KogakuKyufuKonkyoPanel;
    }

    /*
     * setKogakuKyufuKonkyoPanel
     * @param KogakuKyufuKonkyoPanel KogakuKyufuKonkyoPanel
     */
    @JsonProperty("KogakuKyufuKonkyoPanel")
    public void setKogakuKyufuKonkyoPanel(KogakuKyufuKonkyoPanelDiv KogakuKyufuKonkyoPanel) {
        this.KogakuKyufuKonkyoPanel = KogakuKyufuKonkyoPanel;
    }

    /*
     * getbtnTorikeshi
     * @return btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public Button getBtnTorikeshi() {
        return btnTorikeshi;
    }

    /*
     * setbtnTorikeshi
     * @param btnTorikeshi btnTorikeshi
     */
    @JsonProperty("btnTorikeshi")
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.btnTorikeshi = btnTorikeshi;
    }

    /*
     * getbtnkakutei
     * @return btnkakutei
     */
    @JsonProperty("btnkakutei")
    public Button getBtnkakutei() {
        return btnkakutei;
    }

    /*
     * setbtnkakutei
     * @param btnkakutei btnkakutei
     */
    @JsonProperty("btnkakutei")
    public void setBtnkakutei(Button btnkakutei) {
        this.btnkakutei = btnkakutei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxNum getTxtSanteiKijunGaku() {
        return this.getGokeiPanel().getTxtSanteiKijunGaku();
    }

    @JsonIgnore
    public void  setTxtSanteiKijunGaku(TextBoxNum txtSanteiKijunGaku) {
        this.getGokeiPanel().setTxtSanteiKijunGaku(txtSanteiKijunGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSiharaiZumiGaku() {
        return this.getGokeiPanel().getTxtSiharaiZumiGaku();
    }

    @JsonIgnore
    public void  setTxtSiharaiZumiGaku(TextBoxNum txtSiharaiZumiGaku) {
        this.getGokeiPanel().setTxtSiharaiZumiGaku(txtSiharaiZumiGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtKogakuShikyuGaku() {
        return this.getGokeiPanel().getTxtKogakuShikyuGaku();
    }

    @JsonIgnore
    public void  setTxtKogakuShikyuGaku(TextBoxNum txtKogakuShikyuGaku) {
        this.getGokeiPanel().setTxtKogakuShikyuGaku(txtKogakuShikyuGaku);
    }

    @JsonIgnore
    public RadioButton getRdbTsukiOkure() {
        return this.getKogakuKyufuKonkyoPanel().getRdbTsukiOkure();
    }

    @JsonIgnore
    public void  setRdbTsukiOkure(RadioButton rdbTsukiOkure) {
        this.getKogakuKyufuKonkyoPanel().setRdbTsukiOkure(rdbTsukiOkure);
    }

    @JsonIgnore
    public RadioButton getRabSetaiShotokuKubun() {
        return this.getKogakuKyufuKonkyoPanel().getRabSetaiShotokuKubun();
    }

    @JsonIgnore
    public void  setRabSetaiShotokuKubun(RadioButton rabSetaiShotokuKubun) {
        this.getKogakuKyufuKonkyoPanel().setRabSetaiShotokuKubun(rabSetaiShotokuKubun);
    }

    @JsonIgnore
    public RadioButton getRdbShotokuKubun() {
        return this.getKogakuKyufuKonkyoPanel().getRdbShotokuKubun();
    }

    @JsonIgnore
    public void  setRdbShotokuKubun(RadioButton rdbShotokuKubun) {
        this.getKogakuKyufuKonkyoPanel().setRdbShotokuKubun(rdbShotokuKubun);
    }

    @JsonIgnore
    public RadioButton getRdbGassan() {
        return this.getKogakuKyufuKonkyoPanel().getRdbGassan();
    }

    @JsonIgnore
    public void  setRdbGassan(RadioButton rdbGassan) {
        this.getKogakuKyufuKonkyoPanel().setRdbGassan(rdbGassan);
    }

    @JsonIgnore
    public RadioButton getRdbRoreiFukushiNenkin() {
        return this.getKogakuKyufuKonkyoPanel().getRdbRoreiFukushiNenkin();
    }

    @JsonIgnore
    public void  setRdbRoreiFukushiNenkin(RadioButton rdbRoreiFukushiNenkin) {
        this.getKogakuKyufuKonkyoPanel().setRdbRoreiFukushiNenkin(rdbRoreiFukushiNenkin);
    }

    @JsonIgnore
    public RadioButton getRdbRiyoshafutanDai2dankai() {
        return this.getKogakuKyufuKonkyoPanel().getRdbRiyoshafutanDai2dankai();
    }

    @JsonIgnore
    public void  setRdbRiyoshafutanDai2dankai(RadioButton rdbRiyoshafutanDai2dankai) {
        this.getKogakuKyufuKonkyoPanel().setRdbRiyoshafutanDai2dankai(rdbRiyoshafutanDai2dankai);
    }

    @JsonIgnore
    public RadioButton getRdbGekihenkanwaKubun() {
        return this.getKogakuKyufuKonkyoPanel().getRdbGekihenkanwaKubun();
    }

    @JsonIgnore
    public void  setRdbGekihenkanwaKubun(RadioButton rdbGekihenkanwaKubun) {
        this.getKogakuKyufuKonkyoPanel().setRdbGekihenkanwaKubun(rdbGekihenkanwaKubun);
    }

    // </editor-fold>
}
