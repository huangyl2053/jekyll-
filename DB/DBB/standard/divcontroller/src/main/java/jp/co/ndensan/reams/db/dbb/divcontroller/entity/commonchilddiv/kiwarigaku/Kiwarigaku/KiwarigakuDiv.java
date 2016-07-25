package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kiwarigaku.Kiwarigaku;
/*
 * このコードはツールによって生成されました。
 * このファイルへの変更は、再生成時には損失するため
 * 不正な動作の原因になります。
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jp.co.ndensan.reams.db.dbb.business.core.Kiwarigaku;
import jp.co.ndensan.reams.uz.uza.ui.binding.*;
import jp.co.ndensan.reams.uz.uza.ui.binding.Panel;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;

/**
 * Kiwarigaku のクラスファイル
 *
 * @author 自動生成
 */
public class KiwarigakuDiv extends Panel implements IKiwarigakuDiv {

    // <editor-fold defaultstate="collapsed" desc="Created By UIDesigner ver：UZ-deploy-2016-05-30_13-18-33">
    /*
     * [ private の作成 ]
     * クライアント側から取得した情報を元にを検索を行い
     * コントロール名とフィールド名を取得する
     * private + コントロール名 + フィールド名 の文字列を作成
     */
    @JsonProperty("tblTsuki1")
    private tblTsuki1Div tblTsuki1;
    @JsonProperty("tblKiwariGaku1")
    private tblKiwariGaku1Div tblKiwariGaku1;
    @JsonProperty("tblTsuki2")
    private tblTsuki2Div tblTsuki2;
    @JsonProperty("tblKiwariGaku2")
    private tblKiwariGaku2Div tblKiwariGaku2;
    @JsonProperty("tblTsuki3")
    private tblTsuki3Div tblTsuki3;
    @JsonProperty("tblKiwariGaku3")
    private tblKiwariGaku3Div tblKiwariGaku3;
    @JsonProperty("tblTsuki4")
    private tblTsuki4Div tblTsuki4;
    @JsonProperty("tblKiwariGaku4")
    private tblKiwariGaku4Div tblKiwariGaku4;

    /*
     * [ GetterとSetterの作成 ]
     * クライアント側から取得した情報を元に検索を行い
     * コントロール名とフィールド名を取得する
     * フィールド名のGetterとSetter を作成
     */
    /*
     * gettblTsuki1
     * @return tblTsuki1
     */
    @JsonProperty("tblTsuki1")
    public tblTsuki1Div getTblTsuki1() {
        return tblTsuki1;
    }

    /*
     * settblTsuki1
     * @param tblTsuki1 tblTsuki1
     */
    @JsonProperty("tblTsuki1")
    public void setTblTsuki1(tblTsuki1Div tblTsuki1) {
        this.tblTsuki1 = tblTsuki1;
    }

    /*
     * gettblKiwariGaku1
     * @return tblKiwariGaku1
     */
    @JsonProperty("tblKiwariGaku1")
    public tblKiwariGaku1Div getTblKiwariGaku1() {
        return tblKiwariGaku1;
    }

    /*
     * settblKiwariGaku1
     * @param tblKiwariGaku1 tblKiwariGaku1
     */
    @JsonProperty("tblKiwariGaku1")
    public void setTblKiwariGaku1(tblKiwariGaku1Div tblKiwariGaku1) {
        this.tblKiwariGaku1 = tblKiwariGaku1;
    }

    /*
     * gettblTsuki2
     * @return tblTsuki2
     */
    @JsonProperty("tblTsuki2")
    public tblTsuki2Div getTblTsuki2() {
        return tblTsuki2;
    }

    /*
     * settblTsuki2
     * @param tblTsuki2 tblTsuki2
     */
    @JsonProperty("tblTsuki2")
    public void setTblTsuki2(tblTsuki2Div tblTsuki2) {
        this.tblTsuki2 = tblTsuki2;
    }

    /*
     * gettblKiwariGaku2
     * @return tblKiwariGaku2
     */
    @JsonProperty("tblKiwariGaku2")
    public tblKiwariGaku2Div getTblKiwariGaku2() {
        return tblKiwariGaku2;
    }

    /*
     * settblKiwariGaku2
     * @param tblKiwariGaku2 tblKiwariGaku2
     */
    @JsonProperty("tblKiwariGaku2")
    public void setTblKiwariGaku2(tblKiwariGaku2Div tblKiwariGaku2) {
        this.tblKiwariGaku2 = tblKiwariGaku2;
    }

