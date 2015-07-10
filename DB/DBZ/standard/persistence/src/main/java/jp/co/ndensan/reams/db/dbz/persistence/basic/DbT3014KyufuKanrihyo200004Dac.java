/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004.kyotakushienJigyoshoNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004.kyufuKanrihyoMeisaiLineNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004.kyufuKanrihyoSakuseiKubunCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004.kyufuKanrihyoSakuseiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004.kyufuKanrihyoShubetsuKubunCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004.shinsaYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004.shokisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3014KyufuKanrihyo200004Entity;
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
 * 給付管理票200004のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT3014KyufuKanrihyo200004Dac implements IModifiable<DbT3014KyufuKanrihyo200004Entity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付管理票200004を取得します。
     *
     * @param 審査年月 ShinsaYM
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 居宅支援事業所番号 KyotakushienJigyoshoNo
     * @param 給付管理票情報作成区分コード KyufuKanrihyoSakuseiKubunCode
     * @param 給付管理票作成年月日 KyufuKanrihyoSakuseiYMD
     * @param 給付管理票種別区分コード KyufuKanrihyoShubetsuKubunCode
     * @param 給付管理票明細行番号 KyufuKanrihyoMeisaiLineNo
     * @return DbT3014KyufuKanrihyo200004Entity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3014KyufuKanrihyo200004Entity selectByKey(
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
                table(DbT3014KyufuKanrihyo200004.class).
                where(and(
                                eq(shinsaYM, 審査年月),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(kyotakushienJigyoshoNo, 居宅支援事業所番号),
                                eq(kyufuKanrihyoSakuseiKubunCode, 給付管理票情報作成区分コード),
                                eq(kyufuKanrihyoSakuseiYMD, 給付管理票作成年月日),
                                eq(kyufuKanrihyoShubetsuKubunCode, 給付管理票種別区分コード),
                                eq(kyufuKanrihyoMeisaiLineNo, 給付管理票明細行番号))).
                toObject(DbT3014KyufuKanrihyo200004Entity.class);
    }

    /**
     * 給付管理票200004を全件返します。
     *
     * @return List<DbT3014KyufuKanrihyo200004Entity>
     */
    @Transaction
    public List<DbT3014KyufuKanrihyo200004Entity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3014KyufuKanrihyo200004.class).
                toList(DbT3014KyufuKanrihyo200004Entity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3014KyufuKanrihyo200004Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3014KyufuKanrihyo200004Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3014KyufuKanrihyo200004Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3014KyufuKanrihyo200004Entity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3014KyufuKanrihyo200004Entity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
