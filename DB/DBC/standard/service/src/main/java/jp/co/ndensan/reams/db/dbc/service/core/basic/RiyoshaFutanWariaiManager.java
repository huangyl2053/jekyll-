/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3113RiyoshaFutanWariaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担割合を管理するクラスです。
 */
public class RiyoshaFutanWariaiManager {

    private final DbT3113RiyoshaFutanWariaiDac dac;

    /**
     * コンストラクタです。
     */
    public RiyoshaFutanWariaiManager() {
        dac = InstanceProvider.create(DbT3113RiyoshaFutanWariaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3113RiyoshaFutanWariaiDac}
     */
    RiyoshaFutanWariaiManager(DbT3113RiyoshaFutanWariaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する利用者負担割合を返します。
     *
     * @param 年度 Nendo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return RiyoshaFutanWariai
     */
    @Transaction
    public RiyoshaFutanWariai get利用者負担割合(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3113RiyoshaFutanWariaiEntity entity = dac.selectByKey(
                年度,
                被保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RiyoshaFutanWariai(entity);
    }

    /**
     * 利用者負担割合を全件返します。
     *
     * @return List<RiyoshaFutanWariai>
     */
    @Transaction
    public List<RiyoshaFutanWariai> get利用者負担割合一覧() {
        List<RiyoshaFutanWariai> businessList = new ArrayList<>();

        for (DbT3113RiyoshaFutanWariaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new RiyoshaFutanWariai(entity));
        }

        return businessList;
    }

    /**
     * 利用者負担割合{@link RiyoshaFutanWariai}を保存します。
     *
     * @param 利用者負担割合 {@link RiyoshaFutanWariai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save利用者負担割合(RiyoshaFutanWariai 利用者負担割合) {
        requireNonNull(利用者負担割合, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合"));
        if (!利用者負担割合.hasChanged()) {
            return false;
        }
        return 1 == dac.save(利用者負担割合.toEntity());
    }
}
