/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckList;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckList.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckList.niniShitsumonNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckList.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckList.uketsukeYMD;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3102NijiYoboNiniCheckListEntity;
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
 * 二次予防任意チェックリストのデータアクセスクラスです。
 */
public class DbT3102NijiYoboNiniCheckListDac implements ISaveable<DbT3102NijiYoboNiniCheckListEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで二次予防任意チェックリストを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 任意質問番号 NiniShitsumonNo
     * @param 履歴番号 RirekiNo
     * @return DbT3102NijiYoboNiniCheckListEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3102NijiYoboNiniCheckListEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            int 任意質問番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(任意質問番号, UrSystemErrorMessages.値がnull.getReplacedMessage("任意質問番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3102NijiYoboNiniCheckList.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(uketsukeYMD, 受付年月日),
                                eq(niniShitsumonNo, 任意質問番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3102NijiYoboNiniCheckListEntity.class);
    }

    /**
     * 二次予防任意チェックリストを全件返します。
     *
     * @return List<DbT3102NijiYoboNiniCheckListEntity>
     */
    @Transaction
    public List<DbT3102NijiYoboNiniCheckListEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3102NijiYoboNiniCheckList.class).
                toList(DbT3102NijiYoboNiniCheckListEntity.class);
    }

    /**
     * DbT3102NijiYoboNiniCheckListEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3102NijiYoboNiniCheckListEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("二次予防任意チェックリストエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
