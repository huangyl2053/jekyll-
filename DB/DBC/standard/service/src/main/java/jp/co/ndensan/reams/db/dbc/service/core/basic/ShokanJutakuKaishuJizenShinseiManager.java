/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJutakuKaishuJizenShinsei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3035ShokanJutakuKaishuJizenShinseiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払支給住宅改修事前申請を管理するクラスです。
 */
public class ShokanJutakuKaishuJizenShinseiManager {

    private final DbT3035ShokanJutakuKaishuJizenShinseiDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanJutakuKaishuJizenShinseiManager() {
        dac = InstanceProvider.create(DbT3035ShokanJutakuKaishuJizenShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3035ShokanJutakuKaishuJizenShinseiDac}
     */
    ShokanJutakuKaishuJizenShinseiManager(DbT3035ShokanJutakuKaishuJizenShinseiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払支給住宅改修事前申請を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @param 履歴番号 RirekiNo
     * @return ShokanJutakuKaishuJizenShinsei
     */
    @Transaction
    public ShokanJutakuKaishuJizenShinsei get償還払支給住宅改修事前申請(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3035ShokanJutakuKaishuJizenShinseiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanJutakuKaishuJizenShinsei(entity);
    }

    /**
     * 償還払支給住宅改修事前申請を全件返します。
     *
     * @return List<ShokanJutakuKaishuJizenShinsei>
     */
    @Transaction
    public List<ShokanJutakuKaishuJizenShinsei> get償還払支給住宅改修事前申請一覧() {
        List<ShokanJutakuKaishuJizenShinsei> businessList = new ArrayList<>();

        for (DbT3035ShokanJutakuKaishuJizenShinseiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanJutakuKaishuJizenShinsei(entity));
        }

        return businessList;
    }

    /**
     * 償還払支給住宅改修事前申請{@link ShokanJutakuKaishuJizenShinsei}を保存します。
     *
     * @param 償還払支給住宅改修事前申請 {@link ShokanJutakuKaishuJizenShinsei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払支給住宅改修事前申請(ShokanJutakuKaishuJizenShinsei 償還払支給住宅改修事前申請) {
        requireNonNull(償還払支給住宅改修事前申請, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給住宅改修事前申請"));
        if (!償還払支給住宅改修事前申請.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払支給住宅改修事前申請.toEntity());
    }
}
