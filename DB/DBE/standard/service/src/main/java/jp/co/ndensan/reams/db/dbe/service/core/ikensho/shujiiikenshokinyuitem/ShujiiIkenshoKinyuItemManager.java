/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikensho.shujiiikenshokinyuitem;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshokinyuitem.ShujiiIkenshoKinyuItem;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5303ShujiiIkenshoKinyuItemDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定主治医意見書記入項目を管理するクラスです。
 */
public class ShujiiIkenshoKinyuItemManager {

    private final DbT5303ShujiiIkenshoKinyuItemDac dac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoKinyuItemManager() {
        dac = InstanceProvider.create(DbT5303ShujiiIkenshoKinyuItemDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5303ShujiiIkenshoKinyuItemDac}
     */
    ShujiiIkenshoKinyuItemManager(DbT5303ShujiiIkenshoKinyuItemDac dac) {
        this.dac = dac;
    }

    /**
     * 要介護認定主治医意見書記入項目{@link ShujiiIkenshoKinyuItem}を保存します。
     *
     * @param 要介護認定主治医意見書記入項目 {@link ShujiiIkenshoKinyuItem}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定主治医意見書記入項目(ShujiiIkenshoKinyuItem 要介護認定主治医意見書記入項目) {
        requireNonNull(要介護認定主治医意見書記入項目, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書記入項目"));
        if (!要介護認定主治医意見書記入項目.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定主治医意見書記入項目.toEntity());
    }
}
