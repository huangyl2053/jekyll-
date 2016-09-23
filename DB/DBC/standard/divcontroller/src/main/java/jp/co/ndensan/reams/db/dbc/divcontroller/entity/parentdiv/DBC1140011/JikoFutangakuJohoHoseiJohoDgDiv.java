package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1140011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * JikoFutangakuJohoHoseiJohoDg のクラスファイル 
 * 
 * @author 自動生成
 */
public class JikoFutangakuJohoHoseiJohoDgDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("linLine1")
    private HorizontalLine linLine1;
    @JsonProperty("dgJohoIchiranPanel")
    private dgJohoIchiranPanelDiv dgJohoIchiranPanel;
    @JsonProperty("JikoFutangakuHoseiList")
    private JikoFutangakuHoseiListDiv JikoFutangakuHoseiList;
    @JsonProperty("KogakuGassanShikyuShinseiTorokuKaigoKihon")
    private KaigoShikakuKihonDiv KogakuGassanShikyuShinseiTorokuKaigoKihon;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
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
     * getdgJohoIchiranPanel
     * @return dgJohoIchiranPanel
     */
    @JsonProperty("dgJohoIchiranPanel")
    public dgJohoIchiranPanelDiv getDgJohoIchiranPanel() {
        return dgJohoIchiranPanel;
    }

    /*
     * setdgJohoIchiranPanel
     * @param dgJohoIchiranPanel dgJohoIchiranPanel
     */
    @JsonProperty("dgJohoIchiranPanel")
    public void setDgJohoIchiranPanel(dgJohoIchiranPanelDiv dgJohoIchiranPanel) {
        this.dgJohoIchiranPanel = dgJohoIchiranPanel;
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
     * getKogakuGassanShikyuShinseiTorokuKaigoKihon
     * @return KogakuGassanShikyuShinseiTorokuKaigoKihon
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuKaigoKihon")
    public IKaigoShikakuKihonDiv getKogakuGassanShikyuShinseiTorokuKaigoKihon() {
        return KogakuGassanShikyuShinseiTorokuKaigoKihon;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
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
        return this.getDgJohoIchiranPanel().getChkRirekiHyouji();
    }

    @JsonIgnore
    public void  setChkRirekiHyouji(CheckBoxList chkRirekiHyouji) {
        this.getDgJohoIchiranPanel().setChkRirekiHyouji(chkRirekiHyouji);
    }

    @JsonIgnore
    public DataGrid<dgJohoIchiran_Row> getDgJohoIchiran() {
        return this.getDgJohoIchiranPanel().getDgJohoIchiran();
    }

    @JsonIgnore
    public void  setDgJohoIchiran(DataGrid<dgJohoIchiran_Row> dgJohoIchiran) {
        this.getDgJohoIchiranPanel().setDgJohoIchiran(dgJohoIchiran);
    }

    @JsonIgnore
    public HorizontalLine getLin02() {
        return this.getJikoFutangakuHoseiList().getLin02();
    }

    @JsonIgnore
    public void  setLin02(HorizontalLine lin02) {
        this.getJikoFutangakuHoseiList().setLin02(lin02);
    }

    @JsonIgnore
    public JikoFutangakuHoseiDetailDiv getJikoFutangakuHoseiDetail() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail();
    }

    @JsonIgnore
    public void  setJikoFutangakuHoseiDetail(JikoFutangakuHoseiDetailDiv JikoFutangakuHoseiDetail) {
        this.getJikoFutangakuHoseiList().setJikoFutangakuHoseiDetail(JikoFutangakuHoseiDetail);
    }

    @JsonIgnore
    public TextBox getTxtSanteiKBN() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTxtSanteiKBN();
    }

    @JsonIgnore
    public void  setTxtSanteiKBN(TextBox txtSanteiKBN) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setTxtSanteiKBN(txtSanteiKBN);
    }

    @JsonIgnore
    public TextBoxDate getTxtTaishouNendo() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTxtTaishouNendo();
    }

    @JsonIgnore
    public void  setTxtTaishouNendo(TextBoxDate txtTaishouNendo) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setTxtTaishouNendo(txtTaishouNendo);
    }

    @JsonIgnore
    public TextBox getTxtShoukisaiHokenjaNO() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTxtShoukisaiHokenjaNO();
    }

    @JsonIgnore
    public void  setTxtShoukisaiHokenjaNO(TextBox txtShoukisaiHokenjaNO) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setTxtShoukisaiHokenjaNO(txtShoukisaiHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtShikyuShinseiSeiriNO() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTxtShikyuShinseiSeiriNO();
    }

    @JsonIgnore
    public void  setTxtShikyuShinseiSeiriNO(TextBox txtShikyuShinseiSeiriNO) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setTxtShikyuShinseiSeiriNO(txtShikyuShinseiSeiriNO);
    }

    @JsonIgnore
    public TextBoxDate getTxtUketoriYM() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTxtUketoriYM();
    }

    @JsonIgnore
    public void  setTxtUketoriYM(TextBoxDate txtUketoriYM) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setTxtUketoriYM(txtUketoriYM);
    }

    @JsonIgnore
    public CheckBoxList getChkSaisouKBN() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getChkSaisouKBN();
    }

    @JsonIgnore
    public void  setChkSaisouKBN(CheckBoxList chkSaisouKBN) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setChkSaisouKBN(chkSaisouKBN);
    }

    @JsonIgnore
    public CheckBoxList getChkSoufuTaishougai() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getChkSoufuTaishougai();
    }

    @JsonIgnore
    public void  setChkSoufuTaishougai(CheckBoxList chkSoufuTaishougai) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setChkSoufuTaishougai(chkSoufuTaishougai);
    }

    @JsonIgnore
    public TextBoxDate getTxtHoseibiKatsu() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTxtHoseibiKatsu();
    }

    @JsonIgnore
    public void  setTxtHoseibiKatsu(TextBoxDate txtHoseibiKatsu) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setTxtHoseibiKatsu(txtHoseibiKatsu);
    }

    @JsonIgnore
    public TextBoxDate getTxtHoseibiTan() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTxtHoseibiTan();
    }

    @JsonIgnore
    public void  setTxtHoseibiTan(TextBoxDate txtHoseibiTan) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setTxtHoseibiTan(txtHoseibiTan);
    }

    @JsonIgnore
    public HorizontalLine getLinLine2() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getLinLine2();
    }

    @JsonIgnore
    public void  setLinLine2(HorizontalLine linLine2) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setLinLine2(linLine2);
    }

    @JsonIgnore
    public tabJikofutanKanriJohoNyuryokuDiv getTabJikofutanKanriJohoNyuryoku() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku();
    }

    @JsonIgnore
    public void  setTabJikofutanKanriJohoNyuryoku(tabJikofutanKanriJohoNyuryokuDiv tabJikofutanKanriJohoNyuryoku) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setTabJikofutanKanriJohoNyuryoku(tabJikofutanKanriJohoNyuryoku);
    }

    @JsonIgnore
    public tplJikofutanKanriJoho1Div getTplJikofutanKanriJoho1() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1();
    }

    @JsonIgnore
    public void  setTplJikofutanKanriJoho1(tplJikofutanKanriJoho1Div tplJikofutanKanriJoho1) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().setTplJikofutanKanriJoho1(tplJikofutanKanriJoho1);
    }

    @JsonIgnore
    public TextBox getTxtIdouKBN() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtIdouKBN();
    }

    @JsonIgnore
    public void  setTxtIdouKBN(TextBox txtIdouKBN) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtIdouKBN(txtIdouKBN);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKBN() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getDdlShotokuKBN();
    }

    @JsonIgnore
    public void  setDdlShotokuKBN(DropDownList ddlShotokuKBN) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setDdlShotokuKBN(ddlShotokuKBN);
    }

    @JsonIgnore
    public DropDownList getDdl70SaiIjouShotokuKBN() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getDdl70SaiIjouShotokuKBN();
    }

    @JsonIgnore
    public void  setDdl70SaiIjouShotokuKBN(DropDownList ddl70SaiIjouShotokuKBN) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setDdl70SaiIjouShotokuKBN(ddl70SaiIjouShotokuKBN);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtHihokenshaShimei() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtHihokenshaShimei();
    }

    @JsonIgnore
    public void  setTxtHihokenshaShimei(TextBoxAtenaMeisho txtHihokenshaShimei) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtHihokenshaShimei(txtHihokenshaShimei);
    }

    @JsonIgnore
    public JikoFutangakuHoseiTotsugo1Div getJikoFutangakuHoseiTotsugo1() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1();
    }

    @JsonIgnore
    public void  setJikoFutangakuHoseiTotsugo1(JikoFutangakuHoseiTotsugo1Div JikoFutangakuHoseiTotsugo1) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setJikoFutangakuHoseiTotsugo1(JikoFutangakuHoseiTotsugo1);
    }

    @JsonIgnore
    public TextBox getTxtKoukiHokenjaNO() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().getTxtKoukiHokenjaNO();
    }

    @JsonIgnore
    public void  setTxtKoukiHokenjaNO(TextBox txtKoukiHokenjaNO) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().setTxtKoukiHokenjaNO(txtKoukiHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtKoukiHihokenshaNO() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().getTxtKoukiHihokenshaNO();
    }

    @JsonIgnore
    public void  setTxtKoukiHihokenshaNO(TextBox txtKoukiHihokenshaNO) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo1().setTxtKoukiHihokenshaNO(txtKoukiHihokenshaNO);
    }

    @JsonIgnore
    public JikoFutangakuHoseiTotsugo2Div getJikoFutangakuHoseiTotsugo2() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2();
    }

    @JsonIgnore
    public void  setJikoFutangakuHoseiTotsugo2(JikoFutangakuHoseiTotsugo2Div JikoFutangakuHoseiTotsugo2) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setJikoFutangakuHoseiTotsugo2(JikoFutangakuHoseiTotsugo2);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenjaNO() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHokenjaNO();
    }

    @JsonIgnore
    public void  setTxtKokuhoHokenjaNO(TextBox txtKokuhoHokenjaNO) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHokenjaNO(txtKokuhoHokenjaNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshaKojinNO() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHihokenshaKojinNO();
    }

    @JsonIgnore
    public void  setTxtKokuhoHihokenshaKojinNO(TextBox txtKokuhoHihokenshaKojinNO) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHihokenshaKojinNO(txtKokuhoHihokenshaKojinNO);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHihokenshashouNO() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().getTxtKokuhoHihokenshashouNO();
    }

    @JsonIgnore
    public void  setTxtKokuhoHihokenshashouNO(TextBox txtKokuhoHihokenshashouNO) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getJikoFutangakuHoseiTotsugo2().setTxtKokuhoHihokenshashouNO(txtKokuhoHihokenshashouNO);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishouKeisanKikan() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtTaishouKeisanKikan();
    }

    @JsonIgnore
    public void  setTxtTaishouKeisanKikan(TextBoxDateRange txtTaishouKeisanKikan) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtTaishouKeisanKikan(txtTaishouKeisanKikan);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtHihokenshaKikan() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().getTxtHihokenshaKikan();
    }

    @JsonIgnore
    public void  setTxtHihokenshaKikan(TextBoxDateRange txtHihokenshaKikan) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho1().setTxtHihokenshaKikan(txtHihokenshaKikan);
    }

    @JsonIgnore
    public tplJikofutanKanriJoho2Div getTplJikofutanKanriJoho2() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2();
    }

    @JsonIgnore
    public void  setTplJikofutanKanriJoho2(tplJikofutanKanriJoho2Div tplJikofutanKanriJoho2) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().setTplJikofutanKanriJoho2(tplJikofutanKanriJoho2);
    }

    @JsonIgnore
    public JikoFutangakuHoseiAtesakiDiv getJikoFutangakuHoseiAtesaki() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki();
    }

    @JsonIgnore
    public void  setJikoFutangakuHoseiAtesaki(JikoFutangakuHoseiAtesakiDiv JikoFutangakuHoseiAtesaki) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().setJikoFutangakuHoseiAtesaki(JikoFutangakuHoseiAtesaki);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtAtesakiShimei() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiShimei();
    }

    @JsonIgnore
    public void  setTxtAtesakiShimei(TextBoxAtenaMeisho txtAtesakiShimei) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiShimei(txtAtesakiShimei);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtAtesakiYubinNo() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiYubinNo();
    }

    @JsonIgnore
    public void  setTxtAtesakiYubinNo(TextBoxYubinNo txtAtesakiYubinNo) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiYubinNo(txtAtesakiYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtAtesakiJusho() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().getTxtAtesakiJusho();
    }

    @JsonIgnore
    public void  setTxtAtesakiJusho(TextBox txtAtesakiJusho) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiAtesaki().setTxtAtesakiJusho(txtAtesakiJusho);
    }

    @JsonIgnore
    public JikoFutangakuHoseiMadoguchiDiv getJikoFutangakuHoseiMadoguchi() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi();
    }

    @JsonIgnore
    public void  setJikoFutangakuHoseiMadoguchi(JikoFutangakuHoseiMadoguchiDiv JikoFutangakuHoseiMadoguchi) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().setJikoFutangakuHoseiMadoguchi(JikoFutangakuHoseiMadoguchi);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiTaishoushaHantei() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiTaishoushaHantei();
    }

    @JsonIgnore
    public void  setTxtMadoguchiTaishoushaHantei(TextBox txtMadoguchiTaishoushaHantei) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiTaishoushaHantei(txtMadoguchiTaishoushaHantei);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShiharaiBasho() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShiharaiBasho();
    }

    @JsonIgnore
    public void  setTxtMadoguchiShiharaiBasho(TextBox txtMadoguchiShiharaiBasho) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShiharaiBasho(txtMadoguchiShiharaiBasho);
    }

    @JsonIgnore
    public TextBoxDate getTxtMadoguchiKaishiYMD() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiYMD();
    }

    @JsonIgnore
    public void  setTxtMadoguchiKaishiYMD(TextBoxDate txtMadoguchiKaishiYMD) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiYMD(txtMadoguchiKaishiYMD);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiKaishiYoubi() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiYoubi();
    }

    @JsonIgnore
    public void  setTxtMadoguchiKaishiYoubi(TextBox txtMadoguchiKaishiYoubi) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiYoubi(txtMadoguchiKaishiYoubi);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiKaishiJikan() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiJikan();
    }

    @JsonIgnore
    public void  setTxtMadoguchiKaishiJikan(TextBox txtMadoguchiKaishiJikan) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiJikan(txtMadoguchiKaishiJikan);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiKaishiFun() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiKaishiFun();
    }

    @JsonIgnore
    public void  setTxtMadoguchiKaishiFun(TextBox txtMadoguchiKaishiFun) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiKaishiFun(txtMadoguchiKaishiFun);
    }

    @JsonIgnore
    public TextBoxDate getTxtMadoguchiShuryoYMD() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoYMD();
    }

    @JsonIgnore
    public void  setTxtMadoguchiShuryoYMD(TextBoxDate txtMadoguchiShuryoYMD) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoYMD(txtMadoguchiShuryoYMD);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShuryoYoubi() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoYoubi();
    }

    @JsonIgnore
    public void  setTxtMadoguchiShuryoYoubi(TextBox txtMadoguchiShuryoYoubi) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoYoubi(txtMadoguchiShuryoYoubi);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShuryoJikan() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoJikan();
    }

    @JsonIgnore
    public void  setTxtMadoguchiShuryoJikan(TextBox txtMadoguchiShuryoJikan) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoJikan(txtMadoguchiShuryoJikan);
    }

    @JsonIgnore
    public TextBox getTxtMadoguchiShuryoFun() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().getTxtMadoguchiShuryoFun();
    }

    @JsonIgnore
    public void  setTxtMadoguchiShuryoFun(TextBox txtMadoguchiShuryoFun) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getTabJikofutanKanriJohoNyuryoku().getTplJikofutanKanriJoho2().getJikoFutangakuHoseiMadoguchi().setTxtMadoguchiShuryoFun(txtMadoguchiShuryoFun);
    }

    @JsonIgnore
    public Button getBtnJikofutangakuJohoNyuryoku() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getBtnJikofutangakuJohoNyuryoku();
    }

    @JsonIgnore
    public void  setBtnJikofutangakuJohoNyuryoku(Button btnJikofutangakuJohoNyuryoku) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setBtnJikofutangakuJohoNyuryoku(btnJikofutangakuJohoNyuryoku);
    }

    @JsonIgnore
    public Button getBtnJikofutangakuJohoNiModoru() {
        return this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().getBtnJikofutangakuJohoNiModoru();
    }

    @JsonIgnore
    public void  setBtnJikofutangakuJohoNiModoru(Button btnJikofutangakuJohoNiModoru) {
        this.getJikoFutangakuHoseiList().getJikoFutangakuHoseiDetail().setBtnJikofutangakuJohoNiModoru(btnJikofutangakuJohoNiModoru);
    }

    // </editor-fold>
}
