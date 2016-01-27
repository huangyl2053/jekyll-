/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyoshisetsuriyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyoshisetsuriyo.NinteichosahyoShisetsuRiyo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5210NinteichosahyoShisetsuRiyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（概況調査）施設利用を管理するクラスです。
 */
public class NinteichosahyoShisetsuRiyoManager {

    private final DbT5210NinteichosahyoShisetsuRiyoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoShisetsuRiyoManager() {
        dac = InstanceProvider.create(DbT5210NinteichosahyoShisetsuRiyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5210NinteichosahyoShisetsuRiyoDac}
     */
    NinteichosahyoShisetsuRiyoManager(DbT5210NinteichosahyoShisetsuRiyoDac dac) {
        this.dac = dac;
    }

    /**
     * 認定調査票（概況調査）施設利用{@link NinteichosahyoShisetsuRiyo}を保存します。
     *
     * @param 認定調査票_概況調査_施設利用 {@link NinteichosahyoShisetsuRiyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況調査_施設利用(NinteichosahyoShisetsuRiyo 認定調査票_概況調査_施設利用) {
        requireNonNull(認定調査票_概況調査_施設利用, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）施設利用"));
        if (!認定調査票_概況調査_施設利用.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況調査_施設利用.toEntity());
    }
}
