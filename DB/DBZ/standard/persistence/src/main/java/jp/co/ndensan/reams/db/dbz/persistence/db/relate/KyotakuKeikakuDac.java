/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画履歴のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class KyotakuKeikakuDac {

    private final KyotakuKeikakuTodokedeDac 居宅給付計画届出Dac = InstanceProvider.create(KyotakuKeikakuTodokedeDac.class);
    private final KyotakuKeikakuJigyoshaSakuseiDac 居宅給付計画事業者作成Dac = InstanceProvider.create(KyotakuKeikakuJigyoshaSakuseiDac.class);
    private final KyotakuKeikakuJikoSakuseiDac 居宅給付計画自己作成Dac = InstanceProvider.create(KyotakuKeikakuJikoSakuseiDac.class);

    /**
     * 被保険者番号に合致する居宅給付計画履歴のリストを返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<KyotakuKeikakuRelateModel>
     */
    @Transaction
    public IItemList<DbT3005KyotakuKeikakuTodokedeEntity> select居宅計画履歴一覧By被保険者番号(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        IItemList<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出List = 居宅給付計画届出Dac.select居宅給付計画届出一覧By被保険者番号(被保険者番号);
        //List<DbT3005KyotakuKeikakuTodokedeEntity> list = new ArrayList<>();

        List<DbT3005KyotakuKeikakuTodokedeEntity> sortList = sort適用開始年月日(居宅給付計画届出List);
        IItemList<DbT3005KyotakuKeikakuTodokedeEntity> 台帳リスト = ItemList.of(sortList);

        return 台帳リスト;
    }

    private List<DbT3005KyotakuKeikakuTodokedeEntity> sort適用開始年月日(IItemList<DbT3005KyotakuKeikakuTodokedeEntity> list) {
        List<DbT3005KyotakuKeikakuTodokedeEntity> result = new ArrayList<>();
        Map<FlexibleDate, DbT3005KyotakuKeikakuTodokedeEntity> map = new HashMap();

        List<Map.Entry<FlexibleDate, DbT3005KyotakuKeikakuTodokedeEntity>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<FlexibleDate, DbT3005KyotakuKeikakuTodokedeEntity>>() {
            @Override
            public int compare(Map.Entry<FlexibleDate, DbT3005KyotakuKeikakuTodokedeEntity> o1,
                    Map.Entry<FlexibleDate, DbT3005KyotakuKeikakuTodokedeEntity> o2) {
                return (o2.getKey()).compareTo(o1.getKey());
            }
        });

        for (Map.Entry<FlexibleDate, DbT3005KyotakuKeikakuTodokedeEntity> entry : entries) {
            result.add(entry.getValue());
        }
        return result;
    }

}
