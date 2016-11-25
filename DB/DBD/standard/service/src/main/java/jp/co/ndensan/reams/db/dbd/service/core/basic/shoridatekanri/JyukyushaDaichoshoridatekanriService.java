/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.basic.shoridatekanri;

import jp.co.ndensan.reams.db.dbd.persistence.db.relate.ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者台帳リスト初期表示情報の取得
 *
 * @reamsid_L DBD-1760-010 xuejm
 */
public class JyukyushaDaichoshoridatekanriService {

    private final ShoriDateKanriDac dac;

    JyukyushaDaichoshoridatekanriService() {
        this.dac = InstanceProvider.create(ShoriDateKanriDac.class);
    }

    /**
     *
     * @return ShoriDateKanriService
     */
    public static JyukyushaDaichoshoridatekanriService createInstance() {
        return InstanceProvider.create(JyukyushaDaichoshoridatekanriService.class);
    }

    /**
     * DbT7022ShoriDateKanriEntityを取得します
     *
     * @param 市町村コード LasdecCode
     * @return ShoriDateKanri
     */
    @Transaction
    public ShoriDateKanri get一件取得(LasdecCode 市町村コード) {
        DbT7022ShoriDateKanriEntity entity = dac.select前回抽出期間情報の取得(市町村コード);
        if (entity == null) {
            return null;
        } else {
            return new ShoriDateKanri(entity);
        }
    }
}