    /*
     * gettblTsuki3
     * @return tblTsuki3
     */
    @JsonProperty("tblTsuki3")
    public tblTsuki3Div getTblTsuki3() {
        return tblTsuki3;
    }

    /*
     * settblTsuki3
     * @param tblTsuki3 tblTsuki3
     */
    @JsonProperty("tblTsuki3")
    public void setTblTsuki3(tblTsuki3Div tblTsuki3) {
        this.tblTsuki3 = tblTsuki3;
    }

    /*
     * gettblKiwariGaku3
     * @return tblKiwariGaku3
     */
    @JsonProperty("tblKiwariGaku3")
    public tblKiwariGaku3Div getTblKiwariGaku3() {
        return tblKiwariGaku3;
    }

    /*
     * settblKiwariGaku3
     * @param tblKiwariGaku3 tblKiwariGaku3
     */
    @JsonProperty("tblKiwariGaku3")
    public void setTblKiwariGaku3(tblKiwariGaku3Div tblKiwariGaku3) {
        this.tblKiwariGaku3 = tblKiwariGaku3;
    }

    /*
     * gettblTsuki4
     * @return tblTsuki4
     */
    @JsonProperty("tblTsuki4")
    public tblTsuki4Div getTblTsuki4() {
        return tblTsuki4;
    }

    /*
     * settblTsuki4
     * @param tblTsuki4 tblTsuki4
     */
    @JsonProperty("tblTsuki4")
    public void setTblTsuki4(tblTsuki4Div tblTsuki4) {
        this.tblTsuki4 = tblTsuki4;
    }

    /*
     * gettblKiwariGaku4
     * @return tblKiwariGaku4
     */
    @JsonProperty("tblKiwariGaku4")
    public tblKiwariGaku4Div getTblKiwariGaku4() {
        return tblKiwariGaku4;
    }

    /*
     * settblKiwariGaku4
     * @param tblKiwariGaku4 tblKiwariGaku4
     */
    @JsonProperty("tblKiwariGaku4")
    public void setTblKiwariGaku4(tblKiwariGaku4Div tblKiwariGaku4) {
        this.tblKiwariGaku4 = tblKiwariGaku4;
    }

    /*
     * [ ショートカットの作成 ]
     */
    @JsonIgnore
    public Label getLblTsuki0() {
        return this.getTblTsuki1().getLblTsuki0();
    }

    @JsonIgnore
    public Label getLblTsuki() {
        return this.getTblTsuki1().getLblTsuki();
    }

    @JsonIgnore
    public Label getLblTsuki1() {
        return this.getTblTsuki1().getLblTsuki1();
    }

    @JsonIgnore
    public Label getLblTsuki2() {
        return this.getTblTsuki1().getLblTsuki2();
    }

    @JsonIgnore
    public Label getLblTsuki3() {
        return this.getTblTsuki1().getLblTsuki3();
    }

    @JsonIgnore
    public Label getLblTsuki4() {
        return this.getTblTsuki1().getLblTsuki4();
    }

    @JsonIgnore
    public Label getLblTsuki5() {
        return this.getTblTsuki1().getLblTsuki5();
    }

    @JsonIgnore
    public Label getLblTsuki6() {
        return this.getTblTsuki1().getLblTsuki6();
    }

    @JsonIgnore
    public Label getLblTsuki7() {
        return this.getTblTsuki1().getLblTsuki7();
    }

    @JsonIgnore
    public Label getLblTsuki8() {
        return this.getTblTsuki1().getLblTsuki8();
    }

    @JsonIgnore
    public Label getLblTsuki9() {
        return this.getTblTsuki1().getLblTsuki9();
    }

    @JsonIgnore
    public Label getLblTsuki10() {
        return this.getTblTsuki1().getLblTsuki10();
    }

    @JsonIgnore
    public Label getLblTsuki11() {
        return this.getTblTsuki1().getLblTsuki11();
    }

    @JsonIgnore
    public Label getLblTsuki12() {
        return this.getTblTsuki1().getLblTsuki12();
    }

    @JsonIgnore
    public Label getLblTokucho() {
        return this.getTblKiwariGaku1().getLblTokucho();
    }

