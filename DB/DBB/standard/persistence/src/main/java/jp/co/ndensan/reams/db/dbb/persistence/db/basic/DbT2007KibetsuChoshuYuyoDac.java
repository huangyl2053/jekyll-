/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyo.choshuHoho;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyo.choteiNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyo.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyo.ki;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyo.rirekiNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyo.tsuchishoNo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2007KibetsuChoshuYuyoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護期別徴収猶予のデータアクセスクラスです。
 */
public class DbT2007KibetsuChoshuYuyoDac implements ISaveable<DbT2007KibetsuChoshuYuyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護期別徴収猶予を取得します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FukaNendo
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 RirekiNo
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
            int 履歴番号,
            RString 徴収方法,
            int 期) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));
        requireNonNull(期, UrSystemErrorMessages.値がnull.getReplacedMessage("期"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2007KibetsuChoshuYuyo.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(rirekiNo, 履歴番号),
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

    /**
     * DbT2007KibetsuChoshuYuyoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2007KibetsuChoshuYuyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別徴収猶予エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT2007KibetsuChoshuYuyoEntityを削除します。物理削除する。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT2007KibetsuChoshuYuyoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別徴収猶予エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
