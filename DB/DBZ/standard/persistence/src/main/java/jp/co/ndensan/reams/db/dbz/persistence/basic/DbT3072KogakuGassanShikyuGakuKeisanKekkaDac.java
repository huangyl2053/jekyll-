/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekka;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekka.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekka.shikyuShinseishoSeiriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekka.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekka.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekka.taishoNendo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算支給額計算結果のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3072KogakuGassanShikyuGakuKeisanKekkaDac implements IModifiable<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで高額合算支給額計算結果を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 支給申請書整理番号 ShikyuShinseishoSeiriNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity selectByKey(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 証記載保険者番号,
            RString 支給申請書整理番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3072KogakuGassanShikyuGakuKeisanKekka.class).
                where(and(
                                eq(hihokenshaNo, 被保険者番号),
                                eq(taishoNendo, 対象年度),
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shikyuShinseishoSeiriNo, 支給申請書整理番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class);
    }

    /**
     * 高額合算支給額計算結果を全件返します。
     *
     * @return List<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity>
     */
    @Transaction
    public List<DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3072KogakuGassanShikyuGakuKeisanKekka.class).
                toList(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity.class);
    }

    /**
     * 高額合算支給額計算結果を追加します。
     *
     * @param entity 高額合算支給額計算結果
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 高額合算支給額計算結果をDBに更新します。
     *
     * @param entity 高額合算支給額計算結果
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 高額合算支給額計算結果をDBから削除します。（論理削除）
     *
     * @param entity 高額合算支給額計算結果
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 高額合算支給額計算結果を物理削除。
     *
     * @param entity 高額合算支給額計算結果
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
