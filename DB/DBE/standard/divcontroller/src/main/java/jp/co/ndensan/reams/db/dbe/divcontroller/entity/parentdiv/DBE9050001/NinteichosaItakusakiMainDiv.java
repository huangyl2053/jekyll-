package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE9050001;
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
 * NinteichosaItakusakiMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteichosaItakusakiMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-11-29_19-09-25">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ChosainSearch")
    private ChosainSearchDiv ChosainSearch;
    @JsonProperty("SonotaKikanichiran")
    private SonotaKikanichiranDiv SonotaKikanichiran;
    @JsonProperty("ChosaitakusakiJohoInput")
    private ChosaitakusakiJohoInputDiv ChosaitakusakiJohoInput;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("hdnTxtSubGyomuCode")
    private RString hdnTxtSubGyomuCode;
    @JsonProperty("hdnTxtShikibetsuCode")
    private RString hdnTxtShikibetsuCode;

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
     * getSonotaKikanichiran
     * @return SonotaKikanichiran
     */
    @JsonProperty("SonotaKikanichiran")
    public SonotaKikanichiranDiv getSonotaKikanichiran() {
        return SonotaKikanichiran;
    }

    /*
     * setSonotaKikanichiran
     * @param SonotaKikanichiran SonotaKikanichiran
     */
    @JsonProperty("SonotaKikanichiran")
    public void setSonotaKikanichiran(SonotaKikanichiranDiv SonotaKikanichiran) {
        this.SonotaKikanichiran = SonotaKikanichiran;
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
     * gethdnTxtSubGyomuCode
     * @return hdnTxtSubGyomuCode
     */
    @JsonProperty("hdnTxtSubGyomuCode")
    public RString getHdnTxtSubGyomuCode() {
        return hdnTxtSubGyomuCode;
    }

    /*
     * sethdnTxtSubGyomuCode
     * @param hdnTxtSubGyomuCode hdnTxtSubGyomuCode
     */
    @JsonProperty("hdnTxtSubGyomuCode")
    public void setHdnTxtSubGyomuCode(RString hdnTxtSubGyomuCode) {
        this.hdnTxtSubGyomuCode = hdnTxtSubGyomuCode;
    }

    /*
     * gethdnTxtShikibetsuCode
     * @return hdnTxtShikibetsuCode
     */
    @JsonProperty("hdnTxtShikibetsuCode")
    public RString getHdnTxtShikibetsuCode() {
        return hdnTxtShikibetsuCode;
    }

    /*
     * sethdnTxtShikibetsuCode
     * @param hdnTxtShikibetsuCode hdnTxtShikibetsuCode
     */
    @JsonProperty("hdnTxtShikibetsuCode")
    public void setHdnTxtShikibetsuCode(RString hdnTxtShikibetsuCode) {
        this.hdnTxtShikibetsuCode = hdnTxtShikibetsuCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadSearchHaisiFlag() {
        return this.getChosainSearch().getRadSearchHaisiFlag();
    }

    @JsonIgnore
    public void  setRadSearchHaisiFlag(RadioButton radSearchHaisiFlag) {
        this.getChosainSearch().setRadSearchHaisiFlag(radSearchHaisiFlag);
    }

    @JsonIgnore
    public TextBoxCode getTxtSearchSonotaKikanCodeFrom() {
        return this.getChosainSearch().getTxtSearchSonotaKikanCodeFrom();
    }

    @JsonIgnore
    public void  setTxtSearchSonotaKikanCodeFrom(TextBoxCode txtSearchSonotaKikanCodeFrom) {
        this.getChosainSearch().setTxtSearchSonotaKikanCodeFrom(txtSearchSonotaKikanCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtSearchSonotaKikanCodeTo() {
        return this.getChosainSearch().getTxtSearchSonotaKikanCodeTo();
    }

    @JsonIgnore
    public void  setTxtSearchSonotaKikanCodeTo(TextBoxCode txtSearchSonotaKikanCodeTo) {
        this.getChosainSearch().setTxtSearchSonotaKikanCodeTo(txtSearchSonotaKikanCodeTo);
    }

    @JsonIgnore
    public TextBox getTxtSearchSonotaKikanMeisho() {
        return this.getChosainSearch().getTxtSearchSonotaKikanMeisho();
    }

    @JsonIgnore
    public void  setTxtSearchSonotaKikanMeisho(TextBox txtSearchSonotaKikanMeisho) {
        this.getChosainSearch().setTxtSearchSonotaKikanMeisho(txtSearchSonotaKikanMeisho);
    }

    @JsonIgnore
    public TextBoxKana getTxtSearchSonotaKikanKanaMeisho() {
        return this.getChosainSearch().getTxtSearchSonotaKikanKanaMeisho();
    }

    @JsonIgnore
    public void  setTxtSearchSonotaKikanKanaMeisho(TextBoxKana txtSearchSonotaKikanKanaMeisho) {
        this.getChosainSearch().setTxtSearchSonotaKikanKanaMeisho(txtSearchSonotaKikanKanaMeisho);
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
    public DropDownList getDdlitakukubun() {
        return this.getChosainSearch().getDdlitakukubun();
    }

    @JsonIgnore
    public void  setDdlitakukubun(DropDownList ddlitakukubun) {
        this.getChosainSearch().setDdlitakukubun(ddlitakukubun);
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
    public IHokenshaListDiv getCcdhokensha() {
        return this.getChosainSearch().getCcdhokensha();
    }

    // </editor-fold>
}
