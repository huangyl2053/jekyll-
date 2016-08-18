package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0071011;
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

/**
 * Ketteijoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteijohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtToriatsukaiYM")
    private TextBoxDate txtToriatsukaiYM;
    @JsonProperty("ddlShichosonName")
    private DropDownList ddlShichosonName;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("KetteiHokensha")
    private KetteiHokenshaDiv KetteiHokensha;
    @JsonProperty("kubunn")
    private RString kubunn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtToriatsukaiYM
     * @return txtToriatsukaiYM
     */
    @JsonProperty("txtToriatsukaiYM")
    public TextBoxDate getTxtToriatsukaiYM() {
        return txtToriatsukaiYM;
    }

    /*
     * settxtToriatsukaiYM
     * @param txtToriatsukaiYM txtToriatsukaiYM
     */
    @JsonProperty("txtToriatsukaiYM")
    public void setTxtToriatsukaiYM(TextBoxDate txtToriatsukaiYM) {
        this.txtToriatsukaiYM = txtToriatsukaiYM;
    }

    /*
     * getddlShichosonName
     * @return ddlShichosonName
     */
    @JsonProperty("ddlShichosonName")
    public DropDownList getDdlShichosonName() {
        return ddlShichosonName;
    }

    /*
     * setddlShichosonName
     * @param ddlShichosonName ddlShichosonName
     */
    @JsonProperty("ddlShichosonName")
    public void setDdlShichosonName(DropDownList ddlShichosonName) {
        this.ddlShichosonName = ddlShichosonName;
    }

    /*
     * getbtnSearch
     * @return btnSearch
     */
    @JsonProperty("btnSearch")
    public Button getBtnSearch() {
        return btnSearch;
    }

    /*
     * setbtnSearch
     * @param btnSearch btnSearch
     */
    @JsonProperty("btnSearch")
    public void setBtnSearch(Button btnSearch) {
        this.btnSearch = btnSearch;
    }

    /*
     * getKetteiHokensha
     * @return KetteiHokensha
     */
    @JsonProperty("KetteiHokensha")
    public KetteiHokenshaDiv getKetteiHokensha() {
        return KetteiHokensha;
    }

    /*
     * setKetteiHokensha
     * @param KetteiHokensha KetteiHokensha
     */
    @JsonProperty("KetteiHokensha")
    public void setKetteiHokensha(KetteiHokenshaDiv KetteiHokensha) {
        this.KetteiHokensha = KetteiHokensha;
    }

    /*
     * getkubunn
     * @return kubunn
     */
    @JsonProperty("kubunn")
    public RString getKubunn() {
        return kubunn;
    }

    /*
     * setkubunn
     * @param kubunn kubunn
     */
    @JsonProperty("kubunn")
    public void setKubunn(RString kubunn) {
        this.kubunn = kubunn;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnHokneshaJoho() {
        return this.getKetteiHokensha().getBtnHokneshaJoho();
    }

    @JsonIgnore
    public void  setBtnHokneshaJoho(Button btnHokneshaJoho) {
        this.getKetteiHokensha().setBtnHokneshaJoho(btnHokneshaJoho);
    }

    @JsonIgnore
    public Button getBtnSogojigyohiKeikasochiHokenshaJoho() {
        return this.getKetteiHokensha().getBtnSogojigyohiKeikasochiHokenshaJoho();
    }

    @JsonIgnore
    public void  setBtnSogojigyohiKeikasochiHokenshaJoho(Button btnSogojigyohiKeikasochiHokenshaJoho) {
        this.getKetteiHokensha().setBtnSogojigyohiKeikasochiHokenshaJoho(btnSogojigyohiKeikasochiHokenshaJoho);
    }

    @JsonIgnore
    public Button getBtnSogojigyohiHokenshaJoho() {
        return this.getKetteiHokensha().getBtnSogojigyohiHokenshaJoho();
    }

    @JsonIgnore
    public void  setBtnSogojigyohiHokenshaJoho(Button btnSogojigyohiHokenshaJoho) {
        this.getKetteiHokensha().setBtnSogojigyohiHokenshaJoho(btnSogojigyohiHokenshaJoho);
    }

    @JsonIgnore
    public Button getBtnKohoFutanshaJoho() {
        return this.getKetteiHokensha().getBtnKohoFutanshaJoho();
    }

    @JsonIgnore
    public void  setBtnKohoFutanshaJoho(Button btnKohoFutanshaJoho) {
        this.getKetteiHokensha().setBtnKohoFutanshaJoho(btnKohoFutanshaJoho);
    }

    @JsonIgnore
    public Button getBtnSogojigyohiKohiFutanshaJoho() {
        return this.getKetteiHokensha().getBtnSogojigyohiKohiFutanshaJoho();
    }

    @JsonIgnore
    public void  setBtnSogojigyohiKohiFutanshaJoho(Button btnSogojigyohiKohiFutanshaJoho) {
        this.getKetteiHokensha().setBtnSogojigyohiKohiFutanshaJoho(btnSogojigyohiKohiFutanshaJoho);
    }

    @JsonIgnore
    public HorizontalLine getLine1() {
        return this.getKetteiHokensha().getLine1();
    }

    @JsonIgnore
    public void  setLine1(HorizontalLine line1) {
        this.getKetteiHokensha().setLine1(line1);
    }

    @JsonIgnore
    public KetteiHokenshaShukeiDiv getKetteiHokenshaShukei() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei();
    }

    @JsonIgnore
    public void  setKetteiHokenshaShukei(KetteiHokenshaShukeiDiv KetteiHokenshaShukei) {
        this.getKetteiHokensha().setKetteiHokenshaShukei(KetteiHokenshaShukei);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiHokenshaSakuseiYMD() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKetteiHokenshaSakuseiYMD();
    }

    @JsonIgnore
    public DropDownList getDdlRirekiNo1() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getDdlRirekiNo1();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKensu() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblKetteihokenshaKensu();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaTanisuHiyogaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblKetteihokenshaTanisuHiyogaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaHokenshaFutangaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblKetteihokenshaHokenshaFutangaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKaigokyuhuhi() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblKetteihokenshaKaigokyuhuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell11() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell11();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell12() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell12();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell13() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell13();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKogakuServiceHi() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblKetteihokenshaKogakuServiceHi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell21() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell21();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell22() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell22();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell23() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell23();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaTokuteiNyushoshaKaigo() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblKetteihokenshaTokuteiNyushoshaKaigo();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell31() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell31();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell32() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell32();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell33() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtHokenshaCell33();
    }

    @JsonIgnore
    public Label getLblHokenshaHosoku() {
        return this.getKetteiHokensha().getLblHokenshaHosoku();
    }

    @JsonIgnore
    public void  setLblHokenshaHosoku(Label lblHokenshaHosoku) {
        this.getKetteiHokensha().setLblHokenshaHosoku(lblHokenshaHosoku);
    }

    @JsonIgnore
    public DataGrid<dgKagoKetteiDetail_Row> getDgKagoKetteiDetail() {
        return this.getKetteiHokensha().getDgKagoKetteiDetail();
    }

    @JsonIgnore
    public void  setDgKagoKetteiDetail(DataGrid<dgKagoKetteiDetail_Row> dgKagoKetteiDetail) {
        this.getKetteiHokensha().setDgKagoKetteiDetail(dgKagoKetteiDetail);
    }

    // </editor-fold>
}
