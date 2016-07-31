/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.definition.core.gemmengengaku.KetteiKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengaku;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengaku.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengaku.ketteiKubun;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengaku.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengaku.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengaku.tekiyoKaishiYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengaku.tekiyoShuryoYMD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4014RiyoshaFutangakuGengakuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
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
 * 利用者負担額減額のデータアクセスクラスです。
 *
 * @reamsid_L DBC-9999-012 xicongwang
 */
public class DbT4014RiyoshaFutangakuGengakuDac {

    private static final RString 定数_いち = new RString("01");

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで利用者負担額減額を取得します。
     *
     * @param 証記載保険者番号 証記載保険者番号
     * @param 被保険者番号 被保険者番号
     * @param 履歴番号 履歴番号
     * @return DbT4014RiyoshaFutangakuGengakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4014RiyoshaFutangakuGengakuEntity selectByKey(
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4014RiyoshaFutangakuGengaku.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号))).
                toObject(DbT4014RiyoshaFutangakuGengakuEntity.class);
    }

    /**
     * 利用者負担額減額を全件返します。
     *
     * @return DbT4014RiyoshaFutangakuGengakuEntityの{@code list}
     */
    @Transaction
    public List<DbT4014RiyoshaFutangakuGengakuEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4014RiyoshaFutangakuGengaku.class).
                toList(DbT4014RiyoshaFutangakuGengakuEntity.class);
    }

    /**
     * DbT4014RiyoshaFutangakuGengakuEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int save(DbT4014RiyoshaFutangakuGengakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額減額エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT4014RiyoshaFutangakuGengakuEntityを物理削除します。
     *
     * @param entity entity
     * @return 物理削除件数
     */
    @Transaction
    public int delete(DbT4014RiyoshaFutangakuGengakuEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担額減額エンティティ"));
        entity.setState(EntityDataState.Deleted);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 減額給付率の取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return List<DbT4014RiyoshaFutangakuGengakuEntity>
     */
    @Transaction
    public List<DbT4014RiyoshaFutangakuGengakuEntity> select減額給付率(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4014RiyoshaFutangakuGengaku.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(ketteiKubun, KetteiKubun.承認する.getコード()),
                                leq(tekiyoKaishiYMD, new FlexibleDate(サービス提供年月.toDateString().toString() + 定数_いち)),
                                leq(new FlexibleDate(サービス提供年月.toDateString().toString()
                                                + サービス提供年月.getLastDay()), tekiyoShuryoYMD))).
                order(by(rirekiNo, DESC)).
                toList(DbT4014RiyoshaFutangakuGengakuEntity.class);
    }

    /**
     * 被保険者番号より、利用者負担額減免の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int get利用者負担額減免情報の件数(HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4014RiyoshaFutangakuGengaku.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                not(isNULL(ketteiKubun)),
                                not(eq(ketteiKubun, RString.EMPTY)))).
                order(by(rirekiNo, DESC)).
                getCount();

    }

    /**
     * 被保険者番号より、利用者負担額減免の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 基準日 基準日
     * @param 決定区分 決定区分
     * @return DbT4014RiyoshaFutangakuGengakuEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4014RiyoshaFutangakuGengakuEntity get利用者負担額減額(HihokenshaNo 被保険者番号, FlexibleDate 基準日, RString 決定区分) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));
        requireNonNull(決定区分, UrSystemErrorMessages.値がnull.getReplacedMessage("決定区分"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4014RiyoshaFutangakuGengaku.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                leq(tekiyoKaishiYMD, 基準日),
                                leq(基準日, tekiyoShuryoYMD),
                                eq(ketteiKubun, 決定区分))).
                order(by(rirekiNo, DESC)).
                limit(1).
                toObject(DbT4014RiyoshaFutangakuGengakuEntity.class);

    }
}
