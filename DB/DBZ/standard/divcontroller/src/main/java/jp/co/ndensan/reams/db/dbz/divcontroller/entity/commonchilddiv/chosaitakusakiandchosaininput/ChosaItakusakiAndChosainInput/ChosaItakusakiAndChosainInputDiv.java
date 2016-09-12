package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbz.divcontroller.handler.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInputHandler;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ChosaItakusakiAndChosainInput のクラスファイル
 *
 * @reamsid_L DBZ-1300-030 zhangguopeng
 */
public class ChosaItakusakiAndChosainInputDiv extends Panel implements IChosaItakusakiAndChosainInputDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
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
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtChosaItakusakiCode
     * @return txtChosaItakusakiCode
     */
    @JsonProperty("txtChosaItakusakiCode")
    @Override
    public TextBoxCode getTxtChosaItakusakiCode() {
        return txtChosaItakusakiCode;
    }

    /*
     * settxtChosaItakusakiCode
     * @param txtChosaItakusakiCode txtChosaItakusakiCode
     */
    @JsonProperty("txtChosaItakusakiCode")
    public void setTxtChosaItakusakiCode(TextBoxCode txtChosaItakusakiCode) {
        this.txtChosaItakusakiCode = txtChosaItakusakiCode;
    }

    /*
     * getbtnChosaItakusakiGuide
     * @return btnChosaItakusakiGuide
     */
    @JsonProperty("btnChosaItakusakiGuide")
    public ButtonDialog getBtnChosaItakusakiGuide() {
        return btnChosaItakusakiGuide;
    }

    /*
     * setbtnChosaItakusakiGuide
     * @param btnChosaItakusakiGuide btnChosaItakusakiGuide
     */
    @JsonProperty("btnChosaItakusakiGuide")
    public void setBtnChosaItakusakiGuide(ButtonDialog btnChosaItakusakiGuide) {
        this.btnChosaItakusakiGuide = btnChosaItakusakiGuide;
    }

    /*
     * gettxtChosaItakusakiName
     * @return txtChosaItakusakiName
     */
    @JsonProperty("txtChosaItakusakiName")
    @Override
    public TextBox getTxtChosaItakusakiName() {
        return txtChosaItakusakiName;
    }

    /*
     * settxtChosaItakusakiName
     * @param txtChosaItakusakiName txtChosaItakusakiName
     */
    @JsonProperty("txtChosaItakusakiName")
    public void setTxtChosaItakusakiName(TextBox txtChosaItakusakiName) {
        this.txtChosaItakusakiName = txtChosaItakusakiName;
    }

    /*
     * getbtnChosainRenrakuJiko
     * @return btnChosainRenrakuJiko
     */
    @JsonProperty("btnChosainRenrakuJiko")
    public ButtonDialog getBtnChosainRenrakuJiko() {
        return btnChosainRenrakuJiko;
    }

    /*
     * setbtnChosainRenrakuJiko
     * @param btnChosainRenrakuJiko btnChosainRenrakuJiko
     */
    @JsonProperty("btnChosainRenrakuJiko")
    public void setBtnChosainRenrakuJiko(ButtonDialog btnChosainRenrakuJiko) {
        this.btnChosainRenrakuJiko = btnChosainRenrakuJiko;
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
     * gettxtChosainCode
     * @return txtChosainCode
     */
    @JsonProperty("txtChosainCode")
    @Override
    public TextBoxCode getTxtChosainCode() {
        return txtChosainCode;
    }

    /*
     * settxtChosainCode
     * @param txtChosainCode txtChosainCode
     */
    @JsonProperty("txtChosainCode")
    public void setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.txtChosainCode = txtChosainCode;
    }

    /*
     * getbtnChosainGuide
     * @return btnChosainGuide
     */
    @JsonProperty("btnChosainGuide")
    public ButtonDialog getBtnChosainGuide() {
        return btnChosainGuide;
    }

    /*
     * setbtnChosainGuide
     * @param btnChosainGuide btnChosainGuide
     */
    @JsonProperty("btnChosainGuide")
    public void setBtnChosainGuide(ButtonDialog btnChosainGuide) {
        this.btnChosainGuide = btnChosainGuide;
    }

    /*
     * gettxtChosainName
     * @return txtChosainName
     */
    @JsonProperty("txtChosainName")
    @Override
    public TextBox getTxtChosainName() {
        return txtChosainName;
    }

    /*
     * settxtChosainName
     * @param txtChosainName txtChosainName
     */
    @JsonProperty("txtChosainName")
    public void setTxtChosainName(TextBox txtChosainName) {
        this.txtChosainName = txtChosainName;
    }

    /*
     * getbtnClear
     * @return btnClear
     */
    @JsonProperty("btnClear")
    public Button getBtnClear() {
        return btnClear;
    }

    /*
     * setbtnClear
     * @param btnClear btnClear
     */
    @JsonProperty("btnClear")
    public void setBtnClear(Button btnClear) {
        this.btnClear = btnClear;
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
     * gethdnChosainRenrakuJiko
     * @return hdnChosainRenrakuJiko
     */
    @JsonProperty("hdnChosainRenrakuJiko")
    public RString getHdnChosainRenrakuJiko() {
        return hdnChosainRenrakuJiko;
    }

    /*
     * sethdnChosainRenrakuJiko
     * @param hdnChosainRenrakuJiko hdnChosainRenrakuJiko
     */
    @JsonProperty("hdnChosainRenrakuJiko")
    public void setHdnChosainRenrakuJiko(RString hdnChosainRenrakuJiko) {
        this.hdnChosainRenrakuJiko = hdnChosainRenrakuJiko;
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
    @Override
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo = hdnShinseishoKanriNo;
    }

    /*
     * gethdnShichosonCode
     * @return hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    public RString getHdnShichosonCode() {
        return hdnShichosonCode;
    }

    /*
     * sethdnShichosonCode
     * @param hdnShichosonCode hdnShichosonCode
     */
    @JsonProperty("hdnShichosonCode")
    @Override
    public void setHdnShichosonCode(RString hdnShichosonCode) {
        this.hdnShichosonCode = hdnShichosonCode;
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
        return (ShoriType) _CommonChildDivModeUtil.getMode(this.modes, ShoriType.class);
    }

    public void setMode_ShoriType(ShoriType value) {
        _CommonChildDivModeUtil.setMode(this.modes, ShoriType.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(RString モード) {
        getHandler().initialize(モード);
    }

    @Override
    public void initialize(RString モード, RString 調査委託先コード, RString 調査委託先名, RString 調査員コード, RString 調査員名) {
        getHandler().initialize(モード, 調査委託先コード, 調査委託先名, 調査員コード, 調査員名);
    }

    @Override
    public void clear() {
        getHandler().onClick_BtnClear();
    }

    @Override
    public RString getChosainRenrakuJiko() {
        return this.hdnChosainRenrakuJiko;
    }

    @Override
    public void setChosainRenrakuJiko(RString chosainRenrakuJiko) {
        this.hdnChosainRenrakuJiko = chosainRenrakuJiko;
    }

    @JsonIgnore
    private ChosaItakusakiAndChosainInputHandler getHandler() {
        return new ChosaItakusakiAndChosainInputHandler(this);
    }
}
