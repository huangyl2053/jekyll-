/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.kakuninNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.ketteiKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.tekiyoKaishiYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmen.tekiyoShuryoYMD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4020TokubetsuchiikiKasanGemmenEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static jp.co.ndensan.reams.uz.uza.util.db.Order.DESC;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
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
//        if (entity.getLastUpdateTimestamp() != null && !EntityDataState.Deleted.equals(entity.getState())) {
//            entity.setState(EntityDataState.Modified);
//        }
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

    /**
     * 被保険者番号より、特別地域加算減免情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return DbT4020TokubetsuchiikiKasanGemmenEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4020TokubetsuchiikiKasanGemmenEntity get特別地域加算減免情報(HihokenshaNo 被保険者番号)
            throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4020TokubetsuchiikiKasanGemmen.class).
                where(eq(hihokenshaNo, 被保険者番号)).
                order(by(rirekiNo, DESC)).
                limit(1).
                toObject(DbT4020TokubetsuchiikiKasanGemmenEntity.class);
    }

    /**
     * キーで支払方法変更を取得します。
     *
     * @param 年度開始日 年度開始日
     * @param 年度終了日 年度終了日
     * @param 確認番号 確認番号
     * @return DbT4020TokubetsuchiikiKasanGemmenEntity{@code list}
     */
    @Transaction
    public List<DbT4020TokubetsuchiikiKasanGemmenEntity> selectFor確認番号の重複判定(
            FlexibleDate 年度開始日, FlexibleDate 年度終了日, RString 確認番号) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4020TokubetsuchiikiKasanGemmen.class).
                where(and(
                        leq(年度開始日, tekiyoKaishiYMD),
                        leq(tekiyoShuryoYMD, 年度終了日),
                        eq(kakuninNo, 確認番号))).
                toList(DbT4020TokubetsuchiikiKasanGemmenEntity.class);
    }

    /**
     * DbT4020TokubetsuchiikiKasanGemmenEntityを物理削除します。
     *
     * @param entity entity
     * @return 物理削除件数
     */
    @Transaction
    public int delete(DbT4020TokubetsuchiikiKasanGemmenEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("特別地域加算減免エンティティ"));
        entity.setState(EntityDataState.Deleted);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }
}
