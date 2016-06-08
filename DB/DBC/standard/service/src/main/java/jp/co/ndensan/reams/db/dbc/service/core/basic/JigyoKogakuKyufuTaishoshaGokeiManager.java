/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuKyufuTaishoshaGokei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3109JigyoKogakuKyufuTaishoshaGokeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額介護サービス費給付対象者合計を管理するクラスです。
 */
public class JigyoKogakuKyufuTaishoshaGokeiManager {

    private final DbT3109JigyoKogakuKyufuTaishoshaGokeiDac dac;

    /**
     * コンストラクタです。
     */
    public JigyoKogakuKyufuTaishoshaGokeiManager() {
        dac = InstanceProvider.create(DbT3109JigyoKogakuKyufuTaishoshaGokeiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3109JigyoKogakuKyufuTaishoshaGokeiDac}
     */
    JigyoKogakuKyufuTaishoshaGokeiManager(DbT3109JigyoKogakuKyufuTaishoshaGokeiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する事業高額介護サービス費給付対象者合計を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 履歴番号 RirekiNo
     * @return JigyoKogakuKyufuTaishoshaGokei
     */
    @Transaction
    public JigyoKogakuKyufuTaishoshaGokei get事業高額介護サービス費給付対象者合計(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JigyoKogakuKyufuTaishoshaGokei(entity);
    }

    /**
     * 事業高額介護サービス費給付対象者合計を全件返します。
     *
     * @return List<JigyoKogakuKyufuTaishoshaGokei>
     */
    @Transaction
    public List<JigyoKogakuKyufuTaishoshaGokei> get事業高額介護サービス費給付対象者合計一覧() {
        List<JigyoKogakuKyufuTaishoshaGokei> businessList = new ArrayList<>();

        for (DbT3109JigyoKogakuKyufuTaishoshaGokeiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JigyoKogakuKyufuTaishoshaGokei(entity));
        }

        return businessList;
    }

    /**
     * 事業高額介護サービス費給付対象者合計{@link JigyoKogakuKyufuTaishoshaGokei}を保存します。
     *
     * @param 事業高額介護サービス費給付対象者合計 {@link JigyoKogakuKyufuTaishoshaGokei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save事業高額介護サービス費給付対象者合計(JigyoKogakuKyufuTaishoshaGokei 事業高額介護サービス費給付対象者合計) {
        requireNonNull(事業高額介護サービス費給付対象者合計, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費給付対象者合計"));
        if (!事業高額介護サービス費給付対象者合計.hasChanged()) {
            return false;
        }
        return 1 == dac.save(事業高額介護サービス費給付対象者合計.toEntity());
    }
}
