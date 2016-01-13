package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shikakuhenkorireki.ShikakuHenkoRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * ShikakuHenkoRireki のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShikakuHenkoRirekiDiv extends Panel implements IShikakuHenkoRirekiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
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
    @JsonProperty("executionStatus")
    private RString executionStatus;
    @JsonProperty("henkoRirekiExecutionState")
    private RString henkoRirekiExecutionState;
    @JsonProperty("selectRow")
    private RString selectRow;
    @JsonProperty("inputMode")
    private RString inputMode;
    @JsonProperty("selectIdoYMD")
    private RString selectIdoYMD;
    @JsonProperty("latestSoshitsubi")
    private RString latestSoshitsubi;
    @JsonProperty("latestShutokubi")
    private RString latestShutokubi;
    @JsonProperty("latestKoshinbi")
    private RString latestKoshinbi;
    @JsonProperty("ichigoShikakuShutokubi")
    private RString ichigoShikakuShutokubi;

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
     * getexecutionStatus
     * @return executionStatus
     */
    @JsonProperty("executionStatus")
    public RString getExecutionStatus() {
        return executionStatus;
    }

    /*
     * setexecutionStatus
     * @param executionStatus executionStatus
     */
    @JsonProperty("executionStatus")
    public void setExecutionStatus(RString executionStatus) {
        this.executionStatus = executionStatus;
    }

    /*
     * gethenkoRirekiExecutionState
     * @return henkoRirekiExecutionState
     */
    @JsonProperty("henkoRirekiExecutionState")
    public RString getHenkoRirekiExecutionState() {
        return henkoRirekiExecutionState;
    }

    /*
     * sethenkoRirekiExecutionState
     * @param henkoRirekiExecutionState henkoRirekiExecutionState
     */
    @JsonProperty("henkoRirekiExecutionState")
    public void setHenkoRirekiExecutionState(RString henkoRirekiExecutionState) {
        this.henkoRirekiExecutionState = henkoRirekiExecutionState;
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
     * getselectIdoYMD
     * @return selectIdoYMD
     */
    @JsonProperty("selectIdoYMD")
    public RString getSelectIdoYMD() {
        return selectIdoYMD;
    }

    /*
     * setselectIdoYMD
     * @param selectIdoYMD selectIdoYMD
     */
    @JsonProperty("selectIdoYMD")
    public void setSelectIdoYMD(RString selectIdoYMD) {
        this.selectIdoYMD = selectIdoYMD;
    }

    /*
     * getlatestSoshitsubi
     * @return latestSoshitsubi
     */
    @JsonProperty("latestSoshitsubi")
    public RString getLatestSoshitsubi() {
        return latestSoshitsubi;
    }

    /*
     * setlatestSoshitsubi
     * @param latestSoshitsubi latestSoshitsubi
     */
    @JsonProperty("latestSoshitsubi")
    public void setLatestSoshitsubi(RString latestSoshitsubi) {
        this.latestSoshitsubi = latestSoshitsubi;
    }

    /*
     * getlatestShutokubi
     * @return latestShutokubi
     */
    @JsonProperty("latestShutokubi")
    public RString getLatestShutokubi() {
        return latestShutokubi;
    }

    /*
     * setlatestShutokubi
     * @param latestShutokubi latestShutokubi
     */
    @JsonProperty("latestShutokubi")
    public void setLatestShutokubi(RString latestShutokubi) {
        this.latestShutokubi = latestShutokubi;
    }

    /*
     * getlatestKoshinbi
     * @return latestKoshinbi
     */
    @JsonProperty("latestKoshinbi")
    public RString getLatestKoshinbi() {
        return latestKoshinbi;
    }

    /*
     * setlatestKoshinbi
     * @param latestKoshinbi latestKoshinbi
     */
    @JsonProperty("latestKoshinbi")
    public void setLatestKoshinbi(RString latestKoshinbi) {
        this.latestKoshinbi = latestKoshinbi;
    }

    /*
     * getichigoShikakuShutokubi
     * @return ichigoShikakuShutokubi
     */
    @JsonProperty("ichigoShikakuShutokubi")
    public RString getIchigoShikakuShutokubi() {
        return ichigoShikakuShutokubi;
    }

    /*
     * setichigoShikakuShutokubi
     * @param ichigoShikakuShutokubi ichigoShikakuShutokubi
     */
    @JsonProperty("ichigoShikakuShutokubi")
    public void setIchigoShikakuShutokubi(RString ichigoShikakuShutokubi) {
        this.ichigoShikakuShutokubi = ichigoShikakuShutokubi;
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
        return (DataGridHeight) _CommonChildDivModeUtil.getMode( this.modes, DataGridHeight.class );
    }

    public void setMode_DataGridHeight( DataGridHeight value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DataGridHeight.class , value );
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
        return (ShoriNichijiDisplayMode) _CommonChildDivModeUtil.getMode( this.modes, ShoriNichijiDisplayMode.class );
    }

    public void setMode_ShoriNichijiDisplayMode( ShoriNichijiDisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, ShoriNichijiDisplayMode.class , value );
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
        return (DataGridWidth) _CommonChildDivModeUtil.getMode( this.modes, DataGridWidth.class );
    }

    public void setMode_DataGridWidth( DataGridWidth value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DataGridWidth.class , value );
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
        return (HokenshaJohoDisplayMode) _CommonChildDivModeUtil.getMode( this.modes, HokenshaJohoDisplayMode.class );
    }

    public void setMode_HokenshaJohoDisplayMode( HokenshaJohoDisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, HokenshaJohoDisplayMode.class , value );
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
        return (BtnDisplayMode) _CommonChildDivModeUtil.getMode( this.modes, BtnDisplayMode.class );
    }

    public void setMode_BtnDisplayMode( BtnDisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, BtnDisplayMode.class , value );
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
        return (MeisaiMode) _CommonChildDivModeUtil.getMode( this.modes, MeisaiMode.class );
    }

    public void setMode_MeisaiMode( MeisaiMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, MeisaiMode.class , value );
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
        return (DisplayType) _CommonChildDivModeUtil.getMode( this.modes, DisplayType.class );
    }

    public void setMode_DisplayType( DisplayType value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayType.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoDate() {
        return this.getHenkoInput().getTxtHenkoDate();
    }

    @JsonIgnore
    public void  setTxtHenkoDate(TextBoxFlexibleDate txtHenkoDate) {
        this.getHenkoInput().setTxtHenkoDate(txtHenkoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHenkoTodokedeDate() {
        return this.getHenkoInput().getTxtHenkoTodokedeDate();
    }

    @JsonIgnore
    public void  setTxtHenkoTodokedeDate(TextBoxFlexibleDate txtHenkoTodokedeDate) {
        this.getHenkoInput().setTxtHenkoTodokedeDate(txtHenkoTodokedeDate);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoJiyu() {
        return this.getHenkoInput().getDdlHenkoJiyu();
    }

    @JsonIgnore
    public void  setDdlHenkoJiyu(DropDownList ddlHenkoJiyu) {
        this.getHenkoInput().setDdlHenkoJiyu(ddlHenkoJiyu);
    }

    @JsonIgnore
    public HenkoHokenshaJohoDiv getHenkoHokenshaJoho() {
        return this.getHenkoInput().getHenkoHokenshaJoho();
    }

    @JsonIgnore
    public void  setHenkoHokenshaJoho(HenkoHokenshaJohoDiv HenkoHokenshaJoho) {
        this.getHenkoInput().setHenkoHokenshaJoho(HenkoHokenshaJoho);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoSochimotoHokensha() {
        return this.getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoSochimotoHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoSochimotoHokensha(DropDownList ddlHenkoSochimotoHokensha) {
        this.getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoSochimotoHokensha(ddlHenkoSochimotoHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlHenkoKyuHokensha() {
        return this.getHenkoInput().getHenkoHokenshaJoho().getDdlHenkoKyuHokensha();
    }

    @JsonIgnore
    public void  setDdlHenkoKyuHokensha(DropDownList ddlHenkoKyuHokensha) {
        this.getHenkoInput().getHenkoHokenshaJoho().setDdlHenkoKyuHokensha(ddlHenkoKyuHokensha);
    }

    @JsonIgnore
    public DropDownList getDdlJuminJoho() {
        return this.getHenkoInput().getHenkoHokenshaJoho().getDdlJuminJoho();
    }

    @JsonIgnore
    public void  setDdlJuminJoho(DropDownList ddlJuminJoho) {
        this.getHenkoInput().getHenkoHokenshaJoho().setDdlJuminJoho(ddlJuminJoho);
    }

    @JsonIgnore
    public Button getBtnHenkoKakutei() {
        return this.getHenkoInput().getBtnHenkoKakutei();
    }

    @JsonIgnore
    public void  setBtnHenkoKakutei(Button btnHenkoKakutei) {
        this.getHenkoInput().setBtnHenkoKakutei(btnHenkoKakutei);
    }

    @JsonIgnore
    public Button getBtnHenkoTorikeshi() {
        return this.getHenkoInput().getBtnHenkoTorikeshi();
    }

    @JsonIgnore
    public void  setBtnHenkoTorikeshi(Button btnHenkoTorikeshi) {
        this.getHenkoInput().setBtnHenkoTorikeshi(btnHenkoTorikeshi);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
