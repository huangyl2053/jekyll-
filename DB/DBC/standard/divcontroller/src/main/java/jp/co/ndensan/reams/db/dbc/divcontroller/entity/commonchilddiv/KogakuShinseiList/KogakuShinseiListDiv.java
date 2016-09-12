package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KogakuShinseiList;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.HashSet;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.viewstate.ViewStateKeys;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxYearMonth;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ICommonChildDivMode;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ViewStateHolder;
import jp.co.ndensan.reams.uz.uza.ui.servlets._CommonChildDivModeUtil;

/**
 * 画面設計_DBCKD00005_高額申請一覧共有子Div
 *
 * @reamsid_L DBC-2020-010 quxiaodong
 */
public class KogakuShinseiListDiv extends Panel implements IKogakuShinseiListDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtServiceYM")
    private TextBoxYearMonth txtServiceYM;
    @JsonProperty("txtShokisai")
    private TextBoxCode txtShokisai;
    @JsonProperty("btnShinseiJohoTsuika")
    private Button btnShinseiJohoTsuika;
    @JsonProperty("btnTaishosyaJoho")
    private Button btnTaishosyaJoho;
    @JsonProperty("lin1")
    private HorizontalLine lin1;
    @JsonProperty("txtServiceYMFrom")
    private TextBoxYearMonth txtServiceYMFrom;
    @JsonProperty("txtServiceYMTo")
    private TextBoxYearMonth txtServiceYMTo;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("dgShinseiJoho")
    private DataGrid<dgShinseiJoho_Row> dgShinseiJoho;
    @JsonProperty("rowId")
    private TextBoxNum rowId;
    @JsonProperty("サービス年月")
    private RString サービス年月;
    @JsonProperty("証記載保険者番号")
    private RString 証記載保険者番号;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtServiceYM
     * @return txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public TextBoxYearMonth getTxtServiceYM() {
        return txtServiceYM;
    }

    /*
     * settxtServiceYM
     * @param txtServiceYM txtServiceYM
     */
    @JsonProperty("txtServiceYM")
    public void setTxtServiceYM(TextBoxYearMonth txtServiceYM) {
        this.txtServiceYM = txtServiceYM;
    }

    /*
     * gettxtShokisai
     * @return txtShokisai
     */
    @JsonProperty("txtShokisai")
    public TextBoxCode getTxtShokisai() {
        return txtShokisai;
    }

    /*
     * settxtShokisai
     * @param txtShokisai txtShokisai
     */
    @JsonProperty("txtShokisai")
    public void setTxtShokisai(TextBoxCode txtShokisai) {
        this.txtShokisai = txtShokisai;
    }

    /*
     * getbtnShinseiJohoTsuika
     * @return btnShinseiJohoTsuika
     */
    @JsonProperty("btnShinseiJohoTsuika")
    public Button getBtnShinseiJohoTsuika() {
        return btnShinseiJohoTsuika;
    }

    /*
     * setbtnShinseiJohoTsuika
     * @param btnShinseiJohoTsuika btnShinseiJohoTsuika
     */
    @JsonProperty("btnShinseiJohoTsuika")
    public void setBtnShinseiJohoTsuika(Button btnShinseiJohoTsuika) {
        this.btnShinseiJohoTsuika = btnShinseiJohoTsuika;
    }

    /*
     * getbtnTaishosyaJoho
     * @return btnTaishosyaJoho
     */
    @JsonProperty("btnTaishosyaJoho")
    public Button getBtnTaishosyaJoho() {
        return btnTaishosyaJoho;
    }

    /*
     * setbtnTaishosyaJoho
     * @param btnTaishosyaJoho btnTaishosyaJoho
     */
    @JsonProperty("btnTaishosyaJoho")
    public void setBtnTaishosyaJoho(Button btnTaishosyaJoho) {
        this.btnTaishosyaJoho = btnTaishosyaJoho;
    }

    /*
     * getlin1
     * @return lin1
     */
    @JsonProperty("lin1")
    public HorizontalLine getLin1() {
        return lin1;
    }

    /*
     * setlin1
     * @param lin1 lin1
     */
    @JsonProperty("lin1")
    public void setLin1(HorizontalLine lin1) {
        this.lin1 = lin1;
    }

    /*
     * gettxtServiceYMFrom
     * @return txtServiceYMFrom
     */
    @JsonProperty("txtServiceYMFrom")
    public TextBoxYearMonth getTxtServiceYMFrom() {
        return txtServiceYMFrom;
    }

    /*
     * settxtServiceYMFrom
     * @param txtServiceYMFrom txtServiceYMFrom
     */
    @JsonProperty("txtServiceYMFrom")
    public void setTxtServiceYMFrom(TextBoxYearMonth txtServiceYMFrom) {
        this.txtServiceYMFrom = txtServiceYMFrom;
    }

    /*
     * gettxtServiceYMTo
     * @return txtServiceYMTo
     */
    @JsonProperty("txtServiceYMTo")
    public TextBoxYearMonth getTxtServiceYMTo() {
        return txtServiceYMTo;
    }

    /*
     * settxtServiceYMTo
     * @param txtServiceYMTo txtServiceYMTo
     */
    @JsonProperty("txtServiceYMTo")
    public void setTxtServiceYMTo(TextBoxYearMonth txtServiceYMTo) {
        this.txtServiceYMTo = txtServiceYMTo;
    }

    /*
     * getbtnKensaku
     * @return btnKensaku
     */
    @JsonProperty("btnKensaku")
    public Button getBtnKensaku() {
        return btnKensaku;
    }

    /*
     * setbtnKensaku
     * @param btnKensaku btnKensaku
     */
    @JsonProperty("btnKensaku")
    public void setBtnKensaku(Button btnKensaku) {
        this.btnKensaku = btnKensaku;
    }

    /*
     * getdgShinseiJoho
     * @return dgShinseiJoho
     */
    @JsonProperty("dgShinseiJoho")
    public DataGrid<dgShinseiJoho_Row> getDgShinseiJoho() {
        return dgShinseiJoho;
    }

    /*
     * setdgShinseiJoho
     * @param dgShinseiJoho dgShinseiJoho
     */
    @JsonProperty("dgShinseiJoho")
    public void setDgShinseiJoho(DataGrid<dgShinseiJoho_Row> dgShinseiJoho) {
        this.dgShinseiJoho = dgShinseiJoho;
    }

    /*
     * getrowId
     * @return rowId
     */
    @JsonProperty("rowId")
    public TextBoxNum getRowId() {
        return rowId;
    }

    /*
     * setrowId
     * @param rowId rowId
     */
    @JsonProperty("rowId")
    public void setRowId(TextBoxNum rowId) {
        this.rowId = rowId;
    }

    /*
     * getサービス年月
     * @return サービス年月
     */
    @JsonProperty("サービス年月")
    public RString getサービス年月() {
        return サービス年月;
    }

    /*
     * setサービス年月
     * @param サービス年月 サービス年月
     */
    @JsonProperty("サービス年月")
    public void setサービス年月(RString サービス年月) {
        this.サービス年月 = サービス年月;
    }

    /*
     * get証記載保険者番号
     * @return 証記載保険者番号
     */
    @JsonProperty("証記載保険者番号")
    public RString get証記載保険者番号() {
        return 証記載保険者番号;
    }

    /*
     * set証記載保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     */
    @JsonProperty("証記載保険者番号")
    public void set証記載保険者番号(RString 証記載保険者番号) {
        this.証記載保険者番号 = 証記載保険者番号;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        shokai("shokai"),
        toroku("toroku");

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

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    /**
     * 画面初期化
     *
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param 導入形態コード RString
     */
    @Override
    public void initialize(RString メニューID, HihokenshaNo 被保険者番号, RString 導入形態コード) {
        KogakuShinseiListDivHandler.of(this).画面初期化(メニューID, 被保険者番号, 導入形態コード);
        ViewStateHolder.put(ViewStateKeys.被保険者番号, 被保険者番号);
        ViewStateHolder.put(ViewStateKeys.導入形態コード, 導入形態コード);
        ViewStateHolder.put(ViewStateKeys.メニューID, メニューID);
    }

    /**
     * 審査決定フラグ
     *
     * @return boolean
     */
    @Override
    public boolean is審査決定フラグ() {
        return KogakuShinseiListDivHandler.of(this).is審査決定フラグ();
    }

    /**
     * 決定情報フラグ
     *
     * @return boolean
     */
    @Override
    public boolean is決定情報フラグ() {
        return KogakuShinseiListDivHandler.of(this).is決定情報フラグ();
    }

    /**
     * 支給区分フラグ
     *
     * @return boolean
     */
    @Override
    public boolean is支給区分フラグ() {
        return KogakuShinseiListDivHandler.of(this).is支給区分フラグ();
    }
}
