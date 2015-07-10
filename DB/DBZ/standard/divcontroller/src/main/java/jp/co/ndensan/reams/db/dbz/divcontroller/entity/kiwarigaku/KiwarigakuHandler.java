/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.divcontroller.entity.kiwarigaku;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.Kiwarigaku;
import jp.co.ndensan.reams.db.dbz.business.config.FuchoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.FukaKeisanConfig;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.business.config.KanendoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.TokuchoConfig;
import jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.fuka.ChoshuHohoKibetsu;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.model.fuka.KiwarigakuMeisai;
import jp.co.ndensan.reams.db.dbz.realservice.KiwarigakuFinder;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
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

    private Map<RString, Label> 期割額テーブル = new HashMap<>();
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
        this.期割額テーブル = Collections.unmodifiableMap(createTableMap());
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
        this.期割額テーブル = Collections.unmodifiableMap(createTableMap());
    }

    /**
     * 引数に該当するデータをDivに設定します。
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 通知書番号 通知書番号
     * @param 処理日時 処理日時
     */
    public void load(ChoteiNendo 調定年度, FukaNendo 賦課年度, TsuchishoNo 通知書番号, RDateTime 処理日時) {

        List<RString> 月列 = 日付Config.get月別テーブル();
        List<RString> 特徴期列 = 特徴Config.get月の期();
        List<RString> 普徴期列 = (調定年度.value().equals(賦課年度.value())) ? 普徴Config.get月の期() : 過年度Config.get月の期();

        setDisplayMode(賦課年度, 普徴期列.size());

        setTableData(TableItem.月, 月列, SUFFIX_月);
        setTableData(TableItem.特徴期, 特徴期列, SUFFIX_期);
        setTableData(TableItem.普徴期, 普徴期列, SUFFIX_期);

        setKiwarigaku(finder.load期割額(調定年度, 賦課年度, 通知書番号, 処理日時).get(), createIndexMap(特徴期列), createIndexMap(普徴期列));
    }

    private Map<RString, Integer> createIndexMap(List<RString> data) {
        Map<RString, Integer> map = new HashMap<>();
        for (int index = 0; index < data.size(); index++) {
            if (map.get(data.get(index)) == null) {
                map.put(data.get(index), index);
            }
        }
        return map;
    }

    private void setDisplayMode(FukaNendo 賦課年度, int 普徴期数) {

        FlexibleYear 納期統一年度 = new FlexibleYear(賦課計算Config.get納期統一年度());
        boolean is月列表示 = 納期統一年度.isBeforeOrEquals(賦課年度.value());
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

    private void setTableData(TableItem itemNo, List<RString> dataList, RString suffix) {
        for (int index = 0; index < dataList.size(); index++) {
            RString data = dataList.get(index);
            Label label = 期割額テーブル.get(getTableKey(itemNo, index));
            label.setText((data != null) ? new RStringBuilder(data).append(suffix).toRString() : RString.EMPTY);
        }
    }

    private void setTableData(TableItem itemNo, Decimal[] dataList) {
        for (int index = 0; index < dataList.length; index++) {
            Decimal data = dataList[index];
            Label label = 期割額テーブル.get(getTableKey(itemNo, index));
            label.setText((data != null) ? new RString(data.toString("#,##0")) : RString.EMPTY);
        }
    }

    private void setKiwarigaku(Kiwarigaku 期割額, Map<RString, Integer> 特徴期IndexMap, Map<RString, Integer> 普徴期IndexMap) {

        Decimal[] 特徴期別額列 = new Decimal[TABLE_SIZE];
        Decimal[] 特徴納付額列 = new Decimal[TABLE_SIZE];
        Decimal[] 普徴期別額列 = new Decimal[TABLE_SIZE];
        Decimal[] 普徴納付額列 = new Decimal[TABLE_SIZE];
        int 合計Index = TABLE_SIZE - 1;

        for (KiwarigakuMeisai 明細 : 期割額.get期割額明細()) {

            ChoshuHohoKibetsu 徴収方法 = 明細.get期別調定共通().get介護期別モデル().get徴収方法();
//            RString 期 = new RString(String.format("%1$02d", 明細.get期別調定共通().get介護期別モデル().get期()));
            RString 期 = new RString(String.valueOf(明細.get期別調定共通().get介護期別モデル().get期()));
            Decimal 調定額 = 明細.get期別調定共通().get調定共通モデル().get調定額();
            Decimal 収入額 = 明細.get収入額();

            if (徴収方法 == ChoshuHohoKibetsu.特別徴収) {
                Integer 特徴期Index = 特徴期IndexMap.get(期);
                if (特徴期Index != null && 0 <= 特徴期Index && 特徴期Index < 合計Index) {
                    特徴期別額列[特徴期Index] = 調定額;
                    特徴納付額列[特徴期Index] = 収入額;
                }
            } else if (徴収方法 == ChoshuHohoKibetsu.普通徴収) {
                Integer 普徴期Index = 普徴期IndexMap.get(期);
                if (普徴期Index != null && 0 <= 普徴期Index && 普徴期Index < 合計Index) {
                    普徴期別額列[普徴期Index] = 調定額;
                    普徴納付額列[普徴期Index] = 収入額;
                }
            }
        }

        特徴期別額列[合計Index] = 期割額.get特徴期別額合計();
        特徴納付額列[合計Index] = 期割額.get特徴納付額合計();
        普徴期別額列[合計Index] = 期割額.get普徴期別額合計();
        普徴納付額列[合計Index] = 期割額.get普徴納付額合計();

        setTableData(TableItem.特徴期別額, 特徴期別額列);
        setTableData(TableItem.特徴納付額, 特徴納付額列);
        setTableData(TableItem.普徴期別額, 普徴期別額列);
        setTableData(TableItem.普徴納付額, 普徴納付額列);
    }

    private Map<RString, Label> createTableMap() {

        Map<RString, Label> map = new HashMap<>();

        map.put(getTableKey(TableItem.月, 0), div.getLblTsuki1());
        map.put(getTableKey(TableItem.月, 1), div.getLblTsuki2());
        map.put(getTableKey(TableItem.月, 2), div.getLblTsuki3());
        map.put(getTableKey(TableItem.月, 3), div.getLblTsuki4());
        map.put(getTableKey(TableItem.月, 4), div.getLblTsuki5());
        map.put(getTableKey(TableItem.月, 5), div.getLblTsuki6());
        map.put(getTableKey(TableItem.月, 6), div.getLblTsuki7());
        map.put(getTableKey(TableItem.月, 7), div.getLblTsuki8());
        map.put(getTableKey(TableItem.月, 8), div.getLblTsuki9());
        map.put(getTableKey(TableItem.月, 9), div.getLblTsuki10());
        map.put(getTableKey(TableItem.月, 10), div.getLblTsuki11());
        map.put(getTableKey(TableItem.月, 11), div.getLblTsuki12());
        map.put(getTableKey(TableItem.月, 12), div.getLblTsuki13());
        map.put(getTableKey(TableItem.月, 13), div.getLblTsuki14());
        map.put(getTableKey(TableItem.月, 14), div.getLblTsukiGokei());

        map.put(getTableKey(TableItem.特徴期, 0), div.getLblTokuchoKi1());
        map.put(getTableKey(TableItem.特徴期, 1), div.getLblTokuchoKi2());
        map.put(getTableKey(TableItem.特徴期, 2), div.getLblTokuchoKi3());
        map.put(getTableKey(TableItem.特徴期, 3), div.getLblTokuchoKi4());
        map.put(getTableKey(TableItem.特徴期, 4), div.getLblTokuchoKi5());
        map.put(getTableKey(TableItem.特徴期, 5), div.getLblTokuchoKi6());
        map.put(getTableKey(TableItem.特徴期, 6), div.getLblTokuchoKi7());
        map.put(getTableKey(TableItem.特徴期, 7), div.getLblTokuchoKi8());
        map.put(getTableKey(TableItem.特徴期, 8), div.getLblTokuchoKi9());
        map.put(getTableKey(TableItem.特徴期, 9), div.getLblTokuchoKi10());
        map.put(getTableKey(TableItem.特徴期, 10), div.getLblTokuchoKi11());
        map.put(getTableKey(TableItem.特徴期, 11), div.getLblTokuchoKi12());
        map.put(getTableKey(TableItem.特徴期, 12), div.getLblTokuchoKi13());
        map.put(getTableKey(TableItem.特徴期, 13), div.getLblTokuchoKi14());
        map.put(getTableKey(TableItem.特徴期, 14), div.getLblTokuchoKiGokei());

        map.put(getTableKey(TableItem.特徴期別額, 0), div.getLblTokuKibetsuGaku1());
        map.put(getTableKey(TableItem.特徴期別額, 1), div.getLblTokuKibetsuGaku2());
        map.put(getTableKey(TableItem.特徴期別額, 2), div.getLblTokuKibetsuGaku3());
        map.put(getTableKey(TableItem.特徴期別額, 3), div.getLblTokuKibetsuGaku4());
        map.put(getTableKey(TableItem.特徴期別額, 4), div.getLblTokuKibetsuGaku5());
        map.put(getTableKey(TableItem.特徴期別額, 5), div.getLblTokuKibetsuGaku6());
        map.put(getTableKey(TableItem.特徴期別額, 6), div.getLblTokuKibetsuGaku7());
        map.put(getTableKey(TableItem.特徴期別額, 7), div.getLblTokuKibetsuGaku8());
        map.put(getTableKey(TableItem.特徴期別額, 8), div.getLblTokuKibetsuGaku9());
        map.put(getTableKey(TableItem.特徴期別額, 9), div.getLblTokuKibetsuGaku10());
        map.put(getTableKey(TableItem.特徴期別額, 10), div.getLblTokuKibetsuGaku11());
        map.put(getTableKey(TableItem.特徴期別額, 11), div.getLblTokuKibetsuGaku12());
        map.put(getTableKey(TableItem.特徴期別額, 12), div.getLblTokuKibetsuGaku13());
        map.put(getTableKey(TableItem.特徴期別額, 13), div.getLblTokuKibetsuGaku14());
        map.put(getTableKey(TableItem.特徴期別額, 14), div.getLblTokuKibetsuGakuGokei());

        map.put(getTableKey(TableItem.特徴納付額, 0), div.getLblTokuNofuGaku1());
        map.put(getTableKey(TableItem.特徴納付額, 1), div.getLblTokuNofuGaku2());
        map.put(getTableKey(TableItem.特徴納付額, 2), div.getLblTokuNofuGaku3());
        map.put(getTableKey(TableItem.特徴納付額, 3), div.getLblTokuNofuGaku4());
        map.put(getTableKey(TableItem.特徴納付額, 4), div.getLblTokuNofuGaku5());
        map.put(getTableKey(TableItem.特徴納付額, 5), div.getLblTokuNofuGaku6());
        map.put(getTableKey(TableItem.特徴納付額, 6), div.getLblTokuNofuGaku7());
        map.put(getTableKey(TableItem.特徴納付額, 7), div.getLblTokuNofuGaku8());
        map.put(getTableKey(TableItem.特徴納付額, 8), div.getLblTokuNofuGaku9());
        map.put(getTableKey(TableItem.特徴納付額, 9), div.getLblTokuNofuGaku10());
        map.put(getTableKey(TableItem.特徴納付額, 10), div.getLblTokuNofuGaku11());
        map.put(getTableKey(TableItem.特徴納付額, 11), div.getLblTokuNofuGaku12());
        map.put(getTableKey(TableItem.特徴納付額, 12), div.getLblTokuNofuGaku13());
        map.put(getTableKey(TableItem.特徴納付額, 13), div.getLblTokuNofuGaku14());
        map.put(getTableKey(TableItem.特徴納付額, 14), div.getLblTokuNofuGakuGokei());

        map.put(getTableKey(TableItem.普徴期, 0), div.getLblTokuNofuGaku1());
        map.put(getTableKey(TableItem.普徴期, 1), div.getLblTokuNofuGaku2());
        map.put(getTableKey(TableItem.普徴期, 2), div.getLblTokuNofuGaku3());
        map.put(getTableKey(TableItem.普徴期, 3), div.getLblTokuNofuGaku4());
        map.put(getTableKey(TableItem.普徴期, 4), div.getLblTokuNofuGaku5());
        map.put(getTableKey(TableItem.普徴期, 5), div.getLblTokuNofuGaku6());
        map.put(getTableKey(TableItem.普徴期, 6), div.getLblTokuNofuGaku7());
        map.put(getTableKey(TableItem.普徴期, 7), div.getLblTokuNofuGaku8());
        map.put(getTableKey(TableItem.普徴期, 8), div.getLblTokuNofuGaku9());
        map.put(getTableKey(TableItem.普徴期, 9), div.getLblTokuNofuGaku10());
        map.put(getTableKey(TableItem.普徴期, 10), div.getLblTokuNofuGaku11());
        map.put(getTableKey(TableItem.普徴期, 11), div.getLblTokuNofuGaku12());
        map.put(getTableKey(TableItem.普徴期, 12), div.getLblTokuNofuGaku13());
        map.put(getTableKey(TableItem.普徴期, 13), div.getLblTokuNofuGaku14());
        map.put(getTableKey(TableItem.普徴期, 14), div.getLblTokuNofuGakuGokei());

        map.put(getTableKey(TableItem.普徴期別額, 0), div.getLblFuchoKibetsuGaku1());
        map.put(getTableKey(TableItem.普徴期別額, 1), div.getLblFuchoKibetsuGaku2());
        map.put(getTableKey(TableItem.普徴期別額, 2), div.getLblFuchoKibetsuGaku3());
        map.put(getTableKey(TableItem.普徴期別額, 3), div.getLblFuchoKibetsuGaku4());
        map.put(getTableKey(TableItem.普徴期別額, 4), div.getLblFuchoKibetsuGaku5());
        map.put(getTableKey(TableItem.普徴期別額, 5), div.getLblFuchoKibetsuGaku6());
        map.put(getTableKey(TableItem.普徴期別額, 6), div.getLblFuchoKibetsuGaku7());
        map.put(getTableKey(TableItem.普徴期別額, 7), div.getLblFuchoKibetsuGaku8());
        map.put(getTableKey(TableItem.普徴期別額, 8), div.getLblFuchoKibetsuGaku9());
        map.put(getTableKey(TableItem.普徴期別額, 9), div.getLblFuchoKibetsuGaku10());
        map.put(getTableKey(TableItem.普徴期別額, 10), div.getLblFuchoKibetsuGaku11());
        map.put(getTableKey(TableItem.普徴期別額, 11), div.getLblFuchoKibetsuGaku12());
        map.put(getTableKey(TableItem.普徴期別額, 12), div.getLblFuchoKibetsuGaku13());
        map.put(getTableKey(TableItem.普徴期別額, 13), div.getLblFuchoKibetsuGaku14());
        map.put(getTableKey(TableItem.普徴期別額, 14), div.getLblFuchoKibetsuGakuGokei());

        map.put(getTableKey(TableItem.普徴納付額, 0), div.getLblFuchoNofuGaku1());
        map.put(getTableKey(TableItem.普徴納付額, 1), div.getLblFuchoNofuGaku2());
        map.put(getTableKey(TableItem.普徴納付額, 2), div.getLblFuchoNofuGaku3());
        map.put(getTableKey(TableItem.普徴納付額, 3), div.getLblFuchoNofuGaku4());
        map.put(getTableKey(TableItem.普徴納付額, 4), div.getLblFuchoNofuGaku5());
        map.put(getTableKey(TableItem.普徴納付額, 5), div.getLblFuchoNofuGaku6());
        map.put(getTableKey(TableItem.普徴納付額, 6), div.getLblFuchoNofuGaku7());
        map.put(getTableKey(TableItem.普徴納付額, 7), div.getLblFuchoNofuGaku8());
        map.put(getTableKey(TableItem.普徴納付額, 8), div.getLblFuchoNofuGaku9());
        map.put(getTableKey(TableItem.普徴納付額, 9), div.getLblFuchoNofuGaku10());
        map.put(getTableKey(TableItem.普徴納付額, 10), div.getLblFuchoNofuGaku11());
        map.put(getTableKey(TableItem.普徴納付額, 11), div.getLblFuchoNofuGaku12());
        map.put(getTableKey(TableItem.普徴納付額, 12), div.getLblFuchoNofuGaku13());
        map.put(getTableKey(TableItem.普徴納付額, 13), div.getLblFuchoNofuGaku14());
        map.put(getTableKey(TableItem.普徴納付額, 14), div.getLblFuchoNofuGakuGokei());

        return map;
    }

    private RString getTableKey(TableItem item, Integer rowNo) {
        return new RStringBuilder(item.toString()).append(rowNo.toString()).toRString();
    }
}
