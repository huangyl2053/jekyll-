package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.ShiharaiHohoJyohoDiv;
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
 * KogakuGassanShikyuShinseiTorokuAllPanel のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class KogakuGassanShikyuShinseiTorokuAllPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KogakuGassanShikyuShinseiInfo")
    private KogakuGassanShikyuShinseiInfoDiv KogakuGassanShikyuShinseiInfo;
    @JsonProperty("KogakuGassanShikyuShinseiToroku")
    private KogakuGassanShikyuShinseiTorokuDiv KogakuGassanShikyuShinseiToroku;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKogakuGassanShikyuShinseiInfo
     * @return KogakuGassanShikyuShinseiInfo
     */
    @JsonProperty("KogakuGassanShikyuShinseiInfo")
    public KogakuGassanShikyuShinseiInfoDiv getKogakuGassanShikyuShinseiInfo() {
        return KogakuGassanShikyuShinseiInfo;
    }

    /*
     * setKogakuGassanShikyuShinseiInfo
     * @param KogakuGassanShikyuShinseiInfo KogakuGassanShikyuShinseiInfo
     */
    @JsonProperty("KogakuGassanShikyuShinseiInfo")
    public void setKogakuGassanShikyuShinseiInfo(KogakuGassanShikyuShinseiInfoDiv KogakuGassanShikyuShinseiInfo) {
        this.KogakuGassanShikyuShinseiInfo = KogakuGassanShikyuShinseiInfo;
    }

    /*
     * getKogakuGassanShikyuShinseiToroku
     * @return KogakuGassanShikyuShinseiToroku
     */
    @JsonProperty("KogakuGassanShikyuShinseiToroku")
    public KogakuGassanShikyuShinseiTorokuDiv getKogakuGassanShikyuShinseiToroku() {
        return KogakuGassanShikyuShinseiToroku;
    }

    /*
     * setKogakuGassanShikyuShinseiToroku
     * @param KogakuGassanShikyuShinseiToroku KogakuGassanShikyuShinseiToroku
     */
    @JsonProperty("KogakuGassanShikyuShinseiToroku")
    public void setKogakuGassanShikyuShinseiToroku(KogakuGassanShikyuShinseiTorokuDiv KogakuGassanShikyuShinseiToroku) {
        this.KogakuGassanShikyuShinseiToroku = KogakuGassanShikyuShinseiToroku;
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
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtTeishutsuHokenshaNo() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtTeishutsuHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtTeishutsuHokenshaNo(TextBox txtTeishutsuHokenshaNo) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtTeishutsuHokenshaNo(txtTeishutsuHokenshaNo);
    }

    @JsonIgnore
    public DropDownList getDdlShokisaiHokenshaNo() {
        return this.getKogakuGassanShikyuShinseiInfo().getDdlShokisaiHokenshaNo();
    }

    @JsonIgnore
    public void  setDdlShokisaiHokenshaNo(DropDownList ddlShokisaiHokenshaNo) {
        this.getKogakuGassanShikyuShinseiInfo().setDdlShokisaiHokenshaNo(ddlShokisaiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango1() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtKaigoShikyuShinseishoSeiriBango1();
    }

    @JsonIgnore
    public void  setTxtKaigoShikyuShinseishoSeiriBango1(TextBox txtKaigoShikyuShinseishoSeiriBango1) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtKaigoShikyuShinseishoSeiriBango1(txtKaigoShikyuShinseishoSeiriBango1);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango2() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtKaigoShikyuShinseishoSeiriBango2();
    }

    @JsonIgnore
    public void  setTxtKaigoShikyuShinseishoSeiriBango2(TextBox txtKaigoShikyuShinseishoSeiriBango2) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtKaigoShikyuShinseishoSeiriBango2(txtKaigoShikyuShinseishoSeiriBango2);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango3() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtKaigoShikyuShinseishoSeiriBango3();
    }

    @JsonIgnore
    public void  setTxtKaigoShikyuShinseishoSeiriBango3(TextBox txtKaigoShikyuShinseishoSeiriBango3) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtKaigoShikyuShinseishoSeiriBango3(txtKaigoShikyuShinseishoSeiriBango3);
    }

    @JsonIgnore
    public TextBox getTxtKaigoShikyuShinseishoSeiriBango4() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtKaigoShikyuShinseishoSeiriBango4();
    }

    @JsonIgnore
    public void  setTxtKaigoShikyuShinseishoSeiriBango4(TextBox txtKaigoShikyuShinseishoSeiriBango4) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtKaigoShikyuShinseishoSeiriBango4(txtKaigoShikyuShinseishoSeiriBango4);
    }

    @JsonIgnore
    public TextBoxNum getTxtRirekiBango() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtRirekiBango();
    }

    @JsonIgnore
    public void  setTxtRirekiBango(TextBoxNum txtRirekiBango) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtRirekiBango(txtRirekiBango);
    }

    @JsonIgnore
    public DropDownList getDdlShinseiTaishoNendo() {
        return this.getKogakuGassanShikyuShinseiInfo().getDdlShinseiTaishoNendo();
    }

    @JsonIgnore
    public void  setDdlShinseiTaishoNendo(DropDownList ddlShinseiTaishoNendo) {
        this.getKogakuGassanShikyuShinseiInfo().setDdlShinseiTaishoNendo(ddlShinseiTaishoNendo);
    }

    @JsonIgnore
    public Space getSpc01() {
        return this.getKogakuGassanShikyuShinseiInfo().getSpc01();
    }

    @JsonIgnore
    public void  setSpc01(Space spc01) {
        this.getKogakuGassanShikyuShinseiInfo().setSpc01(spc01);
    }

    @JsonIgnore
    public TextBox getTxtIryoShikyuShinseishoSeiriBango1() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtIryoShikyuShinseishoSeiriBango1();
    }

    @JsonIgnore
    public void  setTxtIryoShikyuShinseishoSeiriBango1(TextBox txtIryoShikyuShinseishoSeiriBango1) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtIryoShikyuShinseishoSeiriBango1(txtIryoShikyuShinseishoSeiriBango1);
    }

    @JsonIgnore
    public TextBox getTxtIryoShikyuShinseishoSeiriBango2() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtIryoShikyuShinseishoSeiriBango2();
    }

    @JsonIgnore
    public void  setTxtIryoShikyuShinseishoSeiriBango2(TextBox txtIryoShikyuShinseishoSeiriBango2) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtIryoShikyuShinseishoSeiriBango2(txtIryoShikyuShinseishoSeiriBango2);
    }

    @JsonIgnore
    public TextBox getTxtIryoShikyuShinseishoSeiriBango3() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtIryoShikyuShinseishoSeiriBango3();
    }

    @JsonIgnore
    public void  setTxtIryoShikyuShinseishoSeiriBango3(TextBox txtIryoShikyuShinseishoSeiriBango3) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtIryoShikyuShinseishoSeiriBango3(txtIryoShikyuShinseishoSeiriBango3);
    }

    @JsonIgnore
    public TextBox getTxtIryoShikyuShinseishoSeiriBango4() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtIryoShikyuShinseishoSeiriBango4();
    }

    @JsonIgnore
    public void  setTxtIryoShikyuShinseishoSeiriBango4(TextBox txtIryoShikyuShinseishoSeiriBango4) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtIryoShikyuShinseishoSeiriBango4(txtIryoShikyuShinseishoSeiriBango4);
    }

    @JsonIgnore
    public TextBox getTxtShikyuShinseiKubun() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtShikyuShinseiKubun();
    }

    @JsonIgnore
    public void  setTxtShikyuShinseiKubun(TextBox txtShikyuShinseiKubun) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtShikyuShinseiKubun(txtShikyuShinseiKubun);
    }

    @JsonIgnore
    public DropDownList getDdlShikyuShinseiKeitai() {
        return this.getKogakuGassanShikyuShinseiInfo().getDdlShikyuShinseiKeitai();
    }

    @JsonIgnore
    public void  setDdlShikyuShinseiKeitai(DropDownList ddlShikyuShinseiKeitai) {
        this.getKogakuGassanShikyuShinseiInfo().setDdlShikyuShinseiKeitai(ddlShikyuShinseiKeitai);
    }

    @JsonIgnore
    public ShinseiDaihyoshaDiv getShinseiDaihyosha() {
        return this.getKogakuGassanShikyuShinseiInfo().getShinseiDaihyosha();
    }

    @JsonIgnore
    public void  setShinseiDaihyosha(ShinseiDaihyoshaDiv ShinseiDaihyosha) {
        this.getKogakuGassanShikyuShinseiInfo().setShinseiDaihyosha(ShinseiDaihyosha);
    }

    @JsonIgnore
    public TextBox getTxtDaihyoshaShimei() {
        return this.getKogakuGassanShikyuShinseiInfo().getShinseiDaihyosha().getTxtDaihyoshaShimei();
    }

    @JsonIgnore
    public void  setTxtDaihyoshaShimei(TextBox txtDaihyoshaShimei) {
        this.getKogakuGassanShikyuShinseiInfo().getShinseiDaihyosha().setTxtDaihyoshaShimei(txtDaihyoshaShimei);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDaihyoshaTelNo() {
        return this.getKogakuGassanShikyuShinseiInfo().getShinseiDaihyosha().getTxtDaihyoshaTelNo();
    }

    @JsonIgnore
    public void  setTxtDaihyoshaTelNo(TextBoxTelNo txtDaihyoshaTelNo) {
        this.getKogakuGassanShikyuShinseiInfo().getShinseiDaihyosha().setTxtDaihyoshaTelNo(txtDaihyoshaTelNo);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtDaihyoshaYubinNo() {
        return this.getKogakuGassanShikyuShinseiInfo().getShinseiDaihyosha().getTxtDaihyoshaYubinNo();
    }

    @JsonIgnore
    public void  setTxtDaihyoshaYubinNo(TextBoxYubinNo txtDaihyoshaYubinNo) {
        this.getKogakuGassanShikyuShinseiInfo().getShinseiDaihyosha().setTxtDaihyoshaYubinNo(txtDaihyoshaYubinNo);
    }

    @JsonIgnore
    public TextBox getTxtDaihyoshaJusho() {
        return this.getKogakuGassanShikyuShinseiInfo().getShinseiDaihyosha().getTxtDaihyoshaJusho();
    }

    @JsonIgnore
    public void  setTxtDaihyoshaJusho(TextBox txtDaihyoshaJusho) {
        this.getKogakuGassanShikyuShinseiInfo().getShinseiDaihyosha().setTxtDaihyoshaJusho(txtDaihyoshaJusho);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getKogakuGassanShikyuShinseiInfo().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getKogakuGassanShikyuShinseiInfo().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkKofuShinseiUmu() {
        return this.getKogakuGassanShikyuShinseiInfo().getChkKofuShinseiUmu();
    }

    @JsonIgnore
    public void  setChkKofuShinseiUmu(CheckBoxList chkKofuShinseiUmu) {
        this.getKogakuGassanShikyuShinseiInfo().setChkKofuShinseiUmu(chkKofuShinseiUmu);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getKogakuGassanShikyuShinseiInfo().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getKogakuGassanShikyuShinseiInfo().setLin1(lin1);
    }

    @JsonIgnore
    public Button getBtnAddShinsei() {
        return this.getKogakuGassanShikyuShinseiInfo().getBtnAddShinsei();
    }

    @JsonIgnore
    public void  setBtnAddShinsei(Button btnAddShinsei) {
        this.getKogakuGassanShikyuShinseiInfo().setBtnAddShinsei(btnAddShinsei);
    }

    @JsonIgnore
    public DataGrid<dgShinseiIchiran_Row> getDgShinseiIchiran() {
        return this.getKogakuGassanShikyuShinseiInfo().getDgShinseiIchiran();
    }

    @JsonIgnore
    public void  setDgShinseiIchiran(DataGrid<dgShinseiIchiran_Row> dgShinseiIchiran) {
        this.getKogakuGassanShikyuShinseiInfo().setDgShinseiIchiran(dgShinseiIchiran);
    }

    @JsonIgnore
    public HorizontalLine getLin2() {
        return this.getKogakuGassanShikyuShinseiToroku().getLin2();
    }

    @JsonIgnore
    public void  setLin2(HorizontalLine lin2) {
        this.getKogakuGassanShikyuShinseiToroku().setLin2(lin2);
    }

    @JsonIgnore
    public tabShinseiTorokuDiv getTabShinseiToroku() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku();
    }

    @JsonIgnore
    public void  setTabShinseiToroku(tabShinseiTorokuDiv tabShinseiToroku) {
        this.getKogakuGassanShikyuShinseiToroku().setTabShinseiToroku(tabShinseiToroku);
    }

    @JsonIgnore
    public tabShinseiTorokuPanel1Div getTabShinseiTorokuPanel1() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1();
    }

    @JsonIgnore
    public void  setTabShinseiTorokuPanel1(tabShinseiTorokuPanel1Div tabShinseiTorokuPanel1) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().setTabShinseiTorokuPanel1(tabShinseiTorokuPanel1);
    }

    @JsonIgnore
    public KaigoShikakuDiv getKaigoShikaku() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikaku();
    }

    @JsonIgnore
    public void  setKaigoShikaku(KaigoShikakuDiv KaigoShikaku) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().setKaigoShikaku(KaigoShikaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuKikanYMD() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikaku().getTxtKanyuKikanYMD();
    }

    @JsonIgnore
    public void  setTxtKanyuKikanYMD(TextBoxDateRange txtKanyuKikanYMD) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoShikaku().setTxtKanyuKikanYMD(txtKanyuKikanYMD);
    }

    @JsonIgnore
    public KaigoHihokenshaDiv getKaigoHihokensha() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha();
    }

    @JsonIgnore
    public void  setKaigoHihokensha(KaigoHihokenshaDiv KaigoHihokensha) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().setKaigoHihokensha(KaigoHihokensha);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKubun() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().getDdlShotokuKubun();
    }

    @JsonIgnore
    public void  setDdlShotokuKubun(DropDownList ddlShotokuKubun) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setDdlShotokuKubun(ddlShotokuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlOver70ShotokuKubun() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().getDdlOver70ShotokuKubun();
    }

    @JsonIgnore
    public void  setDdlOver70ShotokuKubun(DropDownList ddlOver70ShotokuKubun) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setDdlOver70ShotokuKubun(ddlOver70ShotokuKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMD() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().getTxtShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public void  setTxtShikakuSoshitsuYMD(TextBoxDate txtShikakuSoshitsuYMD) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setTxtShikakuSoshitsuYMD(txtShikakuSoshitsuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuSoshitsuJiyu() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().getDdlShikakuSoshitsuJiyu();
    }

    @JsonIgnore
    public void  setDdlShikakuSoshitsuJiyu(DropDownList ddlShikakuSoshitsuJiyu) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setDdlShikakuSoshitsuJiyu(ddlShikakuSoshitsuJiyu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoKeisanKikanYMD() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().getTxtTaishoKeisanKikanYMD();
    }

    @JsonIgnore
    public void  setTxtTaishoKeisanKikanYMD(TextBoxDateRange txtTaishoKeisanKikanYMD) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getKaigoHihokensha().setTxtTaishoKeisanKikanYMD(txtTaishoKeisanKikanYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().getTxtBiko();
    }

    @JsonIgnore
    public void  setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel1().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public tabShinseiTorokuPanel2Div getTabShinseiTorokuPanel2() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2();
    }

    @JsonIgnore
    public void  setTabShinseiTorokuPanel2(tabShinseiTorokuPanel2Div tabShinseiTorokuPanel2) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().setTabShinseiTorokuPanel2(tabShinseiTorokuPanel2);
    }

    @JsonIgnore
    public KokuhoShikakuDiv getKokuhoShikaku() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku();
    }

    @JsonIgnore
    public void  setKokuhoShikaku(KokuhoShikakuDiv KokuhoShikaku) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().setKokuhoShikaku(KokuhoShikaku);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenshaNo() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtKokuhoHokenshaNo(TextBox txtKokuhoHokenshaNo) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHokenshaNo(txtKokuhoHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenshaMeisho() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHokenshaMeisho();
    }

    @JsonIgnore
    public void  setTxtKokuhoHokenshaMeisho(TextBox txtKokuhoHokenshaMeisho) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHokenshaMeisho(txtKokuhoHokenshaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHikonenshaShoKigo() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHikonenshaShoKigo();
    }

    @JsonIgnore
    public void  setTxtKokuhoHikonenshaShoKigo(TextBox txtKokuhoHikonenshaShoKigo) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHikonenshaShoKigo(txtKokuhoHikonenshaShoKigo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHikonenshaShoNo() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHikonenshaShoNo();
    }

    @JsonIgnore
    public void  setTxtKokuhoHikonenshaShoNo(TextBox txtKokuhoHikonenshaShoNo) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHikonenshaShoNo(txtKokuhoHikonenshaShoNo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoSetaiNo() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoSetaiNo();
    }

    @JsonIgnore
    public void  setTxtKokuhoSetaiNo(TextBox txtKokuhoSetaiNo) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoSetaiNo(txtKokuhoSetaiNo);
    }

    @JsonIgnore
    public DropDownList getTxtKokuhoZokugara() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoZokugara();
    }

    @JsonIgnore
    public void  setTxtKokuhoZokugara(DropDownList txtKokuhoZokugara) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoZokugara(txtKokuhoZokugara);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhoKanyuKikanYMD() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoKanyuKikanYMD();
    }

    @JsonIgnore
    public void  setTxtKokuhoKanyuKikanYMD(TextBoxDateRange txtKokuhoKanyuKikanYMD) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoKanyuKikanYMD(txtKokuhoKanyuKikanYMD);
    }

    @JsonIgnore
    public KokiShikakuDiv getKokiShikaku() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku();
    }

    @JsonIgnore
    public void  setKokiShikaku(KokiShikakuDiv KokiShikaku) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().setKokiShikaku(KokiShikaku);
    }

    @JsonIgnore
    public TextBox getTxtKokiHokenshaNo() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiHokenshaNo();
    }

    @JsonIgnore
    public void  setTxtKokiHokenshaNo(TextBox txtKokiHokenshaNo) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiHokenshaNo(txtKokiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKokiKoikiRengoMeisho() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiKoikiRengoMeisho();
    }

    @JsonIgnore
    public void  setTxtKokiKoikiRengoMeisho(TextBox txtKokiKoikiRengoMeisho) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiKoikiRengoMeisho(txtKokiKoikiRengoMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKokiHihokenshaNo() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtKokiHihokenshaNo(TextBox txtKokiHihokenshaNo) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiHihokenshaNo(txtKokiHihokenshaNo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokiKanyuKikanYMD() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiKanyuKikanYMD();
    }

    @JsonIgnore
    public void  setTxtKokiKanyuKikanYMD(TextBoxDateRange txtKokiKanyuKikanYMD) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiKanyuKikanYMD(txtKokiKanyuKikanYMD);
    }

    @JsonIgnore
    public tabShinseiTorokuPanel3Div getTabShinseiTorokuPanel3() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel3();
    }

    @JsonIgnore
    public void  setTabShinseiTorokuPanel3(tabShinseiTorokuPanel3Div tabShinseiTorokuPanel3) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().setTabShinseiTorokuPanel3(tabShinseiTorokuPanel3);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJoho() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel3().getCcdShiharaiHohoJoho();
    }

    @JsonIgnore
    public tabShinseiTorokuPanel4Div getTabShinseiTorokuPanel4() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4();
    }

    @JsonIgnore
    public void  setTabShinseiTorokuPanel4(tabShinseiTorokuPanel4Div tabShinseiTorokuPanel4) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().setTabShinseiTorokuPanel4(tabShinseiTorokuPanel4);
    }

    @JsonIgnore
    public KanyuRirekiIchiranDiv getKanyuRirekiIchiran() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void  setKanyuRirekiIchiran(KanyuRirekiIchiranDiv KanyuRirekiIchiran) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().setKanyuRirekiIchiran(KanyuRirekiIchiran);
    }

    @JsonIgnore
    public Button getBtnAddKanyuRireki() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().getBtnAddKanyuRireki();
    }

    @JsonIgnore
    public void  setBtnAddKanyuRireki(Button btnAddKanyuRireki) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().setBtnAddKanyuRireki(btnAddKanyuRireki);
    }

    @JsonIgnore
    public DataGrid<dgKanyuRirekiIchiran_Row> getDgKanyuRirekiIchiran() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().getDgKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void  setDgKanyuRirekiIchiran(DataGrid<dgKanyuRirekiIchiran_Row> dgKanyuRirekiIchiran) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().setDgKanyuRirekiIchiran(dgKanyuRirekiIchiran);
    }

    @JsonIgnore
    public KanyuRirekiInputDiv getKanyuRirekiInput() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput();
    }

    @JsonIgnore
    public void  setKanyuRirekiInput(KanyuRirekiInputDiv KanyuRirekiInput) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().setKanyuRirekiInput(KanyuRirekiInput);
    }

    @JsonIgnore
    public TextBox getTxtKanyuRirekiHokenshaMei() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().getTxtKanyuRirekiHokenshaMei();
    }

    @JsonIgnore
    public void  setTxtKanyuRirekiHokenshaMei(TextBox txtKanyuRirekiHokenshaMei) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().setTxtKanyuRirekiHokenshaMei(txtKanyuRirekiHokenshaMei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuRirekiKanyuKikanYMD() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().getTxtKanyuRirekiKanyuKikanYMD();
    }

    @JsonIgnore
    public void  setTxtKanyuRirekiKanyuKikanYMD(TextBoxDateRange txtKanyuRirekiKanyuKikanYMD) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().setTxtKanyuRirekiKanyuKikanYMD(txtKanyuRirekiKanyuKikanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutangakuShomeishoSeiriBango() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().getTxtJikoFutangakuShomeishoSeiriBango();
    }

    @JsonIgnore
    public void  setTxtJikoFutangakuShomeishoSeiriBango(TextBox txtJikoFutangakuShomeishoSeiriBango) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().setTxtJikoFutangakuShomeishoSeiriBango(txtJikoFutangakuShomeishoSeiriBango);
    }

    @JsonIgnore
    public Button getBtnKakuteiKanyuRireki() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().getBtnKakuteiKanyuRireki();
    }

    @JsonIgnore
    public void  setBtnKakuteiKanyuRireki(Button btnKakuteiKanyuRireki) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().setBtnKakuteiKanyuRireki(btnKakuteiKanyuRireki);
    }

    @JsonIgnore
    public Button getBtnBackKanyuRirekiIchiran() {
        return this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().getBtnBackKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void  setBtnBackKanyuRirekiIchiran(Button btnBackKanyuRirekiIchiran) {
        this.getKogakuGassanShikyuShinseiToroku().getTabShinseiToroku().getTabShinseiTorokuPanel4().getKanyuRirekiInput().setBtnBackKanyuRirekiIchiran(btnBackKanyuRirekiIchiran);
    }

    @JsonIgnore
    public KogakuGassanShikyuShinseiTorokuFooterDiv getKogakuGassanShikyuShinseiTorokuFooter() {
        return this.getKogakuGassanShikyuShinseiToroku().getKogakuGassanShikyuShinseiTorokuFooter();
    }

    @JsonIgnore
    public void  setKogakuGassanShikyuShinseiTorokuFooter(KogakuGassanShikyuShinseiTorokuFooterDiv KogakuGassanShikyuShinseiTorokuFooter) {
        this.getKogakuGassanShikyuShinseiToroku().setKogakuGassanShikyuShinseiTorokuFooter(KogakuGassanShikyuShinseiTorokuFooter);
    }

    @JsonIgnore
    public Button getBtnKakuteiShintei() {
        return this.getKogakuGassanShikyuShinseiToroku().getKogakuGassanShikyuShinseiTorokuFooter().getBtnKakuteiShintei();
    }

    @JsonIgnore
    public void  setBtnKakuteiShintei(Button btnKakuteiShintei) {
        this.getKogakuGassanShikyuShinseiToroku().getKogakuGassanShikyuShinseiTorokuFooter().setBtnKakuteiShintei(btnKakuteiShintei);
    }

    @JsonIgnore
    public Button getBtnBackShinseiIchiran() {
        return this.getKogakuGassanShikyuShinseiToroku().getKogakuGassanShikyuShinseiTorokuFooter().getBtnBackShinseiIchiran();
    }

    @JsonIgnore
    public void  setBtnBackShinseiIchiran(Button btnBackShinseiIchiran) {
        this.getKogakuGassanShikyuShinseiToroku().getKogakuGassanShikyuShinseiTorokuFooter().setBtnBackShinseiIchiran(btnBackShinseiIchiran);
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoShikakuKihon() {
        return this.getKogakuGassanShikyuShinseiToroku().getCcdKaigoShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return this.getKogakuGassanShikyuShinseiToroku().getCcdKaigoAtenaInfo();
    }

    // </editor-fold>
}
