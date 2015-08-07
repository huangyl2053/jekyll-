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
 * 給付費貸付金申請を管理するクラスです。
 */
public class KyufuhiKashitsukekinShinseiManager {

    private final DbT3086KyufuhiKashitsukekinShinseiDac dac;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukekinShinseiManager() {
        dac = InstanceProvider.create(DbT3086KyufuhiKashitsukekinShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3086KyufuhiKashitsukekinShinseiDac}
     */
    KyufuhiKashitsukekinShinseiManager(DbT3086KyufuhiKashitsukekinShinseiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付費貸付金申請を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 借入申請年月日 KariireShinseiYMD
     * @param 履歴番号 RirekiNo
     * @return KyufuhiKashitsukekinShinsei
     */
    @Transaction
    public KyufuhiKashitsukekinShinsei get給付費貸付金申請(
             HihokenshaNo 被保険者番号,
            FlexibleDate 借入申請年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3086KyufuhiKashitsukekinShinseiEntity entity = dac.selectByKey(
                被保険者番号,
                借入申請年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufuhiKashitsukekinShinsei(entity);
    }

    /**
     * 給付費貸付金申請を全件返します。
     *
     * @return List<KyufuhiKashitsukekinShinsei>
     */
    @Transaction
    public List<KyufuhiKashitsukekinShinsei> get給付費貸付金申請一覧() {
        List<KyufuhiKashitsukekinShinsei> businessList = new ArrayList<>();

        for (DbT3086KyufuhiKashitsukekinShinseiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufuhiKashitsukekinShinsei(entity));
        }

        return businessList;
    }

    /**
     * 給付費貸付金申請{@link KyufuhiKashitsukekinShinsei}を保存します。
     *
     * @param 給付費貸付金申請 {@link KyufuhiKashitsukekinShinsei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付費貸付金申請(KyufuhiKashitsukekinShinsei 給付費貸付金申請) {
        requireNonNull(給付費貸付金申請, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金申請"));
        if (!給付費貸付金申請.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付費貸付金申請.toEntity());
    }
}
