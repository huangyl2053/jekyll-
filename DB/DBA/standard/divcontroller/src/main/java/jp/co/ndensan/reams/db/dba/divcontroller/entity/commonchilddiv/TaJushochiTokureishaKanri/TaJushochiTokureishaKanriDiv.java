package jp.co.ndensan.reams.db.dba.divcontroller.entity.commonchilddiv.TaJushochiTokureishaKanri;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.HokenshaJoho.IHokenshaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShisetsuJohoCommonChildDiv.IShisetsuJohoCommonChildDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxCode;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;

/**
 * TaJushochiTokureishaKanri のクラスファイル
 *
 * @author 自動生成
 */
public class TaJushochiTokureishaKanriDiv extends Panel implements ITaJushochiTokureishaKanriDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtNyusyobi() {
        return this.getTajushochiTokureiInput().getTxtNyusyobi();
    }

    @JsonIgnore
    public void setTxtNyusyobi(TextBoxDate txtNyusyobi) {
        this.getTajushochiTokureiInput().setTxtNyusyobi(txtNyusyobi);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyobi() {
        return this.getTajushochiTokureiInput().getTxtTekiyobi();
    }

    @JsonIgnore
    public void setTxtTekiyobi(TextBoxDate txtTekiyobi) {
        this.getTajushochiTokureiInput().setTxtTekiyobi(txtTekiyobi);
    }

    @JsonIgnore
    public TextBoxDate getTxtTekiyoTodokedebi() {
        return this.getTajushochiTokureiInput().getTxtTekiyoTodokedebi();
    }

    @JsonIgnore
    public void setTxtTekiyoTodokedebi(TextBoxDate txtTekiyoTodokedebi) {
        this.getTajushochiTokureiInput().setTxtTekiyoTodokedebi(txtTekiyoTodokedebi);
    }

    @JsonIgnore
    public DropDownList getDdlTekiyoJiyo() {
        return this.getTajushochiTokureiInput().getDdlTekiyoJiyo();
    }

    @JsonIgnore
    public void setDdlTekiyoJiyo(DropDownList ddlTekiyoJiyo) {
        this.getTajushochiTokureiInput().setDdlTekiyoJiyo(ddlTekiyoJiyo);
    }

    @JsonIgnore
    public TextBoxDate getTxtTasyobi() {
        return this.getTajushochiTokureiInput().getTxtTasyobi();
    }

    @JsonIgnore
    public void setTxtTasyobi(TextBoxDate txtTasyobi) {
        this.getTajushochiTokureiInput().setTxtTasyobi(txtTasyobi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijyobi() {
        return this.getTajushochiTokureiInput().getTxtKaijyobi();
    }

    @JsonIgnore
    public void setTxtKaijyobi(TextBoxDate txtKaijyobi) {
        this.getTajushochiTokureiInput().setTxtKaijyobi(txtKaijyobi);
    }

    @JsonIgnore
    public TextBoxDate getTxtKaijyoTodokedebi() {
        return this.getTajushochiTokureiInput().getTxtKaijyoTodokedebi();
    }

    @JsonIgnore
    public void setTxtKaijyoTodokedebi(TextBoxDate txtKaijyoTodokedebi) {
        this.getTajushochiTokureiInput().setTxtKaijyoTodokedebi(txtKaijyoTodokedebi);
    }

    @JsonIgnore
    public DropDownList getDdlKaijyoJiyo() {
        return this.getTajushochiTokureiInput().getDdlKaijyoJiyo();
    }

    @JsonIgnore
    public void setDdlKaijyoJiyo(DropDownList ddlKaijyoJiyo) {
        this.getTajushochiTokureiInput().setDdlKaijyoJiyo(ddlKaijyoJiyo);
    }

    @JsonIgnore
    public panSotimotoJyohoDiv getPanSotimotoJyoho() {
        return this.getTajushochiTokureiInput().getPanSotimotoJyoho();
    }

    @JsonIgnore
    public void setPanSotimotoJyoho(panSotimotoJyohoDiv panSotimotoJyoho) {
        this.getTajushochiTokureiInput().setPanSotimotoJyoho(panSotimotoJyoho);
    }

    @JsonIgnore
    public TextBoxCode getTxtHihoNo() {
        return this.getTajushochiTokureiInput().getPanSotimotoJyoho().getTxtHihoNo();
    }

    @JsonIgnore
    public void setTxtHihoNo(TextBoxCode txtHihoNo) {
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
    public void setPanShisetsuJoho(panShisetsuJohoDiv panShisetsuJoho) {
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
    public void setBtnKakunin(Button btnKakunin) {
        this.getTajushochiTokureiInput().setBtnKakunin(btnKakunin);
    }

    @JsonIgnore
    public Button getBtnTorikeshi() {
        return this.getTajushochiTokureiInput().getBtnTorikeshi();
    }

    @JsonIgnore
    public void setBtnTorikeshi(Button btnTorikeshi) {
        this.getTajushochiTokureiInput().setBtnTorikeshi(btnTorikeshi);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    private TaJushochiTokureishaKanriHandler getHandler() {
        return new TaJushochiTokureishaKanriHandler(this);
    }

    /**
     * 共通子DIVの初期化処理です。
     */
    @Override
    public void initialize() {
        getHandler().initialize();
    }

    /**
     * 他住所地特例者の共有子DIVの画面内容から、他市町村住所地特例情報をDBに反映します。
     */
    @Override
    public void saveTaJushochiTokurei() {
        getHandler().saveTaJushochiTokurei();
    }
}
