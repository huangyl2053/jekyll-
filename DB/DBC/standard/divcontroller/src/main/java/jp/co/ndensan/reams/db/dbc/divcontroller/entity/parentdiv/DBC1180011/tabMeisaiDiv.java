package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1180011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabMeisai のクラスファイル 
 * 
 * @reamsid_L DBC-2030-010 huzongcheng
 */
public class tabMeisaiDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabShikyugakuKeisanKekkaTorokuUchiwake")
    private tabShikyugakuKeisanKekkaTorokuUchiwakeDiv tabShikyugakuKeisanKekkaTorokuUchiwake;
    @JsonProperty("tabShikyugakuKeisanKekkaTorokuShikyuGaku")
    private tabShikyugakuKeisanKekkaTorokuShikyuGakuDiv tabShikyugakuKeisanKekkaTorokuShikyuGaku;
    @JsonProperty("tabShikyugakuKeisanKekkaTorokuRenrakuhyo")
    private tabShikyugakuKeisanKekkaTorokuRenrakuhyoDiv tabShikyugakuKeisanKekkaTorokuRenrakuhyo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabShikyugakuKeisanKekkaTorokuUchiwake
     * @return tabShikyugakuKeisanKekkaTorokuUchiwake
     */
    @JsonProperty("tabShikyugakuKeisanKekkaTorokuUchiwake")
    public tabShikyugakuKeisanKekkaTorokuUchiwakeDiv getTabShikyugakuKeisanKekkaTorokuUchiwake() {
        return tabShikyugakuKeisanKekkaTorokuUchiwake;
    }

    /*
     * settabShikyugakuKeisanKekkaTorokuUchiwake
     * @param tabShikyugakuKeisanKekkaTorokuUchiwake tabShikyugakuKeisanKekkaTorokuUchiwake
     */
    @JsonProperty("tabShikyugakuKeisanKekkaTorokuUchiwake")
    public void setTabShikyugakuKeisanKekkaTorokuUchiwake(tabShikyugakuKeisanKekkaTorokuUchiwakeDiv tabShikyugakuKeisanKekkaTorokuUchiwake) {
        this.tabShikyugakuKeisanKekkaTorokuUchiwake = tabShikyugakuKeisanKekkaTorokuUchiwake;
    }

    /*
     * gettabShikyugakuKeisanKekkaTorokuShikyuGaku
     * @return tabShikyugakuKeisanKekkaTorokuShikyuGaku
     */
    @JsonProperty("tabShikyugakuKeisanKekkaTorokuShikyuGaku")
    public tabShikyugakuKeisanKekkaTorokuShikyuGakuDiv getTabShikyugakuKeisanKekkaTorokuShikyuGaku() {
        return tabShikyugakuKeisanKekkaTorokuShikyuGaku;
    }

    /*
     * settabShikyugakuKeisanKekkaTorokuShikyuGaku
     * @param tabShikyugakuKeisanKekkaTorokuShikyuGaku tabShikyugakuKeisanKekkaTorokuShikyuGaku
     */
    @JsonProperty("tabShikyugakuKeisanKekkaTorokuShikyuGaku")
    public void setTabShikyugakuKeisanKekkaTorokuShikyuGaku(tabShikyugakuKeisanKekkaTorokuShikyuGakuDiv tabShikyugakuKeisanKekkaTorokuShikyuGaku) {
        this.tabShikyugakuKeisanKekkaTorokuShikyuGaku = tabShikyugakuKeisanKekkaTorokuShikyuGaku;
    }

    /*
     * gettabShikyugakuKeisanKekkaTorokuRenrakuhyo
     * @return tabShikyugakuKeisanKekkaTorokuRenrakuhyo
     */
    @JsonProperty("tabShikyugakuKeisanKekkaTorokuRenrakuhyo")
    public tabShikyugakuKeisanKekkaTorokuRenrakuhyoDiv getTabShikyugakuKeisanKekkaTorokuRenrakuhyo() {
        return tabShikyugakuKeisanKekkaTorokuRenrakuhyo;
    }

    /*
     * settabShikyugakuKeisanKekkaTorokuRenrakuhyo
     * @param tabShikyugakuKeisanKekkaTorokuRenrakuhyo tabShikyugakuKeisanKekkaTorokuRenrakuhyo
     */
    @JsonProperty("tabShikyugakuKeisanKekkaTorokuRenrakuhyo")
    public void setTabShikyugakuKeisanKekkaTorokuRenrakuhyo(tabShikyugakuKeisanKekkaTorokuRenrakuhyoDiv tabShikyugakuKeisanKekkaTorokuRenrakuhyo) {
        this.tabShikyugakuKeisanKekkaTorokuRenrakuhyo = tabShikyugakuKeisanKekkaTorokuRenrakuhyo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShikyugakuKeisanKekkaTorokuUchiwakeListDiv getShikyugakuKeisanKekkaTorokuUchiwakeList() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList();
    }

    @JsonIgnore
    public void  setShikyugakuKeisanKekkaTorokuUchiwakeList(ShikyugakuKeisanKekkaTorokuUchiwakeListDiv ShikyugakuKeisanKekkaTorokuUchiwakeList) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().setShikyugakuKeisanKekkaTorokuUchiwakeList(ShikyugakuKeisanKekkaTorokuUchiwakeList);
    }

    @JsonIgnore
    public Button getBtnUchiwakeAdd() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getBtnUchiwakeAdd();
    }

    @JsonIgnore
    public void  setBtnUchiwakeAdd(Button btnUchiwakeAdd) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().setBtnUchiwakeAdd(btnUchiwakeAdd);
    }

    @JsonIgnore
    public DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> getDgKogakuGassanShikyugakuKeisanKekkaMeisai() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getDgKogakuGassanShikyugakuKeisanKekkaMeisai();
    }

    @JsonIgnore
    public void  setDgKogakuGassanShikyugakuKeisanKekkaMeisai(DataGrid<dgKogakuGassanShikyugakuKeisanKekkaMeisai_Row> dgKogakuGassanShikyugakuKeisanKekkaMeisai) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().setDgKogakuGassanShikyugakuKeisanKekkaMeisai(dgKogakuGassanShikyugakuKeisanKekkaMeisai);
    }

    @JsonIgnore
    public GokeiJohoPanelDiv getGokeiJohoPanel() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel();
    }

    @JsonIgnore
    public void  setGokeiJohoPanel(GokeiJohoPanelDiv GokeiJohoPanel) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().setGokeiJohoPanel(GokeiJohoPanel);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoOver70FutangakuGokei() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoOver70FutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoOver70FutangakuGokei(TextBoxNum txtJohoOver70FutangakuGokei) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoOver70FutangakuGokei(txtJohoOver70FutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoOver70ShikyugakuGokei() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoOver70ShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoOver70ShikyugakuGokei(TextBoxNum txtJohoOver70ShikyugakuGokei) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoOver70ShikyugakuGokei(txtJohoOver70ShikyugakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoUnder70FutangakuGokei() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoUnder70FutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoUnder70FutangakuGokei(TextBoxNum txtJohoUnder70FutangakuGokei) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoUnder70FutangakuGokei(txtJohoUnder70FutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoFutangakuGokei() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoFutangakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoFutangakuGokei(TextBoxNum txtJohoFutangakuGokei) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoFutangakuGokei(txtJohoFutangakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoUnder70ShikyugakuGokei() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoUnder70ShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoUnder70ShikyugakuGokei(TextBoxNum txtJohoUnder70ShikyugakuGokei) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoUnder70ShikyugakuGokei(txtJohoUnder70ShikyugakuGokei);
    }

    @JsonIgnore
    public TextBoxNum getTxtJohoShikyugakuGokei() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().getTxtJohoShikyugakuGokei();
    }

    @JsonIgnore
    public void  setTxtJohoShikyugakuGokei(TextBoxNum txtJohoShikyugakuGokei) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeList().getGokeiJohoPanel().setTxtJohoShikyugakuGokei(txtJohoShikyugakuGokei);
    }

    @JsonIgnore
    public ShikyugakuKeisanKekkaTorokuUchiwakeDetailDiv getShikyugakuKeisanKekkaTorokuUchiwakeDetail() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail();
    }

    @JsonIgnore
    public void  setShikyugakuKeisanKekkaTorokuUchiwakeDetail(ShikyugakuKeisanKekkaTorokuUchiwakeDetailDiv ShikyugakuKeisanKekkaTorokuUchiwakeDetail) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().setShikyugakuKeisanKekkaTorokuUchiwakeDetail(ShikyugakuKeisanKekkaTorokuUchiwakeDetail);
    }

    @JsonIgnore
    public DropDownList getDdlHokenSeido() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getDdlHokenSeido();
    }

    @JsonIgnore
    public void  setDdlHokenSeido(DropDownList ddlHokenSeido) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setDdlHokenSeido(ddlHokenSeido);
    }

    @JsonIgnore
    public TextBox getTxtShoKisaiHokenshaNo() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtShoKisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtShoKisaiHokenshaNo(TextBox txtShoKisaiHokenshaNo) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtShoKisaiHokenshaNo(txtShoKisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtHokenshaMei() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtHokenshaMei();
    }

    @JsonIgnore
    public void  setTxtHokenshaMei(TextBox txtHokenshaMei) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtHokenshaMei(txtHokenshaMei);
    }

    @JsonIgnore
    public HorizontalLine getLin3() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin3();
    }

    @JsonIgnore
    public void  setLin3(HorizontalLine lin3) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin3(lin3);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshaShoKigo() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtKokuhoHihokenshaShoKigo();
    }

    @JsonIgnore
    public void  setTxtKokuhoHihokenshaShoKigo(TextBox txtKokuhoHihokenshaShoKigo) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtKokuhoHihokenshaShoKigo(txtKokuhoHihokenshaShoKigo);
    }

    @JsonIgnore
    public TextBox getTxtTaishoshaShimei() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtTaishoshaShimei();
    }

    @JsonIgnore
    public void  setTxtTaishoshaShimei(TextBox txtTaishoshaShimei) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtTaishoshaShimei(txtTaishoshaShimei);
    }

    @JsonIgnore
    public TextBox getTxtHiHokenshaShoNo() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtHiHokenshaShoNo();
    }

    @JsonIgnore
    public void  setTxtHiHokenshaShoNo(TextBox txtHiHokenshaShoNo) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtHiHokenshaShoNo(txtHiHokenshaShoNo);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutanSeiriNom() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtJikoFutanSeiriNom();
    }

    @JsonIgnore
    public void  setTxtJikoFutanSeiriNom(TextBox txtJikoFutanSeiriNom) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtJikoFutanSeiriNom(txtJikoFutanSeiriNom);
    }

    @JsonIgnore
    public HorizontalLine getLin4() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin4();
    }

    @JsonIgnore
    public void  setLin4(HorizontalLine lin4) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin4(lin4);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Futangaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Futangaku();
    }

    @JsonIgnore
    public void  setTxtOver70Futangaku(TextBoxNum txtOver70Futangaku) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Futangaku(txtOver70Futangaku);
    }

    @JsonIgnore
    public TextBox getTxtOver70AmbunRitsu() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70AmbunRitsu();
    }

    @JsonIgnore
    public void  setTxtOver70AmbunRitsu(TextBox txtOver70AmbunRitsu) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70AmbunRitsu(txtOver70AmbunRitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Shikyugaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Shikyugaku();
    }

    @JsonIgnore
    public void  setTxtOver70Shikyugaku(TextBoxNum txtOver70Shikyugaku) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Shikyugaku(txtOver70Shikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Futangaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Futangaku();
    }

    @JsonIgnore
    public void  setTxtUnder70Futangaku(TextBoxNum txtUnder70Futangaku) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Futangaku(txtUnder70Futangaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtFutangaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtFutangaku();
    }

    @JsonIgnore
    public void  setTxtFutangaku(TextBoxNum txtFutangaku) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtFutangaku(txtFutangaku);
    }

    @JsonIgnore
    public TextBox getTxtAmbunRitsu() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtAmbunRitsu();
    }

    @JsonIgnore
    public void  setTxtAmbunRitsu(TextBox txtAmbunRitsu) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtAmbunRitsu(txtAmbunRitsu);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Shikyugaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Shikyugaku();
    }

    @JsonIgnore
    public void  setTxtUnder70Shikyugaku(TextBoxNum txtUnder70Shikyugaku) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Shikyugaku(txtUnder70Shikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShikyuGaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtShikyuGaku();
    }

    @JsonIgnore
    public void  setTxtShikyuGaku(TextBoxNum txtShikyuGaku) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtShikyuGaku(txtShikyuGaku);
    }

    @JsonIgnore
    public HorizontalLine getLin5() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin5();
    }

    @JsonIgnore
    public void  setLin5(HorizontalLine lin5) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin5(lin5);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70Biko() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtOver70Biko();
    }

    @JsonIgnore
    public void  setTxtOver70Biko(TextBoxNum txtOver70Biko) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtOver70Biko(txtOver70Biko);
    }

    @JsonIgnore
    public TextBoxNum getTxtUnder70Biko() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getTxtUnder70Biko();
    }

    @JsonIgnore
    public void  setTxtUnder70Biko(TextBoxNum txtUnder70Biko) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setTxtUnder70Biko(txtUnder70Biko);
    }

    @JsonIgnore
    public HorizontalLine getLin7() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getLin7();
    }

    @JsonIgnore
    public void  setLin7(HorizontalLine lin7) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setLin7(lin7);
    }

    @JsonIgnore
    public Button getBtnUchiwakeKakutei() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getBtnUchiwakeKakutei();
    }

    @JsonIgnore
    public void  setBtnUchiwakeKakutei(Button btnUchiwakeKakutei) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setBtnUchiwakeKakutei(btnUchiwakeKakutei);
    }

    @JsonIgnore
    public Button getBtnUchiwakeIchiramModoru() {
        return this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().getBtnUchiwakeIchiramModoru();
    }

    @JsonIgnore
    public void  setBtnUchiwakeIchiramModoru(Button btnUchiwakeIchiramModoru) {
        this.getTabShikyugakuKeisanKekkaTorokuUchiwake().getShikyugakuKeisanKekkaTorokuUchiwakeDetail().setBtnUchiwakeIchiramModoru(btnUchiwakeIchiramModoru);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoKeisanKikan() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtTaishoKeisanKikan();
    }

    @JsonIgnore
    public void  setTxtTaishoKeisanKikan(TextBoxDateRange txtTaishoKeisanKikan) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtTaishoKeisanKikan(txtTaishoKeisanKikan);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutanSeiriNo() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtJikoFutanSeiriNo();
    }

    @JsonIgnore
    public void  setTxtJikoFutanSeiriNo(TextBox txtJikoFutanSeiriNo) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtJikoFutanSeiriNo(txtJikoFutanSeiriNo);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKubun() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getDdlShotokuKubun();
    }

    @JsonIgnore
    public void  setDdlShotokuKubun(DropDownList ddlShotokuKubun) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setDdlShotokuKubun(ddlShotokuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlOver70ShotokuKubun() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getDdlOver70ShotokuKubun();
    }

    @JsonIgnore
    public void  setDdlOver70ShotokuKubun(DropDownList ddlOver70ShotokuKubun) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setDdlOver70ShotokuKubun(ddlOver70ShotokuKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiFutanSogaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSetaiFutanSogaku();
    }

    @JsonIgnore
    public void  setTxtSetaiFutanSogaku(TextBoxNum txtSetaiFutanSogaku) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSetaiFutanSogaku(txtSetaiFutanSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiShikyuSogaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSetaiShikyuSogaku();
    }

    @JsonIgnore
    public void  setTxtSetaiShikyuSogaku(TextBoxNum txtSetaiShikyuSogaku) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSetaiShikyuSogaku(txtSetaiShikyuSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70SetaiShikyuSogaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70SetaiShikyuSogaku();
    }

    @JsonIgnore
    public void  setTxtOver70SetaiShikyuSogaku(TextBoxNum txtOver70SetaiShikyuSogaku) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70SetaiShikyuSogaku(txtOver70SetaiShikyuSogaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSetaiGassanGaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSetaiGassanGaku();
    }

    @JsonIgnore
    public void  setTxtSetaiGassanGaku(TextBoxNum txtSetaiGassanGaku) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSetaiGassanGaku(txtSetaiGassanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70SetaiGassanGaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70SetaiGassanGaku();
    }

    @JsonIgnore
    public void  setTxtOver70SetaiGassanGaku(TextBoxNum txtOver70SetaiGassanGaku) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70SetaiGassanGaku(txtOver70SetaiGassanGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtHonninShikyugaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtHonninShikyugaku();
    }

    @JsonIgnore
    public void  setTxtHonninShikyugaku(TextBoxNum txtHonninShikyugaku) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtHonninShikyugaku(txtHonninShikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70HonninShikyugaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70HonninShikyugaku();
    }

    @JsonIgnore
    public void  setTxtOver70HonninShikyugaku(TextBoxNum txtOver70HonninShikyugaku) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70HonninShikyugaku(txtOver70HonninShikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtSanteiKijunGaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtSanteiKijunGaku();
    }

    @JsonIgnore
    public void  setTxtSanteiKijunGaku(TextBoxNum txtSanteiKijunGaku) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtSanteiKijunGaku(txtSanteiKijunGaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtOver70SanteiKijyunGaku() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtOver70SanteiKijyunGaku();
    }

    @JsonIgnore
    public void  setTxtOver70SanteiKijyunGaku(TextBoxNum txtOver70SanteiKijyunGaku) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtOver70SanteiKijyunGaku(txtOver70SanteiKijyunGaku);
    }

    @JsonIgnore
    public CheckBoxList getCblTeiShotoku1SaiKeisanUmu() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getCblTeiShotoku1SaiKeisanUmu();
    }

    @JsonIgnore
    public void  setCblTeiShotoku1SaiKeisanUmu(CheckBoxList cblTeiShotoku1SaiKeisanUmu) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setCblTeiShotoku1SaiKeisanUmu(cblTeiShotoku1SaiKeisanUmu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().getTxtBiko();
    }

    @JsonIgnore
    public void  setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getTabShikyugakuKeisanKekkaTorokuShikyuGaku().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public TextBoxDate getTxtTsuchiYMD() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getTxtTsuchiYMD();
    }

    @JsonIgnore
    public void  setTxtTsuchiYMD(TextBoxDate txtTsuchiYMD) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().setTxtTsuchiYMD(txtTsuchiYMD);
    }

    @JsonIgnore
    public RenrakuhyoHakkoshaPanelDiv getRenrakuhyoHakkoshaPanel() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel();
    }

    @JsonIgnore
    public void  setRenrakuhyoHakkoshaPanel(RenrakuhyoHakkoshaPanelDiv RenrakuhyoHakkoshaPanel) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().setRenrakuhyoHakkoshaPanel(RenrakuhyoHakkoshaPanel);
    }

    @JsonIgnore
    public TextBox getTxtRenrakuhyoHakkoshaMei() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaMei();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaMei(TextBox txtRenrakuhyoHakkoshaMei) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaMei(txtRenrakuhyoHakkoshaMei);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtRenrakuhyoHakkoshaYubinNo() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaYubinNo();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaYubinNo(TextBoxYubinNo txtRenrakuhyoHakkoshaYubinNo) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaYubinNo(txtRenrakuhyoHakkoshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtRenrakuhyoHakkoshaJusho() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().getTxtRenrakuhyoHakkoshaJusho();
    }

    @JsonIgnore
    public void  setTxtRenrakuhyoHakkoshaJusho(TextBox txtRenrakuhyoHakkoshaJusho) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getRenrakuhyoHakkoshaPanel().setTxtRenrakuhyoHakkoshaJusho(txtRenrakuhyoHakkoshaJusho);
    }

    @JsonIgnore
    public ToiawasesakiPanelDiv getToiawasesakiPanel() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel();
    }

    @JsonIgnore
    public void  setToiawasesakiPanel(ToiawasesakiPanelDiv ToiawasesakiPanel) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().setToiawasesakiPanel(ToiawasesakiPanel);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiMeisho1() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiMeisho1();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiMeisho1(TextBox txtToiawasesakiMeisho1) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiMeisho1(txtToiawasesakiMeisho1);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtToiawasesakiYobinNo() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiYobinNo();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiYobinNo(TextBoxYubinNo txtToiawasesakiYobinNo) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiYobinNo(txtToiawasesakiYobinNo);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiMeisho2() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiMeisho2();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiMeisho2(TextBox txtToiawasesakiMeisho2) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiMeisho2(txtToiawasesakiMeisho2);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiTelNo() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiTelNo();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiTelNo(TextBox txtToiawasesakiTelNo) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiTelNo(txtToiawasesakiTelNo);
    }

    @JsonIgnore
    public TextBox getTxtToiawasesakiJusho() {
        return this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().getTxtToiawasesakiJusho();
    }

    @JsonIgnore
    public void  setTxtToiawasesakiJusho(TextBox txtToiawasesakiJusho) {
        this.getTabShikyugakuKeisanKekkaTorokuRenrakuhyo().getToiawasesakiPanel().setTxtToiawasesakiJusho(txtToiawasesakiJusho);
    }

    // </editor-fold>
}
