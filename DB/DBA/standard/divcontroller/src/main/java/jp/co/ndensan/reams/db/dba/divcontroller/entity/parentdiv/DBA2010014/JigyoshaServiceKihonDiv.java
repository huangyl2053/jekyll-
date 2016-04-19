package jp.co.ndensan.reams.db.dba.divcontroller.entity.parentdiv.DBA2010014;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * JigyoshaServiceKihon のクラスファイル 
 * 
 */
public class JigyoshaServiceKihonDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlServiceShuruiChiikiMitchaku")
    private DropDownList ddlServiceShuruiChiikiMitchaku;
    @JsonProperty("chkKihonJunkyoFlag")
    private CheckBoxList chkKihonJunkyoFlag;
    @JsonProperty("Jigyosha")
    private JigyoshaDiv Jigyosha;
    @JsonProperty("txtTorokuHokenshaNo")
    private TextBoxCode txtTorokuHokenshaNo;
    @JsonProperty("btnHokenshaInputGuide")
    private ButtonDialog btnHokenshaInputGuide;
    @JsonProperty("txtTorokuHokenshaName")
    private TextBox txtTorokuHokenshaName;
    @JsonProperty("radJuryoininUmu")
    private RadioButton radJuryoininUmu;
    @JsonProperty("txtTorokuKaishiYMD")
    private TextBoxFlexibleDate txtTorokuKaishiYMD;
    @JsonProperty("txtTorokuShuryoYMD")
    private TextBoxFlexibleDate txtTorokuShuryoYMD;
    @JsonProperty("txtKanrishaName")
    private TextBox txtKanrishaName;
    @JsonProperty("txtKanrishaNameKana")
    private TextBox txtKanrishaNameKana;
    @JsonProperty("txtKanrishaYubinNo")
    private TextBoxYubinNo txtKanrishaYubinNo;
    @JsonProperty("txtKanrishaAddress")
    private TextBox txtKanrishaAddress;
    @JsonProperty("txtKanrishaAddressKana")
    private TextBox txtKanrishaAddressKana;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("radShakaiFukushihoujinKeigenjigyouJisshiUumu")
    private RadioButton radShakaiFukushihoujinKeigenjigyouJisshiUumu;
    @JsonProperty("radSeikatsuhogohouShiteiUmu")
    private RadioButton radSeikatsuhogohouShiteiUmu;
    @JsonProperty("btnInputShosai")
    private Button btnInputShosai;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlServiceShuruiChiikiMitchaku
     * @return ddlServiceShuruiChiikiMitchaku
     */
    @JsonProperty("ddlServiceShuruiChiikiMitchaku")
    public DropDownList getDdlServiceShuruiChiikiMitchaku() {
        return ddlServiceShuruiChiikiMitchaku;
    }

    /*
     * setddlServiceShuruiChiikiMitchaku
     * @param ddlServiceShuruiChiikiMitchaku ddlServiceShuruiChiikiMitchaku
     */
    @JsonProperty("ddlServiceShuruiChiikiMitchaku")
    public void setDdlServiceShuruiChiikiMitchaku(DropDownList ddlServiceShuruiChiikiMitchaku) {
        this.ddlServiceShuruiChiikiMitchaku = ddlServiceShuruiChiikiMitchaku;
    }

    /*
     * getchkKihonJunkyoFlag
     * @return chkKihonJunkyoFlag
     */
    @JsonProperty("chkKihonJunkyoFlag")
    public CheckBoxList getChkKihonJunkyoFlag() {
        return chkKihonJunkyoFlag;
    }

    /*
     * setchkKihonJunkyoFlag
     * @param chkKihonJunkyoFlag chkKihonJunkyoFlag
     */
    @JsonProperty("chkKihonJunkyoFlag")
    public void setChkKihonJunkyoFlag(CheckBoxList chkKihonJunkyoFlag) {
        this.chkKihonJunkyoFlag = chkKihonJunkyoFlag;
    }

    /*
     * getJigyosha
     * @return Jigyosha
     */
    @JsonProperty("Jigyosha")
    public JigyoshaDiv getJigyosha() {
        return Jigyosha;
    }

    /*
     * setJigyosha
     * @param Jigyosha Jigyosha
     */
    @JsonProperty("Jigyosha")
    public void setJigyosha(JigyoshaDiv Jigyosha) {
        this.Jigyosha = Jigyosha;
    }

    /*
     * gettxtTorokuHokenshaNo
     * @return txtTorokuHokenshaNo
     */
    @JsonProperty("txtTorokuHokenshaNo")
    public TextBoxCode getTxtTorokuHokenshaNo() {
        return txtTorokuHokenshaNo;
    }

    /*
     * settxtTorokuHokenshaNo
     * @param txtTorokuHokenshaNo txtTorokuHokenshaNo
     */
    @JsonProperty("txtTorokuHokenshaNo")
    public void setTxtTorokuHokenshaNo(TextBoxCode txtTorokuHokenshaNo) {
        this.txtTorokuHokenshaNo = txtTorokuHokenshaNo;
    }

    /*
     * getbtnHokenshaInputGuide
     * @return btnHokenshaInputGuide
     */
    @JsonProperty("btnHokenshaInputGuide")
    public ButtonDialog getBtnHokenshaInputGuide() {
        return btnHokenshaInputGuide;
    }

    /*
     * setbtnHokenshaInputGuide
     * @param btnHokenshaInputGuide btnHokenshaInputGuide
     */
    @JsonProperty("btnHokenshaInputGuide")
    public void setBtnHokenshaInputGuide(ButtonDialog btnHokenshaInputGuide) {
        this.btnHokenshaInputGuide = btnHokenshaInputGuide;
    }

    /*
     * gettxtTorokuHokenshaName
     * @return txtTorokuHokenshaName
     */
    @JsonProperty("txtTorokuHokenshaName")
    public TextBox getTxtTorokuHokenshaName() {
        return txtTorokuHokenshaName;
    }

    /*
     * settxtTorokuHokenshaName
     * @param txtTorokuHokenshaName txtTorokuHokenshaName
     */
    @JsonProperty("txtTorokuHokenshaName")
    public void setTxtTorokuHokenshaName(TextBox txtTorokuHokenshaName) {
        this.txtTorokuHokenshaName = txtTorokuHokenshaName;
    }

    /*
     * getradJuryoininUmu
     * @return radJuryoininUmu
     */
    @JsonProperty("radJuryoininUmu")
    public RadioButton getRadJuryoininUmu() {
        return radJuryoininUmu;
    }

    /*
     * setradJuryoininUmu
     * @param radJuryoininUmu radJuryoininUmu
     */
    @JsonProperty("radJuryoininUmu")
    public void setRadJuryoininUmu(RadioButton radJuryoininUmu) {
        this.radJuryoininUmu = radJuryoininUmu;
    }

    /*
     * gettxtTorokuKaishiYMD
     * @return txtTorokuKaishiYMD
     */
    @JsonProperty("txtTorokuKaishiYMD")
    public TextBoxFlexibleDate getTxtTorokuKaishiYMD() {
        return txtTorokuKaishiYMD;
    }

    /*
     * settxtTorokuKaishiYMD
     * @param txtTorokuKaishiYMD txtTorokuKaishiYMD
     */
    @JsonProperty("txtTorokuKaishiYMD")
    public void setTxtTorokuKaishiYMD(TextBoxFlexibleDate txtTorokuKaishiYMD) {
        this.txtTorokuKaishiYMD = txtTorokuKaishiYMD;
    }

    /*
     * gettxtTorokuShuryoYMD
     * @return txtTorokuShuryoYMD
     */
    @JsonProperty("txtTorokuShuryoYMD")
    public TextBoxFlexibleDate getTxtTorokuShuryoYMD() {
        return txtTorokuShuryoYMD;
    }

    /*
     * settxtTorokuShuryoYMD
     * @param txtTorokuShuryoYMD txtTorokuShuryoYMD
     */
    @JsonProperty("txtTorokuShuryoYMD")
    public void setTxtTorokuShuryoYMD(TextBoxFlexibleDate txtTorokuShuryoYMD) {
        this.txtTorokuShuryoYMD = txtTorokuShuryoYMD;
    }

    /*
     * gettxtKanrishaName
     * @return txtKanrishaName
     */
    @JsonProperty("txtKanrishaName")
    public TextBox getTxtKanrishaName() {
        return txtKanrishaName;
    }

    /*
     * settxtKanrishaName
     * @param txtKanrishaName txtKanrishaName
     */
    @JsonProperty("txtKanrishaName")
    public void setTxtKanrishaName(TextBox txtKanrishaName) {
        this.txtKanrishaName = txtKanrishaName;
    }

    /*
     * gettxtKanrishaNameKana
     * @return txtKanrishaNameKana
     */
    @JsonProperty("txtKanrishaNameKana")
    public TextBox getTxtKanrishaNameKana() {
        return txtKanrishaNameKana;
    }

    /*
     * settxtKanrishaNameKana
     * @param txtKanrishaNameKana txtKanrishaNameKana
     */
    @JsonProperty("txtKanrishaNameKana")
    public void setTxtKanrishaNameKana(TextBox txtKanrishaNameKana) {
        this.txtKanrishaNameKana = txtKanrishaNameKana;
    }

    /*
     * gettxtKanrishaYubinNo
     * @return txtKanrishaYubinNo
     */
    @JsonProperty("txtKanrishaYubinNo")
    public TextBoxYubinNo getTxtKanrishaYubinNo() {
        return txtKanrishaYubinNo;
    }

    /*
     * settxtKanrishaYubinNo
     * @param txtKanrishaYubinNo txtKanrishaYubinNo
     */
    @JsonProperty("txtKanrishaYubinNo")
    public void setTxtKanrishaYubinNo(TextBoxYubinNo txtKanrishaYubinNo) {
        this.txtKanrishaYubinNo = txtKanrishaYubinNo;
    }

    /*
     * gettxtKanrishaAddress
     * @return txtKanrishaAddress
     */
    @JsonProperty("txtKanrishaAddress")
    public TextBox getTxtKanrishaAddress() {
        return txtKanrishaAddress;
    }

    /*
     * settxtKanrishaAddress
     * @param txtKanrishaAddress txtKanrishaAddress
     */
    @JsonProperty("txtKanrishaAddress")
    public void setTxtKanrishaAddress(TextBox txtKanrishaAddress) {
        this.txtKanrishaAddress = txtKanrishaAddress;
    }

    /*
     * gettxtKanrishaAddressKana
     * @return txtKanrishaAddressKana
     */
    @JsonProperty("txtKanrishaAddressKana")
    public TextBox getTxtKanrishaAddressKana() {
        return txtKanrishaAddressKana;
    }

    /*
     * settxtKanrishaAddressKana
     * @param txtKanrishaAddressKana txtKanrishaAddressKana
     */
    @JsonProperty("txtKanrishaAddressKana")
    public void setTxtKanrishaAddressKana(TextBox txtKanrishaAddressKana) {
        this.txtKanrishaAddressKana = txtKanrishaAddressKana;
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
     * getradShakaiFukushihoujinKeigenjigyouJisshiUumu
     * @return radShakaiFukushihoujinKeigenjigyouJisshiUumu
     */
    @JsonProperty("radShakaiFukushihoujinKeigenjigyouJisshiUumu")
    public RadioButton getRadShakaiFukushihoujinKeigenjigyouJisshiUumu() {
        return radShakaiFukushihoujinKeigenjigyouJisshiUumu;
    }

    /*
     * setradShakaiFukushihoujinKeigenjigyouJisshiUumu
     * @param radShakaiFukushihoujinKeigenjigyouJisshiUumu radShakaiFukushihoujinKeigenjigyouJisshiUumu
     */
    @JsonProperty("radShakaiFukushihoujinKeigenjigyouJisshiUumu")
    public void setRadShakaiFukushihoujinKeigenjigyouJisshiUumu(RadioButton radShakaiFukushihoujinKeigenjigyouJisshiUumu) {
        this.radShakaiFukushihoujinKeigenjigyouJisshiUumu = radShakaiFukushihoujinKeigenjigyouJisshiUumu;
    }

    /*
     * getradSeikatsuhogohouShiteiUmu
     * @return radSeikatsuhogohouShiteiUmu
     */
    @JsonProperty("radSeikatsuhogohouShiteiUmu")
    public RadioButton getRadSeikatsuhogohouShiteiUmu() {
        return radSeikatsuhogohouShiteiUmu;
    }

    /*
     * setradSeikatsuhogohouShiteiUmu
     * @param radSeikatsuhogohouShiteiUmu radSeikatsuhogohouShiteiUmu
     */
    @JsonProperty("radSeikatsuhogohouShiteiUmu")
    public void setRadSeikatsuhogohouShiteiUmu(RadioButton radSeikatsuhogohouShiteiUmu) {
        this.radSeikatsuhogohouShiteiUmu = radSeikatsuhogohouShiteiUmu;
    }

    /*
     * getbtnInputShosai
     * @return btnInputShosai
     */
    @JsonProperty("btnInputShosai")
    public Button getBtnInputShosai() {
        return btnInputShosai;
    }

    /*
     * setbtnInputShosai
     * @param btnInputShosai btnInputShosai
     */
    @JsonProperty("btnInputShosai")
    public void setBtnInputShosai(Button btnInputShosai) {
        this.btnInputShosai = btnInputShosai;
    }

    // </editor-fold>
}
