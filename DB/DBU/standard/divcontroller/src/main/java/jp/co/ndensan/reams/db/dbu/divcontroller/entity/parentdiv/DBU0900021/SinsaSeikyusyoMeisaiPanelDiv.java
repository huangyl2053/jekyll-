package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0900021;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoatenainfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.parentdiv.kaigoshikakukihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DropDownList;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.RadioButton;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBox;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxDate;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxMultiLine;
import jp.co.ndensan.reams.uz.uza.ui.binding.TextBoxYubinNo;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxAtenaMeisho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxJusho;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.TextBoxTelNo;

/**
 * SinsaSeikyusyoMeisaiPanel のクラスファイル
 *
 * @author 自動生成
 */
public class SinsaSeikyusyoMeisaiPanelDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：バージョン情報無し">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("AtenaPanel")
    private AtenaPanelDiv AtenaPanel;
    @JsonProperty("KaigoShikakukihonPanel")
    private KaigoShikakukihonPanelDiv KaigoShikakukihonPanel;
    @JsonProperty("修正前の値")
    private RString 修正前の値;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getAtenaPanel
     * @return AtenaPanel
     */
    @JsonProperty("AtenaPanel")
    public AtenaPanelDiv getAtenaPanel() {
        return AtenaPanel;
    }

    /*
     * setAtenaPanel
     * @param AtenaPanel AtenaPanel
     */
    @JsonProperty("AtenaPanel")
    public void setAtenaPanel(AtenaPanelDiv AtenaPanel) {
        this.AtenaPanel = AtenaPanel;
    }

    /*
     * getKaigoShikakukihonPanel
     * @return KaigoShikakukihonPanel
     */
    @JsonProperty("KaigoShikakukihonPanel")
    public KaigoShikakukihonPanelDiv getKaigoShikakukihonPanel() {
        return KaigoShikakukihonPanel;
    }

    /*
     * setKaigoShikakukihonPanel
     * @param KaigoShikakukihonPanel KaigoShikakukihonPanel
     */
    @JsonProperty("KaigoShikakukihonPanel")
    public void setKaigoShikakukihonPanel(KaigoShikakukihonPanelDiv KaigoShikakukihonPanel) {
        this.KaigoShikakukihonPanel = KaigoShikakukihonPanel;
    }

    /*
     * get修正前の値
     * @return 修正前の値
     */
    @JsonProperty("修正前の値")
    public RString get修正前の値() {
        return 修正前の値;
    }

    /*
     * set修正前の値
     * @param 修正前の値 修正前の値
     */
    @JsonProperty("修正前の値")
    public void set修正前の値(RString 修正前の値) {
        this.修正前の値 = 修正前の値;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return this.getAtenaPanel().getCcdKanryoMessage();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getAtenaInfoCommonChildDiv() {
        return this.getAtenaPanel().getAtenaInfoCommonChildDiv();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getKaigoShikakuKihonCommonChildDiv() {
        return this.getAtenaPanel().getKaigoShikakuKihonCommonChildDiv();
    }

    @JsonIgnore
    public MeisaiPanelDiv getMeisaiPanel() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel();
    }

    @JsonIgnore
    public void setMeisaiPanel(MeisaiPanelDiv MeisaiPanel) {
        this.getKaigoShikakukihonPanel().setMeisaiPanel(MeisaiPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtdateTodokedebi() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getTxtdateTodokedebi();
    }

    @JsonIgnore
    public void setTxtdateTodokedebi(TextBoxDate txtdateTodokedebi) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().setTxtdateTodokedebi(txtdateTodokedebi);
    }

    @JsonIgnore
    public SinsaSeikyuninJohoPanelDiv getSinsaSeikyuninJohoPanel() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel();
    }

    @JsonIgnore
    public void setSinsaSeikyuninJohoPanel(SinsaSeikyuninJohoPanelDiv SinsaSeikyuninJohoPanel) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().setSinsaSeikyuninJohoPanel(SinsaSeikyuninJohoPanel);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtYubinNo() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().getTxtYubinNo();
    }

    @JsonIgnore
    public void setTxtYubinNo(TextBoxYubinNo txtYubinNo) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().setTxtYubinNo(txtYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtJusho() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().getTxtJusho();
    }

    @JsonIgnore
    public void setTxtJusho(TextBoxJusho txtJusho) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().setTxtJusho(txtJusho);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtShinsaSeikyuJinShimei() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().getTxtShinsaSeikyuJinShimei();
    }

    @JsonIgnore
    public void setTxtShinsaSeikyuJinShimei(TextBoxAtenaMeisho txtShinsaSeikyuJinShimei) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().setTxtShinsaSeikyuJinShimei(txtShinsaSeikyuJinShimei);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtTelNo() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().getTxtTelNo();
    }

    @JsonIgnore
    public void setTxtTelNo(TextBoxTelNo txtTelNo) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().setTxtTelNo(txtTelNo);
    }

    @JsonIgnore
    public DropDownList getDdlHihokenyakanko() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().getDdlHihokenyakanko();
    }

    @JsonIgnore
    public void setDdlHihokenyakanko(DropDownList ddlHihokenyakanko) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().setDdlHihokenyakanko(ddlHihokenyakanko);
    }

    @JsonIgnore
    public TextBox getTxtHihokensyatonokanken() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().getTxtHihokensyatonokanken();
    }

    @JsonIgnore
    public void setTxtHihokensyatonokanken(TextBox txtHihokensyatonokanken) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getSinsaSeikyuninJohoPanel().setTxtHihokensyatonokanken(txtHihokensyatonokanken);
    }

    @JsonIgnore
    public DaiiniJohoPanelDiv getDaiiniJohoPanel() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getDaiiniJohoPanel();
    }

    @JsonIgnore
    public void setDaiiniJohoPanel(DaiiniJohoPanelDiv DaiiniJohoPanel) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().setDaiiniJohoPanel(DaiiniJohoPanel);
    }

    @JsonIgnore
    public TextBoxYubinNo getTxtDairiYubinNo() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getDaiiniJohoPanel().getTxtDairiYubinNo();
    }

    @JsonIgnore
    public void setTxtDairiYubinNo(TextBoxYubinNo txtDairiYubinNo) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getDaiiniJohoPanel().setTxtDairiYubinNo(txtDairiYubinNo);
    }

    @JsonIgnore
    public TextBoxJusho getTxtDairiJusho() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getDaiiniJohoPanel().getTxtDairiJusho();
    }

    @JsonIgnore
    public void setTxtDairiJusho(TextBoxJusho txtDairiJusho) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getDaiiniJohoPanel().setTxtDairiJusho(txtDairiJusho);
    }

    @JsonIgnore
    public TextBoxAtenaMeisho getTxtDairiJinJohoShimei() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getDaiiniJohoPanel().getTxtDairiJinJohoShimei();
    }

    @JsonIgnore
    public void setTxtDairiJinJohoShimei(TextBoxAtenaMeisho txtDairiJinJohoShimei) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getDaiiniJohoPanel().setTxtDairiJinJohoShimei(txtDairiJinJohoShimei);
    }

    @JsonIgnore
    public TextBoxTelNo getTxtDairiTelNo() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getDaiiniJohoPanel().getTxtDairiTelNo();
    }

    @JsonIgnore
    public void setTxtDairiTelNo(TextBoxTelNo txtDairiTelNo) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getDaiiniJohoPanel().setTxtDairiTelNo(txtDairiTelNo);
    }

    @JsonIgnore
    public SyobunJohoPanelDiv getSyobunJohoPanel() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSyobunJohoPanel();
    }

    @JsonIgnore
    public void setSyobunJohoPanel(SyobunJohoPanelDiv SyobunJohoPanel) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().setSyobunJohoPanel(SyobunJohoPanel);
    }

    @JsonIgnore
    public TextBoxDate getTxtShobubi() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSyobunJohoPanel().getTxtShobubi();
    }

    @JsonIgnore
    public void setTxtShobubi(TextBoxDate txtShobubi) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getSyobunJohoPanel().setTxtShobubi(txtShobubi);
    }

    @JsonIgnore
    public TextBox getTxtShobucho() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSyobunJohoPanel().getTxtShobucho();
    }

    @JsonIgnore
    public void setTxtShobucho(TextBox txtShobucho) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getSyobunJohoPanel().setTxtShobucho(txtShobucho);
    }

    @JsonIgnore
    public DropDownList getDdlShobuShurui() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSyobunJohoPanel().getDdlShobuShurui();
    }

    @JsonIgnore
    public void setDdlShobuShurui(DropDownList ddlShobuShurui) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getSyobunJohoPanel().setDdlShobuShurui(ddlShobuShurui);
    }

    @JsonIgnore
    public TextBoxDate getTxtShobuShitaNichi() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getSyobunJohoPanel().getTxtShobuShitaNichi();
    }

    @JsonIgnore
    public void setTxtShobuShitaNichi(TextBoxDate txtShobuShitaNichi) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().getSyobunJohoPanel().setTxtShobuShitaNichi(txtShobuShitaNichi);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinsaSeikyuRiyu() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getTxtShinsaSeikyuRiyu();
    }

    @JsonIgnore
    public void setTxtShinsaSeikyuRiyu(TextBoxMultiLine txtShinsaSeikyuRiyu) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().setTxtShinsaSeikyuRiyu(txtShinsaSeikyuRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtKyoshiNaiyo() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getTxtKyoshiNaiyo();
    }

    @JsonIgnore
    public void setTxtKyoshiNaiyo(TextBoxMultiLine txtKyoshiNaiyo) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().setTxtKyoshiNaiyo(txtKyoshiNaiyo);
    }

    @JsonIgnore
    public RadioButton getRadTenpuShorui() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getRadTenpuShorui();
    }

    @JsonIgnore
    public void setRadTenpuShorui(RadioButton radTenpuShorui) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().setRadTenpuShorui(radTenpuShorui);
    }

    @JsonIgnore
    public TextBoxDate getTxtShinsaSeikyuTorisage() {
        return this.getKaigoShikakukihonPanel().getMeisaiPanel().getTxtShinsaSeikyuTorisage();
    }

    @JsonIgnore
    public void setTxtShinsaSeikyuTorisage(TextBoxDate txtShinsaSeikyuTorisage) {
        this.getKaigoShikakukihonPanel().getMeisaiPanel().setTxtShinsaSeikyuTorisage(txtShinsaSeikyuTorisage);
    }

    // </editor-fold>
}
