/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.dbc120890;

import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.entity.csv.dbc120230.DbWT1511SeikyugakuTsuchishoTempEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.dbc120890.ISogojigyohiSeikyugakuTsuchishoMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 総合事業費等請求額通知書情報取込みのバッチのビジネス。
 *
 * @reamsid_L DBC-2480-012 sunqingzhu
 */
public class SogojigyohiSeikyugakuTsuchishoInManager {

    private final MapperProvider mapperProvider;
    private final ISogojigyohiSeikyugakuTsuchishoMapper mapper;

    /**
     * コンストラクタです。
     */
    public SogojigyohiSeikyugakuTsuchishoInManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(ISogojigyohiSeikyugakuTsuchishoMapper.class);
    }

    /**
     * get帳票出力対象データ
     *
     * @return List<DbWT1511SeikyugakuTsuchishoTempEntity>
     */
    public List<DbWT1511SeikyugakuTsuchishoTempEntity> get帳票出力対象データ() {
        List<DbWT1511SeikyugakuTsuchishoTempEntity> 帳票出力対象データリスト = mapper.select帳票出力対象データ();
        if (null == 帳票出力対象データリスト) {
            return Collections.EMPTY_LIST;
        }
        return 帳票出力対象データリスト;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link SogojigyohiSeikyugakuTsuchishoInManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link SogojigyohiSeikyugakuTsuchishoInManager}のインスタンス
     */
    public static SogojigyohiSeikyugakuTsuchishoInManager createInstance() {
        return InstanceProvider.create(SogojigyohiSeikyugakuTsuchishoInManager.class);
    }

}
