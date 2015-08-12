/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KagoKetteiMeisai;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3061KagoKetteiMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3061KagoKetteiMeisaiDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 過誤決定明細を管理するクラスです。
 */
public class KagoKetteiMeisaiManager {

    private final DbT3061KagoKetteiMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public KagoKetteiMeisaiManager() {
        dac = InstanceProvider.create(DbT3061KagoKetteiMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3061KagoKetteiMeisaiDac}
     */
    KagoKetteiMeisaiManager(DbT3061KagoKetteiMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する過誤決定明細を返します。
     *
     * @param 取扱年月 ToriatsukaiYM
     * @param 保険者区分 HokenshaKubun
     * @param 履歴番号 RirekiNo
     * @return KagoKetteiMeisai
     */
    @Transaction
    public KagoKetteiMeisai get過誤決定明細(
            FlexibleYearMonth 取扱年月,
            RString 保険者区分,
            Decimal 履歴番号) {
        requireNonNull(取扱年月, UrSystemErrorMessages.値がnull.getReplacedMessage("取扱年月"));
        requireNonNull(保険者区分, UrSystemErrorMessages.値がnull.getReplacedMessage("保険者区分"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3061KagoKetteiMeisaiEntity entity = dac.selectByKey(
                取扱年月,
                保険者区分,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KagoKetteiMeisai(entity);
    }

    /**
     * 過誤決定明細を全件返します。
     *
     * @return List<KagoKetteiMeisai>
     */
    @Transaction
    public List<KagoKetteiMeisai> get過誤決定明細一覧() {
        List<KagoKetteiMeisai> businessList = new ArrayList<>();

        for (DbT3061KagoKetteiMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KagoKetteiMeisai(entity));
        }

        return businessList;
    }

    /**
     * 過誤決定明細{@link KagoKetteiMeisai}を保存します。
     *
     * @param 過誤決定明細 {@link KagoKetteiMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save過誤決定明細(KagoKetteiMeisai 過誤決定明細) {
        requireNonNull(過誤決定明細, UrSystemErrorMessages.値がnull.getReplacedMessage("過誤決定明細"));
        if (!過誤決定明細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(過誤決定明細.toEntity());
    }
}
