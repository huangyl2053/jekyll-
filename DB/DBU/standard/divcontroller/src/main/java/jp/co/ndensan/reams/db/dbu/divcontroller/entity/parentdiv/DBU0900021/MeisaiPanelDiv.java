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
 * MeisaiPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class MeisaiPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("txtdateTodokedebi")
    private TextBoxDate txtdateTodokedebi;
    @JsonProperty("SinsaSeikyuninJohoPanel")
    private SinsaSeikyuninJohoPanelDiv SinsaSeikyuninJohoPanel;
    @JsonProperty("DaiiniJohoPanel")
    private DaiiniJohoPanelDiv DaiiniJohoPanel;
    @JsonProperty("SyobunJohoPanel")
    private SyobunJohoPanelDiv SyobunJohoPanel;
    @JsonProperty("txtShinsaSeikyuRiyu")
    private TextBoxMultiLine txtShinsaSeikyuRiyu;
    @JsonProperty("txtKyoshiNaiyo")
    private TextBoxMultiLine txtKyoshiNaiyo;
    @JsonProperty("radTenpuShorui")
    private RadioButton radTenpuShorui;
    @JsonProperty("txtShinsaSeikyuTorisage")
    private TextBoxDate txtShinsaSeikyuTorisage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettxtdateTodokedebi
     * @return txtdateTodokedebi
     */
    @JsonProperty("txtdateTodokedebi")
    public TextBoxDate getTxtdateTodokedebi() {
        return txtdateTodokedebi;
    }

    /*
     * settxtdateTodokedebi
     * @param txtdateTodokedebi txtdateTodokedebi
     */
    @JsonProperty("txtdateTodokedebi")
    public void setTxtdateTodokedebi(TextBoxDate txtdateTodokedebi) {
        this.txtdateTodokedebi = txtdateTodokedebi;
    }

    /*
     * getSinsaSeikyuninJohoPanel
     * @return SinsaSeikyuninJohoPanel
     */
    @JsonProperty("SinsaSeikyuninJohoPanel")
    public SinsaSeikyuninJohoPanelDiv getSinsaSeikyuninJohoPanel() {
        return SinsaSeikyuninJohoPanel;
    }

    /*
     * setSinsaSeikyuninJohoPanel
     * @param SinsaSeikyuninJohoPanel SinsaSeikyuninJohoPanel
     */
    @JsonProperty("SinsaSeikyuninJohoPanel")
    public void setSinsaSeikyuninJohoPanel(SinsaSeikyuninJohoPanelDiv SinsaSeikyuninJohoPanel) {
        this.SinsaSeikyuninJohoPanel = SinsaSeikyuninJohoPanel;
    }

    /*
     * getDaiiniJohoPanel
     * @return DaiiniJohoPanel
     */
    @JsonProperty("DaiiniJohoPanel")
    public DaiiniJohoPanelDiv getDaiiniJohoPanel() {
        return DaiiniJohoPanel;
    }

    /*
     * setDaiiniJohoPanel
     * @param DaiiniJohoPanel DaiiniJohoPanel
     */
    @JsonProperty("DaiiniJohoPanel")
    public void setDaiiniJohoPanel(DaiiniJohoPanelDiv DaiiniJohoPanel) {
        this.DaiiniJohoPanel = DaiiniJohoPanel;
    }

    /*
     * getSyobunJohoPanel
     * @return SyobunJohoPanel
     */
    @JsonProperty("SyobunJohoPanel")
    public SyobunJohoPanelDiv getSyobunJohoPanel() {
        return SyobunJohoPanel;
    }

    /*
     * setSyobunJohoPanel
     * @param SyobunJohoPanel SyobunJohoPanel
     */
    @JsonProperty("SyobunJohoPanel")
    public void setSyobunJohoPanel(SyobunJohoPanelDiv SyobunJohoPanel) {
        this.SyobunJohoPanel = SyobunJohoPanel;
    }

    /*
     * gettxtShinsaSeikyuRiyu
     * @return txtShinsaSeikyuRiyu
     */
    @JsonProperty("txtShinsaSeikyuRiyu")
    public TextBoxMultiLine getTxtShinsaSeikyuRiyu() {
        return txtShinsaSeikyuRiyu;
    }

    /*
     * settxtShinsaSeikyuRiyu
     * @param txtShinsaSeikyuRiyu txtShinsaSeikyuRiyu
     */
    @JsonProperty("txtShinsaSeikyuRiyu")
    public void setTxtShinsaSeikyuRiyu(TextBoxMultiLine txtShinsaSeikyuRiyu) {
        this.txtShinsaSeikyuRiyu = txtShinsaSeikyuRiyu;
    }

    /*
     * gettxtKyoshiNaiyo
     * @return txtKyoshiNaiyo
     */
    @JsonProperty("txtKyoshiNaiyo")
    public TextBoxMultiLine getTxtKyoshiNaiyo() {
        return txtKyoshiNaiyo;
    }

    /*
     * settxtKyoshiNaiyo
     * @param txtKyoshiNaiyo txtKyoshiNaiyo
     */
    @JsonProperty("txtKyoshiNaiyo")
    public void setTxtKyoshiNaiyo(TextBoxMultiLine txtKyoshiNaiyo) {
        this.txtKyoshiNaiyo = txtKyoshiNaiyo;
    }

    /*
     * getradTenpuShorui
     * @return radTenpuShorui
     */
    @JsonProperty("radTenpuShorui")
    public RadioButton getRadTenpuShorui() {
        return radTenpuShorui;
    }

    /*
     * setradTenpuShorui
     * @param radTenpuShorui radTenpuShorui
     */
    @JsonProperty("radTenpuShorui")
    public void setRadTenpuShorui(RadioButton radTenpuShorui) {
        this.radTenpuShorui = radTenpuShorui;
    }

    /*
     * gettxtShinsaSeikyuTorisage
     * @return txtShinsaSeikyuTorisage
     */
    @JsonProperty("txtShinsaSeikyuTorisage")
    public TextBoxDate getTxtShinsaSeikyuTorisage() {
        return txtShinsaSeikyuTorisage;
    }

    /*
     * settxtShinsaSeikyuTorisage
     * @param txtShinsaSeikyuTorisage txtShinsaSeikyuTorisage
     */
    @JsonProperty("txtShinsaSeikyuTorisage")
    public void setTxtShinsaSeikyuTorisage(TextBoxDate txtShinsaSeikyuTorisage) {
        this.txtShinsaSeikyuTorisage = txtShinsaSeikyuTorisage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getSinsaSeikyuninJohoPanel().getTxtYubinNo();
    }

    @JsonIgnore
    public void  setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getSinsaSeikyuninJohoPanel().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getSinsaSeikyuninJohoPanel().getTxtJusho();
    }

    @JsonIgnore
    public void  setTxtJusho(TextBoxJusho txtJusho) {
        this.getSinsaSeikyuninJohoPanel().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtShinsaSeikyuJinShimei() {
        return this.getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei();
    }

    @JsonIgnore
    public void  setTxtShinsaSeikyuJinShimei(TextBoxAtenaMeisho txtShinsaSeikyuJinShimei) {
        this.getSinsaSeikyuninJohoPanel().setTxtShinsaSeikyuJinShimei(txtShinsaSeikyuJinShimei);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getSinsaSeikyuninJohoPanel().getTxtTelNo();
    }

    @JsonIgnore
    public void  setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getSinsaSeikyuninJohoPanel().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenyakanko() {
        return this.getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko();
    }

    @JsonIgnore
    public void  setDdlHihokenyakanko(DropDownList ddlHihokenyakanko) {
        this.getSinsaSeikyuninJohoPanel().setDdlHihokenyakanko(ddlHihokenyakanko);
    }

    @JsonIgnore
    public TextBox getTxtHihokensyatonokanken() {
        return this.getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken();
    }

    @JsonIgnore
    public void  setTxtHihokensyatonokanken(TextBox txtHihokensyatonokanken) {
        this.getSinsaSeikyuninJohoPanel().setTxtHihokensyatonokanken(txtHihokensyatonokanken);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtDairiYubinNo() {
        return this.getDaiiniJohoPanel().getTxtDairiYubinNo();
    }

    @JsonIgnore
    public void  setTxtDairiYubinNo(TextBoxYubinNo txtDairiYubinNo) {
        this.getDaiiniJohoPanel().setTxtDairiYubinNo(txtDairiYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtDairiJusho() {
        return this.getDaiiniJohoPanel().getTxtDairiJusho();
    }

    @JsonIgnore
    public void  setTxtDairiJusho(TextBoxJusho txtDairiJusho) {
        this.getDaiiniJohoPanel().setTxtDairiJusho(txtDairiJusho);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtDairiJinJohoShimei() {
        return this.getDaiiniJohoPanel().getTxtDairiJinJohoShimei();
    }

    @JsonIgnore
    public void  setTxtDairiJinJohoShimei(TextBoxAtenaMeisho txtDairiJinJohoShimei) {
        this.getDaiiniJohoPanel().setTxtDairiJinJohoShimei(txtDairiJinJohoShimei);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDairiTelNo() {
        return this.getDaiiniJohoPanel().getTxtDairiTelNo();
    }

    @JsonIgnore
    public void  setTxtDairiTelNo(TextBoxTelNo txtDairiTelNo) {
        this.getDaiiniJohoPanel().setTxtDairiTelNo(txtDairiTelNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShobubi() {
        return this.getSyobunJohoPanel().getTxtShobubi();
    }

    @JsonIgnore
    public void  setTxtShobubi(TextBoxDate txtShobubi) {
        this.getSyobunJohoPanel().setTxtShobubi(txtShobubi);
    }

    @JsonIgnore
    public TextBox getTxtShobucho() {
        return this.getSyobunJohoPanel().getTxtShobucho();
    }

    @JsonIgnore
    public void  setTxtShobucho(TextBox txtShobucho) {
        this.getSyobunJohoPanel().setTxtShobucho(txtShobucho);
    }

    @JsonIgnore
    public DropDownList getDdlShobuShurui() {
        return this.getSyobunJohoPanel().getDdlShobuShurui();
    }

    @JsonIgnore
    public void  setDdlShobuShurui(DropDownList ddlShobuShurui) {
        this.getSyobunJohoPanel().setDdlShobuShurui(ddlShobuShurui);
    }

    @JsonIgnore
    public TextBoxDate getTxtShobuShitaNichi() {
        return this.getSyobunJohoPanel().getTxtShobuShitaNichi();
    }

    @JsonIgnore
    public void  setTxtShobuShitaNichi(TextBoxDate txtShobuShitaNichi) {
        this.getSyobunJohoPanel().setTxtShobuShitaNichi(txtShobuShitaNichi);
    }

    // </editor-fold>
}
