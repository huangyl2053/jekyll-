package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tabKojinIraiNaiyouKoshin のクラスファイル 
 * 
 * @author 自動生成
 */
public class tabKojinIraiNaiyouKoshinDiv extends TabContainer {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-31_08-44-29">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblNinteichosa")
    private tblNinteichosaDiv tblNinteichosa;
    @JsonProperty("tblIkensho")
    private tblIkenshoDiv tblIkensho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblNinteichosa
     * @return tblNinteichosa
     */
    @JsonProperty("tblNinteichosa")
    public tblNinteichosaDiv getTblNinteichosa() {
        return tblNinteichosa;
    }

    /*
     * settblNinteichosa
     * @param tblNinteichosa tblNinteichosa
     */
    @JsonProperty("tblNinteichosa")
    public void setTblNinteichosa(tblNinteichosaDiv tblNinteichosa) {
        this.tblNinteichosa = tblNinteichosa;
    }

    /*
     * gettblIkensho
     * @return tblIkensho
     */
    @JsonProperty("tblIkensho")
    public tblIkenshoDiv getTblIkensho() {
        return tblIkensho;
    }

    /*
     * settblIkensho
     * @param tblIkensho tblIkensho
     */
    @JsonProperty("tblIkensho")
    public void setTblIkensho(tblIkenshoDiv tblIkensho) {
        this.tblIkensho = tblIkensho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public KonkaiHomonChosaIraiJohoDiv getKonkaiHomonChosaIraiJoho() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho();
    }

    @JsonIgnore
    public void  setKonkaiHomonChosaIraiJoho(KonkaiHomonChosaIraiJohoDiv KonkaiHomonChosaIraiJoho) {
        this.getTblNinteichosa().setKonkaiHomonChosaIraiJoho(KonkaiHomonChosaIraiJoho);
    }

    @JsonIgnore
    public Label getLblShinkiChosa() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getLblShinkiChosa();
    }

    @JsonIgnore
    public void  setLblShinkiChosa(Label lblShinkiChosa) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setLblShinkiChosa(lblShinkiChosa);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubun() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaBashoKubun();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubun(TextBox txtChosaBashoKubun) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaBashoKubun(txtChosaBashoKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibi() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJisshibi();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibi(TextBoxDate txtChosaJisshibi) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJisshibi(txtChosaJisshibi);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCode() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCode();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCode(TextBoxCode txtChosaJIsshiChikuCode) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCode(txtChosaJIsshiChikuCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChiku() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChiku();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChiku(TextBox txtChosaJIsshiChiku) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChiku(txtChosaJIsshiChiku);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCode() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaKikanCode();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCode(TextBoxCode txtChosaKikanCode) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaKikanCode(txtChosaKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikan() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaKikan();
    }

    @JsonIgnore
    public void  setTxtChosaKikan(TextBox txtChosaKikan) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaKikan(txtChosaKikan);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubun() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaItakuKubun();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubun(TextBox txtChosaItakuKubun) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaItakuKubun(txtChosaItakuKubun);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCode() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosainCode();
    }

    @JsonIgnore
    public void  setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosainCode(txtChosainCode);
    }

    @JsonIgnore
    public TextBox getTxtChosain() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosain();
    }

    @JsonIgnore
    public void  setTxtChosain(TextBox txtChosain) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosain(txtChosain);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikaku() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosainShikaku();
    }

    @JsonIgnore
    public void  setTxtChosainShikaku(TextBox txtChosainShikaku) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosainShikaku(txtChosainShikaku);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBango() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtDenwaBango();
    }

    @JsonIgnore
    public void  setTxtDenwaBango(TextBoxTelNo txtDenwaBango) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtDenwaBango(txtDenwaBango);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFax() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtFax();
    }

    @JsonIgnore
    public void  setTxtFax(TextBoxTelNo txtFax) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtFax(txtFax);
    }

    @JsonIgnore
    public Label getLblSaiChosa() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getLblSaiChosa();
    }

    @JsonIgnore
    public void  setLblSaiChosa(Label lblSaiChosa) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setLblSaiChosa(lblSaiChosa);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubunSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaBashoKubunSai();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubunSai(TextBox txtChosaBashoKubunSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaBashoKubunSai(txtChosaBashoKubunSai);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibiSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJisshibiSai();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibiSai(TextBoxDate txtChosaJisshibiSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJisshibiSai(txtChosaJisshibiSai);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCodeSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCodeSai();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCodeSai(TextBoxCode txtChosaJIsshiChikuCodeSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCodeSai(txtChosaJIsshiChikuCodeSai);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChikuSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuSai();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuSai(TextBox txtChosaJIsshiChikuSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuSai(txtChosaJIsshiChikuSai);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCodeSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaKikanCodeSai();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCodeSai(TextBoxCode txtChosaKikanCodeSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaKikanCodeSai(txtChosaKikanCodeSai);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikanSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaKikanSai();
    }

    @JsonIgnore
    public void  setTxtChosaKikanSai(TextBox txtChosaKikanSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaKikanSai(txtChosaKikanSai);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubunSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosaItakuKubunSai();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubunSai(TextBox txtChosaItakuKubunSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosaItakuKubunSai(txtChosaItakuKubunSai);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCodeSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosainCodeSai();
    }

    @JsonIgnore
    public void  setTxtChosainCodeSai(TextBoxCode txtChosainCodeSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosainCodeSai(txtChosainCodeSai);
    }

    @JsonIgnore
    public TextBox getTxtChosainSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosainSai();
    }

    @JsonIgnore
    public void  setTxtChosainSai(TextBox txtChosainSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosainSai(txtChosainSai);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikakuSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtChosainShikakuSai();
    }

    @JsonIgnore
    public void  setTxtChosainShikakuSai(TextBox txtChosainShikakuSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtChosainShikakuSai(txtChosainShikakuSai);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtDenwaBangoSai();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoSai(TextBoxTelNo txtDenwaBangoSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtDenwaBangoSai(txtDenwaBangoSai);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxSai() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtFaxSai();
    }

    @JsonIgnore
    public void  setTxtFaxSai(TextBoxTelNo txtFaxSai) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtFaxSai(txtFaxSai);
    }

    @JsonIgnore
    public TextBox getTxtHomonUmu() {
        return this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().getTxtHomonUmu();
    }

    @JsonIgnore
    public void  setTxtHomonUmu(TextBox txtHomonUmu) {
        this.getTblNinteichosa().getKonkaiHomonChosaIraiJoho().setTxtHomonUmu(txtHomonUmu);
    }

    @JsonIgnore
    public ZenkaiHomonChosaIraiJohoDiv getZenkaiHomonChosaIraiJoho() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho();
    }

    @JsonIgnore
    public void  setZenkaiHomonChosaIraiJoho(ZenkaiHomonChosaIraiJohoDiv ZenkaiHomonChosaIraiJoho) {
        this.getTblNinteichosa().setZenkaiHomonChosaIraiJoho(ZenkaiHomonChosaIraiJoho);
    }

    @JsonIgnore
    public Label getLblShinkiChosaZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getLblShinkiChosaZen();
    }

    @JsonIgnore
    public void  setLblShinkiChosaZen(Label lblShinkiChosaZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setLblShinkiChosaZen(lblShinkiChosaZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubunZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaBashoKubunZen();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubunZen(TextBox txtChosaBashoKubunZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaBashoKubunZen(txtChosaBashoKubunZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJisshibiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibiZen(TextBoxDate txtChosaJisshibiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJisshibiZen(txtChosaJisshibiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCodeZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCodeZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCodeZen(TextBoxCode txtChosaJIsshiChikuCodeZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCodeZen(txtChosaJIsshiChikuCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChikuZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuZen(TextBox txtChosaJIsshiChikuZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuZen(txtChosaJIsshiChikuZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCodeZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaKikanCodeZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCodeZen(TextBoxCode txtChosaKikanCodeZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaKikanCodeZen(txtChosaKikanCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikanZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaKikanZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanZen(TextBox txtChosaKikanZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaKikanZen(txtChosaKikanZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubunZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaItakuKubunZen();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubunZen(TextBox txtChosaItakuKubunZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaItakuKubunZen(txtChosaItakuKubunZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCodeZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainCodeZen();
    }

    @JsonIgnore
    public void  setTxtChosainCodeZen(TextBoxCode txtChosainCodeZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainCodeZen(txtChosainCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainZen();
    }

    @JsonIgnore
    public void  setTxtChosainZen(TextBox txtChosainZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainZen(txtChosainZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikakuZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainShikakuZen();
    }

    @JsonIgnore
    public void  setTxtChosainShikakuZen(TextBox txtChosainShikakuZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainShikakuZen(txtChosainShikakuZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtDenwaBangoZen();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoZen(TextBoxTelNo txtDenwaBangoZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtDenwaBangoZen(txtDenwaBangoZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtFaxZen();
    }

    @JsonIgnore
    public void  setTxtFaxZen(TextBoxTelNo txtFaxZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtFaxZen(txtFaxZen);
    }

    @JsonIgnore
    public Label getLblSaiChosaZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getLblSaiChosaZen();
    }

    @JsonIgnore
    public void  setLblSaiChosaZen(Label lblSaiChosaZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setLblSaiChosaZen(lblSaiChosaZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubunSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaBashoKubunSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubunSaiZen(TextBox txtChosaBashoKubunSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaBashoKubunSaiZen(txtChosaBashoKubunSaiZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibiSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJisshibiSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibiSaiZen(TextBoxDate txtChosaJisshibiSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJisshibiSaiZen(txtChosaJisshibiSaiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCodeSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCodeSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCodeSaiZen(TextBoxCode txtChosaJIsshiChikuCodeSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCodeSaiZen(txtChosaJIsshiChikuCodeSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChikuSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuSaiZen(TextBox txtChosaJIsshiChikuSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuSaiZen(txtChosaJIsshiChikuSaiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCodeSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaKikanCodeSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCodeSaiZen(TextBoxCode txtChosaKikanCodeSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaKikanCodeSaiZen(txtChosaKikanCodeSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikanSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaKikanSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanSaiZen(TextBox txtChosaKikanSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaKikanSaiZen(txtChosaKikanSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubunSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosaItakuKubunSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubunSaiZen(TextBox txtChosaItakuKubunSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosaItakuKubunSaiZen(txtChosaItakuKubunSaiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCodeSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainCodeSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosainCodeSaiZen(TextBoxCode txtChosainCodeSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainCodeSaiZen(txtChosainCodeSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosainSaiZen(TextBox txtChosainSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainSaiZen(txtChosainSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikakuSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtChosainShikakuSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosainShikakuSaiZen(TextBox txtChosainShikakuSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtChosainShikakuSaiZen(txtChosainShikakuSaiZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtDenwaBangoSaiZen();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoSaiZen(TextBoxTelNo txtDenwaBangoSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtDenwaBangoSaiZen(txtDenwaBangoSaiZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxSaiZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtFaxSaiZen();
    }

    @JsonIgnore
    public void  setTxtFaxSaiZen(TextBoxTelNo txtFaxSaiZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtFaxSaiZen(txtFaxSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtHomonUmuZen() {
        return this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().getTxtHomonUmuZen();
    }

    @JsonIgnore
    public void  setTxtHomonUmuZen(TextBox txtHomonUmuZen) {
        this.getTblNinteichosa().getZenkaiHomonChosaIraiJoho().setTxtHomonUmuZen(txtHomonUmuZen);
    }

    @JsonIgnore
    public KonkaiShujiiIraiJohoDiv getKonkaiShujiiIraiJoho() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho();
    }

    @JsonIgnore
    public void  setKonkaiShujiiIraiJoho(KonkaiShujiiIraiJohoDiv KonkaiShujiiIraiJoho) {
        this.getTblIkensho().setKonkaiShujiiIraiJoho(KonkaiShujiiIraiJoho);
    }

    @JsonIgnore
    public TextBoxCode getTxtIkenshoSakuseiIraiRirekiBango() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIkenshoSakuseiIraiRirekiBango();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiIraiRirekiBango(TextBoxCode txtIkenshoSakuseiIraiRirekiBango) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIkenshoSakuseiIraiRirekiBango(txtIkenshoSakuseiIraiRirekiBango);
    }

    @JsonIgnore
    public TextBox getTxtIkenshoIraiKubun() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIkenshoIraiKubun();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraiKubun(TextBox txtIkenshoIraiKubun) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIkenshoIraiKubun(txtIkenshoIraiKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtIkenshoSakuseiKaisu() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIkenshoSakuseiKaisu();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiKaisu(TextBoxNum txtIkenshoSakuseiKaisu) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIkenshoSakuseiKaisu(txtIkenshoSakuseiKaisu);
    }

    @JsonIgnore
    public TextBox getTxtShujiiShiteiiKubun() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtShujiiShiteiiKubun();
    }

    @JsonIgnore
    public void  setTxtShujiiShiteiiKubun(TextBox txtShujiiShiteiiKubun) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtShujiiShiteiiKubun(txtShujiiShiteiiKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraibi() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIkenshoIraibi();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraibi(TextBoxDate txtIkenshoIraibi) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIkenshoIraibi(txtIkenshoIraibi);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoKinyubi() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIkenshoKinyubi();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyubi(TextBoxDate txtIkenshoKinyubi) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIkenshoKinyubi(txtIkenshoKinyubi);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiKekka() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getChkNinteiKekka();
    }

    @JsonIgnore
    public void  setChkNinteiKekka(CheckBoxList chkNinteiKekka) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setChkNinteiKekka(chkNinteiKekka);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCode() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtShujiiCode();
    }

    @JsonIgnore
    public void  setTxtShujiiCode(TextBoxCode txtShujiiCode) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtShujiiCode(txtShujiiCode);
    }

    @JsonIgnore
    public TextBox getTxtShujii() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtShujii();
    }

    @JsonIgnore
    public void  setTxtShujii(TextBox txtShujii) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtShujii(txtShujii);
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCode() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIryoKikanCode();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCode(TextBoxCode txtIryoKikanCode) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIryoKikanCode(txtIryoKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikan() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIryoKikan();
    }

    @JsonIgnore
    public void  setTxtIryoKikan(TextBox txtIryoKikan) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIryoKikan(txtIryoKikan);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinGango() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtYubinGango();
    }

    @JsonIgnore
    public void  setTxtYubinGango(TextBoxYubinNo txtYubinGango) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtYubinGango(txtYubinGango);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoIkensho() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtDenwaBangoIkensho();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoIkensho(TextBoxTelNo txtDenwaBangoIkensho) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtDenwaBangoIkensho(txtDenwaBangoIkensho);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxIkensho() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtFaxIkensho();
    }

    @JsonIgnore
    public void  setTxtFaxIkensho(TextBoxTelNo txtFaxIkensho) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtFaxIkensho(txtFaxIkensho);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanDaihyoshaShimei() {
        return this.getTblIkensho().getKonkaiShujiiIraiJoho().getTxtIryoKikanDaihyoshaShimei();
    }

    @JsonIgnore
    public void  setTxtIryoKikanDaihyoshaShimei(TextBox txtIryoKikanDaihyoshaShimei) {
        this.getTblIkensho().getKonkaiShujiiIraiJoho().setTxtIryoKikanDaihyoshaShimei(txtIryoKikanDaihyoshaShimei);
    }

    @JsonIgnore
    public ZenkaiShujiiIraiJohoDiv getZenkaiShujiiIraiJoho() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho();
    }

    @JsonIgnore
    public void  setZenkaiShujiiIraiJoho(ZenkaiShujiiIraiJohoDiv ZenkaiShujiiIraiJoho) {
        this.getTblIkensho().setZenkaiShujiiIraiJoho(ZenkaiShujiiIraiJoho);
    }

    @JsonIgnore
    public TextBoxCode getTxtIkenshoSakuseiIraiRirekiBangoZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIkenshoSakuseiIraiRirekiBangoZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiIraiRirekiBangoZen(TextBoxCode txtIkenshoSakuseiIraiRirekiBangoZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIkenshoSakuseiIraiRirekiBangoZen(txtIkenshoSakuseiIraiRirekiBangoZen);
    }

    @JsonIgnore
    public TextBox getTxtIkenshoIraiKubunZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIkenshoIraiKubunZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraiKubunZen(TextBox txtIkenshoIraiKubunZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIkenshoIraiKubunZen(txtIkenshoIraiKubunZen);
    }

    @JsonIgnore
    public TextBoxNum getTxtIkenshoSakuseiKaisuZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIkenshoSakuseiKaisuZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoSakuseiKaisuZen(TextBoxNum txtIkenshoSakuseiKaisuZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIkenshoSakuseiKaisuZen(txtIkenshoSakuseiKaisuZen);
    }

    @JsonIgnore
    public TextBox getTxtShujiiShiteiiKubunZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtShujiiShiteiiKubunZen();
    }

    @JsonIgnore
    public void  setTxtShujiiShiteiiKubunZen(TextBox txtShujiiShiteiiKubunZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtShujiiShiteiiKubunZen(txtShujiiShiteiiKubunZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoIraibiZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIkenshoIraibiZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoIraibiZen(TextBoxDate txtIkenshoIraibiZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIkenshoIraibiZen(txtIkenshoIraibiZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtIkenshoKinyubiZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIkenshoKinyubiZen();
    }

    @JsonIgnore
    public void  setTxtIkenshoKinyubiZen(TextBoxDate txtIkenshoKinyubiZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIkenshoKinyubiZen(txtIkenshoKinyubiZen);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiKekkaZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getChkNinteiKekkaZen();
    }

    @JsonIgnore
    public void  setChkNinteiKekkaZen(CheckBoxList chkNinteiKekkaZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setChkNinteiKekkaZen(chkNinteiKekkaZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtShujiiCodeZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtShujiiCodeZen();
    }

    @JsonIgnore
    public void  setTxtShujiiCodeZen(TextBoxCode txtShujiiCodeZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtShujiiCodeZen(txtShujiiCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtShujiiZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtShujiiZen();
    }

    @JsonIgnore
    public void  setTxtShujiiZen(TextBox txtShujiiZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtShujiiZen(txtShujiiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtIryoKikanCodeZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIryoKikanCodeZen();
    }

    @JsonIgnore
    public void  setTxtIryoKikanCodeZen(TextBoxCode txtIryoKikanCodeZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIryoKikanCodeZen(txtIryoKikanCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIryoKikanZen();
    }

    @JsonIgnore
    public void  setTxtIryoKikanZen(TextBox txtIryoKikanZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIryoKikanZen(txtIryoKikanZen);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinGangoZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtYubinGangoZen();
    }

    @JsonIgnore
    public void  setTxtYubinGangoZen(TextBoxYubinNo txtYubinGangoZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtYubinGangoZen(txtYubinGangoZen);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJushoZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtJushoZen();
    }

    @JsonIgnore
    public void  setTxtJushoZen(TextBoxJusho txtJushoZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtJushoZen(txtJushoZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoIkenshoZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtDenwaBangoIkenshoZen();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoIkenshoZen(TextBoxTelNo txtDenwaBangoIkenshoZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtDenwaBangoIkenshoZen(txtDenwaBangoIkenshoZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxIkenshoZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtFaxIkenshoZen();
    }

    @JsonIgnore
    public void  setTxtFaxIkenshoZen(TextBoxTelNo txtFaxIkenshoZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtFaxIkenshoZen(txtFaxIkenshoZen);
    }

    @JsonIgnore
    public TextBox getTxtIryoKikanDaihyoshaShimeiZen() {
        return this.getTblIkensho().getZenkaiShujiiIraiJoho().getTxtIryoKikanDaihyoshaShimeiZen();
    }

    @JsonIgnore
    public void  setTxtIryoKikanDaihyoshaShimeiZen(TextBox txtIryoKikanDaihyoshaShimeiZen) {
        this.getTblIkensho().getZenkaiShujiiIraiJoho().setTxtIryoKikanDaihyoshaShimeiZen(txtIryoKikanDaihyoshaShimeiZen);
    }

    // </editor-fold>
}
