package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha;

/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaDataPassModel;
import jp.co.ndensan.reams.db.dbz.business.core.ninteishinseitodokedesha.NinteiShinseiTodokedeshaNaiyo;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.ninteishinseitodokedesha.NinteiShinseiTodokedeshaHandler;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.ChoikiInputDiv;
import jp.co.ndensan.reams.ur.ura.divcontroller.entity.commonchilddiv.ChoikiInput.IChoikiInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.IZenkokuJushoInputDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.ZenkokuJushoInput.ZenkokuJushoInputDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * NinteiShinseiTodokedesha のクラスファイル。
 *
 * @reamsid_L DBZ-1300-110 yaodongsheng
 */
public class NinteiShinseiTodokedeshaDiv extends Panel implements INinteiShinseiTodokedeshaDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlTodokledeDaikoKubun")
    private DropDownList ddlTodokledeDaikoKubun;
    @JsonProperty("btnSetaiIchiran")
    private ButtonDialog btnSetaiIchiran;
    @JsonProperty("btnAtenaKensaku")
    private ButtonDialog btnAtenaKensaku;
    @JsonProperty("btnZenkaiFukusha")
    private Button btnZenkaiFukusha;
    @JsonProperty("txtJigyoshaCode")
    private TextBox txtJigyoshaCode;
    @JsonProperty("btnJigyoshaGuide")
    private ButtonDialog btnJigyoshaGuide;
    @JsonProperty("txtJigyoshaName")
    private TextBox txtJigyoshaName;
    @JsonProperty("ddlShinseiKankeisha")
    private DropDownList ddlShinseiKankeisha;
    @JsonProperty("txtShimei")
    private TextBox txtShimei;
    @JsonProperty("txtKanaShimei")
    private TextBox txtKanaShimei;
    @JsonProperty("txtHonninKankeisei")
    private TextBox txtHonninKankeisei;
    @JsonProperty("radKannaiKangai")
    private RadioButton radKannaiKangai;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("ccdChoikiInput")
    private ChoikiInputDiv ccdChoikiInput;
    @JsonProperty("ccdZenkokuJushoInput")
    private ZenkokuJushoInputDiv ccdZenkokuJushoInput;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnShikibetsuCode")
    private RString hdnShikibetsuCode;
    @JsonProperty("hdnShimei")
    private RString hdnShimei;
    @JsonProperty("hdnKanaShimei")
    private RString hdnKanaShimei;
    @JsonProperty("hdnTsudukigara")
    private RString hdnTsudukigara;
    @JsonProperty("hdnYubinNo")
    private RString hdnYubinNo;
    @JsonProperty("hdnJusho")
    private RString hdnJusho;
    @JsonProperty("hdnTelNo")
    private RString hdnTelNo;
    @JsonProperty("hdnGyomuCode")
    private RString hdnGyomuCode;
    @JsonProperty("hdnSerchYusenKubun")
    private RString hdnSerchYusenKubun;
    @JsonProperty("hdnKeyDialog")
    private RString hdnKeyDialog;
    @JsonProperty("hdnKeyAgeArrivalDay")
    private RString hdnKeyAgeArrivalDay;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
 /*
     * getddlTodokledeDaikoKubun
     * @return ddlTodokledeDaikoKubun
     */
    @JsonProperty("ddlTodokledeDaikoKubun")
    @Override
    public DropDownList getDdlTodokledeDaikoKubun() {
        return ddlTodokledeDaikoKubun;
    }

    /*
     * setddlTodokledeDaikoKubun
     * @param ddlTodokledeDaikoKubun ddlTodokledeDaikoKubun
     */
    @JsonProperty("ddlTodokledeDaikoKubun")
    @Override
    public void setDdlTodokledeDaikoKubun(DropDownList ddlTodokledeDaikoKubun) {
        this.ddlTodokledeDaikoKubun = ddlTodokledeDaikoKubun;
    }

    /*
     * getbtnSetaiIchiran
     * @return btnSetaiIchiran
     */
    @JsonProperty("btnSetaiIchiran")
    public ButtonDialog getBtnSetaiIchiran() {
        return btnSetaiIchiran;
    }

    /*
     * setbtnSetaiIchiran
     * @param btnSetaiIchiran btnSetaiIchiran
     */
    @JsonProperty("btnSetaiIchiran")
    public void setBtnSetaiIchiran(ButtonDialog btnSetaiIchiran) {
        this.btnSetaiIchiran = btnSetaiIchiran;
    }

    /*
     * getbtnAtenaKensaku
     * @return btnAtenaKensaku
     */
    @JsonProperty("btnAtenaKensaku")
    public ButtonDialog getBtnAtenaKensaku() {
        return btnAtenaKensaku;
    }

    /*
     * setbtnAtenaKensaku
     * @param btnAtenaKensaku btnAtenaKensaku
     */
    @JsonProperty("btnAtenaKensaku")
    public void setBtnAtenaKensaku(ButtonDialog btnAtenaKensaku) {
        this.btnAtenaKensaku = btnAtenaKensaku;
    }

    /*
     * getbtnZenkaiFukusha
     * @return btnZenkaiFukusha
     */
    @JsonProperty("btnZenkaiFukusha")
    public Button getBtnZenkaiFukusha() {
        return btnZenkaiFukusha;
    }

    /*
     * setbtnZenkaiFukusha
     * @param btnZenkaiFukusha btnZenkaiFukusha
     */
    @JsonProperty("btnZenkaiFukusha")
    public void setBtnZenkaiFukusha(Button btnZenkaiFukusha) {
        this.btnZenkaiFukusha = btnZenkaiFukusha;
    }

    /*
     * gettxtJigyoshaCode
     * @return txtJigyoshaCode
     */
    @JsonProperty("txtJigyoshaCode")
    public TextBox getTxtJigyoshaCode() {
        return txtJigyoshaCode;
    }

    /*
     * settxtJigyoshaCode
     * @param txtJigyoshaCode txtJigyoshaCode
     */
    @JsonProperty("txtJigyoshaCode")
    @Override
    public void setTxtJigyoshaCode(TextBox txtJigyoshaCode) {
        this.txtJigyoshaCode = txtJigyoshaCode;
    }

    /*
     * getbtnJigyoshaGuide
     * @return btnJigyoshaGuide
     */
    @JsonProperty("btnJigyoshaGuide")
    public ButtonDialog getBtnJigyoshaGuide() {
        return btnJigyoshaGuide;
    }

    /*
     * setbtnJigyoshaGuide
     * @param btnJigyoshaGuide btnJigyoshaGuide
     */
    @JsonProperty("btnJigyoshaGuide")
    public void setBtnJigyoshaGuide(ButtonDialog btnJigyoshaGuide) {
        this.btnJigyoshaGuide = btnJigyoshaGuide;
    }

    /*
     * gettxtJigyoshaName
     * @return txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    /*
     * settxtJigyoshaName
     * @param txtJigyoshaName txtJigyoshaName
     */
    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName = txtJigyoshaName;
    }

    /*
     * getddlShinseiKankeisha
     * @return ddlShinseiKankeisha
     */
    @JsonProperty("ddlShinseiKankeisha")
    @Override
    public DropDownList getDdlShinseiKankeisha() {
        return ddlShinseiKankeisha;
    }

    /*
     * setddlShinseiKankeisha
     * @param ddlShinseiKankeisha ddlShinseiKankeisha
     */
    @JsonProperty("ddlShinseiKankeisha")
    @Override
    public void setDdlShinseiKankeisha(DropDownList ddlShinseiKankeisha) {
        this.ddlShinseiKankeisha = ddlShinseiKankeisha;
    }

    /*
     * gettxtShimei
     * @return txtShimei
     */
    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    /*
     * settxtShimei
     * @param txtShimei txtShimei
     */
    @JsonProperty("txtShimei")
    @Override
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei = txtShimei;
    }

    /*
     * gettxtKanaShimei
     * @return txtKanaShimei
     */
    @JsonProperty("txtKanaShimei")
    public TextBox getTxtKanaShimei() {
        return txtKanaShimei;
    }

    /*
     * settxtKanaShimei
     * @param txtKanaShimei txtKanaShimei
     */
    @JsonProperty("txtKanaShimei")
    @Override
    public void setTxtKanaShimei(TextBox txtKanaShimei) {
        this.txtKanaShimei = txtKanaShimei;
    }

    /*
     * gettxtHonninKankeisei
     * @return txtHonninKankeisei
     */
    @JsonProperty("txtHonninKankeisei")
    public TextBox getTxtHonninKankeisei() {
        return txtHonninKankeisei;
    }

    /*
     * settxtHonninKankeisei
     * @param txtHonninKankeisei txtHonninKankeisei
     */
    @JsonProperty("txtHonninKankeisei")
    @Override
    public void setTxtHonninKankeisei(TextBox txtHonninKankeisei) {
        this.txtHonninKankeisei = txtHonninKankeisei;
    }

    /*
     * getradKannaiKangai
     * @return radKannaiKangai
     */
    @JsonProperty("radKannaiKangai")
    @Override
    public RadioButton getRadKannaiKangai() {
        return radKannaiKangai;
    }

    /*
     * setradKannaiKangai
     * @param radKannaiKangai radKannaiKangai
     */
    @JsonProperty("radKannaiKangai")
    public void setRadKannaiKangai(RadioButton radKannaiKangai) {
        this.radKannaiKangai = radKannaiKangai;
    }

    /*
     * gettxtTelNo
     * @return txtTelNo
     */
    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    /*
     * settxtTelNo
     * @param txtTelNo txtTelNo
     */
    @JsonProperty("txtTelNo")
    @Override
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo = txtTelNo;
    }

    /*
     * gettxtYubinNo
     * @return txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    /*
     * settxtYubinNo
     * @param txtYubinNo txtYubinNo
     */
    @JsonProperty("txtYubinNo")
    @Override
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo = txtYubinNo;
    }

    /*
     * getccdChoikiInput
     * @return ccdChoikiInput
     */
    @JsonProperty("ccdChoikiInput")
    @Override
    public IChoikiInputDiv getCcdChoikiInput() {
        return ccdChoikiInput;
    }

    /*
     * getccdZenkokuJushoInput
     * @return ccdZenkokuJushoInput
     */
    @JsonProperty("ccdZenkokuJushoInput")
    @Override
    public IZenkokuJushoInputDiv getCcdZenkokuJushoInput() {
        return ccdZenkokuJushoInput;
    }

    /*
     * gethdnShinseishoKanriNo
     * @return hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    /*
     * sethdnShinseishoKanriNo
     * @param hdnShinseishoKanriNo hdnShinseishoKanriNo
     */
    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo = hdnShinseishoKanriNo;
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
     * gethdnShimei
     * @return hdnShimei
     */
    @JsonProperty("hdnShimei")
    public RString getHdnShimei() {
        return hdnShimei;
    }

    /*
     * sethdnShimei
     * @param hdnShimei hdnShimei
     */
    @JsonProperty("hdnShimei")
    public void setHdnShimei(RString hdnShimei) {
        this.hdnShimei = hdnShimei;
    }

    /*
     * gethdnKanaShimei
     * @return hdnKanaShimei
     */
    @JsonProperty("hdnKanaShimei")
    public RString getHdnKanaShimei() {
        return hdnKanaShimei;
    }

    /*
     * sethdnKanaShimei
     * @param hdnKanaShimei hdnKanaShimei
     */
    @JsonProperty("hdnKanaShimei")
    public void setHdnKanaShimei(RString hdnKanaShimei) {
        this.hdnKanaShimei = hdnKanaShimei;
    }

    /*
     * gethdnTsudukigara
     * @return hdnTsudukigara
     */
    @JsonProperty("hdnTsudukigara")
    public RString getHdnTsudukigara() {
        return hdnTsudukigara;
    }

    /*
     * sethdnTsudukigara
     * @param hdnTsudukigara hdnTsudukigara
     */
    @JsonProperty("hdnTsudukigara")
    public void setHdnTsudukigara(RString hdnTsudukigara) {
        this.hdnTsudukigara = hdnTsudukigara;
    }

    /*
     * gethdnYubinNo
     * @return hdnYubinNo
     */
    @JsonProperty("hdnYubinNo")
    public RString getHdnYubinNo() {
        return hdnYubinNo;
    }

    /*
     * sethdnYubinNo
     * @param hdnYubinNo hdnYubinNo
     */
    @JsonProperty("hdnYubinNo")
    public void setHdnYubinNo(RString hdnYubinNo) {
        this.hdnYubinNo = hdnYubinNo;
    }

    /*
     * gethdnJusho
     * @return hdnJusho
     */
    @JsonProperty("hdnJusho")
    public RString getHdnJusho() {
        return hdnJusho;
    }

    /*
     * sethdnJusho
     * @param hdnJusho hdnJusho
     */
    @JsonProperty("hdnJusho")
    public void setHdnJusho(RString hdnJusho) {
        this.hdnJusho = hdnJusho;
    }

    /*
     * gethdnTelNo
     * @return hdnTelNo
     */
    @JsonProperty("hdnTelNo")
    public RString getHdnTelNo() {
        return hdnTelNo;
    }

    /*
     * sethdnTelNo
     * @param hdnTelNo hdnTelNo
     */
    @JsonProperty("hdnTelNo")
    public void setHdnTelNo(RString hdnTelNo) {
        this.hdnTelNo = hdnTelNo;
    }

    /*
     * gethdnGyomuCode
     * @return hdnGyomuCode
     */
    @JsonProperty("hdnGyomuCode")
    public RString getHdnGyomuCode() {
        return hdnGyomuCode;
    }

    /*
     * sethdnGyomuCode
     * @param hdnGyomuCode hdnGyomuCode
     */
    @JsonProperty("hdnGyomuCode")
    public void setHdnGyomuCode(RString hdnGyomuCode) {
        this.hdnGyomuCode = hdnGyomuCode;
    }

    /*
     * gethdnSerchYusenKubun
     * @return hdnSerchYusenKubun
     */
    @JsonProperty("hdnSerchYusenKubun")
    public RString getHdnSerchYusenKubun() {
        return hdnSerchYusenKubun;
    }

    /*
     * sethdnSerchYusenKubun
     * @param hdnSerchYusenKubun hdnSerchYusenKubun
     */
    @JsonProperty("hdnSerchYusenKubun")
    public void setHdnSerchYusenKubun(RString hdnSerchYusenKubun) {
        this.hdnSerchYusenKubun = hdnSerchYusenKubun;
    }

    /*
     * gethdnKeyDialog
     * @return hdnKeyDialog
     */
    @JsonProperty("hdnKeyDialog")
    public RString getHdnKeyDialog() {
        return hdnKeyDialog;
    }

    /*
     * sethdnKeyDialog
     * @param hdnKeyDialog hdnKeyDialog
     */
    @JsonProperty("hdnKeyDialog")
    public void setHdnKeyDialog(RString hdnKeyDialog) {
        this.hdnKeyDialog = hdnKeyDialog;
    }

    /*
     * gethdnKeyAgeArrivalDay
     * @return hdnKeyAgeArrivalDay
     */
    @JsonProperty("hdnKeyAgeArrivalDay")
    public RString getHdnKeyAgeArrivalDay() {
        return hdnKeyAgeArrivalDay;
    }

    /*
     * sethdnKeyAgeArrivalDay
     * @param hdnKeyAgeArrivalDay hdnKeyAgeArrivalDay
     */
    @JsonProperty("hdnKeyAgeArrivalDay")
    public void setHdnKeyAgeArrivalDay(RString hdnKeyAgeArrivalDay) {
        this.hdnKeyAgeArrivalDay = hdnKeyAgeArrivalDay;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        InputMode("InputMode"),
        ShokaiMode("ShokaiMode");

        private final String name;

        private ShoriType(final String name) {
            this.name = name;
        }

        public static ShoriType getEnum(String str) {
            ShoriType[] enumArray = ShoriType.values();

            for (ShoriType enumStr : enumArray) {
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

    public ShoriType getMode_ShoriType() {
        return (ShoriType) _CommonChildDivModeUtil.getMode(this.modes, ShoriType.class);
    }

    public void setMode_ShoriType(ShoriType value) {
        _CommonChildDivModeUtil.setMode(this.modes, ShoriType.class, value);
    }

    public static enum AtenaType implements ICommonChildDivMode {

        AtenaMode("AtenaMode"),
        AtenaNonMode("AtenaNonMode");

        private final String name;

        private AtenaType(final String name) {
            this.name = name;
        }

        public static AtenaType getEnum(String str) {
            AtenaType[] enumArray = AtenaType.values();

            for (AtenaType enumStr : enumArray) {
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

    public AtenaType getMode_AtenaType() {
        return (AtenaType) _CommonChildDivModeUtil.getMode(this.modes, AtenaType.class);
    }

    public void setMode_AtenaType(AtenaType value) {
        _CommonChildDivModeUtil.setMode(this.modes, AtenaType.class, value);
    }

    public static enum DisplayType implements ICommonChildDivMode {

        管内("管内"),
        管外("管外");

        private final String name;

        private DisplayType(final String name) {
            this.name = name;
        }

        public static DisplayType getEnum(String str) {
            DisplayType[] enumArray = DisplayType.values();

            for (DisplayType enumStr : enumArray) {
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

    public DisplayType getMode_DisplayType() {
        return (DisplayType) _CommonChildDivModeUtil.getMode(this.modes, DisplayType.class);
    }

    public void setMode_DisplayType(DisplayType value) {
        _CommonChildDivModeUtil.setMode(this.modes, DisplayType.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 共通子DIVの初期化処理です。
     *
     * @param model NinteiShinseiTodokedeshaDataPassModel
     */
    @Override
    public void initialize(NinteiShinseiTodokedeshaDataPassModel model) {
        new NinteiShinseiTodokedeshaHandler(this).initialize(model);
    }

    /**
     * 状態の設定すます。
     *
     * @param mode mode
     */
    @Override
    public void set状態(RString mode) {
        if (NinteiShinseiTodokedeshaDiv.ShoriType.getEnum(mode.toString()) != null) {
            setMode_ShoriType(NinteiShinseiTodokedeshaDiv.ShoriType.getEnum(mode.toString()));
        } else if (NinteiShinseiTodokedeshaDiv.AtenaType.getEnum(mode.toString()) != null) {
            setMode_AtenaType(NinteiShinseiTodokedeshaDiv.AtenaType.getEnum(mode.toString()));
        } else if (NinteiShinseiTodokedeshaDiv.DisplayType.getEnum(mode.toString()) != null) {
            setMode_DisplayType(NinteiShinseiTodokedeshaDiv.DisplayType.getEnum(mode.toString()));
        }
    }

    /**
     * 画面一覧内容を取得。
     *
     * @return NinteiShinseiTodokedeshaNaiyo NinteiShinseiTodokedeshaNaiyo
     */
    @Override
    public NinteiShinseiTodokedeshaNaiyo get一覧内容() {
        return new NinteiShinseiTodokedeshaHandler(this).get一覧内容();
    }
}