    @JsonIgnore
    public Label getLblFucho() {
        return this.getTblKiwariGaku1().getLblFucho();
    }

    @JsonIgnore
    public Label getLblTokuchoKi() {
        return this.getTblKiwariGaku1().getLblTokuchoKi();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku();
    }

    @JsonIgnore
    public Label getLblFuchoKi() {
        return this.getTblKiwariGaku1().getLblFuchoKi();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku();
    }

    @JsonIgnore
    public Label getLblTokuchoKi1() {
        return this.getTblKiwariGaku1().getLblTokuchoKi1();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku1() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku1();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku1() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku1();
    }

    @JsonIgnore
    public Label getLblFuchoKi1() {
        return this.getTblKiwariGaku1().getLblFuchoKi1();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku1() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku1();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku1() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku1();
    }

    @JsonIgnore
    public Label getLblTokuchoKi2() {
        return this.getTblKiwariGaku1().getLblTokuchoKi2();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku2() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku2();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku2() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku2();
    }

    @JsonIgnore
    public Label getLblFuchoKi2() {
        return this.getTblKiwariGaku1().getLblFuchoKi2();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku2() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku2();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku2() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku2();
    }

    @JsonIgnore
    public Label getLblTokuchoKi3() {
        return this.getTblKiwariGaku1().getLblTokuchoKi3();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku3() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku3();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku3() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku3();
    }

    @JsonIgnore
    public Label getLblFuchoKi3() {
        return this.getTblKiwariGaku1().getLblFuchoKi3();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku3() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku3();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku3() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku3();
    }

    @JsonIgnore
    public Label getLblTokuchoKi4() {
        return this.getTblKiwariGaku1().getLblTokuchoKi4();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku4() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku4();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku4() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku4();
    }

    @JsonIgnore
    public Label getLblFuchoKi4() {
        return this.getTblKiwariGaku1().getLblFuchoKi4();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku4() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku4();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku4() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku4();
    }

    @JsonIgnore
    public Label getLblTokuchoKi5() {
        return this.getTblKiwariGaku1().getLblTokuchoKi5();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku5() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku5();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku5() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku5();
    }

    @JsonIgnore
    public Label getLblFuchoKi5() {
        return this.getTblKiwariGaku1().getLblFuchoKi5();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku5() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku5();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku5() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku5();
    }

    @JsonIgnore
    public Label getLblTokuchoKi6() {
        return this.getTblKiwariGaku1().getLblTokuchoKi6();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku6() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku6();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku6() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku6();
    }

    @JsonIgnore
    public Label getLblFuchoKi6() {
        return this.getTblKiwariGaku1().getLblFuchoKi6();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku6() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku6();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku6() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku6();
    }

    @JsonIgnore
    public Label getLblTokuchoKi7() {
        return this.getTblKiwariGaku1().getLblTokuchoKi7();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku7() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku7();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku7() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku7();
    }

    @JsonIgnore
    public Label getLblFuchoKi7() {
        return this.getTblKiwariGaku1().getLblFuchoKi7();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku7() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku7();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku7() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku7();
    }

    @JsonIgnore
    public Label getLblTokuchoKi8() {
        return this.getTblKiwariGaku1().getLblTokuchoKi8();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku8() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku8();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku8() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku8();
    }

    @JsonIgnore
    public Label getLblFuchoKi8() {
        return this.getTblKiwariGaku1().getLblFuchoKi8();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku8() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku8();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku8() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku8();
    }

    @JsonIgnore
    public Label getLblTokuchoKi9() {
        return this.getTblKiwariGaku1().getLblTokuchoKi9();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku9() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku9();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku9() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku9();
    }

    @JsonIgnore
    public Label getLblFuchoKi9() {
        return this.getTblKiwariGaku1().getLblFuchoKi9();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku9() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku9();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku9() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku9();
    }

    @JsonIgnore
    public Label getLblTokuchoKi10() {
        return this.getTblKiwariGaku1().getLblTokuchoKi10();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku10() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku10();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku10() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku10();
    }

    @JsonIgnore
    public Label getLblFuchoKi10() {
        return this.getTblKiwariGaku1().getLblFuchoKi10();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku10() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku10();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku10() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku10();
    }

