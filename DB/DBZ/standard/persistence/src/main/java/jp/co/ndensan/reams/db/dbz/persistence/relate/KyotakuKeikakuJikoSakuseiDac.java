/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3007KyotakuKeikakuJikoSakusei;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.model.KyotakuKeikakuJikoSakuseiModel;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT3007KyotakuKeikakuJikoSakuseiDac;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画自己作成のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class KyotakuKeikakuJikoSakuseiDac implements IModifiable<KyotakuKeikakuJikoSakuseiModel> {

    @InjectSession
    private SqlSession session;
    private final DbT3007KyotakuKeikakuJikoSakuseiDac 居宅給付計画自己作成Dac = InstanceProvider.create(DbT3007KyotakuKeikakuJikoSakuseiDac.class);

    /**
     * 居宅給付計画自己作成情報をキー検索で１件返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 対象年月 対象年月
     * @param 処理日時 処理日時
     * @return KyotakuKeikakuJikoSakuseiModel
     */
    @Transaction
    public KyotakuKeikakuJikoSakuseiModel selectByKey(HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            FlexibleYearMonth 対象年月,
            YMDHMS 処理日時) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        return createModel(居宅給付計画自己作成Dac.selectByKey(被保険者番号, 証記載保険者番号,
                識別コード, 対象年月, 処理日時));
    }

    /**
     * 居宅給付計画自己作成を全件返します。
     *
     * @return IItemList<KyotakuKeikakuJikoSakuseiModel>
     */
    @Transaction
    public IItemList<KyotakuKeikakuJikoSakuseiModel> selectAll() {

        List<DbT3007KyotakuKeikakuJikoSakuseiEntity> 居宅給付計画自己作成List = 居宅給付計画自己作成Dac.selectAll();
        List<KyotakuKeikakuJikoSakuseiModel> list = new ArrayList<>();

        for (DbT3007KyotakuKeikakuJikoSakuseiEntity 居宅給付計画自己作成 : 居宅給付計画自己作成List) {
            list.add(createModel(居宅給付計画自己作成));
        }
        IItemList<KyotakuKeikakuJikoSakuseiModel> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 指定されたキーに合致する居宅給付計画自己作成の直近の一件を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 識別コード 識別コード
     * @param 対象年月 対象年月
     * @return KyotakuKeikakuJigyoshaSakuseiModel
     */
    @Transaction
    public KyotakuKeikakuJikoSakuseiModel select直近居宅給付計画自己作成ByKey(HihokenshaNo 被保険者番号,
            HokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            FlexibleYearMonth 対象年月) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT3007KyotakuKeikakuJikoSakuseiEntity> 居宅給付計画自己作成List = accessor.select().
                table(DbT3007KyotakuKeikakuJikoSakusei.class).
                where(and(
                                eq(DbT3007KyotakuKeikakuJikoSakusei.hihokenshaNo, 被保険者番号),
                                eq(DbT3007KyotakuKeikakuJikoSakusei.shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(DbT3007KyotakuKeikakuJikoSakusei.shikibetsuCode, 識別コード),
                                eq(DbT3007KyotakuKeikakuJikoSakusei.taishoYM, 対象年月))).
                order(by(DbT3007KyotakuKeikakuJikoSakusei.shoriTimestamp, Order.DESC)).
                toList(DbT3007KyotakuKeikakuJikoSakuseiEntity.class);

        if (居宅給付計画自己作成List.isEmpty()) {
            return null;
        }

        return createModel(居宅給付計画自己作成List.get(0));
    }

    private KyotakuKeikakuJikoSakuseiModel createModel(DbT3007KyotakuKeikakuJikoSakuseiEntity 居宅給付計画自己作成エンティティ) {
        if (居宅給付計画自己作成エンティティ == null) {
            return null;
        }

        return new KyotakuKeikakuJikoSakuseiModel(居宅給付計画自己作成エンティティ);
    }

    @Override
    public int insert(KyotakuKeikakuJikoSakuseiModel data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画自己作成Dac.insert(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(KyotakuKeikakuJikoSakuseiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画自己作成Dac.update(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(KyotakuKeikakuJikoSakuseiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画自己作成Dac.delete(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    public int deletePhysical(KyotakuKeikakuJikoSakuseiModel data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画自己作成Dac.deletePhysical(data.getEntity());

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
