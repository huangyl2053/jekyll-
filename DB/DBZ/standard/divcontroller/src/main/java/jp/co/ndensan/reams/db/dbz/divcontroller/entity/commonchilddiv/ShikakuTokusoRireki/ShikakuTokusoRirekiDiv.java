package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShikakuTokusoRireki;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

import java.util.HashSet;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.shichosonsecurity.GyomuBunrui;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.service.core.shichosonsecurityjoho.ShichosonSecurityJoho;
import jp.co.ndensan.reams.db.dbz.business.core.shikakutokuso.ShikakuTokuso;
import static jp.co.ndensan.reams.db.dbz.definition.core.GappeiJohoKubun.合併あり;
import static jp.co.ndensan.reams.db.dbz.definition.core.GappeiJohoKubun.合併なし;
import jp.co.ndensan.reams.db.dbz.definition.core.jushochitokureisha.JushochitokureishaKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.shikakutokuso.ShikakuTokusoParameter;
import jp.co.ndensan.reams.db.dbz.service.core.shikakutokuso.ShikakuTokusoFinder;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridButtonState;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxFlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * ShikakuTokusoRireki のクラスファイル
 *
 * @reamsid_L DBA-0130-011 huangh
 */
public class ShikakuTokusoRirekiDiv extends Panel implements IShikakuTokusoRirekiDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("btnClose")
    private Button btnClose;
    @JsonProperty("mode")
    private RString mode;
    @JsonProperty("hdnHihokenshaNo")
    private RString hdnHihokenshaNo;
    @JsonProperty("hdnShikibetsuCode")
    private RString hdnShikibetsuCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnAddShikakuShutoku
     * @return btnAddShikakuShutoku
     */
    @JsonProperty("btnAddShikakuShutoku")
    public Button getBtnAddShikakuShutoku() {
        return btnAddShikakuShutoku;
    }

    /*
     * setbtnAddShikakuShutoku
     * @param btnAddShikakuShutoku btnAddShikakuShutoku
     */
    @JsonProperty("btnAddShikakuShutoku")
    public void setBtnAddShikakuShutoku(Button btnAddShikakuShutoku) {
        this.btnAddShikakuShutoku = btnAddShikakuShutoku;
    }

    /*
     * getdgShikakuShutokuRireki
     * @return dgShikakuShutokuRireki
     */
    @JsonProperty("dgShikakuShutokuRireki")
    public DataGrid<dgShikakuShutokuRireki_Row> getDgShikakuShutokuRireki() {
        return dgShikakuShutokuRireki;
    }

    /*
     * setdgShikakuShutokuRireki
     * @param dgShikakuShutokuRireki dgShikakuShutokuRireki
     */
    @JsonProperty("dgShikakuShutokuRireki")
    public void setDgShikakuShutokuRireki(DataGrid<dgShikakuShutokuRireki_Row> dgShikakuShutokuRireki) {
        this.dgShikakuShutokuRireki = dgShikakuShutokuRireki;
    }

    /*
     * getbtnClose
     * @return btnClose
     */
    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    /*
     * setbtnClose
     * @param btnClose btnClose
     */
    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }

    /*
     * getmode
     * @return mode
     */
    @JsonProperty("mode")
    public RString getMode() {
        return mode;
    }

    /*
     * setmode
     * @param mode mode
     */
    @JsonProperty("mode")
    public void setMode(RString mode) {
        this.mode = mode;
    }

    /*
     * gethdnHihokenshaNo
     * @return hdnHihokenshaNo
     */
    @JsonProperty("hdnHihokenshaNo")
    public RString getHdnHihokenshaNo() {
        return hdnHihokenshaNo;
    }

    /*
     * sethdnHihokenshaNo
     * @param hdnHihokenshaNo hdnHihokenshaNo
     */
    @JsonProperty("hdnHihokenshaNo")
    public void setHdnHihokenshaNo(RString hdnHihokenshaNo) {
        this.hdnHihokenshaNo = hdnHihokenshaNo;
    }

    /*
     * gethdnShikibetsuCode
     * @return hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public RString getHdnShikibetsuCode() {
        return hdnShikibetsuCode;
    }

    /*
     * sethdnShikibetsuCode
     * @param hdnShikibetsuCode hdnShikibetsuCode
     */
    @JsonProperty("hdnShikibetsuCode")
    public void setHdnShikibetsuCode(RString hdnShikibetsuCode) {
        this.hdnShikibetsuCode = hdnShikibetsuCode;
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
        return (DataGridHeight) _CommonChildDivModeUtil.getMode( this.modes, DataGridHeight.class );
    }

    public void setMode_DataGridHeight( DataGridHeight value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DataGridHeight.class , value );
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

    public static enum DialogCloseBtnDisplayMode implements ICommonChildDivMode {

        SetDisplay("SetDisplay"),
        SetDisplayNone("SetDisplayNone");

        private final String name;

        private DialogCloseBtnDisplayMode(final String name) {
            this.name = name;
        }

        public static DialogCloseBtnDisplayMode getEnum(String str) {
            DialogCloseBtnDisplayMode[] enumArray = DialogCloseBtnDisplayMode.values();

            for (DialogCloseBtnDisplayMode enumStr : enumArray) {
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

    public DialogCloseBtnDisplayMode getMode_DialogCloseBtnDisplayMode() {
        return (DialogCloseBtnDisplayMode) _CommonChildDivModeUtil.getMode( this.modes, DialogCloseBtnDisplayMode.class );
    }

    public void setMode_DialogCloseBtnDisplayMode( DialogCloseBtnDisplayMode value ) {
        _CommonChildDivModeUtil.setMode( this.modes, DialogCloseBtnDisplayMode.class , value );
    }

    public static enum DisplayType implements ICommonChildDivMode {

        shokai("shokai"),
        shutoku("shutoku"),
        soshitsu("soshitsu"),
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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * initialize時の処理です。<br/>
     *
     * @param hihokenshaNo 被保険者番号
     * @param shikibetsuCode 識別コード
     */
    @Override
    public void initialize(HihokenshaNo hihokenshaNo,
            ShikibetsuCode shikibetsuCode) {

        // 「ビジネス設計_DBUMN00000_市町村情報セキュリティ情報取得」の「市町村セキュリティ情報を取得する」を参照する
        // １．０．１　導入形態の処理
        ShichosonSecurityJoho 市町村情報セキュリティ情報 = ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護事務);

        // 履歴一覧の「所在保険者」「措置元保険者」「旧保険者」「識別コード」の表示・非表示制御
        if (市町村情報セキュリティ情報 != null && 市町村情報セキュリティ情報.get導入形態コード() != null) {
            if (new RString("112").equals(市町村情報セキュリティ情報.get導入形態コード().value())
                    || new RString("120").equals(市町村情報セキュリティ情報.get導入形態コード().value())
                    && new RString(合併なし.getCode().toString()).equals(
                            DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {

                // 単一で合併無し・・・「所在保険者」「措置元保険者」「旧保険者」「識別コード」の全て非表示。
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("shozaiHokensha").setVisible(false);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("sochimotoHokensha").setVisible(false);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("kyuHokensha").setVisible(false);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("shikibetsuCode").setVisible(false);
            } else if ((new RString("112").equals(市町村情報セキュリティ情報.get導入形態コード().value())
                    || new RString("120").equals(市町村情報セキュリティ情報.get導入形態コード().value()))
                    && new RString(合併あり.getCode().toString()).equals(
                            DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {

                // 単一で合併有り・・・「旧保険者」は表示、以外は非表示。
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("shozaiHokensha").setVisible(false);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("sochimotoHokensha").setVisible(false);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("kyuHokensha").setVisible(true);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("shikibetsuCode").setVisible(false);
            } else if (new RString("111").equals(市町村情報セキュリティ情報.get導入形態コード().value())
                    && new RString(合併なし.getCode().toString()).equals(
                            DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {

                // 広域で合併無し・・・「旧保険者」は非表示、以外は表示。
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("shozaiHokensha").setVisible(true);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("sochimotoHokensha").setVisible(true);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("kyuHokensha").setVisible(false);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("shikibetsuCode").setVisible(true);
            } else if (new RString("111").equals(市町村情報セキュリティ情報.get導入形態コード().value())
                    && new RString(合併あり.getCode().toString()).equals(
                            DbBusinessConfig.get(ConfigNameDBU.合併情報管理_合併情報区分, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告))) {

                // 広域で合併有り・・・「所在保険者」「措置元保険者」「旧保険者」「識別コード」の全て表示。
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("shozaiHokensha").setVisible(true);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("sochimotoHokensha").setVisible(true);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("kyuHokensha").setVisible(true);
                this.getDgShikakuShutokuRireki().getGridSetting().getColumn("shikibetsuCode").setVisible(true);
            }
        }
        ShikakuTokusoFinder shikakuTokusoFinder = ShikakuTokusoFinder.createInstance();
        ShikakuTokusoParameter parmeter = ShikakuTokusoParameter.createParam(hihokenshaNo, shikibetsuCode);

        // 「ビジネス設計_DBAMN00000_資格得喪履歴」の「一覧データ取得」を参照する
        SearchResult<ShikakuTokuso> result = shikakuTokusoFinder.getShikakuTokuso(parmeter);
        List<dgShikakuShutokuRireki_Row> dgShikakuShutokuRirekiList = new ArrayList<>();
        for (ShikakuTokuso shikakuTokuso : result.records()) {
            dgShikakuShutokuRireki_Row row = new dgShikakuShutokuRireki_Row();

            TextBoxFlexibleDate 資格取得日 = new TextBoxFlexibleDate();
            資格取得日.setValue(shikakuTokuso.get資格取得年月日());
            row.setShutokuDate(資格取得日);
            TextBoxFlexibleDate 資格取得届出日 = new TextBoxFlexibleDate();
            資格取得届出日.setValue(shikakuTokuso.get資格取得届出年月日());
            row.setShutokuTodokedeDate(資格取得届出日);
            if (!RString.isNullOrEmpty(shikakuTokuso.get取得事由コード())) {
                row.setShutokuJiyu(ShikakuShutokuJiyu.toValue(shikakuTokuso.get取得事由コード()).get名称());
                row.setShutokuJiyuKey(ShikakuShutokuJiyu.toValue(shikakuTokuso.get取得事由コード()).getコード());
            } else {
                row.setShutokuJiyu(RString.EMPTY);
                row.setShutokuJiyuKey(RString.EMPTY);
            }
            if (!RString.isNullOrEmpty(shikakuTokuso.get被保険者区分コード())) {
                row.setHihokenshaKubun(ShikakuKubun.toValue(shikakuTokuso.get被保険者区分コード()).get略称());
                row.setHihokenshaKubunKey(shikakuTokuso.get被保険者区分コード());
            } else {
                row.setHihokenshaKubun(RString.EMPTY);
                row.setHihokenshaKubunKey(RString.EMPTY);
            }
            TextBoxFlexibleDate 資格喪失日 = new TextBoxFlexibleDate();
            資格喪失日.setValue(shikakuTokuso.get資格喪失年月日());
            row.setSoshitsuDate(資格喪失日);
            TextBoxFlexibleDate 資格喪失届出日 = new TextBoxFlexibleDate();
            資格喪失届出日.setValue(shikakuTokuso.get資格喪失届出年月日());
            row.setSoshitsuTodokedeDate(資格喪失届出日);
            if (!RString.isNullOrEmpty(shikakuTokuso.get喪失事由コード())) {
                row.setSoshitsuJiyu(ShikakuSoshitsuJiyu.toValue(shikakuTokuso.get喪失事由コード()).get名称());
                row.setSoshitsuJiyuKey(ShikakuSoshitsuJiyu.toValue(shikakuTokuso.get喪失事由コード()).getコード());
            } else {
                row.setSoshitsuJiyu(RString.EMPTY);
                row.setSoshitsuJiyuKey(RString.EMPTY);
            }
            if (!RString.isNullOrEmpty(shikakuTokuso.get住所地特例フラグ())) {
                row.setJutokuKubun(JushochitokureishaKubun.toValue(shikakuTokuso.get住所地特例フラグ()).get名称());
            } else {
                row.setJutokuKubun(RString.EMPTY);
            }

            row.setShozaiHokensha(shikakuTokuso.get市町村名称());
            row.setShozaiHokenshaCode(codeToRString(shikakuTokuso.get市町村コード()));
            row.setSochimotoHokensha(shikakuTokuso.get措置元保険者());
            row.setSochimotoHokenshaCode(shikakuTokuso.get広住特措置元市町村コード() == null ? RString.EMPTY : shikakuTokuso.get広住特措置元市町村コード().value());
            row.setKyuHokensha(shikakuTokuso.get旧市町村名称());
            row.setKyuHokenshaCode(shikakuTokuso.get旧市町村コード() == null ? RString.EMPTY : shikakuTokuso.get旧市町村コード().value());
            row.setShikibetsuCode(shikakuTokuso.get識別コード().value());
            row.setHihokenshaNo(shikakuTokuso.get被保険者番号().getColumnValue());
            row.setDaNo(shikakuTokuso.get枝番());
            RDateTime 処理日時 = shikakuTokuso.get処理日時();
            RStringBuilder 処理日時表示 = new RStringBuilder();
            処理日時表示.append(処理日時.getDate().wareki().toDateString());
            処理日時表示.append(RString.HALF_SPACE);
            処理日時表示.append(String.format("%02d", 処理日時.getHour()));
            処理日時表示.append(":");
            処理日時表示.append(String.format("%02d", 処理日時.getMinute()));
            処理日時表示.append(":");
            処理日時表示.append(String.format("%02d", 処理日時.getSecond()));
            row.setShoriDateTime(処理日時表示.toRString());
            row.setDeleteButtonState(DataGridButtonState.Disabled);
            row.setModifyButtonState(DataGridButtonState.Disabled);
            dgShikakuShutokuRirekiList.add(row);
        }
        this.getDgShikakuShutokuRireki().setDataSource(dgShikakuShutokuRirekiList);
        this.getBtnAddShikakuShutoku().setDisabled(true);
    }

    private RString codeToRString(LasdecCode code) {
        RString code_RString = RString.EMPTY;
        if (code != null && !code.isEmpty()) {
            code_RString = code.getColumnValue();
        }
        return code_RString;
    }

    @Override
    public void setDataGridSelectItem(dgShikakuShutokuRireki_Row dataSource) {
        List<dgShikakuShutokuRireki_Row> rowList = this.getDgShikakuShutokuRireki().getDataSource();
        if (this.getDgShikakuShutokuRireki().getClickedRowId() != -1) {
            rowList.set(this.getDgShikakuShutokuRireki().getClickedRowId(), dataSource);
        } else {
            rowList.add(dataSource);
        }
        this.getDgShikakuShutokuRireki().setDataSource(rowList);
    }

    @Override
    public dgShikakuShutokuRireki_Row getDataGridSelectItem() {
        return this.getDgShikakuShutokuRireki().getClickedItem();
    }

    @Override
    public void setDataGridDataSource(List<dgShikakuShutokuRireki_Row> dataSource) {
        this.getDgShikakuShutokuRireki().setDataSource(dataSource);
    }

    @Override
    public List<dgShikakuShutokuRireki_Row> getDataGridDataSource() {
        return this.getDgShikakuShutokuRireki().getDataSource();
    }

    @Override
    public void set追加するボタン(boolean jyotai) {
        this.getBtnAddShikakuShutoku().setDisabled(jyotai);
    }

    @Override
    public void set追加するボタンの表示状態(boolean 表示モード) {
        this.getBtnAddShikakuShutoku().setDisplayNone(表示モード);
    }

    @Override
    public void setDialogDisplay() {
        this.getBtnAddShikakuShutoku().setDisplayNone(true);
        this.getDgShikakuShutokuRireki().getGridSetting().setIsShowModifyButtonColumn(false);
        this.getDgShikakuShutokuRireki().getGridSetting().setIsShowDeleteButtonColumn(false);
        this.getDgShikakuShutokuRireki().getGridSetting().getColumn(new RString("shosai")).setVisible(false);
        this.getBtnClose().setDisplayNone(false);
    }

}
