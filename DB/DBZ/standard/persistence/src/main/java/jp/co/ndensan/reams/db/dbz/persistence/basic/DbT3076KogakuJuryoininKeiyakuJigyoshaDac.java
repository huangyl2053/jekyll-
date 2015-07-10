/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3076KogakuJuryoininKeiyakuJigyosha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3076KogakuJuryoininKeiyakuJigyosha.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3076KogakuJuryoininKeiyakuJigyosha.shikibetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3076KogakuJuryoininKeiyakuJigyosha.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3076KogakuJuryoininKeiyakuJigyosha.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3076KogakuJuryoininKeiyakuJigyosha.uketsukeYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額受領委任契約事業者のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3076KogakuJuryoininKeiyakuJigyoshaDac implements IModifiable<DbT3076KogakuJuryoininKeiyakuJigyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額受領委任契約事業者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 受付年月日 UketsukeYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3076KogakuJuryoininKeiyakuJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3076KogakuJuryoininKeiyakuJigyoshaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            ShikibetsuCode 識別コード,
            HokenshaNo 証記載保険者番号,
            FlexibleDate 受付年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("受付年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3076KogakuJuryoininKeiyakuJigyosha.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shikibetsuCode, 識別コード),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(uketsukeYMD, 受付年月日),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity.class);
    }

    /**
     * 高額受領委任契約事業者を全件返します。
     *
     * @return List<DbT3076KogakuJuryoininKeiyakuJigyoshaEntity>
     */
    @Transaction
    public List<DbT3076KogakuJuryoininKeiyakuJigyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3076KogakuJuryoininKeiyakuJigyosha.class).
                toList(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity.class);
    }

    /**
     * 高額受領委任契約事業者を追加します。
     *
     * @param entity 高額受領委任契約事業者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額受領委任契約事業者をDBに更新します。
     *
     * @param entity 高額受領委任契約事業者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額受領委任契約事業者をDBから削除します。（論理削除）
     *
     * @param entity 高額受領委任契約事業者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額受領委任契約事業者を物理削除。
     *
     * @param entity 高額受領委任契約事業者
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
