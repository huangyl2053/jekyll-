/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7108ShujiiIkenshoHoshuTanakaJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7108ShujiiIkenshoHoshuTanakaJoho.hoshuTankaTekiyoKaishiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7108ShujiiIkenshoHoshuTanakaJoho.hoshuTankaTekiyoShuryoYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7108ShujiiIkenshoHoshuTanakaJoho.ikenshoSakuseiKaisu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7108ShujiiIkenshoHoshuTanakaJoho.ikenshoSakuseiryoShubetsu;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7108ShujiiIkenshoHoshuTanakaJoho.ishiKubunCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7108ShujiiIkenshoHoshuTanakaJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定主治医意見書報酬単価情報のデータアクセスクラスです。
 *
 * @author LDNS 宋文娟
 */
public class DbT7108ShujiiIkenshoHoshuTanakaJohoDac implements IModifiable<DbT7108ShujiiIkenshoHoshuTanakaJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで要介護認定主治医意見書報酬単価情報を取得します。
     *
     * @param 報酬単価適用開始年月日 HoshuTankaTekiyoKaishiYMD
     * @param 報酬単価適用終了年月日 HoshuTankaTekiyoShuryoYMD
     * @param 医師区分 IshiKubunCode
     * @param 意見書作成回数 IkenshoSakuseiKaisu
     * @param 意見書作成料種別 IkenshoSakuseiryoShubetsu
     * @return DbT7108ShujiiIkenshoHoshuTanakaJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7108ShujiiIkenshoHoshuTanakaJohoEntity selectByKey(
            FlexibleDate 報酬単価適用開始年月日,
            FlexibleDate 報酬単価適用終了年月日,
            Code 医師区分,
            int 意見書作成回数,
            RString 意見書作成料種別) throws NullPointerException {
        requireNonNull(報酬単価適用開始年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報酬単価適用開始年月日"));
        requireNonNull(報酬単価適用終了年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("報酬単価適用終了年月日"));
        requireNonNull(医師区分, UrSystemErrorMessages.値がnull.getReplacedMessage("医師区分"));
        requireNonNull(意見書作成回数, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成回数"));
        requireNonNull(意見書作成料種別, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成料種別"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7108ShujiiIkenshoHoshuTanakaJoho.class).
                where(and(
                                eq(hoshuTankaTekiyoKaishiYMD, 報酬単価適用開始年月日),
                                eq(hoshuTankaTekiyoShuryoYMD, 報酬単価適用終了年月日),
                                eq(ishiKubunCode, 医師区分),
                                eq(ikenshoSakuseiKaisu, 意見書作成回数),
                                eq(ikenshoSakuseiryoShubetsu, 意見書作成料種別))).
                toObject(DbT7108ShujiiIkenshoHoshuTanakaJohoEntity.class);
    }

    /**
     * 要介護認定主治医意見書報酬単価情報を全件返します。
     *
     * @return List<DbT7108ShujiiIkenshoHoshuTanakaJohoEntity>
     */
    @Transaction
    public List<DbT7108ShujiiIkenshoHoshuTanakaJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7108ShujiiIkenshoHoshuTanakaJoho.class).
                toList(DbT7108ShujiiIkenshoHoshuTanakaJohoEntity.class);
    }

    /**
     * 要介護認定主治医意見書報酬単価情報を追加します。
     *
     * @param entity 要介護認定主治医意見書報酬単価情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7108ShujiiIkenshoHoshuTanakaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 要介護認定主治医意見書報酬単価情報をDBに更新します。
     *
     * @param entity 要介護認定主治医意見書報酬単価情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7108ShujiiIkenshoHoshuTanakaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 要介護認定主治医意見書報酬単価情報をDBから削除します。（論理削除）
     *
     * @param entity 要介護認定主治医意見書報酬単価情報
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7108ShujiiIkenshoHoshuTanakaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 要介護認定主治医意見書報酬単価情報を物理削除。
     *
     * @param entity 要介護認定主治医意見書報酬単価情報
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7108ShujiiIkenshoHoshuTanakaJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
