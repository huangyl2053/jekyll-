package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC0071011;
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
    @JsonProperty("btnSogojigyohiKeikasochiHokenshaJoho")
    private Button btnSogojigyohiKeikasochiHokenshaJoho;
    @JsonProperty("btnSogojigyohiHokenshaJoho")
    private Button btnSogojigyohiHokenshaJoho;
    @JsonProperty("btnKohoFutanshaJoho")
    private Button btnKohoFutanshaJoho;
    @JsonProperty("btnSogojigyohiKohiFutanshaJoho")
    private Button btnSogojigyohiKohiFutanshaJoho;
    @JsonProperty("line1")
    private HorizontalLine line1;
    @JsonProperty("KetteiHokenshaShukei")
    private KetteiHokenshaShukeiDiv KetteiHokenshaShukei;
    @JsonProperty("lblHokenshaHosoku")
    private Label lblHokenshaHosoku;
    @JsonProperty("dgKagoKetteiDetail")
    private DataGrid<dgKagoKetteiDetail_Row> dgKagoKetteiDetail;

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
     * getbtnSogojigyohiKeikasochiHokenshaJoho
     * @return btnSogojigyohiKeikasochiHokenshaJoho
     */
    @JsonProperty("btnSogojigyohiKeikasochiHokenshaJoho")
    public Button getBtnSogojigyohiKeikasochiHokenshaJoho() {
        return btnSogojigyohiKeikasochiHokenshaJoho;
    }

    /*
     * setbtnSogojigyohiKeikasochiHokenshaJoho
     * @param btnSogojigyohiKeikasochiHokenshaJoho btnSogojigyohiKeikasochiHokenshaJoho
     */
    @JsonProperty("btnSogojigyohiKeikasochiHokenshaJoho")
    public void setBtnSogojigyohiKeikasochiHokenshaJoho(Button btnSogojigyohiKeikasochiHokenshaJoho) {
        this.btnSogojigyohiKeikasochiHokenshaJoho = btnSogojigyohiKeikasochiHokenshaJoho;
    }

    /*
     * getbtnSogojigyohiHokenshaJoho
     * @return btnSogojigyohiHokenshaJoho
     */
    @JsonProperty("btnSogojigyohiHokenshaJoho")
    public Button getBtnSogojigyohiHokenshaJoho() {
        return btnSogojigyohiHokenshaJoho;
    }

    /*
     * setbtnSogojigyohiHokenshaJoho
     * @param btnSogojigyohiHokenshaJoho btnSogojigyohiHokenshaJoho
     */
    @JsonProperty("btnSogojigyohiHokenshaJoho")
    public void setBtnSogojigyohiHokenshaJoho(Button btnSogojigyohiHokenshaJoho) {
        this.btnSogojigyohiHokenshaJoho = btnSogojigyohiHokenshaJoho;
    }

    /*
     * getbtnKohoFutanshaJoho
     * @return btnKohoFutanshaJoho
     */
    @JsonProperty("btnKohoFutanshaJoho")
    public Button getBtnKohoFutanshaJoho() {
        return btnKohoFutanshaJoho;
    }

    /*
     * setbtnKohoFutanshaJoho
     * @param btnKohoFutanshaJoho btnKohoFutanshaJoho
     */
    @JsonProperty("btnKohoFutanshaJoho")
    public void setBtnKohoFutanshaJoho(Button btnKohoFutanshaJoho) {
        this.btnKohoFutanshaJoho = btnKohoFutanshaJoho;
    }

    /*
     * getbtnSogojigyohiKohiFutanshaJoho
     * @return btnSogojigyohiKohiFutanshaJoho
     */
    @JsonProperty("btnSogojigyohiKohiFutanshaJoho")
    public Button getBtnSogojigyohiKohiFutanshaJoho() {
        return btnSogojigyohiKohiFutanshaJoho;
    }

    /*
     * setbtnSogojigyohiKohiFutanshaJoho
     * @param btnSogojigyohiKohiFutanshaJoho btnSogojigyohiKohiFutanshaJoho
     */
    @JsonProperty("btnSogojigyohiKohiFutanshaJoho")
    public void setBtnSogojigyohiKohiFutanshaJoho(Button btnSogojigyohiKohiFutanshaJoho) {
        this.btnSogojigyohiKohiFutanshaJoho = btnSogojigyohiKohiFutanshaJoho;
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
     * getlblHokenshaHosoku
     * @return lblHokenshaHosoku
     */
    @JsonProperty("lblHokenshaHosoku")
    public Label getLblHokenshaHosoku() {
        return lblHokenshaHosoku;
    }

    /*
     * setlblHokenshaHosoku
     * @param lblHokenshaHosoku lblHokenshaHosoku
     */
    @JsonProperty("lblHokenshaHosoku")
    public void setLblHokenshaHosoku(Label lblHokenshaHosoku) {
        this.lblHokenshaHosoku = lblHokenshaHosoku;
    }

    /*
     * getdgKagoKetteiDetail
     * @return dgKagoKetteiDetail
     */
    @JsonProperty("dgKagoKetteiDetail")
    public DataGrid<dgKagoKetteiDetail_Row> getDgKagoKetteiDetail() {
        return dgKagoKetteiDetail;
    }

    /*
     * setdgKagoKetteiDetail
     * @param dgKagoKetteiDetail dgKagoKetteiDetail
     */
    @JsonProperty("dgKagoKetteiDetail")
    public void setDgKagoKetteiDetail(DataGrid<dgKagoKetteiDetail_Row> dgKagoKetteiDetail) {
        this.dgKagoKetteiDetail = dgKagoKetteiDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtKetteiHokenshaSakuseiYMD() {
        return this.getKetteiHokenshaShukei().getTxtKetteiHokenshaSakuseiYMD();
    }

    @JsonIgnore
    public DropDownList getDdlRirekiNo1() {
        return this.getKetteiHokenshaShukei().getDdlRirekiNo1();
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
    public Label getLblKetteihokenshaKaigokyuhuhi() {
        return this.getKetteiHokenshaShukei().getLblKetteihokenshaKaigokyuhuhi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell11() {
        return this.getKetteiHokenshaShukei().getTxtHokenshaCell11();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell12() {
        return this.getKetteiHokenshaShukei().getTxtHokenshaCell12();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell13() {
        return this.getKetteiHokenshaShukei().getTxtHokenshaCell13();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaKogakuServiceHi() {
        return this.getKetteiHokenshaShukei().getLblKetteihokenshaKogakuServiceHi();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell21() {
        return this.getKetteiHokenshaShukei().getTxtHokenshaCell21();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell22() {
        return this.getKetteiHokenshaShukei().getTxtHokenshaCell22();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell23() {
        return this.getKetteiHokenshaShukei().getTxtHokenshaCell23();
    }

    @JsonIgnore
    public Label getLblKetteihokenshaTokuteiNyushoshaKaigo() {
        return this.getKetteiHokenshaShukei().getLblKetteihokenshaTokuteiNyushoshaKaigo();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell31() {
        return this.getKetteiHokenshaShukei().getTxtHokenshaCell31();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell32() {
        return this.getKetteiHokenshaShukei().getTxtHokenshaCell32();
    }

    @JsonIgnore
    public TextBoxNum getTxtHokenshaCell33() {
        return this.getKetteiHokenshaShukei().getTxtHokenshaCell33();
    }

    // </editor-fold>
}
