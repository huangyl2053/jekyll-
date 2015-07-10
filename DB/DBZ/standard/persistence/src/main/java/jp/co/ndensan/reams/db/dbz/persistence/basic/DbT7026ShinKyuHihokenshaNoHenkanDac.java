/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7026ShinKyuHihokenshaNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7026ShinKyuHihokenshaNoHenkan.kyuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7026ShinKyuHihokenshaNoHenkan.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
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
 * 新旧被保険者番号変換テーブルのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7026ShinKyuHihokenshaNoHenkanDac implements IModifiable<DbT7026ShinKyuHihokenshaNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで新旧被保険者番号変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧番号 KyuNo
     * @return DbT7026ShinKyuHihokenshaNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7026ShinKyuHihokenshaNoHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString 旧番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7026ShinKyuHihokenshaNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuNo, 旧番号))).
                toObject(DbT7026ShinKyuHihokenshaNoHenkanEntity.class);
    }

    /**
     * 新旧被保険者番号変換テーブルを全件返します。
     *
     * @return List<DbT7026ShinKyuHihokenshaNoHenkanEntity>
     */
    @Transaction
    public List<DbT7026ShinKyuHihokenshaNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7026ShinKyuHihokenshaNoHenkan.class).
                toList(DbT7026ShinKyuHihokenshaNoHenkanEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7026ShinKyuHihokenshaNoHenkanEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7026ShinKyuHihokenshaNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
