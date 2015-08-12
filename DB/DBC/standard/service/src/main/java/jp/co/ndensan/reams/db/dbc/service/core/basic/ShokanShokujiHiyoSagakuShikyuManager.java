/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanShokujiHiyoSagakuShikyu;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3044ShokanShokujiHiyoSagakuShikyuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3044ShokanShokujiHiyoSagakuShikyuDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求食事費用差額支給を管理するクラスです。
 */
public class ShokanShokujiHiyoSagakuShikyuManager {

    private final DbT3044ShokanShokujiHiyoSagakuShikyuDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanShokujiHiyoSagakuShikyuManager() {
        dac = InstanceProvider.create(DbT3044ShokanShokujiHiyoSagakuShikyuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3044ShokanShokujiHiyoSagakuShikyuDac}
     */
    ShokanShokujiHiyoSagakuShikyuManager(DbT3044ShokanShokujiHiyoSagakuShikyuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払請求食事費用差額支給を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNp
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 履歴番号 RirekiNo
     * @return ShokanShokujiHiyoSagakuShikyu
     */
    @Transaction
    public ShokanShokujiHiyoSagakuShikyu get償還払請求食事費用差額支給(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanShokujiHiyoSagakuShikyu(entity);
    }

    /**
     * 償還払請求食事費用差額支給を全件返します。
     *
     * @return List<ShokanShokujiHiyoSagakuShikyu>
     */
    @Transaction
    public List<ShokanShokujiHiyoSagakuShikyu> get償還払請求食事費用差額支給一覧() {
        List<ShokanShokujiHiyoSagakuShikyu> businessList = new ArrayList<>();

        for (DbT3044ShokanShokujiHiyoSagakuShikyuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanShokujiHiyoSagakuShikyu(entity));
        }

        return businessList;
    }

    /**
     * 償還払請求食事費用差額支給{@link ShokanShokujiHiyoSagakuShikyu}を保存します。
     *
     * @param 償還払請求食事費用差額支給 {@link ShokanShokujiHiyoSagakuShikyu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払請求食事費用差額支給(ShokanShokujiHiyoSagakuShikyu 償還払請求食事費用差額支給) {
        requireNonNull(償還払請求食事費用差額支給, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求食事費用差額支給"));
        if (!償還払請求食事費用差額支給.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払請求食事費用差額支給.toEntity());
    }
}
