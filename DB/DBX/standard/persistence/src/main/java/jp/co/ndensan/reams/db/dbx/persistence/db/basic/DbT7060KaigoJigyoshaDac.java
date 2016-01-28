/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyosha;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyosha.*;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.kaigojigyosha.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.leq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.isNULL;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者のデータアクセスクラスです。
 */
public class DbT7060KaigoJigyoshaDac implements ISaveable<DbT7060KaigoJigyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護事業者を取得します。
     *
     * @param 事業者番号 JigyoshaNo
     * @param 有効開始日 YukoKaishiYMD
     * @return DbT7060KaigoJigyoshaEntity
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
     * 介護事業者を全件返します。
     *
     * @return List<DbT7060KaigoJigyoshaEntity>
     */
    @Transaction
    public List<DbT7060KaigoJigyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                toList(DbT7060KaigoJigyoshaEntity.class);
    }

    /**
     * DbT7060KaigoJigyoshaEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7060KaigoJigyoshaEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 入所施設名称の取得。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @param システム日付 FlexibleDate
     * @return List<DbT7060KaigoJigyoshaEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT7060KaigoJigyoshaEntity> select介護事業者(
            KaigoJigyoshaNo 事業者番号,
            FlexibleDate システム日付) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(システム日付, UrSystemErrorMessages.値がnull.getReplacedMessage("システム日付"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7060KaigoJigyosha.class).
                where(and(
                                eq(DbT7060KaigoJigyosha.jigyoshaNo, 事業者番号),
                                leq(DbT7060KaigoJigyosha.yukoKaishiYMD, システム日付),
                                or(leq(システム日付, DbT7060KaigoJigyosha.yukoShuryoYMD), isNULL(DbT7060KaigoJigyosha.yukoShuryoYMD)))).
                toList(DbT7060KaigoJigyoshaEntity.class);
    }
}
