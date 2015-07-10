/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyo.choshuHoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyo.choteiNendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyo.fukaNendo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyo.ki;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyo.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyo.tsuchishoNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護期別徴収猶予のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT2007KibetsuChoshuYuyoDac implements IModifiable<DbT2007KibetsuChoshuYuyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護期別徴収猶予を取得します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @param 処理日時 ShoriTimestamp
     * @param 徴収方法 ChoshuHoho
     * @param 期 Ki
     * @return DbT2007KibetsuChoshuYuyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2007KibetsuChoshuYuyoEntity selectByKey(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            RDateTime 処理日時,
            RString 徴収方法,
            int 期) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        requireNonNull(期, UrSystemErrorMessages.値がnull.getReplacedMessage("期"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2007KibetsuChoshuYuyo.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(shoriTimestamp, 処理日時),
                                eq(choshuHoho, 徴収方法),
                                eq(ki, 期))).
                toObject(DbT2007KibetsuChoshuYuyoEntity.class);
    }

    /**
     * 介護期別徴収猶予を全件返します。
     *
     * @return List<DbT2007KibetsuChoshuYuyoEntity>
     */
    @Transaction
    public List<DbT2007KibetsuChoshuYuyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2007KibetsuChoshuYuyo.class).
                toList(DbT2007KibetsuChoshuYuyoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT2007KibetsuChoshuYuyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT2007KibetsuChoshuYuyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT2007KibetsuChoshuYuyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT2007KibetsuChoshuYuyoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT2007KibetsuChoshuYuyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
