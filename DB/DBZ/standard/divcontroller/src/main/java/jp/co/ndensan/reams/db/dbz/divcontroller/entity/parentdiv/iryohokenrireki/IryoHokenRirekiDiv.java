package jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.iryohokenrireki;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbz.business.core.basic.IryohokenKanyuJokyo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * IryoHokenRireki のクラスファイル
 *
 * @author 自動生成
 */
public class IryoHokenRirekiDiv extends Panel implements IIryoHokenRirekiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("btnAddIryoHoken")
    private Button btnAddIryoHoken;
    @JsonProperty("dgIryoHokenRireki")
    private DataGrid<dgIryoHokenRireki_Row> dgIryoHokenRireki;
    @JsonProperty("IryoHokenInput")
    private IryoHokenInputDiv IryoHokenInput;
    @JsonProperty("mode")
    private RString mode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddIryoHoken")
    public Button getBtnAddIryoHoken() {
        return btnAddIryoHoken;
    }

    @JsonProperty("btnAddIryoHoken")
    public void setBtnAddIryoHoken(Button btnAddIryoHoken) {
        this.btnAddIryoHoken = btnAddIryoHoken;
    }

    @JsonProperty("dgIryoHokenRireki")
    public DataGrid<dgIryoHokenRireki_Row> getDgIryoHokenRireki() {
        return dgIryoHokenRireki;
    }

    @JsonProperty("dgIryoHokenRireki")
    public void setDgIryoHokenRireki(DataGrid<dgIryoHokenRireki_Row> dgIryoHokenRireki) {
        this.dgIryoHokenRireki = dgIryoHokenRireki;
    }

    @JsonProperty("IryoHokenInput")
    public IryoHokenInputDiv getIryoHokenInput() {
        return IryoHokenInput;
    }

    @JsonProperty("IryoHokenInput")
    public void setIryoHokenInput(IryoHokenInputDiv IryoHokenInput) {
        this.IryoHokenInput = IryoHokenInput;
    }

    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        Toroku("Toroku"),
        Shokai("Shokai"),
        ShikakuIdo("ShikakuIdo");

        private final String name;

        private DisplayMode(final String name) {
            this.name = name;
        }

        public static DisplayMode getEnum(String str) {
            DisplayMode[] enumArray = DisplayMode.values();

            for (DisplayMode enumStr : enumArray) {
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

    public DisplayMode getMode_DisplayMode() {
        return (DisplayMode) _CommonChildDivModeUtil.getMode(this.modes, DisplayMode.class);
    }

    public void setMode_DisplayMode(DisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, DisplayMode.class, value);
    }

    public static enum MeisaiMode implements ICommonChildDivMode {

        toroku("toroku"),
        sakujo("sakujo"),
        setReadOnly("setReadOnly"),
        setDisplayNone("setDisplayNone");

        private final String name;

        private MeisaiMode(final String name) {
            this.name = name;
        }

        public static MeisaiMode getEnum(String str) {
            MeisaiMode[] enumArray = MeisaiMode.values();

            for (MeisaiMode enumStr : enumArray) {
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

    public MeisaiMode getMode_MeisaiMode() {
        return (MeisaiMode) _CommonChildDivModeUtil.getMode(this.modes, MeisaiMode.class);
    }

    public void setMode_MeisaiMode(MeisaiMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, MeisaiMode.class, value);
    }

    public static enum WidthMode implements ICommonChildDivMode {

        Width1("Width1"),
        Width2("Width2");

        private final String name;

        private WidthMode(final String name) {
            this.name = name;
        }

        public static WidthMode getEnum(String str) {
            WidthMode[] enumArray = WidthMode.values();

            for (WidthMode enumStr : enumArray) {
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

    public WidthMode getMode_WidthMode() {
        return (WidthMode) _CommonChildDivModeUtil.getMode(this.modes, WidthMode.class);
    }

    public void setMode_WidthMode(WidthMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, WidthMode.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void initialize(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        //TODO
        //1)、引数から渡されたキーを元に、医療保険加入情報を検索する。
        //2)、取得した情報をPanelSessionAccessorに登録する。
        //3)、取得した情報をグリッドにマッピングする。

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearInputData() {
        //TODO
        //1)、入力明細パネル上のコントロールに対して、空白やnullを設定する。

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItemList<IryohokenKanyuJokyo> get医療保険加入状況List() {
        //TODO
        //1)、Panel;SessionAccessorに登録されている情報を取得し、戻り値として返却する。
        //2)、もし値が存在しない場合は、空のListを返す。

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set医療保険加入状況List(IItemList<IryohokenKanyuJokyo> 医療保険加入状況List) {
        //TODO
        //1)、引数から渡された情報を、PanelSessionAccessorに登録する。
        //2)、登録した情報を、グリッドにマッピングする。

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
