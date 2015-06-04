package jp.co.ndensan.reams.db.dbd.divcontroller.entity.ZenkaiNinteiKekkaJoho;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ZenkaiNinteiKekkaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ZenkaiNinteiKekkaJohoDiv extends Panel implements IZenkaiNinteiKekkaJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
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
    @JsonProperty("btnZenkaiShosai")
    private Button btnZenkaiShosai;
    @JsonProperty("txtYukoKikanTo")
    private TextBoxFlexibleDate txtYukoKikanTo;
    @JsonProperty("hdnShinseishoKanriNo")
    private RString hdnShinseishoKanriNo;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtYokaigodo")
    public TextBox getTxtYokaigodo() {
        return txtYokaigodo;
    }

    @JsonProperty("txtYokaigodo")
    public void setTxtYokaigodo(TextBox txtYokaigodo) {
        this.txtYokaigodo=txtYokaigodo;
    }

    @JsonProperty("txtNinteiDay")
    public TextBoxFlexibleDate getTxtNinteiDay() {
        return txtNinteiDay;
    }

    @JsonProperty("txtNinteiDay")
    public void setTxtNinteiDay(TextBoxFlexibleDate txtNinteiDay) {
        this.txtNinteiDay=txtNinteiDay;
    }

    @JsonProperty("txtYukoKikanFrom")
    public TextBoxFlexibleDate getTxtYukoKikanFrom() {
        return txtYukoKikanFrom;
    }

    @JsonProperty("txtYukoKikanFrom")
    public void setTxtYukoKikanFrom(TextBoxFlexibleDate txtYukoKikanFrom) {
        this.txtYukoKikanFrom=txtYukoKikanFrom;
    }

    @JsonProperty("btnZenkaiShosai")
    public Button getBtnZenkaiShosai() {
        return btnZenkaiShosai;
    }

    @JsonProperty("btnZenkaiShosai")
    public void setBtnZenkaiShosai(Button btnZenkaiShosai) {
        this.btnZenkaiShosai=btnZenkaiShosai;
    }

    @JsonProperty("txtYukoKikanTo")
    public TextBoxFlexibleDate getTxtYukoKikanTo() {
        return txtYukoKikanTo;
    }

    @JsonProperty("txtYukoKikanTo")
    public void setTxtYukoKikanTo(TextBoxFlexibleDate txtYukoKikanTo) {
        this.txtYukoKikanTo=txtYukoKikanTo;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public RString getHdnShinseishoKanriNo() {
        return hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnShinseishoKanriNo")
    public void setHdnShinseishoKanriNo(RString hdnShinseishoKanriNo) {
        this.hdnShinseishoKanriNo=hdnShinseishoKanriNo;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode=hdnDatabaseSubGyomuCode;
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
        ShokaiButtonNoneMode("ShokaiButtonNoneMode");

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
    @Override
    public void clear() {
    }

    @Override
    public void onLoad() {
        getHandler().onLoad();
    }

    private ZenkaiNinteiKekkaJohoHandler getHandler() {
        return new ZenkaiNinteiKekkaJohoHandler(this);
    }
}
