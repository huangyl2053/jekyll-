/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyokihonchosascoreitem;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyokihonchosascoreitem.NinteichosahyoKihonChosaScoreItem;
import jp.co.ndensan.reams.db.dbe.persistence.db.basic.DbT5212NinteichosahyoKihonChosaScoreItemDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（基本調査素点項目）を管理するクラスです。
 */
public class NinteichosahyoKihonChosaScoreItemManager {

    private final DbT5212NinteichosahyoKihonChosaScoreItemDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoKihonChosaScoreItemManager() {
        dac = InstanceProvider.create(DbT5212NinteichosahyoKihonChosaScoreItemDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5212NinteichosahyoKihonChosaScoreItemDac}
     */
    NinteichosahyoKihonChosaScoreItemManager(DbT5212NinteichosahyoKihonChosaScoreItemDac dac) {
        this.dac = dac;
    }

    /**
     * 認定調査票（基本調査素点項目）{@link NinteichosahyoKihonChosaScoreItem}を保存します。
     *
     * @param 認定調査票_基本調査素点項目 {@link NinteichosahyoKihonChosaScoreItem}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_基本調査素点項目(NinteichosahyoKihonChosaScoreItem 認定調査票_基本調査素点項目) {
        requireNonNull(認定調査票_基本調査素点項目, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（基本調査素点項目）"));
        if (!認定調査票_基本調査素点項目.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_基本調査素点項目.toEntity());
    }
}
