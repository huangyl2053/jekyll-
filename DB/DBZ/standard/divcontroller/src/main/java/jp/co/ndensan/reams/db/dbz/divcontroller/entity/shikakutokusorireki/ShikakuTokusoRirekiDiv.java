package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.IShikakuTokusoRirekiDiv;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakutokusorireki.dgShikakuShutokuRireki_Row;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.ItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShikakuTokusoRireki のクラスファイル
 *
 * @author 自動生成
 */
public class ShikakuTokusoRirekiDiv extends Panel implements IShikakuTokusoRirekiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("btnAddShikakuShutoku")
    private Button btnAddShikakuShutoku;
    @JsonProperty("dgShikakuShutokuRireki")
    private DataGrid<dgShikakuShutokuRireki_Row> dgShikakuShutokuRireki;
    @JsonProperty("mode")
    private RString mode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAddShikakuShutoku")
    public Button getBtnAddShikakuShutoku() {
        return btnAddShikakuShutoku;
    }

    @JsonProperty("btnAddShikakuShutoku")
    public void setBtnAddShikakuShutoku(Button btnAddShikakuShutoku) {
        this.btnAddShikakuShutoku = btnAddShikakuShutoku;
    }

    @JsonProperty("dgShikakuShutokuRireki")
    public DataGrid<dgShikakuShutokuRireki_Row> getDgShikakuShutokuRireki() {
        return dgShikakuShutokuRireki;
    }

    @JsonProperty("dgShikakuShutokuRireki")
    public void setDgShikakuShutokuRireki(DataGrid<dgShikakuShutokuRireki_Row> dgShikakuShutokuRireki) {
        this.dgShikakuShutokuRireki = dgShikakuShutokuRireki;
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

    public static enum DataGridHeight implements ICommonChildDivMode {

        SizeDefault("SizeDefault"),
        Size300("Size300");

        private final String name;

        private DataGridHeight(final String name) {
            this.name = name;
        }

        public static DataGridHeight getEnum(String str) {
            DataGridHeight[] enumArray = DataGridHeight.values();

            for (DataGridHeight enumStr : enumArray) {
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

    public DataGridHeight getMode_DataGridHeight() {
        return (DataGridHeight) _CommonChildDivModeUtil.getMode(this.modes, DataGridHeight.class);
    }

    public void setMode_DataGridHeight(DataGridHeight value) {
        _CommonChildDivModeUtil.setMode(this.modes, DataGridHeight.class, value);
    }

    public static enum DataGridWidth implements ICommonChildDivMode {

        Size1("Size1"),
        Size2("Size2"),
        Size3("Size3"),
        Size4("Size4"),
        Size5("Size5"),
        Size6("Size6");

        private final String name;

        private DataGridWidth(final String name) {
            this.name = name;
        }

        public static DataGridWidth getEnum(String str) {
            DataGridWidth[] enumArray = DataGridWidth.values();

            for (DataGridWidth enumStr : enumArray) {
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

    public DataGridWidth getMode_DataGridWidth() {
        return (DataGridWidth) _CommonChildDivModeUtil.getMode(this.modes, DataGridWidth.class);
    }

    public void setMode_DataGridWidth(DataGridWidth value) {
        _CommonChildDivModeUtil.setMode(this.modes, DataGridWidth.class, value);
    }

    public static enum HokenshaJohoDisplayMode implements ICommonChildDivMode {

        TanitsuGappeiNashi("TanitsuGappeiNashi"),
        TanitsuGappeiAri("TanitsuGappeiAri"),
        KoikiGappeiNashi("KoikiGappeiNashi"),
        KoikiGappeiAri("KoikiGappeiAri");

        private final String name;

        private HokenshaJohoDisplayMode(final String name) {
            this.name = name;
        }

        public static HokenshaJohoDisplayMode getEnum(String str) {
            HokenshaJohoDisplayMode[] enumArray = HokenshaJohoDisplayMode.values();

            for (HokenshaJohoDisplayMode enumStr : enumArray) {
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

    public HokenshaJohoDisplayMode getMode_HokenshaJohoDisplayMode() {
        return (HokenshaJohoDisplayMode) _CommonChildDivModeUtil.getMode(this.modes, HokenshaJohoDisplayMode.class);
    }

    public void setMode_HokenshaJohoDisplayMode(HokenshaJohoDisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, HokenshaJohoDisplayMode.class, value);
    }

    public static enum BtnDisplayMode implements ICommonChildDivMode {

        SetDisplay("SetDisplay"),
        SetDisplayNone("SetDisplayNone");

        private final String name;

        private BtnDisplayMode(final String name) {
            this.name = name;
        }

        public static BtnDisplayMode getEnum(String str) {
            BtnDisplayMode[] enumArray = BtnDisplayMode.values();

            for (BtnDisplayMode enumStr : enumArray) {
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

    public BtnDisplayMode getMode_BtnDisplayMode() {
        return (BtnDisplayMode) _CommonChildDivModeUtil.getMode(this.modes, BtnDisplayMode.class);
    }

    public void setMode_BtnDisplayMode(BtnDisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, BtnDisplayMode.class, value);
    }

    public static enum DisplayType implements ICommonChildDivMode {

        shokai("shokai"),
        toroku("toroku"),
        teiseitoroku("teiseitoroku");

        private final String name;

        private DisplayType(final String name) {
            this.name = name;
        }

        public static DisplayType getEnum(String str) {
            DisplayType[] enumArray = DisplayType.values();

            for (DisplayType enumStr : enumArray) {
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

    public DisplayType getMode_DisplayType() {
        return (DisplayType) _CommonChildDivModeUtil.getMode(this.modes, DisplayType.class);
    }

    public void setMode_DisplayType(DisplayType value) {
        _CommonChildDivModeUtil.setMode(this.modes, DisplayType.class, value);
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void load(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        //1)、引数から受け取った市町村コード・被保険者番号を元に、被保険者台帳情報を検索する。
        //2)、取得した情報をPanelSessionAccessorに登録する。
        //3)、取得した被保険者台帳Listから、資格得喪を表す情報を抽出する。
        //4)、抽出した資格特捜情報を、グリッドにマッピングする。
    }

    @Override
    public void load(LasdecCode 市町村コード, ShikibetsuCode 識別コード) {
        //1)、引数から受け取った市町村コード・識別コードを元に、被保険者台帳情報を検索する。
        //2)、取得した情報をPanelSessionAccessorに登録する。
        //3)、取得した被保険者台帳Listから、資格得喪を表す情報を抽出する。
        //4)、抽出した資格特捜情報を、グリッドにマッピングする。
    }

    @Override
    public IItemList<HihokenshaDaichoModel> get資格得喪履歴() {
        //1)、Panel;SessionAccessorに登録されている情報を取得し、戻り値として返却する。
        //2)、もし値が存在しない場合は、空のListを返す。
        return ItemList.empty();
    }

    @Override
    public void set資格得喪履歴(IItemList<HihokenshaDaichoModel> 被保険者台帳List) {
        //1)、引数から渡された情報小w、PanelSessionAccessorに登録する。
        //2)、登録した情報を、グリッドにマッピングする。
    }
}
