/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.KyufuseigenRirekiList;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyuufuseigennrirekijyoho.KyuufuSeigennRirekiJyohoEntity;
import jp.co.ndensan.reams.db.dbc.service.core.kyuufuseigennrirekijyoho.KyuufuSeigennRirekiJyoho;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoKanriKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoShuryoKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.shiharaihohohenko.ShiharaiHenkoTorokuKubun;

/**
 * KyufuseigenRirekiList_給付制限履歴情報のクラスです。
 *
 * @reamsid_L DBC-4350-050 liuxiaoyu
 */
public class KyufuseigenRirekiListHandler {

    private final KyufuseigenRirekiListDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     */
    public KyufuseigenRirekiListHandler(KyufuseigenRirekiListDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面Div
     *
     * @return KyufuseigenRirekiListHandler
     */
    public static KyufuseigenRirekiListHandler of(KyufuseigenRirekiListDiv div) {
        return new KyufuseigenRirekiListHandler(div);
    }

    /**
     * 給付制限履歴情報画面のonLoadンメソッドです。
     *
     * @param 被保険者番号 HihokenshaNo
     */
    public void onLoad(HihokenshaNo 被保険者番号) {
        KyuufuSeigennRirekiJyoho kyuufuSeigennRirekiJyoho = new KyuufuSeigennRirekiJyoho();
        dgKyufuseigenRirekiList_Row dgRow;
        List<dgKyufuseigenRirekiList_Row> rowList = new ArrayList<>();
        List<KyuufuSeigennRirekiJyohoEntity> list = kyuufuSeigennRirekiJyoho.getKyuufuSeigennRirekiJyoho(被保険者番号);

        for (KyuufuSeigennRirekiJyohoEntity kyuufuSeigennRirekiJyohoEntity : list) {
            dgRow = new dgKyufuseigenRirekiList_Row();
            dgRow.setKanriKubun(ShiharaiHenkoKanriKubun.toValue(kyuufuSeigennRirekiJyohoEntity.get管理区分()).get名称());
            dgRow.setTorokuKubun(ShiharaiHenkoTorokuKubun.toValue(kyuufuSeigennRirekiJyohoEntity.get登録区分()).get名称());
            dgRow.getTekiyoKaishiYMD().setValue(kyuufuSeigennRirekiJyohoEntity.get適用開始年月日());
            dgRow.getTekiyoShuryoYMD().setValue(kyuufuSeigennRirekiJyohoEntity.get適用終了年月日());
            if (kyuufuSeigennRirekiJyohoEntity.get終了区分() != null) {
                dgRow.setShuryoKubun(ShiharaiHenkoShuryoKubun.toValue(kyuufuSeigennRirekiJyohoEntity.get終了区分()).get名称());
            }

            rowList.add(dgRow);
        }
        div.getPnlKyufuseigen().getDgKyufuseigenRirekiList().setDataSource(rowList);
    }
}
