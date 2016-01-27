/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyoservicejokyoflag;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyoflag.NinteichosahyoServiceJokyoFlag;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5208NinteichosahyoServiceJokyoFlagDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（概況調査）サービスの状況フラグを管理するクラスです。
 */
public class NinteichosahyoServiceJokyoFlagManager {

    private final DbT5208NinteichosahyoServiceJokyoFlagDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoServiceJokyoFlagManager() {
        dac = InstanceProvider.create(DbT5208NinteichosahyoServiceJokyoFlagDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5208NinteichosahyoServiceJokyoFlagDac}
     */
    NinteichosahyoServiceJokyoFlagManager(DbT5208NinteichosahyoServiceJokyoFlagDac dac) {
        this.dac = dac;
    }

    /**
     * 認定調査票（概況調査）サービスの状況フラグ{@link NinteichosahyoServiceJokyoFlag}を保存します。
     *
     * @param 認定調査票_概況調査_サービスの状況フラグ {@link NinteichosahyoServiceJokyoFlag}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況調査_サービスの状況フラグ(NinteichosahyoServiceJokyoFlag 認定調査票_概況調査_サービスの状況フラグ) {
        requireNonNull(認定調査票_概況調査_サービスの状況フラグ, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）サービスの状況フラグ"));
        if (!認定調査票_概況調査_サービスの状況フラグ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況調査_サービスの状況フラグ.toEntity());
    }
}
