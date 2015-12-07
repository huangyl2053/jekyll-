/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokensha.roreifukushinenkinjukyusha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.roreifukushinenkinjukyusha.RoreiFukushiNenkinJukyusha;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7006RoreiFukushiNenkinJukyushaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 老齢福祉年金受給者を管理するクラスです。
 */
public class RoreiFukushiNenkinJukyushaManager {

    private final DbT7006RoreiFukushiNenkinJukyushaDac dac;

    /**
     * コンストラクタです。
     */
    public RoreiFukushiNenkinJukyushaManager() {
        dac = InstanceProvider.create(DbT7006RoreiFukushiNenkinJukyushaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7006RoreiFukushiNenkinJukyushaDac}
     */
    RoreiFukushiNenkinJukyushaManager(DbT7006RoreiFukushiNenkinJukyushaDac dac) {
        this.dac = dac;
    }

    /**
     * 老齢福祉年金受給者{@link RoreiFukushiNenkinJukyusha}を保存します。
     *
     * @param 老齢福祉年金受給者 {@link RoreiFukushiNenkinJukyusha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save老齢福祉年金受給者(RoreiFukushiNenkinJukyusha 老齢福祉年金受給者) {
        requireNonNull(老齢福祉年金受給者, UrSystemErrorMessages.値がnull.getReplacedMessage("老齢福祉年金受給者"));
        if (!老齢福祉年金受給者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(老齢福祉年金受給者.toEntity());
    }
}
