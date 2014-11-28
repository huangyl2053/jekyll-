package jp.co.ndensan.reams.db.dbc.divcontroller.entity;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
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
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKashitsukekinHenkoDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKashitsukekinKariukeDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKashitsukekinKetteiDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKashitsukekinKozaDiv;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.tplKashitsukekinShinseiDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabKashitsukekinInfo のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKashitsukekinInfoDiv extends TabContainer {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplKashitsukekinShinsei")
    private tplKashitsukekinShinseiDiv tplKashitsukekinShinsei;
    @JsonProperty("tplKashitsukekinKettei")
    private tplKashitsukekinKetteiDiv tplKashitsukekinKettei;
    @JsonProperty("tplKashitsukekinKariuke")
    private tplKashitsukekinKariukeDiv tplKashitsukekinKariuke;
    @JsonProperty("tplKashitsukekinHenko")
    private tplKashitsukekinHenkoDiv tplKashitsukekinHenko;
    @JsonProperty("tplKashitsukekinKoza")
    private tplKashitsukekinKozaDiv tplKashitsukekinKoza;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tplKashitsukekinShinsei")
    public tplKashitsukekinShinseiDiv getTplKashitsukekinShinsei() {
        return tplKashitsukekinShinsei;
    }

    @JsonProperty("tplKashitsukekinShinsei")
    public void setTplKashitsukekinShinsei(tplKashitsukekinShinseiDiv tplKashitsukekinShinsei) {
        this.tplKashitsukekinShinsei=tplKashitsukekinShinsei;
    }

    @JsonProperty("tplKashitsukekinKettei")
    public tplKashitsukekinKetteiDiv getTplKashitsukekinKettei() {
        return tplKashitsukekinKettei;
    }

    @JsonProperty("tplKashitsukekinKettei")
    public void setTplKashitsukekinKettei(tplKashitsukekinKetteiDiv tplKashitsukekinKettei) {
        this.tplKashitsukekinKettei=tplKashitsukekinKettei;
    }

    @JsonProperty("tplKashitsukekinKariuke")
    public tplKashitsukekinKariukeDiv getTplKashitsukekinKariuke() {
        return tplKashitsukekinKariuke;
    }

    @JsonProperty("tplKashitsukekinKariuke")
    public void setTplKashitsukekinKariuke(tplKashitsukekinKariukeDiv tplKashitsukekinKariuke) {
        this.tplKashitsukekinKariuke=tplKashitsukekinKariuke;
    }

    @JsonProperty("tplKashitsukekinHenko")
    public tplKashitsukekinHenkoDiv getTplKashitsukekinHenko() {
        return tplKashitsukekinHenko;
    }

    @JsonProperty("tplKashitsukekinHenko")
    public void setTplKashitsukekinHenko(tplKashitsukekinHenkoDiv tplKashitsukekinHenko) {
        this.tplKashitsukekinHenko=tplKashitsukekinHenko;
    }

    @JsonProperty("tplKashitsukekinKoza")
    public tplKashitsukekinKozaDiv getTplKashitsukekinKoza() {
        return tplKashitsukekinKoza;
    }

    @JsonProperty("tplKashitsukekinKoza")
    public void setTplKashitsukekinKoza(tplKashitsukekinKozaDiv tplKashitsukekinKoza) {
        this.tplKashitsukekinKoza=tplKashitsukekinKoza;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtShinseiYMD() {
        return this.getTplKashitsukekinShinsei().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxDate txtShinseiYMD) {
        this.getTplKashitsukekinShinsei().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtRiyoKikan() {
        return this.getTplKashitsukekinShinsei().getTxtRiyoKikan();
    }

    @JsonIgnore
    public void  setTxtRiyoKikan(TextBoxDateRange txtRiyoKikan) {
        this.getTplKashitsukekinShinsei().setTxtRiyoKikan(txtRiyoKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtSeikyugaku() {
        return this.getTplKashitsukekinShinsei().getTxtSeikyugaku();
    }

    @JsonIgnore
    public void  setTxtSeikyugaku(TextBoxNum txtSeikyugaku) {
        this.getTplKashitsukekinShinsei().setTxtSeikyugaku(txtSeikyugaku);
    }

    @JsonIgnore
    public TextBoxNum getTxtShinseiKingaku() {
        return this.getTplKashitsukekinShinsei().getTxtShinseiKingaku();
    }

    @JsonIgnore
    public void  setTxtShinseiKingaku(TextBoxNum txtShinseiKingaku) {
        this.getTplKashitsukekinShinsei().setTxtShinseiKingaku(txtShinseiKingaku);
    }

    @JsonIgnore
    public KashitsukeShinseiServiceDiv getKashitsukeShinseiService() {
        return this.getTplKashitsukekinShinsei().getKashitsukeShinseiService();
    }

    @JsonIgnore
    public void  setKashitsukeShinseiService(KashitsukeShinseiServiceDiv KashitsukeShinseiService) {
        this.getTplKashitsukekinShinsei().setKashitsukeShinseiService(KashitsukeShinseiService);
    }

    @JsonIgnore
    public KashitsukeShinseishaDiv getKashitsukeShinseisha() {
        return this.getTplKashitsukekinShinsei().getKashitsukeShinseisha();
    }

    @JsonIgnore
    public void  setKashitsukeShinseisha(KashitsukeShinseishaDiv KashitsukeShinseisha) {
        this.getTplKashitsukekinShinsei().setKashitsukeShinseisha(KashitsukeShinseisha);
    }

    @JsonIgnore
    public KashitsukeShinseiHoshoninDiv getKashitsukeShinseiHoshonin() {
        return this.getTplKashitsukekinShinsei().getKashitsukeShinseiHoshonin();
    }

    @JsonIgnore
    public void  setKashitsukeShinseiHoshonin(KashitsukeShinseiHoshoninDiv KashitsukeShinseiHoshonin) {
        this.getTplKashitsukekinShinsei().setKashitsukeShinseiHoshonin(KashitsukeShinseiHoshonin);
    }

    @JsonIgnore
    public KashitsukeShinseiTeishutsuDiv getKashitsukeShinseiTeishutsu() {
        return this.getTplKashitsukekinShinsei().getKashitsukeShinseiTeishutsu();
    }

    @JsonIgnore
    public void  setKashitsukeShinseiTeishutsu(KashitsukeShinseiTeishutsuDiv KashitsukeShinseiTeishutsu) {
        this.getTplKashitsukekinShinsei().setKashitsukeShinseiTeishutsu(KashitsukeShinseiTeishutsu);
    }

    @JsonIgnore
    public TextBox getTxtKetteiShoninKubun() {
        return this.getTplKashitsukekinKettei().getTxtKetteiShoninKubun();
    }

    @JsonIgnore
    public void  setTxtKetteiShoninKubun(TextBox txtKetteiShoninKubun) {
        this.getTplKashitsukekinKettei().setTxtKetteiShoninKubun(txtKetteiShoninKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtKetteiYMD() {
        return this.getTplKashitsukekinKettei().getTxtKetteiYMD();
    }

    @JsonIgnore
    public void  setTxtKetteiYMD(TextBoxDate txtKetteiYMD) {
        this.getTplKashitsukekinKettei().setTxtKetteiYMD(txtKetteiYMD);
    }

    @JsonIgnore
    public KashitsukekinKetteiShoninDiv getKashitsukekinKetteiShonin() {
        return this.getTplKashitsukekinKettei().getKashitsukekinKetteiShonin();
    }

    @JsonIgnore
    public void  setKashitsukekinKetteiShonin(KashitsukekinKetteiShoninDiv KashitsukekinKetteiShonin) {
        this.getTplKashitsukekinKettei().setKashitsukekinKetteiShonin(KashitsukekinKetteiShonin);
    }

    @JsonIgnore
    public TextBox getTxtKetteiFushoninRiyu() {
        return this.getTplKashitsukekinKettei().getTxtKetteiFushoninRiyu();
    }

    @JsonIgnore
    public void  setTxtKetteiFushoninRiyu(TextBox txtKetteiFushoninRiyu) {
        this.getTplKashitsukekinKettei().setTxtKetteiFushoninRiyu(txtKetteiFushoninRiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtKariukeYMD() {
        return this.getTplKashitsukekinKariuke().getTxtKariukeYMD();
    }

    @JsonIgnore
    public void  setTxtKariukeYMD(TextBoxDate txtKariukeYMD) {
        this.getTplKashitsukekinKariuke().setTxtKariukeYMD(txtKariukeYMD);
    }

    @JsonIgnore
    public KashitsukekinKariukeninDiv getKashitsukekinKariukenin() {
        return this.getTplKashitsukekinKariuke().getKashitsukekinKariukenin();
    }

    @JsonIgnore
    public void  setKashitsukekinKariukenin(KashitsukekinKariukeninDiv KashitsukekinKariukenin) {
        this.getTplKashitsukekinKariuke().setKashitsukekinKariukenin(KashitsukekinKariukenin);
    }

    @JsonIgnore
    public KashitsukekinKariukeHoshoDiv getKashitsukekinKariukeHosho() {
        return this.getTplKashitsukekinKariuke().getKashitsukekinKariukeHosho();
    }

    @JsonIgnore
    public void  setKashitsukekinKariukeHosho(KashitsukekinKariukeHoshoDiv KashitsukekinKariukeHosho) {
        this.getTplKashitsukekinKariuke().setKashitsukekinKariukeHosho(KashitsukekinKariukeHosho);
    }

    @JsonIgnore
    public TextBoxDate getTxtEnchoShinseiYMD() {
        return this.getTplKashitsukekinHenko().getTxtEnchoShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtEnchoShinseiYMD(TextBoxDate txtEnchoShinseiYMD) {
        this.getTplKashitsukekinHenko().setTxtEnchoShinseiYMD(txtEnchoShinseiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtEnchoKikan() {
        return this.getTplKashitsukekinHenko().getTxtEnchoKikan();
    }

    @JsonIgnore
    public void  setTxtEnchoKikan(TextBoxDateRange txtEnchoKikan) {
        this.getTplKashitsukekinHenko().setTxtEnchoKikan(txtEnchoKikan);
    }

    @JsonIgnore
    public TextBoxNum getTxtMishokanKingaku() {
        return this.getTplKashitsukekinHenko().getTxtMishokanKingaku();
    }

    @JsonIgnore
    public void  setTxtMishokanKingaku(TextBoxNum txtMishokanKingaku) {
        this.getTplKashitsukekinHenko().setTxtMishokanKingaku(txtMishokanKingaku);
    }

    @JsonIgnore
    public TextBox getTxtEnchoRiyu() {
        return this.getTplKashitsukekinHenko().getTxtEnchoRiyu();
    }

    @JsonIgnore
    public void  setTxtEnchoRiyu(TextBox txtEnchoRiyu) {
        this.getTplKashitsukekinHenko().setTxtEnchoRiyu(txtEnchoRiyu);
    }

    @JsonIgnore
    public KashitsukekinHenkoKariukeDiv getKashitsukekinHenkoKariuke() {
        return this.getTplKashitsukekinHenko().getKashitsukekinHenkoKariuke();
    }

    @JsonIgnore
    public void  setKashitsukekinHenkoKariuke(KashitsukekinHenkoKariukeDiv KashitsukekinHenkoKariuke) {
        this.getTplKashitsukekinHenko().setKashitsukekinHenkoKariuke(KashitsukekinHenkoKariuke);
    }

    @JsonIgnore
    public KashitsukekinHenkoKetteiDiv getKashitsukekinHenkoKettei() {
        return this.getTplKashitsukekinHenko().getKashitsukekinHenkoKettei();
    }

    @JsonIgnore
    public void  setKashitsukekinHenkoKettei(KashitsukekinHenkoKetteiDiv KashitsukekinHenkoKettei) {
        this.getTplKashitsukekinHenko().setKashitsukekinHenkoKettei(KashitsukekinHenkoKettei);
    }

    @JsonIgnore
    public TextBoxCode getTxtKojinKinyuKikanCode() {
        return this.getTplKashitsukekinKoza().getTxtKojinKinyuKikanCode();
    }

    @JsonIgnore
    public void  setTxtKojinKinyuKikanCode(TextBoxCode txtKojinKinyuKikanCode) {
        this.getTplKashitsukekinKoza().setTxtKojinKinyuKikanCode(txtKojinKinyuKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtKojinKinyuKikanName() {
        return this.getTplKashitsukekinKoza().getTxtKojinKinyuKikanName();
    }

    @JsonIgnore
    public void  setTxtKojinKinyuKikanName(TextBox txtKojinKinyuKikanName) {
        this.getTplKashitsukekinKoza().setTxtKojinKinyuKikanName(txtKojinKinyuKikanName);
    }

    @JsonIgnore
    public TextBox getTxtKojinKozaShubetsu() {
        return this.getTplKashitsukekinKoza().getTxtKojinKozaShubetsu();
    }

    @JsonIgnore
    public void  setTxtKojinKozaShubetsu(TextBox txtKojinKozaShubetsu) {
        this.getTplKashitsukekinKoza().setTxtKojinKozaShubetsu(txtKojinKozaShubetsu);
    }

    @JsonIgnore
    public TextBoxKana getTxtKojinMeigininName() {
        return this.getTplKashitsukekinKoza().getTxtKojinMeigininName();
    }

    @JsonIgnore
    public void  setTxtKojinMeigininName(TextBoxKana txtKojinMeigininName) {
        this.getTplKashitsukekinKoza().setTxtKojinMeigininName(txtKojinMeigininName);
    }

    @JsonIgnore
    public TextBoxCode getTxtKojinShitenCode() {
        return this.getTplKashitsukekinKoza().getTxtKojinShitenCode();
    }

    @JsonIgnore
    public void  setTxtKojinShitenCode(TextBoxCode txtKojinShitenCode) {
        this.getTplKashitsukekinKoza().setTxtKojinShitenCode(txtKojinShitenCode);
    }

    @JsonIgnore
    public TextBox getTxtKojinShitenName() {
        return this.getTplKashitsukekinKoza().getTxtKojinShitenName();
    }

    @JsonIgnore
    public void  setTxtKojinShitenName(TextBox txtKojinShitenName) {
        this.getTplKashitsukekinKoza().setTxtKojinShitenName(txtKojinShitenName);
    }

    @JsonIgnore
    public TextBoxCode getTxtKojinKozaNo() {
        return this.getTplKashitsukekinKoza().getTxtKojinKozaNo();
    }

    @JsonIgnore
    public void  setTxtKojinKozaNo(TextBoxCode txtKojinKozaNo) {
        this.getTplKashitsukekinKoza().setTxtKojinKozaNo(txtKojinKozaNo);
    }

    @JsonIgnore
    public TextBoxKana getTxtKojinMeigininKana() {
        return this.getTplKashitsukekinKoza().getTxtKojinMeigininKana();
    }

    @JsonIgnore
    public void  setTxtKojinMeigininKana(TextBoxKana txtKojinMeigininKana) {
        this.getTplKashitsukekinKoza().setTxtKojinMeigininKana(txtKojinMeigininKana);
    }

}
