/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitate;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitate.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3062SaishinsaMoshitateEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 再審査申立のデータアクセスクラスです。
 */
public class DbT3062SaishinsaMoshitateDac implements ISaveable<DbT3062SaishinsaMoshitateEntity> {

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
     * @param 履歴番号 RirekiNo
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
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(サービス項目コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス項目コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3062SaishinsaMoshitate.class).
                where(and(
                eq(jigyoshoNo, 事業所番号),
                eq(hiHokenshaNo, 被保険者番号),
                eq(serviceTeikyoYM, サービス提供年月),
                eq(serviceTeikyoShuruiCode, サービス種類コード),
                eq(serviceKomokuCode, サービス項目コード),
                eq(rirekiNo, 履歴番号))).
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
     * DbT3062SaishinsaMoshitateEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3062SaishinsaMoshitateEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査申立エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
