/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariai;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariai.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariai.nendo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariai.rirekiNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担割合のデータアクセスクラスです。
 *
 * @reamsid_L DBC-5010-011 zhaowei
 */
public class DbT3113RiyoshaFutanWariaiDac implements ISaveable<DbT3113RiyoshaFutanWariaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで利用者負担割合を取得します。
     *
     * @param 年度 Nendo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return DbT3113RiyoshaFutanWariaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3113RiyoshaFutanWariaiEntity selectByKey(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3113RiyoshaFutanWariai.class).
                where(and(
                                eq(nendo, 年度),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3113RiyoshaFutanWariaiEntity.class);
    }

    /**
     * Max履歴番号を返します。
     *
     * @param 年度 Nendo
     * @param 被保険者番号 HihokenshaNo
     * @return Max履歴番号
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3113RiyoshaFutanWariaiEntity selectMax履歴番号(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.selectSpecific(max(rirekiNo)).
                table(DbT3113RiyoshaFutanWariai.class).
                where(and(
                                eq(nendo, 年度),
                                eq(hihokenshaNo, 被保険者番号)))
                .toObject(DbT3113RiyoshaFutanWariaiEntity.class);
    }

    /**
     * 利用者負担割合を全件返します。
     *
     * @return List<DbT3113RiyoshaFutanWariaiEntity>
     */
    @Transaction
    public List<DbT3113RiyoshaFutanWariaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3113RiyoshaFutanWariai.class).
                toList(DbT3113RiyoshaFutanWariaiEntity.class);
    }

    /**
     * DbT3113RiyoshaFutanWariaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3113RiyoshaFutanWariaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで利用者負担割合を取得します。
     *
     * @param 年度 Nendo
     * @param 被保険者番号 HihokenshaNo
     * @return DbT3113RiyoshaFutanWariaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3113RiyoshaFutanWariaiEntity> selectBy年度と被保険者番号(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3113RiyoshaFutanWariai.class).
                where(and(
                                eq(nendo, 年度),
                                eq(hihokenshaNo, 被保険者番号))).
                toList(DbT3113RiyoshaFutanWariaiEntity.class);
    }
}
