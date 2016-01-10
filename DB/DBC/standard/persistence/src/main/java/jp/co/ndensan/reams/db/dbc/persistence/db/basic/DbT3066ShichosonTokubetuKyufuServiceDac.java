/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuService;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuService.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村特別給付サービス内容のデータアクセスクラスです。
 */
public class DbT3066ShichosonTokubetuKyufuServiceDac implements ISaveable<DbT3066ShichosonTokubetuKyufuServiceEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで市町村特別給付サービス内容を取得します。
     *
     * @param 市町村特別給付用サービスコード ServiceCode
     * @param 市町村特別給付用サービス有効期間開始年月日 ServiceYukoKikanKaishiYMD
     * @param 履歴番号 RirekiNo
     * @return DbT3066ShichosonTokubetuKyufuServiceEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3066ShichosonTokubetuKyufuServiceEntity selectByKey(
            RString 市町村特別給付用サービスコード,
            FlexibleDate 市町村特別給付用サービス有効期間開始年月日,
            int 履歴番号) throws NullPointerException {
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        requireNonNull(市町村特別給付用サービス有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス有効期間開始年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3066ShichosonTokubetuKyufuService.class).
                where(and(
                                eq(serviceCode, 市町村特別給付用サービスコード),
                                eq(serviceYukoKikanKaishiYMD, 市町村特別給付用サービス有効期間開始年月日),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3066ShichosonTokubetuKyufuServiceEntity.class);
    }

    /**
     * 市町村特別給付サービス内容を全件返します。
     *
     * @return List<DbT3066ShichosonTokubetuKyufuServiceEntity>
     */
    @Transaction
    public List<DbT3066ShichosonTokubetuKyufuServiceEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3066ShichosonTokubetuKyufuService.class).
                toList(DbT3066ShichosonTokubetuKyufuServiceEntity.class);
    }

    /**
     * DbT3066ShichosonTokubetuKyufuServiceEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3066ShichosonTokubetuKyufuServiceEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付サービス内容エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
