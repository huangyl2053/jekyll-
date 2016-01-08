/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishosha;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishosha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishosha.rirekiNo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 二次予防事業対象者のデータアクセスクラスです。
 */
public class DbT3100NijiYoboJigyoTaishoshaDac implements ISaveable<DbT3100NijiYoboJigyoTaishoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで二次予防事業対象者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT3100NijiYoboJigyoTaishoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3100NijiYoboJigyoTaishoshaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3100NijiYoboJigyoTaishosha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3100NijiYoboJigyoTaishoshaEntity.class);
    }

    /**
     * 二次予防事業対象者を全件返します。
     *
     * @return List<DbT3100NijiYoboJigyoTaishoshaEntity>
     */
    @Transaction
    public List<DbT3100NijiYoboJigyoTaishoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3100NijiYoboJigyoTaishosha.class).
                toList(DbT3100NijiYoboJigyoTaishoshaEntity.class);
    }

    /**
     * DbT3100NijiYoboJigyoTaishoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3100NijiYoboJigyoTaishoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防事業対象者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
