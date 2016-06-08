/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KagoKetteiShukei;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3060KagoKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3060KagoKetteiShukeiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 過誤決定集計を管理するクラスです。
 */
public class KagoKetteiShukeiManager {

    private final DbT3060KagoKetteiShukeiDac dac;

    /**
     * コンストラクタです。
     */
    public KagoKetteiShukeiManager() {
        dac = InstanceProvider.create(DbT3060KagoKetteiShukeiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3060KagoKetteiShukeiDac}
     */
    KagoKetteiShukeiManager(DbT3060KagoKetteiShukeiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する過誤決定集計を返します。
     *
     * @param 取扱年月 ToriatsukaiYM
     * @param 保険者区分 HokenshaKubun
     * @param 履歴番号 RirekiNo
     * @return KagoKetteiShukei
     */
    @Transaction
    public KagoKetteiShukei get過誤決定集計(
            FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            Decimal 履歴番号) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3060KagoKetteiShukeiEntity entity = dac.selectByKey(
                取扱年月,
                保険者区分,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KagoKetteiShukei(entity);
    }

    /**
     * 過誤決定集計を全件返します。
     *
     * @return List<KagoKetteiShukei>
     */
    @Transaction
    public List<KagoKetteiShukei> get過誤決定集計一覧() {
        List<KagoKetteiShukei> businessList = new ArrayList<>();

        for (DbT3060KagoKetteiShukeiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KagoKetteiShukei(entity));
        }

        return businessList;
    }

    /**
     * 過誤決定集計{@link KagoKetteiShukei}を保存します。
     *
     * @param 過誤決定集計 {@link KagoKetteiShukei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save過誤決定集計(KagoKetteiShukei 過誤決定集計) {
        requireNonNull(過誤決定集計, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤決定集計"));
        if (!過誤決定集計.hasChanged()) {
            return false;
        }
        return 1 == dac.save(過誤決定集計.toEntity());
    }
}
