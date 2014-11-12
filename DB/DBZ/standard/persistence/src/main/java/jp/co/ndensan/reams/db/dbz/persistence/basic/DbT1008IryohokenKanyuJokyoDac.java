/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1008IryohokenKanyuJokyo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1008IryohokenKanyuJokyo.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1008IryohokenKanyuJokyo.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1008IryohokenKanyuJokyo.shoriTimeStamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1008IryohokenKanyuJokyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険医療保険加入状況のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT1008IryohokenKanyuJokyoDac implements IModifiable<DbT1008IryohokenKanyuJokyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護保険医療保険加入状況を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 識別コード ShikibetsuCode
     * @param 処理日時 ShoriTimeStamp
     * @return DbT1008IryohokenKanyuJokyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1008IryohokenKanyuJokyoEntity selectByKey(
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1008IryohokenKanyuJokyo.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shikibetsuCode, 識別コード),
                                eq(shoriTimeStamp, 処理日時))).
                toObject(DbT1008IryohokenKanyuJokyoEntity.class);
    }

    /**
     * 介護保険医療保険加入状況を全件返します。
     *
     * @return List<DbT1008IryohokenKanyuJokyoEntity>
     */
    @Transaction
    public List<DbT1008IryohokenKanyuJokyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1008IryohokenKanyuJokyo.class).
                toList(DbT1008IryohokenKanyuJokyoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT1008IryohokenKanyuJokyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT1008IryohokenKanyuJokyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1008IryohokenKanyuJokyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT1008IryohokenKanyuJokyoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT1008IryohokenKanyuJokyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
