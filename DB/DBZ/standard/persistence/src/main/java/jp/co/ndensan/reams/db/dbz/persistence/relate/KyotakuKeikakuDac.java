/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.model.relate.KyotakuKeikakuRelateModel;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
    public IItemList<KyotakuKeikakuRelateModel> select居宅計画履歴一覧By被保険者番号(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        IItemList<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出List = 居宅給付計画届出Dac.select居宅給付計画届出一覧By被保険者番号(被保険者番号);
        List<KyotakuKeikakuRelateModel> list = new ArrayList<>();

        for (DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出 : 居宅給付計画届出List) {
            list.add(createModel(居宅給付計画届出));
        }

        List<KyotakuKeikakuRelateModel> sortList = sort適用開始年月日(list);
        IItemList<KyotakuKeikakuRelateModel> 台帳リスト = ItemList.of(sortList);

        return 台帳リスト;
    }

    private List<KyotakuKeikakuRelateModel> sort適用開始年月日(List<KyotakuKeikakuRelateModel> list) {
        List<KyotakuKeikakuRelateModel> result = new ArrayList<>();
        Map<FlexibleDate, KyotakuKeikakuRelateModel> map = new HashMap();
        for (KyotakuKeikakuRelateModel model : list) {
            map.put(createMapKey(model), model);
        }

        List<Map.Entry<FlexibleDate, KyotakuKeikakuRelateModel>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, new Comparator<Map.Entry<FlexibleDate, KyotakuKeikakuRelateModel>>() {
            @Override
            public int compare(Map.Entry<FlexibleDate, KyotakuKeikakuRelateModel> o1, Map.Entry<FlexibleDate, KyotakuKeikakuRelateModel> o2) {
                return (o2.getKey()).compareTo(o1.getKey());
            }
        });

        for (Map.Entry<FlexibleDate, KyotakuKeikakuRelateModel> entry : entries) {
            result.add(entry.getValue());
        }
        return result;
    }

    private FlexibleDate createMapKey(KyotakuKeikakuRelateModel model) {
        if (model.get居宅給付計画事業者作成モデル().isPresent()) {
            return model.get居宅給付計画事業者作成モデル().get().getTekiyoKaishiYMD();
        } else if (model.get居宅給付計画自己作成モデル().isPresent()) {
            return model.get居宅給付計画自己作成モデル().get().getTekiyoKaishiYMD();
        }
        return FlexibleDate.MIN;
    }

    private Optional<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> select居宅給付計画事業者作成ByKey(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月, Decimal 履歴番号) {
        Optional<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> model = 居宅給付計画事業者作成Dac.select直近居宅給付計画事業者作成(被保険者番号,
                対象年月, 履歴番号);

        return model;
    }

    private Optional<DbT3007KyotakuKeikakuJikoSakuseiEntity> select居宅給付計画自己作成ByKey(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {
        Optional<DbT3007KyotakuKeikakuJikoSakuseiEntity> model = 居宅給付計画自己作成Dac.select直近居宅給付計画自己作成(被保険者番号,
                対象年月, 履歴番号);

        return model;
    }

    private KyotakuKeikakuRelateModel createModel(DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出Model) {
        if (居宅給付計画届出Model == null) {
            return null;
        }

        return new KyotakuKeikakuRelateModel(
                居宅給付計画届出Model,
                select居宅給付計画事業者作成ByKey(居宅給付計画届出Model.getHihokenshaNo(),
                        居宅給付計画届出Model.getTaishoYM(),
                        居宅給付計画届出Model.getRirekiNo()),
                select居宅給付計画自己作成ByKey(居宅給付計画届出Model.getHihokenshaNo(),
                        居宅給付計画届出Model.getTaishoYM(),
                        居宅給付計画届出Model.getRirekiNo()));
    }

}
