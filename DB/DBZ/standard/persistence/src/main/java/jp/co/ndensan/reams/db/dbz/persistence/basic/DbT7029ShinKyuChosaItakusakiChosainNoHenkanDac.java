/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkan;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkan.kyuChosaItakusakiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkan.kyuChosainNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkan.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity;
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
 * 新旧調査委託先調査員番号変換テーブルのデータアクセスクラスです。
 *
 * @author LDNS 宋昕沢
 */
public class DbT7029ShinKyuChosaItakusakiChosainNoHenkanDac implements IModifiable<DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで新旧調査委託先調査員番号変換テーブルを取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 旧調査委託先番号 KyuChosaItakusakiNo
     * @param 旧調査員番号 KyuChosainNo
     * @return DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity selectByKey(
            LasdecCode 市町村コード,
            RString 旧調査委託先番号,
            RString 旧調査員番号) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(旧調査委託先番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査委託先番号"));
        requireNonNull(旧調査員番号, UrSystemErrorMessages.値がnull.getReplacedMessage("旧調査員番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7029ShinKyuChosaItakusakiChosainNoHenkan.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(kyuChosaItakusakiNo, 旧調査委託先番号),
                                eq(kyuChosainNo, 旧調査員番号))).
                toObject(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity.class);
    }

    /**
     * 新旧調査委託先調査員番号変換テーブルを全件返します。
     *
     * @return List<DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity>
     */
    @Transaction
    public List<DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT7029ShinKyuChosaItakusakiChosainNoHenkan.class).
                toList(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
