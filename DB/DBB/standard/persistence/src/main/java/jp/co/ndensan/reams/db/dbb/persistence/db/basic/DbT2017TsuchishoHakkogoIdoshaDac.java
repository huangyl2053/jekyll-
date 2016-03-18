/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdosha;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdosha.chohyosakuseiTimestamp;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdosha.keisanTimestamp;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdosha.reportID;
import static jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdosha.tsuchishoNo;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2017TsuchishoHakkogoIdoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.max;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 通知書発行後異動者のデータアクセスクラスです。
 */
public class DbT2017TsuchishoHakkogoIdoshaDac implements ISaveable<DbT2017TsuchishoHakkogoIdoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで通知書発行後異動者を取得します。
     *
     * @param 帳票ID ReportId
     * @param 帳票作成日時 YMDHMS
     * @param 通知書番号 LasdecCode
     * @return DbT2017TsuchishoHakkogoIdoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT2017TsuchishoHakkogoIdoshaEntity selectByKey(
            ReportId 帳票ID,
            YMDHMS 帳票作成日時,
            LasdecCode 通知書番号) throws NullPointerException {
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));
        requireNonNull(帳票作成日時, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票作成日時"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2017TsuchishoHakkogoIdosha.class).
                where(and(
                                eq(reportID, 帳票ID),
                                eq(chohyosakuseiTimestamp, 帳票作成日時),
                                eq(tsuchishoNo, 通知書番号))).
                toObject(DbT2017TsuchishoHakkogoIdoshaEntity.class);
    }

    /**
     * 通知書発行後異動者を全件返します。
     *
     * @return List<DbT2017TsuchishoHakkogoIdoshaEntity>
     */
    @Transaction
    public List<DbT2017TsuchishoHakkogoIdoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2017TsuchishoHakkogoIdosha.class).
                toList(DbT2017TsuchishoHakkogoIdoshaEntity.class);
    }

    /**
     * DbT2017TsuchishoHakkogoIdoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT2017TsuchishoHakkogoIdoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書発行後異動者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * select発行帳票情報
     *
     * @return List
     */
    @Transaction
    public List<DbT2017TsuchishoHakkogoIdoshaEntity> select発行帳票情報() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        YMDHMS システム日付 = YMDHMS.now();
        YMDHMS システム日付の1ヶ月前の日付 = システム日付.minusMonth(3);

        return accessor.select().
                table(DbT2017TsuchishoHakkogoIdosha.class).
                where(and(
                                leq(chohyosakuseiTimestamp, システム日付),
                                leq(システム日付の1ヶ月前の日付, chohyosakuseiTimestamp))).
                toList(DbT2017TsuchishoHakkogoIdoshaEntity.class);
    }

    /**
     * getMAX計算処理日時
     *
     * @param 帳票ID 帳票ID
     * @param 帳票作成日時 帳票作成日時
     * @return MAX計算処理日時
     * @throws NullPointerException
     */
    @Transaction
    public DbT2017TsuchishoHakkogoIdoshaEntity getMAX計算処理日時(
            ReportId 帳票ID,
            YMDHMS 帳票作成日時) throws NullPointerException {
        requireNonNull(帳票ID, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票ID"));
        requireNonNull(帳票作成日時, UrSystemErrorMessages.値がnull.getReplacedMessage("帳票作成日時"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.selectSpecific(max(keisanTimestamp)).
                table(DbT2017TsuchishoHakkogoIdosha.class).
                where(and(eq(reportID, 帳票ID),
                                eq(chohyosakuseiTimestamp, 帳票作成日時))).
                toObject(DbT2017TsuchishoHakkogoIdoshaEntity.class);
    }
}
