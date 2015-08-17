/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.persistence.basic;

import java.util.List;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV3057KogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbx.entity.basic.DbV3057KogakuShikyuHanteiKekka;
import static jp.co.ndensan.reams.db.dbx.entity.basic.DbV3057KogakuShikyuHanteiKekka.*;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;

/**
 * 高額介護サービス費のデータアクセスクラスです。
 *
 * @author N9943 王 永康
 * @jpName 高額介護サービス費Dac
 * @bizDomain 介護
 * @category 高額介護給付費
 * @subCategory
 * @mainClass
 * @reference
 */
public class KogakuKaigoServiceHiDac implements IKogakuKaigoServiceHiDac {

    @InjectSession
    private SqlSession session;

    @Override
    public DbV3057KogakuShikyuHanteiKekkaEntity select(RString 被保険者番号, FlexibleYearMonth 対象年月) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        List<DbV3057KogakuShikyuHanteiKekkaEntity> result = accessor
                .select()
                .table(DbV3057KogakuShikyuHanteiKekka.class)
                .where(and(eq(hihokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, 対象年月)))
                .toList(DbV3057KogakuShikyuHanteiKekkaEntity.class);
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }
}
