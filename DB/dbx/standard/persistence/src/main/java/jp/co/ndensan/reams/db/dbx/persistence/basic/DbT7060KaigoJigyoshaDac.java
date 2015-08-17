/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7060KaigoJigyosha;
import static jp.co.ndensan.reams.db.dbx.entity.basic.DbT7060KaigoJigyosha.*;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.db.IModifiable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者のデータアクセスクラスです。
 *
 * @author n3317 塚田萌
 * @jpName
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者
 * @mainClass
 * @reference
 */
public class DbT7060KaigoJigyoshaDac implements IModifiable<DbT7060KaigoJigyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護事業者を取得します。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @param 有効開始日 FlexibleDate
     * @return UrT0518KaigoJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7060KaigoJigyoshaEntity selectByKey(
            KaigoJigyoshaNo 事業者番号,
            FlexibleDate 有効開始日) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(and(
                                eq(jigyoshaNo, 事業者番号),
                                eq(yukoKaishiYMD, 有効開始日))).
                toObject(DbT7060KaigoJigyoshaEntity.class);
    }

    /**
     * 事業者番号で検索し基準日が有効開始日以降(当日を含む)かつ有効終了日までに該当するデータを取得して1件返します。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @param 基準日 FlexibleDate
     * @return UrT0518KaigoJigyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7060KaigoJigyoshaEntity selectActive介護事業者Bykey(
            KaigoJigyoshaNo 事業者番号,
            FlexibleDate 基準日) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(基準日, UrSystemErrorMessages.値がnull.getReplacedMessage("基準日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(
                        and(
                                eq(jigyoshaNo, 事業者番号),
                                leq(yukoKaishiYMD, 基準日),
                                or(leq(基準日, yukoShuryoYMD), eq(yukoShuryoYMD, ""), isNULL(yukoShuryoYMD)))).
                toObject(DbT7060KaigoJigyoshaEntity.class);
    }

    /**
     * 介護事業者を全件返します。
     *
     * @return List<UrT0518KaigoJigyoshaEntity>
     */
    @Transaction
    public List<DbT7060KaigoJigyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                toList(DbT7060KaigoJigyoshaEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7060KaigoJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7060KaigoJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7060KaigoJigyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

}
