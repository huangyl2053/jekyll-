package jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki;

/**
 * このコードはツールによって生成されました。 このファイルへの変更は、再生成時には損失するため 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.IShikakuHenkoRirekiDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.HenkoHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.HenkoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.shikakuhenkorireki.dgHenko_Row;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

import java.util.HashSet;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.model.hihokenshadaicho.HihokenshaDaichoModel;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShikakuHenkoRireki のクラスファイル
 *
 * @author 自動生成
 */
public class ShikakuHenkoRirekiDiv extends Panel implements IShikakuHenkoRirekiDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */

    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgHenko")
    private DataGrid<dgHenko_Row> dgHenko;
    @JsonProperty("HenkoInput")
    private HenkoInputDiv HenkoInput;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    @JsonProperty("dgHenko")
    public DataGrid<dgHenko_Row> getDgHenko() {
        return dgHenko;
    }

    @JsonProperty("dgHenko")
    public void setDgHenko(DataGrid<dgHenko_Row> dgHenko) {
        this.dgHenko = dgHenko;
    }

    @JsonProperty("HenkoInput")
    public HenkoInputDiv getHenkoInput() {
        return HenkoInput;
    }

    @JsonProperty("HenkoInput")
    public void setHenkoInput(HenkoInputDiv HenkoInput) {
        this.HenkoInput = HenkoInput;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DataGridHeight implements ICommonChildDivMode {

        Size1("Size1"),
        Size2("Size2"),
        Size3("Size3"),
        Size4("Size4"),
        Size5("Size5"),
        Size6("Size6");

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

    public static enum ShoriNichijiDisplayMode implements ICommonChildDivMode {

        VisibleTrue("VisibleTrue"),
        VisibleFalse("VisibleFalse");

        private final String name;

        private ShoriNichijiDisplayMode(final String name) {
            this.name = name;
        }

        public static ShoriNichijiDisplayMode getEnum(String str) {
            ShoriNichijiDisplayMode[] enumArray = ShoriNichijiDisplayMode.values();

            for (ShoriNichijiDisplayMode enumStr : enumArray) {
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

    public ShoriNichijiDisplayMode getMode_ShoriNichijiDisplayMode() {
        return (ShoriNichijiDisplayMode) _CommonChildDivModeUtil.getMode(this.modes, ShoriNichijiDisplayMode.class);
    }

    public void setMode_ShoriNichijiDisplayMode(ShoriNichijiDisplayMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, ShoriNichijiDisplayMode.class, value);
    }

    public static enum DataGridWidth implements ICommonChildDivMode {

        Size1("Size1"),
        Size2("Size2"),
        Size3("Size3"),
        Size4("Size4"),
        Size5("Size5"),
        Size6("Size6"),
        Size7("Size7"),
        Size8("Size8"),
        Size9("Size9"),
        Size10("Size10"),
        Size11("Size11"),
        Size12("Size12");

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

    public static enum MeisaiMode implements ICommonChildDivMode {

        shokai("shokai"),
        toroku("toroku"),
        sakujo("sakujo"),
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

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoDate() {
        return this.getHenkoInput().getTxtHenkoDate();
    }

    @JsonIgnore
    public void setTxtHenkoDate(TextBoxFlexibleDate txtHenkoDate) {
        this.getHenkoInput().setTxtHenkoDate(txtHenkoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoTodokedeDate() {
        return this.getHenkoInput().getTxtHenkoTodokedeDate();
    }

    @JsonIgnore
    public void setTxtHenkoTodokedeDate(TextBoxFlexibleDate txtHenkoTodokedeDate) {
        this.getHenkoInput().setTxtHenkoTodokedeDate(txtHenkoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoJiyu() {
        return this.getHenkoInput().getDdlHenkoJiyu();
    }

    @JsonIgnore
    public void setDdlHenkoJiyu(DropDownList ddlHenkoJiyu) {
        this.getHenkoInput().setDdlHenkoJiyu(ddlHenkoJiyu);
    }

    @JsonIgnore
    public HenkoHokenshaJohoDiv getHenkoHokenshaJoho() {
        return this.getHenkoInput().getHenkoHokenshaJoho();
    }

    @JsonIgnore
    public void setHenkoHokenshaJoho(HenkoHokenshaJohoDiv HenkoHokenshaJoho) {
        this.getHenkoInput().setHenkoHokenshaJoho(HenkoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoShozaiHokensha() {
        return this.getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoShozaiHokensha();
    }

    @JsonIgnore
    public void setDdlHenkoShozaiHokensha(DropDownList ddlHenkoShozaiHokensha) {
        this.getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoShozaiHokensha(ddlHenkoShozaiHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoSochimotoHokensha() {
        return this.getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoSochimotoHokensha();
    }

    @JsonIgnore
    public void setDdlHenkoSochimotoHokensha(DropDownList ddlHenkoSochimotoHokensha) {
        this.getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoSochimotoHokensha(ddlHenkoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoKyuHokensha() {
        return this.getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoKyuHokensha();
    }

    @JsonIgnore
    public void setDdlHenkoKyuHokensha(DropDownList ddlHenkoKyuHokensha) {
        this.getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoKyuHokensha(ddlHenkoKyuHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlJuminJoho() {
        return this.getHenkoInput().getHenkoHokenshaJoho().getDdlJuminJoho();
    }

    @JsonIgnore
    public void setDdlJuminJoho(DropDownList ddlJuminJoho) {
        this.getHenkoInput().getHenkoHokenshaJoho().setDdlJuminJoho(ddlJuminJoho);
    }

    @JsonIgnore
    public Button getBtnHenkoKakutei() {
        return this.getHenkoInput().getBtnHenkoKakutei();
    }

    @JsonIgnore
    public void setBtnHenkoKakutei(Button btnHenkoKakutei) {
        this.getHenkoInput().setBtnHenkoKakutei(btnHenkoKakutei);
    }

    @JsonIgnore
    public Button getBtnHenkoTorikeshi() {
        return this.getHenkoInput().getBtnHenkoTorikeshi();
    }

    @JsonIgnore
    public void setBtnHenkoTorikeshi(Button btnHenkoTorikeshi) {
        this.getHenkoInput().setBtnHenkoTorikeshi(btnHenkoTorikeshi);
    }

    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public void load(LasdecCode 市町村コード, HihokenshaNo 被保険者番号) {
        //TODO
        //1)、引数から渡されたキーを元に、被保険者台帳情報を検索する。
        //2)、検索結果として取得する被保険者台帳Listから、資格関連異動の履歴を表現するために必要な情報を抽出する。
        //3)、取得した情報をPanelSessionAccessorに登録する。
        //4)、抽出した資格関連異動履歴Listを、グリッドにマッピングする。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void initialize() {
        //TODO
        //１）変更事由ドロップダウンリストに名称をセットする
        //２）明細エリアの各項目の値をクリアする。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clearInputData() {
        //TODO
        //1)、入力明細パネル上のコントロールに対して、空白やnullなどを設定する。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IItemList<HihokenshaDaichoModel> get資格関連異動履歴() {
        //TODO
        //1)、PanelSessionAccessorに登録されている情報を取得し、戻り値として返却する。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set資格関連異動履歴(IItemList<HihokenshaDaichoModel> 被保険者台帳List) {
        //TODO
        //1)、引数から渡された情報を、PanelSessionAccessorに登録する。
        //2)、登録した情報を、グリッドにマッピングする。
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
