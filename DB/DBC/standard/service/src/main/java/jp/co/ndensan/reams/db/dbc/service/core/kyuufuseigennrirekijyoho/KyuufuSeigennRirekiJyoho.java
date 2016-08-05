/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kyuufuseigennrirekijyoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyuufuseigennrirekijyoho.KyuufuSeigennRirekiJyohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4021ShiharaiHohoHenkoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT4021ShiharaiHohoHenkoDac;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * KyuufuSeigennRirekiJyoho_給付制限履歴情報（画面）のクラスです。
 *
 * @reamsid_L DBC-4350-100 liuxiaoyu
 */
public class KyuufuSeigennRirekiJyoho {

    private final DbT4021ShiharaiHohoHenkoDac dbt4021Dac;

    /**
     * コンストラクタです。
     */
    public KyuufuSeigennRirekiJyoho() {
        this.dbt4021Dac = InstanceProvider.create(DbT4021ShiharaiHohoHenkoDac.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KyuufuSeigennRirekiJyoho}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link KyuufuSeigennRirekiJyoho}のインスタンス
     */
    public static KyuufuSeigennRirekiJyoho createInstance() {
        return InstanceProvider.create(KyuufuSeigennRirekiJyoho.class);
    }

    /**
     * 給付制限履歴情報取得
     *
     * @param 被保険者番号 HihokenshaNo
     * @return list List<KyuufuSeigennRirekiJyohoEntity>
     */
    public List<KyuufuSeigennRirekiJyohoEntity> getKyuufuSeigennRirekiJyoho(HihokenshaNo 被保険者番号) {

        List<KyuufuSeigennRirekiJyohoEntity> list = new ArrayList<>();
        List<DbT4021ShiharaiHohoHenkoEntity> dblist = dbt4021Dac.get給付制限履歴情報(被保険者番号);

        if (dblist != null && !dblist.isEmpty()) {
            KyuufuSeigennRirekiJyohoEntity kyuufuSeigennRirekiJyohoEntity;
            for (DbT4021ShiharaiHohoHenkoEntity dbt4021 : dblist) {
                kyuufuSeigennRirekiJyohoEntity = new KyuufuSeigennRirekiJyohoEntity(
                        dbt4021.getHihokenshaNo(),
                        dbt4021.getKanriKubun(),
                        dbt4021.getTorokuKubun(),
                        dbt4021.getTekiyoKaishiYMD(),
                        dbt4021.getTekiyoShuryoYMD(),
                        dbt4021.getShuryoKubun());
                list.add(kyuufuSeigennRirekiJyohoEntity);
            }
        }
        return list;
    }
}
