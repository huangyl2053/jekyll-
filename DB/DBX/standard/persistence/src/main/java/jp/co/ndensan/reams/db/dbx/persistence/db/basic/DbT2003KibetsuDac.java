/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003Kibetsu;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003Kibetsu.choshuHouhou;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003Kibetsu.choteiNendo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003Kibetsu.fukaNendo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003Kibetsu.ki;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003Kibetsu.rirekiNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003Kibetsu.tsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2003KibetsuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
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
 * 介護期別のデータアクセスクラスです。
 *
 * @reamsid_L DBB-9999-023 wangkanglei
 */
public class DbT2003KibetsuDac implements ISaveable<DbT2003KibetsuEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護期別を取得します。
     *
     * @param 調定年度 ChoteiNendo
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @param 履歴番号 RirekiNo
     * @param 徴収方法 ChoshuHouhou
     * @param 期 Ki
     * @return DbT2003KibetsuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2003KibetsuEntity selectByKey(
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
                table(DbT2003Kibetsu.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(rirekiNo, 履歴番号),
                                eq(choshuHouhou, 徴収方法),
                                eq(ki, 期))).
                toObject(DbT2003KibetsuEntity.class);
    }

    /**
     * 介護期別を全件返します。
     *
     * @return List<DbT2003KibetsuEntity>
     */
    @Transaction
    public List<DbT2003KibetsuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2003Kibetsu.class).
                toList(DbT2003KibetsuEntity.class);
    }

    /**
     * DbT2003KibetsuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2003KibetsuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 介護期別を返します
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 履歴番号 履歴番号
     * @param 通知書番号 通知書番号
     * @return DbT2002FukaEntityの{@code list}
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT2003KibetsuEntity> select介護期別(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2003Kibetsu.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(rirekiNo, 履歴番号))).
                toList(DbT2003KibetsuEntity.class);
    }

    /**
     * 介護期別を返します
     *
     * @param 調定年度 調定年度
     * @param 賦課年度 賦課年度
     * @param 履歴番号 履歴番号
     * @param 通知書番号 通知書番号
     * @param 徴収方法 徴収方法
     * @return DbT2002FukaEntityの{@code list}
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT2003KibetsuEntity> select介護期別(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            int 履歴番号,
            RString 徴収方法) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(徴収方法, UrSystemErrorMessages.値がnull.getReplacedMessage("徴収方法"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2003Kibetsu.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(rirekiNo, 履歴番号),
                                eq(choshuHouhou, 徴収方法))).
                toList(DbT2003KibetsuEntity.class);
    }

    /**
     * DbT2003KibetsuEntityを削除します。状態によってdelete処理に振り分けられます。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT2003KibetsuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
