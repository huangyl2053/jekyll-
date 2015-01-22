package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsujoho;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.DaichoType;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.ShisetsuType;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShisetsuCode;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
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
        this.ddlDaichoShubetsu = ddlDaichoShubetsu;
    }

    @JsonProperty("radShisetsuShurui")
    public RadioButton getRadShisetsuShurui() {
        return radShisetsuShurui;
    }

    @JsonProperty("radShisetsuShurui")
    public void setRadShisetsuShurui(RadioButton radShisetsuShurui) {
        this.radShisetsuShurui = radShisetsuShurui;
    }

    @JsonProperty("txtShisetsuCode")
    public TextBoxCode getTxtShisetsuCode() {
        return txtShisetsuCode;
    }

    @JsonProperty("txtShisetsuCode")
    public void setTxtShisetsuCode(TextBoxCode txtShisetsuCode) {
        this.txtShisetsuCode = txtShisetsuCode;
    }

    @JsonProperty("btnJigyoshaInputGuide")
    public ButtonDialog getBtnJigyoshaInputGuide() {
        return btnJigyoshaInputGuide;
    }

    @JsonProperty("btnJigyoshaInputGuide")
    public void setBtnJigyoshaInputGuide(ButtonDialog btnJigyoshaInputGuide) {
        this.btnJigyoshaInputGuide = btnJigyoshaInputGuide;
    }

    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    public ButtonDialog getBtnOtherTokureiShisetsuInputGuide() {
        return btnOtherTokureiShisetsuInputGuide;
    }

    @JsonProperty("btnOtherTokureiShisetsuInputGuide")
    public void setBtnOtherTokureiShisetsuInputGuide(ButtonDialog btnOtherTokureiShisetsuInputGuide) {
        this.btnOtherTokureiShisetsuInputGuide = btnOtherTokureiShisetsuInputGuide;
    }

    @JsonProperty("btnJogaiShisetsuInputGuide")
    public ButtonDialog getBtnJogaiShisetsuInputGuide() {
        return btnJogaiShisetsuInputGuide;
    }

    @JsonProperty("btnJogaiShisetsuInputGuide")
    public void setBtnJogaiShisetsuInputGuide(ButtonDialog btnJogaiShisetsuInputGuide) {
        this.btnJogaiShisetsuInputGuide = btnJogaiShisetsuInputGuide;
    }

    @JsonProperty("txtShisetsuMeisho")
    public TextBox getTxtShisetsuMeisho() {
        return txtShisetsuMeisho;
    }

    @JsonProperty("txtShisetsuMeisho")
    public void setTxtShisetsuMeisho(TextBox txtShisetsuMeisho) {
        this.txtShisetsuMeisho = txtShisetsuMeisho;
    }

    @JsonProperty("selectRow")
    public RString getSelectRow() {
        return selectRow;
    }

    @JsonProperty("selectRow")
    public void setSelectRow(RString selectRow) {
        this.selectRow = selectRow;
    }

    @JsonProperty("inputMode")
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
        return (台帳種別) _CommonChildDivModeUtil.getMode(this.modes, 台帳種別.class);
    }

    public void setMode_台帳種別(台帳種別 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 台帳種別.class, value);
    }

    public static enum 利用機能 implements ICommonChildDivMode {

        台帳種別表示機能("台帳種別表示機能"),
        全施設対象機能("全施設対象機能"),
        被保険者対象機能("被保険者対象機能"),
        他市町村住所地特例者対象機能("他市町村住所地特例者対象機能"),
        適用除外者対象機能("適用除外者対象機能");

        private final String name;

        private 利用機能(final String name) {
            this.name = name;
        }

        public static 利用機能 getEnum(String str) {
            利用機能[] enumArray = 利用機能.values();

            for (利用機能 enumStr : enumArray) {
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

    public 利用機能 getMode_利用機能() {
        return (利用機能) _CommonChildDivModeUtil.getMode(this.modes, 利用機能.class);
    }

    public void setMode_利用機能(利用機能 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 利用機能.class, value);
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
        return (施設種類) _CommonChildDivModeUtil.getMode(this.modes, 施設種類.class);
    }

    public void setMode_施設種類(施設種類 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 施設種類.class, value);
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
        return (入力補助) _CommonChildDivModeUtil.getMode(this.modes, 入力補助.class);
    }

    public void setMode_入力補助(入力補助 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 入力補助.class, value);
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
        return (表示モード) _CommonChildDivModeUtil.getMode(this.modes, 表示モード.class);
    }

    public void setMode_表示モード(表示モード value) {
        _CommonChildDivModeUtil.setMode(this.modes, 表示モード.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void set利用機能(int 利用機能) {
        getHandler().set利用機能(利用機能);
    }

    @Override
    public void set台帳種別(RString 台帳種別キー) {
        ddlDaichoShubetsu.setSelectedKey(台帳種別キー);
        getHandler().select台帳種別();
    }

    @Override
    public void set施設種類(RString 施設種類キー) {
        radShisetsuShurui.setSelectedKey(施設種類キー);
        getHandler().select施設種類();
    }

    @Override
    public void set入所施設コード(RString 入所施設コード) {
        txtShisetsuCode.setValue(入所施設コード);
    }

    @Override
    public void set施設名称(RString 施設名称) {
        txtShisetsuMeisho.setValue(施設名称);
    }

    @Override
    public Optional<DaichoType> get台帳種別() {
        return getHandler().get台帳種別();
    }

    @Override
    public ShisetsuType get施設種類() {
        return getHandler().get施設種類();
    }

    @JsonIgnore
    @Override
    public ShisetsuCode get入所施設コード() {
        return new ShisetsuCode(txtShisetsuCode.getValue());
    }

    @Override
    public RString get施設名称() {
        return txtShisetsuMeisho.getValue();
    }

    @Override
    public void set入力可() {
        getHandler().set入力可();
    }

    @Override
    public void set入力不可() {
        getHandler().set入力不可();
    }

    @Override
    public void initialize() {
        getHandler().initialize();
    }

    @Override
    public void clear() {
        getHandler().clearTxt();
    }

// 以下のメソッドはインタフェースに定義していないので業務には公開されません。
    @JsonIgnore
    private ShisetsuJohoHandler getHandler() {
        return new ShisetsuJohoHandler(this);
    }
}
