/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisai;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisai.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisai.shoKisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisai.shoriTimestamp;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 住宅改修理由書作成手数料請求明細のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT3095JutakuKaishuRiyushoTesuryoMeisaiDac implements IModifiable<DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで住宅改修理由書作成手数料請求明細を取得します。
     *
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param 処理日時 ShoriTimestamp
     * @return DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity selectByKey(
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            YMDHMS 処理日時) throws NullPointerException {
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(処理日時, UrSystemErrorMessages.値がnull.getReplacedMessage("処理日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3095JutakuKaishuRiyushoTesuryoMeisai.class).
                where(and(
                                eq(shoKisaiHokenshaNo, 証記載保険者番号),
                                eq(hihokenshaNo, 被保険者番号),
                                eq(shoriTimestamp, 処理日時))).
                toObject(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity.class);
    }

    /**
     * 住宅改修理由書作成手数料請求明細を全件返します。
     *
     * @return List<DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity>
     */
    @Transaction
    public List<DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3095JutakuKaishuRiyushoTesuryoMeisai.class).
                toList(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3095JutakuKaishuRiyushoTesuryoMeisaiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
