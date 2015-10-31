/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiwariateiinjoho;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiiinjoho.ShinsakaiIinJoho;
import jp.co.ndensan.reams.db.dbe.business.core.Shinsakai.shinsakaiwariateiinjoho.ShinsakaiWariateIinJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5503ShinsakaiWariateIinJohoDac;
import jp.co.ndensan.reams.db.dbe.service.core.shinsakai.shinsakaiiinjoho.ShinsakaiIinJohoManager;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会割当委員情報を管理するクラスです。
 */
public class ShinsakaiWariateIinJohoManager {

    private final DbT5503ShinsakaiWariateIinJohoDac dac;
    private final ShinsakaiIinJohoManager 介護認定審査会委員情報Manager;

    /**
     * コンストラクタです。
     */
    public ShinsakaiWariateIinJohoManager() {
        dac = InstanceProvider.create(DbT5503ShinsakaiWariateIinJohoDac.class);
        this.介護認定審査会委員情報Manager = new ShinsakaiIinJohoManager();
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5503ShinsakaiWariateIinJohoDac}
     */
    ShinsakaiWariateIinJohoManager(
            DbT5503ShinsakaiWariateIinJohoDac dac,
            ShinsakaiIinJohoManager 介護認定審査会委員情報Manager
    ) {
        this.dac = dac;
        this.介護認定審査会委員情報Manager = 介護認定審査会委員情報Manager;
    }

    /**
     * 介護認定審査会割当委員情報{@link ShinsakaiWariateIinJoho}を保存します。
     *
     * @param 介護認定審査会割当委員情報 {@link ShinsakaiWariateIinJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会割当委員情報(ShinsakaiWariateIinJoho 介護認定審査会割当委員情報) {
        requireNonNull(介護認定審査会割当委員情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会割当委員情報"));
        if (!介護認定審査会割当委員情報.hasChanged()) {
            return false;
        }
        save介護認定審査会委員情報リスト(介護認定審査会割当委員情報.getShinsakaiIinJohoList());
        return 1 == dac.save(介護認定審査会割当委員情報.toEntity());
    }

    private void save介護認定審査会委員情報リスト(List<ShinsakaiIinJoho> 介護認定審査会委員情報List) {
        for (ShinsakaiIinJoho 介護認定審査会委員情報 : 介護認定審査会委員情報List) {
            介護認定審査会委員情報Manager.save介護認定審査会委員情報(介護認定審査会委員情報);
        }
    }
}
