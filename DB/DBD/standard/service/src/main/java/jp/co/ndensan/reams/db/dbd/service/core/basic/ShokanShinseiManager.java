/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanShinsei;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3034ShokanShinseiEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3034ShokanShinseiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払支給申請を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 panhe
 */
public class ShokanShinseiManager {

    private final DbT3034ShokanShinseiDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanShinseiManager() {
        dac = InstanceProvider.create(DbT3034ShokanShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3034ShokanShinseiDac}
     */
    ShokanShinseiManager(DbT3034ShokanShinseiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払支給申請を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @return ShokanShinsei
     */
    @Transaction
    public ShokanShinsei get償還払支給申請(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));

        DbT3034ShokanShinseiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanShinsei(entity);
    }

    /**
     * 償還払支給申請を全件返します。
     *
     * @return List<ShokanShinsei>
     */
    @Transaction
    public List<ShokanShinsei> get償還払支給申請一覧() {
        List<ShokanShinsei> businessList = new ArrayList<>();

        for (DbT3034ShokanShinseiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanShinsei(entity));
        }

        return businessList;
    }

    /**
     * 償還払支給申請{@link ShokanShinsei}を保存します。
     *
     * @param 償還払支給申請 {@link ShokanShinsei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払支給申請(ShokanShinsei 償還払支給申請) {
        requireNonNull(償還払支給申請, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給申請"));
        if (!償還払支給申請.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払支給申請.toEntity());
    }
}
