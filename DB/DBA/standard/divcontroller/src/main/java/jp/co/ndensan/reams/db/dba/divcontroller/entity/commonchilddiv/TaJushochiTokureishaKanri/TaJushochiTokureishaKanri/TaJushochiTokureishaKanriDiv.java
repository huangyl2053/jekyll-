package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri.TaJushochiTokureishaKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.IHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.ShisetsuJohoCommonChildDivDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.hokenshajoho.HokenshaJohoDiv;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Mode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * TaJushochiTokureishaKanri のクラスファイル
 *
 * @reamsid_L DBA-0200-010 linghuhang
 */
public class TaJushochiTokureishaKanriDiv extends Panel implements ITaJushochiTokureishaKanriDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnAdd")
    private Button btnAdd;
    @JsonProperty("dgJushochiTokureiRireki")
    private DataGrid<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki;
    @JsonProperty("TajushochiTokureiInput")
    private TajushochiTokureiInputDiv TajushochiTokureiInput;
    @JsonProperty("Strate")
    private RString Strate;
    @JsonProperty("SelectData")
    private RString SelectData;

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
     * getdgJushochiTokureiRireki
     * @return dgJushochiTokureiRireki
     */
    @JsonProperty("dgJushochiTokureiRireki")
    public DataGrid<dgJushochiTokureiRireki_Row> getDgJushochiTokureiRireki() {
        return dgJushochiTokureiRireki;
    }

    /*
     * setdgJushochiTokureiRireki
     * @param dgJushochiTokureiRireki dgJushochiTokureiRireki
     */
    @JsonProperty("dgJushochiTokureiRireki")
    public void setDgJushochiTokureiRireki(DataGrid<dgJushochiTokureiRireki_Row> dgJushochiTokureiRireki) {
        this.dgJushochiTokureiRireki = dgJushochiTokureiRireki;
    }

    /*
     * getTajushochiTokureiInput
     * @return TajushochiTokureiInput
     */
    @JsonProperty("TajushochiTokureiInput")
    public TajushochiTokureiInputDiv getTajushochiTokureiInput() {
        return TajushochiTokureiInput;
    }

    /*
     * setTajushochiTokureiInput
     * @param TajushochiTokureiInput TajushochiTokureiInput
     */
    @JsonProperty("TajushochiTokureiInput")
    public void setTajushochiTokureiInput(TajushochiTokureiInputDiv TajushochiTokureiInput) {
        this.TajushochiTokureiInput = TajushochiTokureiInput;
    }

    /*
     * getStrate
     * @return Strate
     */
    @JsonProperty("Strate")
    public RString getStrate() {
        return Strate;
    }

    /*
     * setStrate
     * @param Strate Strate
     */
    @JsonProperty("Strate")
    public void setStrate(RString Strate) {
        this.Strate = Strate;
    }

    /*
     * getSelectData
     * @return SelectData
     */
    @JsonProperty("SelectData")
    public RString getSelectData() {
        return SelectData;
    }

    /*
     * setSelectData
     * @param SelectData SelectData
     */
    @JsonProperty("SelectData")
    public void setSelectData(RString SelectData) {
        this.SelectData = SelectData;
    }

    /*
     * [共有子DIVモード]
     */
    @JsonProperty("modes")
    private HashSet<Mode> modes;

    public static enum DisplayMode implements ICommonChildDivMode {

        Shokai("Shokai"),
        Teisei("Teisei"),
        Tekiyo("Tekiyo"),
        Kaijyo("Kaijyo"),
        ShisetuHenko("ShisetuHenko");

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

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtNyusyobi() {
        return this.getTajushochiTokureiInput().getTxtNyusyobi();
    }

    @JsonIgnore
    public void  setTxtNyusyobi(TextBoxDate txtNyusyobi) {
        this.getTajushochiTokureiInput().setTxtNyusyobi(txtNyusyobi);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyobi() {
        return this.getTajushochiTokureiInput().getTxtTekiyobi();
    }

    @JsonIgnore
    public void  setTxtTekiyobi(TextBoxDate txtTekiyobi) {
        this.getTajushochiTokureiInput().setTxtTekiyobi(txtTekiyobi);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyoTodokedebi() {
        return this.getTajushochiTokureiInput().getTxtTekiyoTodokedebi();
    }

    @JsonIgnore
    public void  setTxtTekiyoTodokedebi(TextBoxDate txtTekiyoTodokedebi) {
        this.getTajushochiTokureiInput().setTxtTekiyoTodokedebi(txtTekiyoTodokedebi);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyo() {
        return this.getTajushochiTokureiInput().getDdlTekiyoJiyo();
    }

    @JsonIgnore
    public void  setDdlTekiyoJiyo(DropDownList ddlTekiyoJiyo) {
        this.getTajushochiTokureiInput().setDdlTekiyoJiyo(ddlTekiyoJiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtTasyobi() {
        return this.getTajushochiTokureiInput().getTxtTasyobi();
    }

    @JsonIgnore
    public void  setTxtTasyobi(TextBoxDate txtTasyobi) {
        this.getTajushochiTokureiInput().setTxtTasyobi(txtTasyobi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijyobi() {
        return this.getTajushochiTokureiInput().getTxtKaijyobi();
    }

    @JsonIgnore
    public void  setTxtKaijyobi(TextBoxDate txtKaijyobi) {
        this.getTajushochiTokureiInput().setTxtKaijyobi(txtKaijyobi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijyoTodokedebi() {
        return this.getTajushochiTokureiInput().getTxtKaijyoTodokedebi();
    }

    @JsonIgnore
    public void  setTxtKaijyoTodokedebi(TextBoxDate txtKaijyoTodokedebi) {
        this.getTajushochiTokureiInput().setTxtKaijyoTodokedebi(txtKaijyoTodokedebi);
    }

    @JsonIgnore
    public DropDownList getDdlKaijyoJiyo() {
        return this.getTajushochiTokureiInput().getDdlKaijyoJiyo();
    }

    @JsonIgnore
    public void  setDdlKaijyoJiyo(DropDownList ddlKaijyoJiyo) {
        this.getTajushochiTokureiInput().setDdlKaijyoJiyo(ddlKaijyoJiyo);
    }

    @JsonIgnore
    public panSotimotoJyohoDiv getPanSotimotoJyoho() {
        return this.getTajushochiTokureiInput().getPanSotimotoJyoho();
    }

    @JsonIgnore
    public void  setPanSotimotoJyoho(panSotimotoJyohoDiv panSotimotoJyoho) {
        this.getTajushochiTokureiInput().setPanSotimotoJyoho(panSotimotoJyoho);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihoNo() {
        return this.getTajushochiTokureiInput().getPanSotimotoJyoho().getTxtHihoNo();
    }

    @JsonIgnore
    public void  setTxtHihoNo(TextBoxCode txtHihoNo) {
        this.getTajushochiTokureiInput().getPanSotimotoJyoho().setTxtHihoNo(txtHihoNo);
    }

    @JsonIgnore
    public IHokenshaJohoDiv getCcdHokensha() {
        return this.getTajushochiTokureiInput().getPanSotimotoJyoho().getCcdHokensha();
    }

    @JsonIgnore
    public panShisetsuJohoDiv getPanShisetsuJoho() {
        return this.getTajushochiTokureiInput().getPanShisetsuJoho();
    }

    @JsonIgnore
    public void  setPanShisetsuJoho(panShisetsuJohoDiv panShisetsuJoho) {
        this.getTajushochiTokureiInput().setPanShisetsuJoho(panShisetsuJoho);
    }

    @JsonIgnore
    public IShisetsuJohoCommonChildDiv getCcdShisetsuJoho() {
        return this.getTajushochiTokureiInput().getPanShisetsuJoho().getCcdShisetsuJoho();
    }

    @JsonIgnore
    public Button getBtnKakunin() {
        return this.getTajushochiTokureiInput().getBtnKakunin();
    }

    @JsonIgnore
    public void  setBtnKakunin(Button btnKakunin) {
        this.getTajushochiTokureiInput().setBtnKakunin(btnKakunin);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getTajushochiTokureiInput().getBtnTorikeshi();
    }

    @JsonIgnore
    public void  setBtnTorikeshi(Button btnTorikeshi) {
        this.getTajushochiTokureiInput().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private TaJushochiTokureishaKanriHandler getHandler() {
        return new TaJushochiTokureishaKanriHandler(this);
    }

    @Override
    public void set状態(RString mode) {
        setMode_DisplayMode(DisplayMode.getEnum(mode.toString()));
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
     * 他住所地特例者の共有子DIVの画面内容から、他市町村住所地特例情報をDBに反映します。
     */
    @Override
    public void saveTaJushochiTokurei(ShikibetsuCode 識別コード) {
        getHandler().saveTaJushochiTokurei(識別コード);
    }

    /**
     * 適用情報一覧を取得します。
     *
     * @return 適用情報一覧 適用情報一覧
     */
    @Override
    public List<dgJushochiTokureiRireki_Row> get適用情報一覧() {
        return getHandler().get適用情報一覧();
    }
}
