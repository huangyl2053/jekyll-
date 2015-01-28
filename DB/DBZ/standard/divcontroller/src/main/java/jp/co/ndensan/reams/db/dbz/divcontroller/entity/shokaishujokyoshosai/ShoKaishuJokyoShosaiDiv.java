package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyoshosai;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShoKaishuJokyoShosai のクラスファイル
 *
 * @author 自動生成
 */
public class ShoKaishuJokyoShosaiDiv extends Panel implements IShoKaishuJokyoShosaiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("txtShoKofuShurui")
    private TextBox txtShoKofuShurui;
    @JsonProperty("txtKofuDate")
    private TextBoxFlexibleDate txtKofuDate;
    @JsonProperty("txtYukoKigen")
    private TextBoxFlexibleDate txtYukoKigen;
    @JsonProperty("txtKofuJiyu")
    private TextBox txtKofuJiyu;
    @JsonProperty("txtKofuRiyu")
    private TextBoxMultiLine txtKofuRiyu;
    @JsonProperty("txtKaishuDate")
    private TextBoxFlexibleDate txtKaishuDate;
    @JsonProperty("ddlKaishuJiyu")
    private DropDownList ddlKaishuJiyu;
    @JsonProperty("txtKaishuRiyu")
    private TextBoxMultiLine txtKaishuRiyu;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("txtShoKofuShurui")
    public TextBox getTxtShoKofuShurui() {
        return txtShoKofuShurui;
    }

    @JsonProperty("txtShoKofuShurui")
    public void setTxtShoKofuShurui(TextBox txtShoKofuShurui) {
        this.txtShoKofuShurui = txtShoKofuShurui;
    }

    @JsonProperty("txtKofuDate")
    public TextBoxFlexibleDate getTxtKofuDate() {
        return txtKofuDate;
    }

    @JsonProperty("txtKofuDate")
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.txtKofuDate = txtKofuDate;
    }

    @JsonProperty("txtYukoKigen")
    public TextBoxFlexibleDate getTxtYukoKigen() {
        return txtYukoKigen;
    }

    @JsonProperty("txtYukoKigen")
    public void setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.txtYukoKigen = txtYukoKigen;
    }

    @JsonProperty("txtKofuJiyu")
    public TextBox getTxtKofuJiyu() {
        return txtKofuJiyu;
    }

    @JsonProperty("txtKofuJiyu")
    public void setTxtKofuJiyu(TextBox txtKofuJiyu) {
        this.txtKofuJiyu = txtKofuJiyu;
    }

    @JsonProperty("txtKofuRiyu")
    public TextBoxMultiLine getTxtKofuRiyu() {
        return txtKofuRiyu;
    }

    @JsonProperty("txtKofuRiyu")
    public void setTxtKofuRiyu(TextBoxMultiLine txtKofuRiyu) {
        this.txtKofuRiyu = txtKofuRiyu;
    }

    @JsonProperty("txtKaishuDate")
    public TextBoxFlexibleDate getTxtKaishuDate() {
        return txtKaishuDate;
    }

    @JsonProperty("txtKaishuDate")
    public void setTxtKaishuDate(TextBoxFlexibleDate txtKaishuDate) {
        this.txtKaishuDate = txtKaishuDate;
    }

    @JsonProperty("ddlKaishuJiyu")
    public DropDownList getDdlKaishuJiyu() {
        return ddlKaishuJiyu;
    }

    @JsonProperty("ddlKaishuJiyu")
    public void setDdlKaishuJiyu(DropDownList ddlKaishuJiyu) {
        this.ddlKaishuJiyu = ddlKaishuJiyu;
    }

    @JsonProperty("txtKaishuRiyu")
    public TextBoxMultiLine getTxtKaishuRiyu() {
        return txtKaishuRiyu;
    }

    @JsonProperty("txtKaishuRiyu")
    public void setTxtKaishuRiyu(TextBoxMultiLine txtKaishuRiyu) {
        this.txtKaishuRiyu = txtKaishuRiyu;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum 表示方法 implements ICommonChildDivMode {

        照会("照会"),
        入力("入力"),
        非表示("非表示");

        private final String name;

        private 表示方法(final String name) {
            this.name = name;
        }

        public static 表示方法 getEnum(String str) {
            表示方法[] enumArray = 表示方法.values();

            for (表示方法 enumStr : enumArray) {
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

    public 表示方法 getMode_表示方法() {
        return (表示方法) _CommonChildDivModeUtil.getMode(this.modes, 表示方法.class);
    }

    public void setMode_表示方法(表示方法 value) {
        _CommonChildDivModeUtil.setMode(this.modes, 表示方法.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
}
