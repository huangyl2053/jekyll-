/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJisseki;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJisseki.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJisseki.isDeleted;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJisseki.kokanJohoShikibetsuNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJisseki.seiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJisseki.shikyuShinseiSeiriNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算給付実績のデータアクセスクラスです。
 *
 * @reamsid_L DBC-3010-010 linghuhang
 */
public class DbT3075KogakuGassanKyufuJissekiDac implements ISaveable<DbT3075KogakuGassanKyufuJissekiEntity> {

    @InjectSession
    private SqlSession session;
    private static final RString メッセージ_被保険者番号 = new RString("被保険者番号");

    /**
     * 主キーで高額合算給付実績を取得します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 被保険者番号 HihokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseiSeiriNo
     * @param 整理番号 SeiriNo
     * @return DbT3075KogakuGassanKyufuJissekiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3075KogakuGassanKyufuJissekiEntity selectByKey(
            KokanShikibetsuNo 交換情報識別番号,
            HihokenshaNo 被保険者番号,
            RString 支給申請書整理番号,
            RString 整理番号) throws NullPointerException {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3075KogakuGassanKyufuJisseki.class).
                where(and(
                                eq(kokanJohoShikibetsuNo, 交換情報識別番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shikyuShinseiSeiriNo, 支給申請書整理番号),
                                eq(seiriNo, 整理番号))).
                toObject(DbT3075KogakuGassanKyufuJissekiEntity.class);
    }

    /**
     * 高額合算給付実績を全件返します。
     *
     * @return List<DbT3075KogakuGassanKyufuJissekiEntity>
     */
    @Transaction
    public List<DbT3075KogakuGassanKyufuJissekiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3075KogakuGassanKyufuJisseki.class).
                toList(DbT3075KogakuGassanKyufuJissekiEntity.class);
    }

    /**
     * DbT3075KogakuGassanKyufuJissekiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算給付実績エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 高額合算給付実績データを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<DbT3075KogakuGassanKyufuJissekiEntity>
     */
    @Transaction
    public List<DbT3075KogakuGassanKyufuJissekiEntity> getKogakuGassanKyufuJisseki(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3075KogakuGassanKyufuJisseki.class).
                where(and(
                                eq(isDeleted, false),
                                eq(hihokenshaNo, 被保険者番号))).
                order(by(DbT3075KogakuGassanKyufuJisseki.shikyuShinseiSeiriNo, Order.DESC),
                        by(DbT3075KogakuGassanKyufuJisseki.shoriYM, Order.DESC),
                        by(DbT3075KogakuGassanKyufuJisseki.seiriNo, Order.DESC)).
                toList(DbT3075KogakuGassanKyufuJissekiEntity.class);
    }

    /**
     * 高額合算給付実績データを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<DbT3075KogakuGassanKyufuJissekiEntity>
     */
    @Transaction
    public List<DbT3075KogakuGassanKyufuJissekiEntity> get高額合算給付実績(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(メッセージ_被保険者番号.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT3075KogakuGassanKyufuJisseki.class).
                where(and(
                                eq(isDeleted, false),
                                eq(hihokenshaNo, 被保険者番号))).
                toList(DbT3075KogakuGassanKyufuJissekiEntity.class);
    }
}
