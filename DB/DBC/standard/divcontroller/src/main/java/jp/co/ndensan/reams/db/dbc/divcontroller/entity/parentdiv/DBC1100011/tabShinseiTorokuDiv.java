package jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC1100011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.ShiharaiHohoJyoho.ShiharaiHohoJyoho.IShiharaiHohoJyohoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.Button;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGrid;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDateRange;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;

/**
 * tabShinseiToroku のクラスファイル
 *
 * @reamsid_L DBC-2040-030 huzongcheng
 */
public class tabShinseiTorokuDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabShinseiTorokuPanel1")
    private tabShinseiTorokuPanel1Div tabShinseiTorokuPanel1;
    @JsonProperty("tabShinseiTorokuPanel2")
    private tabShinseiTorokuPanel2Div tabShinseiTorokuPanel2;
    @JsonProperty("tabShinseiTorokuPanel3")
    private tabShinseiTorokuPanel3Div tabShinseiTorokuPanel3;
    @JsonProperty("tabShinseiTorokuPanel4")
    private tabShinseiTorokuPanel4Div tabShinseiTorokuPanel4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabShinseiTorokuPanel1
     * @return tabShinseiTorokuPanel1
     */
    @JsonProperty("tabShinseiTorokuPanel1")
    public tabShinseiTorokuPanel1Div getTabShinseiTorokuPanel1() {
        return tabShinseiTorokuPanel1;
    }

    /*
     * settabShinseiTorokuPanel1
     * @param tabShinseiTorokuPanel1 tabShinseiTorokuPanel1
     */
    @JsonProperty("tabShinseiTorokuPanel1")
    public void setTabShinseiTorokuPanel1(tabShinseiTorokuPanel1Div tabShinseiTorokuPanel1) {
        this.tabShinseiTorokuPanel1 = tabShinseiTorokuPanel1;
    }

    /*
     * gettabShinseiTorokuPanel2
     * @return tabShinseiTorokuPanel2
     */
    @JsonProperty("tabShinseiTorokuPanel2")
    public tabShinseiTorokuPanel2Div getTabShinseiTorokuPanel2() {
        return tabShinseiTorokuPanel2;
    }

    /*
     * settabShinseiTorokuPanel2
     * @param tabShinseiTorokuPanel2 tabShinseiTorokuPanel2
     */
    @JsonProperty("tabShinseiTorokuPanel2")
    public void setTabShinseiTorokuPanel2(tabShinseiTorokuPanel2Div tabShinseiTorokuPanel2) {
        this.tabShinseiTorokuPanel2 = tabShinseiTorokuPanel2;
    }

    /*
     * gettabShinseiTorokuPanel3
     * @return tabShinseiTorokuPanel3
     */
    @JsonProperty("tabShinseiTorokuPanel3")
    public tabShinseiTorokuPanel3Div getTabShinseiTorokuPanel3() {
        return tabShinseiTorokuPanel3;
    }

    /*
     * settabShinseiTorokuPanel3
     * @param tabShinseiTorokuPanel3 tabShinseiTorokuPanel3
     */
    @JsonProperty("tabShinseiTorokuPanel3")
    public void setTabShinseiTorokuPanel3(tabShinseiTorokuPanel3Div tabShinseiTorokuPanel3) {
        this.tabShinseiTorokuPanel3 = tabShinseiTorokuPanel3;
    }

    /*
     * gettabShinseiTorokuPanel4
     * @return tabShinseiTorokuPanel4
     */
    @JsonProperty("tabShinseiTorokuPanel4")
    public tabShinseiTorokuPanel4Div getTabShinseiTorokuPanel4() {
        return tabShinseiTorokuPanel4;
    }

    /*
     * settabShinseiTorokuPanel4
     * @param tabShinseiTorokuPanel4 tabShinseiTorokuPanel4
     */
    @JsonProperty("tabShinseiTorokuPanel4")
    public void setTabShinseiTorokuPanel4(tabShinseiTorokuPanel4Div tabShinseiTorokuPanel4) {
        this.tabShinseiTorokuPanel4 = tabShinseiTorokuPanel4;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KaigoShikakuDiv getKaigoShikaku() {
        return this.getTabShinseiTorokuPanel1().getKaigoShikaku();
    }

    @JsonIgnore
    public void setKaigoShikaku(KaigoShikakuDiv KaigoShikaku) {
        this.getTabShinseiTorokuPanel1().setKaigoShikaku(KaigoShikaku);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuKikanYMD() {
        return this.getTabShinseiTorokuPanel1().getKaigoShikaku().getTxtKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKanyuKikanYMD(TextBoxDateRange txtKanyuKikanYMD) {
        this.getTabShinseiTorokuPanel1().getKaigoShikaku().setTxtKanyuKikanYMD(txtKanyuKikanYMD);
    }

    @JsonIgnore
    public KaigoHihokenshaDiv getKaigoHihokensha() {
        return this.getTabShinseiTorokuPanel1().getKaigoHihokensha();
    }

    @JsonIgnore
    public void setKaigoHihokensha(KaigoHihokenshaDiv KaigoHihokensha) {
        this.getTabShinseiTorokuPanel1().setKaigoHihokensha(KaigoHihokensha);
    }

    @JsonIgnore
    public DropDownList getDdlShotokuKubun() {
        return this.getTabShinseiTorokuPanel1().getKaigoHihokensha().getDdlShotokuKubun();
    }

    @JsonIgnore
    public void setDdlShotokuKubun(DropDownList ddlShotokuKubun) {
        this.getTabShinseiTorokuPanel1().getKaigoHihokensha().setDdlShotokuKubun(ddlShotokuKubun);
    }

    @JsonIgnore
    public DropDownList getDdlOver70ShotokuKubun() {
        return this.getTabShinseiTorokuPanel1().getKaigoHihokensha().getDdlOver70ShotokuKubun();
    }

    @JsonIgnore
    public void setDdlOver70ShotokuKubun(DropDownList ddlOver70ShotokuKubun) {
        this.getTabShinseiTorokuPanel1().getKaigoHihokensha().setDdlOver70ShotokuKubun(ddlOver70ShotokuKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtShikakuSoshitsuYMD() {
        return this.getTabShinseiTorokuPanel1().getKaigoHihokensha().getTxtShikakuSoshitsuYMD();
    }

    @JsonIgnore
    public void setTxtShikakuSoshitsuYMD(TextBoxDate txtShikakuSoshitsuYMD) {
        this.getTabShinseiTorokuPanel1().getKaigoHihokensha().setTxtShikakuSoshitsuYMD(txtShikakuSoshitsuYMD);
    }

    @JsonIgnore
    public DropDownList getDdlShikakuSoshitsuJiyu() {
        return this.getTabShinseiTorokuPanel1().getKaigoHihokensha().getDdlShikakuSoshitsuJiyu();
    }

    @JsonIgnore
    public void setDdlShikakuSoshitsuJiyu(DropDownList ddlShikakuSoshitsuJiyu) {
        this.getTabShinseiTorokuPanel1().getKaigoHihokensha().setDdlShikakuSoshitsuJiyu(ddlShikakuSoshitsuJiyu);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTaishoKeisanKikanYMD() {
        return this.getTabShinseiTorokuPanel1().getKaigoHihokensha().getTxtTaishoKeisanKikanYMD();
    }

    @JsonIgnore
    public void setTxtTaishoKeisanKikanYMD(TextBoxDateRange txtTaishoKeisanKikanYMD) {
        this.getTabShinseiTorokuPanel1().getKaigoHihokensha().setTxtTaishoKeisanKikanYMD(txtTaishoKeisanKikanYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtBiko() {
        return this.getTabShinseiTorokuPanel1().getTxtBiko();
    }

    @JsonIgnore
    public void setTxtBiko(TextBoxMultiLine txtBiko) {
        this.getTabShinseiTorokuPanel1().setTxtBiko(txtBiko);
    }

    @JsonIgnore
    public KokuhoShikakuDiv getKokuhoShikaku() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikaku();
    }

    @JsonIgnore
    public void setKokuhoShikaku(KokuhoShikakuDiv KokuhoShikaku) {
        this.getTabShinseiTorokuPanel2().setKokuhoShikaku(KokuhoShikaku);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenshaNo() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHokenshaNo();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenshaNo(TextBox txtKokuhoHokenshaNo) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHokenshaNo(txtKokuhoHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHokenshaMeisho() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHokenshaMeisho();
    }

    @JsonIgnore
    public void setTxtKokuhoHokenshaMeisho(TextBox txtKokuhoHokenshaMeisho) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHokenshaMeisho(txtKokuhoHokenshaMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHikonenshaShoKigo() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHikonenshaShoKigo();
    }

    @JsonIgnore
    public void setTxtKokuhoHikonenshaShoKigo(TextBox txtKokuhoHikonenshaShoKigo) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHikonenshaShoKigo(txtKokuhoHikonenshaShoKigo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoHikonenshaShoNo() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoHikonenshaShoNo();
    }

    @JsonIgnore
    public void setTxtKokuhoHikonenshaShoNo(TextBox txtKokuhoHikonenshaShoNo) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoHikonenshaShoNo(txtKokuhoHikonenshaShoNo);
    }

    @JsonIgnore
    public TextBox getTxtKokuhoSetaiNo() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoSetaiNo();
    }

    @JsonIgnore
    public void setTxtKokuhoSetaiNo(TextBox txtKokuhoSetaiNo) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoSetaiNo(txtKokuhoSetaiNo);
    }

    @JsonIgnore
    public DropDownList getTxtKokuhoZokugara() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoZokugara();
    }

    @JsonIgnore
    public void setTxtKokuhoZokugara(DropDownList txtKokuhoZokugara) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoZokugara(txtKokuhoZokugara);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokuhoKanyuKikanYMD() {
        return this.getTabShinseiTorokuPanel2().getKokuhoShikaku().getTxtKokuhoKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKokuhoKanyuKikanYMD(TextBoxDateRange txtKokuhoKanyuKikanYMD) {
        this.getTabShinseiTorokuPanel2().getKokuhoShikaku().setTxtKokuhoKanyuKikanYMD(txtKokuhoKanyuKikanYMD);
    }

    @JsonIgnore
    public KokiShikakuDiv getKokiShikaku() {
        return this.getTabShinseiTorokuPanel2().getKokiShikaku();
    }

    @JsonIgnore
    public void setKokiShikaku(KokiShikakuDiv KokiShikaku) {
        this.getTabShinseiTorokuPanel2().setKokiShikaku(KokiShikaku);
    }

    @JsonIgnore
    public TextBox getTxtKokiHokenshaNo() {
        return this.getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiHokenshaNo();
    }

    @JsonIgnore
    public void setTxtKokiHokenshaNo(TextBox txtKokiHokenshaNo) {
        this.getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiHokenshaNo(txtKokiHokenshaNo);
    }

    @JsonIgnore
    public TextBox getTxtKokiKoikiRengoMeisho() {
        return this.getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiKoikiRengoMeisho();
    }

    @JsonIgnore
    public void setTxtKokiKoikiRengoMeisho(TextBox txtKokiKoikiRengoMeisho) {
        this.getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiKoikiRengoMeisho(txtKokiKoikiRengoMeisho);
    }

    @JsonIgnore
    public TextBox getTxtKokiHihokenshaNo() {
        return this.getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiHihokenshaNo();
    }

    @JsonIgnore
    public void setTxtKokiHihokenshaNo(TextBox txtKokiHihokenshaNo) {
        this.getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiHihokenshaNo(txtKokiHihokenshaNo);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKokiKanyuKikanYMD() {
        return this.getTabShinseiTorokuPanel2().getKokiShikaku().getTxtKokiKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKokiKanyuKikanYMD(TextBoxDateRange txtKokiKanyuKikanYMD) {
        this.getTabShinseiTorokuPanel2().getKokiShikaku().setTxtKokiKanyuKikanYMD(txtKokiKanyuKikanYMD);
    }

    @JsonIgnore
    public IShiharaiHohoJyohoDiv getCcdShiharaiHohoJoho() {
        return this.getTabShinseiTorokuPanel3().getCcdShiharaiHohoJoho();
    }

    @JsonIgnore
    public KanyuRirekiIchiranDiv getKanyuRirekiIchiran() {
        return this.getTabShinseiTorokuPanel4().getKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void setKanyuRirekiIchiran(KanyuRirekiIchiranDiv KanyuRirekiIchiran) {
        this.getTabShinseiTorokuPanel4().setKanyuRirekiIchiran(KanyuRirekiIchiran);
    }

    @JsonIgnore
    public Button getBtnAddKanyuRireki() {
        return this.getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().getBtnAddKanyuRireki();
    }

    @JsonIgnore
    public void setBtnAddKanyuRireki(Button btnAddKanyuRireki) {
        this.getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().setBtnAddKanyuRireki(btnAddKanyuRireki);
    }

    @JsonIgnore
    public DataGrid<dgKanyuRirekiIchiran_Row> getDgKanyuRirekiIchiran() {
        return this.getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().getDgKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void setDgKanyuRirekiIchiran(DataGrid<dgKanyuRirekiIchiran_Row> dgKanyuRirekiIchiran) {
        this.getTabShinseiTorokuPanel4().getKanyuRirekiIchiran().setDgKanyuRirekiIchiran(dgKanyuRirekiIchiran);
    }

    @JsonIgnore
    public KanyuRirekiInputDiv getKanyuRirekiInput() {
        return this.getTabShinseiTorokuPanel4().getKanyuRirekiInput();
    }

    @JsonIgnore
    public void setKanyuRirekiInput(KanyuRirekiInputDiv KanyuRirekiInput) {
        this.getTabShinseiTorokuPanel4().setKanyuRirekiInput(KanyuRirekiInput);
    }

    @JsonIgnore
    public TextBox getTxtKanyuRirekiHokenshaMei() {
        return this.getTabShinseiTorokuPanel4().getKanyuRirekiInput().getTxtKanyuRirekiHokenshaMei();
    }

    @JsonIgnore
    public void setTxtKanyuRirekiHokenshaMei(TextBox txtKanyuRirekiHokenshaMei) {
        this.getTabShinseiTorokuPanel4().getKanyuRirekiInput().setTxtKanyuRirekiHokenshaMei(txtKanyuRirekiHokenshaMei);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtKanyuRirekiKanyuKikanYMD() {
        return this.getTabShinseiTorokuPanel4().getKanyuRirekiInput().getTxtKanyuRirekiKanyuKikanYMD();
    }

    @JsonIgnore
    public void setTxtKanyuRirekiKanyuKikanYMD(TextBoxDateRange txtKanyuRirekiKanyuKikanYMD) {
        this.getTabShinseiTorokuPanel4().getKanyuRirekiInput().setTxtKanyuRirekiKanyuKikanYMD(txtKanyuRirekiKanyuKikanYMD);
    }

    @JsonIgnore
    public TextBox getTxtJikoFutangakuShomeishoSeiriBango() {
        return this.getTabShinseiTorokuPanel4().getKanyuRirekiInput().getTxtJikoFutangakuShomeishoSeiriBango();
    }

    @JsonIgnore
    public void setTxtJikoFutangakuShomeishoSeiriBango(TextBox txtJikoFutangakuShomeishoSeiriBango) {
        this.getTabShinseiTorokuPanel4().getKanyuRirekiInput().setTxtJikoFutangakuShomeishoSeiriBango(txtJikoFutangakuShomeishoSeiriBango);
    }

    @JsonIgnore
    public Button getBtnKakuteiKanyuRireki() {
        return this.getTabShinseiTorokuPanel4().getKanyuRirekiInput().getBtnKakuteiKanyuRireki();
    }

    @JsonIgnore
    public void setBtnKakuteiKanyuRireki(Button btnKakuteiKanyuRireki) {
        this.getTabShinseiTorokuPanel4().getKanyuRirekiInput().setBtnKakuteiKanyuRireki(btnKakuteiKanyuRireki);
    }

    @JsonIgnore
    public Button getBtnBackKanyuRirekiIchiran() {
        return this.getTabShinseiTorokuPanel4().getKanyuRirekiInput().getBtnBackKanyuRirekiIchiran();
    }

    @JsonIgnore
    public void setBtnBackKanyuRirekiIchiran(Button btnBackKanyuRirekiIchiran) {
        this.getTabShinseiTorokuPanel4().getKanyuRirekiInput().setBtnBackKanyuRirekiIchiran(btnBackKanyuRirekiIchiran);
    }

    // </editor-fold>
}
