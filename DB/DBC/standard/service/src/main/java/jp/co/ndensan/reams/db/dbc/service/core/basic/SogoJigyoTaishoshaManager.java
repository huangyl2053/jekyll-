/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 総合事業対象者を管理するクラスです。
 *
 * @reamsid_L DBC-4800-010 huzongcheng
 */
public class SogoJigyoTaishoshaManager {

    private final DbT3105SogoJigyoTaishoshaDac dac;

    /**
     * コンストラクタです。
     */
    public SogoJigyoTaishoshaManager() {
        dac = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3105SogoJigyoTaishoshaDac}
     */
    SogoJigyoTaishoshaManager(DbT3105SogoJigyoTaishoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する総合事業対象者を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return SogoJigyoTaishosha
     */
    @Transaction
    public SogoJigyoTaishosha get総合事業対象者(
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3105SogoJigyoTaishoshaEntity entity = dac.selectByKey(
                被保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new SogoJigyoTaishosha(entity);
    }

    /**
     * 総合事業対象者を全件返します。
     *
     * @return List<SogoJigyoTaishosha>
     */
    @Transaction
    public List<SogoJigyoTaishosha> get総合事業対象者一覧() {
        List<SogoJigyoTaishosha> businessList = new ArrayList<>();

        for (DbT3105SogoJigyoTaishoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new SogoJigyoTaishosha(entity));
        }

        return businessList;
    }

    /**
     * 被保険者番号より事業対象者を取得します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<SogoJigyoTaishosha>
     */
    @Transaction
    public List<SogoJigyoTaishosha> get総合事業対象者情報(HihokenshaNo 被保険者番号) {
        List<SogoJigyoTaishosha> businessList = new ArrayList<>();

        for (DbT3105SogoJigyoTaishoshaEntity entity : dac.selectBy被保険者番号(被保険者番号)) {
            entity.initializeMd5();
            businessList.add(new SogoJigyoTaishosha(entity));
        }

        return businessList;
    }

    /**
     * 総合事業対象者{@link SogoJigyoTaishosha}を保存します。
     *
     * @param 総合事業対象者 {@link SogoJigyoTaishosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save総合事業対象者(SogoJigyoTaishosha 総合事業対象者) {
        requireNonNull(総合事業対象者, UrSystemErrorMessages.値がnull.getReplacedMessage("総合事業対象者"));
        if (!総合事業対象者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(総合事業対象者.toEntity());
    }

    /**
     * 総合事業対象者を全件返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @return List<SogoJigyoTaishosha>
     */
    @Transaction
    public List<SogoJigyoTaishosha> get総合事業対象者(
            HihokenshaNo 被保険者番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        List<SogoJigyoTaishosha> businessList = new ArrayList<>();
        for (DbT3105SogoJigyoTaishoshaEntity entity : dac.get総合事業対象者(被保険者番号)) {
            entity.initializeMd5();
            businessList.add(new SogoJigyoTaishosha(entity));
        }
        return businessList;
    }
}
