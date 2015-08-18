/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.KyokaisoSochiShinsei;
import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1013KyokaisoSochiShinseiEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT1013KyokaisoSochiShinseiDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 境界層措置申請を管理するクラスです。
 */
public class KyokaisoSochiShinseiManager {

    private final DbT1013KyokaisoSochiShinseiDac dac;

    /**
     * コンストラクタです。
     */
    public KyokaisoSochiShinseiManager() {
        dac = InstanceProvider.create(DbT1013KyokaisoSochiShinseiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1013KyokaisoSochiShinseiDac}
     */
    KyokaisoSochiShinseiManager(DbT1013KyokaisoSochiShinseiDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する境界層措置申請を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return KyokaisoSochiShinsei
     */
    @Transaction
    public KyokaisoSochiShinsei get境界層措置申請(
            HihokenshaNo 被保険者番号,
            Decimal 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT1013KyokaisoSochiShinseiEntity entity = dac.selectByKey(
                被保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KyokaisoSochiShinsei(entity);
    }

    /**
     * 境界層措置申請を全件返します。
     *
     * @return List<KyokaisoSochiShinsei>
     */
    @Transaction
    public List<KyokaisoSochiShinsei> get境界層措置申請一覧() {
        List<KyokaisoSochiShinsei> businessList = new ArrayList<>();

        for (DbT1013KyokaisoSochiShinseiEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KyokaisoSochiShinsei(entity));
        }

        return businessList;
    }

    /**
     * 境界層措置申請{@link KyokaisoSochiShinsei}を保存します。
     *
     * @param 境界層措置申請 {@link KyokaisoSochiShinsei}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save境界層措置申請(KyokaisoSochiShinsei 境界層措置申請) {
        requireNonNull(境界層措置申請, UrSystemErrorMessages.値がnull.getReplacedMessage("境界層措置申請"));
        if (!境界層措置申請.hasChanged()) {
            return false;
        }
        return 1 == dac.save(境界層措置申請.toEntity());
    }
}
