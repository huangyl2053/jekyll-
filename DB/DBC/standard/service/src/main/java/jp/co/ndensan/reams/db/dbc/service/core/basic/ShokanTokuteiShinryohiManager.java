/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShokanTokuteiShinryohi;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei.DbT3041ShokanTokuteiShinryohiEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3041ShokanTokuteiShinryohiDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払請求特定診療費を管理するクラスです。
 */
public class ShokanTokuteiShinryohiManager {

    private final DbT3041ShokanTokuteiShinryohiDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanTokuteiShinryohiManager() {
        dac = InstanceProvider.create(DbT3041ShokanTokuteiShinryohiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3041ShokanTokuteiShinryohiDac}
     */
    ShokanTokuteiShinryohiManager(DbT3041ShokanTokuteiShinryohiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払請求特定診療費を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @param 事業者番号 JigyoshaNo
     * @param 様式番号 YoshikiNo
     * @param 順次番号 JunjiNo
     * @param 履歴番号 RirekiNo
     * @return ShokanTokuteiShinryohi
     */
    @Transaction
    public ShokanTokuteiShinryohi get償還払請求特定診療費(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号,
            JigyoshaNo 事業者番号,
            RString 様式番号,
            RString 順次番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));
        requireNonNull(事業者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("事業者番号"));
        requireNonNull(様式番号, UrSystemErrorMessages.値がnull.getReplacedMessage("様式番号"));
        requireNonNull(順次番号, UrSystemErrorMessages.値がnull.getReplacedMessage("順次番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3041ShokanTokuteiShinryohiEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号,
                事業者番号,
                様式番号,
                順次番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanTokuteiShinryohi(entity);
    }

    /**
     * 償還払請求特定診療費を全件返します。
     *
     * @return List<ShokanTokuteiShinryohi>
     */
    @Transaction
    public List<ShokanTokuteiShinryohi> get償還払請求特定診療費一覧() {
        List<ShokanTokuteiShinryohi> businessList = new ArrayList<>();

        for (DbT3041ShokanTokuteiShinryohiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanTokuteiShinryohi(entity));
        }

        return businessList;
    }

    /**
     * 償還払請求特定診療費{@link ShokanTokuteiShinryohi}を保存します。
     *
     * @param 償還払請求特定診療費 {@link ShokanTokuteiShinryohi}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払請求特定診療費(ShokanTokuteiShinryohi 償還払請求特定診療費) {
        requireNonNull(償還払請求特定診療費, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払請求特定診療費"));
        if (!償還払請求特定診療費.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払請求特定診療費.toEntity());
    }
}
