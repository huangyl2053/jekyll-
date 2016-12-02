package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;

/**
 * tabShikyugakuKeisanKekkaTorokuUchiwake のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class tabShikyugakuKeisanKekkaTorokuUchiwakeDiv extends TabPanel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShikyugakuKeisanKekkaTorokuUchiwakeList")
    private ShikyugakuKeisanKekkaTorokuUchiwakeListDiv ShikyugakuKeisanKekkaTorokuUchiwakeList;
    @JsonProperty("ShikyugakuKeisanKekkaTorokuUchiwakeDetail")
    private ShikyugakuKeisanKekkaTorokuUchiwakeDetailDiv ShikyugakuKeisanKekkaTorokuUchiwakeDetail;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShikyugakuKeisanKekkaTorokuUchiwakeList
     * @return ShikyugakuKeisanKekkaTorokuUchiwakeList
     */
    @JsonProperty("ShikyugakuKeisanKekkaTorokuUchiwakeList")
    public ShikyugakuKeisanKekkaTorokuUchiwakeListDiv getShikyugakuKeisanKekkaTorokuUchiwakeList() {
        return ShikyugakuKeisanKekkaTorokuUchiwakeList;
    }

    /*
     * setShikyugakuKeisanKekkaTorokuUchiwakeList
     * @param ShikyugakuKeisanKekkaTorokuUchiwakeList ShikyugakuKeisanKekkaTorokuUchiwakeList
     */
    @JsonProperty("ShikyugakuKeisanKekkaTorokuUchiwakeList")
    public void setShikyugakuKeisanKekkaTorokuUchiwakeList(ShikyugakuKeisanKekkaTorokuUchiwakeListDiv ShikyugakuKeisanKekkaTorokuUchiwakeList) {
        this.ShikyugakuKeisanKekkaTorokuUchiwakeList = ShikyugakuKeisanKekkaTorokuUchiwakeList;
    }

    /*
     * getShikyugakuKeisanKekkaTorokuUchiwakeDetail
     * @return ShikyugakuKeisanKekkaTorokuUchiwakeDetail
     */
    @JsonProperty("ShikyugakuKeisanKekkaTorokuUchiwakeDetail")
    public ShikyugakuKeisanKekkaTorokuUchiwakeDetailDiv getShikyugakuKeisanKekkaTorokuUchiwakeDetail() {
        return ShikyugakuKeisanKekkaTorokuUchiwakeDetail;
    }

    /*
     * setShikyugakuKeisanKekkaTorokuUchiwakeDetail
     * @param ShikyugakuKeisanKekkaTorokuUchiwakeDetail ShikyugakuKeisanKekkaTorokuUchiwakeDetail
     */
    @JsonProperty("ShikyugakuKeisanKekkaTorokuUchiwakeDetail")
    public void setShikyugakuKeisanKekkaTorokuUchiwakeDetail(ShikyugakuKeisanKekkaTorokuUchiwakeDetailDiv ShikyugakuKeisanKekkaTorokuUchiwakeDetail) {
        this.ShikyugakuKeisanKekkaTorokuUchiwakeDetail = ShikyugakuKeisanKekkaTorokuUchiwakeDetail;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnUchiwakeAdd() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getBtnUchiwakeAdd();
    }

    @JsonIgnore
    public void  setBtnUchiwakeAdd(Button btnUchiwakeAdd) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeList().setBtnUchiwakeAdd(btnUchiwakeAdd);
    }

    @JsonIgnore
    public DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> getDgKogakuGassanShikyugakuKeisanKekkaMeisai() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getDgKogakuGassanShikyugakuKeisanKekkaMeisai();
    }

    @JsonIgnore
    public void  setDgKogakuGassanShikyugakuKeisanKekkaMeisai(DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> dgKogakuGassanShikyugakuKeisanKekkaMeisai) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeList().setDgKogakuGassanShikyugakuKeisanKekkaMeisai(dgKogakuGassanShikyugakuKeisanKekkaMeisai);
    }

    @JsonIgnore
    public GokeiJohoPanelDiv getGokeiJohoPanel() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel();
    }

    @JsonIgnore
    public void  setGokeiJohoPanel(GokeiJohoPanelDiv GokeiJohoPanel) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeList().setGokeiJohoPanel(GokeiJohoPanel);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoOver70FutangakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoOver70FutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoOver70FutangakuGokei(TextBoxNum txtJohoOver70FutangakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoOver70FutangakuGokei(txtJohoOver70FutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoOver70ShikyugakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoOver70ShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoOver70ShikyugakuGokei(TextBoxNum txtJohoOver70ShikyugakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoOver70ShikyugakuGokei(txtJohoOver70ShikyugakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoUnder70FutangakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoUnder70FutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoUnder70FutangakuGokei(TextBoxNum txtJohoUnder70FutangakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoUnder70FutangakuGokei(txtJohoUnder70FutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoFutangakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoFutangakuGokei(TextBoxNum txtJohoFutangakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoFutangakuGokei(txtJohoFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoUnder70ShikyugakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoUnder70ShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoUnder70ShikyugakuGokei(TextBoxNum txtJohoUnder70ShikyugakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoUnder70ShikyugakuGokei(txtJohoUnder70ShikyugakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoShikyugakuGokei() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoShikyugakuGokei(TextBoxNum txtJohoShikyugakuGokei) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoShikyugakuGokei(txtJohoShikyugakuGokei);
    }

    @JsonIgnore
    public DropDownList getDdlHokenSeido() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getDdlHokenSeido();
    }

    @JsonIgnore
    public void  setDdlHokenSeido(DropDownList ddlHokenSeido) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setDdlHokenSeido(ddlHokenSeido);
    }

    @JsonIgnore
    public TextBox getTxtShoKisaiHokenshaNo() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtShoKisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtShoKisaiHokenshaNo(TextBox txtShoKisaiHokenshaNo) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtShoKisaiHokenshaNo(txtShoKisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHokenshaMei() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtHokenshaMei();
    }

    @JsonIgnore
    public void  setTxtHokenshaMei(TextBox txtHokenshaMei) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtHokenshaMei(txtHokenshaMei);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin3();
    }

    @JsonIgnore
    public void  setLin3(HorizontalLine lin3) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin3(lin3);
    }

    @JsonIgnore
    public TextBoxCode getTxtKokuhoHihokenshaShoKigo() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtKokuhoHihokenshaShoKigo();
    }

    @JsonIgnore
    public void  setTxtKokuhoHihokenshaShoKigo(TextBoxCode txtKokuhoHihokenshaShoKigo) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtKokuhoHihokenshaShoKigo(txtKokuhoHihokenshaShoKigo);
    }

    @JsonIgnore
    public TextBox getTxtTaishoshaShimei() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtTaishoshaShimei();
    }

    @JsonIgnore
    public void  setTxtTaishoshaShimei(TextBox txtTaishoshaShimei) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtTaishoshaShimei(txtTaishoshaShimei);
    }

    @JsonIgnore
    public TextBoxCode getTxtHiHokenshaShoNo() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtHiHokenshaShoNo();
    }

    @JsonIgnore
    public void  setTxtHiHokenshaShoNo(TextBoxCode txtHiHokenshaShoNo) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtHiHokenshaShoNo(txtHiHokenshaShoNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtJikoFutanSeiriNom() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtJikoFutanSeiriNom();
    }

    @JsonIgnore
    public void  setTxtJikoFutanSeiriNom(TextBoxCode txtJikoFutanSeiriNom) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtJikoFutanSeiriNom(txtJikoFutanSeiriNom);
    }

    @JsonIgnore
    public HorizontalLine getLin4() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin4();
    }

    @JsonIgnore
    public void  setLin4(HorizontalLine lin4) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin4(lin4);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Futangaku() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Futangaku();
    }

    @JsonIgnore
    public void  setTxtOver70Futangaku(TextBoxNum txtOver70Futangaku) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Futangaku(txtOver70Futangaku);
    }

    @JsonIgnore
    public TextBox getTxtOver70AmbunRitsu() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70AmbunRitsu();
    }

    @JsonIgnore
    public void  setTxtOver70AmbunRitsu(TextBox txtOver70AmbunRitsu) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70AmbunRitsu(txtOver70AmbunRitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Shikyugaku() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Shikyugaku();
    }

    @JsonIgnore
    public void  setTxtOver70Shikyugaku(TextBoxNum txtOver70Shikyugaku) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Shikyugaku(txtOver70Shikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Futangaku() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Futangaku();
    }

    @JsonIgnore
    public void  setTxtUnder70Futangaku(TextBoxNum txtUnder70Futangaku) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Futangaku(txtUnder70Futangaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutangaku() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtFutangaku();
    }

    @JsonIgnore
    public void  setTxtFutangaku(TextBoxNum txtFutangaku) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtFutangaku(txtFutangaku);
    }

    @JsonIgnore
    public TextBox getTxtAmbunRitsu() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtAmbunRitsu();
    }

    @JsonIgnore
    public void  setTxtAmbunRitsu(TextBox txtAmbunRitsu) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtAmbunRitsu(txtAmbunRitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Shikyugaku() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Shikyugaku();
    }

    @JsonIgnore
    public void  setTxtUnder70Shikyugaku(TextBoxNum txtUnder70Shikyugaku) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Shikyugaku(txtUnder70Shikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGaku() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtShikyuGaku();
    }

    @JsonIgnore
    public void  setTxtShikyuGaku(TextBoxNum txtShikyuGaku) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtShikyuGaku(txtShikyuGaku);
    }

    @JsonIgnore
    public HorizontalLine getLin5() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin5();
    }

    @JsonIgnore
    public void  setLin5(HorizontalLine lin5) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin5(lin5);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Biko() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Biko();
    }

    @JsonIgnore
    public void  setTxtOver70Biko(TextBoxNum txtOver70Biko) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Biko(txtOver70Biko);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Biko() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Biko();
    }

    @JsonIgnore
    public void  setTxtUnder70Biko(TextBoxNum txtUnder70Biko) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Biko(txtUnder70Biko);
    }

    @JsonIgnore
    public HorizontalLine getLin7() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin7();
    }

    @JsonIgnore
    public void  setLin7(HorizontalLine lin7) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin7(lin7);
    }

    @JsonIgnore
    public Button getBtnUchiwakeKakutei() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getBtnUchiwakeKakutei();
    }

    @JsonIgnore
    public void  setBtnUchiwakeKakutei(Button btnUchiwakeKakutei) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setBtnUchiwakeKakutei(btnUchiwakeKakutei);
    }

    @JsonIgnore
    public Button getBtnUchiwakeIchiramModoru() {
        return this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getBtnUchiwakeIchiramModoru();
    }

    @JsonIgnore
    public void  setBtnUchiwakeIchiramModoru(Button btnUchiwakeIchiramModoru) {
        this.getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setBtnUchiwakeIchiramModoru(btnUchiwakeIchiramModoru);
    }

    // </editor-fold>
}
