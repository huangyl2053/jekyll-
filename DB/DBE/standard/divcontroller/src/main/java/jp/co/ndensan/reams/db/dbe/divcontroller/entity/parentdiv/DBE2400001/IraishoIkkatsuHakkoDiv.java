package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.BunshoBangoInputDiv;
import jp.co.ndensan.reams.db.dbz.divcontroller.entity.commonchilddiv.bunshobangoinput.BunshoBangoInput.IBunshoBangoInputDiv;
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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
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
    public TextBoxDateRange getTxtNinteiChosaIraibi() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken().getTxtNinteiChosaIraibi();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaIraibi(TextBoxDateRange txtNinteiChosaIraibi) {
        this.getNinteiChosa().getNinteichosaKensakuJoken().setTxtNinteiChosaIraibi(txtNinteiChosaIraibi);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaIraisho() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken().getChkNinteiChosaIraisho();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIraisho(CheckBoxList chkNinteiChosaIraisho) {
        this.getNinteiChosa().getNinteichosaKensakuJoken().setChkNinteiChosaIraisho(chkNinteiChosaIraisho);
    }

    @JsonIgnore
    public TextBoxNum getTxtChosaDispMax() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken().getTxtChosaDispMax();
    }

    @JsonIgnore
    public void  setTxtChosaDispMax(TextBoxNum txtChosaDispMax) {
        this.getNinteiChosa().getNinteichosaKensakuJoken().setTxtChosaDispMax(txtChosaDispMax);
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
    public Button getBtnChosaClear() {
        return this.getNinteiChosa().getNinteichosaKensakuJoken().getBtnChosaClear();
    }

    @JsonIgnore
    public void  setBtnChosaClear(Button btnChosaClear) {
        this.getNinteiChosa().getNinteichosaKensakuJoken().setBtnChosaClear(btnChosaClear);
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
    public CheckBoxList getChkChosahyoIraisho() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoIraisho();
    }

    @JsonIgnore
    public void  setChkChosahyoIraisho(CheckBoxList chkChosahyoIraisho) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoIraisho(chkChosahyoIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoKatamen() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoKatamen();
    }

    @JsonIgnore
    public void  setChkChosahyoKatamen(CheckBoxList chkChosahyoKatamen) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoKatamen(chkChosahyoKatamen);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoRyomen() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoRyomen();
    }

    @JsonIgnore
    public void  setChkChosahyoRyomen(CheckBoxList chkChosahyoRyomen) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoRyomen(chkChosahyoRyomen);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoGaikyo() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoGaikyo();
    }

    @JsonIgnore
    public void  setChkChosahyoGaikyo(CheckBoxList chkChosahyoGaikyo) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoGaikyo(chkChosahyoGaikyo);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoSai() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoSai();
    }

    @JsonIgnore
    public void  setChkChosahyoSai(CheckBoxList chkChosahyoSai) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoSai(chkChosahyoSai);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoTokki() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoTokki();
    }

    @JsonIgnore
    public void  setChkChosahyoTokki(CheckBoxList chkChosahyoTokki) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoTokki(chkChosahyoTokki);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaIraiHakko() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkChosaIraiHakko();
    }

    @JsonIgnore
    public void  setChkChosaIraiHakko(CheckBoxList chkChosaIraiHakko) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkChosaIraiHakko(chkChosaIraiHakko);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaIraiRireki() {
        return this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().getChkChosaIraiRireki();
    }

    @JsonIgnore
    public void  setChkChosaIraiRireki(CheckBoxList chkChosaIraiRireki) {
        this.getNinteiChosa().getNinteiChosaInsatsuChohyoSentaku().setChkChosaIraiRireki(chkChosaIraiRireki);
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
    public TextBoxDateRange getTxtShujiiIkenshoSakuseiIraibi() {
        return this.getShujiiIkensho().getShujiiIkenshoKensakujoken().getTxtShujiiIkenshoSakuseiIraibi();
    }

    @JsonIgnore
    public void  setTxtShujiiIkenshoSakuseiIraibi(TextBoxDateRange txtShujiiIkenshoSakuseiIraibi) {
        this.getShujiiIkensho().getShujiiIkenshoKensakujoken().setTxtShujiiIkenshoSakuseiIraibi(txtShujiiIkenshoSakuseiIraibi);
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
    public TextBoxNum getTxtIkenshoDispMax() {
        return this.getShujiiIkensho().getShujiiIkenshoKensakujoken().getTxtIkenshoDispMax();
    }

    @JsonIgnore
    public void  setTxtIkenshoDispMax(TextBoxNum txtIkenshoDispMax) {
        this.getShujiiIkensho().getShujiiIkenshoKensakujoken().setTxtIkenshoDispMax(txtIkenshoDispMax);
    }

    @JsonIgnore
    public Button getBtnIkenshoClear() {
        return this.getShujiiIkensho().getShujiiIkenshoKensakujoken().getBtnIkenshoClear();
    }

    @JsonIgnore
    public void  setBtnIkenshoClear(Button btnIkenshoClear) {
        this.getShujiiIkensho().getShujiiIkenshoKensakujoken().setBtnIkenshoClear(btnIkenshoClear);
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
    public CheckBoxList getChkIkenshoIraisho() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkIkenshoIraisho();
    }

    @JsonIgnore
    public void  setChkIkenshoIraisho(CheckBoxList chkIkenshoIraisho) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkIkenshoIraisho(chkIkenshoIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkensho() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkIkensho();
    }

    @JsonIgnore
    public void  setChkIkensho(CheckBoxList chkIkensho) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkIkensho(chkIkensho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSeikyusho() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkIkenshoSeikyusho();
    }

    @JsonIgnore
    public void  setChkIkenshoSeikyusho(CheckBoxList chkIkenshoSeikyusho) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkIkenshoSeikyusho(chkIkenshoSeikyusho);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoSeikyuIchiran() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkIkenshoSeikyuIchiran();
    }

    @JsonIgnore
    public void  setChkIkenshoSeikyuIchiran(CheckBoxList chkIkenshoSeikyuIchiran) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkIkenshoSeikyuIchiran(chkIkenshoSeikyuIchiran);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoHakkoIchiran() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkIkenshoHakkoIchiran();
    }

    @JsonIgnore
    public void  setChkIkenshoHakkoIchiran(CheckBoxList chkIkenshoHakkoIchiran) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkIkenshoHakkoIchiran(chkIkenshoHakkoIchiran);
    }

    @JsonIgnore
    public CheckBoxList getChkIkenshoRirekiIchiran() {
        return this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().getChkIkenshoRirekiIchiran();
    }

    @JsonIgnore
    public void  setChkIkenshoRirekiIchiran(CheckBoxList chkIkenshoRirekiIchiran) {
        this.getShujiiIkensho().getShujiiIkenshoInsatsuChohyo().setChkIkenshoRirekiIchiran(chkIkenshoRirekiIchiran);
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

    @JsonIgnore
    public IBunshoBangoInputDiv getCcdBunshoNo() {
        return this.getHakkobiAndTeishutsuKigen().getCcdBunshoNo();
    }

    // </editor-fold>
}
