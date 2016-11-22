/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.valueobject.ninteishinsei.ChosainCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJoho.jokyoFlag;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJoho.ninteiChosaItakusakiCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJoho.ninteiChosainCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJoho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
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
 * 調査員情報のデータアクセスクラスです。
 *
 * @reamsid_L DBE-0280-010 sunhaidi
 */
public class DbT5913ChosainJohoDac implements ISaveable<DbT5913ChosainJohoEntity> {

    @InjectSession
    private SqlSession session;

    private static final RString 定数市町村コード = new RString("市町村コード");
    private static final RString 定数認定調査委託先コード = new RString("認定調査委託先コード");
    private static final RString 定数認定調査員コード = new RString("認定調査員コード");
    private static final RString 定数調査員情報エンティティ = new RString("調査員情報エンティティ");

    /**
     * 主キーで調査員情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @param 認定調査員コード 認定調査員コード
     * @return DbT5913ChosainJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5913ChosainJohoEntity selectByKey(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード,
            ChosainCode 認定調査員コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数市町村コード.toString()));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数認定調査委託先コード.toString()));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数認定調査員コード.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5913ChosainJoho.class).
                where(and(
                        eq(shichosonCode, 市町村コード),
                        eq(ninteiChosaItakusakiCode, 認定調査委託先コード),
                        eq(ninteiChosainCode, 認定調査員コード))).
                toObject(DbT5913ChosainJohoEntity.class);
    }

    /**
     * 市町村コード、認定調査委託先コードで調査員情報一覧を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return DbT5913ChosainJohoEntityの{@code list}
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5913ChosainJohoEntity> selectByKey(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数市町村コード.toString()));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数認定調査委託先コード.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5913ChosainJoho.class).
                where(and(
                        eq(shichosonCode, 市町村コード),
                        eq(ninteiChosaItakusakiCode, 認定調査委託先コード))).
                toList(DbT5913ChosainJohoEntity.class);
    }

    /**
     * 調査員情報を全件返します。
     *
     * @return DbT5913ChosainJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT5913ChosainJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5913ChosainJoho.class).
                toList(DbT5913ChosainJohoEntity.class);
    }

    /**
     * DbT5913ChosainJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT5913ChosainJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(定数調査員情報エンティティ.toString()));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * DbT5913ChosainJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 件数
     */
    @Transaction
    public int saveOrDelete(DbT5913ChosainJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage(定数調査員情報エンティティ.toString()));

        return DbAccessors.saveOrDeletePhysicalBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 市町村コードと認定調査委託先コードで、調査員情報の件数を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return 件数
     */
    @Transaction
    public int countByShichosonCodeAndNinteichosaItakusakiCode(LasdecCode 市町村コード, RString 認定調査委託先コード) {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数市町村コード.toString()));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数認定調査委託先コード.toString()));
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5913ChosainJoho.class).
                where(and(
                        eq(DbT5913ChosainJoho.shichosonCode, 市町村コード),
                        eq(DbT5913ChosainJoho.ninteiChosaItakusakiCode, 認定調査委託先コード)))
                .getCount();
    }

    /**
     * 調査員情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return DbT5913ChosainJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public List<DbT5913ChosainJohoEntity> select調査員情報(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数市町村コード.toString()));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage(定数認定調査委託先コード.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5913ChosainJoho.class).
                where(and(
                        eq(shichosonCode, 市町村コード),
                        eq(ninteiChosaItakusakiCode, 認定調査委託先コード),
                        eq(jokyoFlag, true))).
                toList(DbT5913ChosainJohoEntity.class);
    }
}
