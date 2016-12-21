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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
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
    public TextBoxNum getTxtChosaDispMax() {
        return this.getNinteichosaKensakuJoken().getTxtChosaDispMax();
    }

    @JsonIgnore
    public void  setTxtChosaDispMax(TextBoxNum txtChosaDispMax) {
        this.getNinteichosaKensakuJoken().setTxtChosaDispMax(txtChosaDispMax);
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
    public ChosahyoSelectItemsOneDiv getChosahyoSelectItemsOne() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne();
    }

    @JsonIgnore
    public void  setChosahyoSelectItemsOne(ChosahyoSelectItemsOneDiv ChosahyoSelectItemsOne) {
        this.getNinteiChosaInsatsuChohyoSentaku().setChosahyoSelectItemsOne(ChosahyoSelectItemsOne);
    }

    @JsonIgnore
    public CheckBoxList getChkirai() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().getChkirai();
    }

    @JsonIgnore
    public void  setChkirai(CheckBoxList Chkirai) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().setChkirai(Chkirai);
    }

    @JsonIgnore
    public CheckBoxList getChkchosaOcr() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().getChkchosaOcr();
    }

    @JsonIgnore
    public void  setChkchosaOcr(CheckBoxList ChkchosaOcr) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsOne().setChkchosaOcr(ChkchosaOcr);
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
    public CheckBoxList getChkchosa() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().getChkchosa();
    }

    @JsonIgnore
    public void  setChkchosa(CheckBoxList Chkchosa) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().setChkchosa(Chkchosa);
    }

    @JsonIgnore
    public CheckBoxList getChkchosaSonota() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().getChkchosaSonota();
    }

    @JsonIgnore
    public void  setChkchosaSonota(CheckBoxList ChkchosaSonota) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoSelectItemsTwo().setChkchosaSonota(ChkchosaSonota);
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
    public CheckBoxList getChkChosahyoTokkijiko() {
        return this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().getChkChosahyoTokkijiko();
    }

    @JsonIgnore
    public void  setChkChosahyoTokkijiko(CheckBoxList chkChosahyoTokkijiko) {
        this.getNinteiChosaInsatsuChohyoSentaku().getChosahyoTokkijikoSelect().setChkChosahyoTokkijiko(chkChosahyoTokkijiko);
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
