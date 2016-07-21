package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ChosaItakusakiAndChosainGuide.ChosaItakusakiAndChosainGuide;
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

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxChikuCode;

/**
 * ChosaItakusakiAndChosainGuide のクラスファイル
 *
 * @reamsid_L DBZ-1300-020 wanghui
 */
public class ChosaItakusakiAndChosainGuideDiv extends Panel implements IChosaItakusakiAndChosainGuideDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum TaishoMode implements ICommonChildDivMode {

        Itakusaki("Itakusaki"),
        Chosain("Chosain");

        private final String name;

        private TaishoMode(final String name) {
            this.name = name;
        }

        public static TaishoMode getEnum(String str) {
            TaishoMode[] enumArray = TaishoMode.values();

            for (TaishoMode enumStr : enumArray) {
                if (str.equals(enumStr.name.toString())) { 
                    return enumStr;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return this.name;
        }

    }

    public TaishoMode getMode_TaishoMode() {
        return (TaishoMode) _CommonChildDivModeUtil.getMode( this.modes, TaishoMode.class );
    }

    public void setMode_TaishoMode( TaishoMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, TaishoMode.class , value );
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
    public TextBoxCode getTxtChosainCodeFrom() {
        return this.getKensakuJoken().getTxtChosainCodeFrom();
    }

    @JsonIgnore
    public void  setTxtChosainCodeFrom(TextBoxCode txtChosainCodeFrom) {
        this.getKensakuJoken().setTxtChosainCodeFrom(txtChosainCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCodeTo() {
        return this.getKensakuJoken().getTxtChosainCodeTo();
    }

    @JsonIgnore
    public void  setTxtChosainCodeTo(TextBoxCode txtChosainCodeTo) {
        this.getKensakuJoken().setTxtChosainCodeTo(txtChosainCodeTo);
    }

    @JsonIgnore
    public RadioButton getRadChosainJokyo() {
        return this.getKensakuJoken().getRadChosainJokyo();
    }

    @JsonIgnore
    public void  setRadChosainJokyo(RadioButton radChosainJokyo) {
        this.getKensakuJoken().setRadChosainJokyo(radChosainJokyo);
    }

    @JsonIgnore
    public TextBox getTxtChosainName() {
        return this.getKensakuJoken().getTxtChosainName();
    }

    @JsonIgnore
    public void  setTxtChosainName(TextBox txtChosainName) {
        this.getKensakuJoken().setTxtChosainName(txtChosainName);
    }

    @JsonIgnore
    public TextBox getTxtChosainKanaShimei() {
        return this.getKensakuJoken().getTxtChosainKanaShimei();
    }

    @JsonIgnore
    public void  setTxtChosainKanaShimei(TextBox txtChosainKanaShimei) {
        this.getKensakuJoken().setTxtChosainKanaShimei(txtChosainKanaShimei);
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
    private ChosaItakusakiAndChosainGuideHandler getHandler(ChosaItakusakiAndChosainGuideDiv div) {
        return new ChosaItakusakiAndChosainGuideHandler(div);
    }

    /**
     * 調査委託先＆調査員ガイドに初期化を設定します。
     */
    @Override
    public void initialize() {
        getHandler(this).intialize();
    }
}
