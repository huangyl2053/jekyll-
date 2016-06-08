/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoKinyuItem;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
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
     * 主キーに合致する要介護認定主治医意見書記入項目を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return ShujiiIkenshoKinyuItem
     */
    @Transaction
    public ShujiiIkenshoKinyuItem get要介護認定主治医意見書記入項目(
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));

        DbT5303ShujiiIkenshoKinyuItemEntity entity = dac.selectByKey(
                申請書管理番号,
                主治医意見書作成依頼履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShujiiIkenshoKinyuItem(entity);
    }

    /**
     * 要介護認定主治医意見書記入項目を全件返します。
     *
     * @return ShujiiIkenshoKinyuItemの{@code list}
     */
    @Transaction
    public List<ShujiiIkenshoKinyuItem> get要介護認定主治医意見書記入項目一覧() {
        List<ShujiiIkenshoKinyuItem> businessList = new ArrayList<>();

        for (DbT5303ShujiiIkenshoKinyuItemEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShujiiIkenshoKinyuItem(entity));
        }

        return businessList;
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
