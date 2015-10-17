/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyo.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3115RiyoshaFutanWariaiKonkyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担割合世帯員のデータアクセスクラスです。
 */
public class DbT3115RiyoshaFutanWariaiKonkyoDac implements ISaveable<DbT3115RiyoshaFutanWariaiKonkyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで利用者負担割合世帯員を取得します。
     *
     * @param 年度 Nendo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @param 枝番号 EdaNo
     * @param 世帯員被保険者番号 SetaiinHihokenshaNo
     * @return DbT3115RiyoshaFutanWariaiKonkyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3115RiyoshaFutanWariaiKonkyoEntity selectByKey(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号,
            Decimal 枝番号,
            HihokenshaNo 世帯員被保険者番号) throws NullPointerException {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番号, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番号"));
        requireNonNull(世帯員被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("世帯員被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3115RiyoshaFutanWariaiKonkyo.class).
                where(and(
                                eq(nendo, 年度),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号),
                                eq(edaNo, 枝番号),
                                eq(setaiinHihokenshaNo, 世帯員被保険者番号))).
                toObject(DbT3115RiyoshaFutanWariaiKonkyoEntity.class);
    }

    /**
     * 利用者負担割合世帯員を全件返します。
     *
     * @return List<DbT3115RiyoshaFutanWariaiKonkyoEntity>
     */
    @Transaction
    public List<DbT3115RiyoshaFutanWariaiKonkyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3115RiyoshaFutanWariaiKonkyo.class).
                toList(DbT3115RiyoshaFutanWariaiKonkyoEntity.class);
    }

    /**
     * DbT3115RiyoshaFutanWariaiKonkyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3115RiyoshaFutanWariaiKonkyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合世帯員エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
