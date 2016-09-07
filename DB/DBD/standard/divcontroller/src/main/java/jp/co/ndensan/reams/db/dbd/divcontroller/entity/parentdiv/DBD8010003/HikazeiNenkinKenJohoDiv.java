package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD8010003;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * HikazeiNenkinKenJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class HikazeiNenkinKenJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("SeigyoArea")
    private SeigyoAreaDiv SeigyoArea;
    @JsonProperty("shoSaiPanel")
    private shoSaiPanelDiv shoSaiPanel;
    @JsonProperty("ccdKaigoShikaku")
    private KaigoShikakuKihonDiv ccdKaigoShikaku;
    @JsonProperty("ccvComplateMsg")
    private KaigoKanryoMessageDiv ccvComplateMsg;
    @JsonProperty("ccdKaigoAtena")
    private KaigoAtenaInfoDiv ccdKaigoAtena;
    @JsonProperty("hiddenHihokenshaNo")
    private RString hiddenHihokenshaNo;
    @JsonProperty("hiddenNendo")
    private RString hiddenNendo;
    @JsonProperty("hiddenLastInputHousehold")
    private RString hiddenLastInputHousehold;
    @JsonProperty("hiddenModel")
    private RString hiddenModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getSeigyoArea
     * @return SeigyoArea
     */
    @JsonProperty("SeigyoArea")
    public SeigyoAreaDiv getSeigyoArea() {
        return SeigyoArea;
    }

    /*
     * setSeigyoArea
     * @param SeigyoArea SeigyoArea
     */
    @JsonProperty("SeigyoArea")
    public void setSeigyoArea(SeigyoAreaDiv SeigyoArea) {
        this.SeigyoArea = SeigyoArea;
    }

    /*
     * getshoSaiPanel
     * @return shoSaiPanel
     */
    @JsonProperty("shoSaiPanel")
    public shoSaiPanelDiv getShoSaiPanel() {
        return shoSaiPanel;
    }

    /*
     * setshoSaiPanel
     * @param shoSaiPanel shoSaiPanel
     */
    @JsonProperty("shoSaiPanel")
    public void setShoSaiPanel(shoSaiPanelDiv shoSaiPanel) {
        this.shoSaiPanel = shoSaiPanel;
    }

    /*
     * getccdKaigoShikaku
     * @return ccdKaigoShikaku
     */
    @JsonProperty("ccdKaigoShikaku")
    public IKaigoShikakuKihonDiv getCcdKaigoShikaku() {
        return ccdKaigoShikaku;
    }

    /*
     * getccvComplateMsg
     * @return ccvComplateMsg
     */
    @JsonProperty("ccvComplateMsg")
    public IKaigoKanryoMessageDiv getCcvComplateMsg() {
        return ccvComplateMsg;
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
     * gethiddenHihokenshaNo
     * @return hiddenHihokenshaNo
     */
    @JsonProperty("hiddenHihokenshaNo")
    public RString getHiddenHihokenshaNo() {
        return hiddenHihokenshaNo;
    }

    /*
     * sethiddenHihokenshaNo
     * @param hiddenHihokenshaNo hiddenHihokenshaNo
     */
    @JsonProperty("hiddenHihokenshaNo")
    public void setHiddenHihokenshaNo(RString hiddenHihokenshaNo) {
        this.hiddenHihokenshaNo = hiddenHihokenshaNo;
    }

    /*
     * gethiddenNendo
     * @return hiddenNendo
     */
    @JsonProperty("hiddenNendo")
    public RString getHiddenNendo() {
        return hiddenNendo;
    }

    /*
     * sethiddenNendo
     * @param hiddenNendo hiddenNendo
     */
    @JsonProperty("hiddenNendo")
    public void setHiddenNendo(RString hiddenNendo) {
        this.hiddenNendo = hiddenNendo;
    }

    /*
     * gethiddenLastInputHousehold
     * @return hiddenLastInputHousehold
     */
    @JsonProperty("hiddenLastInputHousehold")
    public RString getHiddenLastInputHousehold() {
        return hiddenLastInputHousehold;
    }

    /*
     * sethiddenLastInputHousehold
     * @param hiddenLastInputHousehold hiddenLastInputHousehold
     */
    @JsonProperty("hiddenLastInputHousehold")
    public void setHiddenLastInputHousehold(RString hiddenLastInputHousehold) {
        this.hiddenLastInputHousehold = hiddenLastInputHousehold;
    }

    /*
     * gethiddenModel
     * @return hiddenModel
     */
    @JsonProperty("hiddenModel")
    public RString getHiddenModel() {
        return hiddenModel;
    }

    /*
     * sethiddenModel
     * @param hiddenModel hiddenModel
     */
    @JsonProperty("hiddenModel")
    public void setHiddenModel(RString hiddenModel) {
        this.hiddenModel = hiddenModel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public DropDownList getDdlYear() {
        return this.getSeigyoArea().getDdlYear();
    }

    @JsonIgnore
    public void  setDdlYear(DropDownList ddlYear) {
        this.getSeigyoArea().setDdlYear(ddlYear);
    }

    @JsonIgnore
    public ButtonDialog getBtnSearch() {
        return this.getSeigyoArea().getBtnSearch();
    }

    @JsonIgnore
    public void  setBtnSearch(ButtonDialog btnSearch) {
        this.getSeigyoArea().setBtnSearch(btnSearch);
    }

    @JsonIgnore
    public Button getBtnCreate() {
        return this.getSeigyoArea().getBtnCreate();
    }

    @JsonIgnore
    public void  setBtnCreate(Button btnCreate) {
        this.getSeigyoArea().setBtnCreate(btnCreate);
    }

    @JsonIgnore
    public TextBox getTbYear() {
        return this.getShoSaiPanel().getTbYear();
    }

    @JsonIgnore
    public void  setTbYear(TextBox tbYear) {
        this.getShoSaiPanel().setTbYear(tbYear);
    }

    @JsonIgnore
    public TextBoxCode getTbNenkinHokenshaCode() {
        return this.getShoSaiPanel().getTbNenkinHokenshaCode();
    }

    @JsonIgnore
    public void  setTbNenkinHokenshaCode(TextBoxCode tbNenkinHokenshaCode) {
        this.getShoSaiPanel().setTbNenkinHokenshaCode(tbNenkinHokenshaCode);
    }

    @JsonIgnore
    public TextBoxCode getTbKisoNenkinNo() {
        return this.getShoSaiPanel().getTbKisoNenkinNo();
    }

    @JsonIgnore
    public void  setTbKisoNenkinNo(TextBoxCode tbKisoNenkinNo) {
        this.getShoSaiPanel().setTbKisoNenkinNo(tbKisoNenkinNo);
    }

    @JsonIgnore
    public TextBoxCode getTbNenkinCode() {
        return this.getShoSaiPanel().getTbNenkinCode();
    }

    @JsonIgnore
    public void  setTbNenkinCode(TextBoxCode tbNenkinCode) {
        this.getShoSaiPanel().setTbNenkinCode(tbNenkinCode);
    }

    @JsonIgnore
    public Button getBtnDisplay() {
        return this.getShoSaiPanel().getBtnDisplay();
    }

    @JsonIgnore
    public void  setBtnDisplay(Button btnDisplay) {
        this.getShoSaiPanel().setBtnDisplay(btnDisplay);
    }

    @JsonIgnore
    public Button getBtnDelete() {
        return this.getShoSaiPanel().getBtnDelete();
    }

    @JsonIgnore
    public void  setBtnDelete(Button BtnDelete) {
        this.getShoSaiPanel().setBtnDelete(BtnDelete);
    }

    @JsonIgnore
    public NaiyoAreaDiv getNaiyoArea() {
        return this.getShoSaiPanel().getNaiyoArea();
    }

    @JsonIgnore
    public void  setNaiyoArea(NaiyoAreaDiv NaiyoArea) {
        this.getShoSaiPanel().setNaiyoArea(NaiyoArea);
    }

    @JsonIgnore
    public TextBoxMultiLine getTbNenKinHokenshaName() {
        return this.getShoSaiPanel().getNaiyoArea().getTbNenKinHokenshaName();
    }

    @JsonIgnore
    public void  setTbNenKinHokenshaName(TextBoxMultiLine tbNenKinHokenshaName) {
        this.getShoSaiPanel().getNaiyoArea().setTbNenKinHokenshaName(tbNenKinHokenshaName);
    }

    @JsonIgnore
    public TextBoxCode getTbGenkisoNenkinNo() {
        return this.getShoSaiPanel().getNaiyoArea().getTbGenkisoNenkinNo();
    }

    @JsonIgnore
    public void  setTbGenkisoNenkinNo(TextBoxCode tbGenkisoNenkinNo) {
        this.getShoSaiPanel().getNaiyoArea().setTbGenkisoNenkinNo(tbGenkisoNenkinNo);
    }

    @JsonIgnore
    public TextBoxMultiLine getTbTaishoNenKin() {
        return this.getShoSaiPanel().getNaiyoArea().getTbTaishoNenKin();
    }

    @JsonIgnore
    public void  setTbTaishoNenKin(TextBoxMultiLine tbTaishoNenKin) {
        this.getShoSaiPanel().getNaiyoArea().setTbTaishoNenKin(tbTaishoNenKin);
    }

    @JsonIgnore
    public DropDownList getDdlTsuki() {
        return this.getShoSaiPanel().getNaiyoArea().getDdlTsuki();
    }

    @JsonIgnore
    public void  setDdlTsuki(DropDownList ddlTsuki) {
        this.getShoSaiPanel().getNaiyoArea().setDdlTsuki(ddlTsuki);
    }

    @JsonIgnore
    public TextBoxNum getTbKingaku() {
        return this.getShoSaiPanel().getNaiyoArea().getTbKingaku();
    }

    @JsonIgnore
    public void  setTbKingaku(TextBoxNum tbKingaku) {
        this.getShoSaiPanel().getNaiyoArea().setTbKingaku(tbKingaku);
    }

    @JsonIgnore
    public TextBoxDate getTbCreateDate() {
        return this.getShoSaiPanel().getNaiyoArea().getTbCreateDate();
    }

    @JsonIgnore
    public void  setTbCreateDate(TextBoxDate tbCreateDate) {
        this.getShoSaiPanel().getNaiyoArea().setTbCreateDate(tbCreateDate);
    }

    @JsonIgnore
    public TextBox getTbTaishoNen() {
        return this.getShoSaiPanel().getNaiyoArea().getTbTaishoNen();
    }

    @JsonIgnore
    public void  setTbTaishoNen(TextBox tbTaishoNen) {
        this.getShoSaiPanel().getNaiyoArea().setTbTaishoNen(tbTaishoNen);
    }

    @JsonIgnore
    public TextBox getTbLoadCata() {
        return this.getShoSaiPanel().getNaiyoArea().getTbLoadCata();
    }

    @JsonIgnore
    public void  setTbLoadCata(TextBox tbLoadCata) {
        this.getShoSaiPanel().getNaiyoArea().setTbLoadCata(tbLoadCata);
    }

    @JsonIgnore
    public NenkinJohoTukiaiKeyAreaDiv getNenkinJohoTukiaiKeyArea() {
        return this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea();
    }

    @JsonIgnore
    public void  setNenkinJohoTukiaiKeyArea(NenkinJohoTukiaiKeyAreaDiv NenkinJohoTukiaiKeyArea) {
        this.getShoSaiPanel().setNenkinJohoTukiaiKeyArea(NenkinJohoTukiaiKeyArea);
    }

    @JsonIgnore
    public TextBox getTbNameKana() {
        return this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().getTbNameKana();
    }

    @JsonIgnore
    public void  setTbNameKana(TextBox tbNameKana) {
        this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().setTbNameKana(tbNameKana);
    }

    @JsonIgnore
    public DropDownList getDdlSex() {
        return this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().getDdlSex();
    }

    @JsonIgnore
    public void  setDdlSex(DropDownList ddlSex) {
        this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().setDdlSex(ddlSex);
    }

    @JsonIgnore
    public TextBoxDate getTbBirthday() {
        return this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().getTbBirthday();
    }

    @JsonIgnore
    public void  setTbBirthday(TextBoxDate tbBirthday) {
        this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().setTbBirthday(tbBirthday);
    }

    @JsonIgnore
    public TextBox getTbNameKanji() {
        return this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().getTbNameKanji();
    }

    @JsonIgnore
    public void  setTbNameKanji(TextBox tbNameKanji) {
        this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().setTbNameKanji(tbNameKanji);
    }

    @JsonIgnore
    public TextBox getTbAddressKana() {
        return this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().getTbAddressKana();
    }

    @JsonIgnore
    public void  setTbAddressKana(TextBox tbAddressKana) {
        this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().setTbAddressKana(tbAddressKana);
    }

    @JsonIgnore
    public TextBox getTbAddressKanji() {
        return this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().getTbAddressKanji();
    }

    @JsonIgnore
    public void  setTbAddressKanji(TextBox tbAddressKanji) {
        this.getShoSaiPanel().getNenkinJohoTukiaiKeyArea().setTbAddressKanji(tbAddressKanji);
    }

    // </editor-fold>
}
