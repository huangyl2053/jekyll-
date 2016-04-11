/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ikensho.shujiiikenshoiraijoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshoiraijoho.ShujiiIkenshoIraiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJoho;
import jp.co.ndensan.reams.db.dbe.service.core.ikensho.shujiiikenshojoho.ShujiiIkenshoJohoManager;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5301ShujiiIkenshoIraiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 主治医意見書作成依頼情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class ShujiiIkenshoIraiJohoManager {

    private final DbT5301ShujiiIkenshoIraiJohoDac 主治医意見書作成依頼情報Dac;
    private final ShujiiIkenshoJohoManager 要介護認定主治医意見書情報Manager;

    /**
     * コンストラクタです。
     */
    ShujiiIkenshoIraiJohoManager() {
        this.主治医意見書作成依頼情報Dac = InstanceProvider.create(DbT5301ShujiiIkenshoIraiJohoDac.class);
        this.要介護認定主治医意見書情報Manager = ShujiiIkenshoJohoManager.createInstance();
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     * @param 主治医意見書作成依頼情報Dac 主治医意見書作成依頼情報Dac
     * @param 要介護認定主治医意見書情報Manager 要介護認定主治医意見書情報Manager
     */
    ShujiiIkenshoIraiJohoManager(
            DbT5301ShujiiIkenshoIraiJohoDac 主治医意見書作成依頼情報Dac,
            ShujiiIkenshoJohoManager 要介護認定主治医意見書情報Manager
    ) {
        this.主治医意見書作成依頼情報Dac = 主治医意見書作成依頼情報Dac;
        this.要介護認定主治医意見書情報Manager = 要介護認定主治医意見書情報Manager;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoIraiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShujiiIkenshoIraiJohoManager}のインスタンス
     */
    public static ShujiiIkenshoIraiJohoManager createInstance() {
        return InstanceProvider.create(ShujiiIkenshoIraiJohoManager.class);
    }

    /**
     * 主治医意見書作成依頼情報{@link ShujiiIkenshoIraiJoho}を保存します。
     *
     * @param 主治医意見書作成依頼情報 主治医意見書作成依頼情報
     * @return 更新あり:true、更新なし:false <br>
     * いずれかのテーブルに更新があればtrueを返す、いずれのテーブルもunchangedで更新無しの場合falseを返す
     */
    @Transaction
    public boolean save(ShujiiIkenshoIraiJoho 主治医意見書作成依頼情報) {
        requireNonNull(主治医意見書作成依頼情報, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医意見書作成依頼情報"));

        if (!主治医意見書作成依頼情報.hasChanged()) {
            return false;
        }
        主治医意見書作成依頼情報 = 主治医意見書作成依頼情報.modifiedModel();
        save要介護認定主治医意見書情報リスト(主治医意見書作成依頼情報.getShujiiIkenshoJohoList());
        return 1 == 主治医意見書作成依頼情報Dac.save(主治医意見書作成依頼情報.toEntity());
    }

    private void save要介護認定主治医意見書情報リスト(List<ShujiiIkenshoJoho> 要介護認定主治医意見書情報List) {
        for (ShujiiIkenshoJoho 要介護認定主治医意見書情報 : 要介護認定主治医意見書情報List) {
            要介護認定主治医意見書情報Manager.save(要介護認定主治医意見書情報);
        }
    }
}
