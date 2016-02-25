package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri;
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
 * ShisetsuNyutaishoRirekiKanri のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShisetsuNyutaishoRirekiKanriDiv extends Panel implements IShisetsuNyutaishoRirekiKanriDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAddShisetsuNyutaisho")
    private Button btnAddShisetsuNyutaisho;
    @JsonProperty("dgShisetsuNyutaishoRireki")
    private DataGrid<dgShisetsuNyutaishoRireki_Row> dgShisetsuNyutaishoRireki;
    @JsonProperty("ShisetsuNyutaishoInput")
    private ShisetsuNyutaishoInputDiv ShisetsuNyutaishoInput;
    @JsonProperty("selectRow")
    private RString selectRow;
    @JsonProperty("inputMode")
    private RString inputMode;
    @JsonProperty("shichosonCode")
    private RString shichosonCode;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddShisetsuNyutaisho
     * @return btnAddShisetsuNyutaisho
     */
    @JsonProperty("btnAddShisetsuNyutaisho")
    public Button getBtnAddShisetsuNyutaisho() {
        return btnAddShisetsuNyutaisho;
    }

    /*
     * setbtnAddShisetsuNyutaisho
     * @param btnAddShisetsuNyutaisho btnAddShisetsuNyutaisho
     */
    @JsonProperty("btnAddShisetsuNyutaisho")
    public void setBtnAddShisetsuNyutaisho(Button btnAddShisetsuNyutaisho) {
        this.btnAddShisetsuNyutaisho = btnAddShisetsuNyutaisho;
    }

    /*
     * getdgShisetsuNyutaishoRireki
     * @return dgShisetsuNyutaishoRireki
     */
    @JsonProperty("dgShisetsuNyutaishoRireki")
    public DataGrid<dgShisetsuNyutaishoRireki_Row> getDgShisetsuNyutaishoRireki() {
        return dgShisetsuNyutaishoRireki;
    }

    /*
     * setdgShisetsuNyutaishoRireki
     * @param dgShisetsuNyutaishoRireki dgShisetsuNyutaishoRireki
     */
    @JsonProperty("dgShisetsuNyutaishoRireki")
    public void setDgShisetsuNyutaishoRireki(DataGrid<dgShisetsuNyutaishoRireki_Row> dgShisetsuNyutaishoRireki) {
        this.dgShisetsuNyutaishoRireki = dgShisetsuNyutaishoRireki;
    }

    /*
     * getShisetsuNyutaishoInput
     * @return ShisetsuNyutaishoInput
     */
    @JsonProperty("ShisetsuNyutaishoInput")
    public ShisetsuNyutaishoInputDiv getShisetsuNyutaishoInput() {
        return ShisetsuNyutaishoInput;
    }

    /*
     * setShisetsuNyutaishoInput
     * @param ShisetsuNyutaishoInput ShisetsuNyutaishoInput
     */
    @JsonProperty("ShisetsuNyutaishoInput")
    public void setShisetsuNyutaishoInput(ShisetsuNyutaishoInputDiv ShisetsuNyutaishoInput) {
        this.ShisetsuNyutaishoInput = ShisetsuNyutaishoInput;
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
     * getshichosonCode
     * @return shichosonCode
     */
    @JsonProperty("shichosonCode")
    public RString getShichosonCode() {
        return shichosonCode;
    }

    /*
     * setshichosonCode
     * @param shichosonCode shichosonCode
     */
    @JsonProperty("shichosonCode")
    public void setShichosonCode(RString shichosonCode) {
        this.shichosonCode = shichosonCode;
    }

    /*
     * getshikibetsuCode
     * @return shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public RString getShikibetsuCode() {
        return shikibetsuCode;
    }

    /*
     * setshikibetsuCode
     * @param shikibetsuCode shikibetsuCode
     */
    @JsonProperty("shikibetsuCode")
    public void setShikibetsuCode(RString shikibetsuCode) {
        this.shikibetsuCode = shikibetsuCode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum 表示widthサイズ implements ICommonChildDivMode {

        モード1("モード1"),
        モード2("モード2"),
        モード3("モード3"),
        モード4("モード4"),
        モード5("モード5");

        private final String name;

        private 表示widthサイズ(final String name) {
            this.name = name;
        }

        public static 表示widthサイズ getEnum(String str) {
            表示widthサイズ[] enumArray = 表示widthサイズ.values();

            for (表示widthサイズ enumStr : enumArray) {
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

    public 表示widthサイズ getMode_表示widthサイズ() {
        return (表示widthサイズ) _CommonChildDivModeUtil.getMode( this.modes, 表示widthサイズ.class );
    }

    public void setMode_表示widthサイズ( 表示widthサイズ value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 表示widthサイズ.class , value );
    }

    public static enum 利用 implements ICommonChildDivMode {

        台帳種別表示機能("台帳種別表示機能"),
        全施設対象機能("全施設対象機能"),
        被保険者対象機能("被保険者対象機能"),
        他市町村住所地特例者対象機能("他市町村住所地特例者対象機能"),
        適用除外者対象機能("適用除外者対象機能");

        private final String name;

        private 利用(final String name) {
            this.name = name;
        }

        public static 利用 getEnum(String str) {
            利用[] enumArray = 利用.values();

            for (利用 enumStr : enumArray) {
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

    public 利用 getMode_利用() {
        return (利用) _CommonChildDivModeUtil.getMode( this.modes, 利用.class );
    }

    public void setMode_利用( 利用 value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 利用.class , value );
    }

    public static enum 表示heightサイズ implements ICommonChildDivMode {

        サイズ200("サイズ200"),
        サイズ250("サイズ250"),
        サイズ300("サイズ300"),
        サイズ350("サイズ350"),
        サイズ400("サイズ400"),
        サイズ450("サイズ450"),
        サイズ500("サイズ500");

        private final String name;

        private 表示heightサイズ(final String name) {
            this.name = name;
        }

        public static 表示heightサイズ getEnum(String str) {
            表示heightサイズ[] enumArray = 表示heightサイズ.values();

            for (表示heightサイズ enumStr : enumArray) {
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

    public 表示heightサイズ getMode_表示heightサイズ() {
        return (表示heightサイズ) _CommonChildDivModeUtil.getMode( this.modes, 表示heightサイズ.class );
    }

    public void setMode_表示heightサイズ( 表示heightサイズ value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 表示heightサイズ.class , value );
    }

    public static enum 表示モード implements ICommonChildDivMode {

        登録("登録"),
        照会("照会"),
        照会選択有("照会選択有"),
        資格異動("資格異動");

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

    public static enum 明細表示モード implements ICommonChildDivMode {

        追加_修正("追加_修正"),
        削除("削除"),
        選択不可("選択不可"),
        非表示("非表示");

        private final String name;

        private 明細表示モード(final String name) {
            this.name = name;
        }

        public static 明細表示モード getEnum(String str) {
            明細表示モード[] enumArray = 明細表示モード.values();

            for (明細表示モード enumStr : enumArray) {
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

    public 明細表示モード getMode_明細表示モード() {
        return (明細表示モード) _CommonChildDivModeUtil.getMode( this.modes, 明細表示モード.class );
    }

    public void setMode_明細表示モード( 明細表示モード value ) {
        _CommonChildDivModeUtil.setMode( this.modes, 明細表示モード.class , value );
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
