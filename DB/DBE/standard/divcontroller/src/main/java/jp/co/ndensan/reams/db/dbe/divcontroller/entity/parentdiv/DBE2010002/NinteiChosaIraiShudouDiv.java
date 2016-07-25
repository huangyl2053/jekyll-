package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002;
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

/**
 * NinteiChosaIraiShudou のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaIraiShudouDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaIraiByHand")
    private NinteichosaIraiByHandDiv NinteichosaIraiByHand;
    @JsonProperty("IraiprintPanel")
    private IraiprintPanelDiv IraiprintPanel;
    @JsonProperty("ccdNinteiShinseishaKihonInfo")
    private NinteiShinseishaKihonInfoDiv ccdNinteiShinseishaKihonInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteichosaIraiByHand
     * @return NinteichosaIraiByHand
     */
    @JsonProperty("NinteichosaIraiByHand")
    public NinteichosaIraiByHandDiv getNinteichosaIraiByHand() {
        return NinteichosaIraiByHand;
    }

    /*
     * setNinteichosaIraiByHand
     * @param NinteichosaIraiByHand NinteichosaIraiByHand
     */
    @JsonProperty("NinteichosaIraiByHand")
    public void setNinteichosaIraiByHand(NinteichosaIraiByHandDiv NinteichosaIraiByHand) {
        this.NinteichosaIraiByHand = NinteichosaIraiByHand;
    }

    /*
     * getIraiprintPanel
     * @return IraiprintPanel
     */
    @JsonProperty("IraiprintPanel")
    public IraiprintPanelDiv getIraiprintPanel() {
        return IraiprintPanel;
    }

    /*
     * setIraiprintPanel
     * @param IraiprintPanel IraiprintPanel
     */
    @JsonProperty("IraiprintPanel")
    public void setIraiprintPanel(IraiprintPanelDiv IraiprintPanel) {
        this.IraiprintPanel = IraiprintPanel;
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
    public CheckBoxList getChkIrai() {
        return this.getIraiprintPanel().getChkIrai();
    }

    @JsonIgnore
    public void  setChkIrai(CheckBoxList chkIrai) {
        this.getIraiprintPanel().setChkIrai(chkIrai);
    }

    @JsonIgnore
    public TextBoxDate getTxtHokkoymd() {
        return this.getIraiprintPanel().getTxtHokkoymd();
    }

    @JsonIgnore
    public void  setTxtHokkoymd(TextBoxDate txtHokkoymd) {
        this.getIraiprintPanel().setTxtHokkoymd(txtHokkoymd);
    }

    @JsonIgnore
    public RadioButton getRadKigen() {
        return this.getIraiprintPanel().getRadKigen();
    }

    @JsonIgnore
    public void  setRadKigen(RadioButton radKigen) {
        this.getIraiprintPanel().setRadKigen(radKigen);
    }

    @JsonIgnore
    public TextBoxDate getTxtKigenymd() {
        return this.getIraiprintPanel().getTxtKigenymd();
    }

    @JsonIgnore
    public void  setTxtKigenymd(TextBoxDate txtKigenymd) {
        this.getIraiprintPanel().setTxtKigenymd(txtKigenymd);
    }

    @JsonIgnore
    public Space getSP() {
        return this.getIraiprintPanel().getSP();
    }

    @JsonIgnore
    public void  setSP(Space SP) {
        this.getIraiprintPanel().setSP(SP);
    }

    @JsonIgnore
    public CheckBoxList getChkGaikyoChosa() {
        return this.getIraiprintPanel().getChkGaikyoChosa();
    }

    @JsonIgnore
    public void  setChkGaikyoChosa(CheckBoxList chkGaikyoChosa) {
        this.getIraiprintPanel().setChkGaikyoChosa(chkGaikyoChosa);
    }

    @JsonIgnore
    public CheckBoxList getChkKihonChosa() {
        return this.getIraiprintPanel().getChkKihonChosa();
    }

    @JsonIgnore
    public void  setChkKihonChosa(CheckBoxList chkKihonChosa) {
        this.getIraiprintPanel().setChkKihonChosa(chkKihonChosa);
    }

    @JsonIgnore
    public CheckBoxList getChkTokukiJiko() {
        return this.getIraiprintPanel().getChkTokukiJiko();
    }

    @JsonIgnore
    public void  setChkTokukiJiko(CheckBoxList chkTokukiJiko) {
        this.getIraiprintPanel().setChkTokukiJiko(chkTokukiJiko);
    }

    @JsonIgnore
    public CheckBoxList getChkGaikyoTokuki() {
        return this.getIraiprintPanel().getChkGaikyoTokuki();
    }

    @JsonIgnore
    public void  setChkGaikyoTokuki(CheckBoxList chkGaikyoTokuki) {
        this.getIraiprintPanel().setChkGaikyoTokuki(chkGaikyoTokuki);
    }

    @JsonIgnore
    public CheckBoxList getChkGaikyoChosaOCR() {
        return this.getIraiprintPanel().getChkGaikyoChosaOCR();
    }

    @JsonIgnore
    public void  setChkGaikyoChosaOCR(CheckBoxList chkGaikyoChosaOCR) {
        this.getIraiprintPanel().setChkGaikyoChosaOCR(chkGaikyoChosaOCR);
    }

    @JsonIgnore
    public CheckBoxList getChkKihonChosaOCR() {
        return this.getIraiprintPanel().getChkKihonChosaOCR();
    }

    @JsonIgnore
    public void  setChkKihonChosaOCR(CheckBoxList chkKihonChosaOCR) {
        this.getIraiprintPanel().setChkKihonChosaOCR(chkKihonChosaOCR);
    }

    @JsonIgnore
    public CheckBoxList getChkTokukiJikoOCR() {
        return this.getIraiprintPanel().getChkTokukiJikoOCR();
    }

    @JsonIgnore
    public void  setChkTokukiJikoOCR(CheckBoxList chkTokukiJikoOCR) {
        this.getIraiprintPanel().setChkTokukiJikoOCR(chkTokukiJikoOCR);
    }

    @JsonIgnore
    public CheckBoxList getChkGaikyoTokukiOCR() {
        return this.getIraiprintPanel().getChkGaikyoTokukiOCR();
    }

    @JsonIgnore
    public void  setChkGaikyoTokukiOCR(CheckBoxList chkGaikyoTokukiOCR) {
        this.getIraiprintPanel().setChkGaikyoTokukiOCR(chkGaikyoTokukiOCR);
    }

    @JsonIgnore
    public CheckBoxList getChkSaiCheck() {
        return this.getIraiprintPanel().getChkSaiCheck();
    }

    @JsonIgnore
    public void  setChkSaiCheck(CheckBoxList chkSaiCheck) {
        this.getIraiprintPanel().setChkSaiCheck(chkSaiCheck);
    }

    @JsonIgnore
    public CheckBoxList getChkFuriYoshi() {
        return this.getIraiprintPanel().getChkFuriYoshi();
    }

    @JsonIgnore
    public void  setChkFuriYoshi(CheckBoxList chkFuriYoshi) {
        this.getIraiprintPanel().setChkFuriYoshi(chkFuriYoshi);
    }

    @JsonIgnore
    public CheckBoxList getChkRirekiIchiran() {
        return this.getIraiprintPanel().getChkRirekiIchiran();
    }

    @JsonIgnore
    public void  setChkRirekiIchiran(CheckBoxList chkRirekiIchiran) {
        this.getIraiprintPanel().setChkRirekiIchiran(chkRirekiIchiran);
    }

    // </editor-fold>
}
