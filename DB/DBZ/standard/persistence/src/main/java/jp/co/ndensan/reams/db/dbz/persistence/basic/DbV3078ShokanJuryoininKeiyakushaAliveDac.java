/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3078ShokanJuryoininKeiyakusha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3078ShokanJuryoininKeiyakusha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3078ShokanJuryoininKeiyakusha.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3078ShokanJuryoininKeiyakusha.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3078ShokanJuryoininKeiyakusha.uketsukeYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 還受領委任契約者Aliveのデータアクセスクラスです。
 */
public class DbV3078ShokanJuryoininKeiyakushaAliveDac implements ISaveable<DbV3078ShokanJuryoininKeiyakushaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで還受領委任契約者Aliveを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 証記載保険者番号 証記載保険者番号
     * @param 受付年月日 受付年月日
     * @param 履歴番号 履歴番号
     * @return DbV3078ShokanJuryoininKeiyakushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV3078ShokanJuryoininKeiyakushaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            FlexibleDate 受付年月日,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3078ShokanJuryoininKeiyakusha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(uketsukeYMD, 受付年月日),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbV3078ShokanJuryoininKeiyakushaEntity.class);
    }

    /**
     * 還受領委任契約者Aliveを全件返します。
     *
     * @return DbV3078ShokanJuryoininKeiyakushaEntityの{@code list}
     */
    @Transaction
    public List<DbV3078ShokanJuryoininKeiyakushaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3078ShokanJuryoininKeiyakusha.class).
                toList(DbV3078ShokanJuryoininKeiyakushaEntity.class);
    }

    /**
     * DbV3078ShokanJuryoininKeiyakushaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV3078ShokanJuryoininKeiyakushaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("還受領委任契約者Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
