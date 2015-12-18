/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.shinsakaiiinjoho.kaigoninteishinsakaiiinshozokukikanjoho.KaigoNinteiShinsakaiIinShozokuKikanJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会委員所属機関情報を管理するクラスです。
 */
public class KaigoNinteiShinsakaiIinShozokuKikanJohoManager {

    private final DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac dac;

    /**
     * コンストラクタです。
     */
    public KaigoNinteiShinsakaiIinShozokuKikanJohoManager() {
        dac = InstanceProvider.create(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac}
     */
    KaigoNinteiShinsakaiIinShozokuKikanJohoManager(DbT5595KaigoNinteiShinsakaiIinShozokuKikanJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 介護認定審査会委員所属機関情報{@link KaigoNinteiShinsakaiIinShozokuKikanJoho}を保存します。
     *
     * @param 介護認定審査会委員所属機関情報 {@link KaigoNinteiShinsakaiIinShozokuKikanJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会委員所属機関情報(KaigoNinteiShinsakaiIinShozokuKikanJoho 介護認定審査会委員所属機関情報) {
        requireNonNull(介護認定審査会委員所属機関情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員所属機関情報"));
        if (!介護認定審査会委員所属機関情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会委員所属機関情報.toEntity());
    }

    /**
     * 介護認定審査会委員所属機関情報{@link KaigoNinteiShinsakaiIinShozokuKikanJoho}を削除します。
     *
     * @param 介護認定審査会委員所属機関情報 {@link KaigoNinteiShinsakaiIinShozokuKikanJoho}
     * @return 削除件数 削除結果の件数を返します。
     */
    @Transaction
    public boolean delete介護認定審査会委員所属機関情報(KaigoNinteiShinsakaiIinShozokuKikanJoho 介護認定審査会委員所属機関情報) {
        requireNonNull(介護認定審査会委員所属機関情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会委員所属機関情報"));

        return 1 == dac.delete(介護認定審査会委員所属機関情報.toEntity());
    }
}
