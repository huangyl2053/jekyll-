/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3066ShichosonTokubetuKyufuService;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3066ShichosonTokubetuKyufuService.serviceCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3066ShichosonTokubetuKyufuService.serviceYukoKikanKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3066ShichosonTokubetuKyufuService.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3066ShichosonTokubetuKyufuServiceEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村特別給付サービス内容のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3066ShichosonTokubetuKyufuServiceDac implements IModifiable<DbT3066ShichosonTokubetuKyufuServiceEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで市町村特別給付サービス内容を取得します。
     *
     * @param 市町村特別給付用サービスコード ServiceCode
     * @param 市町村特別給付用サービス有効期間開始年月日 ServiceYukoKikanKaishiYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3066ShichosonTokubetuKyufuServiceEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3066ShichosonTokubetuKyufuServiceEntity selectByKey(
            RString 市町村特別給付用サービスコード,
            FlexibleDate 市町村特別給付用サービス有効期間開始年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        requireNonNull(市町村特別給付用サービス有効期間開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービス有効期間開始年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3066ShichosonTokubetuKyufuService.class).
                where(and(
                                eq(serviceCode, 市町村特別給付用サービスコード),
                                eq(serviceYukoKikanKaishiYMD, 市町村特別給付用サービス有効期間開始年月日),
                                eq(shoriTimestamp, 処理日時))).
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
     * 市町村特別給付サービス内容を追加します。
     *
     * @param entity 市町村特別給付サービス内容
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3066ShichosonTokubetuKyufuServiceEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 市町村特別給付サービス内容をDBに更新します。
     *
     * @param entity 市町村特別給付サービス内容
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3066ShichosonTokubetuKyufuServiceEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 市町村特別給付サービス内容をDBから削除します。（論理削除）
     *
     * @param entity 市町村特別給付サービス内容
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3066ShichosonTokubetuKyufuServiceEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 市町村特別給付サービス内容を物理削除。
     *
     * @param entity 市町村特別給付サービス内容
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3066ShichosonTokubetuKyufuServiceEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
