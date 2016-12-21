package jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE2400001;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;

/**
 * NinteiChosaInsatsuChohyoSentaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class NinteiChosaInsatsuChohyoSentakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-15_08-21-11">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("chkNinteiChosaIraiChohyo")
    private CheckBoxList chkNinteiChosaIraiChohyo;
    @JsonProperty("ChosahyoSelectItemsOne")
    private ChosahyoSelectItemsOneDiv ChosahyoSelectItemsOne;
    @JsonProperty("ChosahyoSelectItemsTwo")
    private ChosahyoSelectItemsTwoDiv ChosahyoSelectItemsTwo;
    @JsonProperty("ChosahyoTokkijikoSelect")
    private ChosahyoTokkijikoSelectDiv ChosahyoTokkijikoSelect;
    @JsonProperty("Chkchosairaihakko")
    private CheckBoxList Chkchosairaihakko;
    @JsonProperty("ChkchosairaiRireki")
    private CheckBoxList ChkchosairaiRireki;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * getchkNinteiChosaIraiChohyo
     * @return chkNinteiChosaIraiChohyo
     */
    @JsonProperty("chkNinteiChosaIraiChohyo")
    public CheckBoxList getChkNinteiChosaIraiChohyo() {
        return chkNinteiChosaIraiChohyo;
    }

    /*
     * setchkNinteiChosaIraiChohyo
     * @param chkNinteiChosaIraiChohyo chkNinteiChosaIraiChohyo
     */
    @JsonProperty("chkNinteiChosaIraiChohyo")
    public void setChkNinteiChosaIraiChohyo(CheckBoxList chkNinteiChosaIraiChohyo) {
        this.chkNinteiChosaIraiChohyo = chkNinteiChosaIraiChohyo;
    }

    /*
     * getChosahyoSelectItemsOne
     * @return ChosahyoSelectItemsOne
     */
    @JsonProperty("ChosahyoSelectItemsOne")
    public ChosahyoSelectItemsOneDiv getChosahyoSelectItemsOne() {
        return ChosahyoSelectItemsOne;
    }

    /*
     * setChosahyoSelectItemsOne
     * @param ChosahyoSelectItemsOne ChosahyoSelectItemsOne
     */
    @JsonProperty("ChosahyoSelectItemsOne")
    public void setChosahyoSelectItemsOne(ChosahyoSelectItemsOneDiv ChosahyoSelectItemsOne) {
        this.ChosahyoSelectItemsOne = ChosahyoSelectItemsOne;
    }

    /*
     * getChosahyoSelectItemsTwo
     * @return ChosahyoSelectItemsTwo
     */
    @JsonProperty("ChosahyoSelectItemsTwo")
    public ChosahyoSelectItemsTwoDiv getChosahyoSelectItemsTwo() {
        return ChosahyoSelectItemsTwo;
    }

    /*
     * setChosahyoSelectItemsTwo
     * @param ChosahyoSelectItemsTwo ChosahyoSelectItemsTwo
     */
    @JsonProperty("ChosahyoSelectItemsTwo")
    public void setChosahyoSelectItemsTwo(ChosahyoSelectItemsTwoDiv ChosahyoSelectItemsTwo) {
        this.ChosahyoSelectItemsTwo = ChosahyoSelectItemsTwo;
    }

    /*
     * getChosahyoTokkijikoSelect
     * @return ChosahyoTokkijikoSelect
     */
    @JsonProperty("ChosahyoTokkijikoSelect")
    public ChosahyoTokkijikoSelectDiv getChosahyoTokkijikoSelect() {
        return ChosahyoTokkijikoSelect;
    }

    /*
     * setChosahyoTokkijikoSelect
     * @param ChosahyoTokkijikoSelect ChosahyoTokkijikoSelect
     */
    @JsonProperty("ChosahyoTokkijikoSelect")
    public void setChosahyoTokkijikoSelect(ChosahyoTokkijikoSelectDiv ChosahyoTokkijikoSelect) {
        this.ChosahyoTokkijikoSelect = ChosahyoTokkijikoSelect;
    }

    /*
     * getChkchosairaihakko
     * @return Chkchosairaihakko
     */
    @JsonProperty("Chkchosairaihakko")
    public CheckBoxList getChkchosairaihakko() {
        return Chkchosairaihakko;
    }

    /*
     * setChkchosairaihakko
     * @param Chkchosairaihakko Chkchosairaihakko
     */
    @JsonProperty("Chkchosairaihakko")
    public void setChkchosairaihakko(CheckBoxList Chkchosairaihakko) {
        this.Chkchosairaihakko = Chkchosairaihakko;
    }

    /*
     * getChkchosairaiRireki
     * @return ChkchosairaiRireki
     */
    @JsonProperty("ChkchosairaiRireki")
    public CheckBoxList getChkchosairaiRireki() {
        return ChkchosairaiRireki;
    }

    /*
     * setChkchosairaiRireki
     * @param ChkchosairaiRireki ChkchosairaiRireki
     */
    @JsonProperty("ChkchosairaiRireki")
    public void setChkchosairaiRireki(CheckBoxList ChkchosairaiRireki) {
        this.ChkchosairaiRireki = ChkchosairaiRireki;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public CheckBoxList getChkChosaIrai() {
        return this.getChosahyoSelectItemsOne().getChkChosaIrai();
    }

    @JsonIgnore
    public void  setChkChosaIrai(CheckBoxList chkChosaIrai) {
        this.getChosahyoSelectItemsOne().setChkChosaIrai(chkChosaIrai);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaOcr() {
        return this.getChosahyoSelectItemsOne().getChkChosaOcr();
    }

    @JsonIgnore
    public void  setChkChosaOcr(CheckBoxList chkChosaOcr) {
        this.getChosahyoSelectItemsOne().setChkChosaOcr(chkChosaOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiOcr() {
        return this.getChosahyoSelectItemsOne().getChkTokkiOcr();
    }

    @JsonIgnore
    public void  setChkTokkiOcr(CheckBoxList chkTokkiOcr) {
        this.getChosahyoSelectItemsOne().setChkTokkiOcr(chkTokkiOcr);
    }

    @JsonIgnore
    public CheckBoxList getChkNinteiChosahyoSonota() {
        return this.getChosahyoSelectItemsOne().getChkNinteiChosahyoSonota();
    }

    @JsonIgnore
    public void  setChkNinteiChosahyoSonota(CheckBoxList chkNinteiChosahyoSonota) {
        this.getChosahyoSelectItemsOne().setChkNinteiChosahyoSonota(chkNinteiChosahyoSonota);
    }

    @JsonIgnore
    public CheckBoxList getChkChosaDesign() {
        return this.getChosahyoSelectItemsTwo().getChkChosaDesign();
    }

    @JsonIgnore
    public void  setChkChosaDesign(CheckBoxList chkChosaDesign) {
        this.getChosahyoSelectItemsTwo().setChkChosaDesign(chkChosaDesign);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiDesign() {
        return this.getChosahyoSelectItemsTwo().getChkTokkiDesign();
    }

    @JsonIgnore
    public void  setChkTokkiDesign(CheckBoxList chkTokkiDesign) {
        this.getChosahyoSelectItemsTwo().setChkTokkiDesign(chkTokkiDesign);
    }

    @JsonIgnore
    public CheckBoxList getChkSaiCheck() {
        return this.getChosahyoSelectItemsTwo().getChkSaiCheck();
    }

    @JsonIgnore
    public void  setChkSaiCheck(CheckBoxList chkSaiCheck) {
        this.getChosahyoSelectItemsTwo().setChkSaiCheck(chkSaiCheck);
    }

    @JsonIgnore
    public CheckBoxList getChkGaikyoTokki() {
        return this.getChosahyoSelectItemsTwo().getChkGaikyoTokki();
    }

    @JsonIgnore
    public void  setChkGaikyoTokki(CheckBoxList chkGaikyoTokki) {
        this.getChosahyoSelectItemsTwo().setChkGaikyoTokki(chkGaikyoTokki);
    }

    @JsonIgnore
    public TokkiChecksDiv getTokkiChecks() {
        return this.getChosahyoTokkijikoSelect().getTokkiChecks();
    }

    @JsonIgnore
    public void  setTokkiChecks(TokkiChecksDiv TokkiChecks) {
        this.getChosahyoTokkijikoSelect().setTokkiChecks(TokkiChecks);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiKomokuAri() {
        return this.getChosahyoTokkijikoSelect().getTokkiChecks().getChkTokkiKomokuAri();
    }

    @JsonIgnore
    public void  setChkTokkiKomokuAri(CheckBoxList chkTokkiKomokuAri) {
        this.getChosahyoTokkijikoSelect().getTokkiChecks().setChkTokkiKomokuAri(chkTokkiKomokuAri);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiKomokuNashi() {
        return this.getChosahyoTokkijikoSelect().getTokkiChecks().getChkTokkiKomokuNashi();
    }

    @JsonIgnore
    public void  setChkTokkiKomokuNashi(CheckBoxList chkTokkiKomokuNashi) {
        this.getChosahyoTokkijikoSelect().getTokkiChecks().setChkTokkiKomokuNashi(chkTokkiKomokuNashi);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkiFree() {
        return this.getChosahyoTokkijikoSelect().getTokkiChecks().getChkTokkiFree();
    }

    @JsonIgnore
    public void  setChkTokkiFree(CheckBoxList chkTokkiFree) {
        this.getChosahyoTokkijikoSelect().getTokkiChecks().setChkTokkiFree(chkTokkiFree);
    }

    @JsonIgnore
    public CheckBoxList getChkTokkijikoTenyuryoku() {
        return this.getChosahyoTokkijikoSelect().getChkTokkijikoTenyuryoku();
    }

    @JsonIgnore
    public void  setChkTokkijikoTenyuryoku(CheckBoxList chkTokkijikoTenyuryoku) {
        this.getChosahyoTokkijikoSelect().setChkTokkijikoTenyuryoku(chkTokkijikoTenyuryoku);
    }

    // </editor-fold>
}
