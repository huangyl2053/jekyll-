package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * KaigoShikakukihonPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoShikakukihonPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("MeisaiPanel")
    private MeisaiPanelDiv MeisaiPanel;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getMeisaiPanel
     * @return MeisaiPanel
     */
    @JsonProperty("MeisaiPanel")
    public MeisaiPanelDiv getMeisaiPanel() {
        return MeisaiPanel;
    }

    /*
     * setMeisaiPanel
     * @param MeisaiPanel MeisaiPanel
     */
    @JsonProperty("MeisaiPanel")
    public void setMeisaiPanel(MeisaiPanelDiv MeisaiPanel) {
        this.MeisaiPanel = MeisaiPanel;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtdateTodokedebi() {
        return this.getMeisaiPanel().getTxtdateTodokedebi();
    }

    @JsonIgnore
    public void  setTxtdateTodokedebi(TextBoxDate txtdateTodokedebi) {
        this.getMeisaiPanel().setTxtdateTodokedebi(txtdateTodokedebi);
    }

    @JsonIgnore
    public SinsaSeikyuninJohoPanelDiv getSinsaSeikyuninJohoPanel() {
        return this.getMeisaiPanel().getSinsaSeikyuninJohoPanel();
    }

    @JsonIgnore
    public void  setSinsaSeikyuninJohoPanel(SinsaSeikyuninJohoPanelDiv SinsaSeikyuninJohoPanel) {
        this.getMeisaiPanel().setSinsaSeikyuninJohoPanel(SinsaSeikyuninJohoPanel);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtShinsaSeikyuJinShimei() {
        return this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei();
    }

    @JsonIgnore
    public void  setTxtShinsaSeikyuJinShimei(TextBoxAtenaMeisho txtShinsaSeikyuJinShimei) {
        this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().setTxtShinsaSeikyuJinShimei(txtShinsaSeikyuJinShimei);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenyakanko() {
        return this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko();
    }

    @JsonIgnore
    public void  setDdlHihokenyakanko(DropDownList ddlHihokenyakanko) {
        this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().setDdlHihokenyakanko(ddlHihokenyakanko);
    }

    @JsonIgnore
    public TextBox getTxtHihokensyatonokanken() {
        return this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken();
    }

    @JsonIgnore
    public void  setTxtHihokensyatonokanken(TextBox txtHihokensyatonokanken) {
        this.getMeisaiPanel().getSinsaSeikyuninJohoPanel().setTxtHihokensyatonokanken(txtHihokensyatonokanken);
    }

    @JsonIgnore
    public DaiiniJohoPanelDiv getDaiiniJohoPanel() {
        return this.getMeisaiPanel().getDaiiniJohoPanel();
    }

    @JsonIgnore
    public void  setDaiiniJohoPanel(DaiiniJohoPanelDiv DaiiniJohoPanel) {
        this.getMeisaiPanel().setDaiiniJohoPanel(DaiiniJohoPanel);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtDairiYubinNo() {
        return this.getMeisaiPanel().getDaiiniJohoPanel().getTxtDairiYubinNo();
    }

    @JsonIgnore
    public void  setTxtDairiYubinNo(TextBoxYubinNo txtDairiYubinNo) {
        this.getMeisaiPanel().getDaiiniJohoPanel().setTxtDairiYubinNo(txtDairiYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtDairiJusho() {
        return this.getMeisaiPanel().getDaiiniJohoPanel().getTxtDairiJusho();
    }

    @JsonIgnore
    public void  setTxtDairiJusho(TextBoxJusho txtDairiJusho) {
        this.getMeisaiPanel().getDaiiniJohoPanel().setTxtDairiJusho(txtDairiJusho);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtDairiJinJohoShimei() {
        return this.getMeisaiPanel().getDaiiniJohoPanel().getTxtDairiJinJohoShimei();
    }

    @JsonIgnore
    public void  setTxtDairiJinJohoShimei(TextBoxAtenaMeisho txtDairiJinJohoShimei) {
        this.getMeisaiPanel().getDaiiniJohoPanel().setTxtDairiJinJohoShimei(txtDairiJinJohoShimei);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDairiTelNo() {
        return this.getMeisaiPanel().getDaiiniJohoPanel().getTxtDairiTelNo();
    }

    @JsonIgnore
    public void  setTxtDairiTelNo(TextBoxTelNo txtDairiTelNo) {
        this.getMeisaiPanel().getDaiiniJohoPanel().setTxtDairiTelNo(txtDairiTelNo);
    }

    @JsonIgnore
    public SyobunJohoPanelDiv getSyobunJohoPanel() {
        return this.getMeisaiPanel().getSyobunJohoPanel();
    }

    @JsonIgnore
    public void  setSyobunJohoPanel(SyobunJohoPanelDiv SyobunJohoPanel) {
        this.getMeisaiPanel().setSyobunJohoPanel(SyobunJohoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtShobubi() {
        return this.getMeisaiPanel().getSyobunJohoPanel().getTxtShobubi();
    }

    @JsonIgnore
    public void  setTxtShobubi(TextBoxDate txtShobubi) {
        this.getMeisaiPanel().getSyobunJohoPanel().setTxtShobubi(txtShobubi);
    }

    @JsonIgnore
    public TextBox getTxtShobucho() {
        return this.getMeisaiPanel().getSyobunJohoPanel().getTxtShobucho();
    }

    @JsonIgnore
    public void  setTxtShobucho(TextBox txtShobucho) {
        this.getMeisaiPanel().getSyobunJohoPanel().setTxtShobucho(txtShobucho);
    }

    @JsonIgnore
    public DropDownList getDdlShobuShurui() {
        return this.getMeisaiPanel().getSyobunJohoPanel().getDdlShobuShurui();
    }

    @JsonIgnore
    public void  setDdlShobuShurui(DropDownList ddlShobuShurui) {
        this.getMeisaiPanel().getSyobunJohoPanel().setDdlShobuShurui(ddlShobuShurui);
    }

    @JsonIgnore
    public TextBoxDate getTxtShobuShitaNichi() {
        return this.getMeisaiPanel().getSyobunJohoPanel().getTxtShobuShitaNichi();
    }

    @JsonIgnore
    public void  setTxtShobuShitaNichi(TextBoxDate txtShobuShitaNichi) {
        this.getMeisaiPanel().getSyobunJohoPanel().setTxtShobuShitaNichi(txtShobuShitaNichi);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinsaSeikyuRiyu() {
        return this.getMeisaiPanel().getTxtShinsaSeikyuRiyu();
    }

    @JsonIgnore
    public void  setTxtShinsaSeikyuRiyu(TextBoxMultiLine txtShinsaSeikyuRiyu) {
        this.getMeisaiPanel().setTxtShinsaSeikyuRiyu(txtShinsaSeikyuRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyoshiNaiyo() {
        return this.getMeisaiPanel().getTxtKyoshiNaiyo();
    }

    @JsonIgnore
    public void  setTxtKyoshiNaiyo(TextBoxMultiLine txtKyoshiNaiyo) {
        this.getMeisaiPanel().setTxtKyoshiNaiyo(txtKyoshiNaiyo);
    }

    @JsonIgnore
    public RadioButton getRadTenpuShorui() {
        return this.getMeisaiPanel().getRadTenpuShorui();
    }

    @JsonIgnore
    public void  setRadTenpuShorui(RadioButton radTenpuShorui) {
        this.getMeisaiPanel().setRadTenpuShorui(radTenpuShorui);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaSeikyuTorisage() {
        return this.getMeisaiPanel().getTxtShinsaSeikyuTorisage();
    }

    @JsonIgnore
    public void  setTxtShinsaSeikyuTorisage(TextBoxDate txtShinsaSeikyuTorisage) {
        this.getMeisaiPanel().setTxtShinsaSeikyuTorisage(txtShinsaSeikyuTorisage);
    }

    // </editor-fold>
}
