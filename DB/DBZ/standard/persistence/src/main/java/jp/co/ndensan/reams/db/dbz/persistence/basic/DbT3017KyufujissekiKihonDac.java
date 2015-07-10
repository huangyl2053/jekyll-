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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon.hokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon.inputShikibetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon.jigyoshoNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon.kokanShikibetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon.kyufuJissekiKubunCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon.kyufuSakuseiKubunCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon.recodeShubetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihon.toshiNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3017KyufujissekiKihonEntity;
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
 * 給付実績基本のデータアクセスクラスです。
 *
 * @author LDNS 鄭雪双
 */
public class DbT3017KyufujissekiKihonDac implements IModifiable<DbT3017KyufujissekiKihonEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付実績基本を取得します。
     *
     * @param 交換情報識別番号 KokanShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 給付実績情報作成区分コード KyufuSakuseiKubunCode
     * @param 証記載保険者番号 HokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 給付実績区分コード KyufuJissekiKubunCode
     * @param 事業所番号 JigyoshoNo
     * @param 通し番号 ToshiNo
     * @return DbT3017KyufujissekiKihonEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3017KyufujissekiKihonEntity selectByKey(
            KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            RString 給付実績情報作成区分コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 給付実績区分コード,
            JigyoshaNo 事業所番号,
            RString 通し番号) throws NullPointerException {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3017KyufujissekiKihon.class).
                where(and(
                                eq(kokanShikibetsuNo, 交換情報識別番号),
                                eq(inputShikibetsuNo, 入力識別番号),
                                eq(recodeShubetsuCode, レコード種別コード),
                                eq(kyufuSakuseiKubunCode, 給付実績情報作成区分コード),
                                eq(hokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(kyufuJissekiKubunCode, 給付実績区分コード),
                                eq(jigyoshoNo, 事業所番号),
                                eq(toshiNo, 通し番号))).
                toObject(DbT3017KyufujissekiKihonEntity.class);
    }

    /**
     * 給付実績基本を全件返します。
     *
     * @return List<DbT3017KyufujissekiKihonEntity>
     */
    @Transaction
    public List<DbT3017KyufujissekiKihonEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3017KyufujissekiKihon.class).
                toList(DbT3017KyufujissekiKihonEntity.class);
    }

    @Transaction
    @Override
    public int insert(DbT3017KyufujissekiKihonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    @Transaction
    @Override
    public int update(DbT3017KyufujissekiKihonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    @Transaction
    @Override
    public int delete(DbT3017KyufujissekiKihonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 物理削除を行う。
     *
     * @param entity DbT3017KyufujissekiKihonEntity
     * @return int 件数
     */
    @Transaction
    public int deletePhysical(DbT3017KyufujissekiKihonEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
