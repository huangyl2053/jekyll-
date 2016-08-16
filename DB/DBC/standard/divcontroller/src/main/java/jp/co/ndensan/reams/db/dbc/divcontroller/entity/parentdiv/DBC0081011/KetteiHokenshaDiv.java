package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0081011;
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
 * KetteiHokensha のクラスファイル 
 * 
 * @author 自動生成
 */
public class KetteiHokenshaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("btnHokneshaJoho")
    private Button btnHokneshaJoho;
    @JsonProperty("btnSogojigyoHokenshaJoho")
    private Button btnSogojigyoHokenshaJoho;
    @JsonProperty("btnKouhiFutansya")
    private Button btnKouhiFutansya;
    @JsonProperty("btnSougouKouhiFutansya")
    private Button btnSougouKouhiFutansya;
    @JsonProperty("line1")
    private HorizontalLine line1;
    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    private TextBoxDate txtKetteiHokenshaSakuseiYMD;
    @JsonProperty("txtSinsaiinkai")
    private TextBox txtSinsaiinkai;
    @JsonProperty("DDLRireki")
    private DropDownList DDLRireki;
    @JsonProperty("KetteiHokenshaShukei")
    private KetteiHokenshaShukeiDiv KetteiHokenshaShukei;
    @JsonProperty("dgKetteiHokenshaDetail")
    private DataGrid<dgKetteiHokenshaDetail_Row> dgKetteiHokenshaDetail;
    @JsonProperty("kubunn")
    private RString kubunn;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getbtnHokneshaJoho
     * @return btnHokneshaJoho
     */
    @JsonProperty("btnHokneshaJoho")
    public Button getBtnHokneshaJoho() {
        return btnHokneshaJoho;
    }

    /*
     * setbtnHokneshaJoho
     * @param btnHokneshaJoho btnHokneshaJoho
     */
    @JsonProperty("btnHokneshaJoho")
    public void setBtnHokneshaJoho(Button btnHokneshaJoho) {
        this.btnHokneshaJoho = btnHokneshaJoho;
    }

    /*
     * getbtnSogojigyoHokenshaJoho
     * @return btnSogojigyoHokenshaJoho
     */
    @JsonProperty("btnSogojigyoHokenshaJoho")
    public Button getBtnSogojigyoHokenshaJoho() {
        return btnSogojigyoHokenshaJoho;
    }

    /*
     * setbtnSogojigyoHokenshaJoho
     * @param btnSogojigyoHokenshaJoho btnSogojigyoHokenshaJoho
     */
    @JsonProperty("btnSogojigyoHokenshaJoho")
    public void setBtnSogojigyoHokenshaJoho(Button btnSogojigyoHokenshaJoho) {
        this.btnSogojigyoHokenshaJoho = btnSogojigyoHokenshaJoho;
    }

    /*
     * getbtnKouhiFutansya
     * @return btnKouhiFutansya
     */
    @JsonProperty("btnKouhiFutansya")
    public Button getBtnKouhiFutansya() {
        return btnKouhiFutansya;
    }

    /*
     * setbtnKouhiFutansya
     * @param btnKouhiFutansya btnKouhiFutansya
     */
    @JsonProperty("btnKouhiFutansya")
    public void setBtnKouhiFutansya(Button btnKouhiFutansya) {
        this.btnKouhiFutansya = btnKouhiFutansya;
    }

    /*
     * getbtnSougouKouhiFutansya
     * @return btnSougouKouhiFutansya
     */
    @JsonProperty("btnSougouKouhiFutansya")
    public Button getBtnSougouKouhiFutansya() {
        return btnSougouKouhiFutansya;
    }

    /*
     * setbtnSougouKouhiFutansya
     * @param btnSougouKouhiFutansya btnSougouKouhiFutansya
     */
    @JsonProperty("btnSougouKouhiFutansya")
    public void setBtnSougouKouhiFutansya(Button btnSougouKouhiFutansya) {
        this.btnSougouKouhiFutansya = btnSougouKouhiFutansya;
    }

    /*
     * getline1
     * @return line1
     */
    @JsonProperty("line1")
    public HorizontalLine getLine1() {
        return line1;
    }

    /*
     * setline1
     * @param line1 line1
     */
    @JsonProperty("line1")
    public void setLine1(HorizontalLine line1) {
        this.line1 = line1;
    }

    /*
     * gettxtKetteiHokenshaSakuseiYMD
     * @return txtKetteiHokenshaSakuseiYMD
     */
    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    public TextBoxDate getTxtKetteiHokenshaSakuseiYMD() {
        return txtKetteiHokenshaSakuseiYMD;
    }

    /*
     * settxtKetteiHokenshaSakuseiYMD
     * @param txtKetteiHokenshaSakuseiYMD txtKetteiHokenshaSakuseiYMD
     */
    @JsonProperty("txtKetteiHokenshaSakuseiYMD")
    public void setTxtKetteiHokenshaSakuseiYMD(TextBoxDate txtKetteiHokenshaSakuseiYMD) {
        this.txtKetteiHokenshaSakuseiYMD = txtKetteiHokenshaSakuseiYMD;
    }

    /*
     * gettxtSinsaiinkai
     * @return txtSinsaiinkai
     */
    @JsonProperty("txtSinsaiinkai")
    public TextBox getTxtSinsaiinkai() {
        return txtSinsaiinkai;
    }

    /*
     * settxtSinsaiinkai
     * @param txtSinsaiinkai txtSinsaiinkai
     */
    @JsonProperty("txtSinsaiinkai")
    public void setTxtSinsaiinkai(TextBox txtSinsaiinkai) {
        this.txtSinsaiinkai = txtSinsaiinkai;
    }

    /*
     * getDDLRireki
     * @return DDLRireki
     */
    @JsonProperty("DDLRireki")
    public DropDownList getDDLRireki() {
        return DDLRireki;
    }

    /*
     * setDDLRireki
     * @param DDLRireki DDLRireki
     */
    @JsonProperty("DDLRireki")
    public void setDDLRireki(DropDownList DDLRireki) {
        this.DDLRireki = DDLRireki;
    }

    /*
     * getKetteiHokenshaShukei
     * @return KetteiHokenshaShukei
     */
    @JsonProperty("KetteiHokenshaShukei")
    public KetteiHokenshaShukeiDiv getKetteiHokenshaShukei() {
        return KetteiHokenshaShukei;
    }

    /*
     * setKetteiHokenshaShukei
     * @param KetteiHokenshaShukei KetteiHokenshaShukei
     */
    @JsonProperty("KetteiHokenshaShukei")
    public void setKetteiHokenshaShukei(KetteiHokenshaShukeiDiv KetteiHokenshaShukei) {
        this.KetteiHokenshaShukei = KetteiHokenshaShukei;
    }

    /*
     * getdgKetteiHokenshaDetail
     * @return dgKetteiHokenshaDetail
     */
    @JsonProperty("dgKetteiHokenshaDetail")
    public DataGrid<dgKetteiHokenshaDetail_Row> getDgKetteiHokenshaDetail() {
        return dgKetteiHokenshaDetail;
    }

    /*
     * setdgKetteiHokenshaDetail
     * @param dgKetteiHokenshaDetail dgKetteiHokenshaDetail
     */
    @JsonProperty("dgKetteiHokenshaDetail")
    public void setDgKetteiHokenshaDetail(DataGrid<dgKetteiHokenshaDetail_Row> dgKetteiHokenshaDetail) {
        this.dgKetteiHokenshaDetail = dgKetteiHokenshaDetail;
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
    public Space getSpaceKuhaku1() {
        return this.getKetteiHokenshaShukei().getSpaceKuhaku1();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKensu() {
        return this.getKetteiHokenshaShukei().getLblKetteihokenshaKensu();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaTanisuHiyogaku() {
        return this.getKetteiHokenshaShukei().getLblKetteihokenshaTanisuHiyogaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaHokenshaFutangaku() {
        return this.getKetteiHokenshaShukei().getLblKetteihokenshaHokenshaFutangaku();
    }

    @JsonIgnore
    public Space getSpaceKuhaku2() {
        return this.getKetteiHokenshaShukei().getSpaceKuhaku2();
    }

    @JsonIgnore
    public Label getLblSeikyuTani() {
        return this.getKetteiHokenshaShukei().getLblSeikyuTani();
    }

    @JsonIgnore
    public Space getSpaceKuhaku4() {
        return this.getKetteiHokenshaShukei().getSpaceKuhaku4();
    }

    @JsonIgnore
    public Space getSpaceKuhaku5() {
        return this.getKetteiHokenshaShukei().getSpaceKuhaku5();
    }

    @JsonIgnore
    public Label getLblKeteiTani() {
        return this.getKetteiHokenshaShukei().getLblKeteiTani();
    }

    @JsonIgnore
    public Space getSpaceKuhaku6() {
        return this.getKetteiHokenshaShukei().getSpaceKuhaku6();
    }

    @JsonIgnore
    public Space getSpaceKuhaku8() {
        return this.getKetteiHokenshaShukei().getSpaceKuhaku8();
    }

    @JsonIgnore
    public Label getLblTyoseiTani() {
        return this.getKetteiHokenshaShukei().getLblTyoseiTani();
    }

    @JsonIgnore
    public Space getSpaceKuhaku7() {
        return this.getKetteiHokenshaShukei().getSpaceKuhaku7();
    }

    @JsonIgnore
    public Label getLblSeikyuFutangaku() {
        return this.getKetteiHokenshaShukei().getLblSeikyuFutangaku();
    }

    @JsonIgnore
    public Label getLblKeteiFutangaku() {
        return this.getKetteiHokenshaShukei().getLblKeteiFutangaku();
    }

    @JsonIgnore
    public Label getLblTyouseiFutangaku() {
        return this.getKetteiHokenshaShukei().getLblTyouseiFutangaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKaigokyuhuhi() {
        return this.getKetteiHokenshaShukei().getLblKetteihokenshaKaigokyuhuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSeikyuKensu() {
        return this.getKetteiHokenshaShukei().getTxtKaigoSeikyuKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoKeiteKensu() {
        return this.getKetteiHokenshaShukei().getTxtKaigoKeiteKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoYouseiKensu() {
        return this.getKetteiHokenshaShukei().getTxtKaigoYouseiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSeikyuTani() {
        return this.getKetteiHokenshaShukei().getTxtKaigoSeikyuTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoKeteiTani() {
        return this.getKetteiHokenshaShukei().getTxtKaigoKeteiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoTyoseiTani() {
        return this.getKetteiHokenshaShukei().getTxtKaigoTyoseiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoSeikyuFutangaku() {
        return this.getKetteiHokenshaShukei().getTxtKaigoSeikyuFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoKeteiFutangaku() {
        return this.getKetteiHokenshaShukei().getTxtKaigoKeteiFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKaigoTyoseiFutangaku() {
        return this.getKetteiHokenshaShukei().getTxtKaigoTyoseiFutangaku();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKogakuServiceHi() {
        return this.getKetteiHokenshaShukei().getLblKetteihokenshaKogakuServiceHi();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSeikyuKensu() {
        return this.getKetteiHokenshaShukei().getTxtKougakuSeikyuKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuKeiteKensu() {
        return this.getKetteiHokenshaShukei().getTxtKougakuKeiteKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuYouseiKensu() {
        return this.getKetteiHokenshaShukei().getTxtKougakuYouseiKensu();
    }

    @JsonIgnore
    public TextBoxNum getTxtkougakuSeikyuTani() {
        return this.getKetteiHokenshaShukei().getTxtkougakuSeikyuTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuKeteiTani() {
        return this.getKetteiHokenshaShukei().getTxtKougakuKeteiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuTyoseiTani() {
        return this.getKetteiHokenshaShukei().getTxtKougakuTyoseiTani();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuSeikyuFutangaku() {
        return this.getKetteiHokenshaShukei().getTxtKougakuSeikyuFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuKeteiFutangaku() {
        return this.getKetteiHokenshaShukei().getTxtKougakuKeteiFutangaku();
    }

    @JsonIgnore
    public TextBoxNum getTxtKougakuTyoseiFutangaku() {
        return this.getKetteiHokenshaShukei().getTxtKougakuTyoseiFutangaku();
    }

    // </editor-fold>
}
