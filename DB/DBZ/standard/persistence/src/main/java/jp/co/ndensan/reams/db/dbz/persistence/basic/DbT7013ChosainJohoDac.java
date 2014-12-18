/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7013ChosainJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7013ChosainJoho.kaigoChosainNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7013ChosainJoho.kaigoJigyoshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7013ChosainJoho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7013ChosainJohoEntity;
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
 * 調査員情報　継承のデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7013ChosainJohoDac implements IModifiable<DbT7013ChosainJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで調査員情報　継承を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 介護事業者番号 KaigoJigyoshaNo
     * @param 介護調査員番号 KaigoChosainNo
     * @return DbT7013ChosainJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7013ChosainJohoEntity selectByKey(
            LasdecCode 市町村コード,
            RString 介護事業者番号,
            RString 介護調査員番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(介護事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者番号"));
        requireNonNull(介護調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("介護調査員番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7013ChosainJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kaigoJigyoshaNo, 介護事業者番号),
                                eq(kaigoChosainNo, 介護調査員番号))).
                toObject(DbT7013ChosainJohoEntity.class);
    }

    /**
     * 調査員情報　継承を全件返します。
     *
     * @return List<DbT7013ChosainJohoEntity>
     */
    @Transaction
    public List<DbT7013ChosainJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7013ChosainJoho.class).
                toList(DbT7013ChosainJohoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7013ChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7013ChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7013ChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7013ChosainJohoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7013ChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
