package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5120001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoNinteiShinseiKihonJohoInput.KaigoNinteiShinseiKihonJohoInput.IKaigoNinteiShinseiKihonJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiInput.NinteiInput.INinteiInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.NinteiShinseiTodokedesha.NinteiShinseiTodokedesha.INinteiShinseiTodokedeshaDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ShinseiSonotaJohoInput.ShinseiSonotaJohoInput.IShinseiSonotaJohoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.ZenkaiNinteiKekkaJoho.ZenkaiNinteiKekkaJoho.IZenkaiNinteiKekkaJohoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.chosaitakusakiandchosaininput.ChosaItakusakiAndChosainInput.IChosaItakusakiAndChosainInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.shujiiIryokikanandshujiiinput.ShujiiIryokikanAndShujiiInput.IShujiiIryokikanAndShujiiInputDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.TabContainer;

/**
 * tabShinseishaJoho のクラスファイル
 *
 * @author 自動生成
 */
public class tabShinseishaJohoDiv extends TabContainer {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tplShinseijoho")
    private tplShinseijohoDiv tplShinseijoho;
    @JsonProperty("tplEnki")
    private tplEnkiDiv tplEnki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettplShinseijoho
     * @return tplShinseijoho
     */
    @JsonProperty("tplShinseijoho")
    public tplShinseijohoDiv getTplShinseijoho() {
        return tplShinseijoho;
    }

    /*
     * settplShinseijoho
     * @param tplShinseijoho tplShinseijoho
     */
    @JsonProperty("tplShinseijoho")
    public void setTplShinseijoho(tplShinseijohoDiv tplShinseijoho) {
        this.tplShinseijoho = tplShinseijoho;
    }

    /*
     * gettplEnki
     * @return tplEnki
     */
    @JsonProperty("tplEnki")
    public tplEnkiDiv getTplEnki() {
        return tplEnki;
    }

    /*
     * settplEnki
     * @param tplEnki tplEnki
     */
    @JsonProperty("tplEnki")
    public void setTplEnki(tplEnkiDiv tplEnki) {
        this.tplEnki = tplEnki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public ShujiiAndShujiiIryoKikanDiv getShujiiAndShujiiIryoKikan() {
        return this.getTplShinseijoho().getShujiiAndShujiiIryoKikan();
    }

    @JsonIgnore
    public void setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikanDiv ShujiiAndShujiiIryoKikan) {
        this.getTplShinseijoho().setShujiiAndShujiiIryoKikan(ShujiiAndShujiiIryoKikan);
    }

    @JsonIgnore
    public IShujiiIryokikanAndShujiiInputDiv getCcdShujiiIryokikanAndShujiiInput() {
        return this.getTplShinseijoho().getShujiiAndShujiiIryoKikan().getCcdShujiiIryokikanAndShujiiInput();
    }

    @JsonIgnore
    public ChosainAndChosainInputDiv getChosainAndChosainInput() {
        return this.getTplShinseijoho().getChosainAndChosainInput();
    }

    @JsonIgnore
    public void setChosainAndChosainInput(ChosainAndChosainInputDiv ChosainAndChosainInput) {
        this.getTplShinseijoho().setChosainAndChosainInput(ChosainAndChosainInput);
    }

