/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.realservice;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.business.KaigoRenrakusaki;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5050RenrakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbz.business.mapper.RenrakusakiInfoMapper;
import jp.co.ndensan.reams.db.dbz.persistence.basic.RenrakusakiInfoDac;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 連絡先情報を検索するためのクラスです。
 *
 * @author n9606 漢那 憲作
 */
public class RenrakusakiInfoFinder {

    private final RenrakusakiInfoDac dac;

    /**
     * コンストラクタクラスです。
     *
     */
    public RenrakusakiInfoFinder() {
        dac = InstanceProvider.create(RenrakusakiInfoDac.class);
    }

    /**
     * テスト用のコンストラクタです。
     *
     */
    RenrakusakiInfoFinder(RenrakusakiInfoDac dac) {
        this.dac = dac;
    }

    /**
     * 保険者番号、被保険者番号を指定して該当する連絡先データを全件取得するクラスです。
     *
     * @param hokenshaNo 保険者番号
     * @param hihoNo 被保番号
     * @return RenrakusakiInfo
     */
    public List<KaigoRenrakusaki> getRenrakusakiList(ShoKisaiHokenshaNo hokenshaNo,
            HihokenshaNo hihoNo) {
        List<KaigoRenrakusaki> list = new ArrayList();
        List<DbT5050RenrakusakiJohoEntity> entityList = dac.select(hokenshaNo, hihoNo);

        for (DbT5050RenrakusakiJohoEntity entity : entityList) {
            KaigoRenrakusaki renrakusakiInfo = RenrakusakiInfoMapper.toRenrakusakiInfo(entity);
            list.add(renrakusakiInfo);
        }

        return list;
    }
}
