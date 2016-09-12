/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJoho.jokyoFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJoho.ninteichosaItakusakiCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJoho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5910NinteichosaItakusakiJohoEntity;
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
 * 認定調査委託先情報のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-021 lijia
 *
 */
public class DbT5910NinteichosaItakusakiJohoDac implements ISaveable<DbT5910NinteichosaItakusakiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査委託先情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return DbT5910NinteichosaItakusakiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5910NinteichosaItakusakiJohoEntity selectByKey(
            LasdecCode 市町村コード,
            RString 認定調査委託先コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5910NinteichosaItakusakiJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(ninteichosaItakusakiCode, 認定調査委託先コード))).
                toObject(DbT5910NinteichosaItakusakiJohoEntity.class);
    }

    /**
     * 認定調査委託先情報を全件返します。
     *
     * @return DbT5910NinteichosaItakusakiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5910NinteichosaItakusakiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5910NinteichosaItakusakiJoho.class).
                toList(DbT5910NinteichosaItakusakiJohoEntity.class);
    }

    /**
     * DbT5910NinteichosaItakusakiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5910NinteichosaItakusakiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5910NinteichosaItakusakiJohoEntityを物理削除。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    public int deletePhysical(DbT5910NinteichosaItakusakiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先情報エンティティ"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }

    /**
     * 主キーで認定調査委託先情報件数を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 認定調査委託先コード NinteichosaItakusakiCode
     * @return 認定調査委託先情報件数
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public int countByKey(LasdecCode 市町村コード, RString 認定調査委託先コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5910NinteichosaItakusakiJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(ninteichosaItakusakiCode, 認定調査委託先コード))).getCount();
    }

    /**
     * 市町村コードで、認定調査委託先情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @return List<DbT5910NinteichosaItakusakiJohoEntity> 認定調査委託先情報リスト
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5910NinteichosaItakusakiJohoEntity> shichosonCodeAndJokyoFlag(
            LasdecCode 市町村コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5910NinteichosaItakusakiJoho.class).
                where(and(
                                eq(DbT5910NinteichosaItakusakiJoho.shichosonCode, 市町村コード),
                                eq(DbT5910NinteichosaItakusakiJoho.jokyoFlag, true)))
                .toList(DbT5910NinteichosaItakusakiJohoEntity.class);
    }

    /**
     * 対象認定調査員所属機関を全件返します。
     *
     * @param 市町村コード 市町村コード
     * @return DbT5910NinteichosaItakusakiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5910NinteichosaItakusakiJohoEntity> select対象認定調査員所属機関(LasdecCode 市町村コード) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5910NinteichosaItakusakiJoho.class).where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(jokyoFlag, true))).
                toList(DbT5910NinteichosaItakusakiJohoEntity.class);
    }

    /**
     * 主キーで認定調査委託先情報を取得します。
     *
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return DbT5910NinteichosaItakusakiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5910NinteichosaItakusakiJohoEntity> selectBy認定調査委託先コード(RString 認定調査委託先コード) throws NullPointerException {
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5910NinteichosaItakusakiJoho.class).
                where((eq(ninteichosaItakusakiCode, 認定調査委託先コード))).
                toList(DbT5910NinteichosaItakusakiJohoEntity.class);
    }
}
