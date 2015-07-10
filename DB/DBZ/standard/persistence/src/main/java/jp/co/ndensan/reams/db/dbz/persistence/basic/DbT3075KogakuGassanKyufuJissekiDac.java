/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3075KogakuGassanKyufuJisseki;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3075KogakuGassanKyufuJisseki.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3075KogakuGassanKyufuJisseki.kokanJohoShikibetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3075KogakuGassanKyufuJisseki.seiriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3075KogakuGassanKyufuJisseki.shikyuShinseiSeiriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3075KogakuGassanKyufuJisseki.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3075KogakuGassanKyufuJissekiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算給付実績のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3075KogakuGassanKyufuJissekiDac implements IModifiable<DbT3075KogakuGassanKyufuJissekiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額合算給付実績を取得します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 被保険者番号 HihokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseiSeiriNo
     * @param 整理番号 SeiriNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3075KogakuGassanKyufuJissekiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3075KogakuGassanKyufuJissekiEntity selectByKey(
            KokanShikibetsuNo 交換情報識別番号,
            HihokenshaNo 被保険者番号,
            RString 支給申請書整理番号,
            RString 整理番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3075KogakuGassanKyufuJisseki.class).
                where(and(
                                eq(kokanJohoShikibetsuNo, 交換情報識別番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shikyuShinseiSeiriNo, 支給申請書整理番号),
                                eq(seiriNo, 整理番号),
                                eq(shoriTimestamp, 処理日時))).
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
     * 高額合算給付実績を追加します。
     *
     * @param entity 高額合算給付実績
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額合算給付実績をDBに更新します。
     *
     * @param entity 高額合算給付実績
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額合算給付実績をDBから削除します。（論理削除）
     *
     * @param entity 高額合算給付実績
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額合算給付実績を物理削除。
     *
     * @param entity 高額合算給付実績
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3075KogakuGassanKyufuJissekiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
