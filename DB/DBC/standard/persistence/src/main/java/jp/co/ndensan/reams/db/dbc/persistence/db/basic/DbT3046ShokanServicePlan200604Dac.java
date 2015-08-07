/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3046ShokanServicePlan200604Entity;
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
 * 償還払請求サービス計画200604のデータアクセスクラスです。
 */
public class DbT3046ShokanServicePlan200604Dac implements ISaveable<DbT3046ShokanServicePlan200604Entity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで償還払請求サービス計画200604を取得します。
     *

     * @return DbT3046ShokanServicePlan200604Entity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3046ShokanServicePlan200604Entity selectByKey(
) throws NullPointerException {


        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3046ShokanServicePlan200604.class).
                where(and(
)).
                toObject(DbT3046ShokanServicePlan200604Entity.class);
    }

    /**
     * 償還払請求サービス計画200604を全件返します。
     *
     * @return List<DbT3046ShokanServicePlan200604Entity>
     */
    @Transaction
    public List<DbT3046ShokanServicePlan200604Entity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3046ShokanServicePlan200604.class).
                toList(DbT3046ShokanServicePlan200604Entity.class);
    }

    /**
     * DbT3046ShokanServicePlan200604Entityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3046ShokanServicePlan200604Entity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求サービス計画200604エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
