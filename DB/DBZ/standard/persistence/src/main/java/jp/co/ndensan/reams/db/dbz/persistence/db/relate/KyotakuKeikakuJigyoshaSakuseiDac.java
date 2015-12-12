/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.relate;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.IItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.core.util.optional.Optional;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakusei;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3006KyotakuKeikakuJigyoshaSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3006KyotakuKeikakuJigyoshaSakuseiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画事業者作成のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class KyotakuKeikakuJigyoshaSakuseiDac implements IModifiable<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT3006KyotakuKeikakuJigyoshaSakuseiDac 居宅給付計画事業者作成Dac = InstanceProvider.create(DbT3006KyotakuKeikakuJigyoshaSakuseiDac.class);

    /**
     * 居宅給付計画事業者作成情報をキー検索で１件返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @return DbT3006KyotakuKeikakuJigyoshaSakuseiEntity
     */
    @Transaction
    public Optional<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> selectByKey(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        return Optional.ofNullable(createModel(居宅給付計画事業者作成Dac.selectByKey(被保険者番号, 対象年月, 履歴番号)));
    }

    /**
     * 居宅給付計画事業者作成を全件返します。
     *
     * @return JukyushaDaichoModel
     */
    @Transaction
    public IItemList<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> selectAll() {

        List<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成List = 居宅給付計画事業者作成Dac.selectAll();
        List<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> list = new ArrayList<>();

        for (DbT3006KyotakuKeikakuJigyoshaSakuseiEntity 居宅給付計画事業者作成 : 居宅給付計画事業者作成List) {
            list.add(createModel(居宅給付計画事業者作成));
        }
        IItemList<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 指定されたキーに合致する居宅給付計画事業者作成の直近の一件を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @return DbT3006KyotakuKeikakuJigyoshaSakuseiEntity
     */
    @Transaction
    public Optional<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> select直近居宅給付計画事業者作成(HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        List<DbT3006KyotakuKeikakuJigyoshaSakuseiEntity> 居宅給付計画事業者作成List = accessor.select().
                table(DbT3006KyotakuKeikakuJigyoshaSakusei.class).
                where(and(
                                eq(DbT3006KyotakuKeikakuJigyoshaSakusei.hihokenshano, 被保険者番号),
                                eq(DbT3006KyotakuKeikakuJigyoshaSakusei.taishoYM, 対象年月),
                                eq(DbT3006KyotakuKeikakuJigyoshaSakusei.rirekiNo, 履歴番号))).
                order(by(DbT3006KyotakuKeikakuJigyoshaSakusei.rirekiNo, Order.DESC)).
                toList(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity.class);

        if (居宅給付計画事業者作成List.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(createModel(居宅給付計画事業者作成List.get(0)));
    }

    private DbT3006KyotakuKeikakuJigyoshaSakuseiEntity createModel(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity 居宅給付計画事業者作成エンティティ) {
        if (居宅給付計画事業者作成エンティティ == null) {
            return null;
        }

        return new DbT3006KyotakuKeikakuJigyoshaSakuseiEntity();
    }

    @Override
    public int insert(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画事業者作成Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画事業者作成Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画事業者作成Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data DbT3006KyotakuKeikakuJigyoshaSakuseiEntity
     * @return int 件数
     */
    public int deletePhysical(DbT3006KyotakuKeikakuJigyoshaSakuseiEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画事業者作成Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
