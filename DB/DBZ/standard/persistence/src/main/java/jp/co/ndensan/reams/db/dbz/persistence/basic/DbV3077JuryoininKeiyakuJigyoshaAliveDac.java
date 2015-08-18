/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3077JuryoininKeiyakuJigyosha;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3077JuryoininKeiyakuJigyosha.jigyoshaKeiyakuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3077JuryoininKeiyakuJigyosha.kaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbV3077JuryoininKeiyakuJigyosha.rirekiNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbV3077JuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受領委任事業者Aliveのデータアクセスクラスです。
 */
public class DbV3077JuryoininKeiyakuJigyoshaAliveDac implements ISaveable<DbV3077JuryoininKeiyakuJigyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで受領委任事業者Aliveを取得します。
     *
     * @param 事業者契約番号 事業者契約番号
     * @param 開始年月日 開始年月日
     * @param 履歴番号 履歴番号
     * @return DbV3077JuryoininKeiyakuJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV3077JuryoininKeiyakuJigyoshaEntity selectByKey(
            RString 事業者契約番号,
            FlexibleDate 開始年月日,
            int 履歴番号) throws NullPointerException {
        requireNonNull(事業者契約番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者契約番号"));
        requireNonNull(開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3077JuryoininKeiyakuJigyosha.class).
                where(and(
                                eq(jigyoshaKeiyakuNo, 事業者契約番号),
                                eq(kaishiYMD, 開始年月日),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbV3077JuryoininKeiyakuJigyoshaEntity.class);
    }

    /**
     * 受領委任事業者Aliveを全件返します。
     *
     * @return DbV3077JuryoininKeiyakuJigyoshaEntityの{@code list}
     */
    @Transaction
    public List<DbV3077JuryoininKeiyakuJigyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV3077JuryoininKeiyakuJigyosha.class).
                toList(DbV3077JuryoininKeiyakuJigyoshaEntity.class);
    }

    /**
     * DbV3077JuryoininKeiyakuJigyoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV3077JuryoininKeiyakuJigyoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受領委任事業者Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
