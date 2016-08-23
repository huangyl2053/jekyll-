package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD4020011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.GemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.commonchilddiv.gemmemgengakushinsei.GemmenGengakuShinsei.IGemmenGengakuShinseiDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.ISetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.SetaiShotokuIchiran.SetaiShotokuIchiran.SetaiShotokuIchiranDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * ShogaishaKojoTaishoshaShinseiTorokuMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class ShogaishaKojoTaishoshaShinseiTorokuMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ShogaishaKojoTaishoshaShinseiToroku")
    private ShogaishaKojoTaishoshaShinseiTorokuDiv ShogaishaKojoTaishoshaShinseiToroku;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShogaishaKojoTaishoshaShinseiToroku
     * @return ShogaishaKojoTaishoshaShinseiToroku
     */
    @JsonProperty("ShogaishaKojoTaishoshaShinseiToroku")
    public ShogaishaKojoTaishoshaShinseiTorokuDiv getShogaishaKojoTaishoshaShinseiToroku() {
        return ShogaishaKojoTaishoshaShinseiToroku;
    }

    /*
     * setShogaishaKojoTaishoshaShinseiToroku
     * @param ShogaishaKojoTaishoshaShinseiToroku ShogaishaKojoTaishoshaShinseiToroku
     */
    @JsonProperty("ShogaishaKojoTaishoshaShinseiToroku")
    public void setShogaishaKojoTaishoshaShinseiToroku(ShogaishaKojoTaishoshaShinseiTorokuDiv ShogaishaKojoTaishoshaShinseiToroku) {
        this.ShogaishaKojoTaishoshaShinseiToroku = ShogaishaKojoTaishoshaShinseiToroku;
    }

    /*
     * getccdKanryoMessage
     * @return ccdKanryoMessage
     */
    @JsonProperty("ccdKanryoMessage")
    public IKaigoKanryoMessageDiv getCcdKanryoMessage() {
        return ccdKanryoMessage;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getShogaishaKojoTaishoshaShinseiToroku().setLin1(lin1);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazaiJokyo() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getTxtSetaiKazaiJokyo();
    }

    @JsonIgnore
    public void  setTxtSetaiKazaiJokyo(TextBox txtSetaiKazaiJokyo) {
        this.getShogaishaKojoTaishoshaShinseiToroku().setTxtSetaiKazaiJokyo(txtSetaiKazaiJokyo);
    }

    @JsonIgnore
    public Button getBtnShowSetaiJoho() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getBtnShowSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnShowSetaiJoho(Button btnShowSetaiJoho) {
        this.getShogaishaKojoTaishoshaShinseiToroku().setBtnShowSetaiJoho(btnShowSetaiJoho);
    }

    @JsonIgnore
    public Button getBtnCloseSetaiJoho() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getBtnCloseSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnCloseSetaiJoho(Button btnCloseSetaiJoho) {
        this.getShogaishaKojoTaishoshaShinseiToroku().setBtnCloseSetaiJoho(btnCloseSetaiJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnDispGemmenJoho() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getBtnDispGemmenJoho();
    }

    @JsonIgnore
    public void  setBtnDispGemmenJoho(ButtonDialog btnDispGemmenJoho) {
        this.getShogaishaKojoTaishoshaShinseiToroku().setBtnDispGemmenJoho(btnDispGemmenJoho);
    }

    @JsonIgnore
    public SetaiJohoDiv getSetaiJoho() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getSetaiJoho();
    }

    @JsonIgnore
    public void  setSetaiJoho(SetaiJohoDiv SetaiJoho) {
        this.getShogaishaKojoTaishoshaShinseiToroku().setSetaiJoho(SetaiJoho);
    }

    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSetaiShotokuIchiran() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getSetaiJoho().getCcdSetaiShotokuIchiran();
    }

    @JsonIgnore
    public ShinseiListDiv getShinseiList() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiList();
    }

    @JsonIgnore
    public void  setShinseiList(ShinseiListDiv ShinseiList) {
        this.getShogaishaKojoTaishoshaShinseiToroku().setShinseiList(ShinseiList);
    }

    @JsonIgnore
    public Button getBtnAddShinsei() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiList().getBtnAddShinsei();
    }

    @JsonIgnore
    public void  setBtnAddShinsei(Button btnAddShinsei) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiList().setBtnAddShinsei(btnAddShinsei);
    }

    @JsonIgnore
    public DataGrid<dgShinseiList_Row> getDgShinseiList() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiList().getDgShinseiList();
    }

    @JsonIgnore
    public void  setDgShinseiList(DataGrid<dgShinseiList_Row> dgShinseiList) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiList().setDgShinseiList(dgShinseiList);
    }

    @JsonIgnore
    public ShinseiDetailDiv getShinseiDetail() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail();
    }

    @JsonIgnore
    public void  setShinseiDetail(ShinseiDetailDiv ShinseiDetail) {
        this.getShogaishaKojoTaishoshaShinseiToroku().setShinseiDetail(ShinseiDetail);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho();
    }

    @JsonIgnore
    public void  setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().setKetteiJoho(KetteiJoho);
    }

    @JsonIgnore
    public RadioButton getRadKettaiKubun() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getRadKettaiKubun();
    }

    @JsonIgnore
    public void  setRadKettaiKubun(RadioButton radKettaiKubun) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setRadKettaiKubun(radKettaiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYMD() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getTxtKettaiYMD();
    }

    @JsonIgnore
    public void  setTxtKettaiYMD(TextBoxFlexibleDate txtKettaiYMD) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setTxtKettaiYMD(txtKettaiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleYear getTxtTaishoNendo() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getTxtTaishoNendo();
    }

    @JsonIgnore
    public void  setTxtTaishoNendo(TextBoxFlexibleYear txtTaishoNendo) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setTxtTaishoNendo(txtTaishoNendo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKijunYMD() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getTxtKijunYMD();
    }

    @JsonIgnore
    public void  setTxtKijunYMD(TextBoxFlexibleDate txtKijunYMD) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setTxtKijunYMD(txtKijunYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtHaakuYMD() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getTxtHaakuYMD();
    }

    @JsonIgnore
    public void  setTxtHaakuYMD(TextBoxFlexibleDate txtHaakuYMD) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setTxtHaakuYMD(txtHaakuYMD);
    }

    @JsonIgnore
    public CheckBoxList getChkHasShogaishaTecho() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getChkHasShogaishaTecho();
    }

    @JsonIgnore
    public void  setChkHasShogaishaTecho(CheckBoxList chkHasShogaishaTecho) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setChkHasShogaishaTecho(chkHasShogaishaTecho);
    }

    @JsonIgnore
    public CheckBoxList getChkIsNinteishoHakkoTaishoGai() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getChkIsNinteishoHakkoTaishoGai();
    }

    @JsonIgnore
    public void  setChkIsNinteishoHakkoTaishoGai(CheckBoxList chkIsNinteishoHakkoTaishoGai) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setChkIsNinteishoHakkoTaishoGai(chkIsNinteishoHakkoTaishoGai);
    }

    @JsonIgnore
    public DropDownList getDdlNinchishoKoreishaJiritsudo() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getDdlNinchishoKoreishaJiritsudo();
    }

    @JsonIgnore
    public void  setDdlNinchishoKoreishaJiritsudo(DropDownList ddlNinchishoKoreishaJiritsudo) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setDdlNinchishoKoreishaJiritsudo(ddlNinchishoKoreishaJiritsudo);
    }

    @JsonIgnore
    public DropDownList getDdlShogaiKoreishaJiritsudo() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getDdlShogaiKoreishaJiritsudo();
    }

    @JsonIgnore
    public void  setDdlShogaiKoreishaJiritsudo(DropDownList ddlShogaiKoreishaJiritsudo) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setDdlShogaiKoreishaJiritsudo(ddlShogaiKoreishaJiritsudo);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiKubun() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getDdlNinteiKubun();
    }

    @JsonIgnore
    public void  setDdlNinteiKubun(DropDownList ddlNinteiKubun) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setDdlNinteiKubun(ddlNinteiKubun);
    }

    @JsonIgnore
    public DropDownList getDdlNinteiNaiyo() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getDdlNinteiNaiyo();
    }

    @JsonIgnore
    public void  setDdlNinteiNaiyo(DropDownList ddlNinteiNaiyo) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setDdlNinteiNaiyo(ddlNinteiNaiyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiShoninRiyu() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getBtnHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setBtnHiShoninRiyu(btnHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getKetteiJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    @JsonIgnore
    public Button getTxtDetermineShinsei() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getTxtDetermineShinsei();
    }

    @JsonIgnore
    public void  setTxtDetermineShinsei(Button txtDetermineShinsei) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().setTxtDetermineShinsei(txtDetermineShinsei);
    }

    @JsonIgnore
    public Button getBtnBackToShinseiList() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getBtnBackToShinseiList();
    }

    @JsonIgnore
    public void  setBtnBackToShinseiList(Button btnBackToShinseiList) {
        this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().setBtnBackToShinseiList(btnBackToShinseiList);
    }

    @JsonIgnore
    public IGemmenGengakuShinseiDiv getCcdGemmenGengakuShinsei() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getShinseiDetail().getCcdGemmenGengakuShinsei();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoKihon() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getCcdKaigoKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return this.getShogaishaKojoTaishoshaShinseiToroku().getCcdAtenaInfo();
    }

    // </editor-fold>
}
