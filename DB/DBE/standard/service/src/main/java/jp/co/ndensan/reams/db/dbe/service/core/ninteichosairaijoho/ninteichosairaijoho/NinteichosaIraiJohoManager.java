/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosairaijoho.ninteichosairaijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosairaijoho.ninteichosairaijoho.NinteichosaIraiJoho;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5201NinteichosaIraiJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査依頼情報を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class NinteichosaIraiJohoManager {

    private final DbT5201NinteichosaIraiJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosaIraiJohoManager() {
        dac = InstanceProvider.create(DbT5201NinteichosaIraiJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5201NinteichosaIraiJohoDac}
     */
    NinteichosaIraiJohoManager(DbT5201NinteichosaIraiJohoDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link NinteichosaIraiJohoManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link NinteichosaIraiJohoManager}のインスタンス
     */
    public static NinteichosaIraiJohoManager createInstance() {
        return InstanceProvider.create(NinteichosaIraiJohoManager.class);
    }

    /**
     * 認定調査依頼情報{@link NinteichosaIraiJoho}を保存します。
     *
     * @param 認定調査依頼情報 {@link NinteichosaIraiJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査依頼情報(NinteichosaIraiJoho 認定調査依頼情報) {
        requireNonNull(認定調査依頼情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査依頼情報"));
        if (!認定調査依頼情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査依頼情報.toEntity());
    }
}
