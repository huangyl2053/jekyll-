/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokensha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokensha.koikiHokenshaShichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokenshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険者のデータアクセスクラスです。
 */
public class DbT7050KaigoHokenshaDac implements ISaveable<DbT7050KaigoHokenshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護保険者を取得します。
     *
     * @param 広域保険者市町村コード KoikiHokenshaShichosonCode
     * @return DbT7050KaigoHokenshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7050KaigoHokenshaEntity selectByKey(
            LasdecCode 広域保険者市町村コード) throws NullPointerException {
        requireNonNull(広域保険者市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("広域保険者市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7050KaigoHokensha.class).
                where(eq(koikiHokenshaShichosonCode, 広域保険者市町村コード)).
                toObject(DbT7050KaigoHokenshaEntity.class);
    }

    /**
     * 介護保険者を全件返します。
     *
     * @return List<DbT7050KaigoHokenshaEntity>
     */
    @Transaction
    public List<DbT7050KaigoHokenshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7050KaigoHokensha.class).
                toList(DbT7050KaigoHokenshaEntity.class);
    }

    /**
     * DbT7050KaigoHokenshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7050KaigoHokenshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
