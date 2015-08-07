/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3060KagoKetteiShukei;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3060KagoKetteiShukei.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3060KagoKetteiShukeiEntity;
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
 * 過誤決定集計のデータアクセスクラスです。
 */
public class DbT3060KagoKetteiShukeiDac implements ISaveable<DbT3060KagoKetteiShukeiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで過誤決定集計を取得します。
     *
     * @param 取扱年月 ToriatsukaiYM
     * @param 保険者区分 HokenshaKubun
     * @param 履歴番号 RirekiNo
     * @return DbT3060KagoKetteiShukeiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3060KagoKetteiShukeiEntity selectByKey(
            FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3060KagoKetteiShukei.class).
                where(and(
                eq(toriatsukaiYM, 取扱年月),
                eq(hokenshaKubun, 保険者区分),
                eq(rirekiNo, 履歴番号))).
                toObject(DbT3060KagoKetteiShukeiEntity.class);
    }

    /**
     * 過誤決定集計を全件返します。
     *
     * @return List<DbT3060KagoKetteiShukeiEntity>
     */
    @Transaction
    public List<DbT3060KagoKetteiShukeiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3060KagoKetteiShukei.class).
                toList(DbT3060KagoKetteiShukeiEntity.class);
    }

    /**
     * DbT3060KagoKetteiShukeiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3060KagoKetteiShukeiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤決定集計エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
