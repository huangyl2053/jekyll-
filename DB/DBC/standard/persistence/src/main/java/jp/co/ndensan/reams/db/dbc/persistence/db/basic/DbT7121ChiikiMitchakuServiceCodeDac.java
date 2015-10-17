/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7121ChiikiMitchakuServiceCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7121ChiikiMitchakuServiceCode.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7121ChiikiMitchakuServiceCode.serviceKomokuCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7121ChiikiMitchakuServiceCode.serviceShuruiCode;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7121ChiikiMitchakuServiceCode.tekiyoKaishiYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT7121ChiikiMitchakuServiceCodeEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceKomokuCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
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
 * 地域密着型介護サービスコードのデータアクセスクラスです。
 */
public class DbT7121ChiikiMitchakuServiceCodeDac implements ISaveable<DbT7121ChiikiMitchakuServiceCodeEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで地域密着型介護サービスコードを取得します。
     *
     * @param サービス種類コード ServiceShuruiCode
     * @param サービス項目コード ServiceKomokuCode
     * @param 適用開始年月 TekiyoKaishiYM
     * @param 履歴番号 RirekiNo
     * @return DbT7121ChiikiMitchakuServiceCodeEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7121ChiikiMitchakuServiceCodeEntity selectByKey(
            ServiceShuruiCode サービス種類コード,
            ServiceKomokuCode サービス項目コード,
            FlexibleYearMonth 適用開始年月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(適用開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("適用開始年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7121ChiikiMitchakuServiceCode.class).
                where(and(
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(serviceKomokuCode, サービス項目コード),
                                eq(tekiyoKaishiYM, 適用開始年月),
                                eq(rirekiNo, 履歴番号))).
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
     * DbT7121ChiikiMitchakuServiceCodeEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7121ChiikiMitchakuServiceCodeEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("地域密着型介護サービスコードエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
