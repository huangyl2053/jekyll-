package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShujiiIryokikanGuide.ShujiiIryokikanGuide;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShujiiIryokikanGuide のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShujiiIryokikanGuideDiv extends Panel implements IShujiiIryokikanGuideDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-02_08-19-39">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KensakuJoken")
    private KensakuJokenDiv KensakuJoken;
    @JsonProperty("KensakuKekkaIchiran")
    private KensakuKekkaIchiranDiv KensakuKekkaIchiran;
    @JsonProperty("btnBack")
    private Button btnBack;
    @JsonProperty("hdnDatabaseSubGyomuCode")
    private RString hdnDatabaseSubGyomuCode;
    @JsonProperty("hdnShujiiIryoKikanCode")
    private RString hdnShujiiIryoKikanCode;
    @JsonProperty("hdnShujiiCode")
    private RString hdnShujiiCode;
    @JsonProperty("hdnDataPass")
    private RString hdnDataPass;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKensakuJoken
     * @return KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public KensakuJokenDiv getKensakuJoken() {
        return KensakuJoken;
    }

    /*
     * setKensakuJoken
     * @param KensakuJoken KensakuJoken
     */
    @JsonProperty("KensakuJoken")
    public void setKensakuJoken(KensakuJokenDiv KensakuJoken) {
        this.KensakuJoken = KensakuJoken;
    }

    /*
     * getKensakuKekkaIchiran
     * @return KensakuKekkaIchiran
     */
    @JsonProperty("KensakuKekkaIchiran")
    public KensakuKekkaIchiranDiv getKensakuKekkaIchiran() {
        return KensakuKekkaIchiran;
    }

    /*
     * setKensakuKekkaIchiran
     * @param KensakuKekkaIchiran KensakuKekkaIchiran
     */
    @JsonProperty("KensakuKekkaIchiran")
    public void setKensakuKekkaIchiran(KensakuKekkaIchiranDiv KensakuKekkaIchiran) {
        this.KensakuKekkaIchiran = KensakuKekkaIchiran;
    }

    /*
     * getbtnBack
     * @return btnBack
     */
    @JsonProperty("btnBack")
    public Button getBtnBack() {
        return btnBack;
    }

    /*
     * setbtnBack
     * @param btnBack btnBack
     */
    @JsonProperty("btnBack")
    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    /*
     * gethdnDatabaseSubGyomuCode
     * @return hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public RString getHdnDatabaseSubGyomuCode() {
        return hdnDatabaseSubGyomuCode;
    }

    /*
     * sethdnDatabaseSubGyomuCode
     * @param hdnDatabaseSubGyomuCode hdnDatabaseSubGyomuCode
     */
    @JsonProperty("hdnDatabaseSubGyomuCode")
    public void setHdnDatabaseSubGyomuCode(RString hdnDatabaseSubGyomuCode) {
        this.hdnDatabaseSubGyomuCode = hdnDatabaseSubGyomuCode;
    }

    /*
     * gethdnShujiiIryoKikanCode
     * @return hdnShujiiIryoKikanCode
     */
    @JsonProperty("hdnShujiiIryoKikanCode")
    public RString getHdnShujiiIryoKikanCode() {
        return hdnShujiiIryoKikanCode;
    }

    /*
     * sethdnShujiiIryoKikanCode
     * @param hdnShujiiIryoKikanCode hdnShujiiIryoKikanCode
     */
    @JsonProperty("hdnShujiiIryoKikanCode")
    public void setHdnShujiiIryoKikanCode(RString hdnShujiiIryoKikanCode) {
        this.hdnShujiiIryoKikanCode = hdnShujiiIryoKikanCode;
    }

    /*
     * gethdnShujiiCode
     * @return hdnShujiiCode
     */
    @JsonProperty("hdnShujiiCode")
    public RString getHdnShujiiCode() {
        return hdnShujiiCode;
    }

    /*
     * sethdnShujiiCode
     * @param hdnShujiiCode hdnShujiiCode
     */
    @JsonProperty("hdnShujiiCode")
    public void setHdnShujiiCode(RString hdnShujiiCode) {
        this.hdnShujiiCode = hdnShujiiCode;
    }

    /*
     * gethdnDataPass
     * @return hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public RString getHdnDataPass() {
        return hdnDataPass;
    }

    /*
     * sethdnDataPass
     * @param hdnDataPass hdnDataPass
     */
    @JsonProperty("hdnDataPass")
    public void setHdnDataPass(RString hdnDataPass) {
        this.hdnDataPass = hdnDataPass;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IHokenshaListDiv getHokenshaList() {
        return this.getKensakuJoken().getHokenshaList();
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCodeFrom() {
        return this.getKensakuJoken().getTxtIryoKikanCodeFrom();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCodeFrom(TextBoxCode txtIryoKikanCodeFrom) {
        this.getKensakuJoken().setTxtIryoKikanCodeFrom(txtIryoKikanCodeFrom);
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCodeTo() {
        return this.getKensakuJoken().getTxtIryoKikanCodeTo();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCodeTo(TextBoxCode txtIryoKikanCodeTo) {
        this.getKensakuJoken().setTxtIryoKikanCodeTo(txtIryoKikanCodeTo);
    }

    @JsonIgnore
    public RadioButton getRadIryoKikanJokyo() {
        return this.getKensakuJoken().getRadIryoKikanJokyo();
    }

    @JsonIgnore
    public void  setRadIryoKikanJokyo(RadioButton radIryoKikanJokyo) {
        this.getKensakuJoken().setRadIryoKikanJokyo(radIryoKikanJokyo);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanName() {
        return this.getKensakuJoken().getTxtIryoKikanName();
    }

    @JsonIgnore
    public void  setTxtIryoKikanName(TextBox txtIryoKikanName) {
        this.getKensakuJoken().setTxtIryoKikanName(txtIryoKikanName);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanKanaMeisho() {
        return this.getKensakuJoken().getTxtIryoKikanKanaMeisho();
    }

    @JsonIgnore
    public void  setTxtIryoKikanKanaMeisho(TextBox txtIryoKikanKanaMeisho) {
        this.getKensakuJoken().setTxtIryoKikanKanaMeisho(txtIryoKikanKanaMeisho);
    }

    @JsonIgnore
    public TextBoxNum getTxtMaxKensu() {
        return this.getKensakuJoken().getTxtMaxKensu();
    }

    @JsonIgnore
    public void  setTxtMaxKensu(TextBoxNum txtMaxKensu) {
        this.getKensakuJoken().setTxtMaxKensu(txtMaxKensu);
    }

    @JsonIgnore
    public Button getBtnClear() {
        return this.getKensakuJoken().getBtnClear();
    }

    @JsonIgnore
    public void  setBtnClear(Button btnClear) {
        this.getKensakuJoken().setBtnClear(btnClear);
    }

    @JsonIgnore
    public Button getBtnKensaku() {
        return this.getKensakuJoken().getBtnKensaku();
    }

    @JsonIgnore
    public void  setBtnKensaku(Button btnKensaku) {
        this.getKensakuJoken().setBtnKensaku(btnKensaku);
    }

    @JsonIgnore
    public DataGrid<dgKensakuKekkaIchiran_Row> getDgKensakuKekkaIchiran() {
        return this.getKensakuKekkaIchiran().getDgKensakuKekkaIchiran();
    }

    @JsonIgnore
    public void  setDgKensakuKekkaIchiran(DataGrid<dgKensakuKekkaIchiran_Row> dgKensakuKekkaIchiran) {
        this.getKensakuKekkaIchiran().setDgKensakuKekkaIchiran(dgKensakuKekkaIchiran);
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

    @Override
    public void initialize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
