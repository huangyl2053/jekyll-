/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金償還期限変更を管理するクラスです。
 */
public class KyufuhiKashitsukekinShokanKigenHenkoManager {

    private final DbT3089KyufuhiKashitsukekinShokanKigenHenkoDac dac;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukekinShokanKigenHenkoManager() {
        dac = InstanceProvider.create(DbT3089KyufuhiKashitsukekinShokanKigenHenkoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3089KyufuhiKashitsukekinShokanKigenHenkoDac}
     */
    KyufuhiKashitsukekinShokanKigenHenkoManager(DbT3089KyufuhiKashitsukekinShokanKigenHenkoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付費貸付金償還期限変更を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 貸付管理番号 KashitsukeKanriNo
     * @param 償還期限延長受付年月日 ShokanKigenEnchoUketsukeYMD
     * @param 履歴番号 RirekiNo
     * @return KyufuhiKashitsukekinShokanKigenHenko
     */
    @Transaction
    public KyufuhiKashitsukekinShokanKigenHenko get給付費貸付金償還期限変更(
             HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            FlexibleDate 償還期限延長受付年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(償還期限延長受付年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("償還期限延長受付年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity = dac.selectByKey(
                被保険者番号,
                貸付管理番号,
                償還期限延長受付年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufuhiKashitsukekinShokanKigenHenko(entity);
    }

    /**
     * 給付費貸付金償還期限変更を全件返します。
     *
     * @return List<KyufuhiKashitsukekinShokanKigenHenko>
     */
    @Transaction
    public List<KyufuhiKashitsukekinShokanKigenHenko> get給付費貸付金償還期限変更一覧() {
        List<KyufuhiKashitsukekinShokanKigenHenko> businessList = new ArrayList<>();

        for (DbT3089KyufuhiKashitsukekinShokanKigenHenkoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufuhiKashitsukekinShokanKigenHenko(entity));
        }

        return businessList;
    }

    /**
     * 給付費貸付金償還期限変更{@link KyufuhiKashitsukekinShokanKigenHenko}を保存します。
     *
     * @param 給付費貸付金償還期限変更 {@link KyufuhiKashitsukekinShokanKigenHenko}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付費貸付金償還期限変更(KyufuhiKashitsukekinShokanKigenHenko 給付費貸付金償還期限変更) {
        requireNonNull(給付費貸付金償還期限変更, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金償還期限変更"));
        if (!給付費貸付金償還期限変更.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付費貸付金償還期限変更.toEntity());
    }
}
