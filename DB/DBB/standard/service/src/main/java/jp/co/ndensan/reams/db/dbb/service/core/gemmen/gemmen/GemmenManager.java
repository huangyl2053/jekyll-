/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.gemmen.gemmen;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.gemmen.gemmen.Gemmen;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2004GemmenDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護賦課減免を管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class GemmenManager {

    private final DbT2004GemmenDac dac;

    /**
     * コンストラクタです。
     */
    public GemmenManager() {
        dac = InstanceProvider.create(DbT2004GemmenDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2004GemmenDac}
     */
    GemmenManager(DbT2004GemmenDac dac) {
        this.dac = dac;
    }

    /**
     * 介護賦課減免{@link Gemmen}を保存します。
     *
     * @param 介護賦課減免 {@link Gemmen}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護賦課減免(Gemmen 介護賦課減免) {
        requireNonNull(介護賦課減免, UrSystemErrorMessages.値がnull.getReplacedMessage("介護賦課減免"));
        if (!介護賦課減免.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護賦課減免.toEntity());
    }
}
