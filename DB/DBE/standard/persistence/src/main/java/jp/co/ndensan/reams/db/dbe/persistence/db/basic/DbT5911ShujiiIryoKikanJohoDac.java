/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho.shujiiIryokikanCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
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
 * 主治医医療機関情報のデータアクセスクラスです。
 */
public class DbT5911ShujiiIryoKikanJohoDac implements ISaveable<DbT5911ShujiiIryoKikanJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで主治医医療機関情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return DbT5911ShujiiIryoKikanJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5911ShujiiIryoKikanJohoEntity selectByKey(
            LasdecCode 市町村コード,
            RString 主治医医療機関コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5911ShujiiIryoKikanJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shujiiIryokikanCode, 主治医医療機関コード))).
                toObject(DbT5911ShujiiIryoKikanJohoEntity.class);
    }

    /**
     * 主治医医療機関情報を全件返します。
     *
     * @return DbT5911ShujiiIryoKikanJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5911ShujiiIryoKikanJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5911ShujiiIryoKikanJoho.class).
                toList(DbT5911ShujiiIryoKikanJohoEntity.class);
    }

    /**
     * DbT5911ShujiiIryoKikanJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5911ShujiiIryoKikanJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関情報エンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
