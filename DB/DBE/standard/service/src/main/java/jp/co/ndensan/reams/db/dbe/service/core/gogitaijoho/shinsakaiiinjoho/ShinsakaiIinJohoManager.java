/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.shinsakaiiinjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5594ShinsakaiIinJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員情報を管理するクラスです。
 */
public class ShinsakaiIinJohoManager {

    private final DbT5594ShinsakaiIinJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiIinJohoManager() {
        dac = InstanceProvider.create(DbT5594ShinsakaiIinJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5594ShinsakaiIinJohoDac}
     */
    ShinsakaiIinJohoManager(DbT5594ShinsakaiIinJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 介護認定審査会委員情報{@link ShinsakaiIinJoho}を保存します。
     *
     * @param 介護認定審査会委員情報 {@link ShinsakaiIinJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会委員情報(ShinsakaiIinJoho 介護認定審査会委員情報) {
        requireNonNull(介護認定審査会委員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員情報"));
        if (!介護認定審査会委員情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会委員情報.toEntity());
    }
}
