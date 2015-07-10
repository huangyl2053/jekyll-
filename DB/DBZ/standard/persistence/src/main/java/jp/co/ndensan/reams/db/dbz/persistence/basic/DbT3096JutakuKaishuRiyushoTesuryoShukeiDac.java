/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3096JutakuKaishuRiyushoTesuryoShukei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3096JutakuKaishuRiyushoTesuryoShukei.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3096JutakuKaishuRiyushoTesuryoShukei.shoriTimestamp;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3096JutakuKaishuRiyushoTesuryoShukei.shukeiKaishiYM;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修理由書作成手数料請求集計のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3096JutakuKaishuRiyushoTesuryoShukeiDac implements IModifiable<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで住宅改修理由書作成手数料請求集計を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 集計開始年月 ShukeiKaishiYM
     * @param 処理日時 ShoriTimestamp
     * @return DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity selectByKey(
            HokenshaNo 証記載保険者番号,
            FlexibleYearMonth 集計開始年月,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(集計開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("集計開始年月"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3096JutakuKaishuRiyushoTesuryoShukei.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(shukeiKaishiYM, 集計開始年月),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class);
    }

    /**
     * 住宅改修理由書作成手数料請求集計を全件返します。
     *
     * @return List<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity>
     */
    @Transaction
    public List<DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3096JutakuKaishuRiyushoTesuryoShukei.class).
                toList(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3096JutakuKaishuRiyushoTesuryoShukeiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
