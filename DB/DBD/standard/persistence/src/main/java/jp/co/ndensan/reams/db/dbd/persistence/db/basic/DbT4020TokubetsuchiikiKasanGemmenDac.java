/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.ketteiKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.shoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 特別地域加算減免のデータアクセスクラスです。
 *
 * @reamsid_L DBD-9999-013 huangh
 */
public class DbT4020TokubetsuchiikiKasanGemmenDac implements ISaveable<DbT4020TokubetsuchiikiKasanGemmenEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで特別地域加算減免を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @return DbT4020TokubetsuchiikiKasanGemmenEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4020TokubetsuchiikiKasanGemmenEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4020TokubetsuchiikiKasanGemmen.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT4020TokubetsuchiikiKasanGemmenEntity.class);
    }

    /**
     * 特別地域加算減免を全件返します。
     *
     * @return DbT4020TokubetsuchiikiKasanGemmenEntityの{@code list}
     */
    @Transaction
    public List<DbT4020TokubetsuchiikiKasanGemmenEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4020TokubetsuchiikiKasanGemmen.class).
                toList(DbT4020TokubetsuchiikiKasanGemmenEntity.class);
    }

    /**
     * DbT4020TokubetsuchiikiKasanGemmenEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4020TokubetsuchiikiKasanGemmenEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算減免エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 被保険者番号より、特別地域加算減免情報の件数を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT4020TokubetsuchiikiKasanGemmenEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int get特別地域加算減免情報の件数(HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4020TokubetsuchiikiKasanGemmen.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                not(isNULL(ketteiKubun)),
                                not(eq(ketteiKubun, RString.EMPTY)))).
                getCount();
    }
}
