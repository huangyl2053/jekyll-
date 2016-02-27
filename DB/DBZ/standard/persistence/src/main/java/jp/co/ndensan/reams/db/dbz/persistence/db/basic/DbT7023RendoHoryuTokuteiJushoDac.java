/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJusho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJusho.kanriNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJusho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7023RendoHoryuTokuteiJushoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 連動保留特定住所マスタのデータアクセスクラスです。
 */
public class DbT7023RendoHoryuTokuteiJushoDac implements ISaveable<DbT7023RendoHoryuTokuteiJushoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで連動保留特定住所マスタを取得します。
     *
     * @param 管理番号 SubGyomuCode
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

    /**
     * DbT7023RendoHoryuTokuteiJushoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT7023RendoHoryuTokuteiJushoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("連動保留特定住所マスタエンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
