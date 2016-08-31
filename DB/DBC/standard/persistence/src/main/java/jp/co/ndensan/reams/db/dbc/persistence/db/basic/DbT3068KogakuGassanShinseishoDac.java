/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseisho;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseisho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseisho.hokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseisho.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseisho.seiriNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseisho.taishoNendo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3068KogakuGassanShinseishoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算申請書のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 huzongcheng
 */
public class DbT3068KogakuGassanShinseishoDac implements ISaveable<DbT3068KogakuGassanShinseishoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額合算申請書を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 整理番号 SeiriNo
     * @param 履歴番号 RirekiNo
     * @return DbT3068KogakuGassanShinseishoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3068KogakuGassanShinseishoEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 整理番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3068KogakuGassanShinseisho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(seiriNo, 整理番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3068KogakuGassanShinseishoEntity.class);
    }

    /**
     * 高額合算申請書を取得します。
     *
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 整理番号 SeiriNo
     * @param 履歴番号 RirekiNo
     * @return List<DbT3068KogakuGassanShinseishoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3068KogakuGassanShinseishoEntity> selectByItems(
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 整理番号,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3068KogakuGassanShinseisho.class).
                where(and(
                                eq(taishoNendo, 対象年度),
                                eq(hokenshaNo, 保険者番号),
                                eq(seiriNo, 整理番号),
                                eq(rirekiNo, 履歴番号))).
                order(by(seiriNo, Order.DESC),
                        by(hihokenshaNo, Order.DESC)).
                toList(DbT3068KogakuGassanShinseishoEntity.class);
    }

    /**
     * 高額合算申請書を全件返します。
     *
     * @return List<DbT3068KogakuGassanShinseishoEntity>
     */
    @Transaction
    public List<DbT3068KogakuGassanShinseishoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3068KogakuGassanShinseisho.class).
                toList(DbT3068KogakuGassanShinseishoEntity.class);
    }

    /**
     * DbT3068KogakuGassanShinseishoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3068KogakuGassanShinseishoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算申請書エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
