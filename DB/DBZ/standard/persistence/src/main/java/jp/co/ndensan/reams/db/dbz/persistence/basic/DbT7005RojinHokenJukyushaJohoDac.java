/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7005RojinHokenJukyushaJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7005RojinHokenJukyushaJoho.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7005RojinHokenJukyushaJoho.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7005RojinHokenJukyushaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老人保健受給者情報のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7005RojinHokenJukyushaJohoDac implements IModifiable<DbT7005RojinHokenJukyushaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで老人保健受給者情報を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 識別コード ShikibetsuCode
     * @return DbT7005RojinHokenJukyushaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7005RojinHokenJukyushaJohoEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7005RojinHokenJukyushaJoho.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shikibetsuCode, 識別コード))).
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

    @Transaction
    @Override
    public int insert(DbT7005RojinHokenJukyushaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7005RojinHokenJukyushaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7005RojinHokenJukyushaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7005RojinHokenJukyushaJohoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7005RojinHokenJukyushaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
