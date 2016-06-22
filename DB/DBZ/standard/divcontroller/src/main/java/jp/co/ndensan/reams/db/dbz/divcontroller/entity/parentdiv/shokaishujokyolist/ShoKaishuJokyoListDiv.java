package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.shokaishujokyolist;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
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
    @Override
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

    public static enum GridHyojiMode implements ICommonChildDivMode {

        shokai("shokai"),
        toroku("toroku"),
        select("select");

        private final String name;

        private GridHyojiMode(final String name) {
            this.name = name;
        }

        public static GridHyojiMode getEnum(String str) {
            GridHyojiMode[] enumArray = GridHyojiMode.values();

            for (GridHyojiMode enumStr : enumArray) {
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

    public GridHyojiMode getMode_GridHyojiMode() {
        return (GridHyojiMode) _CommonChildDivModeUtil.getMode(this.modes, GridHyojiMode.class);
    }

    public void setMode_GridHyojiMode(GridHyojiMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, GridHyojiMode.class, value);
    }

    public static enum IchiranPanelTakasa implements ICommonChildDivMode {

        Size200("Size200"),
        Size250("Size250"),
        Size300("Size300"),
        Size350("Size350"),
        Size400("Size400"),
        Size450("Size450"),
        Size500("Size500");

        private final String name;

        private IchiranPanelTakasa(final String name) {
            this.name = name;
        }

        public static IchiranPanelTakasa getEnum(String str) {
            IchiranPanelTakasa[] enumArray = IchiranPanelTakasa.values();

            for (IchiranPanelTakasa enumStr : enumArray) {
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

    public IchiranPanelTakasa getMode_IchiranPanelTakasa() {
        return (IchiranPanelTakasa) _CommonChildDivModeUtil.getMode(this.modes, IchiranPanelTakasa.class);
    }

    public void setMode_IchiranPanelTakasa(IchiranPanelTakasa value) {
        _CommonChildDivModeUtil.setMode(this.modes, IchiranPanelTakasa.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
}
