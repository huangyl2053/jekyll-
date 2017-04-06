/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.gogitaijoho.gogitaijoho;

import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJoho;
import jp.co.ndensan.reams.db.dbe.business.core.gogitaijoho.gogitaijoho.GogitaiJohoIdentifier;
import jp.co.ndensan.reams.uz.uza.util.Models;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 合議体情報の保存を同一のトランザクション内で実施します。
 */
public class GogitaiJohoTransactionalService {

    @Deprecated
    public GogitaiJohoTransactionalService() {
    }

    /**
     * @return GogitaiJohoTransactionalService
     */
    public static GogitaiJohoTransactionalService createInstance() {
        return InstanceProvider.create(GogitaiJohoTransactionalService.class);
    }

    /**
     * 指定の{@link IGogitaiJohoPreserver}により、合議体情報を保存します。
     *
     * @param preserver {@link IGogitaiJohoPreserver}
     * @param gogitaiJohoModel 合議体情報
     */
    @Transaction
    public void saveGogitaiJohoBy(IGogitaiJohoPreserver preserver, Models<GogitaiJohoIdentifier, GogitaiJoho> gogitaiJohoModel) {
        preserver.save(gogitaiJohoModel);
    }
}
