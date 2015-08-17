/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1004HihokenshaShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV1004HihokenshaShisetsuNyutaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;
import static jp.co.ndensan.reams.db.dbx.entity.basic.DbV1004HihokenshaShisetsuNyutaisho.*;

/**
 * 施設入退所のデータアクセスクラスです。
 *
 * @author n3317 塚田萌
 * @jpName
 * @bizDomain 介護
 * @category 施設入退所
 * @subCategory
 * @mainClass
 * @reference
 */
public class DbV1004HihokenshaShisetsuNyutaishoDac {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで施設入退所を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 識別コード 識別コード
     * @param 処理日時 処理日時
     * @return 被保険者施設入退所エンティティ
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV1004HihokenshaShisetsuNyutaishoEntity selectByKey(
            LasdecCode 市町村コード,
            ShikibetsuCode 識別コード,
            RDateTime 処理日時) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("shichosonCode"));
        requireNonNull(識別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("shikibetsuCode"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("shoriTimestamp"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1004HihokenshaShisetsuNyutaisho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shikibetsuCode, 識別コード),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbV1004HihokenshaShisetsuNyutaishoEntity.class);
    }

    /**
     * 施設入退所を全件返します。
     *
     * @return 被保険者施設入退所エンティティリスト
     */
    @Transaction
    public List<DbV1004HihokenshaShisetsuNyutaishoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV1004HihokenshaShisetsuNyutaisho.class).
                toList(DbV1004HihokenshaShisetsuNyutaishoEntity.class);
    }

    /**
     * 引数の識別コードに該当する入所者エンティティのリストを取得します。
     *
     * @param 識別コード 識別コード
     * @return 入所者エンティティのリスト
     */
    @Transaction
    public List<DbV1004HihokenshaShisetsuNyutaishoEntity> select(ShikibetsuCode 識別コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select()
                .table(DbV1004HihokenshaShisetsuNyutaisho.class)
                .where(eq(shikibetsuCode, 識別コード))
                .toList(DbV1004HihokenshaShisetsuNyutaishoEntity.class);
    }
}
