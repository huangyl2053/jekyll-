/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ShujiiIryokikanCode;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5911ShujiiIryoKikanJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT5911ShujiiIryoKikanJoho.*;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.IShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.util.itemlist.ItemList;
import jp.co.ndensan.reams.db.dbz.definition.util.optional.Optional;
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
 * 主治医医療機関情報のデータアクセスクラスです。
 *
 * @author n8235 船山洋介
 */
public class DbT5911ShujiiIryoKikanJohoDac implements IModifiable<IShujiiIryoKikanJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで主治医医療機関情報を取得します。
     *
     * @param 市町村コード shichosonCode
     * @param 主治医医療機関コード shujiiIryokikanCode
     * @return Optional<DbT5911ShujiiIryoKikanJohoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT5911ShujiiIryoKikanJohoEntity> selectByKey(
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT5911ShujiiIryoKikanJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shujiiIryokikanCode, 主治医医療機関コード))).
                toObject(DbT5911ShujiiIryoKikanJohoEntity.class));
    }

    /**
     * 主キーで主治医医療機関情報を取得します。
     *
     * @param 市町村コード shichosonCode
     * @param 主治医医療機関コード shujiiIryokikanCode
     * @param 状況フラグ jokyoFlag
     * @return Optional<DbT5911ShujiiIryoKikanJohoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public Optional<DbT5911ShujiiIryoKikanJohoEntity> selectByKey(
            LasdecCode 市町村コード,
            RString 主治医医療機関コード,
            boolean 状況フラグ) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        requireNonNull(状況フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("状況フラグ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return Optional.ofNullable(accessor.select().
                table(DbT5911ShujiiIryoKikanJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shujiiIryokikanCode, 主治医医療機関コード),
                                eq(jokyoFlag, 状況フラグ))).
                toObject(DbT5911ShujiiIryoKikanJohoEntity.class));
    }

    /**
     * 主治医医療機関情報を全件返します。
     *
     * @return ItemList<DbT5911ShujiiIryoKikanJohoEntity>
     */
    @Transaction
    public ItemList<DbT5911ShujiiIryoKikanJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return ItemList.of(accessor.select().
                table(DbT5911ShujiiIryoKikanJoho.class).
                toList(DbT5911ShujiiIryoKikanJohoEntity.class));
    }

    @Transaction
    @Override
    public int insert(IShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(IShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(IShujiiIryoKikanJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

}
