/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7102ZeiritsuJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7102ZeiritsuJoho.zeiritsuKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7102ZeiritsuJoho.zeiritsuShuryoYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7102ZeiritsuJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 税率情報のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7102ZeiritsuJohoDac implements IModifiable<DbT7102ZeiritsuJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで税率情報を取得します。
     *
     * @param 開始年月 ZeiritsuKaishiYMD
     * @param 終了年月 ZeiritsuShuryoYMD
     * @return DbT7102ZeiritsuJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7102ZeiritsuJohoEntity selectByKey(
            FlexibleDate 開始年月,
            FlexibleDate 終了年月) throws NullPointerException {
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7102ZeiritsuJoho.class).
                where(and(
                                eq(zeiritsuKaishiYMD, 開始年月),
                                eq(zeiritsuShuryoYMD, 終了年月))).
                toObject(DbT7102ZeiritsuJohoEntity.class);
    }

    /**
     * 税率情報を全件返します。
     *
     * @return List<DbT7102ZeiritsuJohoEntity>
     */
    @Transaction
    public List<DbT7102ZeiritsuJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7102ZeiritsuJoho.class).
                toList(DbT7102ZeiritsuJohoEntity.class);
    }

    /**
     * 税率情報を追加します。
     *
     * @param entity 税率情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7102ZeiritsuJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 税率情報をDBに更新します。
     *
     * @param entity 税率情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7102ZeiritsuJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 税率情報をDBから削除します。（論理削除）
     *
     * @param entity 税率情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7102ZeiritsuJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 税率情報を物理削除。
     *
     * @param entity 税率情報
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7102ZeiritsuJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
