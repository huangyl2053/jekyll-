/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.FukaNendo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2001ChoshuHoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2001ChoshuHoho.fukaNendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2001ChoshuHoho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2001ChoshuHoho.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護徴収方法のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT2001ChoshuHohoDac implements IModifiable<DbT2001ChoshuHohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護徴収方法を取得します。
     *
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT2001ChoshuHohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2001ChoshuHohoEntity selectByKey(
            FukaNendo 賦課年度,
            HihokenshaNo 被保険者番号,
            RDateTime 処理日時) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度.value()),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT2001ChoshuHohoEntity.class);
    }

    /**
     * 介護徴収方法を全件返します。
     *
     * @return List<DbT2001ChoshuHohoEntity>
     */
    @Transaction
    public List<DbT2001ChoshuHohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2001ChoshuHoho.class).
                toList(DbT2001ChoshuHohoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT2001ChoshuHohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT2001ChoshuHohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT2001ChoshuHohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }
}
