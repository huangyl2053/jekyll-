/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyosha;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyosha.jigyoshaNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyosha.rirekiNo;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyosha.serviceCode;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3065ShichosonTokubetsuKyufuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceCode;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 市町村特別給付サービス事業者のデータアクセスクラスです。
 */
public class DbT3065ShichosonTokubetsuKyufuJigyoshaDac implements ISaveable<DbT3065ShichosonTokubetsuKyufuJigyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで市町村特別給付サービス事業者を取得します。
     *
     * @param 市町村特別給付用事業者番号 JigyoshaNo
     * @param 市町村特別給付用サービスコード ServiceCode
     * @param 履歴番号 RirekiNo
     * @return DbT3065ShichosonTokubetsuKyufuJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3065ShichosonTokubetsuKyufuJigyoshaEntity selectByKey(
            JigyoshaNo 市町村特別給付用事業者番号,
            ServiceCode 市町村特別給付用サービスコード,
            int 履歴番号) throws NullPointerException {
        requireNonNull(市町村特別給付用事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用事業者番号"));
        requireNonNull(市町村特別給付用サービスコード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付用サービスコード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3065ShichosonTokubetsuKyufuJigyosha.class).
                where(and(
                                eq(jigyoshaNo, 市町村特別給付用事業者番号),
                                eq(serviceCode, 市町村特別給付用サービスコード),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity.class);
    }

    /**
     * 市町村特別給付サービス事業者を全件返します。
     *
     * @return List<DbT3065ShichosonTokubetsuKyufuJigyoshaEntity>
     */
    @Transaction
    public List<DbT3065ShichosonTokubetsuKyufuJigyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3065ShichosonTokubetsuKyufuJigyosha.class).
                toList(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity.class);
    }

    /**
     * DbT3065ShichosonTokubetsuKyufuJigyoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3065ShichosonTokubetsuKyufuJigyoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村特別給付サービス事業者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
