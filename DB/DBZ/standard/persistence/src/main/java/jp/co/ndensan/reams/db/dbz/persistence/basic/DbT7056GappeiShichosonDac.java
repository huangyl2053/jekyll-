/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichoson;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichoson.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7056GappeiShichosonEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併市町村のデータアクセスクラスです。
 *
 * @author N8187 久保田 英男
 */
public class DbT7056GappeiShichosonDac implements IModifiable<DbT7056GappeiShichosonEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで合併市町村を取得します。
     *
     * @param 合併年月日 FlexibleDate
     * @param 地域番号 RString
     * @param 旧市町村コード LasdecCode
     * @return DbT7056GappeiShichosonEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7056GappeiShichosonEntity selectByKey(
            FlexibleDate 合併年月日,
            RString 地域番号,
            LasdecCode 旧市町村コード) throws NullPointerException {
        requireNonNull(合併年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("合併年月日"));
        requireNonNull(地域番号, UrSystemErrorMessages.値がnull.getReplacedMessage("地域番号"));
        requireNonNull(旧市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("旧市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7056GappeiShichoson.class).
                where(and(
                                eq(gappeiYMD, 合併年月日),
                                eq(chiikiNo, 地域番号),
                                eq(kyuShichosonCode, 旧市町村コード))).
                toObject(DbT7056GappeiShichosonEntity.class);
    }

    /**
     * 合併市町村を全件返します。
     *
     * @return List<DbT7056GappeiShichosonEntity>
     */
    @Transaction
    public List<DbT7056GappeiShichosonEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7056GappeiShichoson.class).
                toList(DbT7056GappeiShichosonEntity.class);
    }

    /**
     * 合併市町村を追加します。
     *
     * @param entity 合併市町村
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT7056GappeiShichosonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 合併市町村をDBに更新します。
     *
     * @param entity 合併市町村
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT7056GappeiShichosonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 合併市町村をDBから削除します。（論理削除）
     *
     * @param entity 合併市町村
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT7056GappeiShichosonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 合併市町村を物理削除。
     *
     * @param entity 合併市町村
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT7056GappeiShichosonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

}
