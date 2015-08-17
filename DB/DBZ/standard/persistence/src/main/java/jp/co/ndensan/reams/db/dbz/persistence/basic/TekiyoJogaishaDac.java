/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaisha;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1002TekiyoJogaishaEntity;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokurei.edaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokurei.idoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT1003TashichosonJushochiTokurei.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.persistence.IPersistable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 適用除外者のデータアクセスクラスです。
 *
 * @author n8178 城間篤人
 */
public class TekiyoJogaishaDac implements IPersistable<DbT1002TekiyoJogaishaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで適用除外者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 異動日 FlexibleDate
     * @param 枝番 RString
     * @return DbT1002TekiyoJogaishaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1002TekiyoJogaishaEntity selectByKey(
            ShikibetsuCode 識別コード,
            FlexibleDate 異動日,
            RString 枝番) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1002TekiyoJogaisha.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(idoYMD, 異動日),
                                eq(edaNo, 枝番))).
                toObject(DbT1002TekiyoJogaishaEntity.class);
    }

    /**
     * 適用除外者を全件返します。
     *
     * @return List<DbT1002TekiyoJogaishaEntity>
     */
    @Transaction
    public List<DbT1002TekiyoJogaishaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1002TekiyoJogaisha.class).
                toList(DbT1002TekiyoJogaishaEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT1002TekiyoJogaishaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT1002TekiyoJogaishaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT1002TekiyoJogaishaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

//    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
//    @Transaction
//    @Override
//    public int deletePhysical(DbT1002TekiyoJogaishaEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.deletePhysical(entity).execute();
//    }
}
