/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuJissekiCareManagementHi;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki.DbT3031KyufuJissekiCareManagementHiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3031KyufuJissekiCareManagementHiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.KokanShikibetsuNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.NyuryokuShikibetsuNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績ケアマネジメント費を管理するクラスです。
 */
public class KyufuJissekiCareManagementHiManager {

    private final DbT3031KyufuJissekiCareManagementHiDac dac;

    /**
     * コンストラクタです。
     */
    public KyufuJissekiCareManagementHiManager() {
        dac = InstanceProvider.create(DbT3031KyufuJissekiCareManagementHiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3031KyufuJissekiCareManagementHiDac}
     */
    KyufuJissekiCareManagementHiManager(DbT3031KyufuJissekiCareManagementHiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付実績ケアマネジメント費を返します。
     *
     * @param 交換情報識別番号 KokanJohoShikibetsuNo
     * @param 入力識別番号 InputShikibetsuNo
     * @param レコード種別コード RecodeShubetsuCode
     * @param 証記載保険者番号 ShokisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業所番号 JigyoshoNo
     * @param 指定_基準該当事業所区分コード ShiteiKijungaitoJigyoshoKubunCode
     * @param 居宅サービス計画作成依頼届出年月日 KyotakuServiceSakuseiIraiYMD
     * @param 通し番号 ToshiNo
     * @param サービス計画費明細行番号 ServicePlanhiMeisaiLineNo
     * @return KyufuJissekiCareManagementHi
     */
    @Transaction
    public KyufuJissekiCareManagementHi get給付実績ケアマネジメント費(
            KokanShikibetsuNo 交換情報識別番号,
            NyuryokuShikibetsuNo 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業所番号,
            RString 指定_基準該当事業所区分コード,
            FlexibleDate 居宅サービス計画作成依頼届出年月日,
            RString 通し番号,
            RString サービス計画費明細行番号) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業所番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業所番号"));
        requireNonNull(指定_基準該当事業所区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("指定／基準該当事業所区分コード")
        );
        requireNonNull(居宅サービス計画作成依頼届出年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("居宅サービス計画作成依頼届出年月日"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(サービス計画費明細行番号, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス計画費明細行番号"));

        DbT3031KyufuJissekiCareManagementHiEntity entity = dac.selectByKey(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                事業所番号,
                指定_基準該当事業所区分コード,
                居宅サービス計画作成依頼届出年月日,
                通し番号,
                サービス計画費明細行番号
        );
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufuJissekiCareManagementHi(entity);
    }

    /**
     * 給付実績ケアマネジメント費を全件返します。
     *
     * @return List<KyufuJissekiCareManagementHi>
     */
    @Transaction
    public List<KyufuJissekiCareManagementHi> get給付実績ケアマネジメント費一覧() {
        List<KyufuJissekiCareManagementHi> businessList = new ArrayList<>();

        for (DbT3031KyufuJissekiCareManagementHiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufuJissekiCareManagementHi(entity));
        }

        return businessList;
    }

    /**
     * 給付実績ケアマネジメント費{@link KyufuJissekiCareManagementHi}を保存します。
     *
     * @param 給付実績ケアマネジメント費 {@link KyufuJissekiCareManagementHi}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付実績ケアマネジメント費(KyufuJissekiCareManagementHi 給付実績ケアマネジメント費) {
        requireNonNull(給付実績ケアマネジメント費, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績ケアマネジメント費"));
        if (!給付実績ケアマネジメント費.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付実績ケアマネジメント費.toEntity());
    }
}
