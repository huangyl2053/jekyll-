/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokensha.shisetsunyutaisho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.shisetsunyutaisho.ShisetsuNyutaisho;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1004ShisetsuNyutaishoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護保険施設入退所を管理するクラスです。
 */
public class ShisetsuNyutaishoManager {

    private final DbT1004ShisetsuNyutaishoDac dac;

    /**
     * コンストラクタです。
     */
    public ShisetsuNyutaishoManager() {
        dac = InstanceProvider.create(DbT1004ShisetsuNyutaishoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT1004ShisetsuNyutaishoDac}
     */
    ShisetsuNyutaishoManager(DbT1004ShisetsuNyutaishoDac dac) {
        this.dac = dac;
    }

    /**
     * 介護保険施設入退所{@link ShisetsuNyutaisho}を保存します。
     *
     * @param 介護保険施設入退所 {@link ShisetsuNyutaisho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護保険施設入退所(ShisetsuNyutaisho 介護保険施設入退所) {
        requireNonNull(介護保険施設入退所, UrSystemErrorMessages.値がnull.getReplacedMessage("介護保険施設入退所"));
        if (!介護保険施設入退所.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護保険施設入退所.toEntity());
    }
}
