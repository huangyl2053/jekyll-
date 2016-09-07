/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJoho.jokyoFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJoho.shichosonCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJoho.shujiiIryokikanCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5911ShujiiIryoKikanJohoEntity;
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
 *
 * @reamsid_L DBZ-9999-021 lijia
 *
 */
public class DbT5911ShujiiIryoKikanJohoDac implements ISaveable<DbT5911ShujiiIryoKikanJohoEntity> {

    private static final RString 市町村コードMSG = new RString("市町村コード");
    private static final RString 主治医医療機関コードMSG = new RString("主治医医療機関コード");
    private static final RString 主治医医療機関情報エンティティMSG = new RString("主治医医療機関情報エンティティ");
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
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードMSG.toString()));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage(主治医医療機関コードMSG.toString()));

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
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(主治医医療機関情報エンティティMSG.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5911ShujiiIryoKikanJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 件数
     */
    @Transaction
    public int saveOrDelete(DbT5911ShujiiIryoKikanJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(主治医医療機関情報エンティティMSG.toString()));

        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 市町村コードと主治医医療機関コードで、主治医医療機関情報の件数を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return 件数
     */
    @Transaction
    public int countByShichosonCodeAndShujiiIryokikanCode(LasdecCode 市町村コード, RString 主治医医療機関コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードMSG.toString()));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage(主治医医療機関コードMSG.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5911ShujiiIryoKikanJoho.class).
                where(and(
                                eq(DbT5911ShujiiIryoKikanJoho.shichosonCode, 市町村コード),
                                eq(DbT5911ShujiiIryoKikanJoho.shujiiIryokikanCode, 主治医医療機関コード)))
                .getCount();
    }

    /**
     * 主キーで主治医医療機関情報かつ状況フラグがTRUEの情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return DbT5911ShujiiIryoKikanJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5911ShujiiIryoKikanJohoEntity selectByKeyAndJokyoFlg(
            LasdecCode 市町村コード,
            RString 主治医医療機関コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードMSG.toString()));
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage(主治医医療機関コードMSG.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5911ShujiiIryoKikanJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(shujiiIryokikanCode, 主治医医療機関コード),
                                eq(jokyoFlag, true))).
                toObject(DbT5911ShujiiIryoKikanJohoEntity.class);
    }

    /**
     * 市町村コードで、主治医医療機関情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return List<DbT5911ShujiiIryoKikanJohoEntity> 主治医医療機関情報リスト
     */
    @Transaction
    public List<DbT5911ShujiiIryoKikanJohoEntity> shichosonCodeAndJokyoFlag(LasdecCode 市町村コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(市町村コードMSG.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5911ShujiiIryoKikanJoho.class).
                where(and(
                                eq(DbT5911ShujiiIryoKikanJoho.shichosonCode, 市町村コード),
                                eq(DbT5911ShujiiIryoKikanJoho.jokyoFlag, true)))
                .toList(DbT5911ShujiiIryoKikanJohoEntity.class);
    }

    /**
     * 主治医医療機関コードで主治医医療機関情報を取得します。
     *
     * @param 主治医医療機関コード 主治医医療機関コード
     * @return List<DbT5911ShujiiIryoKikanJohoEntity>
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5911ShujiiIryoKikanJohoEntity> selectBy主治医医療機関コード(
            RString 主治医医療機関コード) throws NullPointerException {
        requireNonNull(主治医医療機関コード, UrSystemErrorMessages.値がnull.getReplacedMessage(主治医医療機関コードMSG.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5911ShujiiIryoKikanJoho.class).
                where(eq(shujiiIryokikanCode, 主治医医療機関コード)).
                toList(DbT5911ShujiiIryoKikanJohoEntity.class);
    }
}