    @JsonIgnore
    public Label getLblTokuchoKi11() {
        return this.getTblKiwariGaku1().getLblTokuchoKi11();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku11() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku11();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku11() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku11();
    }

    @JsonIgnore
    public Label getLblFuchoKi11() {
        return this.getTblKiwariGaku1().getLblFuchoKi11();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku11() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku11();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku11() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku11();
    }

    @JsonIgnore
    public Label getLblTokuchoKi12() {
        return this.getTblKiwariGaku1().getLblTokuchoKi12();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku12() {
        return this.getTblKiwariGaku1().getLblTokuKibetsuGaku12();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku12() {
        return this.getTblKiwariGaku1().getLblTokuNofuGaku12();
    }

    @JsonIgnore
    public Label getLblFuchoKi12() {
        return this.getTblKiwariGaku1().getLblFuchoKi12();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku12() {
        return this.getTblKiwariGaku1().getLblFuchoKibetsuGaku12();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku12() {
        return this.getTblKiwariGaku1().getLblFuchoNofuGaku12();
    }

    @JsonIgnore
    public Label getLblTsuki13() {
        return this.getTblTsuki2().getLblTsuki13();
    }

    @JsonIgnore
    public Label getLblTokuchoKi13() {
        return this.getTblKiwariGaku2().getLblTokuchoKi13();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku13() {
        return this.getTblKiwariGaku2().getLblTokuKibetsuGaku13();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku13() {
        return this.getTblKiwariGaku2().getLblTokuNofuGaku13();
    }

    @JsonIgnore
    public Label getLblFuchoKi13() {
        return this.getTblKiwariGaku2().getLblFuchoKi13();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku13() {
        return this.getTblKiwariGaku2().getLblFuchoKibetsuGaku13();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku13() {
        return this.getTblKiwariGaku2().getLblFuchoNofuGaku13();
    }

    @JsonIgnore
    public Label getLblTsuki14() {
        return this.getTblTsuki3().getLblTsuki14();
    }

    @JsonIgnore
    public Label getLblTokuchoKi14() {
        return this.getTblKiwariGaku3().getLblTokuchoKi14();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGaku14() {
        return this.getTblKiwariGaku3().getLblTokuKibetsuGaku14();
    }

    @JsonIgnore
    public Label getLblTokuNofuGaku14() {
        return this.getTblKiwariGaku3().getLblTokuNofuGaku14();
    }

    @JsonIgnore
    public Label getLblFuchoKi14() {
        return this.getTblKiwariGaku3().getLblFuchoKi14();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGaku14() {
        return this.getTblKiwariGaku3().getLblFuchoKibetsuGaku14();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGaku14() {
        return this.getTblKiwariGaku3().getLblFuchoNofuGaku14();
    }

    @JsonIgnore
    public Label getLblTsukiGokei() {
        return this.getTblTsuki4().getLblTsukiGokei();
    }

    @JsonIgnore
    public Label getLblTokuchoKiGokei() {
        return this.getTblKiwariGaku4().getLblTokuchoKiGokei();
    }

    @JsonIgnore
    public Label getLblTokuKibetsuGakuGokei() {
        return this.getTblKiwariGaku4().getLblTokuKibetsuGakuGokei();
    }

    @JsonIgnore
    public Label getLblTokuNofuGakuGokei() {
        return this.getTblKiwariGaku4().getLblTokuNofuGakuGokei();
    }

    @JsonIgnore
    public Label getLblFuchoKiGokei() {
        return this.getTblKiwariGaku4().getLblFuchoKiGokei();
    }

    @JsonIgnore
    public Label getLblFuchoKibetsuGakuGokei() {
        return this.getTblKiwariGaku4().getLblFuchoKibetsuGakuGokei();
    }

    @JsonIgnore
    public Label getLblFuchoNofuGakuGokei() {
        return this.getTblKiwariGaku4().getLblFuchoNofuGakuGokei();
    }

    // </editor-fold>
    //--------------- この行より下にコードを追加してください -------------------
    @Override
    public Optional<Kiwarigaku> load(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, Decimal 履歴番号) {
        return getHandler().load(調定年度, 賦課年度, 通知書番号, 履歴番号.intValue());
    }

    @JsonIgnore
    public KiwarigakuHandler getHandler() {
        return new KiwarigakuHandler(this);
    }
}
