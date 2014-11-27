package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.IKyufuhiKashitsukekinInfoDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukeShinseiHoshoninDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukeShinseiServiceDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukeShinseiTeishutsuDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukeShinseishaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukekinHenkoKariukeDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukekinHenkoKetteiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukekinKariukeHoshoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukekinKariukeninDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.KashitsukekinKetteiShoninDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tabKashitsukekinInfoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKashitsukekinHenkoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKashitsukekinKariukeDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKashitsukekinKetteiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKashitsukekinKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKashitsukekinShinseiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KyufuhiKashitsukekinInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class KyufuhiKashitsukekinInfoDiv extends Panel implements IKyufuhiKashitsukekinInfoDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabKashitsukekinInfo")
    private tabKashitsukekinInfoDiv tabKashitsukekinInfo;
    @JsonProperty("btnClose")
    private Button btnClose;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tabKashitsukekinInfo")
    public tabKashitsukekinInfoDiv getTabKashitsukekinInfo() {
        return tabKashitsukekinInfo;
    }

    @JsonProperty("tabKashitsukekinInfo")
    public void setTabKashitsukekinInfo(tabKashitsukekinInfoDiv tabKashitsukekinInfo) {
        this.tabKashitsukekinInfo=tabKashitsukekinInfo;
    }

    @JsonProperty("btnClose")
    public Button getBtnClose() {
        return btnClose;
    }

    @JsonProperty("btnClose")
    public void setBtnClose(Button btnClose) {
        this.btnClose=btnClose;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tplKashitsukekinShinseiDiv getTplKashitsukekinShinsei() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei();
    }

    @JsonIgnore
    public void  setTplKashitsukekinShinsei(tplKashitsukekinShinseiDiv tplKashitsukekinShinsei) {
        this.getTabKashitsukekinInfo().setTplKashitsukekinShinsei(tplKashitsukekinShinsei);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtRiyoKikan() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().getTxtRiyoKikan();
    }

    @JsonIgnore
    public void  setTxtRiyoKikan(TextBoxDateRange txtRiyoKikan) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().setTxtRiyoKikan(txtRiyoKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikyugaku() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().getTxtSeikyugaku();
    }

    @JsonIgnore
    public void  setTxtSeikyugaku(TextBoxNum txtSeikyugaku) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().setTxtSeikyugaku(txtSeikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShinseiKingaku() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().getTxtShinseiKingaku();
    }

    @JsonIgnore
    public void  setTxtShinseiKingaku(TextBoxNum txtShinseiKingaku) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().setTxtShinseiKingaku(txtShinseiKingaku);
    }

    @JsonIgnore
    public KashitsukeShinseiServiceDiv getKashitsukeShinseiService() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().getKashitsukeShinseiService();
    }

    @JsonIgnore
    public void  setKashitsukeShinseiService(KashitsukeShinseiServiceDiv KashitsukeShinseiService) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().setKashitsukeShinseiService(KashitsukeShinseiService);
    }

    @JsonIgnore
    public KashitsukeShinseishaDiv getKashitsukeShinseisha() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().getKashitsukeShinseisha();
    }

    @JsonIgnore
    public void  setKashitsukeShinseisha(KashitsukeShinseishaDiv KashitsukeShinseisha) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().setKashitsukeShinseisha(KashitsukeShinseisha);
    }

    @JsonIgnore
    public KashitsukeShinseiHoshoninDiv getKashitsukeShinseiHoshonin() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().getKashitsukeShinseiHoshonin();
    }

    @JsonIgnore
    public void  setKashitsukeShinseiHoshonin(KashitsukeShinseiHoshoninDiv KashitsukeShinseiHoshonin) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().setKashitsukeShinseiHoshonin(KashitsukeShinseiHoshonin);
    }

    @JsonIgnore
    public KashitsukeShinseiTeishutsuDiv getKashitsukeShinseiTeishutsu() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().getKashitsukeShinseiTeishutsu();
    }

    @JsonIgnore
    public void  setKashitsukeShinseiTeishutsu(KashitsukeShinseiTeishutsuDiv KashitsukeShinseiTeishutsu) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinShinsei().setKashitsukeShinseiTeishutsu(KashitsukeShinseiTeishutsu);
    }

    @JsonIgnore
    public tplKashitsukekinKetteiDiv getTplKashitsukekinKettei() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKettei();
    }

    @JsonIgnore
    public void  setTplKashitsukekinKettei(tplKashitsukekinKetteiDiv tplKashitsukekinKettei) {
        this.getTabKashitsukekinInfo().setTplKashitsukekinKettei(tplKashitsukekinKettei);
    }

    @JsonIgnore
    public TextBox getTxtKetteiShoninKubun() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKettei().getTxtKetteiShoninKubun();
    }

    @JsonIgnore
    public void  setTxtKetteiShoninKubun(TextBox txtKetteiShoninKubun) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKettei().setTxtKetteiShoninKubun(txtKetteiShoninKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKettei().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKettei().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public KashitsukekinKetteiShoninDiv getKashitsukekinKetteiShonin() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKettei().getKashitsukekinKetteiShonin();
    }

    @JsonIgnore
    public void  setKashitsukekinKetteiShonin(KashitsukekinKetteiShoninDiv KashitsukekinKetteiShonin) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKettei().setKashitsukekinKetteiShonin(KashitsukekinKetteiShonin);
    }

    @JsonIgnore
    public TextBox getTxtKetteiFushoninRiyu() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKettei().getTxtKetteiFushoninRiyu();
    }

    @JsonIgnore
    public void  setTxtKetteiFushoninRiyu(TextBox txtKetteiFushoninRiyu) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKettei().setTxtKetteiFushoninRiyu(txtKetteiFushoninRiyu);
    }

    @JsonIgnore
    public tplKashitsukekinKariukeDiv getTplKashitsukekinKariuke() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKariuke();
    }

    @JsonIgnore
    public void  setTplKashitsukekinKariuke(tplKashitsukekinKariukeDiv tplKashitsukekinKariuke) {
        this.getTabKashitsukekinInfo().setTplKashitsukekinKariuke(tplKashitsukekinKariuke);
    }

    @JsonIgnore
    public TextBoxDate getTxtKariukeYMD() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKariuke().getTxtKariukeYMD();
    }

    @JsonIgnore
    public void  setTxtKariukeYMD(TextBoxDate txtKariukeYMD) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKariuke().setTxtKariukeYMD(txtKariukeYMD);
    }

    @JsonIgnore
    public KashitsukekinKariukeninDiv getKashitsukekinKariukenin() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKariuke().getKashitsukekinKariukenin();
    }

    @JsonIgnore
    public void  setKashitsukekinKariukenin(KashitsukekinKariukeninDiv KashitsukekinKariukenin) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKariuke().setKashitsukekinKariukenin(KashitsukekinKariukenin);
    }

    @JsonIgnore
    public KashitsukekinKariukeHoshoDiv getKashitsukekinKariukeHosho() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKariuke().getKashitsukekinKariukeHosho();
    }

    @JsonIgnore
    public void  setKashitsukekinKariukeHosho(KashitsukekinKariukeHoshoDiv KashitsukekinKariukeHosho) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKariuke().setKashitsukekinKariukeHosho(KashitsukekinKariukeHosho);
    }

    @JsonIgnore
    public tplKashitsukekinHenkoDiv getTplKashitsukekinHenko() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinHenko();
    }

    @JsonIgnore
    public void  setTplKashitsukekinHenko(tplKashitsukekinHenkoDiv tplKashitsukekinHenko) {
        this.getTabKashitsukekinInfo().setTplKashitsukekinHenko(tplKashitsukekinHenko);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnchoShinseiYMD() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().getTxtEnchoShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtEnchoShinseiYMD(TextBoxDate txtEnchoShinseiYMD) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().setTxtEnchoShinseiYMD(txtEnchoShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtEnchoKikan() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().getTxtEnchoKikan();
    }

    @JsonIgnore
    public void  setTxtEnchoKikan(TextBoxDateRange txtEnchoKikan) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().setTxtEnchoKikan(txtEnchoKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtMishokanKingaku() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().getTxtMishokanKingaku();
    }

    @JsonIgnore
    public void  setTxtMishokanKingaku(TextBoxNum txtMishokanKingaku) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().setTxtMishokanKingaku(txtMishokanKingaku);
    }

    @JsonIgnore
    public TextBox getTxtEnchoRiyu() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().getTxtEnchoRiyu();
    }

    @JsonIgnore
    public void  setTxtEnchoRiyu(TextBox txtEnchoRiyu) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().setTxtEnchoRiyu(txtEnchoRiyu);
    }

    @JsonIgnore
    public KashitsukekinHenkoKariukeDiv getKashitsukekinHenkoKariuke() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().getKashitsukekinHenkoKariuke();
    }

    @JsonIgnore
    public void  setKashitsukekinHenkoKariuke(KashitsukekinHenkoKariukeDiv KashitsukekinHenkoKariuke) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().setKashitsukekinHenkoKariuke(KashitsukekinHenkoKariuke);
    }

    @JsonIgnore
    public KashitsukekinHenkoKetteiDiv getKashitsukekinHenkoKettei() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().getKashitsukekinHenkoKettei();
    }

    @JsonIgnore
    public void  setKashitsukekinHenkoKettei(KashitsukekinHenkoKetteiDiv KashitsukekinHenkoKettei) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinHenko().setKashitsukekinHenkoKettei(KashitsukekinHenkoKettei);
    }

    @JsonIgnore
    public tplKashitsukekinKozaDiv getTplKashitsukekinKoza() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKoza();
    }

    @JsonIgnore
    public void  setTplKashitsukekinKoza(tplKashitsukekinKozaDiv tplKashitsukekinKoza) {
        this.getTabKashitsukekinInfo().setTplKashitsukekinKoza(tplKashitsukekinKoza);
    }

    @JsonIgnore
    public TextBoxCode getTxtKojinKinyuKikanCode() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().getTxtKojinKinyuKikanCode();
    }

    @JsonIgnore
    public void  setTxtKojinKinyuKikanCode(TextBoxCode txtKojinKinyuKikanCode) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().setTxtKojinKinyuKikanCode(txtKojinKinyuKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtKojinKinyuKikanName() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().getTxtKojinKinyuKikanName();
    }

    @JsonIgnore
    public void  setTxtKojinKinyuKikanName(TextBox txtKojinKinyuKikanName) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().setTxtKojinKinyuKikanName(txtKojinKinyuKikanName);
    }

    @JsonIgnore
    public TextBox getTxtKojinKozaShubetsu() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().getTxtKojinKozaShubetsu();
    }

    @JsonIgnore
    public void  setTxtKojinKozaShubetsu(TextBox txtKojinKozaShubetsu) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().setTxtKojinKozaShubetsu(txtKojinKozaShubetsu);
    }

    @JsonIgnore
    public TextBoxKana getTxtKojinMeigininName() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().getTxtKojinMeigininName();
    }

    @JsonIgnore
    public void  setTxtKojinMeigininName(TextBoxKana txtKojinMeigininName) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().setTxtKojinMeigininName(txtKojinMeigininName);
    }

    @JsonIgnore
    public TextBoxCode getTxtKojinShitenCode() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().getTxtKojinShitenCode();
    }

    @JsonIgnore
    public void  setTxtKojinShitenCode(TextBoxCode txtKojinShitenCode) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().setTxtKojinShitenCode(txtKojinShitenCode);
    }

    @JsonIgnore
    public TextBox getTxtKojinShitenName() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().getTxtKojinShitenName();
    }

    @JsonIgnore
    public void  setTxtKojinShitenName(TextBox txtKojinShitenName) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().setTxtKojinShitenName(txtKojinShitenName);
    }

    @JsonIgnore
    public TextBoxCode getTxtKojinKozaNo() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().getTxtKojinKozaNo();
    }

    @JsonIgnore
    public void  setTxtKojinKozaNo(TextBoxCode txtKojinKozaNo) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().setTxtKojinKozaNo(txtKojinKozaNo);
    }

    @JsonIgnore
    public TextBoxKana getTxtKojinMeigininKana() {
        return this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().getTxtKojinMeigininKana();
    }

    @JsonIgnore
    public void  setTxtKojinMeigininKana(TextBoxKana txtKojinMeigininKana) {
        this.getTabKashitsukekinInfo().getTplKashitsukekinKoza().setTxtKojinMeigininKana(txtKojinMeigininKana);
    }

    //--------------- この行より下にコードを追加してください -------------------

}
