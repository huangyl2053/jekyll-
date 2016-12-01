package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KojinIraiNaiyouKoshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class KojinIraiNaiyouKoshinDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tabKojinIraiNaiyouKoshin")
    private tabKojinIraiNaiyouKoshinDiv tabKojinIraiNaiyouKoshin;
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    private NinteiShinseishaKihonInfoDiv ccdNinteiShinseishaKihonInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettabKojinIraiNaiyouKoshin
     * @return tabKojinIraiNaiyouKoshin
     */
    @JsonProperty("tabKojinIraiNaiyouKoshin")
    public tabKojinIraiNaiyouKoshinDiv getTabKojinIraiNaiyouKoshin() {
        return tabKojinIraiNaiyouKoshin;
    }

    /*
     * settabKojinIraiNaiyouKoshin
     * @param tabKojinIraiNaiyouKoshin tabKojinIraiNaiyouKoshin
     */
    @JsonProperty("tabKojinIraiNaiyouKoshin")
    public void setTabKojinIraiNaiyouKoshin(tabKojinIraiNaiyouKoshinDiv tabKojinIraiNaiyouKoshin) {
        this.tabKojinIraiNaiyouKoshin = tabKojinIraiNaiyouKoshin;
    }

    /*
     * getccdNinteiShinseishaKihonInfo
     * @return ccdNinteiShinseishaKihonInfo
     */
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    public INinteiShinseishaKihonInfoDiv getCcdNinteiShinseishaKihonInfo() {
        return ccdNinteiShinseishaKihonInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public tblNinteichosaDiv getTblNinteichosa() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa();
    }

    @JsonIgnore
    public void  setTblNinteichosa(tblNinteichosaDiv tblNinteichosa) {
        this.getTabKojinIraiNaiyouKoshin().setTblNinteichosa(tblNinteichosa);
    }

    @JsonIgnore
    public KonkaiHomonChosaIraiJohoDiv getKonkaiHomonChosaIraiJoho() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho();
    }

    @JsonIgnore
    public void  setKonkaiHomonChosaIraiJoho(KonkaiHomonChosaIraiJohoDiv KonkaiHomonChosaIraiJoho) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().setKonkaiHomonChosaIraiJoho(KonkaiHomonChosaIraiJoho);
    }

    @JsonIgnore
    public Label getLblShinkiChosa() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getLblShinkiChosa();
    }

    @JsonIgnore
    public void  setLblShinkiChosa(Label lblShinkiChosa) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setLblShinkiChosa(lblShinkiChosa);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubun() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaBashoKubun();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubun(TextBox txtChosaBashoKubun) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaBashoKubun(txtChosaBashoKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibi() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJisshibi();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibi(TextBoxDate txtChosaJisshibi) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJisshibi(txtChosaJisshibi);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCode() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCode();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCode(TextBoxCode txtChosaJIsshiChikuCode) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCode(txtChosaJIsshiChikuCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChiku() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChiku();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChiku(TextBox txtChosaJIsshiChiku) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChiku(txtChosaJIsshiChiku);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCode() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaKikanCode();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCode(TextBoxCode txtChosaKikanCode) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaKikanCode(txtChosaKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikan() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaKikan();
    }

    @JsonIgnore
    public void  setTxtChosaKikan(TextBox txtChosaKikan) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaKikan(txtChosaKikan);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubun() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaItakuKubun();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubun(TextBox txtChosaItakuKubun) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaItakuKubun(txtChosaItakuKubun);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCode() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosainCode();
    }

    @JsonIgnore
    public void  setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosainCode(txtChosainCode);
    }

    @JsonIgnore
    public TextBox getTxtChosain() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosain();
    }

    @JsonIgnore
    public void  setTxtChosain(TextBox txtChosain) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosain(txtChosain);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikaku() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosainShikaku();
    }

    @JsonIgnore
    public void  setTxtChosainShikaku(TextBox txtChosainShikaku) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosainShikaku(txtChosainShikaku);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBango() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtDenwaBango();
    }

    @JsonIgnore
    public void  setTxtDenwaBango(TextBoxTelNo txtDenwaBango) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtDenwaBango(txtDenwaBango);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFax() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtFax();
    }

    @JsonIgnore
    public void  setTxtFax(TextBoxTelNo txtFax) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtFax(txtFax);
    }

    @JsonIgnore
    public Label getLblSaiChosa() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getLblSaiChosa();
    }

    @JsonIgnore
    public void  setLblSaiChosa(Label lblSaiChosa) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setLblSaiChosa(lblSaiChosa);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubunSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaBashoKubunSai();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubunSai(TextBox txtChosaBashoKubunSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaBashoKubunSai(txtChosaBashoKubunSai);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibiSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJisshibiSai();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibiSai(TextBoxDate txtChosaJisshibiSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJisshibiSai(txtChosaJisshibiSai);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCodeSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCodeSai();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCodeSai(TextBoxCode txtChosaJIsshiChikuCodeSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCodeSai(txtChosaJIsshiChikuCodeSai);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChikuSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuSai();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuSai(TextBox txtChosaJIsshiChikuSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuSai(txtChosaJIsshiChikuSai);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCodeSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaKikanCodeSai();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCodeSai(TextBoxCode txtChosaKikanCodeSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaKikanCodeSai(txtChosaKikanCodeSai);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikanSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaKikanSai();
    }

    @JsonIgnore
    public void  setTxtChosaKikanSai(TextBox txtChosaKikanSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaKikanSai(txtChosaKikanSai);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubunSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaItakuKubunSai();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubunSai(TextBox txtChosaItakuKubunSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaItakuKubunSai(txtChosaItakuKubunSai);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCodeSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosainCodeSai();
    }

    @JsonIgnore
    public void  setTxtChosainCodeSai(TextBoxCode txtChosainCodeSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosainCodeSai(txtChosainCodeSai);
    }

    @JsonIgnore
    public TextBox getTxtChosainSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosainSai();
    }

    @JsonIgnore
    public void  setTxtChosainSai(TextBox txtChosainSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosainSai(txtChosainSai);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikakuSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosainShikakuSai();
    }

    @JsonIgnore
    public void  setTxtChosainShikakuSai(TextBox txtChosainShikakuSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosainShikakuSai(txtChosainShikakuSai);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtDenwaBangoSai();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoSai(TextBoxTelNo txtDenwaBangoSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtDenwaBangoSai(txtDenwaBangoSai);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxSai() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtFaxSai();
    }

    @JsonIgnore
    public void  setTxtFaxSai(TextBoxTelNo txtFaxSai) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtFaxSai(txtFaxSai);
    }

    @JsonIgnore
    public TextBox getTxtHomonUmu() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtHomonUmu();
    }

    @JsonIgnore
    public void  setTxtHomonUmu(TextBox txtHomonUmu) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtHomonUmu(txtHomonUmu);
    }

    @JsonIgnore
    public ZenkaiHomonChosaIraiJohoDiv getZenkaiHomonChosaIraiJoho() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho();
    }

    @JsonIgnore
    public void  setZenkaiHomonChosaIraiJoho(ZenkaiHomonChosaIraiJohoDiv ZenkaiHomonChosaIraiJoho) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().setZenkaiHomonChosaIraiJoho(ZenkaiHomonChosaIraiJoho);
    }

    @JsonIgnore
    public Label getLblShinkiChosaZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getLblShinkiChosaZen();
    }

    @JsonIgnore
    public void  setLblShinkiChosaZen(Label lblShinkiChosaZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setLblShinkiChosaZen(lblShinkiChosaZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubunZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaBashoKubunZen();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubunZen(TextBox txtChosaBashoKubunZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaBashoKubunZen(txtChosaBashoKubunZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJisshibiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibiZen(TextBoxDate txtChosaJisshibiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJisshibiZen(txtChosaJisshibiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCodeZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCodeZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCodeZen(TextBoxCode txtChosaJIsshiChikuCodeZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCodeZen(txtChosaJIsshiChikuCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChikuZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuZen(TextBox txtChosaJIsshiChikuZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuZen(txtChosaJIsshiChikuZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCodeZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaKikanCodeZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCodeZen(TextBoxCode txtChosaKikanCodeZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaKikanCodeZen(txtChosaKikanCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikanZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaKikanZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanZen(TextBox txtChosaKikanZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaKikanZen(txtChosaKikanZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubunZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaItakuKubunZen();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubunZen(TextBox txtChosaItakuKubunZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaItakuKubunZen(txtChosaItakuKubunZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCodeZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainCodeZen();
    }

    @JsonIgnore
    public void  setTxtChosainCodeZen(TextBoxCode txtChosainCodeZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainCodeZen(txtChosainCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainZen();
    }

    @JsonIgnore
    public void  setTxtChosainZen(TextBox txtChosainZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainZen(txtChosainZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikakuZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainShikakuZen();
    }

    @JsonIgnore
    public void  setTxtChosainShikakuZen(TextBox txtChosainShikakuZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainShikakuZen(txtChosainShikakuZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtDenwaBangoZen();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoZen(TextBoxTelNo txtDenwaBangoZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtDenwaBangoZen(txtDenwaBangoZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtFaxZen();
    }

    @JsonIgnore
    public void  setTxtFaxZen(TextBoxTelNo txtFaxZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtFaxZen(txtFaxZen);
    }

    @JsonIgnore
    public Label getLblSaiChosaZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getLblSaiChosaZen();
    }

    @JsonIgnore
    public void  setLblSaiChosaZen(Label lblSaiChosaZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setLblSaiChosaZen(lblSaiChosaZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubunSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaBashoKubunSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubunSaiZen(TextBox txtChosaBashoKubunSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaBashoKubunSaiZen(txtChosaBashoKubunSaiZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibiSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJisshibiSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibiSaiZen(TextBoxDate txtChosaJisshibiSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJisshibiSaiZen(txtChosaJisshibiSaiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCodeSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCodeSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCodeSaiZen(TextBoxCode txtChosaJIsshiChikuCodeSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCodeSaiZen(txtChosaJIsshiChikuCodeSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChikuSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuSaiZen(TextBox txtChosaJIsshiChikuSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuSaiZen(txtChosaJIsshiChikuSaiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCodeSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaKikanCodeSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCodeSaiZen(TextBoxCode txtChosaKikanCodeSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaKikanCodeSaiZen(txtChosaKikanCodeSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikanSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaKikanSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanSaiZen(TextBox txtChosaKikanSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaKikanSaiZen(txtChosaKikanSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubunSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaItakuKubunSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubunSaiZen(TextBox txtChosaItakuKubunSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaItakuKubunSaiZen(txtChosaItakuKubunSaiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCodeSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainCodeSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosainCodeSaiZen(TextBoxCode txtChosainCodeSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainCodeSaiZen(txtChosainCodeSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosainSaiZen(TextBox txtChosainSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainSaiZen(txtChosainSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikakuSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainShikakuSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosainShikakuSaiZen(TextBox txtChosainShikakuSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainShikakuSaiZen(txtChosainShikakuSaiZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtDenwaBangoSaiZen();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoSaiZen(TextBoxTelNo txtDenwaBangoSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtDenwaBangoSaiZen(txtDenwaBangoSaiZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxSaiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtFaxSaiZen();
    }

    @JsonIgnore
    public void  setTxtFaxSaiZen(TextBoxTelNo txtFaxSaiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtFaxSaiZen(txtFaxSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtHomonUmuZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtHomonUmuZen();
    }

    @JsonIgnore
    public void  setTxtHomonUmuZen(TextBox txtHomonUmuZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtHomonUmuZen(txtHomonUmuZen);
    }

    @JsonIgnore
    public tblIkenshoDiv getTblIkensho() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho();
    }

    @JsonIgnore
    public void  setTblIkensho(tblIkenshoDiv tblIkensho) {
        this.getTabKojinIraiNaiyouKoshin().setTblIkensho(tblIkensho);
    }

    @JsonIgnore
    public KonkaiShujiiIraiJohoDiv getKonkaiShujiiIraiJoho() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho();
    }

    @JsonIgnore
    public void  setKonkaiShujiiIraiJoho(KonkaiShujiiIraiJohoDiv KonkaiShujiiIraiJoho) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().setKonkaiShujiiIraiJoho(KonkaiShujiiIraiJoho);
    }

    @JsonIgnore
    public TextBoxCode getTxtIkenshoSakuseiIraiRirekiBango() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIkenshoSakuseiIraiRirekiBango();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiIraiRirekiBango(TextBoxCode txtIkenshoSakuseiIraiRirekiBango) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIkenshoSakuseiIraiRirekiBango(txtIkenshoSakuseiIraiRirekiBango);
    }

    @JsonIgnore
    public TextBox getTxtIkenshoIraiKubun() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIkenshoIraiKubun();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraiKubun(TextBox txtIkenshoIraiKubun) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIkenshoIraiKubun(txtIkenshoIraiKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtIkenshoSakuseiKaisu() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIkenshoSakuseiKaisu();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiKaisu(TextBoxNum txtIkenshoSakuseiKaisu) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIkenshoSakuseiKaisu(txtIkenshoSakuseiKaisu);
    }

    @JsonIgnore
    public TextBox getTxtShujiiShiteiiKubun() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtShujiiShiteiiKubun();
    }

    @JsonIgnore
    public void  setTxtShujiiShiteiiKubun(TextBox txtShujiiShiteiiKubun) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtShujiiShiteiiKubun(txtShujiiShiteiiKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraibi() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIkenshoIraibi();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraibi(TextBoxDate txtIkenshoIraibi) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIkenshoIraibi(txtIkenshoIraibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoKinyubi() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIkenshoKinyubi();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyubi(TextBoxDate txtIkenshoKinyubi) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIkenshoKinyubi(txtIkenshoKinyubi);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiKekka() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getChkNinteiKekka();
    }

    @JsonIgnore
    public void  setChkNinteiKekka(CheckBoxList chkNinteiKekka) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setChkNinteiKekka(chkNinteiKekka);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCode() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtShujiiCode();
    }

    @JsonIgnore
    public void  setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtShujiiCode(txtShujiiCode);
    }

    @JsonIgnore
    public TextBox getTxtShujii() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtShujii();
    }

    @JsonIgnore
    public void  setTxtShujii(TextBox txtShujii) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtShujii(txtShujii);
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCode() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIryoKikanCode();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCode(TextBoxCode txtIryoKikanCode) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIryoKikanCode(txtIryoKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikan() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIryoKikan();
    }

    @JsonIgnore
    public void  setTxtIryoKikan(TextBox txtIryoKikan) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIryoKikan(txtIryoKikan);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinGango() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtYubinGango();
    }

    @JsonIgnore
    public void  setTxtYubinGango(TextBoxYubinNo txtYubinGango) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtYubinGango(txtYubinGango);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoIkensho() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtDenwaBangoIkensho();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoIkensho(TextBoxTelNo txtDenwaBangoIkensho) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtDenwaBangoIkensho(txtDenwaBangoIkensho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxIkensho() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtFaxIkensho();
    }

    @JsonIgnore
    public void  setTxtFaxIkensho(TextBoxTelNo txtFaxIkensho) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtFaxIkensho(txtFaxIkensho);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanDaihyoshaShimei() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIryoKikanDaihyoshaShimei();
    }

    @JsonIgnore
    public void  setTxtIryoKikanDaihyoshaShimei(TextBox txtIryoKikanDaihyoshaShimei) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIryoKikanDaihyoshaShimei(txtIryoKikanDaihyoshaShimei);
    }

    @JsonIgnore
    public ZenkaiShujiiIraiJohoDiv getZenkaiShujiiIraiJoho() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho();
    }

    @JsonIgnore
    public void  setZenkaiShujiiIraiJoho(ZenkaiShujiiIraiJohoDiv ZenkaiShujiiIraiJoho) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().setZenkaiShujiiIraiJoho(ZenkaiShujiiIraiJoho);
    }

    @JsonIgnore
    public TextBoxCode getTxtIkenshoSakuseiIraiRirekiBangoZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIkenshoSakuseiIraiRirekiBangoZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiIraiRirekiBangoZen(TextBoxCode txtIkenshoSakuseiIraiRirekiBangoZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIkenshoSakuseiIraiRirekiBangoZen(txtIkenshoSakuseiIraiRirekiBangoZen);
    }

    @JsonIgnore
    public TextBox getTxtIkenshoIraiKubunZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIkenshoIraiKubunZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraiKubunZen(TextBox txtIkenshoIraiKubunZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIkenshoIraiKubunZen(txtIkenshoIraiKubunZen);
    }

    @JsonIgnore
    public TextBoxNum getTxtIkenshoSakuseiKaisuZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIkenshoSakuseiKaisuZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiKaisuZen(TextBoxNum txtIkenshoSakuseiKaisuZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIkenshoSakuseiKaisuZen(txtIkenshoSakuseiKaisuZen);
    }

    @JsonIgnore
    public TextBox getTxtShujiiShiteiiKubunZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtShujiiShiteiiKubunZen();
    }

    @JsonIgnore
    public void  setTxtShujiiShiteiiKubunZen(TextBox txtShujiiShiteiiKubunZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtShujiiShiteiiKubunZen(txtShujiiShiteiiKubunZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraibiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIkenshoIraibiZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraibiZen(TextBoxDate txtIkenshoIraibiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIkenshoIraibiZen(txtIkenshoIraibiZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoKinyubiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIkenshoKinyubiZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyubiZen(TextBoxDate txtIkenshoKinyubiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIkenshoKinyubiZen(txtIkenshoKinyubiZen);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiKekkaZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getChkNinteiKekkaZen();
    }

    @JsonIgnore
    public void  setChkNinteiKekkaZen(CheckBoxList chkNinteiKekkaZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setChkNinteiKekkaZen(chkNinteiKekkaZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCodeZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtShujiiCodeZen();
    }

    @JsonIgnore
    public void  setTxtShujiiCodeZen(TextBoxCode txtShujiiCodeZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtShujiiCodeZen(txtShujiiCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtShujiiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtShujiiZen();
    }

    @JsonIgnore
    public void  setTxtShujiiZen(TextBox txtShujiiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtShujiiZen(txtShujiiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCodeZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIryoKikanCodeZen();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCodeZen(TextBoxCode txtIryoKikanCodeZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIryoKikanCodeZen(txtIryoKikanCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIryoKikanZen();
    }

    @JsonIgnore
    public void  setTxtIryoKikanZen(TextBox txtIryoKikanZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIryoKikanZen(txtIryoKikanZen);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinGangoZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtYubinGangoZen();
    }

    @JsonIgnore
    public void  setTxtYubinGangoZen(TextBoxYubinNo txtYubinGangoZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtYubinGangoZen(txtYubinGangoZen);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJushoZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtJushoZen();
    }

    @JsonIgnore
    public void  setTxtJushoZen(TextBoxJusho txtJushoZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtJushoZen(txtJushoZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoIkenshoZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtDenwaBangoIkenshoZen();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoIkenshoZen(TextBoxTelNo txtDenwaBangoIkenshoZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtDenwaBangoIkenshoZen(txtDenwaBangoIkenshoZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxIkenshoZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtFaxIkenshoZen();
    }

    @JsonIgnore
    public void  setTxtFaxIkenshoZen(TextBoxTelNo txtFaxIkenshoZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtFaxIkenshoZen(txtFaxIkenshoZen);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanDaihyoshaShimeiZen() {
        return this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIryoKikanDaihyoshaShimeiZen();
    }

    @JsonIgnore
    public void  setTxtIryoKikanDaihyoshaShimeiZen(TextBox txtIryoKikanDaihyoshaShimeiZen) {
        this.getTabKojinIraiNaiyouKoshin().getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIryoKikanDaihyoshaShimeiZen(txtIryoKikanDaihyoshaShimeiZen);
    }

    // </editor-fold>
}
