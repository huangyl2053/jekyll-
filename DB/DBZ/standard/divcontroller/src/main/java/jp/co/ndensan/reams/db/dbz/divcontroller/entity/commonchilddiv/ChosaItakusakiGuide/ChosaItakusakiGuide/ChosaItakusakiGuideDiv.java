package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiGuide.ChosaItakusakiGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ChosaItakusakiGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakusakiGuideDiv extends Panel implements IChosaItakusakiGuideDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("KensakuKekkaIchiran")
    private KensakuKekkaIchiranDiv KensakuKekkaIchiran;
    @JsonProperty("btnBack")
    private Button btnBack;
    @JsonProperty("hdnSelectItakusakiCode")
    private RString hdnSelectItakusakiCode;
    @JsonProperty("hdnSelectItakusakiName")
    private RString hdnSelectItakusakiName;
    @JsonProperty("hdnSelectChosainCode")
    private RString hdnSelectChosainCode;
    @JsonProperty("hdnSelectChosainName")
    private RString hdnSelectChosainName;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getKensakuKekkaIchiran
     * @return KensakuKekkaIchiran
     */
    @JsonProperty("KensakuKekkaIchiran")
    public KensakuKekkaIchiranDiv getKensakuKekkaIchiran() {
        return KensakuKekkaIchiran;
    }

    /*
     * setKensakuKekkaIchiran
     * @param KensakuKekkaIchiran KensakuKekkaIchiran
     */
    @JsonProperty("KensakuKekkaIchiran")
    public void setKensakuKekkaIchiran(KensakuKekkaIchiranDiv KensakuKekkaIchiran) {
        this.KensakuKekkaIchiran = KensakuKekkaIchiran;
    }

    /*
     * getbtnBack
     * @return btnBack
     */
    @JsonProperty("btnBack")
    public Button getBtnBack() {
        return btnBack;
    }

    /*
     * setbtnBack
     * @param btnBack btnBack
     */
    @JsonProperty("btnBack")
    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    /*
     * gethdnSelectItakusakiCode
     * @return hdnSelectItakusakiCode
     */
    @JsonProperty("hdnSelectItakusakiCode")
    public RString getHdnSelectItakusakiCode() {
        return hdnSelectItakusakiCode;
    }

    /*
     * sethdnSelectItakusakiCode
     * @param hdnSelectItakusakiCode hdnSelectItakusakiCode
     */
    @JsonProperty("hdnSelectItakusakiCode")
    public void setHdnSelectItakusakiCode(RString hdnSelectItakusakiCode) {
        this.hdnSelectItakusakiCode = hdnSelectItakusakiCode;
    }

    /*
     * gethdnSelectItakusakiName
     * @return hdnSelectItakusakiName
     */
    @JsonProperty("hdnSelectItakusakiName")
    public RString getHdnSelectItakusakiName() {
        return hdnSelectItakusakiName;
    }

    /*
     * sethdnSelectItakusakiName
     * @param hdnSelectItakusakiName hdnSelectItakusakiName
     */
    @JsonProperty("hdnSelectItakusakiName")
    public void setHdnSelectItakusakiName(RString hdnSelectItakusakiName) {
        this.hdnSelectItakusakiName = hdnSelectItakusakiName;
    }

    /*
     * gethdnSelectChosainCode
     * @return hdnSelectChosainCode
     */
    @JsonProperty("hdnSelectChosainCode")
    public RString getHdnSelectChosainCode() {
        return hdnSelectChosainCode;
    }

    /*
     * sethdnSelectChosainCode
     * @param hdnSelectChosainCode hdnSelectChosainCode
     */
    @JsonProperty("hdnSelectChosainCode")
    public void setHdnSelectChosainCode(RString hdnSelectChosainCode) {
        this.hdnSelectChosainCode = hdnSelectChosainCode;
    }

    /*
     * gethdnSelectChosainName
     * @return hdnSelectChosainName
     */
    @JsonProperty("hdnSelectChosainName")
    public RString getHdnSelectChosainName() {
        return hdnSelectChosainName;
    }

    /*
     * sethdnSelectChosainName
     * @param hdnSelectChosainName hdnSelectChosainName
     */
    @JsonProperty("hdnSelectChosainName")
    public void setHdnSelectChosainName(RString hdnSelectChosainName) {
        this.hdnSelectChosainName = hdnSelectChosainName;
    }

    /*
     * gethdnDatabaseSubGyomuCode
     * @return hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    /*
     * sethdnDatabaseSubGyomuCode
     * @param hdnDatabaseSubGyomuCode hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode = hdnDatabaseSubGyomuCode;
    }

    /*
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IHokenshaListDiv getHokensha() {
        return this.getKensakuJoken().getHokensha();
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaItakusakiCodeFrom() {
        return this.getKensakuJoken().getTxtChosaItakusakiCodeFrom();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiCodeFrom(TextBoxCode txtChosaItakusakiCodeFrom) {
        this.getKensakuJoken().setTxtChosaItakusakiCodeFrom(txtChosaItakusakiCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaItakuaskiCodeTo() {
        return this.getKensakuJoken().getTxtChosaItakuaskiCodeTo();
    }

    @JsonIgnore
    public void  setTxtChosaItakuaskiCodeTo(TextBoxCode txtChosaItakuaskiCodeTo) {
        this.getKensakuJoken().setTxtChosaItakuaskiCodeTo(txtChosaItakuaskiCodeTo);
    }

    @JsonIgnore
    public RadioButton getRadItakusakiJokyo() {
        return this.getKensakuJoken().getRadItakusakiJokyo();
    }

    @JsonIgnore
    public void  setRadItakusakiJokyo(RadioButton radItakusakiJokyo) {
        this.getKensakuJoken().setRadItakusakiJokyo(radItakusakiJokyo);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiName() {
        return this.getKensakuJoken().getTxtChosaItakusakiName();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.getKensakuJoken().setTxtChosaItakusakiName(txtChosaItakusakiName);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakusakiKanaMeisho() {
        return this.getKensakuJoken().getTxtChosaItakusakiKanaMeisho();
    }

    @JsonIgnore
    public void  setTxtChosaItakusakiKanaMeisho(TextBox txtChosaItakusakiKanaMeisho) {
        this.getKensakuJoken().setTxtChosaItakusakiKanaMeisho(txtChosaItakusakiKanaMeisho);
    }

    @JsonIgnore
    public DropDownList getDdlChosaItakusakiKubun() {
        return this.getKensakuJoken().getDdlChosaItakusakiKubun();
    }

    @JsonIgnore
    public void  setDdlChosaItakusakiKubun(DropDownList ddlChosaItakusakiKubun) {
        this.getKensakuJoken().setDdlChosaItakusakiKubun(ddlChosaItakusakiKubun);
    }

    @JsonIgnore
    public TextBoxChikuCode getTxtChikuCode() {
        return this.getKensakuJoken().getTxtChikuCode();
    }

    @JsonIgnore
    public void  setTxtChikuCode(TextBoxChikuCode txtChikuCode) {
        this.getKensakuJoken().setTxtChikuCode(txtChikuCode);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getKensakuJoken().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getKensakuJoken().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuJoken().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuJoken().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKensakuJoken().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getKensakuJoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public DataGrid<dgKensakuKekkaIchiran_Row> getDgKensakuKekkaIchiran() {
        return this.getKensakuKekkaIchiran().getDgKensakuKekkaIchiran();
    }

    @JsonIgnore
    public void  setDgKensakuKekkaIchiran(DataGrid<dgKensakuKekkaIchiran_Row> dgKensakuKekkaIchiran) {
        this.getKensakuKekkaIchiran().setDgKensakuKekkaIchiran(dgKensakuKekkaIchiran);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private ChosaItakusakiGuideHandler getHandler(ChosaItakusakiGuideDiv div) {
        return new ChosaItakusakiGuideHandler(div);
    }

    /**
     * 調査委託先ガイドに初期化を設定します。
     */
    @Override
    public void initialize() {
        getHandler(this).intialize();
    }



}
