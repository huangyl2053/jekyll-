/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyoservicejokyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoservicejokyo.NinteichosahyoServiceJokyo;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5207NinteichosahyoServiceJokyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（概況調査）サービスの状況を管理するクラスです。
 */
public class NinteichosahyoServiceJokyoManager {

    private final DbT5207NinteichosahyoServiceJokyoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoServiceJokyoManager() {
        dac = InstanceProvider.create(DbT5207NinteichosahyoServiceJokyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5207NinteichosahyoServiceJokyoDac}
     */
    NinteichosahyoServiceJokyoManager(DbT5207NinteichosahyoServiceJokyoDac dac) {
        this.dac = dac;
    }

    /**
     * 認定調査票（概況調査）サービスの状況{@link NinteichosahyoServiceJokyo}を保存します。
     *
     * @param 認定調査票_概況調査_サービスの状況 {@link NinteichosahyoServiceJokyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況調査_サービスの状況(NinteichosahyoServiceJokyo 認定調査票_概況調査_サービスの状況) {
        requireNonNull(認定調査票_概況調査_サービスの状況, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）サービスの状況"));
        if (!認定調査票_概況調査_サービスの状況.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況調査_サービスの状況.toEntity()
        );
    }
}
