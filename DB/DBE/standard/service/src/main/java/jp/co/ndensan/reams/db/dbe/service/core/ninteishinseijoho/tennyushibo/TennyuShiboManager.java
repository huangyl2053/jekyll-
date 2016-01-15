/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteishinseijoho.tennyushibo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteishinseijoho.tennyushibo.TennyuShibo;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5129TennyuShiboDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 転入_死亡情報を管理するクラスです。
 */
public class TennyuShiboManager {

    private final DbT5129TennyuShiboDac dac;

    /**
     * コンストラクタです。
     */
    public TennyuShiboManager() {
        dac = InstanceProvider.create(DbT5129TennyuShiboDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5129TennyuShiboDac}
     */
    TennyuShiboManager(DbT5129TennyuShiboDac dac) {
        this.dac = dac;
    }

    /**
     * 転入_死亡情報{@link TennyuShibo}を保存します。
     *
     * @param 転入_死亡情報 {@link TennyuShibo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save転入_死亡情報(TennyuShibo 転入_死亡情報) {
        requireNonNull(転入_死亡情報, UrSystemErrorMessages.値がnull.getReplacedMessage("転入_死亡情報"));
        if (!転入_死亡情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(転入_死亡情報.toEntity());
    }
}
