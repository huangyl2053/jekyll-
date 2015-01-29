/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7023RendoHoryuTokuteiJusho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7023RendoHoryuTokuteiJusho.kanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7023RendoHoryuTokuteiJusho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7023RendoHoryuTokuteiJushoEntity;
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
 * 連動保留特定住所マスタのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7023RendoHoryuTokuteiJushoDac implements IModifiable<DbT7023RendoHoryuTokuteiJushoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで連動保留特定住所マスタを取得します。
     *
     * @param 管理番号 KanriNo
     * @param 市町村コード ShichosonCode
     * @return DbT7023RendoHoryuTokuteiJushoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7023RendoHoryuTokuteiJushoEntity selectByKey(
            RString 管理番号,
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("管理番号"));
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7023RendoHoryuTokuteiJusho.class).
                where(and(
                                eq(kanriNo, 管理番号),
                                eq(shichosonCode, 市町村コード))).
                toObject(DbT7023RendoHoryuTokuteiJushoEntity.class);
    }

    /**
     * 連動保留特定住所マスタを全件返します。
     *
     * @return List<DbT7023RendoHoryuTokuteiJushoEntity>
     */
    @Transaction
    public List<DbT7023RendoHoryuTokuteiJushoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7023RendoHoryuTokuteiJusho.class).
                toList(DbT7023RendoHoryuTokuteiJushoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7023RendoHoryuTokuteiJushoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7023RendoHoryuTokuteiJushoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7023RendoHoryuTokuteiJushoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7023RendoHoryuTokuteiJushoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7023RendoHoryuTokuteiJushoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
