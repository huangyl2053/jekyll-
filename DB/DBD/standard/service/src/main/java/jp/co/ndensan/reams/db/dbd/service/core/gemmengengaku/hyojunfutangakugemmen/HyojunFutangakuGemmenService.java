/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.gemmengengaku.hyojunfutangakugemmen;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.gemmengengaku.hyojunfutangakugemmen.HyojunFutangakuGemmen;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4012HyojunFutangakuGemmenEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4012HyojunFutangakuGemmenDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 標準負担額減免申請（画面）です。
 *
 * @reamsid_L DBD-3700-030 liuwei2
 */
public class HyojunFutangakuGemmenService {

    /**
     * コンストラクタです。
     *
     * @return InstanceProvider
     */
    public static HyojunFutangakuGemmenService createIntance() {
        return InstanceProvider.create(HyojunFutangakuGemmenService.class);
    }

    /**
     * 標準負担額減免情報の取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<標準負担額減免の情報>
     */
    @Transaction
    public List<HyojunFutangakuGemmen> select標準負担額減免申請情報(HihokenshaNo 被保険者番号) {
        List<HyojunFutangakuGemmen> 標準負担額減免情報List = new ArrayList<>();
        DbT4012HyojunFutangakuGemmenDac dac = InstanceProvider.create(DbT4012HyojunFutangakuGemmenDac.class);
        List<DbT4012HyojunFutangakuGemmenEntity> list = dac.select標準負担額減免申請情報(被保険者番号);
        if (!list.isEmpty()) {
            for (DbT4012HyojunFutangakuGemmenEntity entity : list) {
                標準負担額減免情報List.add(new HyojunFutangakuGemmen(entity));
            }
        }
        return 標準負担額減免情報List;
    }
}
