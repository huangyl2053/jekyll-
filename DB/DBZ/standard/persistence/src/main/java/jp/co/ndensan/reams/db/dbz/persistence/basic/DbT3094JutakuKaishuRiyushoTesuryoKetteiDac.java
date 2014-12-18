/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3094JutakuKaishuRiyushoTesuryoKettei;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3094JutakuKaishuRiyushoTesuryoKettei.ketteiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3094JutakuKaishuRiyushoTesuryoKettei.riyushoSakuseiJigyoshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3094JutakuKaishuRiyushoTesuryoKettei.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修理由書作成手数料請求決定のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3094JutakuKaishuRiyushoTesuryoKetteiDac implements IModifiable<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで住宅改修理由書作成手数料請求決定を取得します。
     *
     * @param 介護住宅改修理由書作成事業者番号 RiyushoSakuseiJigyoshaNo
     * @param 決定年月日 KetteiYMD
     * @param 処理日時 ShoriTimestamp
     * @return DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity selectByKey(
            JigyoshaNo 介護住宅改修理由書作成事業者番号,
            FlexibleDate 決定年月日,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(介護住宅改修理由書作成事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護住宅改修理由書作成事業者番号"));
        requireNonNull(決定年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("決定年月日"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3094JutakuKaishuRiyushoTesuryoKettei.class).
                where(and(
                                eq(riyushoSakuseiJigyoshaNo, 介護住宅改修理由書作成事業者番号),
                                eq(ketteiYMD, 決定年月日),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class);
    }

    /**
     * 住宅改修理由書作成手数料請求決定を全件返します。
     *
     * @return List<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity>
     */
    @Transaction
    public List<DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3094JutakuKaishuRiyushoTesuryoKettei.class).
                toList(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3094JutakuKaishuRiyushoTesuryoKetteiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
