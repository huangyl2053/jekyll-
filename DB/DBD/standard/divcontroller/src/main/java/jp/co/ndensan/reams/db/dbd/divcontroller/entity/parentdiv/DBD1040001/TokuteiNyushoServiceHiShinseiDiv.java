package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1040001;
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
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuteiNyushoServiceHiShinsei のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuteiNyushoServiceHiShinseiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-21_20-30-14">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("Shinsei")
    private ShinseiDiv Shinsei;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("ccdKaigoKihon")
    private KaigoShikakuKihonDiv ccdKaigoKihon;
    @JsonProperty("ccdAtenaInfo")
    private KaigoAtenaInfoDiv ccdAtenaInfo;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getShinsei
     * @return Shinsei
     */
    @JsonProperty("Shinsei")
    public ShinseiDiv getShinsei() {
        return Shinsei;
    }

    /*
     * setShinsei
     * @param Shinsei Shinsei
     */
    @JsonProperty("Shinsei")
    public void setShinsei(ShinseiDiv Shinsei) {
        this.Shinsei = Shinsei;
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
     * getccdKaigoKihon
     * @return ccdKaigoKihon
     */
    @JsonProperty("ccdKaigoKihon")
    public IKaigoShikakuKihonDiv getCcdKaigoKihon() {
        return ccdKaigoKihon;
    }

    /*
     * getccdAtenaInfo
     * @return ccdAtenaInfo
     */
    @JsonProperty("ccdAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return ccdAtenaInfo;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getShinsei().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getShinsei().setLin1(lin1);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazaiJokyo() {
        return this.getShinsei().getTxtSetaiKazaiJokyo();
    }

    @JsonIgnore
    public void  setTxtSetaiKazaiJokyo(TextBox txtSetaiKazaiJokyo) {
        this.getShinsei().setTxtSetaiKazaiJokyo(txtSetaiKazaiJokyo);
    }

    @JsonIgnore
    public ButtonDialog getBtnDispSetaiJoho() {
        return this.getShinsei().getBtnDispSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnDispSetaiJoho(ButtonDialog btnDispSetaiJoho) {
        this.getShinsei().setBtnDispSetaiJoho(btnDispSetaiJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnDispGemmenJoho() {
        return this.getShinsei().getBtnDispGemmenJoho();
    }

    @JsonIgnore
    public void  setBtnDispGemmenJoho(ButtonDialog btnDispGemmenJoho) {
        this.getShinsei().setBtnDispGemmenJoho(btnDispGemmenJoho);
    }

    @JsonIgnore
    public ShinseiListDiv getShinseiList() {
        return this.getShinsei().getShinseiList();
    }

    @JsonIgnore
    public void  setShinseiList(ShinseiListDiv ShinseiList) {
        this.getShinsei().setShinseiList(ShinseiList);
    }

    @JsonIgnore
    public Button getBtnAddShinsei() {
        return this.getShinsei().getShinseiList().getBtnAddShinsei();
    }

    @JsonIgnore
    public void  setBtnAddShinsei(Button btnAddShinsei) {
        this.getShinsei().getShinseiList().setBtnAddShinsei(btnAddShinsei);
    }

    @JsonIgnore
    public DataGrid<dgShinseiList_Row> getDgShinseiList() {
        return this.getShinsei().getShinseiList().getDgShinseiList();
    }

    @JsonIgnore
    public void  setDgShinseiList(DataGrid<dgShinseiList_Row> dgShinseiList) {
        this.getShinsei().getShinseiList().setDgShinseiList(dgShinseiList);
    }

    @JsonIgnore
    public ShinseiDetailDiv getShinseiDetail() {
        return this.getShinsei().getShinseiDetail();
    }

    @JsonIgnore
    public void  setShinseiDetail(ShinseiDetailDiv ShinseiDetail) {
        this.getShinsei().setShinseiDetail(ShinseiDetail);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYMD() {
        return this.getShinsei().getShinseiDetail().getTxtShinseiYMD();
    }

    @JsonIgnore
    public void  setTxtShinseiYMD(TextBoxFlexibleDate txtShinseiYMD) {
        this.getShinsei().getShinseiDetail().setTxtShinseiYMD(txtShinseiYMD);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getShinsei().getShinseiDetail().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getShinsei().getShinseiDetail().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public KetteiJohoDiv getKetteiJoho() {
        return this.getShinsei().getShinseiDetail().getKetteiJoho();
    }

    @JsonIgnore
    public void  setKetteiJoho(KetteiJohoDiv KetteiJoho) {
        this.getShinsei().getShinseiDetail().setKetteiJoho(KetteiJoho);
    }

    @JsonIgnore
    public RadioButton getRadKettaiKubun() {
        return this.getShinsei().getShinseiDetail().getKetteiJoho().getRadKettaiKubun();
    }

    @JsonIgnore
    public void  setRadKettaiKubun(RadioButton radKettaiKubun) {
        this.getShinsei().getShinseiDetail().getKetteiJoho().setRadKettaiKubun(radKettaiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYMD() {
        return this.getShinsei().getShinseiDetail().getKetteiJoho().getTxtKettaiYMD();
    }

    @JsonIgnore
    public void  setTxtKettaiYMD(TextBoxFlexibleDate txtKettaiYMD) {
        this.getShinsei().getShinseiDetail().getKetteiJoho().setTxtKettaiYMD(txtKettaiYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYMD() {
        return this.getShinsei().getShinseiDetail().getKetteiJoho().getTxtTekiyoYMD();
    }

    @JsonIgnore
    public void  setTxtTekiyoYMD(TextBoxFlexibleDate txtTekiyoYMD) {
        this.getShinsei().getShinseiDetail().getKetteiJoho().setTxtTekiyoYMD(txtTekiyoYMD);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigenYMD() {
        return this.getShinsei().getShinseiDetail().getKetteiJoho().getTxtYukoKigenYMD();
    }

    @JsonIgnore
    public void  setTxtYukoKigenYMD(TextBoxFlexibleDate txtYukoKigenYMD) {
        this.getShinsei().getShinseiDetail().getKetteiJoho().setTxtYukoKigenYMD(txtYukoKigenYMD);
    }

    @JsonIgnore
    public TextBoxNum getTxtKeigenRitsu() {
        return this.getShinsei().getShinseiDetail().getKetteiJoho().getTxtKeigenRitsu();
    }

    @JsonIgnore
    public void  setTxtKeigenRitsu(TextBoxNum txtKeigenRitsu) {
        this.getShinsei().getShinseiDetail().getKetteiJoho().setTxtKeigenRitsu(txtKeigenRitsu);
    }

    @JsonIgnore
    public TextBoxCode getTxtKakuninNo() {
        return this.getShinsei().getShinseiDetail().getKetteiJoho().getTxtKakuninNo();
    }

    @JsonIgnore
    public void  setTxtKakuninNo(TextBoxCode txtKakuninNo) {
        this.getShinsei().getShinseiDetail().getKetteiJoho().setTxtKakuninNo(txtKakuninNo);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiShoninRiyu() {
        return this.getShinsei().getShinseiDetail().getKetteiJoho().getBtnHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.getShinsei().getShinseiDetail().getKetteiJoho().setBtnHiShoninRiyu(btnHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getShinsei().getShinseiDetail().getKetteiJoho().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getShinsei().getShinseiDetail().getKetteiJoho().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    @JsonIgnore
    public Button getTxtDetermineShinsei() {
        return this.getShinsei().getShinseiDetail().getTxtDetermineShinsei();
    }

    @JsonIgnore
    public void  setTxtDetermineShinsei(Button txtDetermineShinsei) {
        this.getShinsei().getShinseiDetail().setTxtDetermineShinsei(txtDetermineShinsei);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getShinsei().getShinseiDetail().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getShinsei().getShinseiDetail().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnBackToShinseiList() {
        return this.getShinsei().getShinseiDetail().getBtnBackToShinseiList();
    }

    @JsonIgnore
    public void  setBtnBackToShinseiList(Button btnBackToShinseiList) {
        this.getShinsei().getShinseiDetail().setBtnBackToShinseiList(btnBackToShinseiList);
    }

    @JsonIgnore
    public IGemmenGengakuShinseiDiv getCcdShinseiJoho() {
        return this.getShinsei().getShinseiDetail().getCcdShinseiJoho();
    }

    // </editor-fold>
}
