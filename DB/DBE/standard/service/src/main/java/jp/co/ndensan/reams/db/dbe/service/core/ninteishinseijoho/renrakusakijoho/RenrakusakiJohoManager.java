/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.renrakusakijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.renrakusakijoho.RenrakusakiJoho;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5150RenrakusakiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護連絡先情報を管理するクラスです。
 */
public class RenrakusakiJohoManager {

    private final DbT5150RenrakusakiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public RenrakusakiJohoManager() {
        dac = InstanceProvider.create(DbT5150RenrakusakiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5150RenrakusakiJohoDac}
     */
    RenrakusakiJohoManager(DbT5150RenrakusakiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 介護連絡先情報{@link RenrakusakiJoho}を保存します。
     *
     * @param 介護連絡先情報 {@link RenrakusakiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護連絡先情報(RenrakusakiJoho 介護連絡先情報) {
        requireNonNull(介護連絡先情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護連絡先情報"));
        if (!介護連絡先情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護連絡先情報.toEntity());
    }
}
