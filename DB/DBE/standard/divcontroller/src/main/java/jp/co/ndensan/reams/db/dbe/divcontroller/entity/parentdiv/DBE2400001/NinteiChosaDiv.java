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
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosa のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-02-13_05-12-42">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("NinteichosaKensakuJoken")
    private NinteichosaKensakuJokenDiv NinteichosaKensakuJoken;
    @JsonProperty("NinteiChosaIraiTaishoIchiran")
    private NinteiChosaIraiTaishoIchiranDiv NinteiChosaIraiTaishoIchiran;
    @JsonProperty("NinteiChosaInsatsuChohyoSentaku")
    private NinteiChosaInsatsuChohyoSentakuDiv NinteiChosaInsatsuChohyoSentaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getNinteichosaKensakuJoken
     * @return NinteichosaKensakuJoken
     */
    @JsonProperty("NinteichosaKensakuJoken")
    public NinteichosaKensakuJokenDiv getNinteichosaKensakuJoken() {
        return NinteichosaKensakuJoken;
    }

    /*
     * setNinteichosaKensakuJoken
     * @param NinteichosaKensakuJoken NinteichosaKensakuJoken
     */
    @JsonProperty("NinteichosaKensakuJoken")
    public void setNinteichosaKensakuJoken(NinteichosaKensakuJokenDiv NinteichosaKensakuJoken) {
        this.NinteichosaKensakuJoken = NinteichosaKensakuJoken;
    }

    /*
     * getNinteiChosaIraiTaishoIchiran
     * @return NinteiChosaIraiTaishoIchiran
     */
    @JsonProperty("NinteiChosaIraiTaishoIchiran")
    public NinteiChosaIraiTaishoIchiranDiv getNinteiChosaIraiTaishoIchiran() {
        return NinteiChosaIraiTaishoIchiran;
    }

    /*
     * setNinteiChosaIraiTaishoIchiran
     * @param NinteiChosaIraiTaishoIchiran NinteiChosaIraiTaishoIchiran
     */
    @JsonProperty("NinteiChosaIraiTaishoIchiran")
    public void setNinteiChosaIraiTaishoIchiran(NinteiChosaIraiTaishoIchiranDiv NinteiChosaIraiTaishoIchiran) {
        this.NinteiChosaIraiTaishoIchiran = NinteiChosaIraiTaishoIchiran;
    }

    /*
     * getNinteiChosaInsatsuChohyoSentaku
     * @return NinteiChosaInsatsuChohyoSentaku
     */
    @JsonProperty("NinteiChosaInsatsuChohyoSentaku")
    public NinteiChosaInsatsuChohyoSentakuDiv getNinteiChosaInsatsuChohyoSentaku() {
        return NinteiChosaInsatsuChohyoSentaku;
    }

    /*
     * setNinteiChosaInsatsuChohyoSentaku
     * @param NinteiChosaInsatsuChohyoSentaku NinteiChosaInsatsuChohyoSentaku
     */
    @JsonProperty("NinteiChosaInsatsuChohyoSentaku")
    public void setNinteiChosaInsatsuChohyoSentaku(NinteiChosaInsatsuChohyoSentakuDiv NinteiChosaInsatsuChohyoSentaku) {
        this.NinteiChosaInsatsuChohyoSentaku = NinteiChosaInsatsuChohyoSentaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public TextBoxDateRange getTxtNinteiChosaIraibi() {
        return this.getNinteichosaKensakuJoken().getTxtNinteiChosaIraibi();
    }

    @JsonIgnore
    public void  setTxtNinteiChosaIraibi(TextBoxDateRange txtNinteiChosaIraibi) {
        this.getNinteichosaKensakuJoken().setTxtNinteiChosaIraibi(txtNinteiChosaIraibi);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaIraisho() {
        return this.getNinteichosaKensakuJoken().getChkNinteiChosaIraisho();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIraisho(CheckBoxList chkNinteiChosaIraisho) {
        this.getNinteichosaKensakuJoken().setChkNinteiChosaIraisho(chkNinteiChosaIraisho);
    }

    @JsonIgnore
    public TextBoxNum getTxtChosaDispMax() {
        return this.getNinteichosaKensakuJoken().getTxtChosaDispMax();
    }

    @JsonIgnore
    public void  setTxtChosaDispMax(TextBoxNum txtChosaDispMax) {
        this.getNinteichosaKensakuJoken().setTxtChosaDispMax(txtChosaDispMax);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyo() {
        return this.getNinteichosaKensakuJoken().getChkNinteiChosahyo();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyo(CheckBoxList chkNinteiChosahyo) {
        this.getNinteichosaKensakuJoken().setChkNinteiChosahyo(chkNinteiChosahyo);
    }

    @JsonIgnore
    public Button getBtnChosaClear() {
        return this.getNinteichosaKensakuJoken().getBtnChosaClear();
    }

    @JsonIgnore
    public void  setBtnChosaClear(Button btnChosaClear) {
        this.getNinteichosaKensakuJoken().setBtnChosaClear(btnChosaClear);
    }

    @JsonIgnore
    public IHokenshaListDiv getCcdNinteiChosaHokensha() {
        return this.getNinteichosaKensakuJoken().getCcdNinteiChosaHokensha();
    }

    @JsonIgnore
    public DataGrid<dgNinteiChosaIraiTaishoIchiran_Row> getDgNinteiChosaIraiTaishoIchiran() {
        return this.getNinteiChosaIraiTaishoIchiran().getDgNinteiChosaIraiTaishoIchiran();
    }

    @JsonIgnore
    public void  setDgNinteiChosaIraiTaishoIchiran(DataGrid<dgNinteiChosaIraiTaishoIchiran_Row> dgNinteiChosaIraiTaishoIchiran) {
        this.getNinteiChosaIraiTaishoIchiran().setDgNinteiChosaIraiTaishoIchiran(dgNinteiChosaIraiTaishoIchiran);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoIraisho() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoIraisho();
    }

    @JsonIgnore
    public void  setChkChosahyoIraisho(CheckBoxList chkChosahyoIraisho) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoIraisho(chkChosahyoIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoKatamen() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoKatamen();
    }

    @JsonIgnore
    public void  setChkChosahyoKatamen(CheckBoxList chkChosahyoKatamen) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoKatamen(chkChosahyoKatamen);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoRyomen() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoRyomen();
    }

    @JsonIgnore
    public void  setChkChosahyoRyomen(CheckBoxList chkChosahyoRyomen) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoRyomen(chkChosahyoRyomen);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoGaikyo() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoGaikyo();
    }

    @JsonIgnore
    public void  setChkChosahyoGaikyo(CheckBoxList chkChosahyoGaikyo) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoGaikyo(chkChosahyoGaikyo);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoSai() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoSai();
    }

    @JsonIgnore
    public void  setChkChosahyoSai(CheckBoxList chkChosahyoSai) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoSai(chkChosahyoSai);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoTokki() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkChosahyoTokki();
    }

    @JsonIgnore
    public void  setChkChosahyoTokki(CheckBoxList chkChosahyoTokki) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkChosahyoTokki(chkChosahyoTokki);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaIraiHakko() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkChosaIraiHakko();
    }

    @JsonIgnore
    public void  setChkChosaIraiHakko(CheckBoxList chkChosaIraiHakko) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkChosaIraiHakko(chkChosaIraiHakko);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaIraiRireki() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkChosaIraiRireki();
    }

    @JsonIgnore
    public void  setChkChosaIraiRireki(CheckBoxList chkChosaIraiRireki) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkChosaIraiRireki(chkChosaIraiRireki);
    }

    // </editor-fold>
}
