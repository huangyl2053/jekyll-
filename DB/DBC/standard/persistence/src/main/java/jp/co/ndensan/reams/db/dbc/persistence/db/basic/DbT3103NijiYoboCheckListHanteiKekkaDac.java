/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekka;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekka.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekka.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekka.uketsukeYMD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 二次予防チェックリスト判定結果のデータアクセスクラスです。
 */
public class DbT3103NijiYoboCheckListHanteiKekkaDac implements ISaveable<DbT3103NijiYoboCheckListHanteiKekkaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで二次予防チェックリスト判定結果を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 履歴番号 RirekiNo
     * @return DbT3103NijiYoboCheckListHanteiKekkaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3103NijiYoboCheckListHanteiKekkaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3103NijiYoboCheckListHanteiKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(uketsukeYMD, 受付年月日),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3103NijiYoboCheckListHanteiKekkaEntity.class);
    }

    /**
     * 二次予防チェックリスト判定結果を全件返します。
     *
     * @return List<DbT3103NijiYoboCheckListHanteiKekkaEntity>
     */
    @Transaction
    public List<DbT3103NijiYoboCheckListHanteiKekkaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3103NijiYoboCheckListHanteiKekka.class).
                toList(DbT3103NijiYoboCheckListHanteiKekkaEntity.class);
    }

    /**
     * DbT3103NijiYoboCheckListHanteiKekkaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3103NijiYoboCheckListHanteiKekkaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防チェックリスト判定結果エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
