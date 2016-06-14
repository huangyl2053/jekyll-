/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.shisetsuidojoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.shisetsuidojoho.ShisetsuIdoJoho;
import jp.co.ndensan.reams.db.dbd.entity.db.relate.shisetsuidojoho.ShisetsuIdoJohoEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.mapper.relate.shisetsuidojoho.IShisetsuIdoJohoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbV1001HihokenshaDaichoAliveDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 【共有子Div】施設入退Finderです。
 *
 * @reamsid_L DBD-3560-120 wangjie2
 */
public class ShisetsuIdoJohoFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    ShisetsuIdoJohoFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * 【共有子Div】施設入退FinderのIntanceを作成します。
     *
     * @return ShisetsuIdoJohoFinder
     */
    public static ShisetsuIdoJohoFinder createIntance() {
        return InstanceProvider.create(ShisetsuIdoJohoFinder.class);
    }

    /**
     * 被保険者番号より、被保険者台帳管理Newestから識別コードを取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return 識別コード
     */
    public ShikibetsuCode get識別コードBy被保険者番号(HihokenshaNo 被保険者番号) {
        DbV1001HihokenshaDaichoAliveDac dac = InstanceProvider.create(DbV1001HihokenshaDaichoAliveDac.class);
        DbV1001HihokenshaDaichoEntity entity = dac.get最新の被保険者台帳情報(被保険者番号);
        if (entity != null) {
            return entity.getShikibetsuCode();
        }
        return null;
    }

    /**
     * 介護施設入退所情報を取得します。
     *
     * @param 識別コード 識別コード
     * @return 介護施設入退所情報List
     */
    @Transaction
    public List<ShisetsuIdoJoho> get介護施設入退所情報(ShikibetsuCode 識別コード) {
        List<ShisetsuIdoJoho> 介護施設入退所情報List = new ArrayList<>();
        IShisetsuIdoJohoMapper mapper = mapperProvider.create(IShisetsuIdoJohoMapper.class);
        List<ShisetsuIdoJohoEntity> entityList = mapper.get介護施設入退所情報(識別コード);
        for (ShisetsuIdoJohoEntity entity : entityList) {
            介護施設入退所情報List.add(new ShisetsuIdoJoho(entity));
        }
        return 介護施設入退所情報List;
    }

}
