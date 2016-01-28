/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyotakukeika.yobokeikakujikosakuseitankiriyonissu;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.kyotakukeika.yobokeikakujikosakuseitankiriyonissu.YoboKeikakuJikoSakuseiTankiRiyoNissu;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 予防給付計画自己作成短期利用日数を管理するクラスです。
 */
public class YoboKeikakuJikoSakuseiTankiRiyoNissuManager {
    
    private final DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac dac;

    /**
     * コンストラクタです。
     */
    public YoboKeikakuJikoSakuseiTankiRiyoNissuManager() {
        dac = InstanceProvider.create(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac}
     */
    YoboKeikakuJikoSakuseiTankiRiyoNissuManager(DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する予防給付計画自己作成短期利用日数を返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 対象年月 対象年月
     * @param 履歴番号 履歴番号
     * @return YoboKeikakuJikoSakuseiTankiRiyoNissu
     */
    @Transaction
    public YoboKeikakuJikoSakuseiTankiRiyoNissu get予防給付計画自己作成短期利用日数(
             HihokenshaNo 被保険者番号,
            FlexibleYearMonth 対象年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("対象年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity = dac.selectByKey(
                被保険者番号,
                対象年月,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new YoboKeikakuJikoSakuseiTankiRiyoNissu(entity);
    }

    /**
     * 予防給付計画自己作成短期利用日数を全件返します。
     *
     * @return YoboKeikakuJikoSakuseiTankiRiyoNissuの{@code list}
     */
    @Transaction
    public List<YoboKeikakuJikoSakuseiTankiRiyoNissu> get予防給付計画自己作成短期利用日数一覧() {
        List<YoboKeikakuJikoSakuseiTankiRiyoNissu> businessList = new ArrayList<>();

        for (DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new YoboKeikakuJikoSakuseiTankiRiyoNissu(entity));
        }

        return businessList;
    }

    /**
     * 予防給付計画自己作成短期利用日数{@link YoboKeikakuJikoSakuseiTankiRiyoNissu}を保存します。
     *
     * @param 予防給付計画自己作成短期利用日数 {@link YoboKeikakuJikoSakuseiTankiRiyoNissu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save予防給付計画自己作成短期利用日数(YoboKeikakuJikoSakuseiTankiRiyoNissu 予防給付計画自己作成短期利用日数) {
        requireNonNull(予防給付計画自己作成短期利用日数, UrSystemErrorMessages.値がnull.getReplacedMessage("予防給付計画自己作成短期利用日数"));
        if (!予防給付計画自己作成短期利用日数.hasChanged()) {
            return false;
        }
        return 1 == dac.save(予防給付計画自己作成短期利用日数.toEntity());
    }
}
