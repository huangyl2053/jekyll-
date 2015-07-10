/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJoho.shubetsu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJoho.teikeiKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJoho.teikeibunCd;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7103TeikeibunJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 定型文情報のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7103TeikeibunJohoDac implements IModifiable<DbT7103TeikeibunJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで定型文情報を取得します。
     *
     * @param 定型区分 TeikeiKubun
     * @param 種別 Shubetsu
     * @param 定型文コード TeikeibunCd
     * @return DbT7103TeikeibunJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7103TeikeibunJohoEntity selectByKey(
            RString 定型区分,
            RString 種別,
            RString 定型文コード) throws NullPointerException {
        requireNonNull(定型区分, UrSystemErrorMessages.値がnull.getReplacedMessage("定型区分"));
        requireNonNull(種別, UrSystemErrorMessages.値がnull.getReplacedMessage("種別"));
        requireNonNull(定型文コード, UrSystemErrorMessages.値がnull.getReplacedMessage("定型文コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7103TeikeibunJoho.class).
                where(and(
                                eq(teikeiKubun, 定型区分),
                                eq(shubetsu, 種別),
                                eq(teikeibunCd, 定型文コード))).
                toObject(DbT7103TeikeibunJohoEntity.class);
    }

    /**
     * 定型文情報を全件返します。
     *
     * @return List<DbT7103TeikeibunJohoEntity>
     */
    @Transaction
    public List<DbT7103TeikeibunJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7103TeikeibunJoho.class).
                toList(DbT7103TeikeibunJohoEntity.class);
    }

    /**
     * 定型文情報を追加します。
     *
     * @param entity 定型文情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7103TeikeibunJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 定型文情報をDBに更新します。
     *
     * @param entity 定型文情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7103TeikeibunJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 定型文情報をDBから削除します。（論理削除）
     *
     * @param entity 定型文情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7103TeikeibunJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 定型文情報を物理削除。
     *
     * @param entity 定型文情報
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7103TeikeibunJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
