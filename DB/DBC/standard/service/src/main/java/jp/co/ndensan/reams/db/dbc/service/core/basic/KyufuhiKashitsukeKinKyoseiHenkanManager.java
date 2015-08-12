/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiKashitsukeKinKyoseiHenkan;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3093KyufuhiKashitsukeKinKyoseiHenkanDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金強制返還を管理するクラスです。
 */
public class KyufuhiKashitsukeKinKyoseiHenkanManager {

    private final DbT3093KyufuhiKashitsukeKinKyoseiHenkanDac dac;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukeKinKyoseiHenkanManager() {
        dac = InstanceProvider.create(DbT3093KyufuhiKashitsukeKinKyoseiHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3093KyufuhiKashitsukeKinKyoseiHenkanDac}
     */
    KyufuhiKashitsukeKinKyoseiHenkanManager(DbT3093KyufuhiKashitsukeKinKyoseiHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付費貸付金強制返還を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 貸付管理番号 KashitsukeKanriNo
     * @param 履歴番号 RirekiNo
     * @return KyufuhiKashitsukeKinKyoseiHenkan
     */
    @Transaction
    public KyufuhiKashitsukeKinKyoseiHenkan get給付費貸付金強制返還(
            HihokenshaNo 被保険者番号,
            RString 貸付管理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(貸付管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("貸付管理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity = dac.selectByKey(
                被保険者番号,
                貸付管理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufuhiKashitsukeKinKyoseiHenkan(entity);
    }

    /**
     * 給付費貸付金強制返還を全件返します。
     *
     * @return List<KyufuhiKashitsukeKinKyoseiHenkan>
     */
    @Transaction
    public List<KyufuhiKashitsukeKinKyoseiHenkan> get給付費貸付金強制返還一覧() {
        List<KyufuhiKashitsukeKinKyoseiHenkan> businessList = new ArrayList<>();

        for (DbT3093KyufuhiKashitsukeKinKyoseiHenkanEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufuhiKashitsukeKinKyoseiHenkan(entity));
        }

        return businessList;
    }

    /**
     * 給付費貸付金強制返還{@link KyufuhiKashitsukeKinKyoseiHenkan}を保存します。
     *
     * @param 給付費貸付金強制返還 {@link KyufuhiKashitsukeKinKyoseiHenkan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付費貸付金強制返還(KyufuhiKashitsukeKinKyoseiHenkan 給付費貸付金強制返還) {
        requireNonNull(給付費貸付金強制返還, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金強制返還"));
        if (!給付費貸付金強制返還.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付費貸付金強制返還.toEntity());
    }
}
