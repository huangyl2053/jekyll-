/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5914SonotaKikanJoho;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5914SonotaKikanJoho.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5914SonotaKikanJoho.sonotaKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5914SonotaKikanJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * その他機関情報のデータアクセスクラスです。
 */
public class DbT5914SonotaKikanJohoDac implements ISaveable<DbT5914SonotaKikanJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーでその他機関情報を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param その他機関コード その他機関コード
     * @return DbT5914SonotaKikanJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5914SonotaKikanJohoEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            RString その他機関コード) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(その他機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5914SonotaKikanJoho.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(sonotaKikanCode, その他機関コード))).
                toObject(DbT5914SonotaKikanJohoEntity.class);
    }

    /**
     * その他機関情報を全件返します。
     *
     * @return DbT5914SonotaKikanJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5914SonotaKikanJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5914SonotaKikanJoho.class).
                toList(DbT5914SonotaKikanJohoEntity.class);
    }

    /**
     * DbT5914SonotaKikanJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5914SonotaKikanJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("その他機関情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
