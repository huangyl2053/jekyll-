/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.ichigojihanteikekkajoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.ichigojihanteikekkajoho.IchiGojiHanteiKekkaJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5510IchiGojiHanteiKekkaJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定1_5次判定結果情報を管理するクラスです。
 */
public class IchiGojiHanteiKekkaJohoManager {

    private final DbT5510IchiGojiHanteiKekkaJohoDac dac;

    /**
     * コンストラクタです。
     */
    public IchiGojiHanteiKekkaJohoManager() {
        dac = InstanceProvider.create(DbT5510IchiGojiHanteiKekkaJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5510IchiGojiHanteiKekkaJohoDac}
     */
    IchiGojiHanteiKekkaJohoManager(DbT5510IchiGojiHanteiKekkaJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 要介護認定1_5次判定結果情報{@link IchiGojiHanteiKekkaJoho}を保存します。
     *
     * @param 要介護認定1_5次判定結果情報 {@link IchiGojiHanteiKekkaJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定1_5次判定結果情報(IchiGojiHanteiKekkaJoho 要介護認定1_5次判定結果情報) {
        requireNonNull(要介護認定1_5次判定結果情報, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定1_5次判定結果情報"));
        if (!要介護認定1_5次判定結果情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定1_5次判定結果情報.toEntity());
    }
}
