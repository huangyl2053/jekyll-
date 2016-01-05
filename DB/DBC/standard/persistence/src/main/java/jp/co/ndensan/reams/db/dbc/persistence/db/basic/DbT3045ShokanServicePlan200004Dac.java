/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.syokanbaraikettejoho.SyokanbaraiketteJohoParameter;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3045ShokanServicePlan200004;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3045ShokanServicePlan200004.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3045ShokanServicePlan200004.seiriNp;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3045ShokanServicePlan200004.serviceTeikyoYM;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求サービス計画200004のデータアクセスクラスです。
 */
public class DbT3045ShokanServicePlan200004Dac implements ISaveable<DbT3045ShokanServicePlan200004Entity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで償還払請求サービス計画200004を取得します。
     *
     *
     * @return DbT3045ShokanServicePlan200004Entity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3045ShokanServicePlan200004Entity selectByKey() throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3045ShokanServicePlan200004.class).
                toObject(DbT3045ShokanServicePlan200004Entity.class);
    }

    /**
     * 償還払請求サービス計画200004を全件返します。
     *
     * @return List<DbT3045ShokanServicePlan200004Entity>
     */
    @Transaction
    public List<DbT3045ShokanServicePlan200004Entity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3045ShokanServicePlan200004.class).
                toList(DbT3045ShokanServicePlan200004Entity.class);
    }

    /**
     * DbT3045ShokanServicePlan200004Entityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3045ShokanServicePlan200004Entity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求サービス計画200004エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * サービス提供年月により、決定理由情報などを抽出します。
     *
     * @param parameter 償還払決定一覧検索用MyBatisパラメータ
     * @return 決定理由情報
     */
    @Transaction
    public DbT3045ShokanServicePlan200004Entity select決定理由情報(SyokanbaraiketteJohoParameter parameter) {
        requireNonNull(parameter.getHiHokenshaNo(), UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(parameter.getServiceTeikyoYM(), UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(parameter.getSeiriNo(), UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3045ShokanServicePlan200004.class).
                where(and(
                                eq(hiHokenshaNo, parameter.getHiHokenshaNo()),
                                eq(serviceTeikyoYM, parameter.getServiceTeikyoYM()),
                                eq(seiriNp, parameter.getSeiriNo())))
                .order(by(DbT3045ShokanServicePlan200004.jigyoshaNo, Order.DESC),
                        by(DbT3045ShokanServicePlan200004.yoshikiNo, Order.DESC)).limit(1).
                toObject(DbT3045ShokanServicePlan200004Entity.class);
    }
}
