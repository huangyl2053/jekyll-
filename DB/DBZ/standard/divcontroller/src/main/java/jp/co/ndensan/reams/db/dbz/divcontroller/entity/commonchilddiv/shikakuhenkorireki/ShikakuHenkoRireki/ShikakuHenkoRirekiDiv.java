package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaichoIdentifier;
import jp.co.ndensan.reams.db.dbz.definition.core.ViewExecutionStatus;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * ShikakuHenkoRireki のクラスファイル
 *
 * @reamsid_L DBA-1300-050 chengsanyuan
 */
public class ShikakuHenkoRirekiDiv extends Panel implements IShikakuHenkoRirekiDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-03-22_14-06-37">
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
    @JsonProperty("inputMode")
    private RString inputMode;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("idoDate")
    private RString idoDate;
    @JsonProperty("edaban")
    private RString edaban;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAdd
     * @return btnAdd
     */
    @JsonProperty("btnAdd")
    public Button getBtnAdd() {
        return btnAdd;
    }

    /*
     * setbtnAdd
     * @param btnAdd btnAdd
     */
    @JsonProperty("btnAdd")
    public void setBtnAdd(Button btnAdd) {
        this.btnAdd = btnAdd;
    }

    /*
     * getdgHenko
     * @return dgHenko
     */
    @JsonProperty("dgHenko")
    public DataGrid<dgHenko_Row> getDgHenko() {
        return dgHenko;
    }

    /*
     * setdgHenko
     * @param dgHenko dgHenko
     */
    @JsonProperty("dgHenko")
    public void setDgHenko(DataGrid<dgHenko_Row> dgHenko) {
        this.dgHenko = dgHenko;
    }

    /*
     * getHenkoInput
     * @return HenkoInput
     */
    @JsonProperty("HenkoInput")
    public HenkoInputDiv getHenkoInput() {
        return HenkoInput;
    }

    /*
     * setHenkoInput
     * @param HenkoInput HenkoInput
     */
    @JsonProperty("HenkoInput")
    public void setHenkoInput(HenkoInputDiv HenkoInput) {
        this.HenkoInput = HenkoInput;
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
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * getidoDate
     * @return idoDate
     */
    @JsonProperty("idoDate")
    public RString getIdoDate() {
        return idoDate;
    }

    /*
     * setidoDate
     * @param idoDate idoDate
     */
    @JsonProperty("idoDate")
    public void setIdoDate(RString idoDate) {
        this.idoDate = idoDate;
    }

    /*
     * getedaban
     * @return edaban
     */
    @JsonProperty("edaban")
    public RString getEdaban() {
        return edaban;
    }

    /*
     * setedaban
     * @param edaban edaban
     */
    @JsonProperty("edaban")
    public void setEdaban(RString edaban) {
        this.edaban = edaban;
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 引数から渡されたキーを元に被保険者台帳を検索し、その結果をグリッドに設定します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 識別コード 識別コード
     * @param 取得日 取得日
     */
    @Override
    public void initialize(HihokenshaNo 被保険者番号, ShikibetsuCode 識別コード, FlexibleDate 取得日) {
        getHandler().initialize(被保険者番号, 識別コード, 取得日);
    }

    private ShikakuHenkoRirekiHandler getHandler() {
        return new ShikakuHenkoRirekiHandler(this);
    }

    /**
     * 変更履歴グリッドのデータを取得します。
     *
     * @return SearchResult<HihokenshaDaicho>
     */
    @Override
    public SearchResult<HihokenshaDaicho> getGridData() {
        Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> result
                = ViewStateHolder.get(ViewStateKeys.被保険者台帳情報, Models.class);
        List<HihokenshaDaicho> hihokenshaList = new ArrayList<>(result.values());
        if (hihokenshaList.isEmpty()) {
            return SearchResult.of(Collections.<HihokenshaDaicho>emptyList(), 0, false);
        }
        return SearchResult.of(hihokenshaList, 0, false);
    }

    /**
     * 被保険者資格詳細異動用、変更履歴グリッドのデータを取得します。
     *
     * @return SearchResult<HihokenshaDaicho>
     */
    @Override
    public SearchResult<HihokenshaDaicho> getGridDataFor資格詳細異動() {
        Models<HihokenshaDaichoIdentifier, HihokenshaDaicho> result
                = ViewStateHolder.get(ViewStateKeys.被保険者台帳情報, Models.class);
        List<HihokenshaDaicho> retList = new ArrayList<>();
        for (dgHenko_Row row : this.getDgHenko().getDataSource()) {
            retList.add(result.get(new HihokenshaDaichoIdentifier(new HihokenshaNo(row.getHihokenshaNo()),
                    row.getIdoYMD().getValue(), row.getEdaNo())));
        }
        if (retList.isEmpty()) {
            return SearchResult.of(Collections.<HihokenshaDaicho>emptyList(), 0, false);
        }
        return SearchResult.of(retList, 0, false);
    }

    /**
     * 変更事由DDLを設定します。
     *
     * @param key 変更事由key
     * @param falg 活性フラグ
     */
    @Override
    public void setDdlHenkoJiyu(RString key, boolean falg) {
        this.getDdlHenkoJiyu().setSelectedKey(key);
        this.getDdlHenkoJiyu().setDisabled(falg);
    }

    /**
     * モードを設定します。
     *
     * @param mode モードキー
     */
    @Override
    public void setDisplayTypeBykey(RString mode) {
        this.setMode_DisplayType(ShikakuHenkoRirekiDiv.DisplayType.getEnum(mode.toString()));
    }

    @Override
    public boolean is追加済み() {
        for (dgHenko_Row row : this.getDgHenko().getDataSource()) {
            if (row.getState().equals(ViewExecutionStatus.Add.get名称())) {
                return true;
            }
        }
        return false;
    }

}
