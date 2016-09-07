package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiTaskList.YokaigoNinteiTaskList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * YokaigoNinteiTaskList のクラスファイル
 *
 * @author 自動生成
 */
public class YokaigoNinteiTaskListDiv extends Panel implements IYokaigoNinteiTaskListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtCompleteCount")
    private TextBox txtCompleteCount;
    @JsonProperty("txtTotalCount")
    private TextBox txtTotalCount;
    @JsonProperty("dgNinteiTaskList")
    private DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtCompleteCount
     * @return txtCompleteCount
     */
    @JsonProperty("txtCompleteCount")
    public TextBox getTxtCompleteCount() {
        return txtCompleteCount;
    }

    /*
     * settxtCompleteCount
     * @param txtCompleteCount txtCompleteCount
     */
    @JsonProperty("txtCompleteCount")
    public void setTxtCompleteCount(TextBox txtCompleteCount) {
        this.txtCompleteCount = txtCompleteCount;
    }

    /*
     * gettxtTotalCount
     * @return txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public TextBox getTxtTotalCount() {
        return txtTotalCount;
    }

    /*
     * settxtTotalCount
     * @param txtTotalCount txtTotalCount
     */
    @JsonProperty("txtTotalCount")
    public void setTxtTotalCount(TextBox txtTotalCount) {
        this.txtTotalCount = txtTotalCount;
    }

    /*
     * getdgNinteiTaskList
     * @return dgNinteiTaskList
     */
    @JsonProperty("dgNinteiTaskList")
    public DataGrid<dgNinteiTaskList_Row> getDgNinteiTaskList() {
        return dgNinteiTaskList;
    }

    /*
     * setdgNinteiTaskList
     * @param dgNinteiTaskList dgNinteiTaskList
     */
    @JsonProperty("dgNinteiTaskList")
    public void setDgNinteiTaskList(DataGrid<dgNinteiTaskList_Row> dgNinteiTaskList) {
        this.dgNinteiTaskList = dgNinteiTaskList;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum GridDisplayMode implements ICommonChildDivMode {

        KoshinTaisho("KoshinTaisho"),
        ShinseiUketsuke("ShinseiUketsuke"),
        ChosaIrai("ChosaIrai"),
        IkenshoIraisho("IkenshoIraisho"),
        ChosaNyushu("ChosaNyushu"),
        IkenshoNyushu("IkenshoNyushu"),
        IchijiHantei("IchijiHantei"),
        Masking("Masking"),
        ShinsakaiToroku("ShinsakaiToroku"),
        NijiHantei("NijiHantei"),
        GetsureiShori("GetsureiShori");

        private final String name;

        private GridDisplayMode(final String name) {
            this.name = name;
        }

        public static GridDisplayMode getEnum(String str) {
            GridDisplayMode[] enumArray = GridDisplayMode.values();

            for (GridDisplayMode enumStr : enumArray) {
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

    public GridDisplayMode getMode_GridDisplayMode() {
        return (GridDisplayMode) _CommonChildDivModeUtil.getMode(this.modes, GridDisplayMode.class);
    }

    public void setMode_GridDisplayMode(GridDisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, GridDisplayMode.class, value);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private YokaigoNinteiTaskListHandler getHandler() {
        return new YokaigoNinteiTaskListHandler(this);
    }

    /**
     * 共通子DIVの初期化処理です。
     *
     * @param モード
     */
    @Override
    public void initialize(RString モード) {
        getHandler().initialize(モード);
    }

    /**
     * 一覧件数を取得します。
     *
     * @return 一覧件数
     */
    @Override
    public RString 一覧件数() {
        return getHandler().一覧件数();
    }

    /**
     * 一览に選択のデータを取得します。
     *
     * @return 一览に選択のデータ
     */
    @Override
    public List<dgNinteiTaskList_Row> getCheckbox() {
        return getHandler().getCheckbox();
    }

    /**
     * 一览にデータを取得します。
     *
     * @return 一览のデータ
     */
    @Override
    public List<dgNinteiTaskList_Row> getDataSource() {
        return getHandler().getDataSource();
    }
}
