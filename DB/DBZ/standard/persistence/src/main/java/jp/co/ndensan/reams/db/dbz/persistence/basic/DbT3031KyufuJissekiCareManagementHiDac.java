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
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.hiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.inputShikibetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.jigyoshoNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.kokanJohoShikibetsuNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.kyotakuServiceSakuseiIraiYMD;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.recodeShubetsuCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.servicePlanhiMeisaiLineNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.serviceTeikyoYM;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.shiteiKijungaitoJigyoshoKubunCode;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.shokisaiHokenshaNo;
import static jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHi.toshiNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3031KyufuJissekiCareManagementHiEntity;
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
 * 給付実績ケアマネジメント費のデータアクセスクラスです。
 *
 * @author LDNS 周杏月
 */
public class DbT3031KyufuJissekiCareManagementHiDac implements IModifiable<DbT3031KyufuJissekiCareManagementHiEntity> {

    @InjectSession
    private SqlSession session;

    /**
     * 主キーで給付実績ケアマネジメント費を取得します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業所番号 JigyoshoNo
     * @param 指定基準該当事業所区分コード ShiteiKijungaitoJigyoshoKubunCode
     * @param 居宅サービス計画作成依頼届出年月日 KyotakuServiceSakuseiIraiYMD
     * @param 通し番号 ToshiNo
     * @param サービス計画費明細行番号 ServicePlanhiMeisaiLineNo
     * @return DbT3031KyufuJissekiCareManagementHiEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public DbT3031KyufuJissekiCareManagementHiEntity selectByKey(
            KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 指定基準該当事業所区分コード,
            FlexibleDate 居宅サービス計画作成依頼届出年月日,
            RString 通し番号,
            RString サービス計画費明細行番号) throws NullPointerException {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(指定基準該当事業所区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("指定基準該当事業所区分コード")
        );
        requireNonNull(居宅サービス計画作成依頼届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成依頼届出年月日"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(サービス計画費明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス計画費明細行番号"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3031KyufuJissekiCareManagementHi.class).
                where(and(
                                eq(kokanJohoShikibetsuNo, 交換情報識別番号),
                                eq(inputShikibetsuNo, 入力識別番号),
                                eq(recodeShubetsuCode, レコード種別コード),
                                eq(shokisaiHokenshaNo, 証記載保険者番号),
                                eq(hiHokenshaNo, 被保険者番号),
                                eq(serviceTeikyoYM, サービス提供年月),
                                eq(jigyoshoNo, 事業所番号),
                                eq(shiteiKijungaitoJigyoshoKubunCode, 指定基準該当事業所区分コード
                                ),
                                eq(kyotakuServiceSakuseiIraiYMD, 居宅サービス計画作成依頼届出年月日),
                                eq(toshiNo, 通し番号),
                                eq(servicePlanhiMeisaiLineNo, サービス計画費明細行番号)
                        )).
                toObject(DbT3031KyufuJissekiCareManagementHiEntity.class);
    }

    /**
     * 給付実績ケアマネジメント費を全件返します。
     *
     * @return List<DbT3031KyufuJissekiCareManagementHiEntity>
     */
    @Transaction
    public List<DbT3031KyufuJissekiCareManagementHiEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(DbT3031KyufuJissekiCareManagementHi.class).
                toList(DbT3031KyufuJissekiCareManagementHiEntity.class);
    }

    /**
     * 給付実績ケアマネジメント費を追加します。
     *
     * @param entity 給付実績ケアマネジメント費
     * @return 影響行数
     */
    @Transaction
    @Override
    public int insert(DbT3031KyufuJissekiCareManagementHiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.insert(entity).execute();
    }

    /**
     * 給付実績ケアマネジメント費をDBに更新します。
     *
     * @param entity 給付実績ケアマネジメント費
     * @return 影響行数
     */
    @Transaction
    @Override
    public int update(DbT3031KyufuJissekiCareManagementHiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.update(entity).execute();
    }

    /**
     * 給付実績ケアマネジメント費をDBから削除します。（論理削除）
     *
     * @param entity 給付実績ケアマネジメント費
     * @return 影響行数
     */
    @Transaction
    @Override
    public int delete(DbT3031KyufuJissekiCareManagementHiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.delete(entity).execute();
    }

    // TODO 物理削除用メソッドが必要であるかは業務ごとに検討してください。
    /**
     * 給付実績ケアマネジメント費を物理削除。
     *
     * @param entity 給付実績ケアマネジメント費
     * @return 影響行数
     */
    @Transaction
    public int deletePhysical(DbT3031KyufuJissekiCareManagementHiEntity entity) {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.deletePhysical(entity).execute();
    }
}
