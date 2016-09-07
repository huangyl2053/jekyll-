package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001;
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

/**
 * HomonKaigoRiyoshaFutanGengaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonKaigoRiyoshaFutanGengakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtSetaiKazeiJokyo")
    private TextBox txtSetaiKazeiJokyo;
    @JsonProperty("btnShowSetaiJoho")
    private Button btnShowSetaiJoho;
    @JsonProperty("btnCloseSetaiJoho")
    private Button btnCloseSetaiJoho;
    @JsonProperty("btnOpenGemmenJoho")
    private ButtonDialog btnOpenGemmenJoho;
    @JsonProperty("HomonKaigoGengakuShinseiList")
    private HomonKaigoGengakuShinseiListDiv HomonKaigoGengakuShinseiList;
    @JsonProperty("HomonKaigoGengakuShinseiDetail")
    private HomonKaigoGengakuShinseiDetailDiv HomonKaigoGengakuShinseiDetail;
    @JsonProperty("SetaiJoho")
    private SetaiJohoDiv SetaiJoho;
    @JsonProperty("ccdShikakuKihon")
    private KaigoShikakuKihonDiv ccdShikakuKihon;
    @JsonProperty("ccdAtenaInfo")
    private KaigoAtenaInfoDiv ccdAtenaInfo;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;

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
     * gettxtSetaiKazeiJokyo
     * @return txtSetaiKazeiJokyo
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    public TextBox getTxtSetaiKazeiJokyo() {
        return txtSetaiKazeiJokyo;
    }

    /*
     * settxtSetaiKazeiJokyo
     * @param txtSetaiKazeiJokyo txtSetaiKazeiJokyo
     */
    @JsonProperty("txtSetaiKazeiJokyo")
    public void setTxtSetaiKazeiJokyo(TextBox txtSetaiKazeiJokyo) {
        this.txtSetaiKazeiJokyo = txtSetaiKazeiJokyo;
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
     * getbtnOpenGemmenJoho
     * @return btnOpenGemmenJoho
     */
    @JsonProperty("btnOpenGemmenJoho")
    public ButtonDialog getBtnOpenGemmenJoho() {
        return btnOpenGemmenJoho;
    }

    /*
     * setbtnOpenGemmenJoho
     * @param btnOpenGemmenJoho btnOpenGemmenJoho
     */
    @JsonProperty("btnOpenGemmenJoho")
    public void setBtnOpenGemmenJoho(ButtonDialog btnOpenGemmenJoho) {
        this.btnOpenGemmenJoho = btnOpenGemmenJoho;
    }

    /*
     * getHomonKaigoGengakuShinseiList
     * @return HomonKaigoGengakuShinseiList
     */
    @JsonProperty("HomonKaigoGengakuShinseiList")
    public HomonKaigoGengakuShinseiListDiv getHomonKaigoGengakuShinseiList() {
        return HomonKaigoGengakuShinseiList;
    }

    /*
     * setHomonKaigoGengakuShinseiList
     * @param HomonKaigoGengakuShinseiList HomonKaigoGengakuShinseiList
     */
    @JsonProperty("HomonKaigoGengakuShinseiList")
    public void setHomonKaigoGengakuShinseiList(HomonKaigoGengakuShinseiListDiv HomonKaigoGengakuShinseiList) {
        this.HomonKaigoGengakuShinseiList = HomonKaigoGengakuShinseiList;
    }

    /*
     * getHomonKaigoGengakuShinseiDetail
     * @return HomonKaigoGengakuShinseiDetail
     */
    @JsonProperty("HomonKaigoGengakuShinseiDetail")
    public HomonKaigoGengakuShinseiDetailDiv getHomonKaigoGengakuShinseiDetail() {
        return HomonKaigoGengakuShinseiDetail;
    }

    /*
     * setHomonKaigoGengakuShinseiDetail
     * @param HomonKaigoGengakuShinseiDetail HomonKaigoGengakuShinseiDetail
     */
    @JsonProperty("HomonKaigoGengakuShinseiDetail")
    public void setHomonKaigoGengakuShinseiDetail(HomonKaigoGengakuShinseiDetailDiv HomonKaigoGengakuShinseiDetail) {
        this.HomonKaigoGengakuShinseiDetail = HomonKaigoGengakuShinseiDetail;
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
     * getccdShikakuKihon
     * @return ccdShikakuKihon
     */
    @JsonProperty("ccdShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdShikakuKihon() {
        return ccdShikakuKihon;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnAddShinsei() {
        return this.getHomonKaigoGengakuShinseiList().getBtnAddShinsei();
    }

    @JsonIgnore
    public void  setBtnAddShinsei(Button btnAddShinsei) {
        this.getHomonKaigoGengakuShinseiList().setBtnAddShinsei(btnAddShinsei);
    }

    @JsonIgnore
    public DataGrid<dgShinseiList_Row> getDgShinseiList() {
        return this.getHomonKaigoGengakuShinseiList().getDgShinseiList();
    }

    @JsonIgnore
    public void  setDgShinseiList(DataGrid<dgShinseiList_Row> dgShinseiList) {
        this.getHomonKaigoGengakuShinseiList().setDgShinseiList(dgShinseiList);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return this.getHomonKaigoGengakuShinseiDetail().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.getHomonKaigoGengakuShinseiDetail().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getHomonKaigoGengakuShinseiDetail().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getHomonKaigoGengakuShinseiDetail().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public ShogaishaTechoDiv getShogaishaTecho() {
        return this.getHomonKaigoGengakuShinseiDetail().getShogaishaTecho();
    }

    @JsonIgnore
    public void  setShogaishaTecho(ShogaishaTechoDiv ShogaishaTecho) {
        this.getHomonKaigoGengakuShinseiDetail().setShogaishaTecho(ShogaishaTecho);
    }

    @JsonIgnore
    public RadioButton getRadShogaishaTechoUmu() {
        return this.getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().getRadShogaishaTechoUmu();
    }

    @JsonIgnore
    public void  setRadShogaishaTechoUmu(RadioButton radShogaishaTechoUmu) {
        this.getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().setRadShogaishaTechoUmu(radShogaishaTechoUmu);
    }

    @JsonIgnore
    public TextBox getTxtShogaishaTechoTokyu() {
        return this.getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().getTxtShogaishaTechoTokyu();
    }

    @JsonIgnore
    public void  setTxtShogaishaTechoTokyu(TextBox txtShogaishaTechoTokyu) {
        this.getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().setTxtShogaishaTechoTokyu(txtShogaishaTechoTokyu);
    }

    @JsonIgnore
    public TextBox getTxtShogaishaTechoNo() {
        return this.getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().getTxtShogaishaTechoNo();
    }

    @JsonIgnore
    public void  setTxtShogaishaTechoNo(TextBox txtShogaishaTechoNo) {
        this.getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().setTxtShogaishaTechoNo(txtShogaishaTechoNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShogaishaTechoKofuYMD() {
        return this.getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().getTxtShogaishaTechoKofuYMD();
    }

    @JsonIgnore
    public void  setTxtShogaishaTechoKofuYMD(TextBoxFlexibleDate txtShogaishaTechoKofuYMD) {
        this.getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().setTxtShogaishaTechoKofuYMD(txtShogaishaTechoKofuYMD);
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho();
    }

    @JsonIgnore
    public void  setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.getHomonKaigoGengakuShinseiDetail().setKetteiJoho(KetteiJoho);
    }

    @JsonIgnore
    public RadioButton getDdlKettaiKubun() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getDdlKettaiKubun();
    }

    @JsonIgnore
    public void  setDdlKettaiKubun(RadioButton ddlKettaiKubun) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setDdlKettaiKubun(ddlKettaiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYmd() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtKettaiYmd();
    }

    @JsonIgnore
    public void  setTxtKettaiYmd(TextBoxFlexibleDate txtKettaiYmd) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtKettaiYmd(txtKettaiYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYmd() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtTekiyoYmd();
    }

    @JsonIgnore
    public void  setTxtTekiyoYmd(TextBoxFlexibleDate txtTekiyoYmd) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtTekiyoYmd(txtTekiyoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigen() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtYukoKigen();
    }

    @JsonIgnore
    public void  setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtYukoKigen(txtYukoKigen);
    }

    @JsonIgnore
    public DropDownList getDdlHobetsuKubun() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getDdlHobetsuKubun();
    }

    @JsonIgnore
    public void  setDdlHobetsuKubun(DropDownList ddlHobetsuKubun) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setDdlHobetsuKubun(ddlHobetsuKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuRitsu() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtKyufuRitsu(txtKyufuRitsu);
    }

    @JsonIgnore
    public TextBox getTxtKohiFutanshaNo() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtKohiFutanshaNo();
    }

    @JsonIgnore
    public void  setTxtKohiFutanshaNo(TextBox txtKohiFutanshaNo) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtKohiFutanshaNo(txtKohiFutanshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtKohiJyukyshaNo() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtKohiJyukyshaNo();
    }

    @JsonIgnore
    public void  setTxtKohiJyukyshaNo(TextBoxCode txtKohiJyukyshaNo) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtKohiJyukyshaNo(txtKohiJyukyshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtKohiJyukyushaNoCheckDigit() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtKohiJyukyushaNoCheckDigit();
    }

    @JsonIgnore
    public void  setTxtKohiJyukyushaNoCheckDigit(TextBoxCode txtKohiJyukyushaNoCheckDigit) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtKohiJyukyushaNoCheckDigit(txtKohiJyukyushaNoCheckDigit);
    }

    @JsonIgnore
    public ButtonDialog getBtnOpenHiShoninRiyu() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getBtnOpenHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnOpenHiShoninRiyu(ButtonDialog btnOpenHiShoninRiyu) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setBtnOpenHiShoninRiyu(btnOpenHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    @JsonIgnore
    public Button getBtnAddShinseiJoho() {
        return this.getHomonKaigoGengakuShinseiDetail().getBtnAddShinseiJoho();
    }

    @JsonIgnore
    public void  setBtnAddShinseiJoho(Button btnAddShinseiJoho) {
        this.getHomonKaigoGengakuShinseiDetail().setBtnAddShinseiJoho(btnAddShinseiJoho);
    }

    @JsonIgnore
    public Button getBtnReturnShinseiIchiran() {
        return this.getHomonKaigoGengakuShinseiDetail().getBtnReturnShinseiIchiran();
    }

    @JsonIgnore
    public void  setBtnReturnShinseiIchiran(Button btnReturnShinseiIchiran) {
        this.getHomonKaigoGengakuShinseiDetail().setBtnReturnShinseiIchiran(btnReturnShinseiIchiran);
    }

    @JsonIgnore
    public IGemmenGengakuShinseiDiv getCcdShinseiJoho() {
        return this.getHomonKaigoGengakuShinseiDetail().getCcdShinseiJoho();
    }

    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSetaiShotokuIchiran() {
        return this.getSetaiJoho().getCcdSetaiShotokuIchiran();
    }

    // </editor-fold>
}
