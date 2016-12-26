/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5303ShujiiIkenshoKinyuItemDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定主治医意見書記入項目
 *
 * @author n8429
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
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoKinyuItemManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoKinyuItemManager}のインスタンス
     */
    public static ShujiiIkenshoKinyuItemManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoKinyuItemManager.class);
    }

    /**
     * 要介護認定主治医意見書記入項目
     *
     * @param shinseishoKanriNo
     * @param 主治医意見書作成依頼履歴番号
     * @param 連番
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public DbT5303ShujiiIkenshoKinyuItemEntity select主治医意見書(ShinseishoKanriNo shinseishoKanriNo, int 主治医意見書作成依頼履歴番号,int 連番) {
        return dac.selectByKeyNew(shinseishoKanriNo, 主治医意見書作成依頼履歴番号,連番);
    }

    /**
     * 要介護認定主治医意見書記入項目
     *
     * @param 情報
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票(DbT5303ShujiiIkenshoKinyuItemEntity 情報) {
        requireNonNull(情報, UrSystemErrorMessages.値がnull.getReplacedMessage("情報"));

        return 1 == dac.save(情報);
    }
}
