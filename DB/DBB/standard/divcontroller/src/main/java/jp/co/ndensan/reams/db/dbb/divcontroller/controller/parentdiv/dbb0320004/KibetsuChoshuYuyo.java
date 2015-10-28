/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.parentdiv.dbb0320004;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.parentdiv.DBB0320004.ChoshuYuyoKikanDiv;
import jp.co.ndensan.reams.db.dbz.business.config.FuchoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.business.config.KanendoConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.ui.binding.Label;

/**
 * 期別徴収猶予Divのハンドラーです。
 *
 * @author N3317 塚田 萌
 */
public class KibetsuChoshuYuyo {

    private final ChoshuYuyoKikanDiv div;
//    private final IItemList<KibetsuChoshuYuyoModel> list;
    private final IItemList<Object> list;

    private enum TableItem {

        月, 期, 開始日, 終了日;
    };

    private Map<RString, Label> 期別テーブル = new HashMap<>();
    private static final int TABLE_SIZE = 14;

    private static final int ROWNO_3 = 3;
    private static final int ROWNO_4 = 4;
    private static final int ROWNO_5 = 5;
    private static final int ROWNO_6 = 6;
    private static final int ROWNO_7 = 7;
    private static final int ROWNO_8 = 8;
    private static final int ROWNO_9 = 9;
    private static final int ROWNO_10 = 10;
    private static final int ROWNO_11 = 11;
    private static final int ROWNO_12 = 12;
    private static final int ROWNO_13 = 13;
    private static final RString SUFFIX_月 = new RString("月");
    private static final RString SUFFIX_期 = new RString("期");

    private final HizukeConfig 日付Config;
    private final FuchoConfig 普徴Config;
    private final KanendoConfig 過年度Config;

    /**
     * コンストラクタです。
     *
     * @param div 期割額Div
     * @param list 期別徴収猶予モデルリスト
     */
    public KibetsuChoshuYuyo(ChoshuYuyoKikanDiv div, IItemList<Object> list) {
//    public KibetsuChoshuYuyo(ChoshuYuyoKikanDiv div, IItemList<KibetsuChoshuYuyoModel> list) {
        this.div = div;
        this.list = list;
        this.日付Config = new HizukeConfig();
        this.普徴Config = new FuchoConfig();
        this.過年度Config = new KanendoConfig();
        this.期別テーブル = Collections.unmodifiableMap(createTableMap());
    }

    /**
     * データをDivに設定します。
     */
    public void load() {

        List<RString> 月列 = 日付Config.get月別テーブル();
        List<RString> 期列 = (are調定年度and賦課年度SameAge(list.findFirst())) ? 普徴Config.get月の期() : 過年度Config.get月の期();

        setTableData(TableItem.月, 月列, SUFFIX_月);
        setTableData(TableItem.期, 期列, SUFFIX_期);

        setKibetsu(createIndexMap(期列));
    }

    private boolean are調定年度and賦課年度SameAge(Optional<Object> model) {
        return true;
    }
//    private boolean are調定年度and賦課年度SameAge(Optional<KibetsuChoshuYuyoModel> model) {
//        return model.get().get調定年度().value().equals(model.get().get賦課年度().value());
//    }

