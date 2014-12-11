/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3102NijiYoboNiniCheckList;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3102NijiYoboNiniCheckList.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3102NijiYoboNiniCheckList.niniShitsumonNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3102NijiYoboNiniCheckList.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3102NijiYoboNiniCheckList.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3102NijiYoboNiniCheckList.uketsukeYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3102NijiYoboNiniCheckListEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 二次予防任意チェックリストのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3102NijiYoboNiniCheckListDac implements IModifiable<DbT3102NijiYoboNiniCheckListEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで二次予防任意チェックリストを取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 任意質問番号 NiniShitsumonNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3102NijiYoboNiniCheckListEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3102NijiYoboNiniCheckListEntity selectByKey(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            int 任意質問番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(任意質問番号, UrSystemErrorMessages.値がnull.getReplacedMessage("任意質問番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3102NijiYoboNiniCheckList.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(uketsukeYMD, 受付年月日),
                                eq(niniShitsumonNo, 任意質問番号),
                                eq(shoriTimestamp, 処理日時))).
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

    @Transaction
    @Override
    public int insert(DbT3102NijiYoboNiniCheckListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3102NijiYoboNiniCheckListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3102NijiYoboNiniCheckListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3102NijiYoboNiniCheckListEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3102NijiYoboNiniCheckListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
