/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokensha.seikatsuhogofujoshurui;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogofujoshurui.SeikatsuHogoFujoShurui;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urd.persistence.db.basic.seikatsuhogo.UrT0526SeikatsuhogoFujoShuruiDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 生活保護扶助種類を管理するクラスです。
 */
public class SeikatsuHogoFujoShuruiManager {

    private final UrT0526SeikatsuhogoFujoShuruiDac dac;

    /**
     * コンストラクタです。
     */
    public SeikatsuHogoFujoShuruiManager() {
        dac = InstanceProvider.create(UrT0526SeikatsuhogoFujoShuruiDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link UrT0526SeikatsuHogoFujoShuruiDac}
     */
    SeikatsuHogoFujoShuruiManager(UrT0526SeikatsuhogoFujoShuruiDac dac) {
        this.dac = dac;
    }

    /**
     * 生活保護扶助種類{@link SeikatsuHogoFujoShurui}を保存します。
     *
     * @param 生活保護扶助種類 {@link SeikatsuHogoFujoShurui}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save生活保護扶助種類(SeikatsuHogoFujoShurui 生活保護扶助種類) {
        requireNonNull(生活保護扶助種類, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護扶助種類"));
        if (!生活保護扶助種類.hasChanged()) {
            return false;
        }
        return 1 == dac.save(生活保護扶助種類.toEntity());
    }
}
