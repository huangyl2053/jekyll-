package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuNyutaishoRirekiKanri;
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
import java.util.List;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;

/**
 * ShisetsuNyutaishoRirekiKanri のクラスファイル
 *
 * @reamsid_L DBA-0360-030 linghuhang
 */
public class ShisetsuNyutaishoRirekiKanriDiv extends Panel implements IShisetsuNyutaishoRirekiKanriDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
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
    @JsonProperty("selectRow")
    private RString selectRow;
    @JsonProperty("inputMode")
    private RString inputMode;
    @JsonProperty("shichosonCode")
    private RString shichosonCode;
    @JsonProperty("shikibetsuCode")
    private RString shikibetsuCode;

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
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum RiyoType implements ICommonChildDivMode {

        台帳種別表示機能("台帳種別表示機能"),
        全施設対象機能("全施設対象機能"),
        被保険者対象機能("被保険者対象機能"),
        他市町村住所地特例者対象機能("他市町村住所地特例者対象機能"),
        適用除外者対象機能("適用除外者対象機能");

        private final String name;

        private RiyoType(final String name) {
            this.name = name;
        }

        public static RiyoType getEnum(String str) {
            RiyoType[] enumArray = RiyoType.values();

            for (RiyoType enumStr : enumArray) {
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

    public RiyoType getMode_RiyoType() {
        return (RiyoType) _CommonChildDivModeUtil.getMode(this.modes, RiyoType.class);
    }

    public void setMode_RiyoType(RiyoType value) {
        _CommonChildDivModeUtil.setMode(this.modes, RiyoType.class, value);
    }

    public static enum MeisaiHyojiMode implements ICommonChildDivMode {

        追加_修正("追加_修正"),
        削除("削除"),
        選択不可("選択不可"),
        非表示("非表示");

        private final String name;

        private MeisaiHyojiMode(final String name) {
            this.name = name;
        }

        public static MeisaiHyojiMode getEnum(String str) {
            MeisaiHyojiMode[] enumArray = MeisaiHyojiMode.values();

            for (MeisaiHyojiMode enumStr : enumArray) {
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

    public MeisaiHyojiMode getMode_MeisaiHyojiMode() {
        return (MeisaiHyojiMode) _CommonChildDivModeUtil.getMode(this.modes, MeisaiHyojiMode.class);
    }

    public void setMode_MeisaiHyojiMode(MeisaiHyojiMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, MeisaiHyojiMode.class, value);
    }

    public static enum WidthSize implements ICommonChildDivMode {

        モード1("モード1"),
        モード2("モード2"),
        モード3("モード3"),
        モード4("モード4"),
        モード5("モード5");

        private final String name;

        private WidthSize(final String name) {
            this.name = name;
        }

        public static WidthSize getEnum(String str) {
            WidthSize[] enumArray = WidthSize.values();

            for (WidthSize enumStr : enumArray) {
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

    public WidthSize getMode_WidthSize() {
        return (WidthSize) _CommonChildDivModeUtil.getMode(this.modes, WidthSize.class);
    }

    public void setMode_WidthSize(WidthSize value) {
        _CommonChildDivModeUtil.setMode(this.modes, WidthSize.class, value);
    }

    public static enum HyojiMode implements ICommonChildDivMode {

        登録("登録"),
        照会("照会"),
        照会選択有("照会選択有"),
        資格異動("資格異動");

        private final String name;

        private HyojiMode(final String name) {
            this.name = name;
        }

        public static HyojiMode getEnum(String str) {
            HyojiMode[] enumArray = HyojiMode.values();

            for (HyojiMode enumStr : enumArray) {
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

    public HyojiMode getMode_HyojiMode() {
        return (HyojiMode) _CommonChildDivModeUtil.getMode(this.modes, HyojiMode.class);
    }

    public void setMode_HyojiMode(HyojiMode value) {
        _CommonChildDivModeUtil.setMode(this.modes, HyojiMode.class, value);
    }

    public static enum HeightSize implements ICommonChildDivMode {

        サイズ200("サイズ200"),
        サイズ250("サイズ250"),
        サイズ300("サイズ300"),
        サイズ350("サイズ350"),
        サイズ400("サイズ400"),
        サイズ450("サイズ450"),
        サイズ500("サイズ500");

        private final String name;

        private HeightSize(final String name) {
            this.name = name;
        }

        public static HeightSize getEnum(String str) {
            HeightSize[] enumArray = HeightSize.values();

            for (HeightSize enumStr : enumArray) {
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

    public HeightSize getMode_HeightSize() {
        return (HeightSize) _CommonChildDivModeUtil.getMode(this.modes, HeightSize.class);
    }

    public void setMode_HeightSize(HeightSize value) {
        _CommonChildDivModeUtil.setMode(this.modes, HeightSize.class, value);
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

    /**
     * 施設入退所履歴の共有子DIVの画面内容から、施設入退所履歴情報をDBに反映します。
     */
    @Override
    public void saveShisetsuNyutaisho() {
        getHandler().saveShisetsuNyutaisho();
    }

    @Override
    public void set表示モード(RString 表示) {
        setMode_HyojiMode(HyojiMode.getEnum(表示.toString()));
    }

    @Override
    public void set明細表示モード(RString 明細表示) {
        setMode_MeisaiHyojiMode(MeisaiHyojiMode.getEnum(明細表示.toString()));
    }

    @Override
    public void set利用モード(RString 利用モード) {
        setMode_RiyoType(RiyoType.getEnum(利用モード.toString()));
    }

    @Override
    public void set表示widthサイズ(RString widthサイズ) {
        setMode_WidthSize(WidthSize.getEnum(widthサイズ.toString()));
    }

    @Override
    public void set表示heightサイズ(RString heightサイズ) {
        setMode_HeightSize(HeightSize.getEnum(heightサイズ.toString()));
    }

    @Override
    public List<dgShisetsuNyutaishoRireki_Row> get施設入退所履歴一覧() {
        return getHandler().get施設入退所履歴一覧();
    }
}
