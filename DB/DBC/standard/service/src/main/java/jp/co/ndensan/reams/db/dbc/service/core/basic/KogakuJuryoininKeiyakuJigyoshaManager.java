/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.KogakuJuryoininKeiyakuJigyosha;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3076KogakuJuryoininKeiyakuJigyoshaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 高額受領委任契約事業者を管理するクラスです。
 */
public class KogakuJuryoininKeiyakuJigyoshaManager {

    private final DbT3076KogakuJuryoininKeiyakuJigyoshaDac dac;

    /**
     * コンストラクタです。
     */
    public KogakuJuryoininKeiyakuJigyoshaManager() {
        dac = InstanceProvider.create(DbT3076KogakuJuryoininKeiyakuJigyoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3076KogakuJuryoininKeiyakuJigyoshaDac}
     */
    KogakuJuryoininKeiyakuJigyoshaManager(DbT3076KogakuJuryoininKeiyakuJigyoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する高額受領委任契約事業者を返します。
     *
     * @param 被保険者番号 HihokenshaNo
     * @param 履歴番号 RirekiNo
     * @return KogakuJuryoininKeiyakuJigyosha
     */
    @Transaction
    public KogakuJuryoininKeiyakuJigyosha get高額受領委任契約事業者(
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity = dac.selectByKey(
                被保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new KogakuJuryoininKeiyakuJigyosha(entity);
    }

    /**
     * 高額受領委任契約事業者を全件返します。
     *
     * @return List<KogakuJuryoininKeiyakuJigyosha>
     */
    @Transaction
    public List<KogakuJuryoininKeiyakuJigyosha> get高額受領委任契約事業者一覧() {
        List<KogakuJuryoininKeiyakuJigyosha> businessList = new ArrayList<>();

        for (DbT3076KogakuJuryoininKeiyakuJigyoshaEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new KogakuJuryoininKeiyakuJigyosha(entity));
        }

        return businessList;
    }

    /**
     * 高額受領委任契約事業者{@link KogakuJuryoininKeiyakuJigyosha}を保存します。
     *
     * @param 高額受領委任契約事業者 {@link KogakuJuryoininKeiyakuJigyosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save高額受領委任契約事業者(KogakuJuryoininKeiyakuJigyosha 高額受領委任契約事業者) {
        requireNonNull(高額受領委任契約事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("高額受領委任契約事業者"));
        if (!高額受領委任契約事業者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(高額受領委任契約事業者.toEntity());
    }

    /**
     * 高額受領委任契約事業者{@link KogakuJuryoininKeiyakuJigyosha}を保存します。
     *
     * @param 高額受領委任契約事業者 {@link KogakuJuryoininKeiyakuJigyosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean saveOrDeletePhysical高額受領委任契約事業者(KogakuJuryoininKeiyakuJigyosha 高額受領委任契約事業者) {
        requireNonNull(高額受領委任契約事業者, UrSystemErrorMessages.値がnull.getReplacedMessage("高額受領委任契約事業者"));
        if (!高額受領委任契約事業者.hasChanged()) {
            return false;
        }
        return 1 == dac.saveOrDeletePhysical(高額受領委任契約事業者.toEntity());
    }
}
