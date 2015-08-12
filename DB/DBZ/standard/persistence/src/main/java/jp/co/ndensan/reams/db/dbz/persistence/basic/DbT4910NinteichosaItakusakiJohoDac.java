/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.ninteishinsei.ChosaItakusakiCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4910NinteichosaItakusakiJoho;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4910NinteichosaItakusakiJoho.ninteichosaItakusakiCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT4910NinteichosaItakusakiJoho.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査委託先情報のデータアクセスクラスです。
 */
public class DbT4910NinteichosaItakusakiJohoDac implements ISaveable<DbT4910NinteichosaItakusakiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査委託先情報を取得します。
     *
     * @param 市町村コード 市町村コード
     * @param 認定調査委託先コード 認定調査委託先コード
     * @return DbT4910NinteichosaItakusakiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT4910NinteichosaItakusakiJohoEntity selectByKey(
            LasdecCode 市町村コード,
            ChosaItakusakiCode 認定調査委託先コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4910NinteichosaItakusakiJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(ninteichosaItakusakiCode, 認定調査委託先コード))).
                toObject(DbT4910NinteichosaItakusakiJohoEntity.class);
    }

    /**
     * 認定調査委託先情報を全件返します。
     *
     * @return DbT4910NinteichosaItakusakiJohoEntityの{@code list}
     */
    @Transaction
    public List<DbT4910NinteichosaItakusakiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT4910NinteichosaItakusakiJoho.class).
                toList(DbT4910NinteichosaItakusakiJohoEntity.class);
    }

    /**
     * DbT4910NinteichosaItakusakiJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT4910NinteichosaItakusakiJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先情報エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
