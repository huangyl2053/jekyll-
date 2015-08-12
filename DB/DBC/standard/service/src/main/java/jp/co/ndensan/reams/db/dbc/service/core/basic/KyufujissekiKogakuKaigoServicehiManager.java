/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufujissekiKogakuKaigoServicehi;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3028KyufujissekiKogakuKaigoServicehiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3028KyufujissekiKogakuKaigoServicehiDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付実績高額介護サービス費を管理するクラスです。
 */
public class KyufujissekiKogakuKaigoServicehiManager {

    private final DbT3028KyufujissekiKogakuKaigoServicehiDac dac;

    /**
     * コンストラクタです。
     */
    public KyufujissekiKogakuKaigoServicehiManager() {
        dac = InstanceProvider.create(DbT3028KyufujissekiKogakuKaigoServicehiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3028KyufujissekiKogakuKaigoServicehiDac}
     */
    KyufujissekiKogakuKaigoServicehiManager(DbT3028KyufujissekiKogakuKaigoServicehiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付実績高額介護サービス費を返します。
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
     * @return KyufujissekiKogakuKaigoServicehi
     */
    @Transaction
    public KyufujissekiKogakuKaigoServicehi get給付実績高額介護サービス費(
            KokanShikibetsuCode 交換情報識別番号,
            NyuryokuShikibetsuCode 入力識別番号,
            RString レコード種別コード,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 通し番号,
            RString 給付実績情報作成区分コード,
            RString 給付実績区分コード) {
        requireNonNull(交換情報識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("交換情報識別番号"));
        requireNonNull(入力識別番号, UrSystemErrorMessages.値がnull.getReplacedMessage("入力識別番号"));
        requireNonNull(レコード種別コード, UrSystemErrorMessages.値がnull.getReplacedMessage("レコード種別コード"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(通し番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通し番号"));
        requireNonNull(給付実績情報作成区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績情報作成区分コード"));
        requireNonNull(給付実績区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績区分コード"));

        DbT3028KyufujissekiKogakuKaigoServicehiEntity entity = dac.selectByKey(
                交換情報識別番号,
                入力識別番号,
                レコード種別コード,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                通し番号,
                給付実績情報作成区分コード,
                給付実績区分コード);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufujissekiKogakuKaigoServicehi(entity);
    }

    /**
     * 給付実績高額介護サービス費を全件返します。
     *
     * @return List<KyufujissekiKogakuKaigoServicehi>
     */
    @Transaction
    public List<KyufujissekiKogakuKaigoServicehi> get給付実績高額介護サービス費一覧() {
        List<KyufujissekiKogakuKaigoServicehi> businessList = new ArrayList<>();

        for (DbT3028KyufujissekiKogakuKaigoServicehiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufujissekiKogakuKaigoServicehi(entity));
        }

        return businessList;
    }

    /**
     * 給付実績高額介護サービス費{@link KyufujissekiKogakuKaigoServicehi}を保存します。
     *
     * @param 給付実績高額介護サービス費 {@link KyufujissekiKogakuKaigoServicehi}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付実績高額介護サービス費(KyufujissekiKogakuKaigoServicehi 給付実績高額介護サービス費) {
        requireNonNull(給付実績高額介護サービス費, UrSystemErrorMessages.値がnull.getReplacedMessage("給付実績高額介護サービス費"));
        if (!給付実績高額介護サービス費.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付実績高額介護サービス費.toEntity());
    }
}
