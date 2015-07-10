/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7105KaigoninteiJukyuFlag;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7105KaigoninteiJukyuFlagEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定受給フラグのデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
//TODO QA83の回答：そのテーブルに対しては、作業をしなくて構いません。無視してください。
public class DbT7105KaigoninteiJukyuFlagDac implements IModifiable<DbT7105KaigoninteiJukyuFlagEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 介護認定受給フラグを全件返します。
     *
     * @return List<DbT7105KaigoninteiJukyuFlagEntity>
     */
    @Transaction
    public List<DbT7105KaigoninteiJukyuFlagEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7105KaigoninteiJukyuFlag.class).
                toList(DbT7105KaigoninteiJukyuFlagEntity.class);
    }

    /**
     * 介護認定受給フラグを追加します。
     *
     * @param entity 介護認定受給フラグ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7105KaigoninteiJukyuFlagEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 介護認定受給フラグをDBに更新します。
     *
     * @param entity 介護認定受給フラグ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7105KaigoninteiJukyuFlagEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 介護認定受給フラグをDBから削除します。（論理削除）
     *
     * @param entity 介護認定受給フラグ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7105KaigoninteiJukyuFlagEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 介護認定受給フラグを物理削除。
     *
     * @param entity 介護認定受給フラグ
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7105KaigoninteiJukyuFlagEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
