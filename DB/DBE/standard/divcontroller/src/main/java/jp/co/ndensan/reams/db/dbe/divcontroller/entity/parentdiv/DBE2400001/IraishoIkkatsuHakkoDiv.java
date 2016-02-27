package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.HokenshaListDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.hokenshalist.HokenshaList.IHokenshaListDiv;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * IraishoIkkatsuHakko のクラスファイル 
 * 
 * @author 自動生成
 */
public class IraishoIkkatsuHakkoDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("HakkoTaisho")
    private HakkoTaishoDiv HakkoTaisho;
    @JsonProperty("NinteiChosa")
    private NinteiChosaDiv NinteiChosa;
    @JsonProperty("ShujiiIkensho")
    private ShujiiIkenshoDiv ShujiiIkensho;
    @JsonProperty("HakkobiAndTeishutsuKigen")
    private HakkobiAndTeishutsuKigenDiv HakkobiAndTeishutsuKigen;
    @JsonProperty("state")
    private RString state;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getHakkoTaisho
     * @return HakkoTaisho
     */
    @JsonProperty("HakkoTaisho")
    public HakkoTaishoDiv getHakkoTaisho() {
        return HakkoTaisho;
    }

    /*
     * setHakkoTaisho
     * @param HakkoTaisho HakkoTaisho
     */
    @JsonProperty("HakkoTaisho")
    public void setHakkoTaisho(HakkoTaishoDiv HakkoTaisho) {
        this.HakkoTaisho = HakkoTaisho;
    }

    /*
     * getNinteiChosa
     * @return NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public NinteiChosaDiv getNinteiChosa() {
        return NinteiChosa;
    }

    /*
     * setNinteiChosa
     * @param NinteiChosa NinteiChosa
     */
    @JsonProperty("NinteiChosa")
    public void setNinteiChosa(NinteiChosaDiv NinteiChosa) {
        this.NinteiChosa = NinteiChosa;
    }

    /*
     * getShujiiIkensho
     * @return ShujiiIkensho
     */
    @JsonProperty("ShujiiIkensho")
    public ShujiiIkenshoDiv getShujiiIkensho() {
        return ShujiiIkensho;
    }

    /*
     * setShujiiIkensho
     * @param ShujiiIkensho ShujiiIkensho
     */
    @JsonProperty("ShujiiIkensho")
    public void setShujiiIkensho(ShujiiIkenshoDiv ShujiiIkensho) {
        this.ShujiiIkensho = ShujiiIkensho;
    }

    /*
     * getHakkobiAndTeishutsuKigen
     * @return HakkobiAndTeishutsuKigen
     */
    @JsonProperty("HakkobiAndTeishutsuKigen")
    public HakkobiAndTeishutsuKigenDiv getHakkobiAndTeishutsuKigen() {
        return HakkobiAndTeishutsuKigen;
    }

    /*
     * setHakkobiAndTeishutsuKigen
     * @param HakkobiAndTeishutsuKigen HakkobiAndTeishutsuKigen
     */
    @JsonProperty("HakkobiAndTeishutsuKigen")
    public void setHakkobiAndTeishutsuKigen(HakkobiAndTeishutsuKigenDiv HakkobiAndTeishutsuKigen) {
        this.HakkobiAndTeishutsuKigen = HakkobiAndTeishutsuKigen;
    }

    /*
     * getstate
     * @return state
     */
    @JsonProperty("state")
    public RString getState() {
        return state;
    }

    /*
     * setstate
     * @param state state
     */
    @JsonProperty("state")
    public void setState(RString state) {
        this.state = state;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public RadioButton getRadTaishoSentaku() {
        return this.getHakkoTaisho().getRadTaishoSentaku();
    }

    @JsonIgnore
    public void  setRadTaishoSentaku(RadioButton radTaishoSentaku) {
        this.getHakkoTaisho().setRadTaishoSentaku(radTaishoSentaku);
    }

    @JsonIgnore
    public NinteichosaKensakuJokenDiv getNinteichosaKensakuJoken() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken();
    }

    @JsonIgnore
    public void  setNinteichosaKensakuJoken(NinteichosaKensakuJokenDiv NinteichosaKensakuJoken) {
        this.getNinteiChosa().setNinteichosaKensakuJoken(NinteichosaKensakuJoken);
    }

    @JsonIgnore
    public TextBoxDate getTxtIraibiFrom() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken().getTxtIraibiFrom();
    }

    @JsonIgnore
    public void  setTxtIraibiFrom(TextBoxDate txtIraibiFrom) {
        this.getNinteiChosa().getNinteichosaKensakuJoken().setTxtIraibiFrom(txtIraibiFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtIraibiTo() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken().getTxtIraibiTo();
    }

    @JsonIgnore
    public void  setTxtIraibiTo(TextBoxDate txtIraibiTo) {
        this.getNinteiChosa().getNinteichosaKensakuJoken().setTxtIraibiTo(txtIraibiTo);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteioChosaIraisho() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken().getChkNinteioChosaIraisho();
    }

    @JsonIgnore
    public void  setChkNinteioChosaIraisho(CheckBoxList chkNinteioChosaIraisho) {
        this.getNinteiChosa().getNinteichosaKensakuJoken().setChkNinteioChosaIraisho(chkNinteioChosaIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyo() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken().getChkNinteiChosahyo();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyo(CheckBoxList chkNinteiChosahyo) {
        this.getNinteiChosa().getNinteichosaKensakuJoken().setChkNinteiChosahyo(chkNinteiChosahyo);
    }

    @JsonIgnore
    public Button getBtnNinteichosaKensaku() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken().getBtnNinteichosaKensaku();
    }

    @JsonIgnore
    public void  setBtnNinteichosaKensaku(Button btnNinteichosaKensaku) {
        this.getNinteiChosa().getNinteichosaKensakuJoken().setBtnNinteichosaKensaku(btnNinteichosaKensaku);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdNinteiChosaHokensha() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken().getCcdNinteiChosaHokensha();
    }

    @JsonIgnore
    public NinteiChosaIraiTaishoIchiranDiv getNinteiChosaIraiTaishoIchiran() {
        return this.getNinteiChosa().getNinteiChosaIraiTaishoIchiran();
    }

    @JsonIgnore
    public void  setNinteiChosaIraiTaishoIchiran(NinteiChosaIraiTaishoIchiranDiv NinteiChosaIraiTaishoIchiran) {
        this.getNinteiChosa().setNinteiChosaIraiTaishoIchiran(NinteiChosaIraiTaishoIchiran);
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosaIraiTaishoIchiran_Row> getDgNinteiChosaIraiTaishoIchiran() {
        return this.getNinteiChosa().getNinteiChosaIraiTaishoIchiran().getDgNinteiChosaIraiTaishoIchiran();
    }

    @JsonIgnore
    public void  setDgNinteiChosaIraiTaishoIchiran(DataGrid<dgNinteiChosaIraiTaishoIchiran_Row> dgNinteiChosaIraiTaishoIchiran) {
        this.getNinteiChosa().getNinteiChosaIraiTaishoIchiran().setDgNinteiChosaIraiTaishoIchiran(dgNinteiChosaIraiTaishoIchiran);
    }

    @JsonIgnore
    public NinteiChosaInsatsuChohyoSentakuDiv getNinteiChosaInsatsuChohyoSentaku() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku();
    }

    @JsonIgnore
    public void  setNinteiChosaInsatsuChohyoSentaku(NinteiChosaInsatsuChohyoSentakuDiv NinteiChosaInsatsuChohyoSentaku) {
        this.getNinteiChosa().setNinteiChosaInsatsuChohyoSentaku(NinteiChosaInsatsuChohyoSentaku);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaIraiChohyo() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosaIraiChohyo();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIraiChohyo(CheckBoxList chkNinteiChosaIraiChohyo) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosaIraiChohyo(chkNinteiChosaIraiChohyo);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaIraisho() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosaIraisho();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIraisho(CheckBoxList chkNinteiChosaIraisho) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosaIraisho(chkNinteiChosaIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyoShurui() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosahyoShurui();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyoShurui(CheckBoxList chkNinteiChosahyoShurui) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosahyoShurui(chkNinteiChosahyoShurui);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyoOcrShurui() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosahyoOcrShurui();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyoOcrShurui(CheckBoxList chkNinteiChosahyoOcrShurui) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosahyoOcrShurui(chkNinteiChosahyoOcrShurui);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyoSonota() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosahyoSonota();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyoSonota(CheckBoxList chkNinteiChosahyoSonota) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosahyoSonota(chkNinteiChosahyoSonota);
    }

    @JsonIgnore
    public CheckBoxList getChkchosairaihakko() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkchosairaihakko();
    }

    @JsonIgnore
    public void  setChkchosairaihakko(CheckBoxList Chkchosairaihakko) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkchosairaihakko(Chkchosairaihakko);
    }

    @JsonIgnore
    public ShujiiIkenshoKensakujokenDiv getShujiiIkenshoKensakujoken() {
        return this.getShujiiIkensho().getShujiiIkenshoKensakujoken();
    }

    @JsonIgnore
    public void  setShujiiIkenshoKensakujoken(ShujiiIkenshoKensakujokenDiv ShujiiIkenshoKensakujoken) {
        this.getShujiiIkensho().setShujiiIkenshoKensakujoken(ShujiiIkenshoKensakujoken);
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkenshoSakuseiIraibiFrom() {
        return this.getShujiiIkensho().getShujiiIkenshoKensakujoken().getTxtShujiiIkenshoSakuseiIraibiFrom();
    }

    @JsonIgnore
    public void  setTxtShujiiIkenshoSakuseiIraibiFrom(TextBoxDate txtShujiiIkenshoSakuseiIraibiFrom) {
        this.getShujiiIkensho().getShujiiIkenshoKensakujoken().setTxtShujiiIkenshoSakuseiIraibiFrom(txtShujiiIkenshoSakuseiIraibiFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtShujiiIkenshoSakuseiIraibiTo() {
        return this.getShujiiIkensho().getShujiiIkenshoKensakujoken().getTxtShujiiIkenshoSakuseiIraibiTo();
    }

    @JsonIgnore
    public void  setTxtShujiiIkenshoSakuseiIraibiTo(TextBoxDate txtShujiiIkenshoSakuseiIraibiTo) {
        this.getShujiiIkensho().getShujiiIkenshoKensakujoken().setTxtShujiiIkenshoSakuseiIraibiTo(txtShujiiIkenshoSakuseiIraibiTo);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiikenshoSakuseiIrai() {
        return this.getShujiiIkensho().getShujiiIkenshoKensakujoken().getChkShujiiikenshoSakuseiIrai();
    }

    @JsonIgnore
    public void  setChkShujiiikenshoSakuseiIrai(CheckBoxList chkShujiiikenshoSakuseiIrai) {
        this.getShujiiIkensho().getShujiiIkenshoKensakujoken().setChkShujiiikenshoSakuseiIrai(chkShujiiikenshoSakuseiIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkensho() {
        return this.getShujiiIkensho().getShujiiIkenshoKensakujoken().getChkShujiiIkensho();
    }

    @JsonIgnore
    public void  setChkShujiiIkensho(CheckBoxList chkShujiiIkensho) {
        this.getShujiiIkensho().getShujiiIkenshoKensakujoken().setChkShujiiIkensho(chkShujiiIkensho);
    }

    @JsonIgnore
    public Button getBtnShujiiIkenshoKensaku() {
        return this.getShujiiIkensho().getShujiiIkenshoKensakujoken().getBtnShujiiIkenshoKensaku();
    }

    @JsonIgnore
    public void  setBtnShujiiIkenshoKensaku(Button btnShujiiIkenshoKensaku) {
        this.getShujiiIkensho().getShujiiIkenshoKensakujoken().setBtnShujiiIkenshoKensaku(btnShujiiIkenshoKensaku);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdShujiiIkenshoHokensha() {
        return this.getShujiiIkensho().getShujiiIkenshoKensakujoken().getCcdShujiiIkenshoHokensha();
    }

    @JsonIgnore
    public ShujiiIkenshoSakuseiIraiTaishoIchiranDiv getShujiiIkenshoSakuseiIraiTaishoIchiran() {
        return this.getShujiiIkensho().getShujiiIkenshoSakuseiIraiTaishoIchiran();
    }

    @JsonIgnore
    public void  setShujiiIkenshoSakuseiIraiTaishoIchiran(ShujiiIkenshoSakuseiIraiTaishoIchiranDiv ShujiiIkenshoSakuseiIraiTaishoIchiran) {
        this.getShujiiIkensho().setShujiiIkenshoSakuseiIraiTaishoIchiran(ShujiiIkenshoSakuseiIraiTaishoIchiran);
    }

    @JsonIgnore
    public DataGrid<dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row> getDgShujiiIkenshoSakuseiIraiTaishoIchiran() {
        return this.getShujiiIkensho().getShujiiIkenshoSakuseiIraiTaishoIchiran().getDgShujiiIkenshoSakuseiIraiTaishoIchiran();
    }

    @JsonIgnore
    public void  setDgShujiiIkenshoSakuseiIraiTaishoIchiran(DataGrid<dgShujiiIkenshoSakuseiIraiTaishoIchiran_Row> dgShujiiIkenshoSakuseiIraiTaishoIchiran) {
        this.getShujiiIkensho().getShujiiIkenshoSakuseiIraiTaishoIchiran().setDgShujiiIkenshoSakuseiIraiTaishoIchiran(dgShujiiIkenshoSakuseiIraiTaishoIchiran);
    }

    @JsonIgnore
    public ShujiiIkenshoInsatsuChohyoDiv getShujiiIkenshoInsatsuChohyo() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo();
    }

    @JsonIgnore
    public void  setShujiiIkenshoInsatsuChohyo(ShujiiIkenshoInsatsuChohyoDiv ShujiiIkenshoInsatsuChohyo) {
        this.getShujiiIkensho().setShujiiIkenshoInsatsuChohyo(ShujiiIkenshoInsatsuChohyo);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoShutsuryoku() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkShujiiIkenshoShutsuryoku();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoShutsuryoku(CheckBoxList chkShujiiIkenshoShutsuryoku) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkShujiiIkenshoShutsuryoku(chkShujiiIkenshoShutsuryoku);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiiIkenshoSakuseiIraisho() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkShujiiIkenshoSakuseiIraisho();
    }

    @JsonIgnore
    public void  setChkShujiiIkenshoSakuseiIraisho(CheckBoxList chkShujiiIkenshoSakuseiIraisho) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkShujiiIkenshoSakuseiIraisho(chkShujiiIkenshoSakuseiIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkShujiIkenshoKinyuAndSakuseiryoSeikyu() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkShujiIkenshoKinyuAndSakuseiryoSeikyu();
    }

    @JsonIgnore
    public void  setChkShujiIkenshoKinyuAndSakuseiryoSeikyu(CheckBoxList chkShujiIkenshoKinyuAndSakuseiryoSeikyu) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkShujiIkenshoKinyuAndSakuseiryoSeikyu(chkShujiIkenshoKinyuAndSakuseiryoSeikyu);
    }

    @JsonIgnore
    public CheckBoxList getChkShindanMeireishoAndTeishutsuIraisho() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkShindanMeireishoAndTeishutsuIraisho();
    }

    @JsonIgnore
    public void  setChkShindanMeireishoAndTeishutsuIraisho(CheckBoxList chkShindanMeireishoAndTeishutsuIraisho) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkShindanMeireishoAndTeishutsuIraisho(chkShindanMeireishoAndTeishutsuIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkikenshiiraihakko() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkikenshiiraihakko();
    }

    @JsonIgnore
    public void  setChkikenshiiraihakko(CheckBoxList Chkikenshiiraihakko) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkikenshiiraihakko(Chkikenshiiraihakko);
    }

    @JsonIgnore
    public TextBoxDate getTxtHakkobi() {
        return this.getHakkobiAndTeishutsuKigen().getTxtHakkobi();
    }

    @JsonIgnore
    public void  setTxtHakkobi(TextBoxDate txtHakkobi) {
        this.getHakkobiAndTeishutsuKigen().setTxtHakkobi(txtHakkobi);
    }

    @JsonIgnore
    public RadioButton getRadTeishutsuKigen() {
        return this.getHakkobiAndTeishutsuKigen().getRadTeishutsuKigen();
    }

    @JsonIgnore
    public void  setRadTeishutsuKigen(RadioButton radTeishutsuKigen) {
        this.getHakkobiAndTeishutsuKigen().setRadTeishutsuKigen(radTeishutsuKigen);
    }

    @JsonIgnore
    public TextBoxDate getTxtKyotsuHizuke() {
        return this.getHakkobiAndTeishutsuKigen().getTxtKyotsuHizuke();
    }

    @JsonIgnore
    public void  setTxtKyotsuHizuke(TextBoxDate txtKyotsuHizuke) {
        this.getHakkobiAndTeishutsuKigen().setTxtKyotsuHizuke(txtKyotsuHizuke);
    }

    // </editor-fold>
}
