package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600031;
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
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KyufuJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("panelKyufuJoho")
    private panelKyufuJohoDiv panelKyufuJoho;
    @JsonProperty("ccdKaigoShikakuKihon")
    private KaigoShikakuKihonDiv ccdKaigoShikakuKihon;
    @JsonProperty("ccdKaigoatenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoatenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getpanelKyufuJoho
     * @return panelKyufuJoho
     */
    @JsonProperty("panelKyufuJoho")
    public panelKyufuJohoDiv getPanelKyufuJoho() {
        return panelKyufuJoho;
    }

    /*
     * setpanelKyufuJoho
     * @param panelKyufuJoho panelKyufuJoho
     */
    @JsonProperty("panelKyufuJoho")
    public void setPanelKyufuJoho(panelKyufuJohoDiv panelKyufuJoho) {
        this.panelKyufuJoho = panelKyufuJoho;
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
     * getccdKaigoatenaInfo
     * @return ccdKaigoatenaInfo
     */
    @JsonProperty("ccdKaigoatenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoatenaInfo() {
        return ccdKaigoatenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Button getBtnShikakuInfo() {
        return this.getPanelKyufuJoho().getBtnShikakuInfo();
    }

    @JsonIgnore
    public void  setBtnShikakuInfo(Button btnShikakuInfo) {
        this.getPanelKyufuJoho().setBtnShikakuInfo(btnShikakuInfo);
    }

    @JsonIgnore
    public Button getBtnJukyuInfo() {
        return this.getPanelKyufuJoho().getBtnJukyuInfo();
    }

    @JsonIgnore
    public void  setBtnJukyuInfo(Button btnJukyuInfo) {
        this.getPanelKyufuJoho().setBtnJukyuInfo(btnJukyuInfo);
    }

    @JsonIgnore
    public Button getBtnKyufuInfo() {
        return this.getPanelKyufuJoho().getBtnKyufuInfo();
    }

    @JsonIgnore
    public void  setBtnKyufuInfo(Button btnKyufuInfo) {
        this.getPanelKyufuJoho().setBtnKyufuInfo(btnKyufuInfo);
    }

    @JsonIgnore
    public Button getBtnFukaInfo() {
        return this.getPanelKyufuJoho().getBtnFukaInfo();
    }

    @JsonIgnore
    public void  setBtnFukaInfo(Button btnFukaInfo) {
        this.getPanelKyufuJoho().setBtnFukaInfo(btnFukaInfo);
    }

    @JsonIgnore
    public Button getBtnJuminInfo() {
        return this.getPanelKyufuJoho().getBtnJuminInfo();
    }

    @JsonIgnore
    public void  setBtnJuminInfo(Button btnJuminInfo) {
        this.getPanelKyufuJoho().setBtnJuminInfo(btnJuminInfo);
    }

    @JsonIgnore
    public Button getBtnKyotakuSabisu() {
        return this.getPanelKyufuJoho().getBtnKyotakuSabisu();
    }

    @JsonIgnore
    public void  setBtnKyotakuSabisu(Button btnKyotakuSabisu) {
        this.getPanelKyufuJoho().setBtnKyotakuSabisu(btnKyotakuSabisu);
    }

    @JsonIgnore
    public Button getBtnShoukanHaraiJoho() {
        return this.getPanelKyufuJoho().getBtnShoukanHaraiJoho();
    }

    @JsonIgnore
    public void  setBtnShoukanHaraiJoho(Button btnShoukanHaraiJoho) {
        this.getPanelKyufuJoho().setBtnShoukanHaraiJoho(btnShoukanHaraiJoho);
    }

    @JsonIgnore
    public Button getBtnKougakuSabisu() {
        return this.getPanelKyufuJoho().getBtnKougakuSabisu();
    }

    @JsonIgnore
    public void  setBtnKougakuSabisu(Button btnKougakuSabisu) {
        this.getPanelKyufuJoho().setBtnKougakuSabisu(btnKougakuSabisu);
    }

    @JsonIgnore
    public Button getBtnKyufuZisseki() {
        return this.getPanelKyufuJoho().getBtnKyufuZisseki();
    }

    @JsonIgnore
    public void  setBtnKyufuZisseki(Button btnKyufuZisseki) {
        this.getPanelKyufuJoho().setBtnKyufuZisseki(btnKyufuZisseki);
    }

    @JsonIgnore
    public panelKyotakuSabisuDiv getPanelKyotakuSabisu() {
        return this.getPanelKyufuJoho().getPanelKyotakuSabisu();
    }

    @JsonIgnore
    public void  setPanelKyotakuSabisu(panelKyotakuSabisuDiv panelKyotakuSabisu) {
        this.getPanelKyufuJoho().setPanelKyotakuSabisu(panelKyotakuSabisu);
    }

    @JsonIgnore
    public TextBoxDate getTxtTodokede() {
        return this.getPanelKyufuJoho().getPanelKyotakuSabisu().getTxtTodokede();
    }

    @JsonIgnore
    public void  setTxtTodokede(TextBoxDate txtTodokede) {
        this.getPanelKyufuJoho().getPanelKyotakuSabisu().setTxtTodokede(txtTodokede);
    }

    @JsonIgnore
    public TextBox getTxtKeikakuSakuseiKubun() {
        return this.getPanelKyufuJoho().getPanelKyotakuSabisu().getTxtKeikakuSakuseiKubun();
    }

    @JsonIgnore
    public void  setTxtKeikakuSakuseiKubun(TextBox txtKeikakuSakuseiKubun) {
        this.getPanelKyufuJoho().getPanelKyotakuSabisu().setTxtKeikakuSakuseiKubun(txtKeikakuSakuseiKubun);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTekyouKikan() {
        return this.getPanelKyufuJoho().getPanelKyotakuSabisu().getTxtTekyouKikan();
    }

    @JsonIgnore
    public void  setTxtTekyouKikan(TextBoxDateRange txtTekyouKikan) {
        this.getPanelKyufuJoho().getPanelKyotakuSabisu().setTxtTekyouKikan(txtTekyouKikan);
    }

    @JsonIgnore
    public TextBoxCode getTxtZigyoushaKodo() {
        return this.getPanelKyufuJoho().getPanelKyotakuSabisu().getTxtZigyoushaKodo();
    }

    @JsonIgnore
    public void  setTxtZigyoushaKodo(TextBoxCode txtZigyoushaKodo) {
        this.getPanelKyufuJoho().getPanelKyotakuSabisu().setTxtZigyoushaKodo(txtZigyoushaKodo);
    }

    @JsonIgnore
    public TextBox getTxtZigyoushaMesai() {
        return this.getPanelKyufuJoho().getPanelKyotakuSabisu().getTxtZigyoushaMesai();
    }

    @JsonIgnore
    public void  setTxtZigyoushaMesai(TextBox txtZigyoushaMesai) {
        this.getPanelKyufuJoho().getPanelKyotakuSabisu().setTxtZigyoushaMesai(txtZigyoushaMesai);
    }

    @JsonIgnore
    public panelShoukanBaraiDiv getPanelShoukanBarai() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai();
    }

    @JsonIgnore
    public void  setPanelShoukanBarai(panelShoukanBaraiDiv panelShoukanBarai) {
        this.getPanelKyufuJoho().setPanelShoukanBarai(panelShoukanBarai);
    }

    @JsonIgnore
    public panelHukushiYouguJohoDiv getPanelHukushiYouguJoho() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho();
    }

    @JsonIgnore
    public void  setPanelHukushiYouguJoho(panelHukushiYouguJohoDiv panelHukushiYouguJoho) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().setPanelHukushiYouguJoho(panelHukushiYouguJoho);
    }

    @JsonIgnore
    public Label getLabelMaeNando() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().getLabelMaeNando();
    }

    @JsonIgnore
    public void  setLabelMaeNando(Label labelMaeNando) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().setLabelMaeNando(labelMaeNando);
    }

    @JsonIgnore
    public TextBox getTxtMaeNando() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().getTxtMaeNando();
    }

    @JsonIgnore
    public void  setTxtMaeNando(TextBox txtMaeNando) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().setTxtMaeNando(txtMaeNando);
    }

    @JsonIgnore
    public TextBox getTxtMaeKingakuGoukei() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().getTxtMaeKingakuGoukei();
    }

    @JsonIgnore
    public void  setTxtMaeKingakuGoukei(TextBox txtMaeKingakuGoukei) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().setTxtMaeKingakuGoukei(txtMaeKingakuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtMaeSeikyukuGoukei() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().getTxtMaeSeikyukuGoukei();
    }

    @JsonIgnore
    public void  setTxtMaeSeikyukuGoukei(TextBox txtMaeSeikyukuGoukei) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().setTxtMaeSeikyukuGoukei(txtMaeSeikyukuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtMaeSeihutankuGoukei() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().getTxtMaeSeihutankuGoukei();
    }

    @JsonIgnore
    public void  setTxtMaeSeihutankuGoukei(TextBox txtMaeSeihutankuGoukei) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().setTxtMaeSeihutankuGoukei(txtMaeSeihutankuGoukei);
    }

    @JsonIgnore
    public Label getLabelKonNando() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().getLabelKonNando();
    }

    @JsonIgnore
    public void  setLabelKonNando(Label labelKonNando) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().setLabelKonNando(labelKonNando);
    }

    @JsonIgnore
    public TextBox getTxtKonNando() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().getTxtKonNando();
    }

    @JsonIgnore
    public void  setTxtKonNando(TextBox txtKonNando) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().setTxtKonNando(txtKonNando);
    }

    @JsonIgnore
    public TextBox getTxtKonKingakuGoukei() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().getTxtKonKingakuGoukei();
    }

    @JsonIgnore
    public void  setTxtKonKingakuGoukei(TextBox txtKonKingakuGoukei) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().setTxtKonKingakuGoukei(txtKonKingakuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtKonSeikyukuGoukei() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().getTxtKonSeikyukuGoukei();
    }

    @JsonIgnore
    public void  setTxtKonSeikyukuGoukei(TextBox txtKonSeikyukuGoukei) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().setTxtKonSeikyukuGoukei(txtKonSeikyukuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtKonSeihutankuGoukei() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().getTxtKonSeihutankuGoukei();
    }

    @JsonIgnore
    public void  setTxtKonSeihutankuGoukei(TextBox txtKonSeihutankuGoukei) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelHukushiYouguJoho().setTxtKonSeihutankuGoukei(txtKonSeihutankuGoukei);
    }

    @JsonIgnore
    public panelJuutakuKaishuuhiDiv getPanelJuutakuKaishuuhi() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelJuutakuKaishuuhi();
    }

    @JsonIgnore
    public void  setPanelJuutakuKaishuuhi(panelJuutakuKaishuuhiDiv panelJuutakuKaishuuhi) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().setPanelJuutakuKaishuuhi(panelJuutakuKaishuuhi);
    }

    @JsonIgnore
    public TextBox getTxtKaishuuHiyouGoukei() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelJuutakuKaishuuhi().getTxtKaishuuHiyouGoukei();
    }

    @JsonIgnore
    public void  setTxtKaishuuHiyouGoukei(TextBox txtKaishuuHiyouGoukei) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelJuutakuKaishuuhi().setTxtKaishuuHiyouGoukei(txtKaishuuHiyouGoukei);
    }

    @JsonIgnore
    public TextBox getTxtHokenSeikyuGakuGoukei() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelJuutakuKaishuuhi().getTxtHokenSeikyuGakuGoukei();
    }

    @JsonIgnore
    public void  setTxtHokenSeikyuGakuGoukei(TextBox txtHokenSeikyuGakuGoukei) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelJuutakuKaishuuhi().setTxtHokenSeikyuGakuGoukei(txtHokenSeikyuGakuGoukei);
    }

    @JsonIgnore
    public TextBox getTxtRiyoushaHutanGakuGoukei() {
        return this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelJuutakuKaishuuhi().getTxtRiyoushaHutanGakuGoukei();
    }

    @JsonIgnore
    public void  setTxtRiyoushaHutanGakuGoukei(TextBox txtRiyoushaHutanGakuGoukei) {
        this.getPanelKyufuJoho().getPanelShoukanBarai().getPanelJuutakuKaishuuhi().setTxtRiyoushaHutanGakuGoukei(txtRiyoushaHutanGakuGoukei);
    }

    @JsonIgnore
    public panelSabisuRiyouDiv getPanelSabisuRiyou() {
        return this.getPanelKyufuJoho().getPanelSabisuRiyou();
    }

    @JsonIgnore
    public void  setPanelSabisuRiyou(panelSabisuRiyouDiv panelSabisuRiyou) {
        this.getPanelKyufuJoho().setPanelSabisuRiyou(panelSabisuRiyou);
    }

    @JsonIgnore
    public TextBox getTxtSaishinSabisu() {
        return this.getPanelKyufuJoho().getPanelSabisuRiyou().getTxtSaishinSabisu();
    }

    @JsonIgnore
    public void  setTxtSaishinSabisu(TextBox txtSaishinSabisu) {
        this.getPanelKyufuJoho().getPanelSabisuRiyou().setTxtSaishinSabisu(txtSaishinSabisu);
    }

    // </editor-fold>
}
