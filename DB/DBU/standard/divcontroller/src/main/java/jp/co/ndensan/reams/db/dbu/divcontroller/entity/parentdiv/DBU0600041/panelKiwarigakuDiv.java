package jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0600041;
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
 * panelKiwarigaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class panelKiwarigakuDiv extends Panel {
    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-08-09_21-40-56">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKiwarigaku")
    private tblKiwarigakuDiv tblKiwarigaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblKiwarigaku
     * @return tblKiwarigaku
     */
    @JsonProperty("tblKiwarigaku")
    public tblKiwarigakuDiv getTblKiwarigaku() {
        return tblKiwarigaku;
    }

    /*
     * settblKiwarigaku
     * @param tblKiwarigaku tblKiwarigaku
     */
    @JsonProperty("tblKiwarigaku")
    public void setTblKiwarigaku(tblKiwarigakuDiv tblKiwarigaku) {
        this.tblKiwarigaku = tblKiwarigaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTokubetuCyousyuu() {
        return this.getTblKiwarigaku().getLblTokubetuCyousyuu();
    }

    @JsonIgnore
    public Label getLblFutuCyousyu() {
        return this.getTblKiwarigaku().getLblFutuCyousyu();
    }

    @JsonIgnore
    public Label getLblGatu() {
        return this.getTblKiwarigaku().getLblGatu();
    }

    @JsonIgnore
    public Label getLblTokubetuKi() {
        return this.getTblKiwarigaku().getLblTokubetuKi();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku();
    }

    @JsonIgnore
    public Label getLblFutsuKi() {
        return this.getTblKiwarigaku().getLblFutsuKi();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku();
    }

    @JsonIgnore
    public Label getLblGatu4() {
        return this.getTblKiwarigaku().getLblGatu4();
    }

    @JsonIgnore
    public Label getLblTokubetuKi1() {
        return this.getTblKiwarigaku().getLblTokubetuKi1();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku4() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku4();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku4() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku4();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku4() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku4();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku4() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku4();
    }

    @JsonIgnore
    public Label getLblGatu5() {
        return this.getTblKiwarigaku().getLblGatu5();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku5() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku5();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku5() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku5();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku5() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku5();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku5() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku5();
    }

    @JsonIgnore
    public Label getLblGatu6() {
        return this.getTblKiwarigaku().getLblGatu6();
    }

    @JsonIgnore
    public Label getLblTokubetuKi2() {
        return this.getTblKiwarigaku().getLblTokubetuKi2();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku6() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku6();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku6() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku6();
    }

    @JsonIgnore
    public Label getLblFutsuKi1() {
        return this.getTblKiwarigaku().getLblFutsuKi1();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku6() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku6();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku6() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku6();
    }

    @JsonIgnore
    public Label getLblGatu7() {
        return this.getTblKiwarigaku().getLblGatu7();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku7() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku7();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku7() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku7();
    }

    @JsonIgnore
    public Label getLblFutsuKi2() {
        return this.getTblKiwarigaku().getLblFutsuKi2();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku7() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku7();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku7() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku7();
    }

    @JsonIgnore
    public Label getLblGatu8() {
        return this.getTblKiwarigaku().getLblGatu8();
    }

    @JsonIgnore
    public Label getLblTokubetuKi3() {
        return this.getTblKiwarigaku().getLblTokubetuKi3();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku8() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku8();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku8() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku8();
    }

    @JsonIgnore
    public Label getLblFutsuKi3() {
        return this.getTblKiwarigaku().getLblFutsuKi3();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku8() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku8();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku8() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku8();
    }

    @JsonIgnore
    public Label getLblGatu9() {
        return this.getTblKiwarigaku().getLblGatu9();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku9() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku9();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku9() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku9();
    }

    @JsonIgnore
    public Label getLblFutsuKi4() {
        return this.getTblKiwarigaku().getLblFutsuKi4();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku9() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku9();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku9() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku9();
    }

    @JsonIgnore
    public Label getLblGatu10() {
        return this.getTblKiwarigaku().getLblGatu10();
    }

    @JsonIgnore
    public Label getLblTokubetuKi4() {
        return this.getTblKiwarigaku().getLblTokubetuKi4();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku10() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku10();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku10() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku10();
    }

    @JsonIgnore
    public Label getLblFutsuKi5() {
        return this.getTblKiwarigaku().getLblFutsuKi5();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku10() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku10();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku10() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku10();
    }

    @JsonIgnore
    public Label getLblGatu11() {
        return this.getTblKiwarigaku().getLblGatu11();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku11() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku11();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku11() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku11();
    }

    @JsonIgnore
    public Label getLblFutsuKi6() {
        return this.getTblKiwarigaku().getLblFutsuKi6();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku11() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku11();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku11() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku11();
    }

    @JsonIgnore
    public Label getLblGatu12() {
        return this.getTblKiwarigaku().getLblGatu12();
    }

    @JsonIgnore
    public Label getLblTokubetuKi5() {
        return this.getTblKiwarigaku().getLblTokubetuKi5();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku12() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku12();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku12() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku12();
    }

    @JsonIgnore
    public Label getLblFutsuKi7() {
        return this.getTblKiwarigaku().getLblFutsuKi7();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku12() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku12();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku12() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku12();
    }

    @JsonIgnore
    public Label getLblGatu1() {
        return this.getTblKiwarigaku().getLblGatu1();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku1() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku1();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku1() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku1();
    }

    @JsonIgnore
    public Label getLblFutsuKi8() {
        return this.getTblKiwarigaku().getLblFutsuKi8();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku1() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku1();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku1() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku1();
    }

    @JsonIgnore
    public Label getLblGatu2() {
        return this.getTblKiwarigaku().getLblGatu2();
    }

    @JsonIgnore
    public Label getLblTokubetuKi6() {
        return this.getTblKiwarigaku().getLblTokubetuKi6();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku2() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku2();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku2() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku2();
    }

    @JsonIgnore
    public Label getLblFutsuKi9() {
        return this.getTblKiwarigaku().getLblFutsuKi9();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku2() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku2();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku2() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku2();
    }

    @JsonIgnore
    public Label getLblGatu3() {
        return this.getTblKiwarigaku().getLblGatu3();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku3() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku3();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku3() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku3();
    }

    @JsonIgnore
    public Label getLblFutsuKi10() {
        return this.getTblKiwarigaku().getLblFutsuKi10();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku3() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku3();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku3() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku3();
    }

    @JsonIgnore
    public Label getLblGatu41() {
        return this.getTblKiwarigaku().getLblGatu41();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku41() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku41();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku41() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku41();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku41() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku41();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku41() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku41();
    }

    @JsonIgnore
    public Label getLblGatu51() {
        return this.getTblKiwarigaku().getLblGatu51();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugaku51() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugaku51();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugaku51() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugaku51();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugaku51() {
        return this.getTblKiwarigaku().getLblFutsuKibetugaku51();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugaku51() {
        return this.getTblKiwarigaku().getLblFutsuNouhugaku51();
    }

    @JsonIgnore
    public Label getLblGoukei() {
        return this.getTblKiwarigaku().getLblGoukei();
    }

    @JsonIgnore
    public Label getLblTokubetuKibetugakuGoukei() {
        return this.getTblKiwarigaku().getLblTokubetuKibetugakuGoukei();
    }

    @JsonIgnore
    public Label getLblTokubetuNouhugakuGoukei() {
        return this.getTblKiwarigaku().getLblTokubetuNouhugakuGoukei();
    }

    @JsonIgnore
    public Label getLblFutsuKibetugakuGoukei() {
        return this.getTblKiwarigaku().getLblFutsuKibetugakuGoukei();
    }

    @JsonIgnore
    public Label getLblFutsuNouhugakuGoukei() {
        return this.getTblKiwarigaku().getLblFutsuNouhugakuGoukei();
    }

    @JsonIgnore
    public Label getLblKeisanjouNenkanHokenryouGaku() {
        return this.getTblKiwarigaku().getLblKeisanjouNenkanHokenryouGaku();
    }

    @JsonIgnore
    public Label getLblKariSanteiKeisanjouHokenryouGaku() {
        return this.getTblKiwarigaku().getLblKariSanteiKeisanjouHokenryouGaku();
    }

    @JsonIgnore
    public Label getLblKeisanjouNenkanHokenryouGakuValue() {
        return this.getTblKiwarigaku().getLblKeisanjouNenkanHokenryouGakuValue();
    }

    @JsonIgnore
    public Label getLblKariSanteiKeisanjouHokenryouGakuValue() {
        return this.getTblKiwarigaku().getLblKariSanteiKeisanjouHokenryouGakuValue();
    }

    @JsonIgnore
    public Label getLblGenmenGaku() {
        return this.getTblKiwarigaku().getLblGenmenGaku();
    }

    @JsonIgnore
    public Label getLblGenmenGakuValue() {
        return this.getTblKiwarigaku().getLblGenmenGakuValue();
    }

    @JsonIgnore
    public Label getLblKakuteiNenkanHokenryouGaku() {
        return this.getTblKiwarigaku().getLblKakuteiNenkanHokenryouGaku();
    }

    @JsonIgnore
    public Label getLblKariSanteiHokenryouGaku() {
        return this.getTblKiwarigaku().getLblKariSanteiHokenryouGaku();
    }

    @JsonIgnore
    public Label getLblKakuteiNenkanHokenryouGakuValue() {
        return this.getTblKiwarigaku().getLblKakuteiNenkanHokenryouGakuValue();
    }

    @JsonIgnore
    public Label getLblKariSanteiHokenryouGakuValue() {
        return this.getTblKiwarigaku().getLblKariSanteiHokenryouGakuValue();
    }

    // </editor-fold>
}
