/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.shinsakaiiinjogaijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.shinsakaiiinjogaijoho.ShinsakaiIinJogaiJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5590ShinsakaiIinJogaiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 審査会委員除外情報を管理するクラスです。
 */
public class ShinsakaiIinJogaiJohoManager {

    private final DbT5590ShinsakaiIinJogaiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinJogaiJohoManager() {
        dac = InstanceProvider.create(DbT5590ShinsakaiIinJogaiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5590ShinsakaiIinJogaiJohoDac}
     */
    ShinsakaiIinJogaiJohoManager(DbT5590ShinsakaiIinJogaiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 審査会委員除外情報{@link ShinsakaiIinJogaiJoho}を保存します。
     *
     * @param 審査会委員除外情報 {@link ShinsakaiIinJogaiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save審査会委員除外情報(ShinsakaiIinJogaiJoho 審査会委員除外情報) {
        requireNonNull(審査会委員除外情報, UrSystemErrorMessages.値がnull.getReplacedMessage("審査会委員除外情報"));
        if (!審査会委員除外情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(審査会委員除外情報.toEntity());
    }
}
