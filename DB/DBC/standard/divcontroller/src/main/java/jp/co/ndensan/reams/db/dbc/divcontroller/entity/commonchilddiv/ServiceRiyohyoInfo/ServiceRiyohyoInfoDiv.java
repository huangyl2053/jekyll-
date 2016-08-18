package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceRiyohyoInfo;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv.IServiceCodeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDiv.ServiceCodeInputCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.IServiceTypeInputCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDiv.ServiceTypeInputCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;

/**
 * ServiceRiyohyoInfo のクラスファイル
 *
 * @reamsid_L DBC-1930-050 cuilin
 */
public class ServiceRiyohyoInfoDiv extends Panel implements IServiceRiyohyoInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-07-28_11-34-20">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtTodokedeYMD")
    private TextBoxDate txtTodokedeYMD;
    @JsonProperty("txtTekiyoKikan")
    private TextBoxDateRange txtTekiyoKikan;
    @JsonProperty("txtKubunShikyuGendogaku")
    private TextBoxNum txtKubunShikyuGendogaku;
    @JsonProperty("txtGendoKanriKikan")
    private TextBoxDateRange txtGendoKanriKikan;
    @JsonProperty("txtRiyoYM")
    private TextBoxDate txtRiyoYM;
    @JsonProperty("chkZanteiKubun")
    private CheckBoxList chkZanteiKubun;
    @JsonProperty("ddlKoshinKbn")
    private DropDownList ddlKoshinKbn;
    @JsonProperty("txtKoshinYMD")
    private TextBoxDate txtKoshinYMD;
    @JsonProperty("txtSofuYM")
    private TextBoxDate txtSofuYM;
    @JsonProperty("btnShowShuruiGendogaku")
    private ButtonDialog btnShowShuruiGendogaku;
    @JsonProperty("btnZengetsuCopy")
    private Button btnZengetsuCopy;
    @JsonProperty("ServiceRiyohyoBeppyoRiyoNissu")
    private ServiceRiyohyoBeppyoRiyoNissuDiv ServiceRiyohyoBeppyoRiyoNissu;
    @JsonProperty("ServiceRiyohyoBeppyoList")
    private ServiceRiyohyoBeppyoListDiv ServiceRiyohyoBeppyoList;
    @JsonProperty("ServiceRiyohyoBeppyoJigyoshaServiceInput")
    private ServiceRiyohyoBeppyoJigyoshaServiceInputDiv ServiceRiyohyoBeppyoJigyoshaServiceInput;
    @JsonProperty("ServiceRiyohyoBeppyoMeisai")
    private ServiceRiyohyoBeppyoMeisaiDiv ServiceRiyohyoBeppyoMeisai;
    @JsonProperty("ServiceRiyohyoBeppyoGokei")
    private ServiceRiyohyoBeppyoGokeiDiv ServiceRiyohyoBeppyoGokei;
    @JsonProperty("ServiceRiyohyoBeppyoFooter")
    private ServiceRiyohyoBeppyoFooterDiv ServiceRiyohyoBeppyoFooter;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtTodokedeYMD
     * @return txtTodokedeYMD
     */
    @JsonProperty("txtTodokedeYMD")
    public TextBoxDate getTxtTodokedeYMD() {
        return txtTodokedeYMD;
    }

    /*
     * settxtTodokedeYMD
     * @param txtTodokedeYMD txtTodokedeYMD
     */
    @JsonProperty("txtTodokedeYMD")
    public void setTxtTodokedeYMD(TextBoxDate txtTodokedeYMD) {
        this.txtTodokedeYMD = txtTodokedeYMD;
    }

    /*
     * gettxtTekiyoKikan
     * @return txtTekiyoKikan
     */
    @JsonProperty("txtTekiyoKikan")
    public TextBoxDateRange getTxtTekiyoKikan() {
        return txtTekiyoKikan;
    }

    /*
     * settxtTekiyoKikan
     * @param txtTekiyoKikan txtTekiyoKikan
     */
    @JsonProperty("txtTekiyoKikan")
    public void setTxtTekiyoKikan(TextBoxDateRange txtTekiyoKikan) {
        this.txtTekiyoKikan = txtTekiyoKikan;
    }

    /*
     * gettxtKubunShikyuGendogaku
     * @return txtKubunShikyuGendogaku
     */
    @JsonProperty("txtKubunShikyuGendogaku")
    public TextBoxNum getTxtKubunShikyuGendogaku() {
        return txtKubunShikyuGendogaku;
    }

    /*
     * settxtKubunShikyuGendogaku
     * @param txtKubunShikyuGendogaku txtKubunShikyuGendogaku
     */
    @JsonProperty("txtKubunShikyuGendogaku")
    public void setTxtKubunShikyuGendogaku(TextBoxNum txtKubunShikyuGendogaku) {
        this.txtKubunShikyuGendogaku = txtKubunShikyuGendogaku;
    }

    /*
     * gettxtGendoKanriKikan
     * @return txtGendoKanriKikan
     */
    @JsonProperty("txtGendoKanriKikan")
    public TextBoxDateRange getTxtGendoKanriKikan() {
        return txtGendoKanriKikan;
    }

    /*
     * settxtGendoKanriKikan
     * @param txtGendoKanriKikan txtGendoKanriKikan
     */
    @JsonProperty("txtGendoKanriKikan")
    public void setTxtGendoKanriKikan(TextBoxDateRange txtGendoKanriKikan) {
        this.txtGendoKanriKikan = txtGendoKanriKikan;
    }

    /*
     * gettxtRiyoYM
     * @return txtRiyoYM
     */
    @JsonProperty("txtRiyoYM")
    public TextBoxDate getTxtRiyoYM() {
        return txtRiyoYM;
    }

    /*
     * settxtRiyoYM
     * @param txtRiyoYM txtRiyoYM
     */
    @JsonProperty("txtRiyoYM")
    public void setTxtRiyoYM(TextBoxDate txtRiyoYM) {
        this.txtRiyoYM = txtRiyoYM;
    }

    /*
     * getchkZanteiKubun
     * @return chkZanteiKubun
     */
    @JsonProperty("chkZanteiKubun")
    public CheckBoxList getChkZanteiKubun() {
        return chkZanteiKubun;
    }

    /*
     * setchkZanteiKubun
     * @param chkZanteiKubun chkZanteiKubun
     */
    @JsonProperty("chkZanteiKubun")
    public void setChkZanteiKubun(CheckBoxList chkZanteiKubun) {
        this.chkZanteiKubun = chkZanteiKubun;
    }

    /*
     * getddlKoshinKbn
     * @return ddlKoshinKbn
     */
    @JsonProperty("ddlKoshinKbn")
    public DropDownList getDdlKoshinKbn() {
        return ddlKoshinKbn;
    }

    /*
     * setddlKoshinKbn
     * @param ddlKoshinKbn ddlKoshinKbn
     */
    @JsonProperty("ddlKoshinKbn")
    public void setDdlKoshinKbn(DropDownList ddlKoshinKbn) {
        this.ddlKoshinKbn = ddlKoshinKbn;
    }

    /*
     * gettxtKoshinYMD
     * @return txtKoshinYMD
     */
    @JsonProperty("txtKoshinYMD")
    public TextBoxDate getTxtKoshinYMD() {
        return txtKoshinYMD;
    }

    /*
     * settxtKoshinYMD
     * @param txtKoshinYMD txtKoshinYMD
     */
    @JsonProperty("txtKoshinYMD")
    public void setTxtKoshinYMD(TextBoxDate txtKoshinYMD) {
        this.txtKoshinYMD = txtKoshinYMD;
    }

    /*
     * gettxtSofuYM
     * @return txtSofuYM
     */
    @JsonProperty("txtSofuYM")
    public TextBoxDate getTxtSofuYM() {
        return txtSofuYM;
    }

    /*
     * settxtSofuYM
     * @param txtSofuYM txtSofuYM
     */
    @JsonProperty("txtSofuYM")
    public void setTxtSofuYM(TextBoxDate txtSofuYM) {
        this.txtSofuYM = txtSofuYM;
    }

    /*
     * getbtnShowShuruiGendogaku
     * @return btnShowShuruiGendogaku
     */
    @JsonProperty("btnShowShuruiGendogaku")
    public ButtonDialog getBtnShowShuruiGendogaku() {
        return btnShowShuruiGendogaku;
    }

    /*
     * setbtnShowShuruiGendogaku
     * @param btnShowShuruiGendogaku btnShowShuruiGendogaku
     */
    @JsonProperty("btnShowShuruiGendogaku")
    public void setBtnShowShuruiGendogaku(ButtonDialog btnShowShuruiGendogaku) {
        this.btnShowShuruiGendogaku = btnShowShuruiGendogaku;
    }

    /*
     * getbtnZengetsuCopy
     * @return btnZengetsuCopy
     */
    @JsonProperty("btnZengetsuCopy")
    public Button getBtnZengetsuCopy() {
        return btnZengetsuCopy;
    }

    /*
     * setbtnZengetsuCopy
     * @param btnZengetsuCopy btnZengetsuCopy
     */
    @JsonProperty("btnZengetsuCopy")
    public void setBtnZengetsuCopy(Button btnZengetsuCopy) {
        this.btnZengetsuCopy = btnZengetsuCopy;
    }

    /*
     * getServiceRiyohyoBeppyoRiyoNissu
     * @return ServiceRiyohyoBeppyoRiyoNissu
     */
    @JsonProperty("ServiceRiyohyoBeppyoRiyoNissu")
    public ServiceRiyohyoBeppyoRiyoNissuDiv getServiceRiyohyoBeppyoRiyoNissu() {
        return ServiceRiyohyoBeppyoRiyoNissu;
    }

    /*
     * setServiceRiyohyoBeppyoRiyoNissu
     * @param ServiceRiyohyoBeppyoRiyoNissu ServiceRiyohyoBeppyoRiyoNissu
     */
    @JsonProperty("ServiceRiyohyoBeppyoRiyoNissu")
    public void setServiceRiyohyoBeppyoRiyoNissu(ServiceRiyohyoBeppyoRiyoNissuDiv ServiceRiyohyoBeppyoRiyoNissu) {
        this.ServiceRiyohyoBeppyoRiyoNissu = ServiceRiyohyoBeppyoRiyoNissu;
    }

    /*
     * getServiceRiyohyoBeppyoList
     * @return ServiceRiyohyoBeppyoList
     */
    @JsonProperty("ServiceRiyohyoBeppyoList")
    public ServiceRiyohyoBeppyoListDiv getServiceRiyohyoBeppyoList() {
        return ServiceRiyohyoBeppyoList;
    }

    /*
     * setServiceRiyohyoBeppyoList
     * @param ServiceRiyohyoBeppyoList ServiceRiyohyoBeppyoList
     */
    @JsonProperty("ServiceRiyohyoBeppyoList")
    public void setServiceRiyohyoBeppyoList(ServiceRiyohyoBeppyoListDiv ServiceRiyohyoBeppyoList) {
        this.ServiceRiyohyoBeppyoList = ServiceRiyohyoBeppyoList;
    }

    /*
     * getServiceRiyohyoBeppyoJigyoshaServiceInput
     * @return ServiceRiyohyoBeppyoJigyoshaServiceInput
     */
    @JsonProperty("ServiceRiyohyoBeppyoJigyoshaServiceInput")
    public ServiceRiyohyoBeppyoJigyoshaServiceInputDiv getServiceRiyohyoBeppyoJigyoshaServiceInput() {
        return ServiceRiyohyoBeppyoJigyoshaServiceInput;
    }

    /*
     * setServiceRiyohyoBeppyoJigyoshaServiceInput
     * @param ServiceRiyohyoBeppyoJigyoshaServiceInput ServiceRiyohyoBeppyoJigyoshaServiceInput
     */
    @JsonProperty("ServiceRiyohyoBeppyoJigyoshaServiceInput")
    public void setServiceRiyohyoBeppyoJigyoshaServiceInput(ServiceRiyohyoBeppyoJigyoshaServiceInputDiv ServiceRiyohyoBeppyoJigyoshaServiceInput) {
        this.ServiceRiyohyoBeppyoJigyoshaServiceInput = ServiceRiyohyoBeppyoJigyoshaServiceInput;
    }

    /*
     * getServiceRiyohyoBeppyoMeisai
     * @return ServiceRiyohyoBeppyoMeisai
     */
    @JsonProperty("ServiceRiyohyoBeppyoMeisai")
    public ServiceRiyohyoBeppyoMeisaiDiv getServiceRiyohyoBeppyoMeisai() {
        return ServiceRiyohyoBeppyoMeisai;
    }

    /*
     * setServiceRiyohyoBeppyoMeisai
     * @param ServiceRiyohyoBeppyoMeisai ServiceRiyohyoBeppyoMeisai
     */
    @JsonProperty("ServiceRiyohyoBeppyoMeisai")
    public void setServiceRiyohyoBeppyoMeisai(ServiceRiyohyoBeppyoMeisaiDiv ServiceRiyohyoBeppyoMeisai) {
        this.ServiceRiyohyoBeppyoMeisai = ServiceRiyohyoBeppyoMeisai;
    }

    /*
     * getServiceRiyohyoBeppyoGokei
     * @return ServiceRiyohyoBeppyoGokei
     */
    @JsonProperty("ServiceRiyohyoBeppyoGokei")
    public ServiceRiyohyoBeppyoGokeiDiv getServiceRiyohyoBeppyoGokei() {
        return ServiceRiyohyoBeppyoGokei;
    }

    /*
     * setServiceRiyohyoBeppyoGokei
     * @param ServiceRiyohyoBeppyoGokei ServiceRiyohyoBeppyoGokei
     */
    @JsonProperty("ServiceRiyohyoBeppyoGokei")
    public void setServiceRiyohyoBeppyoGokei(ServiceRiyohyoBeppyoGokeiDiv ServiceRiyohyoBeppyoGokei) {
        this.ServiceRiyohyoBeppyoGokei = ServiceRiyohyoBeppyoGokei;
    }

    /*
     * getServiceRiyohyoBeppyoFooter
     * @return ServiceRiyohyoBeppyoFooter
     */
    @JsonProperty("ServiceRiyohyoBeppyoFooter")
    public ServiceRiyohyoBeppyoFooterDiv getServiceRiyohyoBeppyoFooter() {
        return ServiceRiyohyoBeppyoFooter;
    }

    /*
     * setServiceRiyohyoBeppyoFooter
     * @param ServiceRiyohyoBeppyoFooter ServiceRiyohyoBeppyoFooter
     */
    @JsonProperty("ServiceRiyohyoBeppyoFooter")
    public void setServiceRiyohyoBeppyoFooter(ServiceRiyohyoBeppyoFooterDiv ServiceRiyohyoBeppyoFooter) {
        this.ServiceRiyohyoBeppyoFooter = ServiceRiyohyoBeppyoFooter;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum KaigoType implements ICommonChildDivMode {

        kyotakuService("kyotakuService"),
        Sogojigyohi("Sogojigyohi");

        private final String name;

        private KaigoType(final String name) {
            this.name = name;
        }

        public static KaigoType getEnum(String str) {
            KaigoType[] enumArray = KaigoType.values();

            for (KaigoType enumStr : enumArray) {
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

    public KaigoType getMode_KaigoType() {
        return (KaigoType) _CommonChildDivModeUtil.getMode( this.modes, KaigoType.class );
    }

    public void setMode_KaigoType( KaigoType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, KaigoType.class , value );
    }

    public static enum GamenMode implements ICommonChildDivMode {

        TsuikaMode("TsuikaMode"),
        ShuseiMode("ShuseiMode"),
        SakujoMode("SakujoMode"),
        ShokaiMode("ShokaiMode");

        private final String name;

        private GamenMode(final String name) {
            this.name = name;
        }

        public static GamenMode getEnum(String str) {
            GamenMode[] enumArray = GamenMode.values();

            for (GamenMode enumStr : enumArray) {
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

    public GamenMode getMode_GamenMode() {
        return (GamenMode) _CommonChildDivModeUtil.getMode( this.modes, GamenMode.class );
    }

    public void setMode_GamenMode( GamenMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, GamenMode.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdJigyoshaInput() {
        return this.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdJigyoshaInput();
    }

    @JsonIgnore
    public IServiceCodeInputCommonChildDiv getCcdServiceCodeInput() {
        return this.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceCodeInput();
    }

    @JsonIgnore
    public IServiceTypeInputCommonChildDiv getCcdServiceTypeInput() {
        return this.getServiceRiyohyoBeppyoJigyoshaServiceInput().getCcdServiceTypeInput();
    }

    @JsonIgnore
    public Button getBtnBeppyoMeisaiKakutei() {
        return this.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnBeppyoMeisaiKakutei();
    }

    @JsonIgnore
    public void  setBtnBeppyoMeisaiKakutei(Button btnBeppyoMeisaiKakutei) {
        this.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().setBtnBeppyoMeisaiKakutei(btnBeppyoMeisaiKakutei);
    }

    @JsonIgnore
    public Button getBtnCalcMeisaiGokei() {
        return this.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisaiGokei();
    }

    @JsonIgnore
    public void  setBtnCalcMeisaiGokei(Button btnCalcMeisaiGokei) {
        this.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().setBtnCalcMeisaiGokei(btnCalcMeisaiGokei);
    }

    @JsonIgnore
    public Button getBtnCancelMeisaiInput() {
        return this.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCancelMeisaiInput();
    }

    @JsonIgnore
    public void  setBtnCancelMeisaiInput(Button btnCancelMeisaiInput) {
        this.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().setBtnCancelMeisaiInput(btnCancelMeisaiInput);
    }

    @JsonIgnore
    public Button getBtnCalcMeisai() {
        return this.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().getBtnCalcMeisai();
    }

    @JsonIgnore
    public void  setBtnCalcMeisai(Button btnCalcMeisai) {
        this.getServiceRiyohyoBeppyoMeisai().getServiceRiyohyoBeppyoMeisaiFooter().setBtnCalcMeisai(btnCalcMeisai);
    }

    @JsonIgnore
    public Button getBtnBeppyoGokeiKakutei() {
        return this.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnBeppyoGokeiKakutei();
    }

    @JsonIgnore
    public void  setBtnBeppyoGokeiKakutei(Button btnBeppyoGokeiKakutei) {
        this.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().setBtnBeppyoGokeiKakutei(btnBeppyoGokeiKakutei);
    }

    @JsonIgnore
    public Button getBtnCalcGokei() {
        return this.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCalcGokei();
    }

    @JsonIgnore
    public void  setBtnCalcGokei(Button btnCalcGokei) {
        this.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().setBtnCalcGokei(btnCalcGokei);
    }

    @JsonIgnore
    public Button getBtnCancelGokeiInput() {
        return this.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().getBtnCancelGokeiInput();
    }

    @JsonIgnore
    public void  setBtnCancelGokeiInput(Button btnCancelGokeiInput) {
        this.getServiceRiyohyoBeppyoGokei().getServiceRiyohyoBeppyoGokeiFooter().setBtnCancelGokeiInput(btnCancelGokeiInput);
    }

    @JsonIgnore
    public Button getBtnUpdate() {
        return this.getServiceRiyohyoBeppyoFooter().getBtnUpdate();
    }

    @JsonIgnore
    public void  setBtnUpdate(Button btnUpdate) {
        this.getServiceRiyohyoBeppyoFooter().setBtnUpdate(btnUpdate);
    }

    @JsonIgnore
    public Button getBtnBackRiyoNengetsuIchiran() {
        return this.getServiceRiyohyoBeppyoFooter().getBtnBackRiyoNengetsuIchiran();
    }

    @JsonIgnore
    public void  setBtnBackRiyoNengetsuIchiran(Button btnBackRiyoNengetsuIchiran) {
        this.getServiceRiyohyoBeppyoFooter().setBtnBackRiyoNengetsuIchiran(btnBackRiyoNengetsuIchiran);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 画面初期化メソッドです。
     *
     * @param 表示モード RString
     * @param 利用年月 FlexibleYearMonth
     * @param 対象年月 FlexibleYearMonth
     * @param 被保険者番号 HihokenshaNo
     * @param 居宅総合事業区分 RString
     * @param 履歴番号 int
     */
    @Override
    public void initialize(RString 表示モード, FlexibleYearMonth 利用年月, FlexibleYearMonth 対象年月,
            HihokenshaNo 被保険者番号, RString 居宅総合事業区分, int 履歴番号) {
        ServiceRiyohyoInfoDivHandler.of(this).init(表示モード, 利用年月, 対象年月, 被保険者番号, 居宅総合事業区分, 履歴番号);
    }
}
