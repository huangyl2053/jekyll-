package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1070001;
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

/**
 * HomonKaigoRiyoshaFutanGengakuMain のクラスファイル 
 * 
 * @author 自動生成
 */
public class HomonKaigoRiyoshaFutanGengakuMainDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HomonKaigoRiyoshaFutanGengaku")
    private HomonKaigoRiyoshaFutanGengakuDiv HomonKaigoRiyoshaFutanGengaku;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHomonKaigoRiyoshaFutanGengaku
     * @return HomonKaigoRiyoshaFutanGengaku
     */
    @JsonProperty("HomonKaigoRiyoshaFutanGengaku")
    public HomonKaigoRiyoshaFutanGengakuDiv getHomonKaigoRiyoshaFutanGengaku() {
        return HomonKaigoRiyoshaFutanGengaku;
    }

    /*
     * setHomonKaigoRiyoshaFutanGengaku
     * @param HomonKaigoRiyoshaFutanGengaku HomonKaigoRiyoshaFutanGengaku
     */
    @JsonProperty("HomonKaigoRiyoshaFutanGengaku")
    public void setHomonKaigoRiyoshaFutanGengaku(HomonKaigoRiyoshaFutanGengakuDiv HomonKaigoRiyoshaFutanGengaku) {
        this.HomonKaigoRiyoshaFutanGengaku = HomonKaigoRiyoshaFutanGengaku;
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
        return this.getHomonKaigoRiyoshaFutanGengaku().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getHomonKaigoRiyoshaFutanGengaku().setLin1(lin1);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazeiJokyo() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getTxtSetaiKazeiJokyo();
    }

    @JsonIgnore
    public void  setTxtSetaiKazeiJokyo(TextBox txtSetaiKazeiJokyo) {
        this.getHomonKaigoRiyoshaFutanGengaku().setTxtSetaiKazeiJokyo(txtSetaiKazeiJokyo);
    }

    @JsonIgnore
    public Button getBtnShowSetaiJoho() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getBtnShowSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnShowSetaiJoho(Button btnShowSetaiJoho) {
        this.getHomonKaigoRiyoshaFutanGengaku().setBtnShowSetaiJoho(btnShowSetaiJoho);
    }

    @JsonIgnore
    public Button getBtnCloseSetaiJoho() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getBtnCloseSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnCloseSetaiJoho(Button btnCloseSetaiJoho) {
        this.getHomonKaigoRiyoshaFutanGengaku().setBtnCloseSetaiJoho(btnCloseSetaiJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnOpenGemmenJoho() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getBtnOpenGemmenJoho();
    }

    @JsonIgnore
    public void  setBtnOpenGemmenJoho(ButtonDialog btnOpenGemmenJoho) {
        this.getHomonKaigoRiyoshaFutanGengaku().setBtnOpenGemmenJoho(btnOpenGemmenJoho);
    }

    @JsonIgnore
    public HomonKaigoGengakuShinseiListDiv getHomonKaigoGengakuShinseiList() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiList();
    }

    @JsonIgnore
    public void  setHomonKaigoGengakuShinseiList(HomonKaigoGengakuShinseiListDiv HomonKaigoGengakuShinseiList) {
        this.getHomonKaigoRiyoshaFutanGengaku().setHomonKaigoGengakuShinseiList(HomonKaigoGengakuShinseiList);
    }

    @JsonIgnore
    public Button getBtnAddShinsei() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiList().getBtnAddShinsei();
    }

    @JsonIgnore
    public void  setBtnAddShinsei(Button btnAddShinsei) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiList().setBtnAddShinsei(btnAddShinsei);
    }

    @JsonIgnore
    public DataGrid<dgShinseiList_Row> getDgShinseiList() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiList().getDgShinseiList();
    }

    @JsonIgnore
    public void  setDgShinseiList(DataGrid<dgShinseiList_Row> dgShinseiList) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiList().setDgShinseiList(dgShinseiList);
    }

    @JsonIgnore
    public HomonKaigoGengakuShinseiDetailDiv getHomonKaigoGengakuShinseiDetail() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail();
    }

    @JsonIgnore
    public void  setHomonKaigoGengakuShinseiDetail(HomonKaigoGengakuShinseiDetailDiv HomonKaigoGengakuShinseiDetail) {
        this.getHomonKaigoRiyoshaFutanGengaku().setHomonKaigoGengakuShinseiDetail(HomonKaigoGengakuShinseiDetail);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public ShogaishaTechoDiv getShogaishaTecho() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getShogaishaTecho();
    }

    @JsonIgnore
    public void  setShogaishaTecho(ShogaishaTechoDiv ShogaishaTecho) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().setShogaishaTecho(ShogaishaTecho);
    }

    @JsonIgnore
    public RadioButton getRadShogaishaTechoUmu() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().getRadShogaishaTechoUmu();
    }

    @JsonIgnore
    public void  setRadShogaishaTechoUmu(RadioButton radShogaishaTechoUmu) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().setRadShogaishaTechoUmu(radShogaishaTechoUmu);
    }

    @JsonIgnore
    public TextBox getTxtShogaishaTechoTokyu() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().getTxtShogaishaTechoTokyu();
    }

    @JsonIgnore
    public void  setTxtShogaishaTechoTokyu(TextBox txtShogaishaTechoTokyu) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().setTxtShogaishaTechoTokyu(txtShogaishaTechoTokyu);
    }

    @JsonIgnore
    public TextBox getTxtShogaishaTechoNo() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().getTxtShogaishaTechoNo();
    }

    @JsonIgnore
    public void  setTxtShogaishaTechoNo(TextBox txtShogaishaTechoNo) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().setTxtShogaishaTechoNo(txtShogaishaTechoNo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShogaishaTechoKofuYMD() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().getTxtShogaishaTechoKofuYMD();
    }

    @JsonIgnore
    public void  setTxtShogaishaTechoKofuYMD(TextBoxFlexibleDate txtShogaishaTechoKofuYMD) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getShogaishaTecho().setTxtShogaishaTechoKofuYMD(txtShogaishaTechoKofuYMD);
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho();
    }

    @JsonIgnore
    public void  setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().setKetteiJoho(KetteiJoho);
    }

    @JsonIgnore
    public RadioButton getDdlKettaiKubun() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getDdlKettaiKubun();
    }

    @JsonIgnore
    public void  setDdlKettaiKubun(RadioButton ddlKettaiKubun) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setDdlKettaiKubun(ddlKettaiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYmd() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtKettaiYmd();
    }

    @JsonIgnore
    public void  setTxtKettaiYmd(TextBoxFlexibleDate txtKettaiYmd) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtKettaiYmd(txtKettaiYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYmd() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtTekiyoYmd();
    }

    @JsonIgnore
    public void  setTxtTekiyoYmd(TextBoxFlexibleDate txtTekiyoYmd) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtTekiyoYmd(txtTekiyoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigen() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtYukoKigen();
    }

    @JsonIgnore
    public void  setTxtYukoKigen(TextBoxFlexibleDate txtYukoKigen) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtYukoKigen(txtYukoKigen);
    }

    @JsonIgnore
    public DropDownList getDdlHobetsuKubun() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getDdlHobetsuKubun();
    }

    @JsonIgnore
    public void  setDdlHobetsuKubun(DropDownList ddlHobetsuKubun) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setDdlHobetsuKubun(ddlHobetsuKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuRitsu() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtKyufuRitsu(txtKyufuRitsu);
    }

    @JsonIgnore
    public TextBox getTxtKohiFutanshaNo() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtKohiFutanshaNo();
    }

    @JsonIgnore
    public void  setTxtKohiFutanshaNo(TextBox txtKohiFutanshaNo) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtKohiFutanshaNo(txtKohiFutanshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtKohiJyukyshaNo() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtKohiJyukyshaNo();
    }

    @JsonIgnore
    public void  setTxtKohiJyukyshaNo(TextBoxCode txtKohiJyukyshaNo) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtKohiJyukyshaNo(txtKohiJyukyshaNo);
    }

    @JsonIgnore
    public TextBoxCode getTxtKohiJyukyushaNoCheckDigit() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtKohiJyukyushaNoCheckDigit();
    }

    @JsonIgnore
    public void  setTxtKohiJyukyushaNoCheckDigit(TextBoxCode txtKohiJyukyushaNoCheckDigit) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtKohiJyukyushaNoCheckDigit(txtKohiJyukyushaNoCheckDigit);
    }

    @JsonIgnore
    public ButtonDialog getBtnOpenHiShoninRiyu() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getBtnOpenHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnOpenHiShoninRiyu(ButtonDialog btnOpenHiShoninRiyu) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setBtnOpenHiShoninRiyu(btnOpenHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getKetteiJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    @JsonIgnore
    public Button getBtnAddShinseiJoho() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getBtnAddShinseiJoho();
    }

    @JsonIgnore
    public void  setBtnAddShinseiJoho(Button btnAddShinseiJoho) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().setBtnAddShinseiJoho(btnAddShinseiJoho);
    }

    @JsonIgnore
    public Button getBtnReturnShinseiIchiran() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getBtnReturnShinseiIchiran();
    }

    @JsonIgnore
    public void  setBtnReturnShinseiIchiran(Button btnReturnShinseiIchiran) {
        this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().setBtnReturnShinseiIchiran(btnReturnShinseiIchiran);
    }

    @JsonIgnore
    public IGemmenGengakuShinseiDiv getCcdShinseiJoho() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getHomonKaigoGengakuShinseiDetail().getCcdShinseiJoho();
    }

    @JsonIgnore
    public SetaiJohoDiv getSetaiJoho() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getSetaiJoho();
    }

    @JsonIgnore
    public void  setSetaiJoho(SetaiJohoDiv SetaiJoho) {
        this.getHomonKaigoRiyoshaFutanGengaku().setSetaiJoho(SetaiJoho);
    }

    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSetaiShotokuIchiran() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getSetaiJoho().getCcdSetaiShotokuIchiran();
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdShikakuKihon() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getCcdShikakuKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return this.getHomonKaigoRiyoshaFutanGengaku().getCcdAtenaInfo();
    }

    // </editor-fold>
}
