/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuGassanShikyuFushikyuKettei;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3074KogakuGassanShikyuFushikyuKetteiDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額合算支給不支給決定を管理するクラスです。
 */
public class KogakuGassanShikyuFushikyuKetteiManager {

    private final DbT3074KogakuGassanShikyuFushikyuKetteiDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuGassanShikyuFushikyuKetteiManager() {
        dac = InstanceProvider.create(DbT3074KogakuGassanShikyuFushikyuKetteiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3074KogakuGassanShikyuFushikyuKetteiDac}
     */
    KogakuGassanShikyuFushikyuKetteiManager(DbT3074KogakuGassanShikyuFushikyuKetteiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額合算支給不支給決定を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 対象年度 TaishoNendo
     * @param 保険者番号 HokenshaNo
     * @param 支給申請書整理番号 ShikyuSeiriNo
     * @param 履歴番号 RirekiNo
     * @return KogakuGassanShikyuFushikyuKettei
     */
    @Transaction
    public KogakuGassanShikyuFushikyuKettei get高額合算支給不支給決定(
            HihokenshaNo 被保険者番号,
            FlexibleYear 対象年度,
            HokenshaNo 保険者番号,
            RString 支給申請書整理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年度, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年度"));
        requireNonNull(保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者番号"));
        requireNonNull(支給申請書整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("支給申請書整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = dac.selectByKey(
                被保険者番号,
                対象年度,
                保険者番号,
                支給申請書整理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuGassanShikyuFushikyuKettei(entity);
    }

    /**
     * 高額合算支給不支給決定を全件返します。
     *
     * @return List<KogakuGassanShikyuFushikyuKettei>
     */
    @Transaction
    public List<KogakuGassanShikyuFushikyuKettei> get高額合算支給不支給決定一覧() {
        List<KogakuGassanShikyuFushikyuKettei> businessList = new ArrayList<>();

        for (DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuGassanShikyuFushikyuKettei(entity));
        }

        return businessList;
    }

    /**
     * 高額合算支給不支給決定{@link KogakuGassanShikyuFushikyuKettei}を保存します。
     *
     * @param 高額合算支給不支給決定 {@link KogakuGassanShikyuFushikyuKettei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額合算支給不支給決定(KogakuGassanShikyuFushikyuKettei 高額合算支給不支給決定) {
        requireNonNull(高額合算支給不支給決定, UrSystemErrorMessages.値がnull.getReplacedMessage("高額合算支給不支給決定"));
        if (!高額合算支給不支給決定.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額合算支給不支給決定.toEntity());
    }
}
