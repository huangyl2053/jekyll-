/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanKihon;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3038ShokanKihonEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3038ShokanKihonDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求基本を管理するクラスです。
 *
 * @reamsid_L DBC-9999-012 panhe
 */
public class ShokanKihonManager {

    private final DbT3038ShokanKihonDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanKihonManager() {
        dac = InstanceProvider.create(DbT3038ShokanKihonDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3038ShokanKihonDac}
     */
    ShokanKihonManager(DbT3038ShokanKihonDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払請求基本を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNp
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 明細番号 RirekiNo
     * @return ShokanKihon
     */
    @Transaction
    public ShokanKihon get償還払請求基本(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 明細番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(明細番号, UrSystemErrorMessages.値がnull.getReplacedMessage("明細番号"));

        DbT3038ShokanKihonEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                明細番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanKihon(entity);
    }

    /**
     * 償還払請求基本を全件返します。
     *
     * @return List<ShokanKihon>
     */
    @Transaction
    public List<ShokanKihon> get償還払請求基本一覧() {
        List<ShokanKihon> businessList = new ArrayList<>();

        for (DbT3038ShokanKihonEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanKihon(entity));
        }

        return businessList;
    }

    /**
     * 償還払請求基本{@link ShokanKihon}を保存します。
     *
     * @param 償還払請求基本 {@link ShokanKihon}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払請求基本(ShokanKihon 償還払請求基本) {
        requireNonNull(償還払請求基本, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求基本"));
        if (!償還払請求基本.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払請求基本.toEntity());
    }
}
