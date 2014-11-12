/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7121ChiikiMitchakuServiceCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7121ChiikiMitchakuServiceCode.serviceKomokuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7121ChiikiMitchakuServiceCode.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7121ChiikiMitchakuServiceCode.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7121ChiikiMitchakuServiceCode.tekiyoKaishiYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7121ChiikiMitchakuServiceCodeEntity;
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
 * 地域密着型介護サービスコードのデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7121ChiikiMitchakuServiceCodeDac implements IModifiable<DbT7121ChiikiMitchakuServiceCodeEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで地域密着型介護サービスコードを取得します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT7121ChiikiMitchakuServiceCodeEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7121ChiikiMitchakuServiceCodeEntity selectByKey(
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            FlexibleYearMonth 適用開始年月,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7121ChiikiMitchakuServiceCode.class).
                where(and(
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(serviceKomokuCode, サービス項目コード),
                                eq(tekiyoKaishiYM, 適用開始年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT7121ChiikiMitchakuServiceCodeEntity.class);
    }

    /**
     * 地域密着型介護サービスコードを全件返します。
     *
     * @return List<DbT7121ChiikiMitchakuServiceCodeEntity>
     */
    @Transaction
    public List<DbT7121ChiikiMitchakuServiceCodeEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7121ChiikiMitchakuServiceCode.class).
                toList(DbT7121ChiikiMitchakuServiceCodeEntity.class);
    }

    /**
     * 地域密着型介護サービスコードを追加します。
     *
     * @param entity 地域密着型介護サービスコード
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7121ChiikiMitchakuServiceCodeEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 地域密着型介護サービスコードをDBに更新します。
     *
     * @param entity 地域密着型介護サービスコード
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7121ChiikiMitchakuServiceCodeEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 地域密着型介護サービスコードをDBから削除します。（論理削除）
     *
     * @param entity 地域密着型介護サービスコード
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7121ChiikiMitchakuServiceCodeEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 地域密着型介護サービスコードを物理削除。
     *
     * @param entity 地域密着型介護サービスコード
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7121ChiikiMitchakuServiceCodeEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
