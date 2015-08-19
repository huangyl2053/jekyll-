/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanJuryoininMeisai;
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3037ShokanJuryoininMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3037ShokanJuryoininMeisaiDac;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払支給受領委任払明細を管理するクラスです。
 */
public class ShokanJuryoininMeisaiManager {

    private final DbT3037ShokanJuryoininMeisaiDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanJuryoininMeisaiManager() {
        dac = InstanceProvider.create(DbT3037ShokanJuryoininMeisaiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3037ShokanJuryoininMeisaiDac}
     */
    ShokanJuryoininMeisaiManager(DbT3037ShokanJuryoininMeisaiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払支給受領委任払明細を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @param 履歴番号 RirekiNo
     * @return ShokanJuryoininMeisai
     */
    @Transaction
    public ShokanJuryoininMeisai get償還払支給受領委任払明細(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3037ShokanJuryoininMeisaiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanJuryoininMeisai(entity);
    }

    /**
     * 償還払支給受領委任払明細を全件返します。
     *
     * @return List<ShokanJuryoininMeisai>
     */
    @Transaction
    public List<ShokanJuryoininMeisai> get償還払支給受領委任払明細一覧() {
        List<ShokanJuryoininMeisai> businessList = new ArrayList<>();

        for (DbT3037ShokanJuryoininMeisaiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanJuryoininMeisai(entity));
        }

        return businessList;
    }

    /**
     * 償還払支給受領委任払明細{@link ShokanJuryoininMeisai}を保存します。
     *
     * @param 償還払支給受領委任払明細 {@link ShokanJuryoininMeisai}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払支給受領委任払明細(ShokanJuryoininMeisai 償還払支給受領委任払明細) {
        requireNonNull(償還払支給受領委任払明細, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給受領委任払明細"));
        if (!償還払支給受領委任払明細.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払支給受領委任払明細.toEntity());
    }
}
