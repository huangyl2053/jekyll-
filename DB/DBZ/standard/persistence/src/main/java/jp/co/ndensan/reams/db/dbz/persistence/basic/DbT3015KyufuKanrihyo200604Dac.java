/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3015KyufuKanrihyo200604;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3015KyufuKanrihyo200604.kyotakushienJigyoshoNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3015KyufuKanrihyo200604.kyufuMeisaiLineNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3015KyufuKanrihyo200604.kyufuSakuseiKubunCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3015KyufuKanrihyo200604.kyufuSakuseiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3015KyufuKanrihyo200604.kyufuShubetsuKubunCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3015KyufuKanrihyo200604.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3015KyufuKanrihyo200604.shinsaYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3015KyufuKanrihyo200604.shokisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3015KyufuKanrihyo200604Entity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付管理票200604のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT3015KyufuKanrihyo200604Dac implements IModifiable<DbT3015KyufuKanrihyo200604Entity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付管理票200604を取得します。
     *
     * @param 審査年月 ShinsaYM
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 居宅支援事業所番号 KyotakushienJigyoshoNo
     * @param 給付管理票情報作成区分コード KyufuSakuseiKubunCode
     * @param 給付管理票作成年月日 KyufuSakuseiYMD
     * @param 給付管理票種別区分コード KyufuShubetsuKubunCode
     * @param 給付管理票明細行番号 KyufuMeisaiLineNo
     * @return DbT3015KyufuKanrihyo200604Entity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3015KyufuKanrihyo200604Entity selectByKey(
            FlexibleYearMonth 審査年月,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            JigyoshaNo 居宅支援事業所番号,
            RString 給付管理票情報作成区分コード,
            FlexibleDate 給付管理票作成年月日,
            RString 給付管理票種別区分コード,
            RString 給付管理票明細行番号) throws NullPointerException {
        requireNonNull(審査年月, UrSystemErrorMessages.値がnull.getReplacedMessage("審査年月"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(居宅支援事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅支援事業所番号"));
        requireNonNull(給付管理票情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票情報作成区分コード"));
        requireNonNull(給付管理票作成年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票作成年月日"));
        requireNonNull(給付管理票種別区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票種別区分コード"));
        requireNonNull(給付管理票明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("給付管理票明細行番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3015KyufuKanrihyo200604.class).
                where(and(
                                eq(shinsaYM, 審査年月),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(kyotakushienJigyoshoNo, 居宅支援事業所番号),
                                eq(kyufuSakuseiKubunCode, 給付管理票情報作成区分コード),
                                eq(kyufuSakuseiYMD, 給付管理票作成年月日),
                                eq(kyufuShubetsuKubunCode, 給付管理票種別区分コード),
                                eq(kyufuMeisaiLineNo, 給付管理票明細行番号))).
                toObject(DbT3015KyufuKanrihyo200604Entity.class);
    }

    /**
     * 給付管理票200604を全件返します。
     *
     * @return List<DbT3015KyufuKanrihyo200604Entity>
     */
    @Transaction
    public List<DbT3015KyufuKanrihyo200604Entity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3015KyufuKanrihyo200604.class).
                toList(DbT3015KyufuKanrihyo200604Entity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3015KyufuKanrihyo200604Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3015KyufuKanrihyo200604Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3015KyufuKanrihyo200604Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3015KyufuKanrihyo200604Entity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3015KyufuKanrihyo200604Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
