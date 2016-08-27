/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic.shogaishakoujo;

import jp.co.ndensan.reams.db.dbd.business.core.shogaishakoujo.ShogaishaKoujo;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT4038ShogaishaKoujoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT4038ShogaishaKoujoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 障がい者控除対象者認定画面
 *
 * @reamsid_L DBD-3870-010 jinge
 */
public class ShogaishaKoujoService {

    private final DbT4038ShogaishaKoujoDac dac;

    ShogaishaKoujoService() {
        this.dac = InstanceProvider.create(DbT4038ShogaishaKoujoDac.class);
    }

    /**
     *
     * @return ShoriDateKanriService
     */
    public static ShogaishaKoujoService createInstance() {
        return InstanceProvider.create(ShogaishaKoujoService.class);
    }

    /**
     * DbT4038ShogaishaKoujoEntityを取得します
     *
     * @param 被保険者番号 HihokenshaNo
     * @return DbT4038ShogaishaKoujoEntity
     */
    @Transaction
    public ShogaishaKoujo getDbT4038ShogaishaKoujoEntity(HihokenshaNo 被保険者番号) {
        DbT4038ShogaishaKoujoEntity entity = dac.selectBy被保険者番号(被保険者番号);
        if (entity == null) {
            return null;
        } else {
            return new ShogaishaKoujo(entity);
        }
    }
}
