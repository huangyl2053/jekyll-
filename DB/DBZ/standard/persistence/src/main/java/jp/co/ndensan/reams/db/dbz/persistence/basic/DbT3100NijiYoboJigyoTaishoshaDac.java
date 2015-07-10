/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3100NijiYoboJigyoTaishosha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3100NijiYoboJigyoTaishosha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3100NijiYoboJigyoTaishosha.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3100NijiYoboJigyoTaishosha.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3100NijiYoboJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 二次予防事業対象者のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3100NijiYoboJigyoTaishoshaDac implements IModifiable<DbT3100NijiYoboJigyoTaishoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで二次予防事業対象者を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3100NijiYoboJigyoTaishoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3100NijiYoboJigyoTaishoshaEntity selectByKey(
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3100NijiYoboJigyoTaishosha.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoriTimestamp, 処理日時))).
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

    @Transaction
    @Override
    public int insert(DbT3100NijiYoboJigyoTaishoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3100NijiYoboJigyoTaishoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3100NijiYoboJigyoTaishoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3100NijiYoboJigyoTaishoshaEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3100NijiYoboJigyoTaishoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
