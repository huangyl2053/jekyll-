/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3103NijiYoboCheckListHanteiKekka;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3103NijiYoboCheckListHanteiKekka.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3103NijiYoboCheckListHanteiKekka.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3103NijiYoboCheckListHanteiKekka.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3103NijiYoboCheckListHanteiKekka.uketsukeYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3103NijiYoboCheckListHanteiKekkaEntity;
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
 * 二次予防チェックリスト判定結果のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3103NijiYoboCheckListHanteiKekkaDac implements IModifiable<DbT3103NijiYoboCheckListHanteiKekkaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで二次予防チェックリスト判定結果を取得します。
     *
     * @param 識別コード ShikibetsuCode
     * @param 被保険者番号 HihokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3103NijiYoboCheckListHanteiKekkaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3103NijiYoboCheckListHanteiKekkaEntity selectByKey(
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
                table(DbT3103NijiYoboCheckListHanteiKekka.class).
                where(and(
                                eq(shikibetsuCode, 識別コード),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(uketsukeYMD, 受付年月日),
                                eq(shoriTimestamp, 処理日時))).
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

    @Transaction
    @Override
    public int insert(DbT3103NijiYoboCheckListHanteiKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3103NijiYoboCheckListHanteiKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3103NijiYoboCheckListHanteiKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3103NijiYoboCheckListHanteiKekkaEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3103NijiYoboCheckListHanteiKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
