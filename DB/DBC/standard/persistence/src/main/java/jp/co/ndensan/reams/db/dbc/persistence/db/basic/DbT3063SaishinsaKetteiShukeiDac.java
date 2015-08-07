/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3063SaishinsaKetteiShukei;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3063SaishinsaKetteiShukei.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3063SaishinsaKetteiShukeiEntity;
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
 * 再審査決定集計のデータアクセスクラスです。
 */
public class DbT3063SaishinsaKetteiShukeiDac implements ISaveable<DbT3063SaishinsaKetteiShukeiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで再審査決定集計を取得します。
     *
     * @param 取扱年月 ToriatsukaiYM
     * @param 保険者区分 HokenshaKubun
     * @param 履歴番号 RirekiNo
     * @return DbT3063SaishinsaKetteiShukeiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3063SaishinsaKetteiShukeiEntity selectByKey(
            FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            Decimal 履歴番号) throws NullPointerException {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3063SaishinsaKetteiShukei.class).
                where(and(
                eq(toriatsukaiYM, 取扱年月),
                eq(hokenshaKubun, 保険者区分),
                eq(rirekiNo, 履歴番号))).
                toObject(DbT3063SaishinsaKetteiShukeiEntity.class);
    }

    /**
     * 再審査決定集計を全件返します。
     *
     * @return List<DbT3063SaishinsaKetteiShukeiEntity>
     */
    @Transaction
    public List<DbT3063SaishinsaKetteiShukeiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3063SaishinsaKetteiShukei.class).
                toList(DbT3063SaishinsaKetteiShukeiEntity.class);
    }

    /**
     * DbT3063SaishinsaKetteiShukeiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3063SaishinsaKetteiShukeiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査決定集計エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
