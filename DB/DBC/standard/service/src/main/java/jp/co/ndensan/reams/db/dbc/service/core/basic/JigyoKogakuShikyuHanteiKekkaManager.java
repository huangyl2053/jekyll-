/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JigyoKogakuShikyuHanteiKekka;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 事業高額介護サービス費支給判定結果を管理するクラスです。
 */
public class JigyoKogakuShikyuHanteiKekkaManager {

    private final DbT3111JigyoKogakuShikyuHanteiKekkaDac dac;

    /**
     * コンストラクタです。
     */
    public JigyoKogakuShikyuHanteiKekkaManager() {
        dac = InstanceProvider.create(DbT3111JigyoKogakuShikyuHanteiKekkaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3111JigyoKogakuShikyuHanteiKekkaDac}
     */
    JigyoKogakuShikyuHanteiKekkaManager(DbT3111JigyoKogakuShikyuHanteiKekkaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する事業高額介護サービス費支給判定結果を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return JigyoKogakuShikyuHanteiKekka
     */
    @Transaction
    public JigyoKogakuShikyuHanteiKekka get事業高額介護サービス費支給判定結果(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            HokenshaNo 証記載保険者番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                証記載保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JigyoKogakuShikyuHanteiKekka(entity);
    }

    /**
     * 事業高額介護サービス費支給判定結果を全件返します。
     *
     * @return List<JigyoKogakuShikyuHanteiKekka>
     */
    @Transaction
    public List<JigyoKogakuShikyuHanteiKekka> get事業高額介護サービス費支給判定結果一覧() {
        List<JigyoKogakuShikyuHanteiKekka> businessList = new ArrayList<>();

        for (DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JigyoKogakuShikyuHanteiKekka(entity));
        }

        return businessList;
    }

    /**
     * 主キーに合致する事業高額介護サービス費支給判定結果を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 履歴番号 RirekiNo
     * @return List<JigyoKogakuShikyuHanteiKekka>
     */
    @Transaction
    public List<JigyoKogakuShikyuHanteiKekka> getサービス費支給判定結果(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        List<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> entityList = dac.selectサービス費支給判定結果ByKey(
                被保険者番号,
                サービス提供年月,
                履歴番号);
        List<JigyoKogakuShikyuHanteiKekka> businessList = new ArrayList<>();
        for (DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity : entityList) {
            entity.initializeMd5();
            businessList.add(new JigyoKogakuShikyuHanteiKekka(entity));
        }

        return businessList;
    }

    /**
     * 事業高額介護サービス費支給判定結果{@link JigyoKogakuShikyuHanteiKekka}を保存します。
     *
     * @param 事業高額介護サービス費支給判定結果 {@link JigyoKogakuShikyuHanteiKekka}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save事業高額介護サービス費支給判定結果(JigyoKogakuShikyuHanteiKekka 事業高額介護サービス費支給判定結果) {
        requireNonNull(事業高額介護サービス費支給判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費支給判定結果"));
        if (!事業高額介護サービス費支給判定結果.hasChanged()) {
            return false;
        }
        return 1 == dac.save(事業高額介護サービス費支給判定結果.toEntity());
    }

    /**
     * 被保険者番号よりサービス提供年月リストを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return サービス提供年月リスト List<FlexibleYearMonth>
     */
    public List<FlexibleYearMonth> getサービス提供年月リスト(HihokenshaNo 被保険者番号) {
        List<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> サービス費支給判定結果リスト = dac.selectサービス提供年月Bykey(被保険者番号);
        List<FlexibleYearMonth> サービス提供年月 = new ArrayList<>();
        for (DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity : サービス費支給判定結果リスト) {
            サービス提供年月.add(entity.getServiceTeikyoYM());
        }
        return サービス提供年月;
    }

    /**
     * 被保険者番号とサービス提供年月より管理番号リストを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @return サービス提供年月リスト List<Decimal>
     */
    public List<Decimal> get管理番号リスト(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月) {
        List<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> 管理番号リスト = dac.select管理番号Bykey(被保険者番号, サービス提供年月);
        List<Decimal> 管理番号 = new ArrayList<>();
        for (DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity : 管理番号リスト) {
            管理番号.add(entity.getRirekiNo());
        }
        return 管理番号;
    }

    /**
     * 被保険者番号とサービス提供年月より前回発行日リストを取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param サービス提供年月 FlexibleYearMonth
     * @param 管理番号 Decimal
     * @return サービス提供年月リスト List<Decimal>
     */
    public List<FlexibleDate> get前回発行日リスト(HihokenshaNo 被保険者番号, FlexibleYearMonth サービス提供年月, Decimal 管理番号) {
        List<DbT3111JigyoKogakuShikyuHanteiKekkaEntity> 管理番号リスト = dac.select前回発行日Bykey(被保険者番号, サービス提供年月, 管理番号);
        List<FlexibleDate> 前回発行日 = new ArrayList<>();
        for (DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity : 管理番号リスト) {
            前回発行日.add(entity.getKetteiTsuchishoSakuseiYMD());
        }
        return 前回発行日;
    }

    /**
     * 事業高額介護サービス費支給判定結果{@link JigyoKogakuShikyuHanteiKekka}を保存します。
     *
     * @param 事業高額介護サービス費支給判定結果 {@link JigyoKogakuShikyuHanteiKekka}
     */
    @Transaction
    public void update事業高額介護サービス費支給判定結果(JigyoKogakuShikyuHanteiKekka 事業高額介護サービス費支給判定結果) {
        requireNonNull(事業高額介護サービス費支給判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("事業高額介護サービス費支給判定結果"));
        DbT3111JigyoKogakuShikyuHanteiKekkaEntity entity = 事業高額介護サービス費支給判定結果.toEntity();
        entity.setState(EntityDataState.Modified);
        dac.save(entity);
    }
}
