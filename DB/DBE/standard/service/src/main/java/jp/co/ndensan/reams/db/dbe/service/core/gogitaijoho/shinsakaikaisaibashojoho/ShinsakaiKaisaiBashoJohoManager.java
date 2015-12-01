/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.shinsakaikaisaibashojoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.shinsakaikaisaibashojoho.ShinsakaiKaisaiBashoJoho;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5592ShinsakaiKaisaiBashoJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護認定審査会開催場所情報を管理するクラスです。
 */
public class ShinsakaiKaisaiBashoJohoManager {

    private final DbT5592ShinsakaiKaisaiBashoJohoDac dac;

    /**
     * コンストラクタです。
     */
    public ShinsakaiKaisaiBashoJohoManager() {
        dac = InstanceProvider.create(DbT5592ShinsakaiKaisaiBashoJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5592ShinsakaiKaisaiBashoJohoDac}
     */
    ShinsakaiKaisaiBashoJohoManager(DbT5592ShinsakaiKaisaiBashoJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 介護認定審査会開催場所情報{@link ShinsakaiKaisaiBashoJoho}を保存します。
     *
     * @param 介護認定審査会開催場所情報 {@link ShinsakaiKaisaiBashoJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護認定審査会開催場所情報(ShinsakaiKaisaiBashoJoho 介護認定審査会開催場所情報) {
        requireNonNull(介護認定審査会開催場所情報, UrSystemErrorMessages.値がnull.getReplacedMessage("介護認定審査会開催場所情報"));
        if (!介護認定審査会開催場所情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護認定審査会開催場所情報.toEntity());
    }
}
