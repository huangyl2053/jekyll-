package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.ButtonDialog;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;

/**
 * ZenkaiNinteiKekkaJoho のクラスファイル
 *
 * @reamsid_L DBE-3000-020 dongyabin
 */
public class ZenkaiNinteiKekkaJohoDiv extends Panel implements IZenkaiNinteiKekkaJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-24_17-05-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtYokaigodo")
    private TextBox txtYokaigodo;
    @JsonProperty("txtNinteiDay")
    private TextBoxFlexibleDate txtNinteiDay;
    @JsonProperty("txtYukoKikanFrom")
    private TextBoxFlexibleDate txtYukoKikanFrom;
    @JsonProperty("txtYukoKikanTo")
    private TextBoxFlexibleDate txtYukoKikanTo;
    @JsonProperty("btnZenkaiShosai")
    private ButtonDialog btnZenkaiShosai;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;
    @JsonProperty("hdnGamenKubun")
    private RString hdnGamenKubun;
    @JsonProperty("hdnZenkaiShinseishoKanriNo")
    private RString hdnZenkaiShinseishoKanriNo;
    @JsonProperty("hdnKekkaShosaiJohoModel")
    private RString hdnKekkaShosaiJohoModel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtYokaigodo
     * @return txtYokaigodo
     */
    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    /*
     * settxtYokaigodo
     * @param txtYokaigodo txtYokaigodo
     */
    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo = txtYokaigodo;
    }

    /*
     * gettxtNinteiDay
     * @return txtNinteiDay
     */
    @JsonProperty("txtNinteiDay")
    public TextBoxFlexibleDate getTxtNinteiDay() {
        return txtNinteiDay;
    }

    /*
     * settxtNinteiDay
     * @param txtNinteiDay txtNinteiDay
     */
    @JsonProperty("txtNinteiDay")
    public void setTxtNinteiDay(TextBoxFlexibleDate txtNinteiDay) {
        this.txtNinteiDay = txtNinteiDay;
    }

    /*
     * gettxtYukoKikanFrom
     * @return txtYukoKikanFrom
     */
    @JsonProperty("txtYukoKikanFrom")
    public TextBoxFlexibleDate getTxtYukoKikanFrom() {
        return txtYukoKikanFrom;
    }

    /*
     * settxtYukoKikanFrom
     * @param txtYukoKikanFrom txtYukoKikanFrom
     */
    @JsonProperty("txtYukoKikanFrom")
    public void setTxtYukoKikanFrom(TextBoxFlexibleDate txtYukoKikanFrom) {
        this.txtYukoKikanFrom = txtYukoKikanFrom;
    }

    /*
     * gettxtYukoKikanTo
     * @return txtYukoKikanTo
     */
    @JsonProperty("txtYukoKikanTo")
    public TextBoxFlexibleDate getTxtYukoKikanTo() {
        return txtYukoKikanTo;
    }

    /*
     * settxtYukoKikanTo
     * @param txtYukoKikanTo txtYukoKikanTo
     */
    @JsonProperty("txtYukoKikanTo")
    public void setTxtYukoKikanTo(TextBoxFlexibleDate txtYukoKikanTo) {
        this.txtYukoKikanTo = txtYukoKikanTo;
    }

    /*
     * getbtnZenkaiShosai
     * @return btnZenkaiShosai
     */
    @JsonProperty("btnZenkaiShosai")
    public ButtonDialog getBtnZenkaiShosai() {
        return btnZenkaiShosai;
    }

    /*
     * setbtnZenkaiShosai
     * @param btnZenkaiShosai btnZenkaiShosai
     */
    @JsonProperty("btnZenkaiShosai")
    public void setBtnZenkaiShosai(ButtonDialog btnZenkaiShosai) {
        this.btnZenkaiShosai = btnZenkaiShosai;
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
     * gethdnGamenKubun
     * @return hdnGamenKubun
     */
    @JsonProperty("hdnGamenKubun")
    public RString getHdnGamenKubun() {
        return hdnGamenKubun;
    }

    /*
     * sethdnGamenKubun
     * @param hdnGamenKubun hdnGamenKubun
     */
    @JsonProperty("hdnGamenKubun")
    public void setHdnGamenKubun(RString hdnGamenKubun) {
        this.hdnGamenKubun = hdnGamenKubun;
    }

    /*
     * gethdnZenkaiShinseishoKanriNo
     * @return hdnZenkaiShinseishoKanriNo
     */
    @JsonProperty("hdnZenkaiShinseishoKanriNo")
    public RString getHdnZenkaiShinseishoKanriNo() {
        return hdnZenkaiShinseishoKanriNo;
    }

    /*
     * sethdnZenkaiShinseishoKanriNo
     * @param hdnZenkaiShinseishoKanriNo hdnZenkaiShinseishoKanriNo
     */
    @JsonProperty("hdnZenkaiShinseishoKanriNo")
    public void setHdnZenkaiShinseishoKanriNo(RString hdnZenkaiShinseishoKanriNo) {
        this.hdnZenkaiShinseishoKanriNo = hdnZenkaiShinseishoKanriNo;
    }

    /*
     * gethdnKekkaShosaiJohoModel
     * @return hdnKekkaShosaiJohoModel
     */
    @JsonProperty("hdnKekkaShosaiJohoModel")
    public RString getHdnKekkaShosaiJohoModel() {
        return hdnKekkaShosaiJohoModel;
    }

    /*
     * sethdnKekkaShosaiJohoModel
     * @param hdnKekkaShosaiJohoModel hdnKekkaShosaiJohoModel
     */
    @JsonProperty("hdnKekkaShosaiJohoModel")
    public void setHdnKekkaShosaiJohoModel(RString hdnKekkaShosaiJohoModel) {
        this.hdnKekkaShosaiJohoModel = hdnKekkaShosaiJohoModel;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DivSize implements ICommonChildDivMode {

        ShinseiUketsuke("ShinseiUketsuke"),
        ChosaKekkaToroku("ChosaKekkaToroku");

        private final String name;

        private DivSize(final String name) {
            this.name = name;
        }

        public static DivSize getEnum(String str) {
            DivSize[] enumArray = DivSize.values();

            for (DivSize enumStr : enumArray) {
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

    public DivSize getMode_DivSize() {
        return (DivSize) _CommonChildDivModeUtil.getMode( this.modes, DivSize.class );
    }

    public void setMode_DivSize( DivSize value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DivSize.class , value );
    }

    public static enum ShokaiButtonType implements ICommonChildDivMode {

        ShokaiButtonMode("ShokaiButtonMode"),
        ShokaiButtonNoneMode("ShokaiButtonNoneMode"),
        ShokaiButtonDisabledMode("ShokaiButtonDisabledMode");

        private final String name;

        private ShokaiButtonType(final String name) {
            this.name = name;
        }

        public static ShokaiButtonType getEnum(String str) {
            ShokaiButtonType[] enumArray = ShokaiButtonType.values();

            for (ShokaiButtonType enumStr : enumArray) {
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

    public ShokaiButtonType getMode_ShokaiButtonType() {
        return (ShokaiButtonType) _CommonChildDivModeUtil.getMode( this.modes, ShokaiButtonType.class );
    }

    public void setMode_ShokaiButtonType( ShokaiButtonType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ShokaiButtonType.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 前回認定結果Divの初期化です。
     *
     * @param subGyomuCode 画面モード
     * @param shinseishoKanriNo 申請書管理番号
     * @param 参照結果 参照結果
     */
    @Override
    public void onLoad(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo,
            RString 参照結果) {
        getHandler().onLoad(subGyomuCode, shinseishoKanriNo, 参照結果);
    }

    /**
     * 要介護状態区分コードを取得します。
     *
     * @param subGyomuCode 画面モード
     * @param shinseishoKanriNo 申請書管理番号
     * @param 参照結果 参照結果
     * @return 要介護状態区分コード
     */
    @Override
    public RString get要介護状態区分コード(SubGyomuCode subGyomuCode,
            ShinseishoKanriNo shinseishoKanriNo,
            RString 参照結果) {
        return getHandler().get要介護状態区分コード(subGyomuCode, shinseishoKanriNo, 参照結果);
    }

    private ZenkaiNinteiKekkaJohoHandler getHandler() {
        return new ZenkaiNinteiKekkaJohoHandler(this);
    }
}
