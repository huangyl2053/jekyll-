/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic.shoridatekanri;

import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * DbT7022ShoriDateKanriEntityを取得します
 *
 * @reamsid_L DBD-1460-020 liuyl
 */
public class ShoriDateKanriService {

    private final DbT7022ShoriDateKanriDac dac;

    ShoriDateKanriService() {
        this.dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     *
     * @return ShoriDateKanriService
     */
    public static ShoriDateKanriService createInstance() {
        return InstanceProvider.create(ShoriDateKanriService.class);
    }

    /**
     * DbT7022ShoriDateKanriEntityを取得します
     *
     * @param 市町村コード LasdecCode
     * @return DbT7022ShoriDateKanriEntity
     */
    @Transaction
    public ShoriDateKanri getDbT7022ShoriDateKanriEntity(LasdecCode 市町村コード) {
        DbT7022ShoriDateKanriEntity entity = dac.select前回処理日(市町村コード);
        if (entity == null) {
            return null;
        } else {

            return new ShoriDateKanri(entity);
        }
    }

    public ShoriDateKanri get一件取得(LasdecCode 市町村コード) {
        DbT7022ShoriDateKanriEntity entity = dac.select前回抽出期間情報の取得(市町村コード);
        if (entity == null) {
            return null;
        } else {

            return new ShoriDateKanri(entity);

        }
    }
}
