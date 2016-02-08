/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokensha.seikatsuhogoteishikikan;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokensha.seikatsuhogoteishikikan.SeikatsuHogoTeishikikan;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.ur.urd.persistence.db.basic.seikatsuhogo.UrT0528SeikatsuhogoTeishikikanDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 生活保護停止期間を管理するクラスです。
 */
public class SeikatsuHogoTeishikikanManager {

    private final UrT0528SeikatsuhogoTeishikikanDac dac;

    /**
     * コンストラクタです。
     */
    public SeikatsuHogoTeishikikanManager() {
        dac = InstanceProvider.create(UrT0528SeikatsuhogoTeishikikanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link UrT0528SeikatsuHogoTeishikikanDac}
     */
    SeikatsuHogoTeishikikanManager(UrT0528SeikatsuhogoTeishikikanDac dac) {
        this.dac = dac;
    }

    /**
     * 生活保護停止期間{@link SeikatsuHogoTeishikikan}を保存します。
     *
     * @param 生活保護停止期間 {@link SeikatsuHogoTeishikikan}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save生活保護停止期間(SeikatsuHogoTeishikikan 生活保護停止期間) {
        requireNonNull(生活保護停止期間, UrSystemErrorMessages.値がnull.getReplacedMessage("生活保護停止期間"));
        if (!生活保護停止期間.hasChanged()) {
            return false;
        }
        return 1 == dac.save(生活保護停止期間.toEntity());
    }
}
