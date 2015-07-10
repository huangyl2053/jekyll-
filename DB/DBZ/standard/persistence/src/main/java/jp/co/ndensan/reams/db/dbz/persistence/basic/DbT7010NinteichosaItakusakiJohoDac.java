/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7010NinteichosaItakusakiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7010NinteichosaItakusakiJoho.kaigoJigyoshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7010NinteichosaItakusakiJoho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査委託先情報　継承のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7010NinteichosaItakusakiJohoDac implements IModifiable<DbT7010NinteichosaItakusakiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査委託先情報　継承を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 介護事業者番号 KaigoJigyoshaNo
     * @return DbT7010NinteichosaItakusakiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7010NinteichosaItakusakiJohoEntity selectByKey(
            LasdecCode 市町村コード,
            RString 介護事業者番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(介護事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7010NinteichosaItakusakiJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kaigoJigyoshaNo, 介護事業者番号))).
                toObject(DbT7010NinteichosaItakusakiJohoEntity.class);
    }

    /**
     * 認定調査委託先情報　継承を全件返します。
     *
     * @return List<DbT7010NinteichosaItakusakiJohoEntity>
     */
    @Transaction
    public List<DbT7010NinteichosaItakusakiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7010NinteichosaItakusakiJoho.class).
                toList(DbT7010NinteichosaItakusakiJohoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7010NinteichosaItakusakiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7010NinteichosaItakusakiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7010NinteichosaItakusakiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7010NinteichosaItakusakiJohoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7010NinteichosaItakusakiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
