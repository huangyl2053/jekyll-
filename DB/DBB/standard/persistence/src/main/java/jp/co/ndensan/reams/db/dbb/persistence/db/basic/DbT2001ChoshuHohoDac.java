/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuhoho.DbT2001ChoshuHoho;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuhoho.DbT2001ChoshuHoho.*;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuhoho.DbT2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護徴収方法のデータアクセスクラスです。
 */
public class DbT2001ChoshuHohoDac implements ISaveable<DbT2001ChoshuHohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護徴収方法を取得します。
     *
     * @param 賦課年度 FukaNendo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT2001ChoshuHohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2001ChoshuHohoEntity selectByKey(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2001ChoshuHoho.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT2001ChoshuHohoEntity.class);
    }

    /**
     * 介護徴収方法を全件返します。
     *
     * @return List<DbT2001ChoshuHohoEntity>
     */
    @Transaction
    public List<DbT2001ChoshuHohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2001ChoshuHoho.class).
                toList(DbT2001ChoshuHohoEntity.class);
    }

    /**
     * DbT2001ChoshuHohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2001ChoshuHohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護徴収方法エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
