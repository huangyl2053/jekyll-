/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoGaitosha;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1006KyokaisoGaitoshaEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1006KyokaisoGaitoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層該当者を管理するクラスです。
 */
public class KyokaisoGaitoshaManager {

    private final DbT1006KyokaisoGaitoshaDac dac;

    /**
     * コンストラクタです。
     */
    public KyokaisoGaitoshaManager() {
        dac = InstanceProvider.create(DbT1006KyokaisoGaitoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1006KyokaisoGaitoshaDac}
     */
    KyokaisoGaitoshaManager(DbT1006KyokaisoGaitoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する境界層該当者を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return KyokaisoGaitosha
     */
    @Transaction
    public KyokaisoGaitosha get境界層該当者(
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT1006KyokaisoGaitoshaEntity entity = dac.selectByKey(
                被保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyokaisoGaitosha(entity);
    }

    /**
     * 境界層該当者を全件返します。
     *
     * @return List<KyokaisoGaitosha>
     */
    @Transaction
    public List<KyokaisoGaitosha> get境界層該当者一覧() {
        List<KyokaisoGaitosha> businessList = new ArrayList<>();

        for (DbT1006KyokaisoGaitoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyokaisoGaitosha(entity));
        }

        return businessList;
    }

    /**
     * 境界層該当者{@link KyokaisoGaitosha}を保存します。
     *
     * @param 境界層該当者 {@link KyokaisoGaitosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save境界層該当者(KyokaisoGaitosha 境界層該当者) {
        requireNonNull(境界層該当者, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層該当者"));
        if (!境界層該当者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(境界層該当者.toEntity());
    }
}
