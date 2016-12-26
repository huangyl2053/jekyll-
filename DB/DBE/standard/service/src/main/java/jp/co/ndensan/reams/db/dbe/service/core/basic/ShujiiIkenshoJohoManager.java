/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5302ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5302ShujiiIkenshoJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 要介護認定主治医意見書情報を取得します。
 *
 * @author n8429
 */
public class ShujiiIkenshoJohoManager {

    private final DbT5302ShujiiIkenshoJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShujiiIkenshoJohoManager() {
        dac = InstanceProvider.create(DbT5302ShujiiIkenshoJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5302ShujiiIkenshoJohoDac}
     */
    ShujiiIkenshoJohoManager(DbT5302ShujiiIkenshoJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoJohoManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoJohoManager}のインスタンス
     */
    public static ShujiiIkenshoJohoManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoJohoManager.class);
    }

    /**
     * 要介護認定主治医意見書情報 {@link NinteiKeikakuJoho}を保存します。
     *
     * @param shinseishoKanriNo
     * @param 主治医意見書作成依頼履歴番号
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public DbT5302ShujiiIkenshoJohoEntity select主治医意見書(ShinseishoKanriNo shinseishoKanriNo, int 主治医意見書作成依頼履歴番号) {
        return dac.selectByKey(shinseishoKanriNo, 主治医意見書作成依頼履歴番号);
    }

    /**
     * 要介護認定主治医意見書情報{@link NinteiKeikakuJoho}を保存します。
     *
     * @param 情報
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票(DbT5302ShujiiIkenshoJohoEntity 情報) {
        requireNonNull(情報, UrSystemErrorMessages.値がnull.getReplacedMessage("情報"));

        return 1 == dac.save(情報);
    }

}
