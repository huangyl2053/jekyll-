package jp.co.ndensan.reams.db.dbz.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.IShisetsuJohoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShisetsuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuJohoDiv extends Panel implements IShisetsuJohoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlDaichoShubetsu")
    private DropDownList ddlDaichoShubetsu;
    @JsonProperty("radShisetsuShurui")
    private RadioButton radShisetsuShurui;
    @JsonProperty("txtShisetsuCode")
    private TextBoxCode txtShisetsuCode;
    @JsonProperty("btnJigyoshaInputGuide")
    private ButtonDialog btnJigyoshaInputGuide;
    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    private ButtonDialog btnOtherTokureiShisetsuInputGuide;
    @JsonProperty("btnJogaiShisetsuInputGuide")
    private ButtonDialog btnJogaiShisetsuInputGuide;
    @JsonProperty("txtShisetsuMeisho")
    private TextBox txtShisetsuMeisho;
    @JsonProperty("selectRow")
    private RString selectRow;
    @JsonProperty("inputMode")
    private RString inputMode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("ddlDaichoShubetsu")
    public DropDownList getDdlDaichoShubetsu() {
        return ddlDaichoShubetsu;
    }

    @JsonProperty("ddlDaichoShubetsu")
    public void setDdlDaichoShubetsu(DropDownList ddlDaichoShubetsu) {
        this.ddlDaichoShubetsu=ddlDaichoShubetsu;
    }

    @JsonProperty("radShisetsuShurui")
    public RadioButton getRadShisetsuShurui() {
        return radShisetsuShurui;
    }

    @JsonProperty("radShisetsuShurui")
    public void setRadShisetsuShurui(RadioButton radShisetsuShurui) {
        this.radShisetsuShurui=radShisetsuShurui;
    }

    @JsonProperty("txtShisetsuCode")
    public TextBoxCode getTxtShisetsuCode() {
        return txtShisetsuCode;
    }

    @JsonProperty("txtShisetsuCode")
    public void setTxtShisetsuCode(TextBoxCode txtShisetsuCode) {
        this.txtShisetsuCode=txtShisetsuCode;
    }

    @JsonProperty("btnJigyoshaInputGuide")
    public ButtonDialog getBtnJigyoshaInputGuide() {
        return btnJigyoshaInputGuide;
    }

    @JsonProperty("btnJigyoshaInputGuide")
    public void setBtnJigyoshaInputGuide(ButtonDialog btnJigyoshaInputGuide) {
        this.btnJigyoshaInputGuide=btnJigyoshaInputGuide;
    }

    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    public ButtonDialog getBtnOtherTokureiShisetsuInputGuide() {
        return btnOtherTokureiShisetsuInputGuide;
    }

    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    public void setBtnOtherTokureiShisetsuInputGuide(ButtonDialog btnOtherTokureiShisetsuInputGuide) {
        this.btnOtherTokureiShisetsuInputGuide=btnOtherTokureiShisetsuInputGuide;
    }

    @JsonProperty("btnJogaiShisetsuInputGuide")
    public ButtonDialog getBtnJogaiShisetsuInputGuide() {
        return btnJogaiShisetsuInputGuide;
    }

    @JsonProperty("btnJogaiShisetsuInputGuide")
    public void setBtnJogaiShisetsuInputGuide(ButtonDialog btnJogaiShisetsuInputGuide) {
        this.btnJogaiShisetsuInputGuide=btnJogaiShisetsuInputGuide;
    }

    @JsonProperty("txtShisetsuMeisho")
    public TextBox getTxtShisetsuMeisho() {
        return txtShisetsuMeisho;
    }

    @JsonProperty("txtShisetsuMeisho")
    public void setTxtShisetsuMeisho(TextBox txtShisetsuMeisho) {
        this.txtShisetsuMeisho=txtShisetsuMeisho;
    }

    @JsonProperty("selectRow")
    public RString getSelectRow() {
        return selectRow;
    }

    @JsonProperty("selectRow")
    public void setSelectRow(RString selectRow) {
        this.selectRow=selectRow;
    }

    @JsonProperty("inputMode")
    public RString getInputMode() {
        return inputMode;
    }

    @JsonProperty("inputMode")
    public void setInputMode(RString inputMode) {
        this.inputMode=inputMode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum 台帳種別 implements ICommonChildDivMode {

        台帳種別表示する("台帳種別表示する"),
        台帳種別非表示する("台帳種別非表示する");

        private final String name;

        private 台帳種別(final String name) {
            this.name = name;
        }

        public static 台帳種別 getEnum(String str) {
            台帳種別[] enumArray = 台帳種別.values();

            for (台帳種別 enumStr : enumArray) {
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

    public 台帳種別 getMode_台帳種別() {
        return (台帳種別) _CommonChildDivModeUtil.getMode( this.modes, 台帳種別.class );
    }

    public void setMode_台帳種別( 台帳種別 value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 台帳種別.class , value );
    }

    public static enum 施設種類 implements ICommonChildDivMode {

        施設種類を表示する("施設種類を表示する"),
        施設種類を表示しない("施設種類を表示しない");

        private final String name;

        private 施設種類(final String name) {
            this.name = name;
        }

        public static 施設種類 getEnum(String str) {
            施設種類[] enumArray = 施設種類.values();

            for (施設種類 enumStr : enumArray) {
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

    public 施設種類 getMode_施設種類() {
        return (施設種類) _CommonChildDivModeUtil.getMode( this.modes, 施設種類.class );
    }

    public void setMode_施設種類( 施設種類 value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 施設種類.class , value );
    }

    public static enum 入力補助 implements ICommonChildDivMode {

        事業者を表示する("事業者を表示する"),
        他特例施設を表示する("他特例施設を表示する"),
        除外施設を表示する("除外施設を表示する");

        private final String name;

        private 入力補助(final String name) {
            this.name = name;
        }

        public static 入力補助 getEnum(String str) {
            入力補助[] enumArray = 入力補助.values();

            for (入力補助 enumStr : enumArray) {
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

    public 入力補助 getMode_入力補助() {
        return (入力補助) _CommonChildDivModeUtil.getMode( this.modes, 入力補助.class );
    }

    public void setMode_入力補助( 入力補助 value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 入力補助.class , value );
    }

    //--------------- この行より下にコードを追加してください -------------------

}
