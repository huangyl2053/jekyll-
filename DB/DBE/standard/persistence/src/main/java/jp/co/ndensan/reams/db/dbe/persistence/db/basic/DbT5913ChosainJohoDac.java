/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho.ninteiChosainNo;
import static jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJoho.ninteichosaItakusakiCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5223ChikuNinteiChosain.shichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5913ChosainJohoEntity;
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
 * 調査員情報のデータアクセスクラスです。
 */
public class DbT5913ChosainJohoDac implements ISaveable<DbT5913ChosainJohoEntity> {

    @InjectSession
    private SqlSession session;

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
            RString 認定調査委託先コード,
            RString 認定調査員コード) throws NullPointerException {
        requireNonNull(市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(認定調査委託先コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査委託先コード"));
        requireNonNull(認定調査員コード, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査員コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5913ChosainJoho.class).
                where(and(
                                eq(shichosonCode, 市町村コード),
                                eq(ninteichosaItakusakiCode, 認定調査委託先コード),
                                eq(ninteiChosainNo, 認定調査員コード))).
                toObject(DbT5913ChosainJohoEntity.class);
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
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("調査員情報エンティティ"));

        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }
}
