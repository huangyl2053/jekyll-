/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShurui.*;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.db.ISaveable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.not;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護サービス種類のデータアクセスクラスです。
 */
public class DbT7130KaigoServiceShuruiDac implements ISaveable<DbT7130KaigoServiceShuruiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護サービス種類を取得します。
     *
     * @param サービス種類コード ServiceShuruiCd
     * @param 提供開始年月 TeikyoKaishiYM
     * @return DbT7130KaigoServiceShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7130KaigoServiceShuruiEntity selectByKey(
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 提供開始年月) throws NullPointerException {
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(提供開始年月, UrSystemErrorMessages.値がnull.getReplacedMessage("提供開始年月"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(
                                eq(serviceShuruiCd, サービス種類コード),
                                eq(teikyoKaishiYM, 提供開始年月))).
                toObject(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * 介護サービス種類を全件返します。
     *
     * @return List<DbT7130KaigoServiceShuruiEntity>
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * DbT7130KaigoServiceShuruiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7130KaigoServiceShuruiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護サービス種類エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    public List<DbT7130KaigoServiceShuruiEntity> selectList(ITrueFalseCriteria makeShuruiConditions) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 主キーで介護サービス種類を取得します。
     *
     * @param makeShuruiCondition
     * @return DbT7130KaigoServiceShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> select(
            ITrueFalseCriteria makeShuruiCondition) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(makeShuruiCondition).order(by(DbT7130KaigoServiceShurui.serviceShuruiCd, Order.ASC)).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * 主キーで介護サービス種類を取得します。
     *
     * @param サービス種類コード
     * @param 提供開始年月
     * @return DbT7130KaigoServiceShuruiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> selectByDate(
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleYearMonth 提供開始年月) throws NullPointerException {

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(eq(DbT7130KaigoServiceShurui.serviceShuruiCd, サービス種類コード),
                                leq(DbT7130KaigoServiceShurui.teikyoKaishiYM, 提供開始年月),
                                leq(提供開始年月, DbT7130KaigoServiceShurui.teikyoshuryoYM))).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }

    /**
     * 介護サービス種類を全件返します。
     *
     * @param systemDate システム日付
     * @return List<DbT7130KaigoServiceShuruiEntity>
     */
    @Transaction
    public List<DbT7130KaigoServiceShuruiEntity> selectServiceShurui(RYearMonth systemDate) {
        requireNonNull(systemDate, UrSystemErrorMessages.値がnull.getReplacedMessage("システム日付"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7130KaigoServiceShurui.class).
                where(and(not(eq(DbT7130KaigoServiceShurui.isDeleted, true)), leq(DbT7130KaigoServiceShurui.teikyoKaishiYM, systemDate), leq(systemDate, DbT7130KaigoServiceShurui.teikyoshuryoYM))).
                toList(DbT7130KaigoServiceShuruiEntity.class);
    }
}
