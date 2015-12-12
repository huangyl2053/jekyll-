/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3045ShokanServicePlan200004;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3045ShokanServicePlan200004Entity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
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
}
