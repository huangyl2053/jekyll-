package jp.co.ndensan.reams.db.dbb.divcontroller.entity.Kiwarigaku;
/**
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.Kiwarigaku.IKiwarigakuDiv;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.Kiwarigaku.tblKiwariGakuDiv;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.uz.uza.ui.binding.domain.*;

/**
 * Kiwarigaku のクラスファイル 
 * 
 * @author 自動生成
 */
public class KiwarigakuDiv extends Panel implements IKiwarigakuDiv {
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblKiwariGaku")
    private tblKiwariGakuDiv tblKiwariGaku;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    @JsonProperty("tblKiwariGaku")
    public tblKiwariGakuDiv getTblKiwariGaku() {
        return tblKiwariGaku;
    }

    @JsonProperty("tblKiwariGaku")
    public void setTblKiwariGaku(tblKiwariGakuDiv tblKiwariGaku) {
        this.tblKiwariGaku=tblKiwariGaku;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTokucho() {
        return this.getTblKiwariGaku().getLblTokucho();
    }

    @JsonIgnore
    public Label getLblTsuki() {
        return this.getTblKiwariGaku().getLblTsuki();
    }

    @JsonIgnore
    public Label getLblTokuchoKi() {
        return this.getTblKiwariGaku().getLblTokuchoKi();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku() {
        return this.getTblKiwariGaku().getLblTokuKibetsuGaku();
    }

    @JsonIgnore
    public Label getLblTsuki1() {
        return this.getTblKiwariGaku().getLblTsuki1();
    }

    @JsonIgnore
    public Label getLblTokuchoKi1() {
        return this.getTblKiwariGaku().getLblTokuchoKi1();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku1() {
        return this.getTblKiwariGaku().getLblTokuKibetsuGaku1();
    }

    @JsonIgnore
    public Label getLblFucho() {
        return this.getTblKiwariGaku().getLblFucho();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku() {
        return this.getTblKiwariGaku().getLblTokuNofuGaku();
    }

    @JsonIgnore
    public Label getLblFuchoKi() {
        return this.getTblKiwariGaku().getLblFuchoKi();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku1() {
        return this.getTblKiwariGaku().getLblTokuNofuGaku1();
    }

    @JsonIgnore
    public Label getLblFuchoKi1() {
        return this.getTblKiwariGaku().getLblFuchoKi1();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku1() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku1();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku1() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku1();
    }

    @JsonIgnore
    public Label getLblTsuki2() {
        return this.getTblKiwariGaku().getLblTsuki2();
    }

    @JsonIgnore
    public Label getLblFuchoKi2() {
        return this.getTblKiwariGaku().getLblFuchoKi2();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku2() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku2();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku2() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku2();
    }

    @JsonIgnore
    public Label getLblTsuki3() {
        return this.getTblKiwariGaku().getLblTsuki3();
    }

    @JsonIgnore
    public Label getLblTokuchoKi2() {
        return this.getTblKiwariGaku().getLblTokuchoKi2();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku2() {
        return this.getTblKiwariGaku().getLblTokuKibetsuGaku2();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku2() {
        return this.getTblKiwariGaku().getLblTokuNofuGaku2();
    }

    @JsonIgnore
    public Label getLblFuchoKi3() {
        return this.getTblKiwariGaku().getLblFuchoKi3();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku3() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku3();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku3() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku3();
    }

    @JsonIgnore
    public Label getLblTsuki4() {
        return this.getTblKiwariGaku().getLblTsuki4();
    }

    @JsonIgnore
    public Label getLblFuchoKi4() {
        return this.getTblKiwariGaku().getLblFuchoKi4();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku4() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku4();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku4() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku4();
    }

    @JsonIgnore
    public Label getLblTsuki5() {
        return this.getTblKiwariGaku().getLblTsuki5();
    }

    @JsonIgnore
    public Label getLblTokuchoKi3() {
        return this.getTblKiwariGaku().getLblTokuchoKi3();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku3() {
        return this.getTblKiwariGaku().getLblTokuKibetsuGaku3();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku3() {
        return this.getTblKiwariGaku().getLblTokuNofuGaku3();
    }

    @JsonIgnore
    public Label getLblFuchoKi5() {
        return this.getTblKiwariGaku().getLblFuchoKi5();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku5() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku5();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku5() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku5();
    }

    @JsonIgnore
    public Label getLblTsuki6() {
        return this.getTblKiwariGaku().getLblTsuki6();
    }

    @JsonIgnore
    public Label getLblFuchoKi6() {
        return this.getTblKiwariGaku().getLblFuchoKi6();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku6() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku6();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku6() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku6();
    }

    @JsonIgnore
    public Label getLblTsuki7() {
        return this.getTblKiwariGaku().getLblTsuki7();
    }

    @JsonIgnore
    public Label getLblTokuchoKi4() {
        return this.getTblKiwariGaku().getLblTokuchoKi4();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku4() {
        return this.getTblKiwariGaku().getLblTokuKibetsuGaku4();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku4() {
        return this.getTblKiwariGaku().getLblTokuNofuGaku4();
    }

    @JsonIgnore
    public Label getLblFuchoKi7() {
        return this.getTblKiwariGaku().getLblFuchoKi7();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku7() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku7();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku7() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku7();
    }

    @JsonIgnore
    public Label getLblTsuki8() {
        return this.getTblKiwariGaku().getLblTsuki8();
    }

    @JsonIgnore
    public Label getLblFuchoKi8() {
        return this.getTblKiwariGaku().getLblFuchoKi8();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku8() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku8();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku8() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku8();
    }

    @JsonIgnore
    public Label getLblTsuki9() {
        return this.getTblKiwariGaku().getLblTsuki9();
    }

    @JsonIgnore
    public Label getLblTokuchoKi5() {
        return this.getTblKiwariGaku().getLblTokuchoKi5();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku5() {
        return this.getTblKiwariGaku().getLblTokuKibetsuGaku5();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku5() {
        return this.getTblKiwariGaku().getLblTokuNofuGaku5();
    }

    @JsonIgnore
    public Label getLblFuchoKi9() {
        return this.getTblKiwariGaku().getLblFuchoKi9();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku9() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku9();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku9() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku9();
    }

    @JsonIgnore
    public Label getLblTsuki10() {
        return this.getTblKiwariGaku().getLblTsuki10();
    }

    @JsonIgnore
    public Label getLblFuchoKi10() {
        return this.getTblKiwariGaku().getLblFuchoKi10();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku10() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku10();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku10() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku10();
    }

    @JsonIgnore
    public Label getLblTsuki11() {
        return this.getTblKiwariGaku().getLblTsuki11();
    }

    @JsonIgnore
    public Label getLblTokuchoKi6() {
        return this.getTblKiwariGaku().getLblTokuchoKi6();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku6() {
        return this.getTblKiwariGaku().getLblTokuKibetsuGaku6();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku6() {
        return this.getTblKiwariGaku().getLblTokuNofuGaku6();
    }

    @JsonIgnore
    public Label getLblFuchoKi11() {
        return this.getTblKiwariGaku().getLblFuchoKi11();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku11() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku11();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku11() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku11();
    }

    @JsonIgnore
    public Label getLblTsuki12() {
        return this.getTblKiwariGaku().getLblTsuki12();
    }

    @JsonIgnore
    public Label getLblFuchoKi12() {
        return this.getTblKiwariGaku().getLblFuchoKi12();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku12() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku12();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku12() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku12();
    }

    @JsonIgnore
    public Label getLblTsuki13() {
        return this.getTblKiwariGaku().getLblTsuki13();
    }

    @JsonIgnore
    public Label getLblFuchoKi13() {
        return this.getTblKiwariGaku().getLblFuchoKi13();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku13() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku13();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku13() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku13();
    }

    @JsonIgnore
    public Label getLblTsuki14() {
        return this.getTblKiwariGaku().getLblTsuki14();
    }

    @JsonIgnore
    public Label getLblFuchoKi14() {
        return this.getTblKiwariGaku().getLblFuchoKi14();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku14() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGaku14();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku14() {
        return this.getTblKiwariGaku().getLblFuchoNofuGaku14();
    }

    @JsonIgnore
    public Label getLblTsuki15() {
        return this.getTblKiwariGaku().getLblTsuki15();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGakuKei() {
        return this.getTblKiwariGaku().getLblTokuKibetsuGakuKei();
    }

    @JsonIgnore
    public Label getLblTokuNofuGakuKei() {
        return this.getTblKiwariGaku().getLblTokuNofuGakuKei();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGakuKei() {
        return this.getTblKiwariGaku().getLblFuchoKibetsuGakuKei();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGakuKei() {
        return this.getTblKiwariGaku().getLblFuchoNofuGakuKei();
    }

    //--------------- この行より下にコードを追加してください -------------------

}
