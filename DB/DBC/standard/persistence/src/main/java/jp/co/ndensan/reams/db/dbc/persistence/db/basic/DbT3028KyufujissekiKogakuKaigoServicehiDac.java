/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.persistence.db.basic;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3028KyufujissekiKogakuKaigoServicehi;
import static jp.co.ndensan.reams.db.dbc.entity.basic.DbT3028KyufujissekiKogakuKaigoServicehi.*;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.ISaveable;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessorMethodSelector;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績高額介護サービス費のデータアクセスクラスです。
 */
public class DbT3028KyufujissekiKogakuKaigoServicehiDac implements ISaveable<DbT3028KyufujissekiKogakuKaigoServicehiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付実績高額介護サービス費を取得します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 通し番号 ToshiNo
     * @param 給付実績情報作成区分コード KyufuSakuseiKubunCode
     * @param 給付実績区分コード KyufuJissekiKubunCode
     * @return DbT3028KyufujissekiKogakuKaigoServicehiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3028KyufujissekiKogakuKaigoServicehiEntity selectByKey(
            KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 通し番号,
            RString 給付実績情報作成区分コード,
            RString 給付実績区分コード) throws NullPointerException {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3028KyufujissekiKogakuKaigoServicehi.class).
                where(and(
                                eq(kokanJohoShikibetsuNo, 交換情報識別番号),
                                eq(inputShikibetsuNo, 入力識別番号),
                                eq(recodeShubetsuCode, レコード種別コード),
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(toshiNo, 通し番号),
                                eq(kyufuSakuseiKubunCode, 給付実績情報作成区分コード),
                                eq(kyufuJissekiKubunCode, 給付実績区分コード))).
                toObject(DbT3028KyufujissekiKogakuKaigoServicehiEntity.class);
    }

    /**
     * 給付実績高額介護サービス費を全件返します。
     *
     * @return List<DbT3028KyufujissekiKogakuKaigoServicehiEntity>
     */
    @Transaction
    public List<DbT3028KyufujissekiKogakuKaigoServicehiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3028KyufujissekiKogakuKaigoServicehi.class).
                toList(DbT3028KyufujissekiKogakuKaigoServicehiEntity.class);
    }

    /**
     * DbT3028KyufujissekiKogakuKaigoServicehiEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(DbT3028KyufujissekiKogakuKaigoServicehiEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績高額介護サービス費エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessorMethodSelector.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessorMethodSelector.saveBy(new DbAccessorNormalType(session), entity);
    }
}
