/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiKashitsukeKinEntaiRisokuKinChoshu;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金延滞利息金徴収を管理するクラスです。
 */
public class KyufuhiKashitsukeKinEntaiRisokuKinChoshuManager {

    private final DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuDac dac;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukeKinEntaiRisokuKinChoshuManager() {
        dac = InstanceProvider.create(DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuDac}
     */
    KyufuhiKashitsukeKinEntaiRisokuKinChoshuManager(DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付費貸付金延滞利息金徴収を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 貸付管理番号 KashitsukeKanriNo
     * @param 履歴番号 RirekiNo
     * @return KyufuhiKashitsukeKinEntaiRisokuKinChoshu
     */
    @Transaction
    public KyufuhiKashitsukeKinEntaiRisokuKinChoshu get給付費貸付金延滞利息金徴収(
            HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity entity = dac.selectByKey(
                被保険者番号,
                貸付管理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(entity);
    }

    /**
     * 給付費貸付金延滞利息金徴収を全件返します。
     *
     * @return List<KyufuhiKashitsukeKinEntaiRisokuKinChoshu>
     */
    @Transaction
    public List<KyufuhiKashitsukeKinEntaiRisokuKinChoshu> get給付費貸付金延滞利息金徴収一覧() {
        List<KyufuhiKashitsukeKinEntaiRisokuKinChoshu> businessList = new ArrayList<>();

        for (DbT3091KyufuhiKashitsukeKinEntaiRisokuKinChoshuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufuhiKashitsukeKinEntaiRisokuKinChoshu(entity));
        }

        return businessList;
    }

    /**
     * 給付費貸付金延滞利息金徴収{@link KyufuhiKashitsukeKinEntaiRisokuKinChoshu}を保存します。
     *
     * @param 給付費貸付金延滞利息金徴収 {@link KyufuhiKashitsukeKinEntaiRisokuKinChoshu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付費貸付金延滞利息金徴収(KyufuhiKashitsukeKinEntaiRisokuKinChoshu 給付費貸付金延滞利息金徴収) {
        requireNonNull(給付費貸付金延滞利息金徴収, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金延滞利息金徴収"));
        if (!給付費貸付金延滞利息金徴収.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付費貸付金延滞利息金徴収.toEntity());
    }
}
