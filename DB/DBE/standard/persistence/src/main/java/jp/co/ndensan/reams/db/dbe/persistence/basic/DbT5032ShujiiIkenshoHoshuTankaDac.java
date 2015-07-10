/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5032ShujiiIkenshoHoshuTanka;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5032ShujiiIkenshoHoshuTanka.ikenshoSakuseiKaisuKubun;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5032ShujiiIkenshoHoshuTanka.kaishiYM;
import static jp.co.ndensan.reams.db.dbe.entity.basic.DbT5032ShujiiIkenshoHoshuTanka.zaitakuShisetsuKubun;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5032ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 意見書作成報酬単価のデータアクセスクラスです。
 *
 * @author LDNS 焦蘇晋
 */
public class DbT5032ShujiiIkenshoHoshuTankaDac implements IModifiable<DbT5032ShujiiIkenshoHoshuTankaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで意見書作成報酬単価を取得します。
     *
     * @param 在宅施設区分 ZaitakuShisetsuKubun
     * @param 意見書作成回数区分 IkenshoSakuseiKaisuKubun
     * @param 開始年月 KaishiYM
     * @return DbT5032ShujiiIkenshoHoshuTankaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5032ShujiiIkenshoHoshuTankaEntity selectByKey(
            Code 在宅施設区分,
            Code 意見書作成回数区分,
            FlexibleYearMonth 開始年月) throws NullPointerException {
        requireNonNull(在宅施設区分, UrSystemErrorMessages.値がnull.getReplacedMessage("在宅施設区分"));
        requireNonNull(意見書作成回数区分, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成回数区分"));
        requireNonNull(開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("開始年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5032ShujiiIkenshoHoshuTanka.class).
                where(and(
                                eq(zaitakuShisetsuKubun, 在宅施設区分),
                                eq(ikenshoSakuseiKaisuKubun, 意見書作成回数区分),
                                eq(kaishiYM, 開始年月))).
                toObject(DbT5032ShujiiIkenshoHoshuTankaEntity.class);
    }

    /**
     * 意見書作成報酬単価を全件返します。
     *
     * @return List<DbT5032ShujiiIkenshoHoshuTankaEntity>
     */
    @Transaction
    public List<DbT5032ShujiiIkenshoHoshuTankaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5032ShujiiIkenshoHoshuTanka.class).
                toList(DbT5032ShujiiIkenshoHoshuTankaEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT5032ShujiiIkenshoHoshuTankaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT5032ShujiiIkenshoHoshuTankaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT5032ShujiiIkenshoHoshuTankaEntity entity) {
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
    public int deletePhysical(DbT5032ShujiiIkenshoHoshuTankaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
