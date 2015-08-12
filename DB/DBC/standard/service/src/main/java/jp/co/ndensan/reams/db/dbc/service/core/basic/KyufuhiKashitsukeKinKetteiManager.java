/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KyufuhiKashitsukeKinKettei;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3087KyufuhiKashitsukeKinKetteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3087KyufuhiKashitsukeKinKetteiDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 給付費貸付金決定を管理するクラスです。
 */
public class KyufuhiKashitsukeKinKetteiManager {

    private final DbT3087KyufuhiKashitsukeKinKetteiDac dac;

    /**
     * コンストラクタです。
     */
    public KyufuhiKashitsukeKinKetteiManager() {
        dac = InstanceProvider.create(DbT3087KyufuhiKashitsukeKinKetteiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3087KyufuhiKashitsukeKinKetteiDac}
     */
    KyufuhiKashitsukeKinKetteiManager(DbT3087KyufuhiKashitsukeKinKetteiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する給付費貸付金決定を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 借入申請年月日 KariireShinseiYMD
     * @param 履歴番号 RirekiNo
     * @return KyufuhiKashitsukeKinKettei
     */
    @Transaction
    public KyufuhiKashitsukeKinKettei get給付費貸付金決定(
            HihokenshaNo 被保険者番号,
            FlexibleDate 借入申請年月日,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(借入申請年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("借入申請年月日"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3087KyufuhiKashitsukeKinKetteiEntity entity = dac.selectByKey(
                被保険者番号,
                借入申請年月日,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyufuhiKashitsukeKinKettei(entity);
    }

    /**
     * 給付費貸付金決定を全件返します。
     *
     * @return List<KyufuhiKashitsukeKinKettei>
     */
    @Transaction
    public List<KyufuhiKashitsukeKinKettei> get給付費貸付金決定一覧() {
        List<KyufuhiKashitsukeKinKettei> businessList = new ArrayList<>();

        for (DbT3087KyufuhiKashitsukeKinKetteiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyufuhiKashitsukeKinKettei(entity));
        }

        return businessList;
    }

    /**
     * 給付費貸付金決定{@link KyufuhiKashitsukeKinKettei}を保存します。
     *
     * @param 給付費貸付金決定 {@link KyufuhiKashitsukeKinKettei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save給付費貸付金決定(KyufuhiKashitsukeKinKettei 給付費貸付金決定) {
        requireNonNull(給付費貸付金決定, UrSystemErrorMessages.値がnull.getReplacedMessage("給付費貸付金決定"));
        if (!給付費貸付金決定.hasChanged()) {
            return false;
        }
        return 1 == dac.save(給付費貸付金決定.toEntity());
    }
}
