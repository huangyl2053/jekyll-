/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.seikyugakutsuchishoin;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.seikyugakutsuchishoin.ISeikyugakuTsuchishoInMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbc.service.core.kogakukyufutaishosha.KogakuKyufuTaishoshaInManager;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 介護給付費等請求額通知書情報取込のバッチのビジネス。
 *
 * @reamsid_L DBC-2480-010 jiangwenkai
 */
public class SeikyugakuTsuchishoInManager {

    private final MapperProvider mapperProvider;
    private final ISeikyugakuTsuchishoInMapper mapper;

    /**
     * コンストラクタです。
     */
    public SeikyugakuTsuchishoInManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(ISeikyugakuTsuchishoInMapper.class);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link KogakuKyufuTaishoshaInManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link KogakuKyufuTaishoshaInManager}のインスタンス
     */
    public static SeikyugakuTsuchishoInManager createInstance() {
        return InstanceProvider.create(SeikyugakuTsuchishoInManager.class);
    }

    /**
     * get帳票出力対象データ
     *
     * @return List<SeikyugakuTsuchishoEntity>
     */
    public List<DbWT1511SeikyugakuTsuchishoTempEntity> get帳票出力対象データ() {
        List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト = mapper.select介護給付費サービス請求額通知書一時TBLの全件();
        if (null == 帳票出力対象データリスト) {
            return Collections.EMPTY_LIST;
        }
        return 帳票出力対象データリスト;
    }

}
