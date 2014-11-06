package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shisetsunyutaishorirekikanri;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
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
    @JsonProperty("btnAddShisetsuNyutaisho")
    public Button getBtnAddShisetsuNyutaisho() {
        return btnAddShisetsuNyutaisho;
    }

    @JsonProperty("btnAddShisetsuNyutaisho")
    public void setBtnAddShisetsuNyutaisho(Button btnAddShisetsuNyutaisho) {
        this.btnAddShisetsuNyutaisho = btnAddShisetsuNyutaisho;
    }

    @JsonProperty("dgShisetsuNyutaishoRireki")
    public DataGrid<dgShisetsuNyutaishoRireki_Row> getDgShisetsuNyutaishoRireki() {
        return dgShisetsuNyutaishoRireki;
    }

    @JsonProperty("dgShisetsuNyutaishoRireki")
    public void setDgShisetsuNyutaishoRireki(DataGrid<dgShisetsuNyutaishoRireki_Row> dgShisetsuNyutaishoRireki) {
        this.dgShisetsuNyutaishoRireki = dgShisetsuNyutaishoRireki;
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

    public static enum 表示Heightサイズ implements ICommonChildDivMode {

        サイズ200("サイズ200"),
        サイズ250("サイズ250"),
        サイズ300("サイズ300"),
        サイズ350("サイズ350"),
        サイズ400("サイズ400"),
        サイズ450("サイズ450"),
        サイズ500("サイズ500");

        private final String name;

        private 表示Heightサイズ(final String name) {
            this.name = name;
        }

        public static 表示Heightサイズ getEnum(String str) {
            表示Heightサイズ[] enumArray = 表示Heightサイズ.values();

            for (表示Heightサイズ enumStr : enumArray) {
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

    public 表示Heightサイズ getMode_表示Heightサイズ() {
        return (表示Heightサイズ) _CommonChildDivModeUtil.getMode(this.modes, 表示Heightサイズ.class);
    }

    public void setMode_表示Heightサイズ(表示Heightサイズ value) {
        _CommonChildDivModeUtil.setMode(this.modes, 表示Heightサイズ.class, value);
    }

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
        return (表示widthサイズ) _CommonChildDivModeUtil.getMode(this.modes, 表示widthサイズ.class);
    }

    public void setMode_表示widthサイズ(表示widthサイズ value) {
        _CommonChildDivModeUtil.setMode(this.modes, 表示widthサイズ.class, value);
    }

    public static enum 表示モード implements ICommonChildDivMode {

        登録("登録"),
        照会("照会"),
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
        return (表示モード) _CommonChildDivModeUtil.getMode(this.modes, 表示モード.class);
    }

    public void setMode_表示モード(表示モード value) {
        _CommonChildDivModeUtil.setMode(this.modes, 表示モード.class, value);
    }

    public static enum 台帳種別の列を implements ICommonChildDivMode {

        表示しない("表示しない"),
        表示する("表示する");

        private final String name;

        private 台帳種別の列を(final String name) {
            this.name = name;
        }

        public static 台帳種別の列を getEnum(String str) {
            台帳種別の列を[] enumArray = 台帳種別の列を.values();

            for (台帳種別の列を enumStr : enumArray) {
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

    public 台帳種別の列を getMode_台帳種別の列を() {
        return (台帳種別の列を) _CommonChildDivModeUtil.getMode(this.modes, 台帳種別の列を.class);
    }

    public void setMode_台帳種別の列を(台帳種別の列を value) {
        _CommonChildDivModeUtil.setMode(this.modes, 台帳種別の列を.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
}
