package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShoKaishuJokyoShosai;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShoKaishuJokyoShosai のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShoKaishuJokyoShosaiDiv extends Panel implements IShoKaishuJokyoShosaiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    /*
     * gettxtShoKofuShurui
     * @return txtShoKofuShurui
     */
    @JsonProperty("txtShoKofuShurui")
    public TextBox getTxtShoKofuShurui() {
        return txtShoKofuShurui;
    }

    /*
     * settxtShoKofuShurui
     * @param txtShoKofuShurui txtShoKofuShurui
     */
    @JsonProperty("txtShoKofuShurui")
    public void setTxtShoKofuShurui(TextBox txtShoKofuShurui) {
        this.txtShoKofuShurui = txtShoKofuShurui;
    }

    /*
     * gettxtKofuDate
     * @return txtKofuDate
     */
    @JsonProperty("txtKofuDate")
    public TextBoxFlexibleDate getTxtKofuDate() {
        return txtKofuDate;
    }

    /*
     * settxtKofuDate
     * @param txtKofuDate txtKofuDate
     */
    @JsonProperty("txtKofuDate")
    public void setTxtKofuDate(TextBoxFlexibleDate txtKofuDate) {
        this.txtKofuDate = txtKofuDate;
    }

    /*
     * gettxtYukoKigen
     * @return txtYukoKigen
     */
    @JsonProperty("txtYukoKigen")
    public TextBoxFlexibleDate getTxtYukoKigen() {
        return txtYukoKigen;
    }

    /*
     * settxtYukoKigen
     * @param txtYukoKigen txtYukoKigen
     */
    @JsonProperty("txtYukoKigen")
    public void setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.txtYukoKigen = txtYukoKigen;
    }

    /*
     * gettxtKofuJiyu
     * @return txtKofuJiyu
     */
    @JsonProperty("txtKofuJiyu")
    public TextBox getTxtKofuJiyu() {
        return txtKofuJiyu;
    }

    /*
     * settxtKofuJiyu
     * @param txtKofuJiyu txtKofuJiyu
     */
    @JsonProperty("txtKofuJiyu")
    public void setTxtKofuJiyu(TextBox txtKofuJiyu) {
        this.txtKofuJiyu = txtKofuJiyu;
    }

    /*
     * gettxtKofuRiyu
     * @return txtKofuRiyu
     */
    @JsonProperty("txtKofuRiyu")
    public TextBoxMultiLine getTxtKofuRiyu() {
        return txtKofuRiyu;
    }

    /*
     * settxtKofuRiyu
     * @param txtKofuRiyu txtKofuRiyu
     */
    @JsonProperty("txtKofuRiyu")
    public void setTxtKofuRiyu(TextBoxMultiLine txtKofuRiyu) {
        this.txtKofuRiyu = txtKofuRiyu;
    }

    /*
     * gettxtKaishuDate
     * @return txtKaishuDate
     */
    @JsonProperty("txtKaishuDate")
    public TextBoxFlexibleDate getTxtKaishuDate() {
        return txtKaishuDate;
    }

    /*
     * settxtKaishuDate
     * @param txtKaishuDate txtKaishuDate
     */
    @JsonProperty("txtKaishuDate")
    public void setTxtKaishuDate(TextBoxFlexibleDate txtKaishuDate) {
        this.txtKaishuDate = txtKaishuDate;
    }

    /*
     * getddlKaishuJiyu
     * @return ddlKaishuJiyu
     */
    @JsonProperty("ddlKaishuJiyu")
    public DropDownList getDdlKaishuJiyu() {
        return ddlKaishuJiyu;
    }

    /*
     * setddlKaishuJiyu
     * @param ddlKaishuJiyu ddlKaishuJiyu
     */
    @JsonProperty("ddlKaishuJiyu")
    public void setDdlKaishuJiyu(DropDownList ddlKaishuJiyu) {
        this.ddlKaishuJiyu = ddlKaishuJiyu;
    }

    /*
     * gettxtKaishuRiyu
     * @return txtKaishuRiyu
     */
    @JsonProperty("txtKaishuRiyu")
    public TextBoxMultiLine getTxtKaishuRiyu() {
        return txtKaishuRiyu;
    }

    /*
     * settxtKaishuRiyu
     * @param txtKaishuRiyu txtKaishuRiyu
     */
    @JsonProperty("txtKaishuRiyu")
    public void setTxtKaishuRiyu(TextBoxMultiLine txtKaishuRiyu) {
        this.txtKaishuRiyu = txtKaishuRiyu;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum HyojiHoho implements ICommonChildDivMode {

        照会("照会"),
        入力("入力"),
        非表示("非表示");

        private final String name;

        private HyojiHoho(final String name) {
            this.name = name;
        }

        public static HyojiHoho getEnum(String str) {
            HyojiHoho[] enumArray = HyojiHoho.values();

            for (HyojiHoho enumStr : enumArray) {
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

    public HyojiHoho getMode_HyojiHoho() {
        return (HyojiHoho) _CommonChildDivModeUtil.getMode( this.modes, HyojiHoho.class );
    }

    public void setMode_HyojiHoho( HyojiHoho value ) {
        _CommonChildDivModeUtil.setMode( this.modes, HyojiHoho.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
