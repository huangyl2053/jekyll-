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
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 意見書作成報酬単価のデータアクセスクラスです。
 */
public class DbT5032ShujiiIkenshoHoshuTankaDac implements ISaveable<DbT5032ShujiiIkenshoHoshuTankaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで意見書作成報酬単価を取得します。
     *
     * @param 在宅施設区分 在宅施設区分
     * @param 意見書作成回数区分 意見書作成回数区分
     * @param 開始年月 開始年月
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
     * @return DbT5032ShujiiIkenshoHoshuTankaEntityの{@code list}
     */
    @Transaction
    public List<DbT5032ShujiiIkenshoHoshuTankaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5032ShujiiIkenshoHoshuTanka.class).
                toList(DbT5032ShujiiIkenshoHoshuTankaEntity.class);
    }

    /**
     * DbT5032ShujiiIkenshoHoshuTankaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5032ShujiiIkenshoHoshuTankaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("意見書作成報酬単価エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
