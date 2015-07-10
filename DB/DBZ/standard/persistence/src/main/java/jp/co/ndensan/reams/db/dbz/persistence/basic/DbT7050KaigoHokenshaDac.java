/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokensha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokensha.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7050KaigoHokenshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険者のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7050KaigoHokenshaDac implements IModifiable<DbT7050KaigoHokenshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護保険者を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @return DbT7050KaigoHokenshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7050KaigoHokenshaEntity selectByKey(
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7050KaigoHokensha.class).
                where(
                        eq(shichosonCode, 市町村コード)).
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
     * 介護保険者を追加します。
     *
     * @param entity 介護保険者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7050KaigoHokenshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 介護保険者をDBに更新します。
     *
     * @param entity 介護保険者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7050KaigoHokenshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 介護保険者をDBから削除します。（論理削除）
     *
     * @param entity 介護保険者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7050KaigoHokenshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 介護保険者を物理削除。
     *
     * @param entity 介護保険者
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7050KaigoHokenshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
