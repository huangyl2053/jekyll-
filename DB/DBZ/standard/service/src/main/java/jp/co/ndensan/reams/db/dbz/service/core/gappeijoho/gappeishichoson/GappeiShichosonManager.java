/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.gappeijoho.gappeishichoson;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.business.core.gappeijoho.gappeishichoson.GappeiShichoson;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7056GappeiShichosonDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合併市町村を管理するクラスです。
 */
public class GappeiShichosonManager {

    private final DbT7056GappeiShichosonDac dac;

    /**
     * コンストラクタです。
     */
    public GappeiShichosonManager() {
        dac = InstanceProvider.create(DbT7056GappeiShichosonDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7056GappeiShichosonDac}
     */
    GappeiShichosonManager(DbT7056GappeiShichosonDac dac) {
        this.dac = dac;
    }

    /**
     * 合併市町村{@link GappeiShichoson}を保存します。
     *
     * @param 合併市町村 {@link GappeiShichoson}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save合併市町村(GappeiShichoson 合併市町村) {
        requireNonNull(合併市町村, UrSystemErrorMessages.値がnull.getReplacedMessage("合併市町村"));
        if (!合併市町村.hasChanged()) {
            return false;
        }
        return 1 == dac.save(合併市町村.toEntity());
    }
}
