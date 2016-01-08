/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho.shujiiCode;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho.shujiiIryokikanCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5912ShujiiJohoEntity;
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
 * 主治医情報のデータアクセスクラスです。
 */
public class DbT5912ShujiiJohoDac implements ISaveable<DbT5912ShujiiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで主治医情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @return DbT5912ShujiiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5912ShujiiJohoEntity selectByKey(
            LasdecCode 市町村コード,
            RString 主治医医療機関コード,
            RString 主治医コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5912ShujiiJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shujiiIryokikanCode, 主治医医療機関コード),
                                eq(shujiiCode, 主治医コード))).
                toObject(DbT5912ShujiiJohoEntity.class);
    }

    /**
     * 主治医情報を全件返します。
     *
     * @return DbT5912ShujiiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5912ShujiiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5912ShujiiJoho.class).
                toList(DbT5912ShujiiJohoEntity.class);
    }

    /**
     * DbT5912ShujiiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5912ShujiiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医情報エンティティ"));
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
    
     /**
     * DbT5912ShujiiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 件数
     */
    @Transaction
    public int saveOrDelete(DbT5912ShujiiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医情報エンティティ"));

        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

}
