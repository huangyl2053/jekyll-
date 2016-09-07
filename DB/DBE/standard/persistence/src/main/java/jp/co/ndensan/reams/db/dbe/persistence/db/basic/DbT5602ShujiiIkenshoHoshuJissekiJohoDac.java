/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJoho;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJoho.ikenshoIraiRirekiNo;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJoho.shinseishoKanriNo;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJoho.shujiiCode;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJoho.shujiiIryoKikanCode;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5602ShujiiIkenshoHoshuJissekiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.ISaveable;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成報酬実績情報のデータアクセスクラスです。
 *
 * @reamsid_L DBE-9999-011 xuyannan
 */
public class DbT5602ShujiiIkenshoHoshuJissekiJohoDac implements ISaveable<DbT5602ShujiiIkenshoHoshuJissekiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで主治医意見書作成報酬実績情報を取得します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return DbT5602ShujiiIkenshoHoshuJissekiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5602ShujiiIkenshoHoshuJissekiJohoEntity selectByKey(
            RString 主治医医療機関コード,
            RString 主治医コード,
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) throws NullPointerException {
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5602ShujiiIkenshoHoshuJissekiJoho.class).
                where(and(
                                eq(shujiiIryoKikanCode, 主治医医療機関コード),
                                eq(shujiiCode, 主治医コード),
                                eq(shinseishoKanriNo, 申請書管理番号),
                                eq(ikenshoIraiRirekiNo, 主治医意見書作成依頼履歴番号))).
                toObject(DbT5602ShujiiIkenshoHoshuJissekiJohoEntity.class);
    }

    /**
     * 主治医意見書作成報酬実績情報を全件返します。
     *
     * @return DbT5602ShujiiIkenshoHoshuJissekiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5602ShujiiIkenshoHoshuJissekiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5602ShujiiIkenshoHoshuJissekiJoho.class).
                toList(DbT5602ShujiiIkenshoHoshuJissekiJohoEntity.class);
    }

    /**
     * DbT5602ShujiiIkenshoHoshuJissekiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成報酬実績情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5602ShujiiIkenshoHoshuJissekiJohoEntityを物理削除します。
     *
     * @param entity entity
     * @return 物理削除件数
     */
    @Transaction
    public int delete(DbT5602ShujiiIkenshoHoshuJissekiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成報酬実績情報エンティティ"));
        entity.setState(EntityDataState.Deleted);
        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 主治医意見書作成報酬実績情報を返します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @param 主治医コード 主治医コード
     * @return DbT5602ShujiiIkenshoHoshuJissekiJohoEntity{@code list}
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5602ShujiiIkenshoHoshuJissekiJohoEntity> select報酬実績情報(
            RString 主治医医療機関コード,
            RString 主治医コード) throws NullPointerException {
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医医療機関コード"));
        requireNonNull(主治医コード, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5602ShujiiIkenshoHoshuJissekiJoho.class).
                where(and(
                                eq(shujiiIryoKikanCode, 主治医医療機関コード),
                                eq(shujiiCode, 主治医コード))).
                toList(DbT5602ShujiiIkenshoHoshuJissekiJohoEntity.class);
    }
}
