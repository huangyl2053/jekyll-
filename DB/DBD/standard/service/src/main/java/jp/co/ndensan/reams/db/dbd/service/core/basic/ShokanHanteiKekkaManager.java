/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbd.business.core.basic.ShokanHanteiKekka;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3036ShokanHanteiKekkaEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3036ShokanHanteiKekkaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 償還払支給判定結果を管理するクラスです。
 */
public class ShokanHanteiKekkaManager {

    private final DbT3036ShokanHanteiKekkaDac dac;

    /**
     * コンストラクタです。
     */
    public ShokanHanteiKekkaManager() {
        dac = InstanceProvider.create(DbT3036ShokanHanteiKekkaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3036ShokanHanteiKekkaDac}
     */
    ShokanHanteiKekkaManager(DbT3036ShokanHanteiKekkaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する償還払支給判定結果を返します。
     *
     * @param 被保険者番号 HiHokenshaNo
     * @param サービス提供年月 ServiceTeikyoYM
     * @param 整理番号 SeiriNo
     * @return ShokanHanteiKekka
     */
    @Transaction
    public ShokanHanteiKekka get償還払支給判定結果(
            HihokenshaNo 被保険者番号,
            FlexibleYearMonth サービス提供年月,
            RString 整理番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(サービス提供年月, UrSystemErrorMessages.値がnull.getReplacedMessage("サービス提供年月"));
        requireNonNull(整理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("整理番号"));

        DbT3036ShokanHanteiKekkaEntity entity = dac.selectByKey(
                被保険者番号,
                サービス提供年月,
                整理番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShokanHanteiKekka(entity);
    }

    /**
     * 償還払支給判定結果を全件返します。
     *
     * @return List<ShokanHanteiKekka>
     */
    @Transaction
    public List<ShokanHanteiKekka> get償還払支給判定結果一覧() {
        List<ShokanHanteiKekka> businessList = new ArrayList<>();

        for (DbT3036ShokanHanteiKekkaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShokanHanteiKekka(entity));
        }

        return businessList;
    }

    /**
     * 償還払支給判定結果{@link ShokanHanteiKekka}を保存します。
     *
     * @param 償還払支給判定結果 {@link ShokanHanteiKekka}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save償還払支給判定結果(ShokanHanteiKekka 償還払支給判定結果) {
        requireNonNull(償還払支給判定結果, UrSystemErrorMessages.値がnull.getReplacedMessage("償還払支給判定結果"));
        if (!償還払支給判定結果.hasChanged()) {
            return false;
        }
        return 1 == dac.save(償還払支給判定結果.toEntity());
    }
}
