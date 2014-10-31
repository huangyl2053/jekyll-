package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shokaishujokyolist.IShoKaishuJokyoListDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShisetsuJohoHandler;
import jp.co.ndensan.reams.db.dbz.divcontroller.controller.ShoKaishuJokyoListHandler;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShoKaishuJokyoList のクラスファイル
 *
 * @author 自動生成
 */
public class ShoKaishuJokyoListDiv extends Panel implements IShoKaishuJokyoListDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("dgShoKaishuJokyo")
    private DataGrid<dgShoKaishuJokyo_Row> dgShoKaishuJokyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("dgShoKaishuJokyo")
    public DataGrid<dgShoKaishuJokyo_Row> getDgShoKaishuJokyo() {
        return dgShoKaishuJokyo;
    }

    @JsonProperty("dgShoKaishuJokyo")
    public void setDgShoKaishuJokyo(DataGrid<dgShoKaishuJokyo_Row> dgShoKaishuJokyo) {
        this.dgShoKaishuJokyo = dgShoKaishuJokyo;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DataGridのisShowSelectButtonColumn implements ICommonChildDivMode {

        表示する("表示する"),
        表示しない("表示しない");

        private final String name;

        private DataGridのisShowSelectButtonColumn(final String name) {
            this.name = name;
        }

        public static DataGridのisShowSelectButtonColumn getEnum(String str) {
            DataGridのisShowSelectButtonColumn[] enumArray = DataGridのisShowSelectButtonColumn.values();

            for (DataGridのisShowSelectButtonColumn enumStr : enumArray) {
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

    public DataGridのisShowSelectButtonColumn getMode_DataGridのisShowSelectButtonColumn() {
        return (DataGridのisShowSelectButtonColumn) _CommonChildDivModeUtil.getMode(this.modes, DataGridのisShowSelectButtonColumn.class);
    }

    @Override
    public void setMode_DataGridのisShowSelectButtonColumn(DataGridのisShowSelectButtonColumn value) {
        _CommonChildDivModeUtil.setMode(this.modes, DataGridのisShowSelectButtonColumn.class, value);
    }

    public static enum DataGridのheight implements ICommonChildDivMode {

        サイズ200("サイズ200"),
        サイズ250("サイズ250"),
        サイズ300("サイズ300"),
        サイズ350("サイズ350"),
        サイズ400("サイズ400"),
        サイズ450("サイズ450"),
        サイズ500("サイズ500");

        private final String name;

        private DataGridのheight(final String name) {
            this.name = name;
        }

        public static DataGridのheight getEnum(String str) {
            DataGridのheight[] enumArray = DataGridのheight.values();

            for (DataGridのheight enumStr : enumArray) {
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

    public DataGridのheight getMode_DataGridのheight() {
        return (DataGridのheight) _CommonChildDivModeUtil.getMode(this.modes, DataGridのheight.class);
    }

    @Override
    public void setMode_DataGridのheight(DataGridのheight value) {
        _CommonChildDivModeUtil.setMode(this.modes, DataGridのheight.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
// 以下のメソッドはインタフェースに定義していないので業務には公開されません。
    @JsonIgnore
    public ShoKaishuJokyoListHandler getHandler() {
        return new ShoKaishuJokyoListHandler(this);
    }
}