    private void setTableData(TableItem itemNo, List<RString> dataList, RString suffix) {
        for (int index = 0; index < dataList.size(); index++) {
            RString data = dataList.get(index);
            Label label = 期別テーブル.get(getTableKey(itemNo, index));
            label.setText((data != null) ? new RStringBuilder(data).append(suffix).toRString() : RString.EMPTY);
        }
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

    private void setKibetsu(Map<RString, Integer> 期IndexMap) {

        FlexibleDate[] 開始日 = new FlexibleDate[TABLE_SIZE];
        FlexibleDate[] 終了日 = new FlexibleDate[TABLE_SIZE];

//        for (KibetsuChoshuYuyoModel model : list) {
//
//            RString 期 = new RString(String.format("%1$02d", model.get期()));
//            Integer 期Index = 期IndexMap.get(期);
//
//            if (期Index != null && 0 <= 期Index && 期Index < TABLE_SIZE) {
//                開始日[期Index] = model.get徴収猶予開始年月日();
//                終了日[期Index] = model.get徴収猶予終了年月日();
//            }
//        }
        setTableData(TableItem.開始日, 開始日);
        setTableData(TableItem.終了日, 終了日);
    }

    private void setTableData(TableItem itemNo, FlexibleDate[] dataList) {
        for (int index = 0; index < dataList.length; index++) {
            FlexibleDate data = dataList[index];
            Label label = 期別テーブル.get(getTableKey(itemNo, index));
            label.setText((data != null) ? data.wareki().toDateString() : RString.EMPTY);
        }
    }

    private Map<RString, Label> createTableMap() {

        Map<RString, Label> map = new HashMap<>();

        map.put(getTableKey(TableItem.月, 0), div.getLblChoshuYuyoTsuki1());
        map.put(getTableKey(TableItem.月, 1), div.getLblChoshuYuyoTsuki2());
        map.put(getTableKey(TableItem.月, 2), div.getLblChoshuYuyoTsuki3());
        map.put(getTableKey(TableItem.月, ROWNO_3), div.getLblChoshuYuyoTsuki4());
        map.put(getTableKey(TableItem.月, ROWNO_4), div.getLblChoshuYuyoTsuki5());
        map.put(getTableKey(TableItem.月, ROWNO_5), div.getLblChoshuYuyoTsuki6());
        map.put(getTableKey(TableItem.月, ROWNO_6), div.getLblChoshuYuyoTsuki7());
        map.put(getTableKey(TableItem.月, ROWNO_7), div.getLblChoshuYuyoTsuki8());
        map.put(getTableKey(TableItem.月, ROWNO_8), div.getLblChoshuYuyoTsuki9());
        map.put(getTableKey(TableItem.月, ROWNO_9), div.getLblChoshuYuyoTsuki10());
        map.put(getTableKey(TableItem.月, ROWNO_10), div.getLblChoshuYuyoTsuki11());
        map.put(getTableKey(TableItem.月, ROWNO_11), div.getLblChoshuYuyoTsuki12());
        map.put(getTableKey(TableItem.月, ROWNO_12), div.getLblChoshuYuyoTsuki13());
        map.put(getTableKey(TableItem.月, ROWNO_13), div.getLblChoshuYuyoTsuki14());

        map.put(getTableKey(TableItem.期, 0), div.getLblChoshuYuyoKi1());
        map.put(getTableKey(TableItem.期, 1), div.getLblChoshuYuyoKi2());
        map.put(getTableKey(TableItem.期, 2), div.getLblChoshuYuyoKi3());
        map.put(getTableKey(TableItem.期, ROWNO_3), div.getLblChoshuYuyoKi4());
        map.put(getTableKey(TableItem.期, ROWNO_4), div.getLblChoshuYuyoKi5());
        map.put(getTableKey(TableItem.期, ROWNO_5), div.getLblChoshuYuyoKi6());
        map.put(getTableKey(TableItem.期, ROWNO_6), div.getLblChoshuYuyoKi7());
        map.put(getTableKey(TableItem.期, ROWNO_7), div.getLblChoshuYuyoKi8());
        map.put(getTableKey(TableItem.期, ROWNO_8), div.getLblChoshuYuyoKi9());
        map.put(getTableKey(TableItem.期, ROWNO_9), div.getLblChoshuYuyoKi10());
        map.put(getTableKey(TableItem.期, ROWNO_10), div.getLblChoshuYuyoKi11());
        map.put(getTableKey(TableItem.期, ROWNO_11), div.getLblChoshuYuyoKi12());
        map.put(getTableKey(TableItem.期, ROWNO_12), div.getLblChoshuYuyoKi13());
        map.put(getTableKey(TableItem.期, ROWNO_13), div.getLblChoshuYuyoKi14());

        map.put(getTableKey(TableItem.開始日, 0), div.getLblKaishiDate1());
        map.put(getTableKey(TableItem.開始日, 1), div.getLblKaishiDate2());
        map.put(getTableKey(TableItem.開始日, 2), div.getLblKaishiDate3());
        map.put(getTableKey(TableItem.開始日, ROWNO_3), div.getLblKaishiDate4());
        map.put(getTableKey(TableItem.開始日, ROWNO_4), div.getLblKaishiDate5());
        map.put(getTableKey(TableItem.開始日, ROWNO_5), div.getLblKaishiDate6());
        map.put(getTableKey(TableItem.開始日, ROWNO_6), div.getLblKaishiDate7());
        map.put(getTableKey(TableItem.開始日, ROWNO_7), div.getLblKaishiDate8());
        map.put(getTableKey(TableItem.開始日, ROWNO_8), div.getLblKaishiDate9());
        map.put(getTableKey(TableItem.開始日, ROWNO_9), div.getLblKaishiDate10());
        map.put(getTableKey(TableItem.開始日, ROWNO_10), div.getLblKaishiDate11());
        map.put(getTableKey(TableItem.開始日, ROWNO_11), div.getLblKaishiDate12());
        map.put(getTableKey(TableItem.開始日, ROWNO_12), div.getLblKaishiDate13());
        map.put(getTableKey(TableItem.開始日, ROWNO_13), div.getLblKaishiDate14());

        map.put(getTableKey(TableItem.終了日, 0), div.getLblShuryoDate1());
        map.put(getTableKey(TableItem.終了日, 1), div.getLblShuryoDate2());
        map.put(getTableKey(TableItem.終了日, 2), div.getLblShuryoDate3());
        map.put(getTableKey(TableItem.終了日, ROWNO_3), div.getLblShuryoDate4());
        map.put(getTableKey(TableItem.終了日, ROWNO_4), div.getLblShuryoDate5());
        map.put(getTableKey(TableItem.終了日, ROWNO_5), div.getLblShuryoDate6());
        map.put(getTableKey(TableItem.終了日, ROWNO_6), div.getLblShuryoDate7());
        map.put(getTableKey(TableItem.終了日, ROWNO_7), div.getLblShuryoDate8());
        map.put(getTableKey(TableItem.終了日, ROWNO_8), div.getLblShuryoDate9());
        map.put(getTableKey(TableItem.終了日, ROWNO_9), div.getLblShuryoDate10());
        map.put(getTableKey(TableItem.終了日, ROWNO_10), div.getLblShuryoDate11());
        map.put(getTableKey(TableItem.終了日, ROWNO_11), div.getLblShuryoDate12());
        map.put(getTableKey(TableItem.終了日, ROWNO_12), div.getLblShuryoDate13());
        map.put(getTableKey(TableItem.終了日, ROWNO_13), div.getLblShuryoDate14());

        return map;
    }

    private RString getTableKey(TableItem item, Integer rowNo) {
        return new RStringBuilder(item.toString()).append(rowNo.toString()).toRString();
    }
}
