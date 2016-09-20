/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3061KagoKetteiMeisai;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3061KagoKetteiMeisai.hokenshaKubun;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3061KagoKetteiMeisai.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3061KagoKetteiMeisai.toriatsukaiYM;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3061KagoKetteiMeisai.torikomiYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3061KagoKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 過誤決定明細のデータアクセスクラスです。
 *
 * @reamsid_L DBC-0980-301 surun
 */
public class DbT3061KagoKetteiMeisaiDac implements ISaveable<DbT3061KagoKetteiMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで過誤決定明細を取得します。
     *
     * @param 取扱年月 ToriatsukaiYM
     * @param 保険者区分 HokenshaKubun
     * @param 履歴番号 RirekiNo
     * @return DbT3061KagoKetteiMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3061KagoKetteiMeisaiEntity selectByKey(
            FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            int 履歴番号) throws NullPointerException {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3061KagoKetteiMeisai.class).
                where(and(
                                eq(toriatsukaiYM, 取扱年月),
                                eq(hokenshaKubun, 保険者区分),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3061KagoKetteiMeisaiEntity.class);
    }

    /**
     * selectByKey。
     *
     * @param 取込年月 ToriatsukaiYM
     * @param 保険者区分 HokenshaKubun
     * @return DbT3061KagoKetteiMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT3061KagoKetteiMeisaiEntity> selectByKey(
            FlexibleYearMonth 取込年月,
            RString 保険者区分) throws NullPointerException {
        requireNonNull(取込年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取込年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3061KagoKetteiMeisai.class).
                where(and(
                                eq(torikomiYM, 取込年月),
                                eq(hokenshaKubun, 保険者区分))).
                toList(DbT3061KagoKetteiMeisaiEntity.class);
    }

    /**
     * DbT3078ShokanJuryoininKeiyakushaEntityを登録します。状態によってdelete処理に振り分けられます。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Transaction
    public int delete(DbT3061KagoKetteiMeisaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤決定明細エンティティ"));
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 過誤決定明細を全件返します。
     *
     * @return List<DbT3061KagoKetteiMeisaiEntity>
     */
    @Transaction
    public List<DbT3061KagoKetteiMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3061KagoKetteiMeisai.class).
                toList(DbT3061KagoKetteiMeisaiEntity.class);
    }

    /**
     * DbT3061KagoKetteiMeisaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3061KagoKetteiMeisaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤決定明細エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
