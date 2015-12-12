/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7901ShikakuSearch;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7901ShikakuSearch.hihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.kensaku.DbV7901ShikakuSearchEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 資格検索Aliveのデータアクセスクラスです。
 */
public class DbV7901ShikakuSearchAliveDac implements ISaveable<DbV7901ShikakuSearchEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで資格検索Aliveを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbV7901ShikakuSearchEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbV7901ShikakuSearchEntity selectByKey(
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV7901ShikakuSearch.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                toObject(DbV7901ShikakuSearchEntity.class);
    }

    /**
     * 資格検索Aliveを全件返します。
     *
     * @return DbV7901ShikakuSearchEntityの{@code list}
     */
    @Transaction
    public List<DbV7901ShikakuSearchEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbV7901ShikakuSearch.class).
                toList(DbV7901ShikakuSearchEntity.class);
    }

    /**
     * DbV7901ShikakuSearchEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbV7901ShikakuSearchEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("資格検索Aliveエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
