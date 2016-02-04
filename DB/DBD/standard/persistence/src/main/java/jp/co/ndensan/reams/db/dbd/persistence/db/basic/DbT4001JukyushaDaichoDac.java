/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core.YukoMukoKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaicho;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaicho.edaban;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaicho.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaicho.jukyuShinseiJiyu;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaicho.logicalDeletedFlag;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaicho.ninteiYukoKikanKaishiYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaicho.ninteiYukoKikanShuryoYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaicho.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaicho.shichosonCode;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaicho.yukoMukoKubun;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4001JukyushaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.substr;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳のデータアクセスクラスです。
 */
public class DbT4001JukyushaDaichoDac implements ISaveable<DbT4001JukyushaDaichoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで受給者台帳を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @param 枝番 Edaban
     * @param 受給申請事由 JukyuShinseiJiyu
     * @return DbT4001JukyushaDaichoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4001JukyushaDaichoEntity selectByKey(
            LasdecCode 市町村コード,
            HihokenshaNo 被保険者番号,
            RString 履歴番号,
            RString 枝番,
            Code 受給申請事由) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番"));
        requireNonNull(受給申請事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給申請事由"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号),
                                eq(edaban, 枝番),
                                eq(jukyuShinseiJiyu, 受給申請事由))).
                toObject(DbT4001JukyushaDaichoEntity.class);
    }

    /**
     * 受給者台帳を全件返します。
     *
     * @return List<DbT4001JukyushaDaichoEntity>
     */
    @Transaction
    public List<DbT4001JukyushaDaichoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                toList(DbT4001JukyushaDaichoEntity.class);
    }

    /**
     * DbT4001JukyushaDaichoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4001JukyushaDaichoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者台帳エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * select認定有効期間
     *
     * @param 被保険者番号
     * @return
     */
    @Transaction
    public DbT4001JukyushaDaichoEntity select認定有効期間(HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                not(eq(logicalDeletedFlag, true)))).
                order(by(rirekiNo, Order.DESC)).limit(1).
                toObject(DbT4001JukyushaDaichoEntity.class);
    }

    /**
     * select認定有効期間
     *
     * @param 被保険者番号
     * @param サービス提供年月
     * @return
     */
    @Transaction
    public DbT4001JukyushaDaichoEntity select要介護認定情報(HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月) {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                //                        leq(sub(ninteiYukoKikanKaishiYMD,0,6), サービス提供年月),
                                //                          leq(サービス提供年月, ninteiYukoKikanShuryoYMD),
                                not(eq(logicalDeletedFlag, true)))).
                order(by(rirekiNo, Order.DESC), by(rirekiNo, Order.DESC)).
                toObject(DbT4001JukyushaDaichoEntity.class);
    }

    public DbT4001JukyushaDaichoEntity getYokaigoNinteiJyoho(HihokenshaNo 被保険者番号, FlexibleDate サービス提供年月) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(DbT4001JukyushaDaicho.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                leq(substr(ninteiYukoKikanKaishiYMD, 1, 6), サービス提供年月),
                                leq(サービス提供年月, substr(ninteiYukoKikanShuryoYMD, 1, 6)),
                                eq(yukoMukoKubun, YukoMukoKubun.有効),
                                not(eq(logicalDeletedFlag, true)))).
                order(by(rirekiNo, Order.DESC), by(rirekiNo, Order.DESC)).
                toObject(DbT4001JukyushaDaichoEntity.class);
    }
}
