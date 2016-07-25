/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.entity.commonchilddiv.kiwarigaku.Kiwarigaku;

import java.util.Objects;
import jp.co.ndensan.reams.db.dbb.business.core.Kiwarigaku;
import jp.co.ndensan.reams.db.dbb.business.core.basic.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbb.service.core.relate.KiwarigakuManager;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KanendoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.Kitsuki;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.business.config.FuchoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.business.config.KanendoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.TokuchoConfig;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 期割額Divの操作を行うクラスです。
 */
public class KiwarigakuHandler {

    private static final RString SUFFIX_期 = new RString("期");
    private static final int 追加期1 = 13;
    private static final int 追加期2 = 14;

    private final KiwarigakuDiv div;
    private final KiwarigakuManager manager;
    private final FukaKeisanConfig 賦課計算Config;

    /**
     * コンストラクタです。
     *
     * @param div 期割額Div
     */
    public KiwarigakuHandler(KiwarigakuDiv div) {
        this.div = div;
        this.manager = new KiwarigakuManager();
        this.賦課計算Config = new FukaKeisanConfig();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 期割額Div
     * @param manager 期割額Manager
     * @param 賦課計算Config 賦課計算Config
     * @param 日付Config 日付Config
     * @param 普徴Config 普徴Config
     * @param 特徴Config 特徴Config
     * @param 過年度Config 過年度Config
     */
    public KiwarigakuHandler(KiwarigakuDiv div, KiwarigakuManager manager,
            FukaKeisanConfig 賦課計算Config, HizukeConfig 日付Config, FuchoConfig 普徴Config, TokuchoConfig 特徴Config, KanendoConfig 過年度Config) {
        this.div = div;
        this.manager = manager;
        this.賦課計算Config = 賦課計算Config;
    }

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     */
    public void load(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, int 履歴番号) {
        KitsukiList 普徴期リスト = Objects.equals(調定年度, 賦課年度)
                             ? new FuchoKiUtil(調定年度).get期月リスト()
                             : new KanendoKiUtil(調定年度).get期月リスト();
        clear期別And調定And収入(this.div);
        set普徴期ラベルs(this.div, 普徴期リスト);
        setDisplayMode(賦課年度, 普徴期リスト.getLast().get期AsInt());
        setKiwarigaku(this.div, manager.load期割額(調定年度, 賦課年度, 通知書番号, 履歴番号).get(), 普徴期リスト);
    }

    private static void clear期別And調定And収入(KiwarigakuDiv div) {
        clear普徴期別(div);
        clear普徴調定And収入(div);
        clear特徴調定And収入(div);
    }

    //<editor-fold defaultstate="collapsed" desc="clear普徴期別()">
    private static void clear普徴期別(KiwarigakuDiv div) {
        div.getLblFuchoKi1().setText(RString.FULL_SPACE);
        div.getLblFuchoKi2().setText(RString.FULL_SPACE);
        div.getLblFuchoKi3().setText(RString.FULL_SPACE);
        div.getLblFuchoKi4().setText(RString.FULL_SPACE);
        div.getLblFuchoKi5().setText(RString.FULL_SPACE);
        div.getLblFuchoKi6().setText(RString.FULL_SPACE);
        div.getLblFuchoKi7().setText(RString.FULL_SPACE);
        div.getLblFuchoKi8().setText(RString.FULL_SPACE);
        div.getLblFuchoKi9().setText(RString.FULL_SPACE);
        div.getLblFuchoKi10().setText(RString.FULL_SPACE);
        div.getLblFuchoKi11().setText(RString.FULL_SPACE);
        div.getLblFuchoKi12().setText(RString.FULL_SPACE);
        div.getLblFuchoKi13().setText(RString.FULL_SPACE);
        div.getLblFuchoKi14().setText(RString.FULL_SPACE);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="clear特徴調定And収入()">
    private static void clear特徴調定And収入(KiwarigakuDiv div) {
        div.getLblTokuKibetsuGaku1().setText(RString.FULL_SPACE);
        div.getLblTokuNofuGaku1().setText(RString.FULL_SPACE);
        div.getLblTokuKibetsuGaku3().setText(RString.FULL_SPACE);
        div.getLblTokuNofuGaku3().setText(RString.FULL_SPACE);
        div.getLblTokuKibetsuGaku5().setText(RString.FULL_SPACE);
        div.getLblTokuNofuGaku5().setText(RString.FULL_SPACE);
        div.getLblTokuKibetsuGaku7().setText(RString.FULL_SPACE);
        div.getLblTokuNofuGaku7().setText(RString.FULL_SPACE);
        div.getLblTokuKibetsuGaku9().setText(RString.FULL_SPACE);
        div.getLblTokuNofuGaku9().setText(RString.FULL_SPACE);
        div.getLblTokuKibetsuGaku11().setText(RString.FULL_SPACE);
        div.getLblTokuNofuGaku11().setText(RString.FULL_SPACE);
        div.getLblTokuKibetsuGakuGokei().setText(RString.FULL_SPACE);
        div.getLblTokuKibetsuGakuGokei().setText(RString.FULL_SPACE);
        div.getLblTokuNofuGakuGokei().setText(RString.FULL_SPACE);
        div.getLblTokuNofuGakuGokei().setText(RString.FULL_SPACE);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="clear普徴調定And収入()">
    private static void clear普徴調定And収入(KiwarigakuDiv div) {
        div.getLblFuchoKibetsuGaku1().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku1().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku2().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku2().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku3().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku3().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku4().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku4().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku5().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku5().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku6().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku6().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku7().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku7().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku8().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku8().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku9().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku9().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku10().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku10().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku11().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku11().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku12().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku12().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku13().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku13().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGaku14().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGaku14().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGakuGokei().setText(RString.FULL_SPACE);
        div.getLblFuchoKibetsuGakuGokei().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGakuGokei().setText(RString.FULL_SPACE);
        div.getLblFuchoNofuGakuGokei().setText(RString.FULL_SPACE);
    }
    //</editor-fold>

    private static void set普徴期ラベルs(KiwarigakuDiv div, KitsukiList 普徴期リスト) {
        for (Kitsuki kitsuki : 普徴期リスト.toList()) {
            set普徴期ラベルPer(kitsuki, div);
        }
    }

    //暫定対応 - Kitsukiにバグがあり、get表記().asX期() が利用できない。
    private static RString asX期(Kitsuki 期月) {
        int 期 = 期月.get期AsInt();
        return 期 == 0 ? RString.EMPTY
               : new RStringBuilder().append(期).append(SUFFIX_期).toRString();
    }

    private static void set普徴期ラベルPer(Kitsuki 期月, KiwarigakuDiv div) {
        switch (期月.get月()) {
            case _4月:
                div.getLblFuchoKi1().setText(asX期(期月));
                return;
            case _5月:
                div.getLblFuchoKi2().setText(asX期(期月));
                return;
            case _6月:
                div.getLblFuchoKi3().setText(asX期(期月));
                return;
            case _7月:
                div.getLblFuchoKi4().setText(asX期(期月));
                return;
            case _8月:
                div.getLblFuchoKi5().setText(asX期(期月));
                return;
            case _9月:
                div.getLblFuchoKi6().setText(asX期(期月));
                return;
            case _10月:
                div.getLblFuchoKi7().setText(asX期(期月));
                return;
            case _11月:
                div.getLblFuchoKi8().setText(asX期(期月));
                return;
            case _12月:
                div.getLblFuchoKi9().setText(asX期(期月));
                return;
            case _1月:
                div.getLblFuchoKi10().setText(asX期(期月));
                return;
            case _2月:
                div.getLblFuchoKi11().setText(asX期(期月));
                return;
            case _3月:
                div.getLblFuchoKi12().setText(asX期(期月));
                return;
            case 翌年度4月:
                div.getLblFuchoKi13().setText(asX期(期月));
                return;
            case 翌年度5月:
                div.getLblFuchoKi14().setText(asX期(期月));
            default:
        }
    }

    private void setDisplayMode(FlexibleYear 賦課年度, int 普徴期数) {

        FlexibleYear 不均一納期期限 = new FlexibleYear(賦課計算Config.get不均一納期期限());
        boolean is月列表示 = 不均一納期期限.isBeforeOrEquals(賦課年度);
        boolean is追加期1表示 = (追加期1 <= 普徴期数);
        boolean is追加期2表示 = (追加期2 <= 普徴期数);

        div.getTblTsuki1().setVisible(is月列表示);
        div.getTblTsuki1().setDisplayNone(!is月列表示);
        div.getTblTsuki2().setVisible(is月列表示 && is追加期1表示);
        div.getTblTsuki2().setDisplayNone(!(is月列表示 && is追加期1表示));
        div.getTblTsuki3().setVisible(is月列表示 && is追加期2表示);
        div.getTblTsuki3().setDisplayNone(!(is月列表示 && is追加期2表示));
        div.getTblTsuki4().setVisible(is月列表示);
        div.getTblTsuki4().setDisplayNone(!is月列表示);

        div.getTblKiwariGaku1().setVisible(true);
        div.getTblKiwariGaku1().setDisplayNone(false);
        div.getTblKiwariGaku2().setVisible(is追加期1表示);
        div.getTblKiwariGaku2().setDisplayNone(!is追加期1表示);
        div.getTblKiwariGaku3().setVisible(is追加期2表示);
        div.getTblKiwariGaku3().setDisplayNone(!is追加期2表示);
        div.getTblKiwariGaku4().setVisible(true);
        div.getTblKiwariGaku4().setDisplayNone(false);

        div.getLblTokuchoKiGokei().setVisible(!is月列表示);
    }

    private static void setKiwarigaku(KiwarigakuDiv div, Kiwarigaku 期割額, KitsukiList 普徴期リスト) {
        for (KiwarigakuMeisai 明細 : 期割額.get期割額明細()) {
            set期割額(div, 明細, 普徴期リスト);
        }
        div.getLblTokuKibetsuGakuGokei().setVisible(!期割額.is特徴期別額合計0円());
        div.getLblTokuKibetsuGakuGokei().setText(期割額.get特徴期別額合計表記());
        div.getLblTokuNofuGakuGokei().setVisible(!期割額.is特徴期別額合計0円() || !期割額.is特徴納付額合計0円());
        div.getLblTokuNofuGakuGokei().setText(期割額.get特徴納付額合計表記());
        div.getLblFuchoKibetsuGakuGokei().setVisible(!期割額.is普徴期別額合計0円());
        div.getLblFuchoKibetsuGakuGokei().setText(期割額.get普徴期別額合計表記());
        div.getLblFuchoNofuGakuGokei().setVisible(!期割額.is普徴期別額合計0円() || !期割額.is普徴納付額合計0円());
        div.getLblFuchoNofuGakuGokei().setText(期割額.get普徴納付額合計表記());
    }

    private static void set期割額(KiwarigakuDiv div, KiwarigakuMeisai 期割額明細, KitsukiList 普徴期月リスト) {
        switch (期割額明細.get徴収方法()) {
            case 特別徴収:
                set特別徴収(div, 期割額明細);
                return;
            case 普通徴収:
                set普通徴収(div, 期割額明細, 普徴期月リスト);
        }
    }

    private static void set特別徴収(KiwarigakuDiv div, KiwarigakuMeisai 期割額明細) {
        switch (期割額明細.get期()) {
            case 1:
                div.getLblTokuKibetsuGaku1().setText(期割額明細.get調定額表記());
                div.getLblTokuNofuGaku1().setText(期割額明細.get収入額表記());
                return;
            case 2:
                div.getLblTokuKibetsuGaku3().setText(期割額明細.get調定額表記());
                div.getLblTokuNofuGaku3().setText(期割額明細.get収入額表記());
                return;
            case 3:
                div.getLblTokuKibetsuGaku5().setText(期割額明細.get調定額表記());
                div.getLblTokuNofuGaku5().setText(期割額明細.get収入額表記());
                return;
            case 4:
                div.getLblTokuKibetsuGaku7().setText(期割額明細.get調定額表記());
                div.getLblTokuNofuGaku7().setText(期割額明細.get収入額表記());
                return;
            case 5:
                div.getLblTokuKibetsuGaku9().setText(期割額明細.get調定額表記());
                div.getLblTokuNofuGaku9().setText(期割額明細.get収入額表記());
                return;
            case 6:
                div.getLblTokuKibetsuGaku11().setText(期割額明細.get調定額表記());
                div.getLblTokuNofuGaku11().setText(期割額明細.get収入額表記());
            default:
        }
    }

    private static void set普通徴収(KiwarigakuDiv div, KiwarigakuMeisai 期割額明細, KitsukiList 普徴期月リスト) {
        Kitsuki kitsuki = 普徴期月リスト.get期の最初月(期割額明細.get期());
        switch (kitsuki.get月()) {
            case _4月:
                div.getLblFuchoKibetsuGaku1().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku1().setText(期割額明細.get収入額表記());
                return;
            case _5月:
                div.getLblFuchoKibetsuGaku2().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku2().setText(期割額明細.get収入額表記());
                return;
            case _6月:
                div.getLblFuchoKibetsuGaku3().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku3().setText(期割額明細.get収入額表記());
                return;
            case _7月:
                div.getLblFuchoKibetsuGaku4().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku4().setText(期割額明細.get収入額表記());
                return;
            case _8月:
                div.getLblFuchoKibetsuGaku5().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku5().setText(期割額明細.get収入額表記());
                return;
            case _9月:
                div.getLblFuchoKibetsuGaku6().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku6().setText(期割額明細.get収入額表記());
                return;
            case _10月:
                div.getLblFuchoKibetsuGaku7().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku7().setText(期割額明細.get収入額表記());
                return;
            case _11月:
                div.getLblFuchoKibetsuGaku8().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku8().setText(期割額明細.get収入額表記());
                return;
            case _12月:
                div.getLblFuchoKibetsuGaku9().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku9().setText(期割額明細.get収入額表記());
                return;
            case _1月:
                div.getLblFuchoKibetsuGaku10().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku10().setText(期割額明細.get収入額表記());
                return;
            case _2月:
                div.getLblFuchoKibetsuGaku11().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku11().setText(期割額明細.get収入額表記());
                return;
            case _3月:
                div.getLblFuchoKibetsuGaku12().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku12().setText(期割額明細.get収入額表記());
                return;
            case 翌年度4月:
                div.getLblFuchoKibetsuGaku13().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku13().setText(期割額明細.get収入額表記());
                return;
            case 翌年度5月:
                div.getLblFuchoKibetsuGaku14().setText(期割額明細.get調定額表記());
                div.getLblFuchoNofuGaku14().setText(期割額明細.get収入額表記());
            default:
        }
    }
}
