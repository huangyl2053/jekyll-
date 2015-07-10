/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7054KanrenHihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7054KanrenHihokenshaNo.saishinHihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7054KanrenHihokenshaNo.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 関連被保険者番号のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7054KanrenHihokenshaNoDac implements IModifiable<DbT7054KanrenHihokenshaNoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで関連被保険者番号を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 最新被保険者番号 SaishinHihokenshaNo
     * @return DbT7054KanrenHihokenshaNoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7054KanrenHihokenshaNoEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 最新被保険者番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(最新被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("最新被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7054KanrenHihokenshaNo.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(saishinHihokenshaNo, 最新被保険者番号))).
                toObject(DbT7054KanrenHihokenshaNoEntity.class);
    }

    /**
     * 関連被保険者番号を全件返します。
     *
     * @return List<DbT7054KanrenHihokenshaNoEntity>
     */
    @Transaction
    public List<DbT7054KanrenHihokenshaNoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7054KanrenHihokenshaNo.class).
                toList(DbT7054KanrenHihokenshaNoEntity.class);
    }

    /**
     * 関連被保険者番号を追加します。
     *
     * @param entity 関連被保険者番号
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7054KanrenHihokenshaNoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 関連被保険者番号をDBに更新します。
     *
     * @param entity 関連被保険者番号
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7054KanrenHihokenshaNoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 関連被保険者番号をDBから削除します。（論理削除）
     *
     * @param entity 関連被保険者番号
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7054KanrenHihokenshaNoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 関連被保険者番号を物理削除。
     *
     * @param entity 関連被保険者番号
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7054KanrenHihokenshaNoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
