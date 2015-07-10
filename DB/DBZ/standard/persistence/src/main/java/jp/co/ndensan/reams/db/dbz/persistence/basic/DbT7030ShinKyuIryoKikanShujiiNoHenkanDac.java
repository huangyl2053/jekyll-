/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkan.kyuIryoKikanNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkan.kyuShujiiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkan.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity;
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
 * 新旧医療機関主治医番号変換テーブルのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7030ShinKyuIryoKikanShujiiNoHenkanDac implements IModifiable<DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで新旧医療機関主治医番号変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧医療機関番号 KyuIryoKikanNo
     * @param 旧主治医番号 KyuShujiiNo
     * @return DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString 旧医療機関番号,
            RString 旧主治医番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧医療機関番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧医療機関番号"));
        requireNonNull(旧主治医番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧主治医番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7030ShinKyuIryoKikanShujiiNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuIryoKikanNo, 旧医療機関番号),
                                eq(kyuShujiiNo, 旧主治医番号))).
                toObject(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity.class);
    }

    /**
     * 新旧医療機関主治医番号変換テーブルを全件返します。
     *
     * @return List<DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity>
     */
    @Transaction
    public List<DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7030ShinKyuIryoKikanShujiiNoHenkan.class).
                toList(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
