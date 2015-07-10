/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1009ShikakuShutokuJogaisha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1009ShikakuShutokuJogaisha.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1009ShikakuShutokuJogaisha.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1009ShikakuShutokuJogaisha.shoriTimeStamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1009ShikakuShutokuJogaishaEntity;
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
 * 資格取得除外者のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT1009ShikakuShutokuJogaishaDac implements IModifiable<DbT1009ShikakuShutokuJogaishaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで資格取得除外者を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 識別コード ShikibetsuCode
     * @param 処理日時 ShoriTimeStamp
     * @return DbT1009ShikakuShutokuJogaishaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1009ShikakuShutokuJogaishaEntity selectByKey(
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1009ShikakuShutokuJogaisha.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shikibetsuCode, 識別コード),
                                eq(shoriTimeStamp, 処理日時))).
                toObject(DbT1009ShikakuShutokuJogaishaEntity.class);
    }

    /**
     * 資格取得除外者を全件返します。
     *
     * @return List<DbT1009ShikakuShutokuJogaishaEntity>
     */
    @Transaction
    public List<DbT1009ShikakuShutokuJogaishaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1009ShikakuShutokuJogaisha.class).
                toList(DbT1009ShikakuShutokuJogaishaEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT1009ShikakuShutokuJogaishaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT1009ShikakuShutokuJogaishaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1009ShikakuShutokuJogaishaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT1009ShikakuShutokuJogaishaEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT1009ShikakuShutokuJogaishaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
