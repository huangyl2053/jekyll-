/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShinseitodokedeJoho;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5120ShinseitodokedeJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 申請届出情報を管理するクラスです。
 *
 * @reamsid_L DBZ-9999-013 huangh
 */
public class ShinseitodokedeJohoManager {

    private final DbT5120ShinseitodokedeJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinseitodokedeJohoManager() {
        dac = InstanceProvider.create(DbT5120ShinseitodokedeJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5120ShinseitodokedeJohoDac}
     */
    ShinseitodokedeJohoManager(DbT5120ShinseitodokedeJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 申請届出情報{@link ShinseitodokedeJoho}を保存します。
     *
     * @param 申請届出情報 {@link ShinseitodokedeJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save申請届出情報(ShinseitodokedeJoho 申請届出情報) {
        requireNonNull(申請届出情報, UrSystemErrorMessages.値がnull.getReplacedMessage("申請届出情報"));
        if (!申請届出情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(申請届出情報.toEntity());
    }
}
