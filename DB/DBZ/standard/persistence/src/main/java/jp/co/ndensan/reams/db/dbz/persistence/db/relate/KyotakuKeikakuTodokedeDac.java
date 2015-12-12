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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokede;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku.DbT3005KyotakuKeikakuTodokedeEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3005KyotakuKeikakuTodokedeDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画届出のデータアクセスクラスです。
 *
 * @author n8187 久保田 英男
 */
public class KyotakuKeikakuTodokedeDac implements IModifiable<DbT3005KyotakuKeikakuTodokedeEntity> {

    @InjectSession
    private SqlSession session;
    private final DbT3005KyotakuKeikakuTodokedeDac 居宅給付計画届出Dac = InstanceProvider.create(DbT3005KyotakuKeikakuTodokedeDac.class);

    /**
     * 居宅給付計画届出情報をキー検索で１件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @return DbT3005KyotakuKeikakuTodokedeEntity
     */
    @Transaction
    public Optional<DbT3005KyotakuKeikakuTodokedeEntity> selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        return Optional.ofNullable(createModel(居宅給付計画届出Dac.selectByKey(被保険者番号, 対象年月, 履歴番号)));
    }

    /**
     * 居宅給付計画届出情報を全件返します。
     *
     * @return IItemList<DbT3005KyotakuKeikakuTodokedeEntity>
     */
    @Transaction
    public IItemList<DbT3005KyotakuKeikakuTodokedeEntity> selectAll() {

        List<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出List = 居宅給付計画届出Dac.selectAll();
        List<DbT3005KyotakuKeikakuTodokedeEntity> list = new ArrayList<>();

        for (DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出 : 居宅給付計画届出List) {
            list.add(createModel(居宅給付計画届出));
        }
        IItemList<DbT3005KyotakuKeikakuTodokedeEntity> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    /**
     * 被保険者番号に合致する居宅給付計画届出の一覧を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return IItemList<DbT3005KyotakuKeikakuTodokedeEntity>
     */
    @Transaction
    public IItemList<DbT3005KyotakuKeikakuTodokedeEntity> select居宅給付計画届出一覧By被保険者番号(HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbT3005KyotakuKeikakuTodokedeEntity> 居宅給付計画届出List = accessor.select().
                table(DbT3005KyotakuKeikakuTodokede.class).
                where(eq(DbT3005KyotakuKeikakuTodokede.hihokenshaNo, 被保険者番号)).
                order(by(DbT3005KyotakuKeikakuTodokede.rirekiNo, Order.DESC)).
                toList(DbT3005KyotakuKeikakuTodokedeEntity.class);

        List<DbT3005KyotakuKeikakuTodokedeEntity> list = new ArrayList<>();

        for (DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出 : 居宅給付計画届出List) {
            list.add(createModel(居宅給付計画届出));
        }
        IItemList<DbT3005KyotakuKeikakuTodokedeEntity> 台帳リスト = ItemList.of(list);

        return 台帳リスト;
    }

    private DbT3005KyotakuKeikakuTodokedeEntity createModel(DbT3005KyotakuKeikakuTodokedeEntity 居宅給付計画届出エンティティ) {
        if (居宅給付計画届出エンティティ == null) {
            return null;
        }

        return new DbT3005KyotakuKeikakuTodokedeEntity();
    }

    @Override
    public int insert(DbT3005KyotakuKeikakuTodokedeEntity data) {

        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画届出Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int update(DbT3005KyotakuKeikakuTodokedeEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画届出Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    @Override
    public int delete(DbT3005KyotakuKeikakuTodokedeEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画届出Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }

    /**
     * 物理削除を行います。
     *
     * @param data DbT3005KyotakuKeikakuTodokedeEntity
     * @return int 件数
     */
    public int deletePhysical(DbT3005KyotakuKeikakuTodokedeEntity data) {
        int result = 0;

        if (data == null) {
            return result;
        }

        result = 居宅給付計画届出Dac.save(data);

        // TODO リストで持っているクラスについては修正が必要になります。
        return result;
    }
}
