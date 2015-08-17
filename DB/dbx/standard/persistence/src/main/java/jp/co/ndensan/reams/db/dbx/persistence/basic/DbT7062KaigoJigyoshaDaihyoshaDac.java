/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7062KaigoJigyoshaDaihyosha;
import static jp.co.ndensan.reams.db.dbx.entity.basic.DbT7062KaigoJigyoshaDaihyosha.*;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urz.persistence.db.IModifiable;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.KaigoJigyoshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者代表者のデータアクセスクラスです。
 *
 * @author n3317 塚田萌
 * @jpName
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者代表者
 * @mainClass
 * @reference
 */
public class DbT7062KaigoJigyoshaDaihyoshaDac implements IModifiable<DbT7062KaigoJigyoshaDaihyoshaEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで介護事業者代表者を取得します。
     *
     * @param 事業者番号 KaigoJigyoshaNo
     * @param 有効開始日 FlexibleDate
     * @return UrT0520KaigoJigyoshaDaihyoshaEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7062KaigoJigyoshaDaihyoshaEntity selectByKey(
            KaigoJigyoshaNo 事業者番号,
            FlexibleDate 有効開始日) throws NullPointerException {
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(有効開始日, UrSystemErrorMessages.値がnull.getReplacedMessage("有効開始日"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7062KaigoJigyoshaDaihyosha.class).
                where(and(
                                eq(jigyoshaNo, 事業者番号),
                                eq(yukoKaishiYMD, 有効開始日))).
                toObject(DbT7062KaigoJigyoshaDaihyoshaEntity.class);
    }

    /**
     * 介護事業者代表者を全件返します。
     *
     * @return List<UrT0520KaigoJigyoshaDaihyoshaEntity>
     */
    @Transaction
    public List<DbT7062KaigoJigyoshaDaihyoshaEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7062KaigoJigyoshaDaihyosha.class).
                toList(DbT7062KaigoJigyoshaDaihyoshaEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7062KaigoJigyoshaDaihyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7062KaigoJigyoshaDaihyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7062KaigoJigyoshaDaihyoshaEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

}
