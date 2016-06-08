/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJoho.bemmeishaEdaban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJoho.bemmeishoSakuseiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJoho.genshobunHihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJoho.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJoho.shinsaseikyuTodokedeYMD;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 弁明者情報のデータアクセスクラスです。
 */
public class DbT7003BemmeishaJohoDac implements ISaveable<DbT7003BemmeishaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで弁明者情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 GenshobunHihokenshaNo
     * @param 審査請求届出日 ShinsaseikyuTodokedeYMD
     * @param 弁明書作成日 BemmeishoSakuseiYMD
     * @param 弁明者枝番 BemmeishaEdaban
     * @return DbT7003BemmeishaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7003BemmeishaJohoEntity selectByKey(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            Decimal 弁明者枝番) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));
        requireNonNull(弁明者枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者枝番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7003BemmeishaJoho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(genshobunHihokenshaNo, 原処分被保険者番号),
                                eq(shinsaseikyuTodokedeYMD, 審査請求届出日),
                                eq(bemmeishoSakuseiYMD, 弁明書作成日),
                                eq(bemmeishaEdaban, 弁明者枝番))).
                toObject(DbT7003BemmeishaJohoEntity.class);
    }

    /**
     * 弁明者情報を全件返します。
     *
     * @return List<DbT7003BemmeishaJohoEntity>
     */
    @Transaction
    public List<DbT7003BemmeishaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7003BemmeishaJoho.class).
                toList(DbT7003BemmeishaJohoEntity.class);
    }

    /**
     * DbT7003BemmeishaJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7003BemmeishaJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで弁明者情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 GenshobunHihokenshaNo
     * @param 審査請求届出日 ShinsaseikyuTodokedeYMD
     * @param 弁明書作成日 BemmeishoSakuseiYMD
     * @return DbT7003BemmeishaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7003BemmeishaJohoEntity> selectGyomuToutokuByKey(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7003BemmeishaJoho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(genshobunHihokenshaNo, 原処分被保険者番号),
                                eq(shinsaseikyuTodokedeYMD, 審査請求届出日),
                                eq(bemmeishoSakuseiYMD, 弁明書作成日))).
                toList(DbT7003BemmeishaJohoEntity.class);
    }

    /**
     * 主キーで弁明者情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 原処分被保険者番号 GenshobunHihokenshaNo
     * @param 審査請求届出日 ShinsaseikyuTodokedeYMD
     * @return DbT7003BemmeishaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7003BemmeishaJohoEntity> selectGyomuDelUpdByKey(
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7003BemmeishaJoho.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(genshobunHihokenshaNo, 原処分被保険者番号),
                                eq(shinsaseikyuTodokedeYMD, 審査請求届出日))).
                toList(DbT7003BemmeishaJohoEntity.class);
    }

    /**
     * DbT7003BemmeishaJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 件数
     */
    @Transaction
    public int saveOrDelete(DbT7003BemmeishaJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者情報エンティティ"));

        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
