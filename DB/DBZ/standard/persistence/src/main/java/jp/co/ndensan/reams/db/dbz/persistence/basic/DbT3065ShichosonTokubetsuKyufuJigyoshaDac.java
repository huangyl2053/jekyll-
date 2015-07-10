/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3065ShichosonTokubetsuKyufuJigyosha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3065ShichosonTokubetsuKyufuJigyosha.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3065ShichosonTokubetsuKyufuJigyosha.serviceCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3065ShichosonTokubetsuKyufuJigyosha.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村特別給付サービス事業者のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3065ShichosonTokubetsuKyufuJigyoshaDac implements IModifiable<DbT3065ShichosonTokubetsuKyufuJigyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで市町村特別給付サービス事業者を取得します。
     *
     * @param 市町村特別給付用事業者番号 JigyoshaNo
     * @param 市町村特別給付用サービスコード ServiceCode
     * @param 処理日時 ShoriTimestamp
     * @return DbT3065ShichosonTokubetsuKyufuJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3065ShichosonTokubetsuKyufuJigyoshaEntity selectByKey(
            JigyoshaNo 市町村特別給付用事業者番号,
            ServiceCode 市町村特別給付用サービスコード,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(市町村特別給付用事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用事業者番号"));
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3065ShichosonTokubetsuKyufuJigyosha.class).
                where(and(
                                eq(jigyoshaNo, 市町村特別給付用事業者番号),
                                eq(serviceCode, 市町村特別給付用サービスコード),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity.class);
    }

    /**
     * 市町村特別給付サービス事業者を全件返します。
     *
     * @return List<DbT3065ShichosonTokubetsuKyufuJigyoshaEntity>
     */
    @Transaction
    public List<DbT3065ShichosonTokubetsuKyufuJigyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3065ShichosonTokubetsuKyufuJigyosha.class).
                toList(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity.class);
    }

    /**
     * 市町村特別給付サービス事業者を追加します。
     *
     * @param entity 市町村特別給付サービス事業者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 市町村特別給付サービス事業者をDBに更新します。
     *
     * @param entity 市町村特別給付サービス事業者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 市町村特別給付サービス事業者をDBから削除します。（論理削除）
     *
     * @param entity 市町村特別給付サービス事業者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 市町村特別給付サービス事業者を物理削除。
     *
     * @param entity 市町村特別給付サービス事業者
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
