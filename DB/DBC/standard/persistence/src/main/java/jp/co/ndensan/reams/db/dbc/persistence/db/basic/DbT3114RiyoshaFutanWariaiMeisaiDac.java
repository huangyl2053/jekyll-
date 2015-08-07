/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisai;
import static jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisai.*;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担割合明細のデータアクセスクラスです。
 */
public class DbT3114RiyoshaFutanWariaiMeisaiDac implements ISaveable<DbT3114RiyoshaFutanWariaiMeisaiEntity> {

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
            Decimal 履歴番号,
            Decimal 枝番号) throws NullPointerException {
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
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
