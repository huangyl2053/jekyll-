/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuShikyuShinsaKettei;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3112KogakuShikyuShinsaKetteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3112KogakuShikyuShinsaKetteiDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額介護サービス費支給審査決定を管理するクラスです。
 */
public class KogakuShikyuShinsaKetteiManager {

    private final DbT3112KogakuShikyuShinsaKetteiDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuShikyuShinsaKetteiManager() {
        dac = InstanceProvider.create(DbT3112KogakuShikyuShinsaKetteiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3112KogakuShikyuShinsaKetteiDac}
     */
    KogakuShikyuShinsaKetteiManager(DbT3112KogakuShikyuShinsaKetteiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する事業高額介護サービス費支給審査決定を返します。
     *
     * @param 決定者受取年月 KetteishaUketoriYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 通知書番号 TsuchishoNo
     * @return KogakuShikyuShinsaKettei
     */
    @Transaction
    public KogakuShikyuShinsaKettei get事業高額介護サービス費支給審査決定(
            FlexibleYearMonth 決定者受取年月,
            HokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 通知書番号) {
        requireNonNull(決定者受取年月, UrSystemErrorMessages.値がnull.getReplacedMessage("決定者受取年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(通知書番号, UrSystemErrorMessages.値がnull.getReplacedMessage("通知書番号"));

        DbT3112KogakuShikyuShinsaKetteiEntity entity = dac.selectByKey(
                決定者受取年月,
                証記載保険者番号,
                被保険者番号,
                サービス提供年月,
                通知書番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuShikyuShinsaKettei(entity);
    }

    /**
     * 事業高額介護サービス費支給審査決定を全件返します。
     *
     * @return List<KogakuShikyuShinsaKettei>
     */
    @Transaction
    public List<KogakuShikyuShinsaKettei> get事業高額介護サービス費支給審査決定一覧() {
        List<KogakuShikyuShinsaKettei> businessList = new ArrayList<>();

        for (DbT3112KogakuShikyuShinsaKetteiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuShikyuShinsaKettei(entity));
        }

        return businessList;
    }

    /**
     * 事業高額介護サービス費支給審査決定{@link KogakuShikyuShinsaKettei}を保存します。
     *
     * @param 事業高額介護サービス費支給審査決定 {@link KogakuShikyuShinsaKettei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save事業高額介護サービス費支給審査決定(KogakuShikyuShinsaKettei 事業高額介護サービス費支給審査決定) {
        requireNonNull(事業高額介護サービス費支給審査決定, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費支給審査決定"));
        if (!事業高額介護サービス費支給審査決定.hasChanged()) {
            return false;
        }
        return 1 == dac.save(事業高額介護サービス費支給審査決定.toEntity());
    }
}
