package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuKyufuTaishoList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * 画面設計_DBCKD00006_高額給付対象一覧共有子Div
 *
 * @reamsid_L DBC-2020-030 quxiaodong
 */
public class MeisaiGokeiHenshuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-04_20-51-13">
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
    @JsonProperty("txtSanteiKijunGaku")
    private TextBoxNum txtSanteiKijunGaku;
    @JsonProperty("txtSiharaiZumiGaku")
    private TextBoxNum txtSiharaiZumiGaku;
    @JsonProperty("txtKogakuShikyuGaku")
    private TextBoxNum txtKogakuShikyuGaku;
    @JsonProperty("txtSetaiSyuyakuBango")
    private TextBox txtSetaiSyuyakuBango;
    @JsonProperty("rdbKogakuJidoSyokanTaisyo")
    private RadioButton rdbKogakuJidoSyokanTaisyo;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("rdbTsukiOkure")
    private RadioButton rdbTsukiOkure;
    @JsonProperty("rabSetaiShotokuKubun")
    private RadioButton rabSetaiShotokuKubun;
    @JsonProperty("rdbShotokuKubun")
    private RadioButton rdbShotokuKubun;
    @JsonProperty("rdbGassan")
    private RadioButton rdbGassan;
    @JsonProperty("rdbRoreiFukushiNenkin")
    private RadioButton rdbRoreiFukushiNenkin;
    @JsonProperty("rdbRiyoshafutanDai2dankai")
    private RadioButton rdbRiyoshafutanDai2dankai;
    @JsonProperty("rdbGekihenkanwaKubun")
    private RadioButton rdbGekihenkanwaKubun;
    @JsonProperty("btnkakutei")
    private Button btnkakutei;
    @JsonProperty("btnTorikeshi")
    private Button btnTorikeshi;

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
     * gettxtSanteiKijunGaku
     * @return txtSanteiKijunGaku
     */
    @JsonProperty("txtSanteiKijunGaku")
    public TextBoxNum getTxtSanteiKijunGaku() {
        return txtSanteiKijunGaku;
    }

    /*
     * settxtSanteiKijunGaku
     * @param txtSanteiKijunGaku txtSanteiKijunGaku
     */
    @JsonProperty("txtSanteiKijunGaku")
    public void setTxtSanteiKijunGaku(TextBoxNum txtSanteiKijunGaku) {
        this.txtSanteiKijunGaku = txtSanteiKijunGaku;
    }

    /*
     * gettxtSiharaiZumiGaku
     * @return txtSiharaiZumiGaku
     */
    @JsonProperty("txtSiharaiZumiGaku")
    public TextBoxNum getTxtSiharaiZumiGaku() {
        return txtSiharaiZumiGaku;
    }

    /*
     * settxtSiharaiZumiGaku
     * @param txtSiharaiZumiGaku txtSiharaiZumiGaku
     */
    @JsonProperty("txtSiharaiZumiGaku")
    public void setTxtSiharaiZumiGaku(TextBoxNum txtSiharaiZumiGaku) {
        this.txtSiharaiZumiGaku = txtSiharaiZumiGaku;
    }

    /*
     * gettxtKogakuShikyuGaku
     * @return txtKogakuShikyuGaku
     */
    @JsonProperty("txtKogakuShikyuGaku")
    public TextBoxNum getTxtKogakuShikyuGaku() {
        return txtKogakuShikyuGaku;
    }

    /*
     * settxtKogakuShikyuGaku
     * @param txtKogakuShikyuGaku txtKogakuShikyuGaku
     */
    @JsonProperty("txtKogakuShikyuGaku")
    public void setTxtKogakuShikyuGaku(TextBoxNum txtKogakuShikyuGaku) {
        this.txtKogakuShikyuGaku = txtKogakuShikyuGaku;
    }

    /*
     * gettxtSetaiSyuyakuBango
     * @return txtSetaiSyuyakuBango
     */
    @JsonProperty("txtSetaiSyuyakuBango")
    public TextBox getTxtSetaiSyuyakuBango() {
        return txtSetaiSyuyakuBango;
    }

    /*
     * settxtSetaiSyuyakuBango
     * @param txtSetaiSyuyakuBango txtSetaiSyuyakuBango
     */
    @JsonProperty("txtSetaiSyuyakuBango")
    public void setTxtSetaiSyuyakuBango(TextBox txtSetaiSyuyakuBango) {
        this.txtSetaiSyuyakuBango = txtSetaiSyuyakuBango;
    }

    /*
     * getrdbKogakuJidoSyokanTaisyo
     * @return rdbKogakuJidoSyokanTaisyo
     */
    @JsonProperty("rdbKogakuJidoSyokanTaisyo")
    public RadioButton getRdbKogakuJidoSyokanTaisyo() {
        return rdbKogakuJidoSyokanTaisyo;
    }

    /*
     * setrdbKogakuJidoSyokanTaisyo
     * @param rdbKogakuJidoSyokanTaisyo rdbKogakuJidoSyokanTaisyo
     */
    @JsonProperty("rdbKogakuJidoSyokanTaisyo")
    public void setRdbKogakuJidoSyokanTaisyo(RadioButton rdbKogakuJidoSyokanTaisyo) {
        this.rdbKogakuJidoSyokanTaisyo = rdbKogakuJidoSyokanTaisyo;
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
     * getrdbTsukiOkure
     * @return rdbTsukiOkure
     */
    @JsonProperty("rdbTsukiOkure")
    public RadioButton getRdbTsukiOkure() {
        return rdbTsukiOkure;
    }

    /*
     * setrdbTsukiOkure
     * @param rdbTsukiOkure rdbTsukiOkure
     */
    @JsonProperty("rdbTsukiOkure")
    public void setRdbTsukiOkure(RadioButton rdbTsukiOkure) {
        this.rdbTsukiOkure = rdbTsukiOkure;
    }

    /*
     * getrabSetaiShotokuKubun
     * @return rabSetaiShotokuKubun
     */
    @JsonProperty("rabSetaiShotokuKubun")
    public RadioButton getRabSetaiShotokuKubun() {
        return rabSetaiShotokuKubun;
    }

    /*
     * setrabSetaiShotokuKubun
     * @param rabSetaiShotokuKubun rabSetaiShotokuKubun
     */
    @JsonProperty("rabSetaiShotokuKubun")
    public void setRabSetaiShotokuKubun(RadioButton rabSetaiShotokuKubun) {
        this.rabSetaiShotokuKubun = rabSetaiShotokuKubun;
    }

    /*
     * getrdbShotokuKubun
     * @return rdbShotokuKubun
     */
    @JsonProperty("rdbShotokuKubun")
    public RadioButton getRdbShotokuKubun() {
        return rdbShotokuKubun;
    }

    /*
     * setrdbShotokuKubun
     * @param rdbShotokuKubun rdbShotokuKubun
     */
    @JsonProperty("rdbShotokuKubun")
    public void setRdbShotokuKubun(RadioButton rdbShotokuKubun) {
        this.rdbShotokuKubun = rdbShotokuKubun;
    }

    /*
     * getrdbGassan
     * @return rdbGassan
     */
    @JsonProperty("rdbGassan")
    public RadioButton getRdbGassan() {
        return rdbGassan;
    }

    /*
     * setrdbGassan
     * @param rdbGassan rdbGassan
     */
    @JsonProperty("rdbGassan")
    public void setRdbGassan(RadioButton rdbGassan) {
        this.rdbGassan = rdbGassan;
    }

    /*
     * getrdbRoreiFukushiNenkin
     * @return rdbRoreiFukushiNenkin
     */
    @JsonProperty("rdbRoreiFukushiNenkin")
    public RadioButton getRdbRoreiFukushiNenkin() {
        return rdbRoreiFukushiNenkin;
    }

    /*
     * setrdbRoreiFukushiNenkin
     * @param rdbRoreiFukushiNenkin rdbRoreiFukushiNenkin
     */
    @JsonProperty("rdbRoreiFukushiNenkin")
    public void setRdbRoreiFukushiNenkin(RadioButton rdbRoreiFukushiNenkin) {
        this.rdbRoreiFukushiNenkin = rdbRoreiFukushiNenkin;
    }

    /*
     * getrdbRiyoshafutanDai2dankai
     * @return rdbRiyoshafutanDai2dankai
     */
    @JsonProperty("rdbRiyoshafutanDai2dankai")
    public RadioButton getRdbRiyoshafutanDai2dankai() {
        return rdbRiyoshafutanDai2dankai;
    }

    /*
     * setrdbRiyoshafutanDai2dankai
     * @param rdbRiyoshafutanDai2dankai rdbRiyoshafutanDai2dankai
     */
    @JsonProperty("rdbRiyoshafutanDai2dankai")
    public void setRdbRiyoshafutanDai2dankai(RadioButton rdbRiyoshafutanDai2dankai) {
        this.rdbRiyoshafutanDai2dankai = rdbRiyoshafutanDai2dankai;
    }

    /*
     * getrdbGekihenkanwaKubun
     * @return rdbGekihenkanwaKubun
     */
    @JsonProperty("rdbGekihenkanwaKubun")
    public RadioButton getRdbGekihenkanwaKubun() {
        return rdbGekihenkanwaKubun;
    }

    /*
     * setrdbGekihenkanwaKubun
     * @param rdbGekihenkanwaKubun rdbGekihenkanwaKubun
     */
    @JsonProperty("rdbGekihenkanwaKubun")
    public void setRdbGekihenkanwaKubun(RadioButton rdbGekihenkanwaKubun) {
        this.rdbGekihenkanwaKubun = rdbGekihenkanwaKubun;
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

    // </editor-fold>
}
