/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigen;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigen.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigen.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigen.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 社会福祉法人等利用者負担軽減のデータアクセスクラスです。
 */
public class DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで支払方法変更を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @return DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigen.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity.class);
    }

    /**
     * 支払方法変更を全件返します。
     *
     * @return DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntityの{@code list}
     */
    @Transaction
    public List<DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigen.class).
                toList(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity.class);
    }

    /**
     * DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("支払方法変更エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * キーで支払方法変更を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @return DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntityの{@code list}
     */
    @Transaction
    public List<DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity> selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigen.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号))).
                toList(DbT4017ShakaiFukushiHojinRiyoshaFutanKeigenEntity.class);
    }
}
