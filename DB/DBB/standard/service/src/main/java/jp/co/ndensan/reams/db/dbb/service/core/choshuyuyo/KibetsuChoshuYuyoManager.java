/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.choshuyuyo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.KibetsuChoshuYuyo;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2007KibetsuChoshuYuyoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 介護期別徴収猶予を管理するクラスです。
 */
public class KibetsuChoshuYuyoManager {

    private final DbT2007KibetsuChoshuYuyoDac dac;

    /**
     * コンストラクタです。
     */
    public KibetsuChoshuYuyoManager() {
        dac = InstanceProvider.create(DbT2007KibetsuChoshuYuyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2007KibetsuChoshuYuyoDac}
     */
    KibetsuChoshuYuyoManager(DbT2007KibetsuChoshuYuyoDac dac) {
        this.dac = dac;
    }

    /**
     * 介護期別徴収猶予{@link KibetsuChoshuYuyo}を保存します。
     *
     * @param 介護期別徴収猶予 {@link KibetsuChoshuYuyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save介護期別徴収猶予(KibetsuChoshuYuyo 介護期別徴収猶予) {
        requireNonNull(介護期別徴収猶予, UrSystemErrorMessages.値がnull.getReplacedMessage("介護期別徴収猶予"));
        if (!介護期別徴収猶予.hasChanged()) {
            return false;
        }
        return 1 == dac.save(介護期別徴収猶予.toEntity());
    }
}
