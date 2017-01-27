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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2017-01-10_09-26-16">
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
    public CheckBoxList getChkNinteioChosaIraisho() {
        return this.getNinteichosaKensakuJoken().getChkNinteioChosaIraisho();
    }

    @JsonIgnore
    public void  setChkNinteioChosaIraisho(CheckBoxList chkNinteioChosaIraisho) {
        this.getNinteichosaKensakuJoken().setChkNinteioChosaIraisho(chkNinteioChosaIraisho);
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
    public CheckBoxList getChkNinteiChosaIraiIchiran() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosaIraiIchiran();
    }

    @JsonIgnore
    public void  setChkNinteiChosaIraiIchiran(CheckBoxList chkNinteiChosaIraiIchiran) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosaIraiIchiran(chkNinteiChosaIraiIchiran);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosaShinseiTani() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkNinteiChosaShinseiTani();
    }

    @JsonIgnore
    public void  setChkNinteiChosaShinseiTani(CheckBoxList chkNinteiChosaShinseiTani) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkNinteiChosaShinseiTani(chkNinteiChosaShinseiTani);
    }

    @JsonIgnore
    public ChosahyoSelectItemsOneDiv getChosahyoSelectItemsOne() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne();
    }

    @JsonIgnore
    public void  setChosahyoSelectItemsOne(ChosahyoSelectItemsOneDiv ChosahyoSelectItemsOne) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChosahyoSelectItemsOne(ChosahyoSelectItemsOne);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaIrai() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().getChkChosaIrai();
    }

    @JsonIgnore
    public void  setChkChosaIrai(CheckBoxList chkChosaIrai) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().setChkChosaIrai(chkChosaIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaOcr() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().getChkChosaOcr();
    }

    @JsonIgnore
    public void  setChkChosaOcr(CheckBoxList chkChosaOcr) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().setChkChosaOcr(chkChosaOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiOcr() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().getChkTokkiOcr();
    }

    @JsonIgnore
    public void  setChkTokkiOcr(CheckBoxList chkTokkiOcr) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().setChkTokkiOcr(chkTokkiOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyoSonota() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().getChkNinteiChosahyoSonota();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyoSonota(CheckBoxList chkNinteiChosahyoSonota) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().setChkNinteiChosahyoSonota(chkNinteiChosahyoSonota);
    }

    @JsonIgnore
    public ChosahyoSelectItemsTwoDiv getChosahyoSelectItemsTwo() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo();
    }

    @JsonIgnore
    public void  setChosahyoSelectItemsTwo(ChosahyoSelectItemsTwoDiv ChosahyoSelectItemsTwo) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChosahyoSelectItemsTwo(ChosahyoSelectItemsTwo);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaDesign() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().getChkChosaDesign();
    }

    @JsonIgnore
    public void  setChkChosaDesign(CheckBoxList chkChosaDesign) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().setChkChosaDesign(chkChosaDesign);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiDesign() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().getChkTokkiDesign();
    }

    @JsonIgnore
    public void  setChkTokkiDesign(CheckBoxList chkTokkiDesign) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().setChkTokkiDesign(chkTokkiDesign);
    }

    @JsonIgnore
    public CheckBoxList getChkSaiCheck() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().getChkSaiCheck();
    }

    @JsonIgnore
    public void  setChkSaiCheck(CheckBoxList chkSaiCheck) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().setChkSaiCheck(chkSaiCheck);
    }

    @JsonIgnore
    public CheckBoxList getChkGaikyoTokki() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().getChkGaikyoTokki();
    }

    @JsonIgnore
    public void  setChkGaikyoTokki(CheckBoxList chkGaikyoTokki) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().setChkGaikyoTokki(chkGaikyoTokki);
    }

    @JsonIgnore
    public ChosahyoTokkijikoSelectDiv getChosahyoTokkijikoSelect() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect();
    }

    @JsonIgnore
    public void  setChosahyoTokkijikoSelect(ChosahyoTokkijikoSelectDiv ChosahyoTokkijikoSelect) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChosahyoTokkijikoSelect(ChosahyoTokkijikoSelect);
    }

    @JsonIgnore
    public TokkiChecksDiv getTokkiChecks() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().getTokkiChecks();
    }

    @JsonIgnore
    public void  setTokkiChecks(TokkiChecksDiv TokkiChecks) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().setTokkiChecks(TokkiChecks);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiKomokuAri() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().getTokkiChecks().getChkTokkiKomokuAri();
    }

    @JsonIgnore
    public void  setChkTokkiKomokuAri(CheckBoxList chkTokkiKomokuAri) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().getTokkiChecks().setChkTokkiKomokuAri(chkTokkiKomokuAri);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiKomokuNashi() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().getTokkiChecks().getChkTokkiKomokuNashi();
    }

    @JsonIgnore
    public void  setChkTokkiKomokuNashi(CheckBoxList chkTokkiKomokuNashi) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().getTokkiChecks().setChkTokkiKomokuNashi(chkTokkiKomokuNashi);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiFree() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().getTokkiChecks().getChkTokkiFree();
    }

    @JsonIgnore
    public void  setChkTokkiFree(CheckBoxList chkTokkiFree) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().getTokkiChecks().setChkTokkiFree(chkTokkiFree);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkijikoTenyuryoku() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().getChkTokkijikoTenyuryoku();
    }

    @JsonIgnore
    public void  setChkTokkijikoTenyuryoku(CheckBoxList chkTokkijikoTenyuryoku) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().setChkTokkijikoTenyuryoku(chkTokkijikoTenyuryoku);
    }

    @JsonIgnore
    public CheckBoxList getChkchosairaihakko() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkchosairaihakko();
    }

    @JsonIgnore
    public void  setChkchosairaihakko(CheckBoxList Chkchosairaihakko) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkchosairaihakko(Chkchosairaihakko);
    }

    @JsonIgnore
    public CheckBoxList getChkchosairaiRireki() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChkchosairaiRireki();
    }

    @JsonIgnore
    public void  setChkchosairaiRireki(CheckBoxList ChkchosairaiRireki) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChkchosairaiRireki(ChkchosairaiRireki);
    }

    // </editor-fold>
}
