/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3101NijiYoboKihonCheckList;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3101NijiYoboKihonCheckList.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3101NijiYoboKihonCheckList.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3101NijiYoboKihonCheckList.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3101NijiYoboKihonCheckList.uketsukeYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3101NijiYoboKihonCheckListEntity;
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
 * 二次予防基本チェックリストのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3101NijiYoboKihonCheckListDac implements IModifiable<DbT3101NijiYoboKihonCheckListEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで二次予防基本チェックリストを取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3101NijiYoboKihonCheckListEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3101NijiYoboKihonCheckListEntity selectByKey(
            ShikibetsuCode 識別コード,
            HihokenshaNo 被保険者番号,
            FlexibleDate 受付年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3101NijiYoboKihonCheckList.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(uketsukeYMD, 受付年月日),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3101NijiYoboKihonCheckListEntity.class);
    }

    /**
     * 二次予防基本チェックリストを全件返します。
     *
     * @return List<DbT3101NijiYoboKihonCheckListEntity>
     */
    @Transaction
    public List<DbT3101NijiYoboKihonCheckListEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3101NijiYoboKihonCheckList.class).
                toList(DbT3101NijiYoboKihonCheckListEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3101NijiYoboKihonCheckListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3101NijiYoboKihonCheckListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3101NijiYoboKihonCheckListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3101NijiYoboKihonCheckListEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3101NijiYoboKihonCheckListEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
