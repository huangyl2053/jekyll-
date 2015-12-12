/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7051KoseiShichosonMaster.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7054KanrenHihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7054KanrenHihokenshaNo.saishinHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7054KanrenHihokenshaNoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 関連被保険者番号のデータアクセスクラスです。
 */
public class DbT7054KanrenHihokenshaNoDac implements ISaveable<DbT7054KanrenHihokenshaNoEntity> {

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
     * DbT7054KanrenHihokenshaNoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7054KanrenHihokenshaNoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("関連被保険者番号エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
