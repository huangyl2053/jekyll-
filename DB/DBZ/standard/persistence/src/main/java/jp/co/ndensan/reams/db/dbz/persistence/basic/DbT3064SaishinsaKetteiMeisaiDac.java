
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3064SaishinsaKetteiMeisai;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3064SaishinsaKetteiMeisai.hokenshaKubun;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3064SaishinsaKetteiMeisai.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3064SaishinsaKetteiMeisai.toriatsukaiYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 再審査決定明細のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3064SaishinsaKetteiMeisaiDac implements IModifiable<DbT3064SaishinsaKetteiMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで再審査決定明細を取得します。
     *
     * @param 取扱年月 ToriatsukaiYM
     * @param 保険者区分 HokenshaKubun
     * @param 処理日時 ShoriTimestamp
     * @return DbT3064SaishinsaKetteiMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3064SaishinsaKetteiMeisaiEntity selectByKey(
            FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3064SaishinsaKetteiMeisai.class).
                where(and(
                                eq(toriatsukaiYM, 取扱年月),
                                eq(hokenshaKubun, 保険者区分),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3064SaishinsaKetteiMeisaiEntity.class);
    }

    /**
     * 再審査決定明細を全件返します。
     *
     * @return List<DbT3064SaishinsaKetteiMeisaiEntity>
     */
    @Transaction
    public List<DbT3064SaishinsaKetteiMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3064SaishinsaKetteiMeisai.class).
                toList(DbT3064SaishinsaKetteiMeisaiEntity.class);
    }

    /**
     * 再審査決定明細を追加します。
     *
     * @param entity 再審査決定明細
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3064SaishinsaKetteiMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 再審査決定明細をDBに更新します。
     *
     * @param entity 再審査決定明細
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3064SaishinsaKetteiMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 再審査決定明細をDBから削除します。（論理削除）
     *
     * @param entity 再審査決定明細
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3064SaishinsaKetteiMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 再審査決定明細を物理削除。
     *
     * @param entity 再審査決定明細
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3064SaishinsaKetteiMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
