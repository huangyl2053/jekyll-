/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyotokkijiko;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5205NinteichosahyoTokkijikoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（特記情報）を管理するクラスです。
 */
public class NinteichosahyoTokkijikoManager {

    private final DbT5205NinteichosahyoTokkijikoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoTokkijikoManager() {
        dac = InstanceProvider.create(DbT5205NinteichosahyoTokkijikoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5205NinteichosahyoTokkijikoDac}
     */
    NinteichosahyoTokkijikoManager(DbT5205NinteichosahyoTokkijikoDac dac) {
        this.dac = dac;
    }

    /**
     * 認定調査票（特記情報）{@link NinteichosahyoTokkijiko}を保存します。
     *
     * @param 認定調査票_特記情報 {@link NinteichosahyoTokkijiko}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_特記情報(NinteichosahyoTokkijiko 認定調査票_特記情報) {
        requireNonNull(認定調査票_特記情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（特記情報）"));
        if (!認定調査票_特記情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_特記情報.toEntity());
    }
}
