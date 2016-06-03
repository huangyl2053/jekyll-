/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.hokenryodankai.hokenryorank;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.hokenryodankai.hokenryorank.HokenryoRank;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT2012HokenryoRankDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 保険料ランクを管理するクラスです。
 *
 * @reamsid_L DBB-9999-013 huangh
 */
public class HokenryoRankManager {

    private final DbT2012HokenryoRankDac dac;

    /**
     * コンストラクタです。
     */
    public HokenryoRankManager() {
        dac = InstanceProvider.create(DbT2012HokenryoRankDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT2012HokenryoRankDac}
     */
    HokenryoRankManager(DbT2012HokenryoRankDac dac) {
        this.dac = dac;
    }

    /**
     * 保険料ランク{@link HokenryoRank}を保存します。
     *
     * @param 保険料ランク {@link HokenryoRank}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save保険料ランク(HokenryoRank 保険料ランク) {
        requireNonNull(保険料ランク, UrSystemErrorMessages.値がnull.getReplacedMessage("保険料ランク"));
        if (!保険料ランク.hasChanged()) {
            return false;
        }
        return 1 == dac.save(保険料ランク.toEntity());
    }
}
