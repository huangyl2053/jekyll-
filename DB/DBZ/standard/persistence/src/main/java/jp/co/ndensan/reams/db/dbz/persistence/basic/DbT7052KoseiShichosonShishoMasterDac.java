/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7052KoseiShichosonShishoMaster;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7052KoseiShichosonShishoMaster.shishoCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7052KoseiShichosonShishoMaster.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村支所マスタのデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7052KoseiShichosonShishoMasterDac implements IModifiable<DbT7052KoseiShichosonShishoMasterEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで構成市町村支所マスタを取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 支所コード ShishoCode
     * @return DbT7052KoseiShichosonShishoMasterEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7052KoseiShichosonShishoMasterEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            ShishoCode 支所コード) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支所コード, UrSystemErrorMessages.値がnull.getReplacedMessage("支所コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7052KoseiShichosonShishoMaster.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shishoCode, 支所コード))).
                toObject(DbT7052KoseiShichosonShishoMasterEntity.class);
    }

    /**
     * 構成市町村支所マスタを全件返します。
     *
     * @return List<DbT7052KoseiShichosonShishoMasterEntity>
     */
    @Transaction
    public List<DbT7052KoseiShichosonShishoMasterEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7052KoseiShichosonShishoMaster.class).
                toList(DbT7052KoseiShichosonShishoMasterEntity.class);
    }

    /**
     * 構成市町村支所マスタを追加します。
     *
     * @param entity 構成市町村支所マスタ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7052KoseiShichosonShishoMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 構成市町村支所マスタをDBに更新します。
     *
     * @param entity 構成市町村支所マスタ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7052KoseiShichosonShishoMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 構成市町村支所マスタをDBから削除します。（論理削除）
     *
     * @param entity 構成市町村支所マスタ
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7052KoseiShichosonShishoMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 構成市町村支所マスタを物理削除。
     *
     * @param entity 構成市町村支所マスタ
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7052KoseiShichosonShishoMasterEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
