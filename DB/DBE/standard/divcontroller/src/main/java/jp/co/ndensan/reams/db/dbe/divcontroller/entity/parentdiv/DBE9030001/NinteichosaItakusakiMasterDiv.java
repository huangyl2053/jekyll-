package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9030001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteichosaItakusakiMaster のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaItakusakiMasterDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosainSearch")
    private ChosainSearchDiv ChosainSearch;
    @JsonProperty("Chosaitakusakichiran")
    private ChosaitakusakichiranDiv Chosaitakusakichiran;
    @JsonProperty("ChosaitakusakiJohoInput")
    private ChosaitakusakiJohoInputDiv ChosaitakusakiJohoInput;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("状態")
    private RString 状態;
    @JsonProperty("hdnTxtCode")
    private RString hdnTxtCode;
    @JsonProperty("hdnTxtCodeMeisho")
    private RString hdnTxtCodeMeisho;
    @JsonProperty("hdnInputDiv")
    private RString hdnInputDiv;
    @JsonProperty("hdnSelectID")
    private RString hdnSelectID;
    @JsonProperty("hdnShichosonCodeList")
    private RString hdnShichosonCodeList;
    @JsonProperty("hdnSubGyomuCode")
    private RString hdnSubGyomuCode;
    @JsonProperty("hdnCodeShubetsu")
    private RString hdnCodeShubetsu;
    @JsonProperty("hdnJigyoshaMode")
    private RString hdnJigyoshaMode;
    @JsonProperty("hdnSchemaName")
    private RString hdnSchemaName;
    @JsonProperty("hdnShikibetsuCode")
    private RString hdnShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getChosainSearch
     * @return ChosainSearch
     */
    @JsonProperty("ChosainSearch")
    public ChosainSearchDiv getChosainSearch() {
        return ChosainSearch;
    }

    /*
     * setChosainSearch
     * @param ChosainSearch ChosainSearch
     */
    @JsonProperty("ChosainSearch")
    public void setChosainSearch(ChosainSearchDiv ChosainSearch) {
        this.ChosainSearch = ChosainSearch;
    }

    /*
     * getChosaitakusakichiran
     * @return Chosaitakusakichiran
     */
    @JsonProperty("Chosaitakusakichiran")
    public ChosaitakusakichiranDiv getChosaitakusakichiran() {
        return Chosaitakusakichiran;
    }

    /*
     * setChosaitakusakichiran
     * @param Chosaitakusakichiran Chosaitakusakichiran
     */
    @JsonProperty("Chosaitakusakichiran")
    public void setChosaitakusakichiran(ChosaitakusakichiranDiv Chosaitakusakichiran) {
        this.Chosaitakusakichiran = Chosaitakusakichiran;
    }

    /*
     * getChosaitakusakiJohoInput
     * @return ChosaitakusakiJohoInput
     */
    @JsonProperty("ChosaitakusakiJohoInput")
    public ChosaitakusakiJohoInputDiv getChosaitakusakiJohoInput() {
        return ChosaitakusakiJohoInput;
    }

    /*
     * setChosaitakusakiJohoInput
     * @param ChosaitakusakiJohoInput ChosaitakusakiJohoInput
     */
    @JsonProperty("ChosaitakusakiJohoInput")
    public void setChosaitakusakiJohoInput(ChosaitakusakiJohoInputDiv ChosaitakusakiJohoInput) {
        this.ChosaitakusakiJohoInput = ChosaitakusakiJohoInput;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * get状態
     * @return 状態
     */
    @JsonProperty("状態")
    public RString get状態() {
        return 状態;
    }

    /*
     * set状態
     * @param 状態 状態
     */
    @JsonProperty("状態")
    public void set状態(RString 状態) {
        this.状態 = 状態;
    }

    /*
     * gethdnTxtCode
     * @return hdnTxtCode
     */
    @JsonProperty("hdnTxtCode")
    public RString getHdnTxtCode() {
        return hdnTxtCode;
    }

    /*
     * sethdnTxtCode
     * @param hdnTxtCode hdnTxtCode
     */
    @JsonProperty("hdnTxtCode")
    public void setHdnTxtCode(RString hdnTxtCode) {
        this.hdnTxtCode = hdnTxtCode;
    }

    /*
     * gethdnTxtCodeMeisho
     * @return hdnTxtCodeMeisho
     */
    @JsonProperty("hdnTxtCodeMeisho")
    public RString getHdnTxtCodeMeisho() {
        return hdnTxtCodeMeisho;
    }

    /*
     * sethdnTxtCodeMeisho
     * @param hdnTxtCodeMeisho hdnTxtCodeMeisho
     */
    @JsonProperty("hdnTxtCodeMeisho")
    public void setHdnTxtCodeMeisho(RString hdnTxtCodeMeisho) {
        this.hdnTxtCodeMeisho = hdnTxtCodeMeisho;
    }

    /*
     * gethdnInputDiv
     * @return hdnInputDiv
     */
    @JsonProperty("hdnInputDiv")
    public RString getHdnInputDiv() {
        return hdnInputDiv;
    }

    /*
     * sethdnInputDiv
     * @param hdnInputDiv hdnInputDiv
     */
    @JsonProperty("hdnInputDiv")
    public void setHdnInputDiv(RString hdnInputDiv) {
        this.hdnInputDiv = hdnInputDiv;
    }

    /*
     * gethdnSelectID
     * @return hdnSelectID
     */
    @JsonProperty("hdnSelectID")
    public RString getHdnSelectID() {
        return hdnSelectID;
    }

    /*
     * sethdnSelectID
     * @param hdnSelectID hdnSelectID
     */
    @JsonProperty("hdnSelectID")
    public void setHdnSelectID(RString hdnSelectID) {
        this.hdnSelectID = hdnSelectID;
    }

    /*
     * gethdnShichosonCodeList
     * @return hdnShichosonCodeList
     */
    @JsonProperty("hdnShichosonCodeList")
    public RString getHdnShichosonCodeList() {
        return hdnShichosonCodeList;
    }

    /*
     * sethdnShichosonCodeList
     * @param hdnShichosonCodeList hdnShichosonCodeList
     */
    @JsonProperty("hdnShichosonCodeList")
    public void setHdnShichosonCodeList(RString hdnShichosonCodeList) {
        this.hdnShichosonCodeList = hdnShichosonCodeList;
    }

    /*
     * gethdnSubGyomuCode
     * @return hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public RString getHdnSubGyomuCode() {
        return hdnSubGyomuCode;
    }

    /*
     * sethdnSubGyomuCode
     * @param hdnSubGyomuCode hdnSubGyomuCode
     */
    @JsonProperty("hdnSubGyomuCode")
    public void setHdnSubGyomuCode(RString hdnSubGyomuCode) {
        this.hdnSubGyomuCode = hdnSubGyomuCode;
    }

    /*
     * gethdnCodeShubetsu
     * @return hdnCodeShubetsu
     */
    @JsonProperty("hdnCodeShubetsu")
    public RString getHdnCodeShubetsu() {
        return hdnCodeShubetsu;
    }

    /*
     * sethdnCodeShubetsu
     * @param hdnCodeShubetsu hdnCodeShubetsu
     */
    @JsonProperty("hdnCodeShubetsu")
    public void setHdnCodeShubetsu(RString hdnCodeShubetsu) {
        this.hdnCodeShubetsu = hdnCodeShubetsu;
    }

    /*
     * gethdnJigyoshaMode
     * @return hdnJigyoshaMode
     */
    @JsonProperty("hdnJigyoshaMode")
    public RString getHdnJigyoshaMode() {
        return hdnJigyoshaMode;
    }

    /*
     * sethdnJigyoshaMode
     * @param hdnJigyoshaMode hdnJigyoshaMode
     */
    @JsonProperty("hdnJigyoshaMode")
    public void setHdnJigyoshaMode(RString hdnJigyoshaMode) {
        this.hdnJigyoshaMode = hdnJigyoshaMode;
    }

    /*
     * gethdnSchemaName
     * @return hdnSchemaName
     */
    @JsonProperty("hdnSchemaName")
    public RString getHdnSchemaName() {
        return hdnSchemaName;
    }

    /*
     * sethdnSchemaName
     * @param hdnSchemaName hdnSchemaName
     */
    @JsonProperty("hdnSchemaName")
    public void setHdnSchemaName(RString hdnSchemaName) {
        this.hdnSchemaName = hdnSchemaName;
    }

    /*
     * gethdnShikibetsuCode
     * @return hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public RString getHdnShikibetsuCode() {
        return hdnShikibetsuCode;
    }

    /*
     * sethdnShikibetsuCode
     * @param hdnShikibetsuCode hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public void setHdnShikibetsuCode(RString hdnShikibetsuCode) {
        this.hdnShikibetsuCode = hdnShikibetsuCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxCode getTxtSearchChosaItakusakiCodeFrom() {
        return this.getChosainSearch().getTxtSearchChosaItakusakiCodeFrom();
    }

    @JsonIgnore
    public void  setTxtSearchChosaItakusakiCodeFrom(TextBoxCode txtSearchChosaItakusakiCodeFrom) {
        this.getChosainSearch().setTxtSearchChosaItakusakiCodeFrom(txtSearchChosaItakusakiCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtSearchChosaItakusakiCodeTo() {
        return this.getChosainSearch().getTxtSearchChosaItakusakiCodeTo();
    }

    @JsonIgnore
    public void  setTxtSearchChosaItakusakiCodeTo(TextBoxCode txtSearchChosaItakusakiCodeTo) {
        this.getChosainSearch().setTxtSearchChosaItakusakiCodeTo(txtSearchChosaItakusakiCodeTo);
    }

    @JsonIgnore
    public TextBox getTxtSearchChosaItakusakiMeisho() {
        return this.getChosainSearch().getTxtSearchChosaItakusakiMeisho();
    }

    @JsonIgnore
    public void  setTxtSearchChosaItakusakiMeisho(TextBox txtSearchChosaItakusakiMeisho) {
        this.getChosainSearch().setTxtSearchChosaItakusakiMeisho(txtSearchChosaItakusakiMeisho);
    }

    @JsonIgnore
    public DropDownList getDdlItakusakiMeisho() {
        return this.getChosainSearch().getDdlItakusakiMeisho();
    }

    @JsonIgnore
    public void  setDdlItakusakiMeisho(DropDownList ddlItakusakiMeisho) {
        this.getChosainSearch().setDdlItakusakiMeisho(ddlItakusakiMeisho);
    }

    @JsonIgnore
    public TextBoxKana getTxtSearchChosaItakusakiKanaMeisho() {
        return this.getChosainSearch().getTxtSearchChosaItakusakiKanaMeisho();
    }

    @JsonIgnore
    public void  setTxtSearchChosaItakusakiKanaMeisho(TextBoxKana txtSearchChosaItakusakiKanaMeisho) {
        this.getChosainSearch().setTxtSearchChosaItakusakiKanaMeisho(txtSearchChosaItakusakiKanaMeisho);
    }

    @JsonIgnore
    public DropDownList getDdlItakusakiKanaMeisho() {
        return this.getChosainSearch().getDdlItakusakiKanaMeisho();
    }

    @JsonIgnore
    public void  setDdlItakusakiKanaMeisho(DropDownList ddlItakusakiKanaMeisho) {
        this.getChosainSearch().setDdlItakusakiKanaMeisho(ddlItakusakiKanaMeisho);
    }

    @JsonIgnore
    public DropDownList getDdlitakukubun() {
        return this.getChosainSearch().getDdlitakukubun();
    }

    @JsonIgnore
    public void  setDdlitakukubun(DropDownList ddlitakukubun) {
        this.getChosainSearch().setDdlitakukubun(ddlitakukubun);
    }

    @JsonIgnore
    public DropDownList getDdlkikankubun() {
        return this.getChosainSearch().getDdlkikankubun();
    }

    @JsonIgnore
    public void  setDdlkikankubun(DropDownList ddlkikankubun) {
        this.getChosainSearch().setDdlkikankubun(ddlkikankubun);
    }

    @JsonIgnore
    public RadioButton getRadSearchChosainJokyo() {
        return this.getChosainSearch().getRadSearchChosainJokyo();
    }

    @JsonIgnore
    public void  setRadSearchChosainJokyo(RadioButton radSearchChosainJokyo) {
        this.getChosainSearch().setRadSearchChosainJokyo(radSearchChosainJokyo);
    }

    @JsonIgnore
    public TextBoxNum getTxtSaidaiHyojiKensu() {
        return this.getChosainSearch().getTxtSaidaiHyojiKensu();
    }

    @JsonIgnore
    public void  setTxtSaidaiHyojiKensu(TextBoxNum txtSaidaiHyojiKensu) {
        this.getChosainSearch().setTxtSaidaiHyojiKensu(txtSaidaiHyojiKensu);
    }

    @JsonIgnore
    public Button getBtnSearchShujii() {
        return this.getChosainSearch().getBtnSearchShujii();
    }

    @JsonIgnore
    public void  setBtnSearchShujii(Button btnSearchShujii) {
        this.getChosainSearch().setBtnSearchShujii(btnSearchShujii);
    }

    @JsonIgnore
    public Button getBtnClearKensakuJoken() {
        return this.getChosainSearch().getBtnClearKensakuJoken();
    }

    @JsonIgnore
    public void  setBtnClearKensakuJoken(Button btnClearKensakuJoken) {
        this.getChosainSearch().setBtnClearKensakuJoken(btnClearKensakuJoken);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdHokenshaList() {
        return this.getChosainSearch().getCcdHokenshaList();
    }

    // </editor-fold>
}
