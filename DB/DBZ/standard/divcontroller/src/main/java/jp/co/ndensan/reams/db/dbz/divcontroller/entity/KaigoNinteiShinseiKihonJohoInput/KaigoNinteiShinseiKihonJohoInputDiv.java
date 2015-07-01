package jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * KaigoNinteiShinseiKihonJohoInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoNinteiShinseiKihonJohoInputDiv extends Panel implements IKaigoNinteiShinseiKihonJohoInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("radShinseishoKubun")
    private RadioButton radShinseishoKubun;
    @JsonProperty("txtShinseiYMD")
    private TextBoxDate txtShinseiYMD;
    @JsonProperty("ddlShinseiShubetsu")
    private DropDownList ddlShinseiShubetsu;
    @JsonProperty("ddlShinseiKubunShinseiji")
    private DropDownList ddlShinseiKubunShinseiji;
    @JsonProperty("ddlShinseiKubunHorei")
    private DropDownList ddlShinseiKubunHorei;
    @JsonProperty("chkKyuSochisha")
    private CheckBoxList chkKyuSochisha;
    @JsonProperty("ddlHihokenshaKubun")
    private DropDownList ddlHihokenshaKubun;
    @JsonProperty("chkShikakuShutokuMae")
    private CheckBoxList chkShikakuShutokuMae;
    @JsonProperty("ddlTokuteiShippei")
    private DropDownList ddlTokuteiShippei;
    @JsonProperty("txtShinseiJokyo")
    private TextBox txtShinseiJokyo;
    @JsonProperty("ServiceSakujo")
    private ServiceSakujoDiv ServiceSakujo;
    @JsonProperty("NinteiShinseiRiyu")
    private NinteiShinseiRiyuDiv NinteiShinseiRiyu;
    @JsonProperty("hdnServiceSakujoTeikeibunKey")
    private RString hdnServiceSakujoTeikeibunKey;
    @JsonProperty("hdnNinteiRiyuTeikeibunKey")
    private RString hdnNinteiRiyuTeikeibunKey;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("radShinseishoKubun")
    public RadioButton getRadShinseishoKubun() {
        return radShinseishoKubun;
    }

    @JsonProperty("radShinseishoKubun")
    public void setRadShinseishoKubun(RadioButton radShinseishoKubun) {
        this.radShinseishoKubun=radShinseishoKubun;
    }

    @JsonProperty("txtShinseiYMD")
    public TextBoxDate getTxtShinseiYMD() {
        return txtShinseiYMD;
    }

    @JsonProperty("txtShinseiYMD")
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.txtShinseiYMD=txtShinseiYMD;
    }

    @JsonProperty("ddlShinseiShubetsu")
    public DropDownList getDdlShinseiShubetsu() {
        return ddlShinseiShubetsu;
    }

    @JsonProperty("ddlShinseiShubetsu")
    public void setDdlShinseiShubetsu(DropDownList ddlShinseiShubetsu) {
        this.ddlShinseiShubetsu=ddlShinseiShubetsu;
    }

    @JsonProperty("ddlShinseiKubunShinseiji")
    public DropDownList getDdlShinseiKubunShinseiji() {
        return ddlShinseiKubunShinseiji;
    }

    @JsonProperty("ddlShinseiKubunShinseiji")
    public void setDdlShinseiKubunShinseiji(DropDownList ddlShinseiKubunShinseiji) {
        this.ddlShinseiKubunShinseiji=ddlShinseiKubunShinseiji;
    }

    @JsonProperty("ddlShinseiKubunHorei")
    public DropDownList getDdlShinseiKubunHorei() {
        return ddlShinseiKubunHorei;
    }

    @JsonProperty("ddlShinseiKubunHorei")
    public void setDdlShinseiKubunHorei(DropDownList ddlShinseiKubunHorei) {
        this.ddlShinseiKubunHorei=ddlShinseiKubunHorei;
    }

    @JsonProperty("chkKyuSochisha")
    public CheckBoxList getChkKyuSochisha() {
        return chkKyuSochisha;
    }

    @JsonProperty("chkKyuSochisha")
    public void setChkKyuSochisha(CheckBoxList chkKyuSochisha) {
        this.chkKyuSochisha=chkKyuSochisha;
    }

    @JsonProperty("ddlHihokenshaKubun")
    public DropDownList getDdlHihokenshaKubun() {
        return ddlHihokenshaKubun;
    }

    @JsonProperty("ddlHihokenshaKubun")
    public void setDdlHihokenshaKubun(DropDownList ddlHihokenshaKubun) {
        this.ddlHihokenshaKubun=ddlHihokenshaKubun;
    }

    @JsonProperty("chkShikakuShutokuMae")
    public CheckBoxList getChkShikakuShutokuMae() {
        return chkShikakuShutokuMae;
    }

    @JsonProperty("chkShikakuShutokuMae")
    public void setChkShikakuShutokuMae(CheckBoxList chkShikakuShutokuMae) {
        this.chkShikakuShutokuMae=chkShikakuShutokuMae;
    }

    @JsonProperty("ddlTokuteiShippei")
    public DropDownList getDdlTokuteiShippei() {
        return ddlTokuteiShippei;
    }

    @JsonProperty("ddlTokuteiShippei")
    public void setDdlTokuteiShippei(DropDownList ddlTokuteiShippei) {
        this.ddlTokuteiShippei=ddlTokuteiShippei;
    }

    @JsonProperty("txtShinseiJokyo")
    public TextBox getTxtShinseiJokyo() {
        return txtShinseiJokyo;
    }

    @JsonProperty("txtShinseiJokyo")
    public void setTxtShinseiJokyo(TextBox txtShinseiJokyo) {
        this.txtShinseiJokyo=txtShinseiJokyo;
    }

    @JsonProperty("ServiceSakujo")
    public ServiceSakujoDiv getServiceSakujo() {
        return ServiceSakujo;
    }

    @JsonProperty("ServiceSakujo")
    public void setServiceSakujo(ServiceSakujoDiv ServiceSakujo) {
        this.ServiceSakujo=ServiceSakujo;
    }

    @JsonProperty("NinteiShinseiRiyu")
    public NinteiShinseiRiyuDiv getNinteiShinseiRiyu() {
        return NinteiShinseiRiyu;
    }

    @JsonProperty("NinteiShinseiRiyu")
    public void setNinteiShinseiRiyu(NinteiShinseiRiyuDiv NinteiShinseiRiyu) {
        this.NinteiShinseiRiyu=NinteiShinseiRiyu;
    }

    @JsonProperty("hdnServiceSakujoTeikeibunKey")
    public RString getHdnServiceSakujoTeikeibunKey() {
        return hdnServiceSakujoTeikeibunKey;
    }

    @JsonProperty("hdnServiceSakujoTeikeibunKey")
    public void setHdnServiceSakujoTeikeibunKey(RString hdnServiceSakujoTeikeibunKey) {
        this.hdnServiceSakujoTeikeibunKey=hdnServiceSakujoTeikeibunKey;
    }

    @JsonProperty("hdnNinteiRiyuTeikeibunKey")
    public RString getHdnNinteiRiyuTeikeibunKey() {
        return hdnNinteiRiyuTeikeibunKey;
    }

    @JsonProperty("hdnNinteiRiyuTeikeibunKey")
    public void setHdnNinteiRiyuTeikeibunKey(RString hdnNinteiRiyuTeikeibunKey) {
        this.hdnNinteiRiyuTeikeibunKey=hdnNinteiRiyuTeikeibunKey;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum InputType implements ICommonChildDivMode {

        AllInputMode("AllInputMode"),
        ServiceInputMode("ServiceInputMode"),
        ServiceShokaiMode("ServiceShokaiMode"),
        ServiceNomalInputMode("ServiceNomalInputMode"),
        TokuteiShippeiMode("TokuteiShippeiMode"),
        TokuteiShippeiNashiMode("TokuteiShippeiNashiMode"),
        JizenShinseiNashiMode("JizenShinseiNashiMode"),
        ShinseibiMode("ShinseibiMode"),
        NinteiMode("NinteiMode"),
        ShokaiMode("ShokaiMode");

        private final String name;

        private InputType(final String name) {
            this.name = name;
        }

        public static InputType getEnum(String str) {
            InputType[] enumArray = InputType.values();

            for (InputType enumStr : enumArray) {
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

    public InputType getMode_InputType() {
        return (InputType) _CommonChildDivModeUtil.getMode( this.modes, InputType.class );
    }

    public void setMode_InputType( InputType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, InputType.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ButtonDialog getBtnServiceSakujoTeikeibun() {
        return this.getServiceSakujo().getBtnServiceSakujoTeikeibun();
    }

    @JsonIgnore
    public void  setBtnServiceSakujoTeikeibun(ButtonDialog btnServiceSakujoTeikeibun) {
        this.getServiceSakujo().setBtnServiceSakujoTeikeibun(btnServiceSakujoTeikeibun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtServiceSakujo() {
        return this.getServiceSakujo().getTxtServiceSakujo();
    }

    @JsonIgnore
    public void  setTxtServiceSakujo(TextBoxMultiLine txtServiceSakujo) {
        this.getServiceSakujo().setTxtServiceSakujo(txtServiceSakujo);
    }

    @JsonIgnore
    public ButtonDialog getBtnNinteiShinseiRiyuTeikeibun() {
        return this.getNinteiShinseiRiyu().getBtnNinteiShinseiRiyuTeikeibun();
    }

    @JsonIgnore
    public void  setBtnNinteiShinseiRiyuTeikeibun(ButtonDialog btnNinteiShinseiRiyuTeikeibun) {
        this.getNinteiShinseiRiyu().setBtnNinteiShinseiRiyuTeikeibun(btnNinteiShinseiRiyuTeikeibun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtNinteiShinseRiyu() {
        return this.getNinteiShinseiRiyu().getTxtNinteiShinseRiyu();
    }

    @JsonIgnore
    public void  setTxtNinteiShinseRiyu(TextBoxMultiLine txtNinteiShinseRiyu) {
        this.getNinteiShinseiRiyu().setTxtNinteiShinseRiyu(txtNinteiShinseRiyu);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void clear() {
        createHandler().clear();
    }

    @Override
    public void initialize() {
        createHandler().Initialize();
    }

    @Override
    public void setTxtShinseiJokyo(RString txtShinseiJokyo) {
        this.txtShinseiJokyo.setValue(txtShinseiJokyo);
    }

    private KaigoNinteiShinseiKihonJohoInputHandler createHandler() {
        return new KaigoNinteiShinseiKihonJohoInputHandler(this);
    }
}
