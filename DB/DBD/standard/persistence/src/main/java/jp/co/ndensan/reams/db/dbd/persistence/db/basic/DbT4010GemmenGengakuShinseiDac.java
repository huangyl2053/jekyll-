/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinsei;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinsei.gemmenGengakuShurui;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinsei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinsei.shinseiRirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinsei.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4010GemmenGengakuShinseiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 減免減額申請のデータアクセスクラスです。
 *
 * @reamsid_L DBD-9999-011 sunhaidi
 */
public class DbT4010GemmenGengakuShinseiDac implements ISaveable<DbT4010GemmenGengakuShinseiEntity> {

    @InjectSession
    private SqlSession session;

    private static final RString 減免減額申請エンティティ = new RString("減免減額申請エンティティ");

    /**
     * 主キーで減免減額申請を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 減免減額種類 減免減額種類
     * @param 履歴番号 履歴番号
     * @return DbT4010GemmenGengakuShinseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4010GemmenGengakuShinseiEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            RString 減免減額種類,
            int 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(減免減額種類, UrSystemErrorMessages.値がnull.getReplacedMessage("減免減額種類"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4010GemmenGengakuShinsei.class).
                where(and(
                        eq(shoKisaiHokenshaNo, 証記載保険者番号),
                        eq(hihokenshaNo, 被保険者番号),
                        eq(gemmenGengakuShurui, 減免減額種類),
                        eq(shinseiRirekiNo, 履歴番号))).
                toObject(DbT4010GemmenGengakuShinseiEntity.class);
    }

    /**
     * 減免減額申請を全件返します。
     *
     * @return DbT4010GemmenGengakuShinseiEntityの{@code list}
     */
    @Transaction
    public List<DbT4010GemmenGengakuShinseiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4010GemmenGengakuShinsei.class).
                toList(DbT4010GemmenGengakuShinseiEntity.class);
    }

    /**
     * DbT4010GemmenGengakuShinseiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4010GemmenGengakuShinseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(減免減額申請エンティティ.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        if (entity.getLastUpdateTimestamp() != null && !EntityDataState.Deleted.equals(entity.getState())) {
            entity.setState(EntityDataState.Modified);
        }
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT4010GemmenGengakuShinseiEntityを登録します。insert処理を行います。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int insert(DbT4010GemmenGengakuShinseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(減免減額申請エンティティ.toString()));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT4010GemmenGengakuShinseiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int saveOrDeletePhysicalBy(DbT4010GemmenGengakuShinseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(減免減額申請エンティティ.toString()));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT4010GemmenGengakuShinseiEntityを物理削除します。
     *
     * @param entity entity
     * @return 物理削除件数
     */
    @Transaction
    public int delete(DbT4010GemmenGengakuShinseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(減免減額申請エンティティ.toString()));
        entity.setState(EntityDataState.Deleted);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
