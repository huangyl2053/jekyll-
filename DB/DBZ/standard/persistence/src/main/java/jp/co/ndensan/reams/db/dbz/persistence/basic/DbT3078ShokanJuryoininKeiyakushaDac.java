/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3078ShokanJuryoininKeiyakusha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3078ShokanJuryoininKeiyakusha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3078ShokanJuryoininKeiyakusha.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3078ShokanJuryoininKeiyakusha.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3078ShokanJuryoininKeiyakusha.uketsukeYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3078ShokanJuryoininKeiyakushaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還受領委任契約者のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3078ShokanJuryoininKeiyakushaDac implements IModifiable<DbT3078ShokanJuryoininKeiyakushaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで償還受領委任契約者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3078ShokanJuryoininKeiyakushaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3078ShokanJuryoininKeiyakushaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            ShoKisaiHokenshaNo 証記載保険者番号,
            FlexibleDate 受付年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3078ShokanJuryoininKeiyakusha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(uketsukeYMD, 受付年月日),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3078ShokanJuryoininKeiyakushaEntity.class);
    }

    /**
     * 償還受領委任契約者を全件返します。
     *
     * @return List<DbT3078ShokanJuryoininKeiyakushaEntity>
     */
    @Transaction
    public List<DbT3078ShokanJuryoininKeiyakushaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3078ShokanJuryoininKeiyakusha.class).
                toList(DbT3078ShokanJuryoininKeiyakushaEntity.class);
    }

    /**
     * 償還受領委任契約者を追加します。
     *
     * @param entity 償還受領委任契約者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3078ShokanJuryoininKeiyakushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 償還受領委任契約者をDBに更新します。
     *
     * @param entity 償還受領委任契約者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3078ShokanJuryoininKeiyakushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 償還受領委任契約者をDBから削除します。（論理削除）
     *
     * @param entity 償還受領委任契約者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3078ShokanJuryoininKeiyakushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 償還受領委任契約者を物理削除。
     *
     * @param entity 償還受領委任契約者
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3078ShokanJuryoininKeiyakushaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
