/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJoho.isDeleted;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJoho.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老人保健受給者情報のデータアクセスクラスです。
 */
public class DbT7005RojinHokenJukyushaJohoDac implements ISaveable<DbT7005RojinHokenJukyushaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで老人保健受給者情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return DbT7005RojinHokenJukyushaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7005RojinHokenJukyushaJohoEntity selectByKey(
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7005RojinHokenJukyushaJoho.class).
                where(
                        eq(shikibetsuCode, 識別コード)).
                toObject(DbT7005RojinHokenJukyushaJohoEntity.class);
    }

    /**
     * 老人保健受給者情報を全件返します。
     *
     * @return List<DbT7005RojinHokenJukyushaJohoEntity>
     */
    @Transaction
    public List<DbT7005RojinHokenJukyushaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7005RojinHokenJukyushaJoho.class).
                toList(DbT7005RojinHokenJukyushaJohoEntity.class);
    }

    /**
     * DbT7005RojinHokenJukyushaJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7005RojinHokenJukyushaJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("老人保健受給者情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 老健受給情報を取得する。
     *
     * @param 識別コード ShikibetsuCode
     * @return DbT7005RojinHokenJukyushaJohoEntity 老健受給情報を項目定義
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7005RojinHokenJukyushaJohoEntity selectRoukenJukyuJoho(ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT7005RojinHokenJukyushaJoho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                not(eq(isDeleted, true)))).
                toObject(DbT7005RojinHokenJukyushaJohoEntity.class);
    }
}
