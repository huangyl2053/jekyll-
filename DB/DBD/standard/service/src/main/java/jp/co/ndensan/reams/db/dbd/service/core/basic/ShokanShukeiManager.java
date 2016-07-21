/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShukei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3053ShokanShukeiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3053ShokanShukeiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求集計を管理するクラスです。
 */
public class ShokanShukeiManager {

    private final DbT3053ShokanShukeiDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanShukeiManager() {
        dac = InstanceProvider.create(DbT3053ShokanShukeiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3053ShokanShukeiDac}
     */
    ShokanShukeiManager(DbT3053ShokanShukeiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払請求集計を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 明細番号 JunjiNo
     * @param 連番 RirekiNo
     * @return ShokanShukei
     */
    @Transaction
    public ShokanShukei get償還払請求集計(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号,
            RString 連番) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));
        requireNonNull(連番, UrSystemErrorMessages.値がnull.getReplacedMessage("連番"));

        DbT3053ShokanShukeiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号,
                連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanShukei(entity);
    }

    /**
     * 償還払請求集計を全件返します。
     *
     * @return List<ShokanShukei>
     */
    @Transaction
    public List<ShokanShukei> get償還払請求集計一覧() {
        List<ShokanShukei> businessList = new ArrayList<>();

        for (DbT3053ShokanShukeiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanShukei(entity));
        }

        return businessList;
    }

    /**
     * 償還払請求集計{@link ShokanShukei}を保存します。
     *
     * @param 償還払請求集計 {@link ShokanShukei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払請求集計(ShokanShukei 償還払請求集計) {
        requireNonNull(償還払請求集計, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求集計"));
        if (!償還払請求集計.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払請求集計.toEntity());
    }
}
