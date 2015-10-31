/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.syujii.koseishichosonmaster;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.syujii.koseishichosonmaster.KoseiShichosonMaster;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5051KoseiShichosonMasterDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村マスタを管理するクラスです。
 */
public class KoseiShichosonMasterManager {

    private final DbT5051KoseiShichosonMasterDac dac;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonMasterManager() {
        dac = InstanceProvider.create(DbT5051KoseiShichosonMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5051KoseiShichosonMasterDac}
     */
    KoseiShichosonMasterManager(DbT5051KoseiShichosonMasterDac dac) {
        this.dac = dac;
    }

    /**
     * 構成市町村マスタ{@link KoseiShichosonMaster}を保存します。
     *
     * @param 構成市町村マスタ {@link KoseiShichosonMaster}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save構成市町村マスタ(KoseiShichosonMaster 構成市町村マスタ) {
        requireNonNull(構成市町村マスタ, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村マスタ"));
        if (!構成市町村マスタ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(構成市町村マスタ.toEntity());
    }
}
