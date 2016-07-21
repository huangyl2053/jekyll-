/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2020ShotokuShokaihyoHakkoRireki;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2020ShotokuShokaihyoHakkoRireki.rirekiNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2020ShotokuShokaihyoHakkoRireki.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2020ShotokuShokaihyoHakkoRireki.shoriNendo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2020ShotokuShokaihyoHakkoRirekiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 所得照会票発行履歴のデータアクセスクラスです。
 *
 * @reamsid_L DBB-1720-050 lijunjun
 */
public class DbT2020ShotokuShokaihyoHakkoRirekiDac implements ISaveable<DbT2020ShotokuShokaihyoHakkoRirekiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで所得照会票発行履歴を取得します。
     *
     * @param 照会年度 照会年度
     * @param 識別コード 識別コード
     * @param 履歴番号 履歴番号
     * @return DbT2020ShotokuShokaihyoHakkoRirekiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2020ShotokuShokaihyoHakkoRirekiEntity selectByKey(
            FlexibleYear 照会年度,
            ShikibetsuCode 識別コード,
            int 履歴番号) throws NullPointerException {
        requireNonNull(照会年度, UrSystemErrorMessages.値がnull.getReplacedMessage("照会年度"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2020ShotokuShokaihyoHakkoRireki.class).
                where(and(
                                eq(shoriNendo, 照会年度),
                                eq(shikibetsuCode, 識別コード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT2020ShotokuShokaihyoHakkoRirekiEntity.class);
    }

    /**
     * 所得照会票発行履歴を全件返します。
     *
     * @return DbT2020ShotokuShokaihyoHakkoRirekiEntityの{@code list}
     */
    @Transaction
    public List<DbT2020ShotokuShokaihyoHakkoRirekiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2020ShotokuShokaihyoHakkoRireki.class).
                toList(DbT2020ShotokuShokaihyoHakkoRirekiEntity.class);
    }

    /**
     * DbT2020ShotokuShokaihyoHakkoRirekiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2020ShotokuShokaihyoHakkoRirekiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("所得照会票発行履歴エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 履歴番号を取得します。
     *
     * @param 照会年度 照会年度
     * @param 識別コード 識別コード
     * @return DbT2020ShotokuShokaihyoHakkoRirekiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2020ShotokuShokaihyoHakkoRirekiEntity select履歴番号(
            FlexibleYear 照会年度,
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(照会年度, UrSystemErrorMessages.値がnull.getReplacedMessage("照会年度"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2020ShotokuShokaihyoHakkoRireki.class).
                where(and(
                                eq(shoriNendo, 照会年度),
                                eq(shikibetsuCode, 識別コード))).order(by(rirekiNo))
                .limit(1).toObject(DbT2020ShotokuShokaihyoHakkoRirekiEntity.class);
    }

    /**
     * selectBySomeKey
     *
     * @param 照会年度 FlexibleYear
     * @param 識別コード ShikibetsuCode
     * @return DbT2020ShotokuShokaihyoHakkoRirekiEntity
     * @throws NullPointerException
     */
    @Transaction
    public DbT2020ShotokuShokaihyoHakkoRirekiEntity selectBySomeKey(
            FlexibleYear 照会年度,
            ShikibetsuCode 識別コード) throws NullPointerException {
        requireNonNull(照会年度, UrSystemErrorMessages.値がnull.getReplacedMessage("照会年度"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(rirekiNo)).
                table(DbT2020ShotokuShokaihyoHakkoRireki.class).
                where(and(
                                eq(shoriNendo, 照会年度),
                                eq(shikibetsuCode, 識別コード))).
                toObject(DbT2020ShotokuShokaihyoHakkoRirekiEntity.class);
    }
}
