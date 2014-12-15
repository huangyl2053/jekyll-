/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.business.config.FuchoConfig;
import jp.co.ndensan.reams.db.dbb.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbb.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbb.business.config.KanendoConfig;
import jp.co.ndensan.reams.db.dbb.business.config.TokuchoConfig;
import jp.co.ndensan.reams.db.dbb.definition.enumeratedtype.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.Kiwarigaku.KiwarigakuDiv;
import jp.co.ndensan.reams.db.dbb.model.Kiwarigaku;
import jp.co.ndensan.reams.db.dbb.realservice.KiwarigakuFinder;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.model.util.itemlist.IItemList;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;

/**
 * 期割額Divの操作を行うクラスです。
 *
 * @author N8156 宮本 康
 */
public class KiwarigakuHandler {

    private final KiwarigakuDiv div;
    private final KiwarigakuFinder finder;

    private final Label[][] 期割額テーブル;
    private static final int TABLE_SIZE = 15;

    private static final int COL_NO_月 = 0;
    private static final int COL_NO_特徴期 = 1;
    private static final int COL_NO_特徴期別額 = 2;
    private static final int COL_NO_特徴納付額 = 3;
    private static final int COL_NO_普徴期 = 4;
    private static final int COL_NO_普徴期別額 = 5;
    private static final int COL_NO_普徴納付額 = 6;

    private static final RString SUFFIX_月 = new RString("月");
    private static final RString SUFFIX_期 = new RString("期");

    private static final int 追加期1 = 13;
    private static final int 追加期2 = 14;

    private final FukaKeisanConfig 賦課計算Config;
    private final HizukeConfig 日付Config;
    private final FuchoConfig 普徴Config;
    private final TokuchoConfig 特徴Config;
    private final KanendoConfig 過年度Config;

    /**
     * コンストラクタです。
     *
     * @param div 期割額Div
     */
    public KiwarigakuHandler(KiwarigakuDiv div) {
        this.div = div;
        this.finder = new KiwarigakuFinder();
        this.期割額テーブル = getTable();
        this.賦課計算Config = new FukaKeisanConfig();
        this.日付Config = new HizukeConfig();
        this.普徴Config = new FuchoConfig();
        this.特徴Config = new TokuchoConfig();
        this.過年度Config = new KanendoConfig();
    }

    /**
     * モックを使用するテスト用コンストラクタです。
     *
     * @param div 期割額Div
     * @param finder 期割額Finder
     * @param 賦課計算Config 賦課計算Config
     * @param 日付Config 日付Config
     * @param 普徴Config 普徴Config
     * @param 特徴Config 特徴Config
     * @param 過年度Config 過年度Config
     */
    KiwarigakuHandler(KiwarigakuDiv div, KiwarigakuFinder finder,
            FukaKeisanConfig 賦課計算Config, HizukeConfig 日付Config, FuchoConfig 普徴Config, TokuchoConfig 特徴Config, KanendoConfig 過年度Config) {
        this.div = div;
        this.finder = finder;
        this.期割額テーブル = getTable();
        this.賦課計算Config = 賦課計算Config;
        this.日付Config = 日付Config;
        this.普徴Config = 普徴Config;
        this.特徴Config = 特徴Config;
        this.過年度Config = 過年度Config;
    }

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     */
    public void load(FlexibleYear 調定年度, FlexibleYear 賦課年度, TsuchishoNo 通知書番号, RDateTime 処理日時) {

        RString[] 月列 = 日付Config.get月別テーブル();
        RString[] 特徴期列 = 特徴Config.get月の期();
        RString[] 普徴期列 = (調定年度.equals(賦課年度)) ? 普徴Config.get月の期() : 過年度Config.get月の期();

        setDisplayMode(賦課年度, 普徴期列.length);

        setTableData(COL_NO_月, 月列, SUFFIX_月);
        setTableData(COL_NO_特徴期, 特徴期列, SUFFIX_期);
        setTableData(COL_NO_普徴期, 普徴期列, SUFFIX_期);

        setKiwarigaku(finder.get期割額(調定年度, 賦課年度, 通知書番号, 処理日時), createIndexMap(特徴期列), createIndexMap(普徴期列));
    }

    private Map<RString, Integer> createIndexMap(RString[] data) {
        Map<RString, Integer> map = new HashMap<>();
        for (int index = 0; index < data.length; index++) {
            if (map.get(data[index]) == null) {
                map.put(data[index], index);
            }
        }
        return map;
    }

