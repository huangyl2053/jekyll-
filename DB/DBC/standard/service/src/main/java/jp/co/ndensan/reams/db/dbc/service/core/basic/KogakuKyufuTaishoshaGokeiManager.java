/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3055KogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3055KogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費給付対象者合計を管理するクラスです。
 */
public class KogakuKyufuTaishoshaGokeiManager {

    private final DbT3055KogakuKyufuTaishoshaGokeiDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuKyufuTaishoshaGokeiManager() {
        dac = InstanceProvider.create(DbT3055KogakuKyufuTaishoshaGokeiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3055KogakuKyufuTaishoshaGokeiDac}
     */
    KogakuKyufuTaishoshaGokeiManager(DbT3055KogakuKyufuTaishoshaGokeiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額介護サービス費給付対象者合計を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 履歴番号 RirekiNo
     * @return KogakuKyufuTaishoshaGokei
     */
    @Transaction
    public KogakuKyufuTaishoshaGokei get高額介護サービス費給付対象者合計(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3055KogakuKyufuTaishoshaGokeiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuKyufuTaishoshaGokei(entity);
    }

    /**
     * 高額介護サービス費給付対象者合計を全件返します。
     *
     * @return List<KogakuKyufuTaishoshaGokei>
     */
    @Transaction
    public List<KogakuKyufuTaishoshaGokei> get高額介護サービス費給付対象者合計一覧() {
        List<KogakuKyufuTaishoshaGokei> businessList = new ArrayList<>();

        for (DbT3055KogakuKyufuTaishoshaGokeiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuKyufuTaishoshaGokei(entity));
        }

        return businessList;
    }

    /**
     * 高額介護サービス費給付対象者合計{@link KogakuKyufuTaishoshaGokei}を保存します。
     *
     * @param 高額介護サービス費給付対象者合計 {@link KogakuKyufuTaishoshaGokei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額介護サービス費給付対象者合計(KogakuKyufuTaishoshaGokei 高額介護サービス費給付対象者合計) {
        requireNonNull(高額介護サービス費給付対象者合計, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費給付対象者合計"));
        if (!高額介護サービス費給付対象者合計.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額介護サービス費給付対象者合計.toEntity());
    }
}
