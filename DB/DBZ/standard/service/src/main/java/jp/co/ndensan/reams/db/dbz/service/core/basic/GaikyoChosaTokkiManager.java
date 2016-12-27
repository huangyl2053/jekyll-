/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.GaikyoChosaTokki;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5213GaikyoChosaTokkiMaskDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * @author n3509
 */
public class GaikyoChosaTokkiManager {

    private final DbT5213GaikyoChosaTokkiMaskDac dac;

    /**
     * コンストラクタです。
     */
    public GaikyoChosaTokkiManager() {
        dac = InstanceProvider.create(DbT5213GaikyoChosaTokkiMaskDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5206GaikyoTokkiDac}
     */
    GaikyoChosaTokkiManager(DbT5213GaikyoChosaTokkiMaskDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link GaikyoChosaTokkiManager}のインスタンスを返します。
     *
     *
     * @return GaikyoChosaTokkiManager
     */
    public static GaikyoChosaTokkiManager createInstance() {
        return InstanceProvider.create(GaikyoChosaTokkiManager.class);
    }

    /**
     * 概況調査特記{@link GaikyoChosaTokki}を保存します。
     *
     * @param 概況調査特記 {@link GaikyoChosaTokki}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save概況調査特記(GaikyoChosaTokki 概況調査特記) {
        requireNonNull(概況調査特記, UrSystemErrorMessages.値がnull.getReplacedMessage("概況調査特記"));
        if (!概況調査特記.hasChanged()) {
            return false;
        }
        return 1 == dac.save(概況調査特記.toEntity());
    }
}
