/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ShujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4911ShujiiIryoKikanJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4911ShujiiIryoKikanJoho.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4911ShujiiIryoKikanJoho.shujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4911ShujiiIryoKikanJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医医療機関情報のデータアクセスクラスです。
 */
public class DbT4911ShujiiIryoKikanJohoDac implements ISaveable<DbT4911ShujiiIryoKikanJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで主治医医療機関情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return DbT4911ShujiiIryoKikanJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4911ShujiiIryoKikanJohoEntity selectByKey(
            LasdecCode 市町村コード,
            ShujiiIryokikanCode 主治医医療機関コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4911ShujiiIryoKikanJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shujiiIryokikanCode, 主治医医療機関コード))).
                toObject(DbT4911ShujiiIryoKikanJohoEntity.class);
    }

    /**
     * 主治医医療機関情報を全件返します。
     *
     * @return DbT4911ShujiiIryoKikanJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT4911ShujiiIryoKikanJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4911ShujiiIryoKikanJoho.class).
                toList(DbT4911ShujiiIryoKikanJohoEntity.class);
    }

    /**
     * DbT4911ShujiiIryoKikanJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4911ShujiiIryoKikanJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
