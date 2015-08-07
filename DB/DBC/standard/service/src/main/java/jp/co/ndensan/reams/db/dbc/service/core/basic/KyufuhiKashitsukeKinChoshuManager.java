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
 * 給付費貸付金徴収を管理するクラスです。
 */
public class KyufuhiKashitsukeKinChoshuManager {

    private final DbT3092KyufuhiKashitsukeKinChoshuDac dac;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukeKinChoshuManager() {
        dac = InstanceProvider.create(DbT3092KyufuhiKashitsukeKinChoshuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3092KyufuhiKashitsukeKinChoshuDac}
     */
    KyufuhiKashitsukeKinChoshuManager(DbT3092KyufuhiKashitsukeKinChoshuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付費貸付金徴収を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 貸付管理番号 KashitsukeKanriNo
     * @param 履歴番号 RirekiNo
     * @return KyufuhiKashitsukeKinChoshu
     */
    @Transaction
    public KyufuhiKashitsukeKinChoshu get給付費貸付金徴収(
             HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3092KyufuhiKashitsukeKinChoshuEntity entity = dac.selectByKey(
                被保険者番号,
                貸付管理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufuhiKashitsukeKinChoshu(entity);
    }

    /**
     * 給付費貸付金徴収を全件返します。
     *
     * @return List<KyufuhiKashitsukeKinChoshu>
     */
    @Transaction
    public List<KyufuhiKashitsukeKinChoshu> get給付費貸付金徴収一覧() {
        List<KyufuhiKashitsukeKinChoshu> businessList = new ArrayList<>();

        for (DbT3092KyufuhiKashitsukeKinChoshuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufuhiKashitsukeKinChoshu(entity));
        }

        return businessList;
    }

    /**
     * 給付費貸付金徴収{@link KyufuhiKashitsukeKinChoshu}を保存します。
     *
     * @param 給付費貸付金徴収 {@link KyufuhiKashitsukeKinChoshu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付費貸付金徴収(KyufuhiKashitsukeKinChoshu 給付費貸付金徴収) {
        requireNonNull(給付費貸付金徴収, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金徴収"));
        if (!給付費貸付金徴収.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付費貸付金徴収.toEntity());
    }
}
