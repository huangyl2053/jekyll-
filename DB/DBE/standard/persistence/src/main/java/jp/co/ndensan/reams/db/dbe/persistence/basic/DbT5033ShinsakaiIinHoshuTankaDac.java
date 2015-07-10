/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5033ShinsakaiIinHoshuTanka;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5033ShinsakaiIinHoshuTanka.kaigoNinteiShinsaIinShubetsu;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5033ShinsakaiIinHoshuTanka.kaishiYM;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5033ShinsakaiIinHoshuTanka.shuryoYM;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5033ShinsakaiIinHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.CodeShubetsu;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定調査委員報酬単価のデータアクセスクラスです。
 *
 * @author LDNS 焦蘇晋
 */
public class DbT5033ShinsakaiIinHoshuTankaDac implements IModifiable<DbT5033ShinsakaiIinHoshuTankaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護認定調査委員報酬単価を取得します。
     *
     * @param 介護認定審査委員種別 KaigoNinteiShinsaIinShubetsu
     * @param 開始年月 KaishiYM
     * @param 終了年月 ShuryoYM
     * @return DbT5033ShinsakaiIinHoshuTankaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5033ShinsakaiIinHoshuTankaEntity selectByKey(
            CodeShubetsu 介護認定審査委員種別,
            FlexibleYearMonth 開始年月,
            FlexibleYearMonth 終了年月) throws NullPointerException {
        requireNonNull(介護認定審査委員種別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査委員種別"));
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));
        requireNonNull(終了年月, UrSystemErrorMessages.値がnull.getReplacedMessage("終了年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5033ShinsakaiIinHoshuTanka.class).
                where(and(
                                eq(kaigoNinteiShinsaIinShubetsu, 介護認定審査委員種別),
                                eq(kaishiYM, 開始年月),
                                eq(shuryoYM, 終了年月))).
                toObject(DbT5033ShinsakaiIinHoshuTankaEntity.class);
    }

    /**
     * 介護認定調査委員報酬単価を全件返します。
     *
     * @return List<DbT5033ShinsakaiIinHoshuTankaEntity>
     */
    @Transaction
    public List<DbT5033ShinsakaiIinHoshuTankaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5033ShinsakaiIinHoshuTanka.class).
                toList(DbT5033ShinsakaiIinHoshuTankaEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT5033ShinsakaiIinHoshuTankaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT5033ShinsakaiIinHoshuTankaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT5033ShinsakaiIinHoshuTankaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * OCR収入を物理削除。
     *
     * @param entity OCR収入
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT5033ShinsakaiIinHoshuTankaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
