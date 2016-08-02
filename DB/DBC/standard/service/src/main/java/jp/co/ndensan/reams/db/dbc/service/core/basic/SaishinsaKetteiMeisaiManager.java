/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SaishinsaKetteiMeisai;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3064SaishinsaKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3064SaishinsaKetteiMeisaiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 再審査決定明細を管理するクラスです。
 */
public class SaishinsaKetteiMeisaiManager {

    private final DbT3064SaishinsaKetteiMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public SaishinsaKetteiMeisaiManager() {
        dac = InstanceProvider.create(DbT3064SaishinsaKetteiMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3064SaishinsaKetteiMeisaiDac}
     */
    SaishinsaKetteiMeisaiManager(DbT3064SaishinsaKetteiMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する再審査決定明細を返します。
     *
     * @param 取扱年月 ToriatsukaiYM
     * @param 保険者区分 HokenshaKubun
     * @param 履歴番号 RirekiNo
     * @return SaishinsaKetteiMeisai
     */
    @Transaction
    public SaishinsaKetteiMeisai get再審査決定明細(
            FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            Decimal 履歴番号) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3064SaishinsaKetteiMeisaiEntity entity = dac.selectByKey(
                取扱年月,
                保険者区分,
                履歴番号.intValue());
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new SaishinsaKetteiMeisai(entity);
    }

    /**
     * 再審査決定明細を全件返します。
     *
     * @return List<SaishinsaKetteiMeisai>
     */
    @Transaction
    public List<SaishinsaKetteiMeisai> get再審査決定明細一覧() {
        List<SaishinsaKetteiMeisai> businessList = new ArrayList<>();

        for (DbT3064SaishinsaKetteiMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new SaishinsaKetteiMeisai(entity));
        }

        return businessList;
    }

    /**
     * 再審査決定明細{@link SaishinsaKetteiMeisai}を保存します。
     *
     * @param 再審査決定明細 {@link SaishinsaKetteiMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save再審査決定明細(SaishinsaKetteiMeisai 再審査決定明細) {
        requireNonNull(再審査決定明細, UrSystemErrorMessages.値がnull.getReplacedMessage("再審査決定明細"));
        if (!再審査決定明細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(再審査決定明細.toEntity());
    }
}
