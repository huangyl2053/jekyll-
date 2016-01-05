/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishosha;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishosha.*;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1010TennyushutsuHoryuTaishoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 転入保留対象者のデータアクセスクラスです。
 */
public class DbT1010TennyushutsuHoryuTaishoshaDac implements ISaveable<DbT1010TennyushutsuHoryuTaishoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで転入保留対象者を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 履歴番号 RirekiNo
     * @return DbT1010TennyushutsuHoryuTaishoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1010TennyushutsuHoryuTaishoshaEntity selectByKey(
            ShikibetsuCode 識別コード,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1010TennyushutsuHoryuTaishosha.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT1010TennyushutsuHoryuTaishoshaEntity.class);
    }

    /**
     * 転入保留対象者を全件返します。
     *
     * @return List<DbT1010TennyushutsuHoryuTaishoshaEntity>
     */
    @Transaction
    public List<DbT1010TennyushutsuHoryuTaishoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1010TennyushutsuHoryuTaishosha.class).
                toList(DbT1010TennyushutsuHoryuTaishoshaEntity.class);
    }

    /**
     * DbT1010TennyushutsuHoryuTaishoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1010TennyushutsuHoryuTaishoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("転入保留対象者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT1010TennyushutsuHoryuTaishoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int delete(DbT1010TennyushutsuHoryuTaishoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("転入保留対象者エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
