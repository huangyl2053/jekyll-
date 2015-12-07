/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikensho.shujiiikenshoikenitem;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoikenitem.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5304ShujiiIkenshoIkenItemDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定主治医意見書意見項目を管理するクラスです。
 */
public class ShujiiIkenshoIkenItemManager {

    private final DbT5304ShujiiIkenshoIkenItemDac dac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoIkenItemManager() {
        dac = InstanceProvider.create(DbT5304ShujiiIkenshoIkenItemDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5304ShujiiIkenshoIkenItemDac}
     */
    ShujiiIkenshoIkenItemManager(DbT5304ShujiiIkenshoIkenItemDac dac) {
        this.dac = dac;
    }

    /**
     * 要介護認定主治医意見書意見項目{@link ShujiiIkenshoIkenItem}を保存します。
     *
     * @param 要介護認定主治医意見書意見項目 {@link ShujiiIkenshoIkenItem}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save要介護認定主治医意見書意見項目(ShujiiIkenshoIkenItem 要介護認定主治医意見書意見項目) {
        requireNonNull(要介護認定主治医意見書意見項目, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定主治医意見書意見項目"));
        if (!要介護認定主治医意見書意見項目.hasChanged()) {
            return false;
        }
        return 1 == dac.save(要介護認定主治医意見書意見項目.toEntity());
    }
}
