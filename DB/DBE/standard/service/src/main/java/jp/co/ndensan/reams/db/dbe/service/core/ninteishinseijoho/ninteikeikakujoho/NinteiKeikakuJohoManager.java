/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ninteikeikakujoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikeikakujoho.NinteiKeikakuJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5123NinteiKeikakuJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定計画情報を管理するクラスです。
 */
public class NinteiKeikakuJohoManager {

    private final DbT5123NinteiKeikakuJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiKeikakuJohoManager() {
        dac = InstanceProvider.create(DbT5123NinteiKeikakuJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5123NinteiKeikakuJohoDac}
     */
    NinteiKeikakuJohoManager(DbT5123NinteiKeikakuJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 要介護認定計画情報{@link NinteiKeikakuJoho}を保存します。
     *
     * @param 要介護認定計画情報 {@link NinteiKeikakuJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定計画情報(NinteiKeikakuJoho 要介護認定計画情報) {
        requireNonNull(要介護認定計画情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定計画情報"));
        if (!要介護認定計画情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定計画情報.toEntity());
    }
}
