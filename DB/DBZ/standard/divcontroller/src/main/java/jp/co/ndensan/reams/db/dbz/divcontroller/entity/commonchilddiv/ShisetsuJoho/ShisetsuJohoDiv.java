package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJoho;
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

/**
 * ShisetsuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuJohoDiv extends Panel implements IShisetsuJohoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlDaichoShubetsu")
    private DropDownList ddlDaichoShubetsu;
    @JsonProperty("radJigyosha")
    private RadioButton radJigyosha;
    @JsonProperty("radOther")
    private RadioButton radOther;
    @JsonProperty("radJyogai")
    private RadioButton radJyogai;
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
    /*
     * getddlDaichoShubetsu
     * @return ddlDaichoShubetsu
     */
    @JsonProperty("ddlDaichoShubetsu")
    public DropDownList getDdlDaichoShubetsu() {
        return ddlDaichoShubetsu;
    }

    /*
     * setddlDaichoShubetsu
     * @param ddlDaichoShubetsu ddlDaichoShubetsu
     */
    @JsonProperty("ddlDaichoShubetsu")
    public void setDdlDaichoShubetsu(DropDownList ddlDaichoShubetsu) {
        this.ddlDaichoShubetsu = ddlDaichoShubetsu;
    }

    /*
     * getradJigyosha
     * @return radJigyosha
     */
    @JsonProperty("radJigyosha")
    public RadioButton getRadJigyosha() {
        return radJigyosha;
    }

    /*
     * setradJigyosha
     * @param radJigyosha radJigyosha
     */
    @JsonProperty("radJigyosha")
    public void setRadJigyosha(RadioButton radJigyosha) {
        this.radJigyosha = radJigyosha;
    }

    /*
     * getradOther
     * @return radOther
     */
    @JsonProperty("radOther")
    public RadioButton getRadOther() {
        return radOther;
    }

    /*
     * setradOther
     * @param radOther radOther
     */
    @JsonProperty("radOther")
    public void setRadOther(RadioButton radOther) {
        this.radOther = radOther;
    }

    /*
     * getradJyogai
     * @return radJyogai
     */
    @JsonProperty("radJyogai")
    public RadioButton getRadJyogai() {
        return radJyogai;
    }

    /*
     * setradJyogai
     * @param radJyogai radJyogai
     */
    @JsonProperty("radJyogai")
    public void setRadJyogai(RadioButton radJyogai) {
        this.radJyogai = radJyogai;
    }

    /*
     * gettxtShisetsuCode
     * @return txtShisetsuCode
     */
    @JsonProperty("txtShisetsuCode")
    public TextBoxCode getTxtShisetsuCode() {
        return txtShisetsuCode;
    }

    /*
     * settxtShisetsuCode
     * @param txtShisetsuCode txtShisetsuCode
     */
    @JsonProperty("txtShisetsuCode")
    public void setTxtShisetsuCode(TextBoxCode txtShisetsuCode) {
        this.txtShisetsuCode = txtShisetsuCode;
    }

    /*
     * getbtnJigyoshaInputGuide
     * @return btnJigyoshaInputGuide
     */
    @JsonProperty("btnJigyoshaInputGuide")
    public ButtonDialog getBtnJigyoshaInputGuide() {
        return btnJigyoshaInputGuide;
    }

    /*
     * setbtnJigyoshaInputGuide
     * @param btnJigyoshaInputGuide btnJigyoshaInputGuide
     */
    @JsonProperty("btnJigyoshaInputGuide")
    public void setBtnJigyoshaInputGuide(ButtonDialog btnJigyoshaInputGuide) {
        this.btnJigyoshaInputGuide = btnJigyoshaInputGuide;
    }

    /*
     * getbtnOtherTokureiShisetsuInputGuide
     * @return btnOtherTokureiShisetsuInputGuide
     */
    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    public ButtonDialog getBtnOtherTokureiShisetsuInputGuide() {
        return btnOtherTokureiShisetsuInputGuide;
    }

    /*
     * setbtnOtherTokureiShisetsuInputGuide
     * @param btnOtherTokureiShisetsuInputGuide btnOtherTokureiShisetsuInputGuide
     */
    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    public void setBtnOtherTokureiShisetsuInputGuide(ButtonDialog btnOtherTokureiShisetsuInputGuide) {
        this.btnOtherTokureiShisetsuInputGuide = btnOtherTokureiShisetsuInputGuide;
    }

    /*
     * getbtnJogaiShisetsuInputGuide
     * @return btnJogaiShisetsuInputGuide
     */
    @JsonProperty("btnJogaiShisetsuInputGuide")
    public ButtonDialog getBtnJogaiShisetsuInputGuide() {
        return btnJogaiShisetsuInputGuide;
    }

    /*
     * setbtnJogaiShisetsuInputGuide
     * @param btnJogaiShisetsuInputGuide btnJogaiShisetsuInputGuide
     */
    @JsonProperty("btnJogaiShisetsuInputGuide")
    public void setBtnJogaiShisetsuInputGuide(ButtonDialog btnJogaiShisetsuInputGuide) {
        this.btnJogaiShisetsuInputGuide = btnJogaiShisetsuInputGuide;
    }

    /*
     * gettxtShisetsuMeisho
     * @return txtShisetsuMeisho
     */
    @JsonProperty("txtShisetsuMeisho")
    public TextBox getTxtShisetsuMeisho() {
        return txtShisetsuMeisho;
    }

    /*
     * settxtShisetsuMeisho
     * @param txtShisetsuMeisho txtShisetsuMeisho
     */
    @JsonProperty("txtShisetsuMeisho")
    public void setTxtShisetsuMeisho(TextBox txtShisetsuMeisho) {
        this.txtShisetsuMeisho = txtShisetsuMeisho;
    }

    /*
     * getselectRow
     * @return selectRow
     */
    @JsonProperty("selectRow")
    public RString getSelectRow() {
        return selectRow;
    }

    /*
     * setselectRow
     * @param selectRow selectRow
     */
    @JsonProperty("selectRow")
    public void setSelectRow(RString selectRow) {
        this.selectRow = selectRow;
    }

    /*
     * getinputMode
     * @return inputMode
     */
    @JsonProperty("inputMode")
    public RString getInputMode() {
        return inputMode;
    }

    /*
     * setinputMode
     * @param inputMode inputMode
     */
    @JsonProperty("inputMode")
    public void setInputMode(RString inputMode) {
        this.inputMode = inputMode;
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
        施設種類を非表示する("施設種類を非表示する"),
        介護保険特例者表示("介護保険特例者表示");

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
        除外施設を表示する("除外施設を表示する"),
        除外施設を非表示する("除外施設を非表示する"),
        全て表示する("全て表示する");

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

    public static enum 表示モード implements ICommonChildDivMode {

        defaultView("defaultView"),
        readOnly("readOnly"),
        displayNone("displayNone");

        private final String name;

        private 表示モード(final String name) {
            this.name = name;
        }

        public static 表示モード getEnum(String str) {
            表示モード[] enumArray = 表示モード.values();

            for (表示モード enumStr : enumArray) {
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

    public 表示モード getMode_表示モード() {
        return (表示モード) _CommonChildDivModeUtil.getMode( this.modes, 表示モード.class );
    }

    public void setMode_表示モード( 表示モード value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 表示モード.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
