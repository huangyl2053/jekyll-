/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5304ShujiiIkenshoIkenItemDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定主治医意見書意見項目
 *
 * @author n8429
 */
public class ShujiiIkenshoIkenItemNewManager {

    private final DbT5304ShujiiIkenshoIkenItemDac dac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoIkenItemNewManager() {
        dac = InstanceProvider.create(DbT5304ShujiiIkenshoIkenItemDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5304ShujiiIkenshoIkenItemDac}
     */
    ShujiiIkenshoIkenItemNewManager(DbT5304ShujiiIkenshoIkenItemDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoIkenItemNewManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoIkenItemNewManager}のインスタンス
     */
    public static ShujiiIkenshoIkenItemNewManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoIkenItemNewManager.class);
    }

    /**
     * 要介護認定主治医意見書意見項目
     *
     * @param shinseishoKanriNo
     * @param 主治医意見書作成依頼履歴番号
     * @param 連番
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public DbT5304ShujiiIkenshoIkenItemEntity select主治医意見書(ShinseishoKanriNo shinseishoKanriNo, int 主治医意見書作成依頼履歴番号, int 連番) {
        return dac.selectByMainKey(shinseishoKanriNo, 主治医意見書作成依頼履歴番号, 連番);
    }

    /**
     * 要介護認定主治医意見書意見項目
     *
     * @param 情報
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save主治医意見書(DbT5304ShujiiIkenshoIkenItemEntity 情報) {
        requireNonNull(情報, UrSystemErrorMessages.値がnull.getReplacedMessage("情報"));

        return 1 == dac.save(情報);
    }

}
