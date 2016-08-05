package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC8130011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.CheckBoxList;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxNum;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;

/**
 * JikoFutangakuHosei のクラスファイル
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class JikoFutangakuHoseiDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("JikoFutangakuHoseiList")
    private JikoFutangakuHoseiListDiv JikoFutangakuHoseiList;
    @JsonProperty("JikoFutangakuHoseiDetail")
    private JikoFutangakuHoseiDetailDiv JikoFutangakuHoseiDetail;
    @JsonProperty("KogakuGassanShikyuShinseiTorokuKaigoKihon")
    private KaigoShikakuKihonDiv KogakuGassanShikyuShinseiTorokuKaigoKihon;
    @JsonProperty("KogakuGassanShikyuShinseiTorokuKihon")
    private KaigoAtenaInfoDiv KogakuGassanShikyuShinseiTorokuKihon;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlinLine1
     * @return linLine1
     */
    @JsonProperty("linLine1")
    public HorizontalLine getLinLine1() {
        return linLine1;
    }

    /*
     * setlinLine1
     * @param linLine1 linLine1
     */
    @JsonProperty("linLine1")
    public void setLinLine1(HorizontalLine linLine1) {
        this.linLine1 = linLine1;
    }

    /*
     * getJikoFutangakuHoseiList
     * @return JikoFutangakuHoseiList
     */
    @JsonProperty("JikoFutangakuHoseiList")
    public JikoFutangakuHoseiListDiv getJikoFutangakuHoseiList() {
        return JikoFutangakuHoseiList;
    }

    /*
     * setJikoFutangakuHoseiList
     * @param JikoFutangakuHoseiList JikoFutangakuHoseiList
     */
    @JsonProperty("JikoFutangakuHoseiList")
    public void setJikoFutangakuHoseiList(JikoFutangakuHoseiListDiv JikoFutangakuHoseiList) {
        this.JikoFutangakuHoseiList = JikoFutangakuHoseiList;
    }

    /*
     * getJikoFutangakuHoseiDetail
     * @return JikoFutangakuHoseiDetail
     */
    @JsonProperty("JikoFutangakuHoseiDetail")
    public JikoFutangakuHoseiDetailDiv getJikoFutangakuHoseiDetail() {
        return JikoFutangakuHoseiDetail;
    }

    /*
     * setJikoFutangakuHoseiDetail
     * @param JikoFutangakuHoseiDetail JikoFutangakuHoseiDetail
     */
    @JsonProperty("JikoFutangakuHoseiDetail")
    public void setJikoFutangakuHoseiDetail(JikoFutangakuHoseiDetailDiv JikoFutangakuHoseiDetail) {
        this.JikoFutangakuHoseiDetail = JikoFutangakuHoseiDetail;
    }

    /*
     * getKogakuGassanShikyuShinseiTorokuKaigoKihon
     * @return KogakuGassanShikyuShinseiTorokuKaigoKihon
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuKaigoKihon")
    public IKaigoShikakuKihonDiv getKogakuGassanShikyuShinseiTorokuKaigoKihon() {
        return KogakuGassanShikyuShinseiTorokuKaigoKihon;
    }

    /*
     * getKogakuGassanShikyuShinseiTorokuKihon
     * @return KogakuGassanShikyuShinseiTorokuKihon
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuKihon")
    public IKaigoAtenaInfoDiv getKogakuGassanShikyuShinseiTorokuKihon() {
        return KogakuGassanShikyuShinseiTorokuKihon;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkRirekiHyouji() {
        return this.getJikoFutangakuHoseiList().getChkRirekiHyouji();
    }

    @JsonIgnore
    public void setChkRirekiHyouji(CheckBoxList chkRirekiHyouji) {
        this.getJikoFutangakuHoseiList().setChkRirekiHyouji(chkRirekiHyouji);
    }

    @JsonIgnore
    public DataGrid<dgJohoIchiran_Row> getDgJohoIchiran() {
        return this.getJikoFutangakuHoseiList().getDgJohoIchiran();
    }

    @JsonIgnore
    public void setDgJohoIchiran(DataGrid<dgJohoIchiran_Row> dgJohoIchiran) {
        this.getJikoFutangakuHoseiList().setDgJohoIchiran(dgJohoIchiran);
    }

    @JsonIgnore
    public TextBox getTxtSanteiKBN() {
        return this.getJikoFutangakuHoseiDetail().getTxtSanteiKBN();
    }

    @JsonIgnore
    public void setTxtSanteiKBN(TextBox txtSanteiKBN) {
        this.getJikoFutangakuHoseiDetail().setTxtSanteiKBN(txtSanteiKBN);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishouNendo() {
        return this.getJikoFutangakuHoseiDetail().getTxtTaishouNendo();
    }

    @JsonIgnore
    public void setTxtTaishouNendo(TextBoxDate txtTaishouNendo) {
        this.getJikoFutangakuHoseiDetail().setTxtTaishouNendo(txtTaishouNendo);
    }

    @JsonIgnore
    public TextBox getTxtShoukisaiHokenjaNO() {
        return this.getJikoFutangakuHoseiDetail().getTxtShoukisaiHokenjaNO();
    }

    @JsonIgnore
    public void setTxtShoukisaiHokenjaNO(TextBox txtShoukisaiHokenjaNO) {
        this.getJikoFutangakuHoseiDetail().setTxtShoukisaiHokenjaNO(txtShoukisaiHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtShikyuShinseiSeiriNO() {
        return this.getJikoFutangakuHoseiDetail().getTxtShikyuShinseiSeiriNO();
    }

    @JsonIgnore
    public void setTxtShikyuShinseiSeiriNO(TextBox txtShikyuShinseiSeiriNO) {
        this.getJikoFutangakuHoseiDetail().setTxtShikyuShinseiSeiriNO(txtShikyuShinseiSeiriNO);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriYM() {
        return this.getJikoFutangakuHoseiDetail().getTxtUketoriYM();
    }

    @JsonIgnore
    public void setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.getJikoFutangakuHoseiDetail().setTxtUketoriYM(txtUketoriYM);
    }

    @JsonIgnore
    public TextBoxDate getTxtJikofutangakuKeisanYMD() {
        return this.getJikoFutangakuHoseiDetail().getTxtJikofutangakuKeisanYMD();
    }

    @JsonIgnore
    public void setTxtJikofutangakuKeisanYMD(TextBoxDate txtJikofutangakuKeisanYMD) {
        this.getJikoFutangakuHoseiDetail().setTxtJikofutangakuKeisanYMD(txtJikofutangakuKeisanYMD);
    }

    @JsonIgnore
    public TextBoxDate getTxtHoseibiTan() {
        return this.getJikoFutangakuHoseiDetail().getTxtHoseibiTan();
    }

    @JsonIgnore
    public void setTxtHoseibiTan(TextBoxDate txtHoseibiTan) {
        this.getJikoFutangakuHoseiDetail().setTxtHoseibiTan(txtHoseibiTan);
    }

    @JsonIgnore
    public TextBoxDate getTxtShoumeishoSakuseiYMD() {
        return this.getJikoFutangakuHoseiDetail().getTxtShoumeishoSakuseiYMD();
    }

    @JsonIgnore
    public void setTxtShoumeishoSakuseiYMD(TextBoxDate txtShoumeishoSakuseiYMD) {
        this.getJikoFutangakuHoseiDetail().setTxtShoumeishoSakuseiYMD(txtShoumeishoSakuseiYMD);
    }

    @JsonIgnore
    public Label getLblShoumeishoYou() {
        return this.getJikoFutangakuHoseiDetail().getLblShoumeishoYou();
    }

    @JsonIgnore
    public void setLblShoumeishoYou(Label lblShoumeishoYou) {
        this.getJikoFutangakuHoseiDetail().setLblShoumeishoYou(lblShoumeishoYou);
    }

    @JsonIgnore
    public HorizontalLine getLinLine2() {
        return this.getJikoFutangakuHoseiDetail().getLinLine2();
    }

    @JsonIgnore
    public void setLinLine2(HorizontalLine linLine2) {
        this.getJikoFutangakuHoseiDetail().setLinLine2(linLine2);
    }

    @JsonIgnore
    public tabJikofutanKanriJohoNyuryokuDiv getTabJikofutanKanriJohoNyuryoku() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku();
    }

    @JsonIgnore
    public void setTabJikofutanKanriJohoNyuryoku(tabJikofutanKanriJohoNyuryokuDiv tabJikofutanKanriJohoNyuryoku) {
        this.getJikoFutangakuHoseiDetail().setTabJikofutanKanriJohoNyuryoku(tabJikofutanKanriJohoNyuryoku);
    }

    @JsonIgnore
    public tplJikofutanKanriJoho1Div getTplJikofutanKanriJoho1() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1();
    }

    @JsonIgnore
    public void setTplJikofutanKanriJoho1(tplJikofutanKanriJoho1Div tplJikofutanKanriJoho1) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().setTplJikofutanKanriJoho1(tplJikofutanKanriJoho1);
    }

    @JsonIgnore
    public TextBox getTxtIdouKBN() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtIdouKBN();
    }

    @JsonIgnore
    public void setTxtIdouKBN(TextBox txtIdouKBN) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtIdouKBN(txtIdouKBN);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKBN() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getDdlShotokuKBN();
    }

    @JsonIgnore
    public void setDdlShotokuKBN(DropDownList ddlShotokuKBN) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setDdlShotokuKBN(ddlShotokuKBN);
    }

    @JsonIgnore
    public DropDownList getDdl70SaiIjouShotokuKBN() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getDdl70SaiIjouShotokuKBN();
    }

    @JsonIgnore
    public void setDdl70SaiIjouShotokuKBN(DropDownList ddl70SaiIjouShotokuKBN) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setDdl70SaiIjouShotokuKBN(ddl70SaiIjouShotokuKBN);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaName() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtHihokenshaName();
    }

    @JsonIgnore
    public void setTxtHihokenshaName(TextBox txtHihokenshaName) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtHihokenshaName(txtHihokenshaName);
    }

    @JsonIgnore
    public JikoFutangakuHoseiTotsugo1Div getJikoFutangakuHoseiTotsugo1() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiTotsugo1(JikoFutangakuHoseiTotsugo1Div JikoFutangakuHoseiTotsugo1) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setJikoFutangakuHoseiTotsugo1(JikoFutangakuHoseiTotsugo1);
    }

    @JsonIgnore
    public TextBox getTxtKoukiHokenjaNO() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().getTxtKoukiHokenjaNO();
    }

    @JsonIgnore
    public void setTxtKoukiHokenjaNO(TextBox txtKoukiHokenjaNO) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().setTxtKoukiHokenjaNO(txtKoukiHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtKoukiHihokenshaNO() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().getTxtKoukiHihokenshaNO();
    }

    @JsonIgnore
    public void setTxtKoukiHihokenshaNO(TextBox txtKoukiHihokenshaNO) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().setTxtKoukiHihokenshaNO(txtKoukiHihokenshaNO);
    }

    @JsonIgnore
    public JikoFutangakuHoseiTotsugo2Div getJikoFutangakuHoseiTotsugo2() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiTotsugo2(JikoFutangakuHoseiTotsugo2Div JikoFutangakuHoseiTotsugo2) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setJikoFutangakuHoseiTotsugo2(JikoFutangakuHoseiTotsugo2);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenjaNO() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHokenjaNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenjaNO(TextBox txtKokuhoHokenjaNO) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHokenjaNO(txtKokuhoHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshaKojinNO() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHihokenshaKojinNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHihokenshaKojinNO(TextBox txtKokuhoHihokenshaKojinNO) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHihokenshaKojinNO(txtKokuhoHihokenshaKojinNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshashouNO() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHihokenshashouNO();
    }

    @JsonIgnore
    public void setTxtKokuhoHihokenshashouNO(TextBox txtKokuhoHihokenshashouNO) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHihokenshashouNO(txtKokuhoHihokenshashouNO);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishouKeisanKikan() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtTaishouKeisanKikan();
    }

    @JsonIgnore
    public void setTxtTaishouKeisanKikan(TextBoxDateRange txtTaishouKeisanKikan) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtTaishouKeisanKikan(txtTaishouKeisanKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtHihokenshaKikan() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtHihokenshaKikan();
    }

    @JsonIgnore
    public void setTxtHihokenshaKikan(TextBoxDateRange txtHihokenshaKikan) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtHihokenshaKikan(txtHihokenshaKikan);
    }

    @JsonIgnore
    public tplJikofutanKanriJoho2Div getTplJikofutanKanriJoho2() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2();
    }

    @JsonIgnore
    public void setTplJikofutanKanriJoho2(tplJikofutanKanriJoho2Div tplJikofutanKanriJoho2) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().setTplJikofutanKanriJoho2(tplJikofutanKanriJoho2);
    }

    @JsonIgnore
    public JikoFutangakuHoseiAtesakiDiv getJikoFutangakuHoseiAtesaki() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiAtesaki(JikoFutangakuHoseiAtesakiDiv JikoFutangakuHoseiAtesaki) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().setJikoFutangakuHoseiAtesaki(JikoFutangakuHoseiAtesaki);
    }

    @JsonIgnore
    public TextBox getTxtAtesakiShimei() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiShimei();
    }

    @JsonIgnore
    public void setTxtAtesakiShimei(TextBox txtAtesakiShimei) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiShimei(txtAtesakiShimei);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtAtesakiYubinNO() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiYubinNO();
    }

    @JsonIgnore
    public void setTxtAtesakiYubinNO(TextBoxYubinNo txtAtesakiYubinNO) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiYubinNO(txtAtesakiYubinNO);
    }

    @JsonIgnore
    public TextBox getTxtAtesakiJusho() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiJusho();
    }

    @JsonIgnore
    public void setTxtAtesakiJusho(TextBox txtAtesakiJusho) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiJusho(txtAtesakiJusho);
    }

    @JsonIgnore
    public JikoFutangakuHoseiMadoguchiDiv getJikoFutangakuHoseiMadoguchi() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi();
    }

    @JsonIgnore
    public void setJikoFutangakuHoseiMadoguchi(JikoFutangakuHoseiMadoguchiDiv JikoFutangakuHoseiMadoguchi) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().setJikoFutangakuHoseiMadoguchi(JikoFutangakuHoseiMadoguchi);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiTaishoushaHantei() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiTaishoushaHantei();
    }

    @JsonIgnore
    public void setTxtMadoguchiTaishoushaHantei(TextBox txtMadoguchiTaishoushaHantei) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiTaishoushaHantei(txtMadoguchiTaishoushaHantei);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShiharaiBasho() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShiharaiBasho();
    }

    @JsonIgnore
    public void setTxtMadoguchiShiharaiBasho(TextBox txtMadoguchiShiharaiBasho) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShiharaiBasho(txtMadoguchiShiharaiBasho);
    }

    @JsonIgnore
    public TextBoxDate getTxtMadoguchiKaishiYMD() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiYMD();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiYMD(TextBoxDate txtMadoguchiKaishiYMD) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiYMD(txtMadoguchiKaishiYMD);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiKaishiYoubi() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiYoubi();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiYoubi(TextBox txtMadoguchiKaishiYoubi) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiYoubi(txtMadoguchiKaishiYoubi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiKaishiJikan() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiJikan();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiJikan(TextBoxNum txtMadoguchiKaishiJikan) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiJikan(txtMadoguchiKaishiJikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiKaishiFun() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiFun();
    }

    @JsonIgnore
    public void setTxtMadoguchiKaishiFun(TextBoxNum txtMadoguchiKaishiFun) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiFun(txtMadoguchiKaishiFun);
    }

    @JsonIgnore
    public TextBoxDate getTxtMadoguchiShuryoYMD() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoYMD();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoYMD(TextBoxDate txtMadoguchiShuryoYMD) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoYMD(txtMadoguchiShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShuryoYoubi() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoYoubi();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoYoubi(TextBox txtMadoguchiShuryoYoubi) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoYoubi(txtMadoguchiShuryoYoubi);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiShuryoJikan() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoJikan();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoJikan(TextBoxNum txtMadoguchiShuryoJikan) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoJikan(txtMadoguchiShuryoJikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtMadoguchiShuryoFun() {
        return this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoFun();
    }

    @JsonIgnore
    public void setTxtMadoguchiShuryoFun(TextBoxNum txtMadoguchiShuryoFun) {
        this.getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoFun(txtMadoguchiShuryoFun);
    }

    @JsonIgnore
    public Button getBtnJikofutangakuJohoNyuryoku() {
        return this.getJikoFutangakuHoseiDetail().getBtnJikofutangakuJohoNyuryoku();
    }

    @JsonIgnore
    public void setBtnJikofutangakuJohoNyuryoku(Button btnJikofutangakuJohoNyuryoku) {
        this.getJikoFutangakuHoseiDetail().setBtnJikofutangakuJohoNyuryoku(btnJikofutangakuJohoNyuryoku);
    }

    @JsonIgnore
    public Button getBtnJikofutangakuJohoNiModoru() {
        return this.getJikoFutangakuHoseiDetail().getBtnJikofutangakuJohoNiModoru();
    }

    @JsonIgnore
    public void setBtnJikofutangakuJohoNiModoru(Button btnJikofutangakuJohoNiModoru) {
        this.getJikoFutangakuHoseiDetail().setBtnJikofutangakuJohoNiModoru(btnJikofutangakuJohoNiModoru);
    }

    // </editor-fold>
}
