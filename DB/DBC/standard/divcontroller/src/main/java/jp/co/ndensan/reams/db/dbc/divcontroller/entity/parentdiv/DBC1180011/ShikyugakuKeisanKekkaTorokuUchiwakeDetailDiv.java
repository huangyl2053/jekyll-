package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * ShikyugakuKeisanKekkaTorokuUchiwakeDetail のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class ShikyugakuKeisanKekkaTorokuUchiwakeDetailDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ddlHokenSeido")
    private DropDownList ddlHokenSeido;
    @JsonProperty("txtShoKisaiHokenshaNo")
    private TextBox txtShoKisaiHokenshaNo;
    @JsonProperty("txtHokenshaMei")
    private TextBox txtHokenshaMei;
    @JsonProperty("lin3")
    private HorizontalLine lin3;
    @JsonProperty("txtKokuhoHihokenshaShoKigo")
    private TextBox txtKokuhoHihokenshaShoKigo;
    @JsonProperty("txtTaishoshaShimei")
    private TextBox txtTaishoshaShimei;
    @JsonProperty("txtHiHokenshaShoNo")
    private TextBox txtHiHokenshaShoNo;
    @JsonProperty("txtJikoFutanSeiriNom")
    private TextBox txtJikoFutanSeiriNom;
    @JsonProperty("lin4")
    private HorizontalLine lin4;
    @JsonProperty("txtOver70Futangaku")
    private TextBoxNum txtOver70Futangaku;
    @JsonProperty("txtOver70AmbunRitsu")
    private TextBox txtOver70AmbunRitsu;
    @JsonProperty("txtOver70Shikyugaku")
    private TextBoxNum txtOver70Shikyugaku;
    @JsonProperty("txtUnder70Futangaku")
    private TextBoxNum txtUnder70Futangaku;
    @JsonProperty("txtFutangaku")
    private TextBoxNum txtFutangaku;
    @JsonProperty("txtAmbunRitsu")
    private TextBox txtAmbunRitsu;
    @JsonProperty("txtUnder70Shikyugaku")
    private TextBoxNum txtUnder70Shikyugaku;
    @JsonProperty("txtShikyuGaku")
    private TextBoxNum txtShikyuGaku;
    @JsonProperty("lin5")
    private HorizontalLine lin5;
    @JsonProperty("txtOver70Biko")
    private TextBoxNum txtOver70Biko;
    @JsonProperty("txtUnder70Biko")
    private TextBoxNum txtUnder70Biko;
    @JsonProperty("lin7")
    private HorizontalLine lin7;
    @JsonProperty("btnUchiwakeKakutei")
    private Button btnUchiwakeKakutei;
    @JsonProperty("btnUchiwakeIchiramModoru")
    private Button btnUchiwakeIchiramModoru;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getddlHokenSeido
     * @return ddlHokenSeido
     */
    @JsonProperty("ddlHokenSeido")
    public DropDownList getDdlHokenSeido() {
        return ddlHokenSeido;
    }

    /*
     * setddlHokenSeido
     * @param ddlHokenSeido ddlHokenSeido
     */
    @JsonProperty("ddlHokenSeido")
    public void setDdlHokenSeido(DropDownList ddlHokenSeido) {
        this.ddlHokenSeido = ddlHokenSeido;
    }

    /*
     * gettxtShoKisaiHokenshaNo
     * @return txtShoKisaiHokenshaNo
     */
    @JsonProperty("txtShoKisaiHokenshaNo")
    public TextBox getTxtShoKisaiHokenshaNo() {
        return txtShoKisaiHokenshaNo;
    }

    /*
     * settxtShoKisaiHokenshaNo
     * @param txtShoKisaiHokenshaNo txtShoKisaiHokenshaNo
     */
    @JsonProperty("txtShoKisaiHokenshaNo")
    public void setTxtShoKisaiHokenshaNo(TextBox txtShoKisaiHokenshaNo) {
        this.txtShoKisaiHokenshaNo = txtShoKisaiHokenshaNo;
    }

    /*
     * gettxtHokenshaMei
     * @return txtHokenshaMei
     */
    @JsonProperty("txtHokenshaMei")
    public TextBox getTxtHokenshaMei() {
        return txtHokenshaMei;
    }

    /*
     * settxtHokenshaMei
     * @param txtHokenshaMei txtHokenshaMei
     */
    @JsonProperty("txtHokenshaMei")
    public void setTxtHokenshaMei(TextBox txtHokenshaMei) {
        this.txtHokenshaMei = txtHokenshaMei;
    }

    /*
     * getlin3
     * @return lin3
     */
    @JsonProperty("lin3")
    public HorizontalLine getLin3() {
        return lin3;
    }

    /*
     * setlin3
     * @param lin3 lin3
     */
    @JsonProperty("lin3")
    public void setLin3(HorizontalLine lin3) {
        this.lin3 = lin3;
    }

    /*
     * gettxtKokuhoHihokenshaShoKigo
     * @return txtKokuhoHihokenshaShoKigo
     */
    @JsonProperty("txtKokuhoHihokenshaShoKigo")
    public TextBox getTxtKokuhoHihokenshaShoKigo() {
        return txtKokuhoHihokenshaShoKigo;
    }

    /*
     * settxtKokuhoHihokenshaShoKigo
     * @param txtKokuhoHihokenshaShoKigo txtKokuhoHihokenshaShoKigo
     */
    @JsonProperty("txtKokuhoHihokenshaShoKigo")
    public void setTxtKokuhoHihokenshaShoKigo(TextBox txtKokuhoHihokenshaShoKigo) {
        this.txtKokuhoHihokenshaShoKigo = txtKokuhoHihokenshaShoKigo;
    }

    /*
     * gettxtTaishoshaShimei
     * @return txtTaishoshaShimei
     */
    @JsonProperty("txtTaishoshaShimei")
    public TextBox getTxtTaishoshaShimei() {
        return txtTaishoshaShimei;
    }

    /*
     * settxtTaishoshaShimei
     * @param txtTaishoshaShimei txtTaishoshaShimei
     */
    @JsonProperty("txtTaishoshaShimei")
    public void setTxtTaishoshaShimei(TextBox txtTaishoshaShimei) {
        this.txtTaishoshaShimei = txtTaishoshaShimei;
    }

    /*
     * gettxtHiHokenshaShoNo
     * @return txtHiHokenshaShoNo
     */
    @JsonProperty("txtHiHokenshaShoNo")
    public TextBox getTxtHiHokenshaShoNo() {
        return txtHiHokenshaShoNo;
    }

    /*
     * settxtHiHokenshaShoNo
     * @param txtHiHokenshaShoNo txtHiHokenshaShoNo
     */
    @JsonProperty("txtHiHokenshaShoNo")
    public void setTxtHiHokenshaShoNo(TextBox txtHiHokenshaShoNo) {
        this.txtHiHokenshaShoNo = txtHiHokenshaShoNo;
    }

    /*
     * gettxtJikoFutanSeiriNom
     * @return txtJikoFutanSeiriNom
     */
    @JsonProperty("txtJikoFutanSeiriNom")
    public TextBox getTxtJikoFutanSeiriNom() {
        return txtJikoFutanSeiriNom;
    }

    /*
     * settxtJikoFutanSeiriNom
     * @param txtJikoFutanSeiriNom txtJikoFutanSeiriNom
     */
    @JsonProperty("txtJikoFutanSeiriNom")
    public void setTxtJikoFutanSeiriNom(TextBox txtJikoFutanSeiriNom) {
        this.txtJikoFutanSeiriNom = txtJikoFutanSeiriNom;
    }

    /*
     * getlin4
     * @return lin4
     */
    @JsonProperty("lin4")
    public HorizontalLine getLin4() {
        return lin4;
    }

    /*
     * setlin4
     * @param lin4 lin4
     */
    @JsonProperty("lin4")
    public void setLin4(HorizontalLine lin4) {
        this.lin4 = lin4;
    }

    /*
     * gettxtOver70Futangaku
     * @return txtOver70Futangaku
     */
    @JsonProperty("txtOver70Futangaku")
    public TextBoxNum getTxtOver70Futangaku() {
        return txtOver70Futangaku;
    }

    /*
     * settxtOver70Futangaku
     * @param txtOver70Futangaku txtOver70Futangaku
     */
    @JsonProperty("txtOver70Futangaku")
    public void setTxtOver70Futangaku(TextBoxNum txtOver70Futangaku) {
        this.txtOver70Futangaku = txtOver70Futangaku;
    }

    /*
     * gettxtOver70AmbunRitsu
     * @return txtOver70AmbunRitsu
     */
    @JsonProperty("txtOver70AmbunRitsu")
    public TextBox getTxtOver70AmbunRitsu() {
        return txtOver70AmbunRitsu;
    }

    /*
     * settxtOver70AmbunRitsu
     * @param txtOver70AmbunRitsu txtOver70AmbunRitsu
     */
    @JsonProperty("txtOver70AmbunRitsu")
    public void setTxtOver70AmbunRitsu(TextBox txtOver70AmbunRitsu) {
        this.txtOver70AmbunRitsu = txtOver70AmbunRitsu;
    }

    /*
     * gettxtOver70Shikyugaku
     * @return txtOver70Shikyugaku
     */
    @JsonProperty("txtOver70Shikyugaku")
    public TextBoxNum getTxtOver70Shikyugaku() {
        return txtOver70Shikyugaku;
    }

    /*
     * settxtOver70Shikyugaku
     * @param txtOver70Shikyugaku txtOver70Shikyugaku
     */
    @JsonProperty("txtOver70Shikyugaku")
    public void setTxtOver70Shikyugaku(TextBoxNum txtOver70Shikyugaku) {
        this.txtOver70Shikyugaku = txtOver70Shikyugaku;
    }

    /*
     * gettxtUnder70Futangaku
     * @return txtUnder70Futangaku
     */
    @JsonProperty("txtUnder70Futangaku")
    public TextBoxNum getTxtUnder70Futangaku() {
        return txtUnder70Futangaku;
    }

    /*
     * settxtUnder70Futangaku
     * @param txtUnder70Futangaku txtUnder70Futangaku
     */
    @JsonProperty("txtUnder70Futangaku")
    public void setTxtUnder70Futangaku(TextBoxNum txtUnder70Futangaku) {
        this.txtUnder70Futangaku = txtUnder70Futangaku;
    }

    /*
     * gettxtFutangaku
     * @return txtFutangaku
     */
    @JsonProperty("txtFutangaku")
    public TextBoxNum getTxtFutangaku() {
        return txtFutangaku;
    }

    /*
     * settxtFutangaku
     * @param txtFutangaku txtFutangaku
     */
    @JsonProperty("txtFutangaku")
    public void setTxtFutangaku(TextBoxNum txtFutangaku) {
        this.txtFutangaku = txtFutangaku;
    }

    /*
     * gettxtAmbunRitsu
     * @return txtAmbunRitsu
     */
    @JsonProperty("txtAmbunRitsu")
    public TextBox getTxtAmbunRitsu() {
        return txtAmbunRitsu;
    }

    /*
     * settxtAmbunRitsu
     * @param txtAmbunRitsu txtAmbunRitsu
     */
    @JsonProperty("txtAmbunRitsu")
    public void setTxtAmbunRitsu(TextBox txtAmbunRitsu) {
        this.txtAmbunRitsu = txtAmbunRitsu;
    }

    /*
     * gettxtUnder70Shikyugaku
     * @return txtUnder70Shikyugaku
     */
    @JsonProperty("txtUnder70Shikyugaku")
    public TextBoxNum getTxtUnder70Shikyugaku() {
        return txtUnder70Shikyugaku;
    }

    /*
     * settxtUnder70Shikyugaku
     * @param txtUnder70Shikyugaku txtUnder70Shikyugaku
     */
    @JsonProperty("txtUnder70Shikyugaku")
    public void setTxtUnder70Shikyugaku(TextBoxNum txtUnder70Shikyugaku) {
        this.txtUnder70Shikyugaku = txtUnder70Shikyugaku;
    }

    /*
     * gettxtShikyuGaku
     * @return txtShikyuGaku
     */
    @JsonProperty("txtShikyuGaku")
    public TextBoxNum getTxtShikyuGaku() {
        return txtShikyuGaku;
    }

    /*
     * settxtShikyuGaku
     * @param txtShikyuGaku txtShikyuGaku
     */
    @JsonProperty("txtShikyuGaku")
    public void setTxtShikyuGaku(TextBoxNum txtShikyuGaku) {
        this.txtShikyuGaku = txtShikyuGaku;
    }

    /*
     * getlin5
     * @return lin5
     */
    @JsonProperty("lin5")
    public HorizontalLine getLin5() {
        return lin5;
    }

    /*
     * setlin5
     * @param lin5 lin5
     */
    @JsonProperty("lin5")
    public void setLin5(HorizontalLine lin5) {
        this.lin5 = lin5;
    }

    /*
     * gettxtOver70Biko
     * @return txtOver70Biko
     */
    @JsonProperty("txtOver70Biko")
    public TextBoxNum getTxtOver70Biko() {
        return txtOver70Biko;
    }

    /*
     * settxtOver70Biko
     * @param txtOver70Biko txtOver70Biko
     */
    @JsonProperty("txtOver70Biko")
    public void setTxtOver70Biko(TextBoxNum txtOver70Biko) {
        this.txtOver70Biko = txtOver70Biko;
    }

    /*
     * gettxtUnder70Biko
     * @return txtUnder70Biko
     */
    @JsonProperty("txtUnder70Biko")
    public TextBoxNum getTxtUnder70Biko() {
        return txtUnder70Biko;
    }

    /*
     * settxtUnder70Biko
     * @param txtUnder70Biko txtUnder70Biko
     */
    @JsonProperty("txtUnder70Biko")
    public void setTxtUnder70Biko(TextBoxNum txtUnder70Biko) {
        this.txtUnder70Biko = txtUnder70Biko;
    }

    /*
     * getlin7
     * @return lin7
     */
    @JsonProperty("lin7")
    public HorizontalLine getLin7() {
        return lin7;
    }

    /*
     * setlin7
     * @param lin7 lin7
     */
    @JsonProperty("lin7")
    public void setLin7(HorizontalLine lin7) {
        this.lin7 = lin7;
    }

    /*
     * getbtnUchiwakeKakutei
     * @return btnUchiwakeKakutei
     */
    @JsonProperty("btnUchiwakeKakutei")
    public Button getBtnUchiwakeKakutei() {
        return btnUchiwakeKakutei;
    }

    /*
     * setbtnUchiwakeKakutei
     * @param btnUchiwakeKakutei btnUchiwakeKakutei
     */
    @JsonProperty("btnUchiwakeKakutei")
    public void setBtnUchiwakeKakutei(Button btnUchiwakeKakutei) {
        this.btnUchiwakeKakutei = btnUchiwakeKakutei;
    }

    /*
     * getbtnUchiwakeIchiramModoru
     * @return btnUchiwakeIchiramModoru
     */
    @JsonProperty("btnUchiwakeIchiramModoru")
    public Button getBtnUchiwakeIchiramModoru() {
        return btnUchiwakeIchiramModoru;
    }

    /*
     * setbtnUchiwakeIchiramModoru
     * @param btnUchiwakeIchiramModoru btnUchiwakeIchiramModoru
     */
    @JsonProperty("btnUchiwakeIchiramModoru")
    public void setBtnUchiwakeIchiramModoru(Button btnUchiwakeIchiramModoru) {
        this.btnUchiwakeIchiramModoru = btnUchiwakeIchiramModoru;
    }

    // </editor-fold>
}
