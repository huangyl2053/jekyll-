/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurity;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurity.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurityEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 広域市町村セキュリティのデータアクセスクラスです。
 *
 * @author N8187 久保田 英男
 */
public class DbT7057KoikiShichosonSecurityDac implements IModifiable<DbT7057KoikiShichosonSecurityEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで広域市町村セキュリティを取得します。
     *
     * @param グループID RString
     * @return DbT7056GappeiShichosonEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7057KoikiShichosonSecurityEntity selectByKey(
            RString グループID) throws NullPointerException {
        requireNonNull(グループID, UrSystemErrorMessages.値がnull.getReplacedMessage("グループID"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7057KoikiShichosonSecurity.class).
                where(eq(groupID, グループID)).
                toObject(DbT7057KoikiShichosonSecurityEntity.class);
    }

    /**
     * 広域市町村セキュリティを全件返します。
     *
     * @return List<DbT7057KoikiShichosonSecurityEntity>
     */
    @Transaction
    public List<DbT7057KoikiShichosonSecurityEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7057KoikiShichosonSecurity.class).
                toList(DbT7057KoikiShichosonSecurityEntity.class);
    }

    /**
     * 広域市町村セキュリティを追加します。
     *
     * @param entity 広域市町村セキュリティ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7057KoikiShichosonSecurityEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 広域市町村セキュリティをDBに更新します。
     *
     * @param entity 広域市町村セキュリティ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7057KoikiShichosonSecurityEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 広域市町村セキュリティをDBから削除します。（論理削除）
     *
     * @param entity 広域市町村セキュリティ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7057KoikiShichosonSecurityEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 広域市町村セキュリティを物理削除。
     *
     * @param entity 広域市町村セキュリティ
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7057KoikiShichosonSecurityEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

}
