package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.IryoHokenRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * IryoHokenRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class IryoHokenRirekiDiv extends Panel implements IIryoHokenRirekiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("plIryoHokenRireki")
    private plIryoHokenRirekiDiv plIryoHokenRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getplIryoHokenRireki
     * @return plIryoHokenRireki
     */
    @JsonProperty("plIryoHokenRireki")
    public plIryoHokenRirekiDiv getPlIryoHokenRireki() {
        return plIryoHokenRireki;
    }

    /*
     * setplIryoHokenRireki
     * @param plIryoHokenRireki plIryoHokenRireki
     */
    @JsonProperty("plIryoHokenRireki")
    public void setPlIryoHokenRireki(plIryoHokenRirekiDiv plIryoHokenRireki) {
        this.plIryoHokenRireki = plIryoHokenRireki;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        reference("reference"),
        referenceNoSelect("referenceNoSelect"),
        registration("registration");

        private final String name;

        private DisplayMode(final String name) {
            this.name = name;
        }

        public static DisplayMode getEnum(String str) {
            DisplayMode[] enumArray = DisplayMode.values();

            for (DisplayMode enumStr : enumArray) {
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

    public DisplayMode getMode_DisplayMode() {
        return (DisplayMode) _CommonChildDivModeUtil.getMode( this.modes, DisplayMode.class );
    }

    public void setMode_DisplayMode( DisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayMode.class , value );
    }

    public static enum WidthMode implements ICommonChildDivMode {

        Size1("Size1"),
        Size2("Size2"),
        Size3("Size3");

        private final String name;

        private WidthMode(final String name) {
            this.name = name;
        }

        public static WidthMode getEnum(String str) {
            WidthMode[] enumArray = WidthMode.values();

            for (WidthMode enumStr : enumArray) {
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

    public WidthMode getMode_WidthMode() {
        return (WidthMode) _CommonChildDivModeUtil.getMode( this.modes, WidthMode.class );
    }

    public void setMode_WidthMode( WidthMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, WidthMode.class , value );
    }

    public static enum MeisaiMode implements ICommonChildDivMode {

        meisai1("meisai1");

        private final String name;

        private MeisaiMode(final String name) {
            this.name = name;
        }

        public static MeisaiMode getEnum(String str) {
            MeisaiMode[] enumArray = MeisaiMode.values();

            for (MeisaiMode enumStr : enumArray) {
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

    public MeisaiMode getMode_MeisaiMode() {
        return (MeisaiMode) _CommonChildDivModeUtil.getMode( this.modes, MeisaiMode.class );
    }

    public void setMode_MeisaiMode( MeisaiMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, MeisaiMode.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTbdKanyubi() {
        return this.getPlIryoHokenRireki().getPnlIryohokenJoho().getTbdKanyubi();
    }

    @JsonIgnore
    public void  setTbdKanyubi(TextBoxDate tbdKanyubi) {
        this.getPlIryoHokenRireki().getPnlIryohokenJoho().setTbdKanyubi(tbdKanyubi);
    }

    @JsonIgnore
    public TextBoxDate getTbdDattabi() {
        return this.getPlIryoHokenRireki().getPnlIryohokenJoho().getTbdDattabi();
    }

    @JsonIgnore
    public void  setTbdDattabi(TextBoxDate tbdDattabi) {
        this.getPlIryoHokenRireki().getPnlIryohokenJoho().setTbdDattabi(tbdDattabi);
    }

    @JsonIgnore
    public DropDownList getDdlSyubetsu() {
        return this.getPlIryoHokenRireki().getPnlIryohokenJoho().getDdlSyubetsu();
    }

    @JsonIgnore
    public void  setDdlSyubetsu(DropDownList ddlSyubetsu) {
        this.getPlIryoHokenRireki().getPnlIryohokenJoho().setDdlSyubetsu(ddlSyubetsu);
    }

    @JsonIgnore
    public TextBox getTxtHokensyaKodo() {
        return this.getPlIryoHokenRireki().getPnlIryohokenJoho().getTxtHokensyaKodo();
    }

    @JsonIgnore
    public void  setTxtHokensyaKodo(TextBox txtHokensyaKodo) {
        this.getPlIryoHokenRireki().getPnlIryohokenJoho().setTxtHokensyaKodo(txtHokensyaKodo);
    }

    @JsonIgnore
    public TextBox getTxtHokensyaMeisho() {
        return this.getPlIryoHokenRireki().getPnlIryohokenJoho().getTxtHokensyaMeisho();
    }

    @JsonIgnore
    public void  setTxtHokensyaMeisho(TextBox txtHokensyaMeisho) {
        this.getPlIryoHokenRireki().getPnlIryohokenJoho().setTxtHokensyaMeisho(txtHokensyaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKigoBango() {
        return this.getPlIryoHokenRireki().getPnlIryohokenJoho().getTxtKigoBango();
    }

    @JsonIgnore
    public void  setTxtKigoBango(TextBox txtKigoBango) {
        this.getPlIryoHokenRireki().getPnlIryohokenJoho().setTxtKigoBango(txtKigoBango);
    }

    @JsonIgnore
    public Button getBtnKakutei() {
        return this.getPlIryoHokenRireki().getPnlIryohokenJoho().getBtnKakutei();
    }

    @JsonIgnore
    public void  setBtnKakutei(Button btnKakutei) {
        this.getPlIryoHokenRireki().getPnlIryohokenJoho().setBtnKakutei(btnKakutei);
    }

    @JsonIgnore
    public Button getBtnCancel() {
        return this.getPlIryoHokenRireki().getPnlIryohokenJoho().getBtnCancel();
    }

    @JsonIgnore
    public void  setBtnCancel(Button btnCancel) {
        this.getPlIryoHokenRireki().getPnlIryohokenJoho().setBtnCancel(btnCancel);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
