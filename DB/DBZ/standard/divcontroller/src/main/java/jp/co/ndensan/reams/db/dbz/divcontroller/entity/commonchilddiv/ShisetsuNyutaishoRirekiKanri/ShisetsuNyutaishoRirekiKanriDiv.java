package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.business.core.ShisetsuNyutaishoIdentifier;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.util.Models;

/**
 * ShisetsuNyutaishoRirekiKanri のクラスファイル
 *
 * @reamsid_L DBA-0360-030 linghuhang
 */
public class ShisetsuNyutaishoRirekiKanriDiv extends Panel implements IShisetsuNyutaishoRirekiKanriDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-14_20-51-56">
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
    @JsonProperty("施設入退所履歴")
    private Button 施設入退所履歴;
    @JsonProperty("selectRow")
    private RString selectRow;
    @JsonProperty("inputMode")
    private RString inputMode;
    @JsonProperty("shichosonCode")
    private RString shichosonCode;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;
    @JsonProperty("syokikaMode")
    private RString syokikaMode;

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
     * get施設入退所履歴
     * @return 施設入退所履歴
     */
    @JsonProperty("施設入退所履歴")
    public Button get施設入退所履歴() {
        return 施設入退所履歴;
    }

    /*
     * set施設入退所履歴
     * @param 施設入退所履歴 施設入退所履歴
     */
    @JsonProperty("施設入退所履歴")
    public void set施設入退所履歴(Button 施設入退所履歴) {
        this.施設入退所履歴 = 施設入退所履歴;
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
     * getsyokikaMode
     * @return syokikaMode
     */
    @JsonProperty("syokikaMode")
    public RString getSyokikaMode() {
        return syokikaMode;
    }

    /*
     * setsyokikaMode
     * @param syokikaMode syokikaMode
     */
    @JsonProperty("syokikaMode")
    public void setSyokikaMode(RString syokikaMode) {
        this.syokikaMode = syokikaMode;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DataGridHeight implements ICommonChildDivMode {

        サイズ200("サイズ200"),
        サイズ250("サイズ250"),
        サイズ300("サイズ300"),
        サイズ350("サイズ350"),
        サイズ400("サイズ400"),
        サイズ450("サイズ450"),
        サイズ500("サイズ500");

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

    public static enum DataGridWidth implements ICommonChildDivMode {

        モード1("モード1"),
        モード2("モード2"),
        モード3("モード3"),
        モード4("モード4"),
        モード5("モード5");

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

    public static enum DisplayMode implements ICommonChildDivMode {

        登録("登録"),
        照会("照会"),
        照会選択有("照会選択有"),
        資格異動("資格異動");

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
        return (DisplayMode) _CommonChildDivModeUtil.getMode( this.modes, DisplayMode.class );
    }

    public void setMode_DisplayMode( DisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DisplayMode.class , value );
    }

    public static enum MeisaiMode implements ICommonChildDivMode {

        追加_修正("追加_修正"),
        削除("削除"),
        選択不可("選択不可"),
        非表示("非表示");

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

    public static enum Riyou implements ICommonChildDivMode {

        台帳種別表示機能("台帳種別表示機能"),
        全施設対象機能("全施設対象機能"),
        被保険者対象機能("被保険者対象機能"),
        他市町村住所地特例者対象機能("他市町村住所地特例者対象機能"),
        適用除外者対象機能("適用除外者対象機能");

        private final String name;

        private Riyou(final String name) {
            this.name = name;
        }

        public static Riyou getEnum(String str) {
            Riyou[] enumArray = Riyou.values();

            for (Riyou enumStr : enumArray) {
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

    public Riyou getMode_Riyou() {
        return (Riyou) _CommonChildDivModeUtil.getMode( this.modes, Riyou.class );
    }

    public void setMode_Riyou( Riyou value ) {
        _CommonChildDivModeUtil.setMode( this.modes, Riyou.class , value );
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxFlexibleDate getTxtNyushoDate() {
        return this.getShisetsuNyutaishoInput().getTxtNyushoDate();
    }

    @JsonIgnore
    public void  setTxtNyushoDate(TextBoxFlexibleDate txtNyushoDate) {
        this.getShisetsuNyutaishoInput().setTxtNyushoDate(txtNyushoDate);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTaishoDate() {
        return this.getShisetsuNyutaishoInput().getTxtTaishoDate();
    }

    @JsonIgnore
    public void  setTxtTaishoDate(TextBoxFlexibleDate txtTaishoDate) {
        this.getShisetsuNyutaishoInput().setTxtTaishoDate(txtTaishoDate);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return this.getShisetsuNyutaishoInput().getCcdShisetsuJoho();
    }

    @JsonIgnore
    public TenshutsusakiJohoPanelDiv getTenshutsusakiJohoPanel() {
        return this.getShisetsuNyutaishoInput().getTenshutsusakiJohoPanel();
    }

    @JsonIgnore
    public void  setTenshutsusakiJohoPanel(TenshutsusakiJohoPanelDiv TenshutsusakiJohoPanel) {
        this.getShisetsuNyutaishoInput().setTenshutsusakiJohoPanel(TenshutsusakiJohoPanel);
    }

    @JsonIgnore
    public TextBox getTxtHokensha() {
        return this.getShisetsuNyutaishoInput().getTenshutsusakiJohoPanel().getTxtHokensha();
    }

    @JsonIgnore
    public void  setTxtHokensha(TextBox txtHokensha) {
        this.getShisetsuNyutaishoInput().getTenshutsusakiJohoPanel().setTxtHokensha(txtHokensha);
    }

    @JsonIgnore
    public ButtonDialog getBtnHokenshaKensaku() {
        return this.getShisetsuNyutaishoInput().getTenshutsusakiJohoPanel().getBtnHokenshaKensaku();
    }

    @JsonIgnore
    public void  setBtnHokenshaKensaku(ButtonDialog btnHokenshaKensaku) {
        this.getShisetsuNyutaishoInput().getTenshutsusakiJohoPanel().setBtnHokenshaKensaku(btnHokenshaKensaku);
    }

    @JsonIgnore
    public TextBox getTxtHokensyaMeisho() {
        return this.getShisetsuNyutaishoInput().getTenshutsusakiJohoPanel().getTxtHokensyaMeisho();
    }

    @JsonIgnore
    public void  setTxtHokensyaMeisho(TextBox txtHokensyaMeisho) {
        this.getShisetsuNyutaishoInput().getTenshutsusakiJohoPanel().setTxtHokensyaMeisho(txtHokensyaMeisho);
    }

    @JsonIgnore
    public Button getBtnShisetsuNyutaishoKakutei() {
        return this.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoKakutei();
    }

    @JsonIgnore
    public void  setBtnShisetsuNyutaishoKakutei(Button btnShisetsuNyutaishoKakutei) {
        this.getShisetsuNyutaishoInput().setBtnShisetsuNyutaishoKakutei(btnShisetsuNyutaishoKakutei);
    }

    @JsonIgnore
    public Button getBtnShisetsuNyutaishoTorikeshi() {
        return this.getShisetsuNyutaishoInput().getBtnShisetsuNyutaishoTorikeshi();
    }

    @JsonIgnore
    public void  setBtnShisetsuNyutaishoTorikeshi(Button btnShisetsuNyutaishoTorikeshi) {
        this.getShisetsuNyutaishoInput().setBtnShisetsuNyutaishoTorikeshi(btnShisetsuNyutaishoTorikeshi);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private ShisetsuNyutaishoRirekiKanriHandler getHandler() {
        return new ShisetsuNyutaishoRirekiKanriHandler(this);
    }

    /**
     * 共通子DIVの初期化処理です。
     *
     * @param 識別コード 識別コード
     */
    @Override
    public void initialize(ShikibetsuCode 識別コード) {
        getHandler().initialize(識別コード);
    }

    /**
     * 共通子DIVの初期化処理です。
     *
     * @param 識別コード 識別コード
     * @param 台帳種別 台帳種別
     */
    @Override
    public void initialize(ShikibetsuCode 識別コード, RString 台帳種別) {
        getHandler().initialize(識別コード, 台帳種別);
    }

    @Override
    public void initialize(Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> 施設入退所情報Model) {
        getHandler().initialize(施設入退所情報Model);
    }

    /**
     * 施設入退所履歴の共有子DIVの画面内容から、施設入退所履歴情報をDBに反映します。
     */
    @Override
    public void saveShisetsuNyutaisho() {
        getHandler().saveShisetsuNyutaisho();
    }

    @Override
    public void set表示モード(RString 表示) {
        setMode_DisplayMode(DisplayMode.getEnum(表示.toString()));
    }

    @Override
    public void set明細表示モード(RString 明細表示) {
        setMode_MeisaiMode(MeisaiMode.getEnum(明細表示.toString()));
    }

    @Override
    public void set利用モード(RString 利用モード) {
        setMode_Riyou(Riyou.getEnum(利用モード.toString()));
    }

    @Override
    public void set表示widthサイズ(RString widthサイズ) {
        setMode_DataGridWidth(DataGridWidth.getEnum(widthサイズ.toString()));
    }

    @Override
    public void set表示heightサイズ(RString heightサイズ) {
        setMode_DataGridHeight(DataGridHeight.getEnum(heightサイズ.toString()));
    }

    @Override
    public List<dgShisetsuNyutaishoRireki_Row> get施設入退所履歴一覧() {
        return getHandler().get施設入退所履歴一覧();
    }

    @Override
    public Models<ShisetsuNyutaishoIdentifier, ShisetsuNyutaisho> getSaveData() {
        return getHandler().getSaveData();
    }

    @Override
    public boolean isSavable() {
        return getHandler().isSavable();
    }

    @Override
    public void setShokaiMode() {
        this.setMode_DisplayMode(DisplayMode.照会);
        this.setMode_DataGridHeight(DataGridHeight.サイズ300);
        this.setMode_DataGridWidth(DataGridWidth.モード5);
        this.setMode_MeisaiMode(MeisaiMode.非表示);
        this.setMode_Riyou(Riyou.被保険者対象機能);
    }

    @Override
    public void setTorokuMode() {
        this.setMode_DisplayMode(DisplayMode.資格異動);
        this.setMode_DataGridHeight(DataGridHeight.サイズ300);
        this.setMode_DataGridWidth(DataGridWidth.モード1);
        this.setMode_MeisaiMode(MeisaiMode.追加_修正);
        this.setMode_Riyou(Riyou.他市町村住所地特例者対象機能);
    }

}
