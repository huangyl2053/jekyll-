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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2015-11-30_08-54-50">
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
    public TextBoxDate getTxtIraibiFrom() {
        return this.getNinteichosaKensakuJoken().getTxtIraibiFrom();
    }

    @JsonIgnore
    public void  setTxtIraibiFrom(TextBoxDate txtIraibiFrom) {
        this.getNinteichosaKensakuJoken().setTxtIraibiFrom(txtIraibiFrom);
    }

    @JsonIgnore
    public TextBoxDate getTxtIraibiTo() {
        return this.getNinteichosaKensakuJoken().getTxtIraibiTo();
    }

    @JsonIgnore
    public void  setTxtIraibiTo(TextBoxDate txtIraibiTo) {
        this.getNinteichosaKensakuJoken().setTxtIraibiTo(txtIraibiTo);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteioChosaIraisho() {
        return this.getNinteichosaKensakuJoken().getChkNinteioChosaIraisho();
    }

    @JsonIgnore
    public void  setChkNinteioChosaIraisho(CheckBoxList chkNinteioChosaIraisho) {
        this.getNinteichosaKensakuJoken().setChkNinteioChosaIraisho(chkNinteioChosaIraisho);
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
    public Button getBtnNinteichosaKensaku() {
        return this.getNinteichosaKensakuJoken().getBtnNinteichosaKensaku();
    }

    @JsonIgnore
    public void  setBtnNinteichosaKensaku(Button btnNinteichosaKensaku) {
        this.getNinteichosaKensakuJoken().setBtnNinteichosaKensaku(btnNinteichosaKensaku);
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
    public CheckBoxList getChkNinteiChosaIraiChohyo() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosaIraiChohyo();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIraiChohyo(CheckBoxList chkNinteiChosaIraiChohyo) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosaIraiChohyo(chkNinteiChosaIraiChohyo);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaIraisho() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosaIraisho();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIraisho(CheckBoxList chkNinteiChosaIraisho) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosaIraisho(chkNinteiChosaIraisho);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyoShurui() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosahyoShurui();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyoShurui(CheckBoxList chkNinteiChosahyoShurui) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosahyoShurui(chkNinteiChosahyoShurui);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyoOcrShurui() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosahyoOcrShurui();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyoOcrShurui(CheckBoxList chkNinteiChosahyoOcrShurui) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosahyoOcrShurui(chkNinteiChosahyoOcrShurui);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyoSonota() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosahyoSonota();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyoSonota(CheckBoxList chkNinteiChosahyoSonota) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosahyoSonota(chkNinteiChosahyoSonota);
    }

    @JsonIgnore
    public CheckBoxList getChkchosairaihakko() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkchosairaihakko();
    }

    @JsonIgnore
    public void  setChkchosairaihakko(CheckBoxList Chkchosairaihakko) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkchosairaihakko(Chkchosairaihakko);
    }

    // </editor-fold>
}
