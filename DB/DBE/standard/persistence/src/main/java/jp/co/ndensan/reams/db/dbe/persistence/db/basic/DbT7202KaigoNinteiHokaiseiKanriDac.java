/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanri;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanri.hokaiseiShikoYMD;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT7202KaigoNinteiHokaiseiKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.lt;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定法改正管理のデータアクセスクラスです。
 */
public class DbT7202KaigoNinteiHokaiseiKanriDac implements ISaveable<DbT7202KaigoNinteiHokaiseiKanriEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定法改正管理を取得します。
     *
     * @param 法改正施行年月日 法改正施行年月日
     * @return DbT7202KaigoNinteiHokaiseiKanriEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7202KaigoNinteiHokaiseiKanriEntity selectByKey(
            FlexibleDate 法改正施行年月日) throws NullPointerException {
        requireNonNull(法改正施行年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("法改正施行年月日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7202KaigoNinteiHokaiseiKanri.class).
                where(
                        eq(hokaiseiShikoYMD, 法改正施行年月日)).
                toObject(DbT7202KaigoNinteiHokaiseiKanriEntity.class);
    }

    /**
     * 介護認定法改正管理を全件返します。
     *
     * @return DbT7202KaigoNinteiHokaiseiKanriEntityの{@code list}
     */
    @Transaction
    public List<DbT7202KaigoNinteiHokaiseiKanriEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7202KaigoNinteiHokaiseiKanri.class).
                toList(DbT7202KaigoNinteiHokaiseiKanriEntity.class);
    }

    /**
     * DbT7202KaigoNinteiHokaiseiKanriEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7202KaigoNinteiHokaiseiKanriEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定法改正管理エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主キーで介護認定法改正管理Listを取得します。
     *
     * @param システム日付 システム日付
     * @return List<DbT7202KaigoNinteiHokaiseiKanriEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7202KaigoNinteiHokaiseiKanriEntity> selectListByKey(
            FlexibleDate システム日付) throws NullPointerException {
        requireNonNull(システム日付, UrSystemErrorMessages.値がnull.getReplacedMessage("システム日付"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7202KaigoNinteiHokaiseiKanri.class).
                where(
                        lt(システム日付, hokaiseiShikoYMD)).
                toList(DbT7202KaigoNinteiHokaiseiKanriEntity.class);
    }
}
