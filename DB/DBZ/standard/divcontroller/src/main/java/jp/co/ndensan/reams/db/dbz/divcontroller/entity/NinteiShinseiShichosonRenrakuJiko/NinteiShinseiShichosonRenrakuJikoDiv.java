package jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiShinseiShichosonRenrakuJiko;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.NinteiShinseiShichosonRenrakuJiko.INinteiShinseiShichosonRenrakuJikoDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * NinteiShinseiShichosonRenrakuJiko のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiShinseiShichosonRenrakuJikoDiv extends Panel implements INinteiShinseiShichosonRenrakuJikoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：Uz-master-44">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtRenrakujiko")
    private TextBoxMultiLine txtRenrakujiko;
    @JsonProperty("btnToroku")
    private Button btnToroku;
    @JsonProperty("btnModoru")
    private Button btnModoru;
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
    @JsonProperty("txtRenrakujiko")
    public TextBoxMultiLine getTxtRenrakujiko() {
        return txtRenrakujiko;
    }

    @JsonProperty("txtRenrakujiko")
    public void setTxtRenrakujiko(TextBoxMultiLine txtRenrakujiko) {
        this.txtRenrakujiko=txtRenrakujiko;
    }

    @JsonProperty("btnToroku")
    public Button getBtnToroku() {
        return btnToroku;
    }

    @JsonProperty("btnToroku")
    public void setBtnToroku(Button btnToroku) {
        this.btnToroku=btnToroku;
    }

    @JsonProperty("btnModoru")
    public Button getBtnModoru() {
        return btnModoru;
    }

    @JsonProperty("btnModoru")
    public void setBtnModoru(Button btnModoru) {
        this.btnModoru=btnModoru;
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

    public static enum ShoriType implements ICommonChildDivMode {

        InputMode("InputMode"),
        ShokaiMode("ShokaiMode");

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
        return (ShoriType) _CommonChildDivModeUtil.getMode( this.modes, ShoriType.class );
    }

    public void setMode_ShoriType( ShoriType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ShoriType.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
