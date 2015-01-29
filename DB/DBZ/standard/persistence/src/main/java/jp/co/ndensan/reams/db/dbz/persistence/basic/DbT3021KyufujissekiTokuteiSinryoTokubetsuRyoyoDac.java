/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.inputShikibetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.jigyoshoNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.kokanJohoShikibetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.recodeJunjiNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.recodeShubetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.shokisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.toshiNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.IModifiable;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績特定診療費・特別療養費のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoDac implements IModifiable<DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付実績特定診療費・特別療養費を取得します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業所番号 JigyoshoNo
     * @param 通し番号 ToshiNo
     * @param 特定診療情報レコード順次番号 RecodeJunjiNo
     * @return DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity selectByKey(
            KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 通し番号,
            RString 特定診療情報レコード順次番号) throws NullPointerException {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(特定診療情報レコード順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("特定診療情報レコード順次番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.class).
                where(and(
                                eq(kokanJohoShikibetsuNo, 交換情報識別番号),
                                eq(inputShikibetsuNo, 入力識別番号),
                                eq(recodeShubetsuCode, レコード種別コード),
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(jigyoshoNo, 事業所番号),
                                eq(toshiNo, 通し番号),
                                eq(recodeJunjiNo, 特定診療情報レコード順次番号))).
                toObject(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.class);
    }

    /**
     * 給付実績特定診療費・特別療養費を全件返します。
     *
     * @return List<DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity>
     */
    @Transaction
    public List<DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo.class).
                toList(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyoEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
