package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.HorizontalLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * KogakuGassanShikyuShinseiToroku のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("lin2")
    private HorizontalLine lin2;
    @JsonProperty("tabShinseiToroku")
    private tabShinseiTorokuDiv tabShinseiToroku;
    @JsonProperty("KogakuGassanShikyuShinseiTorokuFooter")
    private KogakuGassanShikyuShinseiTorokuFooterDiv KogakuGassanShikyuShinseiTorokuFooter;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getlin2
     * @return lin2
     */
    @JsonProperty("lin2")
    public HorizontalLine getLin2() {
        return lin2;
    }

    /*
     * setlin2
     * @param lin2 lin2
     */
    @JsonProperty("lin2")
    public void setLin2(HorizontalLine lin2) {
        this.lin2 = lin2;
    }

    /*
     * gettabShinseiToroku
     * @return tabShinseiToroku
     */
    @JsonProperty("tabShinseiToroku")
    public tabShinseiTorokuDiv getTabShinseiToroku() {
        return tabShinseiToroku;
    }

    /*
     * settabShinseiToroku
     * @param tabShinseiToroku tabShinseiToroku
     */
    @JsonProperty("tabShinseiToroku")
    public void setTabShinseiToroku(tabShinseiTorokuDiv tabShinseiToroku) {
        this.tabShinseiToroku = tabShinseiToroku;
    }

    /*
     * getKogakuGassanShikyuShinseiTorokuFooter
     * @return KogakuGassanShikyuShinseiTorokuFooter
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuFooter")
    public KogakuGassanShikyuShinseiTorokuFooterDiv getKogakuGassanShikyuShinseiTorokuFooter() {
        return KogakuGassanShikyuShinseiTorokuFooter;
    }

    /*
     * setKogakuGassanShikyuShinseiTorokuFooter
     * @param KogakuGassanShikyuShinseiTorokuFooter KogakuGassanShikyuShinseiTorokuFooter
     */
    @JsonProperty("KogakuGassanShikyuShinseiTorokuFooter")
    public void setKogakuGassanShikyuShinseiTorokuFooter(KogakuGassanShikyuShinseiTorokuFooterDiv KogakuGassanShikyuShinseiTorokuFooter) {
        this.KogakuGassanShikyuShinseiTorokuFooter = KogakuGassanShikyuShinseiTorokuFooter;
    }

    /*
     * getccdKaigoShikakuKihon
     * @return ccdKaigoShikakuKihon
     */
    @JsonProperty("ccdKaigoShikakuKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return ccdKaigoShikakuKihon;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tabShinseiTorokuPanel1Div getTabShinseiTorokuPanel1() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel1(tabShinseiTorokuPanel1Div tabShinseiTorokuPanel1) {
        this.getTabShinseiToroku().setTabShinseiTorokuPanel1(tabShinseiTorokuPanel1);
    }

    @JsonIgnore
    public KaigoShikakuDiv getKaigoShikaku() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikaku();
    }

    @JsonIgnore
    public void setKaigoShikaku(KaigoShikakuDiv KaigoShikaku) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().setKaigoShikaku(KaigoShikaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuKikanYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikaku().getTxtKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKanyuKikanYMD(TextBoxDateRange txtKanyuKikanYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikaku().setTxtKanyuKikanYMD(txtKanyuKikanYMD);
    }

    @JsonIgnore
    public KaigoHihokenshaDiv getKaigoHihokensha() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha();
    }

    @JsonIgnore
    public void setKaigoHihokensha(KaigoHihokenshaDiv KaigoHihokensha) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().setKaigoHihokensha(KaigoHihokensha);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKubun() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().getDdlShotokuKubun();
    }

    @JsonIgnore
    public void setDdlShotokuKubun(DropDownList ddlShotokuKubun) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setDdlShotokuKubun(ddlShotokuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlOver70ShotokuKubun() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().getDdlOver70ShotokuKubun();
    }

    @JsonIgnore
    public void setDdlOver70ShotokuKubun(DropDownList ddlOver70ShotokuKubun) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setDdlOver70ShotokuKubun(ddlOver70ShotokuKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().getTxtShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public void setTxtShikakuSoshitsuYMD(TextBoxDate txtShikakuSoshitsuYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setTxtShikakuSoshitsuYMD(txtShikakuSoshitsuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuSoshitsuJiyu() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().getDdlShikakuSoshitsuJiyu();
    }

    @JsonIgnore
    public void setDdlShikakuSoshitsuJiyu(DropDownList ddlShikakuSoshitsuJiyu) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setDdlShikakuSoshitsuJiyu(ddlShikakuSoshitsuJiyu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoKeisanKikanYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().getTxtTaishoKeisanKikanYMD();
    }

    @JsonIgnore
    public void setTxtTaishoKeisanKikanYMD(TextBoxDateRange txtTaishoKeisanKikanYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setTxtTaishoKeisanKikanYMD(txtTaishoKeisanKikanYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel1().getTxtBiko();
    }

    @JsonIgnore
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel1().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public tabShinseiTorokuPanel2Div getTabShinseiTorokuPanel2() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel2(tabShinseiTorokuPanel2Div tabShinseiTorokuPanel2) {
        this.getTabShinseiToroku().setTabShinseiTorokuPanel2(tabShinseiTorokuPanel2);
    }

    @JsonIgnore
    public KokuhoShikakuDiv getKokuhoShikaku() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku();
    }

    @JsonIgnore
    public void setKokuhoShikaku(KokuhoShikakuDiv KokuhoShikaku) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().setKokuhoShikaku(KokuhoShikaku);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenshaNo() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHokenshaNo();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenshaNo(TextBox txtKokuhoHokenshaNo) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHokenshaNo(txtKokuhoHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenshaMeisho() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHokenshaMeisho();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenshaMeisho(TextBox txtKokuhoHokenshaMeisho) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHokenshaMeisho(txtKokuhoHokenshaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHikonenshaShoKigo() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHikonenshaShoKigo();
    }

    @JsonIgnore
    public void setTxtKokuhoHikonenshaShoKigo(TextBox txtKokuhoHikonenshaShoKigo) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHikonenshaShoKigo(txtKokuhoHikonenshaShoKigo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHikonenshaShoNo() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHikonenshaShoNo();
    }

    @JsonIgnore
    public void setTxtKokuhoHikonenshaShoNo(TextBox txtKokuhoHikonenshaShoNo) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHikonenshaShoNo(txtKokuhoHikonenshaShoNo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoSetaiNo() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoSetaiNo();
    }

    @JsonIgnore
    public void setTxtKokuhoSetaiNo(TextBox txtKokuhoSetaiNo) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoSetaiNo(txtKokuhoSetaiNo);
    }

    @JsonIgnore
    public DropDownList getTxtKokuhoZokugara() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoZokugara();
    }

    @JsonIgnore
    public void setTxtKokuhoZokugara(DropDownList txtKokuhoZokugara) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoZokugara(txtKokuhoZokugara);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhoKanyuKikanYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKokuhoKanyuKikanYMD(TextBoxDateRange txtKokuhoKanyuKikanYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoKanyuKikanYMD(txtKokuhoKanyuKikanYMD);
    }

    @JsonIgnore
    public KokiShikakuDiv getKokiShikaku() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku();
    }

    @JsonIgnore
    public void setKokiShikaku(KokiShikakuDiv KokiShikaku) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().setKokiShikaku(KokiShikaku);
    }

    @JsonIgnore
    public TextBox getTxtKokiHokenshaNo() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiHokenshaNo();
    }

    @JsonIgnore
    public void setTxtKokiHokenshaNo(TextBox txtKokiHokenshaNo) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiHokenshaNo(txtKokiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKokiKoikiRengoMeisho() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiKoikiRengoMeisho();
    }

    @JsonIgnore
    public void setTxtKokiKoikiRengoMeisho(TextBox txtKokiKoikiRengoMeisho) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiKoikiRengoMeisho(txtKokiKoikiRengoMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKokiHihokenshaNo() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtKokiHihokenshaNo(TextBox txtKokiHihokenshaNo) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiHihokenshaNo(txtKokiHihokenshaNo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokiKanyuKikanYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKokiKanyuKikanYMD(TextBoxDateRange txtKokiKanyuKikanYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiKanyuKikanYMD(txtKokiKanyuKikanYMD);
    }

    @JsonIgnore
    public tabShinseiTorokuPanel3Div getTabShinseiTorokuPanel3() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel3();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel3(tabShinseiTorokuPanel3Div tabShinseiTorokuPanel3) {
        this.getTabShinseiToroku().setTabShinseiTorokuPanel3(tabShinseiTorokuPanel3);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJoho() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel3().getCcdShiharaiHohoJoho();
    }

    @JsonIgnore
    public tabShinseiTorokuPanel4Div getTabShinseiTorokuPanel4() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4();
    }

    @JsonIgnore
    public void setTabShinseiTorokuPanel4(tabShinseiTorokuPanel4Div tabShinseiTorokuPanel4) {
        this.getTabShinseiToroku().setTabShinseiTorokuPanel4(tabShinseiTorokuPanel4);
    }

    @JsonIgnore
    public KanyuRirekiIchiranDiv getKanyuRirekiIchiran() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void setKanyuRirekiIchiran(KanyuRirekiIchiranDiv KanyuRirekiIchiran) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().setKanyuRirekiIchiran(KanyuRirekiIchiran);
    }

    @JsonIgnore
    public Button getBtnAddKanyuRireki() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().getBtnAddKanyuRireki();
    }

    @JsonIgnore
    public void setBtnAddKanyuRireki(Button btnAddKanyuRireki) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().setBtnAddKanyuRireki(btnAddKanyuRireki);
    }

    @JsonIgnore
    public DataGrid<dgKanyuRirekiIchiran_Row> getDgKanyuRirekiIchiran() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().getDgKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void setDgKanyuRirekiIchiran(DataGrid<dgKanyuRirekiIchiran_Row> dgKanyuRirekiIchiran) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().setDgKanyuRirekiIchiran(dgKanyuRirekiIchiran);
    }

    @JsonIgnore
    public KanyuRirekiInputDiv getKanyuRirekiInput() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput();
    }

    @JsonIgnore
    public void setKanyuRirekiInput(KanyuRirekiInputDiv KanyuRirekiInput) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().setKanyuRirekiInput(KanyuRirekiInput);
    }

    @JsonIgnore
    public TextBox getTxtKanyuRirekiHokenshaMei() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().getTxtKanyuRirekiHokenshaMei();
    }

    @JsonIgnore
    public void setTxtKanyuRirekiHokenshaMei(TextBox txtKanyuRirekiHokenshaMei) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().setTxtKanyuRirekiHokenshaMei(txtKanyuRirekiHokenshaMei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuRirekiKanyuKikanYMD() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().getTxtKanyuRirekiKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKanyuRirekiKanyuKikanYMD(TextBoxDateRange txtKanyuRirekiKanyuKikanYMD) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().setTxtKanyuRirekiKanyuKikanYMD(txtKanyuRirekiKanyuKikanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutangakuShomeishoSeiriBango() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().getTxtJikoFutangakuShomeishoSeiriBango();
    }

    @JsonIgnore
    public void setTxtJikoFutangakuShomeishoSeiriBango(TextBox txtJikoFutangakuShomeishoSeiriBango) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().setTxtJikoFutangakuShomeishoSeiriBango(txtJikoFutangakuShomeishoSeiriBango);
    }

    @JsonIgnore
    public Button getBtnKakuteiKanyuRireki() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().getBtnKakuteiKanyuRireki();
    }

    @JsonIgnore
    public void setBtnKakuteiKanyuRireki(Button btnKakuteiKanyuRireki) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().setBtnKakuteiKanyuRireki(btnKakuteiKanyuRireki);
    }

    @JsonIgnore
    public Button getBtnBackKanyuRirekiIchiran() {
        return this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().getBtnBackKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void setBtnBackKanyuRirekiIchiran(Button btnBackKanyuRirekiIchiran) {
        this.getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().setBtnBackKanyuRirekiIchiran(btnBackKanyuRirekiIchiran);
    }

    @JsonIgnore
    public Button getBtnKakuteiShintei() {
        return this.getKogakuGassanShikyuShinseiTorokuFooter().getBtnKakuteiShintei();
    }

    @JsonIgnore
    public void setBtnKakuteiShintei(Button btnKakuteiShintei) {
        this.getKogakuGassanShikyuShinseiTorokuFooter().setBtnKakuteiShintei(btnKakuteiShintei);
    }

    @JsonIgnore
    public Button getBtnBackShinseiIchiran() {
        return this.getKogakuGassanShikyuShinseiTorokuFooter().getBtnBackShinseiIchiran();
    }

    @JsonIgnore
    public void setBtnBackShinseiIchiran(Button btnBackShinseiIchiran) {
        this.getKogakuGassanShikyuShinseiTorokuFooter().setBtnBackShinseiIchiran(btnBackShinseiIchiran);
    }

    // </editor-fold>
}
