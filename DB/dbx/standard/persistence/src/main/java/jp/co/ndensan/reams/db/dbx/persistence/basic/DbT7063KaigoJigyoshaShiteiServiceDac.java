/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7063KaigoJigyoshaShiteiService;
import static jp.co.ndensan.reams.db.dbx.entity.basic.DbT7063KaigoJigyoshaShiteiService.*;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7063KaigoJigyoshaShiteiServiceEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.db.IModifiable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.biz.KaigoServiceShuruiCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者指定サービスのデータアクセスクラスです。
 *
 * @author n3317 塚田萌
 * @jpName
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 */
public class DbT7063KaigoJigyoshaShiteiServiceDac implements IModifiable<DbT7063KaigoJigyoshaShiteiServiceEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護事業者指定サービスを取得します。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @param サービス種類コード KaigoServiceShuruiCode
     * @param 有効開始日 FlexibleDate
     * @return UrT0521KaigoJigyoshaShiteiServiceEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7063KaigoJigyoshaShiteiServiceEntity selectByKey(
            KaigoJigyoshaNo 事業者番号,
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleDate 有効開始日) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                where(and(
                                eq(jigyoshaNo, 事業者番号),
                                eq(serviceShuruiCode, サービス種類コード),
                                eq(yukoKaishiYMD, 有効開始日))).
                toObject(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    /**
     * 事業者番号とサービス種類コードで検索し基準日が有効開始日以降(当日を含む)かつ有効終了日までに該当するデータを取得し、1件返します。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @param サービス種類コード KaigoServiceShuruiCode
     * @param 基準日 FlexibleDate
     * @return KaigoJigyoshaShiteiServiceEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7063KaigoJigyoshaShiteiServiceEntity selectActive介護事業者指定サービスBykey(
            KaigoJigyoshaNo 事業者番号,
            KaigoServiceShuruiCode サービス種類コード,
            FlexibleDate 基準日) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                where(
                        and(
                                eq(jigyoshaNo, 事業者番号),
                                eq(serviceShuruiCode, サービス種類コード),
                                leq(yukoKaishiYMD, 基準日),
                                or(leq(基準日, yukoShuryoYMD), eq(yukoShuryoYMD, ""), isNULL(yukoShuryoYMD)))).
                toObject(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    /**
     * 介護事業者指定サービスを全件返します。
     *
     * @return List<UrT0521KaigoJigyoshaShiteiServiceEntity>
     */
    @Transaction
    public List<DbT7063KaigoJigyoshaShiteiServiceEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                toList(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    /**
     * 事業者番号で介護事業者指定サービスを取得します。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @return List<UrT0521KaigoJigyoshaShiteiServiceEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7063KaigoJigyoshaShiteiServiceEntity> selectBy事業者番号(
            KaigoJigyoshaNo 事業者番号) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7063KaigoJigyoshaShiteiService.class).
                where(eq(jigyoshaNo, 事業者番号)).
                order(by(serviceShuruiCode, Order.ASC)).
                toList(DbT7063KaigoJigyoshaShiteiServiceEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7063KaigoJigyoshaShiteiServiceEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7063KaigoJigyoshaShiteiServiceEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7063KaigoJigyoshaShiteiServiceEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

}
