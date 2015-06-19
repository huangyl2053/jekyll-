package jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiShinseiTodokedesha;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;

/**
 * NinteiShinseiTodokedesha のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinseiTodokedeshaDiv extends Panel implements INinteiShinseiTodokedeshaDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
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
    private TextBoxCode txtHonninKankeisei;
    @JsonProperty("lblHonninKankeiseiMei")
    private Label lblHonninKankeiseiMei;
    @JsonProperty("txtYubinNo")
    private TextBoxYubinNo txtYubinNo;
    @JsonProperty("txtTelNo")
    private TextBoxTelNo txtTelNo;
    @JsonProperty("txtJusho")
    private TextBoxJusho txtJusho;
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
    @JsonProperty("ddlTodokledeDaikoKubun")
    public DropDownList getDdlTodokledeDaikoKubun() {
        return ddlTodokledeDaikoKubun;
    }

    @JsonProperty("ddlTodokledeDaikoKubun")
    public void setDdlTodokledeDaikoKubun(DropDownList ddlTodokledeDaikoKubun) {
        this.ddlTodokledeDaikoKubun=ddlTodokledeDaikoKubun;
    }

    @JsonProperty("btnSetaiIchiran")
    public ButtonDialog getBtnSetaiIchiran() {
        return btnSetaiIchiran;
    }

    @JsonProperty("btnSetaiIchiran")
    public void setBtnSetaiIchiran(ButtonDialog btnSetaiIchiran) {
        this.btnSetaiIchiran=btnSetaiIchiran;
    }

    @JsonProperty("btnAtenaKensaku")
    public ButtonDialog getBtnAtenaKensaku() {
        return btnAtenaKensaku;
    }

    @JsonProperty("btnAtenaKensaku")
    public void setBtnAtenaKensaku(ButtonDialog btnAtenaKensaku) {
        this.btnAtenaKensaku=btnAtenaKensaku;
    }

    @JsonProperty("btnZenkaiFukusha")
    public Button getBtnZenkaiFukusha() {
        return btnZenkaiFukusha;
    }

    @JsonProperty("btnZenkaiFukusha")
    public void setBtnZenkaiFukusha(Button btnZenkaiFukusha) {
        this.btnZenkaiFukusha=btnZenkaiFukusha;
    }

    @JsonProperty("txtJigyoshaCode")
    public TextBox getTxtJigyoshaCode() {
        return txtJigyoshaCode;
    }

    @JsonProperty("txtJigyoshaCode")
    public void setTxtJigyoshaCode(TextBox txtJigyoshaCode) {
        this.txtJigyoshaCode=txtJigyoshaCode;
    }

    @JsonProperty("btnJigyoshaGuide")
    public ButtonDialog getBtnJigyoshaGuide() {
        return btnJigyoshaGuide;
    }

    @JsonProperty("btnJigyoshaGuide")
    public void setBtnJigyoshaGuide(ButtonDialog btnJigyoshaGuide) {
        this.btnJigyoshaGuide=btnJigyoshaGuide;
    }

    @JsonProperty("txtJigyoshaName")
    public TextBox getTxtJigyoshaName() {
        return txtJigyoshaName;
    }

    @JsonProperty("txtJigyoshaName")
    public void setTxtJigyoshaName(TextBox txtJigyoshaName) {
        this.txtJigyoshaName=txtJigyoshaName;
    }

    @JsonProperty("ddlShinseiKankeisha")
    public DropDownList getDdlShinseiKankeisha() {
        return ddlShinseiKankeisha;
    }

    @JsonProperty("ddlShinseiKankeisha")
    public void setDdlShinseiKankeisha(DropDownList ddlShinseiKankeisha) {
        this.ddlShinseiKankeisha=ddlShinseiKankeisha;
    }

    @JsonProperty("txtShimei")
    public TextBox getTxtShimei() {
        return txtShimei;
    }

    @JsonProperty("txtShimei")
    public void setTxtShimei(TextBox txtShimei) {
        this.txtShimei=txtShimei;
    }

    @JsonProperty("txtKanaShimei")
    public TextBox getTxtKanaShimei() {
        return txtKanaShimei;
    }

    @JsonProperty("txtKanaShimei")
    public void setTxtKanaShimei(TextBox txtKanaShimei) {
        this.txtKanaShimei=txtKanaShimei;
    }

    @JsonProperty("txtHonninKankeisei")
    public TextBoxCode getTxtHonninKankeisei() {
        return txtHonninKankeisei;
    }

    @JsonProperty("txtHonninKankeisei")
    public void setTxtHonninKankeisei(TextBoxCode txtHonninKankeisei) {
        this.txtHonninKankeisei=txtHonninKankeisei;
    }

    @JsonProperty("lblHonninKankeiseiMei")
    public Label getLblHonninKankeiseiMei() {
        return lblHonninKankeiseiMei;
    }

    @JsonProperty("lblHonninKankeiseiMei")
    public void setLblHonninKankeiseiMei(Label lblHonninKankeiseiMei) {
        this.lblHonninKankeiseiMei=lblHonninKankeiseiMei;
    }

    @JsonProperty("txtYubinNo")
    public TextBoxYubinNo getTxtYubinNo() {
        return txtYubinNo;
    }

    @JsonProperty("txtYubinNo")
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.txtYubinNo=txtYubinNo;
    }

    @JsonProperty("txtTelNo")
    public TextBoxTelNo getTxtTelNo() {
        return txtTelNo;
    }

    @JsonProperty("txtTelNo")
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.txtTelNo=txtTelNo;
    }

    @JsonProperty("txtJusho")
    public TextBoxJusho getTxtJusho() {
        return txtJusho;
    }

    @JsonProperty("txtJusho")
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.txtJusho=txtJusho;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo=hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnShikibetsuCode")
    public RString getHdnShikibetsuCode() {
        return hdnShikibetsuCode;
    }

    @JsonProperty("hdnShikibetsuCode")
    public void setHdnShikibetsuCode(RString hdnShikibetsuCode) {
        this.hdnShikibetsuCode=hdnShikibetsuCode;
    }

    @JsonProperty("hdnShimei")
    public RString getHdnShimei() {
        return hdnShimei;
    }

    @JsonProperty("hdnShimei")
    public void setHdnShimei(RString hdnShimei) {
        this.hdnShimei=hdnShimei;
    }

    @JsonProperty("hdnKanaShimei")
    public RString getHdnKanaShimei() {
        return hdnKanaShimei;
    }

    @JsonProperty("hdnKanaShimei")
    public void setHdnKanaShimei(RString hdnKanaShimei) {
        this.hdnKanaShimei=hdnKanaShimei;
    }

    @JsonProperty("hdnTsudukigara")
    public RString getHdnTsudukigara() {
        return hdnTsudukigara;
    }

    @JsonProperty("hdnTsudukigara")
    public void setHdnTsudukigara(RString hdnTsudukigara) {
        this.hdnTsudukigara=hdnTsudukigara;
    }

    @JsonProperty("hdnYubinNo")
    public RString getHdnYubinNo() {
        return hdnYubinNo;
    }

    @JsonProperty("hdnYubinNo")
    public void setHdnYubinNo(RString hdnYubinNo) {
        this.hdnYubinNo=hdnYubinNo;
    }

    @JsonProperty("hdnJusho")
    public RString getHdnJusho() {
        return hdnJusho;
    }

    @JsonProperty("hdnJusho")
    public void setHdnJusho(RString hdnJusho) {
        this.hdnJusho=hdnJusho;
    }

    @JsonProperty("hdnTelNo")
    public RString getHdnTelNo() {
        return hdnTelNo;
    }

    @JsonProperty("hdnTelNo")
    public void setHdnTelNo(RString hdnTelNo) {
        this.hdnTelNo=hdnTelNo;
    }

    @JsonProperty("hdnGyomuCode")
    public RString getHdnGyomuCode() {
        return hdnGyomuCode;
    }

    @JsonProperty("hdnGyomuCode")
    public void setHdnGyomuCode(RString hdnGyomuCode) {
        this.hdnGyomuCode=hdnGyomuCode;
    }

    @JsonProperty("hdnSerchYusenKubun")
    public RString getHdnSerchYusenKubun() {
        return hdnSerchYusenKubun;
    }

    @JsonProperty("hdnSerchYusenKubun")
    public void setHdnSerchYusenKubun(RString hdnSerchYusenKubun) {
        this.hdnSerchYusenKubun=hdnSerchYusenKubun;
    }

    @JsonProperty("hdnKeyDialog")
    public RString getHdnKeyDialog() {
        return hdnKeyDialog;
    }

    @JsonProperty("hdnKeyDialog")
    public void setHdnKeyDialog(RString hdnKeyDialog) {
        this.hdnKeyDialog=hdnKeyDialog;
    }

    @JsonProperty("hdnKeyAgeArrivalDay")
    public RString getHdnKeyAgeArrivalDay() {
        return hdnKeyAgeArrivalDay;
    }

    @JsonProperty("hdnKeyAgeArrivalDay")
    public void setHdnKeyAgeArrivalDay(RString hdnKeyAgeArrivalDay) {
        this.hdnKeyAgeArrivalDay=hdnKeyAgeArrivalDay;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        InputMode("InputMode"),
        ShgokaiMode("ShgokaiMode");

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
        return (ShoriType) _CommonChildDivModeUtil.getMode( this.modes, ShoriType.class );
    }

    public void setMode_ShoriType( ShoriType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ShoriType.class , value );
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
        return (AtenaType) _CommonChildDivModeUtil.getMode( this.modes, AtenaType.class );
    }

    public void setMode_AtenaType( AtenaType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, AtenaType.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @JsonIgnore
    @Override
    public RString get申請届出代行区分コード() {
        return ddlTodokledeDaikoKubun.getSelectedValue();
    }

    @JsonIgnore
    @Override
    public void set申請届出代行区分コード(RString 申請届出代行区分コード) {
        ddlTodokledeDaikoKubun.setSelectedValue(申請届出代行区分コード);
    }

    @JsonIgnore
    @Override
    public RString get申請届出代行事業者番号() {
        return txtJigyoshaCode.getValue();
    }

    @JsonIgnore
    @Override
    public void set申請届出代行事業者番号(RString 申請届出代行事業者番号) {
        txtJigyoshaCode.setValue(申請届出代行事業者番号);
    }

    @JsonIgnore
    @Override
    public RString get事業者区分() {
        return ddlShinseiKankeisha.getSelectedValue();
    }

    @JsonIgnore
    @Override
    public void set事業者区分(RString 事業者区分) {
        ddlShinseiKankeisha.setSelectedValue(事業者区分);
    }

    @JsonIgnore
    @Override
    public RString get申請届出者氏名() {
        return txtShimei.getValue();
    }

    @JsonIgnore
    @Override
    public void set申請届出者氏名(RString 申請届出者氏名) {
        txtShimei.setValue(申請届出者氏名);
    }

    @JsonIgnore
    @Override
    public RString get申請届出者氏名カナ() {
        return txtKanaShimei.getValue();
    }

    @JsonIgnore
    @Override
    public void set申請届出者氏名カナ(RString 申請届出者氏名カナ) {
        txtKanaShimei.setValue(申請届出者氏名カナ);
    }

    @JsonIgnore
    @Override
    public RString get申請届出者続柄コード() {
        return txtHonninKankeisei.getValue();
    }

    @JsonIgnore
    @Override
    public void set申請届出者続柄コード(RString 申請届出者続柄コード) {
        txtHonninKankeisei.setValue(申請届出者続柄コード);
    }

    @JsonIgnore
    @Override
    public YubinNo get申請届出者郵便番号() {
        return txtYubinNo.getValue();
    }

    @JsonIgnore
    @Override
    public void set申請届出者郵便番号(YubinNo 申請届出者郵便番号) {
        txtYubinNo.setValue(申請届出者郵便番号);
    }

    @JsonIgnore
    @Override
    public TelNo get申請届出者電話番号() {
        return txtTelNo.getDomain();
    }

    @JsonIgnore
    @Override
    public void set申請届出者電話番号(TelNo 申請届出者電話番号) {
        txtTelNo.setDomain(申請届出者電話番号);
    }

    @JsonIgnore
    @Override
    public AtenaJusho get申請届出者住所() {
        return txtJusho.getDomain();
    }

    @JsonIgnore
    @Override
    public void set申請届出者住所(AtenaJusho 申請届出者住所) {
        txtJusho.setDomain(申請届出者住所);
    }

    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void onClickBtnZenkaiFukusha() {
        getHandler().onClickBtnZenkaiFukusha();
    }

    @Override
    public void onChangeDdlTodokedeDaikoKubun() {
        getHandler().onChangeDdlTodokedeDaikoKubun();
    }

    @JsonIgnore
    private NinteiShinseiTodokedeshaHandler getHandler() {
        return new NinteiShinseiTodokedeshaHandler(this);
    }

    /**
     * 共有子Div情報を全てクリアします。
     */
    public void clear() {
        getHandler().clear();
    }

    /**
     * 共有子Div情報をロードします。
     */
    public void load() {
        getHandler().load();
    }

}
