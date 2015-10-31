/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariatejoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.ninteishinseijoho.NinteiShinseiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariatejoho.ShinsakaiWariateJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5502ShinsakaiWariateJohoDac;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.ninteishinseijoho.NinteiShinseiJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会割当情報を管理するクラスです。
 */
public class ShinsakaiWariateJohoManager {

    private final DbT5502ShinsakaiWariateJohoDac dac;
    private final NinteiShinseiJohoManager 要介護認定申請情報Manager;

    /**
     * コンストラクタです。
     */
    public ShinsakaiWariateJohoManager() {
        this.dac = InstanceProvider.create(DbT5502ShinsakaiWariateJohoDac.class);
        this.要介護認定申請情報Manager = new NinteiShinseiJohoManager();
    }

    /**
     * 単体テスト用コンストラクタです。
     *
     * @param mapperProvider mapperProvider
     * @param 介護認定審査会割当情報Dac 介護認定審査会割当情報Dac
     * @param 要介護認定申請情報Manager 要介護認定申請情報Manager
     * @param dac {@link DbT5502ShinsakaiWariateJohoDac}
     */
    ShinsakaiWariateJohoManager(
            DbT5502ShinsakaiWariateJohoDac dac,
            NinteiShinseiJohoManager 要介護認定申請情報Manager) {

        this.dac = dac;
        this.要介護認定申請情報Manager = 要介護認定申請情報Manager;
    }

    /**
     * 介護認定審査会割当情報{@link ShinsakaiWariateJoho}を保存します。
     *
     * @param 介護認定審査会割当情報 {@link ShinsakaiWariateJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会割当情報(ShinsakaiWariateJoho 介護認定審査会割当情報) {
        requireNonNull(介護認定審査会割当情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当情報"));
        if (!介護認定審査会割当情報.hasChanged()) {
            return false;
        }
        save要介護認定申請情報リスト(介護認定審査会割当情報.getNinteiShinseiJohoList());
        return 1 == dac.save(介護認定審査会割当情報.toEntity());
    }

    private void save要介護認定申請情報リスト(List<NinteiShinseiJoho> 要介護認定申請情報List) {
        for (NinteiShinseiJoho 要介護認定申請情報 : 要介護認定申請情報List) {
            要介護認定申請情報Manager.save要介護認定申請情報(要介護認定申請情報);
        }
    }
}
