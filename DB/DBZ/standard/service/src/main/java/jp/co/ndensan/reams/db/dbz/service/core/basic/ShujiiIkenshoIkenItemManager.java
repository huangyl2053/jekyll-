/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShujiiIkenshoIkenItem;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.basic.DbT5304ShujiiIkenshoIkenItemDac;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.message.UrSystemErrorMessages;
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
     * 主キーに合致する要介護認定主治医意見書意見項目を返します。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 主治医意見書作成依頼履歴番号 主治医意見書作成依頼履歴番号
     * @return ShujiiIkenshoIkenItem
     */
    @Transaction
    public ShujiiIkenshoIkenItem get要介護認定主治医意見書意見項目(
            ShinseishoKanriNo 申請書管理番号,
            int 主治医意見書作成依頼履歴番号) {
        requireNonNull(申請書管理番号, UrSystemErrorMessages.値がnull.getReplacedMessage("申請書管理番号"));
        requireNonNull(主治医意見書作成依頼履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼履歴番号"));

        DbT5304ShujiiIkenshoIkenItemEntity entity = dac.selectByKey(
                申請書管理番号,
                主治医意見書作成依頼履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new ShujiiIkenshoIkenItem(entity);
    }

    /**
     * 要介護認定主治医意見書意見項目を全件返します。
     *
     * @return ShujiiIkenshoIkenItemの{@code list}
     */
    @Transaction
    public List<ShujiiIkenshoIkenItem> get要介護認定主治医意見書意見項目一覧() {
        List<ShujiiIkenshoIkenItem> businessList = new ArrayList<>();

        for (DbT5304ShujiiIkenshoIkenItemEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new ShujiiIkenshoIkenItem(entity));
        }

        return businessList;
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
