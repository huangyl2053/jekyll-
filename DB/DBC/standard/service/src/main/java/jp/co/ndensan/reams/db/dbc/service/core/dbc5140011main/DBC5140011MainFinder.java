/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.dbc5140011main;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.dbc5140011main.DBC5140011MainResult;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc5140011.IDBC5140011MainMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7130KaigoServiceShuruiEntity;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * サービスコード単位明細リストのFinderです。
 *
 * @reamsid_L DBC-3330-010 lihang
 */
public class DBC5140011MainFinder {

    private final MapperProvider mapperProvider;

    /**
     * コンストラクタです。
     */
    DBC5140011MainFinder() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link DBC5140011MainFinder}のインスタンスを返します。
     *
     * @return RiyoshaFutanWariaiSokujiKouseiFinder
     */
    public static DBC5140011MainFinder createInstance() {
        return InstanceProvider.create(DBC5140011MainFinder.class);
    }

    /**
     * 介護サービス種類データを取得します。
     *
     * @return List<DBC5140011MainResult>
     */
    public List<DBC5140011MainResult> get介護サービス種類データ() {
        List<DBC5140011MainResult> resultList = new ArrayList();
        IDBC5140011MainMapper mapper = mapperProvider.create(IDBC5140011MainMapper.class);
        List<DbT7130KaigoServiceShuruiEntity> サービス種類データ = mapper.get介護サービス種類データ();
        for (DbT7130KaigoServiceShuruiEntity entity : サービス種類データ) {
            resultList.add(new DBC5140011MainResult(entity));
        }
        return resultList;
    }

}
