/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2018RealHakkoRireki;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2018RealHakkoRireki.chohyoBunruiID;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2018RealHakkoRireki.choteiNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2018RealHakkoRireki.fukaNendo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2018RealHakkoRireki.tsuchishoNo;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2018RealHakkoRireki.tsuchishoPrintTimeStamp;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2018RealHakkoRirekiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.report.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * リアル発行履歴のデータアクセスクラスです。
 */
public class DbT2018RealHakkoRirekiDac implements ISaveable<DbT2018RealHakkoRirekiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーでリアル発行履歴を取得します。
     *
     * @param 調定年度 FlexibleYear
     * @param 賦課年度 FlexibleYear
     * @param 通知書番号 TsuchishoNo
     * @param 帳票分類ID ReportId
     * @param 帳票作成日時 YMDHMS
     * @return DbT2018RealHakkoRirekiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2018RealHakkoRirekiEntity selectByKey(
            FlexibleYear 調定年度,
            FlexibleYear 賦課年度,
            TsuchishoNo 通知書番号,
            ReportId 帳票分類ID,
            YMDHMS 帳票作成日時) throws NullPointerException {
        requireNonNull(調定年度, UrSystemErrorMessages.値がnull.getReplacedMessage("調定年度"));
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage("賦課年度"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));
        requireNonNull(帳票分類ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票分類ID"));
        requireNonNull(帳票作成日時, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票作成日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2018RealHakkoRireki.class).
                where(and(
                                eq(choteiNendo, 調定年度),
                                eq(fukaNendo, 賦課年度),
                                eq(tsuchishoNo, 通知書番号),
                                eq(chohyoBunruiID, 帳票分類ID),
                                eq(tsuchishoPrintTimeStamp, 帳票作成日時))).
                toObject(DbT2018RealHakkoRirekiEntity.class);
    }

    /**
     * リアル発行履歴を全件返します。
     *
     * @return List<DbT2018RealHakkoRirekiEntity>
     */
    @Transaction
    public List<DbT2018RealHakkoRirekiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2018RealHakkoRireki.class).
                toList(DbT2018RealHakkoRirekiEntity.class);
    }

    /**
     * DbT2018RealHakkoRirekiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2018RealHakkoRirekiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("リアル発行履歴エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
