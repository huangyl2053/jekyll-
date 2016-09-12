/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3007KyotakuKeikakuJikoSakusei;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3007KyotakuKeikakuJikoSakusei.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3007KyotakuKeikakuJikoSakusei.kyotaku_SogoJigyoKubun;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3007KyotakuKeikakuJikoSakusei.rirekiNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3007KyotakuKeikakuJikoSakusei.taishoYM;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3007KyotakuKeikakuJikoSakuseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IDeletable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 居宅給付計画自己作成のデータアクセスクラスです。
 */
public class DbT3007KyotakuKeikakuJikoSakuseiDac implements ISaveable<DbT3007KyotakuKeikakuJikoSakuseiEntity>,
        IDeletable<DbT3007KyotakuKeikakuJikoSakuseiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで居宅給付計画自己作成を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @return DbT3007KyotakuKeikakuJikoSakuseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3007KyotakuKeikakuJikoSakuseiEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3007KyotakuKeikakuJikoSakusei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoYM, 対象年月),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT3007KyotakuKeikakuJikoSakuseiEntity.class);
    }

    /**
     * 居宅給付計画自己作成を全件返します。
     *
     * @return List<DbT3007KyotakuKeikakuJikoSakuseiEntity>
     */
    @Transaction
    public List<DbT3007KyotakuKeikakuJikoSakuseiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3007KyotakuKeikakuJikoSakusei.class).
                toList(DbT3007KyotakuKeikakuJikoSakuseiEntity.class);
    }

    /**
     * DbT3007KyotakuKeikakuJikoSakuseiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3007KyotakuKeikakuJikoSakuseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT3007KyotakuKeikakuJikoSakuseiEntityを物理削除します。
     *
     * @param entity entity
     * @return 削除件数
     */
    @Override
    public int delete(DbT3007KyotakuKeikakuJikoSakuseiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅給付計画自己作成エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * DbT3007KyotakuKeikakuJikoSakuseiから指定された検索キーで検索を行います
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 証記載保険者番号 HokenshaNo
     * @param 識別コード ShikibetsuCode
     * @param 対象年月 FlexibleYearMonth
     * @param 処理日時 YMDHMS
     * @return DbT3007KyotakuKeikakuJikoSakuseiEntity
     */
    public DbT3007KyotakuKeikakuJikoSakuseiEntity
            selectByKey(HihokenshaNo 被保険者番号, HokenshaNo 証記載保険者番号,
                    ShikibetsuCode 識別コード, FlexibleYearMonth 対象年月, YMDHMS 処理日時) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 居宅給付計画自己作成を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年月 TaishoYM
     * @param 履歴番号 RirekiNo
     * @param 総合事業区分 RString
     * @return DbT3007KyotakuKeikakuJikoSakuseiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3007KyotakuKeikakuJikoSakuseiEntity get居宅給付計画自己作成(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            int 履歴番号,
            RString 総合事業区分) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(総合事業区分, UrSystemErrorMessages.値がnull.getReplacedMessage("総合事業区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3007KyotakuKeikakuJikoSakusei.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoYM, 対象年月),
                                eq(rirekiNo, 履歴番号),
                                eq(kyotaku_SogoJigyoKubun, 総合事業区分))).
                toObject(DbT3007KyotakuKeikakuJikoSakuseiEntity.class);
    }
}
