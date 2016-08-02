/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukei;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukei.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修理由書作成手数料請求集計のデータアクセスクラスです。
 */
public class DbT3096JutakuKaishuRiyushoTesuryoShukeiDac implements ISaveable<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで住宅改修理由書作成手数料請求集計を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 集計開始年月 ShukeiKaishiYM
     * @param 履歴番号 RirekiNo
     * @return DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity selectByKey(
            HokenshaNo 証記載保険者番号,
            FlexibleYearMonth 集計開始年月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(集計開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3096JutakuKaishuRiyushoTesuryoShukei.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shukeiKaishiYM, 集計開始年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class);
    }

    /**
     * 住宅改修理由書作成手数料請求集計を全件返します。
     *
     * @return List<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity>
     */
    @Transaction
    public List<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3096JutakuKaishuRiyushoTesuryoShukei.class).
                toList(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class);
    }

    /**
     * DbT3096JutakuKaishuRiyushoTesuryoShukeiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修理由書作成手数料請求集計エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
