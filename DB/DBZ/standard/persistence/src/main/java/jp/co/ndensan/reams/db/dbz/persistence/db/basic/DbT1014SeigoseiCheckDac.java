/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheck;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheck.shikibetsuCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheckEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 整合性チェック情報のデータアクセスクラスです。
 */
public class DbT1014SeigoseiCheckDac implements ISaveable<DbT1014SeigoseiCheckEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで整合性チェック情報を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @return DbT1014SeigoseiCheckEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT1014SeigoseiCheckEntity selectByKey(
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1014SeigoseiCheck.class).
                where(eq(shikibetsuCode, 識別コード)).
                toObject(DbT1014SeigoseiCheckEntity.class);
    }

    /**
     * 整合性チェック情報を全件返します。
     *
     * @return List<DbT1014SeigoseiCheckEntity>
     */
    @Transaction
    public List<DbT1014SeigoseiCheckEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT1014SeigoseiCheck.class).
                toList(DbT1014SeigoseiCheckEntity.class);
    }

    /**
     * DbT1014SeigoseiCheckEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT1014SeigoseiCheckEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("整合性チェック情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

}
