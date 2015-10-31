/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ninteikanryojoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ninteikanryojoho.NinteiKanryoJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5105NinteiKanryoJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定完了情報を管理するクラスです。
 */
public class NinteiKanryoJohoManager {

    private final DbT5105NinteiKanryoJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteiKanryoJohoManager() {
        dac = InstanceProvider.create(DbT5105NinteiKanryoJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5105NinteiKanryoJohoDac}
     */
    NinteiKanryoJohoManager(DbT5105NinteiKanryoJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 要介護認定完了情報{@link NinteiKanryoJoho}を保存します。
     *
     * @param 要介護認定完了情報 {@link NinteiKanryoJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定完了情報(NinteiKanryoJoho 要介護認定完了情報) {
        requireNonNull(要介護認定完了情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定完了情報"));
        if (!要介護認定完了情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定完了情報.toEntity());
    }
}
