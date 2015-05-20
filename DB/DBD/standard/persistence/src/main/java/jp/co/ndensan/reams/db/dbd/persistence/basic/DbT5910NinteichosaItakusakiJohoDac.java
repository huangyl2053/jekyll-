/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.persistence.basic;

import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5910NinteichosaItakusakiJoho;
import static jp.co.ndensan.reams.db.dbd.entity.basic.DbT5910NinteichosaItakusakiJoho.*;
import jp.co.ndensan.reams.db.dbd.entity.basic.DbT5910NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査委託先情報のデータアクセスクラスです。
 *
 * @author n8223 朴義一
 */
public class DbT5910NinteichosaItakusakiJohoDac implements IModifiable<DbT5910NinteichosaItakusakiJohoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで認定調査委託先情報を取得します。
     *
     * @param 市町村コード ShichosonCode
     * @param 認定調査委託先コード NinteichosaItakusakiCode
     * @return DbT5910NinteichosaItakusakiJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT5910NinteichosaItakusakiJohoEntity selectByKey(
            ShichosonCode 市町村コード,
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
     * @return List<DbT5910NinteichosaItakusakiJohoEntity>
     */
    @Transaction
    public List<DbT5910NinteichosaItakusakiJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT5910NinteichosaItakusakiJoho.class).
                toList(DbT5910NinteichosaItakusakiJohoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT5910NinteichosaItakusakiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT5910NinteichosaItakusakiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT5910NinteichosaItakusakiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT5910NinteichosaItakusakiJohoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT5910NinteichosaItakusakiJohoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
