package jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD3010002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.IKaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoatenainfo.KaigoAtenaInfo.KaigoAtenaInfoDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.IKaigoShikakuKihonDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.kaigoshikakukihon.KaigoShikakuKihon.KaigoShikakuKihonDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * JukyushaShokai のクラスファイル 
 * 
 * @author 自動生成
 */
public class JukyushaShokaiDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-10-17_21-01-54">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("ButtonsShosaiShiji")
    private ButtonsShosaiShijiDiv ButtonsShosaiShiji;
    @JsonProperty("NinteiRireki")
    private NinteiRirekiDiv NinteiRireki;
    @JsonProperty("DvRiyoshafutanGakuWariai")
    private DvRiyoshafutanGakuWariaiDiv DvRiyoshafutanGakuWariai;
    @JsonProperty("NinteiDetail")
    private NinteiDetailDiv NinteiDetail;
    @JsonProperty("kaigoShikaku")
    private KaigoShikakuKihonDiv kaigoShikaku;
    @JsonProperty("kaigoAtena")
    private KaigoAtenaInfoDiv kaigoAtena;
    @JsonProperty("hiddenHihokenshaNo")
    private RString hiddenHihokenshaNo;
    @JsonProperty("hiddenShikibetsuCode")
    private RString hiddenShikibetsuCode;
    @JsonProperty("hiddenGyomuCode")
    private RString hiddenGyomuCode;
    @JsonProperty("hiddenモード")
    private RString hiddenモード;
    @JsonProperty("hidden今回履歴情報")
    private RString hidden今回履歴情報;
    @JsonProperty("hidden前回履歴情報")
    private RString hidden前回履歴情報;
    @JsonProperty("hidden表示判定キー")
    private RString hidden表示判定キー;
    @JsonProperty("hiddenSubGyomuCd")
    private RString hiddenSubGyomuCd;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getButtonsShosaiShiji
     * @return ButtonsShosaiShiji
     */
    @JsonProperty("ButtonsShosaiShiji")
    public ButtonsShosaiShijiDiv getButtonsShosaiShiji() {
        return ButtonsShosaiShiji;
    }

    /*
     * setButtonsShosaiShiji
     * @param ButtonsShosaiShiji ButtonsShosaiShiji
     */
    @JsonProperty("ButtonsShosaiShiji")
    public void setButtonsShosaiShiji(ButtonsShosaiShijiDiv ButtonsShosaiShiji) {
        this.ButtonsShosaiShiji = ButtonsShosaiShiji;
    }

    /*
     * getNinteiRireki
     * @return NinteiRireki
     */
    @JsonProperty("NinteiRireki")
    public NinteiRirekiDiv getNinteiRireki() {
        return NinteiRireki;
    }

    /*
     * setNinteiRireki
     * @param NinteiRireki NinteiRireki
     */
    @JsonProperty("NinteiRireki")
    public void setNinteiRireki(NinteiRirekiDiv NinteiRireki) {
        this.NinteiRireki = NinteiRireki;
    }

    /*
     * getDvRiyoshafutanGakuWariai
     * @return DvRiyoshafutanGakuWariai
     */
    @JsonProperty("DvRiyoshafutanGakuWariai")
    public DvRiyoshafutanGakuWariaiDiv getDvRiyoshafutanGakuWariai() {
        return DvRiyoshafutanGakuWariai;
    }

    /*
     * setDvRiyoshafutanGakuWariai
     * @param DvRiyoshafutanGakuWariai DvRiyoshafutanGakuWariai
     */
    @JsonProperty("DvRiyoshafutanGakuWariai")
    public void setDvRiyoshafutanGakuWariai(DvRiyoshafutanGakuWariaiDiv DvRiyoshafutanGakuWariai) {
        this.DvRiyoshafutanGakuWariai = DvRiyoshafutanGakuWariai;
    }

    /*
     * getNinteiDetail
     * @return NinteiDetail
     */
    @JsonProperty("NinteiDetail")
    public NinteiDetailDiv getNinteiDetail() {
        return NinteiDetail;
    }

    /*
     * setNinteiDetail
     * @param NinteiDetail NinteiDetail
     */
    @JsonProperty("NinteiDetail")
    public void setNinteiDetail(NinteiDetailDiv NinteiDetail) {
        this.NinteiDetail = NinteiDetail;
    }

    /*
     * getkaigoShikaku
     * @return kaigoShikaku
     */
    @JsonProperty("kaigoShikaku")
    public IKaigoShikakuKihonDiv getKaigoShikaku() {
        return kaigoShikaku;
    }

    /*
     * getkaigoAtena
     * @return kaigoAtena
     */
    @JsonProperty("kaigoAtena")
    public IKaigoAtenaInfoDiv getKaigoAtena() {
        return kaigoAtena;
    }

    /*
     * gethiddenHihokenshaNo
     * @return hiddenHihokenshaNo
     */
    @JsonProperty("hiddenHihokenshaNo")
    public RString getHiddenHihokenshaNo() {
        return hiddenHihokenshaNo;
    }

    /*
     * sethiddenHihokenshaNo
     * @param hiddenHihokenshaNo hiddenHihokenshaNo
     */
    @JsonProperty("hiddenHihokenshaNo")
    public void setHiddenHihokenshaNo(RString hiddenHihokenshaNo) {
        this.hiddenHihokenshaNo = hiddenHihokenshaNo;
    }

    /*
     * gethiddenShikibetsuCode
     * @return hiddenShikibetsuCode
     */
    @JsonProperty("hiddenShikibetsuCode")
    public RString getHiddenShikibetsuCode() {
        return hiddenShikibetsuCode;
    }

    /*
     * sethiddenShikibetsuCode
     * @param hiddenShikibetsuCode hiddenShikibetsuCode
     */
    @JsonProperty("hiddenShikibetsuCode")
    public void setHiddenShikibetsuCode(RString hiddenShikibetsuCode) {
        this.hiddenShikibetsuCode = hiddenShikibetsuCode;
    }

    /*
     * gethiddenGyomuCode
     * @return hiddenGyomuCode
     */
    @JsonProperty("hiddenGyomuCode")
    public RString getHiddenGyomuCode() {
        return hiddenGyomuCode;
    }

    /*
     * sethiddenGyomuCode
     * @param hiddenGyomuCode hiddenGyomuCode
     */
    @JsonProperty("hiddenGyomuCode")
    public void setHiddenGyomuCode(RString hiddenGyomuCode) {
        this.hiddenGyomuCode = hiddenGyomuCode;
    }

    /*
     * gethiddenモード
     * @return hiddenモード
     */
    @JsonProperty("hiddenモード")
    public RString getHiddenモード() {
        return hiddenモード;
    }

    /*
     * sethiddenモード
     * @param hiddenモード hiddenモード
     */
    @JsonProperty("hiddenモード")
    public void setHiddenモード(RString hiddenモード) {
        this.hiddenモード = hiddenモード;
    }

    /*
     * gethidden今回履歴情報
     * @return hidden今回履歴情報
     */
    @JsonProperty("hidden今回履歴情報")
    public RString getHidden今回履歴情報() {
        return hidden今回履歴情報;
    }

    /*
     * sethidden今回履歴情報
     * @param hidden今回履歴情報 hidden今回履歴情報
     */
    @JsonProperty("hidden今回履歴情報")
    public void setHidden今回履歴情報(RString hidden今回履歴情報) {
        this.hidden今回履歴情報 = hidden今回履歴情報;
    }

    /*
     * gethidden前回履歴情報
     * @return hidden前回履歴情報
     */
    @JsonProperty("hidden前回履歴情報")
    public RString getHidden前回履歴情報() {
        return hidden前回履歴情報;
    }

    /*
     * sethidden前回履歴情報
     * @param hidden前回履歴情報 hidden前回履歴情報
     */
    @JsonProperty("hidden前回履歴情報")
    public void setHidden前回履歴情報(RString hidden前回履歴情報) {
        this.hidden前回履歴情報 = hidden前回履歴情報;
    }

    /*
     * gethidden表示判定キー
     * @return hidden表示判定キー
     */
    @JsonProperty("hidden表示判定キー")
    public RString getHidden表示判定キー() {
        return hidden表示判定キー;
    }

    /*
     * sethidden表示判定キー
     * @param hidden表示判定キー hidden表示判定キー
     */
    @JsonProperty("hidden表示判定キー")
    public void setHidden表示判定キー(RString hidden表示判定キー) {
        this.hidden表示判定キー = hidden表示判定キー;
    }

    /*
     * gethiddenSubGyomuCd
     * @return hiddenSubGyomuCd
     */
    @JsonProperty("hiddenSubGyomuCd")
    public RString getHiddenSubGyomuCd() {
        return hiddenSubGyomuCd;
    }

    /*
     * sethiddenSubGyomuCd
     * @param hiddenSubGyomuCd hiddenSubGyomuCd
     */
    @JsonProperty("hiddenSubGyomuCd")
    public void setHiddenSubGyomuCd(RString hiddenSubGyomuCd) {
        this.hiddenSubGyomuCd = hiddenSubGyomuCd;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDate getTxtRiyoshafutanNendo() {
        return this.getDvRiyoshafutanGakuWariai().getTxtRiyoshafutanNendo();
    }

    @JsonIgnore
    public void  setTxtRiyoshafutanNendo(TextBoxDate txtRiyoshafutanNendo) {
        this.getDvRiyoshafutanGakuWariai().setTxtRiyoshafutanNendo(txtRiyoshafutanNendo);
    }

    @JsonIgnore
    public TextBox getTxtRiyoshafutanWariai() {
        return this.getDvRiyoshafutanGakuWariai().getTxtRiyoshafutanWariai();
    }

    @JsonIgnore
    public void  setTxtRiyoshafutanWariai(TextBox txtRiyoshafutanWariai) {
        this.getDvRiyoshafutanGakuWariai().setTxtRiyoshafutanWariai(txtRiyoshafutanWariai);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtTekiyoKikan() {
        return this.getDvRiyoshafutanGakuWariai().getTxtTekiyoKikan();
    }

    @JsonIgnore
    public void  setTxtTekiyoKikan(TextBoxDateRange txtTekiyoKikan) {
        this.getDvRiyoshafutanGakuWariai().setTxtTekiyoKikan(txtTekiyoKikan);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShinseiDate() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtShinseiDate();
    }

    @JsonIgnore
    public void  setTxtShinseiDate(TextBoxFlexibleDate txtShinseiDate) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtShinseiDate(txtShinseiDate);
    }

    @JsonIgnore
    public TextBox getTxtShinseiShubetsu1() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtShinseiShubetsu1();
    }

    @JsonIgnore
    public void  setTxtShinseiShubetsu1(TextBox txtShinseiShubetsu1) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtShinseiShubetsu1(txtShinseiShubetsu1);
    }

    @JsonIgnore
    public TextBox getTxtShinseiShubetsu2() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtShinseiShubetsu2();
    }

    @JsonIgnore
    public void  setTxtShinseiShubetsu2(TextBox txtShinseiShubetsu2) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtShinseiShubetsu2(txtShinseiShubetsu2);
    }

    @JsonIgnore
    public TextBox getTxtShujiiMeisho() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtShujiiMeisho();
    }

    @JsonIgnore
    public void  setTxtShujiiMeisho(TextBox txtShujiiMeisho) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtShujiiMeisho(txtShujiiMeisho);
    }

    @JsonIgnore
    public CheckBoxList getChkShiteii() {
        return this.getNinteiDetail().getDvShinseiJoho().getChkShiteii();
    }

    @JsonIgnore
    public void  setChkShiteii(CheckBoxList chkShiteii) {
        this.getNinteiDetail().getDvShinseiJoho().setChkShiteii(chkShiteii);
    }

    @JsonIgnore
    public TextBox getTxtShujiIryokikanMeisho() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtShujiIryokikanMeisho();
    }

    @JsonIgnore
    public void  setTxtShujiIryokikanMeisho(TextBox txtShujiIryokikanMeisho) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtShujiIryokikanMeisho(txtShujiIryokikanMeisho);
    }

    @JsonIgnore
    public ButtonDialog getBtnChosaJokyo() {
        return this.getNinteiDetail().getDvShinseiJoho().getBtnChosaJokyo();
    }

    @JsonIgnore
    public void  setBtnChosaJokyo(ButtonDialog btnChosaJokyo) {
        this.getNinteiDetail().getDvShinseiJoho().setBtnChosaJokyo(btnChosaJokyo);
    }

    @JsonIgnore
    public CheckBoxList getChkShinsei() {
        return this.getNinteiDetail().getDvShinseiJoho().getChkShinsei();
    }

    @JsonIgnore
    public void  setChkShinsei(CheckBoxList chkShinsei) {
        this.getNinteiDetail().getDvShinseiJoho().setChkShinsei(chkShinsei);
    }

    @JsonIgnore
    public TextBox getTxtShinseisha() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtShinseisha();
    }

    @JsonIgnore
    public void  setTxtShinseisha(TextBox txtShinseisha) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtShinseisha(txtShinseisha);
    }

    @JsonIgnore
    public TextBoxMultiLine getTxtShinseiRiyu() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtShinseiRiyu();
    }

    @JsonIgnore
    public void  setTxtShinseiRiyu(TextBoxMultiLine txtShinseiRiyu) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtShinseiRiyu(txtShinseiRiyu);
    }

    @JsonIgnore
    public TextBoxCode getTxtYokaigodoCode() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtYokaigodoCode();
    }

    @JsonIgnore
    public void  setTxtYokaigodoCode(TextBoxCode txtYokaigodoCode) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtYokaigodoCode(txtYokaigodoCode);
    }

    @JsonIgnore
    public TextBox getTxtYokaigodo() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtYokaigodo();
    }

    @JsonIgnore
    public void  setTxtYokaigodo(TextBox txtYokaigodo) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtYokaigodo(txtYokaigodo);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtNinteiYMD() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtNinteiYMD();
    }

    @JsonIgnore
    public void  setTxtNinteiYMD(TextBoxFlexibleDate txtNinteiYMD) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtNinteiYMD(txtNinteiYMD);
    }

    @JsonIgnore
    public TextBoxDateRange getTxtYukoKikan() {
        return this.getNinteiDetail().getDvShinseiJoho().getTxtYukoKikan();
    }

    @JsonIgnore
    public void  setTxtYukoKikan(TextBoxDateRange txtYukoKikan) {
        this.getNinteiDetail().getDvShinseiJoho().setTxtYukoKikan(txtYukoKikan);
    }

    // </editor-fold>
}
