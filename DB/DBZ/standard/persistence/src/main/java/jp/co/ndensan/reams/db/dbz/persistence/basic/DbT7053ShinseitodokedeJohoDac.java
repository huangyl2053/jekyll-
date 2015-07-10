/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7053ShinseitodokedeJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7053ShinseitodokedeJoho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7053ShinseitodokedeJoho.shinseiTodokedeYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7053ShinseitodokedeJoho.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7053ShinseitodokedeJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 申請届出情報のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7053ShinseitodokedeJohoDac implements IModifiable<DbT7053ShinseitodokedeJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで申請届出情報を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param 申請届出年月日 ShinseiTodokedeYMD
     * @return DbT7053ShinseitodokedeJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7053ShinseitodokedeJohoEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RDate 申請届出年月日) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(申請届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7053ShinseitodokedeJoho.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shinseiTodokedeYMD, 申請届出年月日))).
                toObject(DbT7053ShinseitodokedeJohoEntity.class);
    }

    /**
     * 申請届出情報を全件返します。
     *
     * @return List<DbT7053ShinseitodokedeJohoEntity>
     */
    @Transaction
    public List<DbT7053ShinseitodokedeJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7053ShinseitodokedeJoho.class).
                toList(DbT7053ShinseitodokedeJohoEntity.class);
    }

    /**
     * 申請届出情報を追加します。
     *
     * @param entity 申請届出情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7053ShinseitodokedeJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 申請届出情報をDBに更新します。
     *
     * @param entity 申請届出情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7053ShinseitodokedeJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 申請届出情報をDBから削除します。（論理削除）
     *
     * @param entity 申請届出情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7053ShinseitodokedeJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 申請届出情報を物理削除。
     *
     * @param entity 申請届出情報
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7053ShinseitodokedeJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
