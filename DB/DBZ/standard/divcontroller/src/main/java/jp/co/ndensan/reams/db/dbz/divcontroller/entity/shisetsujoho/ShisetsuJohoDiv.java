package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho.IShisetsuJohoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShisetsuJohoHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.helper.ModeType;
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

    @JsonProperty("radShisetsuShurui")
    private RadioButton radShisetsuShurui;
    @JsonProperty("lblOtherShisetsuShurui")
    private Label lblOtherShisetsuShurui;
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
    @JsonProperty("radShisetsuShurui")
    @Override
    public RadioButton getRadShisetsuShurui() {
        return radShisetsuShurui;
    }

    @JsonProperty("radShisetsuShurui")
    public void setRadShisetsuShurui(RadioButton radShisetsuShurui) {
        this.radShisetsuShurui = radShisetsuShurui;
    }

    @JsonProperty("lblOtherShisetsuShurui")
    @Override
    public Label getLblOtherShisetsuShurui() {
        return lblOtherShisetsuShurui;
    }

    @JsonProperty("lblOtherShisetsuShurui")
    public void setLblOtherShisetsuShurui(Label lblOtherShisetsuShurui) {
        this.lblOtherShisetsuShurui = lblOtherShisetsuShurui;
    }

    @JsonProperty("txtShisetsuCode")
    @Override
    public TextBoxCode getTxtShisetsuCode() {
        return txtShisetsuCode;
    }

    @JsonProperty("txtShisetsuCode")
    public void setTxtShisetsuCode(TextBoxCode txtShisetsuCode) {
        this.txtShisetsuCode = txtShisetsuCode;
    }

    @JsonProperty("btnJigyoshaInputGuide")
    @Override
    public ButtonDialog getBtnJigyoshaInputGuide() {
        return btnJigyoshaInputGuide;
    }

    @JsonProperty("btnJigyoshaInputGuide")
    public void setBtnJigyoshaInputGuide(ButtonDialog btnJigyoshaInputGuide) {
        this.btnJigyoshaInputGuide = btnJigyoshaInputGuide;
    }

    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    @Override
    public ButtonDialog getBtnOtherTokureiShisetsuInputGuide() {
        return btnOtherTokureiShisetsuInputGuide;
    }

    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    public void setBtnOtherTokureiShisetsuInputGuide(ButtonDialog btnOtherTokureiShisetsuInputGuide) {
        this.btnOtherTokureiShisetsuInputGuide = btnOtherTokureiShisetsuInputGuide;
    }

    @JsonProperty("btnJogaiShisetsuInputGuide")
    @Override
    public ButtonDialog getBtnJogaiShisetsuInputGuide() {
        return btnJogaiShisetsuInputGuide;
    }

    @JsonProperty("btnJogaiShisetsuInputGuide")
    public void setBtnJogaiShisetsuInputGuide(ButtonDialog btnJogaiShisetsuInputGuide) {
        this.btnJogaiShisetsuInputGuide = btnJogaiShisetsuInputGuide;
    }

    @JsonProperty("txtShisetsuMeisho")
    @Override
    public TextBox getTxtShisetsuMeisho() {
        return txtShisetsuMeisho;
    }

    @JsonProperty("txtShisetsuMeisho")
    public void setTxtShisetsuMeisho(TextBox txtShisetsuMeisho) {
        this.txtShisetsuMeisho = txtShisetsuMeisho;
    }

    @JsonProperty("selectRow")
    @Override
    public RString getSelectRow() {
        return selectRow;
    }

    @JsonProperty("selectRow")
    public void setSelectRow(RString selectRow) {
        this.selectRow = selectRow;
    }

    @JsonProperty("inputMode")
    @Override
    public RString getInputMode() {
        return inputMode;
    }

    @JsonProperty("inputMode")
    public void setInputMode(RString inputMode) {
        this.inputMode = inputMode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum 除外施設選択 implements ICommonChildDivMode {

        表示する("表示する"),
        表示しない("表示しない");

        private final String name;

        private 除外施設選択(final String name) {
            this.name = name;
        }

        public static 除外施設選択 getEnum(String str) {
            除外施設選択[] enumArray = 除外施設選択.values();

            for (除外施設選択 enumStr : enumArray) {
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

    @Override
    public 除外施設選択 getMode_除外施設選択() {
        return (除外施設選択) _CommonChildDivModeUtil.getMode(this.modes, 除外施設選択.class);
    }

    @Override
    public void setMode_除外施設選択(除外施設選択 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 除外施設選択.class, value);
    }

    public static enum 他特例施設選択 implements ICommonChildDivMode {

        表示する("表示する"),
        表示しない("表示しない");

        private final String name;

        private 他特例施設選択(final String name) {
            this.name = name;
        }

        public static 他特例施設選択 getEnum(String str) {
            他特例施設選択[] enumArray = 他特例施設選択.values();

            for (他特例施設選択 enumStr : enumArray) {
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

    @Override
    public 他特例施設選択 getMode_他特例施設選択() {
        return (他特例施設選択) _CommonChildDivModeUtil.getMode(this.modes, 他特例施設選択.class);
    }

    @Override
    public void setMode_他特例施設選択(他特例施設選択 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 他特例施設選択.class, value);
    }

    public static enum 事業者選択 implements ICommonChildDivMode {

        表示する("表示する"),
        表示しない("表示しない");

        private final String name;

        private 事業者選択(final String name) {
            this.name = name;
        }

        public static 事業者選択 getEnum(String str) {
            事業者選択[] enumArray = 事業者選択.values();

            for (事業者選択 enumStr : enumArray) {
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

    @Override
    public 事業者選択 getMode_事業者選択() {
        return (事業者選択) _CommonChildDivModeUtil.getMode(this.modes, 事業者選択.class);
    }

    @Override
    public void setMode_事業者選択(事業者選択 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 事業者選択.class, value);
    }

    public static enum 施設選択表示 implements ICommonChildDivMode {

        表示する("表示する"),
        表示しない("表示しない");

        private final String name;

        private 施設選択表示(final String name) {
            this.name = name;
        }

        public static 施設選択表示 getEnum(String str) {
            施設選択表示[] enumArray = 施設選択表示.values();

            for (施設選択表示 enumStr : enumArray) {
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

    @Override
    public 施設選択表示 getMode_施設選択表示() {
        return (施設選択表示) _CommonChildDivModeUtil.getMode(this.modes, 施設選択表示.class);
    }

    @Override
    public void setMode_施設選択表示(施設選択表示 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 施設選択表示.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
    /**
     * divの状態を変更する処理をハンドラクラスに委譲します。
     */
    @Override
    public void onChange_radShisetsuShurui() {
        getHandler().onChange_radShisetsuShurui();
    }

// 以下のメソッドはインタフェースに定義していないので業務には公開されません。
    @JsonIgnore
    public ShisetsuJohoHandler getHandler() {
        return new ShisetsuJohoHandler(this);
    }
}
