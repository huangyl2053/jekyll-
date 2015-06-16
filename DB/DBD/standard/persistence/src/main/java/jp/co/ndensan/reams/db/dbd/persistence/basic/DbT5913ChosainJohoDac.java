/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbd.definition.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbd.entity.basic.IChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5913ChosainJoho;
import static jp.co.ndensan.reams.db.dbd.entity.basic.DbT5913ChosainJoho.*;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5913ChosainJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 調査員情報のデータアクセスクラスです。
 *
 * @author n8223 朴義一
 */
public class DbT5913ChosainJohoDac implements IModifiable<IChosainJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで調査員情報を取得します。
     *
     * @param 市町村コード LasdecCode
     * @param 認定調査委託先コード NinteichosaItakusakiCode
     * @param 認定調査員コード NinteiChosainNo
     * @return DbT5913ChosainJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT5913ChosainJohoEntity> selectByKey(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT5913ChosainJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(ninteichosaItakusakiCode, 認定調査委託先コード),
                                eq(ninteiChosainNo, 認定調査員コード))).
                toObject(DbT5913ChosainJohoEntity.class));
    }

    /**
     * 調査員情報を全件返します。
     *
     * @return List<DbT5913ChosainJohoEntity>
     */
    @Transaction
    public ItemList<DbT5913ChosainJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return ItemList.of(accessor.select().
                table(DbT5913ChosainJoho.class).
                toList(DbT5913ChosainJohoEntity.class));
    }

    @Transaction
    @Override
    public int insert(IChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(IChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(IChosainJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity IChosainJohoEntity
     * @return int 件数
     */
//    @Transaction
//    public int deletePhysical(IChosainJohoEntity entity) {
//        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
//        return accessor.deletePhysical(entity).execute();
//    }
}
