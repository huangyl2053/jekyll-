/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJoho.bemmeishaEdaban;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJoho.bemmeishoSakuseiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJoho.genshobunHihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJoho.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJoho.shinsaseikyuTodokedeYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJoho.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7003BemmeishaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 弁明者情報のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7003BemmeishaJohoDac implements IModifiable<DbT7003BemmeishaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで弁明者情報を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
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
            ShoKisaiHokenshaNo 証記載保険者番号,
            ShikibetsuCode 識別コード,
            HihokenshaNo 原処分被保険者番号,
            FlexibleDate 審査請求届出日,
            FlexibleDate 弁明書作成日,
            int 弁明者枝番) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(原処分被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("原処分被保険者番号"));
        requireNonNull(審査請求届出日, UrSystemErrorMessages.値がnull.getReplacedMessage("審査請求届出日"));
        requireNonNull(弁明書作成日, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明書作成日"));
        requireNonNull(弁明者枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("弁明者枝番"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7003BemmeishaJoho.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
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

    @Transaction
    @Override
    public int insert(DbT7003BemmeishaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7003BemmeishaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7003BemmeishaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7003BemmeishaJohoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7003BemmeishaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
