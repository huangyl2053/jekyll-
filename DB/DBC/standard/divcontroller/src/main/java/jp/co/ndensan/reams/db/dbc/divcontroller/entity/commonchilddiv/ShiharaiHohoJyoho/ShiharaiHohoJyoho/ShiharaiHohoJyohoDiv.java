package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shiharaihohojyoho.SikyuSinseiJyohoParameter;
import jp.co.ndensan.reams.db.dbc.divcontroller.controller.handler.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyohoHandler;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxKinyuKikanCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxKinyuKikanShitenCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShiharaiHohoJyoho のクラスファイル
 *
 * @author 自動生成
 */
public class ShiharaiHohoJyohoDiv extends Panel implements IShiharaiHohoJyohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radMadoguti")
    private RadioButton radMadoguti;
    @JsonProperty("txtShiharaiBasho")
    private TextBox txtShiharaiBasho;
    @JsonProperty("txtStartYMD")
    private TextBoxDate txtStartYMD;
    @JsonProperty("txtStartYobi")
    private TextBox txtStartYobi;
    @JsonProperty("txtStartHHMM")
    private TextBoxTime txtStartHHMM;
    @JsonProperty("txtEndYMD")
    private TextBoxDate txtEndYMD;
    @JsonProperty("txtEndYobi")
    private TextBox txtEndYobi;
    @JsonProperty("txtEndHHMM")
    private TextBoxTime txtEndHHMM;
    @JsonProperty("linMadoguti")
    private HorizontalLine linMadoguti;
    @JsonProperty("radKoza")
    private RadioButton radKoza;
    @JsonProperty("ddlKozaID")
    private DropDownList ddlKozaID;
    @JsonProperty("btnKozaToroku")
    private ButtonDialog btnKozaToroku;
    @JsonProperty("txtKinyuKikanCode")
    private TextBoxKinyuKikanCode txtKinyuKikanCode;
    @JsonProperty("txtKinyuKikanShitenCode")
    private TextBoxKinyuKikanShitenCode txtKinyuKikanShitenCode;
    @JsonProperty("txtTenban")
    private TextBoxCode txtTenban;
    @JsonProperty("txtYokinShubetsu")
    private TextBox txtYokinShubetsu;
    @JsonProperty("txtKozaNo")
    private TextBoxCode txtKozaNo;
    @JsonProperty("txtKinyuKikanName")
    private TextBox txtKinyuKikanName;
    @JsonProperty("txtMeigininKana")
    private TextBoxAtenaKanaMeisho txtMeigininKana;
    @JsonProperty("ttxtMeigininKanji")
    private TextBoxAtenaMeisho ttxtMeigininKanji;
    @JsonProperty("linKoza")
    private HorizontalLine linKoza;
    @JsonProperty("radJyryoinin")
    private RadioButton radJyryoinin;
    @JsonProperty("txtKeiyakuNo")
    private TextBoxCode txtKeiyakuNo;
    @JsonProperty("btnSelect")
    private ButtonDialog btnSelect;
    @JsonProperty("txtKeiyakuCode")
    private TextBoxCode txtKeiyakuCode;
    @JsonProperty("txtKeiyakuName")
    private TextBoxAtenaMeisho txtKeiyakuName;
    @JsonProperty("txtKinyuKikanCode1")
    private TextBoxKinyuKikanCode txtKinyuKikanCode1;
    @JsonProperty("txtKinyuKikanShitenCode1")
    private TextBoxKinyuKikanShitenCode txtKinyuKikanShitenCode1;
    @JsonProperty("txtTenban1")
    private TextBoxCode txtTenban1;
    @JsonProperty("txtYokinShubetsu1")
    private TextBox txtYokinShubetsu1;
    @JsonProperty("txtKozaNo1")
    private TextBoxCode txtKozaNo1;
    @JsonProperty("txtKinyuKikanName1")
    private TextBox txtKinyuKikanName1;
    @JsonProperty("txtMeigininKana1")
    private TextBoxAtenaKanaMeisho txtMeigininKana1;
    @JsonProperty("txtMeigininKanji1")
    private TextBoxAtenaMeisho txtMeigininKanji1;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getradMadoguti
     * @return radMadoguti
     */
    @JsonProperty("radMadoguti")
    public RadioButton getRadMadoguti() {
        return radMadoguti;
    }

    /*
     * setradMadoguti
     * @param radMadoguti radMadoguti
     */
    @JsonProperty("radMadoguti")
    public void setRadMadoguti(RadioButton radMadoguti) {
        this.radMadoguti = radMadoguti;
    }

    /*
     * gettxtShiharaiBasho
     * @return txtShiharaiBasho
     */
    @JsonProperty("txtShiharaiBasho")
    public TextBox getTxtShiharaiBasho() {
        return txtShiharaiBasho;
    }

    /*
     * settxtShiharaiBasho
     * @param txtShiharaiBasho txtShiharaiBasho
     */
    @JsonProperty("txtShiharaiBasho")
    public void setTxtShiharaiBasho(TextBox txtShiharaiBasho) {
        this.txtShiharaiBasho = txtShiharaiBasho;
    }

    /*
     * gettxtStartYMD
     * @return txtStartYMD
     */
    @JsonProperty("txtStartYMD")
    public TextBoxDate getTxtStartYMD() {
        return txtStartYMD;
    }

    /*
     * settxtStartYMD
     * @param txtStartYMD txtStartYMD
     */
    @JsonProperty("txtStartYMD")
    public void setTxtStartYMD(TextBoxDate txtStartYMD) {
        this.txtStartYMD = txtStartYMD;
    }

    /*
     * gettxtStartYobi
     * @return txtStartYobi
     */
    @JsonProperty("txtStartYobi")
    public TextBox getTxtStartYobi() {
        return txtStartYobi;
    }

    /*
     * settxtStartYobi
     * @param txtStartYobi txtStartYobi
     */
    @JsonProperty("txtStartYobi")
    public void setTxtStartYobi(TextBox txtStartYobi) {
        this.txtStartYobi = txtStartYobi;
    }

    /*
     * gettxtStartHHMM
     * @return txtStartHHMM
     */
    @JsonProperty("txtStartHHMM")
    public TextBoxTime getTxtStartHHMM() {
        return txtStartHHMM;
    }

    /*
     * settxtStartHHMM
     * @param txtStartHHMM txtStartHHMM
     */
    @JsonProperty("txtStartHHMM")
    public void setTxtStartHHMM(TextBoxTime txtStartHHMM) {
        this.txtStartHHMM = txtStartHHMM;
    }

    /*
     * gettxtEndYMD
     * @return txtEndYMD
     */
    @JsonProperty("txtEndYMD")
    public TextBoxDate getTxtEndYMD() {
        return txtEndYMD;
    }

    /*
     * settxtEndYMD
     * @param txtEndYMD txtEndYMD
     */
    @JsonProperty("txtEndYMD")
    public void setTxtEndYMD(TextBoxDate txtEndYMD) {
        this.txtEndYMD = txtEndYMD;
    }

    /*
     * gettxtEndYobi
     * @return txtEndYobi
     */
    @JsonProperty("txtEndYobi")
    public TextBox getTxtEndYobi() {
        return txtEndYobi;
    }

    /*
     * settxtEndYobi
     * @param txtEndYobi txtEndYobi
     */
    @JsonProperty("txtEndYobi")
    public void setTxtEndYobi(TextBox txtEndYobi) {
        this.txtEndYobi = txtEndYobi;
    }

    /*
     * gettxtEndHHMM
     * @return txtEndHHMM
     */
    @JsonProperty("txtEndHHMM")
    public TextBoxTime getTxtEndHHMM() {
        return txtEndHHMM;
    }

    /*
     * settxtEndHHMM
     * @param txtEndHHMM txtEndHHMM
     */
    @JsonProperty("txtEndHHMM")
    public void setTxtEndHHMM(TextBoxTime txtEndHHMM) {
        this.txtEndHHMM = txtEndHHMM;
    }

    /*
     * getlinMadoguti
     * @return linMadoguti
     */
    @JsonProperty("linMadoguti")
    public HorizontalLine getLinMadoguti() {
        return linMadoguti;
    }

    /*
     * setlinMadoguti
     * @param linMadoguti linMadoguti
     */
    @JsonProperty("linMadoguti")
    public void setLinMadoguti(HorizontalLine linMadoguti) {
        this.linMadoguti = linMadoguti;
    }

    /*
     * getradKoza
     * @return radKoza
     */
    @JsonProperty("radKoza")
    public RadioButton getRadKoza() {
        return radKoza;
    }

    /*
     * setradKoza
     * @param radKoza radKoza
     */
    @JsonProperty("radKoza")
    public void setRadKoza(RadioButton radKoza) {
        this.radKoza = radKoza;
    }

    /*
     * getddlKozaID
     * @return ddlKozaID
     */
    @JsonProperty("ddlKozaID")
    public DropDownList getDdlKozaID() {
        return ddlKozaID;
    }

    /*
     * setddlKozaID
     * @param ddlKozaID ddlKozaID
     */
    @JsonProperty("ddlKozaID")
    public void setDdlKozaID(DropDownList ddlKozaID) {
        this.ddlKozaID = ddlKozaID;
    }

    /*
     * getbtnKozaToroku
     * @return btnKozaToroku
     */
    @JsonProperty("btnKozaToroku")
    public ButtonDialog getBtnKozaToroku() {
        return btnKozaToroku;
    }

    /*
     * setbtnKozaToroku
     * @param btnKozaToroku btnKozaToroku
     */
    @JsonProperty("btnKozaToroku")
    public void setBtnKozaToroku(ButtonDialog btnKozaToroku) {
        this.btnKozaToroku = btnKozaToroku;
    }

    /*
     * gettxtKinyuKikanCode
     * @return txtKinyuKikanCode
     */
    @JsonProperty("txtKinyuKikanCode")
    public TextBoxKinyuKikanCode getTxtKinyuKikanCode() {
        return txtKinyuKikanCode;
    }

    /*
     * settxtKinyuKikanCode
     * @param txtKinyuKikanCode txtKinyuKikanCode
     */
    @JsonProperty("txtKinyuKikanCode")
    public void setTxtKinyuKikanCode(TextBoxKinyuKikanCode txtKinyuKikanCode) {
        this.txtKinyuKikanCode = txtKinyuKikanCode;
    }

    /*
     * gettxtKinyuKikanShitenCode
     * @return txtKinyuKikanShitenCode
     */
    @JsonProperty("txtKinyuKikanShitenCode")
    public TextBoxKinyuKikanShitenCode getTxtKinyuKikanShitenCode() {
        return txtKinyuKikanShitenCode;
    }

    /*
     * settxtKinyuKikanShitenCode
     * @param txtKinyuKikanShitenCode txtKinyuKikanShitenCode
     */
    @JsonProperty("txtKinyuKikanShitenCode")
    public void setTxtKinyuKikanShitenCode(TextBoxKinyuKikanShitenCode txtKinyuKikanShitenCode) {
        this.txtKinyuKikanShitenCode = txtKinyuKikanShitenCode;
    }

    /*
     * gettxtTenban
     * @return txtTenban
     */
    @JsonProperty("txtTenban")
    public TextBoxCode getTxtTenban() {
        return txtTenban;
    }

    /*
     * settxtTenban
     * @param txtTenban txtTenban
     */
    @JsonProperty("txtTenban")
    public void setTxtTenban(TextBoxCode txtTenban) {
        this.txtTenban = txtTenban;
    }

    /*
     * gettxtYokinShubetsu
     * @return txtYokinShubetsu
     */
    @JsonProperty("txtYokinShubetsu")
    public TextBox getTxtYokinShubetsu() {
        return txtYokinShubetsu;
    }

    /*
     * settxtYokinShubetsu
     * @param txtYokinShubetsu txtYokinShubetsu
     */
    @JsonProperty("txtYokinShubetsu")
    public void setTxtYokinShubetsu(TextBox txtYokinShubetsu) {
        this.txtYokinShubetsu = txtYokinShubetsu;
    }

    /*
     * gettxtKozaNo
     * @return txtKozaNo
     */
    @JsonProperty("txtKozaNo")
    public TextBoxCode getTxtKozaNo() {
        return txtKozaNo;
    }

    /*
     * settxtKozaNo
     * @param txtKozaNo txtKozaNo
     */
    @JsonProperty("txtKozaNo")
    public void setTxtKozaNo(TextBoxCode txtKozaNo) {
        this.txtKozaNo = txtKozaNo;
    }

    /*
     * gettxtKinyuKikanName
     * @return txtKinyuKikanName
     */
    @JsonProperty("txtKinyuKikanName")
    public TextBox getTxtKinyuKikanName() {
        return txtKinyuKikanName;
    }

    /*
     * settxtKinyuKikanName
     * @param txtKinyuKikanName txtKinyuKikanName
     */
    @JsonProperty("txtKinyuKikanName")
    public void setTxtKinyuKikanName(TextBox txtKinyuKikanName) {
        this.txtKinyuKikanName = txtKinyuKikanName;
    }

    /*
     * gettxtMeigininKana
     * @return txtMeigininKana
     */
    @JsonProperty("txtMeigininKana")
    public TextBoxAtenaKanaMeisho getTxtMeigininKana() {
        return txtMeigininKana;
    }

    /*
     * settxtMeigininKana
     * @param txtMeigininKana txtMeigininKana
     */
    @JsonProperty("txtMeigininKana")
    public void setTxtMeigininKana(TextBoxAtenaKanaMeisho txtMeigininKana) {
        this.txtMeigininKana = txtMeigininKana;
    }

    /*
     * getttxtMeigininKanji
     * @return ttxtMeigininKanji
     */
    @JsonProperty("ttxtMeigininKanji")
    public TextBoxAtenaMeisho getTtxtMeigininKanji() {
        return ttxtMeigininKanji;
    }

    /*
     * setttxtMeigininKanji
     * @param ttxtMeigininKanji ttxtMeigininKanji
     */
    @JsonProperty("ttxtMeigininKanji")
    public void setTtxtMeigininKanji(TextBoxAtenaMeisho ttxtMeigininKanji) {
        this.ttxtMeigininKanji = ttxtMeigininKanji;
    }

    /*
     * getlinKoza
     * @return linKoza
     */
    @JsonProperty("linKoza")
    public HorizontalLine getLinKoza() {
        return linKoza;
    }

    /*
     * setlinKoza
     * @param linKoza linKoza
     */
    @JsonProperty("linKoza")
    public void setLinKoza(HorizontalLine linKoza) {
        this.linKoza = linKoza;
    }

    /*
     * getradJyryoinin
     * @return radJyryoinin
     */
    @JsonProperty("radJyryoinin")
    public RadioButton getRadJyryoinin() {
        return radJyryoinin;
    }

    /*
     * setradJyryoinin
     * @param radJyryoinin radJyryoinin
     */
    @JsonProperty("radJyryoinin")
    public void setRadJyryoinin(RadioButton radJyryoinin) {
        this.radJyryoinin = radJyryoinin;
    }

    /*
     * gettxtKeiyakuNo
     * @return txtKeiyakuNo
     */
    @JsonProperty("txtKeiyakuNo")
    public TextBoxCode getTxtKeiyakuNo() {
        return txtKeiyakuNo;
    }

    /*
     * settxtKeiyakuNo
     * @param txtKeiyakuNo txtKeiyakuNo
     */
    @JsonProperty("txtKeiyakuNo")
    public void setTxtKeiyakuNo(TextBoxCode txtKeiyakuNo) {
        this.txtKeiyakuNo = txtKeiyakuNo;
    }

    /*
     * getbtnSelect
     * @return btnSelect
     */
    @JsonProperty("btnSelect")
    public ButtonDialog getBtnSelect() {
        return btnSelect;
    }

    /*
     * setbtnSelect
     * @param btnSelect btnSelect
     */
    @JsonProperty("btnSelect")
    public void setBtnSelect(ButtonDialog btnSelect) {
        this.btnSelect = btnSelect;
    }

    /*
     * gettxtKeiyakuCode
     * @return txtKeiyakuCode
     */
    @JsonProperty("txtKeiyakuCode")
    public TextBoxCode getTxtKeiyakuCode() {
        return txtKeiyakuCode;
    }

    /*
     * settxtKeiyakuCode
     * @param txtKeiyakuCode txtKeiyakuCode
     */
    @JsonProperty("txtKeiyakuCode")
    public void setTxtKeiyakuCode(TextBoxCode txtKeiyakuCode) {
        this.txtKeiyakuCode = txtKeiyakuCode;
    }

    /*
     * gettxtKeiyakuName
     * @return txtKeiyakuName
     */
    @JsonProperty("txtKeiyakuName")
    public TextBoxAtenaMeisho getTxtKeiyakuName() {
        return txtKeiyakuName;
    }

    /*
     * settxtKeiyakuName
     * @param txtKeiyakuName txtKeiyakuName
     */
    @JsonProperty("txtKeiyakuName")
    public void setTxtKeiyakuName(TextBoxAtenaMeisho txtKeiyakuName) {
        this.txtKeiyakuName = txtKeiyakuName;
    }

    /*
     * gettxtKinyuKikanCode1
     * @return txtKinyuKikanCode1
     */
    @JsonProperty("txtKinyuKikanCode1")
    public TextBoxKinyuKikanCode getTxtKinyuKikanCode1() {
        return txtKinyuKikanCode1;
    }

    /*
     * settxtKinyuKikanCode1
     * @param txtKinyuKikanCode1 txtKinyuKikanCode1
     */
    @JsonProperty("txtKinyuKikanCode1")
    public void setTxtKinyuKikanCode1(TextBoxKinyuKikanCode txtKinyuKikanCode1) {
        this.txtKinyuKikanCode1 = txtKinyuKikanCode1;
    }

    /*
     * gettxtKinyuKikanShitenCode1
     * @return txtKinyuKikanShitenCode1
     */
    @JsonProperty("txtKinyuKikanShitenCode1")
    public TextBoxKinyuKikanShitenCode getTxtKinyuKikanShitenCode1() {
        return txtKinyuKikanShitenCode1;
    }

    /*
     * settxtKinyuKikanShitenCode1
     * @param txtKinyuKikanShitenCode1 txtKinyuKikanShitenCode1
     */
    @JsonProperty("txtKinyuKikanShitenCode1")
    public void setTxtKinyuKikanShitenCode1(TextBoxKinyuKikanShitenCode txtKinyuKikanShitenCode1) {
        this.txtKinyuKikanShitenCode1 = txtKinyuKikanShitenCode1;
    }

    /*
     * gettxtTenban1
     * @return txtTenban1
     */
    @JsonProperty("txtTenban1")
    public TextBoxCode getTxtTenban1() {
        return txtTenban1;
    }

    /*
     * settxtTenban1
     * @param txtTenban1 txtTenban1
     */
    @JsonProperty("txtTenban1")
    public void setTxtTenban1(TextBoxCode txtTenban1) {
        this.txtTenban1 = txtTenban1;
    }

    /*
     * gettxtYokinShubetsu1
     * @return txtYokinShubetsu1
     */
    @JsonProperty("txtYokinShubetsu1")
    public TextBox getTxtYokinShubetsu1() {
        return txtYokinShubetsu1;
    }

    /*
     * settxtYokinShubetsu1
     * @param txtYokinShubetsu1 txtYokinShubetsu1
     */
    @JsonProperty("txtYokinShubetsu1")
    public void setTxtYokinShubetsu1(TextBox txtYokinShubetsu1) {
        this.txtYokinShubetsu1 = txtYokinShubetsu1;
    }

    /*
     * gettxtKozaNo1
     * @return txtKozaNo1
     */
    @JsonProperty("txtKozaNo1")
    public TextBoxCode getTxtKozaNo1() {
        return txtKozaNo1;
    }

    /*
     * settxtKozaNo1
     * @param txtKozaNo1 txtKozaNo1
     */
    @JsonProperty("txtKozaNo1")
    public void setTxtKozaNo1(TextBoxCode txtKozaNo1) {
        this.txtKozaNo1 = txtKozaNo1;
    }

    /*
     * gettxtKinyuKikanName1
     * @return txtKinyuKikanName1
     */
    @JsonProperty("txtKinyuKikanName1")
    public TextBox getTxtKinyuKikanName1() {
        return txtKinyuKikanName1;
    }

    /*
     * settxtKinyuKikanName1
     * @param txtKinyuKikanName1 txtKinyuKikanName1
     */
    @JsonProperty("txtKinyuKikanName1")
    public void setTxtKinyuKikanName1(TextBox txtKinyuKikanName1) {
        this.txtKinyuKikanName1 = txtKinyuKikanName1;
    }

    /*
     * gettxtMeigininKana1
     * @return txtMeigininKana1
     */
    @JsonProperty("txtMeigininKana1")
    public TextBoxAtenaKanaMeisho getTxtMeigininKana1() {
        return txtMeigininKana1;
    }

    /*
     * settxtMeigininKana1
     * @param txtMeigininKana1 txtMeigininKana1
     */
    @JsonProperty("txtMeigininKana1")
    public void setTxtMeigininKana1(TextBoxAtenaKanaMeisho txtMeigininKana1) {
        this.txtMeigininKana1 = txtMeigininKana1;
    }

    /*
     * gettxtMeigininKanji1
     * @return txtMeigininKanji1
     */
    @JsonProperty("txtMeigininKanji1")
    public TextBoxAtenaMeisho getTxtMeigininKanji1() {
        return txtMeigininKanji1;
    }

    /*
     * settxtMeigininKanji1
     * @param txtMeigininKanji1 txtMeigininKanji1
     */
    @JsonProperty("txtMeigininKanji1")
    public void setTxtMeigininKanji1(TextBoxAtenaMeisho txtMeigininKanji1) {
        this.txtMeigininKanji1 = txtMeigininKanji1;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        shokai("shokai"),
        toroku("toroku");

        private final String name;

        private DisplayMode(final String name) {
            this.name = name;
        }

        public static DisplayMode getEnum(String str) {
            DisplayMode[] enumArray = DisplayMode.values();

            for (DisplayMode enumStr : enumArray) {
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

    public DisplayMode getMode_DisplayMode() {
        return (DisplayMode) _CommonChildDivModeUtil.getMode( this.modes, DisplayMode.class );
    }

    public void setMode_DisplayMode( DisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayMode.class , value );
    }

    public static enum PageMode implements ICommonChildDivMode {

        Shokan("Shokan"),
        JutakuKaishu("JutakuKaishu"),
        Fukushiyogu("Fukushiyogu"),
        KogakuService("KogakuService"),
        KogakuGassan("KogakuGassan");

        private final String name;

        private PageMode(final String name) {
            this.name = name;
        }

        public static PageMode getEnum(String str) {
            PageMode[] enumArray = PageMode.values();

            for (PageMode enumStr : enumArray) {
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

    public PageMode getMode_PageMode() {
        return (PageMode) _CommonChildDivModeUtil.getMode( this.modes, PageMode.class );
    }

    public void setMode_PageMode( PageMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, PageMode.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private ShiharaiHohoJyohoHandler getHandler() {
        return new ShiharaiHohoJyohoHandler(this);
    }

    /**
     * 共通子DIVの初期化処理です。
     *
     *
     * @param 支給申請情報
     * @param 業務内区分コード
     * @param 状態
     */
    @Override
    public void initialize(SikyuSinseiJyohoParameter 支給申請情報, KamokuCode 業務内区分コード, RString 状態) {
        getHandler().initialize(支給申請情報, 業務内区分コード, 状態);
    }
}
