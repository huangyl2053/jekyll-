/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1012Minashi2GoshaDaicho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1012Minashi2GoshaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1012Minashi2GoshaDaicho.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1012Minashi2GoshaDaicho.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * みなし2号者台帳のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT1012Minashi2GoshaDaichoDac implements IModifiable<DbT1012Minashi2GoshaDaichoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーでみなし2号者台帳を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 被保険者番号 HihokenshaNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT1012Minashi2GoshaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1012Minashi2GoshaDaichoEntity selectByKey(
            LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1012Minashi2GoshaDaicho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT1012Minashi2GoshaDaichoEntity.class);
    }

    /**
     * みなし2号者台帳を全件返します。
     *
     * @return List<DbT1012Minashi2GoshaDaichoEntity>
     */
    @Transaction
    public List<DbT1012Minashi2GoshaDaichoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1012Minashi2GoshaDaicho.class).
                toList(DbT1012Minashi2GoshaDaichoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT1012Minashi2GoshaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT1012Minashi2GoshaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1012Minashi2GoshaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT1012Minashi2GoshaDaichoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT1012Minashi2GoshaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
