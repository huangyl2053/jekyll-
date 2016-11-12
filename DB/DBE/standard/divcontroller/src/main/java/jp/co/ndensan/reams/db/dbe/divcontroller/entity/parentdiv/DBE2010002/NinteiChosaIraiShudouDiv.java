package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.ChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.INinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ninteishinseishakihoninfo.NinteiShinseishaKihonInfo.NinteiShinseishaKihonInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaIraiShudou のクラスファイル
 *
 * @author 自動生成
 */
public class NinteiChosaIraiShudouDiv extends Panel {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-04_20-07-38">
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
    public DropDownList getDdlIraiKubun() {
        return this.getNinteichosaIraiByHand().getDdlIraiKubun();
    }

    @JsonIgnore
    public void setDdlIraiKubun(DropDownList ddlIraiKubun) {
        this.getNinteichosaIraiByHand().setDdlIraiKubun(ddlIraiKubun);
    }

    @JsonIgnore
    public TextBoxDate getTxtChosaIraiD() {
        return this.getNinteichosaIraiByHand().getTxtChosaIraiD();
    }

    @JsonIgnore
    public void setTxtChosaIraiD(TextBoxDate txtChosaIraiD) {
        this.getNinteichosaIraiByHand().setTxtChosaIraiD(txtChosaIraiD);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdItakusakiAndChosainInput() {
        return this.getNinteichosaIraiByHand().getCcdItakusakiAndChosainInput();
    }

    @JsonIgnore
    public CheckBoxList getChkIrai() {
        return this.getIraiprintPanel().getChkIrai();
    }

    @JsonIgnore
    public void setChkIrai(CheckBoxList chkIrai) {
        this.getIraiprintPanel().setChkIrai(chkIrai);
    }

    @JsonIgnore
    public TextBoxDate getTxtHokkoymd() {
        return this.getIraiprintPanel().getTxtHokkoymd();
    }

    @JsonIgnore
    public void setTxtHokkoymd(TextBoxDate txtHokkoymd) {
        this.getIraiprintPanel().setTxtHokkoymd(txtHokkoymd);
    }

    @JsonIgnore
    public RadioButton getRadKigen() {
        return this.getIraiprintPanel().getRadKigen();
    }

    @JsonIgnore
    public void setRadKigen(RadioButton radKigen) {
        this.getIraiprintPanel().setRadKigen(radKigen);
    }

    @JsonIgnore
    public TextBoxDate getTxtKigenymd() {
        return this.getIraiprintPanel().getTxtKigenymd();
    }

    @JsonIgnore
    public void setTxtKigenymd(TextBoxDate txtKigenymd) {
        this.getIraiprintPanel().setTxtKigenymd(txtKigenymd);
    }

    @JsonIgnore
    public NiteiChosaSelectDiv getNiteiChosaSelect() {
        return this.getIraiprintPanel().getNiteiChosaSelect();
    }

    @JsonIgnore
    public void setNiteiChosaSelect(NiteiChosaSelectDiv NiteiChosaSelect) {
        this.getIraiprintPanel().setNiteiChosaSelect(NiteiChosaSelect);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteichosaDesign() {
        return this.getIraiprintPanel().getNiteiChosaSelect().getChkNinteichosaDesign();
    }

    @JsonIgnore
    public void setChkNinteichosaDesign(CheckBoxList chkNinteichosaDesign) {
        this.getIraiprintPanel().getNiteiChosaSelect().setChkNinteichosaDesign(chkNinteichosaDesign);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteichosaOcr() {
        return this.getIraiprintPanel().getNiteiChosaSelect().getChkNinteichosaOcr();
    }

    @JsonIgnore
    public void setChkNinteichosaOcr(CheckBoxList chkNinteichosaOcr) {
        this.getIraiprintPanel().getNiteiChosaSelect().setChkNinteichosaOcr(chkNinteichosaOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkSaiCheck() {
        return this.getIraiprintPanel().getNiteiChosaSelect().getChkSaiCheck();
    }

    @JsonIgnore
    public void setChkSaiCheck(CheckBoxList chkSaiCheck) {
        this.getIraiprintPanel().getNiteiChosaSelect().setChkSaiCheck(chkSaiCheck);
    }

    @JsonIgnore
    public TokkiJokoSelectDiv getTokkiJokoSelect() {
        return this.getIraiprintPanel().getTokkiJokoSelect();
    }

    @JsonIgnore
    public void setTokkiJokoSelect(TokkiJokoSelectDiv TokkiJokoSelect) {
        this.getIraiprintPanel().setTokkiJokoSelect(TokkiJokoSelect);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiJko() {
        return this.getIraiprintPanel().getTokkiJokoSelect().getChkTokkiJko();
    }

    @JsonIgnore
    public void setChkTokkiJko(CheckBoxList chkTokkiJko) {
        this.getIraiprintPanel().getTokkiJokoSelect().setChkTokkiJko(chkTokkiJko);
    }

    @JsonIgnore
    public CheckBoxList getChkTenyuryoku() {
        return this.getIraiprintPanel().getTokkiJokoSelect().getChkTenyuryoku();
    }

    @JsonIgnore
    public void setChkTenyuryoku(CheckBoxList chkTenyuryoku) {
        this.getIraiprintPanel().getTokkiJokoSelect().setChkTenyuryoku(chkTenyuryoku);
    }

    // </editor-fold>
}
