/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.service.core.jigyotaishoshajoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbd.business.core.basic.SogoJigyoTaishosha;
import jp.co.ndensan.reams.db.dbd.entity.db.basic.DbT3105SogoJigyoTaishoshaEntity;
import jp.co.ndensan.reams.db.dbd.persistence.db.basic.DbT3105SogoJigyoTaishoshaDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 【共有子Div】事業対象者Finderです。
 *
 * @reamsid_L DBD-3560-130 wangjie2
 */
public class JigyoTaishoshaJohoFinder {

    private final DbT3105SogoJigyoTaishoshaDac dac;

    /**
     * コンストラクタです。
     */
    JigyoTaishoshaJohoFinder() {
        this.dac = InstanceProvider.create(DbT3105SogoJigyoTaishoshaDac.class);
    }

    /**
     * 【共有子Div】事業対象者FinderのIntanceを作成します。
     *
     * @return JigyoTaishoshaJohoFinder
     */
    public static JigyoTaishoshaJohoFinder createIntance() {
        return InstanceProvider.create(JigyoTaishoshaJohoFinder.class);
    }

    /**
     * 被保険者番号を使用して事業対象者テーブルより事業対象者の情報を取得します。
     *
     * @param 被保険者番号 被保険者番号
     * @return List<SogoJigyoTaishosha>
     */
    public List<SogoJigyoTaishosha> get事業対象者情報(HihokenshaNo 被保険者番号) {
        List<SogoJigyoTaishosha> 事業対象者情報List = new ArrayList<>();
        List<DbT3105SogoJigyoTaishoshaEntity> entityList = dac.selectBy被保険者番号(被保険者番号);
        for (DbT3105SogoJigyoTaishoshaEntity entity : entityList) {
            事業対象者情報List.add(new SogoJigyoTaishosha(entity));
        }
        return 事業対象者情報List;
    }

}
