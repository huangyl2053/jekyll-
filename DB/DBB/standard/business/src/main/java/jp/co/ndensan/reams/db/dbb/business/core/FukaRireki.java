/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.Fuka;
import jp.co.ndensan.reams.db.dbb.business.core.basic.FukaComparators;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ChoteiNendo;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.FukaNendo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 賦課履歴を扱うクラスです。
 *
 * @author N8156 宮本 康
 */
public class FukaRireki implements Iterable<Fuka> {

    public static FukaRireki EMPTY;

    static {
        EMPTY = new FukaRireki(Collections.<Fuka>emptyList());
    }

    private final List<Fuka> 賦課履歴明細;

    /**
     * コンストラクタです。
     *
     * @param 賦課履歴明細 賦課履歴明細
     * @throws NullPointerException 引数がnullの場合
     */
    public FukaRireki(List<Fuka> 賦課履歴明細) throws NullPointerException {
        this.賦課履歴明細 = new ArrayList<>(requireNonNull(賦課履歴明細, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課履歴明細")));
    }

    /**
     * 賦課年度、調定年度、通知書番号でグループ化した賦課履歴を全て返します。<br />
     * グループ化した際に処理日時が最新となる履歴を返却対象とします。
     *
     * @return グループ化した全賦課履歴
     */
    public IItemList<Fuka> getグループ化賦課履歴() {
        Map<RString, Fuka> map = new HashMap<>();
        for (Fuka model : 賦課履歴明細) {
            RString key = createKey(model);
            Fuka value = map.get(key);
            if (value == null || value.get履歴番号() < model.get履歴番号()) {
                map.put(key, model);
            }
        }
        return sort(new ArrayList<>(map.values()));
    }

    private RString createKey(Fuka model) {
        return new RStringBuilder(model.get賦課年度().toDateString())
                .append(model.get調定年度().toDateString())
                .append(model.get通知書番号()).toRString();
    }

    private IItemList<Fuka> sort(List<Fuka> list) {
        return ItemList.of(list)
                .sorted(FukaComparators.orderBy通知書番号.desc())
                .sorted(FukaComparators.orderBy調定年度.desc())
                .sorted(FukaComparators.orderBy賦課年度.desc());
    }

    /**
     * 賦課年度、調定年度、通知書番号でグループ化する前の賦課履歴を全て返します。
     *
     * @return グループ化する前の全賦課履歴
     */
    public IItemList<Fuka> get賦課履歴All() {
        return sort(賦課履歴明細);
    }

    /**
     * 保持する履歴が空の場合、{@code true}を返します。
     *
     * @return 履歴
     */
    public boolean isEmpty() {
        return this.賦課履歴明細.isEmpty();
    }

    /**
     * 賦課年度、調定年度、通知書番号でグループ化する前の賦課履歴の中で、条件に該当する履歴を返します。
     *
     * @param 賦課年度 賦課年度
     * @param 調定年度 調定年度
     * @param 通知書番号 通知書番号
     * @return グループ化する前の条件に該当する賦課履歴
     */
    public IItemList<Fuka> get賦課履歴(FukaNendo 賦課年度, ChoteiNendo 調定年度, TsuchishoNo 通知書番号) {
        List<Fuka> list = new ArrayList<>();
        for (Fuka model : 賦課履歴明細) {
            if (model.get賦課年度().equals(賦課年度.value()) && model.get調定年度().equals(調定年度.value()) && model.get通知書番号().equals(通知書番号)) {
                list.add(model);
            }
        }
        return ItemList.of(list);
    }

    /**
     * 賦課年度、調定年度、通知書番号、履歴番号に一致する履歴を返します。
     *
     * @param 賦課年度 賦課年度
     * @param 調定年度 調定年度
     * @param 通知書番号 通知書番号
     * @param 履歴番号 履歴番号
     * @return 賦課年度、調定年度、通知書番号、履歴番号に一致する賦課履歴
     */
    public Optional<Fuka> get賦課履歴(FukaNendo 賦課年度, ChoteiNendo 調定年度, TsuchishoNo 通知書番号, int 履歴番号) {
        for (Fuka model : 賦課履歴明細) {
            if (model.get賦課年度().equals(賦課年度.value())
                && model.get調定年度().equals(調定年度.value())
                && model.get通知書番号().equals(通知書番号)
                && model.get履歴番号() == 履歴番号) {
                return Optional.of(model);
            }
        }
        return Optional.empty();
    }

    @Override
    public Iterator<Fuka> iterator() {
        return this.賦課履歴明細.iterator();
    }
}
