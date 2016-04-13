package jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.TainoInfo;
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
 * TainoInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class TainoInfoDiv extends Panel implements ITainoInfoDiv {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-01-15_09-59-03">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtHanteiKijunYMD")
    private TextBoxFlexibleDate txtHanteiKijunYMD;
    @JsonProperty("btnKensaku")
    private Button btnKensaku;
    @JsonProperty("btnGengakuJoho")
    private Button btnGengakuJoho;
    @JsonProperty("txtSaikoNokigen")
    private TextBoxFlexibleDate txtSaikoNokigen;
    @JsonProperty("txtKeikaNen")
    private TextBox txtKeikaNen;
    @JsonProperty("txtKeikaTsuki")
    private TextBox txtKeikaTsuki;
    @JsonProperty("linTaino1")
    private HorizontalLine linTaino1;
    @JsonProperty("txtHokenryoNendo1")
    private TextBox txtHokenryoNendo1;
    @JsonProperty("txtHokenryoNendo2")
    private TextBox txtHokenryoNendo2;
    @JsonProperty("txtHokenryoNendo3")
    private TextBox txtHokenryoNendo3;
    @JsonProperty("dgTainoJokyo1")
    private DataGrid<dgTainoJokyo1_Row> dgTainoJokyo1;
    @JsonProperty("dgTainoJokyo2")
    private DataGrid<dgTainoJokyo2_Row> dgTainoJokyo2;
    @JsonProperty("dgTainoJokyo3")
    private DataGrid<dgTainoJokyo3_Row> dgTainoJokyo3;
    @JsonProperty("txtSonotaHokenryo")
    private TextBoxNum txtSonotaHokenryo;
    @JsonProperty("txtSonotatainoGaku")
    private TextBoxNum txtSonotatainoGaku;
    @JsonProperty("TainoSetsumei")
    private TainoSetsumeiDiv TainoSetsumei;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtHanteiKijunYMD
     * @return txtHanteiKijunYMD
     */
    @JsonProperty("txtHanteiKijunYMD")
    public TextBoxFlexibleDate getTxtHanteiKijunYMD() {
        return txtHanteiKijunYMD;
    }

    /*
     * settxtHanteiKijunYMD
     * @param txtHanteiKijunYMD txtHanteiKijunYMD
     */
    @JsonProperty("txtHanteiKijunYMD")
    public void setTxtHanteiKijunYMD(TextBoxFlexibleDate txtHanteiKijunYMD) {
        this.txtHanteiKijunYMD = txtHanteiKijunYMD;
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
     * getbtnGengakuJoho
     * @return btnGengakuJoho
     */
    @JsonProperty("btnGengakuJoho")
    public Button getBtnGengakuJoho() {
        return btnGengakuJoho;
    }

    /*
     * setbtnGengakuJoho
     * @param btnGengakuJoho btnGengakuJoho
     */
    @JsonProperty("btnGengakuJoho")
    public void setBtnGengakuJoho(Button btnGengakuJoho) {
        this.btnGengakuJoho = btnGengakuJoho;
    }

    /*
     * gettxtSaikoNokigen
     * @return txtSaikoNokigen
     */
    @JsonProperty("txtSaikoNokigen")
    public TextBoxFlexibleDate getTxtSaikoNokigen() {
        return txtSaikoNokigen;
    }

    /*
     * settxtSaikoNokigen
     * @param txtSaikoNokigen txtSaikoNokigen
     */
    @JsonProperty("txtSaikoNokigen")
    public void setTxtSaikoNokigen(TextBoxFlexibleDate txtSaikoNokigen) {
        this.txtSaikoNokigen = txtSaikoNokigen;
    }

    /*
     * gettxtKeikaNen
     * @return txtKeikaNen
     */
    @JsonProperty("txtKeikaNen")
    public TextBox getTxtKeikaNen() {
        return txtKeikaNen;
    }

    /*
     * settxtKeikaNen
     * @param txtKeikaNen txtKeikaNen
     */
    @JsonProperty("txtKeikaNen")
    public void setTxtKeikaNen(TextBox txtKeikaNen) {
        this.txtKeikaNen = txtKeikaNen;
    }

    /*
     * gettxtKeikaTsuki
     * @return txtKeikaTsuki
     */
    @JsonProperty("txtKeikaTsuki")
    public TextBox getTxtKeikaTsuki() {
        return txtKeikaTsuki;
    }

    /*
     * settxtKeikaTsuki
     * @param txtKeikaTsuki txtKeikaTsuki
     */
    @JsonProperty("txtKeikaTsuki")
    public void setTxtKeikaTsuki(TextBox txtKeikaTsuki) {
        this.txtKeikaTsuki = txtKeikaTsuki;
    }

    /*
     * getlinTaino1
     * @return linTaino1
     */
    @JsonProperty("linTaino1")
    public HorizontalLine getLinTaino1() {
        return linTaino1;
    }

    /*
     * setlinTaino1
     * @param linTaino1 linTaino1
     */
    @JsonProperty("linTaino1")
    public void setLinTaino1(HorizontalLine linTaino1) {
        this.linTaino1 = linTaino1;
    }

    /*
     * gettxtHokenryoNendo1
     * @return txtHokenryoNendo1
     */
    @JsonProperty("txtHokenryoNendo1")
    public TextBox getTxtHokenryoNendo1() {
        return txtHokenryoNendo1;
    }

    /*
     * settxtHokenryoNendo1
     * @param txtHokenryoNendo1 txtHokenryoNendo1
     */
    @JsonProperty("txtHokenryoNendo1")
    public void setTxtHokenryoNendo1(TextBox txtHokenryoNendo1) {
        this.txtHokenryoNendo1 = txtHokenryoNendo1;
    }

    /*
     * gettxtHokenryoNendo2
     * @return txtHokenryoNendo2
     */
    @JsonProperty("txtHokenryoNendo2")
    public TextBox getTxtHokenryoNendo2() {
        return txtHokenryoNendo2;
    }

    /*
     * settxtHokenryoNendo2
     * @param txtHokenryoNendo2 txtHokenryoNendo2
     */
    @JsonProperty("txtHokenryoNendo2")
    public void setTxtHokenryoNendo2(TextBox txtHokenryoNendo2) {
        this.txtHokenryoNendo2 = txtHokenryoNendo2;
    }

    /*
     * gettxtHokenryoNendo3
     * @return txtHokenryoNendo3
     */
    @JsonProperty("txtHokenryoNendo3")
    public TextBox getTxtHokenryoNendo3() {
        return txtHokenryoNendo3;
    }

    /*
     * settxtHokenryoNendo3
     * @param txtHokenryoNendo3 txtHokenryoNendo3
     */
    @JsonProperty("txtHokenryoNendo3")
    public void setTxtHokenryoNendo3(TextBox txtHokenryoNendo3) {
        this.txtHokenryoNendo3 = txtHokenryoNendo3;
    }

    /*
     * getdgTainoJokyo1
     * @return dgTainoJokyo1
     */
    @JsonProperty("dgTainoJokyo1")
    public DataGrid<dgTainoJokyo1_Row> getDgTainoJokyo1() {
        return dgTainoJokyo1;
    }

    /*
     * setdgTainoJokyo1
     * @param dgTainoJokyo1 dgTainoJokyo1
     */
    @JsonProperty("dgTainoJokyo1")
    public void setDgTainoJokyo1(DataGrid<dgTainoJokyo1_Row> dgTainoJokyo1) {
        this.dgTainoJokyo1 = dgTainoJokyo1;
    }

    /*
     * getdgTainoJokyo2
     * @return dgTainoJokyo2
     */
    @JsonProperty("dgTainoJokyo2")
    public DataGrid<dgTainoJokyo2_Row> getDgTainoJokyo2() {
        return dgTainoJokyo2;
    }

    /*
     * setdgTainoJokyo2
     * @param dgTainoJokyo2 dgTainoJokyo2
     */
    @JsonProperty("dgTainoJokyo2")
    public void setDgTainoJokyo2(DataGrid<dgTainoJokyo2_Row> dgTainoJokyo2) {
        this.dgTainoJokyo2 = dgTainoJokyo2;
    }

    /*
     * getdgTainoJokyo3
     * @return dgTainoJokyo3
     */
    @JsonProperty("dgTainoJokyo3")
    public DataGrid<dgTainoJokyo3_Row> getDgTainoJokyo3() {
        return dgTainoJokyo3;
    }

    /*
     * setdgTainoJokyo3
     * @param dgTainoJokyo3 dgTainoJokyo3
     */
    @JsonProperty("dgTainoJokyo3")
    public void setDgTainoJokyo3(DataGrid<dgTainoJokyo3_Row> dgTainoJokyo3) {
        this.dgTainoJokyo3 = dgTainoJokyo3;
    }

    /*
     * gettxtSonotaHokenryo
     * @return txtSonotaHokenryo
     */
    @JsonProperty("txtSonotaHokenryo")
    public TextBoxNum getTxtSonotaHokenryo() {
        return txtSonotaHokenryo;
    }

    /*
     * settxtSonotaHokenryo
     * @param txtSonotaHokenryo txtSonotaHokenryo
     */
    @JsonProperty("txtSonotaHokenryo")
    public void setTxtSonotaHokenryo(TextBoxNum txtSonotaHokenryo) {
        this.txtSonotaHokenryo = txtSonotaHokenryo;
    }

    /*
     * gettxtSonotatainoGaku
     * @return txtSonotatainoGaku
     */
    @JsonProperty("txtSonotatainoGaku")
    public TextBoxNum getTxtSonotatainoGaku() {
        return txtSonotatainoGaku;
    }

    /*
     * settxtSonotatainoGaku
     * @param txtSonotatainoGaku txtSonotatainoGaku
     */
    @JsonProperty("txtSonotatainoGaku")
    public void setTxtSonotatainoGaku(TextBoxNum txtSonotatainoGaku) {
        this.txtSonotatainoGaku = txtSonotatainoGaku;
    }

    /*
     * getTainoSetsumei
     * @return TainoSetsumei
     */
    @JsonProperty("TainoSetsumei")
    public TainoSetsumeiDiv getTainoSetsumei() {
        return TainoSetsumei;
    }

    /*
     * setTainoSetsumei
     * @param TainoSetsumei TainoSetsumei
     */
    @JsonProperty("TainoSetsumei")
    public void setTainoSetsumei(TainoSetsumeiDiv TainoSetsumei) {
        this.TainoSetsumei = TainoSetsumei;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TainocolorKannoDiv getTainocolorKanno() {
        return this.getTainoSetsumei().getTainocolorKanno();
    }

    @JsonIgnore
    public Label getLblDummyWhite() {
        return this.getTainoSetsumei().getTainocolorKanno().getLblDummyWhite();
    }

    @JsonIgnore
    public TainocolorMinoDiv getTainocolorMino() {
        return this.getTainoSetsumei().getTainocolorMino();
    }

    @JsonIgnore
    public Label getLblDummyRed() {
        return this.getTainoSetsumei().getTainocolorMino().getLblDummyRed();
    }

    @JsonIgnore
    public Label getLblMassage1() {
        return this.getTainoSetsumei().getLblMassage1();
    }

    @JsonIgnore
    public Label getLblMassage2() {
        return this.getTainoSetsumei().getLblMassage2();
    }

    @JsonIgnore
    public TainocolorMitoraiDiv getTainocolorMitorai() {
        return this.getTainoSetsumei().getTainocolorMitorai();
    }

    @JsonIgnore
    public Label getLblDummyYellow() {
        return this.getTainoSetsumei().getTainocolorMitorai().getLblDummyYellow();
    }

    @JsonIgnore
    public TainocolorKanoDiv getTainocolorKano() {
        return this.getTainoSetsumei().getTainocolorKano();
    }

    @JsonIgnore
    public Label getLblDummyGreen() {
        return this.getTainoSetsumei().getTainocolorKano().getLblDummyGreen();
    }

    @JsonIgnore
    public Label getLblMassage3() {
        return this.getTainoSetsumei().getLblMassage3();
    }

    @JsonIgnore
    public Label getLblMassage4() {
        return this.getTainoSetsumei().getLblMassage4();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------

}