    @JsonIgnore
    public IChosaItakusakiAndChosainInputDiv getCcdChosaItakusakiAndChosainInput() {
        return this.getTplShinseijoho().getChosainAndChosainInput().getCcdChosaItakusakiAndChosainInput();
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiTsuchishoDoi() {
        return this.getTplShinseijoho().getChkNinteiTsuchishoDoi();
    }

    @JsonIgnore
    public void setChkNinteiTsuchishoDoi(CheckBoxList chkNinteiTsuchishoDoi) {
        this.getTplShinseijoho().setChkNinteiTsuchishoDoi(chkNinteiTsuchishoDoi);
    }

    @JsonIgnore
    public CheckBoxList getChkJohoTeikyoDoi() {
        return this.getTplShinseijoho().getChkJohoTeikyoDoi();
    }

    @JsonIgnore
    public void setChkJohoTeikyoDoi(CheckBoxList chkJohoTeikyoDoi) {
        this.getTplShinseijoho().setChkJohoTeikyoDoi(chkJohoTeikyoDoi);
    }

    @JsonIgnore
    public IKaigoNinteiShinseiKihonJohoInputDiv getCcdKaigoNinteiShinseiKihon() {
        return this.getTplShinseijoho().getCcdKaigoNinteiShinseiKihon();
    }

    @JsonIgnore
    public INinteiInputDiv getCcdNinteiInput() {
        return this.getTplShinseijoho().getCcdNinteiInput();
    }

    @JsonIgnore
    public IShinseiSonotaJohoInputDiv getCcdShinseiSonotaJohoInput() {
        return this.getTplShinseijoho().getCcdShinseiSonotaJohoInput();
    }

    @JsonIgnore
    public IZenkaiNinteiKekkaJohoDiv getCcdZenkaiNinteiKekkaJoho() {
        return this.getTplShinseijoho().getCcdZenkaiNinteiKekkaJoho();
    }

    @JsonIgnore
    public INinteiShinseiTodokedeshaDiv getCcdShinseiTodokedesha() {
        return this.getTplShinseijoho().getCcdShinseiTodokedesha();
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtEnkiKetteiYMD() {
        return this.getTplEnki().getTxtEnkiKetteiYMD();
    }

    @JsonIgnore
    public void setTxtEnkiKetteiYMD(TextBoxFlexibleDate txtEnkiKetteiYMD) {
        this.getTplEnki().setTxtEnkiKetteiYMD(txtEnkiKetteiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtEnkiMikomiKikanFrom() {
        return this.getTplEnki().getTxtEnkiMikomiKikanFrom();
    }

    @JsonIgnore
    public void setTxtEnkiMikomiKikanFrom(TextBoxFlexibleDate txtEnkiMikomiKikanFrom) {
        this.getTplEnki().setTxtEnkiMikomiKikanFrom(txtEnkiMikomiKikanFrom);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtEnkiMikomiKikanTo() {
        return this.getTplEnki().getTxtEnkiMikomiKikanTo();
    }

    @JsonIgnore
    public void setTxtEnkiMikomiKikanTo(TextBoxFlexibleDate txtEnkiMikomiKikanTo) {
        this.getTplEnki().setTxtEnkiMikomiKikanTo(txtEnkiMikomiKikanTo);
    }

    @JsonIgnore
    public Label getLblEnkiRiyu() {
        return this.getTplEnki().getLblEnkiRiyu();
    }

    @JsonIgnore
    public void setLblEnkiRiyu(Label lblEnkiRiyu) {
        this.getTplEnki().setLblEnkiRiyu(lblEnkiRiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnEnkiRiyuTeikeibun() {
        return this.getTplEnki().getBtnEnkiRiyuTeikeibun();
    }

    @JsonIgnore
    public void setBtnEnkiRiyuTeikeibun(ButtonDialog btnEnkiRiyuTeikeibun) {
        this.getTplEnki().setBtnEnkiRiyuTeikeibun(btnEnkiRiyuTeikeibun);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtEnkiRiyu() {
        return this.getTplEnki().getTxtEnkiRiyu();
    }

    @JsonIgnore
    public void setTxtEnkiRiyu(TextBoxMultiLine txtEnkiRiyu) {
        this.getTplEnki().setTxtEnkiRiyu(txtEnkiRiyu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtEnkiTsuchiHakkoYMD() {
        return this.getTplEnki().getTxtEnkiTsuchiHakkoYMD();
    }

    @JsonIgnore
    public void setTxtEnkiTsuchiHakkoYMD(TextBoxFlexibleDate txtEnkiTsuchiHakkoYMD) {
        this.getTplEnki().setTxtEnkiTsuchiHakkoYMD(txtEnkiTsuchiHakkoYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtEnkiTsuchishoHakkoCount() {
        return this.getTplEnki().getTxtEnkiTsuchishoHakkoCount();
    }

    @JsonIgnore
    public void setTxtEnkiTsuchishoHakkoCount(TextBoxNum txtEnkiTsuchishoHakkoCount) {
        this.getTplEnki().setTxtEnkiTsuchishoHakkoCount(txtEnkiTsuchishoHakkoCount);
    }

    // </editor-fold>
}
