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
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-12-16_10-13-04">
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
    public CheckBoxList getChkirai() {
        return this.getChosahyoSelectItemsOne().getChkirai();
    }

    @JsonIgnore
    public void  setChkirai(CheckBoxList Chkirai) {
        this.getChosahyoSelectItemsOne().setChkirai(Chkirai);
    }

    @JsonIgnore
    public CheckBoxList getChkchosaOcr() {
        return this.getChosahyoSelectItemsOne().getChkchosaOcr();
    }

    @JsonIgnore
    public void  setChkchosaOcr(CheckBoxList ChkchosaOcr) {
        this.getChosahyoSelectItemsOne().setChkchosaOcr(ChkchosaOcr);
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
    public CheckBoxList getChkchosa() {
        return this.getChosahyoSelectItemsTwo().getChkchosa();
    }

    @JsonIgnore
    public void  setChkchosa(CheckBoxList Chkchosa) {
        this.getChosahyoSelectItemsTwo().setChkchosa(Chkchosa);
    }

    @JsonIgnore
    public CheckBoxList getChkchosaSonota() {
        return this.getChosahyoSelectItemsTwo().getChkchosaSonota();
    }

    @JsonIgnore
    public void  setChkchosaSonota(CheckBoxList ChkchosaSonota) {
        this.getChosahyoSelectItemsTwo().setChkchosaSonota(ChkchosaSonota);
    }

    @JsonIgnore
    public CheckBoxList getChkChosahyoTokkijiko() {
        return this.getChosahyoTokkijikoSelect().getChkChosahyoTokkijiko();
    }

    @JsonIgnore
    public void  setChkChosahyoTokkijiko(CheckBoxList chkChosahyoTokkijiko) {
        this.getChosahyoTokkijikoSelect().setChkChosahyoTokkijiko(chkChosahyoTokkijiko);
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
