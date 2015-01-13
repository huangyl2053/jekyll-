/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.divcontroller.controller.dbb0320004;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbz.business.config.FuchoConfig;
import jp.co.ndensan.reams.db.dbz.business.config.HizukeConfig;
import jp.co.ndensan.reams.db.dbz.business.config.KanendoConfig;
import jp.co.ndensan.reams.db.dbb.divcontroller.entity.DBB0320004.ChoshuYuyoKikanDiv;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.IOptional;
import jp.co.ndensan.reams.db.dbz.model.fuka.KibetsuChoshuYuyoModel;
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
    private final IItemList<KibetsuChoshuYuyoModel> list;

    private enum TableItem {

        月, 期, 開始日, 終了日;
    };

    private Map<RString, Label> 期別テーブル = new HashMap<>();
    private static final int TABLE_SIZE = 14;

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
    public KibetsuChoshuYuyo(ChoshuYuyoKikanDiv div, IItemList<KibetsuChoshuYuyoModel> list) {
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

    private boolean are調定年度and賦課年度SameAge(IOptional<KibetsuChoshuYuyoModel> model) {
        return model.get().get調定年度().value().equals(model.get().get賦課年度().value());
    }

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

        for (KibetsuChoshuYuyoModel model : list) {

            RString 期 = new RString(String.format("%1$02d", model.get期()));
            Integer 期Index = 期IndexMap.get(期);

            if (期Index != null && 0 <= 期Index && 期Index < TABLE_SIZE) {
                開始日[期Index] = model.get徴収猶予開始年月日();
                終了日[期Index] = model.get徴収猶予終了年月日();
            }
        }
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
        map.put(getTableKey(TableItem.月, 3), div.getLblChoshuYuyoTsuki4());
        map.put(getTableKey(TableItem.月, 4), div.getLblChoshuYuyoTsuki5());
        map.put(getTableKey(TableItem.月, 5), div.getLblChoshuYuyoTsuki6());
        map.put(getTableKey(TableItem.月, 6), div.getLblChoshuYuyoTsuki7());
        map.put(getTableKey(TableItem.月, 7), div.getLblChoshuYuyoTsuki8());
        map.put(getTableKey(TableItem.月, 8), div.getLblChoshuYuyoTsuki9());
        map.put(getTableKey(TableItem.月, 9), div.getLblChoshuYuyoTsuki10());
        map.put(getTableKey(TableItem.月, 10), div.getLblChoshuYuyoTsuki11());
        map.put(getTableKey(TableItem.月, 11), div.getLblChoshuYuyoTsuki12());
        map.put(getTableKey(TableItem.月, 12), div.getLblChoshuYuyoTsuki13());
        map.put(getTableKey(TableItem.月, 13), div.getLblChoshuYuyoTsuki14());

        map.put(getTableKey(TableItem.期, 0), div.getLblChoshuYuyoKi1());
        map.put(getTableKey(TableItem.期, 1), div.getLblChoshuYuyoKi2());
        map.put(getTableKey(TableItem.期, 2), div.getLblChoshuYuyoKi3());
        map.put(getTableKey(TableItem.期, 3), div.getLblChoshuYuyoKi4());
        map.put(getTableKey(TableItem.期, 4), div.getLblChoshuYuyoKi5());
        map.put(getTableKey(TableItem.期, 5), div.getLblChoshuYuyoKi6());
        map.put(getTableKey(TableItem.期, 6), div.getLblChoshuYuyoKi7());
        map.put(getTableKey(TableItem.期, 7), div.getLblChoshuYuyoKi8());
        map.put(getTableKey(TableItem.期, 8), div.getLblChoshuYuyoKi9());
        map.put(getTableKey(TableItem.期, 9), div.getLblChoshuYuyoKi10());
        map.put(getTableKey(TableItem.期, 10), div.getLblChoshuYuyoKi11());
        map.put(getTableKey(TableItem.期, 11), div.getLblChoshuYuyoKi12());
        map.put(getTableKey(TableItem.期, 12), div.getLblChoshuYuyoKi13());
        map.put(getTableKey(TableItem.期, 13), div.getLblChoshuYuyoKi14());

        map.put(getTableKey(TableItem.開始日, 0), div.getLblKaishiDate1());
        map.put(getTableKey(TableItem.開始日, 1), div.getLblKaishiDate2());
        map.put(getTableKey(TableItem.開始日, 2), div.getLblKaishiDate3());
        map.put(getTableKey(TableItem.開始日, 3), div.getLblKaishiDate4());
        map.put(getTableKey(TableItem.開始日, 4), div.getLblKaishiDate5());
        map.put(getTableKey(TableItem.開始日, 5), div.getLblKaishiDate6());
        map.put(getTableKey(TableItem.開始日, 6), div.getLblKaishiDate7());
        map.put(getTableKey(TableItem.開始日, 7), div.getLblKaishiDate8());
        map.put(getTableKey(TableItem.開始日, 8), div.getLblKaishiDate9());
        map.put(getTableKey(TableItem.開始日, 9), div.getLblKaishiDate10());
        map.put(getTableKey(TableItem.開始日, 10), div.getLblKaishiDate11());
        map.put(getTableKey(TableItem.開始日, 11), div.getLblKaishiDate12());
        map.put(getTableKey(TableItem.開始日, 12), div.getLblKaishiDate13());
        map.put(getTableKey(TableItem.開始日, 13), div.getLblKaishiDate14());

        map.put(getTableKey(TableItem.終了日, 0), div.getLblShuryoDate1());
        map.put(getTableKey(TableItem.終了日, 1), div.getLblShuryoDate2());
        map.put(getTableKey(TableItem.終了日, 2), div.getLblShuryoDate3());
        map.put(getTableKey(TableItem.終了日, 3), div.getLblShuryoDate4());
        map.put(getTableKey(TableItem.終了日, 4), div.getLblShuryoDate5());
        map.put(getTableKey(TableItem.終了日, 5), div.getLblShuryoDate6());
        map.put(getTableKey(TableItem.終了日, 6), div.getLblShuryoDate7());
        map.put(getTableKey(TableItem.終了日, 7), div.getLblShuryoDate8());
        map.put(getTableKey(TableItem.終了日, 8), div.getLblShuryoDate9());
        map.put(getTableKey(TableItem.終了日, 9), div.getLblShuryoDate10());
        map.put(getTableKey(TableItem.終了日, 10), div.getLblShuryoDate11());
        map.put(getTableKey(TableItem.終了日, 11), div.getLblShuryoDate12());
        map.put(getTableKey(TableItem.終了日, 12), div.getLblShuryoDate13());
        map.put(getTableKey(TableItem.終了日, 13), div.getLblShuryoDate14());

        return map;
    }

    private RString getTableKey(TableItem item, Integer rowNo) {
        return new RStringBuilder(item.toString()).append(rowNo.toString()).toRString();
    }
}
