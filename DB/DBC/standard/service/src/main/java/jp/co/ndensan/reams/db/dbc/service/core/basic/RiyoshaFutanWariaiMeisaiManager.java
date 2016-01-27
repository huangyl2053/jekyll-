/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.RiyoshaFutanWariaiMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3114RiyoshaFutanWariaiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3114RiyoshaFutanWariaiMeisaiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 利用者負担割合明細を管理するクラスです。
 */
public class RiyoshaFutanWariaiMeisaiManager {

    private final DbT3114RiyoshaFutanWariaiMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public RiyoshaFutanWariaiMeisaiManager() {
        dac = InstanceProvider.create(DbT3114RiyoshaFutanWariaiMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3114RiyoshaFutanWariaiMeisaiDac}
     */
    RiyoshaFutanWariaiMeisaiManager(DbT3114RiyoshaFutanWariaiMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する利用者負担割合明細を返します。
     *
     * @param 年度 Nendo
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @param 枝番号 EdaNo
     * @return RiyoshaFutanWariaiMeisai
     */
    @Transaction
    public RiyoshaFutanWariaiMeisai get利用者負担割合明細(
            FlexibleYear 年度,
            HihokenshaNo 被保険者番号,
            int 履歴番号,
            int 枝番号) {
        requireNonNull(年度, UrSystemErrorMessages.値がnull.getReplacedMessage("年度"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));
        requireNonNull(枝番号, UrSystemErrorMessages.値がnull.getReplacedMessage("枝番号"));

        DbT3114RiyoshaFutanWariaiMeisaiEntity entity = dac.selectByKey(
                年度,
                被保険者番号,
                履歴番号,
                枝番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new RiyoshaFutanWariaiMeisai(entity);
    }

    /**
     * 利用者負担割合明細を全件返します。
     *
     * @return List<RiyoshaFutanWariaiMeisai>
     */
    @Transaction
    public List<RiyoshaFutanWariaiMeisai> get利用者負担割合明細一覧() {
        List<RiyoshaFutanWariaiMeisai> businessList = new ArrayList<>();

        for (DbT3114RiyoshaFutanWariaiMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new RiyoshaFutanWariaiMeisai(entity));
        }

        return businessList;
    }

    /**
     * 利用者負担割合明細{@link RiyoshaFutanWariaiMeisai}を保存します。
     *
     * @param 利用者負担割合明細 {@link RiyoshaFutanWariaiMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save利用者負担割合明細(RiyoshaFutanWariaiMeisai 利用者負担割合明細) {
        requireNonNull(利用者負担割合明細, UrSystemErrorMessages.値がnull.getReplacedMessage("利用者負担割合明細"));
        if (!利用者負担割合明細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(利用者負担割合明細.toEntity());
    }
}
