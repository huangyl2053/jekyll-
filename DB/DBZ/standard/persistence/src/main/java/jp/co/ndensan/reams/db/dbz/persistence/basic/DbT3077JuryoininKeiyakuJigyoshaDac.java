/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3077JuryoininKeiyakuJigyosha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3077JuryoininKeiyakuJigyosha.jigyoshaKeiyakuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3077JuryoininKeiyakuJigyosha.kaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3077JuryoininKeiyakuJigyosha.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受領委任契約事業者のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3077JuryoininKeiyakuJigyoshaDac implements IModifiable<DbT3077JuryoininKeiyakuJigyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで受領委任契約事業者を取得します。
     *
     * @param 事業者契約番号 JigyoshaKeiyakuNo
     * @param 開始年月日 KaishiYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3077JuryoininKeiyakuJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3077JuryoininKeiyakuJigyoshaEntity selectByKey(
            RString 事業者契約番号,
            FlexibleDate 開始年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(事業者契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者契約番号"));
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3077JuryoininKeiyakuJigyosha.class).
                where(and(
                                eq(jigyoshaKeiyakuNo, 事業者契約番号),
                                eq(kaishiYMD, 開始年月日),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3077JuryoininKeiyakuJigyoshaEntity.class);
    }

    /**
     * 受領委任契約事業者を全件返します。
     *
     * @return List<DbT3077JuryoininKeiyakuJigyoshaEntity>
     */
    @Transaction
    public List<DbT3077JuryoininKeiyakuJigyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3077JuryoininKeiyakuJigyosha.class).
                toList(DbT3077JuryoininKeiyakuJigyoshaEntity.class);
    }

    /**
     * 受領委任契約事業者を追加します。
     *
     * @param entity 受領委任契約事業者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 受領委任契約事業者をDBに更新します。
     *
     * @param entity 受領委任契約事業者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 受領委任契約事業者をDBから削除します。（論理削除）
     *
     * @param entity 受領委任契約事業者
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 受領委任契約事業者を物理削除。
     *
     * @param entity 受領委任契約事業者
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3077JuryoininKeiyakuJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
