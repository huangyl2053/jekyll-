/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.dvshokanbaraijoho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.basic.ShikibetsuNoKanri;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3118ShikibetsuNoKanriEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3118ShikibetsuNoKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 様式名称・様式コードの取得
 *
 * @reamsid_L DBC-3093-010 gongliang
 */
public class DvShokanbaraiJohoManager {

    private final DbT3118ShikibetsuNoKanriDac 識別番号管理Dac;

    /**
     * コンストラクタです。
     */
    DvShokanbaraiJohoManager() {
        this.識別番号管理Dac = InstanceProvider.create(DbT3118ShikibetsuNoKanriDac.class);
    }

    /**
     * {@link InstanceProvider#create}により生成されたインタフェースを返します。
     *
     * @return
     * {@link InstanceProvider#create}により生成された{@link DvShokanbaraiJohoManager}
     */
    public static DvShokanbaraiJohoManager createInstance() {
        return InstanceProvider.create(DvShokanbaraiJohoManager.class);
    }

    /**
     * 様式名称とコードを返します。
     *
     * @return 識別番号管理
     */
    public List<ShikibetsuNoKanri> select様式名称とコード() {
        FlexibleYearMonth システム日付_年月 = new FlexibleYearMonth(RDate.getNowDate().getYearMonth().toString());
        List<DbT3118ShikibetsuNoKanriEntity> entitys = 識別番号管理Dac.select様式名称とコード(システム日付_年月);
        List<ShikibetsuNoKanri> list = new ArrayList<>();
        if (entitys == null || entitys.isEmpty()) {
            return list;
        }
        for (DbT3118ShikibetsuNoKanriEntity entity : entitys) {
            list.add(new ShikibetsuNoKanri(entity));
        }
        return list;
    }
}
