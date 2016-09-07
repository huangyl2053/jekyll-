/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.fuka;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.fuka.Kibetsu;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT2003KibetsuDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護期別を管理するクラスです。
 */
public class KibetsuManager {

    private final DbT2003KibetsuDac dac;

    /**
     * コンストラクタです。
     */
    public KibetsuManager() {
        dac = InstanceProvider.create(DbT2003KibetsuDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2003KibetsuDac}
     */
    KibetsuManager(DbT2003KibetsuDac dac) {
        this.dac = dac;
    }

    /**
     * 介護期別{@link Kibetsu}を保存します。
     *
     * @param 介護期別 {@link Kibetsu}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護期別(Kibetsu 介護期別) {
        requireNonNull(介護期別, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別"));
        if (!介護期別.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護期別.toEntity());
    }
}
