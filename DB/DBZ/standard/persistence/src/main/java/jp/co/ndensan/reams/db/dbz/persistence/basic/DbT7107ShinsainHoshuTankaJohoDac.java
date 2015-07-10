/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7107ShinsainHoshuTankaJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7107ShinsainHoshuTankaJoho.gogitaiChoKubunCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7107ShinsainHoshuTankaJoho.hoshuTankaTekiyoKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7107ShinsainHoshuTankaJoho.hoshuTankaTekiyoShuryoYMD;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7107ShinsainHoshuTankaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定審査員報酬単価情報のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7107ShinsainHoshuTankaJohoDac implements IModifiable<DbT7107ShinsainHoshuTankaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定審査員報酬単価情報を取得します。
     *
     * @param 報酬単価適用開始年月日 HoshuTankaTekiyoKaishiYMD
     * @param 報酬単価適用終了年月日 HoshuTankaTekiyoShuryoYMD
     * @param 合議体長区分 GogitaiChoKubunCode
     * @return DbT7107ShinsainHoshuTankaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7107ShinsainHoshuTankaJohoEntity selectByKey(
            FlexibleDate 報酬単価適用開始年月日,
            FlexibleDate 報酬単価適用終了年月日,
            Code 合議体長区分) throws NullPointerException {
        requireNonNull(報酬単価適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報酬単価適用開始年月日"));
        requireNonNull(報酬単価適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報酬単価適用終了年月日"));
        requireNonNull(合議体長区分, UrSystemErrorMessages.値がnull.getReplacedMessage("合議体長区分"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7107ShinsainHoshuTankaJoho.class).
                where(and(
                                eq(hoshuTankaTekiyoKaishiYMD, 報酬単価適用開始年月日),
                                eq(hoshuTankaTekiyoShuryoYMD, 報酬単価適用終了年月日),
                                eq(gogitaiChoKubunCode, 合議体長区分))).
                toObject(DbT7107ShinsainHoshuTankaJohoEntity.class);
    }

    /**
     * 要介護認定審査員報酬単価情報を全件返します。
     *
     * @return List<DbT7107ShinsainHoshuTankaJohoEntity>
     */
    @Transaction
    public List<DbT7107ShinsainHoshuTankaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7107ShinsainHoshuTankaJoho.class).
                toList(DbT7107ShinsainHoshuTankaJohoEntity.class);
    }

    /**
     * 要介護認定審査員報酬単価情報を追加します。
     *
     * @param entity 要介護認定審査員報酬単価情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7107ShinsainHoshuTankaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 要介護認定審査員報酬単価情報をDBに更新します。
     *
     * @param entity 要介護認定審査員報酬単価情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7107ShinsainHoshuTankaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 要介護認定審査員報酬単価情報をDBから削除します。（論理削除）
     *
     * @param entity 要介護認定審査員報酬単価情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7107ShinsainHoshuTankaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 要介護認定審査員報酬単価情報を物理削除。
     *
     * @param entity 要介護認定審査員報酬単価情報
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7107ShinsainHoshuTankaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
