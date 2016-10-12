package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD1020001;
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
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * RiyoshaFutangakuGengakuPanel のクラスファイル 
 * 
 * @author 自動生成
 */
public class RiyoshaFutangakuGengakuPanelDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-06-27_21-36-36">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ccdSetaiKazei")
    private ccdSetaiKazeiDiv ccdSetaiKazei;
    @JsonProperty("SetaiJoho")
    private SetaiJohoDiv SetaiJoho;
    @JsonProperty("RiyoshaFutangakuGengakuShinseiList")
    private RiyoshaFutangakuGengakuShinseiListDiv RiyoshaFutangakuGengakuShinseiList;
    @JsonProperty("RiyoshaFutangakuGengakuShinseiDetail")
    private RiyoshaFutangakuGengakuShinseiDetailDiv RiyoshaFutangakuGengakuShinseiDetail;
    @JsonProperty("ccdKanryoMessage")
    private KaigoKanryoMessageDiv ccdKanryoMessage;
    @JsonProperty("hihokenshaNo")
    private RString hihokenshaNo;
    @JsonProperty("hidden登録業務コード")
    private RString hidden登録業務コード;
    @JsonProperty("hidden登録グループコード")
    private RString hidden登録グループコード;
    @JsonProperty("hiddenサンプル文書")
    private RString hiddenサンプル文書;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getccdSetaiKazei
     * @return ccdSetaiKazei
     */
    @JsonProperty("ccdSetaiKazei")
    public ccdSetaiKazeiDiv getCcdSetaiKazei() {
        return ccdSetaiKazei;
    }

    /*
     * setccdSetaiKazei
     * @param ccdSetaiKazei ccdSetaiKazei
     */
    @JsonProperty("ccdSetaiKazei")
    public void setCcdSetaiKazei(ccdSetaiKazeiDiv ccdSetaiKazei) {
        this.ccdSetaiKazei = ccdSetaiKazei;
    }

    /*
     * getSetaiJoho
     * @return SetaiJoho
     */
    @JsonProperty("SetaiJoho")
    public SetaiJohoDiv getSetaiJoho() {
        return SetaiJoho;
    }

    /*
     * setSetaiJoho
     * @param SetaiJoho SetaiJoho
     */
    @JsonProperty("SetaiJoho")
    public void setSetaiJoho(SetaiJohoDiv SetaiJoho) {
        this.SetaiJoho = SetaiJoho;
    }

    /*
     * getRiyoshaFutangakuGengakuShinseiList
     * @return RiyoshaFutangakuGengakuShinseiList
     */
    @JsonProperty("RiyoshaFutangakuGengakuShinseiList")
    public RiyoshaFutangakuGengakuShinseiListDiv getRiyoshaFutangakuGengakuShinseiList() {
        return RiyoshaFutangakuGengakuShinseiList;
    }

    /*
     * setRiyoshaFutangakuGengakuShinseiList
     * @param RiyoshaFutangakuGengakuShinseiList RiyoshaFutangakuGengakuShinseiList
     */
    @JsonProperty("RiyoshaFutangakuGengakuShinseiList")
    public void setRiyoshaFutangakuGengakuShinseiList(RiyoshaFutangakuGengakuShinseiListDiv RiyoshaFutangakuGengakuShinseiList) {
        this.RiyoshaFutangakuGengakuShinseiList = RiyoshaFutangakuGengakuShinseiList;
    }

    /*
     * getRiyoshaFutangakuGengakuShinseiDetail
     * @return RiyoshaFutangakuGengakuShinseiDetail
     */
    @JsonProperty("RiyoshaFutangakuGengakuShinseiDetail")
    public RiyoshaFutangakuGengakuShinseiDetailDiv getRiyoshaFutangakuGengakuShinseiDetail() {
        return RiyoshaFutangakuGengakuShinseiDetail;
    }

    /*
     * setRiyoshaFutangakuGengakuShinseiDetail
     * @param RiyoshaFutangakuGengakuShinseiDetail RiyoshaFutangakuGengakuShinseiDetail
     */
    @JsonProperty("RiyoshaFutangakuGengakuShinseiDetail")
    public void setRiyoshaFutangakuGengakuShinseiDetail(RiyoshaFutangakuGengakuShinseiDetailDiv RiyoshaFutangakuGengakuShinseiDetail) {
        this.RiyoshaFutangakuGengakuShinseiDetail = RiyoshaFutangakuGengakuShinseiDetail;
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
     * gethihokenshaNo
     * @return hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public RString getHihokenshaNo() {
        return hihokenshaNo;
    }

    /*
     * sethihokenshaNo
     * @param hihokenshaNo hihokenshaNo
     */
    @JsonProperty("hihokenshaNo")
    public void setHihokenshaNo(RString hihokenshaNo) {
        this.hihokenshaNo = hihokenshaNo;
    }

    /*
     * gethidden登録業務コード
     * @return hidden登録業務コード
     */
    @JsonProperty("hidden登録業務コード")
    public RString getHidden登録業務コード() {
        return hidden登録業務コード;
    }

    /*
     * sethidden登録業務コード
     * @param hidden登録業務コード hidden登録業務コード
     */
    @JsonProperty("hidden登録業務コード")
    public void setHidden登録業務コード(RString hidden登録業務コード) {
        this.hidden登録業務コード = hidden登録業務コード;
    }

    /*
     * gethidden登録グループコード
     * @return hidden登録グループコード
     */
    @JsonProperty("hidden登録グループコード")
    public RString getHidden登録グループコード() {
        return hidden登録グループコード;
    }

    /*
     * sethidden登録グループコード
     * @param hidden登録グループコード hidden登録グループコード
     */
    @JsonProperty("hidden登録グループコード")
    public void setHidden登録グループコード(RString hidden登録グループコード) {
        this.hidden登録グループコード = hidden登録グループコード;
    }

    /*
     * gethiddenサンプル文書
     * @return hiddenサンプル文書
     */
    @JsonProperty("hiddenサンプル文書")
    public RString getHiddenサンプル文書() {
        return hiddenサンプル文書;
    }

    /*
     * sethiddenサンプル文書
     * @param hiddenサンプル文書 hiddenサンプル文書
     */
    @JsonProperty("hiddenサンプル文書")
    public void setHiddenサンプル文書(RString hiddenサンプル文書) {
        this.hiddenサンプル文書 = hiddenサンプル文書;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public HeaderDiv getHeader() {
        return this.getCcdSetaiKazei().getHeader();
    }

    @JsonIgnore
    public void  setHeader(HeaderDiv Header) {
        this.getCcdSetaiKazei().setHeader(Header);
    }

    @JsonIgnore
    public HorizontalLine getLin1() {
        return this.getCcdSetaiKazei().getHeader().getLin1();
    }

    @JsonIgnore
    public void  setLin1(HorizontalLine lin1) {
        this.getCcdSetaiKazei().getHeader().setLin1(lin1);
    }

    @JsonIgnore
    public TextBox getTxtSetaiKazeiJokyo() {
        return this.getCcdSetaiKazei().getHeader().getTxtSetaiKazeiJokyo();
    }

    @JsonIgnore
    public void  setTxtSetaiKazeiJokyo(TextBox txtSetaiKazeiJokyo) {
        this.getCcdSetaiKazei().getHeader().setTxtSetaiKazeiJokyo(txtSetaiKazeiJokyo);
    }

    @JsonIgnore
    public Button getBtnShowSetaiJoho() {
        return this.getCcdSetaiKazei().getHeader().getBtnShowSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnShowSetaiJoho(Button btnShowSetaiJoho) {
        this.getCcdSetaiKazei().getHeader().setBtnShowSetaiJoho(btnShowSetaiJoho);
    }

    @JsonIgnore
    public Button getBtnCloseSetaiJoho() {
        return this.getCcdSetaiKazei().getHeader().getBtnCloseSetaiJoho();
    }

    @JsonIgnore
    public void  setBtnCloseSetaiJoho(Button btnCloseSetaiJoho) {
        this.getCcdSetaiKazei().getHeader().setBtnCloseSetaiJoho(btnCloseSetaiJoho);
    }

    @JsonIgnore
    public ButtonDialog getBtnShowGemmenJoho() {
        return this.getCcdSetaiKazei().getHeader().getBtnShowGemmenJoho();
    }

    @JsonIgnore
    public void  setBtnShowGemmenJoho(ButtonDialog btnShowGemmenJoho) {
        this.getCcdSetaiKazei().getHeader().setBtnShowGemmenJoho(btnShowGemmenJoho);
    }

    @JsonIgnore
    public IKaigoShikakuKihonDiv getCcdKaigoKihon() {
        return this.getCcdSetaiKazei().getHeader().getCcdKaigoKihon();
    }

    @JsonIgnore
    public IKaigoAtenaInfoDiv getCcdAtenaInfo() {
        return this.getCcdSetaiKazei().getHeader().getCcdAtenaInfo();
    }

    @JsonIgnore
    public ISetaiShotokuIchiranDiv getCcdSetaiShotokuIchiran() {
        return this.getSetaiJoho().getCcdSetaiShotokuIchiran();
    }

    @JsonIgnore
    public Button getBtnInputNew() {
        return this.getRiyoshaFutangakuGengakuShinseiList().getBtnInputNew();
    }

    @JsonIgnore
    public void  setBtnInputNew(Button btnInputNew) {
        this.getRiyoshaFutangakuGengakuShinseiList().setBtnInputNew(btnInputNew);
    }

    @JsonIgnore
    public DataGrid<ddlShinseiIchiran_Row> getDdlShinseiIchiran() {
        return this.getRiyoshaFutangakuGengakuShinseiList().getDdlShinseiIchiran();
    }

    @JsonIgnore
    public void  setDdlShinseiIchiran(DataGrid<ddlShinseiIchiran_Row> ddlShinseiIchiran) {
        this.getRiyoshaFutangakuGengakuShinseiList().setDdlShinseiIchiran(ddlShinseiIchiran);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiYmd() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getTxtShinseiYmd();
    }

    @JsonIgnore
    public void  setTxtShinseiYmd(TextBoxFlexibleDate txtShinseiYmd) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().setTxtShinseiYmd(txtShinseiYmd);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public KetteiNaiyoDiv getKetteiNaiyo() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo();
    }

    @JsonIgnore
    public void  setKetteiNaiyo(KetteiNaiyoDiv KetteiNaiyo) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().setKetteiNaiyo(KetteiNaiyo);
    }

    @JsonIgnore
    public RadioButton getRadKetteiKubun() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().getRadKetteiKubun();
    }

    @JsonIgnore
    public void  setRadKetteiKubun(RadioButton radKetteiKubun) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().setRadKetteiKubun(radKetteiKubun);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtKettaiYmd() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().getTxtKettaiYmd();
    }

    @JsonIgnore
    public void  setTxtKettaiYmd(TextBoxFlexibleDate txtKettaiYmd) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().setTxtKettaiYmd(txtKettaiYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtTekiyoYmd() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().getTxtTekiyoYmd();
    }

    @JsonIgnore
    public void  setTxtTekiyoYmd(TextBoxFlexibleDate txtTekiyoYmd) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().setTxtTekiyoYmd(txtTekiyoYmd);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtYukoKigenYmd() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().getTxtYukoKigenYmd();
    }

    @JsonIgnore
    public void  setTxtYukoKigenYmd(TextBoxFlexibleDate txtYukoKigenYmd) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().setTxtYukoKigenYmd(txtYukoKigenYmd);
    }

    @JsonIgnore
    public DropDownList getDdlKyusochiKubun() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().getDdlKyusochiKubun();
    }

    @JsonIgnore
    public void  setDdlKyusochiKubun(DropDownList ddlKyusochiKubun) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().setDdlKyusochiKubun(ddlKyusochiKubun);
    }

    @JsonIgnore
    public TextBoxNum getTxtKyufuRitsu() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().getTxtKyufuRitsu();
    }

    @JsonIgnore
    public void  setTxtKyufuRitsu(TextBoxNum txtKyufuRitsu) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().setTxtKyufuRitsu(txtKyufuRitsu);
    }

    @JsonIgnore
    public ButtonDialog getBtnHiShoninRiyu() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().getBtnHiShoninRiyu();
    }

    @JsonIgnore
    public void  setBtnHiShoninRiyu(ButtonDialog btnHiShoninRiyu) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().setBtnHiShoninRiyu(btnHiShoninRiyu);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtHiShoninRiyu() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().getTxtHiShoninRiyu();
    }

    @JsonIgnore
    public void  setTxtHiShoninRiyu(TextBoxMultiLine txtHiShoninRiyu) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getKetteiNaiyo().setTxtHiShoninRiyu(txtHiShoninRiyu);
    }

    @JsonIgnore
    public ccdJohoAreaButtonDiv getCcdJohoAreaButton() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getCcdJohoAreaButton();
    }

    @JsonIgnore
    public void  setCcdJohoAreaButton(ccdJohoAreaButtonDiv ccdJohoAreaButton) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().setCcdJohoAreaButton(ccdJohoAreaButton);
    }

    @JsonIgnore
    public Button getBtnShinseiKakutei() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getCcdJohoAreaButton().getBtnShinseiKakutei();
    }

    @JsonIgnore
    public void  setBtnShinseiKakutei(Button btnShinseiKakutei) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getCcdJohoAreaButton().setBtnShinseiKakutei(btnShinseiKakutei);
    }

    @JsonIgnore
    public Button getBtnConfirm() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getCcdJohoAreaButton().getBtnConfirm();
    }

    @JsonIgnore
    public void  setBtnConfirm(Button btnConfirm) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getCcdJohoAreaButton().setBtnConfirm(btnConfirm);
    }

    @JsonIgnore
    public Button getBtnBackShinseiIchirai() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getCcdJohoAreaButton().getBtnBackShinseiIchirai();
    }

    @JsonIgnore
    public void  setBtnBackShinseiIchirai(Button btnBackShinseiIchirai) {
        this.getRiyoshaFutangakuGengakuShinseiDetail().getCcdJohoAreaButton().setBtnBackShinseiIchirai(btnBackShinseiIchirai);
    }

    @JsonIgnore
    public IGemmenGengakuShinseiDiv getCcdShinseiJoho() {
        return this.getRiyoshaFutangakuGengakuShinseiDetail().getCcdShinseiJoho();
    }

    // </editor-fold>
}
