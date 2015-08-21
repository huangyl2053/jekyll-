/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiKashitsukekinEntaiRisokuKeisan;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金延滞利息計算を管理するクラスです。
 */
public class KyufuhiKashitsukekinEntaiRisokuKeisanManager {

    private final DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanDac dac;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukekinEntaiRisokuKeisanManager() {
        dac = InstanceProvider.create(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanDac}
     */
    KyufuhiKashitsukekinEntaiRisokuKeisanManager(DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付費貸付金延滞利息計算を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 貸付管理番号 KashitsukeKanriNo
     * @param 履歴番号 RirekiNo
     * @return KyufuhiKashitsukekinEntaiRisokuKeisan
     */
    @Transaction
    public KyufuhiKashitsukekinEntaiRisokuKeisan get給付費貸付金延滞利息計算(
            HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity = dac.selectByKey(
                被保険者番号,
                貸付管理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufuhiKashitsukekinEntaiRisokuKeisan(entity);
    }

    /**
     * 給付費貸付金延滞利息計算を全件返します。
     *
     * @return List<KyufuhiKashitsukekinEntaiRisokuKeisan>
     */
    @Transaction
    public List<KyufuhiKashitsukekinEntaiRisokuKeisan> get給付費貸付金延滞利息計算一覧() {
        List<KyufuhiKashitsukekinEntaiRisokuKeisan> businessList = new ArrayList<>();

        for (DbT3090KyufuhiKashitsukekinEntaiRisokuKeisanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufuhiKashitsukekinEntaiRisokuKeisan(entity));
        }

        return businessList;
    }

    /**
     * 給付費貸付金延滞利息計算{@link KyufuhiKashitsukekinEntaiRisokuKeisan}を保存します。
     *
     * @param 給付費貸付金延滞利息計算 {@link KyufuhiKashitsukekinEntaiRisokuKeisan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付費貸付金延滞利息計算(KyufuhiKashitsukekinEntaiRisokuKeisan 給付費貸付金延滞利息計算) {
        requireNonNull(給付費貸付金延滞利息計算, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金延滞利息計算"));
        if (!給付費貸付金延滞利息計算.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付費貸付金延滞利息計算.toEntity());
    }
}
