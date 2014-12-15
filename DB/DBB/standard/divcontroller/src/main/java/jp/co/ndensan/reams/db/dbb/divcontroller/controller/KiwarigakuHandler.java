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

    private enum TableItem {

        月, 特徴期, 特徴期別額, 特徴納付額, 普徴期, 普徴期別額, 普徴納付額;
    };

    private final Map<RString, Label> 期割額テーブル = new HashMap<>();
    private TableItem tableItem;
    private int tableRowNo;

    private static final int TABLE_SIZE = 15;

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
        this.賦課計算Config = new FukaKeisanConfig();
        this.日付Config = new HizukeConfig();
        this.普徴Config = new FuchoConfig();
        this.特徴Config = new TokuchoConfig();
        this.過年度Config = new KanendoConfig();
        initTable();
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
        this.賦課計算Config = 賦課計算Config;
        this.日付Config = 日付Config;
        this.普徴Config = 普徴Config;
        this.特徴Config = 特徴Config;
        this.過年度Config = 過年度Config;
        initTable();
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

        setTableData(TableItem.月, 月列, SUFFIX_月);
        setTableData(TableItem.特徴期, 特徴期列, SUFFIX_期);
        setTableData(TableItem.普徴期, 普徴期列, SUFFIX_期);

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

    private void setTableData(TableItem itemNo, RString[] dataList, RString suffix) {
        for (int index = 0; index < dataList.length; index++) {
            RString data = dataList[index];
            Label label = 期割額テーブル.get(getTableKey(itemNo, index + 1));
            label.setText((data != null) ? new RStringBuilder(data).append(suffix).toRString() : RString.EMPTY);
        }
    }

    private void setTableData(TableItem itemNo, Decimal[] dataList) {
        for (int index = 0; index < dataList.length; index++) {
            Decimal data = dataList[index];
            Label label = 期割額テーブル.get(getTableKey(itemNo, index + 1));
            label.setText((data != null) ? new RString(data.toString("#,##0")) : RString.EMPTY);
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

        setTableData(TableItem.特徴期別額, 特徴期別額列);
        setTableData(TableItem.特徴納付額, 特徴納付額列);
        setTableData(TableItem.普徴期別額, 普徴期別額列);
        setTableData(TableItem.普徴納付額, 普徴納付額列);
    }

    private void initTable() {

        setTableItem(TableItem.月);
        putTableData(div.getLblTsuki1());
        putTableData(div.getLblTsuki2());
        putTableData(div.getLblTsuki3());
        putTableData(div.getLblTsuki4());
        putTableData(div.getLblTsuki5());
        putTableData(div.getLblTsuki6());
        putTableData(div.getLblTsuki7());
        putTableData(div.getLblTsuki8());
        putTableData(div.getLblTsuki9());
        putTableData(div.getLblTsuki10());
        putTableData(div.getLblTsuki11());
        putTableData(div.getLblTsuki12());
        putTableData(div.getLblTsuki13());
        putTableData(div.getLblTsuki14());
        putTableData(div.getLblTsukiGokei());

        setTableItem(TableItem.特徴期);
        putTableData(div.getLblTokuchoKi1());
        putTableData(div.getLblTokuchoKi2());
        putTableData(div.getLblTokuchoKi3());
        putTableData(div.getLblTokuchoKi4());
        putTableData(div.getLblTokuchoKi5());
        putTableData(div.getLblTokuchoKi6());
        putTableData(div.getLblTokuchoKi7());
        putTableData(div.getLblTokuchoKi8());
        putTableData(div.getLblTokuchoKi9());
        putTableData(div.getLblTokuchoKi10());
        putTableData(div.getLblTokuchoKi11());
        putTableData(div.getLblTokuchoKi12());
        putTableData(div.getLblTokuchoKi13());
        putTableData(div.getLblTokuchoKi14());
        putTableData(div.getLblTokuchoKiGokei());

        setTableItem(TableItem.特徴期別額);
        putTableData(div.getLblTokuKibetsuGaku1());
        putTableData(div.getLblTokuKibetsuGaku2());
        putTableData(div.getLblTokuKibetsuGaku3());
        putTableData(div.getLblTokuKibetsuGaku4());
        putTableData(div.getLblTokuKibetsuGaku5());
        putTableData(div.getLblTokuKibetsuGaku6());
        putTableData(div.getLblTokuKibetsuGaku7());
        putTableData(div.getLblTokuKibetsuGaku8());
        putTableData(div.getLblTokuKibetsuGaku9());
        putTableData(div.getLblTokuKibetsuGaku10());
        putTableData(div.getLblTokuKibetsuGaku11());
        putTableData(div.getLblTokuKibetsuGaku12());
        putTableData(div.getLblTokuKibetsuGaku13());
        putTableData(div.getLblTokuKibetsuGaku14());
        putTableData(div.getLblTokuKibetsuGakuGokei());

        setTableItem(TableItem.特徴納付額);
        putTableData(div.getLblTokuNofuGaku1());
        putTableData(div.getLblTokuNofuGaku2());
        putTableData(div.getLblTokuNofuGaku3());
        putTableData(div.getLblTokuNofuGaku4());
        putTableData(div.getLblTokuNofuGaku5());
        putTableData(div.getLblTokuNofuGaku6());
        putTableData(div.getLblTokuNofuGaku7());
        putTableData(div.getLblTokuNofuGaku8());
        putTableData(div.getLblTokuNofuGaku9());
        putTableData(div.getLblTokuNofuGaku10());
        putTableData(div.getLblTokuNofuGaku11());
        putTableData(div.getLblTokuNofuGaku12());
        putTableData(div.getLblTokuNofuGaku13());
        putTableData(div.getLblTokuNofuGaku14());
        putTableData(div.getLblTokuNofuGakuGokei());

        setTableItem(TableItem.普徴期);
        putTableData(div.getLblTokuNofuGaku1());
        putTableData(div.getLblTokuNofuGaku2());
        putTableData(div.getLblTokuNofuGaku3());
        putTableData(div.getLblTokuNofuGaku4());
        putTableData(div.getLblTokuNofuGaku5());
        putTableData(div.getLblTokuNofuGaku6());
        putTableData(div.getLblTokuNofuGaku7());
        putTableData(div.getLblTokuNofuGaku8());
        putTableData(div.getLblTokuNofuGaku9());
        putTableData(div.getLblTokuNofuGaku10());
        putTableData(div.getLblTokuNofuGaku11());
        putTableData(div.getLblTokuNofuGaku12());
        putTableData(div.getLblTokuNofuGaku13());
        putTableData(div.getLblTokuNofuGaku14());
        putTableData(div.getLblFuchoKiGokei());

        setTableItem(TableItem.普徴期別額);
        putTableData(div.getLblFuchoKibetsuGaku1());
        putTableData(div.getLblFuchoKibetsuGaku2());
        putTableData(div.getLblFuchoKibetsuGaku3());
        putTableData(div.getLblFuchoKibetsuGaku4());
        putTableData(div.getLblFuchoKibetsuGaku5());
        putTableData(div.getLblFuchoKibetsuGaku6());
        putTableData(div.getLblFuchoKibetsuGaku7());
        putTableData(div.getLblFuchoKibetsuGaku8());
        putTableData(div.getLblFuchoKibetsuGaku9());
        putTableData(div.getLblFuchoKibetsuGaku10());
        putTableData(div.getLblFuchoKibetsuGaku11());
        putTableData(div.getLblFuchoKibetsuGaku12());
        putTableData(div.getLblFuchoKibetsuGaku13());
        putTableData(div.getLblFuchoKibetsuGaku14());
        putTableData(div.getLblFuchoKibetsuGakuGokei());

        setTableItem(TableItem.普徴納付額);
        putTableData(div.getLblFuchoNofuGaku1());
        putTableData(div.getLblFuchoNofuGaku2());
        putTableData(div.getLblFuchoNofuGaku3());
        putTableData(div.getLblFuchoNofuGaku4());
        putTableData(div.getLblFuchoNofuGaku5());
        putTableData(div.getLblFuchoNofuGaku6());
        putTableData(div.getLblFuchoNofuGaku7());
        putTableData(div.getLblFuchoNofuGaku8());
        putTableData(div.getLblFuchoNofuGaku9());
        putTableData(div.getLblFuchoNofuGaku10());
        putTableData(div.getLblFuchoNofuGaku11());
        putTableData(div.getLblFuchoNofuGaku12());
        putTableData(div.getLblFuchoNofuGaku13());
        putTableData(div.getLblFuchoNofuGaku14());
        putTableData(div.getLblFuchoNofuGakuGokei());
    }

    private void setTableItem(TableItem item) {
        tableItem = item;
        tableRowNo = 1;
    }

    private void putTableData(Label label) {
        期割額テーブル.put(getTableKey(tableItem, tableRowNo), label);
        tableRowNo++;
    }

    private RString getTableKey(TableItem item, Integer rowNo) {
        return new RStringBuilder(item.toString()).append(rowNo.toString()).toRString();
    }
}
