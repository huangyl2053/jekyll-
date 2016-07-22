package jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB2710002;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.IKaigoKanryoMessageDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.KaigoKanryoMessage.KaigoKanryoMessage.KaigoKanryoMessageDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.IOutputChohyoIchiranDiv;
import jp.co.ndensan.reams.ur.urz.divcontroller.entity.commonchilddiv.OutputChohyoIchiran.OutputChohyoIchiranDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * TokuchoTaishoshaIchiran のクラスファイル 
 * 
 * @author 自動生成
 */
public class TokuchoTaishoshaIchiranDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("TokuchoTaishoshaIchiranSelectJokenPanel")
    private TokuchoTaishoshaIchiranSelectJokenPanelDiv TokuchoTaishoshaIchiranSelectJokenPanel;
    @JsonProperty("ShutsuryokuTaishoPanel")
    private ShutsuryokuTaishoPanelDiv ShutsuryokuTaishoPanel;
    @JsonProperty("DoteiMiDoteiShisei")
    private DoteiMiDoteiShiseiDiv DoteiMiDoteiShisei;
    @JsonProperty("TokuchoDoteiIchiran")
    private TokuchoDoteiIchiranDiv TokuchoDoteiIchiran;
    @JsonProperty("TokuchoMidoteiIchiran")
    private TokuchoMidoteiIchiranDiv TokuchoMidoteiIchiran;
    @JsonProperty("TokuchoDoteiKohoshaIchiran")
    private TokuchoDoteiKohoshaIchiranDiv TokuchoDoteiKohoshaIchiran;
    @JsonProperty("TokuchoDoteiKohoshaShosai")
    private TokuchoDoteiKohoshaShosaiDiv TokuchoDoteiKohoshaShosai;
    @JsonProperty("KanryoKakunin")
    private KanryoKakuninDiv KanryoKakunin;
    @JsonProperty("ccdOutputChohyoIchiran")
    private OutputChohyoIchiranDiv ccdOutputChohyoIchiran;
    @JsonProperty("hiddenTokubetsuChoshuGimushaCode")
    private RString hiddenTokubetsuChoshuGimushaCode;
    @JsonProperty("hiddenState")
    private RString hiddenState;
    @JsonProperty("hiddenReasonCode")
    private RString hiddenReasonCode;
    @JsonProperty("hiddenConfirmState")
    private RString hiddenConfirmState;
    @JsonProperty("hiddenFukaNendo")
    private RString hiddenFukaNendo;
    @JsonProperty("hiddenPageState")
    private RString hiddenPageState;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getTokuchoTaishoshaIchiranSelectJokenPanel
     * @return TokuchoTaishoshaIchiranSelectJokenPanel
     */
    @JsonProperty("TokuchoTaishoshaIchiranSelectJokenPanel")
    public TokuchoTaishoshaIchiranSelectJokenPanelDiv getTokuchoTaishoshaIchiranSelectJokenPanel() {
        return TokuchoTaishoshaIchiranSelectJokenPanel;
    }

    /*
     * setTokuchoTaishoshaIchiranSelectJokenPanel
     * @param TokuchoTaishoshaIchiranSelectJokenPanel TokuchoTaishoshaIchiranSelectJokenPanel
     */
    @JsonProperty("TokuchoTaishoshaIchiranSelectJokenPanel")
    public void setTokuchoTaishoshaIchiranSelectJokenPanel(TokuchoTaishoshaIchiranSelectJokenPanelDiv TokuchoTaishoshaIchiranSelectJokenPanel) {
        this.TokuchoTaishoshaIchiranSelectJokenPanel = TokuchoTaishoshaIchiranSelectJokenPanel;
    }

    /*
     * getShutsuryokuTaishoPanel
     * @return ShutsuryokuTaishoPanel
     */
    @JsonProperty("ShutsuryokuTaishoPanel")
    public ShutsuryokuTaishoPanelDiv getShutsuryokuTaishoPanel() {
        return ShutsuryokuTaishoPanel;
    }

    /*
     * setShutsuryokuTaishoPanel
     * @param ShutsuryokuTaishoPanel ShutsuryokuTaishoPanel
     */
    @JsonProperty("ShutsuryokuTaishoPanel")
    public void setShutsuryokuTaishoPanel(ShutsuryokuTaishoPanelDiv ShutsuryokuTaishoPanel) {
        this.ShutsuryokuTaishoPanel = ShutsuryokuTaishoPanel;
    }

    /*
     * getDoteiMiDoteiShisei
     * @return DoteiMiDoteiShisei
     */
    @JsonProperty("DoteiMiDoteiShisei")
    public DoteiMiDoteiShiseiDiv getDoteiMiDoteiShisei() {
        return DoteiMiDoteiShisei;
    }

    /*
     * setDoteiMiDoteiShisei
     * @param DoteiMiDoteiShisei DoteiMiDoteiShisei
     */
    @JsonProperty("DoteiMiDoteiShisei")
    public void setDoteiMiDoteiShisei(DoteiMiDoteiShiseiDiv DoteiMiDoteiShisei) {
        this.DoteiMiDoteiShisei = DoteiMiDoteiShisei;
    }

    /*
     * getTokuchoDoteiIchiran
     * @return TokuchoDoteiIchiran
     */
    @JsonProperty("TokuchoDoteiIchiran")
    public TokuchoDoteiIchiranDiv getTokuchoDoteiIchiran() {
        return TokuchoDoteiIchiran;
    }

    /*
     * setTokuchoDoteiIchiran
     * @param TokuchoDoteiIchiran TokuchoDoteiIchiran
     */
    @JsonProperty("TokuchoDoteiIchiran")
    public void setTokuchoDoteiIchiran(TokuchoDoteiIchiranDiv TokuchoDoteiIchiran) {
        this.TokuchoDoteiIchiran = TokuchoDoteiIchiran;
    }

    /*
     * getTokuchoMidoteiIchiran
     * @return TokuchoMidoteiIchiran
     */
    @JsonProperty("TokuchoMidoteiIchiran")
    public TokuchoMidoteiIchiranDiv getTokuchoMidoteiIchiran() {
        return TokuchoMidoteiIchiran;
    }

    /*
     * setTokuchoMidoteiIchiran
     * @param TokuchoMidoteiIchiran TokuchoMidoteiIchiran
     */
    @JsonProperty("TokuchoMidoteiIchiran")
    public void setTokuchoMidoteiIchiran(TokuchoMidoteiIchiranDiv TokuchoMidoteiIchiran) {
        this.TokuchoMidoteiIchiran = TokuchoMidoteiIchiran;
    }

    /*
     * getTokuchoDoteiKohoshaIchiran
     * @return TokuchoDoteiKohoshaIchiran
     */
    @JsonProperty("TokuchoDoteiKohoshaIchiran")
    public TokuchoDoteiKohoshaIchiranDiv getTokuchoDoteiKohoshaIchiran() {
        return TokuchoDoteiKohoshaIchiran;
    }

    /*
     * setTokuchoDoteiKohoshaIchiran
     * @param TokuchoDoteiKohoshaIchiran TokuchoDoteiKohoshaIchiran
     */
    @JsonProperty("TokuchoDoteiKohoshaIchiran")
    public void setTokuchoDoteiKohoshaIchiran(TokuchoDoteiKohoshaIchiranDiv TokuchoDoteiKohoshaIchiran) {
        this.TokuchoDoteiKohoshaIchiran = TokuchoDoteiKohoshaIchiran;
    }

    /*
     * getTokuchoDoteiKohoshaShosai
     * @return TokuchoDoteiKohoshaShosai
     */
    @JsonProperty("TokuchoDoteiKohoshaShosai")
    public TokuchoDoteiKohoshaShosaiDiv getTokuchoDoteiKohoshaShosai() {
        return TokuchoDoteiKohoshaShosai;
    }

    /*
     * setTokuchoDoteiKohoshaShosai
     * @param TokuchoDoteiKohoshaShosai TokuchoDoteiKohoshaShosai
     */
    @JsonProperty("TokuchoDoteiKohoshaShosai")
    public void setTokuchoDoteiKohoshaShosai(TokuchoDoteiKohoshaShosaiDiv TokuchoDoteiKohoshaShosai) {
        this.TokuchoDoteiKohoshaShosai = TokuchoDoteiKohoshaShosai;
    }

    /*
     * getKanryoKakunin
     * @return KanryoKakunin
     */
    @JsonProperty("KanryoKakunin")
    public KanryoKakuninDiv getKanryoKakunin() {
        return KanryoKakunin;
    }

    /*
     * setKanryoKakunin
     * @param KanryoKakunin KanryoKakunin
     */
    @JsonProperty("KanryoKakunin")
    public void setKanryoKakunin(KanryoKakuninDiv KanryoKakunin) {
        this.KanryoKakunin = KanryoKakunin;
    }

    /*
     * getccdOutputChohyoIchiran
     * @return ccdOutputChohyoIchiran
     */
    @JsonProperty("ccdOutputChohyoIchiran")
    public IOutputChohyoIchiranDiv getCcdOutputChohyoIchiran() {
        return ccdOutputChohyoIchiran;
    }

    /*
     * gethiddenTokubetsuChoshuGimushaCode
     * @return hiddenTokubetsuChoshuGimushaCode
     */
    @JsonProperty("hiddenTokubetsuChoshuGimushaCode")
    public RString getHiddenTokubetsuChoshuGimushaCode() {
        return hiddenTokubetsuChoshuGimushaCode;
    }

    /*
     * sethiddenTokubetsuChoshuGimushaCode
     * @param hiddenTokubetsuChoshuGimushaCode hiddenTokubetsuChoshuGimushaCode
     */
    @JsonProperty("hiddenTokubetsuChoshuGimushaCode")
    public void setHiddenTokubetsuChoshuGimushaCode(RString hiddenTokubetsuChoshuGimushaCode) {
        this.hiddenTokubetsuChoshuGimushaCode = hiddenTokubetsuChoshuGimushaCode;
    }

    /*
     * gethiddenState
     * @return hiddenState
     */
    @JsonProperty("hiddenState")
    public RString getHiddenState() {
        return hiddenState;
    }

    /*
     * sethiddenState
     * @param hiddenState hiddenState
     */
    @JsonProperty("hiddenState")
    public void setHiddenState(RString hiddenState) {
        this.hiddenState = hiddenState;
    }

    /*
     * gethiddenReasonCode
     * @return hiddenReasonCode
     */
    @JsonProperty("hiddenReasonCode")
    public RString getHiddenReasonCode() {
        return hiddenReasonCode;
    }

    /*
     * sethiddenReasonCode
     * @param hiddenReasonCode hiddenReasonCode
     */
    @JsonProperty("hiddenReasonCode")
    public void setHiddenReasonCode(RString hiddenReasonCode) {
        this.hiddenReasonCode = hiddenReasonCode;
    }

    /*
     * gethiddenConfirmState
     * @return hiddenConfirmState
     */
    @JsonProperty("hiddenConfirmState")
    public RString getHiddenConfirmState() {
        return hiddenConfirmState;
    }

    /*
     * sethiddenConfirmState
     * @param hiddenConfirmState hiddenConfirmState
     */
    @JsonProperty("hiddenConfirmState")
    public void setHiddenConfirmState(RString hiddenConfirmState) {
        this.hiddenConfirmState = hiddenConfirmState;
    }

    /*
     * gethiddenFukaNendo
     * @return hiddenFukaNendo
     */
    @JsonProperty("hiddenFukaNendo")
    public RString getHiddenFukaNendo() {
        return hiddenFukaNendo;
    }

    /*
     * sethiddenFukaNendo
     * @param hiddenFukaNendo hiddenFukaNendo
     */
    @JsonProperty("hiddenFukaNendo")
    public void setHiddenFukaNendo(RString hiddenFukaNendo) {
        this.hiddenFukaNendo = hiddenFukaNendo;
    }

    /*
     * gethiddenPageState
     * @return hiddenPageState
     */
    @JsonProperty("hiddenPageState")
    public RString getHiddenPageState() {
        return hiddenPageState;
    }

    /*
     * sethiddenPageState
     * @param hiddenPageState hiddenPageState
     */
    @JsonProperty("hiddenPageState")
    public void setHiddenPageState(RString hiddenPageState) {
        this.hiddenPageState = hiddenPageState;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBox getTxtKaishiYM() {
        return this.getTokuchoTaishoshaIchiranSelectJokenPanel().getTxtKaishiYM();
    }

    @JsonIgnore
    public void  setTxtKaishiYM(TextBox txtKaishiYM) {
        this.getTokuchoTaishoshaIchiranSelectJokenPanel().setTxtKaishiYM(txtKaishiYM);
    }

    @JsonIgnore
    public CheckBoxList getChkShutsuryokuTaisho() {
        return this.getShutsuryokuTaishoPanel().getChkShutsuryokuTaisho();
    }

    @JsonIgnore
    public void  setChkShutsuryokuTaisho(CheckBoxList chkShutsuryokuTaisho) {
        this.getShutsuryokuTaishoPanel().setChkShutsuryokuTaisho(chkShutsuryokuTaisho);
    }

    @JsonIgnore
    public RadioButton getRadhyojiTaisho() {
        return this.getDoteiMiDoteiShisei().getRadhyojiTaisho();
    }

    @JsonIgnore
    public void  setRadhyojiTaisho(RadioButton radhyojiTaisho) {
        this.getDoteiMiDoteiShisei().setRadhyojiTaisho(radhyojiTaisho);
    }

    @JsonIgnore
    public KakuninZumiFukumuDiv getKakuninZumiFukumu() {
        return this.getDoteiMiDoteiShisei().getKakuninZumiFukumu();
    }

    @JsonIgnore
    public void  setKakuninZumiFukumu(KakuninZumiFukumuDiv KakuninZumiFukumu) {
        this.getDoteiMiDoteiShisei().setKakuninZumiFukumu(KakuninZumiFukumu);
    }

    @JsonIgnore
    public CheckBoxList getChkKakuninZumiFukumu() {
        return this.getDoteiMiDoteiShisei().getKakuninZumiFukumu().getChkKakuninZumiFukumu();
    }

    @JsonIgnore
    public void  setChkKakuninZumiFukumu(CheckBoxList chkKakuninZumiFukumu) {
        this.getDoteiMiDoteiShisei().getKakuninZumiFukumu().setChkKakuninZumiFukumu(chkKakuninZumiFukumu);
    }

    @JsonIgnore
    public TextBox getTxtMaxHyojiKensu() {
        return this.getDoteiMiDoteiShisei().getTxtMaxHyojiKensu();
    }

    @JsonIgnore
    public void  setTxtMaxHyojiKensu(TextBox txtMaxHyojiKensu) {
        this.getDoteiMiDoteiShisei().setTxtMaxHyojiKensu(txtMaxHyojiKensu);
    }

    @JsonIgnore
    public DataGrid<dgTokubetChoshuTaishoshaIchiran_Row> getDgTokubetChoshuTaishoshaIchiran() {
        return this.getTokuchoDoteiIchiran().getDgTokubetChoshuTaishoshaIchiran();
    }

    @JsonIgnore
    public void  setDgTokubetChoshuTaishoshaIchiran(DataGrid<dgTokubetChoshuTaishoshaIchiran_Row> dgTokubetChoshuTaishoshaIchiran) {
        this.getTokuchoDoteiIchiran().setDgTokubetChoshuTaishoshaIchiran(dgTokubetChoshuTaishoshaIchiran);
    }

    @JsonIgnore
    public DataGrid<dgTokubetChoshuMidoteiIchiran_Row> getDgTokubetChoshuMidoteiIchiran() {
        return this.getTokuchoMidoteiIchiran().getDgTokubetChoshuMidoteiIchiran();
    }

    @JsonIgnore
    public void  setDgTokubetChoshuMidoteiIchiran(DataGrid<dgTokubetChoshuMidoteiIchiran_Row> dgTokubetChoshuMidoteiIchiran) {
        this.getTokuchoMidoteiIchiran().setDgTokubetChoshuMidoteiIchiran(dgTokubetChoshuMidoteiIchiran);
    }

    @JsonIgnore
    public DataGrid<dgTokuchoDoteiKohoshaIchiran_Row> getDgTokuchoDoteiKohoshaIchiran() {
        return this.getTokuchoDoteiKohoshaIchiran().getDgTokuchoDoteiKohoshaIchiran();
    }

    @JsonIgnore
    public void  setDgTokuchoDoteiKohoshaIchiran(DataGrid<dgTokuchoDoteiKohoshaIchiran_Row> dgTokuchoDoteiKohoshaIchiran) {
        this.getTokuchoDoteiKohoshaIchiran().setDgTokuchoDoteiKohoshaIchiran(dgTokuchoDoteiKohoshaIchiran);
    }

    @JsonIgnore
    public NenkinTokuchoKaifuInfoDiv getNenkinTokuchoKaifuInfo() {
        return this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo();
    }

    @JsonIgnore
    public void  setNenkinTokuchoKaifuInfo(NenkinTokuchoKaifuInfoDiv NenkinTokuchoKaifuInfo) {
        this.getTokuchoDoteiKohoshaIchiran().setNenkinTokuchoKaifuInfo(NenkinTokuchoKaifuInfo);
    }

    @JsonIgnore
    public TextBox getTxtKisoNenkinNo() {
        return this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().getTxtKisoNenkinNo();
    }

    @JsonIgnore
    public void  setTxtKisoNenkinNo(TextBox txtKisoNenkinNo) {
        this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().setTxtKisoNenkinNo(txtKisoNenkinNo);
    }

    @JsonIgnore
    public TextBox getTxtNenkinCode() {
        return this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().getTxtNenkinCode();
    }

    @JsonIgnore
    public void  setTxtNenkinCode(TextBox txtNenkinCode) {
        this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().setTxtNenkinCode(txtNenkinCode);
    }

    @JsonIgnore
    public TextBox getTxtTokuchoGimusha() {
        return this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().getTxtTokuchoGimusha();
    }

    @JsonIgnore
    public void  setTxtTokuchoGimusha(TextBox txtTokuchoGimusha) {
        this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().setTxtTokuchoGimusha(txtTokuchoGimusha);
    }

    @JsonIgnore
    public TextBox getTxtShimeiKana() {
        return this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().getTxtShimeiKana();
    }

    @JsonIgnore
    public void  setTxtShimeiKana(TextBox txtShimeiKana) {
        this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().setTxtShimeiKana(txtShimeiKana);
    }

    @JsonIgnore
    public TextBoxDate getTxtUmareYMD() {
        return this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().getTxtUmareYMD();
    }

    @JsonIgnore
    public void  setTxtUmareYMD(TextBoxDate txtUmareYMD) {
        this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().setTxtUmareYMD(txtUmareYMD);
    }

    @JsonIgnore
    public TextBox getTxtShimeiKanji() {
        return this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().getTxtShimeiKanji();
    }

    @JsonIgnore
    public void  setTxtShimeiKanji(TextBox txtShimeiKanji) {
        this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().setTxtShimeiKanji(txtShimeiKanji);
    }

    @JsonIgnore
    public TextBox getTxtSebetsu() {
        return this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().getTxtSebetsu();
    }

    @JsonIgnore
    public void  setTxtSebetsu(TextBox txtSebetsu) {
        this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().setTxtSebetsu(txtSebetsu);
    }

    @JsonIgnore
    public TextBox getTxtJushoKana() {
        return this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().getTxtJushoKana();
    }

    @JsonIgnore
    public void  setTxtJushoKana(TextBox txtJushoKana) {
        this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().setTxtJushoKana(txtJushoKana);
    }

    @JsonIgnore
    public TextBox getTxtJushoKanji() {
        return this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().getTxtJushoKanji();
    }

    @JsonIgnore
    public void  setTxtJushoKanji(TextBox txtJushoKanji) {
        this.getTokuchoDoteiKohoshaIchiran().getNenkinTokuchoKaifuInfo().setTxtJushoKanji(txtJushoKanji);
    }

    @JsonIgnore
    public AtenaInfoDiv getAtenaInfo() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo();
    }

    @JsonIgnore
    public void  setAtenaInfo(AtenaInfoDiv AtenaInfo) {
        this.getTokuchoDoteiKohoshaShosai().setAtenaInfo(AtenaInfo);
    }

    @JsonIgnore
    public TextBox getTxtShikibetsuCode() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().getTxtShikibetsuCode();
    }

    @JsonIgnore
    public void  setTxtShikibetsuCode(TextBox txtShikibetsuCode) {
        this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().setTxtShikibetsuCode(txtShikibetsuCode);
    }

    @JsonIgnore
    public TextBox getTxtAtenaShimeiKana() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().getTxtAtenaShimeiKana();
    }

    @JsonIgnore
    public void  setTxtAtenaShimeiKana(TextBox txtAtenaShimeiKana) {
        this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().setTxtAtenaShimeiKana(txtAtenaShimeiKana);
    }

    @JsonIgnore
    public TextBoxDate getTxtAtenaUmareYMD() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().getTxtAtenaUmareYMD();
    }

    @JsonIgnore
    public void  setTxtAtenaUmareYMD(TextBoxDate txtAtenaUmareYMD) {
        this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().setTxtAtenaUmareYMD(txtAtenaUmareYMD);
    }

    @JsonIgnore
    public TextBox getTxtJuminshu() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().getTxtJuminshu();
    }

    @JsonIgnore
    public void  setTxtJuminshu(TextBox txtJuminshu) {
        this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().setTxtJuminshu(txtJuminshu);
    }

    @JsonIgnore
    public TextBox getTxtAtenaShimeiKanji() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().getTxtAtenaShimeiKanji();
    }

    @JsonIgnore
    public void  setTxtAtenaShimeiKanji(TextBox txtAtenaShimeiKanji) {
        this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().setTxtAtenaShimeiKanji(txtAtenaShimeiKanji);
    }

    @JsonIgnore
    public TextBox getTxtAtenaSebetsu() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().getTxtAtenaSebetsu();
    }

    @JsonIgnore
    public void  setTxtAtenaSebetsu(TextBox txtAtenaSebetsu) {
        this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().setTxtAtenaSebetsu(txtAtenaSebetsu);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtJutoYMD() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().getTxtJutoYMD();
    }

    @JsonIgnore
    public void  setTxtJutoYMD(TextBoxFlexibleDate txtJutoYMD) {
        this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().setTxtJutoYMD(txtJutoYMD);
    }

    @JsonIgnore
    public TextBox getTxtAtenaJushoKana() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().getTxtAtenaJushoKana();
    }

    @JsonIgnore
    public void  setTxtAtenaJushoKana(TextBox txtAtenaJushoKana) {
        this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().setTxtAtenaJushoKana(txtAtenaJushoKana);
    }

    @JsonIgnore
    public TextBoxFlexibleDate getTxtShojoYMD() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().getTxtShojoYMD();
    }

    @JsonIgnore
    public void  setTxtShojoYMD(TextBoxFlexibleDate txtShojoYMD) {
        this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().setTxtShojoYMD(txtShojoYMD);
    }

    @JsonIgnore
    public TextBox getTxtAtenaJushoKanji() {
        return this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().getTxtAtenaJushoKanji();
    }

    @JsonIgnore
    public void  setTxtAtenaJushoKanji(TextBox txtAtenaJushoKanji) {
        this.getTokuchoDoteiKohoshaShosai().getAtenaInfo().setTxtAtenaJushoKanji(txtAtenaJushoKanji);
    }

    @JsonIgnore
    public KaigoShikakuInfoDiv getKaigoShikakuInfo() {
        return this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo();
    }

    @JsonIgnore
    public void  setKaigoShikakuInfo(KaigoShikakuInfoDiv KaigoShikakuInfo) {
        this.getTokuchoDoteiKohoshaShosai().setKaigoShikakuInfo(KaigoShikakuInfo);
    }

    @JsonIgnore
    public TextBox getTxtHihokenshaNo() {
        return this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().getTxtHihokenshaNo();
    }

    @JsonIgnore
    public void  setTxtHihokenshaNo(TextBox txtHihokenshaNo) {
        this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().setTxtHihokenshaNo(txtHihokenshaNo);
    }

    @JsonIgnore
    public TextBoxDate getTxtShutokuYMD() {
        return this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().getTxtShutokuYMD();
    }

    @JsonIgnore
    public void  setTxtShutokuYMD(TextBoxDate txtShutokuYMD) {
        this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().setTxtShutokuYMD(txtShutokuYMD);
    }

    @JsonIgnore
    public TextBox getTxtShutokuJiyu() {
        return this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().getTxtShutokuJiyu();
    }

    @JsonIgnore
    public void  setTxtShutokuJiyu(TextBox txtShutokuJiyu) {
        this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().setTxtShutokuJiyu(txtShutokuJiyu);
    }

    @JsonIgnore
    public TextBoxDate getTxtSoshitsuYMD() {
        return this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().getTxtSoshitsuYMD();
    }

    @JsonIgnore
    public void  setTxtSoshitsuYMD(TextBoxDate txtSoshitsuYMD) {
        this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().setTxtSoshitsuYMD(txtSoshitsuYMD);
    }

    @JsonIgnore
    public TextBox getTxtSoshitsuJiyu() {
        return this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().getTxtSoshitsuJiyu();
    }

    @JsonIgnore
    public void  setTxtSoshitsuJiyu(TextBox txtSoshitsuJiyu) {
        this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().setTxtSoshitsuJiyu(txtSoshitsuJiyu);
    }

    @JsonIgnore
    public ButtonDialog getBtnHihokenshaFinder() {
        return this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().getBtnHihokenshaFinder();
    }

    @JsonIgnore
    public void  setBtnHihokenshaFinder(ButtonDialog btnHihokenshaFinder) {
        this.getTokuchoDoteiKohoshaShosai().getKaigoShikakuInfo().setBtnHihokenshaFinder(btnHihokenshaFinder);
    }

    @JsonIgnore
    public TorokuZumiNenkinInfoDiv getTorokuZumiNenkinInfo() {
        return this.getTokuchoDoteiKohoshaShosai().getTorokuZumiNenkinInfo();
    }

    @JsonIgnore
    public void  setTorokuZumiNenkinInfo(TorokuZumiNenkinInfoDiv TorokuZumiNenkinInfo) {
        this.getTokuchoDoteiKohoshaShosai().setTorokuZumiNenkinInfo(TorokuZumiNenkinInfo);
    }

    @JsonIgnore
    public TextBox getTxtTorokuZumiKisoNenkinNo() {
        return this.getTokuchoDoteiKohoshaShosai().getTorokuZumiNenkinInfo().getTxtTorokuZumiKisoNenkinNo();
    }

    @JsonIgnore
    public void  setTxtTorokuZumiKisoNenkinNo(TextBox txtTorokuZumiKisoNenkinNo) {
        this.getTokuchoDoteiKohoshaShosai().getTorokuZumiNenkinInfo().setTxtTorokuZumiKisoNenkinNo(txtTorokuZumiKisoNenkinNo);
    }

    @JsonIgnore
    public TextBox getTxtTorokuZumiNenkinCode() {
        return this.getTokuchoDoteiKohoshaShosai().getTorokuZumiNenkinInfo().getTxtTorokuZumiNenkinCode();
    }

    @JsonIgnore
    public void  setTxtTorokuZumiNenkinCode(TextBox txtTorokuZumiNenkinCode) {
        this.getTokuchoDoteiKohoshaShosai().getTorokuZumiNenkinInfo().setTxtTorokuZumiNenkinCode(txtTorokuZumiNenkinCode);
    }

    @JsonIgnore
    public TextBox getTxtTorokuZumiTokuchoGimusha() {
        return this.getTokuchoDoteiKohoshaShosai().getTorokuZumiNenkinInfo().getTxtTorokuZumiTokuchoGimusha();
    }

    @JsonIgnore
    public void  setTxtTorokuZumiTokuchoGimusha(TextBox txtTorokuZumiTokuchoGimusha) {
        this.getTokuchoDoteiKohoshaShosai().getTorokuZumiNenkinInfo().setTxtTorokuZumiTokuchoGimusha(txtTorokuZumiTokuchoGimusha);
    }

    @JsonIgnore
    public IKaigoKanryoMessageDiv getCcdKaigoKanryoMessage() {
        return this.getKanryoKakunin().getCcdKaigoKanryoMessage();
    }

    // </editor-fold>
}
