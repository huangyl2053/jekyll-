/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyokinyuitem;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokinyuitem.NinteichosahyoKinyuItem;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5209NinteichosahyoKinyuItemDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（概況調査）記入項目を管理するクラスです。
 */
public class NinteichosahyoKinyuItemManager {

    private final DbT5209NinteichosahyoKinyuItemDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoKinyuItemManager() {
        dac = InstanceProvider.create(DbT5209NinteichosahyoKinyuItemDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5209NinteichosahyoKinyuItemDac}
     */
    NinteichosahyoKinyuItemManager(DbT5209NinteichosahyoKinyuItemDac dac) {
        this.dac = dac;
    }

    /**
     * 認定調査票（概況調査）記入項目{@link NinteichosahyoKinyuItem}を保存します。
     *
     * @param 認定調査票_概況調査_記入項目 {@link NinteichosahyoKinyuItem}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_概況調査_記入項目(NinteichosahyoKinyuItem 認定調査票_概況調査_記入項目) {
        requireNonNull(認定調査票_概況調査_記入項目, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（概況調査）記入項目"));
        if (!認定調査票_概況調査_記入項目.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_概況調査_記入項目.toEntity());
    }
}
