package jp.co.ndensan.reams.db.dbz.divcontroller.entity.chosaitakusakiandchosaininput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.chosaitakusakiandchosaininput.IChosaItakusakiAndChosainInputDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * ChosaItakusakiAndChosainInput のクラスファイル 
 * 
 * @author 自動生成
 */
public class ChosaItakusakiAndChosainInputDiv extends Panel implements IChosaItakusakiAndChosainInputDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtChosaItakusakiCode")
    private TextBoxCode txtChosaItakusakiCode;
    @JsonProperty("btnChosaItakusakiGuide")
    private ButtonDialog btnChosaItakusakiGuide;
    @JsonProperty("txtChosaItakusakiName")
    private TextBox txtChosaItakusakiName;
    @JsonProperty("btnChosainRenrakuJiko")
    private ButtonDialog btnChosainRenrakuJiko;
    @JsonProperty("btnZenkaiFukusha")
    private Button btnZenkaiFukusha;
    @JsonProperty("txtChosainCode")
    private TextBoxCode txtChosainCode;
    @JsonProperty("btnChosainGuide")
    private ButtonDialog btnChosainGuide;
    @JsonProperty("txtChosainName")
    private TextBox txtChosainName;
    @JsonProperty("btnClear")
    private Button btnClear;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;
    @JsonProperty("hdnChosainRenrakuJiko")
    private RString hdnChosainRenrakuJiko;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnShichosonCode")
    private RString hdnShichosonCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtChosaItakusakiCode")
    public TextBoxCode getTxtChosaItakusakiCode() {
        return txtChosaItakusakiCode;
    }

    @JsonProperty("txtChosaItakusakiCode")
    public void setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.txtChosaItakusakiCode=txtChosaItakusakiCode;
    }

    @JsonProperty("btnChosaItakusakiGuide")
    public ButtonDialog getBtnChosaItakusakiGuide() {
        return btnChosaItakusakiGuide;
    }

    @JsonProperty("btnChosaItakusakiGuide")
    public void setBtnChosaItakusakiGuide(ButtonDialog btnChosaItakusakiGuide) {
        this.btnChosaItakusakiGuide=btnChosaItakusakiGuide;
    }

    @JsonProperty("txtChosaItakusakiName")
    public TextBox getTxtChosaItakusakiName() {
        return txtChosaItakusakiName;
    }

    @JsonProperty("txtChosaItakusakiName")
    public void setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.txtChosaItakusakiName=txtChosaItakusakiName;
    }

    @JsonProperty("btnChosainRenrakuJiko")
    public ButtonDialog getBtnChosainRenrakuJiko() {
        return btnChosainRenrakuJiko;
    }

    @JsonProperty("btnChosainRenrakuJiko")
    public void setBtnChosainRenrakuJiko(ButtonDialog btnChosainRenrakuJiko) {
        this.btnChosainRenrakuJiko=btnChosainRenrakuJiko;
    }

    @JsonProperty("btnZenkaiFukusha")
    public Button getBtnZenkaiFukusha() {
        return btnZenkaiFukusha;
    }

    @JsonProperty("btnZenkaiFukusha")
    public void setBtnZenkaiFukusha(Button btnZenkaiFukusha) {
        this.btnZenkaiFukusha=btnZenkaiFukusha;
    }

    @JsonProperty("txtChosainCode")
    public TextBoxCode getTxtChosainCode() {
        return txtChosainCode;
    }

    @JsonProperty("txtChosainCode")
    public void setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.txtChosainCode=txtChosainCode;
    }

    @JsonProperty("btnChosainGuide")
    public ButtonDialog getBtnChosainGuide() {
        return btnChosainGuide;
    }

    @JsonProperty("btnChosainGuide")
    public void setBtnChosainGuide(ButtonDialog btnChosainGuide) {
        this.btnChosainGuide=btnChosainGuide;
    }

    @JsonProperty("txtChosainName")
    public TextBox getTxtChosainName() {
        return txtChosainName;
    }

    @JsonProperty("txtChosainName")
    public void setTxtChosainName(TextBox txtChosainName) {
        this.txtChosainName=txtChosainName;
    }

    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear=btnClear;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode=hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnChosainRenrakuJiko")
    public RString getHdnChosainRenrakuJiko() {
        return hdnChosainRenrakuJiko;
    }

    @JsonProperty("hdnChosainRenrakuJiko")
    public void setHdnChosainRenrakuJiko(RString hdnChosainRenrakuJiko) {
        this.hdnChosainRenrakuJiko=hdnChosainRenrakuJiko;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo=hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnShichosonCode")
    public RString getHdnShichosonCode() {
        return hdnShichosonCode;
    }

    @JsonProperty("hdnShichosonCode")
    public void setHdnShichosonCode(RString hdnShichosonCode) {
        this.hdnShichosonCode=hdnShichosonCode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum ShoriType implements ICommonChildDivMode {

        InputMode("InputMode"),
        ShokaiMode("ShokaiMode"),
        SimpleInputMode("SimpleInputMode"),
        SimpleShokaiMode("SimpleShokaiMode");

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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void onClickBtnClear() {
        createHandler().onClickBtnClear();
    }

    @Override
    public void onClickbtnToroku() {
        createHandler().onClickbtnToroku();
    }

    // 以下のメソッドはインタフェースに定義していないので業務には公開されません。
    @JsonIgnore
    private ChosaItakusakiAndChosainInputHandler createHandler() {
        return new ChosaItakusakiAndChosainInputHandler(this);
    }

    @Override
    public RString getChosain() {
        return this.txtChosainCode.getValue();
    }

    @Override
    public RString getChosaItakusakiCode() {
        return this.txtChosaItakusakiCode.getValue();
    }

    @Override
    public void onBlurTxtChosaItakusakiCode() {
        createHandler().onBlurTxtChosaItakusakiCode();
    }

    @Override
    public void onBlurTxtShujiiCode() {
        createHandler().onBlurTxtChosainCode();
    }

    @Override
    public void setTxtChosaItakusakiCode(RString chosaItakusakiCode) {
        this.txtChosaItakusakiCode.setValue(chosaItakusakiCode);
    }

    @Override
    public void setTxtChosaItakusakiName(RString chosaItakusakiName) {
        this.txtChosaItakusakiName.setValue(chosaItakusakiName);
    }

    @Override
    public void setTxtChosainCode(RString chosainCode) {
        this.txtChosainCode.setValue(chosainCode);
    }

    @Override
    public void setTxtChosainName(RString chosainName) {
        this.txtChosainName.setValue(chosainName);
    }

}
