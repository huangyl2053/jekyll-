/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKettei;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKettei.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修理由書作成手数料請求決定のデータアクセスクラスです。
 */
public class DbT3094JutakuKaishuRiyushoTesuryoKetteiDac implements ISaveable<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで住宅改修理由書作成手数料請求決定を取得します。
     *
     * @param 介護住宅改修理由書作成事業者番号 RiyushoSakuseiJigyoshaNo
     * @param 決定年月日 KetteiYMD
     * @param 履歴番号 RirekiNo
     * @return DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity selectByKey(
            JigyoshaNo 介護住宅改修理由書作成事業者番号,
            FlexibleDate 決定年月日,
            int 履歴番号) throws NullPointerException {
        requireNonNull(介護住宅改修理由書作成事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成事業者番号"));
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3094JutakuKaishuRiyushoTesuryoKettei.class).
                where(and(
                                eq(riyushoSakuseiJigyoshaNo, 介護住宅改修理由書作成事業者番号),
                                eq(ketteiYMD, 決定年月日),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class);
    }

    /**
     * 住宅改修理由書作成手数料請求決定を全件返します。
     *
     * @return List<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity>
     */
    @Transaction
    public List<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3094JutakuKaishuRiyushoTesuryoKettei.class).
                toList(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class);
    }

    /**
     * DbT3094JutakuKaishuRiyushoTesuryoKetteiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("住宅改修理由書作成手数料請求決定エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
