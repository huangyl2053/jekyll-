/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.db.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002Fuka;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002Fuka.choteiNendo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002Fuka.fukaNendo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002Fuka.hihokenshaNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002Fuka.rirekiNo;
import static jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002Fuka.tsuchishoNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT2002FukaEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.Order;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.by;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 介護賦課のデータアクセスクラスです。
 * <p/>
 * DBX修正回避のための暫定対応です。
 */
public class _DbT2002FukaDac {

    private static final RString 賦課年度_KEY = new RString("賦課年度");
    private static final RString 被保険者番号_KEY = new RString("被保険者番号");
    @InjectSession
    private SqlSession session;

    /**
     * 指定の被保険者について、賦課年度に対する最新の介護賦課を返します。
     *
     * @param 賦課年度 賦課年度
     * @param 被保険者番号 被保険者番号
     * @return DbT2002FukaEntity もしくは{@code null}
     * @throws NullPointerException 引数のいずれかが{@code null}の場合
     */
    public DbT2002FukaEntity selectByFukanendoSaishinPerHihokenshaNo(
            FlexibleYear 賦課年度,
            HihokenshaNo 被保険者番号) throws NullPointerException {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度_KEY.toString()));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号_KEY.toString()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT2002Fuka.class).
                where(and(
                                eq(fukaNendo, 賦課年度),
                                eq(hihokenshaNo, 被保険者番号))).
                order(
                        by(choteiNendo, Order.DESC),
                        by(tsuchishoNo, Order.DESC),
                        by(rirekiNo, Order.DESC))
                .limit(1)
                .toObject(DbT2002FukaEntity.class);
    }
}
