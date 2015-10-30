/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.service.core.kaigojigyosha.kaigojigyoshadaihyosha;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.kaigojigyosha.kaigojigyoshadaihyosha.KaigoJigyoshaDaihyosha;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7062KaigoJigyoshaDaihyoshaDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護事業者代表者を管理するクラスです。
 */
public class KaigoJigyoshaDaihyoshaManager {

    private final DbT7062KaigoJigyoshaDaihyoshaDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoJigyoshaDaihyoshaManager() {
        dac = InstanceProvider.create(DbT7062KaigoJigyoshaDaihyoshaDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7062KaigoJigyoshaDaihyoshaDac}
     */
    KaigoJigyoshaDaihyoshaManager(DbT7062KaigoJigyoshaDaihyoshaDac dac) {
        this.dac = dac;
    }

    /**
     * 介護事業者代表者{@link KaigoJigyoshaDaihyosha}を保存します。
     *
     * @param 介護事業者代表者 {@link KaigoJigyoshaDaihyosha}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護事業者代表者(KaigoJigyoshaDaihyosha 介護事業者代表者) {
        requireNonNull(介護事業者代表者, UrSystemErrorMessages.値がnull.getReplacedMessage("介護事業者代表者"));
        if (!介護事業者代表者.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護事業者代表者.toEntity());
    }
}
