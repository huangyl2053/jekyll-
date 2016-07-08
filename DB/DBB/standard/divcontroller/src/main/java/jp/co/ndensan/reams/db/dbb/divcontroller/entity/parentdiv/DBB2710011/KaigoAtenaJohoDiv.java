package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710011;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.IKaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kaigofukakihon.KaigoFukaKihon.KaigoFukaKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * KaigoAtenaJoho のクラスファイル 
 * 
 * @author 自動生成
 */
public class KaigoAtenaJohoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NenkinJohoKensaku")
    private NenkinJohoKensakuDiv NenkinJohoKensaku;
    @JsonProperty("KanrenTsukeSakujo")
    private KanrenTsukeSakujoDiv KanrenTsukeSakujo;
    @JsonProperty("NenkinInfoKensaku")
    private NenkinInfoKensakuDiv NenkinInfoKensaku;
    @JsonProperty("KanryoMsg")
    private KanryoMsgDiv KanryoMsg;
    @JsonProperty("ccdKaigoFukaKihon")
    private KaigoFukaKihonDiv ccdKaigoFukaKihon;
    @JsonProperty("ccdKaigoAtenaInfo")
    private KaigoAtenaInfoDiv ccdKaigoAtenaInfo;
    @JsonProperty("yearofprocessedsequence")
    private RString yearofprocessedsequence;
    @JsonProperty("oldNenkinNo")
    private RString oldNenkinNo;
    @JsonProperty("oldNenkinCode")
    private RString oldNenkinCode;
    @JsonProperty("catchMoon")
    private RString catchMoon;
    @JsonProperty("tokubetsuChoshuGimushaCode")
    private RString tokubetsuChoshuGimushaCode;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNenkinJohoKensaku
     * @return NenkinJohoKensaku
     */
    @JsonProperty("NenkinJohoKensaku")
    public NenkinJohoKensakuDiv getNenkinJohoKensaku() {
        return NenkinJohoKensaku;
    }

    /*
     * setNenkinJohoKensaku
     * @param NenkinJohoKensaku NenkinJohoKensaku
     */
    @JsonProperty("NenkinJohoKensaku")
    public void setNenkinJohoKensaku(NenkinJohoKensakuDiv NenkinJohoKensaku) {
        this.NenkinJohoKensaku = NenkinJohoKensaku;
    }

    /*
     * getKanrenTsukeSakujo
     * @return KanrenTsukeSakujo
     */
    @JsonProperty("KanrenTsukeSakujo")
    public KanrenTsukeSakujoDiv getKanrenTsukeSakujo() {
        return KanrenTsukeSakujo;
    }

    /*
     * setKanrenTsukeSakujo
     * @param KanrenTsukeSakujo KanrenTsukeSakujo
     */
    @JsonProperty("KanrenTsukeSakujo")
    public void setKanrenTsukeSakujo(KanrenTsukeSakujoDiv KanrenTsukeSakujo) {
        this.KanrenTsukeSakujo = KanrenTsukeSakujo;
    }

    /*
     * getNenkinInfoKensaku
     * @return NenkinInfoKensaku
     */
    @JsonProperty("NenkinInfoKensaku")
    public NenkinInfoKensakuDiv getNenkinInfoKensaku() {
        return NenkinInfoKensaku;
    }

    /*
     * setNenkinInfoKensaku
     * @param NenkinInfoKensaku NenkinInfoKensaku
     */
    @JsonProperty("NenkinInfoKensaku")
    public void setNenkinInfoKensaku(NenkinInfoKensakuDiv NenkinInfoKensaku) {
        this.NenkinInfoKensaku = NenkinInfoKensaku;
    }

    /*
     * getKanryoMsg
     * @return KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public KanryoMsgDiv getKanryoMsg() {
        return KanryoMsg;
    }

    /*
     * setKanryoMsg
     * @param KanryoMsg KanryoMsg
     */
    @JsonProperty("KanryoMsg")
    public void setKanryoMsg(KanryoMsgDiv KanryoMsg) {
        this.KanryoMsg = KanryoMsg;
    }

    /*
     * getccdKaigoFukaKihon
     * @return ccdKaigoFukaKihon
     */
    @JsonProperty("ccdKaigoFukaKihon")
    public IKaigoFukaKihonDiv getCcdKaigoFukaKihon() {
        return ccdKaigoFukaKihon;
    }

    /*
     * getccdKaigoAtenaInfo
     * @return ccdKaigoAtenaInfo
     */
    @JsonProperty("ccdKaigoAtenaInfo")
    public IKaigoAtenaInfoDiv getCcdKaigoAtenaInfo() {
        return ccdKaigoAtenaInfo;
    }

    /*
     * getyearofprocessedsequence
     * @return yearofprocessedsequence
     */
    @JsonProperty("yearofprocessedsequence")
    public RString getYearofprocessedsequence() {
        return yearofprocessedsequence;
    }

    /*
     * setyearofprocessedsequence
     * @param yearofprocessedsequence yearofprocessedsequence
     */
    @JsonProperty("yearofprocessedsequence")
    public void setYearofprocessedsequence(RString yearofprocessedsequence) {
        this.yearofprocessedsequence = yearofprocessedsequence;
    }

    /*
     * getoldNenkinNo
     * @return oldNenkinNo
     */
    @JsonProperty("oldNenkinNo")
    public RString getOldNenkinNo() {
        return oldNenkinNo;
    }

    /*
     * setoldNenkinNo
     * @param oldNenkinNo oldNenkinNo
     */
    @JsonProperty("oldNenkinNo")
    public void setOldNenkinNo(RString oldNenkinNo) {
        this.oldNenkinNo = oldNenkinNo;
    }

    /*
     * getoldNenkinCode
     * @return oldNenkinCode
     */
    @JsonProperty("oldNenkinCode")
    public RString getOldNenkinCode() {
        return oldNenkinCode;
    }

    /*
     * setoldNenkinCode
     * @param oldNenkinCode oldNenkinCode
     */
    @JsonProperty("oldNenkinCode")
    public void setOldNenkinCode(RString oldNenkinCode) {
        this.oldNenkinCode = oldNenkinCode;
    }

    /*
     * getcatchMoon
     * @return catchMoon
     */
    @JsonProperty("catchMoon")
    public RString getCatchMoon() {
        return catchMoon;
    }

    /*
     * setcatchMoon
     * @param catchMoon catchMoon
     */
    @JsonProperty("catchMoon")
    public void setCatchMoon(RString catchMoon) {
        this.catchMoon = catchMoon;
    }

    /*
     * gettokubetsuChoshuGimushaCode
     * @return tokubetsuChoshuGimushaCode
     */
    @JsonProperty("tokubetsuChoshuGimushaCode")
    public RString getTokubetsuChoshuGimushaCode() {
        return tokubetsuChoshuGimushaCode;
    }

    /*
     * settokubetsuChoshuGimushaCode
     * @param tokubetsuChoshuGimushaCode tokubetsuChoshuGimushaCode
     */
    @JsonProperty("tokubetsuChoshuGimushaCode")
    public void setTokubetsuChoshuGimushaCode(RString tokubetsuChoshuGimushaCode) {
        this.tokubetsuChoshuGimushaCode = tokubetsuChoshuGimushaCode;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKisoNenkinNo() {
        return this.getNenkinJohoKensaku().getTxtKisoNenkinNo();
    }

    @JsonIgnore
    public void  setTxtKisoNenkinNo(TextBox txtKisoNenkinNo) {
        this.getNenkinJohoKensaku().setTxtKisoNenkinNo(txtKisoNenkinNo);
    }

    @JsonIgnore
    public TextBox getTxtNenkinCode() {
        return this.getNenkinJohoKensaku().getTxtNenkinCode();
    }

    @JsonIgnore
    public void  setTxtNenkinCode(TextBox txtNenkinCode) {
        this.getNenkinJohoKensaku().setTxtNenkinCode(txtNenkinCode);
    }

    @JsonIgnore
    public TextBox getTxtNenkinMeiSho() {
        return this.getNenkinJohoKensaku().getTxtNenkinMeiSho();
    }

    @JsonIgnore
    public void  setTxtNenkinMeiSho(TextBox txtNenkinMeiSho) {
        this.getNenkinJohoKensaku().setTxtNenkinMeiSho(txtNenkinMeiSho);
    }

    @JsonIgnore
    public Button getBtnNenkinInfoKensaku() {
        return this.getNenkinJohoKensaku().getBtnNenkinInfoKensaku();
    }

    @JsonIgnore
    public void  setBtnNenkinInfoKensaku(Button btnNenkinInfoKensaku) {
        this.getNenkinJohoKensaku().setBtnNenkinInfoKensaku(btnNenkinInfoKensaku);
    }

    @JsonIgnore
    public Button getBtnKanrenTsukeSakujo() {
        return this.getKanrenTsukeSakujo().getBtnKanrenTsukeSakujo();
    }

    @JsonIgnore
    public void  setBtnKanrenTsukeSakujo(Button btnKanrenTsukeSakujo) {
        this.getKanrenTsukeSakujo().setBtnKanrenTsukeSakujo(btnKanrenTsukeSakujo);
    }

    @JsonIgnore
    public TextBox getTxtKaishiTsuki() {
        return this.getNenkinInfoKensaku().getTxtKaishiTsuki();
    }

    @JsonIgnore
    public void  setTxtKaishiTsuki(TextBox txtKaishiTsuki) {
        this.getNenkinInfoKensaku().setTxtKaishiTsuki(txtKaishiTsuki);
    }

    @JsonIgnore
    public TextBox getTxtHosokuTsuki() {
        return this.getNenkinInfoKensaku().getTxtHosokuTsuki();
    }

    @JsonIgnore
    public void  setTxtHosokuTsuki(TextBox txtHosokuTsuki) {
        this.getNenkinInfoKensaku().setTxtHosokuTsuki(txtHosokuTsuki);
    }

    @JsonIgnore
    public TextBoxKana getTxtShimeiKana() {
        return this.getNenkinInfoKensaku().getTxtShimeiKana();
    }

    @JsonIgnore
    public void  setTxtShimeiKana(TextBoxKana txtShimeiKana) {
        this.getNenkinInfoKensaku().setTxtShimeiKana(txtShimeiKana);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtUmareYMD() {
        return this.getNenkinInfoKensaku().getTxtUmareYMD();
    }

    @JsonIgnore
    public void  setTxtUmareYMD(TextBoxFlexibleDate txtUmareYMD) {
        this.getNenkinInfoKensaku().setTxtUmareYMD(txtUmareYMD);
    }

    @JsonIgnore
    public TextBox getTxtShimeiKanji() {
        return this.getNenkinInfoKensaku().getTxtShimeiKanji();
    }

    @JsonIgnore
    public void  setTxtShimeiKanji(TextBox txtShimeiKanji) {
        this.getNenkinInfoKensaku().setTxtShimeiKanji(txtShimeiKanji);
    }

    @JsonIgnore
    public TextBox getTxtSebetsu() {
        return this.getNenkinInfoKensaku().getTxtSebetsu();
    }

    @JsonIgnore
    public void  setTxtSebetsu(TextBox txtSebetsu) {
        this.getNenkinInfoKensaku().setTxtSebetsu(txtSebetsu);
    }

    @JsonIgnore
    public TextBoxKana getTxtJushoKana() {
        return this.getNenkinInfoKensaku().getTxtJushoKana();
    }

    @JsonIgnore
    public void  setTxtJushoKana(TextBoxKana txtJushoKana) {
        this.getNenkinInfoKensaku().setTxtJushoKana(txtJushoKana);
    }

    @JsonIgnore
    public TextBox getTxtJushoKanji() {
        return this.getNenkinInfoKensaku().getTxtJushoKanji();
    }

    @JsonIgnore
    public void  setTxtJushoKanji(TextBox txtJushoKanji) {
        this.getNenkinInfoKensaku().setTxtJushoKanji(txtJushoKanji);
    }

    @JsonIgnore
    public TextBox getTxtTokuchoGimusha() {
        return this.getNenkinInfoKensaku().getTxtTokuchoGimusha();
    }

    @JsonIgnore
    public void  setTxtTokuchoGimusha(TextBox txtTokuchoGimusha) {
        this.getNenkinInfoKensaku().setTxtTokuchoGimusha(txtTokuchoGimusha);
    }

    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessge() {
        return this.getKanryoMsg().getCcdKaigoKanryoMessge();
    }

    // </editor-fold>
}
