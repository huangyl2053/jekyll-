package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2410001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabPanel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * tblNinteichosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class tblNinteichosaDiv extends TabPanel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("KonkaiHomonChosaIraiJoho")
    private KonkaiHomonChosaIraiJohoDiv KonkaiHomonChosaIraiJoho;
    @JsonProperty("ZenkaiHomonChosaIraiJoho")
    private ZenkaiHomonChosaIraiJohoDiv ZenkaiHomonChosaIraiJoho;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getKonkaiHomonChosaIraiJoho
     * @return KonkaiHomonChosaIraiJoho
     */
    @JsonProperty("KonkaiHomonChosaIraiJoho")
    public KonkaiHomonChosaIraiJohoDiv getKonkaiHomonChosaIraiJoho() {
        return KonkaiHomonChosaIraiJoho;
    }

    /*
     * setKonkaiHomonChosaIraiJoho
     * @param KonkaiHomonChosaIraiJoho KonkaiHomonChosaIraiJoho
     */
    @JsonProperty("KonkaiHomonChosaIraiJoho")
    public void setKonkaiHomonChosaIraiJoho(KonkaiHomonChosaIraiJohoDiv KonkaiHomonChosaIraiJoho) {
        this.KonkaiHomonChosaIraiJoho = KonkaiHomonChosaIraiJoho;
    }

    /*
     * getZenkaiHomonChosaIraiJoho
     * @return ZenkaiHomonChosaIraiJoho
     */
    @JsonProperty("ZenkaiHomonChosaIraiJoho")
    public ZenkaiHomonChosaIraiJohoDiv getZenkaiHomonChosaIraiJoho() {
        return ZenkaiHomonChosaIraiJoho;
    }

    /*
     * setZenkaiHomonChosaIraiJoho
     * @param ZenkaiHomonChosaIraiJoho ZenkaiHomonChosaIraiJoho
     */
    @JsonProperty("ZenkaiHomonChosaIraiJoho")
    public void setZenkaiHomonChosaIraiJoho(ZenkaiHomonChosaIraiJohoDiv ZenkaiHomonChosaIraiJoho) {
        this.ZenkaiHomonChosaIraiJoho = ZenkaiHomonChosaIraiJoho;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblShinkiChosa() {
        return this.getKonkaiHomonChosaIraiJoho().getLblShinkiChosa();
    }

    @JsonIgnore
    public void  setLblShinkiChosa(Label lblShinkiChosa) {
        this.getKonkaiHomonChosaIraiJoho().setLblShinkiChosa(lblShinkiChosa);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubun() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaBashoKubun();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubun(TextBox txtChosaBashoKubun) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaBashoKubun(txtChosaBashoKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibi() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaJisshibi();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibi(TextBoxDate txtChosaJisshibi) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaJisshibi(txtChosaJisshibi);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCode() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCode();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCode(TextBoxCode txtChosaJIsshiChikuCode) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCode(txtChosaJIsshiChikuCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChiku() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChiku();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChiku(TextBox txtChosaJIsshiChiku) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChiku(txtChosaJIsshiChiku);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCode() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaKikanCode();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCode(TextBoxCode txtChosaKikanCode) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaKikanCode(txtChosaKikanCode);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikan() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaKikan();
    }

    @JsonIgnore
    public void  setTxtChosaKikan(TextBox txtChosaKikan) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaKikan(txtChosaKikan);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubun() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaItakuKubun();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubun(TextBox txtChosaItakuKubun) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaItakuKubun(txtChosaItakuKubun);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCode() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosainCode();
    }

    @JsonIgnore
    public void  setTxtChosainCode(TextBoxCode txtChosainCode) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosainCode(txtChosainCode);
    }

    @JsonIgnore
    public TextBox getTxtChosain() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosain();
    }

    @JsonIgnore
    public void  setTxtChosain(TextBox txtChosain) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosain(txtChosain);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikaku() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosainShikaku();
    }

    @JsonIgnore
    public void  setTxtChosainShikaku(TextBox txtChosainShikaku) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosainShikaku(txtChosainShikaku);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBango() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtDenwaBango();
    }

    @JsonIgnore
    public void  setTxtDenwaBango(TextBoxTelNo txtDenwaBango) {
        this.getKonkaiHomonChosaIraiJoho().setTxtDenwaBango(txtDenwaBango);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFax() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtFax();
    }

    @JsonIgnore
    public void  setTxtFax(TextBoxTelNo txtFax) {
        this.getKonkaiHomonChosaIraiJoho().setTxtFax(txtFax);
    }

    @JsonIgnore
    public Label getLblSaiChosa() {
        return this.getKonkaiHomonChosaIraiJoho().getLblSaiChosa();
    }

    @JsonIgnore
    public void  setLblSaiChosa(Label lblSaiChosa) {
        this.getKonkaiHomonChosaIraiJoho().setLblSaiChosa(lblSaiChosa);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubunSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaBashoKubunSai();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubunSai(TextBox txtChosaBashoKubunSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaBashoKubunSai(txtChosaBashoKubunSai);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibiSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaJisshibiSai();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibiSai(TextBoxDate txtChosaJisshibiSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaJisshibiSai(txtChosaJisshibiSai);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCodeSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCodeSai();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCodeSai(TextBoxCode txtChosaJIsshiChikuCodeSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCodeSai(txtChosaJIsshiChikuCodeSai);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChikuSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuSai();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuSai(TextBox txtChosaJIsshiChikuSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuSai(txtChosaJIsshiChikuSai);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCodeSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaKikanCodeSai();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCodeSai(TextBoxCode txtChosaKikanCodeSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaKikanCodeSai(txtChosaKikanCodeSai);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikanSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaKikanSai();
    }

    @JsonIgnore
    public void  setTxtChosaKikanSai(TextBox txtChosaKikanSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaKikanSai(txtChosaKikanSai);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubunSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosaItakuKubunSai();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubunSai(TextBox txtChosaItakuKubunSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosaItakuKubunSai(txtChosaItakuKubunSai);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCodeSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosainCodeSai();
    }

    @JsonIgnore
    public void  setTxtChosainCodeSai(TextBoxCode txtChosainCodeSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosainCodeSai(txtChosainCodeSai);
    }

    @JsonIgnore
    public TextBox getTxtChosainSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosainSai();
    }

    @JsonIgnore
    public void  setTxtChosainSai(TextBox txtChosainSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosainSai(txtChosainSai);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikakuSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtChosainShikakuSai();
    }

    @JsonIgnore
    public void  setTxtChosainShikakuSai(TextBox txtChosainShikakuSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtChosainShikakuSai(txtChosainShikakuSai);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtDenwaBangoSai();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoSai(TextBoxTelNo txtDenwaBangoSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtDenwaBangoSai(txtDenwaBangoSai);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxSai() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtFaxSai();
    }

    @JsonIgnore
    public void  setTxtFaxSai(TextBoxTelNo txtFaxSai) {
        this.getKonkaiHomonChosaIraiJoho().setTxtFaxSai(txtFaxSai);
    }

    @JsonIgnore
    public TextBox getTxtHomonUmu() {
        return this.getKonkaiHomonChosaIraiJoho().getTxtHomonUmu();
    }

    @JsonIgnore
    public void  setTxtHomonUmu(TextBox txtHomonUmu) {
        this.getKonkaiHomonChosaIraiJoho().setTxtHomonUmu(txtHomonUmu);
    }

    @JsonIgnore
    public Label getLblShinkiChosaZen() {
        return this.getZenkaiHomonChosaIraiJoho().getLblShinkiChosaZen();
    }

    @JsonIgnore
    public void  setLblShinkiChosaZen(Label lblShinkiChosaZen) {
        this.getZenkaiHomonChosaIraiJoho().setLblShinkiChosaZen(lblShinkiChosaZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubunZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaBashoKubunZen();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubunZen(TextBox txtChosaBashoKubunZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaBashoKubunZen(txtChosaBashoKubunZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaJisshibiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibiZen(TextBoxDate txtChosaJisshibiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaJisshibiZen(txtChosaJisshibiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCodeZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCodeZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCodeZen(TextBoxCode txtChosaJIsshiChikuCodeZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCodeZen(txtChosaJIsshiChikuCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChikuZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuZen(TextBox txtChosaJIsshiChikuZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuZen(txtChosaJIsshiChikuZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCodeZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaKikanCodeZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCodeZen(TextBoxCode txtChosaKikanCodeZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaKikanCodeZen(txtChosaKikanCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikanZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaKikanZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanZen(TextBox txtChosaKikanZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaKikanZen(txtChosaKikanZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubunZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaItakuKubunZen();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubunZen(TextBox txtChosaItakuKubunZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaItakuKubunZen(txtChosaItakuKubunZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCodeZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosainCodeZen();
    }

    @JsonIgnore
    public void  setTxtChosainCodeZen(TextBoxCode txtChosainCodeZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosainCodeZen(txtChosainCodeZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosainZen();
    }

    @JsonIgnore
    public void  setTxtChosainZen(TextBox txtChosainZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosainZen(txtChosainZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikakuZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosainShikakuZen();
    }

    @JsonIgnore
    public void  setTxtChosainShikakuZen(TextBox txtChosainShikakuZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosainShikakuZen(txtChosainShikakuZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtDenwaBangoZen();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoZen(TextBoxTelNo txtDenwaBangoZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtDenwaBangoZen(txtDenwaBangoZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtFaxZen();
    }

    @JsonIgnore
    public void  setTxtFaxZen(TextBoxTelNo txtFaxZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtFaxZen(txtFaxZen);
    }

    @JsonIgnore
    public Label getLblSaiChosaZen() {
        return this.getZenkaiHomonChosaIraiJoho().getLblSaiChosaZen();
    }

    @JsonIgnore
    public void  setLblSaiChosaZen(Label lblSaiChosaZen) {
        this.getZenkaiHomonChosaIraiJoho().setLblSaiChosaZen(lblSaiChosaZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaBashoKubunSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaBashoKubunSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaBashoKubunSaiZen(TextBox txtChosaBashoKubunSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaBashoKubunSaiZen(txtChosaBashoKubunSaiZen);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaJisshibiSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaJisshibiSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJisshibiSaiZen(TextBoxDate txtChosaJisshibiSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaJisshibiSaiZen(txtChosaJisshibiSaiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaJIsshiChikuCodeSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuCodeSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuCodeSaiZen(TextBoxCode txtChosaJIsshiChikuCodeSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuCodeSaiZen(txtChosaJIsshiChikuCodeSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaJIsshiChikuSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaJIsshiChikuSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaJIsshiChikuSaiZen(TextBox txtChosaJIsshiChikuSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaJIsshiChikuSaiZen(txtChosaJIsshiChikuSaiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosaKikanCodeSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaKikanCodeSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanCodeSaiZen(TextBoxCode txtChosaKikanCodeSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaKikanCodeSaiZen(txtChosaKikanCodeSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaKikanSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaKikanSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaKikanSaiZen(TextBox txtChosaKikanSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaKikanSaiZen(txtChosaKikanSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosaItakuKubunSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosaItakuKubunSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosaItakuKubunSaiZen(TextBox txtChosaItakuKubunSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosaItakuKubunSaiZen(txtChosaItakuKubunSaiZen);
    }

    @JsonIgnore
    public TextBoxCode getTxtChosainCodeSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosainCodeSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosainCodeSaiZen(TextBoxCode txtChosainCodeSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosainCodeSaiZen(txtChosainCodeSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosainSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosainSaiZen(TextBox txtChosainSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosainSaiZen(txtChosainSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtChosainShikakuSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtChosainShikakuSaiZen();
    }

    @JsonIgnore
    public void  setTxtChosainShikakuSaiZen(TextBox txtChosainShikakuSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtChosainShikakuSaiZen(txtChosainShikakuSaiZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDenwaBangoSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtDenwaBangoSaiZen();
    }

    @JsonIgnore
    public void  setTxtDenwaBangoSaiZen(TextBoxTelNo txtDenwaBangoSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtDenwaBangoSaiZen(txtDenwaBangoSaiZen);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtFaxSaiZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtFaxSaiZen();
    }

    @JsonIgnore
    public void  setTxtFaxSaiZen(TextBoxTelNo txtFaxSaiZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtFaxSaiZen(txtFaxSaiZen);
    }

    @JsonIgnore
    public TextBox getTxtHomonUmuZen() {
        return this.getZenkaiHomonChosaIraiJoho().getTxtHomonUmuZen();
    }

    @JsonIgnore
    public void  setTxtHomonUmuZen(TextBox txtHomonUmuZen) {
        this.getZenkaiHomonChosaIraiJoho().setTxtHomonUmuZen(txtHomonUmuZen);
    }

    // </editor-fold>
}
