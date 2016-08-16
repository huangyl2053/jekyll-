/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisai;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisai.edaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisai.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisai.nendo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisai.rirekiNo;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisai.yukoKaishiYMD;
import static jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisai.yukoShuryoYMD;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenko.logicalDeletedFlag;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.substr;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担割合明細のデータアクセスクラスです。
 */
public class DbT3114RiyoshaFutanWariaiMeisaiDac implements ISaveable<DbT3114RiyoshaFutanWariaiMeisaiEntity> {

    private static final int NUM_6 = 6;
    @InjectSession
    private SqlSession session;

    /**
     * 主キーで利用者負担割合明細を取得します。
     *
     * @param 年度 Nendo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @param 枝番号 EdaNo
     * @return DbT3114RiyoshaFutanWariaiMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3114RiyoshaFutanWariaiMeisaiEntity selectByKey(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号,
            int 枝番号) throws NullPointerException {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番号, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3114RiyoshaFutanWariaiMeisai.class).
                where(and(
                                eq(nendo, 年度),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(rirekiNo, 履歴番号),
                                eq(edaNo, 枝番号))).
                toObject(DbT3114RiyoshaFutanWariaiMeisaiEntity.class);
    }

    /**
     * 利用者負担割合明細を全件返します。
     *
     * @return List<DbT3114RiyoshaFutanWariaiMeisaiEntity>
     */
    @Transaction
    public List<DbT3114RiyoshaFutanWariaiMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3114RiyoshaFutanWariaiMeisai.class).
                toList(DbT3114RiyoshaFutanWariaiMeisaiEntity.class);
    }

    /**
     * DbT3114RiyoshaFutanWariaiMeisaiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3114RiyoshaFutanWariaiMeisaiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合明細エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 利用者負担割合明細を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 利用年月 FlexibleYearMonth
     * @return List<DbT3114RiyoshaFutanWariaiMeisaiEntity>
     */
    @Transaction
    public List<DbT3114RiyoshaFutanWariaiMeisaiEntity> select負担割合区分(HihokenshaNo 被保険者番号, FlexibleYearMonth 利用年月) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3114RiyoshaFutanWariaiMeisai.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                leq(substr(yukoKaishiYMD, 0, NUM_6), 利用年月),
                                leq(利用年月, substr(yukoShuryoYMD, 0, NUM_6)),
                                eq(logicalDeletedFlag, false))).
                toList(DbT3114RiyoshaFutanWariaiMeisaiEntity.class);
    }
}
