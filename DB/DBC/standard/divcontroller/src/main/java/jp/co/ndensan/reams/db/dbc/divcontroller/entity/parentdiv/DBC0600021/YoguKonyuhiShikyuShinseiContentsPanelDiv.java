package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0600021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * YoguKonyuhiShikyuShinseiContentsPanel のクラスファイル
 *
 * @reamsid_L DBC-1020-030 quxiaodong
 */
public class YoguKonyuhiShikyuShinseiContentsPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTeikyoYM")
    private TextBoxDate txtTeikyoYM;
    @JsonProperty("txtSeiriNo")
    private TextBoxCode txtSeiriNo;
    @JsonProperty("txtKyufuritsu")
    private TextBoxNum txtKyufuritsu;
    @JsonProperty("ddlShityoson")
    private DropDownList ddlShityoson;
    @JsonProperty("chkKokuhorenSend")
    private CheckBoxList chkKokuhorenSend;
    @JsonProperty("txtJigyoshaNo")
    private TextBoxCode txtJigyoshaNo;
    @JsonProperty("txtSyomeisyo")
    private TextBoxCode txtSyomeisyo;
    @JsonProperty("btnAddDetail")
    private Button btnAddDetail;
    @JsonProperty("dgSeikyuDetail")
    private DataGrid<dgSeikyuDetail_Row> dgSeikyuDetail;
    @JsonProperty("YoguKonyuhiDetailInput")
    private YoguKonyuhiDetailInputDiv YoguKonyuhiDetailInput;
    @JsonProperty("PnlSummary")
    private PnlSummaryDiv PnlSummary;
    @JsonProperty("PnlShinsakekka")
    private PnlShinsakekkaDiv PnlShinsakekka;
    @JsonProperty("PnlShinsesyaJoho")
    private PnlShinsesyaJohoDiv PnlShinsesyaJoho;
    @JsonProperty("PnlShiharaiHoho")
    private PnlShiharaiHohoDiv PnlShiharaiHoho;
    @JsonProperty("rowId")
    private TextBoxNum rowId;
    @JsonProperty("txtServiceCode")
    private TextBox txtServiceCode;
    @JsonProperty("JigyoshaMode")
    private RString JigyoshaMode;
    @JsonProperty("FukushiyoguShohinMode")
    private RString FukushiyoguShohinMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTeikyoYM
     * @return txtTeikyoYM
     */
    @JsonProperty("txtTeikyoYM")
    public TextBoxDate getTxtTeikyoYM() {
        return txtTeikyoYM;
    }

    /*
     * settxtTeikyoYM
     * @param txtTeikyoYM txtTeikyoYM
     */
    @JsonProperty("txtTeikyoYM")
    public void setTxtTeikyoYM(TextBoxDate txtTeikyoYM) {
        this.txtTeikyoYM = txtTeikyoYM;
    }

    /*
     * gettxtSeiriNo
     * @return txtSeiriNo
     */
    @JsonProperty("txtSeiriNo")
    public TextBoxCode getTxtSeiriNo() {
        return txtSeiriNo;
    }

    /*
     * settxtSeiriNo
     * @param txtSeiriNo txtSeiriNo
     */
    @JsonProperty("txtSeiriNo")
    public void setTxtSeiriNo(TextBoxCode txtSeiriNo) {
        this.txtSeiriNo = txtSeiriNo;
    }

    /*
     * gettxtKyufuritsu
     * @return txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public TextBoxNum getTxtKyufuritsu() {
        return txtKyufuritsu;
    }

    /*
     * settxtKyufuritsu
     * @param txtKyufuritsu txtKyufuritsu
     */
    @JsonProperty("txtKyufuritsu")
    public void setTxtKyufuritsu(TextBoxNum txtKyufuritsu) {
        this.txtKyufuritsu = txtKyufuritsu;
    }

    /*
     * getddlShityoson
     * @return ddlShityoson
     */
    @JsonProperty("ddlShityoson")
    public DropDownList getDdlShityoson() {
        return ddlShityoson;
    }

    /*
     * setddlShityoson
     * @param ddlShityoson ddlShityoson
     */
    @JsonProperty("ddlShityoson")
    public void setDdlShityoson(DropDownList ddlShityoson) {
        this.ddlShityoson = ddlShityoson;
    }

    /*
     * getchkKokuhorenSend
     * @return chkKokuhorenSend
     */
    @JsonProperty("chkKokuhorenSend")
    public CheckBoxList getChkKokuhorenSend() {
        return chkKokuhorenSend;
    }

    /*
     * setchkKokuhorenSend
     * @param chkKokuhorenSend chkKokuhorenSend
     */
    @JsonProperty("chkKokuhorenSend")
    public void setChkKokuhorenSend(CheckBoxList chkKokuhorenSend) {
        this.chkKokuhorenSend = chkKokuhorenSend;
    }

    /*
     * gettxtJigyoshaNo
     * @return txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public TextBoxCode getTxtJigyoshaNo() {
        return txtJigyoshaNo;
    }

    /*
     * settxtJigyoshaNo
     * @param txtJigyoshaNo txtJigyoshaNo
     */
    @JsonProperty("txtJigyoshaNo")
    public void setTxtJigyoshaNo(TextBoxCode txtJigyoshaNo) {
        this.txtJigyoshaNo = txtJigyoshaNo;
    }

    /*
     * gettxtSyomeisyo
     * @return txtSyomeisyo
     */
    @JsonProperty("txtSyomeisyo")
    public TextBoxCode getTxtSyomeisyo() {
        return txtSyomeisyo;
    }

    /*
     * settxtSyomeisyo
     * @param txtSyomeisyo txtSyomeisyo
     */
    @JsonProperty("txtSyomeisyo")
    public void setTxtSyomeisyo(TextBoxCode txtSyomeisyo) {
        this.txtSyomeisyo = txtSyomeisyo;
    }

    /*
     * getbtnAddDetail
     * @return btnAddDetail
     */
    @JsonProperty("btnAddDetail")
    public Button getBtnAddDetail() {
        return btnAddDetail;
    }

    /*
     * setbtnAddDetail
     * @param btnAddDetail btnAddDetail
     */
    @JsonProperty("btnAddDetail")
    public void setBtnAddDetail(Button btnAddDetail) {
        this.btnAddDetail = btnAddDetail;
    }

    /*
     * getdgSeikyuDetail
     * @return dgSeikyuDetail
     */
    @JsonProperty("dgSeikyuDetail")
    public DataGrid<dgSeikyuDetail_Row> getDgSeikyuDetail() {
        return dgSeikyuDetail;
    }

    /*
     * setdgSeikyuDetail
     * @param dgSeikyuDetail dgSeikyuDetail
     */
    @JsonProperty("dgSeikyuDetail")
    public void setDgSeikyuDetail(DataGrid<dgSeikyuDetail_Row> dgSeikyuDetail) {
        this.dgSeikyuDetail = dgSeikyuDetail;
    }

    /*
     * getYoguKonyuhiDetailInput
     * @return YoguKonyuhiDetailInput
     */
    @JsonProperty("YoguKonyuhiDetailInput")
    public YoguKonyuhiDetailInputDiv getYoguKonyuhiDetailInput() {
        return YoguKonyuhiDetailInput;
    }

    /*
     * setYoguKonyuhiDetailInput
     * @param YoguKonyuhiDetailInput YoguKonyuhiDetailInput
     */
    @JsonProperty("YoguKonyuhiDetailInput")
    public void setYoguKonyuhiDetailInput(YoguKonyuhiDetailInputDiv YoguKonyuhiDetailInput) {
        this.YoguKonyuhiDetailInput = YoguKonyuhiDetailInput;
    }

    /*
     * getPnlSummary
     * @return PnlSummary
     */
    @JsonProperty("PnlSummary")
    public PnlSummaryDiv getPnlSummary() {
        return PnlSummary;
    }

    /*
     * setPnlSummary
     * @param PnlSummary PnlSummary
     */
    @JsonProperty("PnlSummary")
    public void setPnlSummary(PnlSummaryDiv PnlSummary) {
        this.PnlSummary = PnlSummary;
    }

    /*
     * getPnlShinsakekka
     * @return PnlShinsakekka
     */
    @JsonProperty("PnlShinsakekka")
    public PnlShinsakekkaDiv getPnlShinsakekka() {
        return PnlShinsakekka;
    }

    /*
     * setPnlShinsakekka
     * @param PnlShinsakekka PnlShinsakekka
     */
    @JsonProperty("PnlShinsakekka")
    public void setPnlShinsakekka(PnlShinsakekkaDiv PnlShinsakekka) {
        this.PnlShinsakekka = PnlShinsakekka;
    }

    /*
     * getPnlShinsesyaJoho
     * @return PnlShinsesyaJoho
     */
    @JsonProperty("PnlShinsesyaJoho")
    public PnlShinsesyaJohoDiv getPnlShinsesyaJoho() {
        return PnlShinsesyaJoho;
    }

    /*
     * setPnlShinsesyaJoho
     * @param PnlShinsesyaJoho PnlShinsesyaJoho
     */
    @JsonProperty("PnlShinsesyaJoho")
    public void setPnlShinsesyaJoho(PnlShinsesyaJohoDiv PnlShinsesyaJoho) {
        this.PnlShinsesyaJoho = PnlShinsesyaJoho;
    }

    /*
     * getPnlShiharaiHoho
     * @return PnlShiharaiHoho
     */
    @JsonProperty("PnlShiharaiHoho")
    public PnlShiharaiHohoDiv getPnlShiharaiHoho() {
        return PnlShiharaiHoho;
    }

    /*
     * setPnlShiharaiHoho
     * @param PnlShiharaiHoho PnlShiharaiHoho
     */
    @JsonProperty("PnlShiharaiHoho")
    public void setPnlShiharaiHoho(PnlShiharaiHohoDiv PnlShiharaiHoho) {
        this.PnlShiharaiHoho = PnlShiharaiHoho;
    }

    /*
     * getrowId
     * @return rowId
     */
    @JsonProperty("rowId")
    public TextBoxNum getRowId() {
        return rowId;
    }

    /*
     * setrowId
     * @param rowId rowId
     */
    @JsonProperty("rowId")
    public void setRowId(TextBoxNum rowId) {
        this.rowId = rowId;
    }

    /*
     * gettxtServiceCode
     * @return txtServiceCode
     */
    @JsonProperty("txtServiceCode")
    public TextBox getTxtServiceCode() {
        return txtServiceCode;
    }

    /*
     * settxtServiceCode
     * @param txtServiceCode txtServiceCode
     */
    @JsonProperty("txtServiceCode")
    public void setTxtServiceCode(TextBox txtServiceCode) {
        this.txtServiceCode = txtServiceCode;
    }

    /*
     * getJigyoshaMode
     * @return JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public RString getJigyoshaMode() {
        return JigyoshaMode;
    }

    /*
     * setJigyoshaMode
     * @param JigyoshaMode JigyoshaMode
     */
    @JsonProperty("JigyoshaMode")
    public void setJigyoshaMode(RString JigyoshaMode) {
        this.JigyoshaMode = JigyoshaMode;
    }

    /*
     * getFukushiyoguShohinMode
     * @return FukushiyoguShohinMode
     */
    @JsonProperty("FukushiyoguShohinMode")
    public RString getFukushiyoguShohinMode() {
        return FukushiyoguShohinMode;
    }

    /*
     * setFukushiyoguShohinMode
     * @param FukushiyoguShohinMode FukushiyoguShohinMode
     */
    @JsonProperty("FukushiyoguShohinMode")
    public void setFukushiyoguShohinMode(RString FukushiyoguShohinMode) {
        this.FukushiyoguShohinMode = FukushiyoguShohinMode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tpSummaryDiv getTpSummary() {
        return this.getPnlSummary().getTpSummary();
    }

    @JsonIgnore
    public void setTpSummary(tpSummaryDiv tpSummary) {
        this.getPnlSummary().setTpSummary(tpSummary);
    }

    @JsonIgnore
    public Label getLblShukei() {
        return this.getPnlSummary().getTpSummary().getLblShukei();
    }

    @JsonIgnore
    public Label getLblHiyogakuGokei() {
        return this.getPnlSummary().getTpSummary().getLblHiyogakuGokei();
    }

    @JsonIgnore
    public Label getLblHokenTaishoHiyogakuGokei() {
        return this.getPnlSummary().getTpSummary().getLblHokenTaishoHiyogakuGokei();
    }

    @JsonIgnore
    public Label getLblHokenkyufugakuGokei() {
        return this.getPnlSummary().getTpSummary().getLblHokenkyufugakuGokei();
    }

    @JsonIgnore
    public Label getLblRiyoshaFutangakuGokei() {
        return this.getPnlSummary().getTpSummary().getLblRiyoshaFutangakuGokei();
    }

    @JsonIgnore
    public Label getLblZenkaimadeshiharaikeka() {
        return this.getPnlSummary().getTpSummary().getLblZenkaimadeshiharaikeka();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiHiyogakuGokei() {
        return this.getPnlSummary().getTpSummary().getTxtZenkaiHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiHokenTaishoHiyogakuGokei() {
        return this.getPnlSummary().getTpSummary().getTxtZenkaiHokenTaishoHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiHokenkyufugakuGokei() {
        return this.getPnlSummary().getTpSummary().getTxtZenkaiHokenkyufugakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtZenkaiRiyoshaFutangakuGokei() {
        return this.getPnlSummary().getTpSummary().getTxtZenkaiRiyoshaFutangakuGokei();
    }

    @JsonIgnore
    public Button getBtnKakoFukushiyogukonyuhiKakutei() {
        return this.getPnlSummary().getTpSummary().getBtnKakoFukushiyogukonyuhiKakutei();
    }

    @JsonIgnore
    public Label getLblKonkaiShiharaiJyokyo() {
        return this.getPnlSummary().getTpSummary().getLblKonkaiShiharaiJyokyo();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiHiyogakuGokei() {
        return this.getPnlSummary().getTpSummary().getTxtKonkaiHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiHokenTaishoHiyogakuGokei() {
        return this.getPnlSummary().getTpSummary().getTxtKonkaiHokenTaishoHiyogakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiHokenkyufugakuGokei() {
        return this.getPnlSummary().getTpSummary().getTxtKonkaiHokenkyufugakuGokei();
    }

    @JsonIgnore
    public TextBoxNum getTxtKonkaiRiyoshaFutangakuGokei() {
        return this.getPnlSummary().getTpSummary().getTxtKonkaiRiyoshaFutangakuGokei();
    }

    @JsonIgnore
    public Button getBtnGendogakuCheck() {
        return this.getPnlSummary().getTpSummary().getBtnGendogakuCheck();
    }

    @JsonIgnore
    public Label getLblShinseinaiyo() {
        return this.getPnlShinsakekka().getLblShinseinaiyo();
    }

    @JsonIgnore
    public void setLblShinseinaiyo(Label lblShinseinaiyo) {
        this.getPnlShinsakekka().setLblShinseinaiyo(lblShinseinaiyo);
    }

    @JsonIgnore
    public RadioButton getRadShinsakekka() {
        return this.getPnlShinsakekka().getRadShinsakekka();
    }

    @JsonIgnore
    public void setRadShinsakekka(RadioButton radShinsakekka) {
        this.getPnlShinsakekka().setRadShinsakekka(radShinsakekka);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseibi() {
        return this.getPnlShinsesyaJoho().getTxtShinseibi();
    }

    @JsonIgnore
    public void setTxtShinseibi(TextBoxDate txtShinseibi) {
        this.getPnlShinsesyaJoho().setTxtShinseibi(txtShinseibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtUkechikebi() {
        return this.getPnlShinsesyaJoho().getTxtUkechikebi();
    }

    @JsonIgnore
    public void setTxtUkechikebi(TextBoxDate txtUkechikebi) {
        this.getPnlShinsesyaJoho().setTxtUkechikebi(txtUkechikebi);
    }

    @JsonIgnore
    public TextBoxDate getTxtRyosyuYMD() {
        return this.getPnlShinsesyaJoho().getTxtRyosyuYMD();
    }

    @JsonIgnore
    public void setTxtRyosyuYMD(TextBoxDate txtRyosyuYMD) {
        this.getPnlShinsesyaJoho().setTxtRyosyuYMD(txtRyosyuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShinseisyakubun() {
        return this.getPnlShinsesyaJoho().getDdlShinseisyakubun();
    }

    @JsonIgnore
    public void setDdlShinseisyakubun(DropDownList ddlShinseisyakubun) {
        this.getPnlShinsesyaJoho().setDdlShinseisyakubun(ddlShinseisyakubun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiriyu() {
        return this.getPnlShinsesyaJoho().getTxtShinseiriyu();
    }

    @JsonIgnore
    public void setTxtShinseiriyu(TextBoxMultiLine txtShinseiriyu) {
        this.getPnlShinsesyaJoho().setTxtShinseiriyu(txtShinseiriyu);
    }

    @JsonIgnore
    public TextBoxCode getTxtJigyosya() {
        return this.getPnlShinsesyaJoho().getTxtJigyosya();
    }

    @JsonIgnore
    public void setTxtJigyosya(TextBoxCode txtJigyosya) {
        this.getPnlShinsesyaJoho().setTxtJigyosya(txtJigyosya);
    }

    @JsonIgnore
    public ButtonDialog getBtnJigyosya() {
        return this.getPnlShinsesyaJoho().getBtnJigyosya();
    }

    @JsonIgnore
    public void setBtnJigyosya(ButtonDialog btnJigyosya) {
        this.getPnlShinsesyaJoho().setBtnJigyosya(btnJigyosya);
    }

    @JsonIgnore
    public Button getBtnHonninJohoCopy() {
        return this.getPnlShinsesyaJoho().getBtnHonninJohoCopy();
    }

    @JsonIgnore
    public void setBtnHonninJohoCopy(Button btnHonninJohoCopy) {
        this.getPnlShinsesyaJoho().setBtnHonninJohoCopy(btnHonninJohoCopy);
    }

    @JsonIgnore
    public TextBox getTxtShimei() {
        return this.getPnlShinsesyaJoho().getTxtShimei();
    }

    @JsonIgnore
    public void setTxtShimei(TextBox txtShimei) {
        this.getPnlShinsesyaJoho().setTxtShimei(txtShimei);
    }

    @JsonIgnore
    public TextBoxKana getTxtShimeiKana() {
        return this.getPnlShinsesyaJoho().getTxtShimeiKana();
    }

    @JsonIgnore
    public void setTxtShimeiKana(TextBoxKana txtShimeiKana) {
        this.getPnlShinsesyaJoho().setTxtShimeiKana(txtShimeiKana);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtShinseisyaTel() {
        return this.getPnlShinsesyaJoho().getTxtShinseisyaTel();
    }

    @JsonIgnore
    public void setTxtShinseisyaTel(TextBoxTelNo txtShinseisyaTel) {
        this.getPnlShinsesyaJoho().setTxtShinseisyaTel(txtShinseisyaTel);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtShinseisyaYubin() {
        return this.getPnlShinsesyaJoho().getTxtShinseisyaYubin();
    }

    @JsonIgnore
    public void setTxtShinseisyaYubin(TextBoxYubinNo txtShinseisyaYubin) {
        this.getPnlShinsesyaJoho().setTxtShinseisyaYubin(txtShinseisyaYubin);
    }

    @JsonIgnore
    public TextBoxJusho getTxtShinseisyaJyusyo() {
        return this.getPnlShinsesyaJoho().getTxtShinseisyaJyusyo();
    }

    @JsonIgnore
    public void setTxtShinseisyaJyusyo(TextBoxJusho txtShinseisyaJyusyo) {
        this.getPnlShinsesyaJoho().setTxtShinseisyaJyusyo(txtShinseisyaJyusyo);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoInfo() {
        return this.getPnlShiharaiHoho().getCcdShiharaiHohoInfo();
    }

    // </editor-fold>
}
