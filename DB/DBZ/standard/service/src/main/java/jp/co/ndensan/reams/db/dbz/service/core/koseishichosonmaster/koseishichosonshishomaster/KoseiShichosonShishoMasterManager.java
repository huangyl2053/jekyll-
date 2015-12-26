/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.koseishichosonmaster.koseishichosonshishomaster;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.koseishichoson.koseishichosonshisho.KoseiShichosonShishoMaster;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7052KoseiShichosonShishoMasterDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 構成市町村支所マスタを管理するクラスです。
 */
public class KoseiShichosonShishoMasterManager {

    private final DbT7052KoseiShichosonShishoMasterDac dac;

    /**
     * コンストラクタです。
     */
    public KoseiShichosonShishoMasterManager() {
        dac = InstanceProvider.create(DbT7052KoseiShichosonShishoMasterDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7052KoseiShichosonShishoMasterDac}
     */
    KoseiShichosonShishoMasterManager(DbT7052KoseiShichosonShishoMasterDac dac) {
        this.dac = dac;
    }

    /**
     * 構成市町村支所マスタ{@link KoseiShichosonShishoMaster}を保存します。
     *
     * @param 構成市町村支所マスタ {@link KoseiShichosonShishoMaster}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save構成市町村支所マスタ(KoseiShichosonShishoMaster 構成市町村支所マスタ) {
        requireNonNull(構成市町村支所マスタ, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村支所マスタ"));
        if (!構成市町村支所マスタ.hasChanged()) {
            return false;
        }
        return 1 == dac.save(構成市町村支所マスタ.toEntity());
    }
}
