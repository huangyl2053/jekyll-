/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3062SaishinsaMoshitate;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3062SaishinsaMoshitate.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3062SaishinsaMoshitate.jigyoshoNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3062SaishinsaMoshitate.serviceKomokuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3062SaishinsaMoshitate.serviceTeikyoShuruiCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3062SaishinsaMoshitate.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3062SaishinsaMoshitate.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 再審査申立のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3062SaishinsaMoshitateDac implements IModifiable<DbT3062SaishinsaMoshitateEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで再審査申立を取得します。
     *
     * @param 事業所番号 JigyoshoNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param サービス種類コード ServiceTeikyoShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @param 処理日時 ShoriTimestamp
     * @return DbT3062SaishinsaMoshitateEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3062SaishinsaMoshitateEntity selectByKey(
            JigyoshaNo 事業所番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3062SaishinsaMoshitate.class).
                where(and(
                                eq(jigyoshoNo, 事業所番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(serviceTeikyoShuruiCode, サービス種類コード),
                                eq(serviceKomokuCode, サービス項目コード),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3062SaishinsaMoshitateEntity.class);
    }

    /**
     * 再審査申立を全件返します。
     *
     * @return List<DbT3062SaishinsaMoshitateEntity>
     */
    @Transaction
    public List<DbT3062SaishinsaMoshitateEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3062SaishinsaMoshitate.class).
                toList(DbT3062SaishinsaMoshitateEntity.class);
    }

    /**
     * 再審査申立を追加します。
     *
     * @param entity 再審査申立
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3062SaishinsaMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 再審査申立をDBに更新します。
     *
     * @param entity 再審査申立
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3062SaishinsaMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 再審査申立をDBから削除します。（論理削除）
     *
     * @param entity 再審査申立
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3062SaishinsaMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 再審査申立を物理削除。
     *
     * @param entity 再審査申立
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3062SaishinsaMoshitateEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
