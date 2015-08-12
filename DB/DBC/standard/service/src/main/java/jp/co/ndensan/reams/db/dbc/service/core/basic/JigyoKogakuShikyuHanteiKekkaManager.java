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
import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3111JigyoKogakuShikyuHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3111JigyoKogakuShikyuHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
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
}
