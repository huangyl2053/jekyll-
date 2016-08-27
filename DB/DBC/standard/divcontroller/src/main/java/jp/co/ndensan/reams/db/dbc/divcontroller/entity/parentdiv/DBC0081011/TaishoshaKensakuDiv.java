package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0081011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TaishoshaKensaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class TaishoshaKensakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtToriatsukaiYM")
    private TextBoxDate txtToriatsukaiYM;
    @JsonProperty("DDLSityouson")
    private DropDownList DDLSityouson;
    @JsonProperty("btnSearch")
    private Button btnSearch;
    @JsonProperty("KetteiHokensha")
    private KetteiHokenshaDiv KetteiHokensha;

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
     * getDDLSityouson
     * @return DDLSityouson
     */
    @JsonProperty("DDLSityouson")
    public DropDownList getDDLSityouson() {
        return DDLSityouson;
    }

    /*
     * setDDLSityouson
     * @param DDLSityouson DDLSityouson
     */
    @JsonProperty("DDLSityouson")
    public void setDDLSityouson(DropDownList DDLSityouson) {
        this.DDLSityouson = DDLSityouson;
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
    public Button getBtnSogojigyoHokenshaJoho() {
        return this.getKetteiHokensha().getBtnSogojigyoHokenshaJoho();
    }

    @JsonIgnore
    public void  setBtnSogojigyoHokenshaJoho(Button btnSogojigyoHokenshaJoho) {
        this.getKetteiHokensha().setBtnSogojigyoHokenshaJoho(btnSogojigyoHokenshaJoho);
    }

    @JsonIgnore
    public Button getBtnKouhiFutansya() {
        return this.getKetteiHokensha().getBtnKouhiFutansya();
    }

    @JsonIgnore
    public void  setBtnKouhiFutansya(Button btnKouhiFutansya) {
        this.getKetteiHokensha().setBtnKouhiFutansya(btnKouhiFutansya);
    }

    @JsonIgnore
    public Button getBtnSougouKouhiFutansya() {
        return this.getKetteiHokensha().getBtnSougouKouhiFutansya();
    }

    @JsonIgnore
    public void  setBtnSougouKouhiFutansya(Button btnSougouKouhiFutansya) {
        this.getKetteiHokensha().setBtnSougouKouhiFutansya(btnSougouKouhiFutansya);
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
    public TextBoxDate getTxtKetteiHokenshaSakuseiYMD() {
        return this.getKetteiHokensha().getTxtKetteiHokenshaSakuseiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiHokenshaSakuseiYMD(TextBoxDate txtKetteiHokenshaSakuseiYMD) {
        this.getKetteiHokensha().setTxtKetteiHokenshaSakuseiYMD(txtKetteiHokenshaSakuseiYMD);
    }

    @JsonIgnore
    public TextBox getTxtSinsaiinkai() {
        return this.getKetteiHokensha().getTxtSinsaiinkai();
    }

    @JsonIgnore
    public void  setTxtSinsaiinkai(TextBox txtSinsaiinkai) {
        this.getKetteiHokensha().setTxtSinsaiinkai(txtSinsaiinkai);
    }

    @JsonIgnore
    public DropDownList getDDLRireki() {
        return this.getKetteiHokensha().getDDLRireki();
    }

    @JsonIgnore
    public void  setDDLRireki(DropDownList DDLRireki) {
        this.getKetteiHokensha().setDDLRireki(DDLRireki);
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
    public Space getSpaceKuhaku1() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getSpaceKuhaku1();
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
    public Space getSpaceKuhaku2() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getSpaceKuhaku2();
    }

    @JsonIgnore
    public Label getLblSeikyuTani() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblSeikyuTani();
    }

    @JsonIgnore
    public Space getSpaceKuhaku4() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getSpaceKuhaku4();
    }

    @JsonIgnore
    public Space getSpaceKuhaku5() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getSpaceKuhaku5();
    }

    @JsonIgnore
    public Label getLblKeteiTani() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblKeteiTani();
    }

    @JsonIgnore
    public Space getSpaceKuhaku6() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getSpaceKuhaku6();
    }

    @JsonIgnore
    public Space getSpaceKuhaku8() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getSpaceKuhaku8();
    }

    @JsonIgnore
    public Label getLblTyoseiTani() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblTyoseiTani();
    }

    @JsonIgnore
    public Space getSpaceKuhaku7() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getSpaceKuhaku7();
    }

    @JsonIgnore
    public Label getLblSeikyuFutangaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblSeikyuFutangaku();
    }

    @JsonIgnore
    public Label getLblKeteiFutangaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblKeteiFutangaku();
    }

    @JsonIgnore
    public Label getLblTyouseiFutangaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblTyouseiFutangaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKaigokyuhuhi() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblKetteihokenshaKaigokyuhuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSeikyuKensu() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKaigoSeikyuKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoKeiteKensu() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKaigoKeiteKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoYouseiKensu() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKaigoYouseiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSeikyuTani() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKaigoSeikyuTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoKeteiTani() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKaigoKeteiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoTyoseiTani() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKaigoTyoseiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSeikyuFutangaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKaigoSeikyuFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoKeteiFutangaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKaigoKeteiFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoTyoseiFutangaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKaigoTyoseiFutangaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKogakuServiceHi() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getLblKetteihokenshaKogakuServiceHi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSeikyuKensu() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKougakuSeikyuKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuKeiteKensu() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKougakuKeiteKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuYouseiKensu() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKougakuYouseiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtkougakuSeikyuTani() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtkougakuSeikyuTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuKeteiTani() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKougakuKeteiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuTyoseiTani() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKougakuTyoseiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSeikyuFutangaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKougakuSeikyuFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuKeteiFutangaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKougakuKeteiFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuTyoseiFutangaku() {
        return this.getKetteiHokensha().getKetteiHokenshaShukei().getTxtKougakuTyoseiFutangaku();
    }

    @JsonIgnore
    public DataGrid<dgKetteiHokenshaDetail_Row> getDgKetteiHokenshaDetail() {
        return this.getKetteiHokensha().getDgKetteiHokenshaDetail();
    }

    @JsonIgnore
    public void  setDgKetteiHokenshaDetail(DataGrid<dgKetteiHokenshaDetail_Row> dgKetteiHokenshaDetail) {
        this.getKetteiHokensha().setDgKetteiHokenshaDetail(dgKetteiHokenshaDetail);
    }

    // </editor-fold>
}
