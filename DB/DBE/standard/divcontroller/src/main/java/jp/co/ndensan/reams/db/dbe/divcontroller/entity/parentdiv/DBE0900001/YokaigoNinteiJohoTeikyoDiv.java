package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE0900001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * YokaigoNinteiJohoTeikyo のクラスファイル
 *
 * @author 自動生成
 */
public class YokaigoNinteiJohoTeikyoDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-24_17-05-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHihokenshaNo")
    private TextBoxCode txtHihokenshaNo;
    @JsonProperty("txtHihokenshaKubun")
    private TextBox txtHihokenshaKubun;
    @JsonProperty("txtHokenshaNo")
    private TextBoxNum txtHokenshaNo;
    @JsonProperty("txtHokenshaName")
    private TextBox txtHokenshaName;
    @JsonProperty("txtHihokenshaName")
    private TextBox txtHihokenshaName;
    @JsonProperty("txtHihokenshaKana")
    private TextBox txtHihokenshaKana;
    @JsonProperty("txtSeinenYmd")
    private TextBoxDate txtSeinenYmd;
    @JsonProperty("txtNenrei")
    private TextBoxNum txtNenrei;
    @JsonProperty("txtSeibetsu")
    private TextBox txtSeibetsu;
    @JsonProperty("txtYubibNo")
    private TextBoxYubinNo txtYubibNo;
    @JsonProperty("txtjusho")
    private TextBox txtjusho;
    @JsonProperty("txtTelNo")
    private TextBox txtTelNo;
    @JsonProperty("NInteiRirekiInfo")
    private NInteiRirekiInfoDiv NInteiRirekiInfo;
    @JsonProperty("NinteiKekkaShosai")
    private NinteiKekkaShosaiDiv NinteiKekkaShosai;
    @JsonProperty("HakkoChohyo")
    private HakkoChohyoDiv HakkoChohyo;
    @JsonProperty("wfParameter")
    private RString wfParameter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHihokenshaNo
     * @return txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public TextBoxCode getTxtHihokenshaNo() {
        return txtHihokenshaNo;
    }

    /*
     * settxtHihokenshaNo
     * @param txtHihokenshaNo txtHihokenshaNo
     */
    @JsonProperty("txtHihokenshaNo")
    public void setTxtHihokenshaNo(TextBoxCode txtHihokenshaNo) {
        this.txtHihokenshaNo = txtHihokenshaNo;
    }

    /*
     * gettxtHihokenshaKubun
     * @return txtHihokenshaKubun
     */
    @JsonProperty("txtHihokenshaKubun")
    public TextBox getTxtHihokenshaKubun() {
        return txtHihokenshaKubun;
    }

    /*
     * settxtHihokenshaKubun
     * @param txtHihokenshaKubun txtHihokenshaKubun
     */
    @JsonProperty("txtHihokenshaKubun")
    public void setTxtHihokenshaKubun(TextBox txtHihokenshaKubun) {
        this.txtHihokenshaKubun = txtHihokenshaKubun;
    }

    /*
     * gettxtHokenshaNo
     * @return txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public TextBoxNum getTxtHokenshaNo() {
        return txtHokenshaNo;
    }

    /*
     * settxtHokenshaNo
     * @param txtHokenshaNo txtHokenshaNo
     */
    @JsonProperty("txtHokenshaNo")
    public void setTxtHokenshaNo(TextBoxNum txtHokenshaNo) {
        this.txtHokenshaNo = txtHokenshaNo;
    }

    /*
     * gettxtHokenshaName
     * @return txtHokenshaName
     */
    @JsonProperty("txtHokenshaName")
    public TextBox getTxtHokenshaName() {
        return txtHokenshaName;
    }

    /*
     * settxtHokenshaName
     * @param txtHokenshaName txtHokenshaName
     */
    @JsonProperty("txtHokenshaName")
    public void setTxtHokenshaName(TextBox txtHokenshaName) {
        this.txtHokenshaName = txtHokenshaName;
    }

    /*
     * gettxtHihokenshaName
     * @return txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public TextBox getTxtHihokenshaName() {
        return txtHihokenshaName;
    }

    /*
     * settxtHihokenshaName
     * @param txtHihokenshaName txtHihokenshaName
     */
    @JsonProperty("txtHihokenshaName")
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.txtHihokenshaName = txtHihokenshaName;
    }

    /*
     * gettxtHihokenshaKana
     * @return txtHihokenshaKana
     */
    @JsonProperty("txtHihokenshaKana")
    public TextBox getTxtHihokenshaKana() {
        return txtHihokenshaKana;
    }

    /*
     * settxtHihokenshaKana
     * @param txtHihokenshaKana txtHihokenshaKana
     */
    @JsonProperty("txtHihokenshaKana")
    public void setTxtHihokenshaKana(TextBox txtHihokenshaKana) {
        this.txtHihokenshaKana = txtHihokenshaKana;
    }

    /*
     * gettxtSeinenYmd
     * @return txtSeinenYmd
     */
    @JsonProperty("txtSeinenYmd")
    public TextBoxDate getTxtSeinenYmd() {
        return txtSeinenYmd;
    }

    /*
     * settxtSeinenYmd
     * @param txtSeinenYmd txtSeinenYmd
     */
    @JsonProperty("txtSeinenYmd")
    public void setTxtSeinenYmd(TextBoxDate txtSeinenYmd) {
        this.txtSeinenYmd = txtSeinenYmd;
    }

    /*
     * gettxtNenrei
     * @return txtNenrei
     */
    @JsonProperty("txtNenrei")
    public TextBoxNum getTxtNenrei() {
        return txtNenrei;
    }

    /*
     * settxtNenrei
     * @param txtNenrei txtNenrei
     */
    @JsonProperty("txtNenrei")
    public void setTxtNenrei(TextBoxNum txtNenrei) {
        this.txtNenrei = txtNenrei;
    }

    /*
     * gettxtSeibetsu
     * @return txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public TextBox getTxtSeibetsu() {
        return txtSeibetsu;
    }

    /*
     * settxtSeibetsu
     * @param txtSeibetsu txtSeibetsu
     */
    @JsonProperty("txtSeibetsu")
    public void setTxtSeibetsu(TextBox txtSeibetsu) {
        this.txtSeibetsu = txtSeibetsu;
    }

    /*
     * gettxtYubibNo
     * @return txtYubibNo
     */
    @JsonProperty("txtYubibNo")
    public TextBoxYubinNo getTxtYubibNo() {
        return txtYubibNo;
    }

    /*
     * settxtYubibNo
     * @param txtYubibNo txtYubibNo
     */
    @JsonProperty("txtYubibNo")
    public void setTxtYubibNo(TextBoxYubinNo txtYubibNo) {
        this.txtYubibNo = txtYubibNo;
    }

    /*
     * gettxtjusho
     * @return txtjusho
     */
    @JsonProperty("txtjusho")
    public TextBox getTxtjusho() {
        return txtjusho;
    }

    /*
     * settxtjusho
     * @param txtjusho txtjusho
     */
    @JsonProperty("txtjusho")
    public void setTxtjusho(TextBox txtjusho) {
        this.txtjusho = txtjusho;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBox getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBox txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * getNInteiRirekiInfo
     * @return NInteiRirekiInfo
     */
    @JsonProperty("NInteiRirekiInfo")
    public NInteiRirekiInfoDiv getNInteiRirekiInfo() {
        return NInteiRirekiInfo;
    }

    /*
     * setNInteiRirekiInfo
     * @param NInteiRirekiInfo NInteiRirekiInfo
     */
    @JsonProperty("NInteiRirekiInfo")
    public void setNInteiRirekiInfo(NInteiRirekiInfoDiv NInteiRirekiInfo) {
        this.NInteiRirekiInfo = NInteiRirekiInfo;
    }

    /*
     * getNinteiKekkaShosai
     * @return NinteiKekkaShosai
     */
    @JsonProperty("NinteiKekkaShosai")
    public NinteiKekkaShosaiDiv getNinteiKekkaShosai() {
        return NinteiKekkaShosai;
    }

    /*
     * setNinteiKekkaShosai
     * @param NinteiKekkaShosai NinteiKekkaShosai
     */
    @JsonProperty("NinteiKekkaShosai")
    public void setNinteiKekkaShosai(NinteiKekkaShosaiDiv NinteiKekkaShosai) {
        this.NinteiKekkaShosai = NinteiKekkaShosai;
    }

    /*
     * getHakkoChohyo
     * @return HakkoChohyo
     */
    @JsonProperty("HakkoChohyo")
    public HakkoChohyoDiv getHakkoChohyo() {
        return HakkoChohyo;
    }

    /*
     * setHakkoChohyo
     * @param HakkoChohyo HakkoChohyo
     */
    @JsonProperty("HakkoChohyo")
    public void setHakkoChohyo(HakkoChohyoDiv HakkoChohyo) {
        this.HakkoChohyo = HakkoChohyo;
    }

    /*
     * getwfParameter
     * @return wfParameter
     */
    @JsonProperty("wfParameter")
    public RString getWfParameter() {
        return wfParameter;
    }

    /*
     * setwfParameter
     * @param wfParameter wfParameter
     */
    @JsonProperty("wfParameter")
    public void setWfParameter(RString wfParameter) {
        this.wfParameter = wfParameter;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DataGrid<dgNinteiKekkaIchiran_Row> getDgNinteiKekkaIchiran() {
        return this.getNInteiRirekiInfo().getDgNinteiKekkaIchiran();
    }

    @JsonIgnore
    public void setDgNinteiKekkaIchiran(DataGrid<dgNinteiKekkaIchiran_Row> dgNinteiKekkaIchiran) {
        this.getNInteiRirekiInfo().setDgNinteiKekkaIchiran(dgNinteiKekkaIchiran);
    }

    @JsonIgnore
    public RadioButton getRadHihokenshaJohoTeikyoDoi() {
        return this.getNinteiKekkaShosai().getRadHihokenshaJohoTeikyoDoi();
    }

    @JsonIgnore
    public void setRadHihokenshaJohoTeikyoDoi(RadioButton radHihokenshaJohoTeikyoDoi) {
        this.getNinteiKekkaShosai().setRadHihokenshaJohoTeikyoDoi(radHihokenshaJohoTeikyoDoi);
    }

    @JsonIgnore
    public RadioButton getRadShijiiJohoTeikyoDoi() {
        return this.getNinteiKekkaShosai().getRadShijiiJohoTeikyoDoi();
    }

    @JsonIgnore
    public void setRadShijiiJohoTeikyoDoi(RadioButton radShijiiJohoTeikyoDoi) {
        this.getNinteiKekkaShosai().setRadShijiiJohoTeikyoDoi(radShijiiJohoTeikyoDoi);
    }

    @JsonIgnore
    public ShinseiDiv getShinsei() {
        return this.getNinteiKekkaShosai().getShinsei();
    }

    @JsonIgnore
    public void setShinsei(ShinseiDiv Shinsei) {
        this.getNinteiKekkaShosai().setShinsei(Shinsei);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseibi() {
        return this.getNinteiKekkaShosai().getShinsei().getTxtShinseibi();
    }

    @JsonIgnore
    public void setTxtShinseibi(TextBoxDate txtShinseibi) {
        this.getNinteiKekkaShosai().getShinsei().setTxtShinseibi(txtShinseibi);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubunShin() {
        return this.getNinteiKekkaShosai().getShinsei().getTxtShinseiKubunShin();
    }

    @JsonIgnore
    public void setTxtShinseiKubunShin(TextBox txtShinseiKubunShin) {
        this.getNinteiKekkaShosai().getShinsei().setTxtShinseiKubunShin(txtShinseiKubunShin);
    }

    @JsonIgnore
    public TextBox getTxtShinseiKubun() {
        return this.getNinteiKekkaShosai().getShinsei().getTxtShinseiKubun();
    }

    @JsonIgnore
    public void setTxtShinseiKubun(TextBox txtShinseiKubun) {
        this.getNinteiKekkaShosai().getShinsei().setTxtShinseiKubun(txtShinseiKubun);
    }

    @JsonIgnore
    public NinteiChosaDiv getNinteiChosa() {
        return this.getNinteiKekkaShosai().getNinteiChosa();
    }

    @JsonIgnore
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.getNinteiKekkaShosai().setNinteiChosa(NinteiChosa);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaIraibi() {
        return this.getNinteiKekkaShosai().getNinteiChosa().getTxtNinteiChosaIraibi();
    }

    @JsonIgnore
    public void setTxtNinteiChosaIraibi(TextBoxDate txtNinteiChosaIraibi) {
        this.getNinteiKekkaShosai().getNinteiChosa().setTxtNinteiChosaIraibi(txtNinteiChosaIraibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJisshibi() {
        return this.getNinteiKekkaShosai().getNinteiChosa().getTxtNinteiChosaJisshibi();
    }

    @JsonIgnore
    public void setTxtNinteiChosaJisshibi(TextBoxDate txtNinteiChosaJisshibi) {
        this.getNinteiKekkaShosai().getNinteiChosa().setTxtNinteiChosaJisshibi(txtNinteiChosaJisshibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtNinteiChosaJuryobi() {
        return this.getNinteiKekkaShosai().getNinteiChosa().getTxtNinteiChosaJuryobi();
    }

    @JsonIgnore
    public void setTxtNinteiChosaJuryobi(TextBoxDate txtNinteiChosaJuryobi) {
        this.getNinteiKekkaShosai().getNinteiChosa().setTxtNinteiChosaJuryobi(txtNinteiChosaJuryobi);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return this.getNinteiKekkaShosai().getNinteiChosa().getCcdChosaItakusakiAndChosainInput();
    }

    @JsonIgnore
    public IkenshoDiv getIkensho() {
        return this.getNinteiKekkaShosai().getIkensho();
    }

    @JsonIgnore
    public void setIkensho(IkenshoDiv Ikensho) {
        this.getNinteiKekkaShosai().setIkensho(Ikensho);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraibi() {
        return this.getNinteiKekkaShosai().getIkensho().getTxtIkenshoIraibi();
    }

    @JsonIgnore
    public void setTxtIkenshoIraibi(TextBoxDate txtIkenshoIraibi) {
        this.getNinteiKekkaShosai().getIkensho().setTxtIkenshoIraibi(txtIkenshoIraibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoJuryobi() {
        return this.getNinteiKekkaShosai().getIkensho().getTxtIkenshoJuryobi();
    }

    @JsonIgnore
    public void setTxtIkenshoJuryobi(TextBoxDate txtIkenshoJuryobi) {
        this.getNinteiKekkaShosai().getIkensho().setTxtIkenshoJuryobi(txtIkenshoJuryobi);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryoKikanAndShujiiInput() {
        return this.getNinteiKekkaShosai().getIkensho().getCcdShujiiIryoKikanAndShujiiInput();
    }

    @JsonIgnore
    public ShinsakaiDiv getShinsakai() {
        return this.getNinteiKekkaShosai().getShinsakai();
    }

    @JsonIgnore
    public void setShinsakai(ShinsakaiDiv Shinsakai) {
        this.getNinteiKekkaShosai().setShinsakai(Shinsakai);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsakaiKaisaibi() {
        return this.getNinteiKekkaShosai().getShinsakai().getTxtShinsakaiKaisaibi();
    }

    @JsonIgnore
    public void setTxtShinsakaiKaisaibi(TextBoxDate txtShinsakaiKaisaibi) {
        this.getNinteiKekkaShosai().getShinsakai().setTxtShinsakaiKaisaibi(txtShinsakaiKaisaibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsakaiYoteibi() {
        return this.getNinteiKekkaShosai().getShinsakai().getTxtShinsakaiYoteibi();
    }

    @JsonIgnore
    public void setTxtShinsakaiYoteibi(TextBoxDate txtShinsakaiYoteibi) {
        this.getNinteiKekkaShosai().getShinsakai().setTxtShinsakaiYoteibi(txtShinsakaiYoteibi);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyo() {
        return this.getHakkoChohyo().getChkNinteiChosahyo();
    }

    @JsonIgnore
    public void setChkNinteiChosahyo(CheckBoxList chkNinteiChosahyo) {
        this.getHakkoChohyo().setChkNinteiChosahyo(chkNinteiChosahyo);
    }

    @JsonIgnore
    public Space getSpSpace1() {
        return this.getHakkoChohyo().getSpSpace1();
    }

    @JsonIgnore
    public void setSpSpace1(Space spSpace1) {
        this.getHakkoChohyo().setSpSpace1(spSpace1);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiJiko() {
        return this.getHakkoChohyo().getChkTokkiJiko();
    }

    @JsonIgnore
    public void setChkTokkiJiko(CheckBoxList chkTokkiJiko) {
        this.getHakkoChohyo().setChkTokkiJiko(chkTokkiJiko);
    }

    @JsonIgnore
    public RadioButton getRadTokkiJikoMasking() {
        return this.getHakkoChohyo().getRadTokkiJikoMasking();
    }

    @JsonIgnore
    public void setRadTokkiJikoMasking(RadioButton radTokkiJikoMasking) {
        this.getHakkoChohyo().setRadTokkiJikoMasking(radTokkiJikoMasking);
    }

    @JsonIgnore
    public Space getSpSpace2() {
        return this.getHakkoChohyo().getSpSpace2();
    }

    @JsonIgnore
    public void setSpSpace2(Space spSpace2) {
        this.getHakkoChohyo().setSpSpace2(spSpace2);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkensho() {
        return this.getHakkoChohyo().getChkShujiiIkensho();
    }

    @JsonIgnore
    public void setChkShujiiIkensho(CheckBoxList chkShujiiIkensho) {
        this.getHakkoChohyo().setChkShujiiIkensho(chkShujiiIkensho);
    }

    @JsonIgnore
    public RadioButton getRadShujii() {
        return this.getHakkoChohyo().getRadShujii();
    }

    @JsonIgnore
    public void setRadShujii(RadioButton radShujii) {
        this.getHakkoChohyo().setRadShujii(radShujii);
    }

    @JsonIgnore
    public Space getSpSpace3() {
        return this.getHakkoChohyo().getSpSpace3();
    }

    @JsonIgnore
    public void setSpSpace3(Space spSpace3) {
        this.getHakkoChohyo().setSpSpace3(spSpace3);
    }

    @JsonIgnore
    public CheckBoxList getChkSonotaShiryo() {
        return this.getHakkoChohyo().getChkSonotaShiryo();
    }

    @JsonIgnore
    public void setChkSonotaShiryo(CheckBoxList chkSonotaShiryo) {
        this.getHakkoChohyo().setChkSonotaShiryo(chkSonotaShiryo);
    }

    @JsonIgnore
    public RadioButton getRadSohotaShiryoMasking() {
        return this.getHakkoChohyo().getRadSohotaShiryoMasking();
    }

    @JsonIgnore
    public void setRadSohotaShiryoMasking(RadioButton radSohotaShiryoMasking) {
        this.getHakkoChohyo().setRadSohotaShiryoMasking(radSohotaShiryoMasking);
    }

    @JsonIgnore
    public Space getSpSpace4() {
        return this.getHakkoChohyo().getSpSpace4();
    }

    @JsonIgnore
    public void setSpSpace4(Space spSpace4) {
        this.getHakkoChohyo().setSpSpace4(spSpace4);
    }

    @JsonIgnore
    public CheckBoxList getChkIchijiHanteiKekka() {
        return this.getHakkoChohyo().getChkIchijiHanteiKekka();
    }

    @JsonIgnore
    public void setChkIchijiHanteiKekka(CheckBoxList chkIchijiHanteiKekka) {
        this.getHakkoChohyo().setChkIchijiHanteiKekka(chkIchijiHanteiKekka);
    }

    // </editor-fold>
}