    private void setDisplayMode(FlexibleYear 賦課年度, int 普徴期数) {

        FlexibleYear 納期統一年度 = new FlexibleYear(賦課計算Config.get納期統一年度());
        boolean is月列表示 = 納期統一年度.isBeforeOrEquals(賦課年度);
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

    private void setTableData(int itemNo, RString[] dataList, RString suffix) {
        for (int index = 0; index < dataList.length; index++) {
            RString data = dataList[index];
            期割額テーブル[itemNo][index].setText((data != null) ? new RStringBuilder(data).append(suffix).toRString() : RString.EMPTY);
        }
    }

    private void setTableData(int itemNo, Decimal[] dataList) {
        for (int index = 0; index < dataList.length; index++) {
            Decimal data = dataList[index];
            期割額テーブル[itemNo][index].setText((data != null) ? new RString(data.toString("#,##0")) : RString.EMPTY);
        }
    }

    private void setKiwarigaku(IItemList<Kiwarigaku> 期割額List, Map<RString, Integer> 特徴期IndexMap, Map<RString, Integer> 普徴期IndexMap) {

        Decimal[] 特徴期別額列 = new Decimal[TABLE_SIZE];
        Decimal[] 特徴納付額列 = new Decimal[TABLE_SIZE];
        Decimal[] 普徴期別額列 = new Decimal[TABLE_SIZE];
        Decimal[] 普徴納付額列 = new Decimal[TABLE_SIZE];
        int 合計Index = TABLE_SIZE - 1;

        特徴期別額列[合計Index] = Decimal.ZERO;
        特徴納付額列[合計Index] = Decimal.ZERO;
        普徴期別額列[合計Index] = Decimal.ZERO;
        普徴納付額列[合計Index] = Decimal.ZERO;

        for (Kiwarigaku 期割額 : 期割額List) {

            ChoshuHohoKibetsu 徴収方法 = ChoshuHohoKibetsu.toValue(期割額.get期別調定共通().get介護期別モデル().get徴収方法());
            RString 期 = new RString(String.format("%1$02d", 期割額.get期別調定共通().get介護期別モデル().get期()));
            Decimal 調定額 = 期割額.get期別調定共通().get調定共通モデル().get調定額();
            Decimal 収入額 = 期割額.get収入額();

            if (徴収方法 == ChoshuHohoKibetsu.特別徴収) {
                Integer 特徴期Index = 特徴期IndexMap.get(期);
                if (特徴期Index != null && 0 <= 特徴期Index && 特徴期Index < 合計Index) {
                    特徴期別額列[特徴期Index] = 調定額;
                    特徴納付額列[特徴期Index] = 収入額;
                    特徴期別額列[合計Index] = 特徴期別額列[合計Index].add(調定額);
                    特徴納付額列[合計Index] = 特徴納付額列[合計Index].add(収入額);
                }
            } else if (徴収方法 == ChoshuHohoKibetsu.普通徴収) {
                Integer 普徴期Index = 普徴期IndexMap.get(期);
                if (普徴期Index != null && 0 <= 普徴期Index && 普徴期Index < 合計Index) {
                    普徴期別額列[普徴期Index] = 調定額;
                    普徴納付額列[普徴期Index] = 収入額;
                    普徴期別額列[合計Index] = 普徴期別額列[合計Index].add(調定額);
                    普徴納付額列[合計Index] = 普徴納付額列[合計Index].add(収入額);
                }
            }
        }

        setTableData(COL_NO_特徴期別額, 特徴期別額列);
        setTableData(COL_NO_特徴納付額, 特徴納付額列);
        setTableData(COL_NO_普徴期別額, 普徴期別額列);
        setTableData(COL_NO_普徴納付額, 普徴納付額列);
    }

    private Label[][] getTable() {

        Label[][] table = {
            {
                div.getLblTsuki1(),
                div.getLblTsuki2(),
                div.getLblTsuki3(),
                div.getLblTsuki4(),
                div.getLblTsuki5(),
                div.getLblTsuki6(),
                div.getLblTsuki7(),
                div.getLblTsuki8(),
                div.getLblTsuki9(),
                div.getLblTsuki10(),
                div.getLblTsuki11(),
                div.getLblTsuki12(),
                div.getLblTsuki13(),
                div.getLblTsuki14(),
                div.getLblTsukiGokei()
            },
            {
                div.getLblTokuchoKi1(),
                div.getLblTokuchoKi2(),
                div.getLblTokuchoKi3(),
                div.getLblTokuchoKi4(),
                div.getLblTokuchoKi5(),
                div.getLblTokuchoKi6(),
                div.getLblTokuchoKi7(),
                div.getLblTokuchoKi8(),
                div.getLblTokuchoKi9(),
                div.getLblTokuchoKi10(),
                div.getLblTokuchoKi11(),
                div.getLblTokuchoKi12(),
                div.getLblTokuchoKi13(),
                div.getLblTokuchoKi14(),
                div.getLblTokuchoKiGokei()
            },
            {
                div.getLblTokuKibetsuGaku1(),
                div.getLblTokuKibetsuGaku2(),
                div.getLblTokuKibetsuGaku3(),
                div.getLblTokuKibetsuGaku4(),
                div.getLblTokuKibetsuGaku5(),
                div.getLblTokuKibetsuGaku6(),
                div.getLblTokuKibetsuGaku7(),
                div.getLblTokuKibetsuGaku8(),
                div.getLblTokuKibetsuGaku9(),
                div.getLblTokuKibetsuGaku10(),
                div.getLblTokuKibetsuGaku11(),
                div.getLblTokuKibetsuGaku12(),
                div.getLblTokuKibetsuGaku13(),
                div.getLblTokuKibetsuGaku14(),
                div.getLblTokuKibetsuGakuGokei()
            },
            {
                div.getLblTokuNofuGaku1(),
                div.getLblTokuNofuGaku2(),
                div.getLblTokuNofuGaku3(),
                div.getLblTokuNofuGaku4(),
                div.getLblTokuNofuGaku5(),
                div.getLblTokuNofuGaku6(),
                div.getLblTokuNofuGaku7(),
                div.getLblTokuNofuGaku8(),
                div.getLblTokuNofuGaku9(),
                div.getLblTokuNofuGaku10(),
                div.getLblTokuNofuGaku11(),
                div.getLblTokuNofuGaku12(),
                div.getLblTokuNofuGaku13(),
                div.getLblTokuNofuGaku14(),
                div.getLblTokuNofuGakuGokei()
            },
            {
                div.getLblFuchoKi1(),
                div.getLblFuchoKi2(),
                div.getLblFuchoKi3(),
                div.getLblFuchoKi4(),
                div.getLblFuchoKi5(),
                div.getLblFuchoKi6(),
                div.getLblFuchoKi7(),
                div.getLblFuchoKi8(),
                div.getLblFuchoKi9(),
                div.getLblFuchoKi10(),
                div.getLblFuchoKi11(),
                div.getLblFuchoKi12(),
                div.getLblFuchoKi13(),
                div.getLblFuchoKi14(),
                div.getLblFuchoKiGokei()
            },
            {
                div.getLblFuchoKibetsuGaku1(),
                div.getLblFuchoKibetsuGaku2(),
                div.getLblFuchoKibetsuGaku3(),
                div.getLblFuchoKibetsuGaku4(),
                div.getLblFuchoKibetsuGaku5(),
                div.getLblFuchoKibetsuGaku6(),
                div.getLblFuchoKibetsuGaku7(),
                div.getLblFuchoKibetsuGaku8(),
                div.getLblFuchoKibetsuGaku9(),
                div.getLblFuchoKibetsuGaku10(),
                div.getLblFuchoKibetsuGaku11(),
                div.getLblFuchoKibetsuGaku12(),
                div.getLblFuchoKibetsuGaku13(),
                div.getLblFuchoKibetsuGaku14(),
                div.getLblFuchoKibetsuGakuGokei()
            },
            {
                div.getLblFuchoNofuGaku1(),
                div.getLblFuchoNofuGaku2(),
                div.getLblFuchoNofuGaku3(),
                div.getLblFuchoNofuGaku4(),
                div.getLblFuchoNofuGaku5(),
                div.getLblFuchoNofuGaku6(),
                div.getLblFuchoNofuGaku7(),
                div.getLblFuchoNofuGaku8(),
                div.getLblFuchoNofuGaku9(),
                div.getLblFuchoNofuGaku10(),
                div.getLblFuchoNofuGaku11(),
                div.getLblFuchoNofuGaku12(),
                div.getLblFuchoNofuGaku13(),
                div.getLblFuchoNofuGaku14(),
                div.getLblFuchoNofuGakuGokei()
            }
        };

        return table;
    }
}
