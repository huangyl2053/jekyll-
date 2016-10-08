package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.GemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.IGemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShogaishaKojoTaishoshaShinseiToroku のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoTaishoshaShinseiTorokuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtSetaiKazaiJokyo")
    private TextBox txtSetaiKazaiJokyo;
    @JsonProperty("btnShowSetaiJoho")
    private Button btnShowSetaiJoho;
    @JsonProperty("btnCloseSetaiJoho")
    private Button btnCloseSetaiJoho;
    @JsonProperty("btnDispGemmenJoho")
    private ButtonDialog btnDispGemmenJoho;
    @JsonProperty("SetaiJoho")
    private SetaiJohoDiv SetaiJoho;
    @JsonProperty("ShinseiList")
    private ShinseiListDiv ShinseiList;
    @JsonProperty("ShinseiDetail")
    private ShinseiDetailDiv ShinseiDetail;
    @JsonProperty("ccdKaigoKihon")
    private KaigoShikakuKihonDiv ccdKaigoKihon;
    @JsonProperty("ccdAtenaInfo")
    private KaigoAtenaInfoDiv ccdAtenaInfo;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("subGyomuCode")
    private RString subGyomuCode;
    @JsonProperty("sampleBunshoGroupCode")
    private RString sampleBunshoGroupCode;
    @JsonProperty("teikeibun")
    private RString teikeibun;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
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
     * gettxtSetaiKazaiJokyo
     * @return txtSetaiKazaiJokyo
     */
    @JsonProperty("txtSetaiKazaiJokyo")
    public TextBox getTxtSetaiKazaiJokyo() {
        return txtSetaiKazaiJokyo;
    }

    /*
     * settxtSetaiKazaiJokyo
     * @param txtSetaiKazaiJokyo txtSetaiKazaiJokyo
     */
    @JsonProperty("txtSetaiKazaiJokyo")
    public void setTxtSetaiKazaiJokyo(TextBox txtSetaiKazaiJokyo) {
        this.txtSetaiKazaiJokyo = txtSetaiKazaiJokyo;
    }

    /*
     * getbtnShowSetaiJoho
     * @return btnShowSetaiJoho
     */
    @JsonProperty("btnShowSetaiJoho")
    public Button getBtnShowSetaiJoho() {
        return btnShowSetaiJoho;
    }

    /*
     * setbtnShowSetaiJoho
     * @param btnShowSetaiJoho btnShowSetaiJoho
     */
    @JsonProperty("btnShowSetaiJoho")
    public void setBtnShowSetaiJoho(Button btnShowSetaiJoho) {
        this.btnShowSetaiJoho = btnShowSetaiJoho;
    }

    /*
     * getbtnCloseSetaiJoho
     * @return btnCloseSetaiJoho
     */
    @JsonProperty("btnCloseSetaiJoho")
    public Button getBtnCloseSetaiJoho() {
        return btnCloseSetaiJoho;
    }

    /*
     * setbtnCloseSetaiJoho
     * @param btnCloseSetaiJoho btnCloseSetaiJoho
     */
    @JsonProperty("btnCloseSetaiJoho")
    public void setBtnCloseSetaiJoho(Button btnCloseSetaiJoho) {
        this.btnCloseSetaiJoho = btnCloseSetaiJoho;
    }

    /*
     * getbtnDispGemmenJoho
     * @return btnDispGemmenJoho
     */
    @JsonProperty("btnDispGemmenJoho")
    public ButtonDialog getBtnDispGemmenJoho() {
        return btnDispGemmenJoho;
    }

    /*
     * setbtnDispGemmenJoho
     * @param btnDispGemmenJoho btnDispGemmenJoho
     */
    @JsonProperty("btnDispGemmenJoho")
    public void setBtnDispGemmenJoho(ButtonDialog btnDispGemmenJoho) {
        this.btnDispGemmenJoho = btnDispGemmenJoho;
    }

    /*
     * getSetaiJoho
     * @return SetaiJoho
     */
    @JsonProperty("SetaiJoho")
    public SetaiJohoDiv getSetaiJoho() {
        return SetaiJoho;
    }

    /*
     * setSetaiJoho
     * @param SetaiJoho SetaiJoho
     */
    @JsonProperty("SetaiJoho")
    public void setSetaiJoho(SetaiJohoDiv SetaiJoho) {
        this.SetaiJoho = SetaiJoho;
    }

    /*
     * getShinseiList
     * @return ShinseiList
     */
    @JsonProperty("ShinseiList")
    public ShinseiListDiv getShinseiList() {
        return ShinseiList;
    }

    /*
     * setShinseiList
     * @param ShinseiList ShinseiList
     */
    @JsonProperty("ShinseiList")
    public void setShinseiList(ShinseiListDiv ShinseiList) {
        this.ShinseiList = ShinseiList;
    }

    /*
     * getShinseiDetail
     * @return ShinseiDetail
     */
    @JsonProperty("ShinseiDetail")
    public ShinseiDetailDiv getShinseiDetail() {
        return ShinseiDetail;
    }

    /*
     * setShinseiDetail
     * @param ShinseiDetail ShinseiDetail
     */
    @JsonProperty("ShinseiDetail")
    public void setShinseiDetail(ShinseiDetailDiv ShinseiDetail) {
        this.ShinseiDetail = ShinseiDetail;
    }

    /*
     * getccdKaigoKihon
     * @return ccdKaigoKihon
     */
    @JsonProperty("ccdKaigoKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoKihon() {
        return ccdKaigoKihon;
    }

    /*
     * getccdAtenaInfo
     * @return ccdAtenaInfo
     */
    @JsonProperty("ccdAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return ccdAtenaInfo;
    }

    /*
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * getsubGyomuCode
     * @return subGyomuCode
     */
    @JsonProperty("subGyomuCode")
    public RString getSubGyomuCode() {
        return subGyomuCode;
    }

    /*
     * setsubGyomuCode
     * @param subGyomuCode subGyomuCode
     */
    @JsonProperty("subGyomuCode")
    public void setSubGyomuCode(RString subGyomuCode) {
        this.subGyomuCode = subGyomuCode;
    }

    /*
     * getsampleBunshoGroupCode
     * @return sampleBunshoGroupCode
     */
    @JsonProperty("sampleBunshoGroupCode")
    public RString getSampleBunshoGroupCode() {
        return sampleBunshoGroupCode;
    }

    /*
     * setsampleBunshoGroupCode
     * @param sampleBunshoGroupCode sampleBunshoGroupCode
     */
    @JsonProperty("sampleBunshoGroupCode")
    public void setSampleBunshoGroupCode(RString sampleBunshoGroupCode) {
        this.sampleBunshoGroupCode = sampleBunshoGroupCode;
    }

    /*
     * getteikeibun
     * @return teikeibun
     */
    @JsonProperty("teikeibun")
    public RString getTeikeibun() {
        return teikeibun;
    }

    /*
     * setteikeibun
     * @param teikeibun teikeibun
     */
    @JsonProperty("teikeibun")
    public void setTeikeibun(RString teikeibun) {
        this.teikeibun = teikeibun;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSetaiShotokuIchiran() {
        return this.getSetaiJoho().getCcdSetaiShotokuIchiran();
    }

    @JsonIgnore
    public Button getBtnAddShinsei() {
        return this.getShinseiList().getBtnAddShinsei();
    }

    @JsonIgnore
    public void  setBtnAddShinsei(Button btnAddShinsei) {
        this.getShinseiList().setBtnAddShinsei(btnAddShinsei);
    }

    @JsonIgnore
    public DataGrid<dgShinseiList_Row> getDgShinseiList() {
        return this.getShinseiList().getDgShinseiList();
    }

    @JsonIgnore
    public void  setDgShinseiList(DataGrid<dgShinseiList_Row> dgShinseiList) {
        this.getShinseiList().setDgShinseiList(dgShinseiList);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return this.getShinseiDetail().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.getShinseiDetail().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getShinseiDetail().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getShinseiDetail().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.getShinseiDetail().getKetteiJoho();
    }

    @JsonIgnore
    public void  setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.getShinseiDetail().setKetteiJoho(KetteiJoho);
    }

    @JsonIgnore
    public RadioButton getRadKettaiKubun() {
        return this.getShinseiDetail().getKetteiJoho().getRadKettaiKubun();
    }

    @JsonIgnore
    public void  setRadKettaiKubun(RadioButton radKettaiKubun) {
        this.getShinseiDetail().getKetteiJoho().setRadKettaiKubun(radKettaiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYMD() {
        return this.getShinseiDetail().getKetteiJoho().getTxtKettaiYMD();
    }

    @JsonIgnore
    public void  setTxtKettaiYMD(TextBoxFlexibleDate txtKettaiYMD) {
        this.getShinseiDetail().getKetteiJoho().setTxtKettaiYMD(txtKettaiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleYear getTxtTaishoNendo() {
        return this.getShinseiDetail().getKetteiJoho().getTxtTaishoNendo();
    }

    @JsonIgnore
    public void  setTxtTaishoNendo(TextBoxFlexibleYear txtTaishoNendo) {
        this.getShinseiDetail().getKetteiJoho().setTxtTaishoNendo(txtTaishoNendo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return this.getShinseiDetail().getKetteiJoho().getTxtKijunYMD();
    }

    @JsonIgnore
    public void  setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.getShinseiDetail().getKetteiJoho().setTxtKijunYMD(txtKijunYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHaakuYMD() {
        return this.getShinseiDetail().getKetteiJoho().getTxtHaakuYMD();
    }

    @JsonIgnore
    public void  setTxtHaakuYMD(TextBoxFlexibleDate txtHaakuYMD) {
        this.getShinseiDetail().getKetteiJoho().setTxtHaakuYMD(txtHaakuYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHasShogaishaTecho() {
        return this.getShinseiDetail().getKetteiJoho().getChkHasShogaishaTecho();
    }

    @JsonIgnore
    public void  setChkHasShogaishaTecho(CheckBoxList chkHasShogaishaTecho) {
        this.getShinseiDetail().getKetteiJoho().setChkHasShogaishaTecho(chkHasShogaishaTecho);
    }

    @JsonIgnore
    public CheckBoxList getChkIsNinteishoHakkoTaishoGai() {
        return this.getShinseiDetail().getKetteiJoho().getChkIsNinteishoHakkoTaishoGai();
    }

    @JsonIgnore
    public void  setChkIsNinteishoHakkoTaishoGai(CheckBoxList chkIsNinteishoHakkoTaishoGai) {
        this.getShinseiDetail().getKetteiJoho().setChkIsNinteishoHakkoTaishoGai(chkIsNinteishoHakkoTaishoGai);
    }

    @JsonIgnore
    public DropDownList getDdlNinchishoKoreishaJiritsudo() {
        return this.getShinseiDetail().getKetteiJoho().getDdlNinchishoKoreishaJiritsudo();
    }

    @JsonIgnore
    public void  setDdlNinchishoKoreishaJiritsudo(DropDownList ddlNinchishoKoreishaJiritsudo) {
        this.getShinseiDetail().getKetteiJoho().setDdlNinchishoKoreishaJiritsudo(ddlNinchishoKoreishaJiritsudo);
    }

    @JsonIgnore
    public DropDownList getDdlShogaiKoreishaJiritsudo() {
        return this.getShinseiDetail().getKetteiJoho().getDdlShogaiKoreishaJiritsudo();
    }

    @JsonIgnore
    public void  setDdlShogaiKoreishaJiritsudo(DropDownList ddlShogaiKoreishaJiritsudo) {
        this.getShinseiDetail().getKetteiJoho().setDdlShogaiKoreishaJiritsudo(ddlShogaiKoreishaJiritsudo);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiKubun() {
        return this.getShinseiDetail().getKetteiJoho().getDdlNinteiKubun();
    }

    @JsonIgnore
    public void  setDdlNinteiKubun(DropDownList ddlNinteiKubun) {
        this.getShinseiDetail().getKetteiJoho().setDdlNinteiKubun(ddlNinteiKubun);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiNaiyo() {
        return this.getShinseiDetail().getKetteiJoho().getDdlNinteiNaiyo();
    }

    @JsonIgnore
    public void  setDdlNinteiNaiyo(DropDownList ddlNinteiNaiyo) {
        this.getShinseiDetail().getKetteiJoho().setDdlNinteiNaiyo(ddlNinteiNaiyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiShoninRiyu() {
        return this.getShinseiDetail().getKetteiJoho().getBtnHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.getShinseiDetail().getKetteiJoho().setBtnHiShoninRiyu(btnHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getShinseiDetail().getKetteiJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getShinseiDetail().getKetteiJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    @JsonIgnore
    public Button getTxtDetermineShinsei() {
        return this.getShinseiDetail().getTxtDetermineShinsei();
    }

    @JsonIgnore
    public void  setTxtDetermineShinsei(Button txtDetermineShinsei) {
        this.getShinseiDetail().setTxtDetermineShinsei(txtDetermineShinsei);
    }

    @JsonIgnore
    public Button getBtnBackToShinseiList() {
        return this.getShinseiDetail().getBtnBackToShinseiList();
    }

    @JsonIgnore
    public void  setBtnBackToShinseiList(Button btnBackToShinseiList) {
        this.getShinseiDetail().setBtnBackToShinseiList(btnBackToShinseiList);
    }

    @JsonIgnore
    public IGemmenGengakuShinseiDiv getCcdGemmenGengakuShinsei() {
        return this.getShinseiDetail().getCcdGemmenGengakuShinsei();
    }

    // </editor-fold>
}
