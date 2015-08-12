/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SaishinsaKetteiShukei;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3063SaishinsaKetteiShukeiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3063SaishinsaKetteiShukeiDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 再審査決定集計を管理するクラスです。
 */
public class SaishinsaKetteiShukeiManager {

    private final DbT3063SaishinsaKetteiShukeiDac dac;

    /**
     * コンストラクタです。
     */
    public SaishinsaKetteiShukeiManager() {
        dac = InstanceProvider.create(DbT3063SaishinsaKetteiShukeiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3063SaishinsaKetteiShukeiDac}
     */
    SaishinsaKetteiShukeiManager(DbT3063SaishinsaKetteiShukeiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する再審査決定集計を返します。
     *
     * @param 取扱年月 ToriatsukaiYM
     * @param 保険者区分 HokenshaKubun
     * @param 履歴番号 RirekiNo
     * @return SaishinsaKetteiShukei
     */
    @Transaction
    public SaishinsaKetteiShukei get再審査決定集計(
            FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            Decimal 履歴番号) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3063SaishinsaKetteiShukeiEntity entity = dac.selectByKey(
                取扱年月,
                保険者区分,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new SaishinsaKetteiShukei(entity);
    }

    /**
     * 再審査決定集計を全件返します。
     *
     * @return List<SaishinsaKetteiShukei>
     */
    @Transaction
    public List<SaishinsaKetteiShukei> get再審査決定集計一覧() {
        List<SaishinsaKetteiShukei> businessList = new ArrayList<>();

        for (DbT3063SaishinsaKetteiShukeiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new SaishinsaKetteiShukei(entity));
        }

        return businessList;
    }

    /**
     * 再審査決定集計{@link SaishinsaKetteiShukei}を保存します。
     *
     * @param 再審査決定集計 {@link SaishinsaKetteiShukei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save再審査決定集計(SaishinsaKetteiShukei 再審査決定集計) {
        requireNonNull(再審査決定集計, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査決定集計"));
        if (!再審査決定集計.hasChanged()) {
            return false;
        }
        return 1 == dac.save(再審査決定集計.toEntity());
    }
}
