/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4001JukyushaDaicho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4001JukyushaDaicho.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳のデータアクセスクラスです。
 *
 * @author n8235 船山洋介
 */
public class DbT4001JukyushaDaichoDac implements IModifiable<DbT4001JukyushaDaichoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで受給者台帳を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @param 枝番 Edaban
     * @param 受給申請事由 jukyuShinseiJiyu
     * @return DbT4001JukyushaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4001JukyushaDaichoEntity selectByKey(
            LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RString 履歴番号,
            RString 枝番,
            Code 受給申請事由) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        requireNonNull(受給申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請事由"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号),
                                eq(edaban, 枝番),
                                eq(jukyuShinseiJiyu, 受給申請事由))).
                toObject(DbT4001JukyushaDaichoEntity.class);
    }

    /**
     * 被保険者番号に合致する受給者台帳の履歴を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @return JukyushaDaichoModel
     */
    @Transaction
    public List<DbT4001JukyushaDaichoEntity> select受給者台帳履歴By被保険者番号(
            HihokenshaNo 被保険者番号) {

        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(eq(DbT4001JukyushaDaicho.hihokenshaNo, 被保険者番号)).
                order(by(DbT4001JukyushaDaicho.shinseishoKanriNo, Order.DESC)).
                toList(DbT4001JukyushaDaichoEntity.class);

    }

    /**
     * 申請書管理番号に合致する受給者台帳の履歴を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @return JukyushaDaichoModel
     */
    @Transaction
    public DbT4001JukyushaDaichoEntity select受給者台帳履歴By申請書管理番号(
            ShinseishoKanriNo 申請書管理番号) {

        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(eq(DbT4001JukyushaDaicho.shinseishoKanriNo, 申請書管理番号),
                                eq(DbT4001JukyushaDaicho.chokkinFlag, true))).
                toObject(DbT4001JukyushaDaichoEntity.class);

    }

    /**
     * 受給者台帳を全件返します。
     *
     * @return List<DbT4001JukyushaDaichoEntity>
     */
    @Transaction
    public List<DbT4001JukyushaDaichoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                toList(DbT4001JukyushaDaichoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT4001JukyushaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT4001JukyushaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT4001JukyushaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    @Transaction
    public int deletePhysical(DbT4001JukyushaDaichoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
