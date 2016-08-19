/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuKyufuTaishoshaMeisai;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT3054KogakuKyufuTaishoshaMeisaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額介護サービス費給付対象者明細を管理するクラスです。
 */
public class KogakuKyufuTaishoshaMeisaiManager {

    private final DbT3054KogakuKyufuTaishoshaMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuKyufuTaishoshaMeisaiManager() {
        dac = InstanceProvider.create(DbT3054KogakuKyufuTaishoshaMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3054KogakuKyufuTaishoshaMeisaiDac}
     */
    KogakuKyufuTaishoshaMeisaiManager(DbT3054KogakuKyufuTaishoshaMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額介護サービス費給付対象者明細を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 事業者番号 JigyoshaNo
     * @param サービス種類コード ServiceShuruiCode
     * @param 履歴番号 RirekiNo
     * @return KogakuKyufuTaishoshaMeisai
     */
    @Transaction
    public KogakuKyufuTaishoshaMeisai get高額介護サービス費給付対象者明細(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            JigyoshaNo 事業者番号,
            ServiceShuruiCode サービス種類コード,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(サービス種類コード, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス種類コード"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3054KogakuKyufuTaishoshaMeisaiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                事業者番号,
                サービス種類コード,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuKyufuTaishoshaMeisai(entity);
    }

    /**
     * 高額介護サービス費給付対象者明細を全件返します。
     *
     * @return List<KogakuKyufuTaishoshaMeisai>
     */
    @Transaction
    public List<KogakuKyufuTaishoshaMeisai> get高額介護サービス費給付対象者明細一覧() {
        List<KogakuKyufuTaishoshaMeisai> businessList = new ArrayList<>();

        for (DbT3054KogakuKyufuTaishoshaMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuKyufuTaishoshaMeisai(entity));
        }

        return businessList;
    }

    /**
     * 高額介護サービス費給付対象者明細{@link KogakuKyufuTaishoshaMeisai}を保存します。
     *
     * @param 高額介護サービス費給付対象者明細 {@link KogakuKyufuTaishoshaMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額介護サービス費給付対象者明細(KogakuKyufuTaishoshaMeisai 高額介護サービス費給付対象者明細) {
        requireNonNull(高額介護サービス費給付対象者明細, UrSystemErrorMessages.値がnull.getReplacedMessage("高額介護サービス費給付対象者明細"));
        if (!高額介護サービス費給付対象者明細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額介護サービス費給付対象者明細.toEntity());
    }
}
